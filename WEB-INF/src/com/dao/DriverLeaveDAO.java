package com.dao;

import java.util.ArrayList;
import org.apache.log4j.Logger;
import com.dbcom.*;
import com.vo.DriverLeaveVO;
import com.util.DriverLeaveUtil;
import com.util.OperationsGeneralLookupUtil;

public class DriverLeaveDAO {
	
		private static final Logger logger=(Logger)Logger.getLogger(DriverLeaveDAO.class);
		dbcom db=new dbcom();
		ArrayList list=new ArrayList();
		ArrayList list1=new ArrayList();
		OperationsGeneralLookupUtil util=new OperationsGeneralLookupUtil();
		DriverLeaveUtil driverutil =new DriverLeaveUtil();
		/**
		 * retrieve driver id values from lookup
		 * @param vo
		 * @return list
		 */
		public ArrayList driveridcombo(DriverLeaveVO vo)
		{
		logger.debug("DriverLeaveDAO:driveridcombo---------->");
		String query=util.driveridQuery();
		list=db.selectQuery("com.vo.DriverLeaveVO", query);
		logger.debug("DriverLeaveDAO:driveridcombo<----------");
		return list;
		}
		
		/**
		 * retrieve driver name from lookup
		 * @param id
		 * @return list
		 */
	 	public ArrayList comboretrieve(int id) {
		// TODO Auto-generated method stub
		logger.debug("DriverLeaveDAO: comboretrieve<----------");
		DriverLeaveVO vo=new DriverLeaveVO();
		String query="select CDESC as DRIVERNAME from LOOKUP where CODE in( select distinct(DRIVER_NAME) from DRIVER_PERSONAL where DRIVER_ID="+id+")";
		list=db.selectQuery("com.vo.DriverLeaveVO", query);
		vo=(DriverLeaveVO)list.get(0);
		logger.debug("driver desc in comboretrieve:"+vo.getDriverdesc());
		logger.debug("driver name in comboretrieve:"+vo.getDriverName());
		logger.debug("array size in comboretrieve:"+list.size());
		logger.debug("DriverLeaveDAO: comboretrieve---------->");
		return list;
	 	}

	 	/**
	 	 * save values into database
	 	 * @param vo
	 	 */
	 	public void insert(DriverLeaveVO vo) 
	 	{
		// TODO Auto-generated method stub
		logger.debug("DriverLeaveDAO: insert<----------");
		DriverLeaveVO vo1=new DriverLeaveVO();
		DriverLeaveVO vo2=new DriverLeaveVO();
		//String query="select CODE as DRIVERNAME from lookup where CDESC='"+vo.getDriverName()+"'";
		String query=driverutil.drivercodequery(vo);
		list=db.selectQuery("com.vo.DriverLeaveVO",query );
		logger.debug("array list size of driver code in action:"+list.size());
		vo1=(DriverLeaveVO)list.get(0);
		logger.debug("driver name in code in dao:"+vo1.getDriverName());
		//String query1="select CODE as DEPARTMENT from lookup where CDESC='"+vo.getDepartment()+"'";
		String deptquery=driverutil.deptcodequery(vo);
		list1=db.selectQuery("com.vo.DriverLeaveVO",deptquery);
		vo2=(DriverLeaveVO)list1.get(0);
		logger.debug("dept in code in action:"+vo2.getDepartment());
		String insertquery=driverutil.insertquery(vo, vo1, vo2);
		db.otherQuery(insertquery);
		//db.otherQuery("insert into driver_leave values("+vo.getDriverId()+","+vo1.getDriverName()+","+vo2.getDepartment()+","+vo.getNoOfDaysLeaveRequired()+","+vo.getLeaveAlreadyTaken()+","+vo.getCasualLeave()+","+vo.getCompensationLeave()+","+vo.getMedicalLeave()+","+vo.getVacationLeave()+")");
		logger.debug("DriverLeaveDAO: insert---------->");
	 	}

	 	/**
	 	 * retrieve values from database
	 	 * @param id
	 	 * return list
	 	 */
	 	public ArrayList retrieve(int id) 
	 	{
		// TODO Auto-generated method stub
		logger.debug("DriverLeaveDAO: retrieve<----------");
		//String query="select LEAVE_ALREADY_TAKEN,CASUAL_LEAVE,COMPENSATION_LEAVE,MEDICAL_LEAVE,VACATION_LEAVE FROM DRIVER_LEAVE WHERE DRIVER_ID='"+id+"'";
		String query=driverutil.retrievequery(id);
		list=db.selectQuery("com.vo.DriverLeaveVO", query);
		logger.debug("DriverLeaveDAO: retrieve---------->");
		return list;
	 	}
	 	
	 	/**
	 	 * retrieve department code, department name by comparing lookup and driver_official table
	 	 * @param id
	 	 * @return list
	 	 */
	 	public ArrayList deptretrieve(int id)
	 	{
		// TODO Auto-generated method stub
		logger.debug("DriverLeaveDAO: deptretrieve<----------");
		String query="select CDESC as DEPARTMENT,CODE as DEPTCODE from LOOKUP where CODE in( select distinct(DEPT) from DRIVER_OFFICIAL where DRIVER_ID='"+id+"')";
		list=db.selectQuery("com.vo.DriverLeaveVO", query);
		logger.debug("DriverLeaveDAO: deptretrieve---------->");
		return list;
	 	}
	 	
