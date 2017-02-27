package com.voronovich.controller;

import com.voronovich.entity.*;
import com.voronovich.service.*;
import org.springframework.ui.ModelMap;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/catalog")
public class CatalogMainController {

    @Autowired
    private DataService serviceData;

    @Autowired
    private DescriptionService serviceDescription;

    @Autowired
    private CatalogService serviceCatalog;

    @Autowired
    private BasketService serviceBasket;

    private static final int FRIDGE = 1;
    private static final int TV = 2;
    private static final int WASHER = 3;
    private static final int MOBILE = 4;
    private static final String FRIDGES = "fridges";
    private static final String TELEVISIONS = "televisions";
    private static final String WASHERS = "washers";
    private static final String MOBILES = "mobiles";

    @RequestMapping(value = "/{products}", method = RequestMethod.GET)
    public String showFridges(@RequestParam(required = false, defaultValue = "1") int page,
                              @RequestParam(required = false, defaultValue = "3") int size,
                              @PathVariable String products,
                              ModelMap model) {
        String productName = null;
        String productsValue = null;
        int productsName = 0;
        List<DataEntity> allProducts = new ArrayList<>();
        List<DataEntity> list = new ArrayList<>();
        List<DataEntity> allGoods = serviceData.getAllData();
        if (StringUtils.equals(products, FRIDGES)) {
            allProducts = allGoods.stream().filter(dataEntity -> dataEntity.getCatalogEntity().getIdCatalog() == FRIDGE).collect(Collectors.toList());
            list = serviceData.getAllDataPerPage(page, size, serviceCatalog.get(FRIDGE));
            productName = "fridge";
            productsValue = FRIDGES;
            productsName = FRIDGE;
        } else if (StringUtils.equals(products, TELEVISIONS)) {
            allProducts = allGoods.stream().filter(dataEntity -> dataEntity.getCatalogEntity().getIdCatalog() == TV).collect(Collectors.toList());
            list = serviceData.getAllDataPerPage(page, size, serviceCatalog.get(TV));
            productName = "tv";
            productsValue = TELEVISIONS;
            productsName = TV;
        } else if (StringUtils.equals(products, WASHERS)) {
            allProducts = allGoods.stream().filter(dataEntity -> dataEntity.getCatalogEntity().getIdCatalog() == WASHER).collect(Collectors.toList());
            list = serviceData.getAllDataPerPage(page, size, serviceCatalog.get(WASHER));
            productName = "washer";
            productsValue = WASHERS;
            productsName = WASHER;
        } else if (StringUtils.equals(products, MOBILES)) {
            allProducts = allGoods.stream().filter(dataEntity -> dataEntity.getCatalogEntity().getIdCatalog() == MOBILE).collect(Collectors.toList());
            list = serviceData.getAllDataPerPage(page, size, serviceCatalog.get(MOBILE));
            productName = "mobile";
            productsValue = MOBILES;
            productsName = MOBILE;
        }
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
        model.addAttribute("productsName", productsName);
        model.addAttribute("productsValue", productsValue);
        model.addAttribute("productName", productName);
        model.addAttribute("products", list);
        model.addAttribute("paginationSize", list1);
        model.addAttribute("currentPage", page);
        return "catalog";
    }

    @RequestMapping(value = {"/fridges/{ID}","/televisions/{ID}","/washers/{ID}","/mobiles/{ID}"}, method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void addOrder(@PathVariable int ID, HttpServletRequest request) {
        BasketEntity basketEntity = new BasketEntity(0, (UserEntity) request.getSession(true).getAttribute("user"), serviceData.get(ID));
        serviceBasket.saveOrUpdate(basketEntity);
    }

    @RequestMapping(value = {"fridges/{ID}","televisions/{ID}","washers/{ID}","mobiles/{ID}"}, method = RequestMethod.GET)
    public String showFridge(@PathVariable int ID, ModelMap model) {
        DataEntity dataEntity = serviceData.get(ID);
        List<DescriptionEntity> list = serviceDescription.getAllDescriptionsByData(dataEntity);
        String productName = null;
        int productValue = 0;
        if(dataEntity.getCatalogEntity().getIdCatalog()==FRIDGE){
            productName = "fridge";
            productValue = FRIDGE;
        } else if(dataEntity.getCatalogEntity().getIdCatalog()==TV){
            productName = "tv";
            productValue = TV;
        } else if(dataEntity.getCatalogEntity().getIdCatalog()==WASHER){
            productName = "washer";
            productValue = WASHER;
        } else if(dataEntity.getCatalogEntity().getIdCatalog()==MOBILE){
            productName = "mobile";
            productValue = MOBILE;
        }
        model.addAttribute("productName", productName);
        model.addAttribute("productValue", productValue);
        model.addAttribute("data", dataEntity);
        model.addAttribute("list", list);
        return "catalog/product";
    }
}