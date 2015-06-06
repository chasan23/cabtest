package com.cabtest.service;

import org.springframework.stereotype.Service;

import com.cabtest.dao.GenericDAO;
import com.cabtest.dao.DriverDAO;
import com.cabtest.model.Driver;

@Service
public class DriverRegisterServiceImpl extends GenericPersistenceServiceImpl<Driver, Integer> implements DriverRegisterService {
private DriverDAO driverDAO;
	
	
	public DriverRegisterServiceImpl() {
		super();
	}


	public DriverDAO getDriverDAO() {
		return driverDAO;
	}


	public void setDriverDAO(DriverDAO driverDAO) {
		super.setGenericDAO((GenericDAO)driverDAO);
		this.driverDAO = driverDAO;
	}

}
