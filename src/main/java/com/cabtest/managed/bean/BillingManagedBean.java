package com.cabtest.managed.bean;


import com.cabtest.model.Billing;
import com.cabtest.service.BillingRegisterService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "billingMB")
@RequestScoped
public class BillingManagedBean {

    private static final long serialVersionUID = 1L;
    private static final String SUCCESS = "success";
    private static final String ERROR = "error";
    private static final Log LOG = LogFactory.getLog(BillingManagedBean.class);

    @ManagedProperty(value = "#{billingService}")
    BillingRegisterService billingRegisterService;

    List<Billing> billingList;

    String billingId;
    String assignmentId;
    String amount;

    public String addBilling() {
        try {
            Billing billing = new Billing();
            billing.setAssignmentId(Integer.parseInt(this.getAssignmentId()));
            billing.setAmount(Integer.parseInt(this.getAmount()));

            getBillingRegisterService().save(billing);
            return SUCCESS;
        } catch (Exception e) {
            LOG.error("Error while trying to add billing.", e);
        }
        return ERROR;
    }

    public String updateBilling() {
        try {
            Billing billing = new Billing();
            billing.setBillingId(Integer.parseInt(this.getBillingId()));
            billing.setAssignmentId(Integer.parseInt(this.getAssignmentId()));
            billing.setAmount(Integer.parseInt(this.getAmount()));
            getBillingRegisterService().update(billing);
            return SUCCESS;
        } catch (Exception e) {
            LOG.error("Error while trying to update billing.", e);
        }
        return ERROR;
    }

    public String deleteBilling() {
        try {
            getBillingRegisterService().deleteByKey(Integer.parseInt(this.getBillingId()));
            return SUCCESS;
        } catch (Exception e) {
            LOG.error("Error while trying to delete billing.", e);
        }
        return ERROR;
    }

    public void reset() {
        this.setBillingId("");
        this.setAssignmentId("");
        this.setAmount("");
    }

    public List<Billing> getBillingList() {
        billingList = new ArrayList<Billing>();
        billingList.addAll(getBillingRegisterService().getAll());
        return billingList;
    }


    public BillingRegisterService getBillingRegisterService() {
        return billingRegisterService;
    }

    public void setBillingRegisterService(BillingRegisterService billingRegisterService) {
        this.billingRegisterService = billingRegisterService;
    }


    public void setBillingList(List<Billing> billingList) {
        this.billingList = billingList;
    }

    public String getBillingId() {
        return billingId;
    }

    public void setBillingId(String billingId) {
        this.billingId = billingId;
    }

    public String getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(String assignmentId) {
        this.assignmentId = assignmentId;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
