package com.banking.basics;

import java.util.Scanner;

public class Main1toFive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Task 1:
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your credit score: ");
		int credScore = sc.nextInt();
		System.out.println("Enter your annual income: ");
		int annIncome = sc.nextInt();
		
		if((credScore > 700) && (annIncome >= 50000))
		{
			System.out.println("Customer eligible for loan");
		}
		else
			System.out.println("Customer not eligible for loan");
		
		// Task 2:
		System.out.print("Enter your current balance: ");
		int currBal = sc.nextInt();
		System.out.println("1. Check Balance");
        System.out.println("2. Withdraw");
        System.out.println("3. Deposit");

        System.out.print("Enter your choice (1-3): ");
        int choice = sc.nextInt();
        switch(choice)
        {
        case 1:
        	System.out.println("Your current balance is: $" + currBal);
            break;
        case 2:
        	System.out.print("Enter the amount to withdraw: $");
            double withdrawAmount = sc.nextDouble();

            if (withdrawAmount <= currBal) {
                if (withdrawAmount % 100 == 0 || withdrawAmount % 500 == 0) {
                    currBal -= withdrawAmount;
                    System.out.println("Withdrawal successful. Remaining balance: $" + currBal);
                } else {
                    System.out.println("Withdrawal amount must be in multiples of 100 or 500.");
                }
            } else {
                System.out.println("Insufficient funds. Withdrawal failed.");
            }
            break;
        case 3:
        	System.out.print("Enter the amount to deposit: $");
            double depositAmount = sc.nextDouble();

            if (depositAmount > 0) {
                currBal += depositAmount;
                System.out.println("Deposit successful. Updated balance: $" + currBal);
            } else {
                System.out.println("Invalid deposit amount. Please enter a positive value.");
            }
            break;
        default:
            System.out.println("Invalid choice. Please enter a number between 1 and 3.");
        }
        
        // Task 3:
        System.out.print("Enter the number of customers: ");
        int noOfCustomers = sc.nextInt();
        
        for(int i = 0; i < noOfCustomers; i++)
        {
        	System.out.println("\nCustomer " + i);
        	
        	System.out.print("Enter initial balance for customer " + i + ": $");
            double initialBalance = sc.nextDouble();
            
            System.out.print("Enter annual interest rate for customer " + i + " (%): ");
            double annualInterestRate = sc.nextDouble();
            
            System.out.print("Enter the number of years for customer " + i + ": ");
            int numberOfYears = sc.nextInt();
            
            double rate = 1 + annualInterestRate / 100;
            double futBal = initialBalance * Math.pow(rate, numberOfYears);
            
            System.out.println("Future balance for customer " + i + ": $" + futBal);
        }
        
        // Task 4:
        int[] accountNumbers = {1234, 5678, 9012};
        double[] accountBalances = {1000.00, 2500.50, 500.75};
        boolean isValidAccount = false;
        
        while(!isValidAccount)
        {
        	System.out.println("Enter your account number: ");
        	int enteredAccountNumber = sc.nextInt();
        	int index = -1;
        	
        	for(int i = 0; i < accountNumbers.length; i++)
        	{
        		if(accountNumbers[i] == enteredAccountNumber)
        			index = i;
        	}
        	
        	if(index != -1)
        	{
        		System.out.println("Account balance: $" + accountBalances[index]);
        		isValidAccount = true;
        	}
        	else
        		System.out.println("Invalid account number. Please try again!");
        }
        
        // Task 5:
        System.out.println("Create a password for your bank account: ");
        String pwd = sc.nextLine();
        if(isPasswordValid(pwd))
        {
        	System.out.println("Password is valid.");
        }
        else
        	System.out.print("Invalid password. Please try again");
		sc.close();
	}
	
	private static boolean isPasswordValid(String password)
	{
		if (password.length() < 8) {
            System.out.println("Password must be at least 8 characters long.");
            return false;
        }

        // Check for at least one uppercase letter
        if (!containsUppercaseLetter(password)) {
            System.out.println("Password must contain at least one uppercase letter.");
            return false;
        }

        // Check for at least one digit
        if (!containsDigit(password)) {
            System.out.println("Password must contain at least one digit.");
            return false;
        }

        // Password is valid if it passes all checks
        return true;
	}

	private static boolean containsDigit(String password) {
		// TODO Auto-generated method stub
		for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                return true;
            }
        }
		return false;
	}

	private static boolean containsUppercaseLetter(String password) {
		// TODO Auto-generated method stub
		for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
		return false;
	}
	

}
