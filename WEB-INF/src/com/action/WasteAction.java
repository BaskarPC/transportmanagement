package com.action;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.formbean.KeroseneForm;
import com.formbean.WasteForm;
import com.service.KeroseneIssueService;
import com.service.SparepartsService;
import com.service.WasteService;
import com.vo.KeroseneIssueVO;
import com.vo.SparePartsFormVO;
import com.vo.WasteVO;
import com.wf.arrayList;
import com.wf.job;




public class WasteAction extends BaseDispatchAction{
	private static final Logger logger=(Logger)Logger.getLogger(WasteAction.class);
	job jb=new job();
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
	int oldavail;
	int newavail;
	float oldrate;
	float newrate;
	KeroseneIssueService keroseneservice=new KeroseneIssueService();
	ArrayList res_list=new ArrayList();
	ArrayList res_list1=new ArrayList();
	SparepartsService ss=new SparepartsService();
	
	
	public ActionForward defaultMethod(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {
		KeroseneIssueVO vo=new KeroseneIssueVO();
		WasteForm sf=(WasteForm)form;
		ArrayList reasonList;
		arrayList list=new arrayList();
		list.dropdownList(form);
		WasteService wasteservice=new WasteService();
		reasonList=wasteservice.fetchWasteReason();
		logger.debug("action in"+reasonList.size());
		sf.setReasonList(reasonList);
		reasonList=keroseneservice.fetchRates("P7");
		vo=(KeroseneIssueVO)reasonList.get(0);
		sf.setOldAvailable(vo.getOldAvailable());
		sf.setNewAvailable(vo.getNewAvailable());
		sf.setOldRate(vo.getOldRate());
		sf.setNewRate(vo.getNewRate());
		int total=Integer.parseInt(vo.getOldAvailable())+Integer.parseInt(vo.getNewAvailable());
		sf.setTotalAvailableQuantity(Integer.toString(total));
		return mapping.findForward("load");
		
	}
	
	// to create the job and task
	
	public ActionForward jobMethod(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {
		
		// gets the form name and passes it to create job and tasks
		
		String reqName="WasteClothIssue";
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
		logger.debug("inserted in waste form"+jobid);
		insertvalues(jobid,form);
		logger.debug("insert executed for Job and Task");
		return mapping.findForward("load");
	
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
		logger.debug("inside approve method");
		int job=(Integer)session.getAttribute("jobseq");
		logger.debug("job in approve"+job);
		int task=(Integer)session.getAttribute("taskseqseq");
		logger.debug("task in approve"+task);
		jb.approveStatus(job,task);
		logger.debug("Updated after approve");
		return mapping.findForward("load");
	}
	
	public ActionForward okMethod(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {
		
		// have to pass the jobid,taskid to change the status to 2 for the issue task
		
		HttpSession session = ((HttpServletRequest) request).getSession();
		logger.debug("inside approve method");
		int job=(Integer)session.getAttribute("jobseq");
		logger.debug("job in ok method"+job);
		int task=(Integer)session.getAttribute("taskseqseq");
		logger.debug("task in ok method"+task);
		jb.okStatus(job,task);
		logger.debug("Updated after ok method");
		updateValues(job,form);
		return mapping.findForward("load");
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
			WasteForm sf=(WasteForm)form;
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
			ArrayList reasonList;
			arrayList list1=new arrayList();
			list1.dropdownList(form);
			WasteService wasteservice=new WasteService();
			reasonList=wasteservice.fetchWasteReason();
			logger.debug("action in"+reasonList.size());
			ArrayList list=new ArrayList();
			WasteForm sf=(WasteForm)form;
			int instname=Integer.parseInt(sf.getInstitutionName());
			int type=Integer.parseInt(sf.getVehicleType());
			
			list=ss.fetchVehicleNumber(type,instname);
			sf.setVehicleNumberList(list);
			sf.setReasonList(reasonList);
			logger.debug("spare1Action:defaultMethod---------->");
			return mapping.findForward("load");
	}
	
	
	/**
	 * to insert the values in table
	 * @param jobid
	 * @param form
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 */
	public void insertvalues(int jobid,ActionForm form) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException
	{
		logger.debug("inserted in waste form"+jobid);
		WasteForm sf=(WasteForm)form;
		WasteVO kvo=new WasteVO();
		PropertyUtils.copyProperties(kvo,sf);
		try
	    {
			WasteService ss=new WasteService();
			ss.insertValues(kvo,jobid);
	   		logger.debug("inserted");
	    }
	    catch(Exception e)
	    {
	    	logger.debug("error"+e);
	    }
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
	public ActionForward qtyUpdateMethod(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {
		WasteForm sf=(WasteForm)form;
		
		if(!StringUtils.isEmpty(sf.getOldAvailable()))
		{
		oldAvailable=Integer.parseInt(sf.getOldAvailable());
		oldRate=Float.parseFloat(sf.getOldRate());
		}
		if(!StringUtils.isEmpty(sf.getNewAvailable()))
		{
		newAvailable=Integer.parseInt(sf.getNewAvailable());
		newRate=Float.parseFloat(sf.getNewRate());
		}
		int total=Integer.parseInt(sf.getTotalAvailableQuantity());
		logger.debug("total quantity Available"+total);
		int qtywanted=Integer.parseInt(sf.getRequiredQuantity());
		if(total<qtywanted)
		{
			temp=0;
			//append in needed spares
		}
		else if(total>=qtywanted)
		{	
			if(Integer.parseInt(sf.getOldAvailable())!=0)
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
				ss.updateOldQuantityValues(3,oldtemp);
			}
			else if(Integer.parseInt(sf.getOldAvailable())==0)
			{
				if((oldAvailable-qtywanted)<0)
				{
					temp=qtywanted-oldAvailable;
					oldtemp=0;
					totaloldRate=oldAvailable*oldRate;
					
				}
			}
			if(Integer.parseInt(sf.getNewAvailable())!=0)
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
					ss.updateNewQuantityValues(3,newtemp);
				}
			}
		}
		totalRate=totaloldRate+totalnewRate;
		
		sf.setTotalAmount(Float.toString(totalRate));
		int rem=total-qtywanted;
		sf.setRemainingQuantity(Integer.toString(rem));
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
		ArrayList reasonList;
		KeroseneIssueVO kvo=new KeroseneIssueVO();
		WasteForm sf=(WasteForm)form;
		arrayList list=new arrayList();
		list.dropdownList(form);
		KeroseneIssueService keroseneservice=new KeroseneIssueService();
		reasonList=keroseneservice.fetchKeroseneReason();
		sf.setReasonList(reasonList);
		KeroseneIssueVO vo=new KeroseneIssueVO();
		
		HttpSession session = ((HttpServletRequest) request).getSession();
		int job=(Integer)session.getAttribute("jobseq");
		
	    res_list=keroseneservice.fetchValues(job);
	    kvo=(KeroseneIssueVO)res_list.get(0);
	    
	    sf.setInstitutionName(kvo.getInstitutionName());
	    sf.setVehicleType(kvo.getVehicleType());
	    sf.setVehicleNumber(kvo.getVehicleNumber());
	    sf.setBillNumber(kvo.getBillNumber());
	    sf.setDriverName(kvo.getDriverName());
	    sf.setRequestedDriverName(kvo.getRequestedDriverName());
	    sf.setOtherPurpose(kvo.getOtherPurpose());
	    sf.setTotalAvailableQuantity(kvo.getTotalAvailableQuantity());
	    sf.setRequiredQuantity(kvo.getRequiredQuantity());
	    sf.setOldAvailable(kvo.getOldAvailable());
	    sf.setNewAvailable(kvo.getNewAvailable());
	    sf.setOldRate(kvo.getOldRate());
	    sf.setNewRate(kvo.getNewRate());
	    sf.setTotalAmount(kvo.getTotalAmount());
	    sf.setCurrentKm(kvo.getCurrentKm());
	    sf.setWasteReason(kvo.getKeroseneReason());
	    logger.debug("select command executed"+res_list.size());
	    return mapping.findForward("load");
	}
	
	
	public void updateValues(int jobid,ActionForm form)
	{

		WasteForm sf=(WasteForm)form;
	String pid;

	if(!StringUtils.isEmpty(sf.getRequiredQuantity()))
			{
		
			pid="P7";
			res_list1=keroseneservice.fetchRates(pid);
			KeroseneIssueVO vo=new KeroseneIssueVO();
			vo=(KeroseneIssueVO)res_list1.get(0);
			if(Integer.parseInt(vo.getOldAvailable())==0 && Integer.parseInt(vo.getNewAvailable())!=0 )
			{
				oldavail=Integer.parseInt(vo.getNewAvailable());
				newavail=0;
				oldrate=Float.parseFloat(vo.getNewRate());
				newrate=0;
			}
			else if(Integer.parseInt(vo.getOldAvailable())!=0 && Integer.parseInt(vo.getNewAvailable())==0 )
			{
				oldavail=Integer.parseInt(vo.getOldAvailable());
				newavail=0;
				oldrate=Float.parseFloat(vo.getOldRate());
				newrate=0;
			}
			else if(Integer.parseInt(vo.getOldAvailable())==0 && Integer.parseInt(vo.getNewAvailable())==0 )
			{
				oldavail=0;
				newavail=0;
				oldrate=0;
				newrate=0;
			}
			else if(Integer.parseInt(vo.getOldAvailable())!=0 && Integer.parseInt(vo.getNewAvailable())!=0 )
			{
				oldavail=Integer.parseInt(vo.getOldAvailable());
				newavail=Integer.parseInt(vo.getNewAvailable());
				oldrate=Float.parseFloat(vo.getOldRate());
				newrate=Float.parseFloat(vo.getNewRate());
			}
			//ss.updateValues(pid,oldavail,newavail,oldrate,newrate);
			}
	}
	
}
