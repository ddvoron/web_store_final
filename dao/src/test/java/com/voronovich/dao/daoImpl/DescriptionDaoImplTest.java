package com.voronovich.dao.daoImpl;

import com.voronovich.dao.DataDao;
import com.voronovich.dao.DescriptionDao;
import com.voronovich.entity.DataEntity;
import com.voronovich.entity.DescriptionEntity;
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
public class DescriptionDaoImplTest {

    @Autowired
    DescriptionDao dao;

    @Autowired
    DataDao dataDao;

    @Test
    public void saveCatalog() throws DaoException {
        DataEntity dataEntity = dataDao.get(41);
            DescriptionEntity descriptionEntity = new DescriptionEntity(1000,"test","test",dataEntity);
            List<DescriptionEntity> before = dao.getAllDescription();
            int sizeBefore = before.size();
            dao.saveOrUpdate(descriptionEntity);
            List<DescriptionEntity> after = dao.getAllDescription();
            int sizeAfter = after.size();
            Assert.assertEquals("Not created", sizeBefore + 1, sizeAfter);
    }

    @Test
    public void getByData() throws DaoException{
        DataEntity dataEntity = dataDao.get(41);
            List<DescriptionEntity> descriptionEntities = dao.getAllDescriptionByData(dataEntity);
            Assert.assertNotNull(descriptionEntities);
    }

    @Test
    public void deleteCatalog() throws DaoException {
            List<DescriptionEntity> before = dao.getAllDescription();
            int sizeBefore = before.size();
            DescriptionEntity descriptionEntity = dao.get(514);
            dao.delete(descriptionEntity);
            List<DescriptionEntity> after = dao.getAllDescription();
            int sizeAfter = after.size();
            Assert.assertEquals("Not deleted", sizeBefore - 1, sizeAfter);
    }
}
