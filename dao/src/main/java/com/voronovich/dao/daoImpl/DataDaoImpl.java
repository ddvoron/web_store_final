package com.voronovich.dao.daoImpl;

import com.voronovich.dao.DataDao;
import com.voronovich.entity.CatalogEntity;
import com.voronovich.entity.DataEntity;
import com.voronovich.exceptions.DaoException;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DataDaoImpl extends DaoImpl<DataEntity> implements DataDao {

    private static Logger log = Logger.getLogger(DaoImpl.class);

    public DataDaoImpl(){
    }

    @Autowired
    public DataDaoImpl(SessionFactory sessionFactory){
        super(sessionFactory);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<DataEntity> getAllData() throws DaoException {
        List<DataEntity> dataEntities;
        try {
            Query query = getSession().getNamedQuery("getAllData");
            dataEntities = query.list();
            log.info("Got all data:" + dataEntities);
            return dataEntities;
        } catch (HibernateException e) {
            log.error("Error getting all data" + e);
            throw new DaoException(e);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<DataEntity> getAllDataPerPage(int page,
                                              int recordPerPage) throws DaoException {
        List<DataEntity> dataEntities;
        try {
            Criteria cr = getSession().createCriteria(DataEntity.class);
            cr.setFirstResult((page - 1) * recordPerPage);
            cr.setMaxResults(recordPerPage);
            dataEntities = cr.list();
            return dataEntities;
        } catch (HibernateException e) {
            log.error("Error getting all data" + e);
            throw new DaoException(e);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<DataEntity> getAllDataPerPage(int page, int recordPerPage,
                                              CatalogEntity catalogEntity) throws DaoException {
        List<DataEntity> dataEntities;
        try {
            Criteria cr = getSession().createCriteria(DataEntity.class);
            cr.add(Restrictions.eq("catalogEntity", catalogEntity));
            cr.setFirstResult((page - 1) * recordPerPage);
            cr.setMaxResults(recordPerPage);
            dataEntities = cr.list();
            return dataEntities;
        } catch (HibernateException e) {
            log.error("Error getting all data" + e);
            throw new DaoException(e);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<DataEntity> getAllDataPerPageAndCost(int page, int recordPerPage,
                                                     float minCost, float maxCost,
                                                     CatalogEntity catalogEntity) throws DaoException {
        List<DataEntity> dataEntities;
        try {
            Criteria cr = getSession().createCriteria(DataEntity.class);
            cr.add(Restrictions.eq("catalogEntity", catalogEntity));
            cr.add(Restrictions.gt("price", minCost));
            cr.add(Restrictions.lt("price", maxCost));
            cr.setFirstResult((page - 1) * recordPerPage);
            cr.setMaxResults(recordPerPage);
            dataEntities = cr.list();
            return dataEntities;
        } catch (HibernateException e) {
            log.error("Error getting all data" + e);
            throw new DaoException(e);
        }
    }
}
