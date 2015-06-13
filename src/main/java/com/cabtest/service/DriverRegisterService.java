package com.cabtest.service;

import com.cabtest.model.Driver;

import java.util.List;

public interface DriverRegisterService {

    void saveDriver(Driver driver);

    void updateDriver(Driver driver);

    void deleteDriver(Driver driver);

    List<Driver> getDriverList();

    void deleteDriverByID(Integer id);
}
