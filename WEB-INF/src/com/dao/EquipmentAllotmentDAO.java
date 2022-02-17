package com.dao;

import java.util.ArrayList;
import com.util.EquipmentAllotmentUtil;
import com.util.OperationsGeneralLookupUtil;
import com.vo.EquipmentAllotmentVO;
import com.dbcom.dbcom;
public class EquipmentAllotmentDAO {
ArrayList list=new ArrayList();
EquipmentAllotmentUtil util=new EquipmentAllotmentUtil();
OperationsGeneralLookupUtil operationutil=new OperationsGeneralLookupUtil();
dbcom db=new dbcom();
String vofile="com.vo.EquipmentAllotmentVO";

	public ArrayList tyresizecombo() {
		// TODO Auto-generated method stub
		String query=operationutil.tyresizecombo();
		list=db.selectQuery(vofile,query);
		return list;
	}

	public ArrayList combo1retrieve() {
		// TODO Auto-generated method stub
		String query=operationutil.combo1retrieve();
		list=db.selectQuery(vofile, query);
		return list;
	}

	public ArrayList combo2retrieve() {
		// TODO Auto-generated method stub
		String query=operationutil.combo2retrieve();
		list=db.selectQuery(vofile, query);
		return list;
	}

	public ArrayList combo3retrieve() {
		// TODO Auto-generated method stub
		String query=operationutil.combo3retrieve();
		list=db.selectQuery(vofile, query);
		return list;
	}

	public ArrayList combo4retrieve() {
		// TODO Auto-generated method stub
		String query=operationutil.combo4retrieve();
		list=db.selectQuery(vofile, query);
		return list;
	}

	public void insert(EquipmentAllotmentVO vo) {
		// TODO Auto-generated method stub
		util.insert(vo);		
	}

	public void add(EquipmentAllotmentVO vo) {
		// TODO Auto-generated method stub
		util.add(vo);
	}

	public ArrayList equipmentdesc(int combo1) {
		// TODO Auto-generated method stub
		list=util.equipmentdesc(combo1);
		//list=db.selectQuery(vofile, query);
		return list;
	}

	public ArrayList displayequipment(int vehicleid) {
		// TODO Auto-generated method stub
		list=util.displayequipment(vehicleid);
		return list;
	}

	public ArrayList equipmentname(int id) {
		// TODO Auto-generated method stub
		list=util.equipmentname(id);
		return list;
	}

}