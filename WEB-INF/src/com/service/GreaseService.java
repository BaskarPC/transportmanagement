package com.service;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.service.GreaseService;
import com.util.GreaseUtil;
import com.util.GeneralUtil;
import com.vo.GreaseVO;
import com.dao.GreaseDAO;

public class GreaseService {
	private static final Logger logger=(Logger)Logger.getLogger(GreaseService.class);
	GeneralUtil generalutil=new GeneralUtil();
	GreaseUtil util=new GreaseUtil();
	GreaseDAO greaseDAO=new GreaseDAO();
	public ArrayList fetchInst()throws Exception
	{
		logger.debug("DieselService:fetchInst<----------");
		ArrayList institutionList=new ArrayList();
		String query=generalutil.fetchInst();
		institutionList=greaseDAO.fetchInst(query);
		logger.debug("DieselService:fetchInst---------->");
		return institutionList;
	}

	public ArrayList fetchType()throws Exception
	{
		logger.debug("DieselService:fetchType<----------");
		ArrayList typeList=new ArrayList();
		String query=generalutil.fetchType();
		typeList=greaseDAO.fetchType(query);
		logger.debug("DieselService:fetchType---------->");
		return typeList;
	}
	
	public ArrayList fetchVehicle()throws Exception
	{
		logger.debug("DieselService:fetchVehicle<----------");
		ArrayList vehicleList=new ArrayList();
		String query=generalutil.fetchVehicle();
		vehicleList=greaseDAO.fetchVehicle(query);
		logger.debug("DieselService:fetchVehicle---------->");
		return vehicleList;
	}
	
	public ArrayList fetchGrease() throws Exception {
		logger.debug("DieselService:fetchGrease---------->");
		String query=util.fetchGrease();
		ArrayList greaseList=greaseDAO.fetchGrease(query);
		logger.debug("DieselService:fetchGrease<----------");
		return greaseList;
	}
	
	public ArrayList fetchGreaseReason() throws Exception {
		logger.debug("DieselService:fetchGreaseReason---------->");
		String query=util.fetchGreaseReason();
		ArrayList reasonList=greaseDAO.fetchGreaseReason(query);
		logger.debug("DieselService:fetchGreaseReason<----------");
		return reasonList;
	}
	
	public ArrayList instMethod(int institutionName)throws Exception {
		logger.debug("DieselService:instMethod<----------");
		String query=generalutil.instMethod(institutionName);
		ArrayList typeList=greaseDAO.instMethod(query);
		logger.debug("DieselService:instMethod---------->");
		return typeList;
	}

	public ArrayList vehicleMethod(int vehicleType)throws Exception {
		logger.debug("DieselService:vehicleMethod<----------");
		String query=generalutil.vehicleMethod(vehicleType);
		ArrayList vehicleList=greaseDAO.vehicleMethod(query);
		logger.debug("DieselService:vehicleMethod---------->");
		return vehicleList;
	}

	public ArrayList driverMethod(int vehnum) throws Exception {
		logger.debug("DieselService:driverMethod<----------"); 
		String query=generalutil.driverMethod(vehnum);
		ArrayList driverList=greaseDAO.driverMethod(query);
		logger.debug("DieselService:driverMethod---------->");
		return driverList;
	}
	
	public ArrayList quantityMethod(String partnumber) {
		logger.debug("DieselService:quantityMethod<----------");
		ArrayList generalList=new ArrayList();
		String query=util.quantityMethod(partnumber);
		generalList=greaseDAO.quantityMethod(query);
		logger.debug("DieselService:quantityMethod---------->");
		return generalList;
	}

	public void insertmaster(int jobid, int institution_name, int vehicle_type, int vehicle_number, int bill_number, String req_date, int driver_name, String other_purpose, int req_drivername, int goods_type, float totalAmount, int place, int service_station) {
		// TODO Auto-generated method stub
		logger.debug("DieselService:insertmaster<----------");
		String query=util.insertmaster(jobid,institution_name,vehicle_type,vehicle_number,bill_number,req_date,driver_name,other_purpose,req_drivername,goods_type,totalAmount,place,service_station);
		greaseDAO.insertmaster(query);
		logger.debug("DieselService:insertmaster---------->");
	}

