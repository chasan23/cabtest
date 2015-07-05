package com.cabtest.service;

import com.cabtest.model.VehicleAvailability;

public interface VehicleAvailabilityService extends GenericPersistenceService<VehicleAvailability, Integer> {
    VehicleAvailability getVehicleAvailability ();
}
