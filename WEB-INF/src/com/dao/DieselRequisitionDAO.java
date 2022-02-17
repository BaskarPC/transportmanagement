package com.dao;


import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import java.io.FileNotFoundException;
import java.sql.SQLException;
/*
* Import the required Oracle classes
*/

import org.apache.log4j.Logger;
import org.apache.struts.upload.FormFile;
import com.dbcom.dbcom;
import com.vo.DieselPurchaseVO;
import com.vo.DieselRequisitionVO;


public class DieselRequisitionDAO {
	private static final Logger logger = (Logger) Logger
			.getLogger(DieselRequisitionDAO.class);

	dbcom db = new dbcom();

	ArrayList list = null;

	public void insert(DieselRequisitionVO vo) {
		String reqdate, reqfrom;
		int tank, need;
		float current;
		reqdate = vo.getDate();
		reqfrom = vo.getFrom();
		tank = Integer.parseInt(vo.getTankCapacity());
		current = Float.parseFloat(vo.getCurrentCapacity());
		need = Integer.parseInt(vo.getQtyNeeded());
		logger.debug("insert :DieselRequisitionDAO <<<<<<<<<<<<<<< ");
		String query = "insert into DieselRequisition values(" + vo.getJobid()
				+ ",'" + reqdate + "','" + reqfrom + "'," + tank + ","
				+ current + "," + need + ")";
		db.otherQuery(query);
		logger.debug("insert :DieselRequisitionDAO : Record Inserted");
		logger.debug("insert :DieselRequisitionDAO >>>>>>>>>>>>>>> ");

	}

	public ArrayList retrieve(Integer jobid) {
		logger.debug("retrieve :DieselRequisitionDAO <<<<<<<<<<<<<<< ");
		String query = "select reqdate,reqfrom,tankcapacity,currentcapacity,neededcapacity from dieselrequisition where jobid="
				+ jobid + "";
		list = db.selectQuery("com.vo.DieselRequisitionVO", query);
		logger.debug("retrive dao :list size.." + list.size());
		DieselRequisitionVO vo = (DieselRequisitionVO) list.get(0);
		logger.debug(vo.getDate() + vo.getFrom() + vo.getTankCapacity()
				+ vo.getCurrentCapacity() + vo.getQtyNeeded());
		logger.debug("retrieve :DieselRequisitionDAO : Record Fetched");
		logger.debug("retrieve :DieselRequisitionDAO >>>>>>>>>>>>>>> ");
		return list;
	}

	public ArrayList getPetrolCompany() {
		logger.debug("getCompanyList :DieselRequisitionDAO <<<<<<<<<<<<<<< ");
		String query = "select code,description as des from store_lookup where ctype='petrolcompany'";
		list = db.selectQuery("com.vo.DieselRequisitionVO", query);
		logger.debug("getCompanyList dao :list size.." + list.size());
		DieselRequisitionVO vo = (DieselRequisitionVO) list.get(0);
		logger.debug("getCompanyList :DieselRequisitionDAO : Record Fetched");
		logger.debug("getCompanyList :DieselRequisitionDAO >>>>>>>>>>>>>>> ");
		return list;

	}
	
	

	
	public String getRole(String userName) {
		logger.debug("getRole :DieselRequisitionService <<<<<<<<<<<<<<< ");
		String query = "select user_role as role from login where user_name='"
				+ userName + "'";
		list = db.selectQuery("com.vo.DieselRequisitionVO", query);
		logger.debug("getCompanyList dao :list size.." + list.size());
		DieselRequisitionVO vo = (DieselRequisitionVO) list.get(0);
		String role = vo.getRole();
		logger.debug("getCompanyList :DieselRequisitionDAO : Record Fetched");
		logger.debug("getCompanyList :DieselRequisitionDAO >>>>>>>>>>>>>>> ");
		return role;
	}

	
	public ArrayList getBankList() {
		logger.debug("getBankList :DieselRequisitionDAO <<<<<<<<<<<<<<< ");
		String query = "select code,cdesc as des from lookup where ctype='bankname'";
		list = db.selectQuery("com.vo.DieselRequisitionVO", query);
		logger.debug("getBankList dao :list size.." + list.size());
		DieselRequisitionVO vo = (DieselRequisitionVO) list.get(0);
		logger.debug("getBankList :DieselRequisitionDAO : Record Fetched");
		logger.debug("getBankList :DieselRequisitionDAO >>>>>>>>>>>>>>> ");
		return list;
	}

	public String getRequiredLiters(int job) {
		logger
				.debug("getRequiredLiters :DieselRequisitionDAO <<<<<<<<<<<<<<< ");
		String query = "select neededcapacity as qty from dieselrequisition where jobid="
				+ job;
		list = db.selectQuery("com.vo.DieselRequisitionVO", query);
		logger.debug("getRequiredLiters dao :list size.." + list.size());
		DieselRequisitionVO vo = (DieselRequisitionVO) list.get(0);
		logger.debug("getRequiredLiters :DieselRequisitionDAO : Record Fetched"
				+ vo.getQtyNeeded());
		logger
				.debug("getRequiredLiters :DieselRequisitionDAO >>>>>>>>>>>>>>> ");
		String qty = vo.getQtyNeeded();
		return qty;
	}
   
	
	
	
	
	
	public String getCurrentCapacity() {
		logger
				.debug("getCurrentCapacity :DieselRequisitionDAO <<<<<<<<<<<<<<< ");
		String query = "select sum(told_qty+tnew_qty)as currentCapacity from common_transaction where partnumber='P1'";
		list = db.selectQuery("com.vo.DieselRequisitionVO", query);
		logger.debug("retrive dao :list size.." + list.size());
		DieselRequisitionVO vo = (DieselRequisitionVO) list.get(0);
		String qty = vo.getCurrentCapacity();
		logger.debug("Qty :" + vo.getCurrentCapacity());
		logger.debug("retrieve :DieselRequisitionDAO : Record Fetched");
		logger
				.debug("getCurrentCapacity :DieselRequisitionDAO >>>>>>>>>>>>>>> ");
		return qty;
	}
	
}

