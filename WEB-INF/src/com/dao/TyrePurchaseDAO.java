package com.dao;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import com.dbcom.dbcom;
import com.vo.OilGreasePurchaseVO;
import com.vo.TyrePurchaseVO;

public class TyrePurchaseDAO {
	private static final Logger logger=(Logger)Logger.getLogger(OilGreasePurchaseDAO.class);
	dbcom db=new dbcom();
	ArrayList list=null;
	ArrayList list1=new ArrayList();
	ArrayList list2=new ArrayList();
	ArrayList brandnamelist=new ArrayList();
	ArrayList brandtypelist=new ArrayList();
	TyrePurchaseVO vo=new TyrePurchaseVO();
	public ArrayList getCompanyNameList()
	{
		logger.debug("TyrePurchaseDAO:getCompanyNameList <<<<<<<<<");
		list=db.selectQuery("com.vo.TyrePurchaseVO","select code,description as des from store_lookup where ctype='CompanyName'" );
		logger.debug("TyrePurchaseDAO:getCompanyNameList >>>>>>>>>");
		return list;
	}
	public ArrayList fetchplacelist(String cname)
	{
		logger.debug("TyrePurchaseDAO:fetchplacelist<<<<<<<<<");
		int cid=Integer.parseInt(cname);
		list=db.selectQuery("com.vo.TyrePurchaseVO", "select code,description as des from store_lookup where ctype=(select description as des from store_lookup where code="+cid+")");
		logger.debug("TyrePurchaseDAO:fetchplacelist >>>>>>>>>");
		return list;
	}
	public String fetchpartno(String item)
	{
		logger.debug("TyrePurchaseDAO:fetchpartno <<<<<<<<<");
		ArrayList deslist=db.selectQuery("com.vo.TyrePurchaseVO","select description as des from COMMON_PARTNO_LOOKUP where ctype='"+item+"'");
		vo=(TyrePurchaseVO)deslist.get(0);
		String des=vo.getDes();
		logger.debug("TyrePurchaseDAO:fetchpartno >>>>>>>>>>");
		return des;
	}
	public ArrayList getTyreBrandList(int jobid)
	{
		logger.debug("TyrePurchaseDAO:getTyreBrandList <<<<<<<<<<");	
		ArrayList list1=db.selectQuery("com.vo.TyrePurchaseVO","select code from store_lookup where ctype='approvestatus' and description='Yes'");
		vo=(TyrePurchaseVO)list1.get(0);
		int status=Integer.parseInt(vo.getCode());
		ArrayList deslist=db.selectQuery("com.vo.TyrePurchaseVO","select code, cdesc as des from lookup where code in(select tyrebrand from tyrerequisition where jid="+jobid+" and approvestatus="+status+")");
		logger.debug("TyrePurchaseDAO:fetchBrandName >>>>>>>>>");
		return deslist;
	}
	public ArrayList getTyreSizeList(int jobid)
	{
		logger.debug("TyrePurchaseDAO:fetchBrandType <<<<<<<<<");	
		ArrayList list1=db.selectQuery("com.vo.TyrePurchaseVO","select code from store_lookup where ctype='approvestatus' and description='Yes'");
		vo=(TyrePurchaseVO)list1.get(0);
		int status=Integer.parseInt(vo.getCode());
		ArrayList deslist=db.selectQuery("com.vo.TyrePurchaseVO","select code, cdesc as des from lookup where code in(select tyresize from tyrerequisition where jid="+jobid+" and approvestatus="+status+")");	
		logger.debug("TyrePurchaseDAO:fetchBrandType >>>>>>>>>");
		return deslist;
	}
	public ArrayList getTyrePlyList(int jobid)
	{
		logger.debug("TyrePurchaseDAO:getTyrePlyList <<<<<<<<<");	
		ArrayList list1=db.selectQuery("com.vo.TyrePurchaseVO","select code from store_lookup where ctype='approvestatus' and description='Yes'");
		vo=(TyrePurchaseVO)list1.get(0);
		int status=Integer.parseInt(vo.getCode());
		ArrayList deslist=db.selectQuery("com.vo.TyrePurchaseVO","select code, cdesc as des from lookup where code in(select tyreply from tyrerequisition where jid="+jobid+" and approvestatus="+status+")");	
		logger.debug("TyrePurchaseDAO:getTyrePlyList >>>>>>>>>");
		return deslist;
	}
	public ArrayList getTyrePartsList(int jobid)
	{
		logger.debug("TyrePurchaseDAO:getTyreTypeList <<<<<<<<<");	
		ArrayList list1=db.selectQuery("com.vo.TyrePurchaseVO","select code from store_lookup where ctype='approvestatus' and description='Yes'");
		vo=(TyrePurchaseVO)list1.get(0);
		int status=Integer.parseInt(vo.getCode());
		ArrayList deslist=db.selectQuery("com.vo.TyrePurchaseVO","select code, cdesc as des from lookup where code in(select tyreply from tyrerequisition where jid="+jobid+" and approvestatus="+status+")");	
		logger.debug("TyrePurchaseDAO:getTyreTypeList >>>>>>>>>");
		return deslist;
	}
	public int getsid()
	{
		logger.debug("TyrePurchaseDAO:getsid <<<<<<<<<");
		ArrayList sidlist=db.selectQuery("com.vo.TyrePurchaseVO", "select MAX(sid)as sid from STORE_SUPPLIER");
		vo=(TyrePurchaseVO)sidlist.get(0);
		String strsid=vo.getSid();
		int sid=Integer.parseInt(strsid);
		sid=sid+1;
		logger.debug("TyrePurchaseDAO:getsid >>>>>>>>>>>>>");
		return sid;
	}
	public void insertSupplier(int jobid,String date,String billno,String delivereddate,String cname,String place,String reqitem)
	{
		logger.debug("insertSupplier <<<<<<<<<");
		int sid=getsid();
		db.otherQuery("insert into STORE_SUPPLIER values("+sid+",'"+jobid+"','"+date+"','"+billno+"','"+delivereddate+"','"+cname+"','"+place+"','"+reqitem+"',"+0+")");
	}
	public void insertProduct(int jobid,int tyrebrand,int tyresize,int tyreply,String tyreparts,String tyreno,float unitprice,float vatpercent,float vatamount,float additionalamount,float amount)

	{
		
		logger.debug("TyrePurchaseDAO:insertProduct <<<<<<<<<");
		int sid=getsid();
		db.otherQuery("insert into STORE_TYRE values("+jobid+","+sid+","+tyrebrand+","+tyresize+","+tyreply+",'"+tyreparts+"','"+tyreno+"',"+unitprice+","+vatpercent+","+vatamount+","+additionalamount+","+amount+")");
		logger.debug("TyrePurchaseDAO:insertProduct >>>>>>>>>");
	
	}
	public void insertcommontrans(int tyrebrand,int tyresize,int tyreply,String tyreno)
	{
		logger.debug("TyrePurchaseDAO:insertcommontrans <<<<<<<<<");
		int sid=getsid();
		db.otherQuery("insert into tyremaster values("+tyrebrand+","+tyresize+","+tyreply+",'"+tyreno+"','Original','N','Y')");
		logger.debug("TyrePurchaseDAO:insertcommontrans >>>>>>>>>");
	}
}
