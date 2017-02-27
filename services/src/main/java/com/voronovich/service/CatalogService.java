package com.voronovich.service;

import com.voronovich.entity.CatalogEntity;

import java.io.Serializable;
import java.util.List;

/**
 * Interface contains abstract methods
 * for CatalogService layer
 *
 * @author Dmitry V
 * @version 1.0
 */
public interface CatalogService {

    /**
     * Method saves or updates catalogEntity
     *
     * @param catalogEntity CatalogEntity
     */
    void saveOrUpdate(CatalogEntity catalogEntity) ;

    /**
     * Method removes catalogEntity from database
     *
     * @param catalogEntity CatalogEntity
     */
    void delete(CatalogEntity catalogEntity) ;

    /**
     * Method gets catalogEntity by it's id
     *
     * @param id catalogEntity ID
     * @return catalogEntity CatalogEntity
     */
    CatalogEntity get(Serializable id) ;

    /**
     * Method reads the whole list of catalog
     *
     * @return List<CatalogEntity>
     */
    List<CatalogEntity> getAllDepartments();
}
