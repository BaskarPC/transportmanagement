package com.service;

import com.dao.DieselOutsideDAO;
import com.util.DieselOutsideUtil;
import com.util.GeneralUtil;
import com.vo.DieselOutsideVO;
import java.util.ArrayList;
import org.apache.log4j.Logger;

public class DieselOutsideService {
	private static final Logger logger=(Logger)Logger.getLogger(DieselOutsideService.class);
	DieselOutsideDAO dieseloutsideDAO=new DieselOutsideDAO();
	GeneralUtil generalutil=new GeneralUtil();
	DieselOutsideUtil util=new DieselOutsideUtil();
	
	public ArrayList fetchInst()throws Exception
	{
		ArrayList institutionList=new ArrayList();
		String query=generalutil.fetchInst();
		institutionList=dieseloutsideDAO.fetchInst(query);
		return institutionList;
	}
	public ArrayList fetchType()throws Exception
	{
		ArrayList typeList=new ArrayList();
		String query=generalutil.fetchType();
		typeList=dieseloutsideDAO.fetchType(query);
		return typeList;
	}
	public ArrayList fetchVehicle()throws Exception
	{
		ArrayList vehicleList=new ArrayList();
		String query=generalutil.fetchVehicle();
		vehicleList=dieseloutsideDAO.fetchVehicle(query);
		return vehicleList;
	}
	public ArrayList fetchFuel() throws Exception {
		String query=util.fetchFuel();
		ArrayList fuelList=dieseloutsideDAO.fetchFuel(query);
		return fuelList;
	}
	public ArrayList instMethod(int institutionName)throws Exception {
		// TODO Auto-generated method stub
		String query=generalutil.instMethod(institutionName);
		ArrayList typeList=dieseloutsideDAO.instMethod(query);
		return typeList;
	}
	
	public ArrayList vehicleMethod(int vehicleType)throws Exception {
		// TODO Auto-generated method stub
		String query=generalutil.vehicleMethod(vehicleType);
		ArrayList vehicleList=dieseloutsideDAO.vehicleMethod(query);
		return vehicleList;
	}
	public ArrayList retrieve(int job) {
	// TODO Auto-generated method stub
    String query=util.retrieve(job);
	ArrayList retrieveList=dieseloutsideDAO.retrieve(query);
	logger.debug("Inside Service"+retrieveList.size());
	return retrieveList;
}

public ArrayList driverMethod(int vehnum) throws Exception {
	// TODO Auto-generated method stub
	String query=generalutil.driverMethod(vehnum);
	ArrayList driverList=dieseloutsideDAO.driverMethod(query);
	return driverList;
}
public ArrayList convertToDesc(String drivercode)throws Exception
{
	ArrayList descList=new ArrayList();
	String query=generalutil.convertToDesc(drivercode);
	descList=dieseloutsideDAO.convertToDesc(query);
	return descList;
}
public int convertToCode(String drivername)throws Exception
{
	ArrayList codeList=new ArrayList();
	int DRIVER_NAME=0;
	String query=generalutil.convertToCode(drivername);
	codeList=dieseloutsideDAO.convertToCode(query);
	for(int i=0;i<codeList.size();i++)
	{
		DieselOutsideVO drivercodevo=new DieselOutsideVO();
		drivercodevo=(DieselOutsideVO)codeList.get(0);
		DRIVER_NAME=Integer.parseInt(drivercodevo.getDriverName());
			
	}
	return DRIVER_NAME;
}

	

	public ArrayList lastFillingKmMethod(String vehnum,int code) {
		// TODO Auto-generated method stub
		ArrayList lastFillingKmList=new ArrayList();
		String query=util.lastFillingKmMethod(vehnum,code);
		lastFillingKmList=dieseloutsideDAO.lastFillingKmMethod(query);
		logger.debug("Last List:"+lastFillingKmList.size());
		if(lastFillingKmList.size()==0)
		{
			 query=util.vehiclepurchaseMethod(vehnum);
			 lastFillingKmList=dieseloutsideDAO.lastFillingKmMethod(query);
			 
		}
		return lastFillingKmList;
	}

	public void insertmaster(int jobid, int institution_name, int vehicle_type, int vehicle_number, int bill_number, String req_date, int driver_name, int req_drivername, int route_number,int goodstype, int bunkname, int place, float amount) {
		// TODO Auto-generated method stub
		String query=util.insertmaster(jobid, institution_name, vehicle_type,vehicle_number,bill_number,req_date,driver_name,req_drivername,route_number,goodstype,bunkname,place,amount);
		dieseloutsideDAO.insertmaster(query);
		
	}

	public void insert(int jobid, float qty_wanted, float unitrate, float amount, int presentkm, int last_km, int diff_km, float avg_km, String remarks, int fueltype, int bunkname, String other_bunk) {
		// TODO Auto-generated method stub
		String query=util.insert(jobid,qty_wanted,unitrate,amount,presentkm,last_km,diff_km,avg_km,remarks,fueltype,bunkname,other_bunk);
		dieseloutsideDAO.insertmaster(query);
		
	}
	public ArrayList retrieveMaster(int job) {
		// TODO Auto-generated method stub
	    String query=util.retrieveMaster(job);
		ArrayList userList=dieseloutsideDAO.retrieveMaster(query);
		return userList;
	}
	

	}
