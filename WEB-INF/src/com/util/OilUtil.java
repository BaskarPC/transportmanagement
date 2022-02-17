package com.util;


import org.apache.log4j.Logger;



public class OilUtil {
	private static final Logger logger=(Logger)Logger.getLogger(OilUtil.class);
	
	public String fetchOil() 
	{
		// TODO Auto-generated method stub
		String query="select CDESC as ODESC,CODE as OCODE from LOOKUP where CTYPE='oiltype'";
		return query;
	}

	public String fetchOilReason() 
	{
	// TODO Auto-generated method stub
	String query="select CDESC as ORDESC,CODE as ORCODE from LOOKUP where CTYPE='oilreason'";
	return query;
	}
	
	public String previouslyServicedKmMethod(int vehnum) {
		// TODO Auto-generated method stub
		String query="select CURRENT_KM as OCURRENT_KM from GREASEOIL_KEROSENE where JOB_ID in(select MAX(JOB_ID) from MAINTENANCE_MASTER WHERE VEHICLE_NUMBER="+vehnum+" AND GOODS_TYPE=130)";
		return query;
	}
	
	public String quantityMethod(String partnumber) {
		// TODO Auto-generated method stub
		String query="select TOLD_QTY AS OIQTY_OLD,TNEW_QTY AS OIQTY_NEW,TOLD_RATE AS OURATE_OLD,TNEW_RATE AS OURATE_NEW,REORDER_LVL as RLVL,EXTRA_QTY as XQTY,EXTRA_RATE as XRATE from COMMON_TRANSACTION where SUBTYPE='"+partnumber+"'";
		return query;
	}
	
	public String insertmaster(int jobid, int INSTITUTION_NAME, int VEHICLE_TYPE, int VEHICLE_NUMBER, int BILL_NUMBER, String REQ_DATE, int DRIVER_NAME, String OTHER_REASON,int REQ_DRIVERNAME,int GOODS_TYPE, float totalAmount, int place, int service_station) {
		// TODO Auto-generated method stub
		String query="insert into MAINTENANCE_MASTER values("+INSTITUTION_NAME+","+VEHICLE_TYPE+","+VEHICLE_NUMBER+","+BILL_NUMBER+",'"+REQ_DATE+"','',"+DRIVER_NAME+","+REQ_DRIVERNAME+",'','"+OTHER_REASON+"','',"+GOODS_TYPE+","+place+","+service_station+",0,"+jobid+","+totalAmount+")";
		return query;
		}
	
	public String insert(int jobid, int ITEM_TYPE, float AVAILABLE_QTY, float QTY_WANTED, float IQTY_OLD, float IQTY_NEW, float URATE_OLD, float URATE_NEW, float AMOUNT, int REASON_REQ, int CURRENT_KM, int PREV_SERVICED_KM, int DIFFRENCE_KM) {
		// TODO Auto-generated method stub
		String query="insert into GREASEOIL_KEROSENE values("+jobid+","+ITEM_TYPE+","+AVAILABLE_QTY+","+QTY_WANTED+","+IQTY_OLD+","+IQTY_NEW+","+URATE_OLD+","+URATE_NEW+","+AMOUNT+","+REASON_REQ+","+CURRENT_KM+","+PREV_SERVICED_KM+","+DIFFRENCE_KM+")";
		return query;
		
	}
	
	public String retrieveMaster(int job) {
		// TODO Auto-generated method stub
		String query="select INSTITUTION_NAME,VEHICLE_TYPE,VEHICLE_NUMBER,BILL_NUMBER,REQ_DATE,OTHER_REASON,DRIVER_NAME AS DRIVERNAME,REQ_DRIVERNAME FROM MAINTENANCE_MASTER WHERE JOB_ID="+job+"";
		return query;
	}
	
	public String retrieve(int job) {
		// TODO Auto-generated method stub
		String query="select ITEM_TYPE as OITEM_TYPE,REASON_REQ as OREASON_REQ,QTY_WANTED as OQTY_WANTED,AVAILABLE_QTY as OAVAILABLE_QTY,IQTY_OLD as OIQTY_OLD,IQTY_NEW as OIQTY_NEW,URATE_OLD as OURATE_OLD,URATE_NEW as OURATE_NEW,AMOUNT as OAMOUNT,CURRENT_KM as OCURRENT_KM,PREV_SERVICED_KM as OPREV_SERVICED_KM,DIFFERNCE_KM as ODIFFERNCE_KM from GREASEOIL_KEROSENE WHERE JOB_ID ="+job+"";
		return query;
	}
	 public String updateValues(float toldqty, float tnewqty, String itemname, String subtype) {
			// TODO Auto-generated method stub
			 logger.debug("OilUtil:updateValues<---------->");
			String query="update COMMON_TRANSACTION set TOLD_QTY="+toldqty+",TNEW_QTY="+tnewqty+" where ITEMNAME='"+itemname+"' and SUBTYPE='"+subtype+"'";
			return query;
			}

	public String updateValuestemporary(float oldavail, float newavail, float oldrate, float newrate, String itemname, String subtype) {
		// TODO Auto-generated method stub
		 logger.debug("OilUtil:updateValuestemporary<---------->");
			String query="update COMMON_TRANSACTION set OLD_QTY="+oldavail+",NEW_QTY="+newavail+",OLD_RATE="+oldrate+",NEW_RATE="+newrate+" where ITEMNAME='"+itemname+"' and SUBTYPE='"+subtype+"'";
			return query;
		 }
	public String updateExtra(float toldqty, float tnewqty, float oldrate, float newrate, String itemname, String subtype) {
			// TODO Auto-generated method stub
			 logger.debug("OilUtil:updateExtra<---------->");
			String query="update COMMON_TRANSACTION set TOLD_QTY="+toldqty+",TNEW_QTY="+tnewqty+",TOLD_RATE="+oldrate+",TNEW_RATE ="+newrate+" where ITEMNAME='"+itemname+"' and SUBTYPE='"+subtype+"'";
			return query;
		 }

	public String updateDate(int jobid) {
		// TODO Auto-generated method stub
		String query="update MAINTENANCE_MASTER set ISSUE_DATE=SYSDATE where JOB_ID='"+jobid+"'";
		return query;
	}

}
