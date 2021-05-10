package com.capgemini.claim.dao;

import com.capgemini.claim.bean.User;

public interface UserDao {

	
	public abstract User loginUser(String username,String password);
	public abstract void profileCreation(User user);
}
