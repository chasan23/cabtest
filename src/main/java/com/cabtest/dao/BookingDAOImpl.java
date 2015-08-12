package com.cabtest.dao;

import com.cabtest.model.Booking;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookingDAOImpl extends GenericDAOImpl<Booking, Integer> implements BookingDAO {
    public List<Booking> getUnassignedBookingList() {
        Query query = getCurrentSession().createQuery("from Booking where isAssigned = '0'");
        return (List<Booking>) query.list();
    }
}
