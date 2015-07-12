package com.cabtest.managed.bean;


import com.cabtest.model.DistanceMatrix;

import com.cabtest.service.DistanceMatrixService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import java.util.ArrayList;
import java.util.List;
import java.sql.Timestamp;
import java.util.Date;
@ManagedBean(name = "distanceMatrixMB")
@RequestScoped
public class DistanceMatrixManagedBean {

    private static final long serialVersionUID = 1L;
    private static final String SUCCESS = "success";
    private static final String ERROR = "error";
    private static final Log LOG = LogFactory.getLog(DistanceMatrixManagedBean.class);

    @ManagedProperty(value = "#{distanceMatrixService}")
    DistanceMatrixService distanceMatrixService;

    List<DistanceMatrix> distanceMatrixList;

    String id;
    String locationA;
    String locationB;
    String time;


    public void reset() {
        this.setLocationA("");
        this.setLocationB("");
        this.setTime("");

    }


    public String addDistanceMatrix() {
        try {
            DistanceMatrix distanceMatrix = new DistanceMatrix();
            distanceMatrix.setLocationA(Integer.parseInt(this.getLocationA()));
            distanceMatrix.setLocationB(Integer.parseInt(this.getLocationB()));
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
            distanceMatrix.setLocationA(Integer.parseInt(this.getLocationA()));
            distanceMatrix.setLocationB(Integer.parseInt(this.getLocationB()));
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
    public List<DistanceMatrix> getDistanceMatrixList() {
        distanceMatrixList = new ArrayList<DistanceMatrix>();
        distanceMatrixList.addAll(getDistanceMatrixService().getAll());
        return distanceMatrixList;
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
