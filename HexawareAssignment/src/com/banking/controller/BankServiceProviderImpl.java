package com.banking.controller;

import java.sql.Date;
import java.util.Scanner;

import com.banking.dao.AccountsDao;
import com.banking.dao.CustomersDao;
import com.banking.dao.TransactionsDao;
import com.banking.entity.Account;
import com.banking.entity.Customer;
import com.banking.entity.Transaction;

public class BankServiceProviderImpl implements IBankServiceProvider{

	private String branchName;
	private String branchAddress;
	AccountsDao accountsDao = new AccountsDao();
	CustomersDao customersDao = new CustomersDao();
	TransactionsDao transactionDao = new TransactionsDao();
	Account account;
	Scanner scanner = new Scanner(System.in);
	Transaction transaction;
	public BankServiceProviderImpl(String branchName, String branchAddress)
	{
		super();
		this.branchName = branchName;
		this.branchAddress = branchAddress;
	}
	@Override
	public void createAccount(Customer customer, String accType, float balance) {
		try {
			account = new Account(accType, balance, customer);
			customersDao.addCustomer(customer);
			accountsDao.addAccount(account);
	        System.out.println("Account created successfully!");
	        System.out.println("Account Number: " + account.getAccountNumber());
			} catch (NullPointerException e)
			{
				e.printStackTrace();
				e.getMessage();
			}
		
	}


	@Override
	public float getAccountBalance(long accountNumber) {
		float accountBal = accountsDao.getAccountBalance(accountNumber);
		return accountBal;
	}

	@Override
	public float deposit(long accountNumber, float amount) {
		System.out.println("Enter description of the transaction: ");
		String desc = scanner.nextLine();
		long millis = System.currentTimeMillis();
		Date date = new Date(millis);
		transaction = new Transaction(desc, date, "Deposit", amount);
		transactionDao.addTransaction(transaction, accountNumber);
		float newBal = accountsDao.updateAccount(accountNumber, amount);
		return newBal;
	}

	@Override
	public float withdraw(long accountNumber, float amount) {
		System.out.println("Enter description of the transaction: ");
		String desc = scanner.nextLine();
		long millis = System.currentTimeMillis();
		Date date = new Date(millis);
		transaction = new Transaction(desc, date, "Withdraw", amount);
		transactionDao.addTransaction(transaction, accountNumber);
		float newBal = accountsDao.updateWithdraw(accountNumber, amount);
		return newBal;
	}

	@Override
	public void transfer(long fromAccountNumber, long toAccountNumber, float amount) {
		System.out.println("Enter description of the transaction: ");
		String desc = scanner.nextLine();
		long millis = System.currentTimeMillis();
		Date date = new Date(millis);
		transaction = new Transaction(desc, date, "Transfer", amount);
		transactionDao.addTransaction(transaction, fromAccountNumber);
		transactionDao.addTransaction(transaction, toAccountNumber);
		float fromBalance = withdraw(fromAccountNumber, amount);
        if (fromBalance != -1) {
            deposit(toAccountNumber, amount);
        }
	}

	@Override
	public void getAccountDetails(long accountNumber) {
		accountsDao.viewAccount(accountNumber);
	}
	
	@Override
	public void getTransactions(long accountNumber, Date fromDate, Date toDate) {
		transactionDao.viewTransactionBetweenDates(accountNumber, fromDate, toDate);
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getBranchAddress() {
		return branchAddress;
	}
	public void setBranchAddress(String branchAddress) {
		this.branchAddress = branchAddress;
	}
	
	
	
	
}
