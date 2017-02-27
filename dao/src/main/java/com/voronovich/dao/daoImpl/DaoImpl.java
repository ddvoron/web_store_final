package com.voronovich.dao.daoImpl;

import com.voronovich.dao.Dao;
import com.voronovich.exceptions.DaoException;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.lang.reflect.ParameterizedType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public class DaoImpl<T> implements Dao<T> {

    private static Logger log = Logger.getLogger(DaoImpl.class);
    private SessionFactory sessionFactory;

    public DaoImpl(){
    }

    @Autowired
    public DaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void saveOrUpdate(T t) throws DaoException {
        try {
            getSession().saveOrUpdate(t);
            log.info("Save or update: " + t);
        } catch (HibernateException e) {
            log.error("Error save or update Object in Dao " + e);
            throw new DaoException(e);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public T get(Serializable id) throws DaoException {
        T t = null;
        try {
            t = (T) getSession().get(getPersistentClass(), id);
        } catch (HibernateException e) {
            log.error("Error get " + getPersistentClass() + " in Dao " + e);
            throw new DaoException(e);
        }
        return t;
    }

    @Override
    public void delete(T t) throws DaoException {
        try {
            getSession().delete(t);
            log.info("Delete: " + t);
        } catch (HibernateException e) {
            log.error("Error save or update Object in Dao " + e);
            throw new DaoException(e);
        }
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    private Class getPersistentClass() {
        return (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
    }
}