package com.voronovich.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Class implements functionality of Spring controller
 * which is responsible for logout service
 *
 * @author Dmitry V
 * @version 1.0
 */
@Controller
@RequestMapping("/logout")
public class LogoutController {

    /**
     * Method returns view with logout form
     *
     * @return view
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String showLogOutForm() {
        return "logout";
    }

    /**
     * Method finishes users session
     *
     * @param request
     * @return view
     */
    @RequestMapping(value = "/finish", method = RequestMethod.POST)
    public String logOut(HttpServletRequest request){
        request.getSession().invalidate();
        request.setAttribute("message", "Сеанс завершен");
        return "redirect:../";
    }
}
