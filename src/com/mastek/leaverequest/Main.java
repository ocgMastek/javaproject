package com.mastek.leaverequest;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	
	static List<LeaveRequest> lrq = new LinkedList<>();
	
	public static void main(String[] args) throws IOException {
		
		populateListWithTempData();
		
		final int empno_const = 61074;
		boolean menuTrue = true;
		Employee emp = new Employee();
		Scanner userInput = new Scanner(System.in);
		
		System.out.println("Enter employee number: ");
		int empno = userInput.nextInt();
		//login.close();
		
		if(empno == emp.getEmpno()) {
		
			while(menuTrue) {
				menuOptions();
				System.out.print("Choice:");
				int menuSelection = userInput.nextInt();
				//nuScan.close();
				
				switch(menuSelection) {
					case 1:
						System.out.println("Previous Leave Requests");
						break;
					case 2:
						System.out.println("Make new leave requests");
						makeRequest(emp.getEmpno(),emp.getName());
						break;
					case 3:
						System.out.println("Cancel leave request");
						remove();
						break;
					case 4:
						System.out.println("Summary of requests \n");
						getRequests();
						break;
					case 5:
						System.out.println("Shutting down...");
						System.exit(0);
						break;
				}
			}
			userInput.close();
		} else {
			System.exit(0);
		}
			
	}	
	
	static void makeRequest(int empno, String empname) {
		LeaveRequest lrqObj = new LeaveRequest();
		
		Scanner lrqInput = new Scanner(System.in);
		
		System.out.print("Leave date: ");
		int leavedate = Integer.parseInt(lrqInput.nextLine());
		
		System.out.print("Return date: ");
		int returndate = Integer.parseInt(lrqInput.nextLine());
		
		System.out.print("Duration of leave: " );
		int duration = Integer.parseInt(lrqInput.nextLine());
		
		lrqObj.setLDate(leavedate);
		lrqObj.setRDate(returndate);
		lrqObj.setDuration(duration);
		lrq.add(lrqObj);
		
		System.out.println(lrqObj);
		//lrq.add(lrqObj.getLDate(), lrqObj.getRDate());
		
		//add all input values to lrqobj
		//store lrqobj in as a new LeaveRequest linkedList value
	}
	
	static void populateListWithTempData() {
		LeaveRequest tempDataObj = new LeaveRequest();
		LeaveRequest tempDataObj2 = new LeaveRequest();
		LeaveRequest tempDataObj3 = new LeaveRequest();
		
		tempDataObj.setLDate(2012);
		tempDataObj.setRDate(2912);
		tempDataObj.setDuration(9);
		
		tempDataObj2.setLDate(2010);
		tempDataObj2.setRDate(2910);
		tempDataObj2.setDuration(9);
		
		tempDataObj3.setLDate(1512);
		tempDataObj3.setRDate(2012);
		tempDataObj3.setDuration(5);
		
		lrq.add(tempDataObj);
		lrq.add(tempDataObj2);
		lrq.add(tempDataObj3);
	}
	
	static void getRequests() {
		//print all existing requests in the list
		//also print their indexes next to them, so they have the index values to remove
		//when using the remove statement
		for(int i = 0; i < lrq.size(); i += 1) {
			System.out.println("request at index " + i + " : " + lrq.get(i));
		}
	}
	

	
//	static void loadFile() {
//		 final String filelocation = "data/leaverequests.dat";
//		
//		 try(ObjectInputStream objin = new ObjectInputStream(new FileInputStream(filelocation))){
//			 
////				 lrq.add(objin);
//			 
//		 } catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
	static void remove() {
		//take index of object as parameter
		//remove that index value
		System.out.println("Enter the index of the value to remove");
		Scanner deleteInput = new Scanner(System.in);
		int index = Integer.parseInt(deleteInput.nextLine());
		lrq.remove(index);
		System.out.println("Removed leave request: " + index);
		//add remove from list logic here, using index as the list index value
		
	}
	
	static void saveData(LeaveRequest obj) {
		 final String filelocation = "data/leaverequests.dat";
		 
		 try(ObjectOutputStream objoutput = new ObjectOutputStream(new FileOutputStream(filelocation))){
			 objoutput.writeObject(obj);
			 objoutput.close();
		 } catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static void menuOptions() {
		System.out.println("-------------");
		System.out.println("Menu options");
		System.out.println("-------------");
		System.out.println("1: Previous leave requests");
		System.out.println("2: Make new leave request");
		System.out.println("3: Cancel leave request");
		System.out.println("4: All previous requests");
		System.out.println("5: Quit Application");
	}
	
}

	

