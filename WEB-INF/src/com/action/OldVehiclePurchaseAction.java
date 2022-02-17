package com.action;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import javax.servlet.http.HttpServletResponse;
import com.formbean.LoginForm;
import com.service.OldVehiclePurchaseService;
import com.action.BaseDispatchAction;
import java.util.ArrayList;
import com.vo.OldVehiclePurchaseVO;
import com.formbean.OldVehiclePurchaseForm;
import com.vo.UserVerifyVO;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


/**
 * 
 * 
 *
 */
public class OldVehiclePurchaseAction  extends BaseDispatchAction{
	private static final Logger logger=(Logger)Logger.getLogger(OldVehiclePurchaseAction.class);
	OldVehiclePurchaseService service=new OldVehiclePurchaseService();
	ArrayList list=new ArrayList();
	ArrayList retrievelist=new ArrayList();
	ArrayList retrievealllist=new ArrayList();
	OldVehiclePurchaseVO vo=new OldVehiclePurchaseVO();
	OldVehiclePurchaseVO retrieveallvo=new OldVehiclePurchaseVO();
	
	/** default method to load vehiclestatus and retrieve the values from database
	 * 
	 */
	public ActionForward defaultMethod(ActionMapping aMapping,
	        ActionForm aForm, HttpServletRequest aRequest,
	        HttpServletResponse aResponse)throws Exception{
			logger.debug("OldVehiclePurchaseAction:defaultMethod---------->");
			OldVehiclePurchaseForm form=(OldVehiclePurchaseForm)aForm;			
			list=service.vehiclestatuscombo();
			form.setVehiclestatusList(list);
			
			HttpSession session=((HttpServletRequest)aRequest).getSession();
			String vehicleid=(String)session.getAttribute("vehicleId");
			
			retrievealllist=service.retrieveall();
			for(int i=0;i<retrievelist.size();i++)
			{
				retrieveallvo=(OldVehiclePurchaseVO)retrievealllist.get(i);
				logger.debug("vehicle id in action"+retrieveallvo.getVehicleiddesc());
			}			
		for(int i=0;i<retrievelist.size();i++)
		{
			if(retrieveallvo.getVehicleiddesc().equals(vehicleid.toString()))
			{
				logger.debug("values are equal");
				int id=Integer.parseInt(vehicleid);
				retrievelist=service.retrieve(id);
				for(int j=0;j<retrievelist.size();j++)
				{
					vo=(OldVehiclePurchaseVO)retrievelist.get(j);
				}
				
				form.setVehicleAge(vo.getVehicleAge());
				form.setVehiclestatus(vo.getVehiclestatus());
				form.setBodyCmpy(vo.getBodyCmpy());
				form.setKmTraveled(vo.getKmTraveled());
				i=retrievelist.size()+1;
			}			
			else
			{
				logger.debug("values are not equal");
				form.setVehicleAge(null);
				form.setVehiclestatus(null);
				form.setBodyCmpy(null);
				form.setKmTraveled(null);
				}
			}	
		return aMapping.findForward("load");
	}
	
	/**
	 * Values are saved into database
	 * @param aMapping
	 * @param aForm
	 * @param aRequest
	 * @param aResponse
	 * @return
	 * @throws Exception
	 */
	public ActionForward saveMethod(ActionMapping aMapping,
	        ActionForm aForm, HttpServletRequest aRequest,
	        HttpServletResponse aResponse)throws Exception{
			logger.debug("OldVehiclePurchaseAction:saveMethod---------->");			
			OldVehiclePurchaseForm form=(OldVehiclePurchaseForm)aForm;
		
			HttpSession session=((HttpServletRequest)aRequest).getSession();
			String vehicleid=(String)session.getAttribute("vehicleId");
			vo.setVehicleId(vehicleid);
			vo.setKmTraveled(form.getKmTraveled());		
			vo.setVehicleAge(form.getVehicleAge());		
			vo.setVehiclestatus(form.getVehiclestatus());
			vo.setBodyCmpy(form.getBodyCmpy());			
			service.insert(vo);
		return aMapping.findForward("save");
	}	
}

