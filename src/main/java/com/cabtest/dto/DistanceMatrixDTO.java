package com.cabtest.dto;

import com.cabtest.model.DistanceMatrix;

public class DistanceMatrixDTO {

    int id;
    String locationA;
    String locationB;
    int time;


    public DistanceMatrixDTO() {
    }

    public DistanceMatrixDTO(DistanceMatrix distanceMatrix) {
        String locationAB = distanceMatrix.getLocationAB();
        String locationA = locationAB.split(":")[0];
        String locationB = locationAB.split(":")[1];
        DistanceMatrixDTO distanceMatrixDTO = new DistanceMatrixDTO();
        this.id = distanceMatrix.getId();
        this.locationA = locationA;
        this.locationB = locationB;
        this.time = distanceMatrix.getTime();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocationA() {
        return locationA;
    }

    public void setLocationA(String locationA) {
        this.locationA = locationA;
    }

    public String getLocationB() {
        return locationB;
    }

    public void setLocationB(String locationB) {
        this.locationB = locationB;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}