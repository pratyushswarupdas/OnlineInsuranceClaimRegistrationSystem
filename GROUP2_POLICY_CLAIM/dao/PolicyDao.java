package com.capgemini.claim.dao;

import com.capgemini.claim.bean.User;

public interface PolicyDao {
	
	public abstract void viewPolicy(User user);
	public abstract void createPolicy(User user);
	


}
