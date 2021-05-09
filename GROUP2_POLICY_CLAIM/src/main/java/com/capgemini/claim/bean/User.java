package com.capgemini.claim.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USERS")
public class User {
	@Id
	@Column(name="USERNAME")
	private String UserName;
	
	@Column(name="PASSWORD")
	private String Password;
	
	@Column(name="ROLECODE")
	private int RoleCode;
	
	//CONSTRUCTORS
	public User(String userName, String password, int roleCode) {
		super();
		UserName = userName;
		Password = password;
		RoleCode = roleCode;
	}

	public User() {
		super();
	}

	//GETTER & SETTERS
	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public int getRoleCode() {
		return RoleCode;
	}

	public void setRoleCode(int roleCode) {
		RoleCode = roleCode;
	}
	
	//TOSTRING
	@Override
	public String toString() {
		return "\n User [UserName=" + UserName + ", Password=" + Password + ", RoleCode=" + RoleCode + "]";
	}

	
	
	
	
}
