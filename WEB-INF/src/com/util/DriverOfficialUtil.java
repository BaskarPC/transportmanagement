package com.util;

import com.vo.DriverOfficialVO;

public class DriverOfficialUtil {

	
	public String insert(DriverOfficialVO vo)
	{
		String query="insert into driver_official values("+vo.getDriverId()+","+vo.getInstituteName()+","+vo.getDepartment()+",'"+vo.getEducationalQualification()+"',"+vo.getMarks()+",'"+vo.getTransport()+"','"+vo.getNonTransport()+"','"+vo.getNonTransportDesc()+"','"+vo.getBloodGroup()+"','"+vo.getLicenceNo()+"','"+vo.getInsuranceNo()+"','N')";
		return query;
	}
	
	public String driveridcodequery(String driverid)
	{
		String idquery="select CODE as DRIVERID from lookup where CDESC='"+driverid+"'";
		return idquery;
	}
	
	public String updatequery(DriverOfficialVO vo, String driverid)
	{
	String query="UPDATE DRIVER_OFFICIAL set INSTITUTE_NAME="+vo.getInstituteName()+",DEPT="+vo.getDepartment()+",EDUCATIONAL_QUALIFICATION='"+vo.getEducationalQualification()+"',MARKS="+vo.getMarks()+",TRANSPORT_EXP='"+vo.getTransport()+"',NON_TRANSPORT_EXP='"+vo.getNonTransport()+",DESC_NON_TRANSPORT_EXP='"+vo.getNonTransportDesc()+"',BLOOD_GROUP="+vo.getBloodGroup()+",LICENCE_NO='"+vo.getLicenceNo()+"',INSURANCE_NO='"+vo.getInsuranceNo()+"',DEL_IND='N' where DRIVER_ID="+driverid+"";
	return query;
	}
}
