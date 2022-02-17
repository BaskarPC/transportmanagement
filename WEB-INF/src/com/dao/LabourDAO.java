package com.dao;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.dbcom.dbcom;
import com.util.LabourUtil;

public class LabourDAO {
	private static final Logger logger=(Logger)Logger.getLogger(LabourDAO.class);
	dbcom db=new dbcom();
	LabourUtil util=new LabourUtil();
	public ArrayList fetchInst()throws Exception
	{
		ArrayList list=new ArrayList();
		list=util.fetchInst();
		return list;
	}
	
	public ArrayList fetchType()throws Exception
	{
		ArrayList list=new ArrayList();
		list=util.fetchType();
		return list;
	}
	
	public ArrayList fetchVehicle()throws Exception
	{
		ArrayList list=new ArrayList();
		list=util.fetchVehicle();
		return list;
	}
	public ArrayList instMethod(int instname) {
		// TODO Auto-generated method stub
		ArrayList list=new ArrayList();
		list=util.instMethod(instname);
		return list;
	}
	public ArrayList vehicleMethod(int vehtype) {
		// TODO Auto-generated method stub
		ArrayList list=new ArrayList();
		logger.debug("DAO Called.................");
		list=util.vehicleMethod(vehtype);
		return list;
	}
	public void insertmaster(int jobid, int institution_name, int vehicle_type, int vehicle_number, String req_date) {
		// TODO Auto-generated method stub
		util.insertmaster(jobid, institution_name, vehicle_type,vehicle_number,req_date);
	}

	public void insert(int jobid, float amount, String now,String other_purpose) {
		// TODO Auto-generated method stub
		util.insert(jobid,amount,now,other_purpose);
	}

	public ArrayList fetchLabour() {
		// TODO Auto-generated method stub
		ArrayList list=new ArrayList();
		list=util.fetchLabour();
		return list;
	}
	public ArrayList retrieve(int job) {
		// TODO Auto-generated method stub
		ArrayList list=new ArrayList();
		list=util.retrieve(job);
		logger.debug("Inside DAO"+list.size());
		return list;
	}
	public ArrayList retrieveMaster(int job) {
		// TODO Auto-generated method stub
		ArrayList list=new ArrayList();
		list=util.retrieveMaster(job);
		logger.debug("Inside DAO"+list.size());
		return list;
	}
}
