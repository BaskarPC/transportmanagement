package com.util;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.dbcom.dbcom;
import com.vo.ScrapVO;

public class ScrapUtil {
	private static final Logger logger=(Logger)Logger.getLogger(ScrapUtil.class);
	dbcom db=new dbcom();
	ScrapVO vo=new ScrapVO();
	public ArrayList fetchInst()throws Exception
	{
	ArrayList list=new ArrayList();
	String query="select CDESC as CDESC,CODE as CODE from LOOKUP where CTYPE='institution'";
	list=db.selectQuery("com.vo.ScrapVO",query);
	return list;
	}
	
	public ArrayList instMethod(int instname) {
		// TODO Auto-generated method stub
		ArrayList list=new ArrayList();
		ScrapVO vo=new ScrapVO();
		String query="select CDESC as TDESC,CODE as TCODE from LOOKUP where CODE in (select distinct(vehicletype) as vehtype from vehicle where INSTNAME="+instname+")";
		list=db.selectQuery("com.vo.ScrapVO",query);
		return list;
	}
	
	public ArrayList vehicleMethod(int vehtype) {
		// TODO Auto-generated method stub
		logger.debug("Util Called.................");
		ArrayList list=new ArrayList();
		String query="select CDESC as VDESC,CODE as VCODE from LOOKUP where CODE in (select distinct(VEHICLEID) as vehtype from vehicle where VEHICLETYPE="+vehtype+")";
		list=db.selectQuery("com.vo.ScrapVO",query);
		logger.debug("List Size:"+list.size());
		return list;
	}

	public ArrayList fetchCategory() {
		// TODO Auto-generated method stub
		ArrayList list=new ArrayList();
		String query="select CDESC as SDESC,CODE as SCODE from LOOKUP where CTYPE='category'";
		list=db.selectQuery("com.vo.ScrapVO",query);
		logger.debug("Inside Util"+list.size());
		return list;
	}
	
}
