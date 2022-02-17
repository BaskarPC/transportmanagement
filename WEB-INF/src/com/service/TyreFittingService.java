package com.service;

import org.apache.log4j.Logger;
import java.util.*;

import com.action.TyreFittingAction;
import com.dao.TyreFittingDAO;
import com.util.GeneralLookupUtil;
import com.vo.TyreFittingVO;
import com.util.TyreFittingUtil;
public class TyreFittingService {
	private static final Logger logger=(Logger)Logger.getLogger(TyreFittingService.class);
       TyreFittingDAO tyrefittingdao=new TyreFittingDAO();
       TyreFittingUtil tyrefittingutil=new TyreFittingUtil();
       GeneralLookupUtil generallookuputil=new GeneralLookupUtil();
	public ArrayList tyreSizeCombo()
	{   
		ArrayList tyreSizeList=new ArrayList();
		try
		{
		
		String query=tyrefittingutil.tyreSizeQuery();	
		tyreSizeList=tyrefittingdao.fetchTyreSize(query);
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
		
		String query=tyrefittingutil.tyreBrandQuery();
		TyreFittingDAO tyrefittingdao=new TyreFittingDAO();
		tyreBrandList=tyrefittingdao.fetchTyreBrand(query);

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
		
		String query=tyrefittingutil.tyrePlyQuery();
		TyreFittingDAO tyrefittingdao=new TyreFittingDAO();
		tyrePlyList=tyrefittingdao.fetchTyrePly(query);

		}
		catch(Exception e)
		{
		logger.debug("Exception "+e);
		}
		return tyrePlyList;
	}

	public ArrayList tyreNumberCombo(int tyreSize,int tyrePly,int tyreBrand)
	{   
		ArrayList tyreNumberList=new ArrayList();
		try
		{
		
		String query=tyrefittingutil.tyreNumberQuery(tyreSize,tyrePly,tyreBrand);
		TyreFittingDAO tyrefittingdao=new TyreFittingDAO();
		tyreNumberList=tyrefittingdao.fetchTyreNumber(query);
		}
		catch(Exception e)
		{
		logger.debug("Exception "+e);
		}
		return tyreNumberList;
	}
	
	public ArrayList institutionCombo()  
	{   
		ArrayList institutionList=new ArrayList();
		try
		{
		
		String query=tyrefittingutil.institutionQuery();
		TyreFittingDAO tyrefittingdao=new TyreFittingDAO();
		institutionList=tyrefittingdao.fetchInstitutionName(query);
		}
		catch(Exception e)
		{
		logger.debug("Exception "+e);
		}
		return institutionList;
	}
		
	public ArrayList vehicleTypeCombo(int institutionName)
   	{   
		ArrayList vehicleTypeList=new ArrayList();
		try
		{
		String query=tyrefittingutil.vehicleTypeQuery(institutionName);
		TyreFittingDAO tyrefittingdao=new TyreFittingDAO();
		vehicleTypeList=tyrefittingdao.fetchvehicleType(query);
	    }
		catch(Exception e)
		{
		logger.debug("Exception "+e);
		}
		return vehicleTypeList;
	}
	
    public ArrayList vehicleNumberCombo(int vehicleType)
   	{   
		ArrayList vehicleNumberList=new ArrayList();
		try
		{
		String query=tyrefittingutil.vehicleNumberQuery(vehicleType);
		TyreFittingDAO tyrefittingdao=new TyreFittingDAO();
		vehicleNumberList=tyrefittingdao.fetchVehicleNumber(query);
		}
		catch(Exception e)
		{
		logger.debug("Exception "+e);
		}
		return vehicleNumberList;
	}
    
   public ArrayList tyrePositionCombo()
   {   
	    ArrayList tyrePositionList=new ArrayList();
		try
		{
		String query=tyrefittingutil.tyrePositionQuery();
		TyreFittingDAO tyrefittingdao=new TyreFittingDAO();
		tyrePositionList=tyrefittingdao.fetchTyrePosition(query);
		}
		catch(Exception e)
		{
		logger.debug("Exception "+e);
		}
		return tyrePositionList;
	}
   
   public ArrayList tyreStatusValue(String tyreNumber)
   {   
	    ArrayList tyreStatusList=new ArrayList();
		try
		{
		String query=tyrefittingutil.tyreStatusQuery(tyreNumber);
		TyreFittingDAO tyrefittingdao=new TyreFittingDAO();
		tyreStatusList=tyrefittingdao.fetchTyreStatus(query);
		TyreFittingVO tyrefittingvo=(TyreFittingVO)tyreStatusList.get(0);
		logger.debug("tyre status in sERVICE "+tyrefittingvo.getTyreStatus());
		}
		catch(Exception e)
		{
		logger.debug("Exception "+e);
		}
		return tyreStatusList;
	}
   public void insert(TyreFittingVO tyrefittingvo)
   {   
	    
		try
		{
		String query=tyrefittingutil.insertQuery(tyrefittingvo);
		TyreFittingDAO tyrefittingdao=new TyreFittingDAO();
	    tyrefittingdao.insertValues(query);
		}
		catch(Exception e)
		{
		logger.debug("Exception "+e);
		}
	}
   public void updateTyreMaster(String tyreNumber)
   {
	   try
	   {
		   String query=tyrefittingutil.updateTyreMaster(tyreNumber);
		   TyreFittingDAO tyrefittingdao=new TyreFittingDAO();
		   tyrefittingdao.updateTyreMaster(query);
		   }
	   catch(Exception e)
	   {
		   logger.debug("Exception "+e);
	   }
	
}
  }

	 
   
