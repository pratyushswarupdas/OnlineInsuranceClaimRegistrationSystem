package com.capgemini.claim.service;

import com.capgemini.claim.bean.User;
import com.capgemini.claim.customexp.CustomException;

public interface IUserService {

	public abstract User loginUser(String username,String password)throws CustomException;
	public abstract void profileCreation(User user)throws CustomException;
}
