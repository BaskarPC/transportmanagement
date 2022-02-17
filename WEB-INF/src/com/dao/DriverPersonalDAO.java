package com.dao;

import java.util.ArrayList;
import org.apache.log4j.Logger;
import com.dbcom.dbcom;
import com.util.OperationsGeneralLookupUtil;
import com.vo.DriverLeaveVO;
import com.vo.DriverLicenceVO;
import com.vo.DriverOfficialVO;
import com.vo.DriverPersonalVO;
import com.vo.DriverPolicyVO;



public class DriverPersonalDAO {
	private static final Logger logger=(Logger)Logger.getLogger(DriverPersonalDAO.class);
	ArrayList list =new ArrayList();
	dbcom db=new dbcom();
	DriverPersonalVO vo1=new DriverPersonalVO();
	DriverPersonalVO vo2=new DriverPersonalVO();
	OperationsGeneralLookupUtil util=new OperationsGeneralLookupUtil();
	String vofile="com.vo.DriverPersonalVO";
	
	/**
	 * To retrieve district values 
	 * @return list
	 */
	
	public ArrayList districtcombo1() {
		// TODO Auto-generated method stub
		String query=util.district1Query();
		list=db.selectQuery(vofile, query);
		logger.debug("array siz of district 1 in dao"+list.size());
		return list;
	}
    /**
     * To retrieve district values
     * @return list
     */
	public ArrayList districtcombo2() {
		// TODO Auto-generated method stub
		String query=util.district2Query();
		list=db.selectQuery(vofile, query);
		return list;
	}
    /**
     * To retrieve state values
     * @return list
     */
	public ArrayList statecombo1() {
		// TODO Auto-generated method stub
		
		String query=util.state1Query();
		list=db.selectQuery(vofile, query);
		return list;
	}
	/**
   * To retrieve state values
   * @return list
   */
	public ArrayList statecombo2() {
		// TODO Auto-generated method stub
		String query=util.state2Query();
		list=db.selectQuery(vofile, query);
		return list;
		}
	 /**
	   * To retrieve community values
	   * @return list
	   */

	public ArrayList communitycombo() {
		// TODO Auto-generated method stub
		String query=util.communityQuery();
		list=db.selectQuery(vofile, query);
		return list;
	}
	 /**
	   * To retrieve religion values
	   * @return list
	   */
	public ArrayList religioncombo() {
		// TODO Auto-generated method stub
		String query=util.religionQuery();
		list=db.selectQuery(vofile, query);
		return list;
	}
	 /**
	  * Save values in database
	  * @param vo
	  */
	  
	public void save(DriverPersonalVO vo) {
		// TODO Auto-generated method stub
		logger.debug("DriverPersonalDAO: save<-------------");
		
		//inserting driverid into lookup
		
		String seqidquery="select max(CODE) as SEQID from lookup";
		list=db.selectQuery("com.vo.DriverPersonalVO", seqidquery);
		logger.debug("array list size of seq in driverid dao:"+list.size());
		vo1=(DriverPersonalVO)list.get(0);
		logger.debug("seqid in dao:"+vo1.getSeqid());
		int seq=Integer.parseInt(vo1.getSeqid())+1;
		
		 logger.debug("driver id in dao"+vo.getDriverId());
		   logger.debug("driver name in dao"+vo.getDriverName());
		   
		db.otherQuery("insert into lookup values("+seq+",'driverid','"+vo.getDriverId()+"')");
		
		//inserting drivername into lookup
		DriverPersonalVO vo2=new DriverPersonalVO();
		String seqidquery1="select max(CODE) as SEQID from lookup";
		list=db.selectQuery("com.vo.DriverPersonalVO", seqidquery1);
		logger.debug("array list size of seq in drivername dao:"+list.size());
		vo2=(DriverPersonalVO)list.get(0);
		logger.debug("seqid in dao:"+vo2.getSeqid());
		int seq1=Integer.parseInt(vo2.getSeqid())+1;
		db.otherQuery("insert into lookup values("+seq1+",'drivername','"+vo.getDriverName()+"')");
		
		
		//refering driverid via lookup
		String idquery="select CODE as DRIVERID from lookup where CDESC='"+vo.getDriverId()+"'";
		list=db.selectQuery(vofile, idquery);
		vo1=(DriverPersonalVO)list.get(0);
		
		//referring drivername via lookup
		String namequery="select CODE as DRIVERNAME from lookup where CDESC='"+vo.getDriverName()+"'";
		list=db.selectQuery(vofile, namequery);
		vo2=(DriverPersonalVO)list.get(0);
		db.otherQuery("insert into DRIVER_PERSONAL values("+vo1.getDriverId()+","+vo2.getDriverName()+",'"+vo.getPermanentAddress()+"',"+vo.getDistrict1()+","+vo.getState1()+",'"+vo.getTemporaryAddress()+"',"+vo.getDistrict2()+","+vo.getState2()+","+vo.getMobileNo()+","+vo.getResidentialNo1()+","+vo.getResidentialNo2()+","+vo.getSalary()+","+vo.getCommunity()+",'"+vo.getCaste()+"',"+vo.getReligion()+",'"+vo.getDOB()+"','"+vo.getDOJ()+"','N')");
		logger.debug("DriverPersonalDAO: save------------->");
		
	}
	/**
	 * Retrieve values from database
	 * @param id
	 * @return list
	 */

