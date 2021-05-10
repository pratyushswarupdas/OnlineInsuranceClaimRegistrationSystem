package com.capgemini.claim.user;

import java.sql.SQLException;
import java.util.Scanner;

import com.capgemini.claim.bean.Account;
import com.capgemini.claim.bean.User;
import com.capgemini.claim.customexp.CustomException;
import com.capgemini.claim.dao.PolicyDao;
import com.capgemini.claim.dao.PolicyDaoImpl;
import com.capgemini.claim.dao.UserDao;
import com.capgemini.claim.dao.UserDaoImpl;
import com.capgemini.claim.service.IAccountService;
import com.capgemini.claim.service.IClaimService;
import com.capgemini.claim.service.IUserService;
import com.capgemini.claim.service.ImplAccountService;
import com.capgemini.claim.service.ImplClaimService;
import com.capgemini.claim.service.ImplUserService;

public class UserApp {
	
	static Scanner sc=new Scanner(System.in);
	static User user=new User();
	private static int ans=0;
	
	public static void main(String[] args) {
		
		UserDao userDao=new UserDaoImpl();
		PolicyDao policyDao=new PolicyDaoImpl();
		IUserService userService=new ImplUserService();
		IClaimService claimService=new ImplClaimService();
		IAccountService accountService = new ImplAccountService();
		
	
		String ch="yes";
		do {
		System.out.println("\t*_*_*_*_*_*_*_*_*\tInsurance Claim Registration System\t*_*_*_*_*_*_*_*_*");
		System.out.println("\nLogin=>");
		System.out.println("\tUsername:");
		String username=sc.next();
		System.out.println("\tPassword:");
		String password=sc.next();
		try 
		{
			user=userDao.loginUser(username, password);
		
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
										claimService.claimCreation(user);
						
										break;
								
								case 2:	policyDao.viewPolicy(user);
										break;
										
								case 3: try 
										{
											System.out.println(claimService.viewReport(user));
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
										claimService.claimCreation(user);
		
										break;
								
								case 2:	policyDao.viewPolicy(user);
										break;
										
								case 3: 
										try {
											System.out.println(claimService.viewReport(user));										} 
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
							System.out.println("6. Create Account");
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
										
										System.out.println("Enter new RollCode (1 , 2 , 3)");
										int rollcode=sc.nextInt();
										user_new.setRoleCode(rollcode);
										
										try {
											userService.profileCreation(user_new);
										}
										catch(CustomException e) {
											System.out.println(e.getMessage());
										}
										break;
								
								case 2:	//view policy
										policyDao.viewPolicy(user);
										break;
								
								case 3://Claim Creation
										claimService.claimCreation(user);
										break;
								case 4:
										try {
											
											System.out.println(claimService.viewReport(user));
										} 
										catch (SQLException e) 
										{
											e.printStackTrace();
										}
										break;
										
								case 5:
										break;
								
								case 6:
											
										Account a = new Account();
										a.setUserName(user.getUserName());
										System.out.println("enter Bank acc no");
										long tempAccNumber = sc.nextLong();
										a.setAccountNumber(tempAccNumber);
										System.out.println("Enter the user for whom you want to set Bank Account details for");
										String tempInsuredUser = sc.next();
										a.setInsuredName(tempInsuredUser);
										
										try {
											accountService.createAccount(user,a);
										}
										catch(CustomException e) {
											System.out.println(e.getMessage());
										}
										break;
								
								default:System.out.println("Wrong Input");
								break;
							}
							break;	
							
			}
		
		
		
		} catch (CustomException e1) {
			System.out.println(e1.getMessage());
		}
		
		System.out.println("Do u wish to Try Again(yes/no)");
		ch=sc.next();
		ch=ch.toLowerCase();
		
		}while(ch.equals("yes"));
		
		//
		
		sc.close();
		System.exit(0);
		
	}
}
