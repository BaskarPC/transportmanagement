package com.util;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.dao.SparePartsDAO;
import com.dbcom.dbcom;

public class PaintIssueUtil {
	ArrayList instList=new ArrayList();
	dbcom db=new dbcom();
	 String vofile="com.vo.PaintIssueVO";
	 
	private static final Logger logger=(Logger)Logger.getLogger(PaintIssueUtil.class);
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
		String query="select PART_NUMBER as paintissuepartnumber,BRAND_NAME as paintissuebrandname,AVAILABLE_QTY as AVAILQTY,QTY_WANTED as WANTEDQTY,IQTY_OLD as SOLDQUANTITY,IQTY_NEW as spareissuenewqty,URATE_OLD as SOLDRATE,URATE_NEW as spareissuenewrate,AMOUNT as SAMOUNT from SPAREPARTS_PAINT where JOB_ID="+job+"";
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
	 * @param other
	 * @param jobid
	 */
	public void insertCommon(int inst,int vehicletype,int drname,int rdrname,String other,int jobid)
	{
		
		String query="insert into maintenance_master values("+inst+","+vehicletype+","+vehicletype+","+vehicletype+",SYSDATE,SYSDATE,"+drname+","+rdrname+","+rdrname+",'"+other+"','"+other+"',"+rdrname+","+rdrname+","+rdrname+",'n',"+jobid+","+jobid+")";
		db.otherQuery(query);
		logger.debug("institution list size="+instList.size());
	}
	public void insertCommonValues(int jobid,int totalqty,int wantedquantity,int oldavail,int oldrate,int amount)
	{
		
		String query="insert into SPAREPARTS_PAINT values("+jobid+","+jobid+","+jobid+","+jobid+","+jobid+","+totalqty+","+wantedquantity+","+oldavail+","+oldavail+","+oldrate+","+oldrate+","+amount+")";
		db.otherQuery(query);
		logger.debug("institution list size="+instList.size());
	}
	
}
