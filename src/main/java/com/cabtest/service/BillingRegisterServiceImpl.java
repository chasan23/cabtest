package com.cabtest.service;

import com.cabtest.dao.GenericDAO;
import com.cabtest.dao.BillingDAO;
import com.cabtest.model.Billing;
import org.springframework.stereotype.Service;

@Service
public class BillingRegisterServiceImpl extends GenericPersistenceServiceImpl<Billing, Integer>
        implements BillingRegisterService {

    private BillingDAO billingDAO;


    public BillingRegisterServiceImpl() {
        super();
    }


    public BillingDAO getBillingDAO() {
        return billingDAO;
    }

    @SuppressWarnings("unchecked")
    public void setBillingDAO(BillingDAO billingDAO) {
        super.setGenericDAO((GenericDAO) billingDAO);
        this.billingDAO = billingDAO;
    }

}
