package com.dao;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.dbcom.dbcom;

public class SparePartsDAO {
	ArrayList instList=new ArrayList();
	dbcom db=new dbcom();
	 String vofile="com.vo.SparePartsFormVO";
	private static final Logger logger=(Logger)Logger.getLogger(SparePartsDAO.class);
	/**
	 * to fetch all institution
	 * @return
	 */
	public ArrayList fetchInst()
	{
		String query="select code as instid,ctype as insttype,cdesc as instdesc from lookup where ctype='institution'";
		instList=db.selectQuery(vofile,query);
		logger.debug("institution list size="+instList.size());
		return instList;
	}
	/**
	 * to fetch all vehicle types
	 * @return
	 */
	public ArrayList fetchVehicleType()
	{
		String query="select code as vehicletypeid,ctype as vehicletype1,cdesc as vehicletypedesc from LOOKUP where ctype='vehicletype'";
		instList=db.selectQuery(vofile,query);
		logger.debug("institution list size="+instList.size());
		return instList;
	}
	
	/**
	 * to fetch values from db to display in form
	 * @param job
	 * @return
	 */
	public ArrayList fetchCommonValues(int job)
	{
		String query="select INSTITUTION_NAME as institutionName,VEHICLE_TYPE as vehicleType,VEHICLE_NUMBER as vehnumber,BILL_NUMBER as billNumber,DRIVER_NAME as driverName,REQ_DRIVERNAME as reqdriver,OTHER_REASON as spareotherreason from MAINTENANCE_MASTER where JOB_ID="+job+"";
		instList=db.selectQuery(vofile,query);
		logger.debug("institution list size="+instList.size());
		return instList;
	}
	/**
	 * to fetch values from db to display in form
	 * @param job
	 * @return
	 */
	public ArrayList fetchValues(int job)
	{
		String query="select PART_NUMBER as spareissuepartnumber,BRAND_NAME as spareissuebrandname,AVAILABLE_QTY as AVAILQTY,QTY_WANTED as WANTEDQTY,IQTY_OLD as SOLDQUANTITY,IQTY_NEW as spareissuenewqty,URATE_OLD as SOLDRATE,URATE_NEW as spareissuenewrate,AMOUNT as SAMOUNT from SPAREPARTS_PAINT where JOB_ID="+job+"";
		instList=db.selectQuery(vofile,query);
		logger.debug("institution list size="+instList.size());
		return instList;
	}
/**
 * TO FETCH ALL VEHICLE NUMBER
 * @return
 */		
	public ArrayList fetchVehicleNumber()
	{
		String query="select code as vehiclenumberid,ctype as vehiclenumber1,cdesc as vehiclenumberdesc from lookup  where ctype='vehiclenumber'";
		instList=db.selectQuery(vofile,query);
		logger.debug("institution list size="+instList.size());
		return instList;
	}
	
