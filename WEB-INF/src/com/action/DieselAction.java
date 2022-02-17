package com.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletResponse;

import com.formbean.DieselForm;
import com.service.DieselService;
import com.vo.DieselVO;


import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import com.wf.*;

public class DieselAction extends BaseDispatchAction{
	private static final Logger logger=(Logger)Logger.getLogger(DieselAction.class);
	job jb=new job();
	int jobid,itemcode=0;
	String itemname="Fuel";
	String itemtype="Diesel";
	String place="Perundurai";
	String servicestation="KVITT Workshop";
	DieselVO generalvo=new DieselVO();
	DieselVO drivernamevo=new DieselVO();
	DieselVO presentkmvo=new DieselVO();
	DieselService dieselservice=new DieselService();
	float newrate,oldrate=0,xrate=0;
	int newqty,oldqty=0,tnewqty,toldqty=0,xqty=0;
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
		logger.debug("DieselAction:defaultMethod<----------");
		clear(form);
		DieselForm dieselform=(DieselForm)form;
		ArrayList instList=new ArrayList();
		ArrayList stockList=new ArrayList();
		DieselService dieselservice=new DieselService();
		instList=dieselservice.fetchInst();
		stockList=dieselservice.fetchStock(itemtype);
		generalvo=(DieselVO)stockList.get(0);
		oldqty=Integer.parseInt(generalvo.getOldAvailable());
		newqty=Integer.parseInt(generalvo.getNewAvailable());
		int stock=newqty+oldqty;
		dieselform.setStock(Integer.toString(stock));
		dieselform.setInstList(instList);
		logger.debug("DieselAction:defaultMethod---------->");
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
		logger.debug("DieselAction:instMethod<----------");
		ArrayList instList=new ArrayList();
		DieselService dieselservice=new DieselService();
		DieselForm dieselform=(DieselForm)form;
		int instname=Integer.parseInt(dieselform.getInstitutionName());
		instList=dieselservice.instMethod(instname);
		dieselform.setTypeList(instList);
		logger.debug("DieselAction:instMethod---------->");
		return mapping.findForward("dieselretrive");
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
		logger.debug("DieselAction:vehicleMethod<----------");
		ArrayList vehicleList=new ArrayList();
		DieselService dieselservice=new DieselService();
		DieselForm dieselform=(DieselForm)form;
		int vehtype=Integer.parseInt(dieselform.getVehicleType());
		vehicleList=dieselservice.vehicleMethod(vehtype);
		dieselform.setVehicleList(vehicleList);
		logger.debug("DieselAction:vehicleMethod---------->");
		return mapping.findForward("dieselretrive");
		
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
		logger.debug("DieselAction:driverMethod<----------");
		ArrayList driverList=new ArrayList();
		ArrayList drivernameList=new ArrayList();
		ArrayList presentKMList=new ArrayList();
		DieselService dieselservice=new DieselService();
		DieselForm dieselform=(DieselForm)form;
		int vehnum=Integer.parseInt(dieselform.getVehicleNumber());
		driverList=dieselservice.driverMethod(vehnum);
		generalvo=(DieselVO)driverList.get(0);
		String driver_name=generalvo.getDriverName();
		drivernameList=dieselservice.convertToDesc(driver_name);
		itemcode=dieselservice.convertToCode(itemname);
		presentKMList=dieselservice.lastFillingKmMethod(Integer.toString(vehnum),itemcode);
		generalvo=(DieselVO)driverList.get(0);
		drivernamevo=(DieselVO)drivernameList.get(0);
		presentkmvo=(DieselVO)presentKMList.get(0);
		dieselform.setDriverName(drivernamevo.getDriverName());
		dieselform.setRouteNumber(generalvo.getRouteNumber());
		dieselform.setLastFillingKm(presentkmvo.getPresentKm());
		logger.debug("DieselAction:driverMethod---------->");
		return mapping.findForward("dieselretrive");
	}
	/**
	 * pass required quantity
	 * retrieves oldqty,newqty,oldrate,newrate,closing reading 
	 * calculates totalamount,Average Km
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward quantityMethod(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {
		logger.debug("DieselAction:quantityMethod<----------");
		DieselForm dieselform=(DieselForm)form;
		ArrayList quantityList=new ArrayList();
		//itemcode=dieselservice.convertToCode(itemtype);
		int qty=0;
		if(StringUtils.isNotEmpty(dieselform.getWantedQuantity()))
		{
		qty=Integer.parseInt(dieselform.getWantedQuantity());
		quantityList=dieselservice.quantityMethod(itemtype);
		generalvo=(DieselVO)quantityList.get(0);
		oldqty=Integer.parseInt(generalvo.getOldAvailable());
		newqty=Integer.parseInt(generalvo.getNewAvailable());
		oldrate=Float.parseFloat(generalvo.getOldRate());
		newrate=Float.parseFloat(generalvo.getNewRate());
		xqty=Integer.parseInt(generalvo.getExtraQty());
		xrate=Float.parseFloat(generalvo.getExtraRate());
		//int rlvl=Integer.parseInt(generalvo.getReorderLevel());
		int stock=oldqty+newqty;
		float amount=0;
		int close=0;
		if(qty>=stock)
		{
			logger.debug("Stock is very lower than required quantity");
			
		}
		else if(qty<=oldqty)
		{
			dieselform.setOldAvailable(Integer.toString(qty));
			dieselform.setOldRate(generalvo.getOldRate());
			amount=qty*oldrate;		
		}
		else
		{
			int extra=qty-oldqty;
			dieselform.setOldAvailable(generalvo.getOldAvailable());
			dieselform.setOldRate(generalvo.getOldRate());
			dieselform.setNewAvailable(Integer.toString(extra));
			dieselform.setNewRate(generalvo.getNewRate());
			amount=(extra*newrate)+(oldqty*oldrate);
		}
		dieselform.setTotalAmount(Float.toString(amount));
		dieselform.setStock(Integer.toString(stock));
		quantityList=dieselservice.differenceMethod();
		if (quantityList.size()==0)
			close=0;
		else
		{
		generalvo=(DieselVO)quantityList.get(0);
		close=Integer.parseInt(generalvo.getClosingReading());
		}
		dieselform.setOpeningReading(Integer.toString(close));
		int openReading=close;
		int closeReading=qty+openReading;
		dieselform.setClosingReading(Integer.toString(closeReading));
		dieselform.setConsumptionLitres(Integer.toString(qty));
		int balance=stock-qty;
		dieselform.setBalance(Integer.toString(balance));
		}
		logger.debug("DieselAction:quantityMethod---------->");
		return mapping.findForward("load");	
	}
	/**
	 * retrieve presentkm and last filling km
	 * calculates difference
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward differenceMethod(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {
		logger.debug("DieselAction:differenceMethod<----------");
		DieselForm dieselform=(DieselForm)form;
		int presentKm=Integer.parseInt(dieselform.getPresentKm());
		int lastKm=Integer.parseInt(dieselform.getLastFillingKm());
		int qty=Integer.parseInt(dieselform.getWantedQuantity());
		int diffKm=presentKm-lastKm;
		dieselform.setDifferenceKm(Integer.toString(diffKm));
		float avgKm=diffKm/qty;
		dieselform.setAverageKm(Float.toString(avgKm));
		logger.debug("DieselAction:differenceMethod---------->");
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
		logger.debug("DieselAction:jobMethod<----------");
		String reqName="DieselIssue";
		HttpSession session = ((HttpServletRequest) request).getSession();
		String userName=(String) session.getAttribute("userId");
		String jobName=mapping.getName();
		jobid=jb.creatJob(jobName,userName,reqName);
		saveMethod(jobid,form);
		logger.debug("DieselAction:jobMethod---------->");
		return mapping.findForward("dieselinsert");
	
	}
	/**
	 * to insert the values in table
	 * @param jobid
	 * @param form
	 * @throws Exception
	 */
	public void saveMethod(int jobid,ActionForm form)
			throws Exception {
		logger.debug("DieselAction:saveMethod<----------");
		DieselVO insertvo=new DieselVO();
		DieselForm df=(DieselForm)form;
		PropertyUtils.copyProperties(insertvo,df);
		int QTY_WANTED,IQTY_NEW=0,IQTY_OLD=0,BALANCE,CLOSE_READING,STOCK;
		int OPEN_READING,LAST_KM,PRESENTKM,DIFF_KM,CONSUMTION_LITERS;
		int driverName,REQ_DRIVERNAME,GOODS_TYPE,SERVICE_STATION,PLACE;
		float AVG_KM,AMOUNT,URATE_NEW,URATE_OLD;
		QTY_WANTED=Integer.parseInt(insertvo.getWantedQuantity());
		IQTY_OLD=Integer.parseInt(insertvo.getOldAvailable());
		IQTY_NEW=Integer.parseInt(insertvo.getNewAvailable());
		BALANCE=Integer.parseInt(insertvo.getBalance());
		CLOSE_READING=Integer.parseInt(insertvo.getClosingReading());
		STOCK=Integer.parseInt(insertvo.getStock());
		String REMARKS=insertvo.getRemark();
		OPEN_READING=Integer.parseInt(insertvo.getOpeningReading());
		AVG_KM=Float.parseFloat(insertvo.getAverageKm());
		LAST_KM =Integer.parseInt(insertvo.getLastFillingKm());
		PRESENTKM=Integer.parseInt(insertvo.getPresentKm());
		DIFF_KM=Integer.parseInt(insertvo.getDifferenceKm());
		AMOUNT=Float.parseFloat(insertvo.getTotalAmount());
		URATE_NEW=Float.parseFloat(insertvo.getNewRate());
		URATE_OLD=Float.parseFloat(insertvo.getOldRate());
		CONSUMTION_LITERS=Integer.parseInt(insertvo.getConsumptionLitres());
		
		int INSTITUTION_NAME=Integer.parseInt(insertvo.getInstitutionName());
		int VEHICLE_TYPE=Integer.parseInt(insertvo.getVehicleType());
		int VEHICLE_NUMBER=Integer.parseInt(insertvo.getVehicleNumber());
		int BILL_NUMBER=Integer.parseInt(insertvo.getBillNumber());
		String REQ_DATE =insertvo.getRequestedDate();
		String OTHER_PURPOSE=insertvo.getOtherPurpose();
		
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
		
		if(REMARKS=="")
		{
			REMARKS="null";
		}
		
		int ROUTE_NUMBER=Integer.parseInt(insertvo.getRouteNumber());
		
		String DRIVERNAME=df.getDriverName();
		driverName=dieselservice.convertToCode(DRIVERNAME);
		GOODS_TYPE=dieselservice.convertToCode(itemname);
		PLACE=dieselservice.convertToPlaceCode(place,servicestation);
		SERVICE_STATION=dieselservice.convertToCode(servicestation);
		String REQDRIVERNAME=df.getRequestedDriverName();
		REQ_DRIVERNAME=dieselservice.convertToCode(REQDRIVERNAME);
		dieselservice.insertmaster(jobid,INSTITUTION_NAME,VEHICLE_TYPE,VEHICLE_NUMBER,BILL_NUMBER,REQ_DATE,driverName,OTHER_PURPOSE,REQ_DRIVERNAME,ROUTE_NUMBER,GOODS_TYPE,AMOUNT,PLACE,SERVICE_STATION);
		dieselservice.insert(jobid,QTY_WANTED,IQTY_OLD,IQTY_NEW,URATE_OLD,URATE_NEW,AMOUNT,PRESENTKM,LAST_KM,DIFF_KM,AVG_KM,REMARKS,STOCK,OPEN_READING,CLOSE_READING,BALANCE,CONSUMTION_LITERS);
		toldqty=oldqty-IQTY_OLD;
		tnewqty=newqty-IQTY_NEW;
		dieselservice.updateValues(toldqty,tnewqty,itemname,itemtype);
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
		dieselservice.updateExtra(toldqty,tnewqty,oldrate,newrate,itemname,itemtype);
		logger.debug("DieselAction:saveMethod---------->");
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
		logger.debug("DieselAction:inboxMethod<----------");
		DieselForm dieselform=(DieselForm)form;
		clear(form);
		ArrayList instList=new ArrayList();
		ArrayList typeList=new ArrayList();
		ArrayList vehicleList=new ArrayList();
		ArrayList retriveList=new ArrayList();
		ArrayList retrievemasterList=new ArrayList();
		ArrayList driverdesclist=new ArrayList();
		ArrayList reqdriverdesclist=new ArrayList();
		
		DieselService dieselservice=new DieselService();
				
		instList=dieselservice.fetchInst();
		typeList=dieselservice.fetchType();
		vehicleList=dieselservice.fetchVehicle();
		
		dieselform.setInstList(instList);
		dieselform.setTypeList(typeList);
		dieselform.setVehicleList(vehicleList);
				
		HttpSession session = ((HttpServletRequest) request).getSession();
		int job=(Integer)session.getAttribute("jobseq");
		
		retrievemasterList=dieselservice.retrieveMaster(job);
	    retriveList=dieselservice.retrieve(job);
	       
	    DieselVO retrievemastervo=new DieselVO();	
	    DieselVO retrievevo=new DieselVO();	
	    DieselVO drivernamevo=new DieselVO();
	    retrievemastervo=(DieselVO)retrievemasterList.get(0);
	    retrievevo=(DieselVO)retriveList.get(0);
	  
	    dieselform.setAverageKm(retrievevo.getAverageKm());
	    dieselform.setBalance(retrievevo.getBalance());
	    dieselform.setBillNumber(retrievemastervo.getBillNumber());
	    dieselform.setClosingReading(retrievevo.getClosingReading());
	    dieselform.setOldAvailable(retrievevo.getOldAvailable());
	    dieselform.setConsumptionLitres(retrievevo.getConsumptionLitres());
	    dieselform.setDifferenceKm(retrievevo.getDifferenceKm());
	        
	    String drivercode=retrievemastervo.getDriverName();
	    driverdesclist=dieselservice.convertToDesc(drivercode);
	    drivernamevo=(DieselVO)driverdesclist.get(0);
	    dieselform.setDriverName(drivernamevo.getDriverName());
		
	    dieselform.setInstitutionName(retrievemastervo.getInstitutionName());
	    dieselform.setLastFillingKm(retrievevo.getLastFillingKm());
	    dieselform.setNewAvailable(retrievevo.getNewAvailable());
	    dieselform.setNewRate(retrievevo.getNewRate());
	    dieselform.setOldRate(retrievevo.getOldRate());
	    dieselform.setOpeningReading(retrievevo.getOpeningReading());
	    dieselform.setOtherPurpose(retrievemastervo.getOtherPurpose());
	    dieselform.setPresentKm(retrievevo.getPresentKm());
	    dieselform.setRemark(retrievevo.getRemark());
	    dieselform.setRequestedDate(retrievemastervo.getRequestedDate());
	       
	    String reqdrivercode=retrievemastervo.getRequestedDriverName();
	    reqdriverdesclist=dieselservice.convertToDesc(reqdrivercode);
	    drivernamevo=(DieselVO)reqdriverdesclist.get(0);
	    dieselform.setRequestedDriverName(drivernamevo.getDriverName());
	    
	    dieselform.setRouteNumber(retrievemastervo.getRouteNumber());
	    dieselform.setWantedQuantity(retrievevo.getWantedQuantity());
	    dieselform.setStock(retrievevo.getStock());
	    dieselform.setTotalAmount(retrievevo.getTotalAmount());
	    dieselform.setVehicleNumber(retrievemastervo.getVehicleNumber());
	    dieselform.setVehicleType(retrievemastervo.getVehicleType());
	    logger.debug("DieselAction:inboxMethod---------->");
	    return mapping.findForward("load");
	}
	/**
	 * to clear the values
	 * @param form
	 */
	public void clear(ActionForm form)
	{
		logger.debug("DieselAction:clear<----------");
		DieselForm dieselform=(DieselForm)form;
		dieselform.setAverageKm(null);
		dieselform.setBalance(null);
		dieselform.setBillNumber(null);
		dieselform.setClosingReading(null);
		dieselform.setConsumptionLitres(null);
		dieselform.setDifferenceKm(null);
		dieselform.setDriverName(null);
		dieselform.setInstitutionName(null);
		dieselform.setLastFillingKm(null);
		dieselform.setNewAvailable(null);
		dieselform.setNewRate(null);
		dieselform.setOldAvailable(null);
		dieselform.setOldRate(null);
		dieselform.setOpeningReading(null);
		dieselform.setRemark(null);
		dieselform.setRequestedDriverName(null);
		dieselform.setRouteNumber(null);
		dieselform.setRequestedDate(null);
		dieselform.setPresentKm(null);
		dieselform.setStock(null);
		dieselform.setOtherPurpose(null);
		logger.debug("DieselAction:clear---------->");
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
			logger.debug("DieselAction:approveMethod<----------");
			HttpSession session = ((HttpServletRequest) request).getSession();
			int job=(Integer)session.getAttribute("jobseq");
			int task=(Integer)session.getAttribute("taskseqseq");
			jb.approveStatus(job,task);
			logger.debug("DieselAction:approveMethod---------->");
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
			logger.debug("DieselAction:okMethod<----------");
			HttpSession session = ((HttpServletRequest) request).getSession();
			int job=(Integer)session.getAttribute("jobseq");
			int task=(Integer)session.getAttribute("taskseqseq");
			jb.okStatus(job,task);
			updateValues(job,form);
			logger.debug("DieselAction:okMethod---------->");
			return mapping.findForward("load");
	}
	public void updateValues(int jobid,ActionForm form) throws Exception
	{
		ArrayList quantityList=new ArrayList();
		quantityList=dieselservice.quantityMethod(itemtype);
		generalvo=(DieselVO)quantityList.get(0);
		oldqty=Integer.parseInt(generalvo.getOldAvailable());
		newqty=Integer.parseInt(generalvo.getNewAvailable());
		oldrate=Float.parseFloat(generalvo.getOldRate());
		newrate=Float.parseFloat(generalvo.getNewRate());		
		dieselservice.updateValuestemporary(oldqty,newqty,oldrate,newrate,itemname,itemtype,jobid);
		logger.debug("DieselAction:updateValues<---------->");
		
	}
}

