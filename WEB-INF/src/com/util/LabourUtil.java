package com.util;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.dbcom.dbcom;
import com.vo.DieselVO;
import com.vo.LabourVO;

public class LabourUtil {
	private static final Logger logger=(Logger)Logger.getLogger(LabourUtil.class);
	dbcom db=new dbcom();
	LabourVO vo=new LabourVO();
	public ArrayList fetchInst()throws Exception
	{
	ArrayList list=new ArrayList();
	String query="select CDESC as CDESC,CODE as CODE from LOOKUP where CTYPE='institution'";
	list=db.selectQuery("com.vo.LabourVO",query);
	logger.debug("Inside Util"+list.size());
	return list;
	}
	
	public ArrayList fetchType() {
		// TODO Auto-generated method stub
		ArrayList list=new ArrayList();
		String query="select CDESC as TDESC,CODE as TCODE from LOOKUP where CTYPE='vehicletype'";
		list=db.selectQuery("com.vo.LabourVO",query);
		return list;
		}

	public ArrayList fetchVehicle() {
	// TODO Auto-generated method stub
	ArrayList list=new ArrayList();
	String query="select CDESC as VDESC,CODE as VCODE from LOOKUP where CTYPE='vehiclenumber'";
	list=db.selectQuery("com.vo.LabourVO",query);
	return list;
	}
	public ArrayList instMethod(int instname) {
		// TODO Auto-generated method stub
		ArrayList list=new ArrayList();
		String query="select CDESC as TDESC,CODE as TCODE from LOOKUP where CODE in (select distinct(vehicletype) as vehtype from vehicle where INSTNAME="+instname+")";
		list=db.selectQuery("com.vo.LabourVO",query);
		return list;
	}

	public ArrayList vehicleMethod(int vehtype) {
		// TODO Auto-generated method stub
		ArrayList list=new ArrayList();
		String query="select CDESC as VDESC,CODE as VCODE from LOOKUP where CODE in (select distinct(VEHICLEID) as vehtype from vehicle where VEHICLETYPE="+vehtype+")";
		list=db.selectQuery("com.vo.LabourVO",query);
		return list;
	}
	public void insertmaster(int jobid, int INSTITUTION_NAME, int VEHICLE_TYPE, int VEHICLE_NUMBER, String REQ_DATE) {
		// TODO Auto-generated method stub
		String query1="insert into MAINTENANCE_MASTER values("+INSTITUTION_NAME+","+VEHICLE_TYPE+","+VEHICLE_NUMBER+",0,'"+REQ_DATE+"','1-MAR-99',0,0,0,'','','','','','',"+jobid+",6)";
		db.otherQuery(query1);
	}
	
	public void insert(int jobid, float AMOUNT,String NOW, String OTHER_PURPOSE) {
		// TODO Auto-generated method stub
		String query="insert into FCSMOKE_LABOURCHARGE values("+jobid+",'"+NOW+"','"+OTHER_PURPOSE+"',"+AMOUNT+")";
		db.otherQuery(query);
	}

	public ArrayList fetchLabour() {
		// TODO Auto-generated method stub
		ArrayList list=new ArrayList();
		String query="select CDESC as LDESC,CODE as LCODE from LOOKUP where CTYPE='natureofwork'";
		list=db.selectQuery("com.vo.LabourVO",query);
		logger.debug("Inside Util"+list.size());
		return list;
	}
	public ArrayList retrieveMaster(int job) {
		// TODO Auto-generated method stub
		ArrayList list=new ArrayList();
		String query="select INSTITUTION_NAME,VEHICLE_TYPE,VEHICLE_NUMBER,REQ_DATE FROM MAINTENANCE_MASTER WHERE JOB_ID="+job+"";
		list=db.selectQuery("com.vo.LabourVO",query);
		logger.debug("Inside Util"+list.size());
		DieselVO dvo=new DieselVO();
		
		return list;
	}
	
	public ArrayList retrieve(int job) {
		// TODO Auto-generated method stub
		ArrayList list=new ArrayList();
		String query="select AMOUNT,NOW,OTHER_WORK from FCSMOKE_LABOURCHARGE WHERE JOB_ID ="+job+"";
		list=db.selectQuery("com.vo.LabourVO",query);
		logger.debug("Inside Util"+list.size());
		return list;
	}


}
