package com.voronovich.dao;

import com.voronovich.entity.CatalogEntity;
import com.voronovich.entity.DataEntity;
import com.voronovich.exceptions.DaoException;

import java.util.List;

/**
 * Interface contains additional abstract methods
 * for Data DAO layer
 *
 * @author Dmitry V
 * @version 1.0
 */
public interface DataDao extends Dao<DataEntity> {

    /**
     * Method reads the whole list of data
     *
     * @return List<DataEntity>
     * @throws DaoException
     */
    List<DataEntity> getAllData() throws DaoException;

    /**
     * Method reads the whole list of data with pagination
     *
     * @return List<DataEntity>
     * @throws DaoException
     */
    List<DataEntity> getAllDataPerPage(int page,
                                       int recordPerPage) throws DaoException;

    /**
     * Method reads the whole list of data with pagination by id catalog
     *
     * @return List<DataEntity>
     * @throws DaoException
     */
    List<DataEntity> getAllDataPerPage(int page, int recordPerPage,
                                       CatalogEntity catalogEntity) throws DaoException;

    /**
     * Method reads the whole list of data with pagination by id catalog
     * and prices
     *
     * @return List<DataEntity>
     * @throws DaoException
     */
    List<DataEntity> getAllDataPerPageAndCost(int page, int recordPerPage,
                                              float minCost, float maxCost,
                                              CatalogEntity catalogEntity) throws DaoException;

}
