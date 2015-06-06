package com.cabtest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DRIVER")
public class Driver {
	
	@Id
	@Column(name = "DRIVER_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int driverId;

	@Column(name = "FIRST_NAME")
	String firstName;

	@Column(name = "LAST_NAME")
	String lastName;

	@Column(name = "AGE")
	int age;

	@Column(name = "CONTACT_ID")
	int contactId;

	@Column(name = "AVAILABILITY")
	String availability;

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

	public int getContactId() {
		return contactId;
	}

	public void setContactId(int contactId) {
		this.contactId = contactId;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

}
