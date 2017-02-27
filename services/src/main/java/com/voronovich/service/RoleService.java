package com.voronovich.service;

import com.voronovich.entity.RoleEntity;

import java.io.Serializable;
import java.util.List;

/**
 * Interface contains abstract methods
 * for RoleService layer
 *
 * @author Dmitry V
 * @version 1.0
 */
public interface RoleService {

    /**
     * Method saves or updates roleEntity
     *
     * @param roleEntity RoleEntity
     */
    void saveOrUpdate(RoleEntity roleEntity);

    /**
     * Method removes roleEntity from database
     *
     * @param roleEntity RoleEntity
     */
    void delete(RoleEntity roleEntity);

    /**
     * Method reads the whole list of roles
     *
     * @return List<RoleEntity>
     */
    List<RoleEntity> getAllRoles();

    /**
     * Method gets roleEntity by it's id
     *
     * @param id roleEntity ID
     * @return roleEntity RoleEntity
     */
    RoleEntity get(Serializable id);
}
