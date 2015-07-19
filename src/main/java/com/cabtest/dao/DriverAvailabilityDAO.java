package com.cabtest.dao;

import com.cabtest.model.DriverAvailability;
import com.cabtest.model.Location;

import java.sql.Date;
import java.util.List;

public interface DriverAvailabilityDAO extends GenericDAO<DriverAvailability, Integer> {
    List<DriverAvailability> getAvailableDrivers(Date date, List<Location> location);
}
