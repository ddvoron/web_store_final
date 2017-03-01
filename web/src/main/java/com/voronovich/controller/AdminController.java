package com.voronovich.controller;

import com.voronovich.entity.DataEntity;
import com.voronovich.entity.UserEntity;
import com.voronovich.service.CatalogService;
import com.voronovich.service.DataService;
import com.voronovich.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private DataService serviceData;

    @Autowired
    CatalogService serviceCatalog;

    @Autowired
    UserService serviceUser;

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String showProducts(@RequestParam(required = false, defaultValue = "1") int page,
                               @RequestParam(required = false, defaultValue = "10") int size,
                               HttpServletRequest request, ModelMap model) {
        UserEntity userEntity = (UserEntity) request.getSession(true).getAttribute("user");
        if (userEntity != null && userEntity.getRoleEntity().getIdRole() == 2) {

            List<DataEntity> allProducts = serviceData.getAllData();
            List<DataEntity> list = serviceData.getAllDataPerPage(page, size);
            List<Integer> list1 = new ArrayList<>();
            int paginationSize;
            if (allProducts.size() % size == 0) {
                paginationSize = allProducts.size() / size;
            } else {
                paginationSize = (allProducts.size() / size) + 1;
            }
            for (int i = 1; i <= paginationSize; i++) {
                list1.add(i);
            }
            model.addAttribute("product", new DataEntity());
            model.addAttribute("products", list);
            model.addAttribute("paginationSize", list1);
            model.addAttribute("currentPage", page);
            return "products";
        } else {
            model.addAttribute("message", "Вы не авторизированы либо не обладаете правами администратора");
            return "redirect:../";
        }
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String showProducts(HttpServletRequest request, ModelMap model) {
        UserEntity userEntity = (UserEntity) request.getSession(true).getAttribute("user");
        if (userEntity != null && userEntity.getRoleEntity().getIdRole() == 2) {

            List<UserEntity> allUsers = serviceUser.getAllUsers();
            model.addAttribute("user", new UserEntity());
            model.addAttribute("users", allUsers);
            return "users";
        } else {
            model.addAttribute("message", "Вы не авторизированы либо не обладаете правами администратора");
            return "redirect:../";
        }
    }

    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public String addOrUpdateProduct(@ModelAttribute("product") DataEntity dataEntity,
                             HttpServletRequest request) {
        UserEntity user = (UserEntity) request.getSession(true).getAttribute("user");
        if (dataEntity.getIdData() == 0) {
            dataEntity.setCreator(user.getName() + " " + user.getSurname());
            dataEntity.setCreationDate(new Date());
        } else {
            DataEntity product = serviceData.get(dataEntity.getIdData());
            dataEntity.setCreator(product.getCreator());
            dataEntity.setCreationDate(product.getCreationDate());
        }
        dataEntity.setCatalogEntity(serviceCatalog.get(Integer.parseInt(request.getParameter("Department"))));
        dataEntity.setUpdater(user.getName() + " " + user.getSurname());
        dataEntity.setUpdateDate(new Date());
        serviceData.saveOrUpdate(dataEntity);
        return "redirect: products";
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public String updateProduct(@ModelAttribute("user") UserEntity userEntity) {
        UserEntity user = serviceUser.get(userEntity.getIdUser());
        user.setName(userEntity.getName());
        user.setSurname(userEntity.getSurname());
        user.setEmail(userEntity.getEmail());
        user.setLogin(userEntity.getLogin());
        user.setBlackList(userEntity.getBlackList());
        serviceUser.saveOrUpdate(user);
        return "redirect: users";
    }
}