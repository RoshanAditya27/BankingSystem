package com.banking.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {
	static Connection con;
	public static Connection getDBConn()
	{
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/fun", "root", "Casious#2002");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
	}
	public static void main(String[] args) {
		System.out.println(getDBConn());
	}

}
