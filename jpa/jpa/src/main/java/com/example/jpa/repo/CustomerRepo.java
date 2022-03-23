package com.example.jpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jpa.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {

	Customer findByName(String name);

}
