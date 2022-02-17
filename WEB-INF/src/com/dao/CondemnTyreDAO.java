package com.dao;

import java.util.ArrayList;
import org.apache.log4j.Logger;
import com.vo.CondemnTyreVO;
import com.dbcom.*;

public class CondemnTyreDAO {
	
private static final Logger logger=(Logger)Logger.getLogger(TyreFittingDAO.class);
	CondemnTyreVO condemntyrevo=new CondemnTyreVO();
	
	/**
	 * DAO to fetch the tyresize
	 * @param query
	 * @return
	 * @throws Exception
	 */
	public ArrayList fetchTyreSize(String query)throws Exception
	{   
		ArrayList tyreSizeList=new ArrayList();
		dbcom ob=new dbcom();
		tyreSizeList=ob.selectQuery("com.vo.CondemnTyreVO", query);
		return tyreSizeList;
	 }
	
	/**
	 * DAO to fetch tyrebrand
	 * @param query
	 * @return
	 * @throws Exception
	 */
	public ArrayList fetchTyreBrand(String query)throws Exception
	{   
		ArrayList tyreBrandList=new ArrayList();
		dbcom ob=new dbcom();
		tyreBrandList=ob.selectQuery("com.vo.CondemnTyreVO", query);
		return tyreBrandList;
	 }
	
	/**
	 * DAO to fetch tyreply
	 * @param query
	 * @return
	 * @throws Exception
	 */
	public ArrayList fetchTyrePly(String query)throws Exception
	{   
		ArrayList tyrePlyList=new ArrayList();
		dbcom ob=new dbcom();
		tyrePlyList=ob.selectQuery("com.vo.CondemnTyreVO", query);
		return tyrePlyList;
	 }
	/**
	 * DAO to fetch tyrenumber
	 * @param query
	 * @return
	 * @throws Exception
	 */
	public ArrayList fetchTyreNumber(String query)throws Exception
	{   
		ArrayList tyreNumberList=new ArrayList();
		dbcom ob=new dbcom();
		tyreNumberList=ob.selectQuery("com.vo.CondemnTyreVO", query);
		return tyreNumberList;
	}

	/**
	 * DAO to fetch tyrestaus
	 * @param query
	 * @return
	 */
	public ArrayList fetchTyreStatus(String query) {
		// TODO Auto-generated method stub
		ArrayList tyreStatusList=new ArrayList();
		dbcom ob=new dbcom();
		tyreStatusList=ob.selectQuery("com.vo.CondemnTyreVO", query);
		return tyreStatusList;
	}

	/**
	 * DAO to update tyremaster
	 * @param query
	 */
	public void updateTyreMaster(String query) {
		dbcom ob=new dbcom();
		ob.otherQuery(query);
	}

	/**
	 * DAO to insert the values into the database
	 * @param query
	 */
	public void insert(String query) {
		// TODO Auto-generated method stub
		dbcom ob=new dbcom();
		ob.otherQuery(query);
		
	}
}
