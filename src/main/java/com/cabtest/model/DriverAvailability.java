package com.cabtest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.sql.Date;


@Entity
@Table(name = "DRIVER_AVAILABILITY")
public class DriverAvailability {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "DRIVER_ID", nullable = false)
    Driver driver;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "VEHICLE_ID", nullable = false)
    Vehicle vehicle;

    @Column(name = "DATE")
    Date date;

    @Column(name = "TIME_SLOT")
    String timeSlot;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "LOCATION_ID", nullable = false)
    Location location;

    public DriverAvailability() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(String timeSlot) {
        this.timeSlot = timeSlot;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
