package com.service;

import org.apache.log4j.Logger;
import java.util.*;

import com.dao.TyreRebuiltDAO;
import com.dao.TyreRebuiltRequisitionDAO;
import com.util.GeneralLookupUtil;
import com.vo.TyreRebuiltRequisitionVO;
import com.vo.TyreRebuiltVO;
import com.util.TyreRebuiltUtil;

public class TyreRebuiltService {
	private static final Logger logger=(Logger)Logger.getLogger(TyreRebuiltService.class);
	TyreRebuiltDAO tyrerebuiltdao=new TyreRebuiltDAO();
	TyreRebuiltUtil tyrerebuiltutil=new TyreRebuiltUtil();
	TyreRebuiltVO tyrerebuiltvo=new TyreRebuiltVO();
    GeneralLookupUtil generallookuputil=new GeneralLookupUtil();
	/*public ArrayList tyreSizeCombo()
	{   
		ArrayList tyreSizeList=new ArrayList();
		try
		{
		
		String query=tyrerebuiltutil.tyreSizeQuery();	
		tyreSizeList=tyrerebuiltdao.fetchTyreSize(query);
		}
		catch(Exception e)
		{
		logger.debug("Exception "+e);
		}
		return tyreSizeList;
	}
	
	public ArrayList tyreBrandCombo()
	{   
		ArrayList tyreBrandList=new ArrayList();
		try
		{
		
		String query=tyrerebuiltutil.tyreBrandQuery();
		TyreRebuiltDAO tyrerebuiltdao=new TyreRebuiltDAO();
		tyreBrandList=tyrerebuiltdao.fetchTyreBrand(query);

		}
		catch(Exception e)
		{
		logger.debug("Exception "+e);
		}
		return tyreBrandList;
	}
	
	public ArrayList tyrePlyCombo()
	{   
		ArrayList tyrePlyList=new ArrayList();
		try
		{
		String query=tyrerebuiltutil.tyrePlyQuery();
		TyreRebuiltDAO tyrerebuiltdao=new TyreRebuiltDAO();
		tyrePlyList=tyrerebuiltdao.fetchTyrePly(query);
		}
		catch(Exception e)
		{
		logger.debug("Exception "+e);
		}
		return tyrePlyList;
	}*/

	public ArrayList retrieveTyreDetails(String tyreNumber)
	{   
		ArrayList tyreDetailsList=new ArrayList();
		try
		{
		String query=tyrerebuiltutil.retrieveTyreDetailsQuery(tyreNumber);
		tyreDetailsList=tyrerebuiltdao.fetchTyreDetails(query);
		}
		catch(Exception e)
		{
		logger.debug("Exception "+e);
		}
		logger.debug("list size in Service:"+tyreDetailsList.size());
		return tyreDetailsList;
	}
	
	public ArrayList tyreNumberCombo()
	{   
		ArrayList tyreNumberList=new ArrayList();
		try
		{
		String query=tyrerebuiltutil.tyreNumberQuery();
		tyreNumberList=tyrerebuiltdao.fetchTyreNumber(query);
		}
		catch(Exception e)
		{
		logger.debug("Exception "+e);
		}
		return tyreNumberList;
	}
	
	public void insertCommontyretransaction(int job_id,TyreRebuiltVO tyrerebuiltvo)
	   {   
		    logger.debug("inside Service: ");
		    logger.debug("jobid"+job_id);
			try
			{
			String query=tyrerebuiltutil.insertQuery1(job_id,tyrerebuiltvo);
			tyrerebuiltdao.insertValues1(query);
			}
			catch(Exception e)
			{
			logger.debug("Exception "+e);
			}
		}
	 public void insertTyretransaction(int job_id,String tyreNumber,String rebuilt_repair,String reason)
	   {   
		   try
			{
			String query=tyrerebuiltutil.insertQuery2(job_id,tyreNumber,rebuilt_repair,reason);
			tyrerebuiltdao.insertValues2(query);
			}
			catch(Exception e)
			{
			logger.debug("Exception "+e);
			}
		}
	 
		
		public ArrayList tyreBrandDesc(int tyreBrandCode)
		{
			ArrayList tyreBrandList=new ArrayList();
			try
			{
				String query=tyrerebuiltutil.tyreBrandDescQuery(tyreBrandCode);
				tyreBrandList=tyrerebuiltdao.tyreBrandDesc(query);
			}
			catch(Exception e)
			{
				logger.debug("Exception "+e);	
			}
			return tyreBrandList;
		}
		public ArrayList tyreSizeDesc(int tyreSizeCode)
		{
			ArrayList tyreSizeList=new ArrayList();
			try
			{
				String query=tyrerebuiltutil.tyreSizeDescQuery(tyreSizeCode);
				tyreSizeList=tyrerebuiltdao.tyreSizeDesc(query);
			}
			catch(Exception e)
			{
				logger.debug("Exception "+e);	
			}
			return tyreSizeList;
		}
	public ArrayList retrievetyredetails(int job) {
		// TODO Auto-generated method stub
		ArrayList tyredetailslist=new ArrayList();
		try
		{
		String query=tyrerebuiltutil.retrievedetailsQuery(job);		
		tyredetailslist=tyrerebuiltdao.retrievetyredetails(query);
		}
		catch(Exception e)
		{
		logger.debug("Exception "+e);
		}
		return tyredetailslist;
	}

	public ArrayList tyredetailscode(String tyreNumber)
	{
		ArrayList tyredetailslist=new ArrayList();
		try
		{
			String query=tyrerebuiltutil.tyredetailscodequery(tyreNumber);
			tyredetailslist=tyrerebuiltdao.tyredetailscode(query);
		}
		catch(Exception e)
		{
			logger.debug("Exception : "+e);
		}
		return tyredetailslist;
	}
	public ArrayList retrievecommondetails(int job) {
		// TODO Auto-generated method stub
		ArrayList commondetailslist=new ArrayList();
		try
		{
		String query=tyrerebuiltutil.retrievecommondetailsQuery(job);		
		commondetailslist=tyrerebuiltdao.retrievecommontyredetails(query);
		}
		catch(Exception e)
		{
		logger.debug("Exception "+e);
		}
		return commondetailslist;
	}
	public void updateIndicator(String tyreNumber)
	   {   
		   try
			{
			String query=tyrerebuiltutil.updateIndicatorQuery(tyreNumber);
			tyrerebuiltdao.updateIndicator(query);
			}
			catch(Exception e)
			{
			logger.debug("Exception "+e);
			}
		}
	public void updateTyreMaster(String tyreNumber,String tyreStatus)
	   {   
		   try
			{
			String query=tyrerebuiltutil.updateTyreMaster(tyreNumber, tyreStatus);
			tyrerebuiltdao.updateTyreMaster(query);
			}
			catch(Exception e)
			{
			logger.debug("Exception "+e);
			}
		}
	
	

}
