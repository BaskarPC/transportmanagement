package com.util;

import java.util.ArrayList;
import org.apache.log4j.Logger;
import org.displaytag.decorator.TableDecorator;

import com.dbcom.dbcom;
import com.vo.EquipmentAllotmentVO;
import com.vo.EquipmentDetailsVO;
import com.vo.VehicleVo;

public class EquipmentDetailsUtil extends TableDecorator {
	dbcom db=new dbcom();
	ArrayList list=new ArrayList();
	String vofile="com.vo.EquipmentDetailsVO";
	EquipmentDetailsVO vo=new EquipmentDetailsVO();
	private static final Logger logger=(Logger)Logger.getLogger(EquipmentDetailsUtil.class);

	public EquipmentDetailsUtil() {
		super();
		logger.debug("inside the util");		
	}
	
	public void add(EquipmentDetailsVO vo) {
		// TODO Auto-generated method stub
		logger.debug("inside the add method in util");
		db.otherQuery("insert into EQUIPMENT_DETAILS values("+vo.getVehicleId()+","+vo.getCombo1()+","+vo.getQuantity1()+")");
		db.otherQuery("insert into EQUIPMENT_DETAILS values("+vo.getVehicleId()+","+vo.getCombo2()+","+vo.getQuantity2()+")");
		db.otherQuery("insert into EQUIPMENT_DETAILS values("+vo.getVehicleId()+","+vo.getCombo3()+","+vo.getQuantity3()+")");
		db.otherQuery("insert into EQUIPMENT_DETAILS values("+vo.getVehicleId()+","+vo.getCombo4()+","+vo.getQuantity4()+")");
	}
	
	public ArrayList displayequipment(int vehicleid) {
		// TODO Auto-generated method stub
		
		String query="select EQUIPMENT_NAME as EQUIPMENTNAME from EQUIPMENT_DETAILS where VEHICLE_ID='"+vehicleid+"'";
		list=db.selectQuery(vofile, query);
		logger.debug("inside the util,size of array"+list.size());
		return list;
	}
	
	public ArrayList equipmentname(int id) {
		// TODO Auto-generated method stub
		String query="select CDESC as EQUIPMENTNAME from LOOKUP where CODE in(select distinct(EQUIPMENT_NAME) from EQUIPMENT_DETAILS where VEHICLE_ID='"+id+"')";
		list=db.selectQuery(vofile, query);
		logger.debug("size of equipment in dao"+list.size());
		for(int i=0;i<list.size();i++)
		{
		vo=(EquipmentDetailsVO)list.get(i);
		logger.debug("values of equipments in dao"+vo.getEquipmentName());
		}
		return list;
	}
	public void addequipment(String str) {
		// TODO Auto-generated method stub
		String seqidquery="select max(CODE) as SEQID from LOOKUP";						
		list=db.selectQuery(vofile, seqidquery);		
		vo=(EquipmentDetailsVO)list.get(0);		
		int seq=Integer.parseInt(vo.getSeqid())+1;	
		logger.debug("str in util"+str);
		db.otherQuery("insert into LOOKUP values("+seq+",'equipment1','"+str+"')");
	//	list=db.selectQuery(vofile, query);
	}
	
		public void insert(EquipmentDetailsVO vo) {
		// TODO Auto-generated method stub		
		db.otherQuery("insert into EQUIPMENT_DETAILS values("+vo.getVehicleId()+","+vo.getFrontLeftTyre()+","+vo.getQuantity5()+")");
	    db.otherQuery("insert into EQUIPMENT_DETAILS values("+vo.getVehicleId()+","+vo.getFrontRightTyre()+","+vo.getQuantity6()+")");
	    db.otherQuery("insert into EQUIPMENT_DETAILS values("+vo.getVehicleId()+","+vo.getBackLeftInTyre()+","+vo.getQuantity7()+")");
	    db.otherQuery("insert into EQUIPMENT_DETAILS values("+vo.getVehicleId()+","+vo.getBackLeftOutTyre()+","+vo.getQuantity8()+")");
	    db.otherQuery("insert into EQUIPMENT_DETAILS values("+vo.getVehicleId()+","+vo.getBackRightInTyre()+","+vo.getQuantity9()+")");
	    db.otherQuery("insert into EQUIPMENT_DETAILS values("+vo.getVehicleId()+","+vo.getBackRightOutTyre()+","+vo.getQuantity10()+")");
		
	}
}
