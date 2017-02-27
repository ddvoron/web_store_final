package com.voronovich.service.serviceImpl;

import com.voronovich.entity.RoleEntity;
import com.voronovich.entity.UserEntity;
import com.voronovich.exceptions.DaoException;
import com.voronovich.service.UserService;
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

@ContextConfiguration("/beans-services.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@Rollback(true)
public class UserServiceImplTest {

    private Date date = new Date();

    @Autowired
    private UserService service;

    @Test
    public void saveUser() throws DaoException {
        RoleEntity roleEntity = new RoleEntity(3, "test");
            List<UserEntity> before = service.getAllUsers();
            int sizeBefore = before.size();
            UserEntity userEntity = new UserEntity(1, "test", "test", "test@mail.ru",
                    "test", "test", "test", "test", roleEntity, date);
        service.saveOrUpdate(userEntity);
            List<UserEntity> after = service.getAllUsers();
            int sizeAfter = after.size();
            Assert.assertEquals("User not created", sizeBefore + 1, sizeAfter);
    }

    @Test
    public void getUserById() throws DaoException {
            UserEntity userEntity = service.get(11);
            Assert.assertEquals("Not got", "superman", userEntity.getLogin());
    }

    @Test
    public void getUserByLogin() throws DaoException {
            UserEntity userEntity = service.getByLogin("superman");
            Assert.assertEquals("Not got", "superman", userEntity.getLogin());
    }

    @Test
    public void getUserByEmail() throws DaoException {
            UserEntity userEntity = service.getByEmail("dd.versus@gmail.com");
            Assert.assertEquals("Not got", "dd.versus@gmail.com", userEntity.getEmail());
    }

    @Test
    public void getUserByLoginAndPassword() throws DaoException {
            UserEntity userEntity = service.get("superman", "fa2ea19006ff591270d608e022ab63011ad160ef92454332eca039656e932ff4");
            Assert.assertEquals("Not got", "superman", userEntity.getLogin());
            Assert.assertEquals("Not got", "fa2ea19006ff591270d608e022ab63011ad160ef92454332eca039656e932ff4", userEntity.getPassword());
    }

    @Test
    public void deleteUser() throws DaoException {
            List<UserEntity> before = service.getAllUsers();
            int sizeBefore = before.size();
            UserEntity userEntity = service.get(14);
        service.delete(userEntity);
            List<UserEntity> after = service.getAllUsers();
            int sizeAfter = after.size();
            Assert.assertEquals("User not deleted", sizeBefore - 1, sizeAfter);
    }
}
