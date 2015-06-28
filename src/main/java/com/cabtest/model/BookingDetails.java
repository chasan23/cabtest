package com.cabtest.model;


import java.sql.Timestamp;
import java.util.Date;

public class BookingDetails {

    private int bookingId;
    private int customerId;
    private int contactId;
    private String vehicleType;
    private Date time;
    private String location;
    private String firstName;
    private String lastName;
    private String homePhone;
    private String mobilePhone;
    private String email;
    private String address;

    public BookingDetails(Booking booking) {
        this.setBookingId(booking.getBookingId());
        this.setVehicleType(booking.getVehicleType());
        this.setTime(new Date(booking.getTime().getTime()));
        this.setLocation(booking.getLocation());

        Customer customer = booking.getCustomer();

        this.setCustomerId(customer.getCustomerId());
        this.setFirstName(customer.getFirstName());
        this.setLastName(customer.getLastName());

        Contact contact = customer.getContact();

        this.setContactId(contact.getContactId());
        this.setHomePhone(contact.getHomePhone());
        this.setMobilePhone(contact.getMobilePhone());
        this.setEmail(contact.getEmail());
        this.setAddress(contact.getAddress());

    }


    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getContactId() {
        return contactId;
    }

    public void setContactId(int contactId) {
        this.contactId = contactId;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
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
}

