package com.capgemini.claim.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PolicyDetails")
public class PolicyDetails {
	@Id
	@Column(name="POLICYNUMBER")
	private long policyNumber;
	
	@Column(name="QUESTIONID")
	private int questionId;
	
	
	//CONSTRUCTORS
	public PolicyDetails(long policyNumber, int questionId) {
		super();
		this.policyNumber = policyNumber;
		this.questionId = questionId;
	}

	public PolicyDetails() {
		super();
	}

	//GETTER & SETTERS
	public long getPolicyNumber() {
		return policyNumber;
	}

	public void setPolicyNumber(long policyNumber) {
		this.policyNumber = policyNumber;
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}


	
	//TOSTRING
	@Override
	public String toString() {
		return "\n PolicyDetails [policyNumber=" + policyNumber + ", questionId=" + questionId +"]";
	}
	
	

}
