package com.service;
import com.dao.DriverOfficialDAO;
import com.vo.DriverOfficialVO;
import java.util.*;
public class DriverOfficialService {
    ArrayList list =new ArrayList();
    DriverOfficialDAO dao= new DriverOfficialDAO();
    /**
     * retrieve institute names from database
     * @param vo
     * @return list
     * @throws Exception
     */
	public ArrayList institutecombo(DriverOfficialVO vo)throws Exception
	{
	    list=dao.institutecombo(vo);
	     return list;
	}
	/**
	 * retrieve department names from database
	 * @param vo
	 * @return list
	 * @throws Exception
	 */
	public ArrayList departmentcombo(DriverOfficialVO vo)throws Exception
	{
		 list=dao.departmentcombo(vo);
	     return list;
	}
	/**
	 * retrieve blood group names from database
	 * @param vo
	 * @return list
	 */
	public ArrayList bloodgpcombo(DriverOfficialVO vo) {
		// TODO Auto-generated method stub
		list=dao.bloodgpcombo(vo);
		return list;
	}
	/**
	 * save values into database
	 * @param vo
	 */
	public void save(DriverOfficialVO vo) {
		// TODO Auto-generated method stub
		dao.save(vo);
		
	}
	/**
	 * retrieving driver id code from lookup
	 * @param driverid
	 * @return list
	 */
	public ArrayList idcoderetrieve(String driverid) {
		// TODO Auto-generated method stub
		list=dao.idcoderetrieve(driverid);
		return list;
	}
	public ArrayList idretrieve(String driverId) {
		// TODO Auto-generated method stub
		list=dao.idretrieve(driverId);
		return list;
	}
	public void update(DriverOfficialVO vo, String driverid) {
		// TODO Auto-generated method stub
		dao.update(vo,driverid);
		
	}
	public ArrayList retrieveall(String driverId) {
		// TODO Auto-generated method stub
		list=dao.retrieveall(driverId);
		return list;
	}
	
	
}
