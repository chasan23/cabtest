package com.cabtest.managed.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.hibernate.mapping.Array;

import com.cabtest.model.DriverDetails;
import com.cabtest.model.Vehicle;
import com.cabtest.service.DriverRegisterService;
import com.cabtest.service.VehicleRegisterService;

@ManagedBean(name="driverMB")
@RequestScoped
public class DriverManagedBean {
	private static final long serialVersionUID = 1L;
	private static final String SUCCESS = "success";
	private static final String ERROR = "error";

	DriverRegisterService driverRegisterService;

	String driverId;
	String firstName;
	String lastName;
	String age;
	String homePhone;
	String mobilePhone;
	String email;
	String address;
	String availability;
	
	List<DriverDetails> driverList = new ArrayList<DriverDetails>();

	public String addDriver() {
		return SUCCESS;
	}

	public String deleteDriver() {
		return SUCCESS;
	}

	public String updateDriver() {
		return SUCCESS;
	}

	public void reset() {

	}

	public DriverRegisterService getDriverRegisterService() {
		return driverRegisterService;
	}

	public String getDriverId() {
		return driverId;
	}

	public void setDriverId(String driverId) {
		this.driverId = driverId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getHomePhone() {
		return homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

	public List<DriverDetails> getDriverList() {
		return driverList;
	}

	public void setDriverList(List<DriverDetails> driverList) {
		this.driverList = driverList;
	}

	public void setDriverRegisterService(DriverRegisterService driverRegisterService) {
		this.driverRegisterService = driverRegisterService;
	}

}
