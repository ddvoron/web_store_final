package com.voronovich.controller;

import com.voronovich.entity.BasketEntity;
import com.voronovich.entity.UserEntity;
import com.voronovich.service.BasketService;
import com.voronovich.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/basket")
public class BasketController {

    @Autowired
    BasketService serviceBasket;

    @Autowired
    DataService serviceData;

    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public String showOrders(HttpServletRequest request, ModelMap model){
        if ((request.getSession(true).getAttribute("user")) == null) {
           model.addAttribute("message", "Для работы с корзиной требуется авторизация");
        } else {
            UserEntity userEntity = (UserEntity) request.getSession(true).getAttribute("user");
            List<BasketEntity> list = serviceBasket.getByUser(userEntity);
            if (list.size() == 0) {
                model.addAttribute("message", "Ваша корзина пуста");
            } else {
                model.addAttribute("list", list);
            }
        }
        return "basket";
    }

    @RequestMapping(value = "/orders/{ID}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteOrder(@PathVariable int ID) {
        serviceBasket.delete(serviceBasket.get(ID));
    }
}
