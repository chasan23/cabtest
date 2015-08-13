package com.cabtest.service;

import com.cabtest.agent.SettlementAgent;
import com.cabtest.dao.BillingDAO;
import com.cabtest.dao.GenericDAO;
import com.cabtest.model.Billing;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class BillingRegisterServiceImpl extends GenericPersistenceServiceImpl<Billing, Integer>
        implements BillingRegisterService {

    private BillingDAO billingDAO;
    private SettlementAgent settlementAgent;


    public BillingRegisterServiceImpl() {
        super();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void save(Billing billing) {
        super.save(billing);
        settlementAgent.addToBillingQueue(billing);
    }

    public BillingDAO getBillingDAO() {
        return billingDAO;
    }

    @SuppressWarnings("unchecked")
    public void setBillingDAO(BillingDAO billingDAO) {
        super.setGenericDAO((GenericDAO) billingDAO);
        this.billingDAO = billingDAO;
    }

    @Override
    public List<Billing> getUnprocessedBillingEntries() {
        return billingDAO.getUnprocessedBillingEntries();
    }
}
