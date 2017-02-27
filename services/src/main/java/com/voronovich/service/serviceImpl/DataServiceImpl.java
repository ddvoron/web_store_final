package com.voronovich.service.serviceImpl;

import com.voronovich.dao.DataDao;
import com.voronovich.entity.CatalogEntity;
import com.voronovich.entity.DataEntity;
import com.voronovich.exceptions.DaoException;
import com.voronovich.service.DataService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Service("dataService")
@Transactional
public class DataServiceImpl implements DataService {

    private static Logger log = Logger.getLogger(RoleServiceImpl.class);

    @Autowired
    private DataDao dao;

    @Override
    public void saveOrUpdate(DataEntity dataEntity) {
        try {
            dao.saveOrUpdate(dataEntity);
        } catch (DaoException e) {
            log.error("Error data save/update in DataServiceImpl: " + e);
        }
    }

    @Override
    public void delete(DataEntity dataEntity) {
        try {
            dao.delete(dataEntity);
        } catch (DaoException e) {
            log.error("Error data delete in DataServiceImpl: " + e);
        }
    }

    @Override
    public List<DataEntity> getAllData() {
        List<DataEntity> dataEntities = null;
        try {
            dataEntities = dao.getAllData();
            return dataEntities;
        } catch (DaoException e) {
            log.error("Error getting data in DataServiceImpl: " + e);
        }
        return dataEntities;
    }

    @Override
    public DataEntity get(Serializable id) {
        DataEntity dataEntity = null;
        try {
            dataEntity = dao.get(id);
            return dataEntity;
        } catch (DaoException e) {
            log.error("Error getting data by id in DataServiceImpl: " + e);
        }
        return dataEntity;
    }

    @Override
    public List<DataEntity> getAllDataPerPage(int page, int recordPerPage) {
        List<DataEntity> dataEntities = null;
        try {
            dataEntities = dao.getAllDataPerPage(page, recordPerPage);
            return dataEntities;
        } catch (DaoException e) {
            log.error("Error getting all data" + e);
        }
        return dataEntities;
    }

    @Override
    public List<DataEntity> getAllDataPerPage(int page, int recordPerPage,
                                              CatalogEntity catalogEntity) {
        List<DataEntity> dataEntities = null;
        try {
            dataEntities = dao.getAllDataPerPage(page, recordPerPage, catalogEntity);
            return dataEntities;
        } catch (DaoException e) {
            log.error("Error getting all data" + e);
        }
        return dataEntities;
    }

    @Override
    public List<DataEntity> getAllDataPerPageAndCost(int page, int recordPerPage,
                                                     float minCost, float maxCost,
                                                     CatalogEntity catalogEntity) {
        List<DataEntity> dataEntities = null;
        try {
            dataEntities = dao.getAllDataPerPageAndCost(page, recordPerPage, minCost,
                    maxCost, catalogEntity);
            return dataEntities;
        } catch (DaoException e) {
            log.error("Error getting all data" + e);
        }
        return dataEntities;
    }
}