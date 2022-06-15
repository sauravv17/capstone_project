package com.abctelecom.crsystem;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.abctelecom.crsystem.entity.Customer;
import com.abctelecom.crsystem.entity.CustomerRole;
import com.abctelecom.crsystem.entity.Role;
import com.abctelecom.crsystem.service.CustomerService;

@RunWith(SpringRunner.class)
@SpringBootTest
class CrsystemApplicationTests {
	
	@Autowired
	ApplicationContext context;
	
	@Autowired
	private CustomerService customerService;

	@Test
	void savecustomer() throws Exception {
		
		System.out.println("Starting code...");
		Customer customer =new Customer();
		
		customer.setfName("ss");
		customer.setlName("kr");
		customer.setUsername("sskr123");
		
		Role role1=new Role();
		role1.setRoleId(11L);
		role1.setRoleName("ADMIN");
		
		Set<CustomerRole> customerRoleSet=new HashSet<>();
		CustomerRole customerRole=new CustomerRole();
		customerRole.setRole(role1);
		customerRole.setCustomer(customer);
		
		customerRoleSet.add(customerRole);
		
		Customer customer1 =this.customerService.createCustomer(customer, customerRoleSet);
		System.out.println(customer1.getUsername());
		}

}
