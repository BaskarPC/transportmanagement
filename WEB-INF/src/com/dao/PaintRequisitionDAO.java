package com.dao;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.dbcom.dbcom;
import com.vo.PaintRequisitionVO;
public class PaintRequisitionDAO {
	private static final Logger logger=(Logger)Logger.getLogger(PaintRequisitionDAO.class);
	ArrayList list=null;
	dbcom db=new dbcom();
	String vo="com.vo.PaintRequisitionVO";
	ArrayList deslist=new ArrayList();
	PaintRequisitionVO vo1=new PaintRequisitionVO();
	public ArrayList fetchbrandlist()
	{
		logger.debug("fetchbrandlist : PaintRequisitionDAO <<-----------");
		list=db.selectQuery(vo, "select code,cdesc as des from lookup where ctype='paintname'");
		logger.debug("fetchbrandlist : PaintRequisitionDAO ----------->>");
		return list;
	}
	public ArrayList fetchtypelist(String code)
	{
		logger.debug("fetchbrandlist : PaintRequisitionDAO <<-----------");
		list=db.selectQuery(vo, "select code,cdesc as des from lookup where ctype in(select cdesc as des from lookup where code="+code+")");
		logger.debug("fetchbrandlist : PaintRequisitionDAO ----------->>");
		return list;
	}
	public ArrayList fetchAvailbaleQty(int brandname,int brandtype)
	{ 
	logger.debug("PaintRequisitionDAO:fetchAvailbaleQty <<<<<<<<<");
	list=db.selectQuery(vo, "select cdesc as des from lookup where code="+brandname);
	vo1=(PaintRequisitionVO)list.get(0);
	String name=vo1.getDes();
	logger.debug("breand name :"+name);
	list=db.selectQuery(vo, "select cdesc as des from lookup where code="+brandtype);
	vo1=(PaintRequisitionVO)list.get(0);
	String typename=vo1.getDes();
	logger.debug("breand type :"+typename);
	list=db.selectQuery(vo,"select partnumber as pno from common_transaction where itemname='"+name+"' and subtype='"+typename+"'");
	if(list.size()>0)
	{
	deslist=db.selectQuery(vo,"select sum(told_qty+tnew_qty)as availableqty1 from common_transaction where itemname='"+name+"' and subtype='"+typename+"'");
	logger.debug("exisiting entry :"+deslist.size());
	}
	else{
		logger.debug("no entry before");
		db.otherQuery("insert into common_transaction values('P4','"+name+"','"+typename+"',0,0,0,0,0,0,0,0,0,0,0,0,0)");
		deslist=db.selectQuery(vo,"select sum(told_qty+tnew_qty)as availableqty1 from common_transaction where itemname='"+name+"' and subtype='"+typename+"'");
		logger.debug("AFTER entry :"+deslist.size());
	}
	logger.debug("PaintRequisitionDAO:fetchAvailbaleQty >>>>>>>>>");
	return deslist;
}
}
