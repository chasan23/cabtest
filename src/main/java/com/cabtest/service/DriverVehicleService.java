package com.cabtest.service;

import com.cabtest.model.DriverVehicle;

public interface DriverVehicleService extends GenericPersistenceService<DriverVehicle, Integer> {
    DriverVehicle getDriverVehicle(int driverId);
}
