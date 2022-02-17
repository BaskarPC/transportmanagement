package com.util;

import org.apache.log4j.Logger;
import com.vo.DieselVO;

public class GeneralUtil {
	private static final Logger logger=(Logger)Logger.getLogger(GeneralUtil.class);
	DieselVO vo=new DieselVO();
	/**
	 * retrieve institution name
	 * @return
	 * @throws Exception
	 */
	public String fetchInst()throws Exception
	{
		logger.debug("GeneralUtil:fetchInst<----------");
		String ctype="institution";
    	String query= new StringBuffer("select CDESC as ICDESC,CODE as ICODE from ")	
		.append("LOOKUP ")
		.append("where CTYPE='")
		.append(ctype)
	 	.append("'").toString();
    	logger.debug("GeneralUtil:fetchInst---------->");
	    return query;
	}
	/**
	 * retrieve vehicle type
	 * @return
	 * @throws Exception
	 */
	public String fetchType()throws Exception
	{
		logger.debug("GeneralUtil:fetchType<----------");
		String ctype="vehicletype";
    	String query= new StringBuffer("select CDESC as TDESC,CODE as TCODE from ")	
		.append("LOOKUP ")
		.append("where CTYPE='")
		.append(ctype)
	 	.append("'").toString();
    	logger.debug("GeneralUtil:fetchType---------->");
	    return query;
	}
	
	/**
	 * retrieve vehicle number 
	 * @return
	 * @throws Exception
	 */
	public String fetchVehicle()throws Exception
	{
		logger.debug("GeneralUtil:fetchVehicle<----------");
		String ctype="vehiclenumber";
    	String query= new StringBuffer("select CDESC as VDESC,CODE as VCODE from ")	
		.append("LOOKUP ")
		.append("where CTYPE='")
		.append(ctype)
	 	.append("'").toString();
    	logger.debug("GeneralUtil:fetchVehicle---------->");
	    return query;
	}
	/**
	 * retrieve corresponding vehicle type for the institution 
	 * @param institutionName
	 * @return
	 */
	public String instMethod(int institutionName) 
	{
		logger.debug("GeneralUtil:instMethod<---------->");
		String query="select CDESC as TDESC,CODE as TCODE from LOOKUP where CODE in (select distinct(VEHICLE_TYPE) as vehtype from bus_allotment where INSTITUTE_NAME="+institutionName+")";
		return query;
	}
	/**
	 * retrieve corresponding vehicle number for the vehicle type 
	 * @param vehicleType
	 * @return
	 */
	public String vehicleMethod(int vehicleType) {
		logger.debug("GeneralUtil:vehicleMethod<---------->");
		String query="select CDESC as VDESC,CODE as VCODE from LOOKUP where CODE in (select distinct(VEHICLE_ID) as vehtype from bus_allotment where VEHICLE_TYPE="+vehicleType+")";
		return query;
	}
	/**
	 * retrieve corresponding driver name for the vehicle  
	 * @param vehnum
	 * @return
	 */
	public String driverMethod(int vehnum) {
		logger.debug("GeneralUtil:driverMethod<---------->");
		String query="select ROUTE_NO as ROUTENUMBER,DRIVER_NAME as DRIVERNAME from bus_allotment where VEHICLE_ID="+vehnum+"";
		return query;
	}
    /**
     * retrieve code from lookup for the description
     * @param drivername
     * @return
     */
    public String convertToCode(String drivername) {
    	logger.debug("GeneralUtil:convertToCode<---------->");
      	 String query="select CODE as CONV from LOOKUP where CDESC='"+drivername+"'";
      	 return query;
      	}
    /**
     * retrieve description from lookup for the code
     * @param drivercode
     * @return
    */
    public String convertToDesc(String drivercode) {
    	logger.debug("GeneralUtil:convertToDesc<---------->");
		String query="select CDESC as CONV from LOOKUP where CODE='"+drivercode+"'";
		return query;
	}
    public String institutionQuery()
    {
    	String ctype="institution";
    	
     String query= new StringBuffer("select CDESC as CDESC,CODE as CODE from ")	
	.append("LOOKUP ")
	.append("where CTYPE='")
	.append(ctype)
 	.append("'").toString();
    return query;
    }
    
	
    public String vehicleTypeQuery(int institutionName) {
    String query="select CDESC as TDESC,CODE as TCODE from LOOKUP where CODE in (select distinct(VEHICLETYPE) as vehtype from vehicle where INSTNAME="+institutionName+")";
	return query;
    }
    
    public String vehicleNumberQuery(int vehicleType) {
		String query="select CDESC as VDESC,CODE as VCODE from LOOKUP where CODE in (select distinct(VEHICLEID) as vehtype from vehicle where VEHICLETYPE="+vehicleType+")";
		return query;
	}
    
    public String driverNameQuery(int vehicleNumber) {
		
		String query="select DRIVERNAME as DRIVERNAME from driverdetails where VEHICLENUMBER="+vehicleNumber+"";
		return query;
	}
    
    public String drivercodeQuery(String DRIVERNAME) {
		
      	 String query="select CODE as DRIVERCODE from LOOKUP where CDESC='"+DRIVERNAME+"'";
      	 return query;
      	}
       
    public String driverdescQuery(String Drivercode) 
     {
      	String query="select CDESC as DRIVERDESC from LOOKUP where CODE='"+Drivercode+"'";
      	return query;
     }
    public String serviceTypeQuery() {
		
	 String query="select CDESC as FDESC,CODE as FCODE from LOOKUP where CTYPE='fcreason'";
	return query;
	}
	public String convertToPlaceCode(String place, String servicestation) {
		// TODO Auto-generated method stub
		logger.debug("GeneralUtil:convertToPlaceCode<---------->");
     	 String query="select CODE as CONV from LOOKUP where CDESC='"+place+"' and CTYPE='"+servicestation+"'";
     	 return query;
	}
}
