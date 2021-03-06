package com.cabtest.service;

import com.cabtest.model.Vehicle;

/**
 * Vehical Service Interface
 *
 * @author onlinetechvision.com
 * @version 1.0.0
 * @since 25 Mar 2012
 */
public interface VehicleRegisterService extends GenericPersistenceService<Vehicle, Integer> {

    Vehicle getAvailableVehicle(String vehicleType);

}
