package com.voronovich.dao.daoImpl;

import com.voronovich.dao.BasketDao;
import com.voronovich.dao.DataDao;
import com.voronovich.dao.UserDao;
import com.voronovich.entity.BasketEntity;
import com.voronovich.entity.DataEntity;
import com.voronovich.entity.UserEntity;
import com.voronovich.exceptions.DaoException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@ContextConfiguration("/beans-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@Rollback(true)
public class BasketDaoImplTest {

    @Autowired
    BasketDao dao;

    @Autowired
    DataDao dataDao;

    @Autowired
    UserDao userDao;

    @Test
    public void aSaveBasket() throws DaoException {
        UserEntity userEntity = userDao.get(14);
        DataEntity dataEntity = dataDao.get(41);
        BasketEntity basketEntity = new BasketEntity(700, userEntity, dataEntity);
        List<BasketEntity> before = dao.getByUser(userEntity);
        int size_before = before.size();
        dao.saveOrUpdate(basketEntity);
        List<BasketEntity> list_after = dao.getByUser(userEntity);
        int size_after = list_after.size();
        Assert.assertEquals("Not created", size_before + 1, size_after);
    }

    @Test
    public void bGetByData() throws DaoException {
        DataEntity dataEntity = dataDao.get(39);
        BasketEntity basketEntity = dao.getByData(dataEntity);
        Assert.assertNotNull(basketEntity);
    }

    @Test
    public void cGetAll() throws DaoException {
        List<BasketEntity> basketEntity = dao.getAllBasket();
        Assert.assertNotNull(basketEntity);
    }

    @Test
    public void dGetBasketById() throws DaoException {
        UserEntity userEntity = userDao.get(14);
        BasketEntity basketEntity = dao.get(1);
        Assert.assertEquals("Not got", userEntity.getLogin(),
                basketEntity.getUserEntity().getLogin());
    }

    @Test
    public void eDeleteBasket() throws DaoException {
        UserEntity userEntity = userDao.get(14);
        List<BasketEntity> before = dao.getByUser(userEntity);
        int sizeBefore = before.size();
        BasketEntity basketEntity = dao.get(1);
        dao.delete(basketEntity);
        List<BasketEntity> after = dao.getByUser(userEntity);
        int sizeAfter = after.size();
        Assert.assertEquals("Not deleted", sizeBefore - 1, sizeAfter);
    }
}
