package com.mastek.leaverequest;

import java.io.OutputStream;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class LeaveRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int empno;
	int duration;
	int leavedate;
	int returndate;
	String employeeName;
	String manager;
	private int daysavailable = 24;
	
	 
	String file = "leave-requests.dat";
	
	public LeaveRequest() {
		
	}
	
	public LeaveRequest(int leavedate, int returndate, int duration, String manager, int empno) {
		this.duration = duration;
		this.leavedate = leavedate;
		this.returndate = returndate;
		this.manager = manager;
		this.empno = empno;
	}
	
	
	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public int getEmpno() {
		return empno;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	public void reduceDays(int days) {
		this.daysavailable = daysavailable - days;
	}
	
	public int durationRemaining() {
		return this.daysavailable;
	}
	
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	
	public void makeRequest() {
		
	}

	public void setLDate(int date) {
		this.leavedate = date;
	}

	public void setRDate(int date) {
		this.returndate = date;
		// TODO Auto-generated method stub
	}
	public int getLDate() {
		return leavedate;
	}
	
	public int getRDate() {
		return returndate;
	}
	
	public void toList() {
		
	}
	@Override
	public String toString() {
		String output = "added request for " + this.duration + " days leave between " 
					+ this.leavedate+ " and " + this.returndate;
		return output;
	}
	
}
