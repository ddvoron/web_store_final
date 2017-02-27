package com.voronovich.dao.daoImpl;

import com.voronovich.dao.RoleDao;
import com.voronovich.entity.RoleEntity;
import com.voronovich.exceptions.DaoException;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoleDaoImpl extends DaoImpl<RoleEntity> implements RoleDao {

    private Logger log = Logger.getLogger(RoleDaoImpl.class);

    @Autowired
    public RoleDaoImpl(SessionFactory sessionFactory){
        super(sessionFactory);
    }

    @Override
    public List<RoleEntity> getAllRoles() throws DaoException {
        List<RoleEntity> roleEntities;
        try {
            Query query = getSession().getNamedQuery("getAllRoles");
            roleEntities =  query.list();
            log.info("Got all roles:" + roleEntities);
            return roleEntities;
        } catch (HibernateException e) {
            log.error("Error getting all roles" + e);
            throw new DaoException(e);
        }
    }
}

