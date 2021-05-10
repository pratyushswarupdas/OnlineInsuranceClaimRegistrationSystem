package com.capgemini.claim.dao;

import java.sql.SQLException;
import java.util.List;

import com.capgemini.claim.bean.Claim;
import com.capgemini.claim.bean.User;
import com.capgemini.claim.customexp.CustomException;

public interface ClaimDao {

	public abstract void claimCreation(Claim claim)throws CustomException;
	public abstract List<Claim> viewReport(User user) throws SQLException;
}
