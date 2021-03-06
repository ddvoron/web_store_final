package com.voronovich.controller;

import com.voronovich.entity.UserEntity;
import com.voronovich.hash.RandomSalt;
import com.voronovich.hash.Sha256;
import com.voronovich.service.RoleService;
import com.voronovich.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * Class implements functionality of Spring Controller for registration
 *
 * @author Dmitry V
 * @version 1.0
 */
@Controller
@RequestMapping("/user")
public class UserController {

    private static final int DEFAULT_USER_ID = 0;
    private static final int DEFAULT_ROLE_ID = 1;
    private static final int LENGTH_RANDOM_NUMBER = 20;
    private static final String BLOCK_VALUE = "false";
    private static final String STATIC_SALT = ResourceBundle.getBundle("staticValue").getString("staticValue");
    private static final String MESSAGE_REGISTRATION_FAIL = "Ошибка регистрации";
    private static final String MESSAGE_DATA_CORRECTION = "Введите корректные данные";
    private static final String MESSAGE_REGISTRATION_SUCCESS = "Регистрация прошла успешно";

    @Autowired
    private UserService service;

    @Autowired
    private RoleService serviceRole;

    /**
     * Method is for preparing view for registration page
     *
     * @param model
     * @return view
     */
    @RequestMapping(value = "/reg", method = RequestMethod.GET)
    public String showRegForm(Map<String, Object> model) {
        UserEntity userForm = new UserEntity();
        model.put("userForm", userForm);
        return "reg";
    }

    /**
     * Method adds new userEntity
     *
     * @param user -userEntity form
     * @param result
     * @param PasswordRepeat
     * @param request
     * @return  view
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addUser(@Valid @ModelAttribute("userForm") UserEntity user,
                          BindingResult result,
                          @RequestParam String PasswordRepeat,
                          HttpServletRequest request) {
        if (result.hasErrors()) {
            request.setAttribute("message", MESSAGE_REGISTRATION_FAIL);
            return "reg";
        }
        if (!StringUtils.equals(user.getPassword(), PasswordRepeat)) {
            request.setAttribute("message", MESSAGE_REGISTRATION_FAIL);
            return "reg";
        }
        if (service.getByLogin(user.getLogin()) != null && service.getByEmail((user.getEmail())) != null) {
            request.setAttribute("message", MESSAGE_DATA_CORRECTION);
            return "reg";
        }
        fillModel(user);
        service.saveOrUpdate(user);
        request.setAttribute("message", MESSAGE_REGISTRATION_SUCCESS);
        return "redirect:../login/log";
    }

    /**
     * Method prepares filled form of Entity
     *
     * @param user - UserEntity
     * @return UserEntity
     */
    public UserEntity fillModel(UserEntity user) {
        String password = user.getPassword();
        String salt = RandomSalt.csRandomAlphaNumericString(LENGTH_RANDOM_NUMBER);
        String password1 = Sha256.sha256(password + salt + STATIC_SALT);

        user.setRoleEntity(serviceRole.get(DEFAULT_ROLE_ID));
        user.setBlackList(BLOCK_VALUE);
        user.setIdUser(DEFAULT_USER_ID);
        user.setSalt(salt);
        user.setRegistrationDate(new Date());
        user.setPassword(password1);
        return user;
    }
}

