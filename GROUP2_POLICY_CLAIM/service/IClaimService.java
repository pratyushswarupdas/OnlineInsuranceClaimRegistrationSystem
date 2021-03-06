package com.capgemini.claim.service;

import java.sql.SQLException;
import java.util.List;

import com.capgemini.claim.bean.Claim;
import com.capgemini.claim.bean.User;

public interface IClaimService {

	public abstract void claimCreation(User user);
	public abstract List<Claim> viewReport(User user)throws SQLException;

}
