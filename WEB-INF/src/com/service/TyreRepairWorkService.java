package com.service;
import org.apache.log4j.Logger;
import java.util.*;
import com.dao.TyreRepairWorkDAO;
import com.util.GeneralLookupUtil;
import com.vo.TyreRepairWorkVO;
import com.util.TyreRepairWorkUtil;

public class TyreRepairWorkService {
	private static final Logger logger=(Logger)Logger.getLogger(TyreRepairWorkService.class);
	TyreRepairWorkDAO tyrerepairworkdao=new TyreRepairWorkDAO();
	TyreRepairWorkUtil tyrerepairworkutil=new TyreRepairWorkUtil();
	TyreRepairWorkVO tyrerepairworkvo=new TyreRepairWorkVO();
    GeneralLookupUtil generallookuputil=new GeneralLookupUtil();
	

	public ArrayList retrieveTyreDetails(String tyreNumber)
	{   
		ArrayList tyreDetailsList=new ArrayList();
		try
		{
		String query=tyrerepairworkutil.retrieveTyreDetailsQuery(tyreNumber);
		tyreDetailsList=tyrerepairworkdao.fetchTyreDetails(query);
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
		String query=tyrerepairworkutil.tyreNumberQuery();
		tyreNumberList=tyrerepairworkdao.fetchTyreNumber(query);
		}
		catch(Exception e)
		{
		logger.debug("Exception "+e);
		}
		return tyreNumberList;
	}
	
	public void insertCommontyretransaction(int job_id,TyreRepairWorkVO tyrerepairworkvo)
	   {   
		    logger.debug("inside Service: ");
		    logger.debug("jobid"+job_id);
			try
			{
			String query=tyrerepairworkutil.insertQuery1(job_id,tyrerepairworkvo);
			tyrerepairworkdao.insertValues1(query);
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
			String query=tyrerepairworkutil.insertQuery2(job_id,tyreNumber,rebuilt_repair,reason);
			tyrerepairworkdao.insertValues2(query);
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
				String query=tyrerepairworkutil.tyreBrandDescQuery(tyreBrandCode);
				tyreBrandList=tyrerepairworkdao.tyreBrandDesc(query);
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
				String query=tyrerepairworkutil.tyreSizeDescQuery(tyreSizeCode);
				tyreSizeList=tyrerepairworkdao.tyreSizeDesc(query);
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
		String query=tyrerepairworkutil.retrievedetailsQuery(job);		
		tyredetailslist=tyrerepairworkdao.retrievetyredetails(query);
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
			String query=tyrerepairworkutil.tyredetailscodequery(tyreNumber);
			tyredetailslist=tyrerepairworkdao.tyredetailscode(query);
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
		logger.debug("Inside   ssssssssssservice");	
		String query=tyrerepairworkutil.retrievecommondetailsQuery(job);		
		commondetailslist=tyrerepairworkdao.retrievecommontyredetails(query);
		logger.debug("list size : "+commondetailslist.size());
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
			String query=tyrerepairworkutil.updateIndicatorQuery(tyreNumber);
			tyrerepairworkdao.updateIndicator(query);
			}
			catch(Exception e)
			{
			logger.debug("Exception "+e);
			}
		}
}
