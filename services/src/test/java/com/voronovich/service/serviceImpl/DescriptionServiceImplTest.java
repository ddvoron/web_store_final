package com.voronovich.service.serviceImpl;

import com.voronovich.entity.DataEntity;
import com.voronovich.entity.DescriptionEntity;
import com.voronovich.exceptions.DaoException;
import com.voronovich.service.DataService;
import com.voronovich.service.DescriptionService;
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
public class DescriptionServiceImplTest {

    @Autowired
    DescriptionService service;

    @Autowired
    DataService dataService;

    @Test
    public void saveCatalog() throws DaoException {
        DataEntity dataEntity = dataService.get(41);
            DescriptionEntity descriptionEntity = new DescriptionEntity(1000,"test","test",dataEntity);
            List<DescriptionEntity> before = service.getAllDescriptions();
            int sizeBefore = before.size();
            service.saveOrUpdate(descriptionEntity);
            List<DescriptionEntity> after = service.getAllDescriptions();
            int sizeAfter = after.size();
            Assert.assertEquals("Not created", sizeBefore + 1, sizeAfter);
    }

    @Test
    public void getByData() throws DaoException{
        DataEntity dataEntity = dataService.get(41);
            List<DescriptionEntity> descriptionEntities = service.getAllDescriptionsByData(dataEntity);
            Assert.assertNotNull(descriptionEntities);
    }

    @Test
    public void deleteCatalog() throws DaoException {
            List<DescriptionEntity> before = service.getAllDescriptions();
            int sizeBefore = before.size();
            DescriptionEntity descriptionEntity = service.get(514);
            service.delete(descriptionEntity);
            List<DescriptionEntity> after = service.getAllDescriptions();
            int sizeAfter = after.size();
            Assert.assertEquals("Not deleted", sizeBefore - 1, sizeAfter);
    }
}
