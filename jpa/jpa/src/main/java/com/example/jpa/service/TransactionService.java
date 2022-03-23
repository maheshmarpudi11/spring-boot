package com.example.jpa.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jpa.entity.Account;
import com.example.jpa.entity.TransactionHistory;
import com.example.jpa.repo.AccountRepo;
import com.example.jpa.repo.TransactionRepo;

@Service
public class TransactionService {

	@Autowired
	private AccountRepo accountRepo;

	@Autowired
	private TransactionRepo txnHistoryRepo;

	public String transaction(TransactionHistory transaction) {

		String message = "";
		Account accountInfo = accountRepo.findByAccNumber(transaction.getAccNumber());
		System.out.println("accountInfo :"+accountInfo.getAccNumber());
		System.out.println(transaction);
		
		transaction.setCurrentDate(LocalDate.now().toString());
		
		if (transaction.getAccNumber() != accountInfo.getAccNumber()) {
			message = "Invalid Account Number : " + transaction.getAccNumber() + ", Check with Home Branch.";
		}

		if (transaction.getTxnType() != null && transaction.getTxnType().equals("DEBIT")) {

			int currentBalance = accountInfo.getAmount();
			int withdrawAmount = transaction.getAmount();

			if (currentBalance > withdrawAmount) {
				txnHistoryRepo.save(transaction);

				int updatedAmount = currentBalance - withdrawAmount;
				accountInfo.setAmount(updatedAmount);

				accountRepo.save(accountInfo);

				message = "Transaction is Successful.";

			} else {
				message = "Insufficent Funds, Current Account Balance : " + currentBalance;
			}

		}

		if (transaction.getTxnType() != null && transaction.getTxnType().equals("CREDIT")) {

			int currentBalance = accountInfo.getAmount();
			int depositAmount = transaction.getAmount();

			txnHistoryRepo.save(transaction);

			int updatedAmount = currentBalance + depositAmount;
			accountInfo.setAmount(updatedAmount);

			accountRepo.save(accountInfo);

			message = "Transaction is Successful.";
		}

		return message;
	}

	public List<TransactionHistory> findTxnHistory(int accNumber) {

		return txnHistoryRepo.findByAccNumber(accNumber);
	}

}
