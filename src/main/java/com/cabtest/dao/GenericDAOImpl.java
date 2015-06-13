package com.cabtest.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@SuppressWarnings("unchecked")
@Repository
public  abstract class GenericDAOImpl<E, K extends Serializable> implements GenericDAO<E, K>{

	private SessionFactory sessionFactory;
	private Class<E> clazz;
	
	public GenericDAOImpl(){
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		this.clazz = (Class<E>) pt.getActualTypeArguments()[0]; 
	}
	
	public Class<E> getCurrentClazz() {
		return clazz;
	}
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	protected Session getCurrentSession(){
		return sessionFactory.getCurrentSession();
	}
	
	public void save(E entity) {
		this.getCurrentSession().save(entity);
	}

	public void saveOrUpdate(E entity) {
		this.getCurrentSession().saveOrUpdate(entity);
	}

	public void update(E entity) {
		this.getCurrentSession().update(entity);
	}

	public void delete(E entity) {
		this.getCurrentSession().delete(entity);
	}
	
	public void deleteByKey(K key){
		E entity = this.findByKey(key);
		this.delete(entity);
	}

	public E findByKey(K key) {
		Session session = this.getCurrentSession();
		E p = (E)session.load(this.getCurrentClazz(), key);
		return p;
	}

	public List<E> getAll() {
		List<E> list = this.getCurrentSession().createCriteria(this.getCurrentClazz()).list();
		return list;
	}

}
