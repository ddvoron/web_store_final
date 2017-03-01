package com.voronovich.controller;

import com.voronovich.service.CatalogService;
import com.voronovich.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Class implements functionality of Spring rest controller
 * which is responsible for operations with products
 *
 * @author Dmitry V
 * @version 1.0
 */
@RestController
@RequestMapping("/admin")
public class AdminRestController {

    @Autowired
    DataService serviceData;

    @Autowired
    CatalogService serviceCatalog;

    /**
     * Method removes product
     *
     * @param id - product id
     */
    @RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteProduct(@PathVariable("id") Integer id) {
        serviceData.delete(serviceData.get(id));
    }

}