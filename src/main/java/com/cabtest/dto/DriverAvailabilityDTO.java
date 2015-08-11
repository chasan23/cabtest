package com.cabtest.dto;

import java.util.Date;

public class DriverAvailabilityDTO {

    String id;
    String driverId;
    String vehicleId;
    Date date;
    String dateString;
    Date timeFrom;
    String timeFromString;
    Date timeTo;
    String timeToString;
    String locationId;
    String timeSlot;

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getTimeFrom() {
        return timeFrom;
    }

    public void setTimeFrom(Date timeFrom) {
        this.timeFrom = timeFrom;
        setTimeFromString(timeFrom);
    }

    public Date getTimeTo() {
        return timeTo;
    }

    public void setTimeTo(Date timeTo) {
        this.timeTo = timeTo;
        setTimeToString(timeTo);
    }

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(String timeSlot) {
        this.timeSlot = timeSlot;
    }

    public String getDateString() {
        return dateString;
    }

    public void setDateString(Date date) {
        this.dateString = date.toString();
    }

    public void setDateString(String dateString) {
        this.dateString = dateString;
    }

    public String getTimeFromString() {
        return timeFromString;
    }

    public void setTimeFromString(Date timeFrom) {
        this.timeFromString = timeFrom.toString();
    }

    public String getTimeToString() {
        return timeToString;
    }

    public void setTimeToString(Date timeTo) {
        this.timeToString = timeTo.toString();
    }
}
