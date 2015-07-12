package com.cabtest.managed.bean;


import com.cabtest.service.LocationService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "locationMB")
@RequestScoped
public class LocationManagedBean {

    private static final long serialVersionUID = 1L;
    private static final String SUCCESS = "success";
    private static final String ERROR = "error";
    private static final Log LOG = LogFactory.getLog(LocationManagedBean.class);

    @ManagedProperty(value = "#{locationService}")
    LocationService locationService;

    List<Location> locationList;

    String id;
    String location;
    String district;
    String province;

    public void reset() {
        this.setId("");
        this.setLocation("");
        this.setDistrict("");
        this.setProvince("");
    }


    public String addLocation() {
        try {
            Location location = new Location();
            location.setId(Integer.parseInt(this.getId()));
            location.setLocation(this.getLocation());
            location.setDistrict(this.getDistrict());
            location.setProvince(this.getProvince());

            getLocationService().save(location);

            return SUCCESS;
        } catch (Exception e) {
            LOG.error("Error while trying to add location.", e);
        }
        return ERROR;
    }

    public String updateLocation() {
        try {
            Location location = new Location();
            location.setId(Integer.parseInt(this.getId()));
            location.setLocation(this.getLocation());
            location.setDistrict(this.getDistrict());
            location.setProvince(this.getProvince());
            getLocationService().update(location);
            return SUCCESS;
        } catch (Exception e) {
            LOG.error("Error while trying to update location.", e);
        }
        return ERROR;
    }

    public String deleteLocation() {
        try {
            getLocationService().deleteByKey(Integer.parseInt(this.getId()));
            return SUCCESS;
        } catch (Exception e) {
            LOG.error("Error while trying to delete location.", e);
        }
        return ERROR;
    }
    public List<Location> getLocationList() {
        locationList = new ArrayList<Location>();
        locationList.addAll(getLocationService().getAll());
        return locationList;
    }

    public LocationService getLocationService() {
        return locationService;
    }

    public void setLocationService(LocationService locationService) {
        this.locationService = locationService;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
}


