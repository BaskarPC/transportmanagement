package com.service;

import java.io.File;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.apache.struts.upload.FormFile;

import com.dao.DieselRequisitionDAO;
import com.dao.UploadDocDAO;

public class UploadDocService {
	UploadDocDAO dao=new UploadDocDAO();
	ArrayList list=new ArrayList();
	private static final Logger logger=(Logger)Logger.getLogger(UploadDocService.class);
	public File retrieveFile(String strDocId, String strFilePath, String strFileName)
	{
	logger.info(" retrieveFile  ----->>");

	File fObj = null;
	fObj = dao.retrieveFile(strDocId,strFilePath,strFileName);
	logger.info(" retrieveFile  <<-----");
	return fObj;
}
	public void editMethod(FormFile f,String id)
	{
		logger.debug("editMethod :DieselRequisitionService <<<<<<<<<<<<<<< ");
		dao.editMethod(f,id);
		logger.debug("editMethod :DieselRequisitionService >>>>>>>>>>>>>>> ");
		
	}
	public ArrayList getImageList()
	{
		logger.debug("getimagelist :DieselRequisitionService <<<<<<<<<<<<<<< ");
		list=dao.getImageList();
		logger.debug("getimagelist :DieselRequisitionService >>>>>>>>>>>>>>> ");
		return list;
	}
	public int UploadFile(FormFile f,int jobid,int taskid)	throws Exception {
	logger.info("UploadFile ------>>");
	int update = 0;
	dao.UploadFile(f,jobid,taskid);

	logger.info(" UploadFile <<--------");
	return update;
}
	public String fetchFilename(String strIndexDocID)
	{
		logger.debug("getimagelist :DieselRequisitionService <<<<<<<<<<<<<<< ");
	
		String name=dao.fetchFilename(strIndexDocID);
		logger.debug("getimagelist :DieselRequisitionService >>>>>>>>>>>>>>> ");
		return name;
	}
	public void deleteImage(String imagename)
	{
		logger.debug("deleteImage :DieselRequisitionService <<<<<<<<<<<<<<< ");
	
		dao.deleteImage(imagename);
		logger.debug("deleteImage :DieselRequisitionService >>>>>>>>>>>>>>> ");
		
	}
}
