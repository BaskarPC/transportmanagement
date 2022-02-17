package com.service;

import java.util.ArrayList;

import com.dao.PaintIssueDAO;


public class PaintIssueService {
	ArrayList instlist;
	PaintIssueDAO paintissueDAO=new PaintIssueDAO();
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
		paintissueDAO.insertCommon(inst,vehicletype,drname,rdrname,other,jobid);
	}
	public void insertCommonValues(int jobid,int totalqty,int wantedquantity,int oldavail,int oldrate,int amount)
	{
		paintissueDAO.insertCommonValues(jobid,totalqty,wantedquantity,oldavail,oldrate,amount);
	}
	/**
	 * to fetch values from db to display in form
	 * @param job
	 * @return
	 */

	public ArrayList fetchCommonValues(int job )
	{
		instlist=paintissueDAO.fetchCommonValues(job);
		return instlist;
	}
	/**
	 * to fetch values from db to display in form
	 * @param job
	 * @return
	 */

	public ArrayList fetchValues(int job )
	{
		instlist=paintissueDAO.fetchValues(job);
		return instlist;
	}
	
	public ArrayList fetchTypeValues()
	{
		instlist=paintissueDAO.fetchTypeValues();
		return instlist;
	}
	
	public ArrayList fetchColorValues(int id)
	{
		instlist=paintissueDAO.fetchColorValues(id);
		return instlist;
	}
	
	public ArrayList fetchRateValue1(int compid,int colorid)
	{
		instlist=paintissueDAO.fetchRateValue1(compid,colorid);
		return instlist;
	}
	
	public void updateOldQuantityValues(int compid,int colorid,int qty)
	{
		paintissueDAO.updateOldQuantityValues(compid,colorid,qty);
	}
	public void updateNewQuantityValues(int compid,int colorid,int qty)
	{
		paintissueDAO.updateNewQuantityValues(compid,colorid,qty);
	}
	public void updateValues(int compid,int colorid,int oldavail,int newavail,float oldrate,float newrate)
	{
		
		paintissueDAO.updateValues(compid,colorid,oldavail,newavail,oldrate,newrate);
		
	}
}
