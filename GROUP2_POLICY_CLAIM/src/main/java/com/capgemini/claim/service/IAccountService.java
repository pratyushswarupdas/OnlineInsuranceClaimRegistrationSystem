package com.capgemini.claim.service;

import java.util.List;

import com.capgemini.claim.bean.Account;
import com.capgemini.claim.bean.User;
import com.capgemini.claim.customexp.CustomException;

public interface IAccountService {
	
	public abstract List<Long> getPolicyByUserName(String username);
	public abstract void createAccount(User user,Account a)throws CustomException;
	public abstract List<Long> getPolicyByInsuredName(String username);

}
