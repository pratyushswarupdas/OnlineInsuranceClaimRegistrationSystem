package com.capgemini.claim.service;

import java.util.List;

import com.capgemini.claim.bean.Claim;
import com.capgemini.claim.bean.Questions;
import com.capgemini.claim.bean.User;
import com.capgemini.claim.customexp.CustomException;

public interface IClaimService {

	public abstract void claimCreation(User user) throws CustomException;
	public abstract List<Claim> viewReport(User user);
	public abstract long calcClaimAmount(Questions q);
	

}
