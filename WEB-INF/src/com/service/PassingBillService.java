package com.service;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import com.dao.PassingBillDAO;
import com.util.GeneralUtil;
import com.util.PassingBillUtil;
import com.vo.PassingBillVO;

public class PassingBillService {
	PassingBillDAO passingbillDAO=new PassingBillDAO();
	PassingBillUtil util=new PassingBillUtil();
	GeneralUtil generalutil=new GeneralUtil();
	private static final Logger logger=(Logger)Logger.getLogger(PassingBillService.class);
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public ArrayList fetchType()throws Exception
	{
		logger.debug("PassingBillService:fetchType<----------");
		ArrayList typeList=new ArrayList();
		String query=util.fetchType();
		typeList=passingbillDAO.fetchType(query);
		logger.debug("PassingBillService:fetchType---------->");
		return typeList;
	}
	public ArrayList fetchGoodsType(String ptype) throws Exception {
		// TODO Auto-generated method stub
		logger.debug("PassingBillService:fetchGoodsType<----------");
		ArrayList typeList=new ArrayList();
		String query=util.fetchGoodsType(ptype);
		typeList=passingbillDAO.fetchGoodsType(query);
		logger.debug("PassingBillService:fetchGoodsType---------->");
		return typeList;
	}
	/**
	 * 
	 * @param drivercode
	 * @return
	 * @throws Exception
	 */
	public ArrayList convertToDesc(String drivercode)throws Exception
	{
		logger.debug("PassingBillService:convertToDesc<----------");
		ArrayList descList=new ArrayList();
		String query=generalutil.convertToDesc(drivercode);
		descList=passingbillDAO.convertToDesc(query);
		logger.debug("PassingBillService:convertToDesc---------->");
		return descList;
	}
	public ArrayList fetchBillNumbers(int prtype, String type) {
		// TODO Auto-generated method stub
		logger.debug("PassingBillService:fetchBillNumbers<----------");
		ArrayList billnumberList=new ArrayList();
		String query=util.fetchBillNumbers(prtype,type);
		billnumberList=passingbillDAO.fetchBillNumbers(query);
		logger.debug("PassingBillService:fetchBillNumbers---------->");
		return billnumberList;
	}
	public ArrayList fetchServiceDetails(String ptype, int billnumber, String goodstype) {
		// TODO Auto-generated method stub
		logger.debug("PassingBillService:fetchServiceDetails<----------");
		ArrayList generalList=new ArrayList();
		String query=util.fetchServiceDetails(ptype,billnumber,goodstype);
		generalList=passingbillDAO.fetchServiceDetails(query);
		logger.debug("PassingBillService:fetchServiceDetails---------->");
		return generalList;
	}
	public int convertToCode(String drivername) {
		// TODO Auto-generated method stub
		ArrayList codeList=new ArrayList();
		int DRIVER_NAME=0;
		String query=generalutil.convertToCode(drivername);
		codeList=passingbillDAO.convertToCode(query);
		logger.debug("List Size"+codeList);
		for(int i=0;i<codeList.size();i++)
		{
			PassingBillVO drivercodevo=new PassingBillVO();
			drivercodevo=(PassingBillVO)codeList.get(0);
			logger.debug("list size"+codeList.size());
			DRIVER_NAME=Integer.parseInt(drivercodevo.getDriverName());
			logger.debug("driver name:"+DRIVER_NAME);
		}
		return DRIVER_NAME;
	}
	public void insertmaster(int institutionname, int billnumber, String billdate, String requesteddate, int servicename, int location, int vehiclenumber, int jobid) {
		// TODO Auto-generated method stub
		String query=util.insertmaster(jobid,institutionname,vehiclenumber,billnumber,requesteddate,location,servicename,billdate);
		passingbillDAO.insert(query);
	}
	public void insert(int jobid, int passingbillnumber, String headofaccdebit, int purchaseissue, int producttype, float amount) {
		// TODO Auto-generated method stub
		String query=util.insert(jobid,passingbillnumber,headofaccdebit,purchaseissue,producttype,amount);
		passingbillDAO.insert(query);
	}
	public void updateBillPassed(String vehiclenumber, String purchaseissue, int producttype, String servicename) {
		// TODO Auto-generated method stub
		logger.debug("PassingBillService:updateBillPassed<----------");
		String query=util.updateBillPassed(vehiclenumber,purchaseissue,producttype,servicename);
		passingbillDAO.updateBillPassed(query);
		logger.debug("PassingBillService:updateBillPassed---------->");
	}
}
