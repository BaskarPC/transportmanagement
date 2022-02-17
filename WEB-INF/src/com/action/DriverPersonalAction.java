package com.action;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import javax.servlet.http.HttpServletResponse;
import com.formbean.DriverPersonalForm;
import com.service.DriverPersonalService;
import com.action.BaseDispatchAction;
import java.util.ArrayList;

import com.vo.DriverLeaveVO;
import com.vo.DriverLicenceVO;
import com.vo.DriverPersonalVO;
import com.vo.DriverOfficialVO;
import com.vo.DriverPolicyVO;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


/**
 * Driver personal action
 * @author administrator
 *
 */
 
 
public class DriverPersonalAction  extends BaseDispatchAction{
	private static final Logger logger=(Logger)Logger.getLogger(DriverPersonalAction.class);
	 
	DriverPersonalService personservice=new DriverPersonalService();
	DriverPersonalVO vo=new DriverPersonalVO();
	DriverPersonalVO vo1=new DriverPersonalVO();
	DriverPersonalVO drivervo=new DriverPersonalVO();
	DriverPersonalVO drivervo1=new DriverPersonalVO();
	DriverOfficialVO newvo=new DriverOfficialVO();
	DriverLicenceVO licencevo=new DriverLicenceVO();
	DriverPolicyVO policyvo=new DriverPolicyVO();
	DriverLeaveVO leavevo=new DriverLeaveVO();
	ArrayList driverlist =new ArrayList();
	ArrayList list =new ArrayList();
	ArrayList newlist =new ArrayList();
	ArrayList idlist =new ArrayList();
	DriverPersonalVO idvo=new DriverPersonalVO();
	ArrayList driveridlist =new ArrayList();
	DriverPersonalVO driveridvo=new DriverPersonalVO();

