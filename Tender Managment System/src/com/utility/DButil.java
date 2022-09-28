package com.utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class DButil {
	
	public static Connection provideConnection() {
		
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String url = "jdbc:mysql://localhost:3306/Tendermangment";
		
		try {
			 conn = DriverManager.getConnection(url, "root", "root");
			 
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		
		return conn;
	}
	

}
