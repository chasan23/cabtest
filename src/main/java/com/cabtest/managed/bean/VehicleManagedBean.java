package com.cabtest.managed.bean;

import com.cabtest.model.Vehicle;
import com.cabtest.service.VehicleRegisterService;
import org.apache.log4j.Logger;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "vehicleMB")
@RequestScoped
public class VehicleManagedBean {

    private static final long serialVersionUID = 1L;
    private static final String SUCCESS = "success";
    private static final String ERROR = "error";
    private static final Logger LOG = Logger.getLogger(VehicleManagedBean.class);

    @ManagedProperty(value = "#{vehicleService}")
    VehicleRegisterService vehicleRegisterService;

    List<Vehicle> vehicleList;

    String registrationNumber;
    String type;
    String model;
    String vehicleId;

    public String addVehicle() {
        try {
            Vehicle vehicle = new Vehicle();
            vehicle.setVehicleType(this.getType());
            vehicle.setModel(this.getModel());
            vehicle.setRegistrationNumber(this.getRegistrationNumber());
            getVehicleRegisterService().save(vehicle);
            return SUCCESS;
        } catch (Exception e) {
            LOG.error("Error while trying to add vehicle.", e);
        }
        return ERROR;
    }

    public String updateVehicle() {
        try {
            Vehicle vehicle = new Vehicle();
            vehicle.setVehicleId(Integer.parseInt(this.getVehicleId()));
            vehicle.setVehicleType(this.getType());
            vehicle.setModel(this.getModel());
            vehicle.setRegistrationNumber(this.getRegistrationNumber());
            getVehicleRegisterService().update(vehicle);
            return SUCCESS;
        } catch (Exception e) {
            LOG.error("Error while trying to update vehicle.", e);
        }
        return ERROR;
    }

    public String deleteVehicle() {
        try {
            getVehicleRegisterService().deleteByKey(Integer.parseInt(this.getVehicleId()));
            return SUCCESS;
        } catch (Exception e) {
            LOG.error("Error while trying to delete vehicle.", e);
        }
        return ERROR;
    }

    public void reset() {
        this.setModel("");
        this.setRegistrationNumber("");
        this.setType("");
    }

    public List<Vehicle> getVehicleList() {
        vehicleList = new ArrayList<Vehicle>();
        vehicleList.addAll(getVehicleRegisterService().getAll());
        return vehicleList;
    }

    public VehicleRegisterService getVehicleRegisterService() {
        return vehicleRegisterService;
    }

    public void setVehicleRegisterService(
            VehicleRegisterService vehicleRegisterService) {
        this.vehicleRegisterService = vehicleRegisterService;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }


}
