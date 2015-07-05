package com.cabtest.service;

import com.cabtest.dao.GenericDAO;
import com.cabtest.dao.DriverVehicleDAO;
import com.cabtest.model.DriverVehicle;

import org.springframework.stereotype.Service;

@Service
public class DriverVehicleServiceImpl extends GenericPersistenceServiceImpl<DriverVehicle, Integer>
        implements DriverVehicleService {

    private DriverVehicleDAO driverVehicleDAO;


    public DriverVehicleServiceImpl() {
        super();
    }


    public DriverVehicleDAO getDriverVehicleDAO() {
        return driverVehicleDAO;
    }

    @SuppressWarnings("unchecked")
    public void setDriverVehicleDAO(DriverVehicleDAO driverVehicleDAO) {
        super.setGenericDAO((GenericDAO) driverVehicleDAO);
        this.driverVehicleDAO = driverVehicleDAO;
    }

    @Override
    public DriverVehicle getDriverVehicle(int driverId) {
        return null;
    }
}




