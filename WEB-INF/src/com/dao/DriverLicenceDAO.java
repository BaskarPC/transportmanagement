package com.dao;
import java.util.*;

import org.apache.log4j.Logger;
import com.dbcom.*;
import com.util.DriverLicenceUtil;
import com.util.OperationsGeneralLookupUtil;
import com.vo.DriverLicenceVO;


public class DriverLicenceDAO {
		private static final Logger logger=(Logger)Logger.getLogger(DriverLicenceDAO.class);
		dbcom db=new dbcom();
		OperationsGeneralLookupUtil util=new OperationsGeneralLookupUtil();
		ArrayList list=new ArrayList();
		DriverLicenceVO vo1=new DriverLicenceVO();
		DriverLicenceUtil driverutil=new DriverLicenceUtil();
	
	/**
	 * retrieve driver id from database
	 * @param vo
	 * @return list
	 * @throws Exception
 	*/
	public ArrayList driveridcombo(DriverLicenceVO vo)throws Exception
	{
	logger.debug("DriverLicenceDAO: driveridcombo<-------------");
	String query=util.driveridQuery();
	list=db.selectQuery("com.vo.DriverLicenceVO", query);
	logger.debug("DriverLicenceDAO: driveridcombo------------->");
	return list;	
	}

	/**
	 * retrieve drivername
	 * @param id
	 * @return list
 	*/
	public ArrayList retrievedrivername(int id) 
	{
	// TODO Auto-generated method stub
	logger.debug("DriverLicenceDAO: retrievedrivername<-------------");
	String query="select CODE as DRIVERCODE,CDESC as DRIVERNAME from LOOKUP where CODE in( select distinct(DRIVER_NAME) from DRIVER_PERSONAL where DRIVER_ID="+id+")";
	list=db.selectQuery("com.vo.DriverLicenceVO", query);
	logger.debug("DriverLicenceDAO: retrievedrivername------------->");
	return list;
	}
	
	/**
	 * retrieve licence category from database
	 * @param vo
	 * @return list
	 */
	public ArrayList categorycombo(DriverLicenceVO vo) 
	{
	// TODO Auto-generated method stub
	logger.debug("DriverLicenceDAO: categorycombo<-------------");
	String query=util.categoryQuery();
	list=db.selectQuery("com.vo.DriverLicenceVO", query);
	logger.debug("DriverLicenceDAO: categorycombo------------->");
	return list;
	}
	
	/**
	 * retrieve endorsement values from database
	 * 	@param vo
	 * 	@return list
	 */
	public ArrayList endorsementcombo(DriverLicenceVO vo)
	{
	// TODO Auto-generated method stub
	logger.debug("DriverLicenceDAO: endorsementcombo<-------------");
	String query=util.endorsementQuery();
	list=db.selectQuery("com.vo.DriverLicenceVO", query);
	logger.debug("DriverLicenceDAO: endorsementcombo------------->");
	return list;
	}
	
	/**
	 * save values into database
	 * @param vo
	 * @throws Exception 
	 */
	public void insert(DriverLicenceVO vo) throws Exception 
	{
	// TODO Auto-generated method stub
	logger.debug("DriverLicenceDAO: insert<-------------");
	DriverLicenceVO vo1=new DriverLicenceVO();
	String query=driverutil.drivercodequery(vo);
	list=db.selectQuery("com.vo.DriverLicenceVO", query);
	vo1=(DriverLicenceVO)list.get(0);
	String insertquery=driverutil.insert(vo,vo1);
	db.otherQuery(insertquery);
	logger.debug("DriverLicenceDAO: insert------------->");
	}
	
	/**
	 * insert values into database
	 * @param vo
	 */
	public void insertothers(DriverLicenceVO vo) 
	{
	// TODO Auto-generated method stub
	logger.debug("DriverLicenceDAO: insertothers<-------------");
	DriverLicenceVO vo1=new DriverLicenceVO();
	String query=driverutil.retrievemaxcodevalue();
	list=db.selectQuery("com.vo.DriverLicenceVO", query);
	logger.debug("array list size of seq in dao:"+list.size());
	vo1=(DriverLicenceVO)list.get(0);
	logger.debug("seqid in dao:"+vo1.getSeqid());
	int seq=Integer.parseInt(vo1.getSeqid())+1;
	String insertquery=driverutil.insertothers(seq, vo);
	db.otherQuery(insertquery);
	logger.debug("DriverLicenceDAO: insertothers------------->");
	}
	
