package com.dao;

import java.util.ArrayList;
import org.apache.log4j.Logger;
import com.dbcom.dbcom;
import com.util.*;


public class DieselOutsideDAO {
	private static final Logger logger=(Logger)Logger.getLogger(DieselOutsideDAO.class);
	dbcom db=new dbcom();
	DieselOutsideUtil util=new DieselOutsideUtil();

	public ArrayList fetchInst(String query)throws Exception
	{
		logger.debug("DieselOutsideDAO:fetchInst<----------");
		ArrayList institutionList=new ArrayList();
		institutionList=db.selectQuery("com.vo.DieselOutsideVO", query);
		logger.debug("DieselOutsideDAO:fetchInst<----------");
		return institutionList;
	}
	public ArrayList fetchType(String query)throws Exception
	{
		logger.debug("DieselOutsideDAO:fetchType<----------");
		ArrayList typeList=new ArrayList();
		typeList=db.selectQuery("com.vo.DieselOutsideVO", query);
		logger.debug("DieselOutsideDAO:fetchType---------->");
		return typeList;
	}
	public ArrayList fetchVehicle(String query)throws Exception
	{
		logger.debug("DieselOutsideDAO:fetchVehicle<----------");
		ArrayList vehicleList=new ArrayList();
		vehicleList=db.selectQuery("com.vo.DieselOutsideVO", query);
		logger.debug("DieselOutsideDAO:fetchVehicle---------->");
		return vehicleList;
	}
	public ArrayList instMethod(String query)throws Exception
	{
		logger.debug("DieselOutsideDAO:instMethod<----------");
		ArrayList vehicleTypeList=new ArrayList();
		vehicleTypeList=db.selectQuery("com.vo.DieselOutsideVO", query);
		logger.debug("DieselOutsideDAO:instMethod---------->");
		return vehicleTypeList;
	}
	
	public ArrayList vehicleMethod(String query)throws Exception
	{
		logger.debug("DieselOutsideDAO:vehicleMethod<----------");
		ArrayList vehicleList=new ArrayList();
		vehicleList=db.selectQuery("com.vo.DieselOutsideVO", query);
		logger.debug("DieselOutsideDAO:vehicleMethod---------->");
		return vehicleList;
	}
	public ArrayList convertToDesc(String query)throws Exception
	{
		logger.debug("DieselOutsideDAO:convertToDesc<----------");
		ArrayList descList=new ArrayList();
		descList=db.selectQuery("com.vo.DieselOutsideVO", query);
		logger.debug("DieselOutsideDAO:convertToDesc---------->");
		return descList;
	}
	public ArrayList convertToCode(String query)throws Exception
	{
		logger.debug("DieselOutsideDAO:convertToCode<----------");
		ArrayList codeList=new ArrayList();
		codeList=db.selectQuery("com.vo.DieselOutsideVO", query);
		logger.debug("List Size"+codeList);
		return codeList;
	}
	public void insert(String query){
		// TODO Auto-generated method stub
		logger.debug("DieselOutsideDAO:insert<---------->");
		db.otherQuery(query);
	}
	
	public ArrayList retrieve(String query) {
		// TODO Auto-generated method stub
		logger.debug("DieselOutsideDAO:retrieve<----------");
		ArrayList retrieveList=new ArrayList();
		retrieveList=db.selectQuery("com.vo.DieselOutsideVO", query);
		logger.debug("DieselOutsideDAO:retrieve---------->");
		return retrieveList;
	}
	public ArrayList driverMethod(String query) {
		// TODO Auto-generated method stub
		logger.debug("DieselOutsideDAO:driverMethod<----------");
		ArrayList driverNameList=new ArrayList();
		driverNameList=db.selectQuery("com.vo.DieselOutsideVO",query);
		logger.debug("DieselOutsideDAO:driverMethod---------->");
		return driverNameList;
	}

	public void insertmaster(String query){
		// TODO Auto-generated method stub
		logger.debug("DieselOutsideDAO:insertmaster<---------->");
		db.otherQuery(query);
	}

	public ArrayList retrieveMaster(String query) {
		// TODO Auto-generated method stub
		logger.debug("DieselOutsideDAO:retrieveMaster<----------");
		ArrayList retrieveMasterList=new ArrayList();
		retrieveMasterList=db.selectQuery("com.vo.DieselOutsideVO", query);
		logger.debug("DieselOutsideDAO:retrieveMaster---------->");
		return retrieveMasterList;
	}

	public ArrayList quantityMethod(String query) {
		// TODO Auto-generated method stub
		logger.debug("DieselOutsideDAO:quantityMethod<----------");
		ArrayList quantityList=new ArrayList();
		quantityList=db.selectQuery("com.vo.DieselOutsideVO", query);
		logger.debug("DieselOutsideDAO:quantityMethod---------->");
		return quantityList;
	}

	public ArrayList differenceMethod(String query) {
		// TODO Auto-generated method stub
		logger.debug("DieselOutsideDAO:differenceMethod<----------");
		ArrayList differenceList=new ArrayList();
		differenceList=db.selectQuery("com.vo.DieselOutsideVO", query);
		logger.debug("DieselOutsideDAO:lastFillingKmMethod---------->");
		return differenceList;
	}
	
	public ArrayList fetchFuel(String query) {
		logger.debug("DieselOutsideDAO:fetchFuel<----------");
		ArrayList fuelList=new ArrayList();
		fuelList=db.selectQuery("com.vo.DieselOutsideVO", query);
		logger.debug("DieselOutsideDAO:fetchFuel---------->");
		return fuelList;
	}

	public ArrayList lastFillingKmMethod(String query) {
		// TODO Auto-generated method stub
		logger.debug("DieselOutsideDAO:lastFillingKmMethod<----------");
		ArrayList lastFillingKmList=new ArrayList();
		lastFillingKmList=db.selectQuery("com.vo.DieselOutsideVO", query);
		logger.debug("DieselOutsideDAO:lastFillingKmMethod---------->");
		return lastFillingKmList;
	}
	
	}
        