package com.dao;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.dbcom.dbcom;
import com.util.OilUtil;
import com.vo.OilVO;

public class OilDAO {
	private static final Logger logger=(Logger)Logger.getLogger(OilDAO.class);
	dbcom db=new dbcom();
	OilVO oilvo=new OilVO();
	OilUtil util=new OilUtil();
	public ArrayList fetchInst(String query)throws Exception
	{
		logger.debug("OilDAO:fetchInst<----------");
		ArrayList institutionList=new ArrayList();
		institutionList=db.selectQuery("com.vo.OilVO", query);
		logger.debug("OilDAO:fetchInst---------->");
		return institutionList;
	}
	
	public ArrayList fetchType(String query)throws Exception
	{
		ArrayList typeList=new ArrayList();
		typeList=db.selectQuery("com.vo.OilVO", query);
		return typeList;
	}
	
	public ArrayList fetchVehicle(String query)throws Exception
	{
		ArrayList vehicleList=new ArrayList();
		vehicleList=db.selectQuery("com.vo.OilVO", query);
		return vehicleList;
	}

	public ArrayList fetchOil(String query)throws Exception
	{
		ArrayList oilList=new ArrayList();
		oilList=db.selectQuery("com.vo.OilVO", query);
		return oilList;
	}
	
	public ArrayList fetchOilReason(String query)throws Exception
	{
		ArrayList reasonList=new ArrayList();
		reasonList=db.selectQuery("com.vo.OilVO", query);
		return reasonList;
	}
	
	public ArrayList instMethod(String query) {
		// TODO Auto-generated method stub
		ArrayList vehicleTypeList=new ArrayList();
		vehicleTypeList=db.selectQuery("com.vo.OilVO", query);
		logger.debug("OilDAO:instMethod---------->");
		return vehicleTypeList;
	}
	public ArrayList vehicleMethod(String query)throws Exception
	{
		logger.debug("OilDAO:vehicleMethod<----------");
		ArrayList vehicleList=new ArrayList();
		vehicleList=db.selectQuery("com.vo.OilVO", query);
		logger.debug("OilDAO:vehicleMethod---------->");
		return vehicleList;
	}

	public ArrayList driverMethod(String query) {
		// TODO Auto-generated method stub
		ArrayList driverList=new ArrayList();
		driverList=db.selectQuery("com.vo.OilVO", query);
		return driverList;
	}
	
	public ArrayList previouslyServicedKmMethod(String query) {
		// TODO Auto-generated method stub
		ArrayList servicedKmList=new ArrayList();
		servicedKmList=db.selectQuery("com.vo.OilVO", query);
		return servicedKmList;
	}

	public ArrayList quantityMethod(String query) {
		// TODO Auto-generated method stub
		ArrayList quantityList=new ArrayList();
		quantityList=db.selectQuery("com.vo.OilVO", query);
		return quantityList;
	}

	public void insertmaster(String query){
		// TODO Auto-generated method stub
		logger.debug("OilDAO:insert<----------");
		db.otherQuery(query);
	
	}

	public void insert(String query){
		// TODO Auto-generated method stub
		logger.debug("OilDAO:insert<----------");
		db.otherQuery(query);
	}
	
	public ArrayList retrieveMaster(String query) {
		// TODO Auto-generated method stub
		ArrayList retrieveMasterList=new ArrayList();
		retrieveMasterList=db.selectQuery("com.vo.OilVO", query);
		return retrieveMasterList;
	}
	
	public ArrayList retrieve(String query) {
		// TODO Auto-generated method stub
		logger.debug("OilDAO:retrieve<----------");
		ArrayList vehicleTypeList=new ArrayList();
		vehicleTypeList=db.selectQuery("com.vo.OilVO", query);
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
		logger.debug("OilDAO:convertToDesc<----------");
		ArrayList descList=new ArrayList();
		descList=db.selectQuery("com.vo.OilVO", query);
		logger.debug("OilDAO:convertToDesc---------->");
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
		logger.debug("OilDAO:convertToCode<----------");
		ArrayList codeList=new ArrayList();
		codeList=db.selectQuery("com.vo.OilVO", query);
		logger.debug("List Size"+codeList);
		return codeList;
	}
	public void updateValues(String query) {
		// TODO Auto-generated method stub
		logger.debug("OilDAO:updateValues<---------->");
		db.otherQuery(query);
	}
	public void updateValuestemporary(String query) {
		// TODO Auto-generated method stub
		logger.debug("OilDAO:updateValuestemporary<---------->");
		db.otherQuery(query);
	}
	public void updateExtra(String query) {
		// TODO Auto-generated method stub
		logger.debug("OilDAO:updateExtra<---------->");
		db.otherQuery(query);
	}

	public void updateDate(String query1) {
		// TODO Auto-generated method stub
		logger.debug("OilDAO:updateDate<---------->");
		db.otherQuery(query1);
	}

}
