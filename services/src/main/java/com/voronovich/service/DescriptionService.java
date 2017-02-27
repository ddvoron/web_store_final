package com.voronovich.service;

import com.voronovich.entity.DataEntity;
import com.voronovich.entity.DescriptionEntity;

import java.io.Serializable;
import java.util.List;

/**
 * Interface contains abstract methods
 * for DescriptionService layer
 *
 * @author Dmitry V
 * @version 1.0
 */
public interface DescriptionService{

    /**
     * Method saves or updates descriptionEntity
     *
     * @param descriptionEntity DescriptionEntity
     */
    void saveOrUpdate(DescriptionEntity descriptionEntity);

    /**
     * Method removes descriptionEntity from database
     *
     * @param descriptionEntity DescriptionEntity
     */
    void delete(DescriptionEntity descriptionEntity);

    /**
     * Method gets descriptionEntity by it's id
     *
     * @param id descriptionEntity ID
     * @return descriptionEntity DescriptionEntity
     */
    DescriptionEntity get(Serializable id);

    /**
     * Method reads the whole list of descriptions
     *
     * @return List<DescriptionEntity>
     */
    List<DescriptionEntity> getAllDescriptions();

    /**
     * Method reads the whole list of descriptions
     * by dataEntity
     *
     * @return List<DescriptionEntity>
     */
    List<DescriptionEntity> getAllDescriptionsByData(DataEntity dataEntity);
}
