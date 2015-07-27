package com.cabtest.service;

import com.cabtest.dao.ContactDAO;
import com.cabtest.dao.DriverDAO;
import com.cabtest.model.Contact;
import com.cabtest.model.Driver;
import com.cabtest.dto.DriverDTO;
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
        contact.getPersons().add(driver);
        getDriverDAO().save(driver);
    }

    @Override
    @Transactional
    public void updateDriver(DriverDTO updatedDriver) {
        Driver existingDriver = getDriverDAO().findByKey(updatedDriver.getDriverId());
        existingDriver.setAge(updatedDriver.getAge());

        existingDriver.setFirstName(updatedDriver.getFirstName());
        existingDriver.setLastName(updatedDriver.getLastName());

        Contact existingContact = existingDriver.getContact();
        existingContact.setHomePhone(updatedDriver.getHomePhone());
        existingContact.setMobilePhone(updatedDriver.getMobilePhone());
        existingContact.setAddress(updatedDriver.getAddress());
        existingContact.setEmail(updatedDriver.getEmail());

        getContactDAO().update(existingContact);
        existingDriver.setContact(existingContact);
        existingContact.getPersons().add(existingDriver);
        getDriverDAO().update(existingDriver);

    }

    @Override
    @Transactional
    public void deleteDriver(Driver driver) {
        driverDAO.delete(driver);
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
