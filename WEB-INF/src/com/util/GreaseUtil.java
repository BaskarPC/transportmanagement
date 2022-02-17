package com.util;

import org.apache.log4j.Logger;

public class GreaseUtil {
	private static final Logger logger=(Logger)Logger.getLogger(GreaseUtil.class);
	
	public String fetchGrease() 
	{
		String query="select CDESC as GDESC,CODE as GCODE from LOOKUP where CTYPE='greasetype'";
		return query;
	}

	public String fetchGreaseReason() 
	{
		String query="select CDESC as GRDESC,CODE as GRCODE from LOOKUP where CTYPE='greasereason'";
		return query;
	}
	
	public String quantityMethod(String partnumber) {
		String query="select TOLD_QTY AS GIQTY_OLD,TNEW_QTY AS GIQTY_NEW,OLD_RATE AS GURATE_OLD,NEW_RATE AS GURATE_NEW from COMMON_TRANSACTION where SUBTYPE ='"+partnumber+"'";
		return query;
	}
	
	public String insertmaster(int jobid, int INSTITUTION_NAME, int VEHICLE_TYPE, int VEHICLE_NUMBER, int BILL_NUMBER, String REQ_DATE, int DRIVER_NAME, String OTHER_REASON,int REQ_DRIVERNAME,int GOODS_TYPE, float totalAmount, int place, int service_station) {
		String query="insert into MAINTENANCE_MASTER values("+INSTITUTION_NAME+","+VEHICLE_TYPE+","+VEHICLE_NUMBER+","+BILL_NUMBER+",'"+REQ_DATE+"','',"+DRIVER_NAME+","+REQ_DRIVERNAME+",'','"+OTHER_REASON+"','',"+GOODS_TYPE+","+place+","+service_station+",0,"+jobid+","+totalAmount+")";
		return query;
	}
	
	public String insert(int jobid, int ITEM_TYPE, float available_qty, float qty_wanted, float iqty_old, float iqty_new, float URATE_OLD, float URATE_NEW, float AMOUNT, int REASON_REQ) {
		String query="insert into GREASEOIL_KEROSENE values("+jobid+","+ITEM_TYPE+","+available_qty+","+qty_wanted+","+iqty_old+","+iqty_new+","+URATE_OLD+","+URATE_NEW+","+AMOUNT+","+REASON_REQ+",0,0,0)";
		return query;	
	}
	
	public String retrieveMaster(int job) {
		String query="select INSTITUTION_NAME,VEHICLE_TYPE,VEHICLE_NUMBER,BILL_NUMBER,REQ_DATE,OTHER_REASON,DRIVER_NAME AS DRIVERNAME,REQ_DRIVERNAME FROM MAINTENANCE_MASTER WHERE JOB_ID="+job+"";
		return query;
	}
	
	public String retrieve(int job) {
		String query="select ITEM_TYPE as GITEM_TYPE,REASON_REQ as GREASON_REQ,QTY_WANTED as GQTY_WANTED,AVAILABLE_QTY as GAVAILABLE_QTY,IQTY_OLD as GIQTY_OLD,IQTY_NEW as GIQTY_NEW,URATE_OLD as GURATE_OLD,URATE_NEW as GURATE_NEW,AMOUNT as GAMOUNT from GREASEOIL_KEROSENE WHERE JOB_ID ="+job+"";
		return query;
	}
	public String updateValuestemporary(float oldavail, float newavail, float oldrate, float newrate, String itemname, String subtype) {
		 logger.debug("GreaseUtil:updateValuestemporary<---------->");
			String query="update COMMON_TRANSACTION set OLD_QTY="+oldavail+",NEW_QTY="+newavail+",OLD_RATE="+oldrate+",NEW_RATE="+newrate+" where ITEMNAME='"+itemname+"' and SUBTYPE='"+subtype+"'";
			return query;
	}
	public String updateDate(int jobid) {
		String query="update MAINTENANCE_MASTER set ISSUE_DATE=SYSDATE where JOB_ID='"+jobid+"'";
		return query;
	}	
	 public String updateValues(float toldqty, float tnewqty, String itemname, String subtype) {
			 logger.debug("GreaseUtil:updateValues<---------->");
			String query="update COMMON_TRANSACTION set TOLD_QTY="+toldqty+",TNEW_QTY="+tnewqty+" where ITEMNAME='"+itemname+"' and SUBTYPE='"+subtype+"'";
			return query;
			}
	 public String updateExtra(float toldqty, float tnewqty, float oldrate, float newrate, String itemname, String subtype) {
			 logger.debug("GreaseUtil:updateExtra<---------->");
			String query="update COMMON_TRANSACTION set TOLD_QTY="+toldqty+",TNEW_QTY="+tnewqty+",TOLD_RATE="+oldrate+",TNEW_RATE ="+newrate+" where ITEMNAME='"+itemname+"' and SUBTYPE='"+subtype+"'";
			return query;
		 }
}
