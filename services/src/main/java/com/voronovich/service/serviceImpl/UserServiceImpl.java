package com.voronovich.service.serviceImpl;

import com.voronovich.dao.UserDao;
import com.voronovich.entity.UserEntity;
import com.voronovich.exceptions.DaoException;
import com.voronovich.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    private static Logger log = Logger.getLogger(RoleServiceImpl.class);

    @Autowired
    private UserDao dao;

    @Override
    public UserEntity get(String login, String password) {
        UserEntity userEntity = null;
        try {
            userEntity = dao.get(login, password);
            return userEntity;
        } catch (DaoException e) {
            log.error("Error getting user by login and password in UserServiceImpl: " + e);
        }
        return userEntity;
    }

    @Override
    public UserEntity getByLogin(String login) {
        UserEntity userEntity = null;
        try {
            userEntity = dao.getByLogin(login);
            return userEntity;
        } catch (DaoException e) {
            log.error("Error getting user by login in UserServiceImpl: " + e);
        }
        return userEntity;
    }

    @Override
    public UserEntity getByEmail(String email) {
        UserEntity userEntity = null;
        try {
            userEntity = dao.getByEmail(email);
            return userEntity;
        } catch (DaoException e) {
            log.error("Error getting user by email in UserServiceImpl: " + e);
        }
        return userEntity;
    }

    @Override
    public List<UserEntity> getAllUsers() {
        List<UserEntity> userEntities = null;
        try {
            userEntities = dao.getAllUsers();
            return userEntities;
        } catch (DaoException e) {
            log.error("Error getting users in UserServiceImpl: " + e);
        }
        return userEntities;
    }

    @Override
    public void saveOrUpdate(UserEntity userEntity) {
        try {
            dao.saveOrUpdate(userEntity);
        } catch (DaoException e) {
            log.error("Error role save/update in UserServiceImpl: " + e);
        }
    }

    @Override
    public void delete(UserEntity userEntity) {
        try {
            dao.delete(userEntity);
        } catch (DaoException e) {
            log.error("Error role delete in UserServiceImpl: " + e);
        }
    }

    @Override
    public UserEntity get(Serializable id) {
        UserEntity userEntity = null;
        try {
            userEntity = dao.get(id);
            return userEntity;
        } catch (DaoException e) {
            log.error("Error getting user by id in UserServiceImpl: " + e);
        }
        return userEntity;
    }
}
