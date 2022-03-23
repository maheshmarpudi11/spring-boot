package com.example.jpa.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties(value="id")
public class TransactionHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int accNumber;
	private int refAccNumber;
	private String comments;
	private String currentdate;
	private String txnType;
	private int amount;
	
	@Override
	public String toString() {
		return "TransactionHistory [id=" + id + ", accNumber=" + accNumber + ", currentdate=" + currentdate
				+ ", txnType=" + txnType + ", amount=" + amount + "]";
	}

	public TransactionHistory() {}
	
	public TransactionHistory(int accNumber,int refAccNumber,String comments, String currentDate, String txnType, int amount) {
		this.accNumber = accNumber;
		this.refAccNumber = refAccNumber;
		this.currentdate = currentDate;
		this.txnType = txnType;
		this.amount = amount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAccNumber() {
		return accNumber;
	}

	public void setAccNumber(int accNumber) {
		this.accNumber = accNumber;
	}

	public String getCurrentDate() {
		return currentdate;
	}

	public void setCurrentDate(String currentDate) {
		this.currentdate = currentDate;
	}

	public String getTxnType() {
		return txnType;
	}

	public void setTxnType(String txnType) {
		this.txnType = txnType;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getRefAccNumber() {
		return refAccNumber;
	}

	public void setRefAccNumber(int refAccNumber) {
		this.refAccNumber = refAccNumber;
	}

	public String getCurrentdate() {
		return currentdate;
	}

	public void setCurrentdate(String currentdate) {
		this.currentdate = currentdate;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
	
}
