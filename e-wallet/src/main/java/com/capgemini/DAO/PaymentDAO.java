package com.capgemini.DAO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.capgemini.bean.AccountDetails;

public class PaymentDAO implements IPaymentDAO{

	static HashMap<String,AccountDetails> map=new HashMap<String,AccountDetails>();

	static AccountDetails account;
	
	static List<String> transaction=new ArrayList<String>();
	
	int tid=(int)((Math.random()*123)+999);

	public boolean createAccount(AccountDetails details2) {
		// TODO Auto-generated method stub
		  for(String key:map.keySet())
		   {
			   if(details2.getDetails().getUsername().equals(key))
			   {
				   return false;
			   }
		   }
		   map.put(details2.getDetails().getUsername(),details2);
		   return true;
	}

	public int showBalance() {
		// TODO Auto-generated method stub
		return account.getBalance();
	}

	public boolean deposit(int amount) {
		// TODO Auto-generated method stub
		account.setBalance(account.getBalance()+amount);
		String deposit=tid+"Amount of"+amount+"is deposited: "+account.getBalance();
		transaction.add(deposit);
		return true;
	}

	public boolean withdraw(int amount) {
		// TODO Auto-generated method stub
		if(account.getBalance()>=(amount+1000))
		{
			account.setBalance(account.getBalance()-amount);
			String withdraw=tid+"Amount of"+amount+"is withdrawn"+account.getBalance();
			transaction.add(withdraw);
			return true;
		}
		else
		{
			System.out.println("minimum balance");
		}
		return false;
	}

	public boolean login(String username, String password) {
		// TODO Auto-generated method stub
		for(String key:map.keySet())
		{
		account=map.get(key);	
			if(account.getDetails().getUsername().equals(username) && account.getDetails().getPassword().equals(password))
			{
				return true;
			}
		}
		return false;
	}

	public boolean fundTransfer(int accnum, int amount) {
		// TODO Auto-generated method stub
		if(account.getBalance()<(amount+1000))
		{
			System.out.println("Minimum Balance");
			return false;
		}
		for(String key:map.keySet())
		{
			AccountDetails ac=map.get(key);
			if(ac.getId()==accnum)
			{
				ac.setBalance(ac.getBalance()+amount);
				account.setBalance(account.getBalance()-amount);
				String transfer=tid+"Amount of"+amount+"is withdrawn from"+account.getBalance()+"add deposited in"+ac.getId();
				return true;
			}
		}
		System.out.println("Incorecct");
		return false;
	}

	public List<String> printTransaction() {
		// TODO Auto-generated method stub
		return transaction;
	}

}
