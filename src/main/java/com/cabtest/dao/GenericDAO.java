package com.cabtest.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDAO<E, K extends Serializable> {
	
	E findByKey(K key);

	void save(E entity);
	
	void update(E entity);

	void saveOrUpdate(E entity);
	
	void delete(E entity);
	
	void deleteByKey(K key);
	
	List<E> getAll();
	
}