package com.capgemini.e_wallet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Scanner;

import com.capgemini.bean.AccountDetails;
import com.capgemini.bean.CustomerDetails;
import com.capgemini.service.DataValidate;
import com.capgemini.service.PaymentService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    		int choice;
    		
    		do
    		{
    			int choice1;
    			Scanner sc=new Scanner(System.in);
    			System.out.println("E-WALLET");
    			System.out.println("1.Create Account");
    			System.out.println("2.Login");
    			System.out.println("3.EXIT");
    			choice=sc.nextInt();
    			switch(choice)
    			{
    			case 1:
    				
    				createAccount();
    				break;
    			
    			case 2:
    				
    				boolean b= login();
    				if(b)
    				{
    					do
    					{
    						System.out.println("1.Show Balance");
    						System.out.println("2.Deposit Amount");
    						System.out.println("3.Withdraw Amount");
    						System.out.println("4.Fund Transfer");
    						System.out.println("5.Print Transaction");
    						System.out.println("6.Exit");
    						System.out.println("Enter your choice");
    						choice1=sc.nextInt();
    						switch(choice1)
    						{
    						case 1:
    							display();
    							break;
    						
    						case 2:
    							deposit();
    							break;
    							
    						case 3:
    							withdraw();
    							break;
    						
    						case 4:
    							fundTransfer();
    							break;
    							
    						case 5:
    							printTransaction();
    							break;
    							
    						default:
    							break;
    						}
    					}
    						while(choice1!=6);
    						
    					
    					}
    				else
    				{
    					System.out.println("Invalid Login Details");
    				}
    				break;
    				
    			case 3:
    				System.exit(0);
    				}
    		}
    		while(choice!=3);
    	}

	private static void printTransaction() {
		// TODO Auto-generated method stub
		PaymentService service=new PaymentService();
		java.util.List<String> l1=service.printTransaction();
		Iterator<String> it=l1.iterator();
		  while(it.hasNext())
		  {
			  String s=it.next();
			  System.out.println(s);
		  }
		
	}

	private static void fundTransfer() {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		PaymentService service = new PaymentService();
		System.out.println("Enter Account Number to transfer amount");
		int accnum=sc.nextInt();
		System.out.println("Enter the amount to be transfered");
		int amount=sc.nextInt();
		boolean b=service.fundTransfer(accnum,amount);
		if(b)
		{
			System.out.println("Amount Transferred Scuuceesully");
	    }
		else
		{
			System.out.println("Enter the correct details");
		}
	}

	private static void withdraw() {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		PaymentService service = new PaymentService();
		
		System.out.println("Enter amount to be withdrawn");
		int amount=sc.nextInt();
		boolean deposit=service.withdraw(amount);
		
		if(deposit)
		{
			System.out.println("Amount Deposited");
      	}
		
	}

	private static void deposit() {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		PaymentService service = new PaymentService();
		
		System.out.println("Enter amount to be deposited");
		int amount=sc.nextInt();
		boolean deposit=service.deposit(amount);
		
		if(deposit)
		{
			System.out.println("Ammount Deposited");
      	}
		
	}

	private static void display() {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		PaymentService service = new PaymentService();
		int balance=service.showBalance();
		System.out.println("Balance"+balance);
		
	}

	private static boolean login() {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		PaymentService service = new PaymentService();
		System.out.println("Enter the username");
		String username=sc.next();
		System.out.println("Enter the password");
		String password=sc.next();
		
		boolean b=service.login(username,password);
		if(true)
		{
			return true;
		}
		else
			return false;
	}

	private static void createAccount() {
		// TODO Auto-generated method stub

		boolean b = false;
		boolean isValidName;
		boolean isValidAge; 
		boolean isValidMobile; 
		boolean isValidAadhar;
		
		DataValidate validate = new DataValidate();
		
		PaymentService service = new PaymentService();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String name;
		try {
			System.out.println("enter the name");
			name = br.readLine();
			System.out.println("enter the age");
			String age = br.readLine();
			System.out.println("enter the aadhar");
			String aadhar = br.readLine();
			System.out.println("enter the email");
			String email = br.readLine();
			System.out.println("enter the phone");
			String phone = br.readLine();
			System.out.println("enter username");
			String username=br.readLine();
			System.out.println("enter the password");
			String password=br.readLine();
			System.out.println("enter the initial balance" );
			String balance=br.readLine();
			
			int id = (int) (Math.random() * 1234 + 9999);
			System.out.println("Your account id is:" + id);
			
			 CustomerDetails details = new CustomerDetails();
				details.setName(name);
				details.setAge(Integer.parseInt(age));
				details.setEmail(email);
				details.setAadhar(Long.parseLong(aadhar));
				details.setPhone(Long.parseLong(phone));
				details.setUsername(username);
				details.setPassword(password);
			
				AccountDetails details2=new AccountDetails();
				details2.setBalance(Integer.parseInt(balance));
				details2.setId(id);
				details2.setDetails(details);
			
         
			
			
			isValidName = validate.validateName(name); 
			isValidAge = validate.validateAge(age); 
			
			isValidMobile = validate.validateMobile(phone); 
			isValidAadhar = validate.validateAadhar(aadhar);
			if (isValidName && isValidAge && isValidMobile && isValidAadhar) 
			{
				b=service.createAccount(details2);
		    } 
			else
			{
				System.out.println("Invalid Data");
			}
		}
			catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		      }
		

		if(b)
			{
				System.out.println("Account Created");
		    } 
			else 
			{
			System.out.println("Wrong Details");
		    }
		
	    
	}
	
    	
    }

