package com.util;
import com.dbcom.*;
import com.vo.OldVehiclePurchaseVO;
import java.util.ArrayList;

public class OldVehiclePurchaseUtil {
	dbcom db=new dbcom();
	ArrayList list=new ArrayList();
	String vofile="com.vo.OldVehiclePurchaseVO";
	public ArrayList insert(OldVehiclePurchaseVO vo)throws Exception
	{	
	db.otherQuery("insert into OLDVEHICLE_PURCHASE values("+vo.getVehicleId()+","+vo.getKmTraveled()+","+vo.getVehicleAge()+","+vo.getVehiclestatus()+",'"+vo.getBodyCmpy()+"')");
	return list;
	}

	public ArrayList retrieveall() {
		// TODO Auto-generated method stub
		String query="select CDESC from LOOKUP where CODE in(select distinct(VEHICLE_ID) from OLDVEHICLE_PURCHASE)";
		list=db.selectQuery(vofile, query);
		return list;
	}

	public ArrayList retrieve(int id) {
		// TODO Auto-generated method stub
		String query="select KM_TRAVELLED,VEHICLE_AGE,VEHICLE_STATUS,COMPANY_NAME as BDY_COMPANY_NAME from OLDVEHICLE_PURCHASE where VEHICLE_ID="+id+"";
		db.selectQuery(vofile, query);
		return list;
	}
}
