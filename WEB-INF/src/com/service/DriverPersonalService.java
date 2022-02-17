package com.service;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.dao.DriverPersonalDAO;
import com.vo.DriverLeaveVO;
import com.vo.DriverLicenceVO;
import com.vo.DriverPersonalVO;
import com.vo.DriverOfficialVO;
import com.vo.DriverPolicyVO;


public class DriverPersonalService {
	private static final Logger logger=(Logger)Logger.getLogger(DriverPersonalService.class);
	
	ArrayList list =new ArrayList();
	DriverPersonalDAO dao=new DriverPersonalDAO();
	
	/**
	 * retrieve district values
	 * @param vo 
	 * @return list
	 */
	public ArrayList districtcombo1(DriverPersonalVO vo) {
		// TODO Auto-generated method stub
		list=dao.districtcombo1();
		return list;
	}
	/**
	 * retrieve district values
	 * @param vo
	 * @return list
	 */

	public ArrayList districtcombo2(DriverPersonalVO vo) {
		// TODO Auto-generated method stub
		list=dao.districtcombo2();
		return list;
	}
	
	/**
	 * retrieve state values
	 * @param vo
	 * @return list
	 */ 

	public ArrayList statecombo1(DriverPersonalVO vo) {
		// TODO Auto-generated method stub
		list=dao.statecombo1();
		return list;
	}
	/**
	 * retrieve state values
	 * @param vo
	 * @return list
	 */ 

	public ArrayList statecombo2(DriverPersonalVO vo) {
		// TODO Auto-generated method stub
		list=dao.statecombo2();
		return list;
	}
	/**
	 * retrieve community values
	 * @param vo
	 * @return list
	 */ 

	public ArrayList communitycombo(DriverPersonalVO vo) {
		// TODO Auto-generated method stub
		list=dao.communitycombo();
		return list;
	}
	/**
	 * retrieve religion values
	 * @param vo
	 * @return list
	 */ 
	public ArrayList religioncombo(DriverPersonalVO vo) {
		// TODO Auto-generated method stub
		list=dao.religioncombo();
		return list;
	}
	/**
	 * Save values in database
	 * @param vo
	 */
	 
	public void save(DriverPersonalVO vo) {
		// TODO Auto-generated method stub
		dao.save(vo);
		
	}
	/**
	 * retrieve values from database
	 * @param id
	 * @return list
	 */
	public ArrayList retrieve(String id) {
		// TODO Auto-generated method stub
		list=dao.retrieve(id);
		return list;
	}
	
  /**
   * retrieve values of drivername from lookup
   * @param driverName
   * @return list
   */
	public ArrayList drivernamelookup(String driverName) {
		// TODO Auto-generated method stub
		list=dao.drivernamelookup(driverName);
		return list;
	}
	
	/**
	 * delete values of driver details
	 * @param vo
	 * @param ind
	 */
	
	public void deleteind(DriverOfficialVO vo,String ind) {
		// TODO Auto-generated method stub
		dao.deleteind(vo,ind);
		
	}
	/**
	 * retrieving drivername from lookup and driver_personal table
	 * @return list
	 */
	public ArrayList retrieveall() {
		// TODO Auto-generated method stub
		list=dao.retrieveall();
		return list;
	}
	public ArrayList driveridcombo(DriverPersonalVO vo) {
		// TODO Auto-generated method stub
		logger.debug("DriverPersonalService: driveridcombo------------->");
		list=dao.driveridcombo(vo);
		logger.debug("DriverPersonalService: driveridcombo<-------------");
		return list;
	}
	public ArrayList driveridretrieve(DriverPersonalVO vo) {
		// TODO Auto-generated method stub
		list=dao.driveridretrieve(vo);
		return list;
	}
	public ArrayList idretrieve(String driverId) {
		// TODO Auto-generated method stub
		list=dao.idretrieve(driverId);
		return list;
	}
	public void licencedeleteind(DriverLicenceVO licencevo, String ind) {
		// TODO Auto-generated method stub
		dao.licencedeleteind(licencevo,ind);
	}
	public void policydeleteind(DriverPolicyVO policyvo, String ind) {
		// TODO Auto-generated method stub
		dao.policydeleteind(policyvo,ind);
	}
	public void leavedeleteind(DriverLeaveVO leavevo, String ind) {
		// TODO Auto-generated method stub
		dao.leavedeleteind(leavevo,ind);
	}
	public ArrayList retrievedriverid(String seqid) {
		// TODO Auto-generated method stub
		list=dao.retrievedriverid(seqid);
		return list;
		
	}
	public void update(DriverPersonalVO vo, String string) {
		// TODO Auto-generated method stub
	dao.update(vo,string);
	}
		


}
