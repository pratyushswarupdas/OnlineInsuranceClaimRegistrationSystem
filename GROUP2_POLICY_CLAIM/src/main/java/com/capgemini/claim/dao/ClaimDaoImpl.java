package com.capgemini.claim.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import com.capgemini.claim.bean.Claim;
import com.capgemini.claim.bean.User;
import com.capgemini.claim.customexp.CustomException;
import com.capgemini.claim.service.IAccountService;
import com.capgemini.claim.service.ImplAccountService;
import com.capgemini.jpautil.JPAUtil;

public class ClaimDaoImpl implements ClaimDao {

	private EntityManager em = JPAUtil.getEntityManager();

	@Override
	public void claimCreation(Claim claim) throws CustomException
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
			  	//Insured
			  	policyList=accService.getPolicyByInsuredName(user.getUserName());
			  	
			  	for(Long plList : policyList)
			  	{
			  			
			  		String qStr = "SELECT c FROM Claim c WHERE c.policyNumber=:pnumber";
					TypedQuery<Claim> query = em.createQuery(qStr, Claim.class);
					query.setParameter("pnumber", plList); 
					claimList=query.getResultList();
			  		
			  	}
			  	break;
			  	
	 
	  
		  case 2: //Claim Handler
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
			  	//Claim Adjuster
			  	String qStr = "SELECT c FROM Claim c";
			  	TypedQuery<Claim> query = em.createQuery(qStr, Claim.class);
			  	claimList=query.getResultList();
			  	break;
		  
		  }
		  return claimList;
	  
	  }
	 

}
