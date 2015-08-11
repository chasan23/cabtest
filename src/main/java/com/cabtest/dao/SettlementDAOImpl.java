package com.cabtest.dao;

import com.cabtest.model.Settlement;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Vehical DAO
 *
 * @author onlinetechvision.com
 * @version 1.0.0
 * @since 25 Mar 2012
 */

@Repository
public class SettlementDAOImpl extends GenericDAOImpl<Settlement, Integer> implements SettlementDAO {

    @Override
    public List<Settlement> getUnprocessedSettlements(Date date) {
        Query query = getCurrentSession().createQuery("from SETTLEMENT_ENTRY where DATE <= :date and is_processed = " +
                "false");
        query.setParameter("date", date);
        return (ArrayList<Settlement>) query.list();
    }
}
