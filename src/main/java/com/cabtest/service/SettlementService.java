package com.cabtest.service;

import com.cabtest.model.Settlement;

import java.util.Date;
import java.util.List;

/**
 * Vehical Service Interface
 *
 * @author onlinetechvision.com
 * @version 1.0.0
 * @since 25 Mar 2012
 */
public interface SettlementService extends GenericPersistenceService<Settlement, Integer> {

    List<Settlement> getEntriesToSettle(Date settlementDate);
}