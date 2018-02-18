package org.com.java.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	public static Connection getConnection() {
		Connection con=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/india?autoReconnect=true&useSSL=false","root","Pri@uncc792");
		} catch (SQLException e) {
			System.err.println("ERROR : Cannot create the connection.");
			System.err.println("ERROR : \nSQL Error Code : "+e.getErrorCode()+" SQL State : "+e.getSQLState());
		}
		return con;
	}  
	
	
	public static void closeConnection(Connection con){
		try {
			con.close();
		} catch (SQLException e) {
			System.err.println("ERROR : Cannot close the connection.");
			System.err.println("ERROR : \nSQL Error Code : "+e.getErrorCode()+" SQL State : "+e.getSQLState());
		}
	}
}



