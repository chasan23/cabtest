package com.cabtest.dto;

import com.cabtest.model.DistanceMatrix;
import com.cabtest.model.Location;

public class DistanceMatrixDTO {

    int id;
    String locationNameA;
    String locationNameB;
    Location locationA;
    Location locationB;
    int time;


    public DistanceMatrixDTO() {
    }

    public DistanceMatrixDTO(DistanceMatrix distanceMatrix) {
        this.id = distanceMatrix.getId();
        this.time = distanceMatrix.getTime();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocationNameA() {
        return locationNameA;
    }

    public void setLocationNameA(String locationNameA) {
        this.locationNameA = locationNameA;
    }

    public void setLocationNameA(Location locationNameA) {
        this.locationNameA = locationNameA.getLocation();
    }

    public String getLocationNameB() {
        return locationNameB;
    }

    public void setLocationNameB(String locationNameB) {
        this.locationNameB = locationNameB;
    }

    public void setLocationNameB(Location locationNameB) {
        this.locationNameB = locationNameB.getLocation();
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public Location getLocationB() {
        return locationB;
    }

    public void setLocationB(Location locationB) {
        this.locationB = locationB;
        this.locationNameB = locationB.getLocation();
    }

    public Location getLocationA() {
        return locationA;
    }

    public void setLocationA(Location locationA) {
        this.locationA = locationA;
        this.locationNameA = locationA.getLocation();
    }
}