package com.service;

import org.apache.log4j.Logger;
import com.dao.BusAllotmentDAO;
import com.vo.BusAllotmentVO;
import java.util.ArrayList;

public class BusAllotmentService {
	BusAllotmentDAO dao=new BusAllotmentDAO();
	ArrayList list=new ArrayList();
	
	private static final Logger logger=(Logger)Logger.getLogger(BusAllotmentService.class);
	
	/**
	 * retrieve institution combo 
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	public ArrayList instcombo(BusAllotmentVO vo)throws Exception
	{
		list=dao.instcombo(vo);
		return list;
	}
	
	/**
	 * retrieve driverid combo
	 * @param vo
	 * @return
	 */
	public ArrayList driveridcombo(BusAllotmentVO vo) {
		// TODO Auto-generated method stub
		list=dao.driveridcombo(vo);
		return list;
	}

	/**
	 * retrieve vehicleid
	 * @param str
	 * @return
	 */
	public ArrayList vehicleretrieve(String str) {
		// TODO Auto-generated method stub
		list=dao.vehicleretrieve(str);
		return list;
	}

	/**
	 * retrieve drivername
	 * @param id
	 * @return
	 */
	public ArrayList nameretrieve(int id) {
		// TODO Auto-generated method stub
		list=dao.nameretrieve(id);
		return list;
	}

	/**
	 * retrieve district combo
	 * @param vo
	 * @return
	 */
	public ArrayList districtcombo(BusAllotmentVO vo) {
		// TODO Auto-generated method stub
		list=dao.districtcombo(vo);
		return list;
	}

	/**
	 * insert values into database
	 * @param vo
	 */
	public void insert(BusAllotmentVO vo) {
		// TODO Auto-generated method stub
		dao.insert(vo);
	}

	/**
	 * retrieve values from database
	 * @param id
	 * @return
	 */
	public ArrayList retrieve(int id) {
		// TODO Auto-generated method stub
		list=dao.retrieve(id);
		return list;
	}

	/**
	 * update delete indicator
	 * @param id
	 */
	public void deleteind(int id) {
		// TODO Auto-generated method stub
		dao.deleteind(id);
	}

	/**
	 * retrieve vehicle type
	 * @param str
	 * @return
	 */
	public ArrayList vehicletyperetrieve(String str) {
	// TODO Auto-generated method stub
	list=dao.vehicletyperetrieve(str);
	return list;
	}

	/**
	 * retrieve vehicletype combo
	 * @param vo
	 * @return
	 */
	public ArrayList vehicletypecombo(BusAllotmentVO vo) {
		// TODO Auto-generated method stub
		list=dao.vehicletypecombo(vo);
		return list;
	}

	/**
	 * retrieve all vehicle id from database
	 * @return
	 */
	public ArrayList retrieveall() {
		// TODO Auto-generated method stub
		list=dao.retrieveall();
		return list;
	}

	/**
	 * retrieve corresponding vehicleid description for vehicleid
	 * @param
	 * @return
	 */
	public ArrayList vehicleidretrieve(int vehicleId) {
		// TODO Auto-generated method stub
		list=dao.vehicleidretrieve(vehicleId);
		return list;
	}

	/**
	 * retrieve corresponding drivername for drivername
	 * @param drivername
	 * @return
	 */
	public ArrayList drivernamedesc(int drivername) {
		// TODO Auto-generated method stub
		list=dao.drivernamedesc(drivername);
		return list;
	}

	public void insertother(BusAllotmentVO vo) {
		// TODO Auto-generated method stub
		dao.insertother(vo);
		
	}

	public void update(BusAllotmentVO vo, String vehicleId) {
		// TODO Auto-generated method stub
		dao.update(vo,vehicleId);		
	}

	public void updateother(BusAllotmentVO vo, String vehicleId) {
		// TODO Auto-generated method stub
		dao.updateother(vo,vehicleId);
	}
	
	public ArrayList retrievedistrictvalues(String string) {
		// TODO Auto-generated method stub
		list=dao.retrievedistrictvalues(string);
		return list;
	}


	
}
