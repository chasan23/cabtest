package com.cabtest.dao;

import com.cabtest.model.Customer;

import org.springframework.stereotype.Repository;

@Repository
public class CustomerDAOImpl extends GenericDAOImpl<Customer, Integer> implements CustomerDAO {

}