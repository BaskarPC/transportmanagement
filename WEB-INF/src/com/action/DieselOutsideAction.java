package com.action;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.formbean.DieselOutsideForm;
import com.wf.*;
import com.service.DieselOutsideService;
import com.vo.DieselOutsideVO;





public class DieselOutsideAction extends BaseDispatchAction{
	private static final Logger logger=(Logger)Logger.getLogger(DieselOutsideAction.class);
	job jb=new job();
	String itemname="Fuel";
	int jobid,itemcode=0;
	DieselOutsideService dieseloutsideservice=new DieselOutsideService();
	DieselOutsideVO generalvo=new DieselOutsideVO();
	DieselOutsideVO presentkmvo=new DieselOutsideVO();
	
	/**
	 * 
	 */
	public ActionForward defaultMethod(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {
		logger.debug("DieselOutsideAction:defaultMethod<----------");
		DieselOutsideForm dieseloutsideform=(DieselOutsideForm)form;
		ArrayList instList=new ArrayList();
		ArrayList fuelList=new ArrayList();
		instList=dieseloutsideservice.fetchInst();
		fuelList=dieseloutsideservice.fetchFuel();
		dieseloutsideform.setInstList(instList);
		dieseloutsideform.setFuelList(fuelList);
		logger.debug("DieselOutsideAction:defaultMethod---------->");
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
		logger.debug("DieselOutsideAction:instMethod<----------");
		ArrayList typeList=new ArrayList();
		DieselOutsideForm dieseloutsideform=(DieselOutsideForm)form;
		int instname=Integer.parseInt(dieseloutsideform.getInstitutionName());
		typeList=dieseloutsideservice.instMethod(instname);
		dieseloutsideform.setTypeList(typeList);
		logger.debug("DieselOutsideAction:instMethod---------->");
		return mapping.findForward("dieselretrive");
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
		logger.debug("DieselOutsideAction:vehicleMethod<----------");
		ArrayList vehicleList=new ArrayList();
		DieselOutsideForm dieseloutsideform=(DieselOutsideForm)form;
		int vehtype=Integer.parseInt(dieseloutsideform.getVehicleType());
		vehicleList=dieseloutsideservice.vehicleMethod(vehtype);
		dieseloutsideform.setVehicleList(vehicleList);
		logger.debug("DieselOutsideAction:vehicleMethod---------->");
		return mapping.findForward("dieselretrive");
		
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
		logger.debug("DieselOutsideAction:driverMethod<----------");
		ArrayList vehicleList=new ArrayList();
		DieselOutsideForm dieseloutsideform=(DieselOutsideForm)form;
		int vehnum=Integer.parseInt(dieseloutsideform.getVehicleNumber());
		vehicleList=dieseloutsideservice.driverMethod(vehnum);
		generalvo=(DieselOutsideVO)vehicleList.get(0);
		dieseloutsideform.setDriverName(generalvo.getDriverName());
		dieseloutsideform.setRouteNumber(generalvo.getRouteNumber());
		logger.debug("DieselOutsideAction:driverMethod---------->");
		return mapping.findForward("dieselretrive");
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
	public ActionForward lastFillingKMMethod(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {
		logger.debug("DieselOutsideAction:lastFillingKMMethod<----------");
		ArrayList lastFillingKmList=new ArrayList();
		DieselOutsideForm dieseloutsideform=(DieselOutsideForm)form;
		int vehnum=Integer.parseInt(dieseloutsideform.getVehicleNumber());
		int code=dieseloutsideservice.convertToCode(itemname);
		lastFillingKmList=dieseloutsideservice.lastFillingKmMethod(Integer.toString(vehnum),code);
		presentkmvo=(DieselOutsideVO)lastFillingKmList.get(0);
		logger.debug("Present KM:"+presentkmvo.getPresentKm());
		dieseloutsideform.setLastFillingKm(presentkmvo.getPresentKm());
		logger.debug("DieselOutsideAction:lastFillingKMMethod---------->");
		return mapping.findForward("dieselretrive");
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
	
	public ActionForward quantityMethod(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {
		logger.debug("DieselOutsideAction:quantityMethod<----------");
		DieselOutsideForm dieseloutsideform=(DieselOutsideForm)form;
		float qty=Float.parseFloat(dieseloutsideform.getWantedQuantity());
		float rate=Float.parseFloat(dieseloutsideform.getUnitRate());
		float amount=qty*rate;	
		dieseloutsideform.setTotalAmount(Float.toString(amount));
		logger.debug("DieselOutsideAction:quantityMethod---------->");
		return mapping.findForward("dieselretrive");
	
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
	public ActionForward differenceMethod(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {
		logger.debug("DieselOutsideAction:differenceMethod<----------");
		DieselOutsideForm dieseloutsideform=(DieselOutsideForm)form;
		int presentKm=Integer.parseInt(dieseloutsideform.getPresentKm());
		int lastKm=Integer.parseInt(dieseloutsideform.getLastFillingKm());
		float qty=Float.parseFloat(dieseloutsideform.getWantedQuantity());
		int diffKm=presentKm-lastKm;
		dieseloutsideform.setDifferenceKm(Integer.toString(diffKm));
		float avgKm=diffKm/qty;
		dieseloutsideform.setAverageKm(Float.toString(avgKm));
		logger.debug("DieselOutsideAction:differenceMethod---------->");
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
		logger.debug("DieselOutsideAction:jobMethod<----------");
		String reqName="DieselOutsideIssue";
		HttpSession session = ((HttpServletRequest) request).getSession();
		String userName=(String) session.getAttribute("userId");
		String ss1=mapping.getName();
		jobid=jb.creatJob(ss1,userName,reqName);
		saveMethod(jobid,form);
		logger.debug("insert executed");
		logger.debug("DieselOutsideAction:jobMethod---------->");
		return mapping.findForward("dieselinsert");
	
	}
	/**
	 * 
	 * @param jobid
	 * @param form
	 * @throws Exception
	 */
	public void saveMethod(int jobid,ActionForm form)
	throws Exception {
		ArrayList bunkdesclist=new ArrayList();
		DieselOutsideVO bunknamevo=new DieselOutsideVO();
		String bunkname;
		logger.debug("DieselOutsideAction:saveMethod<----------");
		DieselOutsideVO insertvo=new DieselOutsideVO();
		DieselOutsideForm dieseloutsideform=(DieselOutsideForm)form;
		DieselOutsideService dieseloutsideservice=new DieselOutsideService();
		int driverName,REQ_DRIVERNAME,PLACE;
		PropertyUtils.copyProperties(insertvo,dieseloutsideform);
		float UNITRATE=Float.parseFloat(insertvo.getUnitRate());
		float QTY_WANTED=Float.parseFloat(insertvo.getWantedQuantity());
		float AVG_KM=Float.parseFloat(insertvo.getAverageKm());
		int LAST_KM =Integer.parseInt(insertvo.getLastFillingKm());
		int PRESENTKM=Integer.parseInt(insertvo.getPresentKm());
		int DIFF_KM=Integer.parseInt(insertvo.getDifferenceKm());
		float AMOUNT=Float.parseFloat(insertvo.getTotalAmount());
		int INSTITUTION_NAME=Integer.parseInt(insertvo.getInstitutionName());
		int VEHICLE_TYPE=Integer.parseInt(insertvo.getVehicleType());
		int VEHICLE_NUMBER=Integer.parseInt(insertvo.getVehicleNumber());
		int BILL_NUMBER=Integer.parseInt(insertvo.getBillNumber());
		String REQ_DATE =insertvo.getRequestedDate();
		
		String REMARKS=insertvo.getRemark();		
		int BUNKNAME=Integer.parseInt(insertvo.getBunkName());
		bunkdesclist=dieseloutsideservice.convertToDesc(insertvo.getBunkName());
	    bunknamevo=(DieselOutsideVO)bunkdesclist.get(0);
	    bunkname=bunknamevo.getDriverName();
	    PLACE=dieseloutsideservice.convertToCode(bunkname);
		String OTHER_BUNK=insertvo.getOtherBunkName();
		int FUELTYPE=Integer.parseInt(insertvo.getFuelType());
			
		if(REMARKS=="")
		{
			REMARKS="null";
		}
		int ROUTE_NUMBER=Integer.parseInt(insertvo.getRouteNumber());
		String DRIVERNAME=insertvo.getDriverName();
		driverName=dieseloutsideservice.convertToCode(DRIVERNAME);
		String REQDRIVERNAME=dieseloutsideform.getRequestedDriverName();
		REQ_DRIVERNAME=dieseloutsideservice.convertToCode(REQDRIVERNAME);
		dieseloutsideservice.insertmaster(jobid,INSTITUTION_NAME,VEHICLE_TYPE,VEHICLE_NUMBER,BILL_NUMBER,REQ_DATE,driverName,REQ_DRIVERNAME,ROUTE_NUMBER,FUELTYPE,BUNKNAME,PLACE,AMOUNT);
		dieseloutsideservice.insert(jobid,QTY_WANTED,UNITRATE,AMOUNT,PRESENTKM,LAST_KM,DIFF_KM,AVG_KM,REMARKS,FUELTYPE,BUNKNAME,OTHER_BUNK);
		logger.debug("DieselOutsideAction:saveMethod---------->");
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
	public ActionForward inboxMethod(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {
		logger.debug("DieselOutsideAction:inboxMethod<----------");
		DieselOutsideForm dieseloutsideform=(DieselOutsideForm)form;
		clear(form);
		DieselOutsideVO retrievemastervo=new DieselOutsideVO();	
		DieselOutsideVO retrievevo=new DieselOutsideVO();	
		DieselOutsideVO drivernamevo=new DieselOutsideVO();
	    
		ArrayList instList=new ArrayList();
		ArrayList typeList=new ArrayList();
		ArrayList vehicleList=new ArrayList();
		ArrayList fuelList=new ArrayList();
		ArrayList retriveList=new ArrayList();
		ArrayList retrievemasterList=new ArrayList();
		ArrayList driverdesclist=new ArrayList();
		ArrayList reqdriverdesclist=new ArrayList();
		
		instList=dieseloutsideservice.fetchInst();
		dieseloutsideform.setInstList(instList);
		typeList=dieseloutsideservice.fetchType();
		dieseloutsideform.setTypeList(typeList);
		vehicleList=dieseloutsideservice.fetchVehicle();
		dieseloutsideform.setVehicleList(vehicleList);
		fuelList=dieseloutsideservice.fetchFuel();
		dieseloutsideform.setFuelList(fuelList);
		logger.debug("Size"+fuelList.size());
		HttpSession session = ((HttpServletRequest) request).getSession();
		int job=(Integer)session.getAttribute("jobseq");
		
		retrievemasterList=dieseloutsideservice.retrieveMaster(job);
		retriveList=dieseloutsideservice.retrieve(job);
	       
	    retrievemastervo=(DieselOutsideVO)retrievemasterList.get(0);
	    retrievevo=(DieselOutsideVO)retriveList.get(0);
	  
	    dieseloutsideform.setAverageKm(retrievevo.getAverageKm());
	    dieseloutsideform.setBillNumber(retrievevo.getBillNumber());
	    dieseloutsideform.setBunkName(retrievevo.getBunkName());
	    dieseloutsideform.setDifferenceKm(retrievevo.getDifferenceKm());
	    dieseloutsideform.setFuelType(retrievevo.getFuelType());   
	    String drivercode=retrievemastervo.getDriverName();
	    driverdesclist=dieseloutsideservice.convertToDesc(drivercode);
	    drivernamevo=(DieselOutsideVO)driverdesclist.get(0);
	    dieseloutsideform.setDriverName(drivernamevo.getDriverName());
	    
	    dieseloutsideform.setInstitutionName(retrievemastervo.getInstitutionName());
	    dieseloutsideform.setLastFillingKm(retrievevo.getLastFillingKm());
	    dieseloutsideform.setOtherBunkName(retrievemastervo.getOtherBunkName());
        dieseloutsideform.setPresentKm(retrievevo.getPresentKm());
	    dieseloutsideform.setRequestedDate(retrievemastervo.getRequestedDate());
	    dieseloutsideform.setUnitRate(retrievevo.getUnitRate());
	    dieseloutsideform.setRemarks(retrievevo.getRemark());
	    String reqdrivercode=retrievemastervo.getRequestedDriverName();
	    reqdriverdesclist=dieseloutsideservice.convertToDesc(reqdrivercode);
	    drivernamevo=(DieselOutsideVO)reqdriverdesclist.get(0);	    
		dieseloutsideform.setRequestedDriverName(drivernamevo.getDriverName());
		
	    dieseloutsideform.setRouteNumber(retrievemastervo.getRouteNumber());
	    dieseloutsideform.setWantedQuantity(retrievevo.getWantedQuantity());
	    dieseloutsideform.setTotalAmount(retrievevo.getTotalAmount());
	    dieseloutsideform.setVehicleNumber(retrievemastervo.getVehicleNumber());
	    dieseloutsideform.setVehicleType(retrievemastervo.getVehicleType());
	    logger.debug("DieselOutsideAction:inboxMethod---------->");
	    return mapping.findForward("load");
	}
	/**
	 * 
	 * @param form
	 */
	public void clear(ActionForm form)
	{
		logger.debug("DieselOutsideAction:clear<----------");
		DieselOutsideForm dieseloutsideform=(DieselOutsideForm)form;
		dieseloutsideform.setAverageKm(null);
		dieseloutsideform.setBillNumber(null);
		dieseloutsideform.setDifferenceKm(null);
		dieseloutsideform.setDriverName(null);
		dieseloutsideform.setInstitutionName(null);
		dieseloutsideform.setLastFillingKm(null);
		dieseloutsideform.setRequestedDriverName(null);
		dieseloutsideform.setRouteNumber(null);
		dieseloutsideform.setRequestedDate(null);
		dieseloutsideform.setPresentKm(null);
		dieseloutsideform.setOtherPurpose(null);
		logger.debug("DieselOutsideAction:clear---------->");
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
			logger.debug("DieselOutsideAction:approveMethod<----------");
			HttpSession session = ((HttpServletRequest) request).getSession();
			int job=(Integer)session.getAttribute("jobseq");
			int task=(Integer)session.getAttribute("taskseqseq");
			jb.approveStatus(job,task);
			logger.debug("DieselOutsideAction:approveMethod---------->");
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
			logger.debug("DieselOutsideAction:okMethod<----------");
			HttpSession session = ((HttpServletRequest) request).getSession();
			int job=(Integer)session.getAttribute("jobseq");
			logger.debug("job in acquire"+job);
			int task=(Integer)session.getAttribute("taskseqseq");
			logger.debug("task in acquire"+task);
			jb.okStatus(job,task);
			logger.debug("DieselOutsideAction:okMethod---------->");
			return mapping.findForward("load");
	}
}
	
	
