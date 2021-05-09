package com.capgemini.claim.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.capgemini.claim.bean.Account;
import com.capgemini.claim.bean.Claim;
import com.capgemini.claim.bean.Policy;
import com.capgemini.claim.bean.PolicyDetails;
import com.capgemini.claim.bean.User;
import com.capgemini.jpautil.JPAUtil;

public class PolicyDaoImpl implements PolicyDao {
	
	private EntityManager em = JPAUtil.getEntityManager();
	AccountDao accDao=new AccountDaoImpl();
	Scanner sc=new Scanner(System.in);
	
	
	@Override
	public void createPolicy(User user) {
		long bankAccNo;
		Account checkBankAccNo;
		double premiumAmount;
		int questionId;
		
		
		
		Policy p=new Policy();
		Policy check=new Policy();
		PolicyDetails pd=new PolicyDetails();
		
		System.out.println("Enter premium amount");
		premiumAmount=sc.nextDouble();
		System.out.println("Enter account no: ");
		bankAccNo=sc.nextLong();
		System.out.println("Enter Vehicle type 1 for two wheeler, 2 for HatchBack, 3 for SUV");
		questionId=sc.nextInt();
		
	
		
	 checkBankAccNo = em.find(Account.class,bankAccNo);
	 System.out.println(checkBankAccNo);
	 if(checkBankAccNo.getAccountNumber()==bankAccNo)
	 { 
	 	
	 
		if(checkBankAccNo.getUserName().equals(user.getUserName()))
		{	
			 em.getTransaction().begin();
			 p.setAccountNumber(bankAccNo);
			 p.setPolicyPremium(premiumAmount);
			 em.persist(p);
			 em.getTransaction().commit();
		}

	 }
	 em.getTransaction().begin();
	 pd.setPolicyNumber(p.getPolicyNumber());
	 pd.setQuestionId(questionId);
	 em.persist(pd);
	 em.getTransaction().commit();
	 	
}
	
	
	
	@Override
	public void viewPolicy(User user) {
		// TODO Auto-generated method stub
		
		List<Policy> allPolicyList=new ArrayList<>();
		AccountDao accdao=new AccountDaoImpl();
		List<Long> policyList=accdao.getPolicyByInsuredName(user.getUserName());

		switch(user.getRoleCode())
		{
		
		case 1:
				
				for(Long pnumber : policyList)
				{
					String qStr = "SELECT p FROM Policy p WHERE p.policyNumber=:pnumber";
					TypedQuery<Policy> query = em.createQuery(qStr, Policy.class);
					query.setParameter("pnumber", pnumber); 
					allPolicyList=query.getResultList();
					System.out.println("\n"+allPolicyList);	  
				}
			System.out.println("\n");
			break;
			
			
			
			
		case 2://view all for agents
				
				for(Long pnumber : policyList)
				{
					String qStr = "SELECT p FROM Policy p WHERE p.policyNumber=:pnumber";
					TypedQuery<Policy> query = em.createQuery(qStr, Policy.class);
					query.setParameter("pnumber", pnumber); 
					allPolicyList=query.getResultList();
					System.out.println("\n"+allPolicyList);	  
				}
				System.out.println("\n");
				break;
			
		case 3:
				//view all for admin
				
				String qStr = "SELECT p FROM Policy p";
				
				TypedQuery<Policy> query = em.createQuery(qStr, Policy.class);
				allPolicyList=query.getResultList();
				System.out.print("\n"+allPolicyList);
				break;

		
		}
		
		
	}
	

}
