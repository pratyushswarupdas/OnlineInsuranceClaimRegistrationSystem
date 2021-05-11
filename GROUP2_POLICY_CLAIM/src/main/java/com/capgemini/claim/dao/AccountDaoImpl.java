package com.capgemini.claim.dao;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;

import com.capgemini.claim.bean.Account;
import com.capgemini.claim.customexp.CustomException;
import com.capgemini.jpautil.JPAUtil;

public class AccountDaoImpl implements AccountDao 
{
	Logger myLogger =  Logger.getLogger(AccountDaoImpl.class.getName());
	
	private EntityManager em = JPAUtil.getEntityManager();

		public void createAccount(Account a) throws CustomException
		{
		
			em.getTransaction().begin();
			em.persist(a);
			em.getTransaction().commit();
			myLogger.info("Account Successfully Created for: "+a);
			System.out.println("Account created");
		}
	

}
