package com.cabtest.dto;

import com.cabtest.model.Contact;
import com.cabtest.model.Driver;

public class DriverDTO {

    private int driverId;
    private String firstName;
    private String lastName;
    private int age;
    private int contactId;
    private String homePhone;
    private String mobilePhone;
    private String email;
    private String address;


    public DriverDTO(Driver driver) {
        this.setFirstName(driver.getFirstName());
        this.setDriverId(driver.getDriverId());
        this.setLastName(driver.getLastName());
        this.setAge(driver.getAge());

        Contact contact = driver.getContact();
        this.setAddress(contact.getAddress());
        this.setEmail(contact.getEmail());
        this.setHomePhone(contact.getHomePhone());
        this.setMobilePhone(contact.getMobilePhone());
    }

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getContactId() {
        return contactId;
    }

    public void setContactId(int contactId) {
        this.contactId = contactId;
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
