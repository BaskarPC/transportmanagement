package com.util;
import java.util.ArrayList; 

import org.apache.log4j.Logger;
import com.vo.VehicleVo;

import com.dbcom.dbcom;

public class VehicleDetailsUtil {
ArrayList list=new ArrayList();
String vofile="com.vo.VehicleVo";
dbcom db=new dbcom();
VehicleVo vo=new VehicleVo();

private static final Logger logger=(Logger)Logger.getLogger(VehicleDetailsUtil.class);

	public ArrayList retrieveall() {
		// TODO Auto-generated method stub
		String query="select CDESC as VEHICLEIDDESC from LOOKUP where CODE in(select VEHICLE_ID from VEHICLE_PURCHASE)";
		list=db.selectQuery(vofile, query);
		logger.debug("arraysize in util for retrieveall"+list.size());
		for(int i=0;i<list.size();i++)
		{
			vo=(VehicleVo)list.get(i);
			logger.debug("values in util"+vo.getVehicleiddesc());
		}
		return list;
	}

	public ArrayList vehicledesc(int vehicleid) {
		// TODO Auto-generated method stub
		String query="select CDESC as VEHICLEIDDESC from LOOKUP where CODE="+vehicleid+"";
		list=db.selectQuery(vofile, query);
		logger.debug("arraysize in util for vehicle id desc"+list.size());
		vo=(VehicleVo)list.get(0);
		logger.debug("values of vehicle id desc in util"+vo.getVehicleiddesc());
		return list;
	}

	public ArrayList convert(String vehicleid) {
		// TODO Auto-generated method stub
		String query="select CODE as VEHICLEIDCODE from LOOKUP where CDESC='"+vehicleid+"'";
		list=db.selectQuery(vofile, query);
		logger.debug("arraysize in util for vehicle convert"+list.size());
		vo=(VehicleVo)list.get(0);
		logger.debug("values in util for convert"+vo.getVehicleidcode());
		return list;
	}

	public ArrayList vehicledel(String str) {
		// TODO Auto-generated method stub
		VehicleVo vo2=new VehicleVo();
		ArrayList list3=new ArrayList();
		String idquery="select CODE as VEHICLEIDCODE from LOOKUP where CDESC='"+str+"'";
		list3=db.selectQuery(vofile, idquery);
		vo2=(VehicleVo)list3.get(0);
		logger.debug("vid"+vo2.getVehicleidcode());
		int vehicleid=Integer.parseInt(vo2.getVehicleidcode());
		logger.debug("vehicle id"+vehicleid);
		db.otherQuery("UPDATE VEHICLE_PURCHASE set DEL_IND='Y' where VEHICLE_ID="+vehicleid+"");
		return list;
	}

	public void update(VehicleVo vo,String vehicleId) {
		// TODO Auto-generated method stub
		VehicleVo vo1=new VehicleVo();
		
		logger.debug("vehicle id in util"+vehicleId);
		logger.debug("vehile id of vo in util"+vo.getVehicleId());
		
		String idquery="select CODE as VEHICLEIDCODE from lookup where CDESC='"+vo.getVehicleId()+"'";
		list=db.selectQuery(vofile,idquery);
		vo1=(VehicleVo)list.get(0);	
		
		db.otherQuery("UPDATE VEHICLE_PURCHASE SET PURCHASE_DATE='"+vo.getDateOfPurchase()+"',MANUFACTURING_DATE='"+vo.getManufacturingDate()+"',INSTITUTE_NAME='"+vo.getInstituteName()+"',PRICE="+vo.getPrice()+",SUPPLIER_NAME='"+vo.getSupplierName()+"',VEHICLE_TYPE="+vo.getVehicleType()+",MAKE='"+vo.getMake()+"',CHASSIS_NO='"+vo.getChassisNo()+"',ENGINE_NO='"+vo.getEngineNo()+"',BODY_TYPE='"+vo.getBodyType()+"',TANK_CAPACITY="+vo.getTankCapacity()+",SEAT_CAPACITY="+vo.getSeatCapacity()+",WHEEL_BASE='"+vo.getWheelBase()+"',VEHICLE_STATUS="+vo.getVehicleStatus()+",ROADTAX_PAID="+vo.getRoadyesNoOption()+",ROADTAX_FROM='"+vo.getRoadTaxFrom()+"',ROADTAX_TO='"+vo.getRoadTaxTo()+"',INSURANCE_PAID="+vo.getInsuranceOption()+",INSURANCE_FROM='"+vo.getInsuranceFrom()+"',INSURANCE_TO='"+vo.getInsuranceTo()+"',INSURANCE_CMPY_NAME='"+vo.getInsuranceCmpyName()+"',FC_EXPIRY_DATE='"+vo.getFcExpiryDate()+"',VALID_PERMIT_DATE='"+vo.getValidPermitDate()+"' where VEHICLE_ID='vehicleId'");
	}

