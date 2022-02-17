/**
 * ==================================================================================
 * Copyright ©  2009.  ALL RIGHTS RESERVED.
 * Filename: SpareAction.java
 * Purpose:  Application class for the Kongu Transport application
 * Classes:  SpareAction
 *==================================================================================
 */
package com.action;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import com.dbcom.dbcom;
import com.formbean.SparePartsForm;
import com.service.PaintSparepartsRequisitionService;
import com.service.SparepartsService;
import com.vo.SparePartsFormVO;
import com.wf.*;

public class SpareAction extends BaseDispatchAction{
	private static final Logger logger=(Logger)Logger.getLogger(SpareAction.class);
	job jb=new job();
	dbcom db=new dbcom();
	SparepartsService spareservices=new SparepartsService();
	SparePartsFormVO sparevo=new SparePartsFormVO();
	SparePartsFormVO descvo=new SparePartsFormVO();
	SparePartsFormVO qtyvo=new SparePartsFormVO();
	SparePartsFormVO drivernamevo=new SparePartsFormVO();
	
	ArrayList res_list=new ArrayList();
	ArrayList res_list1=new ArrayList();
	ArrayList res_list2=new ArrayList();
	ArrayList res_list3=new ArrayList();
	ArrayList desc_list=new ArrayList();
	ArrayList totalqtyList=new ArrayList();
	
	String itemname="SpareParts";
	String servicestation="KVITT Workshop";
	String serviceplace="Perundurai";
	float qty=0,totalqty=0;
	float amt=0,extra=0;
	float newrate,oldrate=0,xrate=0;
	float newqty,oldqty=0,tnewqty,toldqty=0,xqty=0,qtyissue=0;
	String partnumber=null;
	String itemtype1=null,itemtype2=null,itemtype3=null,itemtype4=null,itemtype5=null;
	String itemtype6=null,itemtype7=null,itemtype8=null,itemtype9=null,itemtype10=null;
	
	int total=0,oldavail,newavail,jobid;
	
	PaintSparepartsRequisitionService spareservice=new PaintSparepartsRequisitionService();
	
