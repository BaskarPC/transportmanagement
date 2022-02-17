package com.service;

import java.util.ArrayList;
import java.io.File;
import org.apache.log4j.Logger;
import org.apache.struts.upload.FormFile;


import com.dao.DieselRequisitionDAO;

import com.vo.DieselRequisitionVO;

public class DieselRequisitionService {
	private static final Logger logger=(Logger)Logger.getLogger(DieselRequisitionService.class);
	ArrayList list=null;
	DieselRequisitionDAO dao=new DieselRequisitionDAO();
	public void insert(DieselRequisitionVO vo)
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
	
	

//	public File retrieveFile(String docId, String filePath, String fileName)
	//{
	//logger.debug("DieselRequisitionService: retrieveFile---->");
	//UploadDocService uploadDocService = new UploadDocService();
	//File file = uploadDocService.retrieveFile(docId,filePath,fileName);		
	//logger.debug("DieselRequisitionService: retrieveFile<------");
	//return file;
//}

	public String getRole(String userName)
	{
		logger.debug("getRole :DieselRequisitionService <<<<<<<<<<<<<<< ");
	
		String role=dao.getRole(userName);
		logger.debug("getRole :DieselRequisitionService >>>>>>>>>>>>>>> ");
		return role;
	}
	
	
	
	public ArrayList getPetrolCompany()
	{

		logger.debug("retrieve :DieselRequisitionService <<<<<<<<<<<<<<< ");
		
		list=dao.getPetrolCompany();
		logger.debug("retrieve :DieselRequisitionService >>>>>>>>>>>>>>> ");
		return list;
	}
	public ArrayList getBankList()
	{

		logger.debug("getBankList :DieselRequisitionService <<<<<<<<<<<<<<< ");
		
		list=dao.getBankList();
		logger.debug("getBankList :DieselRequisitionService >>>>>>>>>>>>>>> ");
		return list;
	}
	public String getRequiredLiters(int job)
	{
		logger.debug("getRequiredLiters :DieselRequisitionService <<<<<<<<<<<<<<< ");
		String qty=dao.getRequiredLiters(job);
		logger.debug("getRequiredLiters :DieselRequisitionService >>>>>>>>>>>>>>> ");
		return qty;
	}
	public String getCurrentCapacity()
	{
		logger.debug("getCurrentCapacity :DieselRequisitionService <<<<<<<<<<<<<<< ");
		
		String capacity=dao.getCurrentCapacity();
		logger.debug("getCurrentCapacity :DieselRequisitionService >>>>>>>>>>>>>>> ");
		return capacity;
	}
	

}
