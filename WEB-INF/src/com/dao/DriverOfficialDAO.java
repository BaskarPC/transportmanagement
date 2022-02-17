package com.dao;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import com.dbcom.dbcom;
import com.vo.DriverOfficialVO;
import com.util.OperationsGeneralLookupUtil;
import com.util.DriverOfficialUtil;


public class DriverOfficialDAO {
	dbcom db=new dbcom();
	ArrayList list =new ArrayList();
	OperationsGeneralLookupUtil operationsutil= new OperationsGeneralLookupUtil();
	private static final Logger logger=(Logger)Logger.getLogger(DriverOfficialDAO.class);
	DriverOfficialVO vo =new DriverOfficialVO(); 
	DriverOfficialUtil driverutil=new DriverOfficialUtil();
	
	/**
	 * retrieve institute names from database
	 * @param vo
	 * @return list
	 * @throws Exception
	 */
	public ArrayList institutecombo(DriverOfficialVO vo)throws Exception
	{
		String query=operationsutil.institutionQuery();
	    list=db.selectQuery("com.vo.DriverOfficialVO", query);
	     return list;
	 }
	/**
	 * retrieve departmentnames from database
	 * @param vo
	 * @return list
	 * @throws Exception
	 */
	public ArrayList departmentcombo(DriverOfficialVO vo)throws Exception
	{
		String query=operationsutil.departmentQuery();
	    list=db.selectQuery("com.vo.DriverOfficialVO", query);
	    logger.debug("arraysize(dept) in dao"+list.size());
	     return list;
	}
	/**
	 * retrieve blood group values from database
	 * @param vo
	 * @return
	 */
	public ArrayList bloodgpcombo(DriverOfficialVO vo) {
		// TODO Auto-generated method stub
		String query=operationsutil.bloodgpQuery();
		list=db.selectQuery("com.vo.DriverOfficialVO", query);
		logger.debug("arraysize(blood) in dao"+list.size());
		return list;
	}
	/**
	 * save values into database
	 * @param vo
	 */
	public void save(DriverOfficialVO vo) {
		// TODO Auto-generated method stub
		logger.debug("driverid in dao in save:"+vo.getDriverId());
		String query=driverutil.insert(vo);
		db.otherQuery(query);
		
	}
	/**
	 * retrieve code for driver id
	 * @param driverid
	 * @return
	 */
	public ArrayList idcoderetrieve(String driverid) {
		// TODO Auto-generated method stub
		String idquery=driverutil.driveridcodequery(driverid);
		list=db.selectQuery("com.vo.DriverOfficialVO", idquery);
		vo=(DriverOfficialVO)list.get(0);
		return list;
	}
	public ArrayList idretrieve(String driverId) {
		// TODO Auto-generated method stub
		String query=operationsutil.driveriddescquery(driverId);
		list=db.selectQuery("com.vo.DriverOfficialVO", query);
		return list;
	}
	public void update(DriverOfficialVO vo, String driverid) {
		// TODO Auto-generated method stub
		String query=driverutil.updatequery(vo, driverid);
		db.otherQuery(query);
		logger.debug("inst name:"+vo.getInstituteName());
		
	}
	public ArrayList retrieveall(String driverId) {
		// TODO Auto-generated method stub
		String query="select INSTITUTE_NAME,DEPT,EDUCATIONAL_QUALIFICATION,MARKS,TRANSPORT_EXP,NON_TRANSPORT_EXP,DESC_NON_TRANSPORT_EXP,BLOOD_GROUP,LICENCE_NO,INSURANCE_NO from DRIVER_OFFICIAL where DRIVER_ID="+driverId+" AND DEL_IND='N'";
		list=db.selectQuery("com.vo.DriverOfficialVO", query);
		logger.debug("arraysize in dao"+list.size());
		return list;
	}
	
}
