package com.service;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.dao.KeroseneClothRequisitionDAO;
import com.vo.DieselRequisitionVO;
import com.vo.KeroseneClothRequisitionVO;



public class KeroseneClothRequisitionService {
	private static final Logger logger=(Logger)Logger.getLogger(KeroseneClothRequisitionService.class);
	ArrayList list=null;
	KeroseneClothRequisitionDAO dao=new KeroseneClothRequisitionDAO();
	public ArrayList itemList()
	{
		logger.debug("itemList:KeroseneClothRequisitionService <<<<<------------");
		list=dao.itemList();
		logger.debug("itemList:KeroseneClothRequisitionService ------------>>>>");
		return list;
		
	}
	public String fetchAvailableQty(int code)
	{ 
		logger.debug("fetchAvailableQty:KeroseneClothRequisitionService <<<<<------------");
		String qty=dao.fetchAvailbaleQty(code);
		logger.debug("fetchAvailableQty:KeroseneClothRequisitionService ------------>>>>>");
		return qty;
	}
	public String getRole(String userName)
	{
		logger.debug("getRole :DieselRequisitionService <<<<<<<<<<<<<<< ");
	
		String role=dao.getRole(userName);
		logger.debug("getRole :DieselRequisitionService >>>>>>>>>>>>>>> ");
		return role;
	}
	public void insert(KeroseneClothRequisitionVO vo)
	{
		logger.debug("insert :DieselRequisitionService <<<<<<<<<<<<<<< ");
		
		dao.insert(vo);
		logger.debug("insert :DieselRequisitionService >>>>>>>>>>>>>>> ");
		
	}
	public ArrayList retrieve(int jobid)
	{
		logger.debug("retrieve :DieselRequisitionService <<<<<<<<<<<<<<< ");
	
		list=dao.retrieve(jobid);
		logger.debug("retrieve :DieselRequisitionService >>>>>>>>>>>>>>> ");
		return list;
	}
	

}
