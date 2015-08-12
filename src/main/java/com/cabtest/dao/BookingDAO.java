package com.cabtest.dao;

import com.cabtest.model.Booking;

import java.util.List;

public interface BookingDAO extends GenericDAO<Booking, Integer> {
    List<Booking> getUnassignedBookingList();
}
