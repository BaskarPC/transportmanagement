package com.util;

import com.vo.DriverLeaveVO;;

public class DriverLeaveUtil {
	
	
	
	/**
	 * retrieve drivercode from lookup
	 * @param vo
	 * @return string
	 */
	public String drivercodequery(DriverLeaveVO vo)
	{
	String desc=vo.getDriverName();
     String query= new StringBuffer("select CODE as DRIVERNAME from ")	
	.append("LOOKUP ")
	.append("where CDESC='")
	.append(desc)
 	.append("'").toString();
    return query;
	}
	
	

	/**
	 * retrieve departmentcode from lookup
	 * @param vo
	 * @return string
	 */
	public String deptcodequery(DriverLeaveVO vo)
	{
	String desc=vo.getDepartment();
     String query= new StringBuffer("select CODE as DEPARTMENT from ")	
	.append("LOOKUP ")
	.append("where CDESC='")
	.append(desc)
 	.append("'").toString();
    return query;
	}
	
	/**
	 * insert values into the database
	 * @param vo
	 * @param vo1
	 * @param vo2
	 * @return
	 */
	public String insertquery(DriverLeaveVO vo,DriverLeaveVO vo1,DriverLeaveVO vo2)
	{
		String DRIVER_ID=vo.getDriverId();
		String DRIVER_NAME=vo1.getDriverName();
		String DEPT=vo2.getDepartment();
		String NOOFDAYS=vo.getNoOfDaysLeaveRequired();
		String LEAVEALREADY=vo.getLeaveAlreadyTaken();
		String CASUAL_LEAVE=vo.getCasualLeave();
		String COMPENSATION_LEAVE=vo.getCompensationLeave();
		String MEDICAL_LEAVE=vo.getMedicalLeave();
		String VACATION_LEAVE=vo.getVacationLeave();
		String query=new StringBuffer("insert into driver_leave values(")
		.append(DRIVER_ID)
		.append(",")
		.append(DRIVER_NAME)
		.append(",")
		.append(DEPT)
		.append(",")
		.append(NOOFDAYS)
		.append(",")
		.append(LEAVEALREADY)
		.append(",")
		.append(CASUAL_LEAVE)
		.append(",")
		.append(COMPENSATION_LEAVE)
		.append(",")
		.append(MEDICAL_LEAVE)
		.append(",")
		.append(VACATION_LEAVE)
		.append(")").toString();
		return query;
		}
	
	/**
	 * retrieve leave values from database 
	 * @param id
	 * @return string
	 */
	public String retrievequery(int id)
	{
		String query=new StringBuffer("select LEAVE_ALREADY_TAKEN,CASUAL_LEAVE,COMPENSATION_LEAVE,MEDICAL_LEAVE,VACATION_LEAVE FROM")
		.append("DRIVER_LEAVE")
		.append("WHERE DRIVER_ID=")
		.append(id).toString();
		return query;
	}
	
	/**
	 * retrieve no of days leave,leave already taken from database
	 * @param id
	 * @return string
	 */
	public String leavetakenquery(int id)
	{
		String query=new StringBuffer("select NO_DAYS_LEAVE,LEAVE_ALREADY_TAKEN from")
		.append("DRIVER_LEAVE")
		.append("where DRIVER_ID=")
		.append(id).toString();
		return query;
	}
	
	/**
	 * retrieve medical leave from database
	 * @param id
	 * @return string
	 */
	public String medicalleavequery(int id)
	{
		String query=new StringBuffer("select MEDICAL_LEAVE from")
		.append("DRIVER_LEAVE")
		.append("where DRIVER_ID=")
		.append(id).toString();
		return query;
	}
	
	/**
	 * retrieve vacationleave from database
	 * @param id
	 * @return string
	 */
	public String vacationleavequery(int id)
	{
		String query=new StringBuffer("select VACATION_LEAVE from")
		.append("DRIVER_LEAVE")
		.append("where DRIVER_ID=")
		.append(id).toString();
		return query;
	}
	
	/**
	 * updata values in the database
	 * @param vo
	 * @param driverId
	 * @param vo1
	 * @param vo2
	 * @return
	 */
	public String updatequery(DriverLeaveVO vo, String driverId,DriverLeaveVO vo1,DriverLeaveVO vo2)
	{
	String query="UPDATE DRIVER_LEAVE set DRIVER_NAME="+vo1.getDriverName()+",DEPT="+vo2.getDepartment()+",NO_DAYS_LEAVE="+vo.getNoOfDaysLeaveRequired()+",LEAVE_ALREADY_TAKEN="+vo.getLeaveAlreadyTaken()+",CASUAL_LEAVE="+vo.getCasualLeave()+",COMPENSATION_LEAVE="+vo.getCompensationLeave()+",MEDICAL_LEAVE="+vo.getMedicalLeave()+",VACATION_LEAVE="+vo.getVacationLeave()+" WHERE DRIVER_ID="+driverId+"";
	return query;
	}
	

}
