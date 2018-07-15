package com.capgemini.bean;

public class AccountDetails {
	
	//declaring the variables

		private int balance;
		private int id;
		private CustomerDetails details;
		
		
		//getters and setters
		
		public void setBalance(int balance) {
			this.balance = balance;
		}
		public void setId(int id) {
			this.id = id;
		}
		public void setDetails(CustomerDetails details) {
			this.details = details;
		}
		public int getBalance() {
			return balance;
		}
		public int getId() {
			return id;
		}
		public CustomerDetails getDetails() {
			return details;
		}
		
		//overriding of to string method
		@Override
		public String toString() {
			return "AccountDetails [balance=" + balance + ", id=" + id + ", details=" + details + "]";
		}
		
		
		
	}



