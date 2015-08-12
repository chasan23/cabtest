package com.cabtest.service;

import com.cabtest.dto.DriverDTO;
import com.cabtest.model.Driver;

import java.util.List;

public interface DriverRegisterService {

    void saveDriver(Driver driver);

    void updateDriver(DriverDTO driver);

    void deleteDriver(Driver driver);

    List<Driver> getDriverList();

    void deleteDriverByID(Integer id);

    Driver getAvailableDriver();

    void updateIsAvailable(Driver driver);
}
