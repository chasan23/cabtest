package com.cabtest.service;

import com.cabtest.bean.TimeSlot;
import com.cabtest.model.Driver;
import com.cabtest.model.DriverAvailability;
import com.cabtest.model.DriverVehicle;
import com.cabtest.model.Location;

import java.sql.Date;
import java.util.List;

public interface DriverAvailabilityService extends GenericPersistenceService<DriverAvailability, Integer> {
    DriverAvailability getDriverAvailability ();

    DriverVehicle getFirstAvailableDriver(Date date, List<Location> locations, TimeSlot startTime, TimeSlot endTime,
                                          String vehicleType);
}
