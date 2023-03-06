package com.bptn.utils;

//Paste the code file content here from Eclipse

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FeedAppClass {
	
	static String username = "postgres";
	static String password = "pg123";
	static String dbName = "feedApp";
	static String port = "5432";
	
	static String dbUrl = "localhost";

	public static void main(String[] args) {		
	
		ResultSet rs = null;
		String conStr = "jdbc:postgresql://" + dbUrl + ":" + port + "/" + dbName;
		
				
		String sql = "INSERT INTO \"Userid\" (\"username\",\"name\", \"," +
	             "\"phoneNumber\", \"userPassword\") VALUES (?,?,?,?,?)";
		
					
		try ( Connection conn = DriverManager.getConnection(conStr,username,password); 
					  PreparedStatement stmt = conn.prepareStatement(sql);) {
			
			stmt.setString(1, "Abdi");
			stmt.setString(2,"Abdi Shakur");
			stmt.setString(3, "Abdi@gmail.com");
			stmt.setInt(4, 6472423);
			stmt.setString(5, "shakur");
			
			int num = stmt.executeUpdate();
			
			System.out.println("Rows inserted: " + num);
			
		}catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			if (rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace(); 
				}
			}
		}
		

	}

}