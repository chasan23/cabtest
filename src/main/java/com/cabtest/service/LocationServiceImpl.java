package com.cabtest.service;

import com.cabtest.dao.GenericDAO;
import com.cabtest.dao.LocationDAO;

import org.springframework.stereotype.Service;

@Service
public class LocationServiceImpl extends GenericPersistenceServiceImpl<Location, Integer>
        implements LocationService {

    private LocationDAO locationDAO;


    public LocationServiceImpl() {
        super();
    }


    public LocationDAO getLocationDAO() {
        return locationDAO;
    }

    @SuppressWarnings("unchecked")
    public void setLocationDAO(LocationDAO locationDAO) {
        super.setGenericDAO((GenericDAO) locationDAO);
        this.locationDAO = locationDAO;
    }

    @Override
    public Location getLocation(int id) {
        return getFirstAvailableDriver(null, null, null, null);
    }
}






