package com.dao;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.dbcom.dbcom;
import com.vo.DieselPurchaseVO;
import com.vo.OilGreasePurchaseVO;


public class DieselPurchaseDAO {
	private static final Logger logger=(Logger)Logger.getLogger(DieselPurchaseDAO.class);
	dbcom db=new dbcom();
	String vofile="com.vo.DieselPurchaseVO";
	DieselPurchaseVO vo=new DieselPurchaseVO();
	DieselPurchaseVO vo1=new DieselPurchaseVO();
	ArrayList list=null;
	public String fetchCompany(int jobid)
	{
		logger.debug("fetchCompany :DieselPurchaseDAO <<<<<<<<<<<<<<< ");
		String query="select company_name as ordercompany from dieselorder where jobid="+jobid;
		list=db.selectQuery(vofile,query);
		logger.debug("fetchCompany :DieselPurchaseDAO : Record fetched list size :"+list.size());
		logger.debug("fetchCompany :DieselPurchaseDAO >>>>>>>>>>>>>>> ");
		vo=(DieselPurchaseVO)list.get(0);
		int code=Integer.parseInt(vo.getCompanyName());
		ArrayList list1=db.selectQuery(vofile, "select cdesc as des from lookup where code="+code);
		vo1=(DieselPurchaseVO)list1.get(0);
		logger.debug("comapny name :"+vo1.getDes());
		return vo1.getDes();	
	}
	public void insertSupplier(int sid,int jobid,String date,String billno,String delivereddate,String cname,String place,String reqitem)
	{
		
		logger.debug("insertSupplier <<<<<<<<<");
		
		db.otherQuery("insert into STORE_SUPPLIER values("+sid+",'"+jobid+"','"+date+"','"+billno+"','"+delivereddate+"','"+cname+"','"+place+"','"+reqitem+"',"+0+")");
	}
	public String fetchpartno(String item)
	{
		logger.debug("fetchpartno <<<<<<<<<");
		ArrayList deslist=db.selectQuery("com.vo.DieselPurchaseVO","select description as des from common_partno_lookup where ctype='"+item+"'");
		DieselPurchaseVO vo=(DieselPurchaseVO)deslist.get(0);
		String des=vo.getDes();
		return des;
	}
	public void insertProduct(String partno,int jobid,int sid,String load,String vno,String dname,String damount,String dtime,String tipscale)
	{
		logger.debug("insertProduct <<<<<<<<<");
		db.otherQuery("insert into STORE_DIESEL values('"+partno+"',"+jobid+","+sid+",'"+load+"','"+vno+"','"+dname+"','"+damount+"','"+dtime+"','"+tipscale+"')");
		logger.debug("insertProduct >>>>>>>>>");
	
	}
	public void insertVat(int jobid,int sid,String brandname,String brandcategory,String partno,int quantity,float unitprice,float vatpercent,float vatamount,float additionalamount,float amount)
	{
		logger.debug("insertVat <<<<<<<<<");
		db.otherQuery("insert into store_common_transaction values("+jobid+","+sid+",'"+brandname+"','"+brandcategory+"','"+partno+"',"+quantity+","+unitprice+","+vatpercent+","+vatamount+","+additionalamount+","+amount+")");
		logger.debug("insertVat >>>>>>>>>");
	}
	public int getsid()
	{
		logger.debug("getsid <<<<<<<<<");
		ArrayList sidlist=db.selectQuery("com.vo.DieselPurchaseVO", "select MAX(sid)as sid from STORE_SUPPLIER");
		DieselPurchaseVO vo=(DieselPurchaseVO)sidlist.get(0);
		logger.debug("vosid"+vo.getSid());
		String strsid=vo.getSid();
		int sid=Integer.parseInt(strsid);
		sid=sid+1;
		logger.debug("getsid >>>>>>>>>>>>>");
		return sid;
	}
	public void insertcommontrans(float unitprice,int quantity)
	{
		logger.debug("insertcommontrans <<<<<<<<<");
		ArrayList deslist=db.selectQuery("com.vo.DieselPurchaseVO","select TOLD_QTY as TEMPOLDQTY from common_transaction where partnumber='P1'");
		DieselPurchaseVO vo=(DieselPurchaseVO)deslist.get(0);
		String toldqty=vo.getTempOldQty();
		Float tempqty=Float.parseFloat(toldqty);
		if (tempqty==0)
		{
			ArrayList list1=db.selectQuery("com.vo.DieselPurchaseVO","select TNEW_RATE as NEWRATE,TNEW_QTY as NEWQTY from common_transaction where partnumber='P1'");
			DieselPurchaseVO vo1=(DieselPurchaseVO)list1.get(0);
			float oldrate=Float.parseFloat(vo1.getNewRate());
			float oldqty=Float.parseFloat(vo1.getNewQty());
			db.otherQuery("update common_transaction set TOLD_RATE="+oldrate+",TNEW_RATE="+unitprice+",TOLD_QTY="+oldqty+",TNEW_QTY="+quantity+" where partnumber='P1'" );
		}
		else
		{
			db.otherQuery("update common_transaction set EXTRA_QTY="+quantity+",EXTRA_RATE="+unitprice+" where partnumber='P1'" );
		}
		
		logger.debug("insertcommontrans >>>>>>>>>");
		
		
	}


}
