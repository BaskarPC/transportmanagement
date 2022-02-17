package com.service;

import java.util.ArrayList;

import com.dao.DriverPolicyDAO;
import com.vo.DriverPolicyVO;

public class DriverPolicyService {

	
	ArrayList list =new ArrayList();
	DriverPolicyDAO dao=new DriverPolicyDAO();
	public ArrayList driveridcombo(DriverPolicyVO vo) {
		// TODO Auto-generated method stub
		list=dao.driveridcombo(vo);
		return list;
	}
	public ArrayList comboretrieve(int id) {
		// TODO Auto-generated method stub
		list=dao.comboretrieve(id);
		return list;
	}
	public void save(DriverPolicyVO vo) {
		// TODO Auto-generated method stub
		dao.save(vo);
	}
	public ArrayList comboretrieve1(int id) {
		// TODO Auto-generated method stub
		list=dao.comboretrieve1(id);
		return list;
	}
	public ArrayList retrieveall() {
		// TODO Auto-generated method stub
		list=dao.retrieveall();
		return list;
	}
	public ArrayList idretrieve(String driverId) {
		// TODO Auto-generated method stub
		list=dao.idretrieve(driverId);
		return list;
	}
	public void update(DriverPolicyVO vo, String driverId) {
		// TODO Auto-generated method stub
		dao.update(vo,driverId);
		
	}

}
