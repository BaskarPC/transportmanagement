package com.service;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.dao.LabourDAO;
import com.vo.DieselVO;
import com.vo.LabourVO;

public class LabourService {
	private static final Logger logger=(Logger)Logger.getLogger(LabourService.class);

	LabourDAO labourDAO=new LabourDAO();
	LabourVO lvo=new LabourVO();
	public ArrayList fetchInst()throws Exception
	{
		ArrayList userList=labourDAO.fetchInst();
		logger.debug("Inside Service"+userList.size());
		return userList;
	}
	
	public ArrayList fetchType()throws Exception {
		// TODO Auto-generated method stub
		ArrayList userList=labourDAO.fetchType();
		logger.debug("Inside Service"+userList.size());
		return userList;
	}
	
	public ArrayList fetchVehicle()throws Exception {
		// TODO Auto-generated method stub
		ArrayList userList=labourDAO.fetchVehicle();
		logger.debug("Inside Service"+userList.size());
		return userList;
	}
	public ArrayList instMethod(int instname) {
		// TODO Auto-generated method stub
		ArrayList list=new ArrayList();
		list=labourDAO.instMethod(instname);
		return list;
		
	}

	public ArrayList vehicleMethod(int vehtype) {
		// TODO Auto-generated method stub
		ArrayList list=new ArrayList();
		logger.debug("Service Called.................");
		list=labourDAO.vehicleMethod(vehtype);
		return list;
	}
	public void insertmaster(int jobid, int institution_name, int vehicle_type, int vehicle_number, String req_date) {
		// TODO Auto-generated method stub
		labourDAO.insertmaster(jobid, institution_name, vehicle_type,vehicle_number,req_date);
	}

	public void insert(int jobid, float amount, String now,String other_purpose) {
		// TODO Auto-generated method stub
		labourDAO.insert(jobid,amount,now,other_purpose);
	}

	public ArrayList fetchLabour() {
		// TODO Auto-generated method stub
		ArrayList list=new ArrayList();
		logger.debug("Service Called.................");
		list=labourDAO.fetchLabour();
		return list;
	}

	public ArrayList retrieve(int job) {
		// TODO Auto-generated method stub
		ArrayList list=new ArrayList();
	    list=labourDAO.retrieve(job);
	    return list;
	}
	public ArrayList retrieveMaster(int job) {
		// TODO Auto-generated method stub
		ArrayList list=new ArrayList();
	    list=labourDAO.retrieveMaster(job);
	    return list;
	}
	
}
