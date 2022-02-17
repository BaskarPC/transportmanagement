package com.service;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.apache.struts.upload.FormFile;

import com.dao.DieselPurchaseDAO;

public class DieselPurchaseService {
	private static final Logger logger=(Logger)Logger.getLogger(DieselPurchaseService.class);
	ArrayList list=null;
	DieselPurchaseDAO dao=new DieselPurchaseDAO();
	public String fetchCompany(int jobid)
	{
		logger.debug("insert :DieselRequisitionService <<<<<<<<<<<<<<< ");
		String name=dao.fetchCompany(jobid);
		logger.debug("insert :DieselRequisitionService >>>>>>>>>>>>>>> ");
		return name;
	}
	public void insertSupplier(int sid,int jobid,String date,String billno,String delivereddate,String cname,String place,String reqitem)
	{
		
		dao.insertSupplier(sid,jobid,date,billno,delivereddate,cname,place,reqitem);
	}
	public void insertProduct(String partno,int jobid,int sid,String load,String vno,String dname,String damount,String dtime,String tipscale)
	{
		
		dao.insertProduct(partno,jobid,sid,load,vno,dname,damount,dtime,tipscale);
	}
	public void insertVat(int jobid,int sid,String brandname,String brandcategory,String partno,int quantity,float unitprice,float vatpercent,float vatamount,float additionalamount,float amount)
	{
		dao.insertVat(jobid,sid,brandname,brandcategory,partno,quantity,unitprice,vatpercent,vatamount,additionalamount,amount);
	}
	public String fetchPartNo(String item)
	{
		String partno=dao.fetchpartno(item);
		return partno;
	}
	public void insertcommontrans(float unitprice,int quantity)
	{
		dao.insertcommontrans(unitprice, quantity);
	}
	
	public int getsid()
	{
		int sid=dao.getsid();
		return sid;
	}
}
