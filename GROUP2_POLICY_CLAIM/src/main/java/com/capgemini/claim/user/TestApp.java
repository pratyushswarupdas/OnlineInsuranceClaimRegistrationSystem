	package com.capgemini.claim.user;
	import java.util.Scanner;

//helloAliens
import com.capgemini.claim.bean.User;
import com.capgemini.claim.customexp.CustomException;
import com.capgemini.claim.service.IAccountService;
import com.capgemini.claim.service.IUserService;
import com.capgemini.claim.service.ImplAccountService;
import com.capgemini.claim.service.ImplUserService;

public class TestApp {

	public static void main(String[] args) throws CustomException {
//		UserDao userDao=new UserDaoImpl();
		//User user=userDao.loginUser(username, password);
//		//AccountDao accdao=new AccountDaoImpl();
//		
//		//createAccount -- done in dao
//		//createPolicy - done in dao
//		
//		//claimCreation
//		//claimDetails - yet to be copied from whatsapp
//		User user=userDao.loginUser("Rock", "test123");
//		PolicyDao pdao=new PolicyDaoImpl();
//		pdao.createPolicy(user);
//		System.exit(0);
		
		Scanner sc=new Scanner(System.in);
		System.out.println("\t*_*_*_*_*_*_*_*_*\tInsurance Claim Registration System\t*_*_*_*_*_*_*_*_*");
		System.out.println("\nLogin=>");
		System.out.println("\tUsername:");
		String username=sc.next();
		System.out.println("\tPassword:");
		String password=sc.next();
		

		
		
//for login user.
		
		IUserService userService=new ImplUserService();
		User user=userService.loginUser(username, password);
		System.out.println(user);
	
//		IMPPP	for createAcc
			IAccountService a=new ImplAccountService();
			a.createAccount(user,null);
		
		sc.close();
	}

}
//sent