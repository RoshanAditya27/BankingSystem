package com.banking.controller;

import java.util.HashMap;


import com.banking.entity.Account;

public class CustomerServiceProviderImpl implements ICustomerServiceProvider{
	private HashMap<Long, Account> accounts = new HashMap<>();
	@Override
	public float getAccountBalance(long accountNumber) {
		Account account = accounts.get(accountNumber);
        if (account != null) {
            return (float) account.getAccountBalance();
        } else {
            System.out.println("Account not found!");
            return -1;
        }
	}

	@Override
	public float deposit(long accountNumber, float amount) {
		Account account = accounts.get(accountNumber);
        if (account != null) {
            account.setAccountBalance(account.getAccountBalance() + amount);
            System.out.println("Deposit successful. Current balance: $" + account.getAccountBalance());
            return account.getAccountBalance();
        } else {
            System.out.println("Account not found!");
            return -1;
        }
	}

	@Override
	public float withdraw(long accountNumber, float amount) {
		Account account = accounts.get(accountNumber);
        if (account != null) {
            if (amount <= account.getAccountBalance()) {
                account.setAccountBalance(account.getAccountBalance() - amount);
                System.out.println("Withdrawal successful. Current balance: $" + account.getAccountBalance());
                return account.getAccountBalance();
            } else {
                System.out.println("Insufficient funds. Withdrawal failed.");
                return -1;
            }
        } else {
            System.out.println("Account not found!");
            return -1;
        }
	}

	@Override
	public void transfer(long fromAccountNumber, long toAccountNumber, float amount) {
		float fromBalance = withdraw(fromAccountNumber, amount);
        if (fromBalance != -1) {
            deposit(toAccountNumber, amount);
        }
	}

	@Override
	public void getAccountDetails(long accountNumber) {
		Account account = accounts.get(accountNumber);
        if (account != null) {
            account.printAccountInfo();
        } else {
            System.out.println("Account not found!");
        }
		
	}
	

}
