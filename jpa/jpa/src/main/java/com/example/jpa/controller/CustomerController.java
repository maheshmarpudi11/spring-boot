package com.example.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jpa.entity.Customer;
import com.example.jpa.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService service;
	
	@PostMapping("/create")
	public String createUser(Customer customer) {
		
		service.createCustomer(customer);
		
		return "Customer saved with id : "+customer.getId();
	}
	
	@GetMapping("/find/{name}")
	public Customer findCustomerByName(@PathVariable("name") String name) {
		
		return service.findCustomerByName(name);
		
	}
	
	
	
	
	
}
