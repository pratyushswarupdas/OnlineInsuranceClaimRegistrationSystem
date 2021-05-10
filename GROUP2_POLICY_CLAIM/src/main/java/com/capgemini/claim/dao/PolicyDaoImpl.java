package com.capgemini.claim.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import com.capgemini.claim.bean.Policy;
import com.capgemini.claim.bean.PolicyDetails;
import com.capgemini.claim.bean.User;
import com.capgemini.claim.service.IAccountService;
import com.capgemini.claim.service.ImplAccountService;
import com.capgemini.jpautil.JPAUtil;

public class PolicyDaoImpl implements PolicyDao {
	
	private EntityManager em = JPAUtil.getEntityManager();
	IAccountService accService=new ImplAccountService();
	Scanner sc=new Scanner(System.in);
	
	
	@Override
	public void setPolicy(Policy p) {
		
	
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();

}
	@Override
	public void setPolicyDetails(PolicyDetails pd,Policy p)
	{
		
		 em.getTransaction().begin();
		 pd.setPolicyNumber(p.getPolicyNumber());
		 em.persist(pd);
		 em.getTransaction().commit();
		 	
		
	}
	
	
	
	@Override
	public List<Policy> viewPolicy(User user) 
	{		
		List<Policy> allPolicyList=new ArrayList<>();
		IAccountService accService1=new ImplAccountService();
		List<Long> policyList=accService1.getPolicyByInsuredName(user.getUserName());

		switch(user.getRoleCode())
		{
		
		case 1:
				
				for(Long pnumber : policyList)
				{
					String qStr = "SELECT p FROM Policy p WHERE p.policyNumber=:pnumber";
					TypedQuery<Policy> query = em.createQuery(qStr, Policy.class);
					query.setParameter("pnumber", pnumber); 
					allPolicyList=query.getResultList();
				}
			break;
			
			
			
			
		case 2://view all for Claim Handler
				
				for(Long pnumber : policyList)
				{
					String qStr = "SELECT p FROM Policy p WHERE p.policyNumber=:pnumber";
					TypedQuery<Policy> query = em.createQuery(qStr, Policy.class);
					query.setParameter("pnumber", pnumber); 
					allPolicyList=query.getResultList();
				}
				break;
			
		case 3:
				//view all for Claim Adjuster
				String qStr = "SELECT p FROM Policy p";
				
				TypedQuery<Policy> query = em.createQuery(qStr, Policy.class);
				allPolicyList=query.getResultList();
				break;

		}
		return allPolicyList;
		
		
	}
	

}
