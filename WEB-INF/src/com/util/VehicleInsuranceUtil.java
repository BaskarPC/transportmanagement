package com.util;

import java.util.ArrayList;
import java.util.ArrayList;
import com.vo.VehicleInsuranceVO;
import com.dbcom.dbcom;

public class VehicleInsuranceUtil {
dbcom db=new dbcom();
String vofile="Vcom.vo.VehicleInsuranceVO";
ArrayList list=new ArrayList();

	public void update(VehicleInsuranceVO vo, String vehicleid) {
		// TODO Auto-generated method stub
		db.otherQuery("UPDATE VEHICLE_INSURANCE SET	INSTITUTE_NAME="+vo.getInstituteName()+",VEHICLE_TYPE="+vo.getVehicleType()+",VEHICLE_MODEL="+vo.getVehicleModel()+",MARKET_VALUE="+vo.getMarketValue()+",INSURANCE_FROM='"+vo.getInsuranceValidFrom()+"'INSURANCE_TO='"+vo.getInsuranceValidTo()+"',EXISTING_COMPANY_NAME='"+vo.getExistInsuranceCmpyName()+"',EXISTING_VALUE_INSURED="+vo.getExistVehicleValue()+",EXISTING_PREMIUM_AMT="+vo.getExistInsurancePremiumAmt()+",PROPOSED_COMPANY_NAME='"+vo.getProposedInsuranceCmpyName()+"',PROPOSED_VALUE_INSURED="+vo.getProposedVehicleValue()+",PROPOSED_PREMIUM_AMT="+vo.getProposedInsurancePremiumAmt()+" where VEHICLE_ID="+vehicleid+"");
	}

	public ArrayList vehicletype(String str) {
		// TODO Auto-generated method stub
		String query="select CODE as VEHICLETYPECODE,CDESC as VEHICLETYPEDESC from LOOKUP where CODE in(select distinct(VEHICLE_TYPE) from VEHICLE_PURCHASE where INSTITUTE_NAME='"+str+"')";
		list=db.selectQuery(vofile, query);    
		return list;
	}

	public void insert(VehicleInsuranceVO vo) {
		// TODO Auto-generated method stub
		String query="insert into VEHICLE_INSURANCE values("+vo.getInstituteName()+","+vo.getVehicleId()+","+vo.getVehicleType()+","+vo.getVehicleModel()+","+vo.getMarketValue()+",'"+vo.getInsuranceValidFrom()+"','"+vo.getInsuranceValidTo()+"','"+vo.getExistInsuranceCmpyName()+"','"+vo.getExistVehicleValue()+"','"+vo.getExistInsurancePremiumAmt()+"','"+vo.getProposedInsuranceCmpyName()+"','"+vo.getProposedVehicleValue()+"','"+vo.getProposedInsurancePremiumAmt()+"','N')";
		db.otherQuery(query);
		
	}

	public ArrayList vehicleidretrieve(String str) {
		// TODO Auto-generated method stub
		String query="select CODE as VEHICLEIDCODE,CDESC as VEHICLEIDDESC from LOOKUP where CODE in(select distinct(VEHICLE_ID) from VEHICLE_PURCHASE where VEHICLE_TYPE='"+str+"')";
		list=db.selectQuery(vofile, query);
		return list;
	}

	public ArrayList retrieve(int id) {
		// TODO Auto-generated method stub
		String query="select VEHICLE_MODEL,MARKET_VALUE,INSURANCE_FROM,INSURANCE_TO,EXISTING_COMPANY_NAME,EXISTING_VALUE_INSURED,EXISTING_PREMIUM_AMT,PROPOSED_COMPANY_NAME, PROPOSED_VALUE_INSURED,PROPOSED_PREMIUM_AMT from VEHICLE_INSURANCE where VEHICLE_ID='"+id+"' AND DEL_IND='N'";
		list=db.selectQuery(vofile, query);
		return list;
	}

	public ArrayList retrieveall() {
		// TODO Auto-generated method stub
		String query="select CDESC as VEHICLEIDDESC from LOOKUP where CODE IN(select distinct(VEHICLE_ID) from VEHICLE_INSURANCE)";
		list=db.selectQuery(vofile, query);
		return list;
	}

	public ArrayList formvehicleid(int vehicleid) {
		// TODO Auto-generated method stub
		String query="select CDESC as VEHICLEIDDESC from LOOKUP where CODE='"+vehicleid+"'";
		list=db.selectQuery(vofile, query);
		return list;
	}
}
