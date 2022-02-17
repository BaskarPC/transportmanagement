package com.service;

import java.util.ArrayList;
import com.dao.EquipmentAllotmentDAO;
import com.vo.EquipmentAllotmentVO;
public class EquipmentAllotmentService {
ArrayList list=new ArrayList();
EquipmentAllotmentDAO dao= new EquipmentAllotmentDAO();

	public ArrayList tyresizecombo() {
		// TODO Auto-generated method stub
		list=dao.tyresizecombo();
		return list;
	}

	public ArrayList combo1retrieve() {
		// TODO Auto-generated method stub
		list=dao.combo1retrieve();
		return list;
	}

	public ArrayList combo2retrieve() {
		// TODO Auto-generated method stub
		list=dao.combo2retrieve();
		return list;
	}

	public ArrayList combo3retrieve() {
		// TODO Auto-generated method stub
		list=dao.combo3retrieve();
		return list;
	}

	public ArrayList combo4retrieve() {
		// TODO Auto-generated method stub
		list=dao.combo4retrieve();
		return list;
	}

	public void insert(EquipmentAllotmentVO vo) {
		// TODO Auto-generated method stub
		dao.insert(vo);
		
	}

	public void add(EquipmentAllotmentVO vo) {
		// TODO Auto-generated method stub
		dao.add(vo);
	}

	public ArrayList equipmentdesc(int combo1) {
		// TODO Auto-generated method stub
		list=dao.equipmentdesc(combo1);
		return list;
		
	}

	public ArrayList displayequipment(int vehicleid) {
		// TODO Auto-generated method stub
		list=dao.displayequipment(vehicleid);
		return list;
	}

	public ArrayList equipmentname(int id) {
		// TODO Auto-generated method stub
		list=dao.equipmentname(id);
		return list;
	}

}
