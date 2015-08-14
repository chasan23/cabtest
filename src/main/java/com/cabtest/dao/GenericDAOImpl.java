package com.cabtest.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SuppressWarnings("unchecked")
@Repository
public abstract class GenericDAOImpl<E, K extends Serializable> implements GenericDAO<E, K>, Serializable {

    private SessionFactory sessionFactory;
    private Class<E> clazz;

    public GenericDAOImpl() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        this.clazz = (Class<E>) pt.getActualTypeArguments()[0];
    }

    public Class<E> getCurrentClazz() {
        return clazz;
    }

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void save(E entity) {
        this.getCurrentSession().save(entity);
    }

    @Override
    public void saveOrUpdate(E entity) {
        this.getCurrentSession().saveOrUpdate(entity);
    }

    @Override
    public void update(E entity) {
        this.getCurrentSession().update(entity);
    }

    @Override
    public void delete(E entity) {
        this.getCurrentSession().delete(entity);
    }

    @Override
    public void deleteByKey(K key) {
        E entity = this.findByKey(key);
        this.delete(entity);
    }

    @Override
    public E findByKey(K key) {
        Session session = this.getCurrentSession();
        return (E) session.load(this.getCurrentClazz(), key);
    }

    @Override
    public List<E> getAll() {
        Set<E> set = new HashSet<>();
        set.addAll(this.getCurrentSession().createCriteria(this.getCurrentClazz()).list());
        List<E> duplicatesRemoved = new ArrayList();
        duplicatesRemoved.addAll(set);
        return duplicatesRemoved;
    }

}
