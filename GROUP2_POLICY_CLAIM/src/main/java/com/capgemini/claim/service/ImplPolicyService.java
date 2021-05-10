package com.capgemini.claim.service;

import java.util.List;

import javax.persistence.EntityManager;

import com.capgemini.claim.bean.Account;
import com.capgemini.claim.bean.Policy;
import com.capgemini.claim.bean.PolicyDetails;
import com.capgemini.claim.bean.User;
import com.capgemini.claim.dao.PolicyDao;
import com.capgemini.claim.dao.PolicyDaoImpl;
import com.capgemini.jpautil.JPAUtil;

public class ImplPolicyService implements IPolicyService {
	private EntityManager em = JPAUtil.getEntityManager();
	private PolicyDao policyDao=new PolicyDaoImpl();
	private Policy p=new Policy();
	private PolicyDetails pd=new PolicyDetails();
	@Override
	public void createPolicy(User user,long bankAccNo,double premiumAmount,int questionId)
	{
		 	
		Account checkBankAccNo = em.find(Account.class,bankAccNo);
		 
		switch (user.getRoleCode())
		{
		case 2:
				if(checkBankAccNo.getAccountNumber()==bankAccNo)
				 { 
				 	
				 
					if(checkBankAccNo.getUserName().equals(user.getUserName()))
					{	
						 
						 p.setAccountNumber(bankAccNo);
						 p.setPolicyPremium(premiumAmount);
						 policyDao.setPolicy(p);
						 pd.setPolicyNumber(p.getPolicyNumber());
						 pd.setQuestionId(questionId);
						 policyDao.setPolicyDetails(pd,p);
						
					}
		
				 }
		case 3:
			if(checkBankAccNo.getAccountNumber()==bankAccNo)
			 { 
			 	
					 p.setAccountNumber(bankAccNo);
					 p.setPolicyPremium(premiumAmount);
					 policyDao.setPolicy(p);
					 pd.setPolicyNumber(p.getPolicyNumber());
					 pd.setQuestionId(questionId);
					 policyDao.setPolicyDetails(pd,p);
				
			 }
	
		}
	 
		
		 	
	}
	@Override
	public List<Policy> viewPolicy(User user) {
		return policyDao.viewPolicy(user);
	}
	
		
	}
	

