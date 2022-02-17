package com.service;
import com.dao.DieselDAO;
import com.util.DieselUtil;
import com.util.GeneralUtil;
import com.vo.DieselVO;

import java.util.ArrayList;

import org.apache.log4j.Logger;

public class DieselService {
	private static final Logger logger=(Logger)Logger.getLogger(DieselService.class);

	DieselDAO dieselDAO=new DieselDAO();
	GeneralUtil generalutil=new GeneralUtil();
	DieselUtil util=new DieselUtil();
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public ArrayList fetchInst()throws Exception
	{
		logger.debug("DieselService:fetchInst<----------");
		ArrayList institutionList=new ArrayList();
		String query=generalutil.fetchInst();
		institutionList=dieselDAO.fetchInst(query);
		logger.debug("DieselService:fetchInst---------->");
		return institutionList;
	}
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public ArrayList fetchType()throws Exception
	{
		logger.debug("DieselService:fetchType<----------");
		ArrayList typeList=new ArrayList();
		String query=generalutil.fetchType();
		typeList=dieselDAO.fetchType(query);
		logger.debug("DieselService:fetchType---------->");
		return typeList;
	}
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public ArrayList fetchVehicle()throws Exception
	{
		logger.debug("DieselService:fetchVehicle<----------");
		ArrayList vehicleList=new ArrayList();
		String query=generalutil.fetchVehicle();
		vehicleList=dieselDAO.fetchVehicle(query);
		logger.debug("DieselService:fetchVehicle---------->");
		return vehicleList;
	}
	
	/**
	 * 
	 * @param institutionName
	 * @return
	 * @throws Exception
	 */
	public ArrayList instMethod(int institutionName)throws Exception {
		// TODO Auto-generated method stub
		logger.debug("DieselService:instMethod<----------");
		String query=generalutil.instMethod(institutionName);
		ArrayList typeList=dieselDAO.instMethod(query);
		logger.debug("DieselService:instMethod---------->");
		return typeList;
	}
	
	/**
	 * 
	 * @param vehicleType
	 * @return
	 * @throws Exception
	 */
	public ArrayList vehicleMethod(int vehicleType)throws Exception {
		// TODO Auto-generated method stub
		logger.debug("DieselService:vehicleMethod<----------");
		String query=generalutil.vehicleMethod(vehicleType);
		ArrayList vehicleList=dieselDAO.vehicleMethod(query);
		logger.debug("DieselService:vehicleMethod---------->");
		return vehicleList;
	}
	/**
	 * 
	 * @param job
	 * @return
	 */
	public ArrayList retrieve(int job) {
		// TODO Auto-generated method stub
		logger.debug("DieselService:retrieve<----------");
	    String query=util.retrieve(job);
		ArrayList retrieveList=dieselDAO.retrieve(query);
		logger.debug("DieselService:retrieve---------->");
		return retrieveList;
	}

	/**
	 * 
	 * @param vehnum
	 * @return
	 * @throws Exception
	 */
	public ArrayList driverMethod(int vehnum) throws Exception {
		// TODO Auto-generated method stub
		logger.debug("DieselService:driverMethod<----------"); 
		String query=generalutil.driverMethod(vehnum);
		ArrayList driverList=dieselDAO.driverMethod(query);
		logger.debug("DieselService:driverMethod---------->");
		return driverList;
	}
	/**
	 * 
	 * @param drivercode
	 * @return
	 * @throws Exception
	 */
	public ArrayList convertToDesc(String drivercode)throws Exception
	{
		logger.debug("DieselService:convertToDesc<----------");
		ArrayList descList=new ArrayList();
		String query=generalutil.convertToDesc(drivercode);
		descList=dieselDAO.convertToDesc(query);
		logger.debug("DieselService:convertToDesc---------->");
		return descList;
	}
	/**
	 * 
	 * @param drivername
	 * @return
	 * @throws Exception
	 */
	public int convertToCode(String drivername)throws Exception
	{
		logger.debug("DieselService:convertToCode<----------");
	    ArrayList codeList=new ArrayList();
		int DRIVER_NAME=0;
		String query=generalutil.convertToCode(drivername);
		codeList=dieselDAO.convertToCode(query);
		logger.debug("List Size"+codeList);
		for(int i=0;i<codeList.size();i++)
		{
			DieselVO drivercodevo=new DieselVO();
			drivercodevo=(DieselVO)codeList.get(0);
			DRIVER_NAME=Integer.parseInt(drivercodevo.getDriverName());
			
		}
		logger.debug("DieselService:convertToCode---------->");
		return DRIVER_NAME;
	}
	/**
	 * 
	 * @param jobid
	 * @param institution_name
	 * @param vehicle_type
	 * @param vehicle_number
	 * @param bill_number
	 * @param req_date
	 * @param drivername
	 * @param other_purpose
	 * @param reqdrivername
	 * @param routenumber
	 * @param goodstype
	 * @param amount 
	 * @param service_station 
	 * @param place 
	 */
	public void insertmaster(int jobid, int institution_name, int vehicle_type, int vehicle_number, int bill_number, String req_date, int drivername, String other_purpose,int reqdrivername,int routenumber,int goodstype, float amount, int place, int service_station) {
		// TODO Auto-generated method stub
		logger.debug("DieselService:insertmaster<----------");
		String query=util.insertmaster(jobid, institution_name, vehicle_type, vehicle_number, bill_number, req_date, drivername, other_purpose, reqdrivername, routenumber, goodstype,place,service_station,amount);
		dieselDAO.insertmaster(query);
		logger.debug("DieselService:insertmaster---------->");
	}

