package com.cabtest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
    int vehicleId;

    @Column(name = "REG_NUMBER")
    String registrationNumber;

    @Column(name = "VEHICLE_TYPE")
    String vehicleType;

    @Column(name = "MODEL")
    String model;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "vehicle")
    Set<DriverAvailability> availability = new HashSet<>(0);

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "vehicles")
    Set<Driver> drivers = new HashSet<>(0);

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "vehicle")
    Set<Assignment> assignments = new HashSet<>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "vehicle")
    Set<Settlement> settlements = new HashSet<>();

    public Vehicle() {
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
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

    public Set<Assignment> getAssignments() {
        return assignments;
    }

    public void setAssignments(Set<Assignment> assignments) {
        this.assignments = assignments;
    }

    public Set<Driver> getDrivers() {
        return drivers;
    }

    public void setDrivers(Set<Driver> drivers) {
        this.drivers = drivers;
    }

    public Set<Settlement> getSettlements() {
        return settlements;
    }

    public void setSettlements(Set<Settlement> settlements) {
        this.settlements = settlements;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleId=" + vehicleId +
                ", registrationNumber='" + registrationNumber + '\'' +
                ", vehicleType='" + vehicleType + '\'' +
                ", model='" + model + '\'' +
                ", availability=" + availability +
                ", drivers=" + drivers +
                ", assignments=" + assignments +
                ", settlements=" + settlements +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vehicle vehicle = (Vehicle) o;

        return vehicleId == vehicle.vehicleId;

    }

    @Override
    public int hashCode() {
        return vehicleId;
    }
}
