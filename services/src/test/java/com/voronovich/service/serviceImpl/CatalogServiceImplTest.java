package com.voronovich.service.serviceImpl;

import com.voronovich.entity.CatalogEntity;
import com.voronovich.exceptions.DaoException;
import com.voronovich.service.CatalogService;
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
public class CatalogServiceImplTest {

    @Autowired
    private CatalogService service;

    @Test
    public void aSaveCatalog() throws DaoException {
        CatalogEntity roleEntity = new CatalogEntity(10,"test");
            List<CatalogEntity> before = service.getAllDepartments();
            int sizeBefore = before.size();
            service.saveOrUpdate(roleEntity);
            List<CatalogEntity> after = service.getAllDepartments();
            int sizeAfter = after.size();
            Assert.assertEquals("Catalog not created", sizeBefore + 1, sizeAfter);
    }

    @Test
    public void bGetCatalogById() throws DaoException {
            CatalogEntity catalogEntity = service.get(4);
            Assert.assertEquals("Not got", "mobile", catalogEntity.getDepartment());
    }

    @Test
    public void cDeleteCatalog() throws DaoException {
            List<CatalogEntity> before = service.getAllDepartments();
            int sizeBefore = before.size();
            CatalogEntity catalogEntity = service.get(5);
            service.delete(catalogEntity);
            List<CatalogEntity> after = service.getAllDepartments();
            int sizeAfter = after.size();
            Assert.assertEquals("Catalog not deleted", sizeBefore - 1, sizeAfter);
    }
}
