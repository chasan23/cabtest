package com.cabtest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "BOOKING", catalog = "cab")
public class Booking {

    @Id
    @Column(name = "BOOKING_ID", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookingId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ORIGIN_ID", nullable = false)
    private Location origin;

    @Column(name = "ORIGIN_ADDRESS")
    private String originAddress;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "DESTINATION_ID", nullable = false)
    private Location destination;

    @Column(name = "VEHICLE_TYPE")
    private String vehicleType;

    @Column(name = "TIMESTAMP")
    private Timestamp time;

    @Column(name = "DURATION")
    private int duration;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CUSTOMER_ID", nullable = false)
    private Customer customer;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "booking")
    private Set<Assignment> assignments = new HashSet<>();

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

    public Location getOrigin() {
        return origin;
    }

    public void setOrigin(Location origin) {
        this.origin = origin;
    }

    public String getOriginAddress() {
        return originAddress;
    }

    public void setOriginAddress(String originAddress) {
        this.originAddress = originAddress;
    }

    public Location getDestination() {
        return destination;
    }

    public void setDestination(Location destination) {
        this.destination = destination;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }


    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Set<Assignment> getAssignments() {
        return assignments;
    }

    public void setAssignments(Set<Assignment> assignments) {
        this.assignments = assignments;
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
                ", origin=" + origin +
                ", originAddress='" + originAddress + '\'' +
                ", destination=" + destination +
                ", vehicleType='" + vehicleType + '\'' +
                ", time=" + time +
                ", duration=" + duration +
                ", customer=" + customer +
                ", assignments=" + assignments +
                '}';
    }
}
