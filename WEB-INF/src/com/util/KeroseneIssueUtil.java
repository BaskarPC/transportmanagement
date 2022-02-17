package com.util;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.dao.KeroseneIssueDAO;
import com.dbcom.dbcom;
import com.service.KeroseneIssueService;
import com.vo.KeroseneIssueVO;

public class KeroseneIssueUtil {
	private static final Logger logger=(Logger)Logger.getLogger(KeroseneIssueDAO.class);
	ArrayList instList=new ArrayList();
	dbcom db=new dbcom();
	 String vofile="com.vo.KeroseneIssueVO";
	 
	public void insertValues(KeroseneIssueVO kvo,int jobid)
	{   
		String query="insert into maintenance_master values("+Integer.parseInt(kvo.getInstitutionName())+","+Integer.parseInt(kvo.getVehicleType())+","+Integer.parseInt(kvo.getVehicleNumber())+","+Integer.parseInt(kvo.getBillNumber())+",SYSDATE,SYSDATE,"+Integer.parseInt(kvo.getDriverName())+","+Integer.parseInt(kvo.getRequestedDriverName())+","+Integer.parseInt(kvo.getBillNumber())+",'"+kvo.getOtherPurpose()+"','"+kvo.getOtherPurpose()+"',"+Integer.parseInt(kvo.getCurrentKm())+","+Integer.parseInt(kvo.getBillNumber())+","+Integer.parseInt(kvo.getBillNumber())+",'n',"+jobid+","+jobid+")";
		db.otherQuery(query);
		logger.debug("insert executed");
		String query1="insert into GREASEOIL_KEROSENE values("+jobid+","+jobid+",7,"+jobid+","+Integer.parseInt(kvo.getTotalAvailableQuantity())+","+Integer.parseInt(kvo.getRequiredQuantity())+","+Integer.parseInt(kvo.getOldAvailable())+","+Integer.parseInt(kvo.getNewAvailable())+","+Float.parseFloat(kvo.getOldRate())+","+Float.parseFloat(kvo.getNewRate())+","+Float.parseFloat(kvo.getTotalAmount())+","+Integer.parseInt(kvo.getKeroseneReason())+","+Integer.parseInt(kvo.getCurrentKm())+","+Integer.parseInt(kvo.getCurrentKm())+","+Integer.parseInt(kvo.getCurrentKm())+")";
		db.otherQuery(query1);
		logger.debug("second insert executed");
		
	}
	public ArrayList fetchValues(int jobid)
	{   
		String query="select INSTITUTION_NAME as institutionName,VEHICLE_TYPE as vehicleType,VEHICLE_NUMBER AS VEHNUMBER,BILL_NUMBER as billNumber,DRIVER_NAME as driverName,REQ_DRIVERNAME as reqdriver,OTHER_REASON as otherreason,AVAILABLE_QTY as available,QTY_WANTED as quantitywant, IQTY_OLD as oldwant, IQTY_NEW as newwant,URATE_OLD as oldrate,URATE_NEW as newrate,AMOUNT as totamount,REASON_REQ as requiredreas,CURRENT_KM as currentkm from MAINTENANCE_MASTER m,GREASEOIL_KEROSENE g where g.JOB_ID=m.JOB_ID and g.JOB_ID="+jobid+"";
		instList=db.selectQuery(vofile,query);
		logger.debug("institution list size="+instList.size());
		return instList;
	}
}
