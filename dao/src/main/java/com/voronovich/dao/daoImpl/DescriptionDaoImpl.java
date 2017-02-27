package com.voronovich.dao.daoImpl;

import com.voronovich.dao.DescriptionDao;
import com.voronovich.entity.DataEntity;
import com.voronovich.entity.DescriptionEntity;
import com.voronovich.exceptions.DaoException;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DescriptionDaoImpl extends DaoImpl<DescriptionEntity> implements DescriptionDao {

    private static Logger log = Logger.getLogger(DaoImpl.class);

    public DescriptionDaoImpl(){
    }

    @Autowired
    public DescriptionDaoImpl(SessionFactory sessionFactory){
        super(sessionFactory);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<DescriptionEntity> getAllDescription() throws DaoException {
        List<DescriptionEntity> descriptionEntities;
        try {
            Query query = getSession().getNamedQuery("getAllDescriptions");
            descriptionEntities = query.list();
            log.info("Got all descriptions:" + descriptionEntities);
            return descriptionEntities;
        } catch (HibernateException e) {
            log.error("Error getting all descriptions" + e);
            throw new DaoException(e);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<DescriptionEntity> getAllDescriptionByData(DataEntity dataEntity) throws DaoException {
        List<DescriptionEntity> descriptionEntities;
        try {
            Query query = getSession().getNamedQuery("getAllDescriptionsByData")
                    .setParameter("dataEntity", dataEntity);
            descriptionEntities = query.list();
            log.info("Got all descriptions by data:" + descriptionEntities);
            return descriptionEntities;
        } catch (HibernateException e) {
            log.error("Error getting all descriptions by data" + e);
            throw new DaoException(e);
        }
    }
}
