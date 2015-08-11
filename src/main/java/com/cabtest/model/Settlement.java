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
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "SETTLEMENT_ENTRY", catalog = "cab")
public class Settlement implements Serializable {

    private static final long serialVersionUID = 7895139095426977088L;
    @Column(name = "IS_PROCESSED")
    public boolean isProcessed;
    @Id
    @Column(name = "ID", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "VEHICLE_ID", nullable = false)
    private Vehicle vehicle;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "DRIVER_ID", nullable = false)
    private Driver driver;
    @Column(name = "DATE")
    private Timestamp date;
    @Column(name = "DRIVER_CHARGE")
    private double driverCharge;
    @Column(name = "SERVICE_CHARGE")
    private double serviceCharge;
    @Column(name = "VEHICLE_CHARGE")
    private double vehicleCharge;

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

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public double getDriverCharge() {
        return driverCharge;
    }

    public void setDriverCharge(double driverCharge) {
        this.driverCharge = driverCharge;
    }

    public double getServiceCharge() {
        return serviceCharge;
    }

    public void setServiceCharge(double serviceCharge) {
        this.serviceCharge = serviceCharge;
    }

    public double getVehicleCharge() {
        return vehicleCharge;
    }

    public void setVehicleCharge(double vehicleCharge) {
        this.vehicleCharge = vehicleCharge;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isProcessed() {
        return isProcessed;
    }

    public void setIsProcessed(boolean isProcessed) {
        this.isProcessed = isProcessed;
    }

    @Override
    public String toString() {
        return "Settlement{" +
                "id=" + id +
                ", vehicle=" + vehicle +
                ", driver=" + driver +
                ", date=" + date +
                ", driverCharge=" + driverCharge +
                ", serviceCharge=" + serviceCharge +
                ", vehicleCharge=" + vehicleCharge +
                ", isProcessed=" + isProcessed +
                '}';
    }
}
