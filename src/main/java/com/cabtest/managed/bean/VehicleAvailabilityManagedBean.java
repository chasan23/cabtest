package com.cabtest.managed.bean;


import com.cabtest.model.VehicleAvailability;
import com.cabtest.service.VehicleAvailabilityService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@ManagedBean(name = "vehicleAvailabilityMB")
@RequestScoped
public class VehicleAvailabilityManagedBean {

    private static final long serialVersionUID = 1L;
    private static final String SUCCESS = "success";
    private static final String ERROR = "error";
    private static final Log LOG = LogFactory.getLog(VehicleAvailabilityManagedBean.class);

    @ManagedProperty(value = "#{vehicleAvailabilityService}")
    VehicleAvailabilityService vehicleAvailabilityService;

    List<VehicleAvailability> vehicleAvailabilityList;

    String id;
    String vehicleId;
    String date;
    String timeSlot;
    String locationId;

    public void reset() {
        this.setVehicleId("");
        this.setDate("");
        this.setTimeSlot("");
        this.setLocationId("");
    }


    public String addVehicleAvailability() {
        try {
            VehicleAvailability vehicleAvailability = new VehicleAvailability();
            vehicleAvailability.setVehicleId(Integer.parseInt(this.getVehicleId()));
            vehicleAvailability.setDate(new Date(this.getDate()));
            vehicleAvailability.setTimeSlot(Integer.parseInt(this.getTimeSlot()));
            vehicleAvailability.setLocationId(Integer.parseInt(this.getLocationId()));
            getVehicleAvailabilityService().save(vehicleAvailability);
            return SUCCESS;
        } catch (Exception e) {
            LOG.error("Error while trying to add vehicleAvailability.", e);
        }
        return ERROR;
    }

    public String updateVehicleAvailability() {
        try {
            VehicleAvailability vehicleAvailability = new VehicleAvailability();
            vehicleAvailability.setId(Integer.parseInt(this.getId()));
            vehicleAvailability.setVehicleId(Integer.parseInt(this.getVehicleId()));
            vehicleAvailability.setDate(new Date(this.getDate()));
            vehicleAvailability.setTimeSlot(Integer.parseInt(this.getTimeSlot()));
            vehicleAvailability.setLocationId(Integer.parseInt(this.getLocationId()));
            getVehicleAvailabilityService().update(vehicleAvailability);
            return SUCCESS;
        } catch (Exception e) {
            LOG.error("Error while trying to update vehicleAvailability.", e);
        }
        return ERROR;
    }

    public String deleteVehicleAvailability() {
        try {
            getVehicleAvailabilityService().deleteByKey(Integer.parseInt(this.getId()));
            return SUCCESS;
        } catch (Exception e) {
            LOG.error("Error while trying to delete vehicleAvailability.", e);
        }
        return ERROR;
    }
    public List<VehicleAvailability> getVehicleAvailabilityList() {
        vehicleAvailabilityList = new ArrayList<VehicleAvailability>();
        vehicleAvailabilityList.addAll(getVehicleAvailabilityService().getAll());
        return vehicleAvailabilityList;
    }

    public VehicleAvailabilityService getVehicleAvailabilityService() {
        return vehicleAvailabilityService;
    }

    public void setVehicleAvailabilityService(VehicleAvailabilityService vehicleAvailabilityService) {
        this.vehicleAvailabilityService = vehicleAvailabilityService;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(String timeSlot) {
        this.timeSlot = timeSlot;
    }

}
