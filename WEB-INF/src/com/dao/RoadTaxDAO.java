package com.dao;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import com.util.OperationsGeneralLookupUtil;
import com.vo.RoadTaxVO;
import com.formbean.RoadTaxForm;
import com.util.RoadTaxUtil;
import com.dbcom.dbcom;

public class RoadTaxDAO {
	private static final Logger logger=(Logger)Logger.getLogger(RoadTaxDAO.class);
	dbcom db=new dbcom();
	RoadTaxForm rtf=new RoadTaxForm();
	ArrayList list=new ArrayList();
	OperationsGeneralLookupUtil operationsutil =new OperationsGeneralLookupUtil();
	RoadTaxVO vo=new RoadTaxVO();   
	RoadTaxUtil util=new RoadTaxUtil();

public ArrayList instcombo(RoadTaxVO vo) {
	// TODO Auto-generated method stub
	  String query=operationsutil.institutionQuery();
	  list=db.selectQuery("com.vo.RoadTaxVO", query);
	  return list;
}

public ArrayList vehicleidcombo(String typename, String instname) {
	// TODO Auto-generated method stub
	String query="select CODE as VEHICLEIDCODE,CDESC as VEHICLEIDDESC from LOOKUP where CODE in( select distinct(VEHICLE_ID) from VEHICLE_PURCHASE where VEHICLE_TYPE="+typename+" and INSTITUTION="+instname+")";
	list=db.selectQuery("com.vo.RoadTaxVO", query);
	return list;
}

public ArrayList vehicletypecombo(String instname) {
	// TODO Auto-generated method stub
	String query="select CODE as VEHICLETYPECODE,CDESC as VEHICLETYPEDESC from LOOKUP where CODE in( select distinct(VEHICLE_TYPE) from VEHICLE_PURCHASE where INSTITUTION='"+instname+"')";
	list=db.selectQuery("com.vo.RoadTaxVO", query);
	 return list;
}

public ArrayList periodcombo(RoadTaxVO vo) {
	// TODO Auto-generated method stub
	 String query=operationsutil.periodQuery();
	  list=db.selectQuery("com.vo.RoadTaxVO", query);
	 return list;
}

public ArrayList optioncombo(RoadTaxVO vo) {
	// TODO Auto-generated method stub
	 String query=operationsutil.optionQuery();
	  list=db.selectQuery("com.vo.RoadTaxVO", query);
	  return list;
}

public void saveintodb(RoadTaxVO vo) {
	// TODO Auto-generated method stub
	 util.saveintodb(vo);
/*	db.otherQuery("insert into ROAD_TAX values("+vo.getInstituteName()+","+vo.getVehicleType()+","+vo.getVehicleId()+","+vo.getSeatCapacity()+","+vo.getRatePerSeat()+","+vo.getTaxAmt()+","+vo.getRoadTaxPeriod()+","+vo.getYesNoOption()+","+vo.getPercentOfReduction()+","+vo.getReductionAmt()+","+vo.getTotalAmtAfterReduction()+","+vo.getSubTaxPercent()+","+vo.getSubTaxAmt()+","+vo.getGrandTotal()+",'N')"); */
}

public ArrayList retrieve(int id) {
	// TODO Auto-generated method stub
	
	list=util.retrieveall(id);
	
/*	String query="select SEAT_CAPACITY,RATE_PER_SEAT,TAX_AMT,TAX_PERIOD,REDUCTION_ALLOWED,REDUCTION_PERCENTAGE, REDUCTION_AMOUNT,GROSS_AMT,SUBCHARGE_PERCENTAGE,SUBCHARGE_AMT,GRAND_TOTAL from ROAD_TAX where VEHICLE_ID="+id+" AND DEL_IND='N'";
	 list=db.selectQuery("com.vo.RoadTaxVO", query);
	 logger.debug("array size of retrieve in DAO.."+list.size());
	  for(int i=0;i<list.size();i++)
	 {
	  vo=(RoadTaxVO)list.get(i);
	  logger.debug("vo.getseatcapacity:"+vo.getSeatCapacity());
	 }*/
	return list;
}

public ArrayList vehicleidretrieve() {
	// TODO Aut-generated method stub
	list=util.vehicleidretrieve();
	return list;
}

public ArrayList formvehicleid(int id) {
	// TODO Auto-generated method stub
	list=util.formvehicleid(id);
	return list;
}

public void update(RoadTaxVO vo, String vehicleId) {
	// TODO Auto-generated method stub
	util.update(vo,vehicleId);
}
}
