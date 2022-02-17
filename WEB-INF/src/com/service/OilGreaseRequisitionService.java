package com.service;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import com.dao.OilGreaseRequisitionDAO;

public class OilGreaseRequisitionService {
	private static final Logger logger=(Logger)Logger.getLogger(OilGreaseRequisitionService.class);
	ArrayList list;
	OilGreaseRequisitionDAO dao=new OilGreaseRequisitionDAO();
	public ArrayList fetchRequiredItem()
	{ 
		logger.debug("fetchRequiredItem :OilGreaseRequisitionService <<<<<<<<<<<<<<< ");
		ArrayList instlist=dao.fetchRequiredItem();
		logger.debug("fetchRequiredItem :OilGreaseRequisitionService >>>>>>>>>>>>>>> ");
		return instlist;
	}
	
	public ArrayList fetchBrandName(String item)
	{ 
		logger.debug("fetchBrandName :OilGreaseRequisitionService <<<<<<<<<<<<<<< ");
		ArrayList instlist=dao.fetchBrandName(item);
		logger.debug("fetchBrandName :OilGreaseRequisitionService >>>>>>>>>>>>>>> ");
		return instlist;
	}
	public ArrayList fetchAvailableQty(String brandname,String brandtype)
	{ 
		logger.debug("fetchAvailableQty :OilGreaseRequisitionService <<<<<<<<<<<<<<< ");
		ArrayList instlist=dao.fetchAvailbaleQty(brandname,brandtype);
		logger.debug("fetchAvailableQty :OilGreaseRequisitionService >>>>>>>>>>>>>>> ");
		return instlist;
	}
	public ArrayList fetchApproveStatusList()
	{ 
		logger.debug("fetchApproveStatusList :OilGreaseRequisitionService <<<<<<<<<<<<<<< ");
		ArrayList instlist=dao.fetchApproveStatusList();
		logger.debug("fetchApproveStatusList :OilGreaseRequisitionService >>>>>>>>>>>>>>> ");
		return instlist;
	}
	
	public ArrayList fetchBrandType(String item)
	{ 
		logger.debug("fetchBrandType :OilGreaseRequisitionService <<<<<<<<<<<<<<< ");
		ArrayList instlist=dao.fetchBrandType(item);
		logger.debug("fetchBrandType :OilGreaseRequisitionService >>>>>>>>>>>>>>> ");
		return instlist;
	}
	public void insert(int jobid,String date,String name,int reqitem,int brandname,int brandcategory,int availability,int neededqty)
	{ 
		logger.debug("insert :OilGreaseRequisitionService <<<<<<<<<<<<<<< ");
		dao.insert(jobid,date,name,reqitem,brandname,brandcategory,availability,neededqty);
		logger.debug("insert :OilGreaseRequisitionService >>>>>>>>>>>>>>> ");
	}
	public ArrayList retrieve(int jobid)
	{
		logger.debug("retrieve :OilGreaseRequisitionService <<<<<<<<<<<<<<< ");
		list=dao.retrieve(jobid);
		logger.debug("retrieve :OilGreaseRequisitionService >>>>>>>>>>>>>>> ");
		return list;
	}
	public ArrayList getitem(String name)
	{
		logger.debug("getitem :OilGreaseRequisitionService <<<<<<<<<<<<<<< ");
		
		list=dao.getitem(name);
		logger.debug("getitem :OilGreaseRequisitionService >>>>>>>>>>>>>>> ");
		return list;
	}
	public void insertcommontrans(String item, String brandcategory)
	{ 
		logger.debug("insertcommontrans :OilGreaseRequisitionService <<<<<<<<<<<<<<< ");
		dao.insertcommontrans(item,brandcategory);
		logger.debug("insertcommontrans :OilGreaseRequisitionService >>>>>>>>>>>>>>> ");
	}
	public int insertlookup(int reqitem,String brandname,String brandcategory)
	{
		logger.debug("insertlookup :OilGreaseRequisitionService <<<<<<<<<<<<<<< ");
		int id=dao.insertlookup(reqitem,brandname,brandcategory);
		logger.debug("insertlookup :OilGreaseRequisitionService >>>>>>>>>>>>>>> ");
		return id;
	}
	public void status(int job,String bname,String btype,String appstatus)
	{ 
		logger.debug("status :OilGreaseRequisitionService <<<<<<<<<<<<<<< ");
		dao.status(job,bname,btype,appstatus);
		logger.debug("status :OilGreaseRequisitionService >>>>>>>>>>>>>>> ");
	}
}
