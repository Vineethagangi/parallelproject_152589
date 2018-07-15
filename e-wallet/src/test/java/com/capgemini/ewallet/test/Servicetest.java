package com.capgemini.ewallet.test;

import com.capgemini.bean.AccountDetails;

import junit.framework.Assert;

public class Servicetest {

	AccountDetails details=new AccountDetails();


	public void testAddAccountDetails() {
		//fail("Not yet implemented");
		
		Assert.assertEquals("RESULT", 0, 0);
		Assert.assertEquals("1234567890","1234567890" );
		Assert.assertFalse("vineetha",false);
	}


	public void testShowBalance() {
		//fail("Not yet implemented");
		Assert.assertEquals("RESULT", 0, 0);
		Assert.assertNotSame("1000","1500" );
		Assert.assertNotSame("101",details.getId());
	}

	
	public void testDeposit() {
		//fail("Not yet implemented");
		Assert.assertEquals("RESULT", 0, 0);
		Assert.assertNotSame("1000","1500" );
		Assert.assertNotSame("101",details.getId());
	}

	
	public void testWithdraw() {
		//fail("Not yet implemented");
		Assert.assertEquals("RESULT", 0, 0);
		Assert.assertNotSame("100","150" );
		Assert.assertNotSame("101",details.getId());
	}
	
	public void testFundTransfer() {
		//fail("Not yet implemented");
		Assert.assertEquals("RESULT", 0, 0);
		Assert.assertNotSame("100","150" );
		Assert.assertNotSame("101",details.getId());
	}

	public void testPrintTransaction() {
		//fail("Not yet implemented");
		Assert.assertEquals("RESULT", 0, 0);
		Assert.assertNotSame("100","150" );
		Assert.assertNotSame("101",details.getId());
}
	}
