package com.voronovich.dao;

import com.voronovich.entity.CatalogEntity;
import com.voronovich.exceptions.DaoException;

import java.util.List;

/**
 * Interface contains additional abstract methods
 * for Catalog DAO layer
 *
 * @author Dmitry V
 * @version 1.0
 */
public interface CatalogDao extends Dao<CatalogEntity> {

    /**
     * Method reads the whole list of catalog
     *
     * @return List<CatalogEntity>
     * @throws DaoException
     */
    List<CatalogEntity> getAllDepartments() throws DaoException;
}
