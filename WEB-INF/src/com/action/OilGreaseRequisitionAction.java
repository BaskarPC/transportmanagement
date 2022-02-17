package com.action;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import javax.servlet.http.HttpServletResponse;

import com.action.BaseDispatchAction;
import com.dbcom.dbcom;
import com.formbean.DieselRequisitionForm;
import com.formbean.OilGreaseRequisitionForm;
import com.service.DieselRequisitionService;
import com.service.OilGreaseRequisitionService;
import com.vo.DieselRequisitionVO;
import com.vo.OilGreaseRequisitionVO;
import com.wf.job;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import sun.util.calendar.CalendarDate;
public class OilGreaseRequisitionAction extends BaseDispatchAction{
private static final Logger logger=(Logger)Logger.getLogger(OilGreaseRequisitionAction.class);
ArrayList brandnamelist=null;
ArrayList brandCategorylist=null;
OilGreaseRequisitionService os=new OilGreaseRequisitionService();
OilGreaseRequisitionVO vo=new OilGreaseRequisitionVO();
job jb=new job();
dbcom db=new dbcom();
int jobid;
	public ActionForward defaultMethod(ActionMapping aMapping,
	        ActionForm aForm, HttpServletRequest aRequest,
	        HttpServletResponse aResponse)throws Exception{
		logger.debug("OilGreaseRequisitionAction: defaultMethod<<<<<<<<<<<<");
		OilGreaseRequisitionForm of=(OilGreaseRequisitionForm)aForm;	
		OilGreaseRequisitionService os=new OilGreaseRequisitionService();
		ArrayList list=new ArrayList();
		list=os.fetchRequiredItem();
		of.setItemDesList(list);
		logger.debug("OilGreaseRequisitionAction: defaultMethod>>>>>>>>>>>>");

		return aMapping.findForward("oilreq");
	}
	
	public ActionForward itemReqMethod(ActionMapping aMapping,
	        ActionForm aForm, HttpServletRequest aRequest,
	        HttpServletResponse aResponse)throws Exception{
		logger.debug("OilGreaseRequisitionAction: itemReqMethod<<<<<<<<<<<<");	
		OilGreaseRequisitionForm of=(OilGreaseRequisitionForm)aForm;
		OilGreaseRequisitionService os=new OilGreaseRequisitionService();
	    String item=of.getItemDes();
	    ArrayList list=new ArrayList();
		brandnamelist=os.fetchBrandName(item);
		brandCategorylist=os.fetchBrandType(item);
		of.setBrandNameList(brandnamelist);
		of.setBrandCategoryList(brandCategorylist);
		logger.debug("OilGreaseRequisitionAction: itemReqMethod>>>>>>>>>>>>>");	
		return aMapping.findForward("oilreq");
	}
	
	/**
	 * passes the jobid,taskid to change the status to 2 for the approve task of that form 
	 * and 0 for issue task  for the corresponding form
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	
	
	public ActionForward approveMethod(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {
			logger.debug("OilGreaseRequisitionAction: approveMethod<<<<<<<<<<<<");	
			OilGreaseRequisitionForm of=(OilGreaseRequisitionForm)form;
			 HttpSession session = ((HttpServletRequest) request).getSession();
			int job=(Integer)session.getAttribute("jobseq");
			int task=(Integer)session.getAttribute("taskseqseq");
			if(!StringUtils.isEmpty(of.getQtyNeeded1())) 	
				os.status(job,of.getBrandName1(),of.getBrandType1(),of.getApproveStatus1());
			if(!StringUtils.isEmpty(of.getQtyNeeded2())) 
				os.status(job,of.getBrandName2(),of.getBrandType2(),of.getApproveStatus2());
			if(!StringUtils.isEmpty(of.getQtyNeeded3())) 
				os.status(job,of.getBrandName3(),of.getBrandType3(),of.getApproveStatus3());
			if(!StringUtils.isEmpty(of.getQtyNeeded4())) 
				os.status(job,of.getBrandName4(),of.getBrandType4(),of.getApproveStatus4());
			if(!StringUtils.isEmpty(of.getQtyNeeded5())) 
				os.status(job,of.getBrandName5(),of.getBrandType5(),of.getApproveStatus5());
			if(!StringUtils.isEmpty(of.getNewQtyNeeded1())) 
				os.status(job,of.getNewBrandName1(),of.getNewBrandType1(),of.getApproveStatus6());
			if(!StringUtils.isEmpty(of.getNewQtyNeeded2())) 
				os.status(job,of.getNewBrandName2(),of.getNewBrandType2(),of.getApproveStatus7());
			if(!StringUtils.isEmpty(of.getNewQtyNeeded3())) 
				os.status(job,of.getNewBrandName3(),of.getNewBrandType3(),of.getApproveStatus8());
			jb.approveStatus(job,task);
			logger.debug("OilGreaseRequisitionAction: approveMethod>>>>>>>>>>>>>");	
			return mapping.findForward("fwdtoincharge");
			
			
	}
	
	
	/**
	 * passes the jobid,taskid to change the status to 2 for the issue task of that form
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward okMethod(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {
			logger.debug("OilGreaseRequisitionAction: okMethod<<<<<<<<<<<<");	
			 HttpSession session = ((HttpServletRequest) request).getSession();
			int job=(Integer)session.getAttribute("jobseq");
			int task=(Integer)session.getAttribute("taskseqseq");                 
			jb.approveStatus(job,task);
			logger.debug("OilGreaseRequisitionAction: okMethod >>>>>>>>>>>");	
			return mapping.findForward("oilreq");
	}
	public ActionForward availableQtyMethod(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {
		    OilGreaseRequisitionForm of=(OilGreaseRequisitionForm)form;
		    logger.debug("availableQty Mtd <<<<<<<<<<<<<<<<");
			if(StringUtils.isEmpty(of.getAvailableQty1()))
			{ 	
				of.setAvailableQty1("Nill");
				OilGreaseRequisitionService os=new OilGreaseRequisitionService();
				ArrayList list=os.fetchAvailableQty(of.getItemDes(),of.getBrandType1());
				vo=(OilGreaseRequisitionVO)list.get(0);
				String s=vo.getAvailableQty1();
				of.setAvailableQty1(s);
			
			}
			else if(StringUtils.isEmpty(of.getAvailableQty2()))
			{	of.setAvailableQty2("0");
				OilGreaseRequisitionService os=new OilGreaseRequisitionService();
				ArrayList list=os.fetchAvailableQty(of.getItemDes(),of.getBrandType2());
				vo=(OilGreaseRequisitionVO)list.get(0);
				of.setAvailableQty2(vo.getAvailableQty1());
			}
			else if(StringUtils.isEmpty(of.getAvailableQty3()))
			{
				of.setAvailableQty3("0");
				OilGreaseRequisitionService os=new OilGreaseRequisitionService();
				ArrayList list=os.fetchAvailableQty(of.getItemDes(),of.getBrandType3());
				vo=(OilGreaseRequisitionVO)list.get(0);
				of.setAvailableQty3(vo.getAvailableQty1());
			}
			else if(StringUtils.isEmpty(of.getAvailableQty4()) )
			{
				of.setAvailableQty4("0");
				OilGreaseRequisitionService os=new OilGreaseRequisitionService();
				ArrayList list=os.fetchAvailableQty(of.getItemDes(),of.getBrandType4());
				vo=(OilGreaseRequisitionVO)list.get(0);
				of.setAvailableQty4(vo.getAvailableQty1());
			}
			else if(StringUtils.isEmpty(of.getAvailableQty5()))
			{
				of.setAvailableQty5("0");
				OilGreaseRequisitionService os=new OilGreaseRequisitionService();
				ArrayList list=os.fetchAvailableQty(of.getItemDes(),of.getBrandType5());
				vo=(OilGreaseRequisitionVO)list.get(0);
				of.setAvailableQty5(vo.getAvailableQty1());
			}
			logger.debug("availableQty Mtd >>>>>>>>>>>>>");
			return mapping.findForward("oilreq");
	}
/**
 * to display the values in form 
 * @param mapping
 * @param form
 * @param request
 * @param response
 * @return
 * @throws Exception
 */
public ActionForward inboxMethod(ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {
	logger.debug("inboxMethod Mtd <<<<<<<<<<<<<<");
	OilGreaseRequisitionForm of=(OilGreaseRequisitionForm)form;
	ArrayList list=new ArrayList();
	ArrayList list1=new ArrayList();
	ArrayList combolist1=new ArrayList();
	ArrayList combolist2=new ArrayList();
	ArrayList combolist3=new ArrayList();
	HttpSession session = ((HttpServletRequest) request).getSession();
	int jobid=(Integer)session.getAttribute("jobseq");
	list=os.retrieve(jobid);
	list1=os.fetchApproveStatusList();
	of.setApproveStatusList(list1);
	for(int i=0;i<list.size();i++)
	{
		vo=(OilGreaseRequisitionVO)list.get(i);
		logger.debug("record :"+i+""+vo.getDate()+vo.getFrom()+vo.getItemDes()+vo.getBrandName1()+vo.getBrandType1());
		of.setDate(vo.getDate());
		of.setFrom(vo.getFrom());
		OilGreaseRequisitionService os=new OilGreaseRequisitionService();
		combolist1=os.fetchRequiredItem();
		combolist2=os.fetchBrandName(vo.getItemDes());
		combolist3=os.fetchBrandType(vo.getItemDes());
		of.setItemDesList(combolist1);
		of.setBrandNameList(combolist2);
		of.setBrandCategoryList(combolist3);
		of.setItemDes(vo.getItemDes());
		// assign database value
		
		switch(i)
		{
		case 0:
			of.setBrandName1(vo.getBrandName1());
			of.setBrandType1(vo.getBrandType1());
			of.setAvailableQty1(vo.getAvailableQty1());
			of.setQtyNeeded1(vo.getQtyNeeded1());
			of.setApproveStatus1(vo.getApproveStatus());
			break;
		case 1:
			of.setBrandName2(vo.getBrandName1());
			of.setBrandType2(vo.getBrandType1());
			of.setAvailableQty2(vo.getAvailableQty1());
			of.setQtyNeeded2(vo.getQtyNeeded1());
			of.setApproveStatus2(vo.getApproveStatus());
			break;
		case 2:
			of.setBrandName3(vo.getBrandName1());
			of.setBrandType3(vo.getBrandType1());
			of.setAvailableQty3(vo.getAvailableQty1());
			of.setQtyNeeded3(vo.getQtyNeeded1());
			of.setApproveStatus3(vo.getApproveStatus());
			break;
		case 3:
			of.setBrandName4(vo.getBrandName1());
			of.setBrandType4(vo.getBrandType1());
			of.setAvailableQty4(vo.getAvailableQty1());
			of.setQtyNeeded4(vo.getQtyNeeded1());
			of.setApproveStatus4(vo.getApproveStatus());
			break;
		case 4:
			of.setBrandName5(vo.getBrandName1());
			of.setBrandType5(vo.getBrandType1());
			of.setAvailableQty5(vo.getAvailableQty1());
			of.setQtyNeeded5(vo.getQtyNeeded1());
			of.setApproveStatus5(vo.getApproveStatus());
			break; 
		case 5:
			of.setNewBrandName1(vo.getBrandName1());
			of.setNewBrandType1(vo.getBrandType1());
			of.setNewQtyNeeded1(vo.getQtyNeeded1());
			of.setApproveStatus6(vo.getApproveStatus());
			break; 
		case 6:
			of.setNewBrandName1(vo.getBrandName2());
			of.setNewBrandType1(vo.getBrandType2());
			of.setNewQtyNeeded1(vo.getQtyNeeded2());
			of.setApproveStatus7(vo.getApproveStatus());
			break;
		case 7:
			of.setNewBrandName1(vo.getBrandName3());
			of.setNewBrandType1(vo.getBrandType3());
			of.setNewQtyNeeded1(vo.getQtyNeeded3());
			of.setApproveStatus8(vo.getApproveStatus());
			break;
			
		}
		
	}
	logger.debug("inboxMethod >>>>>>>>>>>>>>>");
	return mapping.findForward("oilreq");
}

public void insertvalues(int jobid,ActionForm form)
{
	logger.debug("insertvalues <<<<<<<<<<<<");
	OilGreaseRequisitionForm of=(OilGreaseRequisitionForm)form;
	OilGreaseRequisitionService os=new OilGreaseRequisitionService();
	String date=of.getDate();
	String name=of.getFrom();
	int reqitem=Integer.parseInt(of.getItemDes());
	int brandname,brandcategory;
	String brandname1,brandcategory1;
	int bid,bcid;
	int availability,neededqty,approvestatus;
	
	if(!StringUtils.isEmpty(of.getQtyNeeded1()))
	{
		brandname=Integer.parseInt(of.getBrandName1());
		brandcategory=Integer.parseInt(of.getBrandType1());
		availability=Integer.parseInt(of.getAvailableQty1());
		neededqty=Integer.parseInt(of.getQtyNeeded1());
		
		os.insert(jobid,date,name,reqitem,brandname,brandcategory,availability,neededqty);
		logger.debug("OilGreaseRequisitionAction: insertvalues->record1 passed to service"); 
	}
	
	if(!StringUtils.isEmpty(of.getQtyNeeded2()))
	{
		brandname=Integer.parseInt(of.getBrandName2());
		brandcategory=Integer.parseInt(of.getBrandType2());
		availability=Integer.parseInt(of.getAvailableQty2());
		neededqty=Integer.parseInt(of.getQtyNeeded2());
		//approvestatus=Integer.parseInt(of.getApproveStatus2());
		os.insert(jobid,date,name,reqitem,brandname,brandcategory,availability,neededqty);
		logger.debug("OilGreaseRequisitionAction: insertvalues ->record2 passed to service"); 
	}
	
	if(!StringUtils.isEmpty(of.getQtyNeeded3()))
	{
		brandname=Integer.parseInt(of.getBrandName3());
		brandcategory=Integer.parseInt(of.getBrandType3());
		availability=Integer.parseInt(of.getAvailableQty3());
		neededqty=Integer.parseInt(of.getQtyNeeded3());
		//approvestatus=Integer.parseInt(of.getApproveStatus3());
		os.insert(jobid,date,name,reqitem,brandname,brandcategory,availability,neededqty);
		logger.debug("OilGreaseRequisitionAction: insertvalues ->record3 passed to service"); 
	}
	
	if(!StringUtils.isEmpty(of.getQtyNeeded4()))
	{
		brandname=Integer.parseInt(of.getBrandName4());
		brandcategory=Integer.parseInt(of.getBrandType4());
		availability=Integer.parseInt(of.getAvailableQty4());
		neededqty=Integer.parseInt(of.getQtyNeeded4());
		//approvestatus=Integer.parseInt(of.getApproveStatus4());
		os.insert(jobid,date,name,reqitem,brandname,brandcategory,availability,neededqty);
		logger.debug("OilGreaseRequisitionAction: saveMethod ->record4 passed to service"); 
	}
	
	if(!StringUtils.isEmpty(of.getQtyNeeded5()))
	{
		brandname=Integer.parseInt(of.getBrandName5());
		brandcategory=Integer.parseInt(of.getBrandType5());
		availability=Integer.parseInt(of.getAvailableQty5());
		neededqty=Integer.parseInt(of.getQtyNeeded5());
		//approvestatus=Integer.parseInt(of.getApproveStatus5());
		os.insert(jobid,date,name,reqitem,brandname,brandcategory,availability,neededqty);
		logger.debug("OilGreaseRequisitionAction: saveMethod ->record5 passed to service"); 
	}
	
	if(!StringUtils.isEmpty(of.getNewQtyNeeded1()))
	{
		brandname1=of.getNewBrandName1();
		brandcategory1=of.getNewBrandType1();
		availability=0;
		neededqty=Integer.parseInt(of.getNewQtyNeeded1());
		int id=os.insertlookup(reqitem,brandname1,brandcategory1);
		//approvestatus=Integer.parseInt(of.getApproveStatus6());
		os.insert(jobid,date,name,reqitem,id,id+1,availability,neededqty);
		os.insertcommontrans(of.getItemDes(),brandcategory1);
	}
	
	if(!StringUtils.isEmpty(of.getNewQtyNeeded2()))
	{
		brandname1=of.getNewBrandName2();
		brandcategory1=of.getNewBrandType2();
		availability=0;
		neededqty=Integer.parseInt(of.getNewQtyNeeded2());
		int id=os.insertlookup(reqitem,brandname1,brandcategory1);
		//approvestatus=Integer.parseInt(of.getApproveStatus7());
		os.insert(jobid,date,name,reqitem,id,id+1,availability,neededqty);
		os.insertcommontrans(of.getItemDes(),brandcategory1);
		
	}
	
	if(!StringUtils.isEmpty(of.getNewQtyNeeded3()))
	{
		brandname1=of.getNewBrandName3();
		brandcategory1=of.getNewBrandType3();
		availability=0;
		neededqty=Integer.parseInt(of.getNewQtyNeeded3());
		int id=os.insertlookup(reqitem,brandname1,brandcategory1);
		//approvestatus=Integer.parseInt(of.getApproveStatus8());
		os.insert(jobid,date,name,reqitem,id,id+1,availability,neededqty);
		os.insertcommontrans(of.getItemDes(),brandcategory1);
	}

	logger.debug("insertvalues >>>>>>>>>>>>>>>>");
  		
}
public ActionForward jobMethod(ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {
	OilGreaseRequisitionForm of=(OilGreaseRequisitionForm)form;
	String name=of.getItemDes();
	ArrayList list=os.getitem(name);
	OilGreaseRequisitionVO vo=(OilGreaseRequisitionVO)list.get(0);
	String reqName=vo.getDes()+"Requisition";
	
	HttpSession session = ((HttpServletRequest) request).getSession();
	String userName=(String) session.getAttribute("username");
	String ss1=mapping.getName();
	try{
	jobid=jb.creatJob(ss1,userName,reqName);
	}
	catch(Exception e)
	{
		logger.debug("error in job"+e);
	}
	
	insertvalues(jobid,form);
	return mapping.findForward("success");

}
/**
 * 
 * @param form
 */
public void clear(ActionForm form)
{
	DieselRequisitionForm df=(DieselRequisitionForm)form;
	df.setDate(null);
	df.setFrom(null);
	df.setCurrentCapacity(null);
	df.setTankCapacity(null);
	df.setQtyNeeded(null);
			
}


	
}
