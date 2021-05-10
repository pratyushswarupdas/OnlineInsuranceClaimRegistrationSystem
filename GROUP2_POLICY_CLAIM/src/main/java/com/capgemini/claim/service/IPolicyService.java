package com.capgemini.claim.service;


import java.util.List;

import com.capgemini.claim.bean.Policy;
import com.capgemini.claim.bean.User;

public interface IPolicyService {
public abstract void createPolicy(User user,long bankAccNo,double premiumAmount,int questionId);
public abstract List<Policy> viewPolicy(User user);

}
