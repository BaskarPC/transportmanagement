package com.service;
import java.util.ArrayList;
import org.apache.log4j.Logger;

import com.dao.TyreRequisitionDAO;
public class TyreRequisitionService {
	private static final Logger logger=(Logger)Logger.getLogger(TyreRequisitionService.class);
	ArrayList list;
	TyreRequisitionDAO dao=new TyreRequisitionDAO();
	
	public ArrayList getTyreBrandList()
	{ 
		logger.debug("getTyreBrandList :TyreRequisitionService <<<<<<<<<<<<<<< ");
		ArrayList instlist=dao.getTyreBrandList();
		logger.debug("getTyreBrandList :TyreRequisitionService >>>>>>>>>>>>>>> ");
		return instlist;
	}
	public ArrayList getTyreSizeList()
	{ 
		logger.debug("getTyreBrandList :TyreRequisitionService <<<<<<<<<<<<<<< ");
		ArrayList instlist=dao.getTyreSizeList();
		logger.debug("getTyreBrandList :TyreRequisitionService >>>>>>>>>>>>>>> ");
		return instlist;
	}
	public ArrayList getTyrePlyList()
	{ 
		logger.debug("getTyreBrandList :TyreRequisitionService <<<<<<<<<<<<<<< ");
		ArrayList instlist=dao.getTyrePlyList();
		logger.debug("getTyreBrandList :TyreRequisitionService >>>>>>>>>>>>>>> ");
		return instlist;
	}
	public ArrayList getTyrePartsList()
	{ 
		logger.debug("getTyrePartsList :TyreRequisitionService <<<<<<<<<<<<<<< ");
		ArrayList instlist=dao.getTyrePartsList();
		logger.debug("getTyrePartsList :TyreRequisitionService >>>>>>>>>>>>>>> ");
		return instlist;
	}
	public void insert(int jobid, String date,String name,String vehicleno,int brandname,int size,int ply,String tyreparts,int availability,int neededqty)
	{ 
		logger.debug("insert :TyreRequisitionService <<<<<<<<<<<<<<< ");
		dao.insert(jobid,date,name,vehicleno,brandname,size,ply,tyreparts,availability,neededqty);
		logger.debug("insert :TyreRequisitionService >>>>>>>>>>>>>>> ");
	}
	public int insertlookup(String name,String ctype)
	{ 
		logger.debug("insert :TyreRequisitionService <<<<<<<<<<<<<<< ");
		int code=dao.insertlookup(name,ctype);
		logger.debug("insert :TyreRequisitionService >>>>>>>>>>>>>>> ");
		return code;
	}
	public int getavailability(int brandname,int size,int ply)
	{ 
		logger.debug("getavailability :TyreRequisitionService <<<<<<<<<<<<<<< ");
		int available=dao.getavailability(brandname,size,ply);
		logger.debug("getavailability :TyreRequisitionService >>>>>>>>>>>>>>> ");
		return available;
	}
	public ArrayList retrieve(int jobid)
	{
		logger.debug("retrieve :TyreRequisitionService <<<<<<<<<<<<<<< ");
		list=dao.retrieve(jobid);
		logger.debug("retrieve :TyreRequisitionService >>>>>>>>>>>>>>> ");
		return list;
	}
	public ArrayList fetchApproveStatusList()
	{ 
		logger.debug("fetchApproveStatusList :TyreRequisitionService <<<<<<<<<<<<<<< ");
		ArrayList instlist=dao.fetchApproveStatusList();
		logger.debug("fetchApproveStatusList :TyreRequisitionService >>>>>>>>>>>>>>> ");
		return instlist;
	}
	public void status(int job,String tyrebrand,String tyresize,String tyreply,String appstatus)
	{ 
		logger.debug("status :OilGreaseRequisitionService <<<<<<<<<<<<<<< ");
		dao.status(job,tyrebrand,tyresize,tyreply,appstatus);
		logger.debug("status :OilGreaseRequisitionService >>>>>>>>>>>>>>> ");
	}

}
