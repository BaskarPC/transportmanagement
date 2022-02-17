package com.service;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.dao.BreakDownDAO;
import com.vo.BreakDownVO;

public class BreakDownService {
ArrayList list=new ArrayList();
BreakDownDAO dao=new BreakDownDAO();
private static final Logger logger=(Logger)Logger.getLogger(BreakDownService.class);
	public ArrayList instcombo(BreakDownVO vo) {
		// TODO Auto-generated method stub
		list=dao.instcombo(vo);
		return list;
	}

	public ArrayList driveridcombo(BreakDownVO vo) {
		// TODO Auto-generated method stub
		list=dao.driveridcombo(vo);
		return list;
	}

	
	public ArrayList retrievecombo(int id) {
		// TODO Auto-generated method stub
		list =dao.retrievecombo(id);
		return list;
		
	}

	public ArrayList vehicleretrieve(String str) {
		// TODO Auto-generated method stub
		list=dao.vehicleretrieve(str);
		return list;
	}

	public ArrayList vehiclecombo(BreakDownVO vo) {
		// TODO Auto-generated method stub
		list=dao.vehiclecombo(vo);
		return list;
	}

     public ArrayList nameretrieve(int id) {
		// TODO Auto-generated method stub
		list=dao.nameretrieve(id);
		return list;
	}

	public void insert(BreakDownVO vo) {
		// TODO Auto-generated method stub
		dao.insert(vo);
	}

	public ArrayList routenoretrieve(int id) {
		// TODO Auto-generated method stub
		list=dao.routenoretrieve(id);
		return list;
	}

	public ArrayList retrieveall(int id) {
		// TODO Auto-generated method stub
		list=dao.retrieveall(id);
		return list;
	}

	public ArrayList vehicleidretrieve(int id) {
		// TODO Auto-generated method stub
		list=dao.vehicleidretrieve(id);
		return list;
	}

	public ArrayList formretrieve(int id) {
		// TODO Auto-generated method stub
		list=dao.formretrieve(id);
		return list;
	}

	public ArrayList drivernameretrieve(int drivername) {
		// TODO Auto-generated method stub
		list=dao.drivernameretrieve(drivername);
		return list;
	}

	public ArrayList alterdriver(int alterdriver) {
		// TODO Auto-generated method stub
		list=dao.alterdriver(alterdriver);
		return list;
	}

	public ArrayList alterbus(int alterbus) {
		// TODO Auto-generated method stub
		list=dao.alterbus(alterbus);
		return list;
	}

	
	

}
