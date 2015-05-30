package com.cabtest.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cabtest.dao.GenericDAO;
import com.cabtest.model.Vehicle;

@Service
public  class GenericPersistenceServiceImpl<E, K extends Serializable> implements GenericPersistenceService<E, K> {

	private GenericDAO<E, Serializable> genericDAO;
	
	public GenericPersistenceServiceImpl(GenericDAO<E, Serializable> genericDAO){
		this.genericDAO = genericDAO;
	}
	
	public GenericPersistenceServiceImpl(){
		
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void save(E entity) {
		genericDAO.save(entity);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void update(E entity) {
		genericDAO.update(entity);
		
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void saveOrUpdate(E entity) {
		genericDAO.saveOrUpdate(entity);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(E entity) {
		genericDAO.delete(entity);
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void deleteByKey(K key){
		genericDAO.deleteByKey(key);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public List<E> getAll() {
		return genericDAO.getAll();
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public E findByKey(K key) {
		return genericDAO.findByKey(key);
	}

	public GenericDAO<E, Serializable> getGenericDAO() {
		return genericDAO;
	}

	public void setGenericDAO(GenericDAO<E, Serializable> genericDAO) {
		this.genericDAO = genericDAO;
	}

	
}
