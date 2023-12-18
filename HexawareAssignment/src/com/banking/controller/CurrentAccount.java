package com.banking.controller;

import com.banking.entity.Account;
import com.banking.entity.Customer;


public class CurrentAccount extends Account{
	private static final double OVERDRAFT_LIMIT = 1000.0; // Constant for overdraft limit
	public CurrentAccount() {
		
	}
	   public CurrentAccount(int accountId, int customerId, long accountNumber, String accountType, float accountBalance, Customer customer) {
	       super(accountType, accountBalance, customer);
	   }
	   
	   public void deposit(float amount) {
			// TODO Auto-generated method stub
			setAccountBalance(getAccountBalance() + amount);
	        System.out.println("Deposit successful. Current balance: $" + getAccountBalance());
		}
	   
	   public void withdraw(float amount) {
	       if (amount <= (getAccountBalance() + OVERDRAFT_LIMIT)) {
	           setAccountBalance(getAccountBalance() - amount);
	           System.out.println("Withdrawn: " + amount);
	       } else {
	           System.out.println("Insufficient balance for withdrawal beyond overdraft limit.");
	       }
	   }
	   public void calculateInterest() {
			// TODO Auto-generated method stub
			System.out.println("No interest for Current Account.");
		}
	
}
