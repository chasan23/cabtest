package com.cabtest.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.cabtest.dao.ContactDAO;
import com.cabtest.dao.DriverDAO;
import com.cabtest.model.Contact;
import com.cabtest.model.Driver;

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

	public void setContactDAO(ContactDAO contactDAO) {
		this.contactDAO = contactDAO;
	}

	public ContactDAO getContactDAO() {
		return contactDAO;
	}


	@Transactional
	public void saveDriver(Driver driver) {
		Contact contact = driver.getContact();
		getContactDAO().save(contact);		
		driver.setContact(contact);
		contact.getDrivers().add(driver);
		getDriverDAO().save(driver);
	}

	@Transactional
	public void updateDriver(Driver driver) {
		Contact contact = driver.getContact();
		getContactDAO().update(contact);		
		driver.setContact(contact);
		contact.getDrivers().add(driver);
		getDriverDAO().update(driver);
		
	}

	@Transactional
	public void deleteDriver(Driver driver) {
		
	}

	@Transactional
	public List<Driver> getDriverList() {
		return driverDAO.getAll();		
	}

	@Transactional
	public void deleteDriverByID(Integer id) {
		driverDAO.deleteByKey(id);
	}

}
