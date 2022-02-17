package com.dao;

import java.util.ArrayList;
import org.apache.log4j.Logger;
import com.dbcom.dbcom;
import com.vo.OilGreasePurchaseVO;
import com.vo.OilGreaseRequisitionVO;

public class OilGreasePurchaseDAO {
	private static final Logger logger=(Logger)Logger.getLogger(OilGreasePurchaseDAO.class);
	dbcom db=new dbcom();
	ArrayList list=null;
	ArrayList list1=new ArrayList();
	ArrayList list2=new ArrayList();
	ArrayList brandnamelist=new ArrayList();
	ArrayList brandtypelist=new ArrayList();
	//OilGreaseRequisitionVO rvo=new OilGreaseRequisitionVO();
	OilGreasePurchaseVO pvo=new OilGreasePurchaseVO();
	public ArrayList fetchCompanyName()
	{
		logger.debug("fetchCompanyName <<<<<<<<<");
		list=db.selectQuery("com.vo.OilGreasePurchaseVO","select code,description as des from storelookup where ctype='CompanyName'" );
		logger.debug("fetchCompanyName >>>>>>>>>");
		return list;
	}
	public String getPurchaseItem(int jobid)
	{
		logger.debug("getPurchaseItem <<<<<<<<<");
		list=db.selectQuery("com.vo.OilGreasePurchaseVO","select reqitem from oilgreaserequisition where jid="+jobid);
		pvo=(OilGreasePurchaseVO)list.get(0);
		String req=pvo.getItemDes();
		logger.debug("getPurchaseItem >>>>>>>>>>>>>>>>");
		return req;
	}
	public ArrayList retrieve(Integer jobid)
	{
		logger.debug("retrieve :OilGreasePurchaseDAO <<<<<<<<<<<<<<< ");
		String query="select BILL_DATE AS BILLDATE,BILL_NO AS BILLNO,PURCHASE_DATE AS PURCHASEDATE,COMPANY_NAME AS COMPANYNAME,PLACE,GOODS_TYPE AS GOODSTYPE from STORE_SUPPLIER where jobid="+jobid+"";
		list=db.selectQuery("com.vo.OilGreasePurchaseVO",query);
		
		 
		for(int i=0;i<list.size();i++)
		{
			OilGreasePurchaseVO vo=(OilGreasePurchaseVO)list.get(i);
		//logger.debug(vo.getDate()+vo.getFrom()+vo.getItemDes()+vo.getBrandName1()+vo.getBrandType1()+vo.getAvailableQty1()+vo.getQtyNeeded1());
		}
		logger.debug("retrieve :OilGreasePurchaseDAO : Record Fetched");
		logger.debug("retrieve :OilGreasePurchaseDAO >>>>>>>>>>>>>>> ");
		return list;
	}
	public ArrayList fetchItemDes()
	{
		logger.debug("fetchItemDes <<<<<<<<<");
		list=db.selectQuery("com.vo.OilGreasePurchaseVO","select code,cdesc as des from lookup where ctype='oilgrease'" );
		logger.debug("fetchItemDes >>>>>>>>>");
		return list;
	}
	
	
	public ArrayList fetchBrandName(int jobid)
	{
		logger.debug("fetchBrandType <<<<<<<<<");	
		ArrayList list1=db.selectQuery("com.vo.OilGreasePurchaseVO","select code from storelookup where description='Yes'");
		pvo=(OilGreasePurchaseVO)list1.get(0);
		int status=Integer.parseInt(pvo.getCode());
		ArrayList deslist=db.selectQuery("com.vo.OilGreasePurchaseVO","select code, cdesc as des from lookup where code in(select Brandname from oilgreaserequisition where jid="+jobid+" and approvestatus="+status+")");
		logger.debug("fetchBrandName >>>>>>>>>");
		return deslist;
	}
	public ArrayList fetchBrandType(int jobid)
	{
		logger.debug("fetchBrandType <<<<<<<<<");	
		
		ArrayList list1=db.selectQuery("com.vo.OilGreasePurchaseVO","select code from storelookup where description='Yes'");
		pvo=(OilGreasePurchaseVO)list1.get(0);
		int status=Integer.parseInt(pvo.getCode());
		ArrayList deslist=db.selectQuery("com.vo.OilGreasePurchaseVO","select code, cdesc as des from lookup where code in(select Brandtype from oilgreaserequisition where jid="+jobid+" and approvestatus="+status+")");
		
		logger.debug("fetchBrandType >>>>>>>>>");
		return deslist;
	}
	
	public ArrayList fetchplacelist(String cname)
	{
		
		logger.debug("fetchplacelist <<<<<<<<<");
		int cid=Integer.parseInt(cname);
		list=db.selectQuery("com.vo.OilGreasePurchaseVO", "select code,description as des from storelookup where ctype=(select description as des from storelookup where code="+cid+")");
		logger.debug("fetchplacelist >>>>>>>>>");
		return list;
	}
	public String getItemName(String item)
	{
		
		logger.debug("getItemName <<<<<<<<<");
		int reqitem= Integer.parseInt(item);
		list1=db.selectQuery("com.vo.OilGreasePurchaseVO","select cdesc as des from lookup where code="+reqitem);
		pvo=(OilGreasePurchaseVO)list1.get(0);
		String des=pvo.getDes();
		logger.debug("getItemName >>>>>>>>>");
		return des;
	}
	
