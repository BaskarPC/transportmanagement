package com.dao;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.dbcom.dbcom;

public class PaintSparepartsRequisitionDAO {
	ArrayList instList;
	dbcom db=new dbcom();
	String vofile="com.vo.PaintSparepartsRequisitionVO";
	private static final Logger logger=(Logger)Logger.getLogger(PaintSparepartsRequisitionDAO.class);
	public ArrayList fetchTypeValues()
	{
		
		String query="select ID as spareid,CODETYPE as sparetype from SPARELOOKUP where CODE='Spare'";
		instList=db.selectQuery(vofile,query);
		logger.debug("institution list size="+instList.size());
		return instList;
	}
	public ArrayList fetchNameValues(String string)
	{
		
		String query="select ID as spareid,CODETYPE as sparenumber from SPARELOOKUP WHERE CODE='"+string+"'";
		instList=db.selectQuery(vofile,query);
		logger.debug("institution list size="+instList.size());
		return instList;
	}
	public void insertCommon(int jobid,int reqItem,String reason)
	{
		
		String query="insert into sparepaint_requisition values("+jobid+",'"+jobid+"',SYSDATE,'"+reason+"',"+reqItem+","+reqItem+")";
		db.otherQuery(query);
		logger.debug("institution list size="+instList.size());
	}
	public void insertCommonValues(int jobid,int brandname,int brandtype,int wantedquantity,int available)
	{
		
		String query="insert into sparepaint_requisition_common values("+jobid+","+brandname+","+brandtype+","+wantedquantity+","+available+")";
		db.otherQuery(query);
		logger.debug("institution list size="+instList.size());
	}
	public ArrayList fetchCommonValues(int id)
	{
		
		String query="select REASON as sparereason,REQITEM as spareitem from sparepaint_requisition where jobid="+id+"";
		instList=db.selectQuery(vofile,query);
		logger.debug("institution list size="+instList.size());
		return instList;
	}
	public ArrayList fetchValues(int id)
	{
		
		String query="select BRANDNAME as sparebrandname,BRANDTYPE as sparebrandtype,WANTEDQUANTITY as sparewantedquantity,AVAILABLE as spareavailable from sparepaint_requisition_common where jobid="+id+"";
		instList=db.selectQuery(vofile,query);
		logger.debug("institution list size="+instList.size());
		return instList;
	}
	public ArrayList fetchSpareLookupId()
	{
		
		String query="select sparelookupid.NEXTVAL as sparesequence from dual";
		instList=db.selectQuery(vofile,query);
		logger.debug("institution list size="+instList.size());
		return instList;
	}
	
	public ArrayList fetchSpareGroupQty()
	{
		
		String query="SELECT SUM(QTY_PURCHASED) as sumqty FROM STORE_COMMON_TRANSACTION where TYPE='spare' GROUP BY PID";
		instList=db.selectQuery(vofile,query);
		logger.debug("institution list size="+instList.size());
		return instList;
	}
	public void insertLookupValues(String brandname,String brandtype,int id)
	{
		
		String query="insert into sparelookup values("+id+",'"+brandname+"','"+brandtype+"')";
		db.otherQuery(query);
		logger.debug("institution list size="+instList.size());
	}
}
