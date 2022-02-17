package com.dao;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.dbcom.dbcom;
import com.util.*;
import com.vo.DieselVO;

public class DieselDAO {
	private static final Logger logger=(Logger)Logger.getLogger(DieselDAO.class);
	dbcom db=new dbcom();
	DieselUtil util=new DieselUtil();
	DieselVO dieselvo=new DieselVO();
	/**
	 * 
	 * @param query
	 * @return
	 * @throws Exception
	 */
	public ArrayList fetchInst(String query)throws Exception
	{
		logger.debug("DieselDAO:fetchInst<----------");
		ArrayList institutionList=new ArrayList();
		institutionList=db.selectQuery("com.vo.DieselVO", query);
		logger.debug("DieselDAO:fetchInst---------->");
		return institutionList;
	}
	/**
	 * 
	 * @param query
	 * @return
	 * @throws Exception
	 */
	public ArrayList fetchType(String query)throws Exception
	{
		logger.debug("DieselDAO:fetchType<----------");
		ArrayList typeList=new ArrayList();
		typeList=db.selectQuery("com.vo.DieselVO", query);
		logger.debug("DieselDAO:fetchType---------->");
		return typeList;
	}
	/**
	 * 
	 * @param query
	 * @return
	 * @throws Exception
	 */
	public ArrayList fetchVehicle(String query)throws Exception
	{
		logger.debug("DieselDAO:fetchVehicle<----------");
		ArrayList vehicleList=new ArrayList();
		vehicleList=db.selectQuery("com.vo.DieselVO", query);
		logger.debug("DieselDAO:fetchVehicle---------->");
		return vehicleList;
	}
	/**
	 * 
	 * @param query
	 * @return
	 * @throws Exception
	 */
	public ArrayList instMethod(String query)throws Exception
	{
		logger.debug("DieselDAO:instMethod<----------");
		ArrayList vehicleTypeList=new ArrayList();
		vehicleTypeList=db.selectQuery("com.vo.DieselVO", query);
		logger.debug("DieselDAO:instMethod---------->");
		return vehicleTypeList;
	}
	
	/**
	 * 
	 * @param query
	 * @return
	 * @throws Exception
	 */
	public ArrayList vehicleMethod(String query)throws Exception
	{
		logger.debug("DieselDAO:vehicleMethod<----------");
		ArrayList vehicleList=new ArrayList();
		vehicleList=db.selectQuery("com.vo.DieselVO", query);
		logger.debug("DieselDAO:vehicleMethod---------->");
		return vehicleList;
	}
	/**
	 * 
	 * @param query
	 * @return
	 * @throws Exception
	 */
	public ArrayList convertToDesc(String query)throws Exception
	{
		logger.debug("DieselDAO:convertToDesc<----------");
		ArrayList descList=new ArrayList();
		descList=db.selectQuery("com.vo.DieselVO", query);
		logger.debug("DieselDAO:convertToDesc---------->");
		return descList;
	}
	/**
	 * 
	 * @param query
	 * @return
	 * @throws Exception
	 */
	public ArrayList convertToCode(String query)throws Exception
	{
		logger.debug("DieselDAO:convertToCode<----------");
		ArrayList codeList=new ArrayList();
		codeList=db.selectQuery("com.vo.DieselVO", query);
		logger.debug("List Size"+codeList);
		return codeList;
	}
	/**
	 * 
	 * @param query
	 */
	public void insert(String query){
		// TODO Auto-generated method stub
		logger.debug("DieselDAO:insert<---------->");
		db.otherQuery(query);
	}
	
	/**
	 * 
	 * @param query
	 * @return
	 */
	public ArrayList retrieve(String query) {
		// TODO Auto-generated method stub
		logger.debug("DieselDAO:retrieve<----------");
		ArrayList retrieveList=new ArrayList();
		retrieveList=db.selectQuery("com.vo.DieselVO", query);
		logger.debug("DieselDAO:retrieve---------->");
		return retrieveList;
	}
	/**
	 * 
	 * @param query
	 * @return
	 */
	public ArrayList driverMethod(String query) {
		// TODO Auto-generated method stub
		logger.debug("DieselDAO:driverMethod<----------");
		ArrayList driverNameList=new ArrayList();
		driverNameList=db.selectQuery("com.vo.DieselVO",query);
		logger.debug("DieselDAO:driverMethod---------->");
		return driverNameList;
	}

	/**
	 * 
	 * @param query
	 */
	public void insertmaster(String query){
		// TODO Auto-generated method stub
		logger.debug("DieselDAO:insertmaster<---------->");
		db.otherQuery(query);
	}

	/**
	 * 
	 * @param query
	 * @return
	 */
	public ArrayList retrieveMaster(String query) {
		// TODO Auto-generated method stub
		logger.debug("DieselDAO:retrieveMaster<----------");
		ArrayList retrieveMasterList=new ArrayList();
		retrieveMasterList=db.selectQuery("com.vo.DieselVO", query);
		logger.debug("DieselDAO:retrieveMaster---------->");
		return retrieveMasterList;
	}

	/**
	 * 
	 * @param query
	 * @return
	 */
	public ArrayList quantityMethod(String query) {
		// TODO Auto-generated method stub
		logger.debug("DieselDAO:quantityMethod<----------");
		ArrayList quantityList=new ArrayList();
		quantityList=db.selectQuery("com.vo.DieselVO", query);
		logger.debug("DieselDAO:quantityMethod---------->");
		return quantityList;
	}

	/**
	 * 
	 * @param query
	 * @return
	 */
	public ArrayList lastFillingKmMethod(String query) {
		// TODO Auto-generated method stub
		logger.debug("DieselDAO:lastFillingKmMethod<----------");
		ArrayList lastFillingKmList=new ArrayList();
		lastFillingKmList=db.selectQuery("com.vo.DieselVO", query);
		logger.debug("DieselDAO:lastFillingKmMethod---------->");
		return lastFillingKmList;
	}

	/**
	 * 
	 * @param query
	 * @return
	 */
	public ArrayList differenceMethod(String query) {
		// TODO Auto-generated method stub
		logger.debug("DieselDAO:differenceMethod<----------");
		ArrayList differenceList=new ArrayList();
		differenceList=db.selectQuery("com.vo.DieselVO", query);
		logger.debug("DieselDAO:differenceMethod---------->");
		return differenceList;
	}
	public void updateValues(String query) {
		// TODO Auto-generated method stub
		logger.debug("DieselDAO:updateValues<---------->");
		db.otherQuery(query);
		
	}
	public void updateValuestemporary(String query) {
		// TODO Auto-generated method stub
		logger.debug("DieselDAO:updateValuestemporary<---------->");
		db.otherQuery(query);
	}
	public void updateExtra(String query) {
		// TODO Auto-generated method stub
		logger.debug("DieselDAO:updateExtra<---------->");
		db.otherQuery(query);
		
	}
	public void updateDate(String query1) {
		// TODO Auto-generated method stub
		logger.debug("DieselDAO:updateDate<---------->");
		db.otherQuery(query1);		
	}
}
        