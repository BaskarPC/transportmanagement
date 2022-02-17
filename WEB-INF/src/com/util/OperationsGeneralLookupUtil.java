package com.util;

public class OperationsGeneralLookupUtil {
	/**
	 * retrieve institution from lookup
	 * @return String
	 */
	 public String institutionQuery()
	    {
	    	String ctype="institution";
	     String query= new StringBuffer("select CODE as INSTCODE,CDESC as INSTDESC from ")	
		.append("LOOKUP ")
		.append("where CTYPE='")
		.append(ctype)
	 	.append("'").toString();
	    return query;
	    }
	 
	 /**
	  * 
	  * @return
	  */
	 public String institution1Query()
	    {
	     String ctype="institution";
	     String query= new StringBuffer("select CODE as INST1CODE,CDESC as INST1DESC from ")	
		.append("LOOKUP ")
		.append("where CTYPE='")
		.append(ctype)
	 	.append("'").toString();
	    return query;
	    }
	 /**
	  * retrieve driver id from lookup
	  * @return String
	  */
	 
	 public String driveridQuery()
	    {
	    	String ctype="driverid";
	     String query= new StringBuffer("select CODE as DRIVERCODE,CDESC as DRIVERDESC from ")	
		.append("LOOKUP ")
		.append("where CTYPE='")
		.append(ctype)
	 	.append("'").toString();
	    return query;
	    }   
	 /**
	  * retrieve department from lookup
	  * @return String
	  */
	 
	 public String departmentQuery()
	    {
	    	String ctype="department";
	     String query= new StringBuffer("select CODE as DEPTCODE,CDESC as DEPTDESC from ")	
		.append("LOOKUP ")
		.append("where CTYPE='")
		.append(ctype)
	 	.append("'").toString();
	    return query;
	    }   
	 /**
	  * retrieve vehicle type from lookup
	  * @return String
	  */
	 
	    public String vehicleTypeQuery()
	    {
	    	String ctype="vehicletype";
	     String query= new StringBuffer("select CODE as VEHICLETYPECODE,CDESC as VEHICLETYPEDESC from ")	
		.append("LOOKUP ")
		.append("where CTYPE='")
		.append(ctype)
	 	.append("'").toString();
	    return query;
	    }
	    /**
		  * retrieve vehicle number from lookup
		  * @return String
		  */
		 
	    public String vehicleNumberQuery()
	    {
	    	String ctype="vehicleid";
	     String query= new StringBuffer("select CODE as VEHICLEIDCODE,CDESC as VEHICLEIDDESC from ")	
		.append("LOOKUP ")
		.append("where CTYPE='")
		.append(ctype)
	 	.append("'").toString();
	     return query;
	    }
	    /**
		  * retrieve Yes/No option from lookup
		  * @return String
		  */
		 
	    public String optionQuery()
	    {
	    	String ctype="roadtaxpaid";
	     String query= new StringBuffer("select CODE as OPTIONCODE,CDESC as OPTIONDESC from ")	
		.append("LOOKUP ")
		.append("where CTYPE='")
		.append(ctype)
	 	.append("'").toString();
	     return query;
	    }
	    /**
		  * retrieve period from lookup
		  * @return String
		  */
		 
	    public String periodQuery()
	    {
	     String ctype="period";
	     String query= new StringBuffer("select CODE as PERIODCODE,CDESC as PERIODDESC from ")	
		.append("LOOKUP ")
		.append("where CTYPE='")
		.append(ctype)
	 	.append("'").toString();
	     return query;
	    }
	    /**
		  * retrieve licence category from lookup
		  * @return String
		  */
		 
	    public String categoryQuery()
	    {
	     String ctype="licencecategory";
	     String query= new StringBuffer("select CODE as CATEGORYCODE,CDESC as CATEGORYDESC from ")	
		.append("LOOKUP ")
		.append("where CTYPE='")
		.append(ctype)
	 	.append("'").toString();
	     return query;
	    }
	    /**
		  * retrieve endorsement from lookup
		  * @return String
		  */
		 
	    public String endorsementQuery()
	    {
	     String ctype="endorsement";
	     String query= new StringBuffer("select CODE as ENDORSEMENTCODE,CDESC as ENDORSEMENTDESC from ")	
		.append("LOOKUP ")
		.append("where CTYPE='")
		.append(ctype)
	 	.append("'").toString();
	     return query;
	    }
	    /**
		  * retrieve driver id from lookup
		  * @return String
		  */
	    public String bloodgpQuery()
	    {
	     String ctype="bloodgroup";
	     String query= new StringBuffer("select CODE as BLOODGROUPCODE,CDESC as BLOODGROUPDESC from ")	
		.append("LOOKUP ")
		.append("where CTYPE='")
		.append(ctype)
	 	.append("'").toString();
	     return query;
	    }
	    /**
		  * retrieve district from lookup
		  * @return String
		  */
		 