	/**
	 * 
	 * @param jobid
	 * @param qty_wanted
	 * @param iqty_old
	 * @param iqty_new
	 * @param urate_old
	 * @param urate_new
	 * @param amount
	 * @param presentkm
	 * @param last_km
	 * @param diff_km
	 * @param avg_km
	 * @param remarks
	 * @param stock
	 * @param open_reading
	 * @param close_reading
	 * @param balance
	 * @param consumtion_liters
	 */
	public void insert(int jobid, int qty_wanted, int iqty_old, int iqty_new, float urate_old, float urate_new, float amount, int presentkm, int last_km, int diff_km, float avg_km, String remarks, int stock, int open_reading, int close_reading, int balance, int consumtion_liters) {
		// TODO Auto-generated method stub
		logger.debug("DieselService:insertmaster<----------");
		String query=util.insert(jobid,qty_wanted,iqty_old,iqty_new,urate_old,urate_new,amount,presentkm,last_km,diff_km,avg_km,remarks,stock,open_reading,close_reading,balance,consumtion_liters);
		dieselDAO.insert(query);
		logger.debug("DieselService:insertmaster---------->");
	}

	/**
	 * 
	 * @param job
	 * @return
	 */
	public ArrayList retrieveMaster(int job) {
		// TODO Auto-generated method stub
		logger.debug("DieselService:retrieveMaster<----------");
		String query=util.retrieveMaster(job);
		ArrayList retrieveList=dieselDAO.retrieveMaster(query);
		logger.debug("DieselService:retrieveMaster---------->");
		return retrieveList;
	}

	/**
	 * 
	 * @param code
	 * @return
	 */
	public ArrayList quantityMethod(String code) {
		// TODO Auto-generated method stub
		logger.debug("DieselService:quantityMethod<----------");
		String query=util.quantityMethod(code);
		ArrayList quantityList=dieselDAO.quantityMethod(query);
		logger.debug("DieselService:quantityMethod---------->");
		return quantityList;
	}

	/**
	 * 
	 * @param vehnum
	 * @param code
	 * @return
	 */
	public ArrayList lastFillingKmMethod(String vehnum,int code) {
		// TODO Auto-generated method stub
		logger.debug("DieselService:lastFillingKmMethod<----------");
		String query=util.lastFillingKmMethod(vehnum,code);
		ArrayList lastFillingKmList=dieselDAO.lastFillingKmMethod(query);
		if(lastFillingKmList.size()==0)
		{
			 query=util.vehiclepurchaseMethod(vehnum);
			 lastFillingKmList=dieselDAO.lastFillingKmMethod(query);
			 
		}
		logger.debug("DieselService:lastFillingKmMethod---------->");
		return lastFillingKmList;
	}

	/**
	 * 
	 * @return
	 */
	public ArrayList differenceMethod() {
		// TODO Auto-generated method stub
		logger.debug("DieselService:differenceMethod<----------");
		String query=util.differenceMethod();
		ArrayList differenceList=dieselDAO.differenceMethod(query);
		logger.debug("DieselService:differenceMethod---------->");
		return differenceList;
	}
	public void updateValues(int oldavail, int newavail, String itemname, String subtype) {
		// TODO Auto-generated method stub
		logger.debug("DieselService:updateValues<----------");
		String query=util.updateValues(oldavail,newavail,itemname,subtype);
		dieselDAO.updateValues(query);
		logger.debug("DieselService:updateValues---------->");
	}
	public void updateValuestemporary(int toldqty, int tnewqty, float oldrate, float newrate, String itemname, String itemtype, int jobid) {
		// TODO Auto-generated method stub
		logger.debug("DieselService:updateValuestemporary<----------");
		String query=util.updateValuestemporary(toldqty,tnewqty,oldrate,newrate,itemname,itemtype);
		String query1=util.updateDate(jobid);
		dieselDAO.updateValuestemporary(query);
		dieselDAO.updateDate(query1);
		logger.debug("DieselService:updateValuestemporary---------->");
		
	}
	public void updateExtra(int toldqty, int tnewqty, float oldrate, float newrate, String itemname, String itemtype) {
		// TODO Auto-generated method stub
		logger.debug("DieselService:updateExtra<----------");
		String query=util.updateExtra(toldqty,tnewqty,oldrate,newrate,itemname,itemtype);
		dieselDAO.updateExtra(query);
		logger.debug("DieselService:updateExtra---------->");
	}
	public ArrayList fetchStock(String itemtype) {
		// TODO Auto-generated method stub
		logger.debug("DieselService:fetchStock<----------");
		String query=util.quantityMethod(itemtype);
		ArrayList quantityList=dieselDAO.quantityMethod(query);
		logger.debug("DieselService:fetchStock---------->");
		return quantityList;
	}
	public int convertToPlaceCode(String place, String servicestation) throws Exception {
		// TODO Auto-generated method stub
		logger.debug("DieselService:convertToPlaceCode<----------");
	    ArrayList codeList=new ArrayList();
		int DRIVER_NAME=0;
		String query=generalutil.convertToPlaceCode(place,servicestation);
		codeList=dieselDAO.convertToCode(query);
		logger.debug("List Size"+codeList);
		for(int i=0;i<codeList.size();i++)
		{
			DieselVO drivercodevo=new DieselVO();
			drivercodevo=(DieselVO)codeList.get(0);
			DRIVER_NAME=Integer.parseInt(drivercodevo.getDriverName());
			
		}
		logger.debug("DieselService:convertToPlaceCode---------->");
		return DRIVER_NAME;
	}
}
