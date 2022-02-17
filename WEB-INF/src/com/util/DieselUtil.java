package com.util;

import org.apache.log4j.Logger;

public class DieselUtil {
	private static final Logger logger=(Logger)Logger.getLogger(DieselUtil.class);
	/**
	 * 
	 * @param jobid
	 * @param INSTITUTION_NAME
	 * @param VEHICLE_TYPE
	 * @param VEHICLE_NUMBER
	 * @param BILL_NUMBER
	 * @param REQ_DATE
	 * @param DRIVER_NAME
	 * @param OTHER_REASON
	 * @param REQ_DRIVERNAME
	 * @param ROUTE_NUMBER
	 * @param GOODS_TYPE
	 * @param service_station 
	 * @param place 
	 * @param amount 
	 * @return
	 */
	public String insertmaster(int jobid, int INSTITUTION_NAME, int VEHICLE_TYPE, int VEHICLE_NUMBER, int BILL_NUMBER, String REQ_DATE, int DRIVER_NAME, String OTHER_REASON,int REQ_DRIVERNAME,int ROUTE_NUMBER,int GOODS_TYPE, int place, int service_station, float amount) {
		// TODO Auto-generated method stub
		logger.debug("DieselUtil:insertmaster<---------->");
		String query="insert into MAINTENANCE_MASTER values("+INSTITUTION_NAME+","+VEHICLE_TYPE+","+VEHICLE_NUMBER+","+BILL_NUMBER+",'"+REQ_DATE+"','',"+DRIVER_NAME+","+REQ_DRIVERNAME+","+ROUTE_NUMBER+",'"+OTHER_REASON+"','',"+GOODS_TYPE+","+place+","+service_station+",0,"+jobid+","+amount+")";
		return query;
	}
	/**
	 * 
	 * @param jobid
	 * @param QTY_WANTED
	 * @param IQTY_OLD
	 * @param IQTY_NEW
	 * @param URATE_OLD
	 * @param URATE_NEW
	 * @param AMOUNT
	 * @param PRESENTKM
	 * @param LAST_KM
	 * @param DIFF_KM
	 * @param AVG_KM
	 * @param REMARKS
	 * @param STOCK
	 * @param OPEN_READING
	 * @param CLOSE_READING
	 * @param BALANCE
	 * @param CONSUMTION_LITERS
	 * @return
	 */
	public String insert(int jobid, int QTY_WANTED, int IQTY_OLD, int IQTY_NEW, float URATE_OLD, float URATE_NEW, float AMOUNT, int PRESENTKM, int LAST_KM, int DIFF_KM, float AVG_KM, String REMARKS, int STOCK, int OPEN_READING, int CLOSE_READING, int BALANCE, int CONSUMTION_LITERS) {
		// TODO Auto-generated method stub
		logger.debug("DieselUtil:insert<---------->");
		String query="insert into FUELENTRY_INSIDE values("+jobid+","+QTY_WANTED+","+IQTY_OLD+","+IQTY_NEW+","+URATE_OLD+","+URATE_NEW+","+AMOUNT+","+PRESENTKM+","+LAST_KM+","+DIFF_KM+","+AVG_KM+",'"+REMARKS+"',"+STOCK+","+OPEN_READING+","+CLOSE_READING+","+BALANCE+","+CONSUMTION_LITERS+")";
		return query;
	}
	
	/**
	 * 
	 * @param job
	 * @return
	 */
	public String retrieveMaster(int job) {
		// TODO Auto-generated method stub
		logger.debug("DieselUtil:retrieveMaster<---------->");
		String query="select INSTITUTION_NAME,VEHICLE_TYPE,VEHICLE_NUMBER,BILL_NUMBER,REQ_DATE,ROUTE_NUMBER AS ROUTENUMBER,OTHER_REASON,DRIVER_NAME AS DRIVERNAME,REQ_DRIVERNAME FROM MAINTENANCE_MASTER WHERE JOB_ID="+job+"";
		return query;
	}
	
