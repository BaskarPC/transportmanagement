package com.service;

import java.util.ArrayList;
import com.dao.EquipmentDetailsDAO;
import com.vo.EquipmentDetailsVO;

public class EquipmentDetailsService {
	ArrayList list=new ArrayList();
	EquipmentDetailsDAO dao= new EquipmentDetailsDAO();

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
		public void add(EquipmentDetailsVO vo) {
			// TODO Auto-generated method stub
			dao.add(vo);
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

		public void addequipment(String str) {
			// TODO Auto-generated method stub
			dao.addequipment(str);
		}

		public void insert(EquipmentDetailsVO vo) {
			// TODO Auto-generated method stub
			dao.insert(vo);			
		}


}
