package com.capgemini.claim.service;

import javax.persistence.EntityManager;

import com.capgemini.claim.bean.User;
import com.capgemini.claim.customexp.CustomException;
import com.capgemini.claim.dao.UserDao;
import com.capgemini.claim.dao.UserDaoImpl;
import com.capgemini.jpautil.JPAUtil;

public class ImplUserService implements IUserService {
	UserDao userDao=new UserDaoImpl();
	private EntityManager em = JPAUtil.getEntityManager();
	
	public User loginUser(String username,String password)throws CustomException
	{
	User user_1=userDao.loginUser(username, password);
	return user_1;
	}
		

	//Profile Creation
	@Override
	public String profileCreation(User user) {
		
		String userName = user.getUserName();
		
		User u = em.find(User.class, userName);
		
		if(u == null) 
		{
			
			userDao.profileCreation(user);
		
					
			return "User Created";
		}
		else
		{
			
		
			return "User Already Exist";
		}
		
	}

}
