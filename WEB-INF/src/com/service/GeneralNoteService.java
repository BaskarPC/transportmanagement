package com.service;

import java.util.ArrayList;
import org.apache.log4j.Logger;
import com.dao.GeneralNoteDAO;
import com.util.GeneralNoteUtil;
import com.util.GeneralUtil;
import com.vo.GreaseVO;


public class GeneralNoteService {
	private static final Logger logger=(Logger)Logger.getLogger(GeneralNoteService.class);
	GeneralUtil generalutil=new GeneralUtil();
	GeneralNoteUtil util=new GeneralNoteUtil();
	GeneralNoteDAO generalnoteDAO=new GeneralNoteDAO();
	public ArrayList fetchInst()throws Exception
	{
		logger.debug("GeneralNoteService:fetchInst<----------");
		ArrayList institutionList=new ArrayList();
		String query=generalutil.fetchInst();
		institutionList=generalnoteDAO.fetchInst(query);
		logger.debug("GeneralNoteService:fetchInst---------->");
		return institutionList;
	}

	public ArrayList fetchType()throws Exception
	{
		logger.debug("GeneralNoteService:fetchType<----------");
		ArrayList typeList=new ArrayList();
		String query=generalutil.fetchType();
		typeList=generalnoteDAO.fetchType(query);
		logger.debug("GeneralNoteService:fetchType---------->");
		return typeList;
	}
	
	public ArrayList fetchVehicle()throws Exception
	{
		logger.debug("GeneralNoteService:fetchVehicle<----------");
		ArrayList vehicleList=new ArrayList();
		String query=generalutil.fetchVehicle();
		vehicleList=generalnoteDAO.fetchVehicle(query);
		logger.debug("GeneralNoteService:fetchVehicle---------->");
		return vehicleList;
	}
	public ArrayList fetchGeneralNote() throws Exception {
		// TODO Auto-generated method stub
		ArrayList GeneralNoteList=new ArrayList();
		String query=util.fetchGeneralNote();
		GeneralNoteList=generalnoteDAO.fetchGeneralNote(query);
		return GeneralNoteList;
	}
	
	public ArrayList instMethod(int institutionName)throws Exception {
		logger.debug("GeneralNoteService:instMethod<----------");
		String query=generalutil.instMethod(institutionName);
		ArrayList typeList=generalnoteDAO.instMethod(query);
		logger.debug("GeneralNoteService:instMethod---------->");
		return typeList;
	}

	public ArrayList vehicleMethod(int vehicleType)throws Exception {
		logger.debug("GeneralNoteService:vehicleMethod<----------");
		String query=generalutil.vehicleMethod(vehicleType);
		ArrayList vehicleList=generalnoteDAO.vehicleMethod(query);
		logger.debug("GeneralNoteService:vehicleMethod---------->");
		return vehicleList;
	}

	public ArrayList driverMethod(int vehnum) throws Exception {
		logger.debug("GeneralNoteService:driverMethod<----------"); 
		String query=generalutil.driverMethod(vehnum);
		ArrayList driverList=generalnoteDAO.driverMethod(query);
		logger.debug("GeneralNoteService:driverMethod---------->");
		return driverList;
	}
	
	public ArrayList quantityMethod(String partnumber) {
		logger.debug("GeneralNoteService:quantityMethod<----------");
		ArrayList generalList=new ArrayList();
		String query=util.quantityMethod(partnumber);
		generalList=generalnoteDAO.quantityMethod(query);
		logger.debug("GeneralNoteService:quantityMethod---------->");
		return generalList;
	}
	public void insertmaster(int jobid, int institution_name, int vehicle_type, int vehicle_number, int bill_number, String req_date, int driver_name, String other_purpose, int req_drivername, int goods_type) {
		// TODO Auto-generated method stub
		logger.debug("GeneralNoteService:insertmaster<----------");
		String query=util.insertmaster(jobid,institution_name,vehicle_type,vehicle_number,bill_number,req_date,driver_name,other_purpose,req_drivername,goods_type);
		generalnoteDAO.insertmaster(query);
		logger.debug("GeneralNoteService:insertmaster---------->");
	}

	public void insert(int jobid, int item_type, float available_qty, float qty_wanted, float urate, float amount, int reason_req) {
		// TODO Auto-generated method stub
		logger.debug("GeneralNoteService:insertmaster<----------");
		String query=util.insert(jobid, item_type, available_qty, qty_wanted, urate, amount, reason_req);
		generalnoteDAO.insert(query);
		logger.debug("GeneralNoteService:insertmaster---------->");
	}

	public ArrayList retrieveMaster(int job) {
		// TODO Auto-generated method stub
		logger.debug("DieselService:retrieveMaster<----------");
		String query=util.retrieveMaster(job);
		ArrayList retrieveList=generalnoteDAO.retrieveMaster(query);
		logger.debug("DieselService:retrieveMaster---------->");
		return retrieveList;
	}
	
	public ArrayList retrieve(int job) {
		// TODO Auto-generated method stub
		logger.debug("GeneralNoteService:retrieve<----------");
		String query=util.retrieveMaster(job);
		ArrayList retrieveList=generalnoteDAO.retrieve(query);
		logger.debug("GeneralNoteService:retrieve---------->");
		return retrieveList;
	}
	public ArrayList convertToDesc(String drivercode)throws Exception
	{
		ArrayList descList=new ArrayList();
		String query=generalutil.convertToDesc(drivercode);
		descList=generalnoteDAO.convertToDesc(query);
		return descList;
	}
	public int convertToCode(String drivername)throws Exception
	{
		ArrayList codeList=new ArrayList();
		int DRIVER_NAME=0;
		String query=generalutil.convertToCode(drivername);
		codeList=generalnoteDAO.convertToCode(query);
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
}
