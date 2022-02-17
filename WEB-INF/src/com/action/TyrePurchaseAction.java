package com.action;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.formbean.OilGreasePurchaseForm;
import com.formbean.TyrePurchaseForm;
import com.service.TyrePurchaseService;
import com.wf.job;

//import com.wf.*;

public class TyrePurchaseAction extends BaseDispatchAction{
	private static final Logger logger=(Logger)Logger.getLogger(TyrePurchaseAction.class);
	TyrePurchaseService ts= new TyrePurchaseService();
	job jb=new job();
	int jobid;
	ArrayList list=new ArrayList();
	ArrayList list1=new ArrayList();
	static float totalamount=0;
	public ActionForward defaultMethod(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {
		HttpSession session = ((HttpServletRequest) request).getSession();
		TyrePurchaseForm tf=(TyrePurchaseForm)form;
			String ss1=mapping.getName();
			logger.debug("TyrePurchaseAction: defaultMethod<-------------"+ss1);
			jobid=(Integer)session.getAttribute("jobseq");
			list=ts.getCompanyNameList();
			tf.setCompanyNameList(list);
			String pno=ts.fetchpartno("Tyre");
			tf.setPartNo(pno);
			list=ts.getTyreBrandList(jobid);
			tf.setTyreTypeList(list);
			list=ts.getTyreSizeList(jobid);
			tf.setTyreSizeList(list);
			list=ts.getTyrePlyList(jobid);
			tf.setTyrePlyList(list);
			list=ts.getTyrePartsList(jobid);
			tf.setTyrePartsList(list);
			//logger.debug("calling job "+mapping.getName());	
			logger.debug("TyrePurchaseAction:defaultMethod---------->");
			return mapping.findForward("eject1");
		
	}
	
	// to create the job and task
	
	public ActionForward jobMethod(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {
		
		// gets the form name and passes it to create job and tasks
		
		
		logger.debug("inside job method");
		String ss1=mapping.getName();
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		logger.debug("inside job method");
		Connection con=DriverManager.getConnection("jdbc:odbc:gomi","system","gomsmca");
		//jb.creatJob(ss1,con);
		return mapping.findForward("inb");
	
	}
	
	public ActionForward fetchplacelist(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {
		logger.debug("TyrePurchaseAction: fetchplacelist<-------------");
		TyrePurchaseForm tf=(TyrePurchaseForm)form;
		String cname=tf.getCompanyName();
			list=ts.fetchplacelist(cname);
			tf.setPlaceList(list);
			logger.debug("TyrePurchaseAction: fetchplacelist------------->");
			return mapping.findForward("eject1");	
			
	}
	
	
	public ActionForward vatpercentMethod(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {
		
		TyrePurchaseForm tf=(TyrePurchaseForm)form;
		logger.debug("TyrePurchaseAction:vatpercentMethod  <---------");
		if((!StringUtils.isEmpty(tf.getTyreNo1()))&&(StringUtils.isEmpty(tf.getVATAmount1())))
		{
		float vatper=Float.parseFloat(tf.getVATPercent1());
		float unitrate=Float.parseFloat(tf.getTyreRate1());
		float vatamt=(vatper/100)*unitrate;
				String vatamount=Float.toString(vatamt);
		tf.setVATAmount1(vatamount);
		
		}
		
		if((!StringUtils.isEmpty(tf.getTyreNo2()))&&(StringUtils.isEmpty(tf.getVATAmount2())))
		{
		float vatper=Float.parseFloat(tf.getVATPercent2());
		float unitrate=Float.parseFloat(tf.getTyreRate2());
		float vatamt=(vatper/100)*unitrate;
				String vatamount=Float.toString(vatamt);
		tf.setVATAmount2(vatamount);
		
		}
		
		if((!StringUtils.isEmpty(tf.getTyreNo3()))&&(StringUtils.isEmpty(tf.getVATAmount3())))
		{
		float vatper=Float.parseFloat(tf.getVATPercent3());
		float unitrate=Float.parseFloat(tf.getTyreRate3());
		float vatamt=(vatper/100)*unitrate;
				String vatamount=Float.toString(vatamt);
		tf.setVATAmount3(vatamount);
		
		}
		
		if((!StringUtils.isEmpty(tf.getTyreNo4()))&&(StringUtils.isEmpty(tf.getVATAmount4())))
		{
		float vatper=Float.parseFloat(tf.getVATPercent4());
		float unitrate=Float.parseFloat(tf.getTyreRate4());
		float vatamt=(vatper/100)*unitrate;
				String vatamount=Float.toString(vatamt);
		tf.setVATAmount4(vatamount);
		
		}
		
		if((!StringUtils.isEmpty(tf.getTyreNo5()))&&(StringUtils.isEmpty(tf.getVATAmount5())))
		{
		float vatper=Float.parseFloat(tf.getVATPercent5());
		float unitrate=Float.parseFloat(tf.getTyreRate5());
		float vatamt=(vatper/100)*unitrate;
				String vatamount=Float.toString(vatamt);
		tf.setVATAmount5(vatamount);
		
		}
		
		if((!StringUtils.isEmpty(tf.getTyreNo6()))&&(StringUtils.isEmpty(tf.getVATAmount6())))
		{
		float vatper=Float.parseFloat(tf.getVATPercent6());
		float unitrate=Float.parseFloat(tf.getTyreRate6());
		float vatamt=(vatper/100)*unitrate;
				String vatamount=Float.toString(vatamt);
		tf.setVATAmount6(vatamount);
		
		}

		if((!StringUtils.isEmpty(tf.getTyreNo7()))&&(StringUtils.isEmpty(tf.getVATAmount7())))
		{
		float vatper=Float.parseFloat(tf.getVATPercent7());
		float unitrate=Float.parseFloat(tf.getTyreRate7());
		float vatamt=(vatper/100)*unitrate;
				String vatamount=Float.toString(vatamt);
		tf.setVATAmount7(vatamount);
		
		}
		
		if((!StringUtils.isEmpty(tf.getTyreNo8()))&&(StringUtils.isEmpty(tf.getVATAmount8())))
		{
		float vatper=Float.parseFloat(tf.getVATPercent8());
		float unitrate=Float.parseFloat(tf.getTyreRate8());
		float vatamt=(vatper/100)*unitrate;
				String vatamount=Float.toString(vatamt);
		tf.setVATAmount8(vatamount);
		
		}
		logger.debug("OilGreasePurchaseAction:vatpercentMethod  --------->");
			return mapping.findForward("eject1");		
	}
		
	public ActionForward amountMethod(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {
		logger.debug("OilGreasePurchaseAction:AmountMethod  <---------");
		TyrePurchaseForm tf=(TyrePurchaseForm)form;
		float additionalamt=0;
		float unitrate=0;
		float qty=0;
		float vatamt=Float.parseFloat(tf.getVATAmount1());
	
		if((!StringUtils.isEmpty(tf.getTyreNo1()))&&(StringUtils.isEmpty(tf.getAmount1())))
		{
		if(!StringUtils.isEmpty(tf.getAdditionalAmt1()))
		additionalamt=Float.parseFloat(tf.getAdditionalAmt1());
		unitrate=Float.parseFloat(tf.getTyreRate1());
		if(!StringUtils.isEmpty(tf.getVATAmount1()))
		vatamt=Float.parseFloat(tf.getVATAmount1());
		Float amt=unitrate+vatamt+additionalamt;
		String amount=Float.toString(amt);
		tf.setAmount1(amount);
		totalamount=totalamount+amt;
		}
		
		if((!StringUtils.isEmpty(tf.getTyreNo2()))&&(StringUtils.isEmpty(tf.getAmount2())))
		{
		if(!StringUtils.isEmpty(tf.getAdditionalAmt2()))
		additionalamt=Float.parseFloat(tf.getAdditionalAmt2());
		unitrate=Float.parseFloat(tf.getTyreRate2());
		if(!StringUtils.isEmpty(tf.getVATAmount2()))
		vatamt=Float.parseFloat(tf.getVATAmount2());
		Float amt=unitrate+vatamt+additionalamt;
		String amount=Float.toString(amt);
		tf.setAmount2(amount);
		totalamount=totalamount+amt;
		}
		
		if((!StringUtils.isEmpty(tf.getTyreNo3()))&&(StringUtils.isEmpty(tf.getAmount3())))
		{
		if(!StringUtils.isEmpty(tf.getAdditionalAmt3()))
		additionalamt=Float.parseFloat(tf.getAdditionalAmt3());
		unitrate=Float.parseFloat(tf.getTyreRate3());
		if(!StringUtils.isEmpty(tf.getVATAmount3()))
		vatamt=Float.parseFloat(tf.getVATAmount3());
		Float amt=unitrate+vatamt+additionalamt;
		String amount=Float.toString(amt);
		tf.setAmount3(amount);
		totalamount=totalamount+amt;
		}
		
		if((!StringUtils.isEmpty(tf.getTyreNo4()))&&(StringUtils.isEmpty(tf.getAmount4())))
		{
		if(!StringUtils.isEmpty(tf.getAdditionalAmt4()))
		additionalamt=Float.parseFloat(tf.getAdditionalAmt4());
		unitrate=Float.parseFloat(tf.getTyreRate4());
		if(!StringUtils.isEmpty(tf.getVATAmount4()))
		vatamt=Float.parseFloat(tf.getVATAmount4());
		Float amt=unitrate+vatamt+additionalamt;
		String amount=Float.toString(amt);
		tf.setAmount4(amount);
		totalamount=totalamount+amt;
		}
		
		if((!StringUtils.isEmpty(tf.getTyreNo5()))&&(StringUtils.isEmpty(tf.getAmount5())))
		{
		if(!StringUtils.isEmpty(tf.getAdditionalAmt5()))
		additionalamt=Float.parseFloat(tf.getAdditionalAmt5());
		unitrate=Float.parseFloat(tf.getTyreRate5());
		if(!StringUtils.isEmpty(tf.getVATAmount5()))
		vatamt=Float.parseFloat(tf.getVATAmount5());
		Float amt=unitrate+vatamt+additionalamt;
		String amount=Float.toString(amt);
		tf.setAmount5(amount);
		totalamount=totalamount+amt;
		}
		
		if((!StringUtils.isEmpty(tf.getTyreNo6()))&&(StringUtils.isEmpty(tf.getAmount6())))
		{
		if(!StringUtils.isEmpty(tf.getAdditionalAmt6()))
		additionalamt=Float.parseFloat(tf.getAdditionalAmt6());
		unitrate=Float.parseFloat(tf.getTyreRate6());
		if(!StringUtils.isEmpty(tf.getVATAmount6()))
		vatamt=Float.parseFloat(tf.getVATAmount6());
		Float amt=unitrate+vatamt+additionalamt;
		String amount=Float.toString(amt);
		tf.setAmount6(amount);
		totalamount=totalamount+amt;
		}
		
		if((!StringUtils.isEmpty(tf.getTyreNo7()))&&(StringUtils.isEmpty(tf.getAmount7())))
		{
		if(!StringUtils.isEmpty(tf.getAdditionalAmt7()))
		additionalamt=Float.parseFloat(tf.getAdditionalAmt7());
		unitrate=Float.parseFloat(tf.getTyreRate7());
		if(!StringUtils.isEmpty(tf.getVATAmount7()))
		vatamt=Float.parseFloat(tf.getVATAmount7());
		Float amt=unitrate+vatamt+additionalamt;
		String amount=Float.toString(amt);
		tf.setAmount7(amount);
		totalamount=totalamount+amt;
		}
		
		
		if((!StringUtils.isEmpty(tf.getTyreNo8()))&&(StringUtils.isEmpty(tf.getAmount8())))
		{
		if(!StringUtils.isEmpty(tf.getAdditionalAmt8()))
		additionalamt=Float.parseFloat(tf.getAdditionalAmt8());
		unitrate=Float.parseFloat(tf.getTyreRate8());
		if(!StringUtils.isEmpty(tf.getVATAmount8()))
		vatamt=Float.parseFloat(tf.getVATAmount8());
		Float amt=unitrate+vatamt+additionalamt;
		String amount=Float.toString(amt);
		tf.setAmount8(amount);
		totalamount=totalamount+amt;
		}
		
		logger.debug("OilGreasePurchaseAction:AmountMethod  --------->");
		return mapping.findForward("eject1");		
	}
	
	
	public ActionForward saveMethod(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {
		logger.debug("OilGreasePurchaseAction:saveMethod  <---------");
		HttpSession session = ((HttpServletRequest) request).getSession();
		int jobid=0;
		int taskid=0;
		try{
			jobid=(Integer)session.getAttribute("jobseq");
			taskid=(Integer)session.getAttribute("taskseqseq");
			insertvalues(jobid,form);
		}
		catch(Exception e)
		{
			logger.debug("error in job"+e);
		}	
		logger.debug("OilGreasePurchaseAction:saveMethod  --------->");
		
		return mapping.findForward("eject1");
	}
	public void insertvalues(int jobid,ActionForm form)
	{
		logger.debug("insertvalues <<<<<<<<<<<<");
		TyrePurchaseForm tf=(TyrePurchaseForm)form;
		String date=tf.getBillDate();
		String billno=tf.getBillNo();
		String delivereddate=tf.getDeliveredDate();
		String cname=tf.getCompanyName();
		String place=tf.getPlace();
		String reqitem=tf.getGoodsType();
		String partno=tf.getPartNo();
		ts.insertSupplier(jobid,date,billno,delivereddate,cname,place,reqitem);
		int tyrebrand,tyresize,tyreply;
		String tyreparts,tyreno;
		int availability,quantity;
		float unitprice;
		float vatpercent=0,vatamount=0,additionalamount=0,amount;
		if(!StringUtils.isEmpty(tf.getTyreNo1()))
		{	
			tyrebrand=Integer.parseInt(tf.getTyreType1());
			tyresize=Integer.parseInt(tf.getTyreSize1());
			tyreply=Integer.parseInt(tf.getTyrePly1());
			tyreparts=tf.getTyreParts1();
			tyreno=tf.getTyreNo1();
			unitprice=Float.parseFloat(tf.getTyreRate1());
				if(!StringUtils.isEmpty(tf.getVATPercent1()));
				vatpercent=Float.parseFloat(tf.getVATPercent1());
				if(!StringUtils.isEmpty(tf.getVATAmount1()))
				vatamount=Float.parseFloat(tf.getVATAmount1());
				if(!StringUtils.isEmpty(tf.getAdditionalAmt1()))
				additionalamount=Float.parseFloat(tf.getAdditionalAmt1());
				amount=Float.parseFloat(tf.getAmount1());
				ts.insertProduct(jobid,tyrebrand,tyresize,tyreply,tyreparts,tyreno,unitprice,vatpercent,vatamount,additionalamount,amount);
				ts.insertcommontrans(tyrebrand,tyresize,tyreply,tyreno);
				
			}
		
		if(!StringUtils.isEmpty(tf.getTyreNo2()))
		{	
			tyrebrand=Integer.parseInt(tf.getTyreType2());
			tyresize=Integer.parseInt(tf.getTyreSize2());
			tyreply=Integer.parseInt(tf.getTyrePly2());
			tyreparts=tf.getTyreParts2();
			tyreno=tf.getTyreNo2();
			unitprice=Float.parseFloat(tf.getTyreRate2());
				if(!StringUtils.isEmpty(tf.getVATPercent2()));
				vatpercent=Float.parseFloat(tf.getVATPercent2());
				if(!StringUtils.isEmpty(tf.getVATAmount2()))
				vatamount=Float.parseFloat(tf.getVATAmount2());
				if(!StringUtils.isEmpty(tf.getAdditionalAmt2()))
				additionalamount=Float.parseFloat(tf.getAdditionalAmt2());
				amount=Float.parseFloat(tf.getAmount2());
				ts.insertProduct(jobid,tyrebrand,tyresize,tyreply,tyreparts,tyreno,unitprice,vatpercent,vatamount,additionalamount,amount);
				ts.insertcommontrans(tyrebrand,tyresize,tyreply,tyreno);			
			}
		
		if(!StringUtils.isEmpty(tf.getTyreNo3()))
		{	
			tyrebrand=Integer.parseInt(tf.getTyreType3());
			tyresize=Integer.parseInt(tf.getTyreSize3());
			tyreply=Integer.parseInt(tf.getTyrePly3());
			tyreparts=tf.getTyreParts3();
			tyreno=tf.getTyreNo3();
			unitprice=Float.parseFloat(tf.getTyreRate3());
				if(!StringUtils.isEmpty(tf.getVATPercent3()));
				vatpercent=Float.parseFloat(tf.getVATPercent3());
				if(!StringUtils.isEmpty(tf.getVATAmount3()))
				vatamount=Float.parseFloat(tf.getVATAmount3());
				if(!StringUtils.isEmpty(tf.getAdditionalAmt3()))
				additionalamount=Float.parseFloat(tf.getAdditionalAmt3());
				amount=Float.parseFloat(tf.getAmount3());
				ts.insertProduct(jobid,tyrebrand,tyresize,tyreply,tyreparts,tyreno,unitprice,vatpercent,vatamount,additionalamount,amount);
				ts.insertcommontrans(tyrebrand,tyresize,tyreply,tyreno);			
			}
		
		if(!StringUtils.isEmpty(tf.getTyreNo4()))
		{	
			tyrebrand=Integer.parseInt(tf.getTyreType4());
			tyresize=Integer.parseInt(tf.getTyreSize4());
			tyreply=Integer.parseInt(tf.getTyrePly4());
			tyreparts=tf.getTyreParts4();
			tyreno=tf.getTyreNo4();
			unitprice=Float.parseFloat(tf.getTyreRate4());
				if(!StringUtils.isEmpty(tf.getVATPercent4()));
				vatpercent=Float.parseFloat(tf.getVATPercent4());
				if(!StringUtils.isEmpty(tf.getVATAmount4()))
				vatamount=Float.parseFloat(tf.getVATAmount4());
				if(!StringUtils.isEmpty(tf.getAdditionalAmt4()))
				additionalamount=Float.parseFloat(tf.getAdditionalAmt4());
				amount=Float.parseFloat(tf.getAmount4());
				ts.insertProduct(jobid,tyrebrand,tyresize,tyreply,tyreparts,tyreno,unitprice,vatpercent,vatamount,additionalamount,amount);
				ts.insertcommontrans(tyrebrand,tyresize,tyreply,tyreno);			
			}
		
		if(!StringUtils.isEmpty(tf.getTyreNo5()))
		{	
			tyrebrand=Integer.parseInt(tf.getTyreType5());
			tyresize=Integer.parseInt(tf.getTyreSize5());
			tyreply=Integer.parseInt(tf.getTyrePly5());
			tyreparts=tf.getTyreParts5();
			tyreno=tf.getTyreNo5();
			unitprice=Float.parseFloat(tf.getTyreRate5());
				if(!StringUtils.isEmpty(tf.getVATPercent5()));
				vatpercent=Float.parseFloat(tf.getVATPercent5());
				if(!StringUtils.isEmpty(tf.getVATAmount5()))
				vatamount=Float.parseFloat(tf.getVATAmount5());
				if(!StringUtils.isEmpty(tf.getAdditionalAmt5()))
				additionalamount=Float.parseFloat(tf.getAdditionalAmt5());
				amount=Float.parseFloat(tf.getAmount5());
				ts.insertProduct(jobid,tyrebrand,tyresize,tyreply,tyreparts,tyreno,unitprice,vatpercent,vatamount,additionalamount,amount);
				ts.insertcommontrans(tyrebrand,tyresize,tyreply,tyreno);			
			}
		
		
		if(!StringUtils.isEmpty(tf.getTyreNo6()))
		{	
			tyrebrand=Integer.parseInt(tf.getTyreType6());
			tyresize=Integer.parseInt(tf.getTyreSize6());
			tyreply=Integer.parseInt(tf.getTyrePly6());
			tyreparts=tf.getTyreParts6();
			tyreno=tf.getTyreNo6();
			unitprice=Float.parseFloat(tf.getTyreRate6());
				if(!StringUtils.isEmpty(tf.getVATPercent6()));
				vatpercent=Float.parseFloat(tf.getVATPercent6());
				if(!StringUtils.isEmpty(tf.getVATAmount6()))
				vatamount=Float.parseFloat(tf.getVATAmount6());
				if(!StringUtils.isEmpty(tf.getAdditionalAmt6()))
				additionalamount=Float.parseFloat(tf.getAdditionalAmt6());
				amount=Float.parseFloat(tf.getAmount6());
				ts.insertProduct(jobid,tyrebrand,tyresize,tyreply,tyreparts,tyreno,unitprice,vatpercent,vatamount,additionalamount,amount);
				ts.insertcommontrans(tyrebrand,tyresize,tyreply,tyreno);			
			}
		
		if(!StringUtils.isEmpty(tf.getTyreNo7()))
		{	
			tyrebrand=Integer.parseInt(tf.getTyreType7());
			tyresize=Integer.parseInt(tf.getTyreSize7());
			tyreply=Integer.parseInt(tf.getTyrePly7());
			tyreparts=tf.getTyreParts7();
			tyreno=tf.getTyreNo7();
			unitprice=Float.parseFloat(tf.getTyreRate7());
				if(!StringUtils.isEmpty(tf.getVATPercent7()));
				vatpercent=Float.parseFloat(tf.getVATPercent7());
				if(!StringUtils.isEmpty(tf.getVATAmount7()))
				vatamount=Float.parseFloat(tf.getVATAmount7());
				if(!StringUtils.isEmpty(tf.getAdditionalAmt7()))
				additionalamount=Float.parseFloat(tf.getAdditionalAmt7());
				amount=Float.parseFloat(tf.getAmount7());
				ts.insertProduct(jobid,tyrebrand,tyresize,tyreply,tyreparts,tyreno,unitprice,vatpercent,vatamount,additionalamount,amount);
				ts.insertcommontrans(tyrebrand,tyresize,tyreply,tyreno);			
			}
		
		if(!StringUtils.isEmpty(tf.getTyreNo8()))
		{	
			tyrebrand=Integer.parseInt(tf.getTyreType8());
			tyresize=Integer.parseInt(tf.getTyreSize8());
			tyreply=Integer.parseInt(tf.getTyrePly8());
			tyreparts=tf.getTyreParts8();
			tyreno=tf.getTyreNo8();
			unitprice=Float.parseFloat(tf.getTyreRate8());
				if(!StringUtils.isEmpty(tf.getVATPercent8()));
				vatpercent=Float.parseFloat(tf.getVATPercent8());
				if(!StringUtils.isEmpty(tf.getVATAmount8()))
				vatamount=Float.parseFloat(tf.getVATAmount8());
				if(!StringUtils.isEmpty(tf.getAdditionalAmt8()))
				additionalamount=Float.parseFloat(tf.getAdditionalAmt8());
				amount=Float.parseFloat(tf.getAmount8());
				ts.insertProduct(jobid,tyrebrand,tyresize,tyreply,tyreparts,tyreno,unitprice,vatpercent,vatamount,additionalamount,amount);
				ts.insertcommontrans(tyrebrand,tyresize,tyreply,tyreno);			
			}
		logger.debug("insertvalues >>>>>>>>>>>>>>>>");
	  		
	}
	
	
	
	//to chage the status to 1 after the approval of E.O 
	
	public ActionForward acquiredMethod(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {
		
		//have to pass the jobid,taskid to change the status to 1 for the approve task
		//called form the inbox
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			logger.debug("inside job method");
			Connection con=DriverManager.getConnection("jdbc:odbc:gomi","system","gomsmca");
			logger.debug("inside acquired method");
			int job=Integer.parseInt(request.getParameter("jobid"));
			logger.debug("job in acquire"+job);
			int task=Integer.parseInt(request.getParameter("taskid"));
			logger.debug("task in acquire"+task);
			//jb.acquiredStatus(job,task,con);
			return mapping.findForward("eject1");
	}
	
	public ActionForward approveMethod(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {
		
		// have to pass the jobid,taskid to change the status to 2 for the approve task
		//and 0 for issue task
		// called from the corresponding form
		
		
		 HttpSession session = ((HttpServletRequest) request).getSession();
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			logger.debug("inside approve method");
			Connection con=DriverManager.getConnection("jdbc:odbc:gomi","system","gomsmca");
			logger.debug("inside approve method");
			int job=(Integer)session.getAttribute("jobseq");
			
			logger.debug("job in acquire"+job);
			int task=(Integer)session.getAttribute("taskseqseq");
			logger.debug("task in acquire"+task);
			//jb.approveStatus(job,task,con);
			return mapping.findForward("inb");
	}
	
	public ActionForward okMethod(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {
		
		// have to pass the jobid,taskid to change the status to 2 for the issue task
		
		 HttpSession session = ((HttpServletRequest) request).getSession();
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			logger.debug("inside approve method");
			Connection con=DriverManager.getConnection("jdbc:odbc:gomi","system","gomsmca");
			logger.debug("inside approve method");
			int job=(Integer)session.getAttribute("jobseq");
			logger.debug("job in acquire"+job);
			int task=(Integer)session.getAttribute("taskseqseq");
			logger.debug("task in acquire"+task);
			//jb.okStatus(job,task,con);
			return mapping.findForward("eject1");
	}

}
