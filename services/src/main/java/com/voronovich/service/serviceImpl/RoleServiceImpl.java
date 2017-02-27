package com.voronovich.service.serviceImpl;

import com.voronovich.dao.RoleDao;
import com.voronovich.entity.RoleEntity;
import com.voronovich.exceptions.DaoException;
import com.voronovich.service.RoleService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Service("roleService")
@Transactional
public class RoleServiceImpl implements RoleService {

    private static Logger log = Logger.getLogger(RoleServiceImpl.class);

    @Autowired
    private RoleDao dao;

    @Override
    public List<RoleEntity> getAllRoles() {
        List<RoleEntity> roleEntities = null;
        try {
            roleEntities = dao.getAllRoles();
            return roleEntities;
        } catch (DaoException e) {
            log.error("Error getting roles in RoleServiceImpl: " + e);
        }
        return roleEntities;
    }

    @Override
    public void saveOrUpdate(RoleEntity roleEntity) {
        try {
            dao.saveOrUpdate(roleEntity);
        } catch (DaoException e) {
            log.error("Error role save/update in RoleServiceImpl: " + e);
        }
    }

    @Override
    public void delete(RoleEntity roleEntity) {
        try {
            dao.delete(roleEntity);
        } catch (DaoException e) {
            log.error("Error role delete in RoleServiceImpl: " + e);
        }
    }

    @Override
    public RoleEntity get(Serializable id) {
        RoleEntity roleEntity = null;
        try {
            roleEntity = dao.get(id);
            return roleEntity;
        } catch (DaoException e) {
            log.error("Error getting role by id in RoleServiceImpl: " + e);
        }
        return roleEntity;
    }
}
