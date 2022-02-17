package com.dao;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.dbcom.dbcom;
import com.util.PaintIssueUtil;

public class PaintIssueDAO {
	ArrayList instlist;
	dbcom db=new dbcom();
	 String vofile="com.vo.PaintIssueVO";
	 private static final Logger logger=(Logger)Logger.getLogger(PaintIssueDAO.class);
	PaintIssueUtil util=new PaintIssueUtil();
	
	/**
	 * to insert the values into maintenance table
	 * @param inst
	 * @param vehicletype
	 * @param drname
	 * @param rdrname
	 * @param other
	 * @param jobid
	 */
	public void insertCommon(int inst,int vehicletype,int drname,int rdrname,String other,int jobid)
	{
		util.insertCommon(inst,vehicletype,drname,rdrname,other,jobid);
	}
	
	
	/**
	 * 
	 * @param jobid
	 * @param totalqty
	 * @param wantedquantity
	 * @param oldavail
	 * @param oldrate
	 * @param amount
	 */
	public void insertCommonValues(int jobid,int totalqty,int wantedquantity,int oldavail,int oldrate,int amount)
	{
		util.insertCommonValues(jobid,totalqty,wantedquantity,oldavail,oldrate,amount);
	}
	
	/**
	 * to fetch values from db to display in form
	 * @param job
	 * @return
	 */
	public ArrayList fetchCommonValues(int job )
	{
		instlist=util.fetchCommonValues(job);
		return instlist;
	}
	
	/**
	 * to fetch values from db to display in form
	 * @param job
	 * @return
	 */

	public ArrayList fetchValues(int job )
	{
		instlist=util.fetchValues(job);
		return instlist;
	}
	
	public ArrayList fetchTypeValues()
	{
		
		String query="select id as paintid,codetype as painttype from paintlookup";
		instlist=db.selectQuery(vofile,query);
		logger.debug("institution list size="+instlist.size());
		return instlist;
	}
	
	public ArrayList fetchColorValues(int id)
	{
		
		String query="select distinct(c.id) as paintid,c.codetype as paintcolor from paintlookup p,paint_company_lookup c where p.id=c.code and c.code="+id+"";
		instlist=db.selectQuery(vofile,query);
		logger.debug("institution list size="+instlist.size());
		return instlist;
	}
	
	/**
	 * to fetch the old & new rate,temporary quantities
	 */
	public ArrayList fetchRateValue1(int compid,int colorid)
	{
		
		String query="select OLD_RATE as tempoldrate,NEW_RATE as tempnewrate,TOLD_QTY as tempoldqty,TNEW_QTY as tempnewqty FROM PAINT_COMMON_TRANSACTION st WHERE st.COMPNAME="+compid+" and st.SUBTYPE="+colorid+"";
		instlist=db.selectQuery(vofile,query);
		logger.debug("institution list size="+instlist.size());
		return instlist;
	}
	
	/**
	 * to update the temporary old quantities
	 * @param pid
	 * @param qty
	 */
	public void updateOldQuantityValues(int compid,int colorid,int qty)
	{
		
		String query="update PAINT_COMMON_TRANSACTION set TOLD_QTY="+qty+" where COMPNAME="+compid+" and SUBTYPE="+colorid+"";
		db.otherQuery(query);
		logger.debug("institution list size="+instlist.size());
	}
	
	/**
	 * to update the temporary new quantities
	 * @param pid
	 * @param qty
	 */
	public void updateNewQuantityValues(int compid,int colorid,int qty)
	{
		
		String query="update PAINT_COMMON_TRANSACTION set TNEW_QTY="+qty+" where COMPNAME="+compid+" and SUBTYPE="+colorid+"";
		db.otherQuery(query);
		logger.debug("institution list size="+instlist.size());
	}
	
	public void updateValues(int compid,int colorid,int oldavail,int newavail,float oldrate,float newrate)
	{
		
		String query="update PAINT_COMMON_TRANSACTION set OLD_QTY="+oldavail+",NEW_QTY="+newavail+",OLD_RATE="+oldrate+",NEW_RATE="+newrate+",TOLD_QTY="+oldavail+",TNEW_QTY="+newavail+" where COMPNAME="+compid+" and SUBTYPE="+colorid+"";
		db.otherQuery(query);
		logger.debug("institution list size="+instlist.size());
	}
}
