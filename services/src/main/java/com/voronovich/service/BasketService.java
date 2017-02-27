package com.voronovich.service;

import com.voronovich.entity.BasketEntity;
import com.voronovich.entity.DataEntity;
import com.voronovich.entity.UserEntity;

import java.io.Serializable;
import java.util.List;

/**
 * Interface contains abstract methods
 * for BasketService layer
 *
 * @author Dmitry V
 * @version 1.0
 */
public interface BasketService {

    /**
     * Method returns list of orders by user id
     *
     * @param userEntity
     * @return list
     */
    List<BasketEntity> getByUser(UserEntity userEntity);

    /**
     * Method returns order by it"s id
     *
     * @param dataEntity
     * @return entity
     */
    BasketEntity getByData(DataEntity dataEntity);

    /**
     * Method saves or updates order
     *
     * @param basketEntity BasketEntity
     */
    void saveOrUpdate(BasketEntity basketEntity);

    /**
     * Method removes order from database
     *
     * @param basketEntity BasketEntity
     */
    void delete(BasketEntity basketEntity);

    /**
     * Method gets order by it's id
     *
     * @param id basketEntity ID
     * @return basketEntity BasketEntity
     */
    BasketEntity get(Serializable id);

    /**
     * Method returns list of orders by user id
     *
     * @return list
     */
    List<BasketEntity> getAllBasket();
}
