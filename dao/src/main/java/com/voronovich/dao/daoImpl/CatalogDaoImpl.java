package com.voronovich.dao.daoImpl;

import com.voronovich.dao.CatalogDao;
import com.voronovich.entity.CatalogEntity;
import com.voronovich.exceptions.DaoException;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class CatalogDaoImpl extends DaoImpl<CatalogEntity> implements CatalogDao{

    private static Logger log = Logger.getLogger(DaoImpl.class);

    public CatalogDaoImpl(){
    }

    @Autowired
    public CatalogDaoImpl(SessionFactory sessionFactory){
        super(sessionFactory);
    }

    @Override
    public List<CatalogEntity> getAllDepartments() throws DaoException {
        List<CatalogEntity> catalogEntities;
        try {
            Query query = getSession().getNamedQuery("getAllDepartments");
            catalogEntities =  query.list();
            log.info("Got all departments:" + catalogEntities);
            return catalogEntities;
        } catch (HibernateException e) {
            log.error("Error getting all departments" + e);
            throw new DaoException(e);
        }
    }
}
