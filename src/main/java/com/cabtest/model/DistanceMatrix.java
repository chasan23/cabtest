package com.cabtest.model;

    import javax.persistence.Column;
    import javax.persistence.Entity;
    import javax.persistence.GeneratedValue;
    import javax.persistence.GenerationType;
    import javax.persistence.Id;
    import javax.persistence.Table;
    import java.util.Date;


    @Entity
    @Table(name = "DISTANCE_MATRIX")
    public class DistanceMatrix {


        @Column(name = "LOCATION_A")
        int locationA;

        @Column(name = "LOCATION_B")
        int locationB;

        @Column(name = "TIME")
        int time;


    public DistanceMatrix() {
    }

    public int getLocationA() {
        return locationA;
    }

    public void setLocationA(int locationA) {
        this.locationA = locationA;
    }

    public int getLocationB() {
        return locationB;
    }

    public void setLocationB(int locationB) {
        this.locationB = locationB;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}