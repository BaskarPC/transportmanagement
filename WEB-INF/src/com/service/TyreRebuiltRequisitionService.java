package com.service;

import org.apache.log4j.Logger;
import java.util.*;


import com.dao.TyreRebuiltRequisitionDAO;
import com.vo.TyreRebuiltRequisitionVO;
import com.util.TyreRebuiltRequisitionUtil;

public class TyreRebuiltRequisitionService {
	private static final Logger logger=(Logger)Logger.getLogger(TyreRebuiltRequisitionService.class);
	TyreRebuiltRequisitionDAO tyrerebuiltrequisitiondao=new TyreRebuiltRequisitionDAO();
	TyreRebuiltRequisitionUtil tyrerebuiltrequisitionutil=new TyreRebuiltRequisitionUtil();
   
	public ArrayList tyreSizeCombo()
	{   
		ArrayList tyreSizeList=new ArrayList();
		try
		{
		String query=tyrerebuiltrequisitionutil.tyreSizeQuery();	
		tyreSizeList=tyrerebuiltrequisitiondao.fetchTyreSize(query);
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
		
		String query=tyrerebuiltrequisitionutil.tyreBrandQuery();
		tyreBrandList=tyrerebuiltrequisitiondao.fetchTyreBrand(query);

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
		String query=tyrerebuiltrequisitionutil.tyrePlyQuery();
		tyrePlyList=tyrerebuiltrequisitiondao.fetchTyrePly(query);
		}
		catch(Exception e)
		{
		logger.debug("Exception "+e);
		}
		return tyrePlyList;
	}

	public ArrayList retrieveTyreDetails(String tyreNumber)
	{   
		ArrayList tyreDetailsList=new ArrayList();
		try
		{
		String query=tyrerebuiltrequisitionutil.retrieveTyreDetailsQuery(tyreNumber);
		tyreDetailsList=tyrerebuiltrequisitiondao.fetchTyreDetails(query);
		}
		catch(Exception e)
		{
		logger.debug("Exception "+e);
		}
		logger.debug("list size in Service:"+tyreDetailsList.size());
		return tyreDetailsList;
	}
	
	public ArrayList tyreNumberCombo(int tyreSize,int tyrePly,int tyreBrand)
	{   
		ArrayList tyreNumberList=new ArrayList();
		try
		{
		String query=tyrerebuiltrequisitionutil.tyreNumberQuery(tyreSize,tyrePly,tyreBrand);
		tyreNumberList=tyrerebuiltrequisitiondao.fetchTyreNumber(query);
		}
		catch(Exception e)
		{
		logger.debug("Exception "+e);
		}
		return tyreNumberList;
	}
	
	 public void insertCommontyretransaction(int job_id,TyreRebuiltRequisitionVO tyrerebuiltrequisitionvo)
	   {   
		    
			try
			{
			logger.debug("job_id : "+job_id);
			String query=tyrerebuiltrequisitionutil.insertQuery1(job_id,tyrerebuiltrequisitionvo);
			tyrerebuiltrequisitiondao.insertValues1(query);
			logger.debug("insert common_tyretransaction : ");
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
			String query=tyrerebuiltrequisitionutil.insertQuery2(job_id,tyreNumber,rebuilt_repair,reason);
			tyrerebuiltrequisitiondao.insertValues2(query);
			logger.debug("insert tyretransaction : ");
			}
			catch(Exception e)
			{
			logger.debug("Exception "+e);
			}
		}

	public ArrayList retrievetyredetails(int job) {
		// TODO Auto-generated method stub
		ArrayList tyredetailslist=new ArrayList();
		try
		{
		String query=tyrerebuiltrequisitionutil.retrievedetailsQuery(job);		
		tyredetailslist=tyrerebuiltrequisitiondao.retrievetyredetails(query);
		}
		catch(Exception e)
		{
		logger.debug("Exception "+e);
		}
		return tyredetailslist;
	}

	public ArrayList retrievecommondetails(int job) {
		// TODO Auto-generated method stub
		ArrayList commondetailslist=new ArrayList();
		try
		{
		String query=tyrerebuiltrequisitionutil.retrievecommondetailsQuery(job);		
		commondetailslist=tyrerebuiltrequisitiondao.retrievecommontyredetails(query);
		}
		catch(Exception e)
		{
		logger.debug("Exception "+e);
		}
		return commondetailslist;
	}
	
	public ArrayList tyreBrandDesc(int tyreBrandCode)
	{
		ArrayList tyreBrandList=new ArrayList();
		try
		{
			String query=tyrerebuiltrequisitionutil.tyreBrandDescQuery(tyreBrandCode);
			tyreBrandList=tyrerebuiltrequisitiondao.tyreBrandDesc(query);
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
			String query=tyrerebuiltrequisitionutil.tyreSizeDescQuery(tyreSizeCode);
			tyreSizeList=tyrerebuiltrequisitiondao.tyreSizeDesc(query);
		}
		catch(Exception e)
		{
			logger.debug("Exception "+e);	
		}
		return tyreSizeList;
	}
}
