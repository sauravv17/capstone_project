package com.abctelecom.crsystem.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
public class CustomerRole {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long custRoleId;
	
	//customer
	@ManyToOne(fetch=FetchType.EAGER)
	private Customer customer;
	
	//role
	@ManyToOne
	private Role role;

	public CustomerRole(Long custRoleId, Customer customer, Role role) {
		this.custRoleId = custRoleId;
		this.customer = customer;
		this.role = role;
	}

	public CustomerRole() {
	}

	public Long getCustRoleId() {
		return custRoleId;
	}

	public void setCustRoleId(Long custRoleId) {
		this.custRoleId = custRoleId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	
	
	

}
