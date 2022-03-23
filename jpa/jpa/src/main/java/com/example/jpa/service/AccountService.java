package com.example.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jpa.entity.Account;
import com.example.jpa.entity.TransactionHistory;
import com.example.jpa.repo.AccountRepo;

@Service
public class AccountService {

	@Autowired
	private AccountRepo repo;
	
	public Account findAccountInfo(int accNumber) {
		return repo.findByAccNumber(accNumber);
	}

	

}
