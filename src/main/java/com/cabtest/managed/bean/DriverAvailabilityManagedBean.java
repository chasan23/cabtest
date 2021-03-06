package com.cabtest.managed.bean;


import com.cabtest.dto.DriverAvailabilityDTO;
import com.cabtest.model.DriverAvailability;
import com.cabtest.service.DriverAvailabilityService;
import org.apache.log4j.Logger;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import java.util.Date;
import java.util.List;

@ManagedBean(name = "driverAvailabilityMB")
@RequestScoped
public class DriverAvailabilityManagedBean {

    private static final long serialVersionUID = 1L;
    private static final String SUCCESS = "success";
    private static final String ERROR = "error";
    private static final Logger LOG = Logger.getLogger(DriverAvailabilityManagedBean.class);

    @ManagedProperty(value = "#{driverAvailabilityService}")
    DriverAvailabilityService driverAvailabilityService;

    List<DriverAvailability> driverAvailabilityList;

    String id;
    String driverId;
    String vehicleId;
    Date date;
    Date timeFrom;
    Date timeTo;
    String locationId;

    public void reset() {
        this.setDriverId("");
//        this.setDate("");
//        this.setTimeSlot("");
        this.setLocationId("");
    }


    public String addDriverAvailability() {
        try {
            DriverAvailabilityDTO driverAvailabilityDTO = new DriverAvailabilityDTO();
            driverAvailabilityDTO.setDriverId(driverId);
            driverAvailabilityDTO.setVehicleId(vehicleId);
            driverAvailabilityDTO.setDate(date);
            driverAvailabilityDTO.setTimeFrom(timeFrom);
            driverAvailabilityDTO.setTimeTo(timeTo);
            driverAvailabilityDTO.setLocationId(locationId);
            getDriverAvailabilityService().save(driverAvailabilityDTO);
            return SUCCESS;
        } catch (Exception e) {
            LOG.error("Error while trying to add driverAvailability.", e);
        }
        return ERROR;
    }

    public String updateDriverAvailability() {
//        try {
//            DriverAvailability driverAvailability = new DriverAvailability();
//            driverAvailability.setId(Integer.parseInt(this.getId()));
//            driverAvailability.setDriverId(Integer.parseInt(this.getDriverId()));
//            driverAvailability.setDate(new Date(this.getDate()));
//            driverAvailability.setTimeSlot(Integer.parseInt(this.getTimeSlot()));
//            driverAvailability.setLocationId(Integer.parseInt(this.getLocationId()));
//            getDriverAvailabilityService().update(driverAvailability);
//            return SUCCESS;
//        } catch (Exception e) {
//            LOG.error("Error while trying to update driverAvailability.", e);
//        }
        return ERROR;
    }

    public String deleteDriverAvailability() {
        try {
            getDriverAvailabilityService().deleteByKey(Integer.parseInt(this.getId()));
            return SUCCESS;
        } catch (Exception e) {
            LOG.error("Error while trying to delete driverAvailability.", e);
        }
        return ERROR;
    }

    public List<DriverAvailabilityDTO> getDriverAvailabilityList() {
        return getDriverAvailabilityService().getAllDriverAvailabilities();
    }

    public DriverAvailabilityService getDriverAvailabilityService() {
        return driverAvailabilityService;
    }

    public void setDriverAvailabilityService(DriverAvailabilityService driverAvailabilityService) {
        this.driverAvailabilityService = driverAvailabilityService;
    }


    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public Date getTimeTo() {
        return timeTo;
    }

    public void setTimeTo(Date timeTo) {
        this.timeTo = timeTo;
    }

    public Date getTimeFrom() {
        return timeFrom;
    }

    public void setTimeFrom(Date timeFrom) {
        this.timeFrom = timeFrom;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }
}