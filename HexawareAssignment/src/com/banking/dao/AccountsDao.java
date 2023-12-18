package com.banking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.banking.entity.Account;
import com.banking.util.DBConn;

public class AccountsDao {
	Connection connection;
	Statement statement;
	PreparedStatement ps;
	ResultSet rs;
	public void addAccount(Account account) {
		// TODO Auto-generated method stub
		try {
			connection= DBConn.getDBConn();
			ps=connection.prepareStatement("insert into accounts values(?,?,?)");
			ps.setInt(1, (int) account.getAccountNumber());
			ps.setString(2, account.getAccountType());
			ps.setFloat(3, account.getAccountBalance());
			int noofrows = ps.executeUpdate();
			System.out.println(noofrows + " inserted successfully !!!");
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
	}
	
	public float getAccountBalance(long accountNumber) {
		float accountBalance = 0;
		try {
			connection= DBConn.getDBConn();
			
			int accNo = (int) accountNumber;
			ps=connection.prepareStatement("select * from accounts where account_number = ?");
			ps.setInt(1, accNo);
			rs = ps.executeQuery();
			while(rs.next())
			{
				accountBalance = rs.getFloat("account_balance");
			}
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		return accountBalance;
	}

	public float updateAccount(long accountNumber, float amount) {
		float newBal = 0;
		try {
			connection = DBConn.getDBConn();
			int accNo = (int) accountNumber;
			
			ps = connection.prepareStatement("update accounts set account_balance = account_balance + ? where account_number = ?");
			ps.setFloat(1, amount);
			ps.setInt(2, accNo);
			int noofrows = ps.executeUpdate();
			System.out.println("Deposited!");
			
			ps = connection.prepareStatement("select * from accounts where account_number = ?");
			ps.setInt(1, accNo);
			rs = ps.executeQuery();
			while(rs.next())
				newBal = rs.getFloat("account_balance");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return newBal;
	}

	public float updateWithdraw(long accountNumber, float amount) {
		float newBal = 0;
		try {
			connection = DBConn.getDBConn();
			int accNo = (int) accountNumber;
			
			ps = connection.prepareStatement("update accounts set account_balance = account_balance - ? where account_number = ?");
			ps.setFloat(1, amount);
			ps.setInt(2, accNo);
			int noofrows = ps.executeUpdate();
			System.out.println("Deposited!");
			
			ps = connection.prepareStatement("select * from accounts where account_number = ?");
			ps.setInt(1, accNo);
			rs = ps.executeQuery();
			while(rs.next())
				newBal = rs.getFloat("account_balance");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return newBal;
	}

	public void viewAccount(long accountNumber) {
		try {
			connection = DBConn.getDBConn();
			ps = connection.prepareStatement("select * from accounts where account_number = ?");
			ps.setInt(1, (int) accountNumber);
			rs = ps.executeQuery();

            while (rs.next()) {
                int account_number = rs.getInt("account_number");
                String account_type = rs.getString("account_type");
                float account_balance = rs.getFloat("account_balance");
                String accountDetails = "Account number: " + account_number +
                        ", account_type: " + account_type + ", account_balance: " + account_balance;
                System.out.println(accountDetails);
            }
		}catch (SQLException e) {
            e.printStackTrace();
        }
		
	}

}
