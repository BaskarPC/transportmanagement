package com.util;
import java.util.ArrayList;
import com.dbcom.dbcom;
import com.vo.RoadTaxVO;

import org.apache.log4j.Logger;
public class RoadTaxUtil {
	private static final Logger logger=(Logger)Logger.getLogger(RoadTaxUtil.class);
	dbcom db=new dbcom();
	String vofile="com.vo.RoadTaxVO";
	ArrayList list=new ArrayList();
	RoadTaxVO vo=new RoadTaxVO();
	
	public ArrayList vehicleidretrieve() {
		// TODO Auto-generated method stub
		String query="select CDESC as VEHICLEIDDESC from LOOKUP where CODE IN(select distinct(VEHICLE_ID) from ROAD_TAX)";
		list=db.selectQuery(vofile, query);
		logger.debug("vehicleid size in util"+list.size());
		for(int i=0;i<list.size();i++)
		{
			vo=(RoadTaxVO)list.get(i);
			logger.debug("vehicleid in util"+vo.getVehicleiddesc());
		}
		return list;
	}
	
	public ArrayList formvehicleid(int id) {
		// TODO Auto-generated method stub
		String query="select CDESC as VEHICLEIDDESC from LOOKUP where CODE='"+id+"'";
		list=db.selectQuery(vofile, query);
		logger.debug("size of vehicleid of form in util"+list.size());
		return list;
	}
	
	public void update(RoadTaxVO vo, String vehicleId) {
		// TODO Auto-generated method stub
		db.otherQuery("UPDATE ROAD_TAX SET INSTITUTE_NAME="+vo.getInstituteName()+",VEHICLE_TYPE="+vo.getVehicleType()+",SEAT_CAPACITY="+vo.getSeatCapacity()+",RATE_PER_SEAT="+vo.getRatePerSeat()+",TAX_AMT="+vo.getTaxAmt()+",TAX_PERIOD="+vo.getRoadTaxPeriod()+",REDUCTION_ALLOWED="+vo.getYesNoOption()+",REDUCTION_PERCENTAGE="+vo.getPercentOfReduction()+",REDUCTION_AMOUNT="+vo.getReductionAmt()+",GROSS_AMT="+vo.getTotalAmtAfterReduction()+",SUBCHARGE_PERCENTAGE="+vo.getSubTaxPercent()+",SUBCHARGE_AMT="+vo.getSubTaxAmt()+",GRAND_TOTAL="+vo.getGrandTotal()+" where VEHICLE_ID="+vehicleId+"");
	}
	
	public void saveintodb(RoadTaxVO vo) {
		// TODO Auto-generated method stub
		db.otherQuery("insert into ROAD_TAX values("+vo.getInstituteName()+","+vo.getVehicleType()+","+vo.getVehicleId()+","+vo.getSeatCapacity()+","+vo.getRatePerSeat()+","+vo.getTaxAmt()+","+vo.getRoadTaxPeriod()+","+vo.getYesNoOption()+","+vo.getPercentOfReduction()+","+vo.getReductionAmt()+","+vo.getTotalAmtAfterReduction()+","+vo.getSubTaxPercent()+","+vo.getSubTaxAmt()+","+vo.getGrandTotal()+",'N')");
	}
	
	public ArrayList retrieveall(int id) {
		// TODO Auto-generated method stub
		String query="select SEAT_CAPACITY,RATE_PER_SEAT,TAX_AMT,TAX_PERIOD,REDUCTION_ALLOWED,REDUCTION_PERCENTAGE, REDUCTION_AMOUNT,GROSS_AMT,SUBCHARGE_PERCENTAGE,SUBCHARGE_AMT,GRAND_TOTAL from ROAD_TAX where VEHICLE_ID="+id+" AND DEL_IND='N'";
		 list=db.selectQuery("com.vo.RoadTaxVO", query);
		 logger.debug("array size of retrieve in DAO.."+list.size());
		  for(int i=0;i<list.size();i++)
		 {
		  vo=(RoadTaxVO)list.get(i);
		  logger.debug("vo.getseatcapacity:"+vo.getSeatCapacity());
		 }
		return list;
	}
}
