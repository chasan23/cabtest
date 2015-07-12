package com.cabtest.managed.bean;

import com.cabtest.model.Settlement;
import com.cabtest.service.SettlementService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

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
    private static final Log LOG = LogFactory.getLog(SettlementManagedBean.class);

    @ManagedProperty(value = "#{settlementService}")
    SettlementService settlementService;

    List<Settlement> settlementList;

    String registrationNumber;
    String type;
    String model;
    String settlementId;

    public String addSettlement() {
        try {
            Settlement settlement = new Settlement();
            settlement.setVehicalType(this.getType());
            settlement.setModel(this.getModel());
            settlement.setRegistrationNumber(this.getRegistrationNumber());
            getSettlementService().save(settlement);
            return SUCCESS;
        } catch (Exception e) {
            LOG.error("Error while trying to add settlement.", e);
        }
        return ERROR;
    }

    public String updateSettlement() {
        try {
            Settlement settlement = new Settlement();
            settlement.setVehicalId(Integer.parseInt(this.getSettlementId()));
            settlement.setVehicalType(this.getType());
            settlement.setModel(this.getModel());
            settlement.setRegistrationNumber(this.getRegistrationNumber());
            getSettlementService().update(settlement);
            return SUCCESS;
        } catch (Exception e) {
            LOG.error("Error while trying to update settlement.", e);
        }
        return ERROR;
    }

    public String deleteSettlement() {
        try {
            getSettlementService().deleteByKey(Integer.parseInt(this.getSettlementId()));
            return SUCCESS;
        } catch (Exception e) {
            LOG.error("Error while trying to delete settlement.", e);
        }
        return ERROR;
    }

    public void reset() {
        this.setModel("");
        this.setRegistrationNumber("");
        this.setType("");
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

    public String getSettlementId() {
        return settlementId;
    }

    public void setSettlementId(String settlementId) {
        this.settlementId = settlementId;
    }


}

