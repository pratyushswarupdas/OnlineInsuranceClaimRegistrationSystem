package com.capgemini.claim.service;

import java.util.List;

import com.capgemini.claim.bean.User;

public interface IAccountService {
	
	public abstract List<Long> getPolicyByUserName(String username);

//	public abstract void addAccount(Account account);
	public abstract void createAccount(User user);

	public abstract List<Long> getPolicyByInsuredName(String username);

}
