package com.cabtest.service;

import com.cabtest.model.DriverAvailability;

public interface DriverAvailabilityService extends GenericPersistenceService<DriverAvailability, Integer> {
DriverAvailability getDriverAvailability ();
}
