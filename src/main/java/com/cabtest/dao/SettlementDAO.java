package com.cabtest.dao;

import com.cabtest.model.Settlement;

import java.sql.Date;
import java.util.List;

/**
 * Vehical DAO Interface
 *
 * @author onlinetechvision.com
 * @version 1.0.0
 * @since 25 Mar 2012
 */
public interface SettlementDAO extends GenericDAO<Settlement, Integer> {
    List<Settlement> getUnprocessedSettlements(Date date);
}