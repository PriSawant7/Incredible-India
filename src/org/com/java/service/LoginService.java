package org.com.java.service;

import java.util.HashMap;

import org.com.java.dto.User;

public class LoginService {
	
	HashMap<String,String> users = new HashMap<String, String>();
	
	
	public LoginService() {
		
		
	/*	users.put("priyanka", "pri");
		users.put("vin", "vin");
		users.put("shri", "shri");
*/
		
	}
	
	public boolean authenticate(String userId, String password)
	{
		if(userId == null ||password == null)
			return false;
		else
			return true;
		
	}
	
	public User getUserDetails(String userId)
	{
		User user = new User();
		user.setUsername(users.get(userId));
		return user;
	}

}
