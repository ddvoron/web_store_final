package com.voronovich.dao;

import com.voronovich.entity.UserEntity;
import com.voronovich.exceptions.DaoException;

import java.util.List;

/**
 * Interface contains additional abstract methods
 * for User DAO layer
 *
 * @author Dmitry V
 * @version 1.0
 */
public interface UserDao extends Dao<UserEntity> {

    /**
     * Method reads user by it's login and password
     *
     * @param login user login
     * @param password user password
     * @return UserEntity
     * @throws DaoException
     */
    UserEntity get(String login, String password) throws DaoException;

    /**
     * Method reads user by it's login
     *
     * @param login user login
     * @return UserEntity
     * @throws DaoException
     */
    UserEntity getByLogin(String login) throws DaoException;

    /**
     * Method reads user by it's email
     *
     * @param email user login
     * @return UserEntity
     * @throws DaoException
     */
    UserEntity getByEmail(String email) throws DaoException;

    /**
     * Method reads the whole list of users
     *
     * @return List<UserEntity>
     * @throws DaoException
     */
    List<UserEntity> getAllUsers() throws DaoException;
}
