package com.cabtest.service;

import com.cabtest.model.DriverVehicle;
import org.springframework.stereotype.Service;

@Service
public class DriverVehicleServiceImpl extends GenericPersistenceServiceImpl<DriverVehicle, Integer>
        implements DriverVehicleService {

    public DriverVehicleServiceImpl() {
        super();
    }


    @Override
    public DriverVehicle getDriverVehicle(int driverId) {
        return null;
    }
}




