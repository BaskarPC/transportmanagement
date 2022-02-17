package com.action;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import javax.servlet.http.HttpServletResponse;
import com.formbean.DriverOfficialForm;
import com.formbean.DriverPersonalForm;
import com.service.DriverOfficialService;
import com.action.BaseDispatchAction;
import java.util.ArrayList;
import com.vo.DriverOfficialVO;
import com.vo.DriverPersonalVO;
import com.vo.UserVerifyVO;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


public class DriverOfficialAction  extends BaseDispatchAction{
	private static final Logger logger=(Logger)Logger.getLogger(DriverOfficialAction.class);

	
	DriverOfficialVO vo =new DriverOfficialVO();
	DriverOfficialVO vo1 =new DriverOfficialVO();
	DriverOfficialVO vo2 =new DriverOfficialVO();
	DriverOfficialService service=new DriverOfficialService();
	ArrayList list=new ArrayList();
	ArrayList idlist=new ArrayList();
	DriverOfficialVO idvo =new DriverOfficialVO();
	/**
	 * to load combo box values
	 */
	public ActionForward defaultMethod(ActionMapping aMapping,
	        ActionForm aForm, HttpServletRequest aRequest,
	        HttpServletResponse aResponse)throws Exception{
		logger.debug("DriverOfficialAction: defaultMethod<-------------");
		DriverOfficialForm driverofficialform =(DriverOfficialForm)aForm;
		ArrayList instlist=new ArrayList();
		ArrayList deptlist=new ArrayList();
    	ArrayList bloodgplist=new ArrayList();
    	instlist=service.institutecombo(vo);
		driverofficialform.setInstlist(instlist);
		deptlist=service.departmentcombo(vo1);
		driverofficialform.setDeptlist(deptlist);
		bloodgplist=service.bloodgpcombo(vo2);
		driverofficialform.setBloodgplist(bloodgplist);
		HttpSession session =((HttpServletRequest)aRequest).getSession();
		session.setAttribute("driverId", driverofficialform.getDriverId());
		String driverid=(String)session.getAttribute("driverId");
		logger.debug("driverid in session in action"+driverid);
		driverofficialform.setDriverId(driverid);
		
	/*	idlist=service.idretrieve(driverid);
		for(int i=0;i<idlist.size();i++)
		{
			idvo=(DriverOfficialVO)idlist.get(i);
		}
		logger.debug("driverid desc:"+idvo.getDriverdesc());
		driverofficialform.setDriverId(idvo.getDriverdesc());*/
		logger.debug("DriverOfficialAction: defaultMethod------------->");
		return aMapping.findForward("load");
	}
	
