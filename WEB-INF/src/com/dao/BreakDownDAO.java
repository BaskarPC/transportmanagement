package com.dao;

import java.util.ArrayList;
import com.dbcom.dbcom;
import org.apache.log4j.Logger;
import com.util.OperationsGeneralLookupUtil;
import com.vo.BreakDownVO;
import com.util.*;

public class BreakDownDAO {
ArrayList list=new ArrayList();
dbcom db=new dbcom();
BreakDownVO vo=new BreakDownVO();
private static final Logger logger=(Logger)Logger.getLogger(BreakDownDAO.class);
OperationsGeneralLookupUtil operationsutil =new OperationsGeneralLookupUtil();
BreakDownUtil util=new BreakDownUtil();
String vofile="com.vo.BreakDownVO";

	public ArrayList instcombo(BreakDownVO vo) {
		// TODO Auto-generated method stub
		 String query=operationsutil.institutionQuery();
		  list=db.selectQuery(vofile, query);
		return list;
	}
	public ArrayList driveridcombo(BreakDownVO vo) {
		// TODO Auto-generated method stub
		String query=operationsutil.driveridQuery();
		list=db.selectQuery(vofile, query);
		return list;
	}
	public ArrayList retrievecombo(int id) {
		// TODO Auto-generated method stub
		
		String query="select CODE as DRIVERCODE,CDESC as DRIVER_NAME from LOOKUP where CODE in( select distinct(DRIVER_NAME) from DRIVER_PERSONAL where DRIVER_ID='"+id+"')"; 
		list=db.selectQuery(vofile, query);
		return list;
	}
	public ArrayList vehicleretrieve(String str) {
		// TODO Auto-generated method stub
		list=util.vehicleretrieve(str);
		
	/*	String query="select CODE as VEHICLEIDCODE,CDESC as VEHICLEIDDESC from LOOKUP where CODE in( select distinct(VEHICLE_ID) from VEHICLE_PURCHASE where INSTITUTION='"+str+"')";
		list=db.selectQuery(vofile,query);	
		logger.debug("array size in dao.."+list.size());
		for(int i=0;i<list.size();i++)
		{
			vo=(BreakDownVO)list.get(i);
		}*/
		return list;
	}
	public ArrayList vehiclecombo(BreakDownVO vo2) {
		// TODO Auto-generated method stub
		String query=operationsutil.vehicleNumberQuery();
		list=db.selectQuery(vofile,query);
		return list;
	}
	public ArrayList nameretrieve(int id) {
		// TODO Auto-generated method stub
		list=util.nameretrieve(id);
		
	/*	String query="select CODE as DRIVERCODE,CDESC as ALTERNATE_DRIVER_NAME from LOOKUP where CODE in(select distinct(DRIVER_NAME) from DRIVER_PERSONAL where DRIVER_ID='"+id+"')";
		list=db.selectQuery(vofile,query);
		logger.debug("array size in dao..."+list.size());
		logger.debug("alter driver name in dao..."+vo.getAlternateBusDriverName());*/
		return list;
	}

	public void insert(BreakDownVO vo) {
		// TODO Auto-generated method stub
		util.insert(vo);
		
	/*	BreakDownVO vo1=new BreakDownVO();
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
	*/
	}
	public ArrayList routenoretrieve(int id) {
		// TODO Auto-generated method stub
		list=util.routenoretrieve(id);
		
	/*	String query="select ROUTE_NO from BUS_ALLOTMENT where VEHICLE_ID='"+id+"'";
		list=db.selectQuery(vofile, query);
		logger.debug("arraysize in dao"+list.size());*/
		return list;
	}
	public ArrayList retrieveall(int id) {
		// TODO Auto-generated method stub
		list=util.retrieveall(id);
		return list;
	}
	public ArrayList vehicleidretrieve(int id) {
		// TODO Auto-generated method stub
		list=util.vehicleidretrieve(id);
		return list;
	}
	public ArrayList formretrieve(int id) {
		// TODO Auto-generated method stub
		list=util.formretrieve(id);
		return list;
	}
	public ArrayList drivernameretrieve(int drivername) {
		// TODO Auto-generated method stub
		list=util.drivernameretrieve(drivername);
		return list;
	}
	public ArrayList alterdriver(int alterdriver) {
		// TODO Auto-generated method stub
		list=util.alterdriver(alterdriver);
		return list;
	}
	public ArrayList alterbus(int alterbus) {
		// TODO Auto-generated method stub
		list=util.alterbus(alterbus);
		return list;
	}
}
