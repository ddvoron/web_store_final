package com.voronovich.controller;

import com.voronovich.entity.UserEntity;
import com.voronovich.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.voronovich.hash.RandomSalt;
import com.voronovich.hash.Sha256;
import com.voronovich.mail.Sender;

import java.util.ResourceBundle;

/**
 * Class implements functionality of Spring controller that provides mail service
 *
 * @author Dmitry V
 * @version 1.0
 */
@Controller
public class MailController {

    private static final int LENGTH_RANDOM_NUMBER = 20;
    private static final int LENGTH_RANDOM_PASSWORD = 7;
    private static final String ADMIN_MAIL = ResourceBundle.getBundle("data").getString("mail");
    private static final String ADMIN_PASSWORD = ResourceBundle.getBundle("data").getString("password");
    private static final String MESSAGE_SUBJECT = "Восстановление пароля";
    private static final String MESSAGE_SUCCESS = "Данные будут высланы в течении одной минуты на указанный E-mail...";

    @Autowired
    UserService service;

    Sender sslSender = new Sender(ADMIN_MAIL, ADMIN_PASSWORD);

    /**
     * Method returns view with email form
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/mail", method = RequestMethod.GET)
    public String mailSender(ModelMap model) {
        model.addAttribute("message", MESSAGE_SUCCESS);
        return "mail";
    }

    /**
     * Method sends mail with updated accounts data by users requests
     *
     * @param Email
     * @return view
     */
    @RequestMapping(value = "/mail", method = RequestMethod.POST)
    public String accountRecovery(@RequestParam String Email) {
        UserEntity userEntity = service.getByEmail(Email);
        if(userEntity==null){
            return "mail";
        }
        String login = userEntity.getLogin();
        String password = RandomSalt.csRandomAlphaNumericString(LENGTH_RANDOM_PASSWORD);
        String salt = RandomSalt.csRandomAlphaNumericString(LENGTH_RANDOM_NUMBER);
        String staticSalt = ResourceBundle.getBundle("staticValue").getString("staticValue");
        String password1 = Sha256.sha256(password + salt + staticSalt);
        userEntity.setPassword(password1);
        userEntity.setSalt(salt);
        service.saveOrUpdate(userEntity);
        String text = "Здравствуйте, " + userEntity.getName()
                + "! Ваш Login: " + login + "; Password: "
                + password + ".";
        sslSender.send(MESSAGE_SUBJECT, text, Email);
        return "redirect:login/log";
    }
}
