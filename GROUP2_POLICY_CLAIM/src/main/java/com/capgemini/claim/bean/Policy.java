package com.capgemini.claim.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Policy")
public class Policy {
	@Id
	@Column(name="POLICYNUMBER")
	@GeneratedValue(generator = "policy_no_seq")
	@SequenceGenerator(name = "policy_no_seq", sequenceName = "POLICY_NO_SEQ", allocationSize = 1)
	private long policyNumber;
	
	@Column(name="POLICYPREMIUM")
	private double policyPremium;
	
	@Column(name="ACCOUNTNUMBER	")
	private long accountNumber;
	
	//CONSTRUCTORS
	public Policy(long policyNumber, double policyPremium, long accountNumber) {
		super();
		this.policyNumber = policyNumber;
		this.policyPremium = policyPremium;
		this.accountNumber = accountNumber;
	}

	public Policy() {
		super();
	}

	//GETTER & SETTERS
	public long getPolicyNumber() {
		return policyNumber;
	}

	public void setPolicyNumber(long policyNumber) {
		this.policyNumber = policyNumber;
	}

	public double getPolicyPremium() {
		return policyPremium;
	}

	public void setPolicyPremium(double policyPremium) {
		this.policyPremium = policyPremium;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	//TOSTRING
	@Override
	public String toString() {
		return "\n Policy [policyNumber=" + policyNumber + ", policyPremium=" + policyPremium + ", accountNumber="
				+ accountNumber + "]";
	}
	
	
	
	
	

}
