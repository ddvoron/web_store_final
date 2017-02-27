package com.voronovich.dao.daoImpl;

import com.voronovich.dao.RoleDao;
import com.voronovich.entity.RoleEntity;
import com.voronovich.exceptions.DaoException;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@ContextConfiguration("/beans-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@Rollback(true)
public class RoleDaoImplTest {

    @Autowired
    private RoleDao dao;

    @Test
    public void saveRole() throws DaoException {
        RoleEntity roleEntity = new RoleEntity(4, "test");
        List<RoleEntity> before = dao.getAllRoles();
        int sizeBefore = before.size();
        dao.saveOrUpdate(roleEntity);
        List<RoleEntity> after = dao.getAllRoles();
        int sizeAfter = after.size();
        Assert.assertEquals("Not created", sizeBefore + 1, sizeAfter);
    }

    @Test
    public void getRoleById() throws DaoException {
        RoleEntity roleEntity = dao.get(2);
        Assert.assertEquals("Not got", "admin", roleEntity.getName());
    }

    @Test
    public void deleteRole() throws DaoException {
        List<RoleEntity> before = dao.getAllRoles();
        int sizeBefore = before.size();
        RoleEntity roleEntity = dao.get(3);
        dao.delete(roleEntity);
        List<RoleEntity> after = dao.getAllRoles();
        int sizeAfter = after.size();
        Assert.assertEquals("Not deleted", sizeBefore - 1, sizeAfter);
    }
}
