package com.action;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import javax.servlet.http.HttpServletResponse;
import com.formbean.LoginForm;
import com.service.EquipmentAllotmentService;
import com.action.BaseDispatchAction;
import java.util.ArrayList;
import com.vo.EquipmentAllotmentVO;
import com.vo.UserVerifyVO;
import com.formbean.EquipmentAllotmentForm;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


/**
 * 
 * 
 *
 */
public class EquipmentAllotmentAction  extends BaseDispatchAction{
	private static final Logger logger=(Logger)Logger.getLogger(EquipmentAllotmentAction.class);

	ArrayList list=new ArrayList();
	ArrayList equipmentlist=new ArrayList();
	EquipmentAllotmentService service=new EquipmentAllotmentService();
	EquipmentAllotmentVO vo=new EquipmentAllotmentVO();
	
	/**
	 * Load equipment names and trye size combo
	 */
	public ActionForward defaultMethod(ActionMapping aMapping,
	        ActionForm aForm, HttpServletRequest aRequest,
	        HttpServletResponse aResponse)throws Exception{
			logger.debug("EquipmentAllotmentAction:defaultMethod---------->");
			EquipmentAllotmentForm form=(EquipmentAllotmentForm)aForm;
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
	 * insert the tyre size and quantity into database
	 * @param aMapping
	 * @param aForm
	 * @param aRequest
	 * @param aResponse
	 * @return
	 * @throws Exception
	 */
	
	public ActionForward insertMethod(ActionMapping aMapping,
	        ActionForm aForm, HttpServletRequest aRequest,
	        HttpServletResponse aResponse)throws Exception{
			logger.debug("EquipmentAllotmentAction:insertMethod---------->");
			EquipmentAllotmentForm form=(EquipmentAllotmentForm)aForm;
			
			HttpSession session=((HttpServletRequest)aRequest).getSession();
			String vehicleid=(String)session.getAttribute("vehicleId");
			vo.setVehicleId(vehicleid);
			vo.setFrontLeftTyre(form.getFrontLeftTyre());
			vo.setFrontRightTyre(form.getFrontRightTyre());
			vo.setBackLeftInTyre(form.getBackLeftInTyre());
			vo.setBackLeftOutTyre(form.getBackLeftOutTyre());
			vo.setBackRightInTyre(form.getBackRightInTyre());
			vo.setBackRightOutTyre(form.getBackRightOutTyre());
			vo.setQuantity5(form.getQuantity5());
			vo.setQuantity6(form.getQuantity6());
			vo.setQuantity7(form.getQuantity7());
			vo.setQuantity8(form.getQuantity8());
			vo.setQuantity9(form.getQuantity9());
			vo.setQuantity10(form.getQuantity10());
			service.insert(vo);
			return aMapping.findForward("back");
	}
	
	/**
	 * insert the equipment name and quantity into database
	 * @param aMapping
	 * @param aForm
	 * @param aRequest
	 * @param aResponse
	 * @return
	 * @throws Exception
	 */
	public ActionForward addMethod(ActionMapping aMapping,
	        ActionForm aForm, HttpServletRequest aRequest,
	        HttpServletResponse aResponse)throws Exception{
			logger.debug("EquipmentAllotmentAction:addMethod---------->");
			EquipmentAllotmentForm form=(EquipmentAllotmentForm)aForm;
				
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
			int id=Integer.parseInt(vehicleid);
			list=service.displayequipment(id);
			equipmentlist=service.equipmentname(id);
			aRequest.setAttribute("tableList", equipmentlist);
			form.setTableList(equipmentlist);
			return aMapping.findForward("load");
	}	
}
