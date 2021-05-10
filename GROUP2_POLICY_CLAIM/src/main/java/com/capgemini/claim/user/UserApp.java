package com.capgemini.claim.user;

import java.sql.SQLException;
import java.util.Scanner;
import com.capgemini.claim.bean.Account;
import com.capgemini.claim.bean.User;
import com.capgemini.claim.customexp.CustomException;
import com.capgemini.claim.service.IAccountService;
import com.capgemini.claim.service.IClaimService;
import com.capgemini.claim.service.IPolicyService;
import com.capgemini.claim.service.IUserService;
import com.capgemini.claim.service.ImplAccountService;
import com.capgemini.claim.service.ImplClaimService;
import com.capgemini.claim.service.ImplPolicyService;
import com.capgemini.claim.service.ImplUserService;

public class UserApp {
	
	private static Scanner sc=new Scanner(System.in);
	private static IPolicyService policyService=new ImplPolicyService();
	private static IUserService userService=new ImplUserService();
	private static IClaimService claimService=new ImplClaimService();
	private static IAccountService accountService = new ImplAccountService();
	
	public static void main(String[] args) {
		
		User user=new User();
		String ch="No";
		do 
		{
			System.out.print("==========================\t                                    \t=========================="
							+"\n<><><><><><><><><><><><><>\tInsurance Claim Registration System\t<><><><><><><><><><><><><>"
							+"\n==========================\t                                   \t==========================");
			
			System.out.println("\n\nLogin=>");
			System.out.println("\tUsername:");
			String username=sc.next();
			System.out.println("\tPassword:");
			String password=sc.next();
			
			try 
			{
				user=userService.loginUser(username, password);
				
				switch(user.getRoleCode())
				{
					case 1:		insuredLogin(user);
								break;
					case 2:
								claimHandlerLogin(user);
								break;
					case 3: 
								claimAdjusterLogin(user);
								break;	
				}
			} 
			catch (CustomException e1) 
			{
				System.out.println(e1.getMessage());
				
//				  System.out.println("Do u wish to Try Again(yes/no)"); 
//				  ch=sc.next();
//				  ch=ch.toLowerCase();
				 
			}
			System.out.println("Do u wish to Re-Login(yes/no)");
			ch=sc.next();
			ch=ch.toLowerCase();
		}while(ch.equals("yes"));

		sc.close();
		System.exit(0);
	}



	//User_Flow

	private static void insuredLogin(User user2) 
	{
		int ans=0;
		
		String ch="No";
		System.out.println("Welcome Insured User");
		do 
		{
	        System.out.println("1. View My Polices");
	        System.out.println("2. Want To Make A Claim");
	        System.out.println("3. View My Claim Reports");
	        System.out.println("Enter Choice");
	        ans=sc.nextInt();
	        switch(ans)
	        {
	            case 1: //View Policies
    					System.out.println(policyService.viewPolicy(user2));

	    
	                    break;
	            
	            case 2: //Claim Creation
		            	try{
		            		claimService.claimCreation(user2);
		            	}							
		            	catch(CustomException e) {
		            		System.out.println(e.getMessage());	
		            	}
	                    break;
	                    
	            case 3: //view Claim
		            	try 
	            		{
	            			System.out.println(claimService.viewReport(user2));                                      
	            		} 
	            		catch (SQLException e) 
	            		{
	            			e.getMessage();
	            		}
	            		break;
	                    
	                
	            default:System.out.println("Wrong Input");
	            break;
	        }		
	        System.out.println("Do You Wish To See The Menu Place Again(yes/no)");
			ch=sc.next();
			ch=ch.toLowerCase();
			
		}while(ch.equals("yes"));
	}
	
