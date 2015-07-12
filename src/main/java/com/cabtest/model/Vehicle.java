package com.cabtest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;


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

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "vehicle")
    Set<DriverAvailability> availability = new HashSet<>(0);

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

    public Set<DriverAvailability> getAvailability() {
        return availability;
    }

    public void setAvailability(Set<DriverAvailability> availability) {
        this.availability = availability;
    }
}
