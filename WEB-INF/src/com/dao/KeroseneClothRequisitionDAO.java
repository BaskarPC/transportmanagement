package com.dao;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.dbcom.dbcom;
import com.vo.DieselRequisitionVO;
import com.vo.KeroseneClothRequisitionVO;



public class KeroseneClothRequisitionDAO {
	private static final Logger logger=(Logger)Logger.getLogger(KeroseneClothRequisitionDAO.class);
	ArrayList list=null;
	dbcom db=new dbcom();
	KeroseneClothRequisitionVO vo1=new KeroseneClothRequisitionVO();
	String vo="com.vo.KeroseneClothRequisitionVO";
	
	public ArrayList itemList()
	{
		logger.debug("itemList:KeroseneClothRequisitionDAO <-------");
		list=db.selectQuery(vo, "select code,description as des from store_lookup where ctype='kerocloth'");
		logger.debug("itemList:KeroseneClothRequisitionDAO ------->");
		return list;
	}
	public String fetchAvailbaleQty(int code)
	{ 
	logger.debug("fetchAvailbaleQty:KeroseneClothRequisitionDAOy <<<<<<<<<");
	ArrayList deslist=db.selectQuery(vo,"select sum(told_qty+tnew_qty)as availability from common_transaction where itemname in (select description as des from store_lookup where code="+code+")");
	logger.debug("fetchAvailbaleQty:KeroseneClothRequisitionDAO>>>>>>>>>");
	vo1=(KeroseneClothRequisitionVO)deslist.get(0);
   String aqty=vo1.getAvailableQty();
	return aqty;
}
	
	public String getRole(String userName) {
		logger.debug("getRole :KeroseneClothRequisitionDAO <<<<<<<<<<<<<<< ");
		String query = "select user_role as role from login where user_name='"
				+ userName + "'";
		list = db.selectQuery(vo, query);
		logger.debug("getRoleList dao :list size.." + list.size());
		vo1 = (KeroseneClothRequisitionVO) list.get(0);
		String role = vo1.getRole();
		logger.debug("getCompanyList :DieselRequisitionDAO : Record Fetched :"+role);
		logger.debug("getCompanyList :KeroseneClothRequisitionDAO >>>>>>>>>>>>>>> ");
		return role;
	}
	public void insert(KeroseneClothRequisitionVO vo) {
		logger.debug("insert :KeroseneClothRequisitionDAO <<<<<<<<<<<<<<< ");
		String query = "insert into KeroseneRequisition values(" + vo.getJobid()
				+ ",'" + vo.getDate() + "','" + vo.getFrom() + "'," + Integer.parseInt(vo.getItemDes())+ ","
				+ Integer.parseInt(vo.getAvailableQty()) + "," +Integer.parseInt(vo.getQtyNeeded())+",'"+vo.getDescription()+"')";
		db.otherQuery(query);
		logger.debug("insert :KeroseneClothRequisitionDAO : Record Inserted");
		logger.debug("insert :KeroseneClothRequisitionDAO >>>>>>>>>>>>>>> ");

	}
	public ArrayList retrieve(Integer jobid) {
		logger.debug("retrieve :KeroseneClothRequisitionDAO <<<<<<<<<<<<<<< ");
		String query = "select reqdate as kreqdate,reqfrom as kreqfrom,reqitem as kreqitem,stock as kstock,qtyneeded as kqtyneeded,description as kdescription from kerosenerequisition where jobid="
				+ jobid + "";
		list = db.selectQuery(vo, query);
		logger.debug("retrive dao :list size.." + list.size());
		vo1 = (KeroseneClothRequisitionVO) list.get(0);
		logger.debug("retrieve :KeroseneClothRequisitionDAO : Record Fetched");
		logger.debug("retrieve :KeroseneClothRequisitionDAO >>>>>>>>>>>>>>> ");
		return list;
	}
}
