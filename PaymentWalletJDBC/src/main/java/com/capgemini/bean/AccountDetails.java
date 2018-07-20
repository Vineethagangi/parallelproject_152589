package com.capgemini.bean;


	import java.time.LocalDate;
	import java.util.ArrayList;
	import java.util.HashMap;
	import java.util.List;
	import java.util.Map;

	public class AccountDetails {

		
		private long accountNumber;
		
		private String username;
		private String password;
		private double balance;
		
		private String branch;
		
		
		private CustomerDetails customer;
		
		

		public long getAccountNumber() {
			return accountNumber;
		}
		public void setAccountNumber(long accountNumber) {
			this.accountNumber = accountNumber;
		}
		
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		
		
		public double getBalance() {
			return balance;
		}


		public void setBalance(double balance) {
			this.balance = balance;
		}
		
		public CustomerDetails getCustomer() {
			return customer;
		}
		public void setCustomer(CustomerDetails customer) {
			this.customer = customer;
		}
		
		public String getBranch() {
			return branch;
		}
		public void setBranch(String branch) {
			this.branch = branch;
		}
		
		
	}



