package com.dao;
import com.service.OldVehiclePurchaseService;
import com.vo.OldVehiclePurchaseVO;
import java.util.ArrayList;
import com.dbcom.dbcom;
import com.util.*;
public class OldVehiclePurchaseDAO {
	dbcom db=new dbcom();
	ArrayList list=new ArrayList();
    OldVehiclePurchaseUtil oldvehicleutil=new OldVehiclePurchaseUtil();
    OperationsGeneralLookupUtil util=new OperationsGeneralLookupUtil();
    String vofile="com.vo.OldVehiclePurchaseVO";
    
	public ArrayList insert(OldVehiclePurchaseVO o)throws Exception
	{
		oldvehicleutil.insert(o);
		return list;
	}

	public ArrayList vehiclestatuscombo() {
		// TODO Auto-generated method stub
		String query=util.optionQuery();
		list=db.selectQuery(vofile, query);
		return list;
	}

	public ArrayList retrieveall() {
		// TODO Auto-generated method stub
		list=oldvehicleutil.retrieveall();
		return list;
	}

	public ArrayList retrieve(int id) {
		// TODO Auto-generated method stub
		list=oldvehicleutil.retrieve(id);
		return list;
	}

}
        