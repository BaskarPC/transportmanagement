package com.dao;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.dbcom.dbcom;
import com.formbean.OilGreaseRequisitionForm;
import com.vo.DieselRequisitionVO;
import com.vo.OilGreasePurchaseVO;
import com.vo.OilGreaseRequisitionVO;

public class OilGreaseRequisitionDAO {
	private static final Logger logger=(Logger)Logger.getLogger(OilGreaseRequisitionDAO.class);
	dbcom db=new dbcom();
	ArrayList list=null;
	OilGreaseRequisitionForm of=new OilGreaseRequisitionForm();
	OilGreaseRequisitionVO vo=new OilGreaseRequisitionVO();
	ArrayList list1=new ArrayList();
	ArrayList list2=new ArrayList();
	public ArrayList fetchRequiredItem()
	{
		logger.debug("fetchRequiredItem <<<<<<<<<");
		list=db.selectQuery("com.vo.OilGreaseRequisitionVO","select code,cdesc as des from lookup where ctype='oilgrease'" );
		logger.debug("fetchRequiredItem >>>>>>>>>");
		return list;
	}
	
	public ArrayList getitem(String name)
	{
		logger.debug("fetchRequiredItem <<<<<<<<<");
		int itemcode=Integer.parseInt(name);
		list=db.selectQuery("com.vo.OilGreaseRequisitionVO","select cdesc as des from lookup where code="+itemcode );
		logger.debug("fetchRequiredItem >>>>>>>>>");
		
		return list;
	}
	public ArrayList fetchAvailbaleQty(String item,String brandtype)
	{ 
	logger.debug("OilGreaseRequisitionDAO:fetchAvailbaleQty <<<<<<<<<");
	ArrayList l1=getitem(item);
	vo=(OilGreaseRequisitionVO)l1.get(0);
	String itemname=vo.getDes();
	ArrayList l2=getitem(brandtype);
	vo=(OilGreaseRequisitionVO)l2.get(0);
	String brandcat=vo.getDes();
	ArrayList deslist=db.selectQuery("com.vo.OilGreaseRequisitionVO","select sum(told_qty+tnew_qty)as availableqty from common_transaction where itemname='"+itemname+"' and subtype='"+brandcat+"'");
	logger.debug("OilGreaseRequisitionDAO:fetchAvailbaleQty >>>>>>>>>");
	return deslist;
}
	
	public void insert(int jobid, String date,String name,int reqitem,int brandname,int brandcategory,int availability,int neededqty)
	{
		logger.debug("OilGreaseRequisitionDAO:insert <<<<<<<<<");
		db.otherQuery("insert into OILGREASEREQUISITION values("+jobid+",'"+date+"','"+name+"','"+reqitem+"','"+brandname+"','"+brandcategory+"',"+availability+","+neededqty+",0)");
		logger.debug("OilGreaseRequisitionDAO:insert >>>>>>>>>");
	}
	
	public ArrayList fetchApproveStatusList()
	{
		logger.debug("fetchApproveStatusList <<<<<<<<<");
		ArrayList deslist=db.selectQuery("com.vo.OilGreasePurchaseVO","select code,description as des from storelookup where ctype='approvestatus'");
		return deslist;
	}
	
	
	public ArrayList fetchBrandName(String item)
	{
		logger.debug("fetchBrandType <<<<<<<<<");		
		int id=Integer.parseInt(item);
		ArrayList deslist=db.selectQuery("com.vo.OilGreaseRequisitionVO","select cdesc as des from lookup where code="+id);
		vo=(OilGreaseRequisitionVO)deslist.get(0);
		String des=vo.getDes();	
		if (des.equals("Oil"))
		list1=db.selectQuery("com.vo.OilGreaseRequisitionVO","select code,cdesc as des from lookup where ctype='oilbrand'" );
		if (des.equals("Grease"))
		list1=db.selectQuery("com.vo.OilGreaseRequisitionVO","select code,cdesc as des from lookup where ctype='greasebrand'" );
		logger.debug("fetchBrandName >>>>>>>>>");
		return list1;
	}
	public ArrayList fetchBrandType(String item)
	{
		logger.debug("fetchBrandType <<<<<<<<<");		
		int id=Integer.parseInt(item);		
		ArrayList deslist=db.selectQuery("com.vo.OilGreaseRequisitionVO","select cdesc as des from lookup where code="+id);
		vo=(OilGreaseRequisitionVO)deslist.get(0);
		String des=vo.getDes();	
		if (des.equals("Grease"))
			list2=db.selectQuery("com.vo.OilGreaseRequisitionVO","select code,cdesc as des from lookup where ctype='greasetype'" );
		if (des.equals("Oil"))
			list2=db.selectQuery("com.vo.OilGreaseRequisitionVO","select code,cdesc as des from lookup where ctype='oiltype'" );
			
		logger.debug("fetchBrandType >>>>>>>>>");
		return list2;
	}
	public ArrayList retrieve(Integer jobid)
	{
		logger.debug("retrieve :OilGreaseRequisitionDAO <<<<<<<<<<<<<<< ");
		String query="select REQDATE,REQFROM,REQITEM,BRANDNAME,BRANDTYPE,AVAILABLEQTY,NEEDEDQTY,APPROVESTATUS from oilgreaserequisition where jid="+jobid+"";
		list=db.selectQuery("com.vo.OilGreaseRequisitionVO",query);
		for(int i=0;i<list.size();i++)
		{
		OilGreaseRequisitionVO vo=(OilGreaseRequisitionVO)list.get(i);
		}
		logger.debug("retrieve :OilGreaseRequisitionDAO : Record Fetched");
		logger.debug("retrieve :OilGreaseRequisitionDAO >>>>>>>>>>>>>>> ");
		return list;
	}
	public int insertlookup(int reqitem,String brandname,String brandcategory)
{
		logger.debug("insertlookup <<<<<<<<");
		int id=reqitem;		
		ArrayList deslist=db.selectQuery("com.vo.OilGreaseRequisitionVO","select cdesc as des from LOOKUP where code="+id);
		vo=(OilGreaseRequisitionVO)deslist.get(0);
		String des=vo.getDes();	
		int lookupid=getlookupcode();
		if (des.equals("Grease"))
		{
			db.otherQuery("insert into lookup values("+lookupid+",'"+"greasebrand"+"','"+brandname+"')");
		    db.otherQuery("insert into lookup values("+(lookupid+1)+",'"+"greasetype"+"','"+brandcategory+"')");
		}
		if (des.equals("Oil"))
		{
			db.otherQuery("insert into lookup values("+lookupid+",'"+"oilbrand"+"','"+brandname+"')");
		db.otherQuery("insert into lookup values("+(lookupid+1)+",'"+"oiltype"+"','"+brandcategory+"')");
		}
		logger.debug("insertlookup >>>>>>>>>");		
		return lookupid;
		
}
	
	public void insertcommontrans(String item, String brandcategory)
	{
		logger.debug("insertcommontrans <<<<<<<<<");
		String partno=fetchpartno(item);
		db.otherQuery("insert into common_transaction values('"+partno+"','"+item+"','"+brandcategory+"',0,0,0,0,0,0,20,0,0)");
		logger.debug("insertcommontrans >>>>>>>>>>");
	}
	
	
	public String fetchpartno(String item)
	{
		logger.debug("fetchpartno <<<<<<<<<");
		ArrayList l1=getitem(item);
		vo=(OilGreaseRequisitionVO)l1.get(0);
		String name=vo.getDes();
		ArrayList deslist=db.selectQuery("com.vo.OilGreaseRequisitionVO","select description as des from STORE_LOOKUP where ctype='"+name+"'");
		OilGreaseRequisitionVO vo=(OilGreaseRequisitionVO)deslist.get(0);
		String des=vo.getDes();
		return des;
	}
	
	public void status(int job,String bname,String btype,String appstatus)
	{
		logger.debug("status <<<<<<<<<");
		logger.debug("appstatus"+appstatus);
		int status=Integer.parseInt(appstatus);
		int brandname=Integer.parseInt(bname);
		int brandcat=Integer.parseInt(btype);
		db.otherQuery("update oilgreaserequisition set approvestatus="+status+" where jid="+job+" and brandname="+brandname+" and brandtype="+brandcat+" " );	
	}
	
	public int getlookupcode()
	{
		logger.debug("getlookupcode <<<<<<<<<");
		ArrayList sidlist=db.selectQuery("com.vo.OilGreaseRequisitionVO", "select MAX(code)as code from LOOKUP");
		OilGreaseRequisitionVO vo=(OilGreaseRequisitionVO)sidlist.get(0);
		logger.debug("vocode"+vo.getCode());
		String strsid=vo.getCode();
		int sid=Integer.parseInt(strsid);
		sid=sid+1;
		logger.debug("getlookupcode >>>>>>>>>>>>>");
		return sid;
	}
}
