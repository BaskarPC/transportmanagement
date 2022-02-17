package com.dao;

import java.util.ArrayList;
import org.apache.log4j.Logger;
import com.dbcom.dbcom;
import com.util.DriverPolicyUtil;
import com.util.OperationsGeneralLookupUtil;
import com.vo.DriverPolicyVO;

public class DriverPolicyDAO {
	
	private static final Logger logger=(Logger)Logger.getLogger(DriverPolicyDAO.class);
	dbcom db=new dbcom();
	ArrayList list=new ArrayList();
	DriverPolicyVO vo=new DriverPolicyVO();
	DriverPolicyVO vo1=new DriverPolicyVO();
	DriverPolicyUtil driverutil=new DriverPolicyUtil();
	OperationsGeneralLookupUtil util=new OperationsGeneralLookupUtil();
	
	/**
	 * Loading driver id in combo
	 * @param vo
	 * @return list
	 */
	public ArrayList driveridcombo(DriverPolicyVO vo) 
	{
		// TODO Auto-generated method stub
		String query=util.driveridQuery();
		list=db.selectQuery("com.vo.DriverPolicyVO", query);
		return list;
	}
	
	/**
	 * retrieving driver name from lookup and driver_personal table
	 * @param id
	 * @return list
	 */
	public ArrayList comboretrieve(int id) 
	{
		// TODO Auto-generated method stub
		String query=driverutil.retrievealldrivers(id);
		list=db.selectQuery("com.vo.DriverPolicyVO", query);
		return list;
	}
	
	/**
	 * save all values into database
	 * @param vo
	 */
	public void save(DriverPolicyVO vo) 
	{
		// TODO Auto-generated method stub
		String namequery=driverutil.drivercodequery(vo);
		list=db.selectQuery("com.vo.DriverPolicyVO", namequery);
		vo1=(DriverPolicyVO)list.get(0);
		String insertquery=driverutil.insertquery(vo, vo1);
		db.otherQuery(insertquery);
	}
	
	/**
	 * retrieve all values from database
	 * @param id
	 * @return list
	 */
	public ArrayList comboretrieve1(int id)
	{
		// TODO Auto-generated method stub
		String query=driverutil.retrieveallvalues(id);
		list=db.selectQuery("com.vo.DriverPolicyVO", query);
		logger.debug("array sizze in select dao:"+list.size());
		return list;
	}
	
	/**
	 * retrieve driver name by comparing lookup and driver_insurance table
	 * @return list
	 */
	public ArrayList retrieveall() 
	{
		// TODO Auto-generated method stub
		String query=driverutil.retrievealldrivervalues();
		list=db.selectQuery("com.vo.DriverPolicyVO", query);
		return list;
	}
	
	/**
	 * retrieve driver id desc from lookup
	 * @param driverId
	 * @return list
	 */	
	public ArrayList idretrieve(String driverId)
	{
		// TODO Auto-generated method stub
		String query=util.driveriddescquery(driverId);
		list=db.selectQuery("com.vo.DriverPolicyVO", query);
		return list;
	}
	
	/**
	 * 
	 * @param vo
	 * @param driverId
	 */
	public void update(DriverPolicyVO vo, String driverId)
	{
		// TODO Auto-generated method stub
		String namequery=driverutil.drivercodequery(vo);
		list=db.selectQuery("com.vo.DriverPolicyVO", namequery);
		vo1=(DriverPolicyVO)list.get(0);
		String query=driverutil.updatequery(vo,driverId, vo1);
		db.otherQuery(query);
	}
	
	

}
