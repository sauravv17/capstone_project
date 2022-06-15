package com.abctelecom.crsystem.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abctelecom.crsystem.entity.Customer;
import com.abctelecom.crsystem.entity.CustomerRole;
import com.abctelecom.crsystem.entity.Role;
import com.abctelecom.crsystem.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	//creating user
	@PostMapping("/")
	public Customer createCustomer(@RequestBody Customer customer) throws Exception {
		
		Set<CustomerRole> customerRoles = new HashSet<CustomerRole>();
		
		Role role=new Role();
		role.setRoleId(12L);
		role.setRoleName("Normal");
		
		CustomerRole customerRole = new CustomerRole();
		customerRole.setCustomer(customer);
		customerRole.setRole(role);
		
		customerRoles.add(customerRole);
		
		
		
		return this.customerService.createCustomer(customer, customerRoles);
		
	}
	@GetMapping("/{username}")
	public Customer getCustomer(@PathVariable("username") String username) {
		
		return this.customerService.getCustomer(username);
		
	}

}
