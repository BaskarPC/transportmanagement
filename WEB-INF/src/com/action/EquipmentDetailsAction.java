package com.action;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import javax.servlet.http.HttpServletResponse;

import com.formbean.EquipmentAllotmentForm;
import com.formbean.EquipmentDetailsForm;
import com.service.EquipmentDetailsService;
import com.vo.EquipmentDetailsVO;
import com.formbean.LoginForm;
import com.service.LoginService;
import com.action.BaseDispatchAction;
import java.util.ArrayList;
import com.vo.UserVO;
import com.vo.UserVerifyVO;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


public class EquipmentDetailsAction  extends BaseDispatchAction{
	
private static final Logger logger=(Logger)Logger.getLogger(EquipmentDetailsAction.class);
ArrayList list=new ArrayList();
ArrayList equipmentlist=new ArrayList();
EquipmentDetailsService service=new EquipmentDetailsService(); 
EquipmentDetailsVO vo=new EquipmentDetailsVO();

/**
 * Load the values of combo
 */
	public ActionForward defaultMethod(ActionMapping aMapping,
	        ActionForm aForm, HttpServletRequest aRequest,
	        HttpServletResponse aResponse)throws Exception{
			logger.debug("EquipmentDetailsAction:defaultMethod---------->");
			
			EquipmentDetailsForm form=(EquipmentDetailsForm)aForm;
			list=service.combo1retrieve();
			form.setCombo1List(list);
			list=service.combo2retrieve();
			form.setCombo2List(list);
			list=service.combo3retrieve();
			form.setCombo3List(list);
			list=service.combo4retrieve();
			form.setCombo4List(list);
			list=service.tyresizecombo();
			form.setTyresizeList(list);
			return aMapping.findForward("load");
}
	
	/**
	 *  Insert the equipment and quantity names into database
	 */
	public ActionForward addMethod(ActionMapping aMapping,
	        ActionForm aForm, HttpServletRequest aRequest,
	        HttpServletResponse aResponse)throws Exception{
			logger.debug("EquipmentDetailsAction:addMethod---------->");
			EquipmentDetailsForm form=(EquipmentDetailsForm)aForm;
			
			HttpSession session=((HttpServletRequest)aRequest).getSession();
			String vehicleid=(String)session.getAttribute("vehicleId");
			vo.setVehicleId(vehicleid);
			vo.setCombo1(form.getCombo1());
			vo.setCombo2(form.getCombo2());
			vo.setCombo3(form.getCombo3());
			vo.setCombo4(form.getCombo4());
			vo.setQuantity1(form.getQuantity1());
			vo.setQuantity2(form.getQuantity2());
			vo.setQuantity3(form.getQuantity3());
			vo.setQuantity4(form.getQuantity4());
			service.add(vo);
			logger.debug("vehicle id in add method"+vehicleid);
			int id=Integer.parseInt(vehicleid);
			list=service.displayequipment(id);
			equipmentlist=service.equipmentname(id);
			aRequest.setAttribute("tableList", equipmentlist);
			form.setTableList(equipmentlist);
			return aMapping.findForward("load");
}
	
	/**
	 *  Insert the tyre size and quantity into database
	 */
	public ActionForward insertMethod(ActionMapping aMapping,
	        ActionForm aForm, HttpServletRequest aRequest,
	        HttpServletResponse aResponse)throws Exception{
			logger.debug("EquipmentDetailsAction:addMethod---------->");
			EquipmentDetailsForm form=(EquipmentDetailsForm)aForm;
			
			vo.setBackLeftInTyre(form.getBackLeftInTyre());
			vo.setBackLeftOutTyre(form.getBackLeftOutTyre());
			vo.setBackRightInTyre(form.getBackRightInTyre());
			vo.setBackRightOutTyre(form.getBackRightOutTyre());
			vo.setFrontLeftTyre(form.getFrontLeftTyre());
			vo.setFrontRightTyre(form.getFrontRightTyre());
			vo.setQuantity5(form.getQuantity5());
			vo.setQuantity6(form.getQuantity6());
			vo.setQuantity7(form.getQuantity7());
			vo.setQuantity8(form.getQuantity8());
			vo.setQuantity9(form.getQuantity9());
			vo.setQuantity10(form.getQuantity10());
			service.insert(vo);
			return aMapping.findForward("load");
}
	
	/**
	 * Insert the  new equipment into lookup table
	 */
	public ActionForward addequipmentMethod(ActionMapping aMapping,
	        ActionForm aForm, HttpServletRequest aRequest,
	        HttpServletResponse aResponse)throws Exception{
			logger.debug("EquipmentDetailsAction:addequipmentMethod---------->");
			EquipmentDetailsForm form=(EquipmentDetailsForm)aForm;
			logger.debug("other equipment"+form.getOtherequipment());
			String str=form.getOtherequipment();
			service.addequipment(str);
			list=service.combo1retrieve();
			form.setCombo1List(list);
			return aMapping.findForward("load");
	}	
}
