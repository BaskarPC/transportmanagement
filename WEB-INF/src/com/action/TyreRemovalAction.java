package com.action;

import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import com.dbcom.dbcom;
import com.formbean.GeneralForm;
import com.formbean.TyreFittingForm;
import com.formbean.TyreRemovalForm;
import com.vo.TyreFittingVO;
import com.vo.TyreRemovalVO;
import com.service.TyreRemovalService;

public class TyreRemovalAction extends BaseDispatchAction{
		private static final Logger logger=(Logger)Logger.getLogger(TyreRemovalAction.class);
		TyreRemovalService tyreremovalservice =new TyreRemovalService();
		public ActionForward defaultMethod(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {
			TyreRemovalForm tyreremovalform=(TyreRemovalForm)form;
			 /**
			 * Setting  Institution Name to Combo Box
			 */
			ArrayList institutionList=new ArrayList();
			institutionList=tyreremovalservice.institutionCombo();
			tyreremovalform.setInstitutionList(institutionList);
		    return mapping.findForward("load");
		}
	
		/** 
		 * TO display vehicle type in the combo box
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
			TyreRemovalForm tyreremovalform=(TyreRemovalForm)form;
			int instname=Integer.parseInt(tyreremovalform.getInstitutionName());
			list=tyreremovalservice.vehicleTypeCombo(instname);
			tyreremovalform.setVehicleTypeList(list);
			return mapping.findForward("load");
		}
	
		/**
		 * To display the vehicle number in the combo box
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
			TyreRemovalForm tyreremovalform=(TyreRemovalForm)form;
			int vehicleType=Integer.parseInt(tyreremovalform.getVehicleType());
			list=tyreremovalservice.vehicleNumberCombo(vehicleType);
			tyreremovalform.setVehicleNumberList(list);
			return mapping.findForward("load");
		}
	
		/**
		 * To display the tyrenumber in Tyre removal form
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
			TyreRemovalForm tyreremovalform=(TyreRemovalForm)form;
			int vehicleNumber=Integer.parseInt(tyreremovalform.getVehicleNumber());
			list=tyreremovalservice.tyreNumberCombo(vehicleNumber);
			tyreremovalform.setTyreNumberList(list);
			return mapping.findForward("load");
		}
		
		/**
		 * Display the tyre details
		 * @param mapping
		 * @param form
		 * @param request
		 * @param response
		 * @return
		 * @throws Exception
		 */
		public ActionForward tyreDetailsMethod(ActionMapping mapping,
				ActionForm form,
				HttpServletRequest request,
				HttpServletResponse response)
				throws Exception {
			ArrayList list=new ArrayList();
			TyreRemovalForm tyreremovalform=(TyreRemovalForm)form;
			ArrayList tyrePositionList=new ArrayList();
			String tyreNumber=tyreremovalform.getTyreNumber();
			logger.debug("Tyre number in actionnn :"+tyreNumber);
			list=tyreremovalservice.tyreDetails(tyreNumber);
			TyreRemovalVO tyreremovalvo=(TyreRemovalVO)list.get(0);
			
			/**
			 * To set the Tyre status,FittingKm in TextBox
			 */
			
			tyreremovalform.setTyreStatus(tyreremovalvo.getTyreStatus());
			tyreremovalform.setFittingKM(tyreremovalvo.getFittingKM());
			int tyreposition=Integer.parseInt(tyreremovalvo.getTyrePosition());
			tyrePositionList=tyreremovalservice.tyrePositionCdesc(tyreposition);
			tyreremovalvo=(TyreRemovalVO)tyrePositionList.get(0);
			tyreremovalform.setTyrePosition(tyreremovalvo.getTyrepositionCdesc());
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
			TyreRemovalForm tyreremovalform=(TyreRemovalForm)form;
			TyreRemovalVO tyreremovalvo=new TyreRemovalVO();
			PropertyUtils.copyProperties(tyreremovalvo,tyreremovalform);
			String tyreNumber=tyreremovalform.getTyreNumber();
		 	tyreremovalservice.insert(tyreremovalvo);	
		 	tyreremovalservice.changeDelIndicator(tyreNumber);
		 	tyreremovalservice.updateTyreMaster(tyreNumber);
		 	return mapping.findForward("load");
		}
		
		/**
		 * To calculate the total kilometer
		 * @param mapping
		 * @param form
		 * @param request
		 * @param response
		 * @return
		 * @throws Exception
		 */
		public ActionForward calculateTotalKMMethod(ActionMapping mapping,
				ActionForm form,
				HttpServletRequest request,
				HttpServletResponse response)
				throws Exception {
			TyreRemovalForm tyreremovalform=(TyreRemovalForm)form;
			int fittingkm=Integer.parseInt(tyreremovalform.getFittingKM());
			int removalkm=Integer.parseInt(tyreremovalform.getRemovalKM());
			int totalkm=removalkm-fittingkm;
			tyreremovalform.setTotalKM(Integer.toString(totalkm));
			return mapping.findForward("load");
		}
		
		/**
		 * TO reset the values in the form
		 * @param mapping
		 * @param form
		 * @param request
		 * @param response
		 * @return
		 * @throws Exception
		 */
		public ActionForward clearMethod(ActionMapping mapping,
				ActionForm form,
				HttpServletRequest request,
				HttpServletResponse response)
				throws Exception {
			TyreRemovalForm tyreremovalform=(TyreRemovalForm)form;		
			tyreremovalform.setInstitutionName(null);
	      	tyreremovalform.setVehicleType(null);
	      	tyreremovalform.setVehicleNumber(null);
	      	tyreremovalform.setTyreNumber(null);
	      	tyreremovalform.setTyreStatus(null);
	      	tyreremovalform.setTyrePosition(null);
	      	tyreremovalform.setRemovalDate(null);
	      	tyreremovalform.setRequestedDate(null);
	      	tyreremovalform.setFittingKM(null);
	      	tyreremovalform.setRemovalKM(null);
	      	tyreremovalform.setTotalKM(null);
	      	tyreremovalform.setRemovalReason(null);
	      	return mapping.findForward("load");
			
		}
	}
