package com.capgemini.claim.service;

import com.capgemini.claim.bean.User;

public interface IUserService {


	
	public abstract User loginUser(String username,String password);
	public abstract String profileCreation(User user);
}
