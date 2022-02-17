package com.dao;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.dbcom.dbcom;
import com.util.PassingBillUtil;
import com.vo.PassingBillVO;


public class PassingBillDAO {
	private static final Logger logger=(Logger)Logger.getLogger(PassingBillDAO.class);
	dbcom db=new dbcom();
	PassingBillUtil util=new PassingBillUtil();
	PassingBillVO passingbillvo=new PassingBillVO();
	/**
	 * 
	 * @param query
	 * @return
	 * @throws Exception
	 */
	public ArrayList fetchType(String query)throws Exception
	{
		logger.debug("PassingBillDAO:fetchType<----------");
		ArrayList typeList=new ArrayList();
		typeList=db.selectQuery("com.vo.PassingBillVO", query);
		logger.debug("PassingBillDAO:fetchType---------->");
		return typeList;
	}
	/**
	 * 
	 * @param query
	 * @return
	 * @throws Exception
	 */
	public ArrayList convertToDesc(String query)throws Exception
	{
		logger.debug("PassingBillDAO:convertToCode<----------");
		ArrayList codeList=new ArrayList();
		codeList=db.selectQuery("com.vo.PassingBillVO", query);
		logger.debug("List Size"+codeList);
		return codeList;
	}
	/**
	 * 
	 * @param query
	 * @return
	 * @throws Exception
	 */
	public ArrayList fetchGoodsType(String query)throws Exception
	{
		logger.debug("PassingBillDAO:fetchType<----------");
		ArrayList typeList=new ArrayList();
		typeList=db.selectQuery("com.vo.PassingBillVO", query);
		logger.debug("PassingBillDAO:fetchType---------->");
		return typeList;
	}
	public ArrayList fetchBillNumbers(String query) {
		// TODO Auto-generated method stub
		logger.debug("PassingBillDAO:fetchBillNumbers<----------");
		ArrayList billnumberList=new ArrayList();
		billnumberList=db.selectQuery("com.vo.PassingBillVO", query);
		logger.debug("PassingBillDAO:fetchBillNumbers---------->");
		return billnumberList;
	}
	public ArrayList fetchServiceDetails(String query) {
		// TODO Auto-generated method stub
		logger.debug("PassingBillDAO:fetchServiceDetails<----------");
		ArrayList generalList=new ArrayList();
		generalList=db.selectQuery("com.vo.PassingBillVO", query);
		logger.debug("PassingBillDAO:fetchServiceDetails---------->");
		return generalList;
	}
	public ArrayList convertToCode(String query) {
		logger.debug("PassingBillDAO:convertToCode<----------");
		ArrayList codeList=new ArrayList();
		codeList=db.selectQuery("com.vo.PassingBillVO", query);
		logger.debug("List Size"+codeList);
		return codeList;
	}
	public void insert(String query) {
		// TODO Auto-generated method stub
		logger.debug("PassingBillDAO:insert<----------");
		db.otherQuery(query);
	}
	public void updateBillPassed(String query) {
		// TODO Auto-generated method stub
		logger.debug("PassingBillDAO:updateBillPassed<----------");
		db.otherQuery(query);
	}
}
