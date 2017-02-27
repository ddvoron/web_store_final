package com.voronovich.service;

import com.voronovich.entity.CatalogEntity;
import com.voronovich.entity.DataEntity;

import java.io.Serializable;
import java.util.List;

/**
 * Interface contains abstract methods
 * for DataService layer
 *
 * @author Dmitry V
 * @version 1.0
 */
public interface DataService {

    /**
     * Method saves or updates dataEntity
     *
     * @param dataEntity DataEntity
     */
    void saveOrUpdate(DataEntity dataEntity);

    /**
     * Method removes dataEntity from database
     *
     * @param dataEntity DataEntity
     */
    void delete(DataEntity dataEntity);

    /**
     * Method gets dataEntity by it's id
     *
     * @param id dataEntity ID
     * @return dataEntity DataEntity
     */
    DataEntity get(Serializable id);

    /**
     * Method reads the whole list of data
     *
     * @return List<DataEntity>
     */
    List<DataEntity> getAllData();

    /**
     * Method reads the whole list of data with pagination
     *
     * @return List<DataEntity>
     */
    List<DataEntity> getAllDataPerPage(int page, int recordPerPage);

    /**
     * Method reads the whole list of data with pagination by id catalog
     *
     * @return List<DataEntity>
     */
    List<DataEntity> getAllDataPerPage(int page, int recordPerPage,
                                       CatalogEntity catalogEntity);

    /**
     * Method reads the whole list of data with pagination by id catalog
     * and prices
     *
     * @return List<DataEntity>
     */
    List<DataEntity> getAllDataPerPageAndCost(int page, int recordPerPage,
                                              float minCost, float maxCost,
                                              CatalogEntity catalogEntity);
}