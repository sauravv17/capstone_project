package com.abctelecom.crsystem.repos;

import org.springframework.data.repository.CrudRepository;

import com.abctelecom.crsystem.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long>{
	
	public Customer findByUsername(String username);

}
