package com.banking.controller;

import com.banking.entity.Account;
import com.banking.entity.Customer;

public class ZeroBalanceAccount extends Account{
	public ZeroBalanceAccount(Customer customer) {
        super("ZeroBalance", 0, customer);
    }
}
