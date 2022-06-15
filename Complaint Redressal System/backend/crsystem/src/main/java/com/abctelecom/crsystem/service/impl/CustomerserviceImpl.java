package com.abctelecom.crsystem.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abctelecom.crsystem.entity.Customer;
import com.abctelecom.crsystem.entity.CustomerRole;
import com.abctelecom.crsystem.repos.CustomerRepository;
import com.abctelecom.crsystem.repos.RoleRepository;
import com.abctelecom.crsystem.service.CustomerService;

@Service
public class CustomerserviceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepository customerrepository;
	
	@Autowired
	private RoleRepository roleRepository;

	//creating user
	@Override
	public Customer createCustomer(Customer customer, Set<CustomerRole> customerRoles) throws Exception {
		
		Customer local =this.customerrepository.findByUsername(customer.getUsername());
		if (local!=null){
			System.out.println("Customer already present");
			throw new Exception("User Already Present!!");
		}
		else {
			//create Customer
			for(CustomerRole cr:customerRoles) {
				roleRepository.save(cr.getRole());
			}
			customer.getCustomerRoles().addAll(customerRoles);
			local=this.customerrepository.save(customer);
			
		}
		return local;
	}

	//getting user by username
	@Override
	public Customer getCustomer(String username) {
		
		return this.customerrepository.findByUsername(username);
	}
	
	

}
