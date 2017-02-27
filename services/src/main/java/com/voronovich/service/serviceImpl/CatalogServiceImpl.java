package com.voronovich.service.serviceImpl;

import com.voronovich.dao.CatalogDao;
import com.voronovich.entity.CatalogEntity;
import com.voronovich.exceptions.DaoException;
import com.voronovich.service.CatalogService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Service("catalogService")
@Transactional
public class CatalogServiceImpl implements CatalogService{

    private static Logger log = Logger.getLogger(RoleServiceImpl.class);

    @Autowired
    private CatalogDao dao;

    @Override
    public void saveOrUpdate(CatalogEntity catalogEntity) {
        try {
            dao.saveOrUpdate(catalogEntity);
        } catch (DaoException e) {
            log.error("Error department save/update in CatalogServiceImpl: " + e);
        }
    }

    @Override
    public void delete(CatalogEntity catalogEntity) {
        try {
            dao.delete(catalogEntity);
        } catch (DaoException e) {
            log.error("Error department delete in CatalogServiceImpl: " + e);
        }
    }

    @Override
    public List<CatalogEntity> getAllDepartments() {
        List<CatalogEntity> catalogEntities = null;
        try {
            catalogEntities = dao.getAllDepartments();
            return catalogEntities;
        } catch (DaoException e) {
            log.error("Error getting departments in CatalogServiceImpl: " + e);
        }
        return catalogEntities;
    }

    @Override
    public CatalogEntity get(Serializable id) {
        CatalogEntity catalogEntity = null;
        try {
            catalogEntity = dao.get(id);
            return catalogEntity;
        } catch (DaoException e) {
            log.error("Error getting department by id in CatalogServiceImpl: " + e);
        }
        return catalogEntity;
    }
}
