package com.voronovich.controller;

import com.voronovich.entity.UserEntity;
import com.voronovich.hash.Sha256;
import com.voronovich.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.ResourceBundle;

@Controller
@RequestMapping("/login")
public class LoginController {

    private static final int TIME_SESSION = 900;
    private static final String STATIC_SALT = ResourceBundle.getBundle("staticValue").getString("staticValue");

    @Autowired
    private UserService service;

    @RequestMapping(value = "/log", method = RequestMethod.GET)
    public String showLogForm(Map<String, Object> model) {
        UserEntity userForm = new UserEntity();
        model.put("userForm", userForm);
        return "log";
    }

    @RequestMapping(value = "/logIn", method = RequestMethod.POST)
    public String logIn(@ModelAttribute("userForm") UserEntity user,
                        HttpServletRequest request) {
        UserEntity userEntity = service.getByLogin(user.getLogin());
        if (userEntity != null) {
            String salt = service.getByLogin(user.getLogin()).getSalt();
            String password1 = Sha256.sha256(user.getPassword() + salt + STATIC_SALT);
            if (service.get(user.getLogin(), password1) == null) {
                request.setAttribute("message", "Проверьте корректность ввода логина и пароля");
                return "log";
            } else if (StringUtils.equals(service.get(user.getLogin(), password1).getBlackList(), "true")) {
                request.setAttribute("message", "Ваш профиль заблокирован за несоблюдение правил сайта, " +
                        "за дополнительной информацией обратитесь к администратору.");
                return "log";
            } else {
                HttpSession session = request.getSession(true);
                session.setMaxInactiveInterval(TIME_SESSION);
                session.setAttribute("user", userEntity);
                request.setAttribute("message", "Добро пожаловать, " + userEntity.getName());
                return "redirect:../";
            }
        } else {
            request.setAttribute("message", "Проверьте корректность ввода логина и пароля");
            return "log";
        }
    }
}
