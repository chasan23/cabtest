package com.cabtest.service;

import com.cabtest.model.Location;

/**
 * Vehical Service Interface
 *
 * @author onlinetechvision.com
 * @version 1.0.0
 * @since 25 Mar 2012
 */
public interface LocationService extends GenericPersistenceService<Location, Integer> {

    Location getLocation(int id);

}