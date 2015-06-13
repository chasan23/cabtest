package com.cabtest.model;

public class DriverDetails {

    private int driverId;
    private String firstName;
    private String lastName;
    private int age;
    private String availability;
    private int contactId;
    private String homePhone;
    private String mobilePhone;
    private String email;
    private String address;


    public DriverDetails(Driver driver) {
        this.setFirstName(driver.getFirstName());
        this.setDriverId(driver.getDriverId());
        this.setLastName(driver.getLastName());
        this.setAge(driver.getAge());

        if (driver.getAvailability() == '1') {
            this.setAvailability("true");
        } else {
            this.setAvailability("false");
        }

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

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    @Override
    public String toString() {
        return "DriverDetails{" +
               "driverId=" + driverId +
               ", firstName='" + firstName + '\'' +
               ", lastName='" + lastName + '\'' +
               ", age=" + age +
               ", availability='" + availability + '\'' +
               ", homePhone='" + homePhone + '\'' +
               ", mobilePhone='" + mobilePhone + '\'' +
               ", email='" + email + '\'' +
               ", address='" + address + '\'' +
               '}';
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
