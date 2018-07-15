package com.capgemini.service;

import java.util.List;


import com.capgemini.DAO.PaymentDAO;
import com.capgemini.bean.AccountDetails;

public class PaymentService implements IPaymentService{
	
	PaymentDAO dao=new PaymentDAO();

	public boolean createAccount(AccountDetails details2) {
		// TODO Auto-generated method stub
		return dao.createAccount(details2);
	}

	public int showBalance() {
		// TODO Auto-generated method stub
		return dao.showBalance();
	}

	public boolean deposit(int amount) {
		// TODO Auto-generated method stub
		return dao.deposit(amount);
	}

	public boolean withdraw(int amount) {
		// TODO Auto-generated method stub
		return dao.withdraw(amount);
	}

	public boolean login(String username, String password) {
		// TODO Auto-generated method stub
		return dao.login(username, password);
	}

	public boolean fundTransfer(int accnum, int amount) {
		// TODO Auto-generated method stub
		return dao.fundTransfer(accnum, amount);
	}

	public List<String> printTransaction() {
		// TODO Auto-generated method stub
		return dao.printTransaction();
	}
	
	
	

}
