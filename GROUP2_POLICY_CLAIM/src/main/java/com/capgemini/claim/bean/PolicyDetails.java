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
	
	@Column(name="ANSWER")
	private String answer;
	
	//CONSTRUCTORS
	public PolicyDetails(long policyNumber, int questionId, String answer) {
		super();
		this.policyNumber = policyNumber;
		this.questionId = questionId;
		this.answer = answer;
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

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	//TOSTRING
	@Override
	public String toString() {
		return "\n PolicyDetails [policyNumber=" + policyNumber + ", questionId=" + questionId + ", answer=" + answer
				+ "]";
	}
	
	

}
