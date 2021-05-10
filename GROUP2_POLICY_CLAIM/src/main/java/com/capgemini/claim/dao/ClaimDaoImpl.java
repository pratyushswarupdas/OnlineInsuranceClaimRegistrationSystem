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
	public void claimCreation(User user) {
	
		long claimAmount = 0;
		Claim claim = new Claim();
		Scanner sc = new Scanner(System.in);
		IAccountService accservice = new ImplAccountService();
		List<Long> allPolicyNumberList=new ArrayList<>();
		Questions q = new Questions();
		PolicyDetails policyDetailslist = new PolicyDetails();
		int qId = 0;
		int answer;
		
		em.getTransaction().begin();

		//Entering and checking for Policy Details
		System.out.println("Enter Policy Number");
		long policyNumber = sc.nextLong();
		claim.setPolicyNumber(policyNumber);
		
		switch(user.getRoleCode())
		{
		case 1:
				//Insured
				if (accservice.getPolicyByInsuredName(user.getUserName()) != null)
				{
					for (Long pnumber : accservice.getPolicyByUserName(user.getUserName())) 
					{
						if (policyNumber == pnumber) 
						{
							//Entering Claim Details
							System.out.println("Please Enter your Claim Reason!");
							String claimReason = sc.next();
							claim.setClaimReason(claimReason);
	
							System.out.println("Please Enter your Accident Location Street!");
							String accidentlocStreet = sc.next();
							claim.setAccidentlocStreet(accidentlocStreet);
	
							System.out.println("Please Enter your Accident City!");
							String accidentCity = sc.next();
							claim.setAccidentCity(accidentCity);
	
							System.out.println("Please Enter your Accident State!");
							String accidentState = sc.next();
							claim.setAccidentState(accidentState);
	
							System.out.println("Please Enter your Accident Zip Code");
							long accidentZip = sc.nextLong();
							claim.setAccidentZip(accidentZip);
	
							System.out.println("Please Enter your Claim Type Id");
							int claimType = sc.nextInt();
							claim.setClaimType(claimType);
							
							//questionnaire  to determine claim amount
							String query = "select pd from PolicyDetails pd where pd.policyNumber=:xyz";
							TypedQuery<PolicyDetails> querystr = em.createQuery(query, PolicyDetails.class);
							querystr.setParameter("xyz", policyNumber);
							policyDetailslist = querystr.getSingleResult();
							qId = policyDetailslist.getQuestionId();
							q = em.find(Questions.class, qId);
							System.out.println("Please Answer few Questions: 1 for Yes, 2 for No!");
							System.out.println(q.getQues_1());
							answer = sc.nextInt();
							if (answer == 1) 
							{
								claimAmount = claimAmount + 1000;
							}
	
							System.out.println(q.getQues_2());
							answer = sc.nextInt();
							if (answer == 1) 
							{
								claimAmount = claimAmount + 2000;
							}
							System.out.println(q.getQues_3());
							answer = sc.nextInt();
							if (answer == 1) 
							{
								claimAmount = claimAmount + 2000;
							}
							System.out.println(q.getQues_4());
							answer = sc.nextInt();
							if (answer == 1) 
							{
								claimAmount = claimAmount + 4000;
							}
							System.out.println(q.getQues_5());
							answer = sc.nextInt();
							if (answer == 1) 
							{
								claimAmount = claimAmount + 10000;
							}
	
							claim.setClaimAmount(claimAmount);
	
							em.persist(claim);
							em.getTransaction().commit();
							System.out.println("Claim Request Initiated");
			
						}
						else
						{
							System.out.println("Wrong Policy Number");
						}
					}
					
					
				}
				else
				{
					System.out.println("User Has No Policy To Claim");
				}
				break;
			
		case 2:
				//agent
				if (accservice.getPolicyByUserName(user.getUserName()) != null )
				{
					for (Long pnumber : accservice.getPolicyByUserName(user.getUserName())) 
					{
						if (policyNumber == pnumber) 
						{
							//Entering Claim Details
							System.out.println("Please Enter your Claim Reason!");
							String claimReason = sc.next();
							claim.setClaimReason(claimReason);
	
							System.out.println("Please Enter your Accident Location Street!");
							String accidentlocStreet = sc.next();
							claim.setAccidentlocStreet(accidentlocStreet);
	
							System.out.println("Please Enter your Accident City!");
							String accidentCity = sc.next();
							claim.setAccidentCity(accidentCity);
	
							System.out.println("Please Enter your Accident State!");
							String accidentState = sc.next();
							claim.setAccidentState(accidentState);
	
							System.out.println("Please Enter your Accident Zip Code");
							long accidentZip = sc.nextLong();
							claim.setAccidentZip(accidentZip);
	
							System.out.println("Please Enter your Claim Type Id");
							int claimType = sc.nextInt();
							claim.setClaimType(claimType);
							
							//questionnaire  to determine claim amount
							String query = "select pd from PolicyDetails pd where pd.policyNumber=:xyz";
							TypedQuery<PolicyDetails> querystr = em.createQuery(query, PolicyDetails.class);
							querystr.setParameter("xyz", policyNumber);
							policyDetailslist = querystr.getSingleResult();
							qId = policyDetailslist.getQuestionId();
							q = em.find(Questions.class, qId);
							System.out.println("Please Answer few Questions: 1 for Yes, 2 for No!");
							System.out.println(q.getQues_1());
							answer = sc.nextInt();
							if (answer == 1) 
							{
								claimAmount = claimAmount + 1000;
							}
	
							System.out.println(q.getQues_2());
							answer = sc.nextInt();
							if (answer == 1) 
							{
								claimAmount = claimAmount + 2000;
							}
							System.out.println(q.getQues_3());
							answer = sc.nextInt();
							if (answer == 1) 
							{
								claimAmount = claimAmount + 2000;
							}
							System.out.println(q.getQues_4());
							answer = sc.nextInt();
							if (answer == 1) 
							{
								claimAmount = claimAmount + 4000;
							}
							System.out.println(q.getQues_5());
							answer = sc.nextInt();
							if (answer == 1) 
							{
								claimAmount = claimAmount + 10000;
							}
	
							claim.setClaimAmount(claimAmount);
	
							em.persist(claim);
							em.getTransaction().commit();
							System.out.println("Claim Request Initiated");
			
						}
						else
						{
							System.out.println("Wrong Policy Number");
						}
					}
					
					
				}
				else
				{
					System.out.println("User Has No Policy To Claim");
				}
				break;
			
		case 3:
				//admin
				String qStr = "SELECT p.policyNumber FROM Policy p";
				
				TypedQuery<Long> query = em.createQuery(qStr, Long.class);
				allPolicyNumberList=query.getResultList();
				
				if (allPolicyNumberList!= null)
				{
					for (Long pnumber : allPolicyNumberList) 
					{
						if (policyNumber == pnumber) 
						{
							//Entering Claim Details
							System.out.println("Please Enter your Claim Reason!");
							String claimReason = sc.next();
							claim.setClaimReason(claimReason);
	
							System.out.println("Please Enter your Accident Location Street!");
							String accidentlocStreet = sc.next();
							claim.setAccidentlocStreet(accidentlocStreet);
	
							System.out.println("Please Enter your Accident City!");
							String accidentCity = sc.next();
							claim.setAccidentCity(accidentCity);
	
							System.out.println("Please Enter your Accident State!");
							String accidentState = sc.next();
							claim.setAccidentState(accidentState);
	
							System.out.println("Please Enter your Accident Zip Code");
							long accidentZip = sc.nextLong();
							claim.setAccidentZip(accidentZip);
	
							System.out.println("Please Enter your Claim Type Id");
							int claimType = sc.nextInt();
							claim.setClaimType(claimType);
							
							//questionnaire  to determine claim amount
							String qry = "select pd from PolicyDetails pd where pd.policyNumber=:xyz";
							TypedQuery<PolicyDetails> querystr = em.createQuery(qry, PolicyDetails.class);
							querystr.setParameter("xyz", policyNumber);
							policyDetailslist = querystr.getSingleResult();
							qId = policyDetailslist.getQuestionId();
							q = em.find(Questions.class, qId);
							System.out.println("Please Answer few Questions: 1 for Yes, 2 for No!");
							System.out.println(q.getQues_1());
							answer = sc.nextInt();
							if (answer == 1) 
							{
								claimAmount = claimAmount + 1000;
							}
	
							System.out.println(q.getQues_2());
							answer = sc.nextInt();
							if (answer == 1) 
							{
								claimAmount = claimAmount + 2000;
							}
							System.out.println(q.getQues_3());
							answer = sc.nextInt();
							if (answer == 1) 
							{
								claimAmount = claimAmount + 2000;
							}
							System.out.println(q.getQues_4());
							answer = sc.nextInt();
							if (answer == 1) 
							{
								claimAmount = claimAmount + 4000;
							}
							System.out.println(q.getQues_5());
							answer = sc.nextInt();
							if (answer == 1) 
							{
								claimAmount = claimAmount + 10000;
							}
	
							claim.setClaimAmount(claimAmount);
	
							em.persist(claim);
							em.getTransaction().commit();
							System.out.println("Claim Request Initiated");
			
						}
						else
						{
							System.out.println("Wrong Policy Number");
						}
					}
					
					
				}
				else
				{
					System.out.println("User Has No Policy To Claim");
				}
				break;
			
		}
		
		
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
