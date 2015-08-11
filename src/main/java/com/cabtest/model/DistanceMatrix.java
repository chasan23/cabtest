package com.cabtest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "DISTANCE_MATRIX")
public class DistanceMatrix {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "LOCATION_A_B")
    String locationAB;

    @Column(name = "TIME")
    int time;

    public DistanceMatrix() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocationAB() {
        return locationAB;
    }

    public void setLocationAB(String locationAB) {
        this.locationAB = locationAB;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}