package com.action;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.*;


public class SuccessAction extends BaseDispatchAction{
	private static final Logger logger=(Logger)Logger.getLogger(SuccessAction.class);
	//job jb=new job();
	public ActionForward defaultMethod(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {				
			logger.debug("successAction: defaultMethod<-------------");			
			logger.debug("successAction: defaultMethod---------->");
			return mapping.findForward("load");
		
		}
	
	
}
