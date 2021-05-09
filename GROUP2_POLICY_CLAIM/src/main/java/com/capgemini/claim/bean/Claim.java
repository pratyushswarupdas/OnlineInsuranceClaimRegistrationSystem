package com.capgemini.claim.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="ClaimDetails")
public class Claim {
	
	@Id
	@Column(name="CLAIMNUMBER")
	@GeneratedValue(generator = "claim_no_seq")
	@SequenceGenerator(name = "claim_no_seq", sequenceName = "CLAIM_NO_SEQ", allocationSize = 1)
	private long claimNumber;
	
	@Column(name="CLAIMREASON")
	private String claimReason;
	
	@Column(name="ACCIDENTLOCSTREET")
	private String accidentlocStreet;
	
	@Column(name="ACCIDENTCITY")
	private String accidentCity;
	
	@Column(name="ACCIDENTSTATE")
	private String accidentState;
	
	@Column(name="ACCIDENTZIP")
	private long accidentZip;
	
	@Column(name="CLAIMTYPEID")
	private int claimType;
	
	@Column(name="POLICYNUMBER")
	private long policyNumber;
	@Column(name="CLAIMAMOUNT")
	private long claimAmount;
	
	//CONSTRUCTORS
	public Claim() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Claim(String claimReason, String accidentlocStreet, String accidentCity,
			String accidentState, long accidentZip, int claimType, long policyNumber) {
		super();
		//this.claimNumber = claimNumber;
		this.claimReason = claimReason;
		this.accidentlocStreet = accidentlocStreet;
		this.accidentCity = accidentCity;
		this.accidentState = accidentState;
		this.accidentZip = accidentZip;
		this.claimType = claimType;
		this.policyNumber = policyNumber;
	}
	
	//GETTER & SETTERS
	public long getClaimNumber() {
		return claimNumber;
	}
	public void setClaimNumber(long claimNumber) {
		this.claimNumber = claimNumber;
	}
	public String getClaimReason() {
		return claimReason;
	}
	public void setClaimReason(String claimReason) {
		this.claimReason = claimReason;
	}
	public String getAccidentlocStreet() {
		return accidentlocStreet;
	}
	public void setAccidentlocStreet(String accidentlocStreet) {
		this.accidentlocStreet = accidentlocStreet;
	}
	public String getAccidentCity() {
		return accidentCity;
	}
	public void setAccidentCity(String accidentCity) {
		this.accidentCity = accidentCity;
	}
	public String getAccidentState() {
		return accidentState;
	}
	public void setAccidentState(String accidentState) {
		this.accidentState = accidentState;
	}
	public long getAccidentZip() {
		return accidentZip;
	}
	public void setAccidentZip(long accidentZip) {
		this.accidentZip = accidentZip;
	}
	public int getClaimType() {
		return claimType;
	}
	public void setClaimType(int claimType) {
		this.claimType = claimType;
	}
	public long getPolicyNumber() {
		return policyNumber;
	}
	public void setPolicyNumber(long policyNumber) {
		this.policyNumber = policyNumber;
	}
	
	
	
	public long getClaimAmount() {
		return claimAmount;
	}
	public void setClaimAmount(long claimAmount) {
		this.claimAmount = claimAmount;
	}
	@Override
	public String toString() {
		return "\n Claim [claimNumber=" + claimNumber + ", claimReason=" + claimReason + ", accidentlocStreet="
				+ accidentlocStreet + ", accidentCity=" + accidentCity + ", accidentState=" + accidentState
				+ ", accidentZip=" + accidentZip + ", claimType=" + claimType + ", policyNumber=" + policyNumber
				+ ", claimAmount=" + claimAmount + "]";
	}
	
	
}
