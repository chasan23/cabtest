package com.cabtest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "SETTLEMENT", catalog = "cab")
public class Settlement implements Serializable {

    private static final long serialVersionUID = 7895139095426977088L;

    @Id
    @Column(name = "ID", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "VEHICLE_ID")
    private int vehicleId;

    @Column(name = "DRIVER_ID")
    private int driverId;

    @Column(name = "FROM_DATE")
    private Timestamp fromDate;

    @Column(name = "TO_DATE")
    private Timestamp toDate;

    @Column(name = "DRIVER_CHARGE")
    private float driverCharge;

    @Column(name = "SERVICE_CHARGE")
    private float serviceCharge;

    @Column(name = "VEHICLE_CHARGE")
    private float vehicleCharge;

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    public Timestamp getFromDate() {
        return fromDate;
    }

    public void setFromDate(Timestamp fromDate) {
        this.fromDate = fromDate;
    }

    public Timestamp getToDate() {
        return toDate;
    }

    public void setToDate(Timestamp toDate) {
        this.toDate = toDate;
    }

    public float getDriverCharge() {
        return driverCharge;
    }

    public void setDriverCharge(float driverCharge) {
        this.driverCharge = driverCharge;
    }

    public float getServiceCharge() {
        return serviceCharge;
    }

    public void setServiceCharge(float serviceCharge) {
        this.serviceCharge = serviceCharge;
    }

    public float getVehicleCharge() {
        return vehicleCharge;
    }

    public void setVehicleCharge(float vehicleCharge) {
        this.vehicleCharge = vehicleCharge;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
