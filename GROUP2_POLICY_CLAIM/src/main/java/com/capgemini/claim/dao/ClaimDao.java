package com.capgemini.claim.dao;

import com.capgemini.claim.bean.Claim;
import com.capgemini.claim.bean.User;

public interface ClaimDao {

	public abstract void claimCreation(User user);
	
}
