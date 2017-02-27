package com.voronovich.service.serviceImpl;

import com.voronovich.entity.RoleEntity;
import com.voronovich.exceptions.DaoException;
import com.voronovich.service.RoleService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@ContextConfiguration("/beans-services.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@Rollback(true)
public class RoleServiceImplTest {

    @Autowired
    private RoleService service;

    @Test
    public void saveRole() throws DaoException {
        RoleEntity roleEntity = new RoleEntity(4, "test");
        List<RoleEntity> before = service.getAllRoles();
        int sizeBefore = before.size();
        service.saveOrUpdate(roleEntity);
        List<RoleEntity> after = service.getAllRoles();
        int sizeAfter = after.size();
        Assert.assertEquals("Not created role", sizeBefore + 1, sizeAfter);
    }

    @Test
    public void getRoleById() throws DaoException {
        RoleEntity roleEntity = service.get(2);
        Assert.assertEquals("Not got", "admin", roleEntity.getName());
    }

    @Test
    public void deleteRole() throws DaoException {
        List<RoleEntity> before = service.getAllRoles();
        int sizeBefore = before.size();
        RoleEntity roleEntity = service.get(3);
        service.delete(roleEntity);
        List<RoleEntity> after = service.getAllRoles();
        int sizeAfter = after.size();
        Assert.assertEquals("Not deleted role", sizeBefore - 1, sizeAfter);
    }
}
