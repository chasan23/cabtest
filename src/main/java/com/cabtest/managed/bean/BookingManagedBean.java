package com.cabtest.managed.bean;

import com.cabtest.model.Booking;
import com.cabtest.dto.BookingDTO;
import com.cabtest.model.Contact;
import com.cabtest.model.Customer;
import com.cabtest.service.BookingRegisterService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ManagedBean(name = "bookingMB")
@RequestScoped
public class BookingManagedBean {

    private static final long serialVersionUID = 1L;
    private static final String SUCCESS = "success";
    private static final String ERROR = "error";
    private static final Logger LOG = Logger.getLogger(BookingManagedBean.class);

    @ManagedProperty(value = "#{bookingService}")
    BookingRegisterService bookingRegisterService;

    String bookingId;
    String type;
    Date time;
    String originId;
    String originAddress;
    String destinationId;
    String duration;
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

            customer.setContact(contact);
            booking.setCustomer(customer);

            getBookingRegisterService().saveBooking(booking);
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
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
        booking.setTime(new Timestamp(this.getTime().getTime()));
        booking.setOriginId(Integer.parseInt(this.getOriginId()));
        booking.setOriginAddress(this.getOriginAddress());
        booking.setDestinationId(Integer.parseInt(this.getDestinationId()));
        booking.setDuration(Integer.parseInt(this.getDuration()));
        return booking;
    }

    public String deleteBooking() {
        try {
            getBookingRegisterService().deleteBookingByID(Integer.parseInt(this.getBookingId()));
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
            booking.setBookingId(Integer.parseInt(this.getBookingId()));

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
        this.setBookingId("");
        this.setHomePhone("");
        this.setMobilePhone("");
        this.setEmail("");
        this.setAddress("");
        this.setOriginAddress("");
        this.setOriginId("");
        this.setDestinationId("");
        this.setDuration("");
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

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
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

    public String getOriginId() {
        return originId;
    }

    public void setOriginId(String originId) {
        this.originId = originId;
    }

    public String getOriginAddress() {
        return originAddress;
    }

    public void setOriginAddress(String originAddress) {
        this.originAddress = originAddress;
    }

    public String getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(String destinationId) {
        this.destinationId = destinationId;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public List<BookingDTO> getBookingList() {
        List<Booking> bookings = getBookingRegisterService().getBookingList();
        List<BookingDTO> bookingDTOList = new ArrayList<>();
        for (Booking booking : bookings) {
            BookingDTO bookingDTO = new BookingDTO(booking);
            bookingDTOList.add(bookingDTO);
        }

        return bookingDTOList;
    }

}
