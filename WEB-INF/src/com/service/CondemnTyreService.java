package com.service;

import org.apache.log4j.Logger;
import java.util.*;
import com.dao.CondemnTyreDAO;
import com.util.CondemnTyreUtil;

public class CondemnTyreService {
	private static final Logger logger=(Logger)Logger.getLogger(TyreFittingService.class);
	CondemnTyreDAO condemntyredao=new CondemnTyreDAO();
	CondemnTyreUtil condemntyreutil=new CondemnTyreUtil();
	/**
	 * Service method to retrieve the tyresize 
	 * @return
	 */
    public ArrayList tyreSizeCombo()	{   
		ArrayList tyreSizeList=new ArrayList();
		try
		{
		String query=condemntyreutil.tyreSizeQuery();	
		tyreSizeList=condemntyredao.fetchTyreSize(query);
		}
		catch(Exception e)
		{
		logger.debug("Exception "+e);
		}
		return tyreSizeList;
	}
	
    /**
     * Service method to retrieve the tyrebrand
     * @return
     */
	public ArrayList tyreBrandCombo()	{   
		ArrayList tyreBrandList=new ArrayList();
		try
		{
		String query=condemntyreutil.tyreBrandQuery();
		CondemnTyreDAO condemntyredao=new CondemnTyreDAO();
		tyreBrandList=condemntyredao.fetchTyreBrand(query);
		}
		catch(Exception e)
		{
		logger.debug("Exception "+e);
		}
		return tyreBrandList;
	}
		
	/**
	 * Service method to retrieve the tyreply
	 * @return
	 */
	public ArrayList tyrePlyCombo()	{   
		ArrayList tyrePlyList=new ArrayList();
		try
		{
		String query=condemntyreutil.tyrePlyQuery();
		CondemnTyreDAO condemntyredao=new CondemnTyreDAO();
		tyrePlyList=condemntyredao.fetchTyrePly(query);
		}
		catch(Exception e)
		{
		logger.debug("Exception "+e);
		}
		return tyrePlyList;
	}

	/**
	 * Service mathod to retrieve the tyrenumbers
	 * @param tyreSize
	 * @param tyrePly
	 * @param tyreBrand
	 * @return
	 */
	public ArrayList tyreNumberCombo(int tyreSize,int tyrePly,int tyreBrand){   
		ArrayList tyreNumberList=new ArrayList();
		try
		{
		
		String query=condemntyreutil.tyreNumberQuery(tyreSize,tyrePly,tyreBrand);
		CondemnTyreDAO condemntyredao=new CondemnTyreDAO();
		tyreNumberList=condemntyredao.fetchTyreNumber(query);
		}
		catch(Exception e)
		{
		logger.debug("Exception "+e);
		}
		return tyreNumberList;
	}
	
	/**
	 * Service method to get the tyrestatus
	 * @param tyreNumber
	 * @return
	 */
	public ArrayList fetchTyreStatus(String tyreNumber){   
		ArrayList tyreStatusList=new ArrayList();
		try
		{
		String query=condemntyreutil.tyreStatusQuery(tyreNumber);
		CondemnTyreDAO condemntyredao=new CondemnTyreDAO();
		tyreStatusList=condemntyredao.fetchTyreStatus(query);
	}
		catch(Exception e)
		{
		logger.debug("Exception "+e);
		}
		return tyreStatusList;
	}
	
	/**
	 * Service method to update use_indicator in the tyremaster 
	 * @param tyreNumber
	 */
	public void updateTyreMaster(String tyreNumber){   
		try
		{
		String query=condemntyreutil.updateTyreMasterQuery(tyreNumber);
		CondemnTyreDAO condemntyredao=new CondemnTyreDAO();
		condemntyredao.updateTyreMaster(query);
		}
		catch(Exception e)
		{
		logger.debug("Exception "+e);
		}
	}	
	
	/**
	 * Service method to insert the values into the database
	 * @param tyreNumber
	 * @param tyreStatus
	 * @param condemnDate
	 * @param condemnReason
	 */
	public void insert(String tyreNumber,String tyreStatus,String condemnDate,String condemnReason){
		try
		{
		String query=condemntyreutil.insertQuery(tyreNumber,tyreStatus,condemnDate,condemnReason);
		CondemnTyreDAO condemntyredao=new CondemnTyreDAO();
		condemntyredao.insert(query);
		}
		catch(Exception e)
		{
		logger.debug("Exception "+e);
		}
	}

}
