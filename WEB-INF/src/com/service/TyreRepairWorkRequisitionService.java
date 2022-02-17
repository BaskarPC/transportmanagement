package com.service;

import org.apache.log4j.Logger;
import java.util.*;


import com.dao.TyreRepairWorkRequisitionDAO;
import com.vo.TyreRepairWorkRequisitionVO;
import com.util.TyreRepairWorkRequisitionUtil;

public class TyreRepairWorkRequisitionService {
	private static final Logger logger=(Logger)Logger.getLogger(TyreRepairWorkRequisitionService.class);
	TyreRepairWorkRequisitionDAO tyrerepairworkrequisitiondao=new TyreRepairWorkRequisitionDAO();
	TyreRepairWorkRequisitionUtil tyrerepairworkrequisitionutil=new TyreRepairWorkRequisitionUtil();
   
	public ArrayList tyreSizeCombo()
	{   
		ArrayList tyreSizeList=new ArrayList();
		try
		{
		String query=tyrerepairworkrequisitionutil.tyreSizeQuery();	
		tyreSizeList=tyrerepairworkrequisitiondao.fetchTyreSize(query);
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
		
		String query=tyrerepairworkrequisitionutil.tyreBrandQuery();
		tyreBrandList=tyrerepairworkrequisitiondao.fetchTyreBrand(query);

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
		String query=tyrerepairworkrequisitionutil.tyrePlyQuery();
		tyrePlyList=tyrerepairworkrequisitiondao.fetchTyrePly(query);
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
		String query=tyrerepairworkrequisitionutil.retrieveTyreDetailsQuery(tyreNumber);
		tyreDetailsList=tyrerepairworkrequisitiondao.fetchTyreDetails(query);
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
		String query=tyrerepairworkrequisitionutil.tyreNumberQuery(tyreSize,tyrePly,tyreBrand);
		tyreNumberList=tyrerepairworkrequisitiondao.fetchTyreNumber(query);
		}
		catch(Exception e)
		{
		logger.debug("Exception "+e);
		}
		return tyreNumberList;
	}
	
	 public void insertCommontyretransaction(int job_id,TyreRepairWorkRequisitionVO tyrerepairworkrequisitionvo)
	   {   
		    
			try
			{
			String query=tyrerepairworkrequisitionutil.insertQuery1(job_id,tyrerepairworkrequisitionvo);
			tyrerepairworkrequisitiondao.insertValues1(query);
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
			String query=tyrerepairworkrequisitionutil.insertQuery2(job_id,tyreNumber,rebuilt_repair,reason);
			tyrerepairworkrequisitiondao.insertValues2(query);
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
		String query=tyrerepairworkrequisitionutil.retrievedetailsQuery(job);		
		tyredetailslist=tyrerepairworkrequisitiondao.retrievetyredetails(query);
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
		String query=tyrerepairworkrequisitionutil.retrievecommondetailsQuery(job);		
		commondetailslist=tyrerepairworkrequisitiondao.retrievecommontyredetails(query);
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
			String query=tyrerepairworkrequisitionutil.tyreBrandDescQuery(tyreBrandCode);
			tyreBrandList=tyrerepairworkrequisitiondao.tyreBrandDesc(query);
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
			String query=tyrerepairworkrequisitionutil.tyreSizeDescQuery(tyreSizeCode);
			tyreSizeList=tyrerepairworkrequisitiondao.tyreSizeDesc(query);
		}
		catch(Exception e)
		{
			logger.debug("Exception "+e);	
		}
		return tyreSizeList;
	}
}
