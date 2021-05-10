package com.capgemini.claim.user;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import com.capgemini.claim.bean.Claim;
import com.capgemini.claim.bean.User;
import com.capgemini.claim.dao.ClaimDao;
import com.capgemini.claim.dao.ClaimDaoImpl;
import com.capgemini.claim.dao.PolicyDetailsDao;
import com.capgemini.claim.dao.PolicyDao;
import com.capgemini.claim.dao.PolicyDaoImpl;
import com.capgemini.claim.dao.PolicyDetailsDao;
import com.capgemini.claim.dao.PolicyDetailsDaoImpl;
import com.capgemini.claim.dao.UserDao;
import com.capgemini.claim.dao.UserDaoImpl;

public class UserApp {
	
	static Scanner sc=new Scanner(System.in);
	static User user=new User();
	private static int ans=0;
	
	public static void main(String[] args) {
		
		UserDao userDao=new UserDaoImpl();
		ClaimDao claimDao=new ClaimDaoImpl();
		PolicyDao policyDao=new PolicyDaoImpl();
		PolicyDetailsDao policydetailsDao=new PolicyDetailsDaoImpl();
		
		/*
		 * UserDao dao = new UserDaoImpl(); User u = dao.getUserById("Jay");
		 * System.out.println(u);
		 */
		String ch="yes";
		do {
		System.out.println("\t*_*_*_*_*_*_*_*_*\tInsurance Claim Registration System\t*_*_*_*_*_*_*_*_*");
		System.out.println("\nLogin=>");
		System.out.println("\tUsername:");
		String username=sc.next();
		System.out.println("\tPassword:");
		String password=sc.next();
		user=userDao.loginUser(username, password);
		if(user!=null)
		{
			ch="no";
			switch(user.getRoleCode())
			{
				case 1:
							System.out.println("Inside Insuredr Functions");
							System.out.println("1. Claim Creation");
							System.out.println("2. View Policies");
							System.out.println("3. Claim View");

							System.out.println("Enter Choce");
							ans=sc.nextInt();
							switch(ans)
							{
								case 1:	//Claim Creation
										claimDao.claimCreation(user);
						
										break;
								
								case 2:	policyDao.viewPolicy(user);
										break;
										
								case 3: try {
											System.out.println(claimDao.viewReport(user).toString());
											} 
											catch (SQLException e) 
											{
												e.printStackTrace();
											}
										break;
									
								default:System.out.println("Wrong Input");
								break;
							}
							break;
							
				case 2:
							System.out.println("Inside Claim Handler Functions");
							System.out.println("1. Claim Creation");
							System.out.println("2. View Policies");
							System.out.println("3. Claim View");
							System.out.println("Enter Choce");
							ans=sc.nextInt();
							switch(ans)
							{
								case 1:	//Claim Creation
										claimDao.claimCreation(user);
		
										break;
								
								case 2:	policyDao.viewPolicy(user);
										break;
										
								case 3: try {
									System.out.println(claimDao.viewReport(user).toString());
									} 
									catch (SQLException e) 
									{
										e.printStackTrace();
									}
								break;
								
								default:System.out.println("Wrong Input");
								break;
							}
							break;
							
				case 3: 
							System.out.println("Inside Claim Adjuster Functions");
							System.out.println("1. New Profile Creation");
							System.out.println("2. View Policies");
							System.out.println("3. Claim Creation");
							System.out.println("4. Claim View");
							System.out.println("5. Report Generation");
							System.out.println("Enter Choce");
							ans=sc.nextInt();
							switch(ans)
							{
								case 1:
										//profile creation
										User user_new=new User();
									
										System.out.println("enter new username");
										username=sc.next();
										user_new.setUserName(username);
										System.out.println("enter new password");
										password=sc.next();
										user_new.setPassword(password);
										System.out.println("enter new RollCode (1 , 2 , 3)");
										int rollcode=sc.nextInt();
										user_new.setRoleCode(rollcode);
		
										String result = userDao.profileCreation(user_new);
										System.out.println(result);
										break;
								
								case 2:	policyDao.viewPolicy(user);
										break;
								
								case 3://Claim Creation
										claimDao.claimCreation(user);
										break;
								case 4:
										break;
								
								default:System.out.println("Wrong Input");
								break;
							}
							break;	
							
			}
		}
		else {
			
			System.out.println("Wrong Input!!!.....Try Again");
			System.out.println("Do u wish to Try Again(yes/no)");
			ch=sc.next();
			//ch=ch.toLowerCase();
			
		}
		
		}while(ch.equals("yes"));
		
		//
		
		sc.close();
		System.exit(0);
		
	}
}
