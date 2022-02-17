package com.action;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.log4j.Logger;
import javax.servlet.http.HttpServletResponse;

import com.formbean.DriverOfficialForm;
import com.formbean.DriverPolicyForm;

import com.service.DriverPolicyService;

import com.action.BaseDispatchAction;
import java.util.ArrayList;

import com.vo.DriverPolicyVO;


import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


/**
 * 
 * @author Sunil
 *
 */
public class DriverPolicyAction  extends BaseDispatchAction{
	private static final Logger logger=(Logger)Logger.getLogger(DriverPolicyAction.class);

	/**
	 * To load combo box values
	 */
	DriverPolicyService service=new DriverPolicyService();
	ArrayList list=new ArrayList();
	DriverPolicyVO vo=new DriverPolicyVO();
	ArrayList list1=new ArrayList();
	ArrayList idlist=new ArrayList();
	ArrayList retrievelist=new ArrayList();
	DriverPolicyVO vo1=new DriverPolicyVO();
	DriverPolicyVO retrievevo=new DriverPolicyVO();
	DriverPolicyVO idvo=new DriverPolicyVO();
	public ActionForward defaultMethod(ActionMapping aMapping,
	        ActionForm aForm, HttpServletRequest aRequest,
	        HttpServletResponse aResponse)throws Exception{
		logger.debug("DriverPolicyAction: defaultMethod<-------------");
		DriverPolicyForm form=(DriverPolicyForm)aForm;
		list=service.driveridcombo(vo);
		form.setIdList(list);
		logger.debug("DriverPolicyAction: defaultMethod<-------------");
		return aMapping.findForward("load");
		
	}
	/**
	 * 
	 * @param aMapping
	 * @param aForm
	 * @param aRequest
	 * @param aResponse
	 * @return
	 * @throws Exception
	 */
	
