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

/**
 * Class implements functionality of Spring controller
 * which is responsible for shopping cart service
 *
 * @author Dmitry V
 * @version 1.0
 */
@Controller
@RequestMapping("/basket")
public class BasketController {

    private static final String MESSAGE_ERROR = "Для работы с корзиной требуется авторизация";
    private static final String MESSAGE_EMPTY = "Ваша корзина пуста";

    @Autowired
    BasketService serviceBasket;

    @Autowired
    DataService serviceData;

    /**
     * Method shows user list with his orders
     *
     * @param request
     * @param model
     * @return view
     */
    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public String showOrders(HttpServletRequest request, ModelMap model){
        if ((request.getSession(true).getAttribute("user")) == null) {
           model.addAttribute("message", MESSAGE_ERROR);
        } else {
            UserEntity userEntity = (UserEntity) request.getSession(true).getAttribute("user");
            List<BasketEntity> list = serviceBasket.getByUser(userEntity);
            if (list.size() == 0) {
                model.addAttribute("message", MESSAGE_EMPTY);
            } else {
                model.addAttribute("list", list);
            }
        }
        return "basket";
    }

    /**
     * Method removes selected order from shopping cart
     *
     * @param ID - order ic
     */
    @RequestMapping(value = "/orders/{ID}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteOrder(@PathVariable int ID) {
        serviceBasket.delete(serviceBasket.get(ID));
    }
}
