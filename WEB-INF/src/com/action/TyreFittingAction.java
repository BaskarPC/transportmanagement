package com.action;

import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import com.formbean.TyreFittingForm;
import com.vo.TyreFittingVO;
import com.vo.TyreRemovalVO;
import com.service.TyreFittingService;

public class TyreFittingAction extends BaseDispatchAction{
	private static final Logger logger=(Logger)Logger.getLogger(TyreFittingAction.class);
	TyreFittingService tyrefittingservice =new TyreFittingService();
	public ActionForward defaultMethod(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {
	   
		TyreFittingForm tyrefittingform=(TyreFittingForm)form;
		
		/**
		 * To set Tyre Size in Combo Box
		 */	
	    ArrayList tyreSizeList=new ArrayList();
	    tyreSizeList=tyrefittingservice.tyreSizeCombo();
		tyrefittingform.setTyreSizeList(tyreSizeList);
	    
	    /**
		 * To set Tyre Brand in Combo Box
		 */	
	    ArrayList tyreBrandList=new ArrayList();
	    tyreBrandList=tyrefittingservice.tyreBrandCombo();
		tyrefittingform.setTyreBrandList(tyreBrandList);
	    
	    /**
		 * To set Tyre Ply in Combo Box
		 */	
	    ArrayList tyrePlyList=new ArrayList();
	    tyrePlyList=tyrefittingservice.tyrePlyCombo();
		tyrefittingform.setTyrePlyList(tyrePlyList);
		
		/**
		 * To set Institution Name in Combo Box
		 */
		ArrayList institutionList=new ArrayList();
		institutionList=tyrefittingservice.institutionCombo();
		tyrefittingform.setInstitutionList(institutionList);
		
	    /**
		 * To set Tyre Position in Combo Box
		 */	
	    ArrayList tyrePositionList=new ArrayList();
	    tyrePositionList=tyrefittingservice.tyrePositionCombo();
		tyrefittingform.setTyrePositionList(tyrePositionList);	
	    return mapping.findForward("load");
	}
	
	/**
	 * To set the vaehicle type in combo box
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward vehicleTypeMethod(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {
		ArrayList list=new ArrayList();
		TyreFittingForm tyrefittingform=(TyreFittingForm)form;
		TyreFittingService tyrefittingservice =new TyreFittingService();
		int instname=Integer.parseInt(tyrefittingform.getInstitutionName());
		list=tyrefittingservice.vehicleTypeCombo(instname);
		tyrefittingform.setVehicleTypeList(list);
		return mapping.findForward("load");
	}
	
	/**
	 * To set the vehicle number in Combo box
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward vehicleNumberMethod(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {
		ArrayList list=new ArrayList();
		TyreFittingForm tyrefittingform=(TyreFittingForm)form;
		TyreFittingService tyrefittingservice =new TyreFittingService();
		int vehicleType=Integer.parseInt(tyrefittingform.getVehicleType());
		list=tyrefittingservice.vehicleNumberCombo(vehicleType);
		tyrefittingform.setVehicleNumberList(list);
		return mapping.findForward("load");
	}
	
	/**
	 * To set the tyrenumber in combo box
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward tyreNumberMethod(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {
		ArrayList list=new ArrayList();
		TyreFittingForm tyrefittingform=(TyreFittingForm)form;
		TyreFittingService tyrefittingservice =new TyreFittingService();
		int tyreSize=Integer.parseInt(tyrefittingform.getTyreSize());
		int tyrePly=Integer.parseInt(tyrefittingform.getTyrePly());
		int tyreBrand=Integer.parseInt(tyrefittingform.getTyreBrand());
		list=tyrefittingservice.tyreNumberCombo(tyreSize,tyreBrand,tyrePly);
		tyrefittingform.setTyreNumberList(list);
		return mapping.findForward("load");
	}
	
	/**
	 * To set the tyre status in the text box 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward tyreStatusMethod(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {
		
		ArrayList tyreStatuslist=new ArrayList();
		TyreFittingForm tyrefittingform=(TyreFittingForm)form;
		TyreFittingService tyrefittingservice =new TyreFittingService();
		String tyreNumber=tyrefittingform.getTyreNumber();
		tyreStatuslist=tyrefittingservice.tyreStatusValue(tyreNumber);
		TyreFittingVO tyrefittingvo=(TyreFittingVO)tyreStatuslist.get(0);
		tyrefittingform.setTyreStatus(tyrefittingvo.getTyreStatus());
        return mapping.findForward("load");
	}
	
	/**
	 * To insert the values into the database
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward saveMethod(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {
		TyreFittingForm tyrefittingform=(TyreFittingForm)form;
		TyreFittingService tyrefittingservice =new TyreFittingService();
		TyreFittingVO tyrefittingvo=new TyreFittingVO();
		ActionErrors actionErrors = new ActionErrors();
		TyreFittingAction action=new TyreFittingAction();
		//actionErrors=action.validate(mapping, request);
	    PropertyUtils.copyProperties(tyrefittingvo,tyrefittingform);
	    tyrefittingservice.insert(tyrefittingvo);
	    String tyreNumber=tyrefittingform.getTyreNumber();
	    tyrefittingservice.updateTyreMaster(tyreNumber);
	 	
	    return mapping.findForward("load");
	}
	
	
	/*public ActionErrors validate(ActionMapping mapping, HttpServletRequest request)
	{
		ActionErrors actionErrors = new ActionErrors();
		TyreFittingForm tyrefittingform=new TyreFittingForm();
		String TyreStatus=tyrefittingform.getTyreStatus();
		String FittingDate=tyrefittingform.getFittingDate();
		logger.debug("FittingDate:"+FittingDate);
	   	if (TyreStatus == null)
	   	{
			actionErrors.add("TyreStatus", new ActionMessage("error.tyrestatus"));
	 	}
		if (FittingDate == null) 
		{
			actionErrors.add("age", new ActionMessage("error.fittingdate"));
		}
			return actionErrors;
	}*/
	
	/**
	 * To clear the values in the form
	 */
	public ActionForward clearMethod(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {
		TyreFittingForm tyrefittingform=(TyreFittingForm)form;
		String empty=null;
		tyrefittingform.setTyreSize(empty);
		tyrefittingform.setTyreBrand(empty);
		tyrefittingform.setTyrePly(empty);
		tyrefittingform.setTyreNumber(empty);
		tyrefittingform.setInstitutionName(empty);
		tyrefittingform.setVehicleType(empty);
		tyrefittingform.setVehicleNumber(empty);
		tyrefittingform.setTyrePosition(empty);
		tyrefittingform.setTyreStatus(empty);
		tyrefittingform.setFittingDate(empty);
		tyrefittingform.setFittingKM(empty);
		return mapping.findForward("load");
		
	}
	
}
