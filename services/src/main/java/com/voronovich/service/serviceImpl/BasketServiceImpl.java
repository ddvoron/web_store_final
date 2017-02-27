package com.voronovich.service.serviceImpl;

import com.voronovich.dao.BasketDao;
import com.voronovich.entity.BasketEntity;
import com.voronovich.entity.DataEntity;
import com.voronovich.entity.UserEntity;
import com.voronovich.exceptions.DaoException;
import com.voronovich.service.BasketService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Service("basketService")
@Transactional
public class BasketServiceImpl implements BasketService{

    private static Logger log = Logger.getLogger(RoleServiceImpl.class);

    @Autowired
    private BasketDao dao;

    @Override
    public List<BasketEntity> getByUser(UserEntity userEntity) {
        List<BasketEntity> basketEntities = null;
        try {
            basketEntities = dao.getByUser(userEntity);
            return basketEntities;
        } catch (DaoException e) {
            log.error("Error getting basket in BasketServiceImpl: " + e);
        }
        return basketEntities;
    }

    @Override
    public BasketEntity getByData(DataEntity dataEntity) {
        BasketEntity basketEntity = null;
        try {
            basketEntity = dao.getByData(dataEntity);
            return basketEntity;
        } catch (DaoException e) {
            log.error("Error getting basket by email in BasketServiceImpl: " + e);
        }
        return basketEntity;
    }

    @Override
    public void saveOrUpdate(BasketEntity basketEntity) {
        try {
            dao.saveOrUpdate(basketEntity);
        } catch (DaoException e) {
            log.error("Error basket save/update in BasketServiceImpl: " + e);
        }
    }

    @Override
    public void delete(BasketEntity basketEntity) {
        try {
            dao.delete(basketEntity);
        } catch (DaoException e) {
            log.error("Error basket delete in BasketServiceImpl: " + e);
        }
    }

    @Override
    public BasketEntity get(Serializable id) {
        BasketEntity basketEntity = null;
        try {
            basketEntity = dao.get(id);
            return basketEntity;
        } catch (DaoException e) {
            log.error("Error getting basket by id in BasketServiceImpl: " + e);
        }
        return basketEntity;
    }

    @Override
    public List<BasketEntity> getAllBasket() {
        List<BasketEntity> basketEntities = null;
        try {
            basketEntities = dao.getAllBasket();
            return basketEntities;
        } catch (DaoException e) {
            log.error("Error getting basket in BasketServiceImpl: " + e);
        }
        return basketEntities;
    }
}
