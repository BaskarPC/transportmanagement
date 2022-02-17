package com.util;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import com.vo.Accidentvo;
import com.vo.VehicleVo;
import com.dbcom.dbcom;

public class AccidentDetailsUtil {
dbcom db=new dbcom();
ArrayList list=new ArrayList();
String vofile="com.vo.Accidentvo";
Accidentvo vo1=new Accidentvo();
Accidentvo vo=new Accidentvo();

private static final Logger logger=(Logger)Logger.getLogger(AccidentDetailsUtil.class);

	public void save(Accidentvo vo) {
		// TODO Auto-generated method stub
		logger.debug("value in drivername"+vo.getDriverName());
		if(vo.getCaseOption().equals(" "))
		{
			vo.setCaseOption("0");
		}
		if(vo.getInstituteName().equals(" "))
		{
			vo.setInstituteName("0");
		}
		
		String query="select CODE as DRIVERCODE from LOOKUP where CDESC='"+vo.getDriverName()+"'";
		list=db.selectQuery(vofile, query);
		vo1=(Accidentvo)list.get(0);
		logger.debug("driver name in util"+vo1.getDrivercode());		
		db.otherQuery("insert into ACCIDENT_DETAILS values('"+vo.getAccidentDate()+"','"+vo.getAccidentTime()+"','"+vo.getAccidentPlace()+"','"+vo.getNearByPoliceStation()+"',"+vo.getVehicleId()+","+vo.getVehicleType()+","+vo.getInstituteName1()+","+vo.getDriverId()+","+vo1.getDrivercode()+",'"+vo.getOpponentVehicleId()+"','"+vo.getOpponentVehicleType()+"',"+vo.getNoOfPersonsInjured()+","+vo.getFIROption()+","+vo.getCaseOption()+","+vo.getInsuranceOption()+","+vo.getAmtClaimedFromInsurance()+","+vo.getAmtClaimedFromOpponent()+","+vo.getDriverPaid()+","+vo.getInstituteName()+","+vo.getAmtPaidByInstitute()+",'"+vo.getAccidentDesc()+"',"+vo.getExpense()+")");
	}

	public ArrayList vehicletyperetrieve(int instid) {
		// TODO Auto-generated method stub
		String query="select CODE as VEHICLETYPECODE,CDESC as VEHICLETYPEDESC from LOOKUP where CODE in (select distinct(VEHICLE_TYPE) from VEHICLE_PURCHASE where INSTITUTE_NAME='"+instid+"' AND DEL_IND='N')";
		list=db.selectQuery(vofile, query);
		return list;
	}

	public ArrayList vehicleidretrieve(int vehicletype) {
		// TODO Auto-generated method stub
		String query="select CODE as VEHICLEIDCODE,CDESC as VEHICLEIDDESC from LOOKUP where CODE in( select distinct(VEHICLE_ID) from VEHICLE_PURCHASE where VEHICLE_TYPE='"+vehicletype+"' AND DEL_IND='N')";
		list=db.selectQuery(vofile, query);
		return list;
	}

	public ArrayList drivernameretrieve(int id) {
		// TODO Auto-generated method stub
		String query="select CODE as DRIVERCODE,CDESC as DRIVER_NAME from LOOKUP where CODE in(select distinct(DRIVER_NAME)from DRIVER_PERSONAL where DRIVER_ID='"+id+"' AND DEL_IND='N')";
		list=db.selectQuery(vofile, query);
		return list;
	}

	public ArrayList retrieveall() {
		// TODO Auto-generated method stub
		String query="select CDESC as VEHICLEIDDESC from LOOKUP where CODE in(select VEHICLE_ID from VEHICLE_PURCHASE)";
		list=db.selectQuery(vofile, query);
		logger.debug("arraysize in util for retrieveall"+list.size());
		for(int i=0;i<list.size();i++)
		{
			vo=(Accidentvo)list.get(i);
			logger.debug("values in util"+vo.getVehicleiddesc());
		}
		return list;
	}

	public ArrayList formvehicleid(int id) {
		// TODO Auto-generated method stub
		String query="select CDESC as VEHICLEIDDESC from LOOKUP where CODE="+id+"";
		list=db.selectQuery(vofile, query);
		return list;
	}

	public ArrayList retrieve(int id) {
		// TODO Auto-generated method stub
		String query="select ACCIDENT_DATE as AACCIDENT_DATE,ACCIDENT_TIME AS AACCIDENT_TIME,ACCIDENT_PLACE as AACCIDENT_PLACE,NEAR_POLICE_STATION as ANEAR_POLICE_STATION,VEHICLE_ID as AVEHICLE_ID,VEHICLE_TYPE as AVEHICLE_TYPE,INSTITUTION,DRIVER_ID as ADRIVER_ID,DRIVER_NAME as ADRIVER_NAME,OPPONENT_VEHICLE_ID,OPPONENT_VEHICLE_TYPE,PERSONS_INJURED,FIR_FILED,CASE_CLOSED,INSURANCE_CLAIMED,AMT_FROM_INSURANCE,AMT_FROM_OPPONENT,DRIVER_PAID,INSTITUTE_NAME as AINST,INSTITUTE_PAID,ACCIDENT_DESC,EXPENSES from ACCIDENT_DETAILS where VEHICLE_ID="+id+"" ;
		list=db.selectQuery(vofile, query);
		for(int i=0;i<list.size();i++)
		{
		vo=(Accidentvo)list.get(i);
	    }
		return list;
	}

	public ArrayList drivernamedesc(int did) {
		// TODO Auto-generated method stub
		String query="select CDESC as DRIVERNAMEDESC from LOOKUP where CODE="+did+"";
		list=db.selectQuery(vofile, query);
		return list;
	}

	public ArrayList expensedesc(int expense) {
		// TODO Auto-generated method stub
		String query="select CDESC as EXPENSEDESC from LOOKUP where CODE="+expense+"";
		list=db.selectQuery(vofile, query);
		return list;
	}

}