	public ActionForward defaultMethod(ActionMapping aMapping,
	        ActionForm aForm, HttpServletRequest aRequest,
	        HttpServletResponse aResponse)throws Exception{
		logger.debug("DriverPersonalAction: defaultMethod<-------------");
		DriverPersonalForm form=(DriverPersonalForm)aForm;
		list=personservice.driveridretrieve(vo);
		form.setDriveridList(list);
		list=personservice.districtcombo1(vo);
		form.setDistrict1List(list);
		list=personservice.districtcombo2(vo);
		form.setDistrict2List(list);
		list=personservice.statecombo1(vo);
		form.setState1List(list);
		list=personservice.statecombo2(vo);
		form.setState2List(list);
		list=personservice.communitycombo(vo);
		form.setCommunityList(list);
		list=personservice.religioncombo(vo);
		form.setReligionList(list);
		logger.debug("DriverPersonalAction: defaultMethod------------->");
		return aMapping.findForward("load");
		
	}
	/**
	 * Used to save values in database 
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
		logger.debug("DriverPersonalAction: saveMethod<-------------");
		DriverPersonalForm form=(DriverPersonalForm)aForm;
		vo.setDriverId(driveridvo.getSeqid());
		vo.setDriverName(form.getDriverName());
		vo.setPermanentAddress(form.getPermanentAddress());
		vo.setTemporaryAddress(form.getTemporaryAddress());
		vo.setDistrict1(form.getDistrict1());
		vo.setDistrict2(form.getDistrict2());
		vo.setState1(form.getState1());
		vo.setState2(form.getState2());
		vo.setMobileNo(form.getMobileNo());
	    vo.setResidentialNo1(form.getResidentialNo1());
	    vo.setResidentialNo2(form.getResidentialNo2());
	    vo.setSalary(form.getSalary());
	    vo.setCommunity(form.getCommunity());
	    vo.setCaste(form.getCaste());
	    vo.setReligion(form.getReligion());
	    vo.setDOB(form.getDOB());
	    vo.setDOJ(form.getDOJ());
	   	personservice.save(vo);
	   	list=personservice.driveridretrieve(vo);
		logger.debug("array size of driverid while retrieving:"+list.size());
		form.setDriveridList(list);
	   	HttpSession session =((HttpServletRequest)aRequest).getSession();
	   	if(form.getDriverId().equals("177"))
	   	{
	   	logger.debug("driver id in save"+driveridvo.getSeqid());
		session.setAttribute("driverId", driveridvo.getSeqid());
		String driverid=(String)session.getAttribute("driverId");
		logger.debug("driverid in session"+driverid);
	   	}
	  	else
	   	{
	   		session.setAttribute("driverId", form.getDriverId());
	   		String driverid=(String)session.getAttribute("driverId");
	   		logger.debug("driverid in session(other than new)"+driverid);
	   	}
		logger.debug("DriverPersonalAction: saveMethod------------->");
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
	public ActionForward updateMethod(ActionMapping aMapping,
	        ActionForm aForm, HttpServletRequest aRequest,
	        HttpServletResponse aResponse)throws Exception{
		logger.debug("DriverPersonalAction: updateMethod<-------------");
		DriverPersonalForm form=(DriverPersonalForm)aForm;
	    logger.debug("form.getdriverid:"+form.getDriverId());
		vo.setDriverName(form.getDriverName());
		vo.setPermanentAddress(form.getPermanentAddress());
		vo.setTemporaryAddress(form.getTemporaryAddress());
		vo.setDistrict1(form.getDistrict1());
		vo.setDistrict2(form.getDistrict2());
		vo.setState1(form.getState1());
		vo.setState2(form.getState2());
		vo.setMobileNo(form.getMobileNo());
	    vo.setResidentialNo1(form.getResidentialNo1());
	    vo.setResidentialNo2(form.getResidentialNo2());
	    vo.setSalary(form.getSalary());
	    vo.setCommunity(form.getCommunity());
	    vo.setCaste(form.getCaste());
	    vo.setReligion(form.getReligion());
	    vo.setDOB(form.getDOB());
	    vo.setDOJ(form.getDOJ());
	   	personservice.update(vo,form.getDriverId());
		logger.debug("DriverPersonalAction: updateMethod------------->");
		  return aMapping.findForward("load");
		}
	
	/**
	 * Used to retrieve values from database
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
		logger.debug("DriverPersonalAction: retrieveMethod<-------------");
		DriverPersonalForm form=(DriverPersonalForm)aForm;
		idlist=personservice.idretrieve(form.getDriverId());
		logger.debug("driver id in form:"+form.getDriverId());
		for(int i=0;i<idlist.size();i++)
		{
			idvo=(DriverPersonalVO)idlist.get(i);
		}
		logger.debug("driver idvo in form:"+idvo.getDrivercode());
		if(idvo.getDriverdesc().equals("new driver"))
		{
			logger.debug("outside if");
			driveridlist=personservice.driveridcombo(vo);
			logger.debug("array size of driverid in action:"+driveridlist.size());
			
			for(int j=0;j<driveridlist.size();j++)
			{
			driveridvo=(DriverPersonalVO)driveridlist.get(j);
			logger.debug("driverid seq:"+driveridvo.getSeqid());
			}
			form.setDriverName(null);
			form.setPermanentAddress(null);
			form.setDistrict1(null);
			form.setState1(null);
			form.setTemporaryAddress(null);
			form.setDistrict2(null);
			form.setState2(null);
			form.setMobileNo(null);
			form.setResidentialNo1(null);
			form.setResidentialNo2(null);
			form.setSalary(null);
			form.setDOB(null);
			form.setDOJ(null);
			form.setCommunity(null);
			form.setReligion(null);
			form.setCaste(null);
		}
		else 
		{
			
		newlist=personservice.retrieveall();
		for(int i=0;i<newlist.size();i++)
		{
		drivervo1=(DriverPersonalVO)newlist.get(i);
		logger.debug("driver desc in action from action:"+drivervo1.getDriverdesc());
		logger.debug("idvo in action:"+idvo.getDrivercode());
			if(drivervo1.getDriverdesc().equals(idvo.getDriverdesc()))
			{
				logger.debug("inside equal if");
				list=personservice.retrieve(form.getDriverId());
				logger.debug("driver id inside if"+form.getDriverId());
				vo=(DriverPersonalVO)list.get(0);
				driverlist=personservice.drivernamelookup(vo.getDriverName());
				drivervo=(DriverPersonalVO)driverlist.get(0);
				form.setDriverName(drivervo.getDriverName());
				form.setPermanentAddress(vo.getPermanentAddress());
				form.setDistrict1(vo.getDistrict1());
				form.setState1(vo.getState1());
				form.setTemporaryAddress(vo.getTemporaryAddress());
				form.setDistrict2(vo.getDistrict2());
				form.setState2(vo.getState2());
				form.setMobileNo(vo.getMobileNo());
				form.setResidentialNo1(vo.getResidentialNo1());
				form.setResidentialNo2(vo.getResidentialNo2());
				form.setSalary(vo.getSalary());
				form.setCommunity(vo.getCommunity());
				form.setCaste(vo.getCaste());
				form.setReligion(vo.getReligion());
				form.setDOB(vo.getDOB());
				form.setDOJ(vo.getDOJ());
				i=newlist.size()+1;
			}
		}
	}
		logger.debug("DriverPersonalAction: retrieveMethod------------->");
	return aMapping.findForward("load");
		
	}
	/**
	 * Used to delete driver related details
	 * @param aMapping
	 * @param aForm
	 * @param aRequest
	 * @param aResponse
	 * @return
	 * @throws Exception
	 */
	public ActionForward deleteindicatorMethod(ActionMapping aMapping,
	        ActionForm aForm, HttpServletRequest aRequest,
	        HttpServletResponse aResponse)throws Exception{
		logger.debug("DriverPersonalAction:deleteindicatorMethod<-------------");
		DriverPersonalForm form=(DriverPersonalForm)aForm;
		String ind=form.getDriverId();
		personservice.deleteind(newvo,ind);
		personservice.licencedeleteind(licencevo,ind);
		personservice.policydeleteind(policyvo,ind);
		personservice.leavedeleteind(leavevo,ind);
		logger.debug("DriverPersonalAction: deleteindicatorMethod------------->");
		return aMapping.findForward("load");
	}
	/**
	 * Used to clear the form
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
		logger.debug("DriverPersonalAction:clearformMethod<-------------");
		DriverPersonalForm form=(DriverPersonalForm)aForm;
		form.setDriverId(null);
		form.setDriverName(null);
		form.setPermanentAddress(null);
		form.setDistrict1(null);
		form.setState1(null);
		form.setTemporaryAddress(null);
		form.setDistrict2(null);
		form.setState2(null);
		form.setMobileNo(null);
		form.setResidentialNo1(null);
		form.setResidentialNo2(null);
		form.setSalary(null);
		form.setDOB(null);
		form.setDOJ(null);
		form.setCommunity(null);
		form.setReligion(null);
		form.setCaste(null);
		logger.debug("DriverPersonalAction: clearformMethod------------->");
		return aMapping.findForward("load");
	}
	
		
}
