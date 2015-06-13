package com.cabtest.service;

import java.io.Serializable;
import java.util.List;

public interface GenericPersistenceService<E, K extends Serializable> {
    void save(E entity);

    void update(E entity);

    void saveOrUpdate(E entity);

    void delete(E entity);

    void deleteByKey(K key);

    List<E> getAll();

    E findByKey(K key);
}
