package com.cabtest.service;

import com.cabtest.dao.GenericDAO;
import com.cabtest.dao.VehicleAvailabilityDAO;
import com.cabtest.model.VehicleAvailability;

import org.springframework.stereotype.Service;

@Service
public class VehicleAvailabilityServiceImpl extends GenericPersistenceServiceImpl<VehicleAvailability, Integer>
        implements VehicleAvailabilityService {

    private VehicleAvailabilityDAO vehicleAvailabilityDAO;


    public VehicleAvailabilityServiceImpl() {
        super();
    }


    public VehicleAvailabilityDAO getVehicleAvailabilityDAO() {
        return vehicleAvailabilityDAO;
    }

    @SuppressWarnings("unchecked")
    public void setVehicleAvailabilityDAO(VehicleAvailabilityDAO vehicleAvailabilityDAO) {
        super.setGenericDAO((GenericDAO) vehicleAvailabilityDAO);
        this.vehicleAvailabilityDAO = vehicleAvailabilityDAO;
    }

    @Override
    public VehicleAvailability getVehicleAvailability() {
        return getFirstAvailableDriver(null, null, null, null);
    }
}



