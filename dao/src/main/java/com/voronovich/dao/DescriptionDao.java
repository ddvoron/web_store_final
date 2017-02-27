package com.voronovich.dao;

import com.voronovich.entity.DataEntity;
import com.voronovich.entity.DescriptionEntity;
import com.voronovich.exceptions.DaoException;

import java.util.List;

/**
 * Interface contains additional abstract methods
 * for Description DAO layer
 *
 * @author Dmitry V
 * @version 1.0
 */
public interface DescriptionDao extends Dao<DescriptionEntity> {

    /**
     * Method reads the whole list of data
     *
     * @return List<DataEntity>
     * @throws DaoException
     */
    List<DescriptionEntity> getAllDescription() throws DaoException;

    /**
     * Method reads the whole list of data by data id
     *
     * @return List<DataEntity>
     * @throws DaoException
     */
    List<DescriptionEntity> getAllDescriptionByData(DataEntity dataEntity) throws DaoException;
}
