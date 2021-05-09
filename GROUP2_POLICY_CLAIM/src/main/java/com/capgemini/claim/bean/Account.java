package com.capgemini.claim.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ACCOUNT")
public class Account {
	
	@Id
	@Column(name="ACCOUNTNUMBER")
	private long accountNumber;
	
	@Column(name="USERNAME")
	private String userName;
	
	@Column(name="INSUREDNAME")
	private String insuredName;
	
	
	//CONSTRUCTORS
	
	public String getInsuredName() {
		return insuredName;
	}

	public void setInsuredName(String insuredName) {
		this.insuredName = insuredName;
	}

	public Account() {
		super();
	}

	public Account(long accountNumber, String userName, String insuredName) {
		super();
		this.accountNumber = accountNumber;
		this.userName = userName;
		this.insuredName = insuredName;
	}

	//GETTER & SETTERS
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	

	@Override
	public String toString() {
		return "\n Account [accountNumber=" + accountNumber + ", userName=" + userName + ", insuredName=" + insuredName
				+ "]";
	}


	
}
