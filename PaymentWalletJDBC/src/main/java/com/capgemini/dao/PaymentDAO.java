package com.capgemini.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.capgemini.bean.AccountDetails;
import com.capgemini.util.JDBCUtil;

public class PaymentDAO implements IPaymentDAO{
	
	
	static Connection connect;
	static double balance;
	static long aadhar,accountNumber;
	

	public int createAccount(AccountDetails details) {
		// TODO Auto-generated method stub
		
		
		int u=0, v=0;
		
		
	
		try {
			connect=JDBCUtil.getConnection();
			String insertCustomerDetails="insert into CustomerDetails values(?,?,?,?,?,?,?,?)";
			java.sql.PreparedStatement pstmtC=connect.prepareStatement(insertCustomerDetails);
			
			
			pstmtC.setString(1,details.getCustomer().getFirstName());
			pstmtC.setString(2,details.getCustomer().getLastName());
			pstmtC.setString(3, details.getCustomer().getGender());
			pstmtC.setInt(4,details.getCustomer().getAge());
			pstmtC.setLong(5, details.getCustomer().getAadhar());
			pstmtC.setLong(6, details.getCustomer().getMobileNo());
			pstmtC.setString(7, details.getCustomer().getEmail());
			pstmtC.setString(8, details.getCustomer().getLocation());
			
			
			
			u=pstmtC.executeUpdate();
			
			
			String insertAccountDetails= "insert into AccountDetails values(?,?,?,?,?)";
			java.sql.PreparedStatement pstmtA=connect.prepareStatement(insertAccountDetails);
			
			
			pstmtA.setLong(1,details.getAccountNumber());
			pstmtA.setString(2,details.getUsername());
			pstmtA.setString(3, details.getPassword());
			pstmtA.setDouble(4,details.getBalance());
			pstmtA.setLong(5, details.getCustomer().getAadhar());
			
			v=pstmtA.executeUpdate();
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connect.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		if(u==1 && v==1) {
			return 1;
		}
		return 0;
	}

	public boolean login(AccountDetails details) {
		// TODO Auto-generated method stub
		int u=0;
		
		try {
			connect=JDBCUtil.getConnection();
			String loginQ="select * from AccountDetails where username= '"+details.getUsername()+"' AND password= '"+details.getPassword()+"'";
			java.sql.PreparedStatement pstmtL=connect.prepareStatement(loginQ);
			ResultSet resultLogin=pstmtL.executeQuery();
			
		
			
			if(resultLogin.first())
			{
				u=1;
				aadhar=resultLogin.getLong(5);
				balance=resultLogin.getLong(4);
				accountNumber=resultLogin.getLong(1);
			}
			
			if(u==1)
				return true;	
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
		
	}

	public double showBalance() {
		// TODO Auto-generated method stub
		
		return balance;
	}

	public int deposit(double amount) {
		// TODO Auto-generated method stub
		
		
		try {
			String depositQ="update accountdetails set balance="+(balance+amount)+"where aadhar="+aadhar;
		    java.sql.PreparedStatement deposit;
			deposit = connect.prepareStatement(depositQ);
			 if(deposit.executeUpdate()==1) {
			    	
			    	String transaction="Deposited:"+Double.toString(amount)+"to"+accountNumber;
			    	balance=balance+amount;
			    	String insertTrans="insert into transactions values("+aadhar+" , '"+transaction+"')";
			        java.sql.PreparedStatement trans=connect.prepareStatement(insertTrans);
			        
			        
			        trans.executeUpdate();
			        return 1;
			 
			 
			 }
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	   
	return 0;
	
	}
	public int withdraw(double amount) {
		// TODO Auto-generated method stub
		
		try {
			String withdrawQ="Update accountdetails set balance="+(balance-amount)+"where aadhar="+aadhar;
		    java.sql.PreparedStatement deposit=connect.prepareStatement(withdrawQ);
			
			 if(deposit.executeUpdate()==1) {
			    	
			    	String transaction="withdrawn"+Double.toString(amount)+"from"+Long.toString(accountNumber);
			    	
			    	balance=balance-amount;
			    	String insertTrans="insert into transactions values("+aadhar+" , '"+transaction+"')";
			        java.sql.PreparedStatement trans=connect.prepareStatement(insertTrans);
			        
			        
			        trans.executeUpdate();
			        return 1;
			 
			 
			 }
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	   
	return 0;	
		
		
		
		
		
		
	}

	public int fundTransfer(long toAccNo, double amount) {
		// TODO Auto-generated method stub
		
	
	try {
		String toAccQ="select * from accountdetails where accountNumber="+toAccNo;
		java.sql.PreparedStatement toAcc=connect.prepareStatement(toAccQ);
		ResultSet Transfer=toAcc.executeQuery();
		
		
		
		
		if(Transfer.first()) {
			String withdrawQ="Update accountdetails set balance="+(balance-amount)+"where aadhar="+aadhar;
		    java.sql.PreparedStatement deposit=connect.prepareStatement(withdrawQ);
			
		    if(deposit.executeUpdate()==1) {
		    	
		    	String transaction="transfer"+Double.toString(amount)+"to"+Long.toString(toAccNo);
		    	String insertTrans="insert into transactions values("+aadhar+" , '"+transaction+"')";
		        java.sql.PreparedStatement trans=connect.prepareStatement(insertTrans);
		        
		        
		        trans.executeUpdate();
		       
		    }
		    
		    
		    double bal=Transfer.getDouble(4)+amount;
		    
		    String depositQ="update accountdetails set balance="+(balance+amount)+"where aadhar="+aadhar;
		    java.sql.PreparedStatement depositA;
			depositA = connect.prepareStatement(depositQ);
		    
			
			 if(deposit.executeUpdate()==1) {
			    	
			    	String transaction="received"+Double.toString(amount)+"from"+Long.toString(accountNumber);
			    	String insertTrans="insert into transactions values("+Transfer.getLong(5)+", '"+transaction+"')";
			        java.sql.PreparedStatement trans=connect.prepareStatement(insertTrans);
			        
			        
			        trans.executeUpdate();
			        return 1;  
		    
		    
		    
		    
			 }
			 else
				 return 0;
		    
		    
		    
		    
		    
		    
		    
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
		
		
		
		
		
	return 0;	
		
		
		
		
		
		
		
		
		
		
	}

	public void printTransaction() {
		// TODO Auto-generated method stub
	String printQ="Select transactioninfo from transactions where aadhar="+aadhar;
	java.sql.PreparedStatement print;
	try {
		print = connect.prepareStatement(printQ);
		ResultSet transactions=print.executeQuery();
		while(transactions.next()) {
			System.out.println(transactions.getString(1));
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
	

	}
    public void logout() {
    	try {
			connect.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
}
