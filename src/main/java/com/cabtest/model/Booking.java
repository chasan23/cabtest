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
import java.sql.Timestamp;

@Entity
@Table(name = "BOOKING", catalog = "cab")
public class Booking {

    @Id
    @Column(name = "BOOKING_ID", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookingId;

    @Column(name = "VEHICLE_TYPE")
    private String vehicleType;

    @Column(name = "TIME")
    private Timestamp time;

    @Column(name = "LOCATION")
    private String location;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CUSTOMER_ID", nullable = false)
    private Customer customer;

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Booking booking = (Booking) o;

        return bookingId == booking.bookingId;

    }

    @Override
    public int hashCode() {
        return bookingId;
    }

    @Override
    public String toString() {
        return "Booking{" +
               "bookingId=" + bookingId +
               ", vehicleType='" + vehicleType + '\'' +
               ", time=" + time +
               ", location='" + location + '\'' +
               ", customer=" + customer +
               '}';
    }
}