	    public String district1Query()
	    {
	     String ctype="district";
	     String query= new StringBuffer("select CODE as DISTRICTCODE1,CDESC as DISTRICTDESC1 from ")	
		.append("LOOKUP ")
		.append("where CTYPE='")
		.append(ctype)
	 	.append("'").toString();
	     return query;
	    }
	    public String districtQuery()
	    {
	     String ctype="district";
	     String query= new StringBuffer("select CODE as DISTRICTCODE,CDESC as DISTRICTDESC from ")	
		.append("LOOKUP ")
		.append("where CTYPE='")
		.append(ctype)
	 	.append("'").toString();
	     return query;
	    }
	    /**
		  * retrieve district from lookup
		  * @return String
		  */
		 public String district2Query()
	    {
	     String ctype="district";
	     String query= new StringBuffer("select CODE as DISTRICTCODE2,CDESC as DISTRICTDESC2 from ")	
		.append("LOOKUP ")
		.append("where CTYPE='")
		.append(ctype)
	 	.append("'").toString();
	     return query;
	    }
	    /**
		  * retrieve state from lookup
		  * @return String
		  */
		 public String state1Query()
	    {
	     String ctype="state";
	     String query= new StringBuffer("select CODE as STATECODE1,CDESC as STATEDESC1 from ")	
		.append("LOOKUP ")
		.append("where CTYPE='")
		.append(ctype)
	 	.append("'").toString();
	     return query;
	    }
		 /**
		  * retrieve state from lookup
		  * @return String
		  */
	    public String state2Query()
	    {
	     String ctype="state";
	     String query= new StringBuffer("select CODE as STATECODE2,CDESC as STATEDESC2 from ")	
		.append("LOOKUP ")
		.append("where CTYPE='")
		.append(ctype)
	 	.append("'").toString();
	     return query;
	    }
	    /**
		  * retrieve community from lookup
		  * @return String
		  */
	    public String communityQuery()
	    {
	     String ctype="community";
	     String query= new StringBuffer("select CODE as COMMUNITYCODE,CDESC as COMMUNITYDESC from ")	
		.append("LOOKUP ")
		.append("where CTYPE='")
		.append(ctype)
	 	.append("'").toString();
	     return query;
	    }
	    /**
		  * retrieve religion from lookup
		  * @return String
		  */
	    public String religionQuery()
	    {
	     String ctype="religion";
	     String query= new StringBuffer("select CODE as RELIGIONCODE,CDESC as RELIGIONDESC from ")	
		.append("LOOKUP ")
		.append("where CTYPE='")
		.append(ctype)
	 	.append("'").toString();
	     return query;
	    }
	    /**
	     * 
	     * @return String
	     */
	    public String driveridseq()
	    {
	     String ctype="religion";
	     String query= new StringBuffer("select CODE as RELIGIONCODE,CDESC as RELIGIONDESC from ")	
		.append("LOOKUP ")
		.append("where CTYPE='")
		.append(ctype)
	 	.append("'").toString();
	     return query;
	    }
	    public String tyresizecombo() {
			// TODO Auto-generated method stub
			String ctype="tyresize";
		     String query= new StringBuffer("select CODE as ETYRESIZECODE,CDESC as ETYRESIZEDESC from ")	
			.append("LOOKUP ")
			.append("where CTYPE='")
			.append(ctype)
		 	.append("'").toString();
		     return query;
		}
		public String combo1retrieve() {
			// TODO Auto-generated method stub
			String ctype="equipment1";
		     String query= new StringBuffer("select CODE as COMBO1CODE,CDESC as COMBO1DESC from ")	
			.append("LOOKUP ")
			.append("where CTYPE='")
			.append(ctype)
		 	.append("'").toString();
			return query;
		}
		public String combo2retrieve() {
			// TODO Auto-generated method stub
			String ctype="equipment2";
		     String query= new StringBuffer("select CODE as COMBO2CODE,CDESC as COMBO2DESC from ")	
			.append("LOOKUP ")
			.append("where CTYPE='")
			.append(ctype)
		 	.append("'").toString();
			return query;
		}
		public String combo3retrieve() {
			// TODO Auto-generated method stub
			String ctype="equipment3";
		     String query= new StringBuffer("select CODE as COMBO3CODE,CDESC as COMBO3DESC from ")	
			.append("LOOKUP ")
			.append("where CTYPE='")
			.append(ctype)
		 	.append("'").toString();
			return query;
		}
		public String combo4retrieve() {
			// TODO Auto-generated method stub
			String ctype="equipment4";
		     String query= new StringBuffer("select CODE as COMBO4CODE,CDESC as COMBO4DESC from ")	
			.append("LOOKUP ")
			.append("where CTYPE='")
			.append(ctype)
		 	.append("'").toString();
			return query;
		}
		
		/**
		 * return driverid description from lookup
		 * @param driverid
		 * @return string
		 */
		public String driveriddescquery(String driverid)
		{
		String query=new StringBuffer("select CDESC as DRIVERDESC from")
		.append("LOOKUP")
		.append("where CODE='")
		.append(driverid)
		.append("'").toString();
		return query;
		}
		/**
		 * 
		 * @return
		 */
		public String vehiclestatusQuery()
		{
		     String ctype="vehiclestatus";
		     String query= new StringBuffer("select CODE as VEHICLESTATUSCODE,CDESC as VEHICLESTATUSDESC from ")	
			.append("LOOKUP ")
			.append("where CTYPE='")
			.append(ctype)
		 	.append("'").toString();
		     return query;
		}
		
		 public String caseOptionQuery()
		    {
		     String ctype="option";
		     String query= new StringBuffer("select CODE as CASECODE,CDESC as CASEDESC from ")	
			.append("LOOKUP ")
			.append("where CTYPE='")
			.append(ctype)
		 	.append("'").toString();
		     return query;
		    }
		    /**
		     * 
		     * @return
		     */
		    public String insuranceOptionQuery()
		    {
		     String ctype="option";
		     String query= new StringBuffer("select CODE as INSURANCECODE,CDESC as INSURANCEDESC from ")	
			.append("LOOKUP ")
			.append("where CTYPE='")
			.append(ctype)
		 	.append("'").toString();
		     return query;
		    }
		    /**
		     * 
		     * @return
		     */
		    public String expensecombo() {
				// TODO Auto-generated method stub
				String ctype="expenses";
			     String query= new StringBuffer("select CODE as EXPENSECODE,CDESC as EXPENSEDESC from ")	
				.append("LOOKUP ")
				.append("where CTYPE='")
				.append(ctype)
			 	.append("'").toString();
				return query;		
			}	
	    
}
