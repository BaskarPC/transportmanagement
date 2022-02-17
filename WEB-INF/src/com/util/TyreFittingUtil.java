package com.util;

import org.apache.log4j.Logger;
import com.formbean.TyreFittingForm;
import com.vo.TyreFittingVO;

public class TyreFittingUtil {
	
	private static final Logger logger=(Logger)Logger.getLogger(TyreFittingUtil.class);
	TyreFittingForm tyrefittingform = new TyreFittingForm();
	
   public String tyreSizeQuery()
   {
	     String ctype="TYRESIZE";
	     String query= new StringBuffer("select CODE as TYRESIZECODE,CDESC as TYRESIZECDESC from  ")	
		.append("LOOKUP ")
		.append("where CTYPE='")
		.append(ctype)
	 	.append("'").toString();

    return query;
    }
    public String tyreBrandQuery()
    {
	     String ctype="TYREBRAND";
	     String query= new StringBuffer("select CODE as TYREBRANDCODE,CDESC as TYREBRANDCDESC from  ")	
		.append("LOOKUP ")
		.append("where CTYPE='")
		.append(ctype)
	 	.append("'").toString();
	     return query;
    }
    
    public String tyrePlyQuery()
    {
	     String ctype="TYREPLY";
	     String query= new StringBuffer("select CODE as TYREPLYCODE,CDESC as TYREPLYCDESC from ")	
		.append("LOOKUP ")
		.append("where CTYPE='")
		.append(ctype)
	 	.append("'").toString();
	     return query;
    }
    
    public String tyreNumberQuery(int tyreSize,int tyreBrand,int tyrePly)
    {
    	 String query="select TYRENUMBER from tyremaster where TYREBRAND="+tyreBrand+" and TYRESIZE="+tyreSize+" and TYREPLY="+tyrePly+" and FIT_INDICATOR='N' and USE_INDICATOR='Y'";
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
	     String query="select CDESC as TDESC,CODE as TCODE from LOOKUP where CODE in (select distinct(VEHICLE_TYPE) as VEHICLE_TYPE from bus_allotment where INSTITUTE_NAME="+institutionName+")";
		 return query;
    }
    
    public String vehicleNumberQuery(int vehicleType) {
		 String query="select CDESC as VDESC,CODE as VCODE from LOOKUP where CODE in (select distinct(VEHICLE_ID) as VEHICLE_NUMBER from bus_allotment where VEHICLE_TYPE="+vehicleType+")";
		 return query;
	}
  
    public String vehicleTypeQuery()
    {
	     String ctype="vehicletype";
	     String query= new StringBuffer("select CODE,CTYPE,CDESC from ")	
		.append("LOOKUP ")
		.append("where CTYPE='")
		.append(ctype)
	 	.append("'").toString();
	    return query;
    }
    
    public String vehicleNumberQuery()
    {
	     String ctype="vehiclenumber";
	     String query= new StringBuffer("select CODE,CTYPE,CDESC from ")	
		.append("LOOKUP ")
		.append("where CTYPE='")
		.append(ctype)
	 	.append("'").toString();
	     return query;
    }
    
    public String tyrePositionQuery()
    {
    	 String ctype="TYREPOSITION";
	     String query= new StringBuffer("select CODE as TYREPOSITIONCODE,CTYPE as TYREPOSITIONCTYPE,CDESC as TYREPOSITIONCDESC from ")	
		.append("LOOKUP ")
		.append("where CTYPE='")
		.append(ctype)
	 	.append("'").toString();
	     return query;
    }
    
    public String tyreStatusQuery(String tyreNumber)
    {
    	 String query="select TYRESTATUS from tyremaster where TYRENUMBER='"+tyreNumber+"'";
    	 return query;
    }
    
    public String updateTyreMaster(String tyreNumber)
    {
    	String query="update tyremaster set FIT_INDICATOR='Y' where TYRENUMBER='"+tyreNumber+"'";
    	return query;
    }
    
    public String insertQuery(TyreFittingVO tyrefittingvo)
    {
	      
	      String TYRENUMBER=tyrefittingvo.getTyreNumber();
	      String VEHICLENUMBER=tyrefittingvo.getVehicleNumber();
	      String TYREPOSITION=tyrefittingvo.getTyrePosition();
	      String TYRESTATUS=tyrefittingvo.getTyreStatus();
	      String FITTINGDATE=tyrefittingvo.getFittingDate();
	      String FITTINGKM=tyrefittingvo.getFittingKM(); 
	      String R_INDICATOR="N";
	      	        	
	     String query= new StringBuffer("insert into tyrefitting values(")	
	    .append("'")
	    .append(TYRENUMBER)
	    .append("','")
		.append(VEHICLENUMBER)
		.append("','")
		.append(TYREPOSITION)
	    .append("','")
	    .append(TYRESTATUS)
	    .append("','")
	 	.append(FITTINGDATE)
	 	.append("','")
	 	.append(FITTINGKM)
	    .append("','")
	  	.append(R_INDICATOR).append("')").toString(); 
	     return query;
	    }
	
}
