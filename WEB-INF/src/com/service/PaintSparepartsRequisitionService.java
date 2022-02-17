package com.service;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.dao.PaintSparepartsRequisitionDAO;

public class PaintSparepartsRequisitionService {
	private static final Logger logger=(Logger)Logger.getLogger(PaintSparepartsRequisitionService.class);
	ArrayList instlist;
	PaintSparepartsRequisitionDAO paintsparereqDAO=new PaintSparepartsRequisitionDAO();
	public ArrayList fetchTypeValues()
	{
		instlist=paintsparereqDAO.fetchTypeValues();
		return instlist;
	}
	public ArrayList fetchNameValues(String string)
	{
		instlist=paintsparereqDAO.fetchNameValues(string);
		return instlist;
	}
	public void insertCommon(int jobid,int reqItem,String reason)
	{
		paintsparereqDAO.insertCommon(jobid,reqItem,reason);
	}
	public void insertCommonValues(int jobid,int brandname,int brandtype,int wantedquantity,int available)
	{
		paintsparereqDAO.insertCommonValues(jobid,brandname,brandtype,wantedquantity,available);
	}
	public ArrayList fetchCommonValues(int id)
	{
		instlist=paintsparereqDAO.fetchCommonValues(id);
		return instlist;
	}
	public ArrayList fetchValues(int id)
	{
		instlist=paintsparereqDAO.fetchValues(id);
		return instlist;
	}
	public ArrayList fetchSpareLookupId()
	{
		instlist=paintsparereqDAO.fetchSpareLookupId();
		return instlist;
	}
	public ArrayList fetchSpareGroupQty()
	{
		instlist=paintsparereqDAO.fetchSpareGroupQty();
		return instlist;
	}
	public void insertLookupValues(String brandname,String brandtype,int id)
	{
		paintsparereqDAO.insertLookupValues(brandname,brandtype,id);
	}
}
