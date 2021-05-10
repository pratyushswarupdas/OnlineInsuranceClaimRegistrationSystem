package com.capgemini.claim.dao;

import javax.persistence.EntityManager;

import com.capgemini.claim.bean.User;
import com.capgemini.claim.customexp.CustomException;
import com.capgemini.jpautil.JPAUtil;

public class UserDaoImpl implements UserDao{

	private EntityManager em = JPAUtil.getEntityManager();

	//Login
		@Override
		public User loginUser(String username, String password) throws CustomException
		{	
			//em.getTransaction().begin();
		
			User user=em.find(User.class, username);
			if(user!=null)
			{
				if(user.getPassword().equals(password))
				{
					return user;
				}
				else
				{
					throw new CustomException("Invalid Credentials");
				}
			}
			else
			{
				throw new CustomException("User doesnt exist");
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
