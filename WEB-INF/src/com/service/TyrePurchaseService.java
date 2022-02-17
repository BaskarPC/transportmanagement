package com.service;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.dao.TyrePurchaseDAO;

public class TyrePurchaseService {
	private static final Logger logger=(Logger)Logger.getLogger(TyrePurchaseService.class);
	TyrePurchaseDAO dao=new TyrePurchaseDAO();
	ArrayList list=new ArrayList();
	
	public ArrayList getCompanyNameList()
	{ 
		logger.debug("TyrePurchaseService:getCompanyNameList <<<<<<<<<<<<<<< ");
		list=dao.getCompanyNameList();
		logger.debug("TyrePurchaseService:getCompanyNameList >>>>>>>>>>>>>>> ");
		return list;
	}
	public ArrayList fetchplacelist(String cname)
	{ 
		list=dao.fetchplacelist(cname);
		return list;
	}
	public String fetchpartno(String item)
	{ 
		String partno=dao.fetchpartno(item);
		return partno;
	}
	public ArrayList getTyreBrandList(int jobid)
	{ 
		list=dao.getTyreBrandList(jobid);
		return list;
	}
	public ArrayList getTyreSizeList(int jobid)
	{ 
		
		list=dao.getTyreSizeList(jobid);
		return list;
	}
	public ArrayList getTyrePlyList(int jobid)
	{ 
		
		list=dao.getTyrePlyList(jobid);
		return list;
	}
	public ArrayList getTyrePartsList(int jobid)
	{ 
		
		list=dao.getTyrePartsList(jobid);
		return list;
	}
	public void insertSupplier(int jobid,String date,String billno,String delivereddate,String cname,String place,String reqitem)
	{
		dao.insertSupplier(jobid,date,billno,delivereddate,cname,place,reqitem);
	}
	public void insertProduct(int jobid,int tyrebrand,int tyresize,int tyreply,String tyreparts,String tyreno,float unitprice,float vatpercent,float vatamount,float additionalamount,float amount)
	{
		logger.debug("TyrePurchaseService:insertProduct <<<<<<<<<<<<<<< ");
		dao.insertProduct(jobid,tyrebrand,tyresize,tyreply,tyreparts,tyreno,unitprice,vatpercent,vatamount,additionalamount,amount);
		logger.debug("TyrePurchaseService:insertProduct >>>>>>>>>>>>>>> ");
	}
	public void insertcommontrans(int tyrebrand,int tyresize,int tyreply,String tyreno)
	{
		dao.insertcommontrans(tyrebrand,tyresize,tyreply,tyreno);
	}
}
