package com.service;

import java.util.ArrayList;

import com.vo.VehicleInsuranceVO;
import com.dao.VehicleInsuranceDAO;

public class VehicleInsuranceService {
	ArrayList list=new ArrayList();
	VehicleInsuranceDAO dao=new VehicleInsuranceDAO();
	
	/**
	 * retrieve institution combo
	 * @param vo
	 * @return
	 */
	public ArrayList instcombo(VehicleInsuranceVO vo) {
		// TODO Auto-generated method stub
		list=dao.instcombo(vo);
		return list;
	}

	/**
	 * retrieve vehicletype
	 * @param str
	 * @return
	 */
	public ArrayList vehicletype(String str) {
		// TODO Auto-generated method stub\
		list=dao.vehicletype(str);
		return list;
	}

	/**
	 * insert values into database
	 * @param vo
	 */
	public void insert(VehicleInsuranceVO vo) {
		// TODO Auto-generated method stub
		dao.insert(vo);
	}

	/**
	 * retrieve vehicleid
	 * @param str
	 * @return
	 */
	public ArrayList vehicleidretrieve(String str) {
		// TODO Auto-generated method stub
		list=dao.vehicleidretrieve(str);
		return list;
	}

	/**
	 * retrieve all values from database
	 * @param id
	 * @return
	 */
	public ArrayList retrieve(int id) {
		// TODO Auto-generated method stub
		list=dao.retrieve(id);
		return list;
	}

	/**
	 * retrieve corresponding description for all vehicle id database
	 * @return
	 */
	public ArrayList retrieveall() {
		// TODO Auto-generated method stub
		list=dao.retrieveall();
		return list;
	}

	/**
	 * retrieve corresponding description for vehicleid from form
	 * @param vehicleid
	 * @return
	 */
	public ArrayList formvehicleid(int vehicleid) {
		// TODO Auto-generated method stub
		list=dao.formvehicleid(vehicleid);
		return list;
	}

	public void update(VehicleInsuranceVO vo,String vehicleid) {
		// TODO Auto-generated method stub
		dao.update(vo,vehicleid);
		
	}
}
