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

import com.formbean.GreaseForm;
import com.service.GreaseService;
import com.util.GreaseUtil;
import com.vo.GreaseVO;
import com.vo.OilVO;
import com.wf.job;

public class GreaseAction extends BaseDispatchAction{
	private static final Logger logger=(Logger)Logger.getLogger(GreaseAction.class);
	
	job jb=new job();
	int jobid;
	String itemname="Grease";
	String place="Perundurai";
	String servicestation="KVITT Workshop";
	GreaseService greaseservice=new GreaseService();
	GreaseUtil greaseutil=new GreaseUtil();
	GreaseVO generalvo=new GreaseVO();
	GreaseVO currentkmvo=new GreaseVO();
	GreaseVO drivernamevo=new GreaseVO();
	GreaseVO drivervo=new GreaseVO();
	GreaseVO greasedvo=new GreaseVO();
	GreaseVO greasedescvo=new GreaseVO();
	
	float qty=0,totalqty=0;
	float amt=0,extra=0;
	float newrate,oldrate=0,xrate=0;
	float newqty,oldqty=0,tnewqty,toldqty=0,xqty=0,qtyissue=0;
	String partnumber=null;
	String itemtype1=null,itemtype2=null,itemtype3=null,itemtype4=null,itemtype5=null;
	
