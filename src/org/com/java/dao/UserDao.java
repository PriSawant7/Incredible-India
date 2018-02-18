package org.com.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.com.java.database.DBConnection;
import org.com.java.dto.User;

public class UserDao {
	
	
	public void checkUserName(User user) {
Connection conn=DBConnection.getConnection();
		
		PreparedStatement ps = null;

		System.out.println("I am at insert");
		// TODO Auto-generated method stub

       String query
               = "SELECT count(*) FROM User where userName= "+user.getUsername();
       try {
           ps = conn.prepareStatement(query);
           int count = ps.executeUpdate();
           if(count==1)
           
        	   System.out.println("Username exist");
        	   
           else
        	   System.out.println("continue");
           
           
       } catch (SQLException e) {
           System.out.println(e);
       } finally {
       	DBConnection.closeConnection(conn);
       }

		
		
		
		
	}
	public int insertUser(User user) {
		Connection conn=DBConnection.getConnection();
		
		PreparedStatement ps = null;

		System.out.println("I am at insert");
		// TODO Auto-generated method stub

       String query
               = "INSERT INTO User (firstName, lastName, userName, password1, email) "
               + "VALUES (?, ?, ?,?, ?)";
       try {
           ps = conn.prepareStatement(query);
           System.out.println("hi"+user.getFirstName());
           ps.setString(1, user.getFirstName());
           ps.setString(2, user.getLastName());
           ps.setString(3, user.getUsername());
           ps.setString(4, user.getPassword());
           ps.setString(5, user.getEmail());

           
           return ps.executeUpdate();
       } catch (SQLException e) {
           System.out.println(e);
           return 0;
       } finally {
       	DBConnection.closeConnection(conn);
       }
	}


}
