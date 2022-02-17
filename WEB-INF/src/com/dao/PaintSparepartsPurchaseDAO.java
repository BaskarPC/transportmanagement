package com.dao;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.dbcom.dbcom;

public class PaintSparepartsPurchaseDAO {
	ArrayList instList;
	dbcom db=new dbcom();
	String vofile="com.vo.PaintSparepartsPurchaseVO";
	private static final Logger logger=(Logger)Logger.getLogger(PaintSparepartsPurchaseDAO.class);
	public ArrayList fetchValues(int job)
	{
		
		String query="select PID AS WANTEDPID,QTY_PURCHASED as WANTEDQTY1,UNIT_PRICE as WANTEDPRICE1 from STORE_COMMON_TRANSACTION where TYPE='spare' and jid="+job+"";
		instList=db.selectQuery(vofile,query);
		logger.debug("institution list size="+instList.size());
		return instList;
	}
	public void insertCommon(String pid,int brandtype,int qty,float price)
	{
		
		String query="insert into COMMON_TRANSACTION values('"+pid+"','spare',"+brandtype+","+qty+",0,"+price+",0,"+qty+",0)";
		db.otherQuery(query);
		logger.debug("institution list size="+instList.size());
	}
	public ArrayList fetchBillNumber()
	{
		
		String query="select billno.NEXTVAL as billsequence from dual";
		instList=db.selectQuery(vofile,query);
		logger.debug("institution list size="+instList.size());
		return instList;
	}
	
	public void updateValues(String pid,int oldavail,int newavail,float oldrate,float newrate)
	{
		
		String query="update COMMON_TRANSACTION set OLD_RATE="+oldrate+",NEW_RATE="+newrate+",TOLD_QTY="+oldavail+",TNEW_QTY="+newavail+" where PARTNUMBER='"+pid+"'";
		db.otherQuery(query);
		logger.debug("institution list size="+instList.size());
	}
	public void insertSupplierValues(int jobid,String billdt,int billno,String deldt,int compname,int place,int goodstype)
	{
		
		String query="insert into supplier_details values("+jobid+",'"+billdt+"',"+billno+",'"+deldt+"',"+compname+","+place+","+goodstype+",'n')";
		db.otherQuery(query);
		logger.debug("institution list size="+instList.size());
	}
	public void insertCommonValues(int jobid,int brandtype,int pid,int qty)
	{
		
		String query="insert into spare_purchase values("+jobid+","+brandtype+","+brandtype+","+pid+","+qty+")";
		db.otherQuery(query);
		logger.debug("institution list size="+instList.size());
	}
	
	public void insertAmountValues(int jobid,int qty,int rate,int vatpercent,int vatamt,int addamt,int amt,int tot)
	{
		
		String query="insert into transaction_amount values("+jobid+","+qty+","+rate+","+vatpercent+","+vatamt+","+addamt+","+amt+","+tot+")";
		db.otherQuery(query);
		logger.debug("institution list size="+instList.size());
	}
}
