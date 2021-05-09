	package com.capgemini.claim.user;

import com.capgemini.claim.bean.User;
import com.capgemini.claim.dao.AccountDao;
import com.capgemini.claim.dao.AccountDaoImpl;
import com.capgemini.claim.dao.PolicyDao;
import com.capgemini.claim.dao.PolicyDaoImpl;
import com.capgemini.claim.dao.UserDao;
import com.capgemini.claim.dao.UserDaoImpl;

public class UserTest {

	public static void main(String[] args) {
		UserDao userDao=new UserDaoImpl();
		//AccountDao accdao=new AccountDaoImpl();
		
		//createAccount -- done in dao
		//createPolicy - done in dao
		
		//claimCreation
		//claimDetails - yet to be copied from whatsapp
		User user=userDao.loginUser("Rock", "test123");
		PolicyDao pdao=new PolicyDaoImpl();
		pdao.createPolicy(user);
		System.exit(0);
		
		
	}

}
//sent