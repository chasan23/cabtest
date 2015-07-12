package com.cabtest.service;

import com.cabtest.dao.BookingDAO;
import com.cabtest.dao.ContactDAO;
import com.cabtest.dao.CustomerDAO;
import com.cabtest.model.Contact;
import com.cabtest.model.Booking;
import com.cabtest.model.Contact;
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
        Contact contact = customer.getContact();

        getContactDAO().save(contact);

        customer.setContact(contact);
        contact.getPersons().add(customer);

        getCustomerDAO().save(customer);

        booking.setCustomer(customer);
        customer.getBookings().add(booking);

        getBookingDAO().save(booking);

    }

    @Override
    @Transactional
    public void updateBooking(Booking updatedBooking) {
        Booking existingBooking = getBookingDAO().findByKey(updatedBooking.getBookingId());
        existingBooking.setVehicleType(updatedBooking.getVehicleType());
        existingBooking.setTime(updatedBooking.getTime());
        existingBooking.setOriginId(updatedBooking.getOriginId());
        existingBooking.setOriginAddress(updatedBooking.getOriginAddress());
        existingBooking.setDestinationId(updatedBooking.getDestinationId());
        existingBooking.setDuration(updatedBooking.getDuration());

        Customer existingCustomer = existingBooking.getCustomer();
        Customer updateCustomer = updatedBooking.getCustomer();
        existingCustomer.setFirstName(updateCustomer.getFirstName());
        existingCustomer.setLastName(updateCustomer.getLastName());

        Contact existingContact = existingCustomer.getContact();
        Contact updatedContact = updateCustomer.getContact();
        existingContact.setEmail(updatedContact.getEmail());
        existingContact.setAddress(updatedContact.getAddress());
        existingContact.setMobilePhone(updatedContact.getMobilePhone());
        existingContact.setHomePhone(updatedContact.getHomePhone());

        getContactDAO().update(existingContact);
        existingCustomer.setContact(existingContact);
        existingContact.getPersons().add(existingCustomer);
        getCustomerDAO().update(existingCustomer);
        existingBooking.setCustomer(existingCustomer);
        existingCustomer.getBookings().add(existingBooking);
        getBookingDAO().update(existingBooking);
    }

    @Override
    @Transactional
    public void deleteBooking(Booking booking) {
        booking.setCustomer(null);
        bookingDAO.delete(booking);
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

