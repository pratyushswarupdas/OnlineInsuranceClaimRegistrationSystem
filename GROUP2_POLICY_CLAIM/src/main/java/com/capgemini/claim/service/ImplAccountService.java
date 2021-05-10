package com.capgemini.claim.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.capgemini.claim.bean.Account;
import com.capgemini.claim.bean.User;
import com.capgemini.jpautil.JPAUtil;
import com.capgemini.claim.dao.AccountDao;
import com.capgemini.claim.dao.AccountDaoImpl;


public class ImplAccountService implements IAccountService {
	private EntityManager em = JPAUtil.getEntityManager();
	Scanner sc=new Scanner(System.in);
	@Override
	public List<Long> getPolicyByUserName(String username) {

		List<Account> accList = new ArrayList<>();
		List<Long> polList = new ArrayList<>();

		String queryString = "select a from Account a where a.userName=:pusername ";
		TypedQuery<Account> querystr = em.createQuery(queryString, Account.class);
		querystr.setParameter("pusername", username);
		accList = querystr.getResultList();

		for (Account accNo : accList) {
			String qStr = "SELECT p.policyNumber FROM Policy p WHERE p.accountNumber=:accNo";
			TypedQuery<Long> qr = em.createQuery(qStr, Long.class);
			qr.setParameter("accNo", accNo.getAccountNumber());
			polList=qr.getResultList();

		}
		// System.out.println(polList);
		return polList;
	}
	@Override
	public List<Long> getPolicyByInsuredName(String insuredName) {

		List<Account> accList = new ArrayList<>();
		List<Long> polList = new ArrayList<>();

		String queryString = "select a from Account a where a.insuredName=:pInsuredName ";
		TypedQuery<Account> querystr = em.createQuery(queryString, Account.class);
		querystr.setParameter("pInsuredName", insuredName);
		accList = querystr.getResultList();

		for (Account accNo : accList) {
			String qStr = "SELECT p.policyNumber FROM Policy p WHERE p.accountNumber=:accNo";
			TypedQuery<Long> qr = em.createQuery(qStr, Long.class);
			qr.setParameter("accNo", accNo.getAccountNumber());
			polList=qr.getResultList();

		}
		// System.out.println(polList);
		return polList;
	}
	@Override
	public void createAccount(User user) 
	{
		AccountDao ad=new AccountDaoImpl();
			long tempAccNumber;
			String tempInsuredUser;
			User checkTempInsuredUser;
			
			Account a = new Account();
			a.setUserName(user.getUserName());
			System.out.println("enter Bank acc no");
			tempAccNumber = sc.nextLong();
			a.setAccountNumber(tempAccNumber);
			System.out.println("Enter the user for whom you want to set Bank Account details for");
			tempInsuredUser = sc.next();

		
			checkTempInsuredUser = em.find(User.class, tempInsuredUser);
			if(checkTempInsuredUser.getUserName()==tempInsuredUser) {
				a.setInsuredName(tempInsuredUser);
				ad.createAccount(a);
				
			}
			else
			{
				System.out.println("No User found");
			}
			

		
		
	}
	

}
