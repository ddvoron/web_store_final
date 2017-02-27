package com.voronovich.dao.daoImpl;

import com.voronovich.dao.CatalogDao;
import com.voronovich.entity.CatalogEntity;
import com.voronovich.exceptions.DaoException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@ContextConfiguration("/beans-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@Rollback(true)
public class CatalogDaoImplTest {

    @Autowired
    private CatalogDao dao;

    @Test
    public void aSaveCatalog() throws DaoException {
        CatalogEntity roleEntity = new CatalogEntity(10,"test");
            List<CatalogEntity> before = dao.getAllDepartments();
            int sizeBefore = before.size();
            dao.saveOrUpdate(roleEntity);
            List<CatalogEntity> after = dao.getAllDepartments();
            int sizeAfter = after.size();
            Assert.assertEquals("Not created", sizeBefore + 1, sizeAfter);
    }

    @Test
    public void bGetCatalogById() throws DaoException {
            CatalogEntity catalogEntity = dao.get(4);
            Assert.assertEquals("Not got", "mobile", catalogEntity.getDepartment());
    }

    @Test
    public void cDeleteCatalog() throws DaoException {
            List<CatalogEntity> before = dao.getAllDepartments();
            int sizeBefore = before.size();
            CatalogEntity catalogEntity = dao.get(5);
            dao.delete(catalogEntity);
            List<CatalogEntity> after = dao.getAllDepartments();
            int sizeAfter = after.size();
            Assert.assertEquals("Not deleted", sizeBefore - 1, sizeAfter);
    }
}
