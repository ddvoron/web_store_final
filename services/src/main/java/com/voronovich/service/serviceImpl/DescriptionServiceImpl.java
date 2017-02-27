package com.voronovich.service.serviceImpl;

import com.voronovich.dao.DescriptionDao;
import com.voronovich.entity.DataEntity;
import com.voronovich.entity.DescriptionEntity;
import com.voronovich.exceptions.DaoException;
import com.voronovich.service.DescriptionService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Service("descriptionService")
@Transactional
public class DescriptionServiceImpl implements DescriptionService{

    private static Logger log = Logger.getLogger(RoleServiceImpl.class);

    @Autowired
    private DescriptionDao dao;

    @Override
    public void saveOrUpdate(DescriptionEntity descriptionEntity) {
        try {
            dao.saveOrUpdate(descriptionEntity);
        } catch (DaoException e) {
            log.error("Error description save/update in DescriptionServiceImpl: " + e);
        }
    }

    @Override
    public void delete(DescriptionEntity descriptionEntity) {
        try {
            dao.delete(descriptionEntity);
        } catch (DaoException e) {
            log.error("Error description delete in : " + e);
        }
    }

    @Override
    public DescriptionEntity get(Serializable id) {
        DescriptionEntity descriptionEntity = null;
        try {
            descriptionEntity = dao.get(id);
            return descriptionEntity;
        } catch (DaoException e) {
            log.error("Error getting description by id in DescriptionServiceImpl: " + e);
        }
        return descriptionEntity;
    }

    @Override
    public List<DescriptionEntity> getAllDescriptions() {
        List<DescriptionEntity> descriptionEntities = null;
        try {
            descriptionEntities = dao.getAllDescription();
            return descriptionEntities;
        } catch (DaoException e) {
            log.error("Error getting descriptions in DescriptionServiceImpl: " + e);
        }
        return descriptionEntities;
    }

    @Override
    public List<DescriptionEntity> getAllDescriptionsByData(DataEntity dataEntity) {
        List<DescriptionEntity> descriptionEntities = null;
        try {
            descriptionEntities = dao.getAllDescriptionByData(dataEntity);
            return descriptionEntities;
        } catch (DaoException e) {
            log.error("Error getting descriptions by data in DescriptionServiceImpl: " + e);
        }
        return descriptionEntities;
    }
}
