package com.example.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.jpa.service.CustomerService;

@SpringBootApplication
public class JpaApplication implements CommandLineRunner {

	@Autowired
	private CustomerService customerService;

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	// createCustomer();

	}

	/*
	 * private void createCustomer() { Customer customer = new Customer("mahesh",
	 * "test@gmail.com", "324324324"); customer.setAccount(new Account(1001,"SA",
	 * 10000));
	 * 
	 * customerService.createCustomer(customer);
	 * 
	 * }
	 */
	 
}
