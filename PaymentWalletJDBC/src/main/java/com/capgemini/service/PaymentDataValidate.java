package com.capgemini.service;

public class PaymentDataValidate {
public boolean validFirstName(String firstName) {
		
		if(!firstName.isEmpty())
			return true;
		else
			return false;
		
	}
	public boolean validLastName(String lastName) {
		
		if(!lastName.isEmpty())
			return true;
		else
			return false;
		
	}
	public boolean validGender(String gender) {
		
		if(gender.equalsIgnoreCase("male") || gender.equalsIgnoreCase("female")  )
			return true;
		else
			return false;
		
	}
	public boolean validUsername(String username) {
		
		if(!username.isEmpty())
			return true;
		else
			return false;
		
		
	}
	public boolean validPassword(String password) {
		
		if(!password.isEmpty() && password.length()>=4)
			return true;
		else
			return false;
		
	}
	
	public boolean validEmail(String email) {
		
		if(!email.isEmpty())
			return true;
		else
			return false;
	}
	
		
	
	public boolean validloc(String location) {
		
		if(!location.isEmpty())
			return true;
		else
		return false;
		
	}
	public boolean validBranch(String branch) {
		
		if(!branch.isEmpty())
			return true;
		else
		return false;
		
	}
	

}