	/**
	 * default method
	 */
	public ActionForward defaultMethod(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {
		SparePartsForm sform=(SparePartsForm)form;
		logger.debug("SpareAction:defaultMethod<----------");
		clear(form);
		ArrayList instList=new ArrayList();
		instList=spareservices.fetchInst();
		sform.setInstList(instList);
		res_list=spareservice.fetchTypeValues();
		sform.setItemTypeList(res_list);
		logger.debug("SpareAction:defaultMethod---------->");
		return mapping.findForward("load");
	}
	/**
	 * pass institution name
	 * To retrieve vehicle type for combo
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
		SparePartsForm sform=(SparePartsForm)form;
		logger.debug("DieselAction:instMethod<----------");
		ArrayList instList=new ArrayList();
		int instname=Integer.parseInt(sform.getInstitutionName());
		instList=spareservices.instMethod(instname);
		sform.setTypeList(instList);
		logger.debug("DieselAction:instMethod---------->");
		return mapping.findForward("load");
	}
	/**
	 * pass vehicle type
	 * to retrieve vehicle number and set values in combo
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
		SparePartsForm sform=(SparePartsForm)form;
		logger.debug("DieselAction:vehicleMethod<----------");
		ArrayList vehicleList=new ArrayList();
		int vehtype=Integer.parseInt(sform.getVehicleType());
		vehicleList=spareservices.vehicleMethod(vehtype);
		sform.setVehicleList(vehicleList);
		logger.debug("DieselAction:vehicleMethod---------->");
		return mapping.findForward("load");
		
	}
	/**
	 * pass vehicle number
	 * To retrieve presentkm,drivername and routenumber
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
		SparePartsForm sform=(SparePartsForm)form;
		logger.debug("DieselAction:driverMethod<----------");
		ArrayList driverList=new ArrayList();
		ArrayList drivernameList=new ArrayList();
		int vehnum=Integer.parseInt(sform.getVehicleNumber());
		driverList=spareservices.driverMethod(vehnum);
		sparevo=(SparePartsFormVO)driverList.get(0);
		String driver_name=sparevo.getDriverName();
		drivernameList=spareservices.convertToDesc(driver_name);
		drivernamevo=(SparePartsFormVO)drivernameList.get(0);
		sform.setDriverName(drivernamevo.getDriverName());
		logger.debug("DieselAction:driverMethod---------->");
		return mapping.findForward("load");
	}
	
	/**
	 *  to create the job and task
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
		String reqName="SpareIssue";
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
	 * passes the jobid,taskid to change the status to 2 for the approve task greaseform that form 
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
			int job=(Integer)session.getAttribute("jobseq");
			int task=(Integer)session.getAttribute("taskseqseq");
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
			int job=(Integer)session.getAttribute("jobseq");
			int task=(Integer)session.getAttribute("taskseqseq");
			jb.okStatus(job,task);
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
	SparePartsForm sf=(SparePartsForm)form;
	clear(form);
	arrayList list=new arrayList();
	list.dropdownList(form);
	int instname;	
	int type;
	HttpSession session = ((HttpServletRequest) request).getSession();
	int job=(Integer)session.getAttribute("jobseq");
	
    res_list=spareservices.fetchCommonValues(job);
    logger.debug("select command executed"+res_list.size());
    
    
    SparePartsFormVO vo=new SparePartsFormVO();	
   for(int i=0;i<res_list.size();i++)
    {
    	vo=(SparePartsFormVO)res_list.get(i);
    	logger.debug(vo.getBillNumber());
    	sf.setBillNumber(vo.getBillNumber());
    	logger.debug(vo.getDriverName());
    	sf.setDriverName(vo.getDriverName());
    	sf.setInstitutionName(vo.getInstitutionName());
    	instname=Integer.parseInt(vo.getInstitutionName());
    	res_list3=spareservices.fetchVehicleType(instname);
    	sf.setTypeList(res_list3);
    	sf.setVehicleType(vo.getVehicleType());
    	type=Integer.parseInt(vo.getVehicleType());
    	res_list2=spareservices.fetchVehicleNumber(type,instname);
    	sf.setVehicleList(res_list2);
    	logger.debug("in spare action "+vo.getVehicleNumber()+""+vo.getOtherPurpose());
    	sf.setVehicleNumber(vo.getVehicleNumber());
    	sf.setOtherPurpose(vo.getOtherPurpose());
    	sf.setRequestedDriverName(vo.getRequestedDriverName());
       }
   res_list2=spareservice.fetchTypeValues();
	sf.setItemTypeList(res_list2);
   res_list=spareservices.fetchValues(job);
   logger.debug("select command executed"+res_list.size());
   SparePartsFormVO vo1=new SparePartsFormVO();	
  for(int i=0;i<res_list.size();i++)
  {
	  vo1=(SparePartsFormVO)res_list.get(i);
	  switch(i)
	  {
	  case 0:
		  sf.setItemDescription1(vo1.getItemDescription1());
		//  res_list1=spareservice.fetchNameValues(Integer.parseInt(vo1.getItemDescription1()));
		  sf.setPartList1(res_list1);
		  sf.setPartNumber1(vo1.getPartNumber1());
		  sf.setWantedQuantity1(vo1.getWantedQuantity1());
		  sf.setTotalAvailableQuantity1(vo1.getTotalAvailableQuantity1());
		  sf.setOldAvailable1(vo1.getOldAvailable1());
		  sf.setNewAvailable1(vo1.getNewAvailable1());
		  sf.setOldRate1(vo1.getOldRate1());
		  sf.setNewRate1(vo1.getNewRate1());
		  sf.setTotalAmount1(vo1.getTotalAmount1());
		  break;
	  case 1:
		  sf.setItemDescription2(vo1.getItemDescription1());
		 // res_list1=spareservice.fetchNameValues(Integer.parseInt(vo1.getItemDescription1()));
		  sf.setPartList2(res_list1);
		  sf.setPartNumber2(vo1.getPartNumber1());
		  sf.setWantedQuantity2(vo1.getWantedQuantity1());
		  sf.setTotalAvailableQuantity2(vo1.getTotalAvailableQuantity1());
		  sf.setOldAvailable2(vo1.getOldAvailable1());
		  sf.setNewAvailable2(vo1.getNewAvailable1());
		  sf.setOldRate2(vo1.getOldRate1());
		  sf.setNewRate2(vo1.getNewRate1());
		  sf.setTotalAmount2(vo1.getTotalAmount1());
		  break;
	  case 2:
		  sf.setItemDescription3(vo1.getItemDescription1());
		//  res_list1=spareservice.fetchNameValues(Integer.parseInt(vo1.getItemDescription1()));
		  sf.setPartList3(res_list1);
		  sf.setPartNumber3(vo1.getPartNumber1());
		  sf.setWantedQuantity3(vo1.getWantedQuantity1());
		  sf.setTotalAvailableQuantity3(vo1.getTotalAvailableQuantity1());
		  sf.setOldAvailable3(vo1.getOldAvailable1());
		  sf.setNewAvailable3(vo1.getNewAvailable1());
		  sf.setOldRate3(vo1.getOldRate1());
		  sf.setNewRate3(vo1.getNewRate1());
		  sf.setTotalAmount3(vo1.getTotalAmount1());
		  break;
	  case 3:
		  sf.setItemDescription4(vo1.getItemDescription1());
		//  res_list1=spareservice.fetchNameValues(Integer.parseInt(vo1.getItemDescription1()));
		  sf.setPartList4(res_list1);
		  sf.setPartNumber4(vo1.getPartNumber1());
		  sf.setWantedQuantity4(vo1.getWantedQuantity1());
		  sf.setTotalAvailableQuantity4(vo1.getTotalAvailableQuantity1());
		  sf.setOldAvailable4(vo1.getOldAvailable1());
		  sf.setNewAvailable4(vo1.getNewAvailable1());
		  sf.setOldRate4(vo1.getOldRate1());
		  sf.setNewRate4(vo1.getNewRate1());
		  sf.setTotalAmount4(vo1.getTotalAmount1());
		  break;
	  case 4:
		  sf.setItemDescription5(vo1.getItemDescription1());
		//  res_list1=spareservice.fetchNameValues(Integer.parseInt(vo1.getItemDescription1()));
		  sf.setPartList5(res_list1);
		  sf.setPartNumber5(vo1.getPartNumber1());
		  sf.setWantedQuantity5(vo1.getWantedQuantity1());
		  sf.setTotalAvailableQuantity5(vo1.getTotalAvailableQuantity1());
		  sf.setOldAvailable5(vo1.getOldAvailable1());
		  sf.setNewAvailable5(vo1.getNewAvailable1());
		  sf.setOldRate5(vo1.getOldRate1());
		  sf.setNewRate5(vo1.getNewRate1());
		  sf.setTotalAmount5(vo1.getTotalAmount1());
		  break;
	  case 5:
		  sf.setItemDescription6(vo1.getItemDescription1());
		//  res_list1=spareservice.fetchNameValues(Integer.parseInt(vo1.getItemDescription1()));
		  sf.setPartList5(res_list1);
		  sf.setPartNumber6(vo1.getPartNumber1());
		  sf.setWantedQuantity6(vo1.getWantedQuantity1());
		  sf.setTotalAvailableQuantity6(vo1.getTotalAvailableQuantity1());
		  sf.setOldAvailable6(vo1.getOldAvailable1());
		  sf.setNewAvailable6(vo1.getNewAvailable1());
		  sf.setOldRate6(vo1.getOldRate1());
		  sf.setNewRate6(vo1.getNewRate1());
		  sf.setTotalAmount6(vo1.getTotalAmount1());
		  break;
	  case 6:
		  sf.setItemDescription7(vo1.getItemDescription1());
		//  res_list1=spareservice.fetchNameValues(Integer.parseInt(vo1.getItemDescription1()));
		  sf.setPartList7(res_list1);
		  sf.setPartNumber7(vo1.getPartNumber1());
		  sf.setWantedQuantity7(vo1.getWantedQuantity1());
		  sf.setTotalAvailableQuantity7(vo1.getTotalAvailableQuantity1());
		  sf.setOldAvailable7(vo1.getOldAvailable1());
		  sf.setNewAvailable7(vo1.getNewAvailable1());
		  sf.setOldRate7(vo1.getOldRate1());
		  sf.setNewRate7(vo1.getNewRate1());
		  sf.setTotalAmount7(vo1.getTotalAmount1());
		  break;
	  case 7:
		  sf.setItemDescription8(vo1.getItemDescription1());
		//  res_list1=spareservice.fetchNameValues(Integer.parseInt(vo1.getItemDescription1()));
		  sf.setPartList8(res_list1);
		  sf.setPartNumber8(vo1.getPartNumber1());
		  sf.setWantedQuantity8(vo1.getWantedQuantity1());
		  sf.setTotalAvailableQuantity8(vo1.getTotalAvailableQuantity1());
		  sf.setOldAvailable8(vo1.getOldAvailable1());
		  sf.setNewAvailable8(vo1.getNewAvailable1());
		  sf.setOldRate8(vo1.getOldRate1());
		  sf.setNewRate8(vo1.getNewRate1());
		  sf.setTotalAmount8(vo1.getTotalAmount1());
		  break;
	  case 8:
		  sf.setItemDescription9(vo1.getItemDescription1());
		//  res_list1=spareservice.fetchNameValues(Integer.parseInt(vo1.getItemDescription1()));
		  sf.setPartList9(res_list1);
		  sf.setPartNumber9(vo1.getPartNumber1());
		  sf.setWantedQuantity9(vo1.getWantedQuantity1());
		  sf.setTotalAvailableQuantity9(vo1.getTotalAvailableQuantity1());
		  sf.setOldAvailable9(vo1.getOldAvailable1());
		  sf.setNewAvailable9(vo1.getNewAvailable1());
		  sf.setOldRate9(vo1.getOldRate1());
		  sf.setNewRate9(vo1.getNewRate1());
		  sf.setTotalAmount9(vo1.getTotalAmount1());
		  break;
	  case 9:
		  sf.setItemDescription10(vo1.getItemDescription1());
		//  res_list1=spareservice.fetchNameValues(Integer.parseInt(vo1.getItemDescription1()));
		  sf.setPartList10(res_list1);
		  sf.setPartNumber10(vo1.getPartNumber1());
		  sf.setWantedQuantity10(vo1.getWantedQuantity1());
		  sf.setTotalAvailableQuantity10(vo1.getTotalAvailableQuantity1());
		  sf.setOldAvailable10(vo1.getOldAvailable1());
		  sf.setNewAvailable10(vo1.getNewAvailable1());
		  sf.setOldRate10(vo1.getOldRate1());
		  sf.setNewRate10(vo1.getNewRate1());
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
	SparePartsForm sform=(SparePartsForm)form;
	logger.debug("SpareAction:qtyUpdateMethod1<----------");
	ArrayList partnumberList=new ArrayList();
	ArrayList descList=new ArrayList();
    String sparetype;
    if(StringUtils.isNotEmpty(sform.getWantedQuantity1()))
	{
		qty=Integer.parseInt(sform.getWantedQuantity1());
		sparetype=sform.getPartNumber1();
		descList=spareservices.convertToSpareDesc(sparetype);
		descvo=(SparePartsFormVO)descList.get(0);
		partnumberList=spareservices.quantityMethod(descvo.getDriverName());
		sparevo=(SparePartsFormVO)partnumberList.get(0);	
		oldqty=Float.parseFloat(sparevo.getOldAvailable1());
		newqty=Float.parseFloat(sparevo.getNewAvailable1());
		oldrate=Float.parseFloat(sparevo.getOldRate1());
		newrate=Float.parseFloat(sparevo.getNewRate1());
		totalqty=oldqty+newqty;
		if(qty>totalqty)
		{
			logger.debug("Stock is very lower than required quantity");
		}
		else if(qty<=oldqty)
		{
			sform.setOldAvailable1(Float.toString(qty));
			sform.setOldRate1(Float.toString(oldrate));
			sform.setNewAvailable1(null);
			sform.setNewRate1(null);	
			amt=qty*oldrate;
		}
		else if(qty>oldqty)
		{
			extra=qty-oldqty;
			sform.setOldAvailable1(Float.toString(oldqty));
			sform.setOldRate1(Float.toString(oldrate));
			sform.setNewAvailable1(Float.toString(extra));
			sform.setNewRate1(Float.toString(newrate));
			
			amt=(extra*newrate)+(oldqty*oldrate);
		}
		sform.setTotalAvailableQuantity1(Float.toString(totalqty));
		sform.setTotalAmount1(Float.toString(amt));
	}
    logger.debug("SpareAction:qtyUpdateMethod1---------->");
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
	SparePartsForm sform=(SparePartsForm)form;
	logger.debug("SpareAction:qtyUpdateMethod2<----------");
	ArrayList partnumberList=new ArrayList();
	ArrayList descList=new ArrayList();
    String sparetype;
    if(StringUtils.isNotEmpty(sform.getWantedQuantity2()))
	{
		qty=Integer.parseInt(sform.getWantedQuantity2());
		sparetype=sform.getPartNumber2();
		descList=spareservices.convertToSpareDesc(sparetype);
		descvo=(SparePartsFormVO)descList.get(0);
		partnumberList=spareservices.quantityMethod(descvo.getDriverName());
		sparevo=(SparePartsFormVO)partnumberList.get(0);	
		oldqty=Float.parseFloat(sparevo.getOldAvailable1());
		newqty=Float.parseFloat(sparevo.getNewAvailable1());
		oldrate=Float.parseFloat(sparevo.getOldRate1());
		newrate=Float.parseFloat(sparevo.getNewRate1());
		totalqty=oldqty+newqty;
		if(qty>totalqty)
		{
			logger.debug("Stock is very lower than required quantity");
		}
		else if(qty<=oldqty)
		{
			sform.setOldAvailable2(Float.toString(qty));
			sform.setOldRate2(Float.toString(oldrate));
			sform.setNewAvailable2(null);
			sform.setNewRate2(null);	
			amt=qty*oldrate;
		}
		else if(qty>oldqty)
		{
			extra=qty-oldqty;
			sform.setOldAvailable2(Float.toString(oldqty));
			sform.setOldRate2(Float.toString(oldrate));
			sform.setNewAvailable2(Float.toString(extra));
			sform.setNewRate2(Float.toString(newrate));
			
			amt=(extra*newrate)+(oldqty*oldrate);
		}
		sform.setTotalAvailableQuantity2(Float.toString(totalqty));
		sform.setTotalAmount2(Float.toString(amt));
	}
    logger.debug("SpareAction:qtyUpdateMethod2---------->");
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
	SparePartsForm sform=(SparePartsForm)form;
	logger.debug("SpareAction:qtyUpdateMethod3<----------");
	ArrayList partnumberList=new ArrayList();
	ArrayList descList=new ArrayList();
    String sparetype;
    if(StringUtils.isNotEmpty(sform.getWantedQuantity3()))
	{
		qty=Integer.parseInt(sform.getWantedQuantity3());
		sparetype=sform.getPartNumber3();
		descList=spareservices.convertToSpareDesc(sparetype);
		descvo=(SparePartsFormVO)descList.get(0);
		partnumberList=spareservices.quantityMethod(descvo.getDriverName());
		sparevo=(SparePartsFormVO)partnumberList.get(0);	
		oldqty=Float.parseFloat(sparevo.getOldAvailable1());
		newqty=Float.parseFloat(sparevo.getNewAvailable1());
		oldrate=Float.parseFloat(sparevo.getOldRate1());
		newrate=Float.parseFloat(sparevo.getNewRate1());
		totalqty=oldqty+newqty;
		if(qty>totalqty)
		{
			logger.debug("Stock is very lower than required quantity");
		}
		else if(qty<=oldqty)
		{
			sform.setOldAvailable3(Float.toString(qty));
			sform.setOldRate3(Float.toString(oldrate));
			sform.setNewAvailable3(null);
			sform.setNewRate3(null);	
			amt=qty*oldrate;
		}
		else if(qty>oldqty)
		{
			extra=qty-oldqty;
			sform.setOldAvailable3(Float.toString(oldqty));
			sform.setOldRate3(Float.toString(oldrate));
			sform.setNewAvailable3(Float.toString(extra));
			sform.setNewRate3(Float.toString(newrate));
			
			amt=(extra*newrate)+(oldqty*oldrate);
		}
		sform.setTotalAvailableQuantity3(Float.toString(totalqty));
		sform.setTotalAmount3(Float.toString(amt));
	}
    logger.debug("SpareAction:qtyUpdateMethod3---------->");
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
	SparePartsForm sform=(SparePartsForm)form;
	logger.debug("SpareAction:qtyUpdateMethod4<----------");
	ArrayList partnumberList=new ArrayList();
	ArrayList descList=new ArrayList();
    String sparetype;
    if(StringUtils.isNotEmpty(sform.getWantedQuantity4()))
	{
		qty=Integer.parseInt(sform.getWantedQuantity4());
		sparetype=sform.getPartNumber4();
		descList=spareservices.convertToSpareDesc(sparetype);
		descvo=(SparePartsFormVO)descList.get(0);
		partnumberList=spareservices.quantityMethod(descvo.getDriverName());
		sparevo=(SparePartsFormVO)partnumberList.get(0);	
		oldqty=Float.parseFloat(sparevo.getOldAvailable1());
		newqty=Float.parseFloat(sparevo.getNewAvailable1());
		oldrate=Float.parseFloat(sparevo.getOldRate1());
		newrate=Float.parseFloat(sparevo.getNewRate1());
		totalqty=oldqty+newqty;
		if(qty>totalqty)
		{
			logger.debug("Stock is very lower than required quantity");
		}
		else if(qty<=oldqty)
		{
			sform.setOldAvailable4(Float.toString(qty));
			sform.setOldRate4(Float.toString(oldrate));
			sform.setNewAvailable4(null);
			sform.setNewRate4(null);	
			amt=qty*oldrate;
		}
		else if(qty>oldqty)
		{
			extra=qty-oldqty;
			sform.setOldAvailable4(Float.toString(oldqty));
			sform.setOldRate4(Float.toString(oldrate));
			sform.setNewAvailable4(Float.toString(extra));
			sform.setNewRate4(Float.toString(newrate));
			
			amt=(extra*newrate)+(oldqty*oldrate);
		}
		sform.setTotalAvailableQuantity4(Float.toString(totalqty));
		sform.setTotalAmount4(Float.toString(amt));
	}
    logger.debug("SpareAction:qtyUpdateMethod4---------->");
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
	SparePartsForm sform=(SparePartsForm)form;
	logger.debug("SpareAction:qtyUpdateMethod5<----------");
	ArrayList partnumberList=new ArrayList();
	ArrayList descList=new ArrayList();
    String sparetype;
    if(StringUtils.isNotEmpty(sform.getWantedQuantity5()))
	{
		qty=Integer.parseInt(sform.getWantedQuantity5());
		sparetype=sform.getPartNumber5();
		descList=spareservices.convertToSpareDesc(sparetype);
		descvo=(SparePartsFormVO)descList.get(0);
		partnumberList=spareservices.quantityMethod(descvo.getDriverName());
		sparevo=(SparePartsFormVO)partnumberList.get(0);	
		oldqty=Float.parseFloat(sparevo.getOldAvailable1());
		newqty=Float.parseFloat(sparevo.getNewAvailable1());
		oldrate=Float.parseFloat(sparevo.getOldRate1());
		newrate=Float.parseFloat(sparevo.getNewRate1());
		totalqty=oldqty+newqty;
		if(qty>totalqty)
		{
			logger.debug("Stock is very lower than required quantity");
		}
		else if(qty<=oldqty)
		{
			sform.setOldAvailable5(Float.toString(qty));
			sform.setOldRate5(Float.toString(oldrate));
			sform.setNewAvailable5(null);
			sform.setNewRate5(null);	
			amt=qty*oldrate;
		}
		else if(qty>oldqty)
		{
			extra=qty-oldqty;
			sform.setOldAvailable5(Float.toString(oldqty));
			sform.setOldRate5(Float.toString(oldrate));
			sform.setNewAvailable5(Float.toString(extra));
			sform.setNewRate5(Float.toString(newrate));
			
			amt=(extra*newrate)+(oldqty*oldrate);
		}
		sform.setTotalAvailableQuantity5(Float.toString(totalqty));
		sform.setTotalAmount5(Float.toString(amt));
	}
    logger.debug("SpareAction:qtyUpdateMethod5---------->");
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
	SparePartsForm sform=(SparePartsForm)form;
	logger.debug("SpareAction:qtyUpdateMethod6<----------");
	ArrayList partnumberList=new ArrayList();
	ArrayList descList=new ArrayList();
    String sparetype;
    if(StringUtils.isNotEmpty(sform.getWantedQuantity6()))
	{
		qty=Integer.parseInt(sform.getWantedQuantity6());
		sparetype=sform.getPartNumber6();
		descList=spareservices.convertToSpareDesc(sparetype);
		descvo=(SparePartsFormVO)descList.get(0);
		partnumberList=spareservices.quantityMethod(descvo.getDriverName());
		sparevo=(SparePartsFormVO)partnumberList.get(0);	
		oldqty=Float.parseFloat(sparevo.getOldAvailable1());
		newqty=Float.parseFloat(sparevo.getNewAvailable1());
		oldrate=Float.parseFloat(sparevo.getOldRate1());
		newrate=Float.parseFloat(sparevo.getNewRate1());
		totalqty=oldqty+newqty;
		if(qty>totalqty)
		{
			logger.debug("Stock is very lower than required quantity");
		}
		else if(qty<=oldqty)
		{
			sform.setOldAvailable6(Float.toString(qty));
			sform.setOldRate6(Float.toString(oldrate));
			sform.setNewAvailable6(null);
			sform.setNewRate6(null);	
			amt=qty*oldrate;
		}
		else if(qty>oldqty)
		{
			extra=qty-oldqty;
			sform.setOldAvailable6(Float.toString(oldqty));
			sform.setOldRate6(Float.toString(oldrate));
			sform.setNewAvailable6(Float.toString(extra));
			sform.setNewRate6(Float.toString(newrate));
			
			amt=(extra*newrate)+(oldqty*oldrate);
		}
		sform.setTotalAvailableQuantity6(Float.toString(totalqty));
		sform.setTotalAmount6(Float.toString(amt));
	}
    logger.debug("SpareAction:qtyUpdateMethod6---------->");
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
	SparePartsForm sform=(SparePartsForm)form;
	logger.debug("SpareAction:qtyUpdateMethod7<----------");
	ArrayList partnumberList=new ArrayList();
	ArrayList descList=new ArrayList();
    String sparetype;
    if(StringUtils.isNotEmpty(sform.getWantedQuantity7()))
	{
		qty=Integer.parseInt(sform.getWantedQuantity7());
		sparetype=sform.getPartNumber7();
		descList=spareservices.convertToSpareDesc(sparetype);
		descvo=(SparePartsFormVO)descList.get(0);
		partnumberList=spareservices.quantityMethod(descvo.getDriverName());
		sparevo=(SparePartsFormVO)partnumberList.get(0);	
		oldqty=Float.parseFloat(sparevo.getOldAvailable1());
		newqty=Float.parseFloat(sparevo.getNewAvailable1());
		oldrate=Float.parseFloat(sparevo.getOldRate1());
		newrate=Float.parseFloat(sparevo.getNewRate1());
		totalqty=oldqty+newqty;
		if(qty>totalqty)
		{
			logger.debug("Stock is very lower than required quantity");
		}
		else if(qty<=oldqty)
		{
			sform.setOldAvailable7(Float.toString(qty));
			sform.setOldRate7(Float.toString(oldrate));
			sform.setNewAvailable7(null);
			sform.setNewRate7(null);	
			amt=qty*oldrate;
		}
		else if(qty>oldqty)
		{
			extra=qty-oldqty;
			sform.setOldAvailable7(Float.toString(oldqty));
			sform.setOldRate7(Float.toString(oldrate));
			sform.setNewAvailable7(Float.toString(extra));
			sform.setNewRate7(Float.toString(newrate));
			
			amt=(extra*newrate)+(oldqty*oldrate);
		}
		sform.setTotalAvailableQuantity7(Float.toString(totalqty));
		sform.setTotalAmount7(Float.toString(amt));
	}
    logger.debug("SpareAction:qtyUpdateMethod7---------->");
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
	SparePartsForm sform=(SparePartsForm)form;
	logger.debug("SpareAction:qtyUpdateMethod8<----------");
	ArrayList partnumberList=new ArrayList();
	ArrayList descList=new ArrayList();
    String sparetype;
    if(StringUtils.isNotEmpty(sform.getWantedQuantity8()))
	{
		qty=Integer.parseInt(sform.getWantedQuantity8());
		sparetype=sform.getPartNumber8();
		descList=spareservices.convertToSpareDesc(sparetype);
		descvo=(SparePartsFormVO)descList.get(0);
		partnumberList=spareservices.quantityMethod(descvo.getDriverName());
		sparevo=(SparePartsFormVO)partnumberList.get(0);	
		oldqty=Float.parseFloat(sparevo.getOldAvailable1());
		newqty=Float.parseFloat(sparevo.getNewAvailable1());
		oldrate=Float.parseFloat(sparevo.getOldRate1());
		newrate=Float.parseFloat(sparevo.getNewRate1());
		totalqty=oldqty+newqty;
		if(qty>totalqty)
		{
			logger.debug("Stock is very lower than required quantity");
		}
		else if(qty<=oldqty)
		{
			sform.setOldAvailable8(Float.toString(qty));
			sform.setOldRate8(Float.toString(oldrate));
			sform.setNewAvailable8(null);
			sform.setNewRate8(null);	
			amt=qty*oldrate;
		}
		else if(qty>oldqty)
		{
			extra=qty-oldqty;
			sform.setOldAvailable8(Float.toString(oldqty));
			sform.setOldRate8(Float.toString(oldrate));
			sform.setNewAvailable8(Float.toString(extra));
			sform.setNewRate8(Float.toString(newrate));
			
			amt=(extra*newrate)+(oldqty*oldrate);
		}
		sform.setTotalAvailableQuantity8(Float.toString(totalqty));
		sform.setTotalAmount8(Float.toString(amt));
	}
    logger.debug("SpareAction:qtyUpdateMethod8---------->");
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
	SparePartsForm sform=(SparePartsForm)form;
	logger.debug("SpareAction:qtyUpdateMethod9<----------");
	ArrayList partnumberList=new ArrayList();
	ArrayList descList=new ArrayList();
    String sparetype;
    if(StringUtils.isNotEmpty(sform.getWantedQuantity9()))
	{
		qty=Integer.parseInt(sform.getWantedQuantity9());
		sparetype=sform.getPartNumber9();
		descList=spareservices.convertToSpareDesc(sparetype);
		descvo=(SparePartsFormVO)descList.get(0);
		partnumberList=spareservices.quantityMethod(descvo.getDriverName());
		sparevo=(SparePartsFormVO)partnumberList.get(0);	
		oldqty=Float.parseFloat(sparevo.getOldAvailable1());
		newqty=Float.parseFloat(sparevo.getNewAvailable1());
		oldrate=Float.parseFloat(sparevo.getOldRate1());
		newrate=Float.parseFloat(sparevo.getNewRate1());
		totalqty=oldqty+newqty;
		if(qty>totalqty)
		{
			logger.debug("Stock is very lower than required quantity");
		}
		else if(qty<=oldqty)
		{
			sform.setOldAvailable9(Float.toString(qty));
			sform.setOldRate9(Float.toString(oldrate));
			sform.setNewAvailable9(null);
			sform.setNewRate9(null);	
			amt=qty*oldrate;
		}
		else if(qty>oldqty)
		{
			extra=qty-oldqty;
			sform.setOldAvailable9(Float.toString(oldqty));
			sform.setOldRate9(Float.toString(oldrate));
			sform.setNewAvailable9(Float.toString(extra));
			sform.setNewRate9(Float.toString(newrate));
			
			amt=(extra*newrate)+(oldqty*oldrate);
		}
		sform.setTotalAvailableQuantity9(Float.toString(totalqty));
		sform.setTotalAmount9(Float.toString(amt));
	}
    logger.debug("SpareAction:qtyUpdateMethod9---------->");
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
	SparePartsForm sform=(SparePartsForm)form;
	logger.debug("SpareAction:qtyUpdateMethod10<----------");
	ArrayList partnumberList=new ArrayList();
	ArrayList descList=new ArrayList();
    String sparetype;
    if(StringUtils.isNotEmpty(sform.getWantedQuantity10()))
	{
		qty=Integer.parseInt(sform.getWantedQuantity10());
		sparetype=sform.getPartNumber10();
		descList=spareservices.convertToSpareDesc(sparetype);
		descvo=(SparePartsFormVO)descList.get(0);
		partnumberList=spareservices.quantityMethod(descvo.getDriverName());
		sparevo=(SparePartsFormVO)partnumberList.get(0);	
		oldqty=Float.parseFloat(sparevo.getOldAvailable1());
		newqty=Float.parseFloat(sparevo.getNewAvailable1());
		oldrate=Float.parseFloat(sparevo.getOldRate1());
		newrate=Float.parseFloat(sparevo.getNewRate1());
		totalqty=oldqty+newqty;
		if(qty>totalqty)
		{
			logger.debug("Stock is very lower than required quantity");
		}
		else if(qty<=oldqty)
		{
			sform.setOldAvailable10(Float.toString(qty));
			sform.setOldRate10(Float.toString(oldrate));
			sform.setNewAvailable10(null);
			sform.setNewRate10(null);	
			amt=qty*oldrate;
		}
		else if(qty>oldqty)
		{
			extra=qty-oldqty;
			sform.setOldAvailable10(Float.toString(oldqty));
			sform.setOldRate10(Float.toString(oldrate));
			sform.setNewAvailable10(Float.toString(extra));
			sform.setNewRate10(Float.toString(newrate));
			
			amt=(extra*newrate)+(oldqty*oldrate);
		}
		sform.setTotalAvailableQuantity10(Float.toString(totalqty));
		sform.setTotalAmount10(Float.toString(amt));
	}
    logger.debug("SpareAction:qtyUpdateMethod10---------->");
	return mapping.findForward("load");
}


/**
 * to insert the values in table
 * @param jobid
 * @param form
 * @throws Exception 
 */
public void insertvalues(int jobid,ActionForm form) throws Exception
{
	int wantedquantity,totalqty,oldavail,newavail=0,brandname,partno;
	float oldrate,newrate=0,amount;
	String other=null;
	SparePartsForm sf=(SparePartsForm)form;
	SparepartsService ss=new SparepartsService();
	
	int inst=ss.convertToCode(sf.getInstitutionName());
	int vehicletype=ss.convertToCode(sf.getVehicleType());
	int vehiclenumber=ss.convertToCode(sf.getVehicleNumber());
	int billnumber=Integer.parseInt(sf.getBillNumber());
	String reqdate=sf.getRequestedDate();
	int drname=ss.convertToCode(sf.getDriverName());
	int rdrname=ss.convertToCode(sf.getRequestedDriverName());
	int goodstype=ss.convertToCode(itemname);
	int place=ss.convertToCode(serviceplace);
	int station=ss.convertToCode(servicestation);
	String neededspares=null;
	if(StringUtils.isNotEmpty(sf.getNeededSpares()))
	{
		neededspares=sf.getNeededSpares();
	}
	float totalamt=Float.parseFloat(sf.getTotalAmount());
	if(StringUtils.isNotEmpty(sf.getOtherPurpose()))
	{
		other=sf.getOtherPurpose();
	}
	try
    {
		ss.insertCommon(inst,vehicletype,vehiclenumber,billnumber,reqdate,drname,rdrname,other,neededspares,goodstype,place,station,jobid,totalamt);
   		logger.debug("main");
    }
    catch(Exception e)
    {
    	logger.debug("error"+e);
    }
    if(!StringUtils.isEmpty(sf.getWantedQuantity1()))
    {
    	brandname=Integer.parseInt(sf.getItemDescription1());
    	logger.debug("Brandname:"+brandname);
    	partno=Integer.parseInt(sf.getPartNumber1());
    	desc_list=spareservices.convertToSpareDesc(sf.getPartNumber1());
		drivernamevo=(SparePartsFormVO)desc_list.get(0);
		itemtype1=drivernamevo.getDriverName();
    	logger.debug("partno:"+partno);
    	wantedquantity=Integer.parseInt(sf.getWantedQuantity1());
    	totalqty=Integer.parseInt(sf.getTotalAvailableQuantity1());
    	oldavail=Integer.parseInt(sf.getOldAvailable1());
    	oldrate=Float.parseFloat(sf.getOldRate1());
    	newavail=Integer.parseInt(sf.getNewAvailable1());
    	newrate=Float.parseFloat(sf.getNewRate1());
    	amount=Float.parseFloat(sf.getTotalAmount1());
    	try
	    {
    		spareservices.insertCommonValues(jobid,partno,brandname,totalqty,wantedquantity,oldavail,newavail,oldrate,newrate,amount);
    		spareservices.updateValues(toldqty,tnewqty,itemname,itemtype1);
			if(toldqty==0 && tnewqty!=0)
			{
				toldqty=tnewqty;
				oldrate=newrate;
				if(xqty!=0)
				{
					tnewqty=xqty;
				    newrate=xrate;
				}
				else
				{
					tnewqty=0;
					newrate=0;
				}			    
			}
			else if(toldqty==0 && tnewqty==0 && xqty!=0)
			{
				    toldqty=xqty;
				    oldrate=xrate;
					tnewqty=0;
					newrate=0;
			}
			logger.debug("Values::" + toldqty+tnewqty+oldrate+newrate);
			spareservices.updateExtra(toldqty,tnewqty,oldrate,newrate,itemname,itemtype1);	
			logger.debug("fuel");
	    }
	    catch(Exception e)
	    {
	    	logger.debug("error"+e);
	    }
    }
    if(!StringUtils.isEmpty(sf.getWantedQuantity2()))
    {
    	brandname=Integer.parseInt(sf.getItemDescription2());
    	partno=Integer.parseInt(sf.getPartNumber2());
    	desc_list=spareservices.convertToSpareDesc(sf.getPartNumber2());
		drivernamevo=(SparePartsFormVO)desc_list.get(0);
		itemtype2=drivernamevo.getDriverName();
    	wantedquantity=Integer.parseInt(sf.getWantedQuantity2());
    	totalqty=Integer.parseInt(sf.getTotalAvailableQuantity2());
    	oldavail=Integer.parseInt(sf.getOldAvailable2());
    	oldrate=Float.parseFloat(sf.getOldRate2());
    	newavail=Integer.parseInt(sf.getNewAvailable2());
    	newrate=Float.parseFloat(sf.getNewRate2());
    	amount=Float.parseFloat(sf.getTotalAmount2());
    	try
	    {
    		spareservices.insertCommonValues(jobid,partno,brandname,totalqty,wantedquantity,oldavail,newavail,oldrate,newrate,amount);
    		spareservices.updateValues(toldqty,tnewqty,itemname,itemtype2);
			if(toldqty==0 && tnewqty!=0)
			{
				toldqty=tnewqty;
				oldrate=newrate;
				if(xqty!=0)
				{
					tnewqty=xqty;
				    newrate=xrate;
				}
				else
				{
					tnewqty=0;
					newrate=0;
				}			    
			}
			else if(toldqty==0 && tnewqty==0 && xqty!=0)
			{
				    toldqty=xqty;
				    oldrate=xrate;
					tnewqty=0;
					newrate=0;
			}
			logger.debug("Values::" + toldqty+tnewqty+oldrate+newrate);
			spareservices.updateExtra(toldqty,tnewqty,oldrate,newrate,itemname,itemtype2);		  
	    	logger.debug("fuel");
	    }
	    catch(Exception e)
	    {
	    	logger.debug("error"+e);
	    }
    }
    if(!StringUtils.isEmpty(sf.getWantedQuantity3()))
    {
    	brandname=Integer.parseInt(sf.getItemDescription3());
    	partno=Integer.parseInt(sf.getPartNumber3());
    	desc_list=spareservices.convertToSpareDesc(sf.getPartNumber3());
		drivernamevo=(SparePartsFormVO)desc_list.get(0);
		itemtype3=drivernamevo.getDriverName();
    	wantedquantity=Integer.parseInt(sf.getWantedQuantity3());
    	totalqty=Integer.parseInt(sf.getTotalAvailableQuantity3());
    	oldavail=Integer.parseInt(sf.getOldAvailable3());
    	oldrate=Float.parseFloat(sf.getOldRate3());
    	newavail=Integer.parseInt(sf.getNewAvailable3());
    	newrate=Float.parseFloat(sf.getNewRate3());
    	amount=Float.parseFloat(sf.getTotalAmount3());
    	try
	    {
    		spareservices.insertCommonValues(jobid,partno,brandname,totalqty,wantedquantity,oldavail,newavail,oldrate,newrate,amount);
    		spareservices.updateValues(toldqty,tnewqty,itemname,itemtype3);
			if(toldqty==0 && tnewqty!=0)
			{
				toldqty=tnewqty;
				oldrate=newrate;
				if(xqty!=0)
				{
					tnewqty=xqty;
				    newrate=xrate;
				}
				else
				{
					tnewqty=0;
					newrate=0;
				}			    
			}
			else if(toldqty==0 && tnewqty==0 && xqty!=0)
			{
				    toldqty=xqty;
				    oldrate=xrate;
					tnewqty=0;
					newrate=0;
			}
			logger.debug("Values::" + toldqty+tnewqty+oldrate+newrate);
			spareservices.updateExtra(toldqty,tnewqty,oldrate,newrate,itemname,itemtype3);	
			logger.debug("fuel");
	    }
	    catch(Exception e)
	    {
	    	logger.debug("error"+e);
	    }
    }
    if(!StringUtils.isEmpty(sf.getWantedQuantity4()))
    {
    	brandname=Integer.parseInt(sf.getItemDescription4());
    	partno=Integer.parseInt(sf.getPartNumber4());
    	desc_list=spareservices.convertToSpareDesc(sf.getPartNumber4());
		drivernamevo=(SparePartsFormVO)desc_list.get(0);
		itemtype4=drivernamevo.getDriverName();
    	wantedquantity=Integer.parseInt(sf.getWantedQuantity4());
    	totalqty=Integer.parseInt(sf.getTotalAvailableQuantity4());
    	oldavail=Integer.parseInt(sf.getOldAvailable4());
    	oldrate=Float.parseFloat(sf.getOldRate4());
    	newavail=Integer.parseInt(sf.getNewAvailable4());
    	newrate=Float.parseFloat(sf.getNewRate4());
    	amount=Float.parseFloat(sf.getTotalAmount4());
    	try
	    {
    		spareservices.insertCommonValues(jobid,partno,brandname,totalqty,wantedquantity,oldavail,newavail,oldrate,newrate,amount);
    		spareservices.updateValues(toldqty,tnewqty,itemname,itemtype4);
			if(toldqty==0 && tnewqty!=0)
			{
				toldqty=tnewqty;
				oldrate=newrate;
				if(xqty!=0)
				{
					tnewqty=xqty;
				    newrate=xrate;
				}
				else
				{
					tnewqty=0;
					newrate=0;
				}			    
			}
			else if(toldqty==0 && tnewqty==0 && xqty!=0)
			{
				    toldqty=xqty;
				    oldrate=xrate;
					tnewqty=0;
					newrate=0;
			}
			logger.debug("Values::" + toldqty+tnewqty+oldrate+newrate);
			spareservices.updateExtra(toldqty,tnewqty,oldrate,newrate,itemname,itemtype4);	
			logger.debug("fuel");
	    }
	    catch(Exception e)
	    {
	    	logger.debug("error"+e);
	    }
    }
    if(!StringUtils.isEmpty(sf.getWantedQuantity5()))
    {
    	brandname=Integer.parseInt(sf.getItemDescription5());
    	partno=Integer.parseInt(sf.getPartNumber5());
    	desc_list=spareservices.convertToSpareDesc(sf.getPartNumber5());
		drivernamevo=(SparePartsFormVO)desc_list.get(0);
		itemtype5=drivernamevo.getDriverName();
    	wantedquantity=Integer.parseInt(sf.getWantedQuantity5());
    	totalqty=Integer.parseInt(sf.getTotalAvailableQuantity5());
    	oldavail=Integer.parseInt(sf.getOldAvailable5());
    	oldrate=Float.parseFloat(sf.getOldRate5());
    	newavail=Integer.parseInt(sf.getNewAvailable5());
    	newrate=Float.parseFloat(sf.getNewRate5());
    	amount=Float.parseFloat(sf.getTotalAmount5());
    	try
	    {
    		spareservices.insertCommonValues(jobid,partno,brandname,totalqty,wantedquantity,oldavail,newavail,oldrate,newrate,amount);
    		spareservices.updateValues(toldqty,tnewqty,itemname,itemtype5);
			if(toldqty==0 && tnewqty!=0)
			{
				toldqty=tnewqty;
				oldrate=newrate;
				if(xqty!=0)
				{
					tnewqty=xqty;
				    newrate=xrate;
				}
				else
				{
					tnewqty=0;
					newrate=0;
				}			    
			}
			else if(toldqty==0 && tnewqty==0 && xqty!=0)
			{
				    toldqty=xqty;
				    oldrate=xrate;
					tnewqty=0;
					newrate=0;
			}
			logger.debug("Values::" + toldqty+tnewqty+oldrate+newrate);
			spareservices.updateExtra(toldqty,tnewqty,oldrate,newrate,itemname,itemtype5);	
    		logger.debug("fuel");
	    }
	    catch(Exception e)
	    {
	    	logger.debug("error"+e);
	    }
    }
    if(!StringUtils.isEmpty(sf.getWantedQuantity6()))
    {
    	brandname=Integer.parseInt(sf.getItemDescription6());
    	partno=Integer.parseInt(sf.getPartNumber6());
    	desc_list=spareservices.convertToSpareDesc(sf.getPartNumber6());
		drivernamevo=(SparePartsFormVO)desc_list.get(0);
		itemtype6=drivernamevo.getDriverName();
    	wantedquantity=Integer.parseInt(sf.getWantedQuantity6());
    	totalqty=Integer.parseInt(sf.getTotalAvailableQuantity6());
    	oldavail=Integer.parseInt(sf.getOldAvailable6());
    	oldrate=Float.parseFloat(sf.getOldRate6());
    	newavail=Integer.parseInt(sf.getNewAvailable6());
    	newrate=Float.parseFloat(sf.getNewRate6());
    	amount=Float.parseFloat(sf.getTotalAmount6());
    	try
	    {
    		spareservices.insertCommonValues(jobid,partno,brandname,totalqty,wantedquantity,oldavail,newavail,oldrate,newrate,amount);
    		spareservices.updateValues(toldqty,tnewqty,itemname,itemtype6);
			if(toldqty==0 && tnewqty!=0)
			{
				toldqty=tnewqty;
				oldrate=newrate;
				if(xqty!=0)
				{
					tnewqty=xqty;
				    newrate=xrate;
				}
				else
				{
					tnewqty=0;
					newrate=0;
				}			    
			}
			else if(toldqty==0 && tnewqty==0 && xqty!=0)
			{
				    toldqty=xqty;
				    oldrate=xrate;
					tnewqty=0;
					newrate=0;
			}
			logger.debug("Values::" + toldqty+tnewqty+oldrate+newrate);
			spareservices.updateExtra(toldqty,tnewqty,oldrate,newrate,itemname,itemtype6);	
    		logger.debug("fuel");
	    }
	    catch(Exception e)
	    {
	    	logger.debug("error"+e);
	    }
    }
    if(!StringUtils.isEmpty(sf.getWantedQuantity7()))
    {
    	brandname=Integer.parseInt(sf.getItemDescription7());
    	partno=Integer.parseInt(sf.getPartNumber7());
    	desc_list=spareservices.convertToSpareDesc(sf.getPartNumber7());
		drivernamevo=(SparePartsFormVO)desc_list.get(0);
		itemtype7=drivernamevo.getDriverName();
    	wantedquantity=Integer.parseInt(sf.getWantedQuantity7());
    	totalqty=Integer.parseInt(sf.getTotalAvailableQuantity7());
    	oldavail=Integer.parseInt(sf.getOldAvailable7());
    	oldrate=Float.parseFloat(sf.getOldRate7());
    	newavail=Integer.parseInt(sf.getNewAvailable7());
    	newrate=Float.parseFloat(sf.getNewRate7());
    	amount=Float.parseFloat(sf.getTotalAmount7());
    	try
	    {
    		spareservices.insertCommonValues(jobid,partno,brandname,totalqty,wantedquantity,oldavail,newavail,oldrate,newrate,amount);
    		spareservices.updateValues(toldqty,tnewqty,itemname,itemtype7);
			if(toldqty==0 && tnewqty!=0)
			{
				toldqty=tnewqty;
				oldrate=newrate;
				if(xqty!=0)
				{
					tnewqty=xqty;
				    newrate=xrate;
				}
				else
				{
					tnewqty=0;
					newrate=0;
				}			    
			}
			else if(toldqty==0 && tnewqty==0 && xqty!=0)
			{
				    toldqty=xqty;
				    oldrate=xrate;
					tnewqty=0;
					newrate=0;
			}
			logger.debug("Values::" + toldqty+tnewqty+oldrate+newrate);
			spareservices.updateExtra(toldqty,tnewqty,oldrate,newrate,itemname,itemtype7);	
			logger.debug("fuel");
	    }
	    catch(Exception e)
	    {
	    	logger.debug("error"+e);
	    }
    }
    if(!StringUtils.isEmpty(sf.getWantedQuantity8()))
    {
    	brandname=Integer.parseInt(sf.getItemDescription8());
    	partno=Integer.parseInt(sf.getPartNumber8());
    	desc_list=spareservices.convertToSpareDesc(sf.getPartNumber8());
		drivernamevo=(SparePartsFormVO)desc_list.get(0);
		itemtype8=drivernamevo.getDriverName();
    	wantedquantity=Integer.parseInt(sf.getWantedQuantity8());
    	totalqty=Integer.parseInt(sf.getTotalAvailableQuantity8());
    	oldavail=Integer.parseInt(sf.getOldAvailable8());
    	oldrate=Float.parseFloat(sf.getOldRate8());
    	newavail=Integer.parseInt(sf.getNewAvailable8());
    	newrate=Float.parseFloat(sf.getNewRate8());
    	amount=Float.parseFloat(sf.getTotalAmount8());
    	try
	    {
    		spareservices.insertCommonValues(jobid,partno,brandname,totalqty,wantedquantity,oldavail,newavail,oldrate,newrate,amount);
    		spareservices.updateValues(toldqty,tnewqty,itemname,itemtype8);
			if(toldqty==0 && tnewqty!=0)
			{
				toldqty=tnewqty;
				oldrate=newrate;
				if(xqty!=0)
				{
					tnewqty=xqty;
				    newrate=xrate;
				}
				else
				{
					tnewqty=0;
					newrate=0;
				}			    
			}
			else if(toldqty==0 && tnewqty==0 && xqty!=0)
			{
				    toldqty=xqty;
				    oldrate=xrate;
					tnewqty=0;
					newrate=0;
			}
			logger.debug("Values::" + toldqty+tnewqty+oldrate+newrate);
			spareservices.updateExtra(toldqty,tnewqty,oldrate,newrate,itemname,itemtype8);	
    		logger.debug("fuel");
	    }
	    catch(Exception e)
	    {
	    	logger.debug("error"+e);
	    }
    }
    if(!StringUtils.isEmpty(sf.getWantedQuantity9()))
    {
    	brandname=Integer.parseInt(sf.getItemDescription9());
    	partno=Integer.parseInt(sf.getPartNumber9());
    	desc_list=spareservices.convertToSpareDesc(sf.getPartNumber9());
		drivernamevo=(SparePartsFormVO)desc_list.get(0);
		itemtype9=drivernamevo.getDriverName();
    	wantedquantity=Integer.parseInt(sf.getWantedQuantity9());
    	totalqty=Integer.parseInt(sf.getTotalAvailableQuantity9());
    	oldavail=Integer.parseInt(sf.getOldAvailable9());
    	oldrate=Float.parseFloat(sf.getOldRate9());
    	newavail=Integer.parseInt(sf.getNewAvailable9());
    	newrate=Float.parseFloat(sf.getNewRate9());
    	amount=Float.parseFloat(sf.getTotalAmount9());
    	try
	    {
    		spareservices.insertCommonValues(jobid,partno,brandname,totalqty,wantedquantity,oldavail,newavail,oldrate,newrate,amount);
    		spareservices.updateValues(toldqty,tnewqty,itemname,itemtype9);
			if(toldqty==0 && tnewqty!=0)
			{
				toldqty=tnewqty;
				oldrate=newrate;
				if(xqty!=0)
				{
					tnewqty=xqty;
				    newrate=xrate;
				}
				else
				{
					tnewqty=0;
					newrate=0;
				}			    
			}
			else if(toldqty==0 && tnewqty==0 && xqty!=0)
			{
				    toldqty=xqty;
				    oldrate=xrate;
					tnewqty=0;
					newrate=0;
			}
			logger.debug("Values::" + toldqty+tnewqty+oldrate+newrate);
			spareservices.updateExtra(toldqty,tnewqty,oldrate,newrate,itemname,itemtype9);	
    		logger.debug("fuel");
	    }
	    catch(Exception e)
	    {
	    	logger.debug("error"+e);
	    }
    }
    if(!StringUtils.isEmpty(sf.getWantedQuantity10()))
    {
    	brandname=Integer.parseInt(sf.getItemDescription10());
    	partno=Integer.parseInt(sf.getPartNumber10());
    	desc_list=spareservices.convertToSpareDesc(sf.getPartNumber10());
		drivernamevo=(SparePartsFormVO)desc_list.get(0);
		itemtype10=drivernamevo.getDriverName();
    	wantedquantity=Integer.parseInt(sf.getWantedQuantity10());
    	totalqty=Integer.parseInt(sf.getTotalAvailableQuantity10());
    	oldavail=Integer.parseInt(sf.getOldAvailable10());
    	oldrate=Float.parseFloat(sf.getOldRate10());
    	newavail=Integer.parseInt(sf.getNewAvailable10());
    	newrate=Float.parseFloat(sf.getNewRate10());
    	amount=Float.parseFloat(sf.getTotalAmount10());
    	try
	    {
    		spareservices.insertCommonValues(jobid,partno,brandname,totalqty,wantedquantity,oldavail,newavail,oldrate,newrate,amount);
    		spareservices.updateValues(toldqty,tnewqty,itemname,itemtype10);
			if(toldqty==0 && tnewqty!=0)
			{
				toldqty=tnewqty;
				oldrate=newrate;
				if(xqty!=0)
				{
					tnewqty=xqty;
				    newrate=xrate;
				}
				else
				{
					tnewqty=0;
					newrate=0;
				}			    
			}
			else if(toldqty==0 && tnewqty==0 && xqty!=0)
			{
				    toldqty=xqty;
				    oldrate=xrate;
					tnewqty=0;
					newrate=0;
			}
			logger.debug("Values::" + toldqty+tnewqty+oldrate+newrate);
			spareservices.updateExtra(toldqty,tnewqty,oldrate,newrate,itemname,itemtype10);	
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
	SparePartsForm sf=(SparePartsForm)form;
	sf.setWantedQuantity1(null);
	sf.setWantedQuantity2(null);
	sf.setWantedQuantity3(null);
	sf.setWantedQuantity4(null);
	sf.setWantedQuantity5(null);
	sf.setWantedQuantity6(null);
	sf.setWantedQuantity7(null);
	sf.setWantedQuantity8(null);
	sf.setWantedQuantity9(null);
	sf.setWantedQuantity10(null);
	
	sf.setTotalAmount1(null);
	sf.setTotalAmount2(null);
	sf.setTotalAmount3(null);
	sf.setTotalAmount4(null);
	sf.setTotalAmount5(null);
	sf.setTotalAmount6(null);
	sf.setTotalAmount7(null);
	sf.setTotalAmount8(null);
	sf.setTotalAmount9(null);
	sf.setTotalAmount10(null);
	sf.setTotalAvailableQuantity1(null);
	sf.setTotalAvailableQuantity2(null);
	sf.setTotalAvailableQuantity3(null);
	sf.setTotalAvailableQuantity4(null);
	sf.setTotalAvailableQuantity5(null);
	sf.setTotalAvailableQuantity6(null);
	sf.setTotalAvailableQuantity7(null);
	sf.setTotalAvailableQuantity8(null);
	sf.setTotalAvailableQuantity9(null);
	sf.setTotalAvailableQuantity10(null);
	sf.setOldAvailable1(null);
	sf.setOldAvailable2(null);
	sf.setOldAvailable3(null);
	sf.setOldAvailable4(null);
	sf.setOldAvailable5(null);
	sf.setOldAvailable6(null);
	sf.setOldAvailable7(null);
	sf.setOldAvailable8(null);
	sf.setOldAvailable9(null);
	sf.setOldAvailable10(null);
	sf.setOldRate1(null);
	sf.setOldRate2(null);
	sf.setOldRate3(null);
	sf.setOldRate4(null);
	sf.setOldRate5(null);
	sf.setOldRate6(null);
	sf.setOldRate7(null);
	sf.setOldRate8(null);
	sf.setOldRate9(null);
	sf.setOldRate10(null);
}


/**
 * to display the quantity and rates in first row
 * @param mapping
 * @param form
 * @param request
 * @param response
 * @return
 * @throws Exception
 */

public ActionForward listRates1Method(ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {
		SparePartsFormVO vo=new SparePartsFormVO();
		ArrayList list=new ArrayList();
		SparePartsForm sf=(SparePartsForm)form;
		sf.setOldAvailable1(null);
		sf.setOldRate1(null);
		sf.setNewAvailable1(null);
		sf.setNewRate1(null);
		desc_list=spareservices.convertToSpareDesc(sf.getPartNumber1());
		descvo=(SparePartsFormVO)desc_list.get(0);
		list=spareservices.fetchRateValue(descvo.getDriverName());
		for(int i=0;i<list.size();i++)
		{
			vo=(SparePartsFormVO)list.get(i);
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
		
		SparePartsFormVO vo=new SparePartsFormVO();
		ArrayList list=new ArrayList();
		SparePartsForm sf=(SparePartsForm)form;
		sf.setOldAvailable2(null);
		sf.setOldRate2(null);
		sf.setNewAvailable2(null);
		sf.setNewRate2(null);
		desc_list=spareservices.convertToSpareDesc(sf.getPartNumber2());
		descvo=(SparePartsFormVO)desc_list.get(0);
		list=spareservices.fetchRateValue(descvo.getDriverName());
		for(int i=0;i<list.size();i++)
		{
			vo=(SparePartsFormVO)list.get(i);
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
		
		SparePartsFormVO vo=new SparePartsFormVO();
		ArrayList list=new ArrayList();
		SparePartsForm sf=(SparePartsForm)form;
		sf.setOldAvailable3(null);
		sf.setOldRate3(null);
		sf.setNewAvailable3(null);
		sf.setNewRate3(null);
		desc_list=spareservices.convertToSpareDesc(sf.getPartNumber3());
		descvo=(SparePartsFormVO)desc_list.get(0);
		list=spareservices.fetchRateValue(descvo.getDriverName());
		for(int i=0;i<list.size();i++)
		{	
			vo=(SparePartsFormVO)list.get(i);
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
		
		SparePartsFormVO vo=new SparePartsFormVO();
		ArrayList list=new ArrayList();
		SparePartsForm sf=(SparePartsForm)form;
		sf.setOldAvailable4(null);
		sf.setOldRate4(null);
		sf.setNewAvailable4(null);
		sf.setNewRate4(null);
		desc_list=spareservices.convertToSpareDesc(sf.getPartNumber4());
		descvo=(SparePartsFormVO)desc_list.get(0);
		list=spareservices.fetchRateValue(descvo.getDriverName());
		for(int i=0;i<list.size();i++)
		{
			vo=(SparePartsFormVO)list.get(i);
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
		
		SparePartsFormVO vo=new SparePartsFormVO();
		ArrayList list=new ArrayList();
		SparePartsForm sf=(SparePartsForm)form;
		sf.setOldAvailable5(null);
		sf.setOldRate5(null);
		sf.setNewAvailable5(null);
		sf.setNewRate5(null);
		desc_list=spareservices.convertToSpareDesc(sf.getPartNumber5());
		descvo=(SparePartsFormVO)desc_list.get(0);
		list=spareservices.fetchRateValue(descvo.getDriverName());
		for(int i=0;i<list.size();i++)
		{
			vo=(SparePartsFormVO)list.get(i);
			total=Integer.parseInt(vo.getOldAvailable1())+Integer.parseInt(vo.getNewAvailable1());
		}
		logger.debug(total);
		sf.setTotalAvailableQuantity5(Integer.toString(total));
		logger.debug("spare1Action:defaultMethod---------->");
		return mapping.findForward("load");
}


public ActionForward listRates6Method(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response)
		throws Exception {
		SparePartsFormVO vo=new SparePartsFormVO();
		ArrayList list=new ArrayList();
		SparePartsForm sf=(SparePartsForm)form;
		sf.setOldAvailable6(null);
		sf.setOldRate6(null);
		sf.setNewAvailable6(null);
		sf.setNewRate6(null);
		desc_list=spareservices.convertToSpareDesc(sf.getPartNumber6());
		descvo=(SparePartsFormVO)desc_list.get(0);
		list=spareservices.fetchRateValue(descvo.getDriverName());
		for(int i=0;i<list.size();i++)
		{
			vo=(SparePartsFormVO)list.get(i);
			total=Integer.parseInt(vo.getOldAvailable1())+Integer.parseInt(vo.getNewAvailable1());
		}
		logger.debug(total);
		sf.setTotalAvailableQuantity6(Integer.toString(total));
		logger.debug("spare1Action:defaultMethod---------->");
		return mapping.findForward("load");
}

public ActionForward listRates7Method(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response)
		throws Exception {
		SparePartsFormVO vo=new SparePartsFormVO();
		ArrayList list=new ArrayList();
		SparePartsForm sf=(SparePartsForm)form;
		sf.setOldAvailable7(null);
		sf.setOldRate7(null);
		sf.setNewAvailable7(null);
		sf.setNewRate7(null);
		desc_list=spareservices.convertToSpareDesc(sf.getPartNumber7());
		descvo=(SparePartsFormVO)desc_list.get(0);
		list=spareservices.fetchRateValue(descvo.getDriverName());
		for(int i=0;i<list.size();i++)
		{
			vo=(SparePartsFormVO)list.get(i);
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
		SparePartsFormVO vo=new SparePartsFormVO();
		ArrayList list=new ArrayList();
		SparePartsForm sf=(SparePartsForm)form;
		sf.setOldAvailable8(null);
		sf.setOldRate8(null);
		sf.setNewAvailable8(null);
		sf.setNewRate8(null);
		desc_list=spareservices.convertToSpareDesc(sf.getPartNumber8());
		descvo=(SparePartsFormVO)desc_list.get(0);
		list=spareservices.fetchRateValue(descvo.getDriverName());
		for(int i=0;i<list.size();i++)
		{
			vo=(SparePartsFormVO)list.get(i);
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
		SparePartsFormVO vo=new SparePartsFormVO();
		ArrayList list=new ArrayList();
		SparePartsForm sf=(SparePartsForm)form;
		sf.setOldAvailable9(null);
		sf.setOldRate9(null);
		sf.setNewAvailable9(null);
		sf.setNewRate9(null);
		desc_list=spareservices.convertToSpareDesc(sf.getPartNumber9());
		descvo=(SparePartsFormVO)desc_list.get(0);
		list=spareservices.fetchRateValue(descvo.getDriverName());
		for(int i=0;i<list.size();i++)
		{
			vo=(SparePartsFormVO)list.get(i);
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
		SparePartsFormVO vo=new SparePartsFormVO();
		ArrayList list=new ArrayList();
		SparePartsForm sf=(SparePartsForm)form;
		sf.setOldAvailable10(null);
		sf.setOldRate10(null);
		sf.setNewAvailable10(null);
		sf.setNewRate10(null);
		desc_list=spareservices.convertToSpareDesc(sf.getPartNumber10());
		descvo=(SparePartsFormVO)desc_list.get(0);
		list=spareservices.fetchRateValue(descvo.getDriverName());
		for(int i=0;i<list.size();i++)
		{
			vo=(SparePartsFormVO)list.get(i);
			total=Integer.parseInt(vo.getOldAvailable1())+Integer.parseInt(vo.getNewAvailable1());
		}
		logger.debug(total);
		sf.setTotalAvailableQuantity10(Integer.toString(total));
		logger.debug("spare1Action:defaultMethod---------->");
		return mapping.findForward("load");
}


public ActionForward partNumberMethod1(ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {
		SparePartsForm sform=(SparePartsForm)form;
		desc_list=spareservices.convertToSpareDesc(sform.getItemDescription1());
		descvo=(SparePartsFormVO)desc_list.get(0);
		res_list1=spareservice.fetchNameValues(descvo.getDriverName());
		sform.setPartList1(res_list1);
		return mapping.findForward("load");
}
public ActionForward partNumberMethod2(ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {
		SparePartsForm sform=(SparePartsForm)form;
		desc_list=spareservices.convertToSpareDesc(sform.getItemDescription2());
		descvo=(SparePartsFormVO)desc_list.get(0);
		res_list1=spareservice.fetchNameValues(descvo.getDriverName());
		sform.setPartList2(res_list1);
		return mapping.findForward("load");
}
public ActionForward partNumberMethod3(ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {
		SparePartsForm sform=(SparePartsForm)form;
		desc_list=spareservices.convertToSpareDesc(sform.getItemDescription3());
		descvo=(SparePartsFormVO)desc_list.get(0);
		res_list1=spareservice.fetchNameValues(descvo.getDriverName());
		sform.setPartList3(res_list1);
		return mapping.findForward("load");
}
public ActionForward partNumberMethod4(ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {
		SparePartsForm sform=(SparePartsForm)form;
		desc_list=spareservices.convertToSpareDesc(sform.getItemDescription4());
		descvo=(SparePartsFormVO)desc_list.get(0);
		res_list1=spareservice.fetchNameValues(descvo.getDriverName());
		sform.setPartList4(res_list1);
		return mapping.findForward("load");
}
public ActionForward partNumberMethod5(ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {
		SparePartsForm sform=(SparePartsForm)form;
		desc_list=spareservices.convertToSpareDesc(sform.getItemDescription5());
		descvo=(SparePartsFormVO)desc_list.get(0);
		res_list1=spareservice.fetchNameValues(descvo.getDriverName());
		sform.setPartList5(res_list1);
		return mapping.findForward("load");
}

public ActionForward partNumberMethod6(ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {
		SparePartsForm sform=(SparePartsForm)form;
		desc_list=spareservices.convertToSpareDesc(sform.getItemDescription6());
		descvo=(SparePartsFormVO)desc_list.get(0);
		res_list1=spareservice.fetchNameValues(descvo.getDriverName());
		sform.setPartList6(res_list1);
		return mapping.findForward("load");
}
public ActionForward partNumberMethod7(ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {
		SparePartsForm sform=(SparePartsForm)form;
		desc_list=spareservices.convertToSpareDesc(sform.getItemDescription7());
		descvo=(SparePartsFormVO)desc_list.get(0);
		res_list1=spareservice.fetchNameValues(descvo.getDriverName());
		sform.setPartList7(res_list1);
		
		return mapping.findForward("load");
}
public ActionForward partNumberMethod8(ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {
		SparePartsForm sform=(SparePartsForm)form;
		desc_list=spareservices.convertToSpareDesc(sform.getItemDescription8());
		descvo=(SparePartsFormVO)desc_list.get(0);
		res_list1=spareservice.fetchNameValues(descvo.getDriverName());
		sform.setPartList8(res_list1);
		
		return mapping.findForward("load");
}
public ActionForward partNumberMethod9(ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {
		SparePartsForm sform=(SparePartsForm)form;
		desc_list=spareservices.convertToSpareDesc(sform.getItemDescription9());
		descvo=(SparePartsFormVO)desc_list.get(0);
		res_list1=spareservice.fetchNameValues(descvo.getDriverName());
		sform.setPartList9(res_list1);
		return mapping.findForward("load");
}
public ActionForward partNumberMethod10(ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {
		SparePartsForm sform=(SparePartsForm)form;
		desc_list=spareservices.convertToSpareDesc(sform.getItemDescription10());
		descvo=(SparePartsFormVO)desc_list.get(0);
		res_list1=spareservice.fetchNameValues(descvo.getDriverName());
		sform.setPartList10(res_list1);
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
public ActionForward totalAmountMethod(ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {
	SparePartsForm sform=(SparePartsForm)form;
	float amt1=0,amt2=0,amt3=0,amt4=0,amt5=0,amt6=0,amt7=0,amt8=0,amt9=0,amt10;
	if(!StringUtils.isEmpty(sform.getTotalAmount1()))
		amt1=Float.parseFloat(sform.getTotalAmount1());
	else
		amt1=0;
	if(!StringUtils.isEmpty(sform.getTotalAmount2()))
		amt2=Float.parseFloat(sform.getTotalAmount2());
	else
		amt2=0;
	if(!StringUtils.isEmpty(sform.getTotalAmount3()))
			amt3=Float.parseFloat(sform.getTotalAmount3());
	else
		amt3=0;
	if(!StringUtils.isEmpty(sform.getTotalAmount4()))
		amt4=Float.parseFloat(sform.getTotalAmount4());
	else
		amt4=0;
	if(!StringUtils.isEmpty(sform.getTotalAmount5()))
		amt5=Float.parseFloat(sform.getTotalAmount5());
	else
		amt5=0;
	if(!StringUtils.isEmpty(sform.getTotalAmount6()))
		amt6=Float.parseFloat(sform.getTotalAmount6());
	else
		amt6=0;
	if(!StringUtils.isEmpty(sform.getTotalAmount7()))
		amt7=Float.parseFloat(sform.getTotalAmount7());
	else
		amt7=0;
	if(!StringUtils.isEmpty(sform.getTotalAmount8()))
		amt8=Float.parseFloat(sform.getTotalAmount8());
	else
		amt8=0;
	if(!StringUtils.isEmpty(sform.getTotalAmount9()))
		amt9=Float.parseFloat(sform.getTotalAmount9());
	else
		amt9=0;
	if(!StringUtils.isEmpty(sform.getTotalAmount10()))
		amt10=Float.parseFloat(sform.getTotalAmount10());
	else
		amt10=0;
	float amount=amt1+amt2+amt3+amt4+amt5+amt6+amt7+amt8+amt9+amt10;
	sform.setTotalAmount(Float.toString(amount));
	return mapping.findForward("load");

}
}
