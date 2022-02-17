package com.action;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.formbean.ScrapForm;
//import com.wf.*;
import com.service.ScrapService;




public class ScrapAction extends BaseDispatchAction{
	private static final Logger logger=(Logger)Logger.getLogger(ScrapAction.class);
	//job jb=new job();
	ScrapService scrapservice=new ScrapService();
	/**
	 * 
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
		ScrapForm scrapform=(ScrapForm)form;
		ArrayList instList=new ArrayList();
		ArrayList categoryList=new ArrayList();
		HttpSession session = ((HttpServletRequest) request).getSession();
		String userName=(String) session.getAttribute("userId");
		instList=scrapservice.fetchInst();
		categoryList=scrapservice.fetchCategory();
		logger.debug("array size in scrap form"+instList.size());
		scrapform.setInstList(instList);
		scrapform.setCategoryList(categoryList);
		logger.debug("ScrapAction:defaultMethod---------->");
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
		ArrayList list=new ArrayList();
		ScrapForm scrapform=(ScrapForm)form;
		int instname=Integer.parseInt(scrapform.getInstitutionName());
		list=scrapservice.instMethod(instname);
		scrapform.setTypeList(list);
		return mapping.findForward("scrapretrieve");
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
		ArrayList list=new ArrayList();
		ScrapForm scrapform=(ScrapForm)form;
		int vehtype=Integer.parseInt(scrapform.getVehicleType());
		list=scrapservice.vehicleMethod(vehtype);
		scrapform.setVehicleList(list);
		return mapping.findForward("scrapretrieve");
	}
	/**
	 * 
	 * @param jobid
	 * @param form
	 * @throws Exception
	 */
	public void saveMethod(int jobid,ActionForm form)
								throws Exception {
		
	
	}
	public void gramMethod()
								throws Exception {
	}
}
