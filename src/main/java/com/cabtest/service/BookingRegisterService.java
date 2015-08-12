package com.cabtest.service;

import com.cabtest.model.Booking;

import javax.transaction.Transactional;
import java.util.List;


public interface BookingRegisterService {

    void saveBooking(Booking booking);

    void updateBooking(Booking booking);

    void updateIsAssigned(Booking updatedBooking);

    void deleteBooking(Booking booking);

    List<Booking> getBookingList();

    void deleteBookingByID(Integer id);

    List<Booking> getUnassignedBookingList();
}

