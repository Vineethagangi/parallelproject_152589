package com.capgemini.ewallet.test;

import com.capgemini.service.DataValidate;

import junit.framework.Assert;
import junit.framework.TestCase;

public class DataValidateTest extends TestCase{
	
	 DataValidate validate = new DataValidate();
		public void testValidateName() {
			//fail("Not yet implemented");
			Assert.assertEquals("result", true, true);
			Assert.assertNotNull("vineetha", "vineetha");
			Assert.assertFalse("vineetha",false);
			Assert.assertEquals("vineetha", "vineetha");
		}

		public void testValidateAge() {
			//fail("Not yet implemented");
			Assert.assertEquals("result", true, true);
			Assert.assertNotNull("2", "3");
			Assert.assertFalse("35",false);
			Assert.assertEquals("20", "20");
		}

		public void testValidateEmail() {
			//fail("Not yet implemented");
			Assert.assertEquals("result", true, true);
			Assert.assertNotNull("vinni@gmail.com", "vinni@gmail.com");
		}
		
		public void testValidateMobile() {
			//fail("Not yet implemented");
			Assert.assertEquals("result", true, validate.validateMobile("8171590847"));
			Assert.assertNotNull("1234567890", "1234567890");
		}

		public void testValidateAadhar() {
			//fail("Not yet implemented");
			Assert.assertEquals("result", true, true);
			Assert.assertNotNull("9999888897", "9876987698");
		}



}
