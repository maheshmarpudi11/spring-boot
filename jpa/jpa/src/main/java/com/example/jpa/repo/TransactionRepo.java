package com.example.jpa.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jpa.entity.TransactionHistory;

public interface TransactionRepo extends JpaRepository<TransactionHistory, Integer>{

	List<TransactionHistory> findByAccNumber(int accNumber);

}
