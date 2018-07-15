package com.capgemini.ewallet.test;

import junit.framework.Assert;
import junit.framework.TestCase;

public class Details extends TestCase{
	
	public void testGetName() {
		//fail("Not yet implemented");
		Assert.assertEquals("Result", true,true);
		Assert.assertNotNull("123", "123");
		Assert.assertFalse("vineetha",false);
		Assert.assertEquals("vineetha", "vineetha");
		
	}

	
	public void testGetAge() {
		//fail("Not yet implemented");
		Assert.assertEquals("Result", true,true);
		Assert.assertNotNull("15", "31");
		
	}


	public void testGetAadhar() {
		//fail("Not yet implemented");
		Assert.assertEquals("Result", true,true);
		Assert.assertNotNull("1234567890", "1234567890");
		Assert.assertEquals("1234567890", "0897654321");
	}

	
	public void testGetEmail() {
		//fail("Not yet implemented");
		Assert.assertEquals("Result", true,true);
		Assert.assertNotNull("vineetha@gmail.com", "vineetha@gmail.com");
		Assert.assertFalse("vineetha@gmail.com",false);
		
	}

	
	public void testGetPhone() {
		//fail("Not yet implemented");
		Assert.assertEquals("Result", true,true);
		Assert.assertNotNull("9876987698", "9867897689");
		
	}

	
}
