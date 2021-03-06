package com.cabtest.service;

import com.cabtest.agent.AssignmentAgent;
import com.cabtest.bean.SMSMessage;
import com.cabtest.dao.BookingDAO;
import com.cabtest.dao.ContactDAO;
import com.cabtest.dao.CustomerDAO;
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
    private AssignmentAgent assignmentAgent;
    private SendSMSService sendSMSService;

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

        SMSMessage smsMessage = new SMSMessage(contact.getMobilePhone(), "Booking successfully added.");
        sendSMSService.send(smsMessage);
        assignmentAgent.addToBookingQueue(booking);
    }

    @Override
    @Transactional
    public void updateBooking(Booking updatedBooking) {
        Booking existingBooking = getBookingDAO().findByKey(updatedBooking.getBookingId());
        existingBooking.setVehicleType(updatedBooking.getVehicleType());
        existingBooking.setTime(updatedBooking.getTime());
        existingBooking.setOrigin(updatedBooking.getOrigin());
        existingBooking.setOriginAddress(updatedBooking.getOriginAddress());
        existingBooking.setDestination(updatedBooking.getDestination());
        existingBooking.setDuration(updatedBooking.getDuration());
        existingBooking.setIsAssigned(updatedBooking.isAssigned());

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

        SMSMessage smsMessage = new SMSMessage(updatedContact.getMobilePhone(), "Booking successfully updated.");
        sendSMSService.send(smsMessage);
    }

    @Override
    @Transactional
    public void updateIsAssigned(Booking updatedBooking) {
        Booking existingBooking = getBookingDAO().findByKey(updatedBooking.getBookingId());
        existingBooking.setIsAssigned(updatedBooking.isAssigned());
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

    @Transactional
    public List<Booking> getUnassignedBookingList() {
        return bookingDAO.getUnassignedBookingList();
    }

    @Override
    @Transactional
    public void deleteBookingByID(Integer id) {
        bookingDAO.deleteByKey(id);
    }

    public void setAssignmentAgent(AssignmentAgent assignmentAgent) {
        this.assignmentAgent = assignmentAgent;
    }

    public void setSendSMSService(SendSMSService sendSMSService) {
        this.sendSMSService = sendSMSService;
    }
}

