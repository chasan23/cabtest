package com.cabtest.service;

import com.cabtest.model.Settlement;

import java.util.List;


public interface SettlementService {

    void saveSettlement(Settlement settlement);

    void updateSettlement(Settlement settlement);

    void deleteSettlement(Settlement settlement);

    List<Settlement> getSettlementList();

    void deleteSettlementByID(Integer id);
}