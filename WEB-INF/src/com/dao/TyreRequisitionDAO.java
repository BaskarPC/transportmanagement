package com.dao;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.dbcom.dbcom;
import com.formbean.TyreRequisitionForm;

import com.vo.OilGreaseRequisitionVO;
import com.vo.TyreRequisitionVO;

public class TyreRequisitionDAO {
	private static final Logger logger=(Logger)Logger.getLogger(TyreRequisitionDAO.class);
	dbcom db=new dbcom();
	ArrayList list=new ArrayList();
	TyreRequisitionForm tf=new TyreRequisitionForm();
	TyreRequisitionVO vo=new TyreRequisitionVO();
	ArrayList list1=new ArrayList();
	ArrayList list2=new ArrayList();
	public ArrayList getTyreBrandList()
	{
		logger.debug("TyreRequisitionDAO:fetchRequiredItem <<<<<<<<<");
		list=db.selectQuery("com.vo.TyreRequisitionVO","select code,cdesc as des from lookup where ctype='TYREBRAND'" );
		logger.debug("TyreRequisitionDAO:fetchRequiredItem >>>>>>>>>");
		return list;
	}
	public ArrayList getTyreSizeList()
	{
		logger.debug("TyreRequisitionDAO:getTyreSizeList <<<<<<<<<");
		list=db.selectQuery("com.vo.TyreRequisitionVO","select code,cdesc as des from lookup where ctype='TYRESIZE'" );
		logger.debug("TyreRequisitionDAO:getTyreSizeList >>>>>>>>>");
		return list;
	}
	public ArrayList getTyrePlyList()
	{
		logger.debug("TyreRequisitionDAO:getTyrePlyList <<<<<<<<<");
		list=db.selectQuery("com.vo.TyreRequisitionVO","select code,cdesc as des from lookup where ctype='TYREPLY'" );
		logger.debug("TyreRequisitionDAO:getTyrePlyList >>>>>>>>>");
		return list;
	}
	public ArrayList getTyrePartsList()
	{
		logger.debug("TyreRequisitionDAO:getTyrePlyList <<<<<<<<<");
		list=db.selectQuery("com.vo.TyreRequisitionVO","select code,description as des from store_lookup where ctype='tyreparts'" );
		logger.debug("TyreRequisitionDAO:getTyrePlyList >>>>>>>>>");
		return list;
	}
	public void insert(int jobid, String date,String name,String vehicleno,int brandname,int size,int ply,String tyreparts,int availability,int neededqty)
	{
		logger.debug("TyreRequisitionDAO:insert <<<<<<<<<");
		db.otherQuery("insert into tyrerequisition values("+jobid+",'"+date+"','"+name+"','"+vehicleno+"',"+brandname+","+size+","+ply+",'"+tyreparts+"',"+availability+","+neededqty+",0)");
		logger.debug("TyreRequisitionDAO:insert >>>>>>>>>");
	}
	public int insertlookup(String name,String ctype)
	{
		logger.debug("TyreRequisitionDAO:insertlookup <<<<<<<<<");
		list=db.selectQuery("com.vo.TyreRequisitionVO","select code from lookup where cdesc='"+name+"'");
		vo=(TyreRequisitionVO)list.get(0);
		if(list.size()==0)
		{
			int lcode=getlookupcode();
			db.otherQuery("insert into lookup values("+lcode+",'"+ctype+"','"+name+"')");
			logger.debug("TyreRequisitionDAO:insertlookup >>>>>>>>>");
			return lcode;
		}
		else
		{
			int code=Integer.parseInt(vo.getCode());
			logger.debug("TyreRequisitionDAO:insertlookup >>>>>>>>>");
			return code;
		}
	}
	public int getlookupcode()
	{
		logger.debug("TyreRequisitionDAO:getlookupcode <<<<<<<<<");
		list=db.selectQuery("com.vo.TyreRequisitionVO", "select MAX(code)as code from lookup");
		TyreRequisitionVO vo=(TyreRequisitionVO)list.get(0);
		String lookupcode=vo.getCode();
		int lcode=Integer.parseInt(lookupcode);
		lcode=lcode+1;
		logger.debug("TyreRequisitionDAO:getlookupcode >>>>>>>>");
		return lcode;
	}
	public int getavailability(int brandname,int size,int ply)
	{
	 logger.debug("TyreRequisitionDAO:getavailability <<<<<<<<<");
	 list=db.selectQuery("com.vo.TyreRequisitionVO", "select count(tyrebrand) as AVAILABLEQTY from tyremaster where tyrebrand="+brandname+" and tyreply="+ply+" and tyresize="+size+"");
	 vo=(TyreRequisitionVO)list.get(0);
	 int avail=Integer.parseInt(vo.getAvailableQty1());
	 logger.debug("getavailability"+avail);
	 logger.debug("TyreRequisitionDAO:getavailability  >>>>>>>>");
	 return avail;
	}
	public ArrayList retrieve(Integer jobid)
	{
		logger.debug("retrieve :TyreRequisitionDAO <<<<<<<<<<<<<<< ");
		String query="select REQDATE,REQFROM,VEHICLENO,TYREBRAND,TYRESIZE,TYREPLY,TYREPARTS,AVAILABLEQTY,NEEDEDQTY,APPROVESTATUS from tyrerequisition where jid="+jobid+"";
		list=db.selectQuery("com.vo.TyreRequisitionVO",query);
		for(int i=0;i<list.size();i++)
		{
		TyreRequisitionVO vo=(TyreRequisitionVO)list.get(i);
		logger.debug("TyreRequisitionDAO:vno"+vo.getApproveStatus());
		}
		logger.debug("retrieve :TyreRequisitionDAO : Record Fetched");
		logger.debug("retrieve :TyreRequisitionDAO >>>>>>>>>>>>>>>");
		return list;
	}
	public ArrayList fetchApproveStatusList()
	{
		logger.debug("TyreRequisitionDAO:fetchApproveStatusList <<<<<<<<<");
		ArrayList deslist=db.selectQuery("com.vo.TyreRequisitionVO","select code,description as des from store_lookup where ctype='approvestatus'");
		logger.debug("TyreRequisitionDAO:fetchApproveStatusList >>>>>>>>>>>>>>>");
		return deslist;
	}
	public void status(int job,String brand,String size,String ply,String appstatus)
	{
		logger.debug("TyreRequisitionDAO:status <<<<<<<<<");
		logger.debug("appstatus"+appstatus);
		int status=Integer.parseInt(appstatus);
		int tbrand=Integer.parseInt(brand);
		int tsize=Integer.parseInt(size);
		int tply=Integer.parseInt(ply);
		db.otherQuery("update tyrerequisition set approvestatus="+status+" where jid="+job+" and tyrebrand="+tbrand+" and tyresize="+tsize+" and tyreply="+tply+" " );
		logger.debug("TyreRequisitionDAO:status >>>>>>>>>>>>>>>");
	}
	
}
