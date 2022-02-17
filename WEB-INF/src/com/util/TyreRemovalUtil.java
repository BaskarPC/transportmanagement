package com.util;

import org.apache.log4j.Logger;
import com.service.TyreRemovalService;
import com.vo.TyreRemovalVO;

public class TyreRemovalUtil {
		private static final Logger logger=(Logger)Logger.getLogger(TyreRemovalService.class);
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
	  
	    public String tyreNumberQuery(int vehicleNumber)
	    {
	    	String query="select TYRENUMBER from tyrefitting where VEHICLENUMBER="+vehicleNumber+" and R_INDICATOR='N'" ;
	   	    return query;
	    }
	    public String tyreDetails(String tyreNumber)
	    {
	    	String query="select TYRESTATUS,TYREPOSITION,FITTINGKM from tyrefitting where TYRENUMBER='"+tyreNumber+"'";
	    	return query;
	    }
	    public String tyrePosition(int tyreposition)
	    {
	   	    String query="select CDESC as TYREPOSITIONCDESC from lookup where CODE="+tyreposition+"";
	   	    return query;
	    }
	    
	    /**
	     * To update the R_indicator in the tyrefitting table
	     * @param tyreNumber
	     * @return
	     */
	    
	    public String changeIndicator(String tyreNumber)
	    {
	    	String query="update tyrefitting set R_INDICATOR='Y' where TYRENUMBER='"+tyreNumber+"'";
	      	return query;
	    }
	    
	    /**
	     * To update the Fit_indicator in the tyre master table
	     * @param tyreNumber
	     * @return
	     */
	    
	    public String updateTyreMaster(String tyreNumber)
	    {
	    	String query="update tyremaster set FIT_INDICATOR='N' where TYRENUMBER='"+tyreNumber+"'";
	    	return query;
	    }
	    /**
	     * To insert the values in the tyreremoval table
	     * @param tyreremovalvo
	     * @return
	     */
	    public String insertQuery(TyreRemovalVO tyreremovalvo)
	    {
	    	
	    	String VEHICLENUMBER=tyreremovalvo.getVehicleNumber();
	    	String TYRENUMBER=tyreremovalvo.getTyreNumber();
	    	String TYRESTATUS=tyreremovalvo.getTyreStatus();
	      	String TYREPOSITION=tyreremovalvo.getTyrePosition();
	      	String REMOVALDATE=tyreremovalvo.getRemovalDate();
	      	String REMOVALKM=tyreremovalvo.getRemovalKM();
	      	String TOTALKM=tyreremovalvo.getTotalKM();
	      	String REMOVALREASON=tyreremovalvo.getRemovalReason();
      	    String query= new StringBuffer("insert into tyreremoval values(")
      	    
	      	.append("'")
			.append(VEHICLENUMBER)
			.append("','")
			.append(TYRENUMBER)
			.append("','")
		    .append(TYRESTATUS)
		    .append("','")
			.append(TYREPOSITION)
	        .append("','")
		 	.append(REMOVALDATE)
		 	.append("','")
		 	.append(REMOVALKM)
		 	.append("','")
		 	.append(TOTALKM)
		    .append("','")
			.append(REMOVALREASON).append("')").toString(); 
		     return query;
	   	}
}


