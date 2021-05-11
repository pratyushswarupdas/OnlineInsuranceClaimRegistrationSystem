package com.capgemini.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.capgemini.claim.bean.Account;
import com.capgemini.claim.bean.User;
import com.capgemini.claim.customexp.CustomException;

import com.capgemini.claim.dao.UserDao;
import com.capgemini.claim.dao.UserDaoImpl;
import com.capgemini.claim.service.IAccountService;
import com.capgemini.claim.service.ImplAccountService;

public class AccountTest {
	
	@Test
	public void createAccountTest() throws CustomException{
		UserDao userDao = new UserDaoImpl();
		IAccountService accountService = new ImplAccountService();
		
		Account account = new Account();
		User user = userDao.loginUser("Abhi", "pass");
		
		account.setUserName(user.getUserName());
		
		//Set only unique number
		account.setAccountNumber(203982);
		
		//Before Setting below name check if it is not already present in accountTable.
		account.setInsuredName("Paquito");

		accountService.createAccount(user,account);
		
		Long accNo = account.getAccountNumber();
		assertNotNull(accNo);

	}
}
