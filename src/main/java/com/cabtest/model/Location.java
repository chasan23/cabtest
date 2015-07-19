package com.cabtest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "LOCATION")
public class Location {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id ;

    @Column(name = "LOCATION")
    String location ;

    @Column(name = "DISTRICT")
    String district ;

    @Column(name = "PROVINCE")
    String province;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "location")
    Set<DriverAvailability> availability = new HashSet<>(0);

    public Location() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public Set<DriverAvailability> getAvailability() {
        return availability;
    }

    public void setAvailability(Set<DriverAvailability> availability) {
        this.availability = availability;
    }
}
