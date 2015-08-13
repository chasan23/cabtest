package com.cabtest.service;

import com.cabtest.model.Billing;

import java.util.List;

public interface BillingRegisterService extends GenericPersistenceService<Billing, Integer> {
    List<Billing> getUnprocessedBillingEntries();
}