	public ArrayList retrieve(String id) {
		// TODO Auto-generated method stub
		logger.debug("DriverPersonalDAO: retrieve<-------------");
		//String query="select DRIVER_NAME,ADDRESS1,DISTRICT1,STATE1,ADDRESS2,DISTRICT2,STATE2,MOBILE_NO,RESIDENTIAL_NO1,RESIDENTIAL_NO2,SALARY,COMMUNITY,CASTE,RELIGION,TO_CHAR(DOB,'dd Mon yyyy hh24:mi:ss'),TO_CHAR(DOJ,'dd Mon yyyy hh24:mi:ss') from DRIVER_PERSONAL where DRIVER_ID="+id+" AND DEL_IND='N'";
		String query="select DRIVER_NAME,ADDRESS1,DISTRICT1,STATE1,ADDRESS2,DISTRICT2,STATE2,MOBILE_NO,RESIDENTIAL_NO1,RESIDENTIAL_NO2,SALARY,COMMUNITY,CASTE,RELIGION,TO_CHAR(DOB,'dd Mon yyyy') as DOB,TO_CHAR(DOJ,'dd Mon yyyy') as DOJ from DRIVER_PERSONAL where DRIVER_ID="+id+" AND DEL_IND='N'";
		list=db.selectQuery(vofile, query);
		vo1=(DriverPersonalVO)list.get(0);
		logger.debug("array size of retrieve in dao"+list.size());
		logger.debug("caste in dao:"+vo1.getCaste());
		logger.debug("dob in dao:"+vo1.getDOB());
		logger.debug("doj in dao:"+vo1.getDOJ());
		logger.debug("DriverPersonalDAO: retrieve------------->");
		return list;
	}
	
	/**
	 * retrieve drivername by passing driver code value
	 * @param driverName
	 * @return
	 */
	public ArrayList drivernamelookup(String driverName) {
		// TODO Auto-generated method stub
		String namequery="select CDESC as DRIVER_NAME from lookup where CODE='"+driverName+"'";
		list=db.selectQuery(vofile, namequery);
		return list;
	}
	
	/**
	 * delete driver details
	 * @param vo
	 * @param ind
	 */

	public void deleteind(DriverOfficialVO vo,String ind) {
		// TODO Auto-generated method stub
		String idquery="select CODE as DRIVER_ID from LOOKUP where CDESC='"+ind+"'";
		list=db.selectQuery(vofile, idquery);
		vo1=(DriverPersonalVO)list.get(0);
		int driverid=Integer.parseInt(vo1.getDriverId());
		
		String query="UPDATE DRIVER_PERSONAL set DEL_IND='Y' where DRIVER_ID='"+driverid+"'";
		String query1="UPDATE DRIVER_OFFICIAL set DEL_IND='Y' where DRIVER_ID='"+vo.getDriverId()+"'";
		
		db.otherQuery(query);
		db.otherQuery(query1);
	}
	/**
	 * retrieving driverid desc from driver_personal table
	 * @return
	 */
	public ArrayList retrieveall() {
		// TODO Auto-generated method stub
		String query="select CDESC as DRIVERDESC from LOOKUP where CODE IN(select distinct(DRIVER_ID) from DRIVER_PERSONAL)";
		//String query="select CDESC  as DRIVERCODE from LOOKUP where DRIVER_ID in (select distinct(DRIVER_ID) from DRIVER_PERSONAL)";
		list=db.selectQuery(vofile, query);
		logger.debug("array size of retrieveall:"+list.size());
		for(int i=0;i<list.size();i++)
		{
		vo1=(DriverPersonalVO)list.get(i);
		}
		logger.debug("driver desc in dao:"+vo1.getDriverdesc());
		return list;
	}