	ArrayList greasedescList=new ArrayList();
	ArrayList totalqtyList=new ArrayList();
	ArrayList descList=new ArrayList();
	
	
	/**
	 * to retrieve institution and set values in combo
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
		logger.debug("GreaseAction:defaultMethod<----------");
		GreaseForm greaseform=(GreaseForm)form;
		ArrayList instList=new ArrayList();
		ArrayList greaseList=new ArrayList();
		ArrayList greaseReasonList=new ArrayList();
		
		instList=greaseservice.fetchInst();
		greaseform.setInstList(instList);
		greaseList=greaseservice.fetchGrease();
		greaseform.setGreaseList(greaseList);
		greaseReasonList=greaseservice.fetchGreaseReason();
		greaseform.setGreaseReasonList(greaseReasonList);
		logger.debug("GreaseAction:defaultMethod---------->");
		return mapping.findForward("load");
	}
	/**
	 *  pass institution name
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
		logger.debug("GreaseAction:instMethod<----------");
		ArrayList instList=new ArrayList();
		GreaseForm greaseform=(GreaseForm)form;
		int instname=Integer.parseInt(greaseform.getInstitutionName());
		instList=greaseservice.instMethod(instname);
		greaseform.setTypeList(instList);
		logger.debug("GreaseAction:instMethod---------->");
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
		logger.debug("GreaseAction:vehicleMethod<----------");
		ArrayList vehicleList=new ArrayList();
		GreaseForm greaseform=(GreaseForm)form;
		int vehtype=Integer.parseInt(greaseform.getVehicleType());
		vehicleList=greaseservice.vehicleMethod(vehtype);
		greaseform.setVehicleList(vehicleList);
		logger.debug("GreaseAction:vehicleMethod---------->");
		return mapping.findForward("load");
	}
	/**
	 * pass vehicle number
	 * To retrieve previously serviced km,drivername
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
		logger.debug("GreaseAction:driverMethod<----------");
		ArrayList drivernameList=new ArrayList();
		ArrayList driverList=new ArrayList();
		GreaseForm greaseform=(GreaseForm)form;
		int vehnum=Integer.parseInt(greaseform.getVehicleNumber());
		drivernameList=greaseservice.driverMethod(vehnum);
		drivernamevo=(GreaseVO)drivernameList.get(0);
		String driver_name=drivernamevo.getDriverName();
		driverList=greaseservice.convertToDesc(driver_name);
		drivervo=(GreaseVO)driverList.get(0);
		greaseform.setDriverName(drivervo.getDriverName());
		logger.debug("GreaseAction:driverMethod---------->");
		return mapping.findForward("load");
	}
	/**
	 * retrieves available quantity while choosing greasetype
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward typeMethod1(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {
		logger.debug("GreaseAction:typeMethod1---------->");
		GreaseForm greaseform=(GreaseForm)form;
		itemtype1=greaseform.getGreaseType1();
		greasedescList=greaseservice.convertToDesc(itemtype1);
		greasedescvo=(GreaseVO)greasedescList.get(0);
		totalqtyList=greaseservice.quantityMethod(greasedescvo.getDriverName());
		greasedescvo=(GreaseVO)totalqtyList.get(0);
		totalqty=Float.parseFloat(greasedescvo.getNewAvailable1())+Float.parseFloat(greasedescvo.getOldAvailable1());
		greaseform.setTotalAvailableQuantity1(Float.toString(totalqty));
		logger.debug("GreaseAction:typeMethod1---------->");
		return mapping.findForward("load");
	}
	/**
	 * retrieves available quantity while choosing greasetype
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward typeMethod2(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {
		logger.debug("GreaseAction:typeMethod1---------->");
		GreaseForm greaseform=(GreaseForm)form;
		itemtype1=greaseform.getGreaseType2();
		greasedescList=greaseservice.convertToDesc(itemtype1);
		greasedescvo=(GreaseVO)greasedescList.get(0);
		totalqtyList=greaseservice.quantityMethod(greasedescvo.getDriverName());
		greasedescvo=(GreaseVO)totalqtyList.get(0);
		totalqty=Float.parseFloat(greasedescvo.getNewAvailable1())+Float.parseFloat(greasedescvo.getOldAvailable1());
		greaseform.setTotalAvailableQuantity2(Float.toString(totalqty));
		logger.debug("GreaseAction:typeMethod1---------->");
		return mapping.findForward("load");
	}
	/**
	 * retrieves available quantity while choosing greasetype
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward typeMethod3(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {
		logger.debug("GreaseAction:typeMethod1---------->");
		GreaseForm greaseform=(GreaseForm)form;
		itemtype1=greaseform.getGreaseType3();
		greasedescList=greaseservice.convertToDesc(itemtype1);
		greasedescvo=(GreaseVO)greasedescList.get(0);
		totalqtyList=greaseservice.quantityMethod(greasedescvo.getDriverName());
		greasedescvo=(GreaseVO)totalqtyList.get(0);
		totalqty=Float.parseFloat(greasedescvo.getNewAvailable1())+Float.parseFloat(greasedescvo.getOldAvailable1());
		greaseform.setTotalAvailableQuantity3(Float.toString(totalqty));
		logger.debug("GreaseAction:typeMethod1---------->");
		return mapping.findForward("load");
	}
	/**
	 * retrieves available quantity while choosing greasetype
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward typeMethod4(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {
		logger.debug("GreaseAction:typeMethod1---------->");
		GreaseForm greaseform=(GreaseForm)form;
		itemtype1=greaseform.getGreaseType4();
		greasedescList=greaseservice.convertToDesc(itemtype1);
		greasedescvo=(GreaseVO)greasedescList.get(0);
		totalqtyList=greaseservice.quantityMethod(greasedescvo.getDriverName());
		greasedescvo=(GreaseVO)totalqtyList.get(0);
		totalqty=Float.parseFloat(greasedescvo.getNewAvailable1())+Float.parseFloat(greasedescvo.getOldAvailable1());
		greaseform.setTotalAvailableQuantity4(Float.toString(totalqty));
		logger.debug("GreaseAction:typeMethod1---------->");
		return mapping.findForward("load");
	}
	/**
	 * retrieves available quantity while choosing greasetype
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward typeMethod5(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {
		logger.debug("GreaseAction:typeMethod1---------->");
		GreaseForm greaseform=(GreaseForm)form;
		itemtype1=greaseform.getGreaseType5();
		greasedescList=greaseservice.convertToDesc(itemtype1);
		greasedescvo=(GreaseVO)greasedescList.get(0);
		totalqtyList=greaseservice.quantityMethod(greasedescvo.getDriverName());
		greasedescvo=(GreaseVO)totalqtyList.get(0);
		totalqty=Float.parseFloat(greasedescvo.getNewAvailable1())+Float.parseFloat(greasedescvo.getOldAvailable1());
		greaseform.setTotalAvailableQuantity5(Float.toString(totalqty));
		logger.debug("GreaseAction:typeMethod1---------->");
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
		GreaseForm greaseform=(GreaseForm)form;
		ArrayList partnumberList=new ArrayList();
		ArrayList greasedescList=new ArrayList();
	    String greasetype;
	if(StringUtils.isNotEmpty(greaseform.getWantedQuantity1()))
		{
			qty=Integer.parseInt(greaseform.getWantedQuantity1());
			greasetype=greaseform.getGreaseType1();
			greasedescList=greaseservice.convertToDesc(greasetype);
			greasedescvo=(GreaseVO)greasedescList.get(0);
			partnumberList=greaseservice.quantityMethod(greasedescvo.getDriverName());
			generalvo=(GreaseVO)partnumberList.get(0);	
			oldqty=Float.parseFloat(generalvo.getOldAvailable1());
			newqty=Float.parseFloat(generalvo.getNewAvailable1());
			oldrate=Float.parseFloat(generalvo.getOldRate1());
			newrate=Float.parseFloat(generalvo.getNewRate1());
			totalqty=oldqty+newqty;
			if(qty>totalqty)
			{
				logger.debug("Stock is very lower than required quantity");
			}
			else if(qty<=oldqty)
			{
				greaseform.setOldAvailable1(Float.toString(qty));
				greaseform.setOldRate1(Float.toString(oldrate));
				greaseform.setNewAvailable1(null);
				greaseform.setNewRate1(null);	
				amt=qty*oldrate;
			}
			else if(qty>oldqty)
			{
				extra=qty-oldqty;
				greaseform.setOldAvailable1(Float.toString(oldqty));
				greaseform.setOldRate1(Float.toString(oldrate));
				greaseform.setNewAvailable1(Float.toString(extra));
				greaseform.setNewRate1(Float.toString(newrate));
				
				amt=(extra*newrate)+(oldqty*oldrate);
			}
			greaseform.setTotalAvailableQuantity1(Float.toString(totalqty));
			greaseform.setTotalAmount1(Float.toString(amt));
		}
	logger.debug("GreaseAction:quantityMethod1---------->");
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
	public ActionForward quantityMethod2(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {
		logger.debug("GreaseAction:quantityMethod2<----------");
		GreaseForm greaseform=(GreaseForm)form;
		ArrayList partnumberList=new ArrayList();
		ArrayList greasedescList=new ArrayList();
	    String greasetype;
	if(StringUtils.isNotEmpty(greaseform.getWantedQuantity2()))
		{
			qty=Integer.parseInt(greaseform.getWantedQuantity2());
			greasetype=greaseform.getGreaseType2();
			greasedescList=greaseservice.convertToDesc(greasetype);
			greasedescvo=(GreaseVO)greasedescList.get(0);
			partnumberList=greaseservice.quantityMethod(greasedescvo.getDriverName());
			generalvo=(GreaseVO)partnumberList.get(0);	
			oldqty=Float.parseFloat(generalvo.getOldAvailable1());
			newqty=Float.parseFloat(generalvo.getNewAvailable1());
			oldrate=Float.parseFloat(generalvo.getOldRate1());
			newrate=Float.parseFloat(generalvo.getNewRate1());
			totalqty=oldqty+newqty;
					
			if(qty>totalqty)
			{
				logger.debug("Stock is very lower than required quantity");
			}
			else if(qty<=oldqty)
			{
				greaseform.setOldAvailable2(Float.toString(qty));
				greaseform.setOldRate2(Float.toString(oldrate));				
				greaseform.setNewAvailable2(null);
				greaseform.setNewRate2(null);	
				amt=qty*oldrate;
			}
			else if(qty>oldqty)
			{
				extra=qty-oldqty;
				logger.debug("Extra"+extra);			
				greaseform.setOldAvailable2(Float.toString(oldqty));
				greaseform.setOldRate2(Float.toString(oldrate));
				greaseform.setNewAvailable2(Float.toString(extra));
				greaseform.setNewRate2(Float.toString(newrate));
				amt=(extra*newrate)+(oldqty*oldrate);
			}
			greaseform.setTotalAvailableQuantity2(Float.toString(totalqty));
			greaseform.setTotalAmount2(Float.toString(amt));
		}
	logger.debug("GreaseAction:quantityMethod2---------->");
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
	public ActionForward quantityMethod3(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {
		logger.debug("GreaseAction:quantityMethod3<----------");
		GreaseForm greaseform=(GreaseForm)form;
		ArrayList partnumberList=new ArrayList();
		ArrayList greasedescList=new ArrayList();
	    String greasetype;
	if(StringUtils.isNotEmpty(greaseform.getWantedQuantity3()))
		{
			qty=Integer.parseInt(greaseform.getWantedQuantity3());
			greasetype=greaseform.getGreaseType3();
			greasedescList=greaseservice.convertToDesc(greasetype);
			greasedescvo=(GreaseVO)greasedescList.get(0);
			partnumberList=greaseservice.quantityMethod(greasedescvo.getDriverName());
			generalvo=(GreaseVO)partnumberList.get(0);	
			oldqty=Float.parseFloat(generalvo.getOldAvailable1());
			newqty=Float.parseFloat(generalvo.getNewAvailable1());
			oldrate=Float.parseFloat(generalvo.getOldRate1());
			newrate=Float.parseFloat(generalvo.getNewRate1());
			totalqty=oldqty+newqty;
					
			if(qty>totalqty)
			{
				logger.debug("Stock is very lower than required quantity");
			}
			else if(qty<=oldqty)
			{
				greaseform.setOldAvailable3(Float.toString(qty));
				greaseform.setOldRate3(Float.toString(oldrate));				
				greaseform.setNewAvailable3(null);
				greaseform.setNewRate3(null);	
				amt=qty*oldrate;
			}
			else if(qty>oldqty)
			{
				extra=qty-oldqty;
							
				greaseform.setOldAvailable3(Float.toString(oldqty));
				greaseform.setOldRate3(Float.toString(oldrate));
				greaseform.setNewAvailable3(Float.toString(extra));
				greaseform.setNewRate3(Float.toString(newrate));
				
				amt=(extra*newrate)+(oldqty*oldrate);
			}
			greaseform.setTotalAvailableQuantity3(Float.toString(totalqty));
			greaseform.setTotalAmount3(Float.toString(amt));
		}
	logger.debug("GreaseAction:quantityMethod3---------->");
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
	public ActionForward quantityMethod4(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {
		logger.debug("GreaseAction:quantityMethod4<----------");
		GreaseForm greaseform=(GreaseForm)form;
		ArrayList partnumberList=new ArrayList();
		ArrayList greasedescList=new ArrayList();
	    String greasetype;
	if(StringUtils.isNotEmpty(greaseform.getWantedQuantity4()))
		{
			qty=Integer.parseInt(greaseform.getWantedQuantity4());
			greasetype=greaseform.getGreaseType4();
			greasedescList=greaseservice.convertToDesc(greasetype);
			greasedescvo=(GreaseVO)greasedescList.get(0);
			partnumberList=greaseservice.quantityMethod(greasedescvo.getDriverName());
			generalvo=(GreaseVO)partnumberList.get(0);	
			oldqty=Float.parseFloat(generalvo.getOldAvailable1());
			newqty=Float.parseFloat(generalvo.getNewAvailable1());
			oldrate=Float.parseFloat(generalvo.getOldRate1());
			newrate=Float.parseFloat(generalvo.getNewRate1());
			totalqty=oldqty+newqty;
					
			if(qty>totalqty)
			{
				logger.debug("Stock is very lower than required quantity");
			}
			else if(qty<=oldqty)
			{
				greaseform.setOldAvailable4(Float.toString(qty));
				greaseform.setOldRate4(Float.toString(oldrate));
				greaseform.setNewAvailable4(null);
				greaseform.setNewRate4(null);	
				amt=qty*oldrate;
			}
			else if(qty>oldqty)
			{
				extra=qty-oldqty;
							
				greaseform.setOldAvailable4(Float.toString(oldqty));
				greaseform.setOldRate4(Float.toString(oldrate));
				greaseform.setNewAvailable4(Float.toString(extra));
				greaseform.setNewRate4(Float.toString(newrate));
				
				amt=(extra*newrate)+(oldqty*oldrate);
			}
			greaseform.setTotalAvailableQuantity4(Float.toString(totalqty));
			greaseform.setTotalAmount4(Float.toString(amt));
		}
	logger.debug("GreaseAction:quantityMethod4---------->");
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
	public ActionForward quantityMethod5(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {
		logger.debug("GreaseAction:quantityMethod5<----------");
		GreaseForm greaseform=(GreaseForm)form;
		ArrayList partnumberList=new ArrayList();
		ArrayList greasedescList=new ArrayList();
	    String greasetype;
	if(StringUtils.isNotEmpty(greaseform.getWantedQuantity5()))
		{
			qty=Integer.parseInt(greaseform.getWantedQuantity5());
			greasetype=greaseform.getGreaseType5();
			greasedescList=greaseservice.convertToDesc(greasetype);
			greasedescvo=(GreaseVO)greasedescList.get(0);
			partnumberList=greaseservice.quantityMethod(greasedescvo.getDriverName());
			generalvo=(GreaseVO)partnumberList.get(0);	
			oldqty=Float.parseFloat(generalvo.getOldAvailable1());
			newqty=Float.parseFloat(generalvo.getNewAvailable1());
			oldrate=Float.parseFloat(generalvo.getOldRate1());
			newrate=Float.parseFloat(generalvo.getNewRate1());
			totalqty=oldqty+newqty;
					
			if(qty>totalqty)
			{
				logger.debug("Stock is very lower than required quantity");
			}
			else if(qty<=oldqty)
			{
				greaseform.setOldAvailable5(Float.toString(qty));
				greaseform.setOldRate5(Float.toString(oldrate));				
				greaseform.setNewAvailable5(null);
				greaseform.setNewRate5(null);	
				amt=qty*oldrate;
			}
			else if(qty>oldqty)
			{
				extra=qty-oldqty;
							
				greaseform.setOldAvailable5(Float.toString(oldqty));
				greaseform.setOldRate5(Float.toString(oldrate));
				greaseform.setNewAvailable5(Float.toString(extra));
				greaseform.setNewRate5(Float.toString(newrate));
				
				amt=(extra*newrate)+(oldqty*oldrate);
			}
			greaseform.setTotalAvailableQuantity5(Float.toString(totalqty));
			greaseform.setTotalAmount5(Float.toString(amt));
		}
	logger.debug("GreaseAction:quantityMethod5---------->");
		return mapping.findForward("load");
	}
	/**
	 * to create the job and task
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
		logger.debug("GreaseAction:jobMethod---------->");
		String reqName="GreaseIssue";
		HttpSession session = ((HttpServletRequest) request).getSession();
		String userName=(String) session.getAttribute("userId");
		String ss1=mapping.getName();
		jobid=jb.creatJob(ss1,userName,reqName);
		saveMethod(jobid,form);
		logger.debug("insert executed");
		logger.debug("GreaseAction:jobMethod<----------");
		return mapping.findForward("load");
	}
	/**
	 * to insert the values in table
	 * @param jobid
	 * @param form
	 * @throws Exception
	 */
	public void saveMethod(int jobid,ActionForm form)
			throws Exception {
		logger.debug("GreaseAction:saveMethod<----------");
		GreaseForm greaseform=(GreaseForm)form;
		
		PropertyUtils.copyProperties(generalvo,greaseform);
		int ITEM_TYPE=0;
		float AVAILABLE_QTY=0,QTY_WANTED=0,IQTY_OLD=0;
		float IQTY_NEW=0,URATE_OLD=0,URATE_NEW=0,AMOUNT=0;
		int REASON_REQ=0;
		int driverName,REQ_DRIVERNAME,GOODS_TYPE,PLACE,SERVICE_STATION;
		int INSTITUTION_NAME=Integer.parseInt(generalvo.getInstitutionName());
		int VEHICLE_TYPE=Integer.parseInt(generalvo.getVehicleType());
		int VEHICLE_NUMBER=Integer.parseInt(generalvo.getVehicleNumber());
		int BILL_NUMBER=Integer.parseInt(generalvo.getBillNumber());
		String REQ_DATE =generalvo.getRequestedDate();
		
		String DRIVERNAME=generalvo.getDriverName();
		driverName=greaseservice.convertToCode(DRIVERNAME);
		PLACE=greaseservice.convertToPlaceCode(place,servicestation);
		SERVICE_STATION=greaseservice.convertToCode(servicestation);		
		String REQDRIVERNAME=greaseform.getRequestedDriverName();
		REQ_DRIVERNAME=greaseservice.convertToCode(REQDRIVERNAME);
			
		String OTHER_PURPOSE=generalvo.getOtherPurpose();
		GOODS_TYPE=greaseservice.convertToCode(itemname);
		float TotalAmount=Float.parseFloat(greaseform.getTotalAmount());
		
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
		try
	    {
			greaseservice.insertmaster(jobid,INSTITUTION_NAME,VEHICLE_TYPE,VEHICLE_NUMBER,BILL_NUMBER,REQ_DATE,driverName,OTHER_PURPOSE,REQ_DRIVERNAME,GOODS_TYPE,TotalAmount,PLACE,SERVICE_STATION);
	   		logger.debug("Grease MASTER");
	    }
	    catch(Exception e)
	    {
	    	logger.debug("error"+e);
	    }
		if(!StringUtils.isEmpty(greaseform.getWantedQuantity1()))
		{
			ITEM_TYPE=Integer.parseInt(greaseform.getGreaseType1());
			descList=greaseservice.convertToDesc(greaseform.getGreaseType1());
			drivernamevo=(GreaseVO)descList.get(0);
			itemtype1=drivernamevo.getDriverName();
			AVAILABLE_QTY=Float.parseFloat(greaseform.getTotalAvailableQuantity1());
			QTY_WANTED=Float.parseFloat(greaseform.getWantedQuantity1()) ;
			IQTY_OLD=Float.parseFloat(greaseform.getOldAvailable1());
			IQTY_NEW=Float.parseFloat(greaseform.getNewAvailable1());
			URATE_OLD=Float.parseFloat(greaseform.getOldRate1());
			URATE_NEW=Float.parseFloat(greaseform.getNewRate1());
			AMOUNT=Float.parseFloat(greaseform.getTotalAmount1());
			REASON_REQ=Integer.parseInt(greaseform.getGreaseReason1());
			toldqty=oldqty-IQTY_OLD;
			tnewqty=newqty-IQTY_NEW;
			greaseservice.insert(jobid,ITEM_TYPE,AVAILABLE_QTY,QTY_WANTED,IQTY_OLD,IQTY_NEW,URATE_OLD,URATE_NEW,AMOUNT,REASON_REQ);
			greaseservice.updateValues(toldqty,tnewqty,itemname,itemtype1);
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
			greaseservice.updateExtra(toldqty,tnewqty,oldrate,newrate,itemname,itemtype1);		  
		}	
		if(!StringUtils.isEmpty(greaseform.getWantedQuantity2()))
		{
			ITEM_TYPE=Integer.parseInt(greaseform.getGreaseType2());
			descList=greaseservice.convertToDesc(greaseform.getGreaseType2());
			drivernamevo=(GreaseVO)descList.get(0);
			itemtype2=drivernamevo.getDriverName();
			AVAILABLE_QTY=Float.parseFloat(greaseform.getTotalAvailableQuantity2());
			QTY_WANTED=Float.parseFloat(greaseform.getWantedQuantity2()) ;
			IQTY_OLD=Float.parseFloat(greaseform.getOldAvailable2());
			IQTY_NEW=Float.parseFloat(greaseform.getNewAvailable2());
			URATE_OLD=Float.parseFloat(greaseform.getOldRate2());
			URATE_NEW=Float.parseFloat(greaseform.getNewRate2());
			AMOUNT=Float.parseFloat(greaseform.getTotalAmount2());
			REASON_REQ=Integer.parseInt(greaseform.getGreaseReason2());
			toldqty=oldqty-IQTY_OLD;
			tnewqty=newqty-IQTY_NEW;
				greaseservice.insert(jobid,ITEM_TYPE,AVAILABLE_QTY,QTY_WANTED,IQTY_OLD,IQTY_NEW,URATE_OLD,URATE_NEW,AMOUNT,REASON_REQ);
				greaseservice.updateValues(toldqty,tnewqty,itemname,itemtype2);
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
				greaseservice.updateExtra(toldqty,tnewqty,oldrate,newrate,itemname,itemtype2);
		    	
		    }
		if(!StringUtils.isEmpty(greaseform.getWantedQuantity3()))
		{
			ITEM_TYPE=Integer.parseInt(greaseform.getGreaseType3());
			descList=greaseservice.convertToDesc(greaseform.getGreaseType3());
			drivernamevo=(GreaseVO)descList.get(0);
			itemtype3=drivernamevo.getDriverName();
			AVAILABLE_QTY=Float.parseFloat(greaseform.getTotalAvailableQuantity3());
			QTY_WANTED=Float.parseFloat(greaseform.getWantedQuantity3()) ;
			IQTY_OLD=Float.parseFloat(greaseform.getOldAvailable3());
			IQTY_NEW=Float.parseFloat(greaseform.getNewAvailable3());
			URATE_OLD=Float.parseFloat(greaseform.getOldRate3());
			URATE_NEW=Float.parseFloat(greaseform.getNewRate3());
			AMOUNT=Float.parseFloat(greaseform.getTotalAmount3());
			REASON_REQ=Integer.parseInt(greaseform.getGreaseReason3());
			toldqty=oldqty-IQTY_OLD;
			tnewqty=newqty-IQTY_NEW;
				greaseservice.insert(jobid,ITEM_TYPE,AVAILABLE_QTY,QTY_WANTED,IQTY_OLD,IQTY_NEW,URATE_OLD,URATE_NEW,AMOUNT,REASON_REQ);
				greaseservice.updateValues(toldqty,tnewqty,itemname,itemtype3);
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
				greaseservice.updateExtra(toldqty,tnewqty,oldrate,newrate,itemname,itemtype3);
		   
		}	
		if(!StringUtils.isEmpty(greaseform.getWantedQuantity4()))
		{
			ITEM_TYPE=Integer.parseInt(greaseform.getGreaseType4());
			descList=greaseservice.convertToDesc(greaseform.getGreaseType4());
			drivernamevo=(GreaseVO)descList.get(0);
			itemtype4=drivernamevo.getDriverName();
			AVAILABLE_QTY=Float.parseFloat(greaseform.getTotalAvailableQuantity4());
			QTY_WANTED=Float.parseFloat(greaseform.getWantedQuantity4()) ;
			IQTY_OLD=Float.parseFloat(greaseform.getOldAvailable4());
			IQTY_NEW=Float.parseFloat(greaseform.getNewAvailable4());
			URATE_OLD=Float.parseFloat(greaseform.getOldRate4());
			URATE_NEW=Float.parseFloat(greaseform.getNewRate4());
			AMOUNT=Float.parseFloat(greaseform.getTotalAmount4());
			REASON_REQ=Integer.parseInt(greaseform.getGreaseReason4());
			toldqty=oldqty-IQTY_OLD;
			tnewqty=newqty-IQTY_NEW;
				greaseservice.insert(jobid,ITEM_TYPE,AVAILABLE_QTY,QTY_WANTED,IQTY_OLD,IQTY_NEW,URATE_OLD,URATE_NEW,AMOUNT,REASON_REQ);
				greaseservice.updateValues(toldqty,tnewqty,itemname,itemtype4);
			    logger.debug("OIL4 INSERT");
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
					greaseservice.updateExtra(toldqty,tnewqty,oldrate,newrate,itemname,itemtype4);
		    	
		   
		}	
		if(!StringUtils.isEmpty(greaseform.getWantedQuantity5()))
		{
			ITEM_TYPE=Integer.parseInt(greaseform.getGreaseType5());
			descList=greaseservice.convertToDesc(greaseform.getGreaseType5());
			drivernamevo=(GreaseVO)descList.get(0);
			itemtype5=drivernamevo.getDriverName();
			AVAILABLE_QTY=Float.parseFloat(greaseform.getTotalAvailableQuantity5());
			QTY_WANTED=Float.parseFloat(greaseform.getWantedQuantity5()) ;
			IQTY_OLD=Float.parseFloat(greaseform.getOldAvailable5());
			IQTY_NEW=Float.parseFloat(greaseform.getNewAvailable5());
			URATE_OLD=Float.parseFloat(greaseform.getOldRate5());
			URATE_NEW=Float.parseFloat(greaseform.getNewRate5());
			AMOUNT=Float.parseFloat(greaseform.getTotalAmount5());
			REASON_REQ=Integer.parseInt(greaseform.getGreaseReason5());
			toldqty=oldqty-IQTY_OLD;
			tnewqty=newqty-IQTY_NEW;
				greaseservice.insert(jobid,ITEM_TYPE,AVAILABLE_QTY,QTY_WANTED,IQTY_OLD,IQTY_NEW,URATE_OLD,URATE_NEW,AMOUNT,REASON_REQ);
				greaseservice.updateValues(toldqty,tnewqty,itemname,itemtype5);
			    logger.debug("OIL5 INSERT");
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
				greaseservice.updateExtra(toldqty,tnewqty,oldrate,newrate,itemname,itemtype5);
		    	
		   
		}	
		logger.debug("GreaseAction:saveMethod---------->");
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
		logger.debug("GreaseAction:inboxMethod---------->");
		GreaseForm greaseform=(GreaseForm)form;
		clear(form);
		HttpSession session = ((HttpServletRequest) request).getSession();
		int job=(Integer)session.getAttribute("jobseq");
		ArrayList instList=new ArrayList();
		ArrayList typeList=new ArrayList();
		ArrayList vehicleList=new ArrayList();
		ArrayList retrieveList=new ArrayList();
		ArrayList retrivemasterList=new ArrayList();
		ArrayList greaseList=new ArrayList();
		ArrayList greaseReasonList=new ArrayList();
		ArrayList descList=new ArrayList();
		
		retrivemasterList=greaseservice.retrieveMaster(job);
	    retrieveList=greaseservice.retrieve(job);
	    GreaseVO vo1=new GreaseVO();	
	    GreaseVO vo=new GreaseVO();
	    vo1=(GreaseVO)retrivemasterList.get(0);
	    vo=(GreaseVO)retrieveList.get(0);
	    
	    instList=greaseservice.fetchInst();
		typeList=greaseservice.fetchType();
		vehicleList=greaseservice.fetchVehicle();
		
		greaseform.setInstList(instList);
		greaseform.setTypeList(typeList);
		greaseform.setVehicleList(vehicleList);
		
		greaseList=greaseservice.fetchGrease();
		greaseReasonList=greaseservice.fetchGreaseReason();
		
		greaseform.setGreaseList(greaseList);
		greaseform.setGreaseReasonList(greaseReasonList);
	    greaseform.setInstitutionName(vo1.getInstitutionName());
	    logger.debug("InstitutionName"+vo1.getInstitutionName());
	    greaseform.setVehicleType(vo1.getVehicleType());
	    logger.debug("VehicleType"+vo1.getVehicleType());
	    greaseform.setVehicleNumber(vo1.getVehicleNumber());
	    logger.debug("VehicleNumber"+vo1.getVehicleNumber());
	 
	    greaseform.setBillNumber(vo1.getBillNumber());
	    logger.debug("BillNumber"+vo1.getBillNumber());
	    greaseform.setRequestedDate(vo1.getRequestedDate());
	    logger.debug("RequestedDate"+vo1.getRequestedDate());
	    greaseform.setOtherPurpose(vo1.getOtherPurpose());
	    logger.debug("Other"+vo1.getOtherPurpose());
	    
	    String drivercode=vo1.getDriverName();
	    descList=greaseservice.convertToDesc(drivercode);
	    drivernamevo=(GreaseVO)descList.get(0);
	    greaseform.setDriverName(drivernamevo.getDriverName());
	    
	    String reqdrivercode=vo1.getRequestedDriverName();
	    descList=greaseservice.convertToDesc(reqdrivercode);
	    greasedvo=(GreaseVO)descList.get(0);
	    greaseform.setRequestedDriverName(greasedvo.getDriverName());
	    logger.debug("RequestedDriverName"+greasedvo.getDriverName());
	    
	    for(int i=0;i<retrieveList.size();i++)
	    {
	    	vo=(GreaseVO)retrieveList.get(i);
		  	  switch(i)
		  	  {
		  	  	case 0:
		  	  	{
		  	  		greaseform.setGreaseType1(vo.getGreaseType1());
		  	  		greaseform.setGreaseReason1(vo.getGreaseReason1());
		  	  		greaseform.setWantedQuantity1(vo.getWantedQuantity1());
		  	  		greaseform.setTotalAvailableQuantity1(vo.getTotalAvailableQuantity1());
		  	  		greaseform.setOldAvailable1(vo.getOldAvailable1());
		  	  		greaseform.setNewAvailable1(vo.getNewAvailable1());
		  	  		greaseform.setNewRate1(vo.getNewRate1());
		  	  		greaseform.setTotalAmount1(vo.getTotalAmount1());
		  	  		break;
		  	  	}
		  		case 1:
		  	  	{
		  	  		greaseform.setGreaseType2(vo.getGreaseType1());
		  	  		greaseform.setGreaseReason2(vo.getGreaseReason1());
		  	  		greaseform.setWantedQuantity2(vo.getWantedQuantity1());
		  	  		greaseform.setTotalAvailableQuantity2(vo.getTotalAvailableQuantity1());
		  	  		greaseform.setOldAvailable2(vo.getOldAvailable1());
		  	  		greaseform.setNewAvailable2(vo.getNewAvailable1());
		  	  		greaseform.setNewRate2(vo.getNewRate1());
		  	  		greaseform.setTotalAmount2(vo.getTotalAmount1());
		  	  		break;
		  	  	}
		  		case 2:
		  	  	{
		  	  		greaseform.setGreaseType3(vo.getGreaseType1());
		  	  		greaseform.setGreaseReason3(vo.getGreaseReason1());
		  	  		greaseform.setWantedQuantity3(vo.getWantedQuantity1());
		  	  		greaseform.setTotalAvailableQuantity3(vo.getTotalAvailableQuantity1());
		  	  		greaseform.setOldAvailable3(vo.getOldAvailable1());
		  	  		greaseform.setNewAvailable3(vo.getNewAvailable1());
		  	  		greaseform.setNewRate3(vo.getNewRate1());
		  	  		greaseform.setTotalAmount3(vo.getTotalAmount1());
		  	  		break;
		  	  	}
		  		case 3:
		  	  	{
		  	  		greaseform.setGreaseType4(vo.getGreaseType1());
		  	  		greaseform.setGreaseReason4(vo.getGreaseReason1());
		  	  		greaseform.setWantedQuantity4(vo.getWantedQuantity1());
		  	  		greaseform.setTotalAvailableQuantity4(vo.getTotalAvailableQuantity1());
		  	  		greaseform.setOldAvailable4(vo.getOldAvailable1());
		  	  		greaseform.setNewAvailable4(vo.getNewAvailable1());
		  	  		greaseform.setNewRate4(vo.getNewRate1());
		  	  		greaseform.setTotalAmount4(vo.getTotalAmount1());
		  	  		break;
		  	  	}
		  		case 4:
		  	  	{
		  	  		greaseform.setGreaseType5(vo.getGreaseType1());
		  	  		greaseform.setGreaseReason5(vo.getGreaseReason1());
		  	  		greaseform.setWantedQuantity5(vo.getWantedQuantity1());
		  	  		greaseform.setTotalAvailableQuantity5(vo.getTotalAvailableQuantity1());
		  	  		greaseform.setOldAvailable5(vo.getOldAvailable1());
		  	  		greaseform.setNewAvailable5(vo.getNewAvailable1());
		  	  		greaseform.setNewRate5(vo.getNewRate1());
		  	  		greaseform.setTotalAmount5(vo.getTotalAmount1());
		  	  		break;
		  	  	}
		  	  }
	    }
	    logger.debug("GreaseAction:inboxMethod<----------"); 	
	    return mapping.findForward("load");
	}
	/**
	 * to clear the values
	 * @param form
	 */
	public void clear(ActionForm form)
	{
		logger.debug("GreaseAction:clear<----------"); 
		GreaseForm greaseform=(GreaseForm)form;
		greaseform.setBillNumber(null);
		greaseform.setDriverName(null);
		greaseform.setInstitutionName(null);
		greaseform.setNewAvailable1(null);
		greaseform.setNewAvailable2(null);
		greaseform.setNewAvailable3(null);
		greaseform.setNewAvailable4(null);
		greaseform.setNewAvailable5(null);
		greaseform.setNewRate1(null);
		greaseform.setNewRate2(null);
		greaseform.setNewRate3(null);
		greaseform.setNewRate4(null);
		greaseform.setNewRate5(null);
		greaseform.setGreaseReason1(null);
		greaseform.setGreaseReason2(null);
		greaseform.setGreaseReason3(null);
		greaseform.setGreaseReason4(null);
		greaseform.setGreaseReason5(null);
		greaseform.setOldAvailable1(null);
		greaseform.setOldAvailable2(null);
		greaseform.setOldAvailable3(null);
		greaseform.setOldAvailable4(null);
		greaseform.setOldAvailable5(null);
		greaseform.setOldRate1(null);
		greaseform.setOldRate2(null);
		greaseform.setOldRate3(null);
		greaseform.setOldRate4(null);
		greaseform.setOldRate5(null);
		greaseform.setGreaseType1(null);
		greaseform.setGreaseType2(null);
		greaseform.setGreaseType3(null);
		greaseform.setGreaseType4(null);
		greaseform.setGreaseType5(null);
		greaseform.setOtherPurpose(null);
		greaseform.setRequestedDate(null);
		greaseform.setRequestedDriverName(null);
		greaseform.setTotalAmount1(null);
		greaseform.setTotalAmount2(null);
		greaseform.setTotalAmount3(null);
		greaseform.setTotalAmount4(null);
		greaseform.setTotalAmount5(null);
		greaseform.setTotalAvailableQuantity1(null);
		greaseform.setTotalAvailableQuantity2(null);
		greaseform.setTotalAvailableQuantity3(null);
		greaseform.setTotalAvailableQuantity4(null);
		greaseform.setTotalAvailableQuantity5(null);
		greaseform.setVehicleNumber(null);
		greaseform.setVehicleType(null);
		greaseform.setWantedQuantity1(null);
		greaseform.setWantedQuantity2(null);
		greaseform.setWantedQuantity3(null);
		greaseform.setWantedQuantity4(null);
		greaseform.setWantedQuantity5(null);
		logger.debug("GreaseAction:clear---------->");
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
	 * 
	 * @param jobid
	 * @param form
	 * @throws Exception
	 */
	public void updateValues(int jobid,ActionForm form) throws Exception
	{
		ArrayList quantityList=new ArrayList();
		if(!StringUtils.isEmpty(itemtype1))
		{
			quantityList=greaseservice.quantityMethod(itemtype1);
			generalvo=(GreaseVO)quantityList.get(0);
			oldqty=Integer.parseInt(generalvo.getOldAvailable1());
			newqty=Integer.parseInt(generalvo.getNewAvailable1());
			oldrate=Float.parseFloat(generalvo.getOldRate1());
			newrate=Float.parseFloat(generalvo.getNewRate1());		
			greaseservice.updateValuestemporary(oldqty,newqty,oldrate,newrate,itemname,itemtype1,jobid);
		}
		else if(!StringUtils.isEmpty(itemtype2))
		{
			quantityList=greaseservice.quantityMethod(itemtype2);
			generalvo=(GreaseVO)quantityList.get(0);
			oldqty=Integer.parseInt(generalvo.getOldAvailable1());
			newqty=Integer.parseInt(generalvo.getNewAvailable1());
			oldrate=Float.parseFloat(generalvo.getOldRate1());
			newrate=Float.parseFloat(generalvo.getNewRate1());		
			greaseservice.updateValuestemporary(oldqty,newqty,oldrate,newrate,itemname,itemtype2,jobid);
		}
		else if(!StringUtils.isEmpty(itemtype3))
		{
			quantityList=greaseservice.quantityMethod(itemtype3);
			generalvo=(GreaseVO)quantityList.get(0);
			oldqty=Integer.parseInt(generalvo.getOldAvailable1());
			newqty=Integer.parseInt(generalvo.getNewAvailable1());
			oldrate=Float.parseFloat(generalvo.getOldRate1());
			newrate=Float.parseFloat(generalvo.getNewRate1());		
			greaseservice.updateValuestemporary(oldqty,newqty,oldrate,newrate,itemname,itemtype3,jobid);
		}
		else if(!StringUtils.isEmpty(itemtype4))
		{
			quantityList=greaseservice.quantityMethod(itemtype4);
			generalvo=(GreaseVO)quantityList.get(0);
			oldqty=Integer.parseInt(generalvo.getOldAvailable1());
			newqty=Integer.parseInt(generalvo.getNewAvailable1());
			oldrate=Float.parseFloat(generalvo.getOldRate1());
			newrate=Float.parseFloat(generalvo.getNewRate1());		
			greaseservice.updateValuestemporary(oldqty,newqty,oldrate,newrate,itemname,itemtype4,jobid);
		}
		else if(!StringUtils.isEmpty(itemtype5))
		{
			quantityList=greaseservice.quantityMethod(itemtype5);
			generalvo=(GreaseVO)quantityList.get(0);
			oldqty=Integer.parseInt(generalvo.getOldAvailable1());
			newqty=Integer.parseInt(generalvo.getNewAvailable1());
			oldrate=Float.parseFloat(generalvo.getOldRate1());
			newrate=Float.parseFloat(generalvo.getNewRate1());		
			greaseservice.updateValuestemporary(oldqty,newqty,oldrate,newrate,itemname,itemtype5,jobid);
		}
		logger.debug("DieselAction:updateValues<---------->");
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
		GreaseForm greaseform=(GreaseForm)form;
		float amt1=0,amt2=0,amt3=0,amt4=0,amt5=0;
		if(!StringUtils.isEmpty(greaseform.getTotalAmount1()))
			amt1=Float.parseFloat(greaseform.getTotalAmount1());
		else
			amt1=0;
		if(!StringUtils.isEmpty(greaseform.getTotalAmount2()))
			amt2=Float.parseFloat(greaseform.getTotalAmount2());
		else
			amt2=0;
		if(!StringUtils.isEmpty(greaseform.getTotalAmount3()))
				amt3=Float.parseFloat(greaseform.getTotalAmount3());
		else
			amt3=0;
		if(!StringUtils.isEmpty(greaseform.getTotalAmount4()))
			amt4=Float.parseFloat(greaseform.getTotalAmount4());
		else
			amt4=0;
		if(!StringUtils.isEmpty(greaseform.getTotalAmount5()))
			amt5=Float.parseFloat(greaseform.getTotalAmount5());
		else
			amt5=0;
		float amount=amt1+amt2+amt3+amt4+amt5;
		greaseform.setTotalAmount(Float.toString(amount));
		return mapping.findForward("load");
	
	}
}
