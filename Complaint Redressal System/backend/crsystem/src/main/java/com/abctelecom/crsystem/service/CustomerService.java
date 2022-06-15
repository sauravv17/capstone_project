package com.abctelecom.crsystem.service;

import java.util.Set;

import com.abctelecom.crsystem.entity.Customer;
import com.abctelecom.crsystem.entity.CustomerRole;

public interface CustomerService {
	
	//create customer
	public Customer createCustomer(Customer customer,Set<CustomerRole>customerRole) throws Exception;
	
	//get user by username
	public Customer getCustomer(String username);
	

}
