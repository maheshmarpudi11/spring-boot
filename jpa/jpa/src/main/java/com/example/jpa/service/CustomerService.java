package com.example.jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jpa.entity.Customer;
import com.example.jpa.repo.CustomerRepo;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepo repo;
	
	public void createCustomer(Customer customer) {
		
		repo.save(customer);
		
	}

	public Customer findCustomerByName(String name) {
		return repo.findByName(name);
	}

}
