package com.voronovich.dao.daoImpl;

import com.voronovich.dao.DataDao;
import com.voronovich.entity.CatalogEntity;
import com.voronovich.entity.DataEntity;
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
public class DataDaoImplTest {

    private Date date = new Date();
    private CatalogEntity catalogEntity = new CatalogEntity(4, "mobile");

    @Autowired
    private DataDao dao;

    @Test
    public void saveData() throws DaoException {
        List<DataEntity> before = dao.getAllData();
        int sizeBefore = before.size();
        DataEntity dataEntity = new DataEntity(500, "test",
                "test", 1, "test", "test", date,
                "test", date, "test", catalogEntity);
        dao.saveOrUpdate(dataEntity);
        List<DataEntity> after = dao.getAllData();
        int sizeAfter = after.size();
        Assert.assertEquals("Not created", sizeBefore + 1, sizeAfter);
    }

    @Test
    public void getByPagination() throws DaoException {
        List<DataEntity> dataEntity = dao.getAllDataPerPage(1, 3);
        int size = dataEntity.size();
        Assert.assertEquals("Not got", 3, size);
    }

    @Test
    public void getPaginationByEntity() throws DaoException {
        List<DataEntity> dataEntity = dao.getAllDataPerPage(1,
                3, catalogEntity);
        int size = dataEntity.size();
        Assert.assertEquals("Not got", 3, size);
    }

    @Test
    public void getPaginationEntityCost() throws DaoException {
        List<DataEntity> dataEntity = dao.getAllDataPerPageAndCost(1,
                3, 1, 1000, catalogEntity);
        int size = dataEntity.size();
        Assert.assertEquals("Not got", 3, size);
    }

    @Test
    public void getDataById() throws DaoException {
        DataEntity dataEntity = dao.get(1);
        Assert.assertEquals("Not got", "ATLANT", dataEntity.getBrand());
    }

    @Test
    public void deleteData() throws DaoException {
        List<DataEntity> before = dao.getAllData();
        int sizeBefore = before.size();
        DataEntity dataEntity = dao.get(41);
        dao.delete(dataEntity);
        List<DataEntity> after = dao.getAllData();
        int sizeAfter = after.size();
        Assert.assertEquals("Not deleted", sizeBefore - 1, sizeAfter);
    }
}
