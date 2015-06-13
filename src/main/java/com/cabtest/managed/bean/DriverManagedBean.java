package com.cabtest.managed.bean;

import com.cabtest.model.Contact;
import com.cabtest.model.Driver;
import com.cabtest.model.DriverDetails;
import com.cabtest.service.DriverRegisterService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "driverMB")
@RequestScoped
public class DriverManagedBean {
    private static final long serialVersionUID = 1L;
    private static final String SUCCESS = "success";
    private static final String ERROR = "error";

    @ManagedProperty(value = "#{DriverService}")
    DriverRegisterService driverRegisterService;

    String driverId;
    String firstName;
    String lastName;
    String age;
    String homePhone;
    String mobilePhone;
    String email;
    String address;
    String availability;
    List<DriverDetails> driverList;

    public String addDriver() {
        try {

            Contact contact = new Contact();
            contact.setHomePhone(this.getHomePhone());
            contact.setMobilePhone(this.getMobilePhone());
            contact.setEmail(this.getEmail());
            contact.setAddress(this.getAddress());

            Driver driver = new Driver();
            driver.setDriverId(Integer.parseInt(this.getDriverId()));
            driver.setFirstName(this.getFirstName());
            driver.setLastName(this.getLastName());
            driver.setAge(Integer.parseInt(this.getAge()));
            if ("true".equals(this.availability)) {
                driver.setAvailability('1');
            } else {
                driver.setAvailability('0');
            }
            driver.setContact(contact);

            getDriverRegisterService().saveDriver(driver);
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ERROR;
    }

    public String deleteDriver() {
        try {
//			 getDriverRegisterService().deleteDriverByID(Integer.parseInt(this.getDriverId()));
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ERROR;
    }

    public String updateDriver() {
        try {

            Contact contact = new Contact();
            contact.setHomePhone(this.getHomePhone());
            contact.setMobilePhone(this.getMobilePhone());
            contact.setEmail(this.getEmail());
            contact.setAddress(this.getAddress());

            Driver driver = new Driver();
            driver.setDriverId(Integer.parseInt(this.getDriverId()));
            driver.setFirstName(this.getFirstName());
            driver.setLastName(this.getLastName());
            driver.setAge(Integer.parseInt(this.getAge()));
            if ("true".equals(this.availability)) {
                driver.setAvailability('1');
            } else {
                driver.setAvailability('0');
            }
            driver.setContact(contact);

            getDriverRegisterService().updateDriver(driver);
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ERROR;
    }

    public void reset() {
        this.setDriverId("");
        this.setFirstName("");
        this.setLastName("");
        this.setAge("");
        this.setAvailability("");
        this.setHomePhone("");
        this.setMobilePhone("");
        this.setEmail("");
        this.setAddress("");

    }

    public DriverRegisterService getDriverRegisterService() {
        return driverRegisterService;
    }

    public void setDriverRegisterService(
            DriverRegisterService driverRegisterService) {
        this.driverRegisterService = driverRegisterService;
    }

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
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

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public List<DriverDetails> getDriverList() {
        List<Driver> drivers = getDriverRegisterService().getDriverList();
        List<DriverDetails> driverDetailsList = new ArrayList<DriverDetails>();
        for (Driver driver : drivers) {
            DriverDetails driverDetails = new DriverDetails(driver);
            driverDetailsList.add(driverDetails);
            System.out.println(driverDetails);
        }
        return driverDetailsList;
    }

    public void setDriverList(List<DriverDetails> driverList) {
        this.driverList = driverList;
    }

}
