package com.banking.controller;

import java.sql.Date;

import com.banking.entity.Account;
import com.banking.entity.Customer;

public interface IBankServiceProvider {
	void createAccount(Customer customer, String accType, float balance);
	float getAccountBalance(long accountNumber);
	float deposit(long accountNumber, float amount);
	float withdraw(long accountNumber, float amount);
	void transfer(long fromAccountNumber, long toAccountNumber, float amount);
	void getAccountDetails(long accountNumber);
	void getTransactions(long accountNumber, Date fromDate, Date toDate);
}
