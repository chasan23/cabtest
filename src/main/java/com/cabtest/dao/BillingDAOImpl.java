package com.cabtest.dao;

import com.cabtest.model.Billing;
import org.hibernate.Query;

import java.util.List;

public class BillingDAOImpl extends GenericDAOImpl<Billing, Integer> implements BillingDAO {

    @Override
    public List<Billing> getUnprocessedBillingEntries() {
        Query query = getCurrentSession().createQuery("from Billing where isProcessed = '0'");
        return (List<Billing>) query.list();
    }
}
