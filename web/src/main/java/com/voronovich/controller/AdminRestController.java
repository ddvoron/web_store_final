package com.voronovich.controller;

import com.voronovich.entity.DataEntity;
import com.voronovich.entity.UserEntity;
import com.voronovich.service.CatalogService;
import com.voronovich.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;

@RestController
@RequestMapping("/admin")
public class AdminRestController {

    @Autowired
    DataService serviceData;

    @Autowired
    CatalogService serviceCatalog;

    @RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteProduct(@PathVariable("id") Integer id) {
        serviceData.delete(serviceData.get(id));
    }

}