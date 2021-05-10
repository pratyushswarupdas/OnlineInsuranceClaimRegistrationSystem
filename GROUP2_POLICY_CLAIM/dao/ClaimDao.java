package com.capgemini.claim.dao;

import java.sql.SQLException;
import java.util.List;

import com.capgemini.claim.bean.Claim;
import com.capgemini.claim.bean.User;

public interface ClaimDao {

	public abstract void claimCreation(Claim claim);
	public abstract List<Claim> viewReport(User user) throws SQLException;
}
