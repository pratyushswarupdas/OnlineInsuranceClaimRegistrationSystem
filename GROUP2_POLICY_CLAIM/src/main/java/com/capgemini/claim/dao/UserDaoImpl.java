package com.capgemini.claim.dao;

import javax.persistence.EntityManager;

import com.capgemini.claim.bean.User;
import com.capgemini.jpautil.JPAUtil;

public class UserDaoImpl implements UserDao{

	private EntityManager em = JPAUtil.getEntityManager();

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
		public void profileCreation(User user) {
			
			
			em.getTransaction().begin();
			em.persist(user);
			em.getTransaction().commit();
		
			
			
		}


	
	
	
	
}
