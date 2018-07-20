package com.capgemini.service;

import java.util.List;

import com.capgemini.bean.AccountDetails;

public interface IPaymentService {
	
public int createAccount(AccountDetails details);
	
	public boolean login(AccountDetails details);
	
	public double showBalance();
	
	public int deposit(double amount);
	
	public int withdraw(double amount);
	
	public int fundTransfer(long toAccNo,double amount);
	
	public void printTransaction();

    public void logout();
}
