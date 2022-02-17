package com.util;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.dao.WasteDAO;
import com.dbcom.dbcom;
import com.vo.KeroseneIssueVO;
import com.vo.WasteVO;

public class WasteUtil {
	private static final Logger logger=(Logger)Logger.getLogger(WasteUtil.class);
	ArrayList instList=new ArrayList();
	dbcom db=new dbcom();
	 String vofile="com.vo.WasteVO";
	 
	public ArrayList fetchWasteReason()
	{   
		String query="select id as GREASEREASONID,codetype as GREASEREASONTYPE,codedesc as GREASEREASONDESC from MAINTENANCE_REASON_LOOKUP where codetype='WASTE_CLOTH'";
		instList=db.selectQuery("com.vo.KeroseneIssueVO",query);
		logger.debug("institution list size="+instList.size());
		return instList;
	}
	public void insertValues(WasteVO kvo,int jobid)
	{   
		String query="insert into maintenance_master values("+Integer.parseInt(kvo.getInstitutionName())+","+Integer.parseInt(kvo.getVehicleType())+","+Integer.parseInt(kvo.getVehicleNumber())+","+Integer.parseInt(kvo.getBillNumber())+",SYSDATE,SYSDATE,"+Integer.parseInt(kvo.getDriverName())+","+Integer.parseInt(kvo.getRequestedDriverName())+",0,'"+kvo.getOtherPurpose()+"','null',0,0,0,'n',"+jobid+","+jobid+")";
		db.otherQuery(query);
		logger.debug("insert executed");
		String query1="insert into GREASEOIL_KEROSENE values("+jobid+","+jobid+",3,"+jobid+","+Integer.parseInt(kvo.getTotalAvailableQuantity())+","+Integer.parseInt(kvo.getRequiredQuantity())+","+Integer.parseInt(kvo.getOldAvailable())+","+Integer.parseInt(kvo.getNewAvailable())+","+Float.parseFloat(kvo.getOldRate())+","+Float.parseFloat(kvo.getNewRate())+","+Float.parseFloat(kvo.getTotalAmount())+","+Integer.parseInt(kvo.getWasteReason())+",0,0,0)";
		db.otherQuery(query1);
		logger.debug("second insert executed");
		
	}
	
}
