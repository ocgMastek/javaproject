package com.mastek.leaverequest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FileManager {
	
	static LeaveRequest levr = new LeaveRequest();
	List<LeaveRequest> lrq = new LinkedList<>();
	
	//Map<String, LeaveRequest> objMap = new HashMap<String,LeaveRequest>();
	
	static final String FILELOC = "data/reqs.dat";
	public static void main(String[] args) {
		
		
		System.out.println("writing object data to file");
		FileManager fm = new FileManager();
		levr.setEmployeeName("Oliver");
		levr.setDuration(8);
		levr.setEmpno(61072);
		fm.writeDataToFile(levr);
		//fm.readDataFromFile();
	}
	
	
	public boolean writeDataToFile(LeaveRequest levrq) {
//		System.out.println("writeData called");
		File objectStorage = new File(FILELOC);
		Map<String, LeaveRequest>levrqMap = null;
		
		try(ObjectInputStream objin = new ObjectInputStream(new FileInputStream(objectStorage))){
			levrqMap=(Map<String, LeaveRequest>) objin.readObject();
		} catch (IOException | ClassNotFoundException ex) {

			ex.printStackTrace();
		
		}
		if(levrqMap==null) {
			levrqMap = new HashMap<>();
		}
		
		levrqMap.put(levrq.getEmployeeName(), levrq);
		
		try(ObjectOutputStream objout = new ObjectOutputStream(new FileOutputStream(FILELOC))){
			objout.writeObject(levrqMap);
		} catch(IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
//	public void writeDataToFile() {
//		File filelocation = new File(fileloc);
//		levr.setDuration(10);
//		levr.setLDate(10102018);
//		Map<String, LeaveRequest> levrMap = null; 
//		//SORT THIS OUT TOMORROWWW
////		leavereq=(Map<String, LeaveRequest>)
//		try(ObjectOutputStream objout = new ObjectOutputStream(new FileOutputStream(filelocation))){
//			levrMap = (Map<String, LeaveRequest>)objout.defaultWriteObject();
//			
////			levrMap=(Map<String,LeaveRequest>)objout.readObject();
////			objout.writeObject(leavereq);
////			objout.close();
//			System.out.println("added " + levr + " to file");
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}

	
	public LeaveRequest readDataFromFile() {	
		File fileLocation = new File(FILELOC);
		
		Map<String,LeaveRequest> leavereq = null;
		try(ObjectInputStream objin = new ObjectInputStream(new FileInputStream(fileLocation))){
			leavereq=(Map<String, LeaveRequest>)objin.readObject();
			System.out.println(leavereq);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		if(leavereq!=null) {
//			return leavereq.get(key)
//		}
		return null;
	}
}
