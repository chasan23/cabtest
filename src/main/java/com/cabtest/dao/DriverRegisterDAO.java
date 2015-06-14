package com.cabtest.dao;

import com.cabtest.model.DriverDetails;

import java.util.List;

public interface DriverRegisterDAO {
    void saveDriver(DriverDetails driverDetails);

    void updateDriver(DriverDetails driverDetails);

    void deleteDriver(DriverDetails driverDetails);

    void getDriverList(List<DriverDetails> driverdetailsList);
}
