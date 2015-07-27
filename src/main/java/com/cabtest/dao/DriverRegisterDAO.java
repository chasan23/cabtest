package com.cabtest.dao;

import com.cabtest.dto.DriverDTO;

import java.util.List;

public interface DriverRegisterDAO {
    void saveDriver(DriverDTO driverDTO);

    void updateDriver(DriverDTO driverDTO);

    void deleteDriver(DriverDTO driverDTO);

    void getDriverList(List<DriverDTO> driverdetailsList);
}
