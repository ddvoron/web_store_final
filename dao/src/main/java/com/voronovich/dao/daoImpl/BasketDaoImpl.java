package com.voronovich.dao.daoImpl;

import com.voronovich.dao.BasketDao;
import com.voronovich.entity.BasketEntity;
import com.voronovich.entity.DataEntity;
import com.voronovich.entity.UserEntity;
import com.voronovich.exceptions.DaoException;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BasketDaoImpl extends DaoImpl<BasketEntity> implements BasketDao {

    private static Logger log = Logger.getLogger(DaoImpl.class);

    public BasketDaoImpl(){
    }

    @Autowired
    public BasketDaoImpl(SessionFactory sessionFactory){
        super(sessionFactory);
    }

    @Override
    public List<BasketEntity> getByUser(UserEntity userEntity) throws DaoException {
        List<BasketEntity> basketEntities;
        try {
            Query query = getSession().getNamedQuery("getOrdersByUser")
                    .setParameter("userEntity", userEntity);
            basketEntities = query.list();
            log.info("Got by data:" + basketEntities);
            return basketEntities;
        } catch (HibernateException e) {
            log.error("Error getting basket by data" + e);
            throw new DaoException(e);
        }
    }

    @Override
    public BasketEntity getByData(DataEntity dataEntity) throws DaoException {
        BasketEntity basketEntity;
        try {
            Query query = getSession().getNamedQuery("getOrdersByData")
                    .setParameter("dataEntity", dataEntity);
            basketEntity = (BasketEntity) query.uniqueResult();
            log.info("Got by data:" + basketEntity);
            return basketEntity;
        } catch (HibernateException e) {
            log.error("Error getting basket by data" + e);
            throw new DaoException(e);
        }
    }

    @Override
    public List<BasketEntity> getAllBasket() throws DaoException {
        List<BasketEntity> basketEntities;
        try {
            Query query = getSession().getNamedQuery("getAllOrders");
            basketEntities = query.list();
            log.info("Got all basket:" + basketEntities);
            return basketEntities;
        } catch (HibernateException e) {
            log.error("Error getting all basket" + e);
            throw new DaoException(e);
        }
    }
}
