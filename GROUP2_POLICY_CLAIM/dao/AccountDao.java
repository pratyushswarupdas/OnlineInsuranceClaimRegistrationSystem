package com.capgemini.claim.dao;



import com.capgemini.claim.bean.Account;
import com.capgemini.claim.customexp.CustomException;


public interface AccountDao {


//	public abstract void addAccount(Account account);
	public abstract void createAccount(Account a) throws CustomException;


}
