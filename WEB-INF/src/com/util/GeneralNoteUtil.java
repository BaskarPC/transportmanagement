package com.util;

import org.apache.log4j.Logger;

public class GeneralNoteUtil {
	private static final Logger logger=(Logger)Logger.getLogger(GeneralNoteUtil.class);
		
	public String fetchGeneralNote() {
		// TODO Auto-generated method stub
		String query="select CDESC as GNDESC,CODE as GNCODE from LOOKUP where ctype='generalnote'";
		return query;
	}
	
	public String quantityMethod(String partnumber) {
		// TODO Auto-generated method stub
		String query="select TOLD_QTY AS GNIQTY_OLD,TNEW_QTY AS GNIQTY_NEW from COMMON_TRANSACTION1 where SUBTYPE ='"+partnumber+"'";
		return query;
	}
	public String insertmaster(int jobid, int INSTITUTION_NAME, int VEHICLE_TYPE, int VEHICLE_NUMBER, int BILL_NUMBER, String REQ_DATE, int DRIVER_NAME, String OTHER_REASON,int REQ_DRIVERNAME,int GOODS_TYPE) {
		// TODO Auto-generated method stub
		String query="insert into MAINTENANCE_MASTER values("+INSTITUTION_NAME+","+VEHICLE_TYPE+","+VEHICLE_NUMBER+","+BILL_NUMBER+",'"+REQ_DATE+"','1-MAR-99',"+DRIVER_NAME+","+REQ_DRIVERNAME+",'','"+OTHER_REASON+"','',"+GOODS_TYPE+",'','','',"+jobid+",5)";
		return query;
		}
	
	public String insert(int jobid, int ITEM_TYPE, float available_qty, float qty_wanted, float URATE, float AMOUNT, int REASON_REQ) {
		// TODO Auto-generated method stub
		String query="insert into GENERAL_WASTECLOTH values("+jobid+",5,23,"+ITEM_TYPE+","+available_qty+","+qty_wanted+","+REASON_REQ+","+URATE+","+AMOUNT+")";
		return query;
		
	}
	
	public String retrieveMaster(int job) {
		// TODO Auto-generated method stub
		String query="select INSTITUTION_NAME,VEHICLE_TYPE,VEHICLE_NUMBER,BILL_NUMBER,REQ_DATE,OTHER_REASON,DRIVER_NAME AS DRIVERNAME,REQ_DRIVERNAME FROM MAINTENANCE_MASTER WHERE JOB_ID="+job+"";
		return query;
	}
	
	public String retrieve(int job) {
		// TODO Auto-generated method stub
		String query="select ITEM_DESC as GNITEM_TYPE,REASON_REQ as GNREASON_REQ,QTY_WANTED as GNQTY_WANTED,AVAILABLE_QTY as GNAVAILABLE_QTY,URATE as GNURATE,AMOUNT as GNAMOUNT from GREASEOIL_KEROSENE WHERE JOB_ID ="+job+"";
		return query;
	}
}
