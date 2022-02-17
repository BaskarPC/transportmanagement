package com.action;
import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;



public class FcAction extends BaseDispatchAction{
	private static final Logger logger=(Logger)Logger.getLogger(FcAction.class);
	
	
	public ActionForward defaultMethod(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {
		
			
		logger.debug("FcAction: defaultMethod<-------------");
		logger.debug("calling job "+mapping.getName());
		
		 logger.debug("after job ");
				logger.debug("FcAction:defaultMethod---------->");
		return mapping.findForward("load");
	
		
	}
	
	
	
}
