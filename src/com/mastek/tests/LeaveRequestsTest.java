package com.mastek.tests;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.Request;

import com.mastek.leaverequest.Employee;
import com.mastek.leaverequest.LeaveRequest;

class LeaveRequestsTest {

	//@Before
	
	private Employee emp;
	private LeaveRequest rq;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("Set up before Class execution");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("Destroying content after Class execution");
	}

	
	@BeforeEach
	public void setUp() throws Exception {
		 emp = new Employee();
		 //emp.setEmpno(61074);
		// emp.setName("Oliver");
		 
		 rq = new LeaveRequest();
		 rq.setDuration(5);
		 rq.setManager("Rosie");
		 rq.setLDate();
		 rq.setRDate();
		 
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void empnoEqualsTest() throws Exception{
		assertEquals(61074, emp.getEmpno(), "Testing employee number is valid");
	}
	
	@Test
	void empnoNameEqualsTest() throws Exception{
		assertNotNull("Oliver", emp.getName());
	}
	
	@Test
	void rqDurationTest() throws Exception{
		assertEquals(5, rq.getDuration());
	}
	
	@Test
	void rqManagerNotNull() throws Exception {
		assertNotNull("Rosie", rq.getManager());
		assertNotNull("Sameer", rq.getManager());
	}
	
	@Test
	void leavedateTest() {
		
	}
	
	@Test void returndateTest() {
		
	}
	
	
	
	
	
	
}
