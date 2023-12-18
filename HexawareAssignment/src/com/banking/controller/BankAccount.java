package com.banking.controller;

public abstract class BankAccount {
	private int accountNumber;
	private String customerName;
	private double balance;
	
	public BankAccount() {
		
	}

	public BankAccount(int accountNumber, String customerName, double balance) {
		super();
		this.accountNumber = accountNumber;
		this.customerName = customerName;
		this.balance = balance;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public abstract void deposit(double amount);
	public abstract void withdraw(double amount);
	public abstract void calculateInterest();
	
	public void printAccountInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Customer Name: " + customerName);
        System.out.println("Balance: $" + balance);
    }
}