	/**
	 * 
	 * @param job
	 * @return
	 */
	public String retrieve(int job) {
		// TODO Auto-generated method stub
		logger.debug("DieselUtil:retrieve<---------->");
		String query="select QTY_WANTED,IQTY_OLD,IQTY_NEW,URATE_OLD,URATE_NEW,AMOUNT,PRESENTKM,DIFF_KM,LAST_KM,AVG_KM,REMARKS,STOCK,OPEN_READING,CLOSE_READING,CONSUMTION_LITERS,BALANCE from FUELENTRY_INSIDE WHERE JOB_ID ="+job+"";
		return query;
	}

	/**
	 * 
	 * @param code
	 * @return
	 */
	 public String quantityMethod(String code) {
		// TODO Auto-generated method stub
		 logger.debug("DieselUtil:quantityMethod<---------->");
		String query="select TNEW_QTY AS IQTY_NEW,TOLD_QTY AS IQTY_OLD,TNEW_RATE AS URATE_NEW,TOLD_RATE AS URATE_OLD,EXTRA_QTY as XQTY,EXTRA_RATE as XRATE from COMMON_TRANSACTION where SUBTYPE ='"+code+"'";
		return query;
	}

	/**
	 * 
	 * @param vehnum
	 * @param code
	 * @return
	 */
	 public String lastFillingKmMethod(String vehnum,int code) {
		// TODO Auto-generated method stub
		 logger.debug("DieselUtil:lastFillingKmMethod<---------->");
		String query="select PRESENTKM from PRESENTKM where JOB_ID in(select MAX(JOB_ID) from MAINTENANCE_MASTER WHERE VEHICLE_NUMBER ="+vehnum+" AND GOODS_TYPE="+code+")";
		return query;
	}
	 /**
		 * 
		 * @param vehnum
		 * @param code
		 * @return
		 */
		 public String vehiclepurchaseMethod(String vehnum) {
			// TODO Auto-generated method stub
			logger.debug("DieselUtil:vehiclepurchaseMethod<---------->");
			String query="select KM_TRAVELLED as PRESENTKM from vehicle_purchase where VEHICLE_ID="+vehnum+"";
			return query;
		}
	/**
	 * 
	 * @return
	 */
	 public String differenceMethod() {
		// TODO Auto-generated method stub
		 logger.debug("DieselUtil:differenceMethod<---------->");
		String query="select CLOSE_READING from FUELENTRY_INSIDE where JOB_ID in(select MAX(JOB_ID) from FUELENTRY_INSIDE)";
		return query;
	 }
	 public String updateValues(int oldavail, int newavail, String itemname, String subtype) {
		// TODO Auto-generated method stub
		 logger.debug("DieselUtil:updateValues<---------->");
		String query="update COMMON_TRANSACTION set TOLD_QTY="+oldavail+",TNEW_QTY="+newavail+" where ITEMNAME='"+itemname+"' and SUBTYPE='"+subtype+"'";
		return query;
		}
	 public String updateValuestemporary(int oldavail, int newavail, float oldrate, float newrate, String itemname, String subtype) {
		// TODO Auto-generated method stub
		 logger.debug("DieselUtil:updateValuestemporary<---------->");
		String query="update COMMON_TRANSACTION set OLD_QTY="+oldavail+",NEW_QTY="+newavail+",OLD_RATE="+oldrate+",NEW_RATE="+newrate+" where ITEMNAME='"+itemname+"' and SUBTYPE='"+subtype+"'";
		return query;
	 }
	 public String updateExtra(int toldqty, int tnewqty, float oldrate, float newrate, String itemname, String subtype) {
		// TODO Auto-generated method stub
		 logger.debug("DieselUtil:updateExtra<---------->");
		String query="update COMMON_TRANSACTION set TOLD_QTY="+toldqty+",TNEW_QTY="+tnewqty+",TOLD_RATE="+oldrate+",TNEW_RATE ="+newrate+" where ITEMNAME='"+itemname+"' and SUBTYPE='"+subtype+"'";
		return query;
	 }
	public String updateDate(int jobid) {
		// TODO Auto-generated method stub
		String query="update MAINTENANCE_MASTER set ISSUE_DATE=SYSDATE where JOB_ID='"+jobid+"'";
		return query;
	}
	}

	

