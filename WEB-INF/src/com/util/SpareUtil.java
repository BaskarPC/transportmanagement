package com.util;

import org.apache.log4j.Logger;

public class SpareUtil {
	private static final Logger logger=(Logger)Logger.getLogger(SpareUtil.class);

	public String convertToSpareDesc(String itemDescription) {
		// TODO Auto-generated method stub
		logger.debug("SpareUtil:convertToSpareDesc<---------->");
		String query="select CODETYPE as CONV from SPARELOOKUP where ID="+itemDescription+"";
		return query;
	}

	public String quantityMethod(String partnumber) {
		// TODO Auto-generated method stub
		String query="select TOLD_QTY AS GIQTY_OLD,TNEW_QTY AS GIQTY_NEW,OLD_RATE AS GURATE_OLD,NEW_RATE AS GURATE_NEW from COMMON_TRANSACTION where SUBTYPE ='"+partnumber+"'";
		return query;
	}
	public String updateValues(float toldqty, float tnewqty, String itemname, String subtype) 
	{
		logger.debug("SpareUtil:updateValues<---------->");
		String query="update COMMON_TRANSACTION set TOLD_QTY="+toldqty+",TNEW_QTY="+tnewqty+" where ITEMNAME='"+itemname+"' and SUBTYPE='"+subtype+"'";
		return query;
	}
	public String updateExtra(float toldqty, float tnewqty, float oldrate, float newrate, String itemname, String subtype) 
	{
		logger.debug("SpareUtil:updateExtra<---------->");
		String query="update COMMON_TRANSACTION set TOLD_QTY="+toldqty+",TNEW_QTY="+tnewqty+",TOLD_RATE="+oldrate+",TNEW_RATE ="+newrate+" where ITEMNAME='"+itemname+"' and SUBTYPE='"+subtype+"'";
		return query;
	 }
}