	/**
	 * Generating seq driver id
	 * @param vo
	 * @return
	 */
	public ArrayList driveridcombo(DriverPersonalVO vo) {
		// TODO Auto-generated method stub
		logger.debug("DriverPersonalDAO: driveridcombo<-------------");
		String query="select driverid.NEXTVAL as SEQID from DUAL";
		list=db.selectQuery(vofile, query);
		logger.debug("array size of seq driverid in dao:"+list.size());
		vo1=(DriverPersonalVO)list.get(0);
		int seq1=Integer.parseInt(vo1.getSeqid())+1;
		
		logger.debug("DriverPersonalDAO: driveridcombo------------->");
		return list;
	}
	/**
	 * retrieving driverid code from lookup
	 * @param vo
	 * @return
	 */
	public ArrayList driveridretrieve(DriverPersonalVO vo) {
		// TODO Auto-generated method stub
		logger.debug("DriverPersonalDAO: driveridretrieve<-------------");
		String query=util.driveridQuery();
		list=db.selectQuery(vofile, query);
		logger.debug("DriverPersonalDAO: driveridretrieve------------->");
		return list;
	}
	public ArrayList idretrieve(String driverId) {
		// TODO Auto-generated method stub
		String query="select CDESC as DRIVERDESC from LOOKUP where CODE='"+driverId+"'";
		list=db.selectQuery(vofile, query);
		return list;
	}
	/**
	 * deleting driver id in licence
	 * @param licencevo
	 * @param ind
	 */
	public void licencedeleteind(DriverLicenceVO licencevo, String ind) {
		// TODO Auto-generated method stub
		String idquery="select CODE as DRIVER_ID from LOOKUP where CDESC='"+ind+"'";
		list=db.selectQuery(vofile, idquery);
		vo1=(DriverPersonalVO)list.get(0);
		int driverid=Integer.parseInt(vo1.getDriverId());
		
		String query="UPDATE DRIVER_PERSONAL set DEL_IND='Y' where DRIVER_ID='"+driverid+"'";
		String query1="UPDATE DRIVER_LICENCE set DEL_IND='Y' where DRIVER_ID='"+licencevo.getDriverId()+"'";
	
		db.otherQuery(query);
		db.otherQuery(query1);
	
	}
	/**
	 * deleting driverid in insurance policy table
	 * @param policyvo
	 * @param ind
	 */
	public void policydeleteind(DriverPolicyVO policyvo, String ind) {
		// TODO Auto-generated method stub
		String idquery="select CODE as DRIVER_ID from LOOKUP where CDESC='"+ind+"'";
		list=db.selectQuery(vofile, idquery);
		vo1=(DriverPersonalVO)list.get(0);
		int driverid=Integer.parseInt(vo1.getDriverId());
		
		String query="UPDATE DRIVER_PERSONAL set DEL_IND='Y' where DRIVER_ID='"+driverid+"'";
		String query1="UPDATE DRIVER_INSURANCE set DEL_IND='Y' where DRIVER_ID='"+policyvo.getDriverId()+"'";
	
		db.otherQuery(query);
		db.otherQuery(query1);
		
	}
	/**
	 * deleting driverid in driver leave table
	 * @param leavevo
	 * @param ind
	 */
	public void leavedeleteind(DriverLeaveVO leavevo, String ind) {
		// TODO Auto-generated method stub
		String idquery="select CODE as DRIVER_ID from LOOKUP where CDESC='"+ind+"'";
		list=db.selectQuery(vofile, idquery);
		vo1=(DriverPersonalVO)list.get(0);
		int driverid=Integer.parseInt(vo1.getDriverId());
		
		String query="UPDATE DRIVER_PERSONAL set DEL_IND='Y' where DRIVER_ID='"+driverid+"'";
		String query1="UPDATE DRIVER_LEAVE set DEL_IND='Y' where DRIVER_ID='"+leavevo.getDriverId()+"'";
	
		db.otherQuery(query);
		db.otherQuery(query1);
	}
	/**
	 * 
	 * @param seqid
	 * @return
	 */
	public ArrayList retrievedriverid(String seqid) {
		// TODO Auto-generated method stub
		String query="select CODE as DRIVERCODE from LOOKUP where CDESC='"+seqid+"'";
		list=db.selectQuery(vofile,query);
		logger.debug("array size in retrievedriverid:"+list.size());
		
		return list;
	}
	/**
	 * 
	 * @param vo
	 * @param string
	 */
	public void update(DriverPersonalVO vo, String string) {
		// TODO Auto-generated method stub
		logger.debug("DriverPersonalDAO: update<-------------");
		
		//referring drivername via lookup
		String namequery="select CODE as DRIVERNAME from lookup where CDESC='"+vo.getDriverName()+"'";
		list=db.selectQuery(vofile, namequery);
		vo2=(DriverPersonalVO)list.get(0);
		db.otherQuery("UPDATE DRIVER_PERSONAL set DRIVER_NAME="+vo2.getDriverName()+",ADDRESS1='"+vo.getPermanentAddress()+"',DISTRICT1="+vo.getDistrict1()+",STATE1="+vo.getState1()+",ADDRESS2='"+vo.getTemporaryAddress()+"',DISTRICT2="+vo.getDistrict2()+",STATE2="+vo.getState2()+",MOBILE_NO='"+vo.getMobileNo()+"', RESIDENTIAL_NO1='"+vo.getResidentialNo1()+"', RESIDENTIAL_NO2="+vo.getResidentialNo2()+",SALARY='"+vo.getSalary()+"',COMMUNITY="+vo.getCommunity()+",CASTE='"+vo.getCaste()+"',RELIGION="+vo.getReligion()+",DOB='"+vo.getDOB()+"',DOJ='"+vo.getDOJ()+"',DEL_IND='N' WHERE DRIVER_ID="+string+"");
		logger.debug("array size of update:"+list.size());
		logger.debug("DriverPersonalDAO: update------------->");
	
	}
	


}
