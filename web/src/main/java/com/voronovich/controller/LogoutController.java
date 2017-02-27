package com.voronovich.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/logout")
public class LogoutController {

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String showLogOutForm() {
        return "logout";
    }

    @RequestMapping(value = "/finish", method = RequestMethod.POST)
    public String logOut(HttpServletRequest request){
        request.getSession().invalidate();
        request.setAttribute("message", "Сеанс завершен");
        return "redirect:../";
    }
}
