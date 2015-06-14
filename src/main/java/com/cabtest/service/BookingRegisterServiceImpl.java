package com.cabtest.service;

import com.cabtest.dao.ContactDAO;
import com.cabtest.dao.BookingDAO;
import com.cabtest.dao.CustomerDAO;
import com.cabtest.model.Contact;
import com.cabtest.model.Booking;
import com.cabtest.model.Customer;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BookingRegisterServiceImpl implements BookingRegisterService {
    private BookingDAO bookingDAO;

    private CustomerDAO customerDAO;

    private ContactDAO contactDAO;

    public BookingRegisterServiceImpl() {
        super();
    }

    public BookingDAO getBookingDAO() {
        return bookingDAO;
    }

    public void setBookingDAO(BookingDAO bookingDAO) {
        this.bookingDAO = bookingDAO;
    }

    public CustomerDAO getCustomerDAO() {
        return customerDAO;
    }

    public void setCustomerDAO(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    public ContactDAO getContactDAO() {
        return contactDAO;
    }

    public void setContactDAO(ContactDAO contactDAO) {
        this.contactDAO = contactDAO;
    }

    @Override
    @Transactional
    public void saveBooking(Booking booking) {
          Customer customer = booking.getCustomer();
          getCustomerDAO().save(customer);
          Contact contact = customer.getContact();
          getContactDAO().save(contact);
//        booking.setContact(contact);
//        contact.getBookings().add(booking);
          getBookingDAO().save(booking);
    }

    @Override
    @Transactional
    public void updateBooking(Booking booking) {
//        Contact contact = booking.getContact();
//        getContactDAO().update(contact);
//        booking.setContact(contact);
//        contact.getBookings().add(booking);
//        getBookingDAO().update(booking);

    }

    @Override
    @Transactional
    public void deleteBooking(Booking booking) {

    }

    @Override
    @Transactional
    public List<Booking> getBookingList() {
        return bookingDAO.getAll();
    }

    @Override
    @Transactional
    public void deleteBookingByID(Integer id) {
        bookingDAO.deleteByKey(id);
    }

}