	/**
	 * retrieve values from database
	 * @param id
	 * @return list
	 */
	public ArrayList retrieve(int id) 
	{
	// TODO Auto-generated method stub
	logger.debug("DriverLicenceDAO: retrieve<-------------");
	//String query="select LICENCE_NO,BATCH_NO,TO_CHAR(LICENCE_DATE,'dd Mon yyyy') as LICENCE_DATE,TO_CHAR(VALID_TILL,'dd Mon yyyy') as VALID_TILL,CATEGORY,TO_CHAR(PRE_LICENCE_EXPIRY,'dd Mon yyyy') as PRE_LICENCE_EXPIRY,ENDORSEMENT,PUNISHMENTS from DRIVER_LICENCE where DRIVER_ID="+id+" AND DEL_IND='N'";
	String query=driverutil.retrieveallvalues(id);
	list=db.selectQuery("com.vo.DriverLicenceVO", query);
	vo1=(DriverLicenceVO)list.get(0);
	logger.debug("array list size of retrieve in dao:"+list.size());
	logger.debug("licence date dao:"+vo1.getDateOfLicence());
	logger.debug("valid date dao:"+vo1.getValidPeriod());
	logger.debug("DriverLicenceDAO: retrieve------------->");
	return list;
	}
	
	/**
	 * retrieve drivername, driverdesc by comparing lookup and driver_licence table
	 * @return list
	 */
	public ArrayList retrieveall()
	{
	// TODO Auto-generated method stub
	logger.debug("DriverLicenceDAO: retrieveall<-------------");
	String query="select CDESC as DRIVERDESC from LOOKUP where CODE IN(select distinct(DRIVER_ID) from DRIVER_LICENCE)";
	list=db.selectQuery("com.vo.DriverLicenceVO", query);
	logger.debug("DriverLicenceDAO: retrieveall------------->");
	return list;
	}
	
	/**
	 * retrieve driver code for driver id from lookup
	 * @param driverId
	 * @return
	 */
	public ArrayList idretrieve(String driverId) 
	{
	// TODO Auto-generated method stub
	logger.debug("DriverLicenceDAO: idretrieve<-------------");
	String query=util.driveriddescquery(driverId);
	//String query="select CDESC as DRIVERDESC from LOOKUP where CODE='"+driverId+"'";
	list=db.selectQuery("com.vo.DriverLicenceVO", query);
	logger.debug("DriverLicenceDAO: idretrieve------------->");
	return list;
	}

	/**
	 * retrieving category names from lookup
	 * returns list
	 */
	public ArrayList retrievecategoryvalues(String string) 
	{
	// TODO Auto-generated method stub
	logger.debug("DriverLicenceDAO: retrieveendorsementvalues<-------------");
	//String query="select CDESC as CATEGORY from LOOKUP where CODE ="+string+"";
	String query=driverutil.retrievecategorydescquery(string);
	list=db.selectQuery("com.vo.DriverLicenceVO", query);
	logger.debug("DriverLicenceDAO: retrieveendorsementvalues------------->");
	return list;
	}
	
	/**
	 * retrieve endorsement numbers from lookup
	 * @param string
	 * @return
	 */

	public ArrayList retrieveendorsementvalues(String string) 
	{
	// TODO Auto-generated method stub
	logger.debug("DriverLicenceDAO: retrieveendorsementvalues<-------------");
	//String query="select CDESC as ENDORSEMENT from LOOKUP where CODE ="+string+"";
	String query=driverutil.retrieveendorsementdescquery(string);
	list=db.selectQuery("com.vo.DriverLicenceVO", query);
	logger.debug("DriverLicenceDAO: retrieveendorsementvalues------------->");
	return list;
	}
	
	/**
	 * update values in the database
	 * @param vo
	 * @param driverId
	 */
	public void update(DriverLicenceVO vo, String driverId) 
	{
	// TODO Auto-generated method stub
	logger.debug("DriverLicenceDAO: update<-------------");
	//String query="select CODE as DRIVERNAME from lookup where CDESC='"+vo.getDriverName()+"'";
	String query=driverutil.drivercodequery(vo);
	list=db.selectQuery("com.vo.DriverLicenceVO",query );
	vo1=(DriverLicenceVO)list.get(0);
	String updatequery=driverutil.updatequery(vo, driverId, vo1);
	db.otherQuery(updatequery);
	//db.otherQuery("UPDATE DRIVER_LICENCE set DRIVER_NAME ="+vo1.getDriverName()+",LICENCE_NO='"+vo.getLicenceNo()+"',BATCH_NO="+vo.getBatchNo()+",LICENCE_DATE='"+vo.getDateOfLicence()+"',VALID_TILL='"+vo.getValidPeriod()+"',CATEGORY='"+vo.getCategory()+"',PRE_LICENCE_EXPIRY='"+vo.getLicenceExpiryDate()+"',ENDORSEMENT='"+vo.getEndorsement()+"',PUNISHMENTS='"+vo.getPunishment()+"',DEL_IND='N' where DRIVER_ID="+driverId+"");
	logger.debug("DriverLicenceDAO: update------------->");
	}
}
