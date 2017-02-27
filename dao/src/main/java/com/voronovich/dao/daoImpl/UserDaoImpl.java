package com.voronovich.dao.daoImpl;

import com.voronovich.dao.UserDao;
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
public class UserDaoImpl extends DaoImpl<UserEntity> implements UserDao {

    private static Logger log = Logger.getLogger(DaoImpl.class);

    public UserDaoImpl(){
    }

    @Autowired
    public UserDaoImpl(SessionFactory sessionFactory){
        super(sessionFactory);
    }

    @Override
    public UserEntity getByLogin(String login) throws DaoException {
        UserEntity userEntity;
        try {
            Query query = getSession().getNamedQuery("getUsersByLogin")
                    .setParameter("login", login);
            userEntity = (UserEntity) query.uniqueResult();
            log.info("Got by login:" + userEntity);
            return userEntity;
        } catch (HibernateException e) {
            log.error("Error getting user by login" + e);
            throw new DaoException(e);
        }
    }

    @Override
    public UserEntity getByEmail(String email) throws DaoException {
        UserEntity userEntity;
        try {
            Query query = getSession().getNamedQuery("getUsersByEmail")
                    .setParameter("email", email);
            userEntity = (UserEntity) query.uniqueResult();
            log.info("Got by email:" + userEntity);
            return userEntity;
        } catch (HibernateException e) {
            log.error("Error getting user by email" + e);
            throw new DaoException(e);
        }
    }

    @Override
    public UserEntity get(String login, String password) throws DaoException {
        UserEntity userEntity;
        try {
            Query query = getSession().getNamedQuery("getUsersByLoginAndPassword")
                    .setParameter("login", login).setParameter("password", password);
            userEntity = (UserEntity) query.uniqueResult();
            log.info("Got by login and password:" + userEntity);
            return userEntity;
        } catch (HibernateException e) {
            log.error("Error getting user by login and password" + e);
            throw new DaoException(e);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<UserEntity> getAllUsers() throws DaoException {
        List<UserEntity> userEntities;
        try {
            Query query = getSession().getNamedQuery("getAllUsers");
            userEntities = query.list();
            log.info("Got all users:" + userEntities);
            return userEntities;
        } catch (HibernateException e) {
            log.error("Error getting all users" + e);
            throw new DaoException(e);
        }
    }
}
