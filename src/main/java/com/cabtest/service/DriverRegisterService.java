package com.cabtest.service;

import com.cabtest.bean.TimeSlot;
import com.cabtest.model.Driver;
import com.cabtest.model.DriverDetails;
import com.cabtest.model.Location;

import java.util.List;

public interface DriverRegisterService {

    void saveDriver(Driver driver);

    void updateDriver(DriverDetails driver);

    void deleteDriver(Driver driver);

    List<Driver> getDriverList();

    void deleteDriverByID(Integer id);

    Driver getAvailableDriver();
}
