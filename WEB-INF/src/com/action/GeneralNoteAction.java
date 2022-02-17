package com.action;

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

import com.formbean.GeneralNoteForm;
import com.formbean.GreaseForm;
import com.service.GeneralNoteService;
import com.util.GeneralNoteUtil;
import com.vo.GeneralNoteVO;
import com.vo.GreaseVO;
import com.wf.*;



public class GeneralNoteAction extends BaseDispatchAction{
	private static final Logger logger=(Logger)Logger.getLogger(GeneralNoteAction.class);
	GeneralNoteService generalnoteservice=new GeneralNoteService();
	job jb=new job();
	int jobid;
	GeneralNoteVO vo=new GeneralNoteVO();
	GeneralNoteVO vo1=new GeneralNoteVO();
	GeneralNoteVO vo2=new GeneralNoteVO();
	GeneralNoteVO generalvo=new GeneralNoteVO();
	GeneralNoteVO greasedescvo=new GeneralNoteVO();
	GeneralNoteUtil generalnoteutil=new GeneralNoteUtil();
	
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
	
	GeneralNoteForm generalnoteform=(GeneralNoteForm)form;
	ArrayList instList=new ArrayList();
	ArrayList generalNoteList=new ArrayList();
	instList=generalnoteservice.fetchInst();
	generalnoteform.setInstList(instList);
	generalNoteList=generalnoteservice.fetchGeneralNote();
	generalnoteform.setGeneralNoteList(generalNoteList);
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
	ArrayList vehicleTypeList=new ArrayList();
	GeneralNoteForm generalnoteform=(GeneralNoteForm)form;
	int instname=Integer.parseInt(generalnoteform.getInstitutionName());
	vehicleTypeList=generalnoteservice.instMethod(instname);
	generalnoteform.setTypeList(vehicleTypeList);
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
	ArrayList vehicleNumberList=new ArrayList();
	GeneralNoteForm generalnoteform=(GeneralNoteForm)form;
	int vehtype=Integer.parseInt(generalnoteform.getVehicleType());
	vehicleNumberList=generalnoteservice.vehicleMethod(vehtype);
	generalnoteform.setVehicleList(vehicleNumberList);
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
public ActionForward driverMethod(ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {
	ArrayList list=new ArrayList();
	GeneralNoteForm generalnoteform=(GeneralNoteForm)form;
	int vehnum=Integer.parseInt(generalnoteform.getVehicleNumber1());
	return mapping.findForward("load");
}
/**
 * pass required quantity
 * retrieves oldqty,newqty,oldrate,newrate
 * calculates totalamount
 * @param mapping
 * @param form
 * @param request
 * @param response
 * @return
 * @throws Exception
 */
public ActionForward quantityMethod1(ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {
	logger.debug("GreaseAction:quantityMethod1<----------");
	GeneralNoteForm generalnoteform=(GeneralNoteForm)form;
	ArrayList partnumberList=new ArrayList();
	ArrayList generalnotedescList=new ArrayList();
    String itemdescription;
    if(StringUtils.isNotEmpty(generalnoteform.getWantedQuantity1()))
	{
		//qty=Integer.parseInt(generalnoteform.getWantedQuantity1());
		itemdescription=generalnoteform.getItemDescription1();
		generalnotedescList=generalnoteservice.convertToDesc(itemdescription);
		greasedescvo=(GeneralNoteVO)generalnotedescList.get(0);
		partnumberList=generalnoteservice.quantityMethod(greasedescvo.getDriverName());
		generalvo=(GeneralNoteVO)partnumberList.get(0);	
		//amount=Float.parseFloat(generalvo.getTotalAmount1());
		//generalnoteform.setTotalAvailableQuantity1(Float.toString(totalqty));
		
	}
logger.debug("GreaseAction:quantityMethod1---------->");
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
	String reqName="OilIssue";
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

public void saveMethod(int jobid,ActionForm form)
										throws Exception {
	GeneralNoteForm generalnoteform=(GeneralNoteForm)form;
	PropertyUtils.copyProperties(vo,generalnoteform);
	
	ArrayList list2=new ArrayList();
	ArrayList list3=new ArrayList();
	int DRIVER_NAME,REQ_DRIVERNAME;
	int INSTITUTION_NAME=Integer.parseInt(vo.getInstitutionName());
	int VEHICLE_TYPE=Integer.parseInt(vo.getVehicleType());
	int VEHICLE_NUMBER=Integer.parseInt(vo.getVehicleNumber());
	int BILL_NUMBER=Integer.parseInt(vo.getBillNumber());
	String REQ_DATE =vo.getRequestedDate();
	
	String DRIVERNAME=vo.getDriverName();
	DRIVER_NAME=generalnoteservice.convertToCode(DRIVERNAME);

		
	String OTHER_PURPOSE=vo.getOtherPurpose();
	/*list3=generalnoteservice.convertToCode("General");
	vo3=(GeneralNoteVO)list3.get(0);*/
	int GOODS_TYPE=Integer.parseInt(vo.getGeneralNoteId());
	logger.debug("GOODS:"+GOODS_TYPE);
	
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
