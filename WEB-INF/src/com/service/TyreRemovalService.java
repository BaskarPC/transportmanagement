package com.service;

import org.apache.log4j.Logger;
import java.util.*;
import com.action.TyreRemovalAction;
import com.dao.TyreFittingDAO;
import com.dao.TyreRemovalDAO;
import com.util.GeneralLookupUtil;
import com.vo.TyreFittingVO;
import com.vo.TyreRemovalVO;
import com.util.TyreRemovalUtil;
public class TyreRemovalService {
	private static final Logger logger=(Logger)Logger.getLogger(TyreRemovalService.class);
	   TyreRemovalDAO tyreremovaldao=new TyreRemovalDAO();
       TyreRemovalUtil tyreremovalutil=new TyreRemovalUtil();
       GeneralLookupUtil generallookuputil=new GeneralLookupUtil();
	   TyreRemovalVO tyreremovalvo=new TyreRemovalVO();
	public ArrayList tyreNumberCombo(int vehicleNumber)
	{   
		ArrayList tyreNumberList=new ArrayList();
		try
		{
		
		String query=tyreremovalutil.tyreNumberQuery(vehicleNumber);
		tyreNumberList=tyreremovaldao.fetchTyreNumber(query);
		}
		catch(Exception e)
		{
		logger.debug("Exception "+e);
		}
		return tyreNumberList;
	}
	
	public ArrayList tyreDetails(String tyreNumber)
	{
		ArrayList list=new ArrayList();
		try
		{
		
		String query=tyreremovalutil.tyreDetails(tyreNumber);
		list=tyreremovaldao.fetchTyreDetails(query);
		logger.debug("Inside serviceeeeeeeeee ");
		logger.debug("List size :"+list.size());
		}
		catch(Exception e)
		{
		logger.debug("Exception "+e);
		}
		return list;
	}
	
	public ArrayList institutionCombo()  
	{   
		ArrayList institutionList=new ArrayList();
		try
		{
		
		String query=tyreremovalutil.institutionQuery();
		logger.debug("Called Tyre removal Service");
		institutionList=tyreremovaldao.fetchInstitutionName(query);
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
		String query=tyreremovalutil.vehicleTypeQuery(institutionName);
		vehicleTypeList=tyreremovaldao.fetchvehicleType(query);
		
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
		String query=tyreremovalutil.vehicleNumberQuery(vehicleType);
		vehicleNumberList=tyreremovaldao.fetchVehicleNumber(query);
		logger.debug("Vehicle number in Service:" +vehicleNumberList.size());
		}
		catch(Exception e)
		{
		logger.debug("Exception "+e);
		}
		return vehicleNumberList;
	}
    
    public ArrayList tyrePositionCdesc(int tyreposition)
   	{   
		ArrayList tyrePositionList=new ArrayList();
		try
		{
		String query=tyreremovalutil.tyrePosition(tyreposition);
		tyrePositionList=tyreremovaldao.fetchTyrePosition(query);
		logger.debug("Vehicle number in Service:" +tyrePositionList.size());
		}
		catch(Exception e)
		{
		logger.debug("Exception "+e);
		}
		return tyrePositionList;
	}
    public void insert(TyreRemovalVO tyreremovalvo)
    {   
 	    
 		try
 		{
 		
 		String query=tyreremovalutil.insertQuery(tyreremovalvo);
 		tyreremovaldao.insertValues(query);
 		}
 		catch(Exception e)
 		{
 		logger.debug("Exception "+e);
 		}
  	}
    public void changeDelIndicator(String tyreNumber)
    {   
		try
		{
		String query=tyreremovalutil.changeIndicator(tyreNumber);
		tyreremovaldao.changeIndicator(query);
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
		String query=tyreremovalutil.updateTyreMaster(tyreNumber);
		tyreremovaldao.updateTyreMaster(query);
		}
		catch(Exception e)
		{
		logger.debug("Exception "+e);
		}
    }
   
   
}
