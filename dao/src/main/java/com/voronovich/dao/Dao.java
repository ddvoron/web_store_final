package com.voronovich.dao;

import com.voronovich.exceptions.DaoException;

import java.io.Serializable;

/**
 * Common abstract methods for every dao entity layer
 *
 * @param <T> Entity
 * @author Dmitry V
 * @version 1.0
 */
public interface Dao<T> {

    /**
     * Method saves or updates entity
     *
     * @param t entity
     * @throws DaoException
     */
    void saveOrUpdate(T t) throws DaoException;

    /**
     * Method deletes entity
     *
     * @param t entity
     * @throws DaoException
     */
    void delete(T t) throws DaoException;

    /**
     * Method reads entity
     *
     * @param id - entity id
     * @return Entity
     * @throws DaoException
     */
    T get(Serializable id) throws DaoException;
}