package com.dao;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.dbcom.dbcom;
import com.util.ScrapUtil;

public class ScrapDAO {
	private static final Logger logger=(Logger)Logger.getLogger(ScrapDAO.class);
	dbcom db=new dbcom();
	ScrapUtil util=new ScrapUtil();
	public ArrayList fetchInst()throws Exception
	{
		ArrayList list=new ArrayList();
		list=util.fetchInst();
		logger.debug("Inside DAO"+list.size());
		return list;
	}

	/*public void insert(int jobid, int qty_wanted, int iqty_old, int iqty_new, float urate_old, float urate_new, float amount, int presentkm, int last_km, int diff_km, float avg_km, String remarks, int stock, int open_reading, int close_reading, int balance, int consumtion_liters) {
		// TODO Auto-generated method stub
		ScrapUtil util=new ScrapUtil();
		util.insert(jobid,qty_wanted,iqty_old,iqty_new,urate_old,urate_new,amount,presentkm,last_km,diff_km,avg_km,remarks,stock,open_reading,close_reading,balance,consumtion_liters);
	}
	
	public ArrayList retrive(int job) {
		// TODO Auto-generated method stub
		ArrayList list=new ArrayList();
		ScrapUtil util=new ScrapUtil();
		list=util.retrieve(job);
		logger.debug("Inside DAO"+list.size());
		return list;
	}*/
	
	public ArrayList instMethod(int instname) {
		// TODO Auto-generated method stub
		ArrayList list=new ArrayList();
		list=util.instMethod(instname);
		return list;
	}
	public ArrayList vehicleMethod(int vehtype) {
		// TODO Auto-generated method stub
		ArrayList list=new ArrayList();
		logger.debug("DAO Called.................");
		list=util.vehicleMethod(vehtype);
		return list;
	}

	public ArrayList fetchCategory() {
		// TODO Auto-generated method stub
		ArrayList list=new ArrayList();
		list=util.fetchCategory();
		logger.debug("Inside DAO"+list.size());
		return list;
	}

}
