package com.dao;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.dbcom.dbcom;
import com.util.GeneralNoteUtil;
import com.vo.GeneralNoteVO;

public class GeneralNoteDAO {
private static final Logger logger=(Logger)Logger.getLogger(GeneralNoteDAO.class);
	dbcom db=new dbcom();
	GeneralNoteVO generalnotevo=new GeneralNoteVO();
	GeneralNoteUtil util=new GeneralNoteUtil();
	public ArrayList fetchInst(String query)throws Exception
	{
		logger.debug("GreaseDAO:fetchInst<----------");
		ArrayList institutionList=new ArrayList();
		institutionList=db.selectQuery("com.vo.GeneralNoteVO", query);
		logger.debug("GreaseDAO:fetchInst---------->");
		return institutionList;
	}
	
	public ArrayList fetchType(String query)throws Exception
	{
		ArrayList typeList=new ArrayList();
		typeList=db.selectQuery("com.vo.GeneralNoteVO", query);
		return typeList;
	}
	
	public ArrayList fetchVehicle(String query)throws Exception
	{
		ArrayList vehicleList=new ArrayList();
		vehicleList=db.selectQuery("com.vo.GeneralNoteVO", query);
		return vehicleList;
	}
	public ArrayList fetchGeneralNote(String query) {
		// TODO Auto-generated method stub
		ArrayList generalNoteList=new ArrayList();
		generalNoteList=db.selectQuery("com.vo.GeneralNoteVO", query);
		return generalNoteList;
	}
	public ArrayList instMethod(String query) {
		// TODO Auto-generated method stub
		ArrayList vehicleTypeList=new ArrayList();
		vehicleTypeList=db.selectQuery("com.vo.GeneralNoteVO", query);
		logger.debug("GreaseDAO:instMethod---------->");
		return vehicleTypeList;
	}
	public ArrayList vehicleMethod(String query)throws Exception
	{
		logger.debug("GreaseDAO:vehicleMethod<----------");
		ArrayList vehicleList=new ArrayList();
		vehicleList=db.selectQuery("com.vo.GeneralNoteVO", query);
		logger.debug("GreaseDAO:vehicleMethod---------->");
		return vehicleList;
	}
	public ArrayList driverMethod(String query) {
		// TODO Auto-generated method stub
		ArrayList driverList=new ArrayList();
		driverList=db.selectQuery("com.vo.GeneralNoteVO", query);
		return driverList;
	}
	public ArrayList quantityMethod(String query) {
		// TODO Auto-generated method stub
		ArrayList quantityList=new ArrayList();
		quantityList=db.selectQuery("com.vo.GeneralNoteVO", query);
		return quantityList;
	}
	public void insertmaster(String query){
		// TODO Auto-generated method stub
		logger.debug("GreaseDAO:insert<----------");
		db.otherQuery(query);
	
	}

	public void insert(String query){
		// TODO Auto-generated method stub
		logger.debug("GreaseDAO:insert<----------");
		db.otherQuery(query);
	}
	
	public ArrayList retrieveMaster(String query) {
		// TODO Auto-generated method stub
		ArrayList retrieveMasterList=new ArrayList();
		retrieveMasterList=db.selectQuery("com.vo.GreaseVO", query);
		return retrieveMasterList;
	}
	
	public ArrayList retrieve(String query) {
		// TODO Auto-generated method stub
		logger.debug("GreaseDAO:retrieve<----------");
		ArrayList vehicleTypeList=new ArrayList();
		vehicleTypeList=db.selectQuery("com.vo.GreaseVO", query);
		return vehicleTypeList;
	}
	/**
	 * 
	 * @param query
	 * @return
	 * @throws Exception
	 */
	public ArrayList convertToDesc(String query)throws Exception
	{
		logger.debug("GreaseDAO:convertToDesc<----------");
		ArrayList descList=new ArrayList();
		descList=db.selectQuery("com.vo.GreaseVO", query);
		logger.debug("GreaseDAO:convertToDesc---------->");
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
		logger.debug("GreaseDAO:convertToCode<----------");
		ArrayList codeList=new ArrayList();
		codeList=db.selectQuery("com.vo.GreaseVO", query);
		logger.debug("List Size"+codeList);
		return codeList;
	}

}
