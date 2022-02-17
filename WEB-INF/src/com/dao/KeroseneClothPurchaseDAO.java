package com.dao;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.dbcom.dbcom;
import com.vo.DieselPurchaseVO;
import com.vo.KeroseneClothPurchaseVO;
import com.vo.OilGreasePurchaseVO;
import com.vo.OilGreaseRequisitionVO;

public class KeroseneClothPurchaseDAO {
	private static final Logger logger=(Logger)Logger.getLogger(KeroseneClothPurchaseDAO.class);
	dbcom db=new dbcom();
	ArrayList list=new ArrayList();
	String vo="com.vo.KeroseneClothPurchaseVO";
	KeroseneClothPurchaseVO vo1=new KeroseneClothPurchaseVO();
	public ArrayList fetchItemDes()
	{
		logger.debug("fetchItemDes <<<<<<<<<");
		list=db.selectQuery(vo,"select code,description as des from store_lookup where ctype='kerocloth'" );
		logger.debug("fetchItemDes >>>>>>>>>");
		return list;
	}
	public String fetchPartNumber(String item)
	{
		logger.debug("fetchPartNumber <<<<<<<<<");
		list=db.selectQuery(vo,"select description as des from common_partno_lookup where code="+item+"" );
		logger.debug("fetchPartNumber >>>>>>>>>");
		vo1=(KeroseneClothPurchaseVO)list.get(0);
		String partno=vo1.getPlace();
		return partno;
	}
	public ArrayList fetchplacelist(String cname)
	{
		
		logger.debug("fetchplacelist <<<<<<<<<");
		int cid=Integer.parseInt(cname);
		list=db.selectQuery(vo, "select code,description as des from store_lookup where ctype in (select description as des from store_lookup where code="+cid+")");
		logger.debug("fetchplacelist >>>>>>>>>");
		return list;
	}
	public ArrayList fetchCompanyName()
	{
		logger.debug("fetchCompanyName <<<<<<<<<");
		list=db.selectQuery(vo,"select code,description as des from store_lookup where ctype='CompanyName'" );
		logger.debug("fetchCompanyName >>>>>>>>>");
		return list;
	}
	public String getPurchaseItem(int jobid)
	{
		logger.debug("getPurchaseItem <<<<<<<<<");
		logger.debug("JOBID"+jobid);
		list=db.selectQuery(vo,"select reqitem from kerosenerequisition where jid="+jobid);
		logger.debug("getPurchaseItem >>>>>>>>>");
		vo1=(KeroseneClothPurchaseVO)list.get(0);
		logger.debug("getPurchaseItem:required item >"+vo1.getItemDes());
		String req=vo1.getItemDes();		
		return req;
	}
	public int getsid()
	{
		logger.debug("getsid <<<<<<<<<");
		ArrayList sidlist=db.selectQuery(vo, "select MAX(sid)as sid from STORE_SUPPLIER");
		KeroseneClothPurchaseVO vo=(KeroseneClothPurchaseVO)sidlist.get(0);
		logger.debug("vosid"+vo.getSid());
		String strsid=vo.getSid();
		int sid=Integer.parseInt(strsid);
		sid=sid+1;
		logger.debug("getsid >>>>>>>>>>>>>");
		return sid;
	}
	public void insertSupplier(int sid,int jobid,String date,String billno,String delivereddate,String cname,String place,String reqitem)
	{
		logger.debug("insertSupplier <<<<<<<<<");
	
		db.otherQuery("insert into STORE_SUPPLIER values("+sid+",'"+jobid+"','"+date+"','"+billno+"','"+delivereddate+"','"+cname+"','"+place+"','"+reqitem+"',"+0+")");
	}
	public void insertProduct(int sid,int jobid,int qtypurchased,float rate,float amt)
	{
		logger.debug("insertProduct <<<<<<<<<");
	
		db.otherQuery("insert into KEROCLOTH_PURCHASE values("+sid+","+jobid+","+qtypurchased+","+rate+","+amt+")");
	}
	public void insertcommontrans(String item, float unitprice,int quantity)
	{
		logger.debug("insertcommontrans <<<<<<<<<");
		list=db.selectQuery(vo, "select description as des from store_lookup where code="+Integer.parseInt(item));
		vo1=(KeroseneClothPurchaseVO)list.get(0);
		String name=vo1.getDes();
		list=db.selectQuery(vo,"select TOLD_QTY as TEMPOLDQTY from common_transaction where itemname='"+name+"'");
		vo1=(KeroseneClothPurchaseVO)list.get(0);
		String toldqty=vo1.getTempOldQty();
		Float tempqty=Float.parseFloat(toldqty);
		if (tempqty==0)
		{
			list=db.selectQuery(vo,"select TNEW_RATE as NEWRATE,TNEW_QTY as NEWQTY from common_transaction where itemname='"+name+"'");
			vo1=(KeroseneClothPurchaseVO)list.get(0);
			float oldrate=Float.parseFloat(vo1.getNewRate());
			float oldqty=Float.parseFloat(vo1.getNewQty());
			db.otherQuery("update common_transaction set TOLD_RATE="+oldrate+",TNEW_RATE="+unitprice+",TOLD_QTY="+oldqty+",TNEW_QTY="+quantity+" where itemname='"+name+"'" );
		}
		else
		{
			db.otherQuery("update common_transaction set EXTRA_QTY="+quantity+",EXTRA_RATE="+unitprice+" where itemname='"+name+"'" );
		}
		
		logger.debug("insertcommontrans >>>>>>>>>");
		
		
	}

}
