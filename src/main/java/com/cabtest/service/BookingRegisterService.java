package com.cabtest.service;

import com.cabtest.model.Booking;

import java.util.List;


public interface BookingRegisterService {

    void saveBooking(Booking booking);

    void updateBooking(Booking booking);

    void deleteBooking(Booking booking);

    List<Booking> getBookingList();

    void deleteBookingByID(Integer id);
}

