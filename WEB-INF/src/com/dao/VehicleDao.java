package com.dao;
import com.vo.VehicleVo;
import java.util.ArrayList;
import com.util.OperationsGeneralLookupUtil;
import org.apache.log4j.Logger;
import com.dbcom.dbcom;
import com.util.VehicleDetailsUtil;

public class VehicleDao {
	
	private static final Logger logger=(Logger)Logger.getLogger(VehicleDao.class);
	dbcom o=new dbcom();
	VehicleVo vo=new VehicleVo();
	ArrayList list=new ArrayList();
	dbcom db=new dbcom();
	VehicleVo vo1=new VehicleVo();
	OperationsGeneralLookupUtil util=new OperationsGeneralLookupUtil();
	VehicleDetailsUtil vehicleutil=new VehicleDetailsUtil(); 
	String vofile="com.vo.VehicleVo";
	
	
	public ArrayList combo(VehicleVo vo)throws Exception
	{  
		String query=util.vehicleTypeQuery();
		list=o.selectQuery(vofile, query);
		return list;
	}
	
	public ArrayList combovstatus(VehicleVo vo)throws Exception
	{  
		String query=util.vehiclestatusQuery();
		list=o.selectQuery(vofile, query);
		 return list;	
	}
	
	public ArrayList comboroadtax(VehicleVo vo)throws Exception
	{  
		String query=util.optionQuery();
		list=o.selectQuery(vofile, query);
	    return list;	
	}	
	
	public ArrayList comboInstitution()throws Exception
	{  
	
		String query=util.institutionQuery();
		list=o.selectQuery(vofile, query);
		return list;	
	}
	
	public ArrayList retrieve(int id) {
		// TODO Auto-generated method stub
				
		list=vehicleutil.retrieve(id);
	/*	String query="select PURCHASE_DATE,MANUFACTURING_DATE,INSTITUTE_NAME as VINSTITUTE_NAME,PRICE,SUPPLIER_NAME,VEHICLE_TYPE as VVEHICLE_TYPE,MAKE,CHASSIS_NO,ENGINE_NO,BODY_TYPE,TANK_CAPACITY,SEAT_CAPACITY as VSEAT_CAPACITY,WHEEL_BASE,VEHICLE_STATUS,ROADTAX_PAID,ROADTAX_FROM,ROADTAX_TO,INSURANCE_PAID,INSURANCE_FROM as VINSURANCE_FROM,INSURANCE_TO as VINSURANCE_TO,INSURANCE_CMPY_NAME,FC_EXPIRY_DATE,VALID_PERMIT_DATE from VEHICLE_PURCHASE where VEHICLE_ID="+id+" AND DEL_IND='N'";
		list=db.selectQuery("com.vo.VehicleVo",query);
		logger.debug("array size of retrieve in dao"+list.size());*/
		return list;
	}
	public void deleteind(String ind) {
		// TODO Auto-generated method stub
		
		vehicleutil.deleteind(ind);
		
	/*	VehicleVo vo2=new VehicleVo();
		ArrayList list3=new ArrayList();
		String idquery="select CODE as VEHICLEIDCODE from LOOKUP where CDESC='"+ind+"'";
		list3=db.selectQuery(vofile, idquery);
		vo2=(VehicleVo)list3.get(0);
		logger.debug("vid"+vo2.getVehicleidcode());
		int vehicleid=Integer.parseInt(vo2.getVehicleidcode());
		logger.debug("vehicle id"+vehicleid);
		db.otherQuery("UPDATE VEHICLE_PURCHASE set DEL_IND='Y' where VEHICLE_ID='"+vehicleid+"'");
		db.otherQuery("UPDATE BUS_ALLOTMENT set DEL_IND='Y' where VEHICLE_ID='"+vehicleid+"'");
	*/
	}
	public void save(VehicleVo vo) {
		// TODO Auto-generated method stub		
		//inserting vehicleid into lookup
		
		vehicleutil.save(vo);
		
	/*	logger.debug("save method");
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
		*/
	}

	public ArrayList insurancecombo() {
		// TODO Auto-generated method stub
		String query=util.insuranceOptionQuery();
		list=o.selectQuery(vofile, query);
		return list;
	}

	public ArrayList vehicletypecombo() {
		// TODO Auto-generated method stub
		String query=util.vehicleTypeQuery();
		list=o.selectQuery(vofile, query);
		return list;
	}

	public ArrayList retrieveall() {
		// TODO Auto-generated method stub
		
		list=vehicleutil.retrieveall();
		return list;
	}

	public ArrayList vehicledesc(int vehicleid) {
		// TODO Auto-generated method stub
		list=vehicleutil.vehicledesc(vehicleid);
		return list;
	}

	public ArrayList convert(String vehicleid) {
		// TODO Auto-generated method stub
		list=vehicleutil.convert(vehicleid);
		return list;
	}

	public ArrayList vehicledel(String str) {
		// TODO Auto-generated method stub
		list=vehicleutil.vehicledel(str);
		return list;
	}

	public void update(VehicleVo vo,String vehicleId) {
		// TODO Auto-generated method stub
		vehicleutil.update(vo,vehicleId);
	}	
}
