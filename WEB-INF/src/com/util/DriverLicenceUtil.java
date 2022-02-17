package com.util;

import com.vo.DriverLicenceVO;

public class DriverLicenceUtil {
		
		/**
		 * retrieve drivercode from lookup
		 * @param vo
		 * @return string
		 */
		public String drivercodequery(DriverLicenceVO vo)
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
		 * retrieve max code from lookup
		 * @return string
		 */
		public String retrievemaxcodevalue()
		{
		String query=new StringBuffer("select max(CODE) as SEQID from ")
		.append("LOOKUP").toString();
		return query;
		}
		
		
		
		/**
		 * retrieve all the values from database for driver_licence
		 * @param id
		 * @return String
		 */
		public String retrieveallvalues(int id)
		{
		String query=new StringBuffer("select LICENCE_NO,BATCH_NO,TO_CHAR(LICENCE_DATE,'dd Mon yyyy') as LICENCE_DATE,TO_CHAR(VALID_TILL,'dd Mon yyyy') as VALID_TILL,CATEGORY,TO_CHAR(PRE_LICENCE_EXPIRY,'dd Mon yyyy') as PRE_LICENCE_EXPIRY,ENDORSEMENT,PUNISHMENTS from ")
		.append("DRIVER_LICENCE")
		.append("where DRIVER_ID=")
		.append(id)
		.append("AND DEL_IND='")
		.append("N'")
		.append(")").toString();
		return query;
		}
		
		/**
		 * retrieve category name from lookup
		 * @param cat
		 * @return string
		 */
		public String retrievecategorydescquery(String cat)
		{
		String query=new StringBuffer("select CDESC as CATEGORY from ")
		.append("LOOKUP")
		.append("where CODE ='")
		.append(cat)
		.append("'").toString();
		return query;
		}
		
		/**
		 * retrieve endorsement name from lookup
		 * @param endorse
		 * @return string
		 */
		public String retrieveendorsementdescquery(String endorse)
		{
		String query=new StringBuffer("select CDESC as ENDORSEMENT from ")
		.append("LOOKUP")
		.append("where CODE ='")
		.append(endorse)
		.append("'").toString();
		return query;
		}
		
		/**
		 * insert new category names into lookup
		 * @param seq
		 * @param vo
		 * @return string
		 */
		public String insertothers(int seq, DriverLicenceVO vo)
		{
		String category="licencecategory";
		String NEWLICENCE_CATEGORY=vo.getOthers();
		String query=new StringBuffer("insert into LOOKUP values(")
		.append(seq)
		.append(",'")
		.append(category)
		.append("','")
		.append(NEWLICENCE_CATEGORY)
		.append("')").toString();
		return query;
		}
		
		/**
		 * insert all the values into the database
		 * @param vo
		 * @param vo1
		 * @return string
		 * @throws Exception
		 */
		 public String insert(DriverLicenceVO vo, DriverLicenceVO vo1)throws Exception
		 {
		 String DRIVER_ID=vo.getDriverId();
		 String DRIVER_NAME=vo1.getDriverName();
		 String LICENCE_NO=vo.getLicenceNo();
		 String BATCH_NO=vo.getBatchNo();
		 String DOL=vo.getDateOfLicence();
		 String VALID_PERIOD=vo.getValidPeriod();
		 String CATEGORY=vo.getCategory();
		 String LICENCE_EXPIRY=vo.getLicenceExpiryDate();
		 String ENDORSEMENT=vo.getEndorsement();
		 String PUNISHMENT=vo.getPunishment();
		 String DEL_IND="N";
		 String query=new StringBuffer("insert into DRIVER_LICENCE values(")
		 	.append(DRIVER_ID)
			.append(",")
		    .append(DRIVER_NAME)
		    .append(",'")
		    .append(LICENCE_NO)
		    .append("',")
		    .append(BATCH_NO)
		    .append(",'")
		    .append(DOL)
		    .append("','")
		    .append(VALID_PERIOD)
		    .append("',")
		    .append(CATEGORY)
		    .append(",'")
		    .append(LICENCE_EXPIRY)
		    .append("',")
		    .append(ENDORSEMENT)
		    .append(",'")
		    .append(PUNISHMENT)
		    .append("','")
		    .append(DEL_IND)
		    .append("')").toString(); 
		 return query;
		 }
		 
		 /**
		  * update all the values in the database
		  * @param vo
		  * @param driverId
		  * @param vo1
		  * @return string
		  */
		 public String updatequery(DriverLicenceVO vo, String driverId,DriverLicenceVO vo1)
		 {
		 String DRIVER_NAME=vo1.getDriverName();
		 String LICENCE_NO=vo.getLicenceNo();
		 String BATCH_NO=vo.getBatchNo();
		 String DOL=vo.getDateOfLicence();
		 String VALID_TILL=vo.getValidPeriod();
		 String CATEGORY=vo.getCategory();
		 String PRE_LICENCE_EXPIRY=vo.getLicenceExpiryDate();
		 String ENDORSEMENT=vo.getEndorsement();
		 String PUNISHMENTS=vo.getPunishment();
		 String DEL_IND="N";
		String query=new StringBuffer(" UPDATE DRIVER_LICENCE set ")
		.append("DRIVER_NAME=")
		.append(DRIVER_NAME)
		.append(",")
		.append("LICENCE_NO='")
		.append(LICENCE_NO)
		.append("',")
		.append("BATCH_NO=")
		.append(BATCH_NO)
		.append(",")
		.append("LICENCE_DATE='")
		.append(DOL)
		.append("',")
		.append("VALID_TILL='")
		.append(VALID_TILL)
		.append("',")
		.append("CATEGORY='")
		.append(CATEGORY)
		.append("',")
		.append("PRE_LICENCE_EXPIRY='")
		.append(PRE_LICENCE_EXPIRY)
		.append("',")
		.append("ENDORSEMENT='")
		.append(ENDORSEMENT)
		.append("',")
		.append("PUNISHMENTS='")
		.append(PUNISHMENTS)
		.append("',")
		.append("DEL_IND='")
		.append(DEL_IND)
		.append("'")
		.append("where DRIVER_ID='")
		.append(driverId)
		.append("'").toString();
		return query;
		 }
}
