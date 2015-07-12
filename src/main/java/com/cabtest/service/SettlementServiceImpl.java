package com.cabtest.service;

import com.cabtest.dao.GenericDAO;
import com.cabtest.dao.SettlementDAO;

import com.cabtest.model.Settlement;
import org.springframework.stereotype.Service;

@Service
public class SettlementServiceImpl extends GenericPersistenceServiceImpl<Settlement, Integer>
        implements SettlementService {

    private SettlementDAO settlementDAO;


    public SettlementServiceImpl() {
        super();
    }


    public SettlementDAO getSettlementDAO() {
        return settlementDAO;
    }

    @SuppressWarnings("unchecked")
    public void setSettlementDAO(SettlementDAO settlementDAO) {
        super.setGenericDAO((GenericDAO) settlementDAO);
        this.settlementDAO = settlementDAO;
    }


}