	public int getsid()
	{
		logger.debug("getsid <<<<<<<<<");
		ArrayList sidlist=db.selectQuery("com.vo.OilGreasePurchaseVO", "select MAX(sid)as sid from STORE_SUPPLIER");
		OilGreasePurchaseVO vo=(OilGreasePurchaseVO)sidlist.get(0);
		String strsid=vo.getSid();
		int sid=Integer.parseInt(strsid);
		sid=sid+1;
		logger.debug("getsid >>>>>>>>>>>>>");
		return sid;
	}
	public void insertSupplier(int jobid,String date,String billno,String delivereddate,String cname,String place,String reqitem)
	{
		logger.debug("insertSupplier <<<<<<<<<");
		int sid=getsid();
		db.otherQuery("insert into STORE_SUPPLIER values("+sid+",'"+jobid+"','"+date+"','"+billno+"','"+delivereddate+"','"+cname+"','"+place+"','"+reqitem+"',"+0+")");
	}
	public String fetchpartno(String item)
	{
		logger.debug("fetchpartno <<<<<<<<<");
		ArrayList deslist=db.selectQuery("com.vo.OilGreasePurchaseVO","select description as des from STORE_LOOKUP where ctype='"+item+"'");
		OilGreasePurchaseVO vo=(OilGreasePurchaseVO)deslist.get(0);
		String des=vo.getDes();
		logger.debug("fetchpartno >>>>>>>>>>");
		return des;
	}
	
	public ArrayList fetchAvailbaleQty(String item,String brandtype)
	{ 
		logger.debug("OilGreasePurchaseDAO:fetchAvailbaleQty <<<<<<<<<");
		
		String itemname=getItemName(item);
		String brandcat=getItemName(brandtype);
		ArrayList deslist=db.selectQuery("com.vo.OilGreasePurchaseVO","select sum(told_qty+tnew_qty)as availableqty from common_transaction where itemname='"+itemname+"' and subtype='"+brandcat+"'");
		logger.debug("OilGreasePurchaseDAO:fetchAvailbaleQty >>>>>>>>>");
		return deslist;
}
	public void insertProduct(int jobid,String brandname,String brandcategory,int availability)
	{
		
		logger.debug("insertProduct <<<<<<<<<");
		int sid=getsid();
		db.otherQuery("insert into STORE_PAINT_SPARE_GREASE_OIL values("+jobid+","+sid+",'"+brandname+"','"+brandcategory+"',"+availability+")");
		logger.debug("insertProduct >>>>>>>>>");
	
	}
	public void insertVat(int jobid,String brandname,String brandcategory,String partno,int quantity,float unitprice,float vatpercent,float vatamount,float additionalamount,float amount)
	{
		logger.debug("insertVat <<<<<<<<<");
		int sid=getsid();
		db.otherQuery("insert into store_common_transaction values("+jobid+","+sid+",'"+brandname+"','"+brandcategory+"','"+partno+"',"+quantity+","+unitprice+","+vatpercent+","+vatamount+","+additionalamount+","+amount+")");
		logger.debug("insertVat >>>>>>>>>");
	}
	
	public void insertcommontrans(String item,String brandcategory,float unitprice,int quantity)
	{
		logger.debug("insertcommontrans <<<<<<<<<");
		String itemname=getItemName(item);
		String brandcat=getItemName(brandcategory);
		ArrayList deslist=db.selectQuery("com.vo.OilGreasePurchaseVO","select TOLD_QTY as TEMPOLDQTY from common_transaction where ITEMNAME='"+itemname+"'and SUBTYPE='"+brandcat+"'");
		OilGreasePurchaseVO vo=(OilGreasePurchaseVO)deslist.get(0);
		String toldqty=vo.getTemporaryOldQty();
		Float tempqty=Float.parseFloat(toldqty);
		if (tempqty==0)
		{
			ArrayList list1=db.selectQuery("com.vo.OilGreasePurchaseVO","select NEW_RATE,TNEW_QTY from common_transaction where ITEMNAME='"+itemname+"'and SUBTYPE='"+brandcat+"'");
			OilGreasePurchaseVO vo1=(OilGreasePurchaseVO)list1.get(0);
			float oldrate=Float.parseFloat(vo1.getNewRate());
			float oldqty=Float.parseFloat(vo1.getTemporaryNewQty());
			db.otherQuery("update common_transaction set OLD_RATE="+oldrate+",NEW_RATE="+unitprice+",TOLD_QTY="+oldqty+",TNEW_QTY="+quantity+" where ITEMNAME='"+itemname+"'and SUBTYPE='"+brandcat+"'" );
		}
		else
		{
			db.otherQuery("update common_transaction set EXTRA_QTY="+quantity+",EXTRA_RATE="+unitprice+" where ITEMNAME='"+itemname+"'and SUBTYPE='"+brandcat+"'" );
		}
		
		logger.debug("insertcommontrans >>>>>>>>>");
	}
}
