package com.capgemini.claim.dao;

import javax.persistence.EntityManager;


import com.capgemini.claim.bean.Account;
import com.capgemini.claim.customexp.CustomException;
import com.capgemini.jpautil.JPAUtil;

public class AccountDaoImpl implements AccountDao {
	private EntityManager em = JPAUtil.getEntityManager();

		public void createAccount(Account a) throws CustomException
		{
		
			em.getTransaction().begin();
			em.persist(a);
			em.getTransaction().commit();
			System.out.println("Account created");
		}
	

}
