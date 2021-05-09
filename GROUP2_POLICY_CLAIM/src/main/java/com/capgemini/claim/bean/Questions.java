package com.capgemini.claim.bean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="QUESTIONS")
public class Questions {
	@Id
	@Column(name="QUSTID")
	private int qustId; 	
	
	@Column(name="QUES_1")
	private String ques_1;

	@Column(name="QUES_2")
	private String ques_2;

	@Column(name="QUES_3")
	private String ques_3;

	@Column(name="QUES_4")
	private String ques_4;

	@Column(name="QUES_5")
	private String ques_5;
	
	public Questions()
	{
		super();
	}

	public Questions(int qustId, String ques_1, String ques_2, String ques_3, String ques_4, String ques_5) {
		super();
		this.qustId = qustId;
		this.ques_1 = ques_1;
		this.ques_2 = ques_2;
		this.ques_3 = ques_3;
		this.ques_4 = ques_4;
		this.ques_5 = ques_5;
	}

	public int getQustId() {
		return qustId;
	}

	public void setQustId(int qustId) {
		this.qustId = qustId;
	}

	public String getQues_1() {
		return ques_1;
	}

	public void setQues_1(String ques_1) {
		this.ques_1 = ques_1;
	}

	public String getQues_2() {
		return ques_2;
	}

	public void setQues_2(String ques_2) {
		this.ques_2 = ques_2;
	}

	public String getQues_3() {
		return ques_3;
	}

	public void setQues_3(String ques_3) {
		this.ques_3 = ques_3;
	}

	public String getQues_4() {
		return ques_4;
	}

	public void setQues_4(String ques_4) {
		this.ques_4 = ques_4;
	}

	public String getQues_5() {
		return ques_5;
	}

	public void setQues_5(String ques_5) {
		this.ques_5 = ques_5;
	}

	@Override
	public String toString() {
		return "Questions [qustId=" + qustId + ", ques_1=" + ques_1 + ", ques_2=" + ques_2 + ", ques_3=" + ques_3
				+ ", ques_4=" + ques_4 + ", ques_5=" + ques_5 + "]";
	}
	

	
	
}
