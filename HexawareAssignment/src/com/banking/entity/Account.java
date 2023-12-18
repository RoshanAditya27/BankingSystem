package com.banking.entity;

public class Account {
	private static long accountNumberCounter = 1000;

    private long accountNumber;
    private String accountType;
    private float accountBalance;
    private Customer customer;
    
    public Account() {
    	this.accountNumber = ++accountNumberCounter;
    }
	public Account(String accountType, float accountBalance, Customer customer) {
		this();
		this.accountType = accountType;
		this.accountBalance = accountBalance;
		this.customer = customer;
	}
	public static long getAccountNumberCounter() {
		return accountNumberCounter;
	}
	public static void setAccountNumberCounter(long accountNumberCounter) {
		Account.accountNumberCounter = accountNumberCounter;
	}
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public float getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(float accountBalance) {
		this.accountBalance = accountBalance;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	@Override
	public String toString() {
		return "AccountTask10 [accountNumber=" + accountNumber + ", accountType=" + accountType + ", accountBalance="
				+ accountBalance + ", customer=" + customer + "]";
	}
    
	public void printAccountInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Type: " + accountType);
        System.out.println("Account Balance: $" + accountBalance);
        System.out.println("Customer Information:");
        customer.printCustomerInfo();
    }
    
}
