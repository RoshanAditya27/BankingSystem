package com.banking.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.banking.entity.Transaction;
import com.banking.util.DBConn;

public class TransactionsDao {
	Connection connection;
	Statement statement;
	PreparedStatement ps;
	ResultSet rs;
	public void addTransaction(Transaction transaction, long accountNumber) {
		// TODO Auto-generated method stub
		try {
			connection= DBConn.getDBConn();
			ps=connection.prepareStatement("insert into transactions values(?,?,?,?,?)");
			ps.setInt(1, (int) accountNumber);
			ps.setString(2, transaction.getDescription());
			ps.setDate(3, transaction.getDateTime());
			ps.setString(4, transaction.getTransactionType());
			ps.setFloat(5, transaction.getTransactionAmount());
			int noofrows = ps.executeUpdate();
			System.out.println(noofrows + " inserted successfully !!!");
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
	}
	public void viewTransactionBetweenDates(long accountNumber, Date fromDate, Date toDate) {
		try {
			connection = DBConn.getDBConn();
			ps = connection.prepareStatement("select * from transactions where account_number = ? and DateandTime between ? and ?");
			ps.setInt(1, (int) accountNumber);
			ps.setDate(2, fromDate);
			ps.setDate(3, toDate);
			rs = ps.executeQuery();
			while(rs.next())
			{
				int account_number = rs.getInt("account_number");
                String description = rs.getString("description");
                Date transactionDate = rs.getDate("DateandTime");
                String transaction_type = rs.getString("transaction_type");
                float transaction_amount = rs.getFloat("transaction_amount");
                String transactionDetails = "Account number: " + account_number +
                        ", Description: " + description + ", Transaction date: " + transactionDate
                        + ", Transaction type: " + transaction_type + ", Transaction amount: " + transaction_amount;
                System.out.println(transactionDetails);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
