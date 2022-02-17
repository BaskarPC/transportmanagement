package com.util;

import org.apache.log4j.Logger;
import com.formbean.TyreRepairWorkRequisitionForm;
import com.vo.TyreRepairWorkRequisitionVO;

public class TyreRepairWorkRequisitionUtil {
	private static final Logger logger=(Logger)Logger.getLogger(TyreRepairWorkRequisitionUtil.class);
	TyreRepairWorkRequisitionForm tyrerepairworkrequisitionform = new TyreRepairWorkRequisitionForm();
   /**
    * To get TyreSize Description from Lookup table
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
    * To get TyreBrand Description from Lookup table
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
     * To get TyrePly Description from Lookup table
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
     * To get the TyreBrand description from Database
     * @param tyreNumber
     * @return
     */
    public String tyreBrandDescQuery(int tyreBrandCode)
    {
    	String query="select CDESC as TYREBRAND from lookup where CODE="+tyreBrandCode+"";
    	return query;
    }
    /**
     *  To get the TyreSize description from Database
     * @param tyreSizeCode
     * @return
     */
    public String tyreSizeDescQuery(int tyreSizeCode)
    {
    	String query="select CDESC as TYRESIZE from lookup where CODE="+tyreSizeCode+"";
    	return query;
    }
   /**
     * To get TyreNumber from tyrepurchase table
     * @param tyreSize
     * @param tyreBrand
     * @param tyrePly
     * @return
     */
    public String tyreNumberQuery(int tyreSize,int tyreBrand,int tyrePly)
    {
    	 String query="select TYRENUMBER from tyremaster where TYREBRAND="+tyreBrand+" and TYRESIZE="+tyreSize+" and TYREPLY="+tyrePly+" and USE_INDICATOR='Y' and FIT_INDICATOR='N'";
    	 return query;
    }
    /**
     * To retrieve tyre details from tyrepurchase table
     * @param tyreNumber
     * @return
     */
    public String retrieveTyreDetailsQuery(String tyreNumber)
    {
    	String query="select TYRESTATUS as REBUILTNUMBER from tyremaster where TYRENUMBER='"+tyreNumber+"'";
    	return query;
    }
    
   /**
     * To insert the common tyre details into the database
     * @param job_id
     * @param tyrerepairworkrequisitionvo
     * @return
     */
    
    public String insertQuery1(int job_id,TyreRepairWorkRequisitionVO tyrerepairworkrequisitionvo)
    {
	      String TRANSACTION_DATE=tyrerepairworkrequisitionvo.getRequestedDate();
	      String INCHARGE_NAME=tyrerepairworkrequisitionvo.getInchargeName();  
	      String REBUILT_REPAIR="RepairWork_Request";
	      String COMPANY_NAME=null;
	      String BILL_NUMBER=null;
	      float TYRE_AMOUNT=0;
	      int JOB_ID=job_id;
	            
	     String query= new StringBuffer("insert into common_tyretransaction values(")	
	    
	   	.append(JOB_ID)
		.append(",'")
	    .append(TRANSACTION_DATE)
	    .append("','")
	    .append(INCHARGE_NAME)
	    .append("','")
	    .append(REBUILT_REPAIR)
	    .append("','")
	    .append(COMPANY_NAME)
	    .append("','")
	    .append(BILL_NUMBER)
	    .append("',")
	    .append(TYRE_AMOUNT)
	    .append(")").toString(); 
	     return query;
    } 
    
    /**
     * To insert the tyre details into the database
     * @param job_id
     * @param tyreNumber
     * @param repairwork_repair
     * @param reason
     * @return
     */
    public String insertQuery2(int job_id,String tyreNumber,String rebuilt_repair,String reason)
    {
    	int JOB_ID=job_id;
    	String TYRENUMBER=tyreNumber;
    	String REBUILT_REPAIR=rebuilt_repair;
    	String REASON=reason;
    	String PURPOSE="RepairWork_Request";
    	String ST_IND="N";
    	String query= new StringBuffer("insert into tyre_transaction values(")	
	    
	   	.append(JOB_ID)
		.append(",'")
	    .append(TYRENUMBER)
	    .append("','")
	    .append(REBUILT_REPAIR)
	    .append("','")
	    .append(REASON)
	    .append("','")
	    .append(ST_IND)
	    .append("','")
	    .append(PURPOSE)
	    .append("')").toString(); 
	     return query;
	}
    
    /**
     * To retrieve the tyre details from database for inbox method
     * @param job
     * @return
     */
    public String retrievedetailsQuery(int job) {
    	String query="select t.TYRENUMBER as TYRENUMBER,REBUILT_REPAIR as REPAIRWORK,REASON as REPAIRREASON,TYRESIZE,TYREBRAND from tyre_transaction t,tyremaster tp where job_id="+job+" and t.TYRENUMBER=tp.TYRENUMBER";
    	return query;
    }
        
   /**
    * To retrieve the common tyre details from database for inbox method
    * @param job
    * @return
    */
    public String retrievecommondetailsQuery(int job) {
        String query="select TRANSACTION_DATE,INCHARGE_NAME from common_tyretransaction WHERE JOB_ID="+job+"";
      	return query;
   	}
}
