package com.cabtest.managed.bean;

import com.cabtest.model.*;
import com.cabtest.service.BookingRegisterService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "bookingMB")
@RequestScoped
public class BookingManagedBean {

    private static final long serialVersionUID = 1L;
    private static final String SUCCESS = "success";
    private static final String ERROR = "error";
    private static final Log LOG = LogFactory.getLog(BookingManagedBean.class);

    @ManagedProperty(value = "#{bookingService}")
    BookingRegisterService bookingRegisterService;

    String type;
    String time;
    String bookingId;
    String location;
    String firstName;
    String lastName;
    String homePhone;
    String mobilePhone;
    String email;
    String address;


    public String addBooking() {
        try {

            Customer customer = getCustomer();

            Contact contact = getContact();

            Booking booking = getBooking();

            booking.setBookingId(Integer.parseInt(this.getBookingId()));

            customer.setContact(contact);
            booking.setCustomer(customer);

            getBookingRegisterService().saveBooking(booking);
            return SUCCESS;
        } catch (Exception e) {
            LOG.error("Error while trying to add booking.", e);
        }
        return ERROR;
    }

    private Contact getContact() {
        Contact contact = new Contact();
        contact.setHomePhone(this.getHomePhone());
        contact.setMobilePhone(this.getMobilePhone());
        contact.setEmail(this.getEmail());
        contact.setAddress(this.getAddress());
        return contact;
    }

    private Customer getCustomer() {
        Customer customer = new Customer();
        customer.setFirstName(this.getFirstName());
        customer.setLastName(this.getLastName());
        return customer;
    }

    private Booking getBooking() {
        Booking booking = new Booking();
        booking.setVehicleType(this.getType());
        booking.setTime(Timestamp.valueOf(this.getTime()));
        booking.setLocation(this.getLocation());
        return booking;
    }

    public String deleteBooking() {
        try {
//			 getBookingRegisterService().deleteBookingByID(Integer.parseInt(this.getBookingId()));
            return SUCCESS;
        } catch (Exception e) {
            LOG.error("Error while trying to delete booking.", e);
        }
        return ERROR;
    }

    public String updateBooking() {
        try {

            Customer customer = getCustomer();

            Contact contact = getContact();

            Booking booking = getBooking();

            customer.setContact(contact);
            booking.setCustomer(customer);

            getBookingRegisterService().updateBooking(booking);
            return SUCCESS;
        } catch (Exception e) {
            LOG.error("Error while trying to update booking.", e);
        }
        return ERROR;
    }

    public void reset() {
        this.setType("");
        this.setFirstName("");
        this.setLastName("");
        this.setTime("");
        this.setBookingId("");
        this.setHomePhone("");
        this.setMobilePhone("");
        this.setEmail("");
        this.setAddress("");
        this.setLocation("");
    }

    public BookingRegisterService getBookingRegisterService() {
        return bookingRegisterService;
    }

    public void setBookingRegisterService(BookingRegisterService bookingRegisterService) {
        this.bookingRegisterService = bookingRegisterService;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<BookingDetails> getBookingList() {
        List<Booking> bookings = getBookingRegisterService().getBookingList();
        List<BookingDetails> bookingDetailsList = new ArrayList<>();
        for (Booking booking : bookings) {
            BookingDetails bookingDetails = new BookingDetails(booking);
            bookingDetailsList.add(bookingDetails);
        }

        for (BookingDetails bookingDetails : bookingDetailsList) {
            System.out.println(bookingDetails.toString());
        }
        return bookingDetailsList;
    }

}
