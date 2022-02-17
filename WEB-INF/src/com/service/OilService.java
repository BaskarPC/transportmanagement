package com.service;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.service.OilService;
import com.util.OilUtil;
import com.util.GeneralUtil;
import com.vo.OilVO;
import com.dao.OilDAO;

public class OilService {
	private static final Logger logger=(Logger)Logger.getLogger(OilService.class);
	GeneralUtil generalutil=new GeneralUtil();
	OilUtil util=new OilUtil();
	OilDAO oilDAO=new OilDAO();
	OilVO previousvo=new OilVO();
	public ArrayList fetchInst()throws Exception
	{
		ArrayList institutionList=new ArrayList();
		String query=generalutil.fetchInst();
		institutionList=oilDAO.fetchInst(query);
		return institutionList;
	}

	public ArrayList fetchType()throws Exception
	{
		ArrayList typeList=new ArrayList();
		String query=generalutil.fetchType();
		typeList=oilDAO.fetchType(query);
		return typeList;
	}
	
	public ArrayList fetchVehicle()throws Exception
	{
		ArrayList vehicleList=new ArrayList();
		String query=generalutil.fetchVehicle();
		vehicleList=oilDAO.fetchVehicle(query);
		return vehicleList;
	}
	
	public ArrayList fetchOil() throws Exception {
		// TODO Auto-generated method stub
		String query=util.fetchOil();
		ArrayList oilList=oilDAO.fetchOil(query);
		return oilList;
	}
	
	public ArrayList fetchOilReason() throws Exception {
		// TODO Auto-generated method stub
		String query=util.fetchOilReason();
		ArrayList reasonList=oilDAO.fetchOilReason(query);
		return reasonList;
	}
	
	public ArrayList instMethod(int institutionName)throws Exception {
		// TODO Auto-generated method stub
		String query=generalutil.instMethod(institutionName);
		ArrayList typeList=oilDAO.instMethod(query);
		return typeList;
	}

	public ArrayList vehicleMethod(int vehicleType)throws Exception {
		// TODO Auto-generated method stub
		String query=generalutil.vehicleMethod(vehicleType);
		ArrayList vehicleList=oilDAO.vehicleMethod(query);
		return vehicleList;
	}

	public ArrayList driverMethod(int vehnum) throws Exception {
		// TODO Auto-generated method stub
		String query=generalutil.driverMethod(vehnum);
		ArrayList driverList=oilDAO.driverMethod(query);
		return driverList;
	}
	
	public int previouslyServicedKmMethod(int vehnum) {
		// TODO Auto-generated method stub
		ArrayList previouslyServicedKmList=new ArrayList();
		int previouskm=0;
		String query=util.previouslyServicedKmMethod(vehnum);
		previouslyServicedKmList=oilDAO.previouslyServicedKmMethod(query);
		if(previouslyServicedKmList.size()==0)
			return previouskm;
		else
		{
			previousvo=(OilVO)previouslyServicedKmList.get(0);
			previouskm=Integer.parseInt(previousvo.getCurrentKM());
			return previouskm;
		}
			
	}

	public ArrayList quantityMethod(String partnumber) {
		// TODO Auto-generated method stub
		ArrayList generalList=new ArrayList();
		String query=util.quantityMethod(partnumber);
		generalList=oilDAO.quantityMethod(query);
		return generalList;
	}

	public void insertmaster(int jobid, int institution_name, int vehicle_type, int vehicle_number, int bill_number, String req_date, int driver_name, String other_purpose, int req_drivername, int goods_type, float totalAmount, int place, int service_station) {
		// TODO Auto-generated method stub
		String query=util.insertmaster(jobid,institution_name,vehicle_type,vehicle_number,bill_number,req_date,driver_name,other_purpose,req_drivername,goods_type,totalAmount,place,service_station);
		oilDAO.insert(query);
	}

	public void insert(int jobid, int item_type, float available_qty, float qty_wanted, float iqty_old, float iqty_new, float urate_old, float urate_new, float amount, int reason_req, int current_km, int prev_serviced_km, int differnce_km) {
		// TODO Auto-generated method stub
		String query=util.insert(jobid, item_type, available_qty, qty_wanted, iqty_old, iqty_new, urate_old, urate_new, amount, reason_req, current_km, prev_serviced_km, differnce_km);
		oilDAO.insert(query);
	}

	public ArrayList retrieveMaster(int job) {
		// TODO Auto-generated method stub
		String query=util.retrieveMaster(job);
		ArrayList retrieveList=oilDAO.retrieveMaster(query);
		return retrieveList;
	}
	
	public ArrayList retrieve(int job) {
		// TODO Auto-generated method stub
		String query=util.retrieve(job);
		ArrayList retrieveList=oilDAO.retrieve(query);
		return retrieveList;
	}
	public ArrayList convertToDesc(String drivercode)throws Exception
	{
		ArrayList descList=new ArrayList();
		String query=generalutil.convertToDesc(drivercode);
		descList=oilDAO.convertToDesc(query);
		return descList;
	}
	
	public int convertToCode(String drivername)throws Exception
	{
		ArrayList codeList=new ArrayList();
		int DRIVER_NAME=0;
		String query=generalutil.convertToCode(drivername);
		codeList=oilDAO.convertToCode(query);
		logger.debug("List Size"+codeList);
		for(int i=0;i<codeList.size();i++)
		{
			OilVO drivercodevo=new OilVO();
			drivercodevo=(OilVO)codeList.get(0);
			logger.debug("list size"+codeList.size());
			DRIVER_NAME=Integer.parseInt(drivercodevo.getDriverName());
			logger.debug("driver name:"+DRIVER_NAME);
		}
		return DRIVER_NAME;
	}
	public void updateValues(float toldqty, float tnewqty, String itemname, String subtype) {
		// TODO Auto-generated method stub
		logger.debug("OilService:updateValues<----------");
		String query=util.updateValues(toldqty,tnewqty,itemname,subtype);
		oilDAO.updateValues(query);
		logger.debug("OilService:updateValues---------->");
	}

	public void updateValuestemporary(float oldqty, float newqty, float oldrate, float newrate, String itemname, String itemtype, int jobid) {
		// TODO Auto-generated method stub
		logger.debug("OilService:updateValuestemporary<----------");
		String query=util.updateValuestemporary(oldqty,newqty,oldrate,newrate,itemname,itemtype);
		String query1=util.updateDate(jobid);
		oilDAO.updateValuestemporary(query);
		oilDAO.updateDate(query1);
		logger.debug("OillService:updateValuestemporary---------->");
		
	}
	public void updateExtra(float toldqty, float tnewqty, float oldrate, float newrate, String itemname, String itemtype) {
		// TODO Auto-generated method stub
		logger.debug("OilService:updateExtra<----------");
		String query=util.updateExtra(toldqty,tnewqty,oldrate,newrate,itemname,itemtype);
		oilDAO.updateExtra(query);
		logger.debug("OilService:updateExtra---------->");
	}


}
