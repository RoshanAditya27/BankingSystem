package com.banking.controller;

public interface ICustomerServiceProvider {
	float getAccountBalance(long accountNumber);
	float deposit(long accountNumber, float amount);
	float withdraw(long accountNumber, float amount);
	void transfer(long fromAccountNumber, long toAccountNumber, float amount);
	void getAccountDetails(long accountNumber);
}
