package com.util;

import org.apache.log4j.Logger;
public class GeneralLookupUtil {
	private static final Logger logger=(Logger)Logger.getLogger(TyreFittingUtil.class);
	
   public String tyreSizeQuery()
    {
    String ctype="tyresize";
     String query= new StringBuffer("select CODE,CTYPE,CDESC from ")	
	.append("TYRELOOKUP ")
	.append("where CTYPE='")
	.append(ctype)
 	.append("'").toString();
    return query;
    }
    public String tyreBrandQuery()
    {
     String ctype="tyrebrand";
     String query= new StringBuffer("select CODE,CTYPE,CDESC from ")	
	.append("TYRELOOKUP ")
	.append("where CTYPE='")
	.append(ctype)
 	.append("'").toString();
    return query;
    }
    
    public String tyrePlyQuery()
    {
    	String ctype="tyreply";
     String query= new StringBuffer("select CODE,CTYPE,CDESC from ")	
	.append("TYRELOOKUP ")
	.append("where CTYPE='")
	.append(ctype)
 	.append("'").toString();
    return query;
    }
    
    public String tyreNumberQuery()
    {
    	String ctype="tyrenumber";
     String query= new StringBuffer("select CODE,CTYPE,CDESC from ")	
	.append("TYRELOOKUP ")
	.append("where CTYPE='")
	.append(ctype)
 	.append("'").toString();
    return query;
    }
	
    public String institutionQuery()
    {
    	String ctype="institution";
     String query= new StringBuffer("select CODE,CTYPE,CDESC from ")	
	.append("LOOKUP ")
	.append("where CTYPE='")
	.append(ctype)
 	.append("'").toString();
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
    	String ctype="tyreposition";
     String query= new StringBuffer("select CODE,CTYPE,CDESC from ")	
	.append("TYRELOOKUP ")
	.append("where CTYPE='")
	.append(ctype)
 	.append("'").toString();
     return query;
    }
    
    
}
