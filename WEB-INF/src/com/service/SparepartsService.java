package com.service;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.dao.DieselDAO;
import com.dao.SparePartsDAO;
import com.util.GeneralUtil;
import com.util.SpareUtil;
import com.vo.OilVO;
import com.vo.SparePartsFormVO;

public class SparepartsService {
	private static final Logger logger=(Logger)Logger.getLogger(SparepartsService.class);
	ArrayList instlist;
	SparePartsDAO sparepartdao=new SparePartsDAO();
	GeneralUtil generalutil=new GeneralUtil();
	SpareUtil util=new SpareUtil();
	SparePartsFormVO vo=new SparePartsFormVO();
	/**
	 * to fetch all institution
	 * @return
	 * @throws Exception 
	 */
	public ArrayList fetchInst() throws Exception
{
		logger.debug("SparepartsService:fetchInst<----------");
		ArrayList institutionList=new ArrayList();
		String query=generalutil.fetchInst();
		institutionList=sparepartdao.fetchInst(query);
		logger.debug("List Size:"+institutionList.size());
		logger.debug("SparepartsService:fetchInst---------->");
		return institutionList;
}
	/**
	 * to fetch all vehicle types
	 * @return
	 */
public ArrayList fetchVehicleType()
{
	instlist=sparepartdao.fetchVehicleType();
	return instlist;
}
/**
 * to fetch values from db to display in form
 * @param job
 * @return
 */

public ArrayList fetchCommonValues(int job )
{
	instlist=sparepartdao.fetchCommonValues(job);
	return instlist;
}
/**
 * to fetch values from db to display in form
 * @param job
 * @return
 */

public ArrayList fetchValues(int job )
{
	instlist=sparepartdao.fetchValues(job);
	return instlist;
}
/**
 * TO FETCH ALL VEHICLE NUMBER
 * @return
 */
public ArrayList fetchVehicleNumber()
{
	instlist=sparepartdao.fetchVehicleNumber();
	return instlist;
}
/**
 * TO DISPLAY THE quantity for each textbox
 * @return
 */
/*public ArrayList fetchWantedQuantity1()
{
	instlist=sparepartdao.fetchWantedQuantity1();
	return instlist;
} */
/**
 * to fetch the vehicle type based on institution name
 * @param instname
 * @return
 */
public ArrayList fetchVehicleType(int instname)
{
	instlist=sparepartdao.fetchVehicleType(instname);
	return instlist;
}
/**
 * to fetch those vehicle number based on
 * selected vehicle type
 * @param type
 * @param instname
 * @return
 */
public ArrayList fetchVehicleNumber(int type,int instname)
{
	instlist=sparepartdao.fetchVehicleNumber(type,instname);
	return instlist;
}
/**
 * 
 * @param inst
 * @param vehicletype
 * @param vehiclenumber
 * @param billnumber
 * @param reqdate
 * @param drname
 * @param rdrname
 * @param other
 * @param neededspares
 * @param goodstype
 * @param place
 * @param station
 * @param jobid
 * @param totalamt
 */
public void insertCommon(int inst, int vehicletype, int vehiclenumber, int billnumber, String reqdate, int drname, int rdrname, String other, String neededspares, int goodstype, int place, int station, int jobid, float totalamt) 
{
	sparepartdao.insertCommon(inst,vehicletype,vehiclenumber,billnumber,reqdate,drname,rdrname,other,neededspares,goodstype,place,station,jobid,totalamt);
}
/**
 * 
 * @param jobid
 * @param partno
 * @param brandname
 * @param totalqty
 * @param wantedquantity
 * @param oldavail
 * @param newavail
 * @param oldrate
 * @param newrate
 * @param amount
 */
public void insertCommonValues(int jobid,int partno,int brandname,int totalqty,int wantedquantity,int oldavail,int newavail,float oldrate,float newrate,float amount)
{
	sparepartdao.insertCommonValues(jobid,partno,brandname,totalqty,wantedquantity,oldavail,newavail,oldrate,newrate,amount);
}
/*public ArrayList fetchQuantityValues()
{
	instlist=sparepartdao.fetchQuantityValues();
	return instlist;
}*/
public ArrayList fetchRateValue(String pid)
{
	instlist=sparepartdao.fetchRateValue(pid);
	return instlist;
}
public void updateOldQuantityValues(int pid,int qty)
{
	sparepartdao.updateOldQuantityValues(pid,qty);
}
public void updateNewQuantityValues(int pid,int qty)
{
	sparepartdao.updateNewQuantityValues(pid,qty);
}
public ArrayList fetchAllValues(int pid)
{
	instlist=sparepartdao.fetchAllValues(pid);
	return instlist;
}

/**
 * 
 * @param institutionName
 * @return
 * @throws Exception
 */
public ArrayList instMethod(int institutionName)throws Exception {
	// TODO Auto-generated method stub
	logger.debug("SparepartsService:instMethod<----------");
	String query=generalutil.instMethod(institutionName);
	ArrayList typeList=sparepartdao.instMethod(query);
	logger.debug("SparepartsService:instMethod---------->");
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
	logger.debug("SparepartsService:vehicleMethod<----------");
	String query=generalutil.vehicleMethod(vehicleType);
	ArrayList vehicleList=sparepartdao.vehicleMethod(query);
	logger.debug("SparepartsService:vehicleMethod---------->");
	return vehicleList;
}
/**
 * 
 * @param vehnum
 * @return
 * @throws Exception
 */
public ArrayList driverMethod(int vehnum) throws Exception {
	// TODO Auto-generated method stub
	logger.debug("SparepartsService:driverMethod<----------"); 
	String query=generalutil.driverMethod(vehnum);
	ArrayList driverList=sparepartdao.driverMethod(query);
	logger.debug("SparepartsService:driverMethod---------->");
	return driverList;
}
public ArrayList convertToDesc(String driver_name) throws Exception {
	// TODO Auto-generated method stub
	logger.debug("SparepartsService:convertToDesc<----------"); 
	String query=generalutil.convertToDesc(driver_name);
	ArrayList driverList=sparepartdao.convertToDesc(query);
	logger.debug("SparepartsService:convertToDesc---------->");
	return driverList;
}
public ArrayList convertToSpareDesc(String itemDescription) {
	// TODO Auto-generated method stub
	logger.debug("SparepartsService:convertToSpareDesc<----------"); 
	String query=util.convertToSpareDesc(itemDescription);
	ArrayList driverList=sparepartdao.convertToSpareDesc(query);
	logger.debug("SparepartsService:convertToSpareDesc---------->");
	return driverList;
}
public int convertToCode(String drivername) throws Exception {
	// TODO Auto-generated method stub
	ArrayList codeList=new ArrayList();
	int DRIVER_NAME=0;
	String query=generalutil.convertToCode(drivername);
	codeList=sparepartdao.convertToCode(query);
	logger.debug("List Size"+codeList);
	for(int i=0;i<codeList.size();i++)
	{
		vo=(SparePartsFormVO)codeList.get(0);
		logger.debug("list size"+codeList.size());
		DRIVER_NAME=Integer.parseInt(vo.getDriverName());
		logger.debug("driver name:"+DRIVER_NAME);
	}
	return DRIVER_NAME;
}
public ArrayList quantityMethod(String partnumber) {
	// TODO Auto-generated method stub
	logger.debug("SparepartsService:quantityMethod<----------");
	ArrayList generalList=new ArrayList();
	String query=util.quantityMethod(partnumber);
	generalList=sparepartdao.quantityMethod(query);
	logger.debug("SparepartsService:quantityMethod---------->");
	return generalList;
}
public void updateValues(float toldqty, float tnewqty, String itemname, String subtype) {
	logger.debug("SparepartsService:updateValues<----------");
	String query=util.updateValues(toldqty,tnewqty,itemname,subtype);
	sparepartdao.updateValues(query);
	logger.debug("SparepartsService:updateValues---------->");
}
public void updateExtra(float toldqty, float tnewqty, float oldrate, float newrate, String itemname, String itemtype) {
	// TODO Auto-generated method stub
	logger.debug("SparepartsService:updateExtra<----------");
	String query=util.updateExtra(toldqty,tnewqty,oldrate,newrate,itemname,itemtype);
	sparepartdao.updateExtra(query);
	logger.debug("SparepartsService:updateExtra---------->");
}
}
