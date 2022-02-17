package com.util;

import com.vo.DriverPolicyVO;;

public class DriverPolicyUtil {
	
	/**
	 * retrieve all drivernames by comparing lookup and driver_personal
	 * @param id
	 * @return string
	 */
	public String retrievealldrivers(int id)
	{
	String query="select CDESC as DRIVER_NAME from LOOKUP where CODE in( select distinct(DRIVER_NAME) from DRIVER_PERSONAL where DRIVER_ID="+id+")";
	return query;
	}
	
	/**
	 * retrieve driver code value from lookup
	 * @param vo
	 * @return string
	 */
	public String drivercodequery(DriverPolicyVO vo)
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
	 * inserting values into database
	 * @param vo
	 * @param vo1
	 * @return string
	 */
	public String insertquery(DriverPolicyVO vo,DriverPolicyVO vo1)
	{
		String query ="insert into DRIVER_INSURANCE values("+vo.getDriverId()+","+vo1.getDriverName()+",'"+vo.getPolicyNo()+"','"+vo.getPolicyName()+"','"+vo.getCoverage()+"',"+vo.getPremiumAmt()+",'"+vo.getInsuranceCmpyAddress()+"','"+vo.getValidFrom()+"','"+vo.getValidTo()+"','"+vo.getTieUp()+"','"+vo.getCompensationAmt()+"','"+vo.getHospitalExpenses()+"','"+vo.getBuffer()+"','"+vo.getConstraints()+"','N')";
		return query;
	}
	
	/**
	 * retrieve all values from database
	 * @param id
	 * @return string
	 */
	public String retrieveallvalues(int id)
	{
	String query=new StringBuffer("select POLICY_NO,POLICY_NAME,COVERAGE,PREMIUM_AMT,INSUR_CMPY_ADDRESS,TO_CHAR(VALID_FROM,'dd Mon yyyy') as VALID_FROM,TO_CHAR(VALID_TO,'dd Mon yyyy') as VALID_TO,TIEUP_HOSPITALS,COMPENSATION_AMT,HOSPITAL_AMT,BUFFER_AMT,CONSTRAINTS FROM")
	.append("DRIVER_INSURANCE")
	.append("WHERE DRIVER_ID=")
	.append(id)
	.append("AND DEL_IND='N'").toString();
	return query;
	}
	
	/**
	 * retrieve all  drivers from driver_insurance table
	 * @return string
	 */
	public String retrievealldrivervalues()
	{
		String query="select CDESC as DRIVERDESC from LOOKUP where CODE IN(select distinct(DRIVER_ID) from DRIVER_INSURANCE)";
		return query;
	}
	
	/**
	 * update values in the database
	 * @param vo
	 * @param driverId
	 * @param vo1
	 * @return string
	 */
	public String updatequery(DriverPolicyVO vo,String driverId,DriverPolicyVO vo1)
	{
		String query="UPDATE DRIVER_INSURANCE set DRIVER_NAME="+vo1.getDriverName()+",POLICY_NO='"+vo.getPolicyNo()+"',POLICY_NAME='"+vo.getPolicyName()+"',COVERAGE='"+vo.getCoverage()+"',PREMIUM_AMT="+vo.getPremiumAmt()+",INSUR_CMPY_ADDRESS='"+vo.getInsuranceCmpyAddress()+"',VALID_FROM='"+vo.getValidFrom()+"',VALID_TO='"+vo.getValidTo()+"',TIEUP_HOSPITALS='"+vo.getTieUp()+"',COMPENSATION_AMT='"+vo.getCompensationAmt()+"',HOSPITAL_AMT='"+vo.getHospitalExpenses()+"',BUFFER_AMT='"+vo.getBuffer()+"',CONSTRAINTS='"+vo.getConstraints()+"',DEL_IND='N' WHERE DRIVER_ID="+driverId+"";
		return query;
	}
	

}
