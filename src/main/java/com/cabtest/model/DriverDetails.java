package com.cabtest.model;

public class DriverDetails {

	int driverId;
	String firstName;
	String lastName;
	int age;
	String availability;

	public DriverDetails(Driver driver) {
		this.firstName = driver.getFirstName();
		this.driverId = driver.getDriverId();
		this.lastName = driver.getLastName();
		this.age = driver.getAge();
		
		if(driver.getAvailability() == '1'){
			this.setAvailability("true");
		} else {
			this.setAvailability("false");
		}
		
		
	}

	public int getDriverId() {
		return driverId;
	}

	public void setDriverId(int driverId) {
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

	@Override
	public String toString() {
		return "DriverDetails [driverId=" + driverId + ", firstName="
				+ firstName + ", lastName=" + lastName + ", age=" + age
				+ ", availability=" + availability + "]";
	}
	
	

}