	private static void claimHandlerLogin(User user2) 
	{
		double premiumAmount;
		long bankAccNo;
		int questionId;
		String ch="No";
		int ans=0;
		System.out.println("Welcome Claim Handler User");
		do 
		{	
			System.out.println("1. Create A New Account");
			System.out.println("2. Create A New Policy");
	        System.out.println("3. View My Customer's Polices");
	        System.out.println("4. Want To Make A Claim");
	        System.out.println("5. View My Claim Reports");
	        System.out.println("Enter Choice");
	        ans=sc.nextInt();
	        switch(ans)
	        {
	        	case 1: //Create_Account
		            	Account a = new Account();
		                a.setUserName(user2.getUserName());
		                System.out.println("enter Bank acc no");
		                long tempAccNumber = sc.nextLong();
		                a.setAccountNumber(tempAccNumber);
		                System.out.println("Enter the user for whom you want to set Bank Account details for");
		                String tempInsuredUser = sc.next();
		                a.setInsuredName(tempInsuredUser);
		                
		                try 
		                {
		                    accountService.createAccount(user2,a);
		                }
		                catch(CustomException e) 
		                {
		                    System.out.println(e.getMessage());
		                }
		                
		                break;
	                
	            case 2: //Create Policies
		            	System.out.println("Enter premium amount");
		        		premiumAmount=sc.nextDouble();
		        		System.out.println("Enter account no: ");
		        		bankAccNo=sc.nextLong();
		        		System.out.println("Enter Vehicle type 1 for two wheeler, 2 for HatchBack, 3 for SUV");
		        		questionId=sc.nextInt();
		        		policyService.createPolicy(user2,bankAccNo,premiumAmount,questionId);
	
		        		break;
	                    
	            case 3: //View Policies
	    				System.out.println(policyService.viewPolicy(user2));
	    				
	                    break;
	            
	            case 4: //Claim Creation
		            	try{
		            		claimService.claimCreation(user2);
		            	}							
		            	catch(CustomException e) {
		            		System.out.println(e.getMessage());	
		            	}
		                break;
	                    
	            case 5: //view Claim
	            		try 
	            		{
	            			System.out.println(claimService.viewReport(user2));                                      
	            		} 
	            		catch (SQLException e) 
	            		{
	            			e.getMessage();
	            		}
	            		break;
	                   
	            
	            default:
	            		System.out.println("Wrong Input");
	            		break;
	        }	
	        System.out.println("Do You Wish To See The Menu Place Again(yes/no)");
			ch=sc.next();
			ch=ch.toLowerCase();
			
		}while(ch.equals("yes"));
	}
	
	
	private static void claimAdjusterLogin(User user2) 
	{
		double premiumAmount;
		long bankAccNo;
		int questionId;
    	String username,password;
    	String ch="No";
    	int ans=0;
    	System.out.println("Welcome Claim Handler User");
    	do 
    	{
	        System.out.println("1. Create A New Profile");
	        System.out.println("2. Create A New Account");
	        System.out.println("3. Create A New Policy");
	        System.out.println("4. View All Policies");
	        System.out.println("5. Want To Make A Claim");
	        System.out.println("6. View My Claim Reports");
	        System.out.println("Enter Choice");		
	        ans=sc.nextInt();
	        switch(ans)
	        {
	            case 1:
	                    //Profile_Creation
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
	            
	            case 2: //Create_Account
		            	Account a = new Account();
		                a.setUserName(user2.getUserName());
		                System.out.println("enter Bank acc no");
		                long tempAccNumber = sc.nextLong();
		                a.setAccountNumber(tempAccNumber);
		                System.out.println("Enter the user for whom you want to set Bank Account details for");
		                String tempInsuredUser = sc.next();
		                a.setInsuredName(tempInsuredUser);
		                
		                try 
		                {
		                    accountService.createAccount(user2,a);
		                }
		                catch(CustomException e) 
		                {
		                    System.out.println(e.getMessage());
		                }
		                
		                break;
	            
	            case 3://Create Policies
		            	System.out.println("Enter premium amount");
		        		premiumAmount=sc.nextDouble();
		        		System.out.println("Enter account no: ");
		        		bankAccNo=sc.nextLong();
		        		System.out.println("Enter Vehicle type 1 for two wheeler, 2 for HatchBack, 3 for SUV");
		        		questionId=sc.nextInt();
		        		policyService.createPolicy(user2,bankAccNo,premiumAmount,questionId);
		            	
	                	break;
	                    
	            case 4: //View_All_Policies
            			System.out.println(policyService.viewPolicy(user2));
            			break;
	                    
	            case 5://Claim Creation
		            	try{
		            		claimService.claimCreation(user2);
		            	}							
		            	catch(CustomException e) {
		            		System.out.println(e.getMessage());	
		            	}
		                break;
	                    
	            case 6://View_All_Claim_Report
		            	try 
		        		{
		        			System.out.println(claimService.viewReport(user2));                                      
		        		} 
		        		catch (SQLException e) 
		        		{
		        			e.printStackTrace();
		        		}
		        		break;
	                    
	            default:
	            		System.out.println("Wrong Input");
	            		break;
	        }		
		
	        System.out.println("Do You Wish To See The Menu Place Again(yes/no)");
	        ch=sc.next();
	        ch=ch.toLowerCase();
		
    	}while(ch.equals("yes"));
	}
	
}
