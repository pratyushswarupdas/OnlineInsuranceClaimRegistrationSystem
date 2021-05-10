package com.capgemini.claim.dao;

import com.capgemini.claim.bean.User;
import com.capgemini.claim.customexp.CustomException;

public interface UserDao {

	
	public abstract User loginUser(String username,String password) throws CustomException;
	public abstract void profileCreation(User user);
}
