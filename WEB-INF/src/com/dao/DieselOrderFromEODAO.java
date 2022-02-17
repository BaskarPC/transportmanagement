package com.dao;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import sun.security.action.GetBooleanAction;

import com.dbcom.dbcom;
import com.vo.DieselOrderFromEOVO;
import com.vo.DieselRequisitionVO;


public class DieselOrderFromEODAO {
	private static final Logger logger=(Logger)Logger.getLogger(DieselOrderFromEODAO.class);
	dbcom db=new dbcom();
	ArrayList list=null;
	public void insert(DieselOrderFromEOVO vo)
	{
		String reqdate,reqfrom,company,bank;
		int job,reqliters,checkno,amount;
		float c;
		reqdate=vo.getDate();
		reqfrom=vo.getFrom();
		company=vo.getCompanyName();	
		reqliters=Integer.parseInt(vo.getRequiredLiters());
		checkno=Integer.parseInt(vo.getCheckNo());
		bank=vo.getBankName();
		amount=Integer.parseInt(vo.getAmount());
		logger.debug("insert :DieselOrderFromEODAO <<<<<<<<<<<<<<< ");
		String query="insert into DieselOrder values("+vo.getJobid()+",'"+ reqdate+"','"+reqfrom+"','"+company+"',"+reqliters+","+checkno+",'"+bank+"',"+amount+")";
		db.otherQuery(query);
		logger.debug("insert :DieselOrderFromEODAO : Record Inserted");
		logger.debug("insert :DieselOrderFromEODAO >>>>>>>>>>>>>>> ");
		
	}
	public ArrayList retrieve(Integer jobid)
	{
		logger.debug("retrieve :DieselOrderFromEODAO <<<<<<<<<<<<<<< ");
		String query="select reqdate as orderdate,reqfrom as orderfrom,company_name as ordercompany,reqliters as orderliters,checkno as ordercheckno,bank_name as orderbank,amount as orderamount from dieselorder where jobid="+jobid+"";
		list=db.selectQuery("com.vo.DieselOrderFromEOVO",query);
		logger.debug("retrive dao :list size.."+list.size());
		DieselOrderFromEOVO vo=(DieselOrderFromEOVO)list.get(0);
		logger.debug(vo.getDate()+vo.getFrom());		
		logger.debug("retrieve :DieselOrderFromEODAO : Record Fetched");
		logger.debug("retrieve :DieselOrderFromEODAO >>>>>>>>>>>>>>> ");
		return list;
	}
}
