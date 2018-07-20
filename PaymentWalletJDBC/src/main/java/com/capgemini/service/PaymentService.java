package com.capgemini.service;

import java.util.List;

import com.capgemini.bean.AccountDetails;
import com.capgemini.dao.PaymentDAO;

public class PaymentService implements IPaymentService{

	
	PaymentDAO dao=new PaymentDAO();
	public int createAccount(AccountDetails details) {
		// TODO Auto-generated method stub
		return dao.createAccount(details);
	}

	public boolean login(AccountDetails details) {
		// TODO Auto-generated method stub
		return dao.login(details);
	}

	public double showBalance() {
		// TODO Auto-generated method stub
		return dao.showBalance();
	}

	public int deposit(double amount) {
		// TODO Auto-generated method stub
		return dao.deposit(amount);
	}

	public int withdraw(double amount) {
		// TODO Auto-generated method stub
		return dao.withdraw(amount);
	}

	public int fundTransfer(long toAccNo, double amount) {
		// TODO Auto-generated method stub
		return dao.fundTransfer(toAccNo, amount);
	}

	public void printTransaction() {
		// TODO Auto-generated method stub
	   dao.printTransaction();
	}

	public void logout() {
		// TODO Auto-generated method stub
		dao.logout();
	}

}
