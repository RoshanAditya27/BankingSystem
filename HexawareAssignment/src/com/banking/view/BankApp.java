package com.banking.view;

import java.sql.Date;
import java.util.Scanner;

//import com.banking.controller.BankTask10;
//import com.banking.entity.AccountTask10;
import com.banking.entity.Customer;
import com.banking.controller.IBankServiceProvider;
import com.banking.controller.BankServiceProviderImpl;

public class BankApp {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		IBankServiceProvider bank = new BankServiceProviderImpl("MyBank", "123 Main St.");
		while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Create Account");
            System.out.println("2. Get Account Balance");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Transfer");
            System.out.println("6. Get Account Details");
            System.out.println("7. Get Transaction Details");
            System.out.println("8. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    // Create Account
                    System.out.print("Enter Customer First Name: ");
                    String firstName = scanner.nextLine();
                    System.out.print("Enter Customer Last Name: ");
                    String lastName = scanner.nextLine();
                    System.out.print("Enter Customer Email Address: ");
                    String emailAddress = scanner.nextLine();
                    // Add validation for a valid email address
                    System.out.print("Enter Customer Phone Number: ");
                    String phoneNumber = scanner.nextLine();
                    // Add validation for a 10-digit phone number
                    System.out.print("Enter Customer Address: ");
                    String address = scanner.nextLine();
                    System.out.println("Enter your customer ID: ");
                    int customer_id = scanner.nextInt();

                    Customer customer = new Customer(customer_id, firstName, lastName, emailAddress, phoneNumber, address);
                    scanner.nextLine();
                    System.out.print("Choose Account Type (Savings/Current): ");
                    String accType = scanner.nextLine();

                    System.out.print("Enter Initial Balance: ");
                    float balance = scanner.nextFloat();

                    bank.createAccount(customer, accType, balance);
                    break;

                case 2:
                    // Get Account Balance
                    System.out.print("Enter Account Number: ");
                    long accNoGetBalance = scanner.nextLong();
                    float accountBalance = bank.getAccountBalance(accNoGetBalance);
                    if (accountBalance != -1) {
                        System.out.println("Current Balance: $" + accountBalance);
                    }
                    break;

                case 3:
                    // Deposit
                    System.out.print("Enter Account Number: ");
                    long accNoDeposit = scanner.nextLong();
                    System.out.print("Enter Deposit Amount: ");
                    float depositAmount = scanner.nextFloat();
                    float newBalanceDeposit = bank.deposit(accNoDeposit, depositAmount);
                    if (newBalanceDeposit != -1) {
                        System.out.println("New Balance: $" + newBalanceDeposit);
                    }
                    break;

                case 4:
                    // Withdraw
                    System.out.print("Enter Account Number: ");
                    long accNoWithdraw = scanner.nextLong();
                    System.out.print("Enter Withdrawal Amount: ");
                    float withdrawAmount = scanner.nextFloat();
                    float newBalanceWithdraw = bank.withdraw(accNoWithdraw, withdrawAmount);
                    if (newBalanceWithdraw != -1) {
                        System.out.println("New Balance: $" + newBalanceWithdraw);
                    }
                    break;

                case 5:
                    // Transfer
                    System.out.print("Enter From Account Number: ");
                    long fromAccNo = scanner.nextLong();
                    System.out.print("Enter To Account Number: ");
                    long toAccNo = scanner.nextLong();
                    System.out.print("Enter Transfer Amount: ");
                    float transferAmount = scanner.nextFloat();
                    bank.transfer(fromAccNo, toAccNo, transferAmount);
                    break;

                case 6:
                    // Get Account Details
                    System.out.print("Enter Account Number: ");
                    long accNoGetDetails = scanner.nextLong();
                    bank.getAccountDetails(accNoGetDetails);
                    break;

                case 7:
                    // Get Transaction Details
                    System.out.println("Enter Account Number: ");
                    long accNoGetTransactionDetails = scanner.nextLong();
                    scanner.nextLine();
                    System.out.println("Enter From Date(yyyy-MM-dd): ");
                    String strFromDate = scanner.nextLine();
                    Date fromDate = Date.valueOf(strFromDate);
                    System.out.println("Enter To Date(yyyy-MM-dd): ");
                    String strToDate = scanner.nextLine();
                    Date toDate = Date.valueOf(strToDate);
                    bank.getTransactions(accNoGetTransactionDetails, fromDate, toDate);
                    break;
                case 8:
                	// Exit
                	System.out.println("Exiting the application. Good Bye!");
                	scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
            }
        }
		
	}
}
