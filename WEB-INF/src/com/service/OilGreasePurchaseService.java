package com.service;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.dao.OilGreasePurchaseDAO;
import com.dao.OilGreaseRequisitionDAO;

public class OilGreasePurchaseService {
	private static final Logger logger=(Logger)Logger.getLogger(OilGreasePurchaseService.class);
	OilGreasePurchaseDAO dao=new OilGreasePurchaseDAO();
	ArrayList list=new ArrayList();
	public ArrayList fetchCompanyName()
	{ 
		
		ArrayList instlist=dao.fetchCompanyName();
		return instlist;
	}
	public ArrayList fetchItemDes()
	{ 
		
		ArrayList instlist=dao.fetchItemDes();
		return instlist;
	}
	
	
	public ArrayList fetchBrandName(int jobid)
	{ 
		
		ArrayList instlist=dao.fetchBrandName(jobid);
		return instlist;
	}
	public ArrayList fetchBrandType(int jobid)
	{ 
		
		ArrayList instlist=dao.fetchBrandType(jobid);
		return instlist;
	}
	public void insertcommontrans(String itemreq,String brandcategory, float unitrate,int quantity)
	{ 
		 dao.insertcommontrans(itemreq,brandcategory,unitrate,quantity);
		
	}
	public ArrayList retrieve(int jobid)
	{
		logger.debug("retrieve :OilGreasePurchaseService <<<<<<<<<<<<<<< ");
		OilGreasePurchaseDAO dao=new OilGreasePurchaseDAO();
		list=dao.retrieve(jobid);
		logger.debug("retrieve :OilGreasePurchaseService >>>>>>>>>>>>>>> ");
		return list;
	}
	public String fetchpartno(String item)
	{ 
		
		String partno=dao.fetchpartno(item);
		return partno;
	}
	
	public String getItemName(String item1)
	{ 
		
		String item=dao.getItemName(item1);
		return item;
	}
	
	public ArrayList fetchplacelist(String cname)
	{ 
		
		ArrayList instlist=dao.fetchplacelist(cname);
		return instlist;
	}
	public String getPurchaseItem(int jobid)
	{
		logger.debug("getPurchaseItem :OilGreasePurchaseService <<<<<<<<<<<<<<< ");
		
		String reqitem=dao.getPurchaseItem(jobid);
	
		logger.debug("getPurchaseItem :OilGreasePurchaseService >>>>>>>>>>>>>>> ");
		return reqitem;
	}
	public ArrayList fetchAvailableQty(String brandname,String brandtype)
	{ 
		
		ArrayList instlist=dao.fetchAvailbaleQty(brandname,brandtype);
		return instlist;
	}
	public void insertSupplier(int jobid,String date,String billno,String delivereddate,String cname,String place,String reqitem)
	{
		
		dao.insertSupplier(jobid,date,billno,delivereddate,cname,place,reqitem);
	}
	public void insertProduct(int jobid,String brandname,String brandcategory,int availability)
	{
		
		dao.insertProduct(jobid,brandname,brandcategory,availability);
	}
	public void insertVat(int jobid,String brandname,String brandcategory,String partno,int quantity,float unitprice,float vatpercent,float vatamount,float additionalamount,float amount)
	{
		dao.insertVat(jobid,brandname,brandcategory,partno,quantity,unitprice,vatpercent,vatamount,additionalamount,amount);
	}
	
}
