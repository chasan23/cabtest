package com.cabtest.service;

import com.cabtest.dao.ContactDAO;
import com.cabtest.dao.DriverDAO;
import com.cabtest.model.Contact;
import com.cabtest.model.Driver;
import com.cabtest.model.DriverDetails;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class DriverRegisterServiceImpl implements DriverRegisterService {
    private DriverDAO driverDAO;
    private ContactDAO contactDAO;

    public DriverRegisterServiceImpl() {
        super();
    }

    public DriverDAO getDriverDAO() {
        return driverDAO;
    }

    public void setDriverDAO(DriverDAO driverDAO) {
        this.driverDAO = driverDAO;
    }

    public ContactDAO getContactDAO() {
        return contactDAO;
    }

    public void setContactDAO(ContactDAO contactDAO) {
        this.contactDAO = contactDAO;
    }

    @Override
    @Transactional
    public void saveDriver(Driver driver) {
        Contact contact = driver.getContact();
        getContactDAO().save(contact);
        driver.setContact(contact);
        contact.getDrivers().add(driver);
        getDriverDAO().save(driver);
    }

    @Override
    @Transactional
    public void updateDriver(DriverDetails updatedDriver) {
        Driver existingDriver = getDriverDAO().findByKey(updatedDriver.getDriverId());
        existingDriver.setAge(updatedDriver.getAge());

        if ("true".equals(updatedDriver.getAvailability())) {
            existingDriver.setAvailability('1');
        } else {
            existingDriver.setAvailability('0');
        }

        existingDriver.setFirstName(updatedDriver.getFirstName());
        existingDriver.setLastName(updatedDriver.getLastName());

        Contact contact = existingDriver.getContact();
        contact.setHomePhone(updatedDriver.getHomePhone());
        contact.setMobilePhone(updatedDriver.getMobilePhone());
        contact.setAddress(updatedDriver.getAddress());
        contact.setEmail(updatedDriver.getEmail());

        getContactDAO().update(contact);
        existingDriver.setContact(contact);
        contact.getDrivers().add(existingDriver);
        getDriverDAO().update(existingDriver);

    }

    @Override
    @Transactional
    public void deleteDriver(Driver driver) {
        //not implemented
    }

    @Override
    @Transactional
    public List<Driver> getDriverList() {
        return driverDAO.getAll();
    }

    @Override
    @Transactional
    public void deleteDriverByID(Integer id) {
        driverDAO.deleteByKey(id);
    }

    @Override
    public Driver getAvailableDriver() {
        return null;
    }

}
