package com.capgemini.claim.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.capgemini.claim.bean.Account;
import com.capgemini.claim.bean.Claim;
import com.capgemini.claim.bean.Policy;
import com.capgemini.claim.bean.PolicyDetails;
import com.capgemini.claim.bean.Questions;
import com.capgemini.claim.bean.User;
import com.capgemini.claim.service.IAccountService;
import com.capgemini.claim.service.ImplAccountService;
import com.capgemini.jpautil.JPAUtil;

public class ClaimDaoImpl implements ClaimDao {

	private EntityManager em = JPAUtil.getEntityManager();

	@Override
	public void claimCreation(Claim claim) 
	{
		em.getTransaction().begin();
		em.persist(claim);
		em.getTransaction().commit();
		
		
	}
	
	//view report OR view claim
	
	  public List<Claim> viewReport(User user)throws SQLException
	  {
			
		  IAccountService accService = new ImplAccountService();
		  List<Claim> claimList=new ArrayList<>();
		  List<Long> policyList=new ArrayList<>();
		  switch(user.getRoleCode()) {
	  
		  case 1:
			  	//insureduser//
			  	policyList=accService.getPolicyByInsuredName(user.getUserName());
			  	
			  	for(Long plList : policyList)
			  	{
			  			
			  		String qStr = "SELECT c FROM Claim c WHERE c.policyNumber=:pnumber";
					TypedQuery<Claim> query = em.createQuery(qStr, Claim.class);
					query.setParameter("pnumber", plList); 
					claimList=query.getResultList();
			  		
			  	}
			  	break;
			  	
	 
	  
		  case 2: //agent
			  	policyList=accService.getPolicyByUserName(user.getUserName());
			  	
			  	for(Long plList : policyList)
			  	{
			  			
			  		String qStr = "SELECT c FROM Claim c WHERE c.policyNumber=:pnumber";
					TypedQuery<Claim> query = em.createQuery(qStr, Claim.class);
					query.setParameter("pnumber", plList); 
					claimList=query.getResultList();
			  		
			  	}
			  	break;
	  
		  case 3:
			  	//
			  	String qStr = "SELECT c FROM Claim c";
			  	TypedQuery<Claim> query = em.createQuery(qStr, Claim.class);
			  	claimList=query.getResultList();
			  	break;
		  
		  }
		  return claimList;
	  
	  }
	 

}
