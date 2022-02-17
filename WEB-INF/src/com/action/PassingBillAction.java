package com.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.formbean.PassingBillForm;
import com.service.PassingBillService;
import com.vo.PassingBillVO;
import com.wf.job;



/**
 * 
 * @author Administrator
 *
 */
public class PassingBillAction extends BaseDispatchAction{
	private static final Logger logger=(Logger)Logger.getLogger(PassingBillAction.class);
	job jb=new job();
	int jobid;
	PassingBillService passingbillservice=new PassingBillService();
	PassingBillVO descvo=new PassingBillVO();
	PassingBillVO generalvo=new PassingBillVO();
	public ActionForward defaultMethod(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {
		
		PassingBillForm passingbillform=(PassingBillForm)form;
		ArrayList passingbillList=new ArrayList();
		passingbillList=passingbillservice.fetchType();
		passingbillform.setPurchaseissueList(passingbillList);	
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
	public ActionForward goodstypeMethod(ActionMapping mapping,
	ActionForm form,
	HttpServletRequest request,
	HttpServletResponse response)
	throws Exception {
		PassingBillForm passingbillform=(PassingBillForm)form;
		ArrayList goodstypeList=new ArrayList();
		ArrayList desclist=new ArrayList();
		String ptype=passingbillform.getPurchaseIssue();
		desclist=passingbillservice.convertToDesc(ptype);
		descvo=(PassingBillVO)desclist.get(0);
	    goodstypeList=passingbillservice.fetchGoodsType(descvo.getDriverName());
	    passingbillform.setGoodsList(goodstypeList);
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
	public ActionForward billnumberMethod(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {
		PassingBillForm passingbillform=(PassingBillForm)form;
		ArrayList billList=new ArrayList();
		ArrayList desclist=new ArrayList();
		String ptype=passingbillform.getPurchaseIssue();
		desclist=passingbillservice.convertToDesc(ptype);
		descvo=(PassingBillVO)desclist.get(0);
		String type=descvo.getDriverName();
		int prtype=Integer.parseInt(passingbillform.getTypeOfProduct());
		billList=passingbillservice.fetchBillNumbers(prtype,type);
		passingbillform.setBillnumberList(billList);
		return mapping.findForward("load");
	}
	public ActionForward servicestationMethod(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {
		PassingBillForm passingbillform=(PassingBillForm)form;
		ArrayList generalList=new ArrayList();
		ArrayList descList=new ArrayList();
		String ptype=passingbillform.getPurchaseIssue();
		descList=passingbillservice.convertToDesc(ptype);
		descvo=(PassingBillVO)descList.get(0);
		String type=descvo.getDriverName();
		String goods_type=passingbillform.getTypeOfProduct();
		int billnumber=Integer.parseInt(passingbillform.getPassingBillNumber());
		logger.debug("Bill:"+billnumber);
		generalList=passingbillservice.fetchServiceDetails(type,billnumber,goods_type);
		generalvo=(PassingBillVO)generalList.get(0);
		passingbillform.setBillAmount(generalvo.getBillAmount());
		passingbillform.setBillDate(generalvo.getBillDate());
		
		descList=passingbillservice.convertToDesc(generalvo.getInstitutionName());
		descvo=(PassingBillVO)descList.get(0);
		passingbillform.setInstitutionName(descvo.getDriverName());
		
		descList=passingbillservice.convertToDesc(generalvo.getVehicleNumber());
		descvo=(PassingBillVO)descList.get(0);
		passingbillform.setVehicleNumber(descvo.getDriverName());
		
		descList=passingbillservice.convertToDesc(generalvo.getServiceName());
		descvo=(PassingBillVO)descList.get(0);
		passingbillform.setServiceName(descvo.getDriverName());
		
		descList=passingbillservice.convertToDesc(generalvo.getServiceStationLocation());
		descvo=(PassingBillVO)descList.get(0);
		passingbillform.setServiceStationLocation(descvo.getDriverName());
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
		logger.debug("PassingBillAction:jobMethod---------->");
		String reqName="PassingBillIssue";
		HttpSession session = ((HttpServletRequest) request).getSession();
		String userName=(String) session.getAttribute("userId");
		String ss1=mapping.getName();
		jobid=jb.creatJob(ss1,userName,reqName);
		saveMethod(jobid,form);
		logger.debug("PassingBillAction:jobMethod<----------");
		return mapping.findForward("load");
	}
	/**
	 * to insert the values in table
	 * @param jobid
	 * @param form
	 * @throws Exception
	 */
	public void saveMethod(int jobid,ActionForm form)
			throws Exception {
		PassingBillForm passingbillform=(PassingBillForm)form;
		int billnumber,passingbillnumber;
		float amount=0;
		String billdate,requesteddate,headofaccdebit;
		int servicename,location,vehiclenumber,producttype,institutionname,purchaseissue;
		billnumber=Integer.parseInt(passingbillform.getBillNumber());
		amount=Float.parseFloat(passingbillform.getBillAmount());
		billdate=passingbillform.getBillDate();
		headofaccdebit=passingbillform.getHeadOfAccountDebit();
		institutionname=passingbillservice.convertToCode(passingbillform.getInstitutionName());;
		passingbillnumber=Integer.parseInt(passingbillform.getPassingBillNumber());
		purchaseissue=passingbillservice.convertToCode(passingbillform.getPurchaseIssue());
		requesteddate=passingbillform.getRequestedDate();
		servicename=passingbillservice.convertToCode(passingbillform.getServiceName());
		location=passingbillservice.convertToCode(passingbillform.getServiceStationLocation());
		vehiclenumber=passingbillservice.convertToCode(passingbillform.getVehicleNumber());
		producttype=passingbillservice.convertToCode(passingbillform.getTypeOfProduct());
		passingbillservice.insertmaster(institutionname,billnumber,billdate,requesteddate,servicename,location,vehiclenumber,jobid);
		passingbillservice.insert(jobid,passingbillnumber,headofaccdebit,purchaseissue,producttype,amount);
				
	}
	
	/**
	 * passes the jobid,taskid to change the status to 2 for the approve task oilform that form 
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
			
			 HttpSession session = ((HttpServletRequest) request).getSession();
			logger.debug("inside approve method");
			int job=(Integer)session.getAttribute("jobseq");
			logger.debug("job in acquire"+job);
			int task=(Integer)session.getAttribute("taskseqseq");
			logger.debug("task in acquire"+task);
			jb.approveStatus(job,task);
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
			ArrayList descList=new ArrayList();
			 HttpSession session = ((HttpServletRequest) request).getSession();
			 PassingBillForm passingbillform=(PassingBillForm)form;
			int job=(Integer)session.getAttribute("jobseq");
			int task=(Integer)session.getAttribute("taskseqseq");
			logger.debug("task in acquire"+task);
			jb.okStatus(job,task);
			String vehiclenumber,servicename,purchaseissue;
			int producttype;
			vehiclenumber=passingbillform.getVehicleNumber();
			descList=passingbillservice.convertToDesc(passingbillform.getPurchaseIssue());
			descvo=(PassingBillVO)descList.get(0);
			purchaseissue=descvo.getDriverName();
			producttype=Integer.parseInt(passingbillform.getTypeOfProduct());
			servicename=passingbillform.getServiceName();
			passingbillservice.updateBillPassed(vehiclenumber,purchaseissue,producttype,servicename);
			return mapping.findForward("load");
	}
}
