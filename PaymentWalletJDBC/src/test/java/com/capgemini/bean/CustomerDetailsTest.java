package com.capgemini.bean;

import static org.junit.Assert.*;

import org.junit.Test;

public class CustomerDetailsTest {
	CustomerDetails data=new CustomerDetails();

	@Test
	public void testGetFirstName() {
		//fail("Not yet implemented");
		
		data.setFirstName("Gangishetty");
		assertNotNull(data);
		assertEquals("Gangishetty",data.getFirstName());
		assertTrue("Gangishetty".equalsIgnoreCase(data.getFirstName()));
	}

	@Test
	public void testGetLastName() {
		//fail("Not yet implemented");
		
		
		
		data.setFirstName("Vineetha");
		assertNotNull(data);
		assertEquals("Vineetha",data.getLastName());
		assertTrue("Vineetha".equalsIgnoreCase(data.getLastName()));
	}

	@Test
	public void testGetGender() {
		//fail("Not yet implemented");
	
	
	
	
	}

	@Test
	public void testGetAge() {
		//fail("Not yet implemented");
		
	
		data.setAge(20);
		assertEquals(20,data.getAge());
	
	
	
	
		
		
	}

	@Test
	public void testGetMobileNo() {
		//fail("Not yet implemented");
		
		/*
		data.setMobileNo(987661234);
		assertEquals(987661234, data.getPhone());*/
	}

	@Test
	public void testGetEmail() {
		//fail("Not yet implemented");
		
		
		data.setEmail("vinni@gmail.com");
		assertEquals("vinni@gmail.com", data.getEmail());
	}

	@Test
	public void testGetLocation() {
		//fail("Not yet implemented");
	}

	@Test
	public void testGetAadhar() {
		//fail("Not yet implemented");
	}

}
