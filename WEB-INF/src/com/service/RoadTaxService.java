package com.service;
import com.vo.RoadTaxVO;
import com.dao.RoadTaxDAO;
import java.util.ArrayList;

import org.apache.log4j.Logger;
public class RoadTaxService {
	RoadTaxDAO dao=new RoadTaxDAO();
	ArrayList list=new ArrayList();
	private static final Logger logger=(Logger)Logger.getLogger(RoadTaxService.class);

public ArrayList instcombo(RoadTaxVO vo) {
	// TODO Auto-generated method stub
	list=dao.instcombo(vo);	
	return list;
}

public ArrayList vehicleidcombo(String typename, String instname) {
	// TODO Auto-generated method stub
	 RoadTaxVO vo=new RoadTaxVO();
	list=dao.vehicleidcombo(typename,instname);	  
	return list;
}

public ArrayList vehicletypecombo(String instname) {
	// TODO Auto-generated method stub
	list=dao.vehicletypecombo(instname);
	return list;
}

public ArrayList periodcombo(RoadTaxVO vo) {
	// TODO Auto-generated method stub
	list=dao.periodcombo(vo);
	return list;
}

public ArrayList optioncombo(RoadTaxVO vo) {
	// TODO Auto-generated method stub
	list=dao.optioncombo(vo);
	return list;
}

public void saveintodb(RoadTaxVO vo) {
	// TODO Auto-generated method stub
	dao.saveintodb(vo);
}

public ArrayList retrieve(int id) {
	// TODO Auto-generated method stub
	list=dao.retrieve(id);
	return list;
}

public ArrayList vehicleidretrieve() {
	// TODO Auto-generated method stub
	list=dao.vehicleidretrieve();
	return list;
}

public ArrayList formvehicleid(int id) {
	// TODO Auto-generated method stub
	list=dao.formvehicleid(id);
	return list;
}

public void update(RoadTaxVO vo, String vehicleId) {
	// TODO Auto-generated method stub
	dao.update(vo,vehicleId);
}

}
