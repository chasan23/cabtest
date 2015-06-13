package com.cabtest.service;

import java.util.List;

import com.cabtest.model.Booking;


/**
 * Created by Chamara on 6/13/2015.
 */
public interface BookingRegisterService {

    void saveBooking(Booking booking);

    void updateBooking(Booking booking);

    void deleteBooking(Booking booking);

    List<Booking> getBookingList();

    void deleteBookingByID(Integer id);
}

