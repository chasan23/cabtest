package com.cabtest.managed.bean;


import com.cabtest.model.DriverVehicle;
import com.cabtest.service.DriverVehicleService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import java.util.ArrayList;
import java.util.List;
@ManagedBean(name = "driverVehicleMB")
@RequestScoped
public class DriverVehicleManagedBean {

    private static final long serialVersionUID = 1L;
    private static final String SUCCESS = "success";
    private static final String ERROR = "error";
    private static final Logger LOG = Logger.getLogger(DriverVehicleManagedBean.class);

    @ManagedProperty(value = "#{driverVehicleService}")
    DriverVehicleService driverVehicleService;

    List<DriverVehicle> driverVehicleList;

    String id;
    String driverId;
    String vehicleId;


    public void reset() {
        this.setId("");
        this.setDriverId("");
        this.setVehicleId("");

    }


    public String addDriverVehicle() {
        try {
            DriverVehicle driverVehicle = new DriverVehicle();
//            driverVehicle.setDriverId(Integer.parseInt(this.getDriverId()));
//            driverVehicle.setVehicleId(Integer.parseInt(this.getVehicleId()));


            getDriverVehicleService().save(driverVehicle);
            return SUCCESS;
        } catch (Exception e) {
            LOG.error("Error while trying to add driverVehicle.", e);
        }
        return ERROR;
    }

    public String updateDriverVehicle() {
        try {
            DriverVehicle driverVehicle = new DriverVehicle();
            driverVehicle.setId(Integer.parseInt(this.getId()));
//            driverVehicle.setDriverId(Integer.parseInt(this.getDriverId()));
//            driverVehicle.setVehicleId(Integer.parseInt(this.getVehicleId()));
            getDriverVehicleService().update(driverVehicle);
            return SUCCESS;
        } catch (Exception e) {
            LOG.error("Error while trying to update driverVehicle.", e);
        }
        return ERROR;
    }

    public String deleteDriverVehicle() {
        try {
            getDriverVehicleService().deleteByKey(Integer.parseInt(this.getId()));
            return SUCCESS;
        } catch (Exception e) {
            LOG.error("Error while trying to delete driverVehicle.", e);
        }
        return ERROR;
    }

    public List<DriverVehicle> getDriverVehicleList() {
        driverVehicleList = new ArrayList<DriverVehicle>();
        driverVehicleList.addAll(getDriverVehicleService().getAll());
        return driverVehicleList;
    }

    public DriverVehicleService getDriverVehicleService() {
        return driverVehicleService;
    }

    public void setDriverVehicleService(DriverVehicleService driverVehicleService) {
        this.driverVehicleService = driverVehicleService;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }
}