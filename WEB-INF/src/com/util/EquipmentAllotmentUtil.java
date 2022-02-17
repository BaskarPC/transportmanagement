package com.util;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.displaytag.decorator.TableDecorator;
import com.dbcom.dbcom;
import com.vo.EquipmentAllotmentVO;

public class EquipmentAllotmentUtil extends TableDecorator{
	
dbcom db=new dbcom();
ArrayList list=new ArrayList();
String vofile="com.vo.EquipmentAllotmentVO";
EquipmentAllotmentVO vo=new EquipmentAllotmentVO();
private static final Logger logger=(Logger)Logger.getLogger(EquipmentAllotmentUtil.class);

	public EquipmentAllotmentUtil() {
		super();
		logger.debug("inside the util");
	
	}
	public void insert(EquipmentAllotmentVO vo) {
		// TODO Auto-generated method stub

		logger.debug("vehicle id in util"+vo.getVehicleId());		
		db.otherQuery("insert into EQUIPMENT_ALLOTMENT values("+vo.getVehicleId()+","+vo.getFrontLeftTyre()+","+vo.getQuantity5()+")");
	    db.otherQuery("insert into EQUIPMENT_ALLOTMENT values("+vo.getVehicleId()+","+vo.getFrontRightTyre()+","+vo.getQuantity6()+")");
	    db.otherQuery("insert into EQUIPMENT_ALLOTMENT values("+vo.getVehicleId()+","+vo.getBackLeftInTyre()+","+vo.getQuantity7()+")");
	    db.otherQuery("insert into EQUIPMENT_ALLOTMENT values("+vo.getVehicleId()+","+vo.getBackLeftOutTyre()+","+vo.getQuantity8()+")");
	    db.otherQuery("insert into EQUIPMENT_ALLOTMENT values("+vo.getVehicleId()+","+vo.getBackRightInTyre()+","+vo.getQuantity9()+")");
	    db.otherQuery("insert into EQUIPMENT_ALLOTMENT values("+vo.getVehicleId()+","+vo.getBackRightOutTyre()+","+vo.getQuantity10()+")");
	  
	}
	public void add(EquipmentAllotmentVO vo) {
		// TODO Auto-generated method stub
		logger.debug("inside the add method in util");
		db.otherQuery("insert into EQUIPMENT_ALLOTMENT values("+vo.getVehicleId()+","+vo.getCombo1()+","+vo.getQuantity1()+")");
		db.otherQuery("insert into EQUIPMENT_ALLOTMENT values("+vo.getVehicleId()+","+vo.getCombo2()+","+vo.getQuantity2()+")");
		db.otherQuery("insert into EQUIPMENT_ALLOTMENT values("+vo.getVehicleId()+","+vo.getCombo3()+","+vo.getQuantity3()+")");
		db.otherQuery("insert into EQUIPMENT_ALLOTMENT values("+vo.getVehicleId()+","+vo.getCombo4()+","+vo.getQuantity4()+")");
		
	}

	public ArrayList equipmentdesc(int combo1) {
		// TODO Auto-generated method stub
	    logger.debug("inside the equipmentdesc in util");
	    String query="select CDESC as EQUIPMENTDESC from LOOKUP where CODE="+combo1+"";
	    list=db.selectQuery(vofile, query);
	    return list;
		
	}

	public ArrayList displayequipment(int vehicleid) {
		// TODO Auto-generated method stub
		EquipmentAllotmentVO vo=new EquipmentAllotmentVO();
		String query="select EQUIPMENT_NAME as EQUIPMENTNAME from EQUIPMENT_ALLOTMENT where VEHICLE_ID='"+vehicleid+"'";
		list=db.selectQuery(vofile, query);
		logger.debug("inside the util,size of array"+list.size());
		return list;
	}

	public ArrayList equipmentname(int id) {
		// TODO Auto-generated method stub
		String query="select CDESC as EQUIPMENTNAME from LOOKUP where CODE in(select distinct(EQUIPMENT_NAME) from EQUIPMENT_ALLOTMENT where VEHICLE_ID='"+id+"')";
		list=db.selectQuery(vofile, query);
		logger.debug("size of equipment in dao"+list.size());
		for(int i=0;i<list.size();i++)
		{
		vo=(EquipmentAllotmentVO)list.get(i);
		logger.debug("values of equipments in dao"+vo.getEquipmentName());
		}
		return list;
	}
}
