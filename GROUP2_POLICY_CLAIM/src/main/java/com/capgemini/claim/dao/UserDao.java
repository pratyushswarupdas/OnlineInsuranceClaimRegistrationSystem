package com.capgemini.claim.dao;

import com.capgemini.claim.bean.User;

public interface UserDao {

	public abstract User getUserById(String userid);
	public abstract User loginUser(String username,String password);
	public abstract String profileCreation(User user);
}