	/**
	 * to fetch the vehicle type based on institution name
	 * @param instname
	 * @return
	 */
	public ArrayList fetchVehicleType(int instname)
	{
		String query="select code as vehicletypeid,cdesc as vehicletypedesc from LOOKUP where code in (select distinct(vehicletype) as vehtype from vehicle where instname="+instname+")";
		instList=db.selectQuery(vofile,query);
		logger.debug("institution list size="+instList.size());
		return instList;
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
		String query="select code as vehiclenumberid,cdesc as vehiclenumberdesc from lookup where code IN (select vehicleid as vehid from vehicle where vehicletype="+type+" and instname="+instname+")";
		instList=db.selectQuery(vofile,query);
		logger.debug("institution list size="+instList.size());
		return instList;
	}
	/**
	 * to insert the values
	 * @param inst
	 * @param vehicletype
	 * @param drname
	 * @param rdrname
	 * @param rdrname2 
	 * @param drname2 
	 * @param other
	 * @param neededspares 
	 * @param jobid
	 * @param totalamt 
	 * @param jobid2 
	 * @param station 
	 * @param place 
	 */
	public void insertCommon(int inst, int vehicletype, int vehiclenumber, int billnumber, String reqdate, int drname, int rdrname, String other, String neededspares, int goodstype, int place, int station, int jobid, float totalamt)
	{
		
		String query="insert into maintenance_master values("+inst+","+vehicletype+","+vehiclenumber+","+billnumber+",'"+reqdate+"','',"+drname+","+rdrname+",'','"+other+"','"+neededspares+"',"+goodstype+","+place+","+station+",0,"+jobid+","+totalamt+")";
		db.otherQuery(query);
		logger.debug("institution list size="+instList.size());
	}
	/**
	 *  to insert set of records
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
		
		String query="insert into SPAREPARTS_PAINT values("+jobid+","+jobid+","+partno+","+brandname+","+jobid+","+totalqty+","+wantedquantity+","+oldavail+","+newavail+","+oldrate+","+newrate+","+amount+")";
		db.otherQuery(query);
		logger.debug("institution list size="+instList.size());
	}	
	/**
	 * to fetch the old & new rate,temporary quantities
	 */
	public ArrayList fetchRateValue(String pid)
	{
		String query="select TOLD_QTY AS OIQTY_OLD,TNEW_QTY AS OIQTY_NEW,TOLD_RATE AS OURATE_OLD,TNEW_RATE AS OURATE_NEW,REORDER_LVL as RLVL,EXTRA_QTY as XQTY,EXTRA_RATE as XRATE from COMMON_TRANSACTION where SUBTYPE='"+pid+"'";
		//String query="select OLD_RATE as tempoldrate,NEW_RATE as tempnewrate,TOLD_QTY as tempoldqty,TNEW_QTY as tempnewqty FROM COMMON_TRANSACTION st,sparelookup s WHERE st.PARTNUMBER="+pid+" and st.PARTNUMBER=s.id ";
		instList=db.selectQuery(vofile,query);
		logger.debug("institution list size="+instList.size());
		return instList;
	}
	/**
	 * to update the temporary old quantities
	 * @param pid
	 * @param qty
	 */
	public void updateOldQuantityValues(int pid,int qty)
	{
		
		String query="update COMMON_TRANSACTION set TOLD_QTY="+qty+" where PARTNUMBER="+pid+"";
		db.otherQuery(query);
		logger.debug("institution list size="+instList.size());
	}
	/**
	 * to update the temporary new quantities
	 * @param pid
	 * @param qty
	 */
	public void updateNewQuantityValues(int pid,int qty)
	{
		
		String query="update SCOMMON_TRANSACTION set TNEW_QTY="+qty+" where PARTNUMBER="+pid+"";
		db.otherQuery(query);
		logger.debug("institution list size="+instList.size());
	}
	
