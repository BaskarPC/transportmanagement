package com.action;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.formbean.LabourForm;

import com.service.LabourService;
import com.vo.DieselVO;
import com.vo.LabourVO;
import com.wf.job;



public class LabourAction extends BaseDispatchAction{
	private static final Logger logger=(Logger)Logger.getLogger(LabourAction.class);
	
	job jb=new job();
	int jobid;
	LabourVO lvo=new LabourVO();
	LabourVO lvo1=new LabourVO();
	LabourVO lvo2=new LabourVO();
	LabourService labourservice=new LabourService();
	/**
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward defaultMethod(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {
		LabourForm labourform=(LabourForm)form;
		ArrayList instList=new ArrayList();
		ArrayList typeList=new ArrayList();
		ArrayList vehicleList=new ArrayList();
		ArrayList labourList=new ArrayList();
		LabourService labourservice=new LabourService();
		instList=labourservice.fetchInst();
		labourform.setInstList(instList);
		typeList=labourservice.fetchType();
		labourform.setTypeList(typeList);
		vehicleList=labourservice.fetchVehicle();
		labourform.setVehicleList(vehicleList);
		labourList=labourservice.fetchLabour();
		labourform.setLabourList(labourList);
		logger.debug("LabourAction:defaultMethod---------->");
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
	public ActionForward instMethod(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {
		ArrayList list=new ArrayList();
		LabourService labourservice=new LabourService();
		LabourForm labourform=(LabourForm)form;
		int instname=Integer.parseInt(labourform.getInstitutionName());
		list=labourservice.instMethod(instname);
		labourform.setTypeList(list);
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
	
	public ActionForward vehicleMethod(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {
		ArrayList list=new ArrayList();
		LabourService labourservice=new LabourService();
		LabourForm labourform=(LabourForm)form;
		int vehtype=Integer.parseInt(labourform.getVehicleType());
		list=labourservice.vehicleMethod(vehtype);
		labourform.setVehicleList(list);
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
	public ActionForward jobMethod(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {
		String reqName="LabourIssue";
		HttpSession session = ((HttpServletRequest) request).getSession();
		String userName=(String) session.getAttribute("userId");
		logger.debug("session user name :"+userName);
		logger.debug("inside job method");
		String ss1=mapping.getName();
		try{
		jobid=jb.creatJob(ss1,userName,reqName);
		logger.debug("Job ID : "+jobid);
		}
		catch(Exception e)
		{
			logger.debug("error in job"+e);
		}
		logger.debug("job executed");
		saveMethod(jobid,form);
		
		logger.debug("insert executed");
		return mapping.findForward("load");
	
	}
	/**
	 * 
	 * @param jobid
	 * @param form
	 * @throws Exception
	 */
	public void saveMethod(int jobid,ActionForm form)
	throws Exception {
		LabourForm labourform=(LabourForm)form;
		int INSTITUTION_NAME=Integer.parseInt(labourform.getInstitutionName());
		int VEHICLE_TYPE=Integer.parseInt(labourform.getVehicleType());
		int VEHICLE_NUMBER=Integer.parseInt(labourform.getVehicleNumber());
		String REQ_DATE =labourform.getRequestedDate();
		String NOW =labourform.getLabourReason();
		logger.debug("Institution Name,"+INSTITUTION_NAME+VEHICLE_TYPE+VEHICLE_NUMBER);
		logger.debug("Requested Date"+REQ_DATE);
		logger.debug("Requested Date"+NOW);
		float AMOUNT=Float.parseFloat(labourform.getTotalAmount());
		String OTHER_PURPOSE=labourform.getOtherPurpose();
		if(VEHICLE_TYPE==102 && OTHER_PURPOSE!="")
		{
			logger.debug("Other Purpose Entered");
		}
		else if(VEHICLE_TYPE==102 && OTHER_PURPOSE=="")
		{
			logger.debug("Other Purpose Should be Entered");
		}
		else
		{
			OTHER_PURPOSE="null";
		}
		LabourService labourservice=new LabourService();
		labourservice.insertmaster(jobid,INSTITUTION_NAME,VEHICLE_TYPE,VEHICLE_NUMBER,REQ_DATE);
		labourservice.insert(jobid,AMOUNT,NOW,OTHER_PURPOSE);
		
	}
	
	public ActionForward inboxMethod(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {
		LabourForm labourform=(LabourForm)form;
		ArrayList instList=new ArrayList();
		ArrayList typeList=new ArrayList();
		ArrayList vehicleList=new ArrayList();
		
		instList=labourservice.fetchInst();
		labourform.setInstList(instList);
		typeList=labourservice.fetchType();
		labourform.setTypeList(typeList);
		vehicleList=labourservice.fetchVehicle();
		labourform.setVehicleList(vehicleList);
		HttpSession session = ((HttpServletRequest) request).getSession();
		int job=(Integer)session.getAttribute("jobseq");
		ArrayList list2=new ArrayList();
		ArrayList list1=new ArrayList();
	    list1=labourservice.retrieveMaster(job);
	    list2=labourservice.retrieve(job);
	    lvo1=(LabourVO)list1.get(0);
	    lvo2=(LabourVO)list2.get(0);
	    labourform.setRequestedDate(lvo1.getRequestedDate());
	    labourform.setVehicleNumber(lvo1.getVehicleNumber());
	    labourform.setInstitutionName(lvo1.getInstitutionName());
	    labourform.setVehicleType(lvo1.getVehicleType());
	    labourform.setLabourReason(lvo2.getLabourReason());
	    labourform.setTotalAmount(lvo2.getTotalAmount());
	    labourform.setOtherPurpose(lvo2.getOtherPurpose());
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
			return mapping.findForward("inb");
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
			return mapping.findForward("load");
	}
	
}
