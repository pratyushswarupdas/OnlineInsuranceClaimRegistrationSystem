package com.capgemini.claim.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.capgemini.claim.bean.Claim;
import com.capgemini.claim.bean.PolicyDetails;
import com.capgemini.claim.bean.Questions;
import com.capgemini.claim.bean.User;
import com.capgemini.claim.dao.ClaimDao;
import com.capgemini.claim.dao.ClaimDaoImpl;
import com.capgemini.jpautil.JPAUtil;

public class ImplClaimService implements IClaimService {
	
	
	private EntityManager em = JPAUtil.getEntityManager();
	private ClaimDao claimDao=new ClaimDaoImpl();
	
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
		int temp=0;
		
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
	
							claimDao.claimCreation(claim);
							System.out.println("Claim Request Initiated");
							temp=1;
						}
						
					}
					
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
	
							claimDao.claimCreation(claim);
							System.out.println("Claim Request Initiated");
							temp=1;							
						}
						
					}
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
	
							claimDao.claimCreation(claim);
							System.out.println("Claim Request Initiated");
							temp=1;
			
						}

					}
					
				}
				
				break;
			
		}
		
		if(temp==0)
		{
			System.out.println("Policy Not Found");;
		}
		sc.close();
		
	}
	@Override
	 public List<Claim> viewReport(User user)throws SQLException
	 {
		 return claimDao.viewReport(user);
	 }
	
	

}
