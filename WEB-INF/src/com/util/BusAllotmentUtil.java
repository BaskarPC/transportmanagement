package com.util;

import java.util.ArrayList;
import org.apache.log4j.Logger;
import com.vo.BusAllotmentVO;
import com.dbcom.dbcom;

public class BusAllotmentUtil{
	dbcom db=new dbcom();
	String vofile="com.vo.BusAllotmentVO";
	private static final Logger logger=(Logger)Logger.getLogger(BusAllotmentUtil.class);
	ArrayList list=new ArrayList();
	
	public void update(BusAllotmentVO vo, String vehicleId) {
		// TODO Auto-generated method stub
		db.otherQuery("UPDATE BUS_ALLOTMENT SET INSTITUTE_NAME="+vo.getInstituteName()+",DRIVER_ID="+vo.getDriverId()+",DRIVER_NAME="+vo.getDriverName()+",VEHICLE_ALLOTED_DATE='"+vo.getVehicleAllottedDate()+"',ROUTE_NO="+vo.getRouteNo()+",KM_PERDAY="+vo.getKmTravelledPerDay()+",STARTING_PLACE='"+vo.getStartPlace()+"',VIA='"+vo.getVia()+"',LAST_STOP='"+vo.getLastStop()+"',HALT_PLACE='"+vo.getHaltPlace()+"',HALT_RES_PHONENO='"+vo.getResidentialNo()+"',HALT_OFFICE_PHONENO="+vo.getOfficeNo()+",PERMITTED_DISTRICT='"+vo.getPermittedDistrict()+"' where VEHICLE_ID="+vehicleId+"");
	}

	public void updateother(BusAllotmentVO vo, String vehicleId) {
		// TODO Auto-generated method stub
		db.otherQuery("UPDATE BUS_ALLOTMENT SET INSTITUTE_NAME="+vo.getInstituteName()+",DRIVER_ID="+vo.getDriverId()+",DRIVER_NAME="+vo.getDriverName()+",VEHICLE_ALLOTED_DATE='"+vo.getVehicleAllottedDate()+"' where VEHICLE_ID="+vehicleId+"");
	}

	public ArrayList vehicleretrieve(String str) {
		// TODO Auto-generated method stub
		String query="select CODE as VEHICLEIDCODE,CDESC as VEHICLEIDDESC from LOOKUP where CODE in( select distinct(VEHICLE_ID) from VEHICLE_PURCHASE where VEHICLE_TYPE='"+str+"')";
		list=db.selectQuery(vofile, query);
		return list;
	}

	public ArrayList nameretrieve(int id) {
		// TODO Auto-generated method stub
		String query="select CODE as DRIVERCODE,CDESC as DRIVER_NAME from LOOKUP where CODE in(select distinct(DRIVER_NAME)from DRIVER_PERSONAL where DRIVER_ID='"+id+"' AND DEL_IND='N')";
		list=db.selectQuery(vofile, query);
		return list;
	}

	public void insert(BusAllotmentVO vo) {
		// TODO Auto-generated method stub
		BusAllotmentVO vo1=new BusAllotmentVO(); 
		String query="select CODE as DRIVER_NAME from LOOKUP where CDESC='"+vo.getDriverName()+"'";
		list=db.selectQuery(vofile, query);
		for(int i=0;i<list.size();i++)
		{
		vo1=(BusAllotmentVO)list.get(i);
		}
		db.otherQuery("insert into BUS_ALLOTMENT values("+vo.getInstituteName()+","+vo.getVehicleId()+","+vo.getDriverId()+","+vo1.getDriverName()+",'"+vo.getVehicleAllottedDate()+"','"+vo.getRouteNo()+"',"+vo.getKmTravelledPerDay()+",'"+vo.getStartPlace()+"','"+vo.getVia()+"','"+vo.getLastStop()+"','"+vo.getHaltPlace()+"',"+vo.getResidentialNo()+","+vo.getOfficeNo()+",'"+vo.getPermittedDistrict()+"','N',"+vo.getVehicleType()+")");
	}

	public ArrayList retrieve(int id) {
		// TODO Auto-generated method stub
		String query="select DRIVER_ID,DRIVER_NAME,VEHICLE_ALLOTED_DATE,ROUTE_NO,KM_PERDAY,STARTING_PLACE,VIA,LAST_STOP,HALT_PLACE,HALT_RES_PHONENO,HALT_OFFICE_PHONENO from BUS_ALLOTMENT where VEHICLE_ID='"+id+"' AND DEL_IND='N'";
		list=db.selectQuery(vofile, query);
		return list;
	}

	public void deleteind(int id) {
		// TODO Auto-generated method stub
		String query="UPDATE BUS_ALLOTMENT SET DEL_IND='Y' where DRIVER_ID='"+id+"'";
		db.otherQuery(query);
	}

	public ArrayList vehicletyperetrieve(String str) {
		// TODO Auto-generated method stub
		String query="select CODE as VEHICLETYPECODE,CDESC as VEHICLETYPEDESC from LOOKUP where CODE in (select distinct(VEHICLE_TYPE) from VEHICLE_PURCHASE where INSTITUTE_NAME='"+str+"')";
		list=db.selectQuery(vofile, query);
		return list;
	}

	public ArrayList retrieveall() {
		// TODO Auto-generated method stub
		String query="select CDESC as VEHICLEIDDESC from LOOKUP where CODE IN(select distinct(VEHICLE_ID) from BUS_ALLOTMENT)";
		list=db.selectQuery(vofile, query);
		return list;
	}

	public ArrayList vehicleidretrieve(int vehicleId) {
		// TODO Auto-generated method stub
		String query="select CDESC as VEHICLEIDDESC from LOOKUP where CODE='"+vehicleId+"'";
		list=db.selectQuery(vofile, query);
		return list;
	}

	public ArrayList drivernamedesc(int drivername) {
		// TODO Auto-generated method stub
		String query="select CDESC as DRIVERNAMEDESC from LOOKUP where CODE="+drivername+"";
		list=db.selectQuery(vofile, query);
		return list;
	}

	public void insertother(BusAllotmentVO vo) {
		// TODO Auto-generated method stub
		BusAllotmentVO vo1=new BusAllotmentVO(); 
		String query="select CODE as DRIVER_NAME from LOOKUP where CDESC='"+vo.getDriverName()+"'";
		list=db.selectQuery(vofile, query);
		for(int i=0;i<list.size();i++)
		{
		vo1=(BusAllotmentVO)list.get(i);
		}
		db.otherQuery("insert into BUS_ALLOTMENT values("+vo.getInstituteName()+","+vo.getVehicleId()+","+vo.getDriverId()+","+vo1.getDriverName()+",'"+vo.getVehicleAllottedDate()+"','','','','','','','','','','N','"+vo.getVehicleType()+"')");
	}		
}
