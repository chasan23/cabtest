package com.cabtest.dao;

import org.springframework.stereotype.Repository;
import com.cabtest.model.Driver;
import com.cabtest.dao.DriverDAO;

@Repository
public class DriverDAOImpl extends GenericDAOImpl<Driver, Integer> implements DriverDAO{

}
