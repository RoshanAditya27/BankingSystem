package com.banking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.banking.entity.Customer;
import com.banking.util.DBConn;

public class CustomersDao {
	Connection connection;
	Statement statement;
	PreparedStatement ps;
	ResultSet rs;
	public void addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		try {
			connection= DBConn.getDBConn();
			
			if(connection != null) {
			ps=connection.prepareStatement("insert into customers values(?,?,?,?,?,?)");
			ps.setInt(1, customer.getCustomer_id());
			ps.setString(2, customer.getFirst_name());
			ps.setString(3, customer.getLast_name());
			ps.setString(4, customer.getEmail_address());
			ps.setString(5, customer.getPhone_number());
			ps.setString(6, customer.getAddress());
			int noofrows = ps.executeUpdate();
			System.out.println(noofrows + " inserted successfully !!!");
			} else {
				System.out.println("Failed to establish connection");
			}
		} catch (SQLException e) {
		
			e.printStackTrace();
		    System.out.println("SQLException: " + e.getMessage());
		    System.out.println("SQLState: " + e.getSQLState());
		    System.out.println("VendorError: " + e.getErrorCode());
		}
	}

}
