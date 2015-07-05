package com.cabtest.service;

import com.cabtest.dao.SettlementDAO;

import com.cabtest.model.Settlement;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class SettlementServiceImpl implements SettlementService {
    @Override
    public void saveSettlement(Settlement settlement) {

    }

    @Override
    public void updateSettlement(Settlement settlement) {

    }

    @Override
    public void deleteSettlement(Settlement settlement) {

    }

    @Override
    public List<Settlement> getSettlementList() {
        return null;
    }

    @Override
    public void deleteSettlementByID(Integer id) {

    }
}