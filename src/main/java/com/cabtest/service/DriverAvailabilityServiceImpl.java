package com.cabtest.service;

import com.cabtest.dao.GenericDAO;
import com.cabtest.dao.DriverAvailabilityDAO;
import com.cabtest.model.DriverAvailability;
import com.cabtest.model.Vehicle;
import org.springframework.stereotype.Service;

@Service
public class DriverAvailabilityServiceImpl extends GenericPersistenceServiceImpl<DriverAvailability, Integer>
        implements DriverAvailabilityService {

    private DriverAvailabilityDAO driverAvailabilityDAO;


    public DriverAvailabilityServiceImpl() {
        super();
    }


    public DriverAvailabilityDAO getDriverAvailabilityDAO() {
        return driverAvailabilityDAO;
    }

    @SuppressWarnings("unchecked")
    public void setDriverAvailabilityDAO(DriverAvailabilityDAO driverAvailabilityDAO) {
        super.setGenericDAO((GenericDAO) driverAvailabilityDAO);
        this.driverAvailabilityDAO = driverAvailabilityDAO;
    }

    @Override
    public DriverAvailability getDriverAvailability() {
        return null;
    }
}


