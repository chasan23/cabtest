package com.cabtest.model;

import javax.persistence.*;
import java.awt.print.Book;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "ASSIGNMENT", catalog = "cab")
public class Assignment implements Serializable {

    private static final long serialVersionUID = 7895139095426977088L;

    @Id
    @Column(name = "ASSIGNMENT_ID", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int assignmentId;

    @Column(name = "BOOKING_ID")
    private Booking booking;

    @Column(name = "VEHICLE_ID")
    private Vehicle vehicle;

    @Column(name = "DRIVER_ID")
    private Driver driver;

    @Column(name = "TIME")
    private Timestamp time;

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public int getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(int assignmentId) {
        this.assignmentId = assignmentId;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }
}
