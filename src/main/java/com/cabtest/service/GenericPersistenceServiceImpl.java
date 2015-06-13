package com.cabtest.service;

import com.cabtest.dao.GenericDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Service
public class GenericPersistenceServiceImpl<E, K extends Serializable> implements GenericPersistenceService<E, K> {

    private GenericDAO<E, Serializable> genericDAO;

    public GenericPersistenceServiceImpl(GenericDAO<E, Serializable> genericDAO) {
        this.genericDAO = genericDAO;
    }

    public GenericPersistenceServiceImpl() {

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void save(E entity) {
        genericDAO.save(entity);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void update(E entity) {
        genericDAO.update(entity);

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void saveOrUpdate(E entity) {
        genericDAO.saveOrUpdate(entity);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(E entity) {
        genericDAO.delete(entity);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteByKey(K key) {
        genericDAO.deleteByKey(key);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<E> getAll() {
        return genericDAO.getAll();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public E findByKey(K key) {
        return genericDAO.findByKey(key);
    }

    public void setGenericDAO(GenericDAO<E, Serializable> genericDAO) {
        this.genericDAO = genericDAO;
    }


}
