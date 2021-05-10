package com.capgemini.claim.dao;

import java.util.List;

import com.capgemini.claim.bean.Policy;
import com.capgemini.claim.bean.PolicyDetails;
import com.capgemini.claim.bean.User;

public interface PolicyDao {
	
	public abstract List<Policy> viewPolicy(User user);
	public abstract void setPolicy(Policy p);
	public abstract void setPolicyDetails(PolicyDetails pd, Policy p);


}
