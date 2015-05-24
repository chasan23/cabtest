package com.cabtest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VEHICLE")
public class Vehicle {
	
	@Id
	@Column(name = "VEHICLE_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int vehicalId;
	
	@Column(name = "REG_NUMBER")
	String registrationNumber;
	
	@Column(name = "VEHICLE_TYPE")
	String vehicalType;
	
	@Column(name = "MODEL")
	String model;
	
	@Column(name = "AVAILABILITY")
	boolean avilability;

	public Vehicle() {
	}
	
	public int getVehicalId() {
		return vehicalId;
	}

	public void setVehicalId(int vehicalId) {
		this.vehicalId = vehicalId;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public String getVehicalType() {
		return vehicalType;
	}

	public void setVehicalType(String vehicalType) {
		this.vehicalType = vehicalType;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public boolean isAvilability() {
		return avilability;
	}

	public void setAvilability(boolean avilability) {
		this.avilability = avilability;
	}
}
