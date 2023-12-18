package com.banking.entity;

import java.sql.Date;

public class Transaction {
	private String description;
	private Date dateTime;
	private String transactionType;
	private float transactionAmount;
	
	
	public Transaction(String description, Date dateTime, String transactionType, float transactionAmount) {
		super();
		this.description = description;
		this.dateTime = dateTime;
		this.transactionType = transactionType;
		this.transactionAmount = transactionAmount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDateTime() {
		return dateTime;
	}
	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public float getTransactionAmount() {
		return transactionAmount;
	}
	public void setTransactionAmount(float transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	

	@Override
	public String toString() {
		return "Transaction [description=" + description + ", dateTime=" + dateTime + ", transactionType="
				+ transactionType + ", transactionAmount=" + transactionAmount + "]";
	}
}
