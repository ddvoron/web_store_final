package com.voronovich.dao.daoImpl;

import com.voronovich.dao.UserDao;
import com.voronovich.entity.RoleEntity;
import com.voronovich.entity.UserEntity;
import com.voronovich.exceptions.DaoException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@ContextConfiguration("/beans-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@Rollback(true)
public class UserDaoImplTest {

    private Date date = new Date();

    @Autowired
    private UserDao dao;

    @Test
    public void saveUser() throws DaoException {
        RoleEntity roleEntity = new RoleEntity(3, "test");
            List<UserEntity> before = dao.getAllUsers();
            int sizeBefore = before.size();
            UserEntity userEntity = new UserEntity(1, "test", "test", "test@mail.ru",
                    "test", "test", "test", "test", roleEntity, date);
            dao.saveOrUpdate(userEntity);
            List<UserEntity> after = dao.getAllUsers();
            int sizeAfter = after.size();
            Assert.assertEquals("Not created", sizeBefore + 1, sizeAfter);
    }

    @Test
    public void getUserById() throws DaoException {
            UserEntity userEntity = dao.get(11);
            Assert.assertEquals("Not got", "superman", userEntity.getLogin());
    }

    @Test
    public void getUserByLogin() throws DaoException {
            UserEntity userEntity = dao.getByLogin("superman");
            Assert.assertEquals("Not got", "superman", userEntity.getLogin());
    }

    @Test
    public void getUserByEmail() throws DaoException {
            UserEntity userEntity = dao.getByEmail("dd.versus@gmail.com");
            Assert.assertEquals("Not got", "dd.versus@gmail.com", userEntity.getEmail());
    }

    @Test
    public void getUserByLoginAndPassword() throws DaoException {
            UserEntity userEntity = dao.get("superman", "fa2ea19006ff591270d608e022ab63011ad160ef92454332eca039656e932ff4");
            Assert.assertEquals("Not got", "superman", userEntity.getLogin());
            Assert.assertEquals("Not got", "fa2ea19006ff591270d608e022ab63011ad160ef92454332eca039656e932ff4", userEntity.getPassword());
    }

    @Test
    public void deleteUser() throws DaoException {
            List<UserEntity> before = dao.getAllUsers();
            int sizeBefore = before.size();
            UserEntity userEntity = dao.get(14);
            dao.delete(userEntity);
            List<UserEntity> after = dao.getAllUsers();
            int sizeAfter = after.size();
            Assert.assertEquals("Not deleted", sizeBefore - 1, sizeAfter);
    }
}