	public void insert(int jobid, int item_type, float available_qty, float qty_wanted, float iqty_old, float iqty_new, float urate_old, float urate_new, float amount, int reason_req) {
		// TODO Auto-generated method stub
		logger.debug("DieselService:insertmaster<----------");
		String query=util.insert(jobid, item_type, available_qty, qty_wanted, iqty_old, iqty_new, urate_old, urate_new, amount, reason_req);
		greaseDAO.insert(query);
		logger.debug("DieselService:insertmaster---------->");
	}

	public ArrayList retrieveMaster(int job) {
		// TODO Auto-generated method stub
		logger.debug("DieselService:retrieveMaster<----------");
		String query=util.retrieveMaster(job);
		ArrayList retrieveList=greaseDAO.retrieveMaster(query);
		logger.debug("DieselService:retrieveMaster---------->");
		return retrieveList;
	}
	
	public ArrayList retrieve(int job) {
		// TODO Auto-generated method stub
		logger.debug("DieselService:retrieve<----------");
		String query=util.retrieveMaster(job);
		ArrayList retrieveList=greaseDAO.retrieve(query);
		logger.debug("DieselService:retrieve---------->");
		return retrieveList;
	}
	public ArrayList convertToDesc(String drivercode)throws Exception
	{
		ArrayList descList=new ArrayList();
		String query=generalutil.convertToDesc(drivercode);
		descList=greaseDAO.convertToDesc(query);
		return descList;
	}
	public int convertToCode(String drivername)throws Exception
	{
		ArrayList codeList=new ArrayList();
		int DRIVER_NAME=0;
		String query=generalutil.convertToCode(drivername);
		codeList=greaseDAO.convertToCode(query);
		logger.debug("List Size"+codeList);
		for(int i=0;i<codeList.size();i++)
		{
			GreaseVO drivercodevo=new GreaseVO();
			drivercodevo=(GreaseVO)codeList.get(0);
			logger.debug("list size"+codeList.size());
			DRIVER_NAME=Integer.parseInt(drivercodevo.getDriverName());
			logger.debug("driver name:"+DRIVER_NAME);
		}
		return DRIVER_NAME;
	}

	public void updateValuestemporary(float oldqty, float newqty, float oldrate, float newrate, String itemname, String itemtype, int jobid) {
		// TODO Auto-generated method stub
		logger.debug("GreaseService:updateValuestemporary<----------");
		String query=util.updateValuestemporary(oldqty,newqty,oldrate,newrate,itemname,itemtype);
		String query1=util.updateDate(jobid);
		greaseDAO.updateValuestemporary(query);
		greaseDAO.updateDate(query1);
		logger.debug("GreaseService:updateValuestemporary---------->");
	}

	public int convertToPlaceCode(String place, String servicestation) throws Exception {
		// TODO Auto-generated method stub
		ArrayList placeList=new ArrayList();
		int DRIVER_NAME=0;
		String query=generalutil.convertToPlaceCode(place,servicestation);
		placeList=greaseDAO.convertToCode(query);
		logger.debug("List Size"+placeList);
		for(int i=0;i<placeList.size();i++)
		{
			GreaseVO drivercodevo=new GreaseVO();
			drivercodevo=(GreaseVO)placeList.get(0);
			logger.debug("list size"+placeList.size());
			DRIVER_NAME=Integer.parseInt(drivercodevo.getDriverName());
			logger.debug("driver name:"+DRIVER_NAME);
		}
		return DRIVER_NAME;
	}
	public void updateValues(float toldqty, float tnewqty, String itemname, String subtype) {
		// TODO Auto-generated method stub
		logger.debug("GreaseService:updateValues<----------");
		String query=util.updateValues(toldqty,tnewqty,itemname,subtype);
		greaseDAO.updateValues(query);
		logger.debug("GreaseService:updateValues---------->");
	}
	public void updateExtra(float toldqty, float tnewqty, float oldrate, float newrate, String itemname, String itemtype) {
		// TODO Auto-generated method stub
		logger.debug("GreaseService:updateExtra<----------");
		String query=util.updateExtra(toldqty,tnewqty,oldrate,newrate,itemname,itemtype);
		greaseDAO.updateExtra(query);
		logger.debug("GreaseService:updateExtra---------->");
	}

}