	/**
	 * TO FETCH THE TEMPORARY VALUES
	 * @param pid
	 * @return
	 */
	public ArrayList fetchAllValues(int pid)
	{
		
		String query="select OLD_QTY as oldqty,NEW_QTY as newqty,OLD_RATE as tempoldrate,NEW_RATE as tempnewrate,TOLD_QTY as tempoldqty,TNEW_QTY as tempnewqty FROM SCOMMON_TRANSACTION WHERE PARTNUMBER="+pid+"";
		instList=db.selectQuery(vofile,query);
		logger.debug("institution list size="+instList.size());
		return instList;
	}
	/**
	 * TO UPDATE THE VALUES IN COMMON TRANSACTION
	 * @param pid
	 * @param oldavail
	 * @param newavail
	 * @param oldrate
	 * @param newrate
	 */
	public void updateValues(String pid,int oldavail,int newavail,float oldrate,float newrate)
	{
		
		String query="update COMMON_TRANSACTION set OLD_QTY="+oldavail+",NEW_QTY="+newavail+",OLD_RATE="+oldrate+",NEW_RATE="+newrate+",TOLD_QTY="+oldavail+",TNEW_QTY="+newavail+" where PARTNUMBER='"+pid+"'";
		db.otherQuery(query);
		logger.debug("institution list size="+instList.size());
	}
	public ArrayList fetchInst(String query) {
		// TODO Auto-generated method stub
		logger.debug("SparePartsDAO:fetchInst<----------");
		ArrayList institutionList=new ArrayList();
		institutionList=db.selectQuery(vofile, query);
		logger.debug("List Size:"+institutionList.size());
		logger.debug("SparePartsDAO:fetchInst---------->");
		return institutionList;
	}
	/**
	 * 
	 * @param query
	 * @return
	 * @throws Exception
	 */
	public ArrayList instMethod(String query)throws Exception
	{
		logger.debug("SparePartsDAO:instMethod<----------");
		ArrayList vehicleTypeList=new ArrayList();
		vehicleTypeList=db.selectQuery(vofile, query);
		logger.debug("SparePartsDAO:instMethod---------->");
		return vehicleTypeList;
	}
	/**
	 * 
	 * @param query
	 * @return
	 * @throws Exception
	 */
	public ArrayList vehicleMethod(String query)throws Exception
	{
		logger.debug("SparePartsDAO:vehicleMethod<----------");
		ArrayList vehicleList=new ArrayList();
		vehicleList=db.selectQuery(vofile, query);
		logger.debug("SparePartsDAO:vehicleMethod---------->");
		return vehicleList;
	}
	/**
	 * 
	 * @param query
	 * @return
	 * @throws Exception
	 */
	public ArrayList convertToDesc(String query)throws Exception
	{
		logger.debug("SparePartsDAO:convertToDesc<----------");
		ArrayList descList=new ArrayList();
		descList=db.selectQuery(vofile, query);
		logger.debug("SparePartsDAO:convertToDesc---------->");
		return descList;
	}
	/**
	 * 
	 * @param query
	 * @return
	 * @throws Exception
	 */
	public ArrayList convertToCode(String query)throws Exception
	{
		logger.debug("SparePartsDAO:convertToCode<----------");
		ArrayList codeList=new ArrayList();
		codeList=db.selectQuery(vofile, query);
		logger.debug("List Size"+codeList);
		return codeList;
	}
	/**
	 * 
	 * @param query
	 * @return
	 */
	public ArrayList driverMethod(String query) {
		// TODO Auto-generated method stub
		logger.debug("SparePartsDAO:driverMethod<----------");
		ArrayList driverNameList=new ArrayList();
		driverNameList=db.selectQuery(vofile,query);
		logger.debug("SparePartsDAO:driverMethod---------->");
		return driverNameList;
	}
	/**
	 * 
	 * @param query
	 * @return
	 */
	public ArrayList convertToSpareDesc(String query) {
		// TODO Auto-generated method stub
		logger.debug("SparePartsDAO:convertToSpareDesc<----------");
		ArrayList descList=new ArrayList();
		descList=db.selectQuery(vofile, query);
		logger.debug("SparePartsDAO:convertToSpareDesc---------->");
		return descList;
	}
	public ArrayList quantityMethod(String query) {
		// TODO Auto-generated method stub
		logger.debug("SparePartsDAO:quantityMethod<----------");
		ArrayList descList=new ArrayList();
		descList=db.selectQuery(vofile, query);
		logger.debug("SparePartsDAO:quantityMethod---------->");
		return descList;
	}
	public void updateExtra(String query) {
		// TODO Auto-generated method stub
		logger.debug("SparePartsDAO:updateExtra<---------->");
		db.otherQuery(query);
	}
	public void updateValues(String query) {
		// TODO Auto-generated method stub
		logger.debug("SparePartsDAO:updateValues<---------->");
		db.otherQuery(query);
	}
}
