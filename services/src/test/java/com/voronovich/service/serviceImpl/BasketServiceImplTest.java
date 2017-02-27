package com.voronovich.service.serviceImpl;

import com.voronovich.entity.BasketEntity;
import com.voronovich.entity.DataEntity;
import com.voronovich.entity.UserEntity;
import com.voronovich.exceptions.DaoException;
import com.voronovich.service.BasketService;
import com.voronovich.service.DataService;
import com.voronovich.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@ContextConfiguration("/beans-services.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@Rollback(true)
public class BasketServiceImplTest {

    @Autowired
    BasketService service;

    @Autowired
    DataService dataService;

    @Autowired
    UserService userService;

    @Test
    public void aSaveBasket() throws DaoException {
        UserEntity userEntity = userService.get(14);
        DataEntity dataEntity = dataService.get(41);
        BasketEntity basketEntity = new BasketEntity(700, userEntity, dataEntity);
        List<BasketEntity> before = service.getByUser(userEntity);
        int size_before = before.size();
        service.saveOrUpdate(basketEntity);
        List<BasketEntity> list_after = service.getByUser(userEntity);
        int size_after = list_after.size();
        Assert.assertEquals("Basket not created", size_before + 1, size_after);
    }

    @Test
    public void bGetByData() throws DaoException {
        DataEntity dataEntity = dataService.get(39);
        BasketEntity basketEntity = service.getByData(dataEntity);
        Assert.assertNotNull(basketEntity);
    }

    @Test
    public void cGetAll() throws DaoException {
        List<BasketEntity> basketEntity = service.getAllBasket();
        Assert.assertNotNull(basketEntity);
    }

    @Test
    public void dGetBasketById() throws DaoException {
        UserEntity userEntity = userService.get(14);
        BasketEntity basketEntity = service.get(1);
        Assert.assertEquals("Not got", userEntity.getLogin(),
                basketEntity.getUserEntity().getLogin());
    }

    @Test
    public void eDeleteBasket() throws DaoException {
        UserEntity userEntity = userService.get(14);
        List<BasketEntity> before = service.getByUser(userEntity);
        int sizeBefore = before.size();
        BasketEntity basketEntity = service.get(1);
        service.delete(basketEntity);
        List<BasketEntity> after = service.getByUser(userEntity);
        int sizeAfter = after.size();
        Assert.assertEquals("Basket not deleted", sizeBefore - 1, sizeAfter);
    }
}
