package com.cabtest.service;

import org.springframework.stereotype.Service;

import com.cabtest.dao.GenericDAO;
import com.cabtest.dao.VehicleDAO;
import com.cabtest.model.Vehicle;

@Service
public class VehicleRegisterServiceImpl extends GenericPersistenceServiceImpl<Vehicle, Integer> implements VehicleRegisterService {

	private VehicleDAO vehicleDAO;
	
	
	public VehicleRegisterServiceImpl() {
		super();
	}


	public VehicleDAO getVehicleDAO() {
		return vehicleDAO;
	}


	public void setVehicleDAO(VehicleDAO vehicleDAO) {
		super.setGenericDAO((GenericDAO)vehicleDAO);
		this.vehicleDAO = vehicleDAO;
	}

}

