package com.voronovich.dao;

import com.voronovich.entity.BasketEntity;
import com.voronovich.entity.DataEntity;
import com.voronovich.entity.UserEntity;
import com.voronovich.exceptions.DaoException;

import java.util.List;

/**
 * Interface contains additional abstract methods
 * for Basket DAO layer
 *
 * @author Dmitry V
 * @version 1.0
 */
public interface BasketDao extends Dao<BasketEntity> {

    /**
     * Method reads the whole list of basket
     *
     * @return List<BasketEntity>
     * @throws DaoException
     */
    List<BasketEntity> getByUser(UserEntity userEntity) throws DaoException;

    /**
     * Method reads basket entity by data entity
     *
     * @param dataEntity
     * @return BasketEntity
     * @throws DaoException
     */
    BasketEntity getByData(DataEntity dataEntity) throws DaoException;

    /**
     * Method reads the whole list of basket
     *
     * @return List<BasketEntity>
     * @throws DaoException
     */
    List<BasketEntity> getAllBasket() throws DaoException;
}
