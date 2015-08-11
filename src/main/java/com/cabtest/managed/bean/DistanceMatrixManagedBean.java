package com.cabtest.managed.bean;


import com.cabtest.dto.DistanceMatrixDTO;
import com.cabtest.model.DistanceMatrix;
import com.cabtest.service.DistanceMatrixService;
import com.cabtest.service.LocationService;
import org.apache.log4j.Logger;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import java.util.List;

@ManagedBean(name = "distanceMatrixMB")
@RequestScoped
public class DistanceMatrixManagedBean {

    private static final long serialVersionUID = 1L;
    private static final String SUCCESS = "success";
    private static final String ERROR = "error";
    private static final Logger LOG = Logger.getLogger(DistanceMatrixManagedBean.class);

    @ManagedProperty(value = "#{distanceMatrixService}")
    DistanceMatrixService distanceMatrixService;

    @ManagedProperty(value = "#{locationService}")
    LocationService locationService;

    List<DistanceMatrix> distanceMatrixList;

    String id;
    String locationIdA;
    String locationIdB;
    String locationNameA;
    String locationNameB;
    String time;


    public void reset() {
        this.setLocationIdA("");
        this.setLocationIdB("");
        this.setTime("");

    }


    public String addDistanceMatrix() {
        try {
            DistanceMatrix distanceMatrix = new DistanceMatrix();
            distanceMatrix.setLocationAB(this.getLocationIdA() + ":" + this.getLocationIdB());
            distanceMatrix.setTime(Integer.parseInt(this.getTime()));
            getDistanceMatrixService().save(distanceMatrix);
            return SUCCESS;
        } catch (Exception e) {
            LOG.error("Error while trying to add distanceMatrix.", e);
        }
        return ERROR;
    }

    public String updateDistanceMatrix() {
        try {
            DistanceMatrix distanceMatrix = new DistanceMatrix();
            distanceMatrix.setId(Integer.parseInt(this.getId()));
            distanceMatrix.setLocationAB(this.getLocationIdA() + ":" + this.getLocationIdB());
            distanceMatrix.setTime(Integer.parseInt(this.getTime()));
            getDistanceMatrixService().update(distanceMatrix);
            return SUCCESS;
        } catch (Exception e) {
            LOG.error("Error while trying to update distanceMatrix.", e);
        }
        return ERROR;
    }

    public String deleteDistanceMatrix() {
        try {
            getDistanceMatrixService().deleteByKey(Integer.parseInt(this.getId()));
            return SUCCESS;
        } catch (Exception e) {
            LOG.error("Error while trying to delete distanceMatrix.", e);
        }
        return ERROR;
    }

    public List<DistanceMatrixDTO> getDistanceMatrixList() {
        return getDistanceMatrixService().getDistanceMatrix();
    }

    public DistanceMatrixService getDistanceMatrixService() {
        return distanceMatrixService;
    }

    public void setDistanceMatrixService(DistanceMatrixService distanceMatrixService) {
        this.distanceMatrixService = distanceMatrixService;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLocationIdA() {
        return locationIdA;
    }

    public void setLocationIdA(String locationIdA) {
        this.locationIdA = locationIdA;
    }

    public String getLocationIdB() {
        return locationIdB;
    }

    public void setLocationIdB(String locationIdB) {
        this.locationIdB = locationIdB;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public LocationService getLocationService() {
        return locationService;
    }

    public void setLocationService(LocationService locationService) {
        this.locationService = locationService;
    }

    public String getLocationNameA() {
        return locationNameA;
    }

    public void setLocationNameA(String locationNameA) {
        this.locationNameA = locationNameA;
    }

    public String getLocationNameB() {
        return locationNameB;
    }

    public void setLocationNameB(String locationNameB) {
        this.locationNameB = locationNameB;
    }
}

