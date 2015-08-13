package com.cabtest.dao;

import com.cabtest.model.Billing;

import java.util.List;

public interface BillingDAO extends GenericDAO<Billing, Integer> {
    List<Billing> getUnprocessedBillingEntries();
}
