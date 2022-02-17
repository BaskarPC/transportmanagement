package com.util;

import org.apache.log4j.Logger;

public class PassingBillUtil {
	private static final Logger logger=(Logger)Logger.getLogger(PassingBillUtil.class);
	String query=null;
	/**
	 * retrieve purchase issue type
	 * @return
	 * @throws Exception
	 */
	public String fetchType()throws Exception
	{
		logger.debug("PassingBillUtil:fetchType<----------");
		String ctype="passingbilltype";
    	String query= new StringBuffer("select CDESC as PDESC,CODE as PCODE from ")	
		.append("LOOKUP ")
		.append("where CTYPE='")
		.append(ctype)
	 	.append("'").toString();
    	logger.debug("PassingBillUtil:fetchType---------->");
	    return query;
	}
	public String fetchGoodsType(String ptype) {
		// TODO Auto-generated method stub
		logger.debug("PassingBillUtil:fetchGoodsType<----------");
		if(ptype.equals("Purchase"))
			query="select CDESC as GODESC,CODE as GOCODE from LOOKUP where CODE in (select distinct(GOODS_TYPE) from STORE_SUPPLIER where BILL_PASSED=0)";
		else if(ptype.equals("Issue"))
			query="select CDESC as GODESC,CODE as GOCODE from LOOKUP where CODE in (select distinct(GOODS_TYPE) from MAINTENANCE_MASTER where BILL_PASSED=0)";
		logger.debug("PassingBillUtil:fetchGoodsType---------->");
	    return query;
	}
	public String fetchBillNumbers(int ptype, String type) {
		// TODO Auto-generated method stub
		if(type.equals("Purchase"))
				query="select BILL_NUMBER as BDESC from STORE_SUPPLIER";
		else if(type.equals("Issue"))
				query="select BILL_NUMBER as BDESC from MAINTENANCE_MASTER where GOODS_TYPE="+ptype+"";	
		return query;
	}
	public String fetchServiceDetails(String ptype, int billnumber, String goodstype) {
		// TODO Auto-generated method stub
		if(ptype.equals("Purchase"))
			query="select BILL_NUMBER as BDESC from STORE_SUPPLIER";
	else if(ptype.equals("Issue"))
			query="select INSTITUTION_NAME,VEHICLE_NUMBER,SERVICE_STATION,PLACE AS SERVICEPLACE,ISSUE_DATE,TOTALAMOUNT as BILLAMOUNT from MAINTENANCE_MASTER where GOODS_TYPE="+goodstype+" AND BILL_NUMBER="+billnumber+"";	
	return query;
	}
	public String insertmaster(int jobid, int institutionname, int vehiclenumber, int billnumber, String requesteddate, int location, int servicename, String billdate) {
		// TODO Auto-generated method stub
		String query="insert into MAINTENANCE_MASTER values("+institutionname+",0,"+vehiclenumber+","+billnumber+",'"+requesteddate+"','"+billdate+"',0,0,'','','',0,"+location+","+servicename+",1,"+jobid+",0)";
		return query;
	}
	public String insert(int jobid, int passingbillnumber, String headofaccdebit, int purchaseissue, int producttype, float amount) {
		// TODO Auto-generated method stub
		String query="insert into PASSINGBILL values(jobid,purchaseissue,passingbillnumber,headofaccdebit,amount,producttype)";
		return query;
	}
	public String updateBillPassed(String vehiclenumber, String purchaseissue, int producttype, String servicename) {
		// TODO Auto-generated method stub 
		if(purchaseissue.equals("Purchase"))
			query="update STORE_SUPPLIER set BILLPASSED=1 where COMPANY_NAME="+servicename+" and GOODS_TYPE="+producttype+"";
		else if (purchaseissue.equals("Issue"))
			query="update MAINTENANCE_MASTER set BILLPASSED=1 where VEHICLE_NUMBER="+vehiclenumber+" and SERVICE_STATION="+servicename+"";
		return query;
	}
}
