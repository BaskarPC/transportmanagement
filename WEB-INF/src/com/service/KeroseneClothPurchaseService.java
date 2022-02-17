package com.service;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.dao.KeroseneClothPurchaseDAO;
import com.dao.OilGreasePurchaseDAO;

public class KeroseneClothPurchaseService {
	private static final Logger logger=(Logger)Logger.getLogger(KeroseneClothPurchaseService.class);
	KeroseneClothPurchaseDAO dao=new KeroseneClothPurchaseDAO();
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
	public String fetchPartNumber(String item)
	{ 
		String pno=dao.fetchPartNumber(item);
		return pno;
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
		logger.debug("getPurchaseItem:reqitem"+reqitem);
		logger.debug("getPurchaseItem :OilGreasePurchaseService >>>>>>>>>>>>>>> ");
		return reqitem;
	}
	public void insertSupplier(int sid,int jobid,String date,String billno,String delivereddate,String cname,String place,String reqitem)
	{
		dao.insertSupplier(sid,jobid,date,billno,delivereddate,cname,place,reqitem);
	}
	public void insertProduct(int sid,int jobid,int qtypurchased,float rate,float amt)
	{
		dao.insertProduct(sid,jobid,qtypurchased,rate,amt);
	}
	
	public void insertcommontrans(String item, float unitprice,int quantity)
	{
		dao.insertcommontrans(item, unitprice,quantity);
	}
	public int getSid()
	{
		int sid=dao.getsid();
		return sid;
	}
}
