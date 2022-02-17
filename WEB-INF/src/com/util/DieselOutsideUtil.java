package com.util;

import org.apache.log4j.Logger;

public class DieselOutsideUtil {
	private static final Logger logger=(Logger)Logger.getLogger(DieselOutsideUtil.class);
	public String fetchFuel()throws Exception
	{
		String ctype="fueltype";
    	String query= new StringBuffer("select CDESC as FTDESC,CODE as FTCODE from ")	
		.append("LOOKUP ")
		.append("where CTYPE='")
		.append(ctype)
	 	.append("'").toString();
	    return query;
	}
	public String lastFillingKmMethod(String vehnum,int code) {
		// TODO Auto-generated method stub
		String query="select PRESENTKM FROM PRESENTKM where JOB_ID in(select MAX(JOB_ID) from MAINTENANCE_MASTER WHERE VEHICLE_NUMBER ="+vehnum+" AND GOODS_TYPE="+code+")";
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
		String query="select KM_TRAVELLED as PRESENTKM from vehicle_purchase where VEHICLE_ID="+vehnum+")";
		return query;
	}
	public String insertmaster(int jobid, int institution_name, int vehicle_type, int vehicle_number, int bill_number, String req_date, int driver_name, int req_drivername, int route_number,int goodstype,int place, int service_station, float amount) {
		// TODO Auto-generated method stub
		String query="insert into MAINTENANCE_MASTER values("+institution_name+","+vehicle_type+","+vehicle_number+","+bill_number+",'"+req_date+"','',"+driver_name+","+req_drivername+","+route_number+",'','',"+goodstype+","+place+","+service_station+",0,"+jobid+","+amount+")";
	    return query;
	}

	public String insert(int jobid,float qty_wanted, float unitrate, float amount, int presentkm, int last_km, int diff_km, float avg_km, String remarks, int fueltype, int bunkname, String other_bunk) {
		// TODO Auto-generated method stub
		String query="insert into FUELENTRY_OUTSIDE values("+jobid+","+fueltype+","+bunkname+",'"+other_bunk+"',"+qty_wanted+","+unitrate+","+amount+","+presentkm+","+last_km+","+diff_km+","+avg_km+","+remarks+")";
		return query;
	}
	public String retrieveMaster(int job) {
		String query="select INSTITUTION_NAME,VEHICLE_TYPE,VEHICLE_NUMBER,BILL_NUMBER,REQ_DATE,ROUTE_NUMBER AS ROUTENUMBER,DRIVER_NAME AS DRIVERNAME,REQ_DRIVERNAME FROM MAINTENANCE_MASTER WHERE JOB_ID="+job+"";
		return query;
	}
	
	public String retrieve(int job) {
		// TODO Auto-generated method stub
		String query="select FUELTYPE,BUNKNAME,OTHER_BUNK,QTY_WANTED,URATE,AMOUNT,PRESENTKM,DIFF_KM,LAST_KM,AVG_KM,REMARKS from FUELENTRY_OUTSIDE WHERE JOB_ID="+job+"";
		return query;
	}

	}
	

