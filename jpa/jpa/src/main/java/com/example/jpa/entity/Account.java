package com.example.jpa.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties(value="id")
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String accType;
	private int amount;
	private int accNumber;

	public Account() {
	}

	public Account( int accNumber, String accType, int amount) {
		this.accNumber = accNumber;
		this.accType = accType;
		this.amount = amount;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAccType() {
		return accType;
	}
	public void setAccType(String accType) {
		this.accType = accType;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getAccNumber() {
		return accNumber;
	}
	public void setAccNumber(int accNumber) {
		this.accNumber = accNumber;
	}
}
