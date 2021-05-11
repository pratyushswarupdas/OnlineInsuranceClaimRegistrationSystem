package com.capgemini.tests;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;

import org.junit.Test;

import com.capgemini.claim.bean.User;
import com.capgemini.claim.customexp.CustomException;
import com.capgemini.claim.dao.UserDao;
import com.capgemini.claim.dao.UserDaoImpl;
import com.capgemini.claim.service.IUserService;
import com.capgemini.claim.service.ImplUserService;
import com.capgemini.jpautil.JPAUtil;

public class UserTest {

	@Test
	public void loginTest() throws CustomException{
				
		UserDao userDao = new UserDaoImpl();	
		
		//Insert your username and pass
		User user = userDao.loginUser("Abhi", "pass");

		String actualName = user.getUserName();
		String actualPass = user.getPassword();
		
		String expectedName = "Abhi";
		String expectedPass = "pass";
		
		assertEquals(expectedName,actualName);
		assertEquals(expectedPass,actualPass);
	}
	

	@Test
	public void profileCreationTest() throws CustomException {

		IUserService userService = new ImplUserService();
		
		User user = new User();
		
		//Take unique user (Creating New User)
		user.setUserName("Lancelot");
		user.setPassword("pass");
		user.setRoleCode(2);
		
		userService.profileCreation(user);
		
	    EntityManager em = JPAUtil.getEntityManager();
		assertTrue(em.contains(user));
	}
	
}
