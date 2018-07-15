package com.capgemini.service;

import java.util.List;

import com.capgemini.bean.AccountDetails;

public interface IPaymentService {
	
	public boolean createAccount(AccountDetails details2);

	public int showBalance();

	public boolean deposit(int amount);

	public boolean withdraw(int amount);
	
	public boolean login(String username,String password);
	
	public boolean fundTransfer(int accnum,int amount);

	public List<String> printTransaction();

}
