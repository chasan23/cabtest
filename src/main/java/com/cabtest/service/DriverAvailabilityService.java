package com.cabtest.service;

import com.cabtest.bean.TimeSlot;
import com.cabtest.dto.DriverAvailabilityDTO;
import com.cabtest.model.DriverAvailability;
import com.cabtest.model.DriverVehicle;
import com.cabtest.model.Location;

import java.sql.Date;
import java.util.List;

public interface DriverAvailabilityService extends GenericPersistenceService<DriverAvailability, Integer> {

    void save(DriverAvailabilityDTO driverAvailabilityDTO);

    DriverAvailability getDriverAvailability ();

    DriverVehicle getFirstAvailableDriver(Date date, List<Location> locations, TimeSlot startTime, TimeSlot endTime,
                                          String vehicleType);
}
