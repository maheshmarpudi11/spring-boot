package com.example.jpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jpa.entity.Account;

public interface AccountRepo extends JpaRepository<Account, Integer> {

	public Account findByAccNumber(int accNumber);
	
}