	 	/**
	 	 * retrieve all values from database
	 	 * @param id
	 	 * @return list
	 	 */
	 	public ArrayList leavetaken(int id)
	 	{
		// TODO Auto-generated method stub
		DriverLeaveVO vo= new DriverLeaveVO();
		logger.debug("DriverLeaveDAO: leavetaken<----------");
		//String query="select NO_DAYS_LEAVE,LEAVE_ALREADY_TAKEN from DRIVER_LEAVE where DRIVER_ID='"+id+"'";
		String query=driverutil.leavetakenquery(id);
		list=db.selectQuery("com.vo.DriverLeaveVO", query);
		vo=(DriverLeaveVO)list.get(0);
		logger.debug("leave already taken from dao:"+vo.getLeaveAlreadyTaken());
		logger.debug("DriverLeaveDAO: leavetaken---------->");
		return list;
	 	}
	 	
	 	/**
	 	 * retrieve medical days from detabase
	 	 * @param id
	 	 * @return list
	 	 */
	 	public ArrayList medicalcal(int id)
	 	{
		// TODO Auto-generated method stub
		logger.debug("DriverLeaveDAO: medicalcal<----------");
		//String query="select MEDICAL_LEAVE from DRIVER_LEAVE where DRIVER_ID='"+id+"'";
		String query=driverutil.medicalleavequery(id);
		list=db.selectQuery("com.vo.DriverLeaveVO", query);
		logger.debug("DriverLeaveDAO: medicalcal---------->");
		return list;
	 	}
	 	
	 	/**
	 	 * retrieve vacation days from database
	 	 * @param id
	 	 * @return list
	 	 */
	 	public ArrayList vacationcal(int id)
	 	{
		// TODO Auto-generated method stub
		logger.debug("DriverLeaveDAO: vacationcal<----------");
		//String query="select VACATION_LEAVE from DRIVER_LEAVE where DRIVER_ID='"+id+"'";
		String query=driverutil.vacationleavequery(id);
		list=db.selectQuery("com.vo.DriverLeaveVO", query);
		logger.debug("DriverLeaveDAO: vacationcal---------->");
		return list;
	 	}
	 	
	 	/**
	 	 * retrieve driver desc, driver name by comparing lookup and driver_leave table
	 	 * @return list
	 	 */
	 	public ArrayList retrieveall()
	 	{
		// TODO Auto-generated method stub
		logger.debug("DriverLeaveDAO: retrieveall<----------");
		String query="select CDESC as DRIVERDESC from LOOKUP where CODE IN(select distinct(DRIVER_ID) from DRIVER_LEAVE)";
		list=db.selectQuery("com.vo.DriverLeaveVO", query);
		logger.debug("DriverLeaveDAO: retrieveall---------->");
		return list;
		}
	 	
	 	/**
	 	 * retrieve driverid desc from lookup
	 	 * @param driverId
	 	 * @return list
	 	 */
	 	public ArrayList idretrieve(String driverId)
	 	{
		// TODO Auto-generated method stub
		logger.debug("DriverLeaveDAO: idretrieve<----------");
		//String query="select CDESC as DRIVERDESC from LOOKUP where CODE='"+driverId+"'";
		String query=util.driveriddescquery(driverId);
		list=db.selectQuery("com.vo.DriverLeaveVO", query);
		logger.debug("DriverLeaveDAO: idretrieve---------->");
		return list;
	 	}
	 	
	 	/**
	 	 * update the values into the database
	 	 * @param vo
	 	 * @param driverId
	 	 */
	 	public void update(DriverLeaveVO vo, String driverId)
	 	{
		// TODO Auto-generated method stub
		logger.debug("DriverLeaveDAO: update<----------");
		DriverLeaveVO vo1=new DriverLeaveVO();
		DriverLeaveVO vo2=new DriverLeaveVO();
		//String query="select CODE as DRIVERNAME from lookup where CDESC='"+vo.getDriverName()+"'";
		String query=driverutil.drivercodequery(vo);
		list=db.selectQuery("com.vo.DriverLeaveVO",query );
		logger.debug("array list size of driver code in action:"+list.size());
		vo1=(DriverLeaveVO)list.get(0);
		logger.debug("driver name in code in dao:"+vo1.getDriverName());
		//String query1="select CODE as DEPARTMENT from lookup where CDESC='"+vo.getDepartment()+"'";
		String deptquery=driverutil.deptcodequery(vo);
		list1=db.selectQuery("com.vo.DriverLeaveVO",deptquery );
		vo2=(DriverLeaveVO)list1.get(0);
		logger.debug("dept in code in action:"+vo2.getDepartment());
		db.otherQuery("UPDATE DRIVER_LEAVE set DRIVER_NAME="+vo1.getDriverName()+",DEPT="+vo2.getDepartment()+",NO_DAYS_LEAVE="+vo.getNoOfDaysLeaveRequired()+",LEAVE_ALREADY_TAKEN="+vo.getLeaveAlreadyTaken()+",CASUAL_LEAVE="+vo.getCasualLeave()+",COMPENSATION_LEAVE="+vo.getCompensationLeave()+",MEDICAL_LEAVE="+vo.getMedicalLeave()+",VACATION_LEAVE="+vo.getVacationLeave()+" WHERE DRIVER_ID="+driverId+""); 
		logger.debug("DriverLeaveDAO: update<----------");
	 	}
}
