package com.service;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.dao.ScrapDAO;

public class ScrapService {
	private static final Logger logger=(Logger)Logger.getLogger(ScrapService.class);
	
	ScrapDAO dao=new ScrapDAO();
	public ArrayList fetchInst()throws Exception
	{
		ArrayList userList=dao.fetchInst();
		logger.debug("Inside Service"+userList.size());
		return userList;
	}

	/*public ArrayList retrieve(int job) {
		// TODO Auto-generated method stub
		ArrayList list=new ArrayList();
		DieselDAO dao=new DieselDAO();
	    list=dao.retrive(job);
	    return list;
	}*/

	public ArrayList instMethod(int instname) {
		// TODO Auto-generated method stub
		ArrayList list=new ArrayList();
		list=dao.instMethod(instname);
		return list;
		
	}

	public ArrayList vehicleMethod(int vehtype) {
		// TODO Auto-generated method stub
		ArrayList list=new ArrayList();
		logger.debug("Service Called.................");
		list=dao.vehicleMethod(vehtype);
		return list;
	}

	public ArrayList fetchCategory() {
		// TODO Auto-generated method stub
		ArrayList userList=dao.fetchCategory();
		logger.debug("Inside Service"+userList.size());
		return userList;
	}

}
