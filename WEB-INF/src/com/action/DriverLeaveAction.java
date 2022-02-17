package com.action;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import javax.servlet.http.HttpServletResponse;

import com.action.BaseDispatchAction;
import java.util.ArrayList;
import com.vo.DriverLeaveVO;
import com.vo.DriverLicenceVO;
import com.dao.DriverLeaveDAO;
import com.formbean.DriverLeaveForm;
import com.service.DriverLeaveService;
import com.vo.UserVerifyVO;
import com.dbcom.*;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionErrors;


/**
 * 
 * @author Sunil
 *
 */
public class DriverLeaveAction  extends BaseDispatchAction{
	private static final Logger logger=(Logger)Logger.getLogger(DriverLeaveAction.class);

	/**
	 * load driverid in combo
	 */
	DriverLeaveService service=new DriverLeaveService();
	ArrayList list=new ArrayList();
	ArrayList idlist=new ArrayList();
	ArrayList retrievelist=new ArrayList();
	DriverLeaveVO vo=new DriverLeaveVO();
	DriverLeaveVO idvo=new DriverLeaveVO();
	DriverLeaveVO retrievevo=new DriverLeaveVO();
	
	dbcom db=new dbcom();
	public ActionForward defaultMethod(ActionMapping aMapping,
	        ActionForm aForm, HttpServletRequest aRequest,
	        HttpServletResponse aResponse)throws Exception{
			logger.debug("DriverLeaveAction:defaultMethod---------->");
			DriverLeaveForm form=(DriverLeaveForm)aForm;
			list=service.driveridcombo(vo);
			form.setIdList(list);
			logger.debug("DriverLeaveAction:defaultMethod<----------");
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
 */	public ActionForward retrieveMethod(ActionMapping aMapping,
	        ActionForm aForm, HttpServletRequest aRequest,
	        HttpServletResponse aResponse)throws Exception{
		ArrayList list1=new ArrayList();
		ArrayList list3=new ArrayList();
		DriverLeaveVO vo1=new DriverLeaveVO();
		logger.debug("DriverLeaveAction: retrieve Method<----------");
		DriverLeaveForm form=(DriverLeaveForm)aForm;
		DriverLeaveVO voo=new DriverLeaveVO();
		idlist=service.idretrieve(form.getDriverId());
		for(int i=0;i<idlist.size();i++)
		{
			idvo=(DriverLeaveVO)idlist.get(i);
		}
		retrievelist=service.retrieveall();
		for(int i=0;i<retrievelist.size();i++)
		{
		retrievevo=(DriverLeaveVO)retrievelist.get(i);
		if(retrievevo.getDriverdesc().equals(idvo.getDriverdesc()))
		{
		logger.debug("equal inside if");
		int id=Integer.parseInt(form.getDriverId());
		list=service.comboretrieve(id);
		vo=(DriverLeaveVO)list.get(0);
		form.setDriverName(vo.getDriverName());
		list1=service.deptretrieve(id);
		vo1=(DriverLeaveVO)list1.get(0);
		form.setDepartment(vo1.getDepartment());
		list3=service.retrieve(id);
		voo=(DriverLeaveVO)list3.get(0);
		form.setNoOfDaysLeaveRequired(voo.getNoOfDaysLeaveRequired());
		list=service.leavetaken(id);
		vo=(DriverLeaveVO)list.get(0);
		int oldleave=Integer.parseInt(vo.getLeaveAlreadyTaken());
		int noofdays=Integer.parseInt(vo.getNoOfDaysLeaveRequired());
		int newleave=oldleave+noofdays;
		Integer.toString(newleave);
		form.setLeaveAlreadyTaken(Integer.toString(newleave));	
		form.setCasualLeave(voo.getCasualLeave());
		form.setCompensationLeave(voo.getCompensationLeave());
		form.setMedicalLeave(voo.getMedicalLeave());
		form.setVacationLeave(voo.getVacationLeave());
		i=retrievelist.size()+1;
			}
		
		else
		{
			int id=Integer.parseInt(form.getDriverId());
			list=service.comboretrieve(id);
			vo=(DriverLeaveVO)list.get(0);
			form.setDriverName(vo.getDriverName());
			list1=service.deptretrieve(id);
			vo1=(DriverLeaveVO)list1.get(0);
			form.setDepartment(vo1.getDepartment());
			form.setNoOfDaysLeaveRequired(null);
			form.setLeaveAlreadyTaken("0");
			form.setCompensationLeave(null);
			form.setCasualLeave("12");
			form.setMedicalLeave("0");
			form.setVacationLeave("0");
		}
	}
		logger.debug("DriverLeaveAction:retrieve Method---------->");
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
	
	public ActionForward saveMethod(ActionMapping aMapping,
	        ActionForm aForm, HttpServletRequest aRequest,
	        HttpServletResponse aResponse)throws Exception{

		logger.debug("DriverLeaveAction: saveMethod<----------");
		DriverLeaveForm form=(DriverLeaveForm)aForm;
		vo.setDriverId(form.getDriverId());
		vo.setDriverName(form.getDriverName());
		vo.setDepartment(form.getDepartment());
		vo.setNoOfDaysLeaveRequired(form.getNoOfDaysLeaveRequired());
		vo.setLeaveAlreadyTaken(form.getLeaveAlreadyTaken());
		vo.setCasualLeave(form.getCasualLeave());
		vo.setCompensationLeave(form.getCompensationLeave());
		vo.setMedicalLeave(form.getMedicalLeave());
		vo.setVacationLeave(form.getVacationLeave());
		service.insert(vo);
		logger.debug("DriverLeaveAction: saveMethod---------->");
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

		logger.debug("DriverLeaveAction: updateMethod<----------");
		DriverLeaveForm form=(DriverLeaveForm)aForm;
		//vo.setDriverId(form.getDriverId());
		vo.setDriverName(form.getDriverName());
		vo.setDepartment(form.getDepartment());
		vo.setNoOfDaysLeaveRequired(form.getNoOfDaysLeaveRequired());
		vo.setLeaveAlreadyTaken(form.getLeaveAlreadyTaken());
		vo.setCasualLeave(form.getCasualLeave());
		vo.setCompensationLeave(form.getCompensationLeave());
		vo.setMedicalLeave(form.getMedicalLeave());
		vo.setVacationLeave(form.getVacationLeave());
		service.update(vo,form.getDriverId());
		logger.debug("DriverLeaveAction: updateMethod---------->");
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
	
	public ActionForward calcMethod(ActionMapping aMapping,
	        ActionForm aForm, HttpServletRequest aRequest,
	        HttpServletResponse aResponse)throws Exception{

		logger.debug("DriverLeaveAction: calcMethod<----------");
		DriverLeaveForm form=(DriverLeaveForm)aForm;
		int days=Integer.parseInt(form.getNoOfDaysLeaveRequired());
		int oldcasual=Integer.parseInt(form.getCasualLeave());
		int newcasual;
		if(days<=oldcasual)
		{
		newcasual=oldcasual-days;
  		form.setCasualLeave(Integer.toString(newcasual));
		}
		else
		{
			logger.error("U have no sufficient leave days");
		}
		logger.debug("DriverLeaveAction: calcMethod---------->");
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
	
	public ActionForward compcalcMethod(ActionMapping aMapping,
	        ActionForm aForm, HttpServletRequest aRequest,
	        HttpServletResponse aResponse)throws Exception{
		logger.debug("DriverLeaveAction: compcalcMethod<----------");
		DriverLeaveForm form=(DriverLeaveForm)aForm;
		int casual=Integer.parseInt(form.getCasualLeave());
		int oldcomp=Integer.parseInt(form.getCompensationLeave());
		int newcomp=oldcomp+casual;
  		form.setCasualLeave(Integer.toString(newcomp));
  		form.setCompensationLeave("0");
		return aMapping.findForward("load");
	}
	
	public ActionForward medicalcalcMethod(ActionMapping aMapping,
	        ActionForm aForm, HttpServletRequest aRequest,
	        HttpServletResponse aResponse)throws Exception{
		logger.debug("DriverLeaveAction: medicalcalcMethod<----------");
		DriverLeaveForm form=(DriverLeaveForm)aForm;
		int id=Integer.parseInt(form.getDriverId());
		list=service.medicalcal(id);
		vo=(DriverLeaveVO)list.get(0);
		int oldmedical=Integer.parseInt(vo.getMedicalLeave());
		int newmedical=Integer.parseInt(form.getMedicalLeave());
		int calc=oldmedical+newmedical;
	    form.setMedicalLeave(Integer.toString(calc));
	    logger.debug("DriverLeaveAction:medicalcalcMethod <----------");
	    return aMapping.findForward("load");
	}
	
	public ActionForward vacationcalcMethod(ActionMapping aMapping,
	        ActionForm aForm, HttpServletRequest aRequest,
	        HttpServletResponse aResponse)throws Exception{
		logger.debug("DriverLeaveAction:vacationcalcMethod<----------");
		DriverLeaveForm form=(DriverLeaveForm)aForm;
		int id=Integer.parseInt(form.getDriverId());
		list=service.vacationcal(id);
		vo=(DriverLeaveVO)list.get(0);
		int oldvacation=Integer.parseInt(vo.getVacationLeave());
		int newvacation=Integer.parseInt(form.getVacationLeave());
		int calc=oldvacation+newvacation;
	    form.setVacationLeave(Integer.toString(calc));
	    logger.debug("DriverLeaveAction:vacationcalcMethod <----------");
	    return aMapping.findForward("load");
	}
	
	public ActionForward clearmtdMethod(ActionMapping aMapping,
	        ActionForm aForm, HttpServletRequest aRequest,
	        HttpServletResponse aResponse)throws Exception{
    	logger.debug("DriverLeaveAction: clearMethod<----------");
		DriverLeaveForm form=(DriverLeaveForm)aForm;
		form.setDriverId(null);
		form.setDriverName(null);
		form.setDepartment(null);
		form.setNoOfDaysLeaveRequired(null);
		form.setLeaveAlreadyTaken(null);
		form.setCasualLeave(null);
		form.setCompensationLeave(null);
		form.setMedicalLeave(null);
		form.setVacationLeave(null);       
		logger.debug("DriverLeaveAction:clearMethod <----------");
		return aMapping.findForward("load");
	}
	
	
	
		
}