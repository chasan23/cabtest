package com.cabtest.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "DRIVER", catalog = "cab")
public class Driver extends Person implements Serializable {

    private static final long serialVersionUID = 7895139095426977088L;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "driver")
    Set<DriverAvailability> availability = new HashSet<>(0);

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "AGE")
    private int age;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "DRIVER_VEHICLE", catalog = "cab", joinColumns = {
            @JoinColumn(name = "DRIVER_ID", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "VEHICLE_ID", nullable = false, updatable = false) })
    Set<Vehicle> vehicles = new HashSet<>(0);

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "driver")
    Set<Assignment> assignments = new HashSet<>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "driver")
    Set<Settlement> settlements = new HashSet<>();

    public Driver() {
    }

    public Driver(int id) {
        setId(id);
    }

    public int getDriverId() {
        return getId();
    }

    public void setDriverId(int driverId) {
        setId(driverId);
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

    public Set<DriverAvailability> getAvailability() {
        return availability;
    }

    public void setAvailability(Set<DriverAvailability> availability) {
        this.availability = availability;
    }

    public Set<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(Set<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    @Override
    public String toString() {
        return super.toString() + "Driver{" +
                "age=" + age +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
