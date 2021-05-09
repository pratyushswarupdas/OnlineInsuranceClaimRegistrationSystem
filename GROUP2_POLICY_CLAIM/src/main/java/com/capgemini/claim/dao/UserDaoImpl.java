package com.capgemini.claim.dao;

import javax.persistence.EntityManager;

import com.capgemini.claim.bean.User;
import com.capgemini.jpautil.JPAUtil;

public class UserDaoImpl implements UserDao{

	private EntityManager em = JPAUtil.getEntityManager();

	@Override
	public User getUserById(String userid) {
		em = JPAUtil.getEntityManager();
		User u1 =  em.find(User.class, userid);
		
		return u1;
	}

	//Login
	@Override
	public User loginUser(String username, String password) 
	{	/*
			Logic
		 if username and password found 
		 	return User
		 else
		 	return null
		  
		  */
		em.getTransaction().begin();
	
		User user=em.find(User.class, username);
		if(user!=null)
		{
			if(user.getPassword().equals(password))
			{
				//em.persist(user);
				em.getTransaction().commit();
			//	em.close();
				return user;
			}
			else
			{
				//em.persist(user);
				em.getTransaction().commit();
			//	em.close();
				return null;
				
			}
		}
		else
		{
			em.getTransaction().commit();
			//em.close();
			return null;
		}

	}
	
	//Profile Creation
	@Override
	public String profileCreation(User user) {
		
		String userName = user.getUserName();
		em.getTransaction().begin();
		User u = em.find(User.class, userName);
		
		if(u == null) 
		{
			
			em.persist(user);
			em.getTransaction().commit();
		//	em.close();
					
			return "User Created";
		}
		else
		{
			em.getTransaction().commit();
		//	em.close();
			return "User Already Exist";
		}
		
	}
	
	
	
	
	
}
