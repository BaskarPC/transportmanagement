package com.service;
import com.vo.DriverLeaveVO;
import com.dao.DriverLeaveDAO;
import java.util.*;

import org.apache.log4j.Logger;



public class DriverLeaveService {
	ArrayList list =new ArrayList();
	DriverLeaveDAO dao=new DriverLeaveDAO();
	private static final Logger logger=(Logger)Logger.getLogger(DriverLeaveService.class);
	/**
	 * Loading driver id combo
	 * @param vo
	 * @return
	 */
	public ArrayList driveridcombo(DriverLeaveVO vo)
	{
		logger.debug("DriverLeaveService:driveridcombo---------->");
		list=dao.driveridcombo(vo);
		logger.debug("DriverLeaveService:driveridcombo<----------");
		return list;
		
		
	}
	/**
	 * retrieving drivername from lookup
	 * @param id
	 * @return
	 */
	public ArrayList comboretrieve(int id) {
		// TODO Auto-generated method stub
		logger.debug("DriverLeaveService: comboretrieve---------->");
		list=dao.comboretrieve(id);
		logger.debug("DriverLeaveService: comboretrieve<----------");
		return list;
	}

	/*public ArrayList deptcombo(DriverLeaveVO vo) {
		// TODO Auto-generated method stub
		list=dao.deptcombo(vo);
		return list;
	}*/
	/**
	 * save values into database
	 * @param vo
	 */
	public void insert(DriverLeaveVO vo) {
		// TODO Auto-generated method stub
		logger.debug("DriverLeaveService: insert---------->");
		dao.insert(vo);
		logger.debug("DriverLeaveService: insert<----------");
	}
	/**
	 * retrieve values from database
	 * @param id
	 * return list
	 */
	public ArrayList retrieve(int vo) {
		// TODO Auto-generated method stub
		logger.debug("DriverLeaveService: retrieve---------->");
		list=dao.retrieve(vo);
		logger.debug("DriverLeaveService: retrieve<----------");
		return list;
	}
	/**
	 * retrieve department code, department name by comparing lookup and driver_official table
	 * @param id
	 * @return list
	 */

	public ArrayList deptretrieve(int id) {
		// TODO Auto-generated method stub
		logger.debug("DriverLeaveService: deptretrieve---------->");
		list=dao.deptretrieve(id);
		logger.debug("DriverLeaveService: deptretrieve<----------");
		return list;
	}
	/**
	 * retrieve all values from database
	 * @param id
	 * @return list
	 */
	
	public ArrayList leavetaken(int id) {
		// TODO Auto-generated method stub
		logger.debug("DriverLeaveService: leavetaken---------->");
	 	  list=dao.leavetaken(id);
	 	 logger.debug("DriverLeaveService: leavetaken<----------");
		return list;
	}
	/**
	 * retrieve medical days from detabase
	 * @param id
	 * @return list
	 */
	public ArrayList medicalcal(int id) {
		// TODO Auto-generated method stub
		logger.debug("DriverLeaveService: medicalcal---------->");
		list=dao.medicalcal(id);
		logger.debug("DriverLeaveService: medicalcal<----------");
		return list;
	}
	/**
	 * retrieve vacation days from database
	 * @param id
	 * @return list
	 */
	public ArrayList vacationcal(int id) {
		// TODO Auto-generated method stub
		logger.debug("DriverLeaveService: vacationcal---------->");
		list=dao.vacationcal(id);
		logger.debug("DriverLeaveService: vacationcal<----------");
		return list;
	}
	/**
	 * retrieve driver desc, driver name by comparing lookup and driver_leave table
	 * @return list
	 */
	public ArrayList retrieveall() {
		// TODO Auto-generated method stub
		logger.debug("DriverLeaveService: retrieveall---------->");
		list=dao.retrieveall();
		logger.debug("DriverLeaveService: retrieveall<----------");
		return list;
	}
	/**
	 * retrieve driverid desc from lookup
	 * @param driverId
	 * @return list
	 */
	public ArrayList idretrieve(String driverId) {
		// TODO Auto-generated method stub
		logger.debug("DriverLeaveService: idretrieve---------->");
		list=dao.idretrieve(driverId);
		logger.debug("DriverLeaveService: idretrieve<----------");
		return list;
	}
	public void update(DriverLeaveVO vo, String driverId) {
		// TODO Auto-generated method stub
		dao.update(vo,driverId);
	}

	

}
