package com.voronovich.service;

import com.voronovich.entity.UserEntity;

import java.io.Serializable;
import java.util.List;

/**
 * Interface contains abstract methods
 * for UserService layer
 *
 * @author Dmitry V
 * @version 1.0
 */
public interface UserService {

    /**
     * Method reads user by it's login and password
     *
     * @param login user login
     * @param password user password
     * @return userEntity UserEntity
     */
    UserEntity get(String login, String password);

    /**
     * Method reads user by it's login
     *
     * @param login user login
     * @return userEntity UserEntity
     */
    UserEntity getByLogin(String login);

    /**
     * Method reads user by it's email
     *
     * @param email user login
     * @return userEntity UserEntity
     */
    UserEntity getByEmail(String email);

    /**
     * Method reads the whole list of users
     *
     * @return List<UserEntity>
     */
    List<UserEntity> getAllUsers();

    /**
     * Method saves or updates userEntity
     *
     * @param userEntity UserEntity
     */
    void saveOrUpdate(UserEntity userEntity);

    /**
     * Method removes userEntity from database
     *
     * @param userEntity UserEntity
     */
    void delete(UserEntity userEntity);

    /**
     * Method gets userEntity by it's id
     *
     * @param id userEntity ID
     * @return userEntity UserEntity
     */
    UserEntity get(Serializable id);
}