	public void save(VehicleVo vo) {
		// TODO Auto-generated method stub
		VehicleVo vo1=new VehicleVo();
		logger.debug("save method");
		String seqidquery="select max(CODE) as SEQID from lookup";
		list=db.selectQuery("com.vo.VehicleVo", seqidquery);
		logger.debug("array list size of seq in vehicleid dao:"+list.size());
		vo1=(VehicleVo)list.get(0);
		
		logger.debug("seqid in dao:"+vo1.getSeqid());
		int seq=Integer.parseInt(vo1.getSeqid())+1;
		logger.debug("vehicleid in dao"+vo.getVehicleId());  		   
		db.otherQuery("insert into lookup values("+seq+",'vehiclenumber','"+vo.getVehicleId()+"')");
		
		logger.debug("vnumber"+"insert into lookup values("+seq+",'vehiclenumber','"+vo.getVehicleId()+"')");		
		//refering vehicleid via lookup
		String idquery="select CODE as VEHICLEIDCODE from lookup where CDESC='"+vo.getVehicleId()+"'";
		list=db.selectQuery(vofile,idquery);
		vo1=(VehicleVo)list.get(0);	
		
		db.otherQuery("insert into VEHICLE_PURCHASE values('"+vo.getDateOfPurchase()+"','"+vo.getManufacturingDate()+"',"+vo.getInstituteName()+","+vo1.getVehicleidcode()+","+vo.getPrice()+",'"+vo.getSupplierName()+"',"+vo.getVehicleType()+",'"+vo.getMake()+"','"+vo.getChassisNo()+"','"+vo.getEngineNo()+"','"+vo.getBodyType()+"',"+vo.getTankCapacity()+","+vo.getSeatCapacity()+",'"+vo.getWheelBase()+"',"+vo.getVehicleStatus()+","+vo.getRoadyesNoOption()+",'"+vo.getRoadTaxFrom()+"','"+vo.getRoadTaxTo()+"',"+vo.getInsuranceOption()+",'"+vo.getInsuranceFrom()+"','"+vo.getInsuranceTo()+"','"+vo.getInsuranceCmpyName()+"','"+vo.getFcExpiryDate()+"','"+vo.getValidPermitDate()+"','0','N')");
		
	}

	public ArrayList retrieve(int id) {
		// TODO Auto-generated method stub

		String query="select PURCHASE_DATE,MANUFACTURING_DATE,INSTITUTE_NAME as VINSTITUTE_NAME,PRICE,SUPPLIER_NAME,VEHICLE_TYPE as VVEHICLE_TYPE,MAKE,CHASSIS_NO,ENGINE_NO,BODY_TYPE,TANK_CAPACITY,SEAT_CAPACITY as VSEAT_CAPACITY,WHEEL_BASE,VEHICLE_STATUS,ROADTAX_PAID,ROADTAX_FROM,ROADTAX_TO,INSURANCE_PAID,INSURANCE_FROM as VINSURANCE_FROM,INSURANCE_TO as VINSURANCE_TO,INSURANCE_CMPY_NAME,FC_EXPIRY_DATE,VALID_PERMIT_DATE from VEHICLE_PURCHASE where VEHICLE_ID="+id+" AND DEL_IND='N'";
		list=db.selectQuery("com.vo.VehicleVo",query);
		logger.debug("array size of retrieve in dao"+list.size());
		return list;
		
	}

	public void deleteind(String ind) {
		// TODO Auto-generated method stub
		
		VehicleVo vo2=new VehicleVo();
		ArrayList list3=new ArrayList();
		String idquery="select CODE as VEHICLEIDCODE from LOOKUP where CDESC='"+ind+"'";
		list3=db.selectQuery(vofile, idquery);
		vo2=(VehicleVo)list3.get(0);
		logger.debug("vid"+vo2.getVehicleidcode());
		int vehicleid=Integer.parseInt(vo2.getVehicleidcode());
		logger.debug("vehicle id"+vehicleid);
		db.otherQuery("UPDATE VEHICLE_PURCHASE set DEL_IND='Y' where VEHICLE_ID='"+vehicleid+"'");
		db.otherQuery("UPDATE BUS_ALLOTMENT set DEL_IND='Y' where VEHICLE_ID='"+vehicleid+"'");
		
	}
}
