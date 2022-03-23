package com.example.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.jpa.entity.Account;
import com.example.jpa.entity.TransactionHistory;
import com.example.jpa.service.AccountService;
import com.example.jpa.service.TransactionService;

@RestController
public class TransactionController {

	@Autowired
	private TransactionService txnService;
	
	@Autowired
	private AccountService accountService;
	
	@GetMapping("/txn/{accNo}")
	public Account findBalance(@PathVariable("accNo") int accNumber){
		
		return accountService.findAccountInfo(accNumber);
	}
	
	@PostMapping("/txn")
	public String transaction(@RequestBody TransactionHistory transaction){
		
		return txnService.transaction(transaction);
	}
	
	
	@GetMapping("/txn/history/{accNo}")
	public List<TransactionHistory> findTxnHistory(@PathVariable("accNo") int accNumber){
	  
	  return txnService.findTxnHistory(accNumber); 
	  
	}
	 	
}
	
 