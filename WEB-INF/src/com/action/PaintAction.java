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

import com.formbean.PaintForm;
import com.formbean.SparePartsForm;
//import com.wf.*;
import com.service.PaintIssueService;
import com.service.SparepartsService;
import com.vo.PaintIssueVO;
import com.vo.SparePartsFormVO;
import com.wf.arrayList;
import com.wf.job;




public class PaintAction extends BaseDispatchAction{
	private static final Logger logger=(Logger)Logger.getLogger(PaintAction.class);
	job jb=new job();
	SparepartsService ss=new SparepartsService();
	PaintIssueService paintserv=new PaintIssueService();
	ArrayList res_list=new ArrayList();
	ArrayList res_list1=new ArrayList();
	ArrayList res_list2=new ArrayList();
	ArrayList res_list3=new ArrayList();
	int jobid;
	int temp;
	int newAvailable;
	int oldAvailable;
	int oldtemp;
	int newtemp;
	float oldRate;
	float newRate;
	float totaloldRate;
	float totalnewRate;
	float totalRate;
	
	int spareid;
	int total=0;
	int oldavail;
	int newavail;
	float oldrate;
	float newrate;
	
	public ActionForward defaultMethod(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {
		
			PaintForm sf=(PaintForm)form;
			arrayList list=new arrayList();
			list.dropdownList(form);
			res_list=paintserv.fetchTypeValues();
			sf.setCompList(res_list);
			logger.debug("spare1Action:defaultMethod---------->");
			return mapping.findForward("load");
		
	}
	
	// to create the job and task
	
	public ActionForward jobMethod(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {
		
		// gets the form name and passes it to create job and tasks
		String reqName="PaintIssue";
		HttpSession session = ((HttpServletRequest) request).getSession();
		String userName=(String) session.getAttribute("username");
		logger.debug("inside job method");
		String ss1=mapping.getName();
		try{
		jobid=jb.creatJob(ss1,userName,reqName);
		}
		catch(Exception e)
		{
			logger.debug("error in job"+e);
		}
		logger.debug("job executed");
		insertvalues(jobid,form);
		
		logger.debug("insert executed");
		return mapping.findForward("load");
	
	
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
			
			 HttpSession session = ((HttpServletRequest) request).getSession();
			logger.debug("inside approve method");
			int job=(Integer)session.getAttribute("jobseq");
			logger.debug("job in acquire"+job);
			int task=(Integer)session.getAttribute("taskseqseq");
			logger.debug("task in acquire"+task);
			jb.approveStatus(job,task);
			return mapping.findForward("load");
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
			 HttpSession session = ((HttpServletRequest) request).getSession();
			logger.debug("inside approve method");
			int job=(Integer)session.getAttribute("jobseq");
			logger.debug("job in acquire"+job);
			int task=(Integer)session.getAttribute("taskseqseq");
			logger.debug("task in acquire"+task);
			jb.okStatus(job,task);
			updateValues(job,form);
			return mapping.findForward("load");
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
		PaintForm sf=(PaintForm)form;
		clear(form);
		arrayList list=new arrayList();
		list.dropdownList(form);
		
		int instname;	
		int type;
		HttpSession session = ((HttpServletRequest) request).getSession();
		int job=(Integer)session.getAttribute("jobseq");
		
	    res_list=paintserv.fetchCommonValues(job);
	    logger.debug("select command executed"+res_list.size());
	    
	    
	    PaintIssueVO vo=new PaintIssueVO();	
	   for(int i=0;i<res_list.size();i++)
	    {
	    	vo=(PaintIssueVO)res_list.get(i);
	    	logger.debug(vo.getBillNumber());
	    	sf.setBillNumber(vo.getBillNumber());
	    	logger.debug(vo.getDriverName());
	    	sf.setDriverName(vo.getDriverName());
	    	sf.setInstitutionName(vo.getInstitutionName());
	    	instname=Integer.parseInt(vo.getInstitutionName());
	    	res_list3=ss.fetchVehicleType(instname);
	    	sf.setVehicleTypeList(res_list3);
	    	sf.setVehicleType(vo.getVehicleType());
	    	type=Integer.parseInt(vo.getVehicleType());
	    	res_list2=ss.fetchVehicleNumber(type,instname);
	    	sf.setVehicleNumberList(res_list2);
	    	logger.debug("in spare action "+vo.getVehicleNumber()+""+vo.getOtherPurpose());
	    	sf.setVehicleNumber(vo.getVehicleNumber());
	    	sf.setOtherPurpose(vo.getOtherPurpose());
	    	sf.setRequestedDriverName(vo.getRequestedDriverName());
	       }
	   res_list2=paintserv.fetchTypeValues();
		sf.setCompList(res_list2);
	   res_list=paintserv.fetchValues(job);
	   logger.debug("select command executed"+res_list.size());
	   PaintIssueVO vo1=new PaintIssueVO();	
	  for(int i=0;i<res_list.size();i++)
	  {
		  vo1=(PaintIssueVO)res_list.get(i);
		  switch(i)
		  {
		  case 0:
			  sf.setPaintType1(vo1.getPaintType1());
			  logger.debug("paint type"+vo1.getPaintType1());
			  res_list1=paintserv.fetchColorValues(Integer.parseInt(vo1.getPaintType1()));
			  sf.setColorList1(res_list1);
			  sf.setPaintColor1(vo1.getPaintColor1());
			  sf.setWantedQuantity1(vo1.getWantedQuantity1());
			  sf.setTotalAvailableQuantity1(vo1.getTotalAvailableQuantity1());
			  sf.setOldAvailable1(vo1.getOldAvailable1());
			  sf.setNewAvailable1(vo1.getNewAvailable1());
			  logger.debug("paint type"+vo1.getOldRate1());
			  sf.setOldRate1(vo1.getOldRate1().toString());
			  logger.debug("paint type"+vo1.getNewRate1());
			  sf.setNewRate1(vo1.getNewRate1());
			  sf.setTotalAmount1(vo1.getTotalAmount1());
			  break;
		  case 1:
			  sf.setPaintType2(vo1.getPaintType1());
			  res_list1=paintserv.fetchColorValues(Integer.parseInt(vo1.getPaintType1()));
			  sf.setColorList2(res_list1);
			  sf.setPaintColor2(vo1.getPaintColor1());
			  sf.setWantedQuantity2(vo1.getWantedQuantity1());
			  sf.setTotalAvailableQuantity2(vo1.getTotalAvailableQuantity1());
			  sf.setOldAvailable2(vo1.getOldAvailable1());
			  sf.setNewAvailable2(vo1.getNewAvailable1());
			  sf.setOldRate2(vo1.getOldRate1().toString());
			  sf.setNewRate2(vo1.getNewRate1().toString());
			  sf.setTotalAmount2(vo1.getTotalAmount1());
			  break;
		  case 2:
			  sf.setPaintType3(vo1.getPaintType1());
			  res_list1=paintserv.fetchColorValues(Integer.parseInt(vo1.getPaintType1()));
			  sf.setColorList3(res_list1);
			  sf.setPaintColor3(vo1.getPaintColor1());
			  sf.setWantedQuantity3(vo1.getWantedQuantity1());
			  sf.setTotalAvailableQuantity3(vo1.getTotalAvailableQuantity1());
			  sf.setOldAvailable3(vo1.getOldAvailable1());
			  sf.setNewAvailable3(vo1.getNewAvailable1());
			  sf.setOldRate3(vo1.getOldRate1().toString());
			  sf.setNewRate3(vo1.getNewRate1().toString());
			  sf.setTotalAmount3(vo1.getTotalAmount1());
			  break;
		  case 3:
			  sf.setPaintType4(vo1.getPaintType1());
			  res_list1=paintserv.fetchColorValues(Integer.parseInt(vo1.getPaintType1()));
			  sf.setColorList4(res_list1);
			  sf.setPaintColor4(vo1.getPaintColor1());
			  sf.setWantedQuantity4(vo1.getWantedQuantity1());
			  sf.setTotalAvailableQuantity4(vo1.getTotalAvailableQuantity1());
			  sf.setOldAvailable4(vo1.getOldAvailable1());
			  sf.setNewAvailable4(vo1.getNewAvailable1());
			  sf.setOldRate4(vo1.getOldRate1().toString());
			  sf.setNewRate4(vo1.getNewRate1().toString());
			  sf.setTotalAmount4(vo1.getTotalAmount1());
			  break;
		  case 4:
			  sf.setPaintType5(vo1.getPaintType1());
			  res_list1=paintserv.fetchColorValues(Integer.parseInt(vo1.getPaintType1()));
			  sf.setColorList5(res_list1);
			  sf.setPaintColor5(vo1.getPaintColor1());
			  sf.setWantedQuantity5(vo1.getWantedQuantity1());
			  sf.setTotalAvailableQuantity5(vo1.getTotalAvailableQuantity1());
			  sf.setOldAvailable5(vo1.getOldAvailable1());
			  sf.setNewAvailable5(vo1.getNewAvailable1());
			  sf.setOldRate5(vo1.getOldRate1().toString());
			  sf.setNewRate5(vo1.getNewRate1().toString());
			  sf.setTotalAmount5(vo1.getTotalAmount1());
			  break;
		  case 5:
			  sf.setPaintType6(vo1.getPaintType1());
			  res_list1=paintserv.fetchColorValues(Integer.parseInt(vo1.getPaintType1()));
			  sf.setColorList6(res_list1);
			  sf.setPaintColor6(vo1.getPaintColor1());
			  sf.setWantedQuantity6(vo1.getWantedQuantity1());
			  sf.setTotalAvailableQuantity6(vo1.getTotalAvailableQuantity1());
			  sf.setOldAvailable6(vo1.getOldAvailable1());
			  sf.setNewAvailable6(vo1.getNewAvailable1());
			  sf.setOldRate6(vo1.getOldRate1().toString());
			  sf.setNewRate6(vo1.getNewRate1().toString());
			  sf.setTotalAmount6(vo1.getTotalAmount1());
			  break;
		  case 6:
			  sf.setPaintType7(vo1.getPaintType1());
			  res_list1=paintserv.fetchColorValues(Integer.parseInt(vo1.getPaintType1()));
			  sf.setColorList7(res_list1);
			  sf.setPaintColor7(vo1.getPaintColor1());
			  sf.setWantedQuantity7(vo1.getWantedQuantity1());
			  sf.setTotalAvailableQuantity7(vo1.getTotalAvailableQuantity1());
			  sf.setOldAvailable7(vo1.getOldAvailable1());
			  sf.setNewAvailable7(vo1.getNewAvailable1());
			  sf.setOldRate7(vo1.getOldRate1().toString());
			  sf.setNewRate7(vo1.getNewRate1().toString());
			  sf.setTotalAmount7(vo1.getTotalAmount1());
			  break;
		  case 7:
			  sf.setPaintType8(vo1.getPaintType1());
			  res_list1=paintserv.fetchColorValues(Integer.parseInt(vo1.getPaintType1()));
			  sf.setColorList8(res_list1);
			  sf.setPaintColor8(vo1.getPaintColor1());
			  sf.setWantedQuantity8(vo1.getWantedQuantity1());
			  sf.setTotalAvailableQuantity8(vo1.getTotalAvailableQuantity1());
			  sf.setOldAvailable8(vo1.getOldAvailable1());
			  sf.setNewAvailable8(vo1.getNewAvailable1());
			  sf.setOldRate8(vo1.getOldRate1().toString());
			  sf.setNewRate8(vo1.getNewRate1().toString());
			  sf.setTotalAmount8(vo1.getTotalAmount1());
			  break;
		  case 8:
			  sf.setPaintType9(vo1.getPaintType1());
			  res_list1=paintserv.fetchColorValues(Integer.parseInt(vo1.getPaintType1()));
			  sf.setColorList9(res_list1);
			  sf.setPaintColor9(vo1.getPaintColor1());
			  sf.setWantedQuantity9(vo1.getWantedQuantity1());
			  sf.setTotalAvailableQuantity9(vo1.getTotalAvailableQuantity1());
			  sf.setOldAvailable9(vo1.getOldAvailable1());
			  sf.setNewAvailable9(vo1.getNewAvailable1());
			  sf.setOldRate9(vo1.getOldRate1().toString());
			  sf.setNewRate9(vo1.getNewRate1().toString());
			  sf.setTotalAmount9(vo1.getTotalAmount1());
			  break;
		  case 9:
			  sf.setPaintType10(vo1.getPaintType1());
			  res_list1=paintserv.fetchColorValues(Integer.parseInt(vo1.getPaintType1()));
			  sf.setColorList10(res_list1);
			  sf.setPaintColor10(vo1.getPaintColor1());
			  sf.setWantedQuantity10(vo1.getWantedQuantity1());
			  sf.setTotalAvailableQuantity10(vo1.getTotalAvailableQuantity1());
			  sf.setOldAvailable10(vo1.getOldAvailable1());
			  sf.setNewAvailable10(vo1.getNewAvailable1());
			  sf.setOldRate10(vo1.getOldRate1().toString());
			  sf.setNewRate10(vo1.getNewRate1().toString());
			  sf.setTotalAmount10(vo1.getTotalAmount1());
			  break;
			  
			  
		  }
	  }
		return mapping.findForward("load");
	}
	

/**
 * to display the values automatically after entering the quantity
 * @param mapping
 * @param form
 * @param request
 * @param response
 * @return
 * @throws Exception
 */
public ActionForward qtyUpdateMethod1(ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {
	
	PaintForm sf=(PaintForm)form;
	int compid=Integer.parseInt(sf.getPaintType1());
	int colorid=Integer.parseInt(sf.getPaintColor1());
	if(!StringUtils.isEmpty(sf.getOldAvailable1()))
	{
	oldAvailable=Integer.parseInt(sf.getOldAvailable1());
	oldRate=Float.parseFloat(sf.getOldRate1());
	}
	if(!StringUtils.isEmpty(sf.getNewAvailable1()))
	{
	newAvailable=Integer.parseInt(sf.getNewAvailable1());
	newRate=Float.parseFloat(sf.getNewRate1());
	}
	int total=Integer.parseInt(sf.getTotalAvailableQuantity1());
	logger.debug("total quantity Available"+total);
	int qtywanted=Integer.parseInt(sf.getWantedQuantity1());
	if(total<qtywanted)
	{
		temp=0;
		//append in needed spares
	}
	else if(total>=qtywanted)
	{	
		if(Integer.parseInt(sf.getOldAvailable1())!=0)
		{
			if((oldAvailable-qtywanted)<0)
			{
				temp=qtywanted-oldAvailable;
				oldtemp=0;
				totaloldRate=oldAvailable*oldRate;
				
			}
			else if((oldAvailable-qtywanted)>0)
			{
				temp=0;
				oldtemp=oldAvailable-qtywanted;
				totaloldRate=qtywanted*oldRate;
			}
			else if((oldAvailable-qtywanted)==0)
			{
				temp=0;
				oldtemp=oldAvailable-qtywanted;
				totaloldRate=oldAvailable*oldRate;
			}
			paintserv.updateOldQuantityValues(compid,colorid,oldtemp);
		}
		else if(Integer.parseInt(sf.getOldAvailable1())==0)
		{
			if((oldAvailable-qtywanted)<0)
			{
				temp=qtywanted-oldAvailable;
				oldtemp=0;
				totaloldRate=oldAvailable*oldRate;
				
			}
		}
		if(Integer.parseInt(sf.getNewAvailable1())!=0)
		{
			if(temp!=0)
			{
				if((newAvailable-temp)>0)
				{
					newtemp=newAvailable-temp;
					totalnewRate=temp*newRate;
					
				}
				else if((newAvailable-temp)==0)
				{
					newtemp=newAvailable-temp;
					totalnewRate=temp*newRate;
					
				}
				paintserv.updateNewQuantityValues(compid,colorid,newtemp);
			}
		}
	}
	totalRate=totaloldRate+totalnewRate;
	
	sf.setTotalAmount1(Float.toString(totalRate));
	return mapping.findForward("load");
}


/**
 * to display the values automatically after entering the quantity
 * @param mapping
 * @param form
 * @param request
 * @param response
 * @return
 * @throws Exception
 */
public ActionForward qtyUpdateMethod2(ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {
	PaintForm sf=(PaintForm)form;
	int compid=Integer.parseInt(sf.getPaintType2());
	int colorid=Integer.parseInt(sf.getPaintColor2());
	if(!StringUtils.isEmpty(sf.getOldAvailable2()))
	{
	oldAvailable=Integer.parseInt(sf.getOldAvailable2());
	oldRate=Float.parseFloat(sf.getOldRate2());
	}
	if(!StringUtils.isEmpty(sf.getNewAvailable2()))
	{
	newAvailable=Integer.parseInt(sf.getNewAvailable2());
	newRate=Float.parseFloat(sf.getNewRate2());
	}
	int total=Integer.parseInt(sf.getTotalAvailableQuantity2());
	logger.debug("total quantity Available"+total);
	int qtywanted=Integer.parseInt(sf.getWantedQuantity2());
	if(total<qtywanted)
	{
		temp=0;
		//append in needed spares
	}
	else if(total>=qtywanted)
	{	
		if(Integer.parseInt(sf.getOldAvailable2())!=0)
		{
			if((oldAvailable-qtywanted)<0)
			{
				temp=qtywanted-oldAvailable;
				oldtemp=0;
				totaloldRate=oldAvailable*oldRate;
				
			}
			else if((oldAvailable-qtywanted)>0)
			{
				temp=0;
				oldtemp=oldAvailable-qtywanted;
				totaloldRate=qtywanted*oldRate;
			}
			else if((oldAvailable-qtywanted)==0)
			{
				temp=0;
				oldtemp=oldAvailable-qtywanted;
				totaloldRate=oldAvailable*oldRate;
			}
			paintserv.updateOldQuantityValues(compid,colorid,oldtemp);
		}
		else if(Integer.parseInt(sf.getOldAvailable2())==0)
		{
			if((oldAvailable-qtywanted)<0)
			{
				temp=qtywanted-oldAvailable;
				oldtemp=0;
				totaloldRate=oldAvailable*oldRate;
				
			}
		}
		if(Integer.parseInt(sf.getNewAvailable2())!=0)
		{
			if(temp!=0)
			{
				if((newAvailable-temp)>0)
				{
					newtemp=newAvailable-temp;
					totalnewRate=temp*newRate;
					
				}
				else if((newAvailable-temp)==0)
				{
					newtemp=newAvailable-temp;
					totalnewRate=temp*newRate;
					
				}
				paintserv.updateNewQuantityValues(compid,colorid,newtemp);
			}
		}
	}
	totalRate=totaloldRate+totalnewRate;
	
	sf.setTotalAmount2(Float.toString(totalRate));
	return mapping.findForward("load");
}

/**
 * to display the values automatically after entering the quantity
 * @param mapping
 * @param form
 * @param request
 * @param response
 * @return
 * @throws Exception
 */
public ActionForward qtyUpdateMethod3(ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {
	PaintForm sf=(PaintForm)form;
	int compid=Integer.parseInt(sf.getPaintType3());
	int colorid=Integer.parseInt(sf.getPaintColor3());
	if(!StringUtils.isEmpty(sf.getOldAvailable3()))
	{
	oldAvailable=Integer.parseInt(sf.getOldAvailable3());
	oldRate=Float.parseFloat(sf.getOldRate3());
	}
	if(!StringUtils.isEmpty(sf.getNewAvailable3()))
	{
	newAvailable=Integer.parseInt(sf.getNewAvailable3());
	newRate=Float.parseFloat(sf.getNewRate3());
	}
	int total=Integer.parseInt(sf.getTotalAvailableQuantity3());
	logger.debug("total quantity Available"+total);
	int qtywanted=Integer.parseInt(sf.getWantedQuantity3());
	if(total<qtywanted)
	{
		temp=0;
		//append in needed spares
	}
	else if(total>=qtywanted)
	{	
		if(Integer.parseInt(sf.getOldAvailable3())!=0)
		{
			if((oldAvailable-qtywanted)<0)
			{
				temp=qtywanted-oldAvailable;
				oldtemp=0;
				totaloldRate=oldAvailable*oldRate;
				
			}
			else if((oldAvailable-qtywanted)>0)
			{
				temp=0;
				oldtemp=oldAvailable-qtywanted;
				totaloldRate=qtywanted*oldRate;
			}
			else if((oldAvailable-qtywanted)==0)
			{
				temp=0;
				oldtemp=oldAvailable-qtywanted;
				totaloldRate=oldAvailable*oldRate;
			}
			paintserv.updateOldQuantityValues(compid,colorid,oldtemp);
		}
		else if(Integer.parseInt(sf.getOldAvailable3())==0)
		{
			if((oldAvailable-qtywanted)<0)
			{
				temp=qtywanted-oldAvailable;
				oldtemp=0;
				totaloldRate=oldAvailable*oldRate;
				
			}
		}
		if(Integer.parseInt(sf.getNewAvailable3())!=0)
		{
			if(temp!=0)
			{
				if((newAvailable-temp)>0)
				{
					newtemp=newAvailable-temp;
					totalnewRate=temp*newRate;
					
				}
				else if((newAvailable-temp)==0)
				{
					newtemp=newAvailable-temp;
					totalnewRate=temp*newRate;
					
				}
				paintserv.updateNewQuantityValues(compid,colorid,newtemp);
			}
		}
	}
	totalRate=totaloldRate+totalnewRate;
	
	sf.setTotalAmount3(Float.toString(totalRate));
	return mapping.findForward("load");
}

/**
 * to display the values automatically after entering the quantity
 * @param mapping
 * @param form
 * @param request
 * @param response
 * @return
 * @throws Exception
 */
public ActionForward qtyUpdateMethod4(ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {
	PaintForm sf=(PaintForm)form;
	int compid=Integer.parseInt(sf.getPaintType4());
	int colorid=Integer.parseInt(sf.getPaintColor4());
	if(!StringUtils.isEmpty(sf.getOldAvailable4()))
	{
	oldAvailable=Integer.parseInt(sf.getOldAvailable4());
	oldRate=Float.parseFloat(sf.getOldRate4());
	}
	if(!StringUtils.isEmpty(sf.getNewAvailable4()))
	{
	newAvailable=Integer.parseInt(sf.getNewAvailable4());
	newRate=Float.parseFloat(sf.getNewRate4());
	}
	int total=Integer.parseInt(sf.getTotalAvailableQuantity4());
	logger.debug("total quantity Available"+total);
	int qtywanted=Integer.parseInt(sf.getWantedQuantity4());
	if(total<qtywanted)
	{
		temp=0;
		//append in needed spares
	}
	else if(total>=qtywanted)
	{	
		if(Integer.parseInt(sf.getOldAvailable4())!=0)
		{
			if((oldAvailable-qtywanted)<0)
			{
				temp=qtywanted-oldAvailable;
				oldtemp=0;
				totaloldRate=oldAvailable*oldRate;
				
			}
			else if((oldAvailable-qtywanted)>0)
			{
				temp=0;
				oldtemp=oldAvailable-qtywanted;
				totaloldRate=qtywanted*oldRate;
			}
			else if((oldAvailable-qtywanted)==0)
			{
				temp=0;
				oldtemp=oldAvailable-qtywanted;
				totaloldRate=oldAvailable*oldRate;
			}
			paintserv.updateOldQuantityValues(compid,colorid,oldtemp);
		}
		else if(Integer.parseInt(sf.getOldAvailable4())==0)
		{
			if((oldAvailable-qtywanted)<0)
			{
				temp=qtywanted-oldAvailable;
				oldtemp=0;
				totaloldRate=oldAvailable*oldRate;
				
			}
		}
		if(Integer.parseInt(sf.getNewAvailable4())!=0)
		{
			if(temp!=0)
			{
				if((newAvailable-temp)>0)
				{
					newtemp=newAvailable-temp;
					totalnewRate=temp*newRate;
					
				}
				else if((newAvailable-temp)==0)
				{
					newtemp=newAvailable-temp;
					totalnewRate=temp*newRate;
					
				}
				paintserv.updateNewQuantityValues(compid,colorid,newtemp);
			}
		}
	}
	totalRate=totaloldRate+totalnewRate;
	
	sf.setTotalAmount4(Float.toString(totalRate));
	return mapping.findForward("load");
}



/**
 * to display the values automatically after entering the quantity
 * @param mapping
 * @param form
 * @param request
 * @param response
 * @return
 * @throws Exception
 */
public ActionForward qtyUpdateMethod5(ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {
	PaintForm sf=(PaintForm)form;
	int compid=Integer.parseInt(sf.getPaintType5());
	int colorid=Integer.parseInt(sf.getPaintColor5());
	if(!StringUtils.isEmpty(sf.getOldAvailable5()))
	{
	oldAvailable=Integer.parseInt(sf.getOldAvailable5());
	oldRate=Float.parseFloat(sf.getOldRate5());
	}
	if(!StringUtils.isEmpty(sf.getNewAvailable5()))
	{
	newAvailable=Integer.parseInt(sf.getNewAvailable5());
	newRate=Float.parseFloat(sf.getNewRate5());
	}
	int total=Integer.parseInt(sf.getTotalAvailableQuantity5());
	logger.debug("total quantity Available"+total);
	int qtywanted=Integer.parseInt(sf.getWantedQuantity5());
	if(total<qtywanted)
	{
		temp=0;
		//append in needed spares
	}
	else if(total>=qtywanted)
	{	
		if(Integer.parseInt(sf.getOldAvailable5())!=0)
		{
			if((oldAvailable-qtywanted)<0)
			{
				temp=qtywanted-oldAvailable;
				oldtemp=0;
				totaloldRate=oldAvailable*oldRate;
				
			}
			else if((oldAvailable-qtywanted)>0)
			{
				temp=0;
				oldtemp=oldAvailable-qtywanted;
				totaloldRate=qtywanted*oldRate;
			}
			else if((oldAvailable-qtywanted)==0)
			{
				temp=0;
				oldtemp=oldAvailable-qtywanted;
				totaloldRate=oldAvailable*oldRate;
			}
			paintserv.updateOldQuantityValues(compid,colorid,oldtemp);
		}
		else if(Integer.parseInt(sf.getOldAvailable5())==0)
		{
			if((oldAvailable-qtywanted)<0)
			{
				temp=qtywanted-oldAvailable;
				oldtemp=0;
				totaloldRate=oldAvailable*oldRate;
				
			}
		}
		if(Integer.parseInt(sf.getNewAvailable5())!=0)
		{
			if(temp!=0)
			{
				if((newAvailable-temp)>0)
				{
					newtemp=newAvailable-temp;
					totalnewRate=temp*newRate;
					
				}
				else if((newAvailable-temp)==0)
				{
					newtemp=newAvailable-temp;
					totalnewRate=temp*newRate;
					
				}
				paintserv.updateNewQuantityValues(compid,colorid,newtemp);
			}
		}
	}
	totalRate=totaloldRate+totalnewRate;
	
	sf.setTotalAmount5(Float.toString(totalRate));
	return mapping.findForward("load");
}


/**
 * to display the values automatically after entering the quantity
 * @param mapping
 * @param form
 * @param request
 * @param response
 * @return
 * @throws Exception
 */
public ActionForward qtyUpdateMethod6(ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {
	PaintForm sf=(PaintForm)form;
	int compid=Integer.parseInt(sf.getPaintType6());
	int colorid=Integer.parseInt(sf.getPaintColor6());
	if(!StringUtils.isEmpty(sf.getOldAvailable6()))
	{
	oldAvailable=Integer.parseInt(sf.getOldAvailable6());
	oldRate=Float.parseFloat(sf.getOldRate6());
	}
	if(!StringUtils.isEmpty(sf.getNewAvailable6()))
	{
	newAvailable=Integer.parseInt(sf.getNewAvailable6());
	newRate=Float.parseFloat(sf.getNewRate6());
	}
	int total=Integer.parseInt(sf.getTotalAvailableQuantity6());
	logger.debug("total quantity Available"+total);
	int qtywanted=Integer.parseInt(sf.getWantedQuantity6());
	if(total<qtywanted)
	{
		temp=0;
		//append in needed spares
	}
	else if(total>=qtywanted)
	{	
		if(Integer.parseInt(sf.getOldAvailable6())!=0)
		{
			if((oldAvailable-qtywanted)<0)
			{
				temp=qtywanted-oldAvailable;
				oldtemp=0;
				totaloldRate=oldAvailable*oldRate;
				
			}
			else if((oldAvailable-qtywanted)>0)
			{
				temp=0;
				oldtemp=oldAvailable-qtywanted;
				totaloldRate=qtywanted*oldRate;
			}
			else if((oldAvailable-qtywanted)==0)
			{
				temp=0;
				oldtemp=oldAvailable-qtywanted;
				totaloldRate=oldAvailable*oldRate;
			}
			paintserv.updateOldQuantityValues(compid,colorid,oldtemp);
		}
		else if(Integer.parseInt(sf.getOldAvailable6())==0)
		{
			if((oldAvailable-qtywanted)<0)
			{
				temp=qtywanted-oldAvailable;
				oldtemp=0;
				totaloldRate=oldAvailable*oldRate;
				
			}
		}
		if(Integer.parseInt(sf.getNewAvailable6())!=0)
		{
			if(temp!=0)
			{
				if((newAvailable-temp)>0)
				{
					newtemp=newAvailable-temp;
					totalnewRate=temp*newRate;
					
				}
				else if((newAvailable-temp)==0)
				{
					newtemp=newAvailable-temp;
					totalnewRate=temp*newRate;
					
				}
				paintserv.updateNewQuantityValues(compid,colorid,newtemp);
			}
		}
	}
	totalRate=totaloldRate+totalnewRate;
	
	sf.setTotalAmount6(Float.toString(totalRate));
	return mapping.findForward("load");
}


/**
 * to display the values automatically after entering the quantity
 * @param mapping
 * @param form
 * @param request
 * @param response
 * @return
 * @throws Exception
 */
public ActionForward qtyUpdateMethod7(ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {
	PaintForm sf=(PaintForm)form;
	int compid=Integer.parseInt(sf.getPaintType7());
	int colorid=Integer.parseInt(sf.getPaintColor7());
	if(!StringUtils.isEmpty(sf.getOldAvailable7()))
	{
	oldAvailable=Integer.parseInt(sf.getOldAvailable7());
	oldRate=Float.parseFloat(sf.getOldRate7());
	}
	if(!StringUtils.isEmpty(sf.getNewAvailable7()))
	{
	newAvailable=Integer.parseInt(sf.getNewAvailable7());
	newRate=Float.parseFloat(sf.getNewRate7());
	}
	int total=Integer.parseInt(sf.getTotalAvailableQuantity7());
	logger.debug("total quantity Available"+total);
	int qtywanted=Integer.parseInt(sf.getWantedQuantity7());
	if(total<qtywanted)
	{
		temp=0;
		//append in needed spares
	}
	else if(total>=qtywanted)
	{	
		if(Integer.parseInt(sf.getOldAvailable7())!=0)
		{
			if((oldAvailable-qtywanted)<0)
			{
				temp=qtywanted-oldAvailable;
				oldtemp=0;
				totaloldRate=oldAvailable*oldRate;
				
			}
			else if((oldAvailable-qtywanted)>0)
			{
				temp=0;
				oldtemp=oldAvailable-qtywanted;
				totaloldRate=qtywanted*oldRate;
			}
			else if((oldAvailable-qtywanted)==0)
			{
				temp=0;
				oldtemp=oldAvailable-qtywanted;
				totaloldRate=oldAvailable*oldRate;
			}
			paintserv.updateOldQuantityValues(compid,colorid,oldtemp);
		}
		else if(Integer.parseInt(sf.getOldAvailable7())==0)
		{
			if((oldAvailable-qtywanted)<0)
			{
				temp=qtywanted-oldAvailable;
				oldtemp=0;
				totaloldRate=oldAvailable*oldRate;
				
			}
		}
		if(Integer.parseInt(sf.getNewAvailable7())!=0)
		{
			if(temp!=0)
			{
				if((newAvailable-temp)>0)
				{
					newtemp=newAvailable-temp;
					totalnewRate=temp*newRate;
					
				}
				else if((newAvailable-temp)==0)
				{
					newtemp=newAvailable-temp;
					totalnewRate=temp*newRate;
					
				}
				paintserv.updateNewQuantityValues(compid,colorid,newtemp);
			}
		}
	}
	totalRate=totaloldRate+totalnewRate;
	
	sf.setTotalAmount7(Float.toString(totalRate));
	return mapping.findForward("load");
}


/**
 * to display the values automatically after entering the quantity
 * @param mapping
 * @param form
 * @param request
 * @param response
 * @return
 * @throws Exception
 */
public ActionForward qtyUpdateMethod8(ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {
	PaintForm sf=(PaintForm)form;
	int compid=Integer.parseInt(sf.getPaintType8());
	int colorid=Integer.parseInt(sf.getPaintColor8());
	if(!StringUtils.isEmpty(sf.getOldAvailable8()))
	{
	oldAvailable=Integer.parseInt(sf.getOldAvailable8());
	oldRate=Float.parseFloat(sf.getOldRate8());
	}
	if(!StringUtils.isEmpty(sf.getNewAvailable8()))
	{
	newAvailable=Integer.parseInt(sf.getNewAvailable8());
	newRate=Float.parseFloat(sf.getNewRate8());
	}
	int total=Integer.parseInt(sf.getTotalAvailableQuantity8());
	logger.debug("total quantity Available"+total);
	int qtywanted=Integer.parseInt(sf.getWantedQuantity8());
	if(total<qtywanted)
	{
		temp=0;
		//append in needed spares
	}
	else if(total>=qtywanted)
	{	
		if(Integer.parseInt(sf.getOldAvailable8())!=0)
		{
			if((oldAvailable-qtywanted)<0)
			{
				temp=qtywanted-oldAvailable;
				oldtemp=0;
				totaloldRate=oldAvailable*oldRate;
				
			}
			else if((oldAvailable-qtywanted)>0)
			{
				temp=0;
				oldtemp=oldAvailable-qtywanted;
				totaloldRate=qtywanted*oldRate;
			}
			else if((oldAvailable-qtywanted)==0)
			{
				temp=0;
				oldtemp=oldAvailable-qtywanted;
				totaloldRate=oldAvailable*oldRate;
			}
			paintserv.updateOldQuantityValues(compid,colorid,oldtemp);
		}
		else if(Integer.parseInt(sf.getOldAvailable8())==0)
		{
			if((oldAvailable-qtywanted)<0)
			{
				temp=qtywanted-oldAvailable;
				oldtemp=0;
				totaloldRate=oldAvailable*oldRate;
				
			}
		}
		if(Integer.parseInt(sf.getNewAvailable8())!=0)
		{
			if(temp!=0)
			{
				if((newAvailable-temp)>0)
				{
					newtemp=newAvailable-temp;
					totalnewRate=temp*newRate;
					
				}
				else if((newAvailable-temp)==0)
				{
					newtemp=newAvailable-temp;
					totalnewRate=temp*newRate;
					
				}
				paintserv.updateNewQuantityValues(compid,colorid,newtemp);
			}
		}
	}
	totalRate=totaloldRate+totalnewRate;
	
	sf.setTotalAmount8(Float.toString(totalRate));
	return mapping.findForward("load");
}


/**
 * to display the values automatically after entering the quantity
 * @param mapping
 * @param form
 * @param request
 * @param response
 * @return
 * @throws Exception
 */
public ActionForward qtyUpdateMethod9(ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {
	PaintForm sf=(PaintForm)form;
	int compid=Integer.parseInt(sf.getPaintType9());
	int colorid=Integer.parseInt(sf.getPaintColor9());
	if(!StringUtils.isEmpty(sf.getOldAvailable9()))
	{
	oldAvailable=Integer.parseInt(sf.getOldAvailable9());
	oldRate=Float.parseFloat(sf.getOldRate9());
	}
	if(!StringUtils.isEmpty(sf.getNewAvailable9()))
	{
	newAvailable=Integer.parseInt(sf.getNewAvailable9());
	newRate=Float.parseFloat(sf.getNewRate9());
	}
	int total=Integer.parseInt(sf.getTotalAvailableQuantity9());
	logger.debug("total quantity Available"+total);
	int qtywanted=Integer.parseInt(sf.getWantedQuantity9());
	if(total<qtywanted)
	{
		temp=0;
		//append in needed spares
	}
	else if(total>=qtywanted)
	{	
		if(Integer.parseInt(sf.getOldAvailable9())!=0)
		{
			if((oldAvailable-qtywanted)<0)
			{
				temp=qtywanted-oldAvailable;
				oldtemp=0;
				totaloldRate=oldAvailable*oldRate;
				
			}
			else if((oldAvailable-qtywanted)>0)
			{
				temp=0;
				oldtemp=oldAvailable-qtywanted;
				totaloldRate=qtywanted*oldRate;
			}
			else if((oldAvailable-qtywanted)==0)
			{
				temp=0;
				oldtemp=oldAvailable-qtywanted;
				totaloldRate=oldAvailable*oldRate;
			}
			paintserv.updateOldQuantityValues(compid,colorid,oldtemp);
		}
		else if(Integer.parseInt(sf.getOldAvailable9())==0)
		{
			if((oldAvailable-qtywanted)<0)
			{
				temp=qtywanted-oldAvailable;
				oldtemp=0;
				totaloldRate=oldAvailable*oldRate;
				
			}
		}
		if(Integer.parseInt(sf.getNewAvailable9())!=0)
		{
			if(temp!=0)
			{
				if((newAvailable-temp)>0)
				{
					newtemp=newAvailable-temp;
					totalnewRate=temp*newRate;
					
				}
				else if((newAvailable-temp)==0)
				{
					newtemp=newAvailable-temp;
					totalnewRate=temp*newRate;
					
				}
				paintserv.updateNewQuantityValues(compid,colorid,newtemp);
			}
		}
	}
	totalRate=totaloldRate+totalnewRate;
	
	sf.setTotalAmount9(Float.toString(totalRate));
	return mapping.findForward("load");
}


/**
 * to display the values automatically after entering the quantity
 * @param mapping
 * @param form
 * @param request
 * @param response
 * @return
 * @throws Exception
 */
public ActionForward qtyUpdateMethod10(ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {
	PaintForm sf=(PaintForm)form;
	int compid=Integer.parseInt(sf.getPaintType10());
	int colorid=Integer.parseInt(sf.getPaintColor10());
	if(!StringUtils.isEmpty(sf.getOldAvailable10()))
	{
	oldAvailable=Integer.parseInt(sf.getOldAvailable10());
	oldRate=Float.parseFloat(sf.getOldRate10());
	}
	if(!StringUtils.isEmpty(sf.getNewAvailable10()))
	{
	newAvailable=Integer.parseInt(sf.getNewAvailable10());
	newRate=Float.parseFloat(sf.getNewRate10());
	}
	int total=Integer.parseInt(sf.getTotalAvailableQuantity10());
	logger.debug("total quantity Available"+total);
	int qtywanted=Integer.parseInt(sf.getWantedQuantity10());
	if(total<qtywanted)
	{
		temp=0;
		//append in needed spares
	}
	else if(total>=qtywanted)
	{	
		if(Integer.parseInt(sf.getOldAvailable10())!=0)
		{
			if((oldAvailable-qtywanted)<0)
			{
				temp=qtywanted-oldAvailable;
				oldtemp=0;
				totaloldRate=oldAvailable*oldRate;
				
			}
			else if((oldAvailable-qtywanted)>0)
			{
				temp=0;
				oldtemp=oldAvailable-qtywanted;
				totaloldRate=qtywanted*oldRate;
			}
			else if((oldAvailable-qtywanted)==0)
			{
				temp=0;
				oldtemp=oldAvailable-qtywanted;
				totaloldRate=oldAvailable*oldRate;
			}
			paintserv.updateOldQuantityValues(compid,colorid,oldtemp);
		}
		else if(Integer.parseInt(sf.getOldAvailable10())==0)
		{
			if((oldAvailable-qtywanted)<0)
			{
				temp=qtywanted-oldAvailable;
				oldtemp=0;
				totaloldRate=oldAvailable*oldRate;
				
			}
		}
		if(Integer.parseInt(sf.getNewAvailable10())!=0)
		{
			if(temp!=0)
			{
				if((newAvailable-temp)>0)
				{
					newtemp=newAvailable-temp;
					totalnewRate=temp*newRate;
					
				}
				else if((newAvailable-temp)==0)
				{
					newtemp=newAvailable-temp;
					totalnewRate=temp*newRate;
					
				}
				paintserv.updateNewQuantityValues(compid,colorid,newtemp);
			}
		}
	}
	totalRate=totaloldRate+totalnewRate;
	
	sf.setTotalAmount10(Float.toString(totalRate));
	return mapping.findForward("load");
}

/**
 * to insert the values in table
 * @param jobid
 * @param form
 */
public void insertvalues(int jobid,ActionForm form)
{
	int wantedquantity;
	int totalqty;
	int oldavail;
	float oldrate;
	int newavail=0;
	float newrate=0;
	float amount;
	int brandname;
	int partno;
	String other=null;
	PaintForm sf=(PaintForm)form;
	int inst=Integer.parseInt(sf.getInstitutionName());
	int vehicletype=Integer.parseInt(sf.getVehicleType());
	int vehiclenumber=Integer.parseInt(sf.getVehicleNumber());;
	int drname=Integer.parseInt(sf.getDriverName());
	int rdrname=Integer.parseInt(sf.getRequestedDriverName());
	if(StringUtils.isNotEmpty(sf.getOtherPurpose()))
	{
	other=sf.getOtherPurpose();
	}
	try
    {
		SparepartsService ss=new SparepartsService();
	//	ss.insertCommon(inst,vehicletype,vehiclenumber,drname,rdrname,other,jobid);
   		logger.debug("main");
    }
    catch(Exception e)
    {
    	logger.debug("error"+e);
    }
    if(!StringUtils.isEmpty(sf.getWantedQuantity1()))
    {
    	brandname=Integer.parseInt(sf.getPaintType1());
    	partno=Integer.parseInt(sf.getPaintColor1());
    	wantedquantity=Integer.parseInt(sf.getWantedQuantity1());
    	totalqty=Integer.parseInt(sf.getTotalAvailableQuantity1());
    	oldavail=Integer.parseInt(sf.getOldAvailable1());
    	oldrate=Float.parseFloat(sf.getOldRate1());
    	newavail=Integer.parseInt(sf.getNewAvailable1());
    	newrate=Float.parseFloat(sf.getNewRate1());
    	amount=Float.parseFloat(sf.getTotalAmount1());
    	      
    	try
	    {
    		ss.insertCommonValues(jobid,partno,brandname,totalqty,wantedquantity,oldavail,newavail,oldrate,newrate,amount);
	    	logger.debug("fuel");
	    }
	    catch(Exception e)
	    {
	    	logger.debug("error"+e);
	    }
    }
    if(!StringUtils.isEmpty(sf.getWantedQuantity2()))
    {
    	brandname=Integer.parseInt(sf.getPaintType2());
    	partno=Integer.parseInt(sf.getPaintColor2());
    	wantedquantity=Integer.parseInt(sf.getWantedQuantity2());
    	totalqty=Integer.parseInt(sf.getTotalAvailableQuantity2());
    	oldavail=Integer.parseInt(sf.getOldAvailable2());
    	oldrate=Float.parseFloat(sf.getOldRate2());
    	newavail=Integer.parseInt(sf.getNewAvailable2());
    	newrate=Float.parseFloat(sf.getNewRate2());
    	amount=Float.parseFloat(sf.getTotalAmount2());
    	try
	    {
    		ss.insertCommonValues(jobid,partno,brandname,totalqty,wantedquantity,oldavail,newavail,oldrate,newrate,amount);
	    	logger.debug("fuel");
	    }
	    catch(Exception e)
	    {
	    	logger.debug("error"+e);
	    }
    }
    if(!StringUtils.isEmpty(sf.getWantedQuantity3()))
    {
    	brandname=Integer.parseInt(sf.getPaintType3());
    	partno=Integer.parseInt(sf.getPaintColor3());
    	wantedquantity=Integer.parseInt(sf.getWantedQuantity3());
    	totalqty=Integer.parseInt(sf.getTotalAvailableQuantity3());
    	oldavail=Integer.parseInt(sf.getOldAvailable3());
    	oldrate=Float.parseFloat(sf.getOldRate3());
    	newavail=Integer.parseInt(sf.getNewAvailable3());
    	newrate=Float.parseFloat(sf.getNewRate3());
    	amount=Float.parseFloat(sf.getTotalAmount3());
    	try
	    {
    		ss.insertCommonValues(jobid,partno,brandname,totalqty,wantedquantity,oldavail,newavail,oldrate,newrate,amount);
	    	logger.debug("fuel");
	    }
	    catch(Exception e)
	    {
	    	logger.debug("error"+e);
	    }
    }
    if(!StringUtils.isEmpty(sf.getWantedQuantity4()))
    {
    	brandname=Integer.parseInt(sf.getPaintType4());
    	partno=Integer.parseInt(sf.getPaintColor4());
    	wantedquantity=Integer.parseInt(sf.getWantedQuantity4());
    	totalqty=Integer.parseInt(sf.getTotalAvailableQuantity4());
    	oldavail=Integer.parseInt(sf.getOldAvailable4());
    	oldrate=Float.parseFloat(sf.getOldRate4());
    	newavail=Integer.parseInt(sf.getNewAvailable4());
    	newrate=Float.parseFloat(sf.getNewRate4());
    	amount=Float.parseFloat(sf.getTotalAmount4());
    	try
	    {
    		ss.insertCommonValues(jobid,partno,brandname,totalqty,wantedquantity,oldavail,newavail,oldrate,newrate,amount);
	    	logger.debug("fuel");
	    }
	    catch(Exception e)
	    {
	    	logger.debug("error"+e);
	    }
    }
    if(!StringUtils.isEmpty(sf.getWantedQuantity5()))
    {
    	brandname=Integer.parseInt(sf.getPaintType5());
    	partno=Integer.parseInt(sf.getPaintColor5());
    	wantedquantity=Integer.parseInt(sf.getWantedQuantity5());
    	totalqty=Integer.parseInt(sf.getTotalAvailableQuantity5());
    	oldavail=Integer.parseInt(sf.getOldAvailable5());
    	oldrate=Float.parseFloat(sf.getOldRate5());
    	newavail=Integer.parseInt(sf.getNewAvailable5());
    	newrate=Float.parseFloat(sf.getNewRate5());
    	amount=Float.parseFloat(sf.getTotalAmount5());
    	try
	    {
    		ss.insertCommonValues(jobid,partno,brandname,totalqty,wantedquantity,oldavail,newavail,oldrate,newrate,amount);
	    	logger.debug("fuel");
	    }
	    catch(Exception e)
	    {
	    	logger.debug("error"+e);
	    }
    }
    if(!StringUtils.isEmpty(sf.getWantedQuantity6()))
    {
    	brandname=Integer.parseInt(sf.getPaintType6());
    	partno=Integer.parseInt(sf.getPaintColor6());
    	wantedquantity=Integer.parseInt(sf.getWantedQuantity6());
    	totalqty=Integer.parseInt(sf.getTotalAvailableQuantity6());
    	oldavail=Integer.parseInt(sf.getOldAvailable6());
    	oldrate=Float.parseFloat(sf.getOldRate6());
    	newavail=Integer.parseInt(sf.getNewAvailable6());
    	newrate=Float.parseFloat(sf.getNewRate6());
    	amount=Float.parseFloat(sf.getTotalAmount6());
    	try
	    {
    		ss.insertCommonValues(jobid,partno,brandname,totalqty,wantedquantity,oldavail,newavail,oldrate,newrate,amount);
	    	logger.debug("fuel");
	    }
	    catch(Exception e)
	    {
	    	logger.debug("error"+e);
	    }
    }
    if(!StringUtils.isEmpty(sf.getWantedQuantity7()))
    {
    	brandname=Integer.parseInt(sf.getPaintType7());
    	partno=Integer.parseInt(sf.getPaintColor7());
    	wantedquantity=Integer.parseInt(sf.getWantedQuantity7());
    	totalqty=Integer.parseInt(sf.getTotalAvailableQuantity7());
    	oldavail=Integer.parseInt(sf.getOldAvailable7());
    	oldrate=Float.parseFloat(sf.getOldRate7());
    	newavail=Integer.parseInt(sf.getNewAvailable7());
    	newrate=Float.parseFloat(sf.getNewRate7());
    	amount=Float.parseFloat(sf.getTotalAmount7());
    	try
	    {
    		ss.insertCommonValues(jobid,partno,brandname,totalqty,wantedquantity,oldavail,newavail,oldrate,newrate,amount);
	    	logger.debug("fuel");
	    }
	    catch(Exception e)
	    {
	    	logger.debug("error"+e);
	    }
    }
    if(!StringUtils.isEmpty(sf.getWantedQuantity8()))
    {
    	brandname=Integer.parseInt(sf.getPaintType8());
    	partno=Integer.parseInt(sf.getPaintColor8());
    	wantedquantity=Integer.parseInt(sf.getWantedQuantity8());
    	totalqty=Integer.parseInt(sf.getTotalAvailableQuantity8());
    	oldavail=Integer.parseInt(sf.getOldAvailable8());
    	oldrate=Float.parseFloat(sf.getOldRate8());
    	newavail=Integer.parseInt(sf.getNewAvailable8());
    	newrate=Float.parseFloat(sf.getNewRate8());
    	amount=Float.parseFloat(sf.getTotalAmount8());
    	try
	    {
    		ss.insertCommonValues(jobid,partno,brandname,totalqty,wantedquantity,oldavail,newavail,oldrate,newrate,amount);
	    	logger.debug("fuel");
	    }
	    catch(Exception e)
	    {
	    	logger.debug("error"+e);
	    }
    }
    if(!StringUtils.isEmpty(sf.getWantedQuantity9()))
    {
    	brandname=Integer.parseInt(sf.getPaintType9());
    	partno=Integer.parseInt(sf.getPaintColor9());
    	wantedquantity=Integer.parseInt(sf.getWantedQuantity9());
    	totalqty=Integer.parseInt(sf.getTotalAvailableQuantity9());
    	oldavail=Integer.parseInt(sf.getOldAvailable9());
    	oldrate=Float.parseFloat(sf.getOldRate9());
    	newavail=Integer.parseInt(sf.getNewAvailable9());
    	newrate=Float.parseFloat(sf.getNewRate9());
    	amount=Float.parseFloat(sf.getTotalAmount9());
    	try
	    {
    		ss.insertCommonValues(jobid,partno,brandname,totalqty,wantedquantity,oldavail,newavail,oldrate,newrate,amount);
	    	logger.debug("fuel");
	    }
	    catch(Exception e)
	    {
	    	logger.debug("error"+e);
	    }
    }
    if(!StringUtils.isEmpty(sf.getWantedQuantity10()))
    {
    	brandname=Integer.parseInt(sf.getPaintType10());
    	partno=Integer.parseInt(sf.getPaintColor10());
    	wantedquantity=Integer.parseInt(sf.getWantedQuantity10());
    	totalqty=Integer.parseInt(sf.getTotalAvailableQuantity10());
    	oldavail=Integer.parseInt(sf.getOldAvailable10());
    	oldrate=Float.parseFloat(sf.getOldRate10());
    	newavail=Integer.parseInt(sf.getNewAvailable10());
    	newrate=Float.parseFloat(sf.getNewRate10());
    	amount=Float.parseFloat(sf.getTotalAmount10());
    	try
	    {
    		ss.insertCommonValues(jobid,partno,brandname,totalqty,wantedquantity,oldavail,newavail,oldrate,newrate,amount);
	    	logger.debug("fuel");
	    }
	    catch(Exception e)
	    {
	    	logger.debug("error"+e);
	    }
    }
    
}


/**
 * 
 * @param form
 */
public void clear(ActionForm form)
{
	PaintForm sf=(PaintForm)form;
	sf.setWantedQuantity1(null);
	sf.setWantedQuantity2(null);
	sf.setWantedQuantity3(null);
	sf.setWantedQuantity4(null);
	sf.setWantedQuantity5(null);
	sf.setWantedQuantity6(null);
	sf.setTotalAmount1(null);
	sf.setTotalAmount2(null);
	sf.setTotalAmount3(null);
	sf.setTotalAmount4(null);
	sf.setTotalAmount5(null);
	sf.setTotalAvailableQuantity1(null);
	sf.setTotalAvailableQuantity2(null);
	sf.setTotalAvailableQuantity3(null);
	sf.setTotalAvailableQuantity4(null);
	sf.setTotalAvailableQuantity5(null);
	sf.setOldAvailable1(null);
	sf.setOldAvailable2(null);
	sf.setOldAvailable3(null);
	sf.setOldAvailable4(null);
	sf.setOldAvailable5(null);
	sf.setOldRate1(null);
	sf.setOldRate2(null);
	sf.setOldRate3(null);
	sf.setOldRate4(null);
	sf.setOldRate5(null);
}


/**
 * to list the vehicle type based on the institution name
 * @param mapping
 * @param form
 * @param request
 * @param response
 * @return
 * @throws Exception
 */
public ActionForward listVehicleMethod(ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {
		arrayList list1=new arrayList();
		list1.dropdownList(form);
		ArrayList list=new ArrayList();
		PaintForm sf=(PaintForm)form;
		int instname=Integer.parseInt(sf.getInstitutionName());
		
		list=ss.fetchVehicleType(instname);
		sf.setVehicleTypeList(list);
		logger.debug("spare1Action:defaultMethod---------->");
		return mapping.findForward("load");
}


/**
 * to list those vehicle number based on institution name and vehicle type
 * @param mapping
 * @param form
 * @param request
 * @param response
 * @return
 * @throws Exception
 */
public ActionForward listVehicleNumberMethod(ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {
		arrayList list1=new arrayList();
		list1.dropdownList(form);
		ArrayList list=new ArrayList();
		PaintForm sf=(PaintForm)form;
		int instname=Integer.parseInt(sf.getInstitutionName());
		int type=Integer.parseInt(sf.getVehicleType());
		
		list=ss.fetchVehicleNumber(type,instname);
		sf.setVehicleNumberList(list);
		res_list3=paintserv.fetchTypeValues();
		sf.setCompList(res_list3);
		logger.debug("spare1Action:defaultMethod---------->");
		return mapping.findForward("load");
}
	

public ActionForward listColorMethod1(ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {
		PaintForm sform=(PaintForm)form;
		res_list=paintserv.fetchTypeValues();
		sform.setCompList(res_list);
		spareid=Integer.parseInt(sform.getPaintType1());
		res_list1=paintserv.fetchColorValues(spareid);
		sform.setColorList1(res_list1);
		return mapping.findForward("load");
}
public ActionForward listColorMethod2(ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {
	PaintForm sform=(PaintForm)form;
	res_list=paintserv.fetchTypeValues();
	sform.setCompList(res_list);
	spareid=Integer.parseInt(sform.getPaintType2());
	res_list1=paintserv.fetchColorValues(spareid);
	sform.setColorList2(res_list1);
				
		return mapping.findForward("load");
}
public ActionForward listColorMethod3(ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {
	PaintForm sform=(PaintForm)form;
	res_list=paintserv.fetchTypeValues();
	sform.setCompList(res_list);
	spareid=Integer.parseInt(sform.getPaintType3());
	res_list1=paintserv.fetchColorValues(spareid);
	sform.setColorList3(res_list1);
		return mapping.findForward("load");
}
public ActionForward listColorMethod4(ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {
	PaintForm sform=(PaintForm)form;
	res_list=paintserv.fetchTypeValues();
	sform.setCompList(res_list);
	spareid=Integer.parseInt(sform.getPaintType4());
	res_list1=paintserv.fetchColorValues(spareid);
	sform.setColorList4(res_list1);
		return mapping.findForward("load");
}
public ActionForward listColorMethod5(ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {
	PaintForm sform=(PaintForm)form;
	res_list=paintserv.fetchTypeValues();
	sform.setCompList(res_list);
	spareid=Integer.parseInt(sform.getPaintType5());
	res_list1=paintserv.fetchColorValues(spareid);
	sform.setColorList5(res_list1);
		return mapping.findForward("load");
}

public ActionForward listColorMethod6(ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {
	PaintForm sform=(PaintForm)form;
	res_list=paintserv.fetchTypeValues();
	sform.setCompList(res_list);
	spareid=Integer.parseInt(sform.getPaintType6());
	res_list1=paintserv.fetchColorValues(spareid);
	sform.setColorList6(res_list1);
		return mapping.findForward("load");
}
public ActionForward listColorMethod7(ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {
	PaintForm sform=(PaintForm)form;
	res_list=paintserv.fetchTypeValues();
	sform.setCompList(res_list);
	spareid=Integer.parseInt(sform.getPaintType7());
	res_list1=paintserv.fetchColorValues(spareid);
	sform.setColorList7(res_list1);
		return mapping.findForward("load");
}
public ActionForward listColorMethod8(ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {
	PaintForm sform=(PaintForm)form;
	res_list=paintserv.fetchTypeValues();
	sform.setCompList(res_list);
	spareid=Integer.parseInt(sform.getPaintType8());
	res_list1=paintserv.fetchColorValues(spareid);
	sform.setColorList8(res_list1);
		return mapping.findForward("load");
}
public ActionForward listColorMethod9(ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {
	PaintForm sform=(PaintForm)form;
	res_list=paintserv.fetchTypeValues();
	sform.setCompList(res_list);
	spareid=Integer.parseInt(sform.getPaintType9());
	res_list1=paintserv.fetchColorValues(spareid);
	sform.setColorList9(res_list1);
		return mapping.findForward("load");
}
public ActionForward listColorMethod10(ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {
	PaintForm sform=(PaintForm)form;
	res_list=paintserv.fetchTypeValues();
	sform.setCompList(res_list);
	spareid=Integer.parseInt(sform.getPaintType10());
	res_list1=paintserv.fetchColorValues(spareid);
	sform.setColorList10(res_list1);
		return mapping.findForward("load");
}


public ActionForward listRates1Method(ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {
	
	PaintIssueVO vo=new PaintIssueVO();
		ArrayList list=new ArrayList();
		PaintForm sf=(PaintForm)form;
		sf.setOldAvailable1(null);
		sf.setOldRate1(null);
		sf.setNewAvailable1(null);
		sf.setNewRate1(null);
		sf.setTotalAvailableQuantity1(null);
		int compid=Integer.parseInt(sf.getPaintType1());
		int pid=Integer.parseInt(sf.getPaintColor1());
		logger.debug("partnumber id"+pid);
		list=paintserv.fetchRateValue1(compid,pid);
		for(int i=0;i<list.size();i++)
		{
			
			vo=(PaintIssueVO)list.get(i);
			logger.debug("spare values"+vo.getOldAvailable1()+""+vo.getNewAvailable1()+""+vo.getOldRate1()+""+vo.getNewRate1());
			sf.setOldAvailable1(vo.getOldAvailable1());
			sf.setNewAvailable1(vo.getNewAvailable1());
			sf.setOldRate1((vo.getOldRate1()).toString());
			sf.setNewRate1((vo.getNewRate1()).toString());
			total=Integer.parseInt(vo.getOldAvailable1())+Integer.parseInt(vo.getNewAvailable1());
		
		}
		logger.debug(total);
		sf.setTotalAvailableQuantity1(Integer.toString(total));
		logger.debug("spare1Action:defaultMethod---------->");
		return mapping.findForward("load");
}

public ActionForward listRates2Method(ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {
		
	PaintIssueVO vo=new PaintIssueVO();
		ArrayList list=new ArrayList();
		PaintForm sf=(PaintForm)form;
		sf.setOldAvailable2(null);
		sf.setOldRate2(null);
		sf.setNewAvailable2(null);
		sf.setNewRate2(null);
		sf.setTotalAvailableQuantity2(null);
		int compid=Integer.parseInt(sf.getPaintType2());
		int pid=Integer.parseInt(sf.getPaintColor2());
		logger.debug("partnumber id"+pid);
		list=paintserv.fetchRateValue1(compid,pid);
		for(int i=0;i<list.size();i++)
		{
			
			vo=(PaintIssueVO)list.get(i);
			logger.debug("spare values"+vo.getOldAvailable1()+""+vo.getNewAvailable1()+""+vo.getOldRate1()+""+vo.getNewRate1());
			sf.setOldAvailable2(vo.getOldAvailable1());
			sf.setNewAvailable2(vo.getNewAvailable1());
			sf.setOldRate2((vo.getOldRate1()).toString());
			sf.setNewRate2((vo.getNewRate1()).toString());
			total=Integer.parseInt(vo.getOldAvailable1())+Integer.parseInt(vo.getNewAvailable1());
		
		}
		logger.debug(total);
		sf.setTotalAvailableQuantity2(Integer.toString(total));
		logger.debug("spare1Action:defaultMethod---------->");
		return mapping.findForward("load");
}
public ActionForward listRates3Method(ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {
		
	PaintIssueVO vo=new PaintIssueVO();
		ArrayList list=new ArrayList();
		PaintForm sf=(PaintForm)form;
		sf.setOldAvailable3(null);
		sf.setOldRate3(null);
		sf.setNewAvailable3(null);
		sf.setNewRate3(null);
		sf.setTotalAvailableQuantity3(null);
		int compid=Integer.parseInt(sf.getPaintType3());
		int pid=Integer.parseInt(sf.getPaintColor3());
		logger.debug("partnumber id"+pid);
		list=paintserv.fetchRateValue1(compid,pid);
		for(int i=0;i<list.size();i++)
		{
			
			vo=(PaintIssueVO)list.get(i);
			logger.debug("spare values"+vo.getOldAvailable1()+""+vo.getNewAvailable1()+""+vo.getOldRate1()+""+vo.getNewRate1());
			sf.setOldAvailable3(vo.getOldAvailable1());
			sf.setNewAvailable3(vo.getNewAvailable1());
			sf.setOldRate3((vo.getOldRate1()).toString());
			sf.setNewRate3((vo.getNewRate1()).toString());
			total=Integer.parseInt(vo.getOldAvailable1())+Integer.parseInt(vo.getNewAvailable1());
		
		}
		logger.debug(total);
		sf.setTotalAvailableQuantity3(Integer.toString(total));
		logger.debug("spare1Action:defaultMethod---------->");
		return mapping.findForward("load");
}

public ActionForward listRates4Method(ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {
		
	PaintIssueVO vo=new PaintIssueVO();
		ArrayList list=new ArrayList();
		PaintForm sf=(PaintForm)form;
		sf.setOldAvailable4(null);
		sf.setOldRate4(null);
		sf.setNewAvailable4(null);
		sf.setNewRate4(null);
		sf.setTotalAvailableQuantity4(null);
		int compid=Integer.parseInt(sf.getPaintType4());
		int pid=Integer.parseInt(sf.getPaintColor4());
		logger.debug("partnumber id"+pid);
		list=paintserv.fetchRateValue1(compid,pid);
		for(int i=0;i<list.size();i++)
		{
			
			vo=(PaintIssueVO)list.get(i);
			logger.debug("spare values"+vo.getOldAvailable1()+""+vo.getNewAvailable1()+""+vo.getOldRate1()+""+vo.getNewRate1());
			sf.setOldAvailable4(vo.getOldAvailable1());
			sf.setNewAvailable4(vo.getNewAvailable1());
			sf.setOldRate4((vo.getOldRate1()).toString());
			sf.setNewRate4((vo.getNewRate1()).toString());
			total=Integer.parseInt(vo.getOldAvailable1())+Integer.parseInt(vo.getNewAvailable1());
		
		}
		logger.debug(total);
		sf.setTotalAvailableQuantity4(Integer.toString(total));
		logger.debug("spare1Action:defaultMethod---------->");
		return mapping.findForward("load");
}

public ActionForward listRates5Method(ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {
		
	PaintIssueVO vo=new PaintIssueVO();
		ArrayList list=new ArrayList();
		PaintForm sf=(PaintForm)form;
		sf.setOldAvailable5(null);
		sf.setOldRate5(null);
		sf.setNewAvailable5(null);
		sf.setNewRate5(null);
		sf.setTotalAvailableQuantity5(null);
		int compid=Integer.parseInt(sf.getPaintType5());
		int pid=Integer.parseInt(sf.getPaintColor5());
		logger.debug("partnumber id"+pid);
		list=paintserv.fetchRateValue1(compid,pid);
		for(int i=0;i<list.size();i++)
		{
			
			vo=(PaintIssueVO)list.get(i);
			logger.debug("spare values"+vo.getOldAvailable1()+""+vo.getNewAvailable1()+""+vo.getOldRate1()+""+vo.getNewRate1());
			sf.setOldAvailable5(vo.getOldAvailable1());
			sf.setNewAvailable5(vo.getNewAvailable1());
			sf.setOldRate5((vo.getOldRate1()).toString());
			sf.setNewRate5((vo.getNewRate1()).toString());
			total=Integer.parseInt(vo.getOldAvailable1())+Integer.parseInt(vo.getNewAvailable1());
		
		}
		logger.debug(total);
		sf.setTotalAvailableQuantity5(Integer.toString(total));
		logger.debug("spare1Action:defaultMethod---------->");
		return mapping.findForward("load");
}


public ActionForward listRates6Method(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response)
		throws Exception {
	PaintIssueVO vo=new PaintIssueVO();
		ArrayList list=new ArrayList();
		PaintForm sf=(PaintForm)form;
		sf.setOldAvailable6(null);
		sf.setOldRate6(null);
		sf.setNewAvailable6(null);
		sf.setNewRate6(null);
		sf.setTotalAvailableQuantity6(null);
		int compid=Integer.parseInt(sf.getPaintType6());
		int pid=Integer.parseInt(sf.getPaintColor6());
		logger.debug("partnumber id"+pid);
		list=paintserv.fetchRateValue1(compid,pid);
		for(int i=0;i<list.size();i++)
		{
			
			vo=(PaintIssueVO)list.get(i);
			logger.debug("spare values"+vo.getOldAvailable1()+""+vo.getNewAvailable1()+""+vo.getOldRate1()+""+vo.getNewRate1());
			sf.setOldAvailable6(vo.getOldAvailable1());
			sf.setNewAvailable6(vo.getNewAvailable1());
			sf.setOldRate6((vo.getOldRate1()).toString());
			sf.setNewRate6((vo.getNewRate1()).toString());
			total=Integer.parseInt(vo.getOldAvailable1())+Integer.parseInt(vo.getNewAvailable1());
		
		}
		logger.debug(total);
		sf.setTotalAvailableQuantity6(Integer.toString(total));
		logger.debug("spare1Action:defaultMethod---------->");
		return mapping.findForward("load");
}

public ActionForward listRates7Method(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response)
		throws Exception {
	PaintIssueVO vo=new PaintIssueVO();
		ArrayList list=new ArrayList();
		PaintForm sf=(PaintForm)form;
		sf.setOldAvailable7(null);
		sf.setOldRate7(null);
		sf.setNewAvailable7(null);
		sf.setNewRate7(null);
		sf.setTotalAvailableQuantity7(null);
		int compid=Integer.parseInt(sf.getPaintType7());
		int pid=Integer.parseInt(sf.getPaintColor7());
		logger.debug("partnumber id"+pid);
		list=paintserv.fetchRateValue1(compid,pid);
		for(int i=0;i<list.size();i++)
		{
			
			vo=(PaintIssueVO)list.get(i);
			logger.debug("spare values"+vo.getOldAvailable1()+""+vo.getNewAvailable1()+""+vo.getOldRate1()+""+vo.getNewRate1());
			sf.setOldAvailable7(vo.getOldAvailable1());
			sf.setNewAvailable7(vo.getNewAvailable1());
			sf.setOldRate7((vo.getOldRate1()).toString());
			sf.setNewRate7((vo.getNewRate1()).toString());
			total=Integer.parseInt(vo.getOldAvailable1())+Integer.parseInt(vo.getNewAvailable1());
		
		}
		logger.debug(total);
		sf.setTotalAvailableQuantity7(Integer.toString(total));
		logger.debug("spare1Action:defaultMethod---------->");
		return mapping.findForward("load");
}

public ActionForward listRates8Method(ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {
	PaintIssueVO vo=new PaintIssueVO();
		ArrayList list=new ArrayList();
		PaintForm sf=(PaintForm)form;
		sf.setOldAvailable8(null);
		sf.setOldRate8(null);
		sf.setNewAvailable8(null);
		sf.setNewRate8(null);
		sf.setTotalAvailableQuantity8(null);
		int compid=Integer.parseInt(sf.getPaintType8());
		int pid=Integer.parseInt(sf.getPaintColor8());
		logger.debug("partnumber id"+pid);
		list=paintserv.fetchRateValue1(compid,pid);
		for(int i=0;i<list.size();i++)
		{
			
			vo=(PaintIssueVO)list.get(i);
			logger.debug("spare values"+vo.getOldAvailable1()+""+vo.getNewAvailable1()+""+vo.getOldRate1()+""+vo.getNewRate1());
			sf.setOldAvailable8(vo.getOldAvailable1());
			sf.setNewAvailable8(vo.getNewAvailable1());
			sf.setOldRate8((vo.getOldRate1()).toString());
			sf.setNewRate8((vo.getNewRate1()).toString());
			total=Integer.parseInt(vo.getOldAvailable1())+Integer.parseInt(vo.getNewAvailable1());
		
		}
		logger.debug(total);
		sf.setTotalAvailableQuantity8(Integer.toString(total));
		logger.debug("spare1Action:defaultMethod---------->");
		return mapping.findForward("load");
}


public ActionForward listRates9Method(ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {
	PaintIssueVO vo=new PaintIssueVO();
		ArrayList list=new ArrayList();
		PaintForm sf=(PaintForm)form;
		sf.setOldAvailable9(null);
		sf.setOldRate9(null);
		sf.setNewAvailable9(null);
		sf.setNewRate9(null);
		sf.setTotalAvailableQuantity9(null);
		int compid=Integer.parseInt(sf.getPaintType9());
		int pid=Integer.parseInt(sf.getPaintColor9());
		logger.debug("partnumber id"+pid);
		list=paintserv.fetchRateValue1(compid,pid);
		for(int i=0;i<list.size();i++)
		{
			
			vo=(PaintIssueVO)list.get(i);
			logger.debug("spare values"+vo.getOldAvailable1()+""+vo.getNewAvailable1()+""+vo.getOldRate1()+""+vo.getNewRate1());
			sf.setOldAvailable9(vo.getOldAvailable1());
			sf.setNewAvailable9(vo.getNewAvailable1());
			sf.setOldRate9((vo.getOldRate1()).toString());
			sf.setNewRate9((vo.getNewRate1()).toString());
			total=Integer.parseInt(vo.getOldAvailable1())+Integer.parseInt(vo.getNewAvailable1());
		
		}
		logger.debug(total);
		sf.setTotalAvailableQuantity9(Integer.toString(total));
		logger.debug("spare1Action:defaultMethod---------->");
		return mapping.findForward("load");
}

/**
 * 
 * @param mapping
 * @param form
 * @param request
 * @param response
 * @return
 * @throws Exception
 */
public ActionForward listRates10Method(ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {
		PaintIssueVO vo=new PaintIssueVO();
		ArrayList list=new ArrayList();
		PaintForm sf=(PaintForm)form;
		sf.setOldAvailable10(null);
		sf.setOldRate10(null);
		sf.setNewAvailable10(null);
		sf.setNewRate10(null);
		sf.setTotalAvailableQuantity10(null);
		int compid=Integer.parseInt(sf.getPaintType10());
		int pid=Integer.parseInt(sf.getPaintColor10());
		logger.debug("partnumber id"+pid);
		list=paintserv.fetchRateValue1(compid,pid);
		for(int i=0;i<list.size();i++)
		{
			
			vo=(PaintIssueVO)list.get(i);
			logger.debug("spare values"+vo.getOldAvailable1()+""+vo.getNewAvailable1()+""+vo.getOldRate1()+""+vo.getNewRate1());
			sf.setOldAvailable10(vo.getOldAvailable1());
			sf.setNewAvailable10(vo.getNewAvailable1());
			sf.setOldRate10((vo.getOldRate1()).toString());
			sf.setNewRate10((vo.getNewRate1()).toString());
			total=Integer.parseInt(vo.getOldAvailable1())+Integer.parseInt(vo.getNewAvailable1());
		
		}
		logger.debug(total);
		sf.setTotalAvailableQuantity10(Integer.toString(total));
		logger.debug("spare1Action:defaultMethod---------->");
		return mapping.findForward("load");
}


public void updateValues(int jobid,ActionForm form)
{

	PaintForm sf=(PaintForm)form;
int compid;
int colorid;

if(!StringUtils.isEmpty(sf.getWantedQuantity1()))
		{
	
		compid=Integer.parseInt(sf.getPaintType1());
		colorid=Integer.parseInt(sf.getPaintColor1());
		res_list1=paintserv.fetchRateValue1(compid,colorid);
		PaintIssueVO vo=new PaintIssueVO();
		vo=(PaintIssueVO)res_list1.get(0);
		if(Integer.parseInt(vo.getOldAvailable1())==0 && Integer.parseInt(vo.getNewAvailable1())!=0 )
		{
			oldavail=Integer.parseInt(vo.getNewAvailable1());
			newavail=0;
			oldrate=Float.parseFloat(vo.getNewRate1());
			newrate=0;
		}
		else if(Integer.parseInt(vo.getOldAvailable1())!=0 && Integer.parseInt(vo.getNewAvailable1())==0 )
		{
			oldavail=Integer.parseInt(vo.getOldAvailable1());
			newavail=0;
			oldrate=Float.parseFloat(vo.getOldRate1());
			newrate=0;
		}
		else if(Integer.parseInt(vo.getOldAvailable1())==0 && Integer.parseInt(vo.getNewAvailable1())==0 )
		{
			oldavail=0;
			newavail=0;
			oldrate=0;
			newrate=0;
		}
		else if(Integer.parseInt(vo.getOldAvailable1())!=0 && Integer.parseInt(vo.getNewAvailable1())!=0 )
		{
			oldavail=Integer.parseInt(vo.getOldAvailable1());
			newavail=Integer.parseInt(vo.getNewAvailable1());
			oldrate=Float.parseFloat(vo.getOldRate1());
			newrate=Float.parseFloat(vo.getNewRate1());
		}
		paintserv.updateValues(compid,colorid,oldavail,newavail,oldrate,newrate);
		}
if(!StringUtils.isEmpty(sf.getWantedQuantity2()))
{

	compid=Integer.parseInt(sf.getPaintType2());
	colorid=Integer.parseInt(sf.getPaintColor2());
	res_list1=paintserv.fetchRateValue1(compid,colorid);
	PaintIssueVO vo=new PaintIssueVO();
	vo=(PaintIssueVO)res_list1.get(0);
if(Integer.parseInt(vo.getOldAvailable1())==0 && Integer.parseInt(vo.getNewAvailable1())!=0 )
{
	oldavail=Integer.parseInt(vo.getNewAvailable1());
	newavail=0;
	oldrate=Float.parseFloat(vo.getNewRate1());
	newrate=0;
}
else if(Integer.parseInt(vo.getOldAvailable1())!=0 && Integer.parseInt(vo.getNewAvailable1())==0 )
{
	oldavail=Integer.parseInt(vo.getOldAvailable1());
	newavail=0;
	oldrate=Float.parseFloat(vo.getOldRate1());
	newrate=0;
}
else if(Integer.parseInt(vo.getOldAvailable1())==0 && Integer.parseInt(vo.getNewAvailable1())==0 )
{
	oldavail=0;
	newavail=0;
	oldrate=0;
	newrate=0;
}
else if(Integer.parseInt(vo.getOldAvailable1())!=0 && Integer.parseInt(vo.getNewAvailable1())!=0 )
{
	oldavail=Integer.parseInt(vo.getOldAvailable1());
	newavail=Integer.parseInt(vo.getNewAvailable1());
	oldrate=Float.parseFloat(vo.getOldRate1());
	newrate=Float.parseFloat(vo.getNewRate1());
}
paintserv.updateValues(compid,colorid,oldavail,newavail,oldrate,newrate);
}

if(!StringUtils.isEmpty(sf.getWantedQuantity3()))
{

	compid=Integer.parseInt(sf.getPaintType3());
	colorid=Integer.parseInt(sf.getPaintColor3());
	res_list1=paintserv.fetchRateValue1(compid,colorid);
	PaintIssueVO vo=new PaintIssueVO();
	vo=(PaintIssueVO)res_list1.get(0);
if(Integer.parseInt(vo.getOldAvailable1())==0 && Integer.parseInt(vo.getNewAvailable1())!=0 )
{
	oldavail=Integer.parseInt(vo.getNewAvailable1());
	newavail=0;
	oldrate=Float.parseFloat(vo.getNewRate1());
	newrate=0;
}
else if(Integer.parseInt(vo.getOldAvailable1())!=0 && Integer.parseInt(vo.getNewAvailable1())==0 )
{
	oldavail=Integer.parseInt(vo.getOldAvailable1());
	newavail=0;
	oldrate=Float.parseFloat(vo.getOldRate1());
	newrate=0;
}
else if(Integer.parseInt(vo.getOldAvailable1())==0 && Integer.parseInt(vo.getNewAvailable1())==0 )
{
	oldavail=0;
	newavail=0;
	oldrate=0;
	newrate=0;
}
else if(Integer.parseInt(vo.getOldAvailable1())!=0 && Integer.parseInt(vo.getNewAvailable1())!=0 )
{
	oldavail=Integer.parseInt(vo.getOldAvailable1());
	newavail=Integer.parseInt(vo.getNewAvailable1());
	oldrate=Float.parseFloat(vo.getOldRate1());
	newrate=Float.parseFloat(vo.getNewRate1());
}
paintserv.updateValues(compid,colorid,oldavail,newavail,oldrate,newrate);
}


if(!StringUtils.isEmpty(sf.getWantedQuantity4()))
{

	compid=Integer.parseInt(sf.getPaintType4());
	colorid=Integer.parseInt(sf.getPaintColor4());
	res_list1=paintserv.fetchRateValue1(compid,colorid);
	PaintIssueVO vo=new PaintIssueVO();
	vo=(PaintIssueVO)res_list1.get(0);
if(Integer.parseInt(vo.getOldAvailable1())==0 && Integer.parseInt(vo.getNewAvailable1())!=0 )
{
	oldavail=Integer.parseInt(vo.getNewAvailable1());
	newavail=0;
	oldrate=Float.parseFloat(vo.getNewRate1());
	newrate=0;
}
else if(Integer.parseInt(vo.getOldAvailable1())!=0 && Integer.parseInt(vo.getNewAvailable1())==0 )
{
	oldavail=Integer.parseInt(vo.getOldAvailable1());
	newavail=0;
	oldrate=Float.parseFloat(vo.getOldRate1());
	newrate=0;
}
else if(Integer.parseInt(vo.getOldAvailable1())==0 && Integer.parseInt(vo.getNewAvailable1())==0 )
{
	oldavail=0;
	newavail=0;
	oldrate=0;
	newrate=0;
}
else if(Integer.parseInt(vo.getOldAvailable1())!=0 && Integer.parseInt(vo.getNewAvailable1())!=0 )
{
	oldavail=Integer.parseInt(vo.getOldAvailable1());
	newavail=Integer.parseInt(vo.getNewAvailable1());
	oldrate=Float.parseFloat(vo.getOldRate1());
	newrate=Float.parseFloat(vo.getNewRate1());
}
paintserv.updateValues(compid,colorid,oldavail,newavail,oldrate,newrate);
}


if(!StringUtils.isEmpty(sf.getWantedQuantity5()))
{

	compid=Integer.parseInt(sf.getPaintType5());
	colorid=Integer.parseInt(sf.getPaintColor5());
	res_list1=paintserv.fetchRateValue1(compid,colorid);
	PaintIssueVO vo=new PaintIssueVO();
	vo=(PaintIssueVO)res_list1.get(0);
if(Integer.parseInt(vo.getOldAvailable1())==0 && Integer.parseInt(vo.getNewAvailable1())!=0 )
{
	oldavail=Integer.parseInt(vo.getNewAvailable1());
	newavail=0;
	oldrate=Float.parseFloat(vo.getNewRate1());
	newrate=0;
}
else if(Integer.parseInt(vo.getOldAvailable1())!=0 && Integer.parseInt(vo.getNewAvailable1())==0 )
{
	oldavail=Integer.parseInt(vo.getOldAvailable1());
	newavail=0;
	oldrate=Float.parseFloat(vo.getOldRate1());
	newrate=0;
}
else if(Integer.parseInt(vo.getOldAvailable1())==0 && Integer.parseInt(vo.getNewAvailable1())==0 )
{
	oldavail=0;
	newavail=0;
	oldrate=0;
	newrate=0;
}
else if(Integer.parseInt(vo.getOldAvailable1())!=0 && Integer.parseInt(vo.getNewAvailable1())!=0 )
{
	oldavail=Integer.parseInt(vo.getOldAvailable1());
	newavail=Integer.parseInt(vo.getNewAvailable1());
	oldrate=Float.parseFloat(vo.getOldRate1());
	newrate=Float.parseFloat(vo.getNewRate1());
}
paintserv.updateValues(compid,colorid,oldavail,newavail,oldrate,newrate);
}


if(!StringUtils.isEmpty(sf.getWantedQuantity6()))
{

	compid=Integer.parseInt(sf.getPaintType6());
	colorid=Integer.parseInt(sf.getPaintColor6());
	res_list1=paintserv.fetchRateValue1(compid,colorid);
	PaintIssueVO vo=new PaintIssueVO();
	vo=(PaintIssueVO)res_list1.get(0);
if(Integer.parseInt(vo.getOldAvailable1())==0 && Integer.parseInt(vo.getNewAvailable1())!=0 )
{
	oldavail=Integer.parseInt(vo.getNewAvailable1());
	newavail=0;
	oldrate=Float.parseFloat(vo.getNewRate1());
	newrate=0;
}
else if(Integer.parseInt(vo.getOldAvailable1())!=0 && Integer.parseInt(vo.getNewAvailable1())==0 )
{
	oldavail=Integer.parseInt(vo.getOldAvailable1());
	newavail=0;
	oldrate=Float.parseFloat(vo.getOldRate1());
	newrate=0;
}
else if(Integer.parseInt(vo.getOldAvailable1())==0 && Integer.parseInt(vo.getNewAvailable1())==0 )
{
	oldavail=0;
	newavail=0;
	oldrate=0;
	newrate=0;
}
else if(Integer.parseInt(vo.getOldAvailable1())!=0 && Integer.parseInt(vo.getNewAvailable1())!=0 )
{
	oldavail=Integer.parseInt(vo.getOldAvailable1());
	newavail=Integer.parseInt(vo.getNewAvailable1());
	oldrate=Float.parseFloat(vo.getOldRate1());
	newrate=Float.parseFloat(vo.getNewRate1());
}
paintserv.updateValues(compid,colorid,oldavail,newavail,oldrate,newrate);
}

if(!StringUtils.isEmpty(sf.getWantedQuantity7()))
{

	compid=Integer.parseInt(sf.getPaintType7());
	colorid=Integer.parseInt(sf.getPaintColor7());
	res_list1=paintserv.fetchRateValue1(compid,colorid);
	PaintIssueVO vo=new PaintIssueVO();
	vo=(PaintIssueVO)res_list1.get(0);
if(Integer.parseInt(vo.getOldAvailable1())==0 && Integer.parseInt(vo.getNewAvailable1())!=0 )
{
	oldavail=Integer.parseInt(vo.getNewAvailable1());
	newavail=0;
	oldrate=Float.parseFloat(vo.getNewRate1());
	newrate=0;
}
else if(Integer.parseInt(vo.getOldAvailable1())!=0 && Integer.parseInt(vo.getNewAvailable1())==0 )
{
	oldavail=Integer.parseInt(vo.getOldAvailable1());
	newavail=0;
	oldrate=Float.parseFloat(vo.getOldRate1());
	newrate=0;
}
else if(Integer.parseInt(vo.getOldAvailable1())==0 && Integer.parseInt(vo.getNewAvailable1())==0 )
{
	oldavail=0;
	newavail=0;
	oldrate=0;
	newrate=0;
}
else if(Integer.parseInt(vo.getOldAvailable1())!=0 && Integer.parseInt(vo.getNewAvailable1())!=0 )
{
	oldavail=Integer.parseInt(vo.getOldAvailable1());
	newavail=Integer.parseInt(vo.getNewAvailable1());
	oldrate=Float.parseFloat(vo.getOldRate1());
	newrate=Float.parseFloat(vo.getNewRate1());
}
paintserv.updateValues(compid,colorid,oldavail,newavail,oldrate,newrate);
}
if(!StringUtils.isEmpty(sf.getWantedQuantity8()))
{

	compid=Integer.parseInt(sf.getPaintType8());
	colorid=Integer.parseInt(sf.getPaintColor8());
	res_list1=paintserv.fetchRateValue1(compid,colorid);
	PaintIssueVO vo=new PaintIssueVO();
	vo=(PaintIssueVO)res_list1.get(0);
if(Integer.parseInt(vo.getOldAvailable1())==0 && Integer.parseInt(vo.getNewAvailable1())!=0 )
{
	oldavail=Integer.parseInt(vo.getNewAvailable1());
	newavail=0;
	oldrate=Float.parseFloat(vo.getNewRate1());
	newrate=0;
}
else if(Integer.parseInt(vo.getOldAvailable1())!=0 && Integer.parseInt(vo.getNewAvailable1())==0 )
{
	oldavail=Integer.parseInt(vo.getOldAvailable1());
	newavail=0;
	oldrate=Float.parseFloat(vo.getOldRate1());
	newrate=0;
}
else if(Integer.parseInt(vo.getOldAvailable1())==0 && Integer.parseInt(vo.getNewAvailable1())==0 )
{
	oldavail=0;
	newavail=0;
	oldrate=0;
	newrate=0;
}
else if(Integer.parseInt(vo.getOldAvailable1())!=0 && Integer.parseInt(vo.getNewAvailable1())!=0 )
{
	oldavail=Integer.parseInt(vo.getOldAvailable1());
	newavail=Integer.parseInt(vo.getNewAvailable1());
	oldrate=Float.parseFloat(vo.getOldRate1());
	newrate=Float.parseFloat(vo.getNewRate1());
}
paintserv.updateValues(compid,colorid,oldavail,newavail,oldrate,newrate);
}

if(!StringUtils.isEmpty(sf.getWantedQuantity9()))
{

	compid=Integer.parseInt(sf.getPaintType9());
	colorid=Integer.parseInt(sf.getPaintColor9());
	res_list1=paintserv.fetchRateValue1(compid,colorid);
	PaintIssueVO vo=new PaintIssueVO();
	vo=(PaintIssueVO)res_list1.get(0);
if(Integer.parseInt(vo.getOldAvailable1())==0 && Integer.parseInt(vo.getNewAvailable1())!=0 )
{
	oldavail=Integer.parseInt(vo.getNewAvailable1());
	newavail=0;
	oldrate=Float.parseFloat(vo.getNewRate1());
	newrate=0;
}
else if(Integer.parseInt(vo.getOldAvailable1())!=0 && Integer.parseInt(vo.getNewAvailable1())==0 )
{
	oldavail=Integer.parseInt(vo.getOldAvailable1());
	newavail=0;
	oldrate=Float.parseFloat(vo.getOldRate1());
	newrate=0;
}
else if(Integer.parseInt(vo.getOldAvailable1())==0 && Integer.parseInt(vo.getNewAvailable1())==0 )
{
	oldavail=0;
	newavail=0;
	oldrate=0;
	newrate=0;
}
else if(Integer.parseInt(vo.getOldAvailable1())!=0 && Integer.parseInt(vo.getNewAvailable1())!=0 )
{
	oldavail=Integer.parseInt(vo.getOldAvailable1());
	newavail=Integer.parseInt(vo.getNewAvailable1());
	oldrate=Float.parseFloat(vo.getOldRate1());
	newrate=Float.parseFloat(vo.getNewRate1());
}
paintserv.updateValues(compid,colorid,oldavail,newavail,oldrate,newrate);
}

if(!StringUtils.isEmpty(sf.getWantedQuantity10()))
{

	compid=Integer.parseInt(sf.getPaintType10());
	colorid=Integer.parseInt(sf.getPaintColor10());
	res_list1=paintserv.fetchRateValue1(compid,colorid);
	PaintIssueVO vo=new PaintIssueVO();
	vo=(PaintIssueVO)res_list1.get(0);
if(Integer.parseInt(vo.getOldAvailable1())==0 && Integer.parseInt(vo.getNewAvailable1())!=0 )
{
	oldavail=Integer.parseInt(vo.getNewAvailable1());
	newavail=0;
	oldrate=Float.parseFloat(vo.getNewRate1());
	newrate=0;
}
else if(Integer.parseInt(vo.getOldAvailable1())!=0 && Integer.parseInt(vo.getNewAvailable1())==0 )
{
	oldavail=Integer.parseInt(vo.getOldAvailable1());
	newavail=0;
	oldrate=Float.parseFloat(vo.getOldRate1());
	newrate=0;
}
else if(Integer.parseInt(vo.getOldAvailable1())==0 && Integer.parseInt(vo.getNewAvailable1())==0 )
{
	oldavail=0;
	newavail=0;
	oldrate=0;
	newrate=0;
}
else if(Integer.parseInt(vo.getOldAvailable1())!=0 && Integer.parseInt(vo.getNewAvailable1())!=0 )
{
	oldavail=Integer.parseInt(vo.getOldAvailable1());
	newavail=Integer.parseInt(vo.getNewAvailable1());
	oldrate=Float.parseFloat(vo.getOldRate1());
	newrate=Float.parseFloat(vo.getNewRate1());
}
paintserv.updateValues(compid,colorid,oldavail,newavail,oldrate,newrate);
}
}

}
