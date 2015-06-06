package com.cabtest.service;

import java.util.List;

import com.cabtest.model.DriverDetails;

public interface DriverRegisterService {

	void saveDriver(DriverDetails driverDetails);

	void updateDriver(DriverDetails driverDetails);

	void deleteDriver(DriverDetails driverDetails);

	void getDriverList(List<DriverDetails> driverdetailsList);
}
