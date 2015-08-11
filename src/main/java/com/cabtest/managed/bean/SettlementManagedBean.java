package com.cabtest.managed.bean;

import com.cabtest.model.Settlement;
import com.cabtest.service.SettlementService;
import org.apache.log4j.Logger;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "settlementMB")
@RequestScoped
public class SettlementManagedBean {

    private static final long serialVersionUID = 1L;
    private static final String SUCCESS = "success";
    private static final String ERROR = "error";
    private static final Logger LOG = Logger.getLogger(SettlementManagedBean.class);

    @ManagedProperty(value = "#{settlementService}")
    SettlementService settlementService;

    List<Settlement> settlementList;

    String id;
    String driverId;
    String vehicleId;
    String fromDate;
    String toDate;
    String driverCharge;
    String serviceCharge;
    String vehicleCharge;

//    public String addSettlement() {
//        try {
//            Settlement settlement = new Settlement();
//            settlement.setId(Integer.parseInt(this.getId()));
//            settlement.setDriverId(Integer.parseInt(this.getDriverId()));
//            settlement.setVehicleId(Integer.parseInt(this.getVehicleId()));
//            settlement.setFromDate();
//            getSettlementService().save(settlement);
//            return SUCCESS;
//        } catch (Exception e) {
//            LOG.error("Error while trying to add settlement.", e);
//        }
//        return ERROR;
//    }

    public String updateSettlement() {
        try {
            Settlement settlement = new Settlement();
            settlement.setId(Integer.parseInt(this.getId()));
//            settlement.setDriverId(Integer.parseInt(this.getDriverId()));
//            settlement.setVehicleId(Integer.parseInt(this.getVehicleId()));
            settlement.setDriverCharge(Float.parseFloat(this.getDriverCharge()));
            settlement.setServiceCharge(Float.parseFloat(this.getServiceCharge()));
            settlement.setVehicleCharge(Float.parseFloat(this.getVehicleCharge()));

            getSettlementService().update(settlement);
            return SUCCESS;
        } catch (Exception e) {
            LOG.error("Error while trying to update settlement.", e);
        }
        return ERROR;
    }

    public String deleteSettlement() {
        try {
            getSettlementService().deleteByKey(Integer.parseInt(this.getId()));
            return SUCCESS;
        } catch (Exception e) {
            LOG.error("Error while trying to delete settlement.", e);
        }
        return ERROR;
    }

    public void reset() {

    }

    public List<Settlement> getSettlementList() {
        settlementList = new ArrayList<Settlement>();
        settlementList.addAll(getSettlementService().getAll());
        return settlementList;
    }

    public SettlementService getSettlementService() {
        return settlementService;
    }

    public void setSettlementService(
            SettlementService settlementService) {
        this.settlementService = settlementService;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public String getDriverCharge() {
        return driverCharge;
    }

    public void setDriverCharge(String driverCharge) {
        this.driverCharge = driverCharge;
    }

    public String getServiceCharge() {
        return serviceCharge;
    }

    public void setServiceCharge(String serviceCharge) {
        this.serviceCharge = serviceCharge;
    }

    public String getVehicleCharge() {
        return vehicleCharge;
    }

    public void setVehicleCharge(String vehicleCharge) {
        this.vehicleCharge = vehicleCharge;
    }
}