	public ActionForward backMethod(ActionMapping aMapping,
	        ActionForm aForm, HttpServletRequest aRequest,
	        HttpServletResponse aResponse)throws Exception{
		DriverPolicyForm form=(DriverPolicyForm)aForm;
		logger.debug("DriverPolicyAction: backMethod<-------------");
		HttpSession session =((HttpServletRequest)aRequest).getSession();
		logger.debug("Policy number"+form.getPolicyNo());
		session.setAttribute("policyNo", form.getPolicyNo());
		String policyno=(String)session.getAttribute("policyNo");
		logger.debug("policy in session"+policyno);
		logger.debug("DriverPolicyAction: backMethod------------->");
        
		return aMapping.findForward("back");
		
	}
	/**
	 * 
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
		logger.debug("DriverPolicyAction: saveMethod<-------------");
		DriverPolicyForm form=(DriverPolicyForm)aForm;
		HttpSession session =((HttpServletRequest)aRequest).getSession();
		logger.debug("Policy number"+form.getPolicyNo());
		session.setAttribute("policyNo", form.getPolicyNo());
		PropertyUtils.copyProperties(vo,form);
		service.save(vo);
		logger.debug("DriverPolicyAction: saveMethod<-------------");
		return aMapping.findForward("load");
		
	}
	public ActionForward updateMethod(ActionMapping aMapping,
	        ActionForm aForm, HttpServletRequest aRequest,
	        HttpServletResponse aResponse)throws Exception{
		logger.debug("DriverPolicyAction: updateMethod<-------------");
		DriverPolicyForm form=(DriverPolicyForm)aForm;
		HttpSession session =((HttpServletRequest)aRequest).getSession();
		logger.debug("Policy number"+form.getPolicyNo());
		session.setAttribute("policyNo", form.getPolicyNo());
		PropertyUtils.copyProperties(vo,form);
		service.update(vo,form.getDriverId());
		logger.debug("DriverPolicyAction: updateMethod<-------------");
		return aMapping.findForward("load");
	}
		
	/**
	 * 
	 * @param aMapping
	 * @param aForm
	 * @param aRequest
	 * @param aResponse
	 * @return
	 * @throws Exception
	 */
	public ActionForward retrieveMethod(ActionMapping aMapping,
	        ActionForm aForm, HttpServletRequest aRequest,
	        HttpServletResponse aResponse)throws Exception{
		logger.debug("DriverPolicyAction: retrieveMethod<-------------");
		DriverPolicyForm form=(DriverPolicyForm)aForm;
		
		idlist=service.idretrieve(form.getDriverId());
		for(int i=0;i<idlist.size();i++)
		{
			idvo=(DriverPolicyVO)idlist.get(i);
		}
		retrievelist=service.retrieveall();
		for(int i=0;i<retrievelist.size();i++)
		{
		retrievevo=(DriverPolicyVO)retrievelist.get(i);
		logger.debug("driverid in action(vo:"+retrievevo.getDriverdesc());
		logger.debug("driverid in idform(vo:"+idvo.getDriverdesc());
		
		if(retrievevo.getDriverdesc().equals(idvo.getDriverdesc()))
		{
		int id=Integer.parseInt(form.getDriverId());
		logger.debug("driver id int(if)"+id);
		list=service.comboretrieve(id);
		vo=(DriverPolicyVO)list.get(0);
		logger.debug("driver name in action(inside if)"+vo.getDriverName());
		form.setDriverName(vo.getDriverName());
		list1=service.comboretrieve1(id);
		vo1=(DriverPolicyVO)list1.get(0);
		logger.debug("array size of vo1:"+list1.size());
		form.setPolicyNo(vo1.getPolicyNo());
		logger.debug("policy no in action:"+vo1.getPolicyNo());
		form.setPolicyName(vo1.getPolicyName());
		logger.debug("policy name in action:"+vo1.getPolicyName());
		form.setCoverage(vo1.getCoverage());
		form.setPremiumAmt(vo1.getPremiumAmt());
		form.setInsuranceCmpyAddress(vo1.getInsuranceCmpyAddress());
		form.setValidFrom(vo1.getValidFrom());
		form.setValidTo(vo1.getValidTo());
		form.setTieUp(vo1.getTieUp());
		form.setCompensationAmt(vo1.getCompensationAmt());
		form.setHospitalExpenses(vo1.getHospitalExpenses());
		form.setBuffer(vo1.getBuffer());
		form.setConstraints(vo1.getConstraints());
		i=retrievelist.size()+1;
	
		}
		else
		{
			logger.debug("new entry");
			int id=Integer.parseInt(form.getDriverId());
			logger.debug("driver id int"+id);
			list=service.comboretrieve(id);
			vo=(DriverPolicyVO)list.get(0);
			logger.debug("driver name in action"+vo.getDriverName());
			form.setDriverName(vo.getDriverName());
			form.setPolicyNo(null);
			form.setPolicyName(null);
			form.setCoverage(null);
			form.setPremiumAmt(null);
			form.setInsuranceCmpyAddress(null);
			form.setValidFrom(null);
			form.setValidTo(null);
			form.setTieUp(null);
			form.setHospitalExpenses(null);
			form.setCompensationAmt(null);
			form.setBuffer(null);
			form.setConstraints(null);
		}
		}
		logger.debug("DriverPolicyAction: retrieveMethod------------->");
		return aMapping.findForward("load");
	}
	/**
	 * 
	 * @param aMapping
	 * @param aForm
	 * @param aRequest
	 * @param aResponse
	 * @return
	 * @throws Exception
	 */
	public ActionForward clearformMethod(ActionMapping aMapping,
	        ActionForm aForm, HttpServletRequest aRequest,
	        HttpServletResponse aResponse)throws Exception{
		logger.debug("DriverPolicyAction: clearformMethod<-------------");
		DriverPolicyForm form=(DriverPolicyForm)aForm;
		form.setDriverId(null);
		form.setDriverName(null);
		form.setPolicyNo(null);
		form.setPolicyName(null);
		form.setCoverage(null);
		form.setPremiumAmt(null);
		form.setInsuranceCmpyAddress(null);
		form.setValidFrom(null);
		form.setValidTo(null);
		form.setTieUp(null);
		form.setHospitalExpenses(null);
		form.setCompensationAmt(null);
		form.setBuffer(null);
		form.setConstraints(null);
		logger.debug("DriverPolicyAction: clearformMethod------------->");
		return aMapping.findForward("load");
	}
}
