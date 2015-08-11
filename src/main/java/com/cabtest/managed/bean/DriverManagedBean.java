package com.cabtest.managed.bean;

import com.cabtest.dto.DriverDTO;
import com.cabtest.model.Contact;
import com.cabtest.model.Driver;
import com.cabtest.service.DriverRegisterService;
import org.apache.log4j.Logger;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "driverMB")
@RequestScoped
public class DriverManagedBean {
    private static final String SUCCESS = "success";
    private static final String ERROR = "error";
    private static final Logger LOG = Logger.getLogger(DriverManagedBean.class);

    @ManagedProperty(value = "#{driverService}")
    DriverRegisterService driverRegisterService;
    String driverId;
    String firstName;
    String lastName;
    String age;
    String homePhone;
    String mobilePhone;
    String email;
    String address;

    public String addDriver() {
        try {

            Contact contact = getContact();
            Driver driver = getDriver();

            driver.setContact(contact);
            getDriverRegisterService().saveDriver(driver);

            return SUCCESS;
        } catch (Exception e) {
            LOG.error("Error while trying to add driver.", e);
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

    public String deleteDriver() {
        try {
            getDriverRegisterService().deleteDriverByID(Integer.parseInt(this.getDriverId()));
            return SUCCESS;
        } catch (Exception e) {
            LOG.error("Error while trying to delete driver.", e);
        }
        return ERROR;
    }

    public String updateDriver() {

        try {

            Contact contact = getContact();

            Driver updatedDriver = getDriver();
            updatedDriver.setDriverId(Integer.parseInt(this.getDriverId()));
            updatedDriver.setContact(contact);

            DriverDTO driverDTO = new DriverDTO(updatedDriver);
            getDriverRegisterService().updateDriver(driverDTO);
            return SUCCESS;
        } catch (Exception e) {
            LOG.error("Error while trying to update driver.", e);
        }
        return ERROR;
    }

    private Driver getDriver() {
        Driver driver = new Driver();
        driver.setFirstName(this.getFirstName());
        driver.setLastName(this.getLastName());
        driver.setAge(Integer.parseInt(this.getAge()));
        return driver;
    }

    public void reset() {
        this.setDriverId("");
        this.setFirstName("");
        this.setLastName("");
        this.setAge("");
        this.setHomePhone("");
        this.setMobilePhone("");
        this.setEmail("");
        this.setAddress("");

    }

    public DriverRegisterService getDriverRegisterService() {
        return driverRegisterService;
    }

    public void setDriverRegisterService(DriverRegisterService driverRegisterService) {
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

    public List<DriverDTO> getDriverList() {
        List<Driver> drivers = getDriverRegisterService().getDriverList();
        List<DriverDTO> driverDTOList = new ArrayList<>();
        for (Driver driver : drivers) {
            DriverDTO driverDTO = new DriverDTO(driver);
            driverDTOList.add(driverDTO);
        }
        return driverDTOList;
    }

}
