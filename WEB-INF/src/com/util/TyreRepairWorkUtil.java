package com.util;

import org.apache.log4j.Logger;
import com.formbean.TyreRepairWorkForm;
import com.vo.TyreRepairWorkVO;

public class TyreRepairWorkUtil {
	private static final Logger logger=(Logger)Logger.getLogger(TyreRepairWorkRequisitionUtil.class);
	TyreRepairWorkForm tyrerepairworkform = new TyreRepairWorkForm();
	
	public String retrieveTyreDetailsQuery(String tyreNumber)
    {
    	String query="select REBUILT_REPAIR as REPAIRWORK,REASON as REPAIRREASON from tyre_transaction where TYRENUMBER='"+tyreNumber+"'";
    	return query;
    }
   
    public String insertQuery1(int job_id,TyreRepairWorkVO tyrerepairworkvo)
    {
	      String TRANSACTION_DATE=tyrerepairworkvo.getBillDate();
	      String INCHARGE_NAME=null;  
	      String REBUILT_REPAIR="Rebuilt";
	      String COMPANY_NAME=tyrerepairworkvo.getCompanyName();
	      String BILL_NUMBER=tyrerepairworkvo.getBillNumber();
	      int JOB_ID=job_id;
	      float TYRE_AMOUNT=Float.parseFloat(tyrerepairworkvo.getBillAmount());
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
    
    public String insertQuery2(int job_id,String tyreNumber,String rebuilt_repair,String reason)
    {
    	int JOB_ID=job_id;
    	String TYRENUMBER=tyreNumber;
    	String REBUILT_REPAIR=rebuilt_repair;
    	String REASON=reason;
    	String PURPOSE="RepairWork";
    	String ST_IND="y";
    	String query= new StringBuffer("insert into tyre_transaction values(")	
	    .append("'")
	   	.append(JOB_ID)
		.append("','")
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
    public String tyreNumberQuery()
    {
    	String query="select tyrenumber from tyre_transaction where ST_IND='N' and PURPOSE='RepairWork_Request'";
    	return query;
    }
    
    /** To display details in the inboxMethod
     * @param job
     * @return
     */
    public String retrievedetailsQuery(int job) {
    	String query="select t.TYRENUMBER as TYRENUMBER,REBUILT_REPAIR as REPAIRWORK,REASON as REPAIRREASON,TYRESIZE,TYREBRAND from tyre_transaction t,tyremaster tp where job_id="+job+" and t.TYRENUMBER=tp.TYRENUMBER";
    	return query;
    }
    
    /**
     * To get tyrebrandcode,tyresize code from lookup
     */
    public String tyredetailscodequery(String tyreNumber)
    {
    	String query="select TYREBRAND,TYRESIZE from tyremaster where TYRENUMBER='"+tyreNumber+"' and FIT_INDICATOR='N'";
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
    * To retrieve the common tyre details from database for inbox method
    * @param job
    * @return
    */
    public String retrievecommondetailsQuery(int job) {
    	String query="select TRANSACTION_DATE as BILL_DATE,BILL_NUMBER,COMPANY_NAME,AMOUNT AS TYRE_AMOUNT from common_tyretransaction WHERE JOB_ID="+job+"";
      	return query;
   	}
    /**
     * To update the indicator value
     * @param tyreNumber
     * @return
     */
    public String updateIndicatorQuery(String tyreNumber)
    {
    	String query="update tyre_transaction set ST_IND='Y' where TYRENUMBER='"+tyreNumber+"'"; 
    	return query;
    }
    /**
     * To update the master table
     * @param tyreNumber
     * @param tyreStatus
     * @return
     */
    
}
