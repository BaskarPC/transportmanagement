package com.dao;

import java.util.ArrayList;
import org.apache.log4j.Logger;
import com.vo.BusAllotmentVO;
import com.vo.VehicleInsuranceVO;
import com.util.OperationsGeneralLookupUtil;
import com.util.VehicleInsuranceUtil;

import com.dbcom.*;
public class VehicleInsuranceDAO {
	
ArrayList list=new ArrayList();
OperationsGeneralLookupUtil operationsutil =new OperationsGeneralLookupUtil();
dbcom db=new dbcom();
String vofile="com.vo.VehicleInsuranceVO";
VehicleInsuranceVO vo=new VehicleInsuranceVO(); 
VehicleInsuranceUtil util=new VehicleInsuranceUtil(); 

private static final Logger logger=(Logger)Logger.getLogger(VehicleInsuranceDAO.class);

/**
 * retrieve institution combo
 * @param vo
 * @return
 */
	public ArrayList instcombo(VehicleInsuranceVO vo) {
		// TODO Auto-generated method stub
		String query=operationsutil.institutionQuery();
		list=db.selectQuery(vofile, query);
		return list;
	}

	/**
	 * retrieve vehicletype
	 * @param str
	 * @return
	 */
	public ArrayList vehicletype(String str) {
		// TODO Auto-generated method stub
		list=util.vehicletype(str);
	/*	String query="select CODE as VEHICLETYPECODE,CDESC as VEHICLETYPEDESC from LOOKUP where CODE in(select distinct(VEHICLE_TYPE) from VEHICLE_PURCHASE where INSTITUTION='"+str+"')";
		list=db.selectQuery(vofile, query);*/    
		return list; 
	}

	/**
	 * insert values into database
	 * @param vo
	 */
	public void insert(VehicleInsuranceVO vo) {
		// TODO Auto-generated method stub
		util.insert(vo);
	/*	String query="insert into VEHICLE_INSURANCE values("+vo.getInstituteName()+","+vo.getVehicleId()+","+vo.getVehicleType()+","+vo.getVehicleModel()+","+vo.getMarketValue()+",'"+vo.getInsuranceValidFrom()+"','"+vo.getInsuranceValidTo()+"','"+vo.getExistInsuranceCmpyName()+"','"+vo.getExistVehicleValue()+"','"+vo.getExistInsurancePremiumAmt()+"','"+vo.getProposedInsuranceCmpyName()+"','"+vo.getProposedVehicleValue()+"','"+vo.getProposedInsurancePremiumAmt()+"','N')";
		db.otherQuery(query);*/
	}

	/**
	 * retrieve vehicleid
	 * @param str
	 * @return
	 */
	public ArrayList vehicleidretrieve(String str) {
		// TODO Auto-generated method stub
		list=util.vehicleidretrieve(str);
	/*	String query="select CODE as VEHICLEIDCODE,CDESC as VEHICLEIDDESC from LOOKUP where CODE in(select distinct(VEHICLE_ID) from VEHICLE_PURCHASE where VEHICLE_TYPE='"+str+"')";
		list=db.selectQuery(vofile, query);*/
		return list;
	}

	/**
	 * retrieve all values from database
	 * @param id
	 * @return
	 */
	public ArrayList retrieve(int id) {
		// TODO Auto-generated method stub
		list=util.retrieve(id);
	/*	String query="select VEHICLE_MODEL,MARKET_VALUE,INSURANCE_FROM,INSURANCE_TO,EXISTING_COMPANY_NAME,EXISTING_VALUE_INSURED,EXISTING_PREMIUM_AMT,PROPOSED_COMPANY_NAME, PROPOSED_VALUE_INSURED,PROPOSED_PREMIUM_AMT from VEHICLE_INSURANCE where VEHICLE_ID='"+id+"' AND DEL_IND='N'";
		list=db.selectQuery(vofile, query);*/
		return list;
	}


	/**
	 * retrieve corresponding description for all vehicle id database
	 * @return
	 */
	public ArrayList retrieveall() {
		// TODO Auto-generated method stub
		list=util.retrieveall();
	/*	String query="select CDESC as VEHICLEIDDESC from LOOKUP where CODE IN(select distinct(VEHICLE_ID) from VEHICLE_INSURANCE)";
		list=db.selectQuery(vofile, query);*/
		return list;
	}

	/**
	 * retrieve corresponding description for vehicleid from form
	 * @param vehicleid
	 * @return
	 */
	public ArrayList formvehicleid(int vehicleid) {
		// TODO Auto-generated method stub
		list=util.formvehicleid(vehicleid);
	/*	String query="select CDESC as VEHICLEIDDESC from LOOKUP where CODE='"+vehicleid+"'";
		list=db.selectQuery(vofile, query);*/
		return list;
	}

	public void update(VehicleInsuranceVO vo, String vehicleid) {
		// TODO Auto-generated method stub
		util.update(vo,vehicleid);
	}
}
