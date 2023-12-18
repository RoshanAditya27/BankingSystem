package com.banking.controller;

import com.banking.entity.Account;
import com.banking.entity.Customer;

public class SavingsAccount extends Account{
	private double interestRate;
	   private static final double MINIMUM_BALANCE = 500.0;
	   
	   public SavingsAccount() {
			
		}
	   public SavingsAccount(int accountId, int customerId, long accountNumber, String accountType, float accountBalance, double interestRate, Customer customer) {
	       super(accountType, accountBalance, customer);
	       this.interestRate = interestRate;
	       if (accountBalance >= MINIMUM_BALANCE) {
	           this.interestRate = interestRate;
	       } else {
	           System.out.println("Initial balance must be at least " + MINIMUM_BALANCE + " to open a savings account.");
	       }
	   }
	   
	   public void deposit(float amount) {
			// TODO Auto-generated method stub
			setAccountBalance(getAccountBalance() + amount);
	        System.out.println("Deposit successful. Current balance: $" + getAccountBalance());
		}
	   
	   public void withdraw(float amount) {
			// TODO Auto-generated method stub
			if (amount <= getAccountBalance()) {
	            setAccountBalance(getAccountBalance() - amount);
	            System.out.println("Withdrawal successful. Current balance: $" + getAccountBalance());
	        } else {
	            System.out.println("Insufficient funds. Withdrawal failed.");
	        }
		}
	   
	   public double calculateInterest() {
	       return (getAccountBalance() * interestRate) / 100;
	   }

    
}
