package com.dao;
import org.apache.log4j.Logger;
import com.vo.BusAllotmentVO;
import com.util.OperationsGeneralLookupUtil;
import java.util.ArrayList;
import com.dbcom.*;
import com.util.BusAllotmentUtil;

public class BusAllotmentDAO {
	private static final Logger logger=(Logger)Logger.getLogger(BusAllotmentDAO.class);
	dbcom db=new dbcom();
	OperationsGeneralLookupUtil operationsutil =new OperationsGeneralLookupUtil();
	ArrayList list=new ArrayList();
	ArrayList list1=new ArrayList();
	BusAllotmentVO vo=new BusAllotmentVO();
	BusAllotmentVO vo1=new BusAllotmentVO();
	String vofile="com.vo.BusAllotmentVO";
	BusAllotmentUtil util = new BusAllotmentUtil();
	
	/**
	 * retrieve institution combo 
	 * @param vo
	 * @return
	 * @throws Exception
	 */
public ArrayList instcombo(BusAllotmentVO vo)throws Exception
	{
    	 String query=operationsutil.institutionQuery();
		  list=db.selectQuery(vofile, query);
		  return list;
	}

/**
 * retrieve driverid combo
 * @param vo
 * @return
 */
public ArrayList driveridcombo(BusAllotmentVO vo) {
	// TODO Auto-generated method stub
	String query=operationsutil.driveridQuery();
	list=db.selectQuery(vofile, query);
	return list;
}

/**
 * retrieve district combo
 * @param vo
 * @return
 */
public ArrayList districtcombo(BusAllotmentVO vo)
{
	// TODO Auto-generated method stub
	String query=operationsutil.districtQuery();
	list=db.selectQuery(vofile, query);
	return list;
}

/**
 * retrieve vehicletype combo
 * @param vo
 * @return
 */
public ArrayList vehicletypecombo(BusAllotmentVO vo2) {
	// TODO Auto-generated method stub
	String query=operationsutil.vehicleTypeQuery();
	list=db.selectQuery(vofile, query);
	return list;
}

/**
 * retrieve vehicleid
 * @param str
 * @return
 */
public ArrayList vehicleretrieve(String str) {
	// TODO Auto-generated method stub
    list=util.vehicleretrieve(str);
    
/*	String query="select CODE as VEHICLEIDCODE,CDESC as VEHICLEIDDESC from LOOKUP where CODE in( select distinct(VEHICLE_ID) from VEHICLE_PURCHASE where VEHICLE_TYPE='"+str+"')";
	list=db.selectQuery(vofile, query);*/
	return list;
}

/**
 * retrieve drivername
 * @param id
 * @return
 */
public ArrayList nameretrieve(int id) {
	// TODO Auto-generated method stub
	list=util.nameretrieve(id);
	
/*	String query="select CODE as DRIVERCODE,CDESC as DRIVER_NAME from LOOKUP where CODE in(select distinct(DRIVER_NAME)from DRIVER_PERSONAL where DRIVER_ID='"+id+"' AND DEL_IND='N')";
	list=db.selectQuery(vofile, query);*/
	return list;
}

/**
 * insert values into database
 * @param vo
 */
public void insert(BusAllotmentVO vo) {
	// TODO Auto-generated method stub
	
	util.insert(vo);
/*	BusAllotmentVO vo1=new BusAllotmentVO(); 
	String query="select CODE as DRIVER_NAME from LOOKUP where CDESC='"+vo.getDriverName()+"'";
	list=db.selectQuery(vofile, query);
	for(int i=0;i<list.size();i++)
	{
	vo1=(BusAllotmentVO)list.get(i);
	}
	db.otherQuery("insert into BUS_ALLOTMENT values("+vo.getInstituteName()+","+vo.getVehicleId()+","+vo.getDriverId()+","+vo1.getDriverName()+",'"+vo.getVehicleAllottedDate()+"','"+vo.getRouteNo()+"',"+vo.getKmTravelledPerDay()+",'"+vo.getStartPlace()+"','"+vo.getVia()+"','"+vo.getLastStop()+"','"+vo.getHaltPlace()+"',"+vo.getResidentialNo()+","+vo.getOfficeNo()+",'"+vo.getPermittedDistrict()+"','N',"+vo.getVehicleType()+")");
*/
}

/**
 * retrieve values from database
 * @param id
 * @return
 */
public ArrayList retrieve(int id) {
	// TODO Auto-generated method stub
	list=util.retrieve(id);
/*	String query="select DRIVER_ID,DRIVER_NAME,VEHICLE_ALLOTED_DATE,ROUTE_NO,KM_PERDAY,STARTING_PLACE,VIA,LAST_STOP,HALT_PLACE,HALT_RES_PHONENO,HALT_OFFICE_PHONENO from BUS_ALLOTMENT where VEHICLE_ID='"+id+"' AND DEL_IND='N'";
	list=db.selectQuery(vofile, query);*/
	return list;
}

/**
 * update delete indicator
 * @param id
 */
public void deleteind(int id) {
	// TODO Auto-generated method stub
	util.deleteind(id);
/*	String query="UPDATE BUS_ALLOTMENT SET DEL_IND='Y' where DRIVER_ID='"+id+"'";
	db.otherQuery(query);*/
}

/**
 * retrieve vehicle type
 * @param str
 * @return
 */
public ArrayList vehicletyperetrieve(String str) {
	// TODO Auto-generated method stub
	list=util.vehicletyperetrieve(str);
/*	String query="select CODE as VEHICLETYPECODE,CDESC as VEHICLETYPEDESC from LOOKUP where CODE in (select distinct(VEHICLE_TYPE) from VEHICLE_PURCHASE where INSTITUTE_NAME='"+str+"')";
	list=db.selectQuery(vofile, query);*/
	return list;
}

/**
 * retrieve all vehicle id from database
 * @return
 */
public ArrayList retrieveall() {
	// TODO Auto-generated method stub
	list=util.retrieveall();
/*	String query="select CDESC as VEHICLEIDDESC from LOOKUP where CODE IN(select distinct(VEHICLE_ID) from BUS_ALLOTMENT)";
	list=db.selectQuery(vofile, query);*/
	return list;
}

/**
 * retrieve corresponding vehicleid description for vehicleid
 * @param
 * @return
 */
public ArrayList vehicleidretrieve(int vehicleId) {
	// TODO Auto-generated method stub
	list=util.vehicleidretrieve(vehicleId);
/*	String query="select CDESC as VEHICLEIDDESC from LOOKUP where CODE='"+vehicleId+"'";
	list=db.selectQuery(vofile, query);*/
	return list;
}

/**
 * retrieve corresponding drivername for drivername
 * @param drivername
 * @return
 */
public ArrayList drivernamedesc(int drivername) {
	// TODO Auto-generated method stub
	list=util.drivernamedesc(drivername);
/*	String query="select CDESC as DRIVERNAMEDESC from LOOKUP where CODE="+drivername+"";
	list=db.selectQuery(vofile, query);*/
	return list;
}

public void insertother(BusAllotmentVO vo) {
	// TODO Auto-generated method stub
	util.insertother(vo);
/*	BusAllotmentVO vo1=new BusAllotmentVO(); 
	String query="select CODE as DRIVER_NAME from LOOKUP where CDESC='"+vo.getDriverName()+"'";
	list=db.selectQuery(vofile, query);
	for(int i=0;i<list.size();i++)
	{
	vo1=(BusAllotmentVO)list.get(i);
	}
	db.otherQuery("insert into BUS_ALLOTMENT values("+vo.getInstituteName()+","+vo.getVehicleId()+","+vo.getDriverId()+","+vo1.getDriverName()+",'"+vo.getVehicleAllottedDate()+"','','','','','','','','','','N','"+vo.getVehicleType()+"')");
*/
}

/**
 * Update the values if vehicletype is bus
 * @param vo
 * @param vehicleId
 */
public void update(BusAllotmentVO vo, String vehicleId) {
	// TODO Auto-generated method stub
	util.update(vo,vehicleId);
}

/**
 * Update the values for other vehicle types
 * @param vo
 * @param vehicleId
 */
public void updateother(BusAllotmentVO vo, String vehicleId) {
	// TODO Auto-generated method stub
	util.updateother(vo,vehicleId);
}

public ArrayList retrievedistrictvalues(String string) {
	// TODO Auto-generated method stub
	String query="select CDESC as PERMITTED_DISTRICT from LOOKUP where CODE ="+string+"";
	list=db.selectQuery(vofile, query);
	return list;
}
}
