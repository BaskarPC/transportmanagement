package com.util;

import org.apache.log4j.Logger;
public class CondemnTyreUtil {
	private static final Logger logger=(Logger)Logger.getLogger(CondemnTyreUtil.class);
	
	/**
	 * Query to display the tyresize in combo
	 * @return
	 */
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
   
   /**
    * Query to display the tyrebrand in combo
    * @return
    */
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
    
    /**
     * Query to display the tyreply in combo
     * @return
     */
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
    
    /**
     * Query to display the tyrenumbers in combo
     * @param tyreSize
     * @param tyreBrand
     * @param tyrePly
     * @return
     */
    public String tyreNumberQuery(int tyreSize,int tyreBrand,int tyrePly)
    {
    	 String query="select TYRENUMBER from tyremaster where TYREBRAND="+tyreBrand+" and TYRESIZE="+tyreSize+" and TYREPLY="+tyrePly+" and FIT_INDICATOR='N' and USE_INDICATOR='Y'";
    	 return query;
    }
    
    /**
     * Query to set the tyrestatus in the textbox
     * @param tyreNumber
     * @return
     */
    public String tyreStatusQuery(String tyreNumber)
    {
    	String query="select TYRESTATUS from tyremaster where TYRENUMBER='"+tyreNumber+"'";
    	return query;
    }
    
    /**
     * Query to update the use_indicator value in the tyremaster table
     * @param tyreNumber
     * @return
     */
    public String updateTyreMasterQuery(String tyreNumber)
    {
    	String query="update tyremaster set USE_INDICATOR='N' where TYRENUMBER='"+tyreNumber+"'";
    	return query;
    }
    
    /**
     * Query to insert the values in the database
     * @param tyreNumber
     * @param tyreStatus
     * @param condemnDate
     * @param condemnReason
     * @return
     */
    public String insertQuery(String tyreNumber,String tyreStatus,String condemnDate,String condemnReason)
    {
	     String TYRENUMBER=tyreNumber;
	     String TYRESTATUS=tyreStatus;
	     String CONDEMNDATE=condemnDate;
	     String CONDEMNREASON=condemnReason;
	     String query= new StringBuffer("insert into condemntyre values(")	
	    .append("'")
	    .append(TYRENUMBER)
	    .append("','")
	    .append(TYRESTATUS)
	    .append("','")
	    .append(CONDEMNDATE)
	    .append("','")
	    .append(CONDEMNREASON)
	    .append("')").toString(); 
	     return query;
    } 
   
}


