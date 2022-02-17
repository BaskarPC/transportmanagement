package com.service;
import java.util.ArrayList;

import com.dao.OldVehiclePurchaseDAO;
import com.vo.OldVehiclePurchaseVO;;

public class OldVehiclePurchaseService {
	ArrayList list=new ArrayList();
	OldVehiclePurchaseDAO dao =new OldVehiclePurchaseDAO();
	
	public ArrayList insert(OldVehiclePurchaseVO vo)throws Exception
	{		
	dao.insert(vo);
	return list;
	}

	public ArrayList vehiclestatuscombo() {
		// TODO Auto-generated method stub
		list=dao.vehiclestatuscombo();	
		return list;
	}

	public ArrayList retrieveall() {
		// TODO Auto-generated method stub
		list=dao.retrieveall();
		return list;
	}

	public ArrayList retrieve(int id) {
		// TODO Auto-generated method stub
		list=dao.retrieve(id);
		return list;
	}
}
