package com.voronovich.service.serviceImpl;

import com.voronovich.entity.CatalogEntity;
import com.voronovich.entity.DataEntity;
import com.voronovich.exceptions.DaoException;
import com.voronovich.service.DataService;
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
@Rollback
public class DataServiceImplTest {

    private Date date = new Date();
    private CatalogEntity catalogEntity = new CatalogEntity(4, "mobile");

    @Autowired
    private DataService service;

    @Test
    public void saveData() throws DaoException {
        List<DataEntity> before = service.getAllData();
        int sizeBefore = before.size();
        DataEntity dataEntity = new DataEntity(500, "test",
                "test", 1, "test", "test", date,
                "test", date, "test", catalogEntity);
        service.saveOrUpdate(dataEntity);
        List<DataEntity> after = service.getAllData();
        int sizeAfter = after.size();
        Assert.assertEquals("Data not created", sizeBefore + 1, sizeAfter);
    }

    @Test
    public void getByPagination() throws DaoException {
        List<DataEntity> dataEntity = service.getAllDataPerPage(1, 3);
        int size = dataEntity.size();
        Assert.assertEquals("Not got", 3, size);
    }

    @Test
    public void getPaginationByEntity() throws DaoException {
        List<DataEntity> dataEntity = service.getAllDataPerPage(1,
                3, catalogEntity);
        int size = dataEntity.size();
        Assert.assertEquals("Not got", 3, size);
    }

    @Test
    public void getPaginationEntityCost() throws DaoException {
        List<DataEntity> dataEntity = service.getAllDataPerPageAndCost(1,
                3, 1, 1000, catalogEntity);
        int size = dataEntity.size();
        Assert.assertEquals("Not got", 3, size);
    }

    @Test
    public void getDataById() throws DaoException {
        DataEntity dataEntity = service.get(1);
        Assert.assertEquals("Not got", "ATLANT", dataEntity.getBrand());
    }

    @Test
    public void deleteData() throws DaoException {
        List<DataEntity> before = service.getAllData();
        int sizeBefore = before.size();
        DataEntity dataEntity = service.get(41);
        service.delete(dataEntity);
        List<DataEntity> after = service.getAllData();
        int sizeAfter = after.size();
        Assert.assertEquals("Data not deleted", sizeBefore - 1, sizeAfter);
    }
}
