package com.util;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import com.vo.BreakDownVO;
import com.dbcom.dbcom;
public class BreakDownUtil {
	private static final Logger logger=(Logger)Logger.getLogger(BreakDownUtil.class);
	dbcom db=new dbcom();
	String vofile="com.vo.BreakDownVO";
	ArrayList list=new ArrayList();
	BreakDownVO vo=new BreakDownVO(); 
	
	public ArrayList retrieveall(int id) {
		// TODO Auto-generated method stub
		String query="select DRIVER_ID,DRIVER_NAME,BREAKDOWN_DATE,BREAKDOWN_TIME,BREAKDOWN_PLACE,BREAKDOWN_NATURE,ALTERNATE_VEHICLE_ID,ALTERNATE_DRIVER_ID,ALTERNATE_DRIVER_NAME,REMARKS as BRREMARKS from BREAKDOWN_DETAILS where VEHICLE_ID='"+id+"'";
		list=db.selectQuery(vofile, query);
		logger.debug("arraylist size of retrieve in util"+list.size());
		return list;
	}

	public ArrayList vehicleidretrieve(int id) {
		// TODO Auto-generated method stub
		String query="select CDESC as VEHICLEIDDESC from LOOKUP where CODE in(select VEHICLE_ID from BREAKDOWN_DETAILS)";
		list=db.selectQuery(vofile, query);
		logger.debug("list size of vehicleid retrieve in util"+list.size());
		return list;
	}

	public ArrayList formretrieve(int id) {
		// TODO Auto-generated method stub
		String query="select CDESC as VEHICLEIDDESC from LOOKUP where CODE='"+id+"'";
		list=db.selectQuery(vofile, query);
		vo=(BreakDownVO)list.get(0);
		logger.debug("form vehicleid desc in util"+vo.getVehicleiddesc());
		return list;		
	}

	public ArrayList drivernameretrieve(int drivername) {
		// TODO Auto-generated method stub
		String query="select CDESC as DRIVER_NAME from LOOKUP where CODE='"+drivername+"'";
		list=db.selectQuery(vofile, query);
		return list;
	}

	public ArrayList alterdriver(int alterdriver) {
		// TODO Auto-generated method stub
		String query="select CDESC as ALTERNATE_DRIVER_NAME from LOOKUP where CODE='"+alterdriver+"'";
		
		list=db.selectQuery(vofile, query);
		logger.debug("arraylist size in util for alterdrivername"+list.size());
		vo=(BreakDownVO)list.get(0);
		logger.debug("alter driver name in util"+vo.getAlternateBusDriverName());
		return list;
	}

	public ArrayList alterbus(int alterbus) {
		// TODO Auto-generated method stub
		String query ="select CDESC as ALTERNATE_VEHICLE_ID from LOOKUP where CODE='"+alterbus+"'";
		list=db.selectQuery(vofile, query);
		logger.debug("size of alternate bus id in util"+list.size());
		vo=(BreakDownVO)list.get(0);
		logger.debug("alternate bus id in util"+vo.getAlternateBusId());
		return list;
	}

	public ArrayList vehicleretrieve(String str) {
		// TODO Auto-generated method stub
		String query="select CODE as VEHICLEIDCODE,CDESC as VEHICLEIDDESC from LOOKUP where CODE in( select distinct(VEHICLE_ID) from VEHICLE_PURCHASE where INSTITUTION='"+str+"')";
		list=db.selectQuery(vofile,query);	
		logger.debug("array size in dao.."+list.size());
		for(int i=0;i<list.size();i++)
		{
			vo=(BreakDownVO)list.get(i);
		}
		return list;
	}

	public ArrayList nameretrieve(int id) {
		// TODO Auto-generated method stub
		String query="select CODE as DRIVERCODE,CDESC as ALTERNATE_DRIVER_NAME from LOOKUP where CODE in(select distinct(DRIVER_NAME) from DRIVER_PERSONAL where DRIVER_ID='"+id+"')";
		list=db.selectQuery(vofile,query);
		logger.debug("array size in dao..."+list.size());
		logger.debug("alter driver name in dao..."+vo.getAlternateBusDriverName());
		return list;
	}

	public void insert(BreakDownVO vo) {
		// TODO Auto-generated method stub
		BreakDownVO vo1=new BreakDownVO();
		BreakDownVO vo2=new BreakDownVO();
		BreakDownVO vo3=new BreakDownVO();
		ArrayList list1=new ArrayList();
		ArrayList list2=new ArrayList();
				
		String query="select CODE as DRIVER_NAME from LOOKUP where CDESC='"+vo.getDriverName()+"'";
		list=db.selectQuery(vofile, query);
		vo1=(BreakDownVO)list.get(0);
				
		String query1="select CODE as ALTERNATE_DRIVER_NAME from LOOKUP where CDESC='"+vo.getAlternateBusDriverName()+"'";
		list1=db.selectQuery(vofile, query1);
		vo2=(BreakDownVO)list1.get(0);
		
		String query2="select CODE as ALTERNATE_VEHICLE_ID from LOOKUP where CDESC='"+vo.getAlternateBusId()+"'";
		list2=db.selectQuery(vofile, query2);
		vo3=(BreakDownVO)list2.get(0); 
			
		logger.debug("driver id in dao"+vo1.getDriverName());
		logger.debug("alterdrivername in dao"+vo2.getAlternateBusDriverName());
		logger.debug("altervehicleid in dao"+vo.getAlternateBusId()); 
		logger.debug("vehicle id in dao"+vo.getVehicleId());
		
		db.otherQuery("insert into BREAKDOWN_DETAILS values('"+vo.getBreakDownDate()+"','"+vo.getBreakDownTime()+"','"+vo.getBreakDownPlace()+"',"+vo.getDriverId()+","+vo1.getDriverName()+","+vo.getInstituteName()+","+vo.getVehicleId()+","+vo.getRouteNo()+",'"+vo.getNatureOfBreakDown()+"','"+vo3.getAlternateBusId()+"',"+vo.getAlterdriverId()+","+vo2.getAlternateBusDriverName()+",'"+vo.getRemarks()+"')");
	}

	public ArrayList routenoretrieve(int id) {
		// TODO Auto-generated method stub
		String query="select ROUTE_NO from BUS_ALLOTMENT where VEHICLE_ID='"+id+"'";
		list=db.selectQuery(vofile, query);
		logger.debug("arraysize in dao"+list.size());
		return list;
	}

}