	/**
	 * save values in database
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
		logger.debug("DriverOfficialAction: saveMethod<-------------");
		DriverOfficialForm form =(DriverOfficialForm)aForm;
		HttpSession session =((HttpServletRequest)aRequest).getSession();
		String driverid=(String)session.getAttribute("driverId");
		vo.setDriverId(driverid);
		logger.debug("driver id via session:"+driverid);
		vo.setInstituteName(form.getInstituteName());
		vo.setDepartment(form.getDepartment());
		vo.setBloodGroup(form.getBloodGroup());
		vo.setEducationalQualification(form.getEducationalQualification());
		vo.setMarks(form.getMarks());
		vo.setTransport(form.getTransport());
		vo.setNonTransport(form.getNonTransport());
		vo.setNonTransportDesc(form.getNonTransportDesc());
		String licenceno=(String)session.getAttribute("driverLicenceNo");
		logger.debug("licence no in official action:"+licenceno);
		vo.setLicenceNo(licenceno);
		//vo.setLicenceNo(form.getLicenceNo());
		//vo.setInsuranceNo(form.getInsuranceNo());
		form.setLicenceNo(licenceno);
		String policyno=(String)session.getAttribute("policyNo");
		logger.debug("policy no in official action:"+policyno);
		vo.setInsuranceNo(policyno);
		form.setInsuranceNo(policyno);
		service.save(vo);
		logger.debug("DriverOfficialAction: saveMethod------------->");
		return aMapping.findForward("load");
	}
	
	public ActionForward updateMethod(ActionMapping aMapping,
	        ActionForm aForm, HttpServletRequest aRequest,
	        HttpServletResponse aResponse)throws Exception{
		logger.debug("DriverOfficialAction: updateMethod<-------------");
		DriverOfficialForm form =(DriverOfficialForm)aForm;
		HttpSession session =((HttpServletRequest)aRequest).getSession();
		String driverid=(String)session.getAttribute("driverId");
		//vo.setDriverId(driverid);
		logger.debug("driver id via session:"+driverid);
		vo.setInstituteName(form.getInstituteName());
		vo.setDepartment(form.getDepartment());
		vo.setBloodGroup(form.getBloodGroup());
		vo.setEducationalQualification(form.getEducationalQualification());
		vo.setMarks(form.getMarks());
		vo.setTransport(form.getTransport());
		vo.setNonTransport(form.getNonTransport());
		vo.setNonTransportDesc(form.getNonTransportDesc());
		String licenceno=(String)session.getAttribute("driverLicenceNo");
		logger.debug("licence no in official action:"+licenceno);
		vo.setLicenceNo(licenceno);
		form.setLicenceNo(licenceno);
		String policyno=(String)session.getAttribute("policyNo");
		logger.debug("policy no in official action:"+policyno);
		vo.setInsuranceNo(policyno);
		form.setInsuranceNo(policyno);
		service.update(vo,driverid);
		logger.debug("DriverOfficialAction: updateMethod------------->");
		return aMapping.findForward("load");
	}
	
	public ActionForward retrieveallMethod(ActionMapping aMapping,
	        ActionForm aForm, HttpServletRequest aRequest,
	        HttpServletResponse aResponse)throws Exception{
		logger.debug("DriverOfficialAction: retrieveallMethod<-------------");
		DriverOfficialForm form =(DriverOfficialForm)aForm;
		idlist=service.idcoderetrieve(form.getDriverId());
		logger.debug("driver id in form:"+form.getDriverId());
		idvo=(DriverOfficialVO)idlist.get(0);
		logger.debug("driver idvo in form:"+idvo.getDriverId());
		list=service.retrieveall(idvo.getDriverId());
		vo=(DriverOfficialVO)list.get(0);
		form.setInstituteName(vo.getInstituteName());
		form.setDepartment(vo.getDepartment());
		form.setEducationalQualification(vo.getEducationalQualification());
		form.setMarks(vo.getMarks());
		form.setTransport(vo.getTransport());
		form.setNonTransport(vo.getNonTransport());
		form.setNonTransportDesc(vo.getNonTransportDesc());
		form.setBloodGroup(vo.getBloodGroup());
		form.setLicenceNo(vo.getLicenceNo());
		form.setInsuranceNo(vo.getInsuranceNo());
		logger.debug("DriverOfficialAction: retrieveallMethod------------->");
		return aMapping.findForward("load");
	}
	/**
	 * Switch to licence form 
	 * @param aMapping
	 * @param aForm
	 * @param aRequest
	 * @param aResponse
	 * @return
	 * @throws Exception
	 */
	public ActionForward licenceMethod(ActionMapping aMapping,
	        ActionForm aForm, HttpServletRequest aRequest,
	        HttpServletResponse aResponse)throws Exception{
		logger.debug("DriverOfficialAction:licenceMethod<-------------");
		logger.debug("DriverOfficialAction:licenceMethod------------->");
		return aMapping.findForward("licence");
		
	}
	/**
	 * Switch to insurance form
	 * @param aMapping
	 * @param aForm
	 * @param aRequest
	 * @param aResponse
	 * @return
	 * @throws Exception
	 */
	public ActionForward insuranceMethod(ActionMapping aMapping,
	        ActionForm aForm, HttpServletRequest aRequest,
	        HttpServletResponse aResponse)throws Exception{
		logger.debug("DriverOfficialAction: insuranceMethod<-------------");
		DriverOfficialForm form =(DriverOfficialForm)aForm;
		logger.debug("DriverOfficialAction: insuranceMethod------------->");
		return aMapping.findForward("insurance");
		
	}
	/**
	 * clear values of office form
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
		logger.debug("DriverOfficialAction: clearformMethod<-------------");
		DriverOfficialForm form =(DriverOfficialForm)aForm;
		form.setInstituteName(null);
		form.setDepartment(null);
		form.setEducationalQualification(null);
		form.setMarks(null);
		form.setTransport(null);
		form.setNonTransport(null);
		form.setNonTransportDesc(null);
		form.setBloodGroup(null);
		form.setLicenceNo(null);
		form.setInsuranceNo(null);
		logger.debug("DriverOfficialAction: clearformMethod------------->");
		return aMapping.findForward("load");
	}
}
