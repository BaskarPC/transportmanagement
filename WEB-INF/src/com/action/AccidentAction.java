package com.action;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import javax.servlet.http.HttpServletResponse;
import com.action.BaseDispatchAction;
import java.util.ArrayList;
import com.formbean.AccidentDetailsForm;
import com.service.Accidentservice;
import com.vo.Accidentvo;
import com.vo.VehicleVo;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


/**
 * 
 * 
 *
 */
public class AccidentAction  extends BaseDispatchAction{
	private static final Logger logger=(Logger)Logger.getLogger(AccidentAction.class);
     Accidentservice service=new Accidentservice();
     Accidentvo  vo=new Accidentvo();
     Accidentvo  vehicleidvo=new Accidentvo();
     Accidentvo  retrievevo=new Accidentvo();
     Accidentvo  drivernamevo=new Accidentvo();
     ArrayList list=new ArrayList();
 	ArrayList instlist=new ArrayList();
 	ArrayList firlist=new ArrayList();
 	ArrayList caselist=new ArrayList();
 	ArrayList expenselist=new ArrayList();
 	ArrayList insurancelist=new ArrayList();
 	ArrayList driverlist=new ArrayList();
 	ArrayList vehicleidlist=new ArrayList();
 	ArrayList retrievelist=new ArrayList();
 	
	/**
	 * Default method to load the combo values
	 */
	public ActionForward defaultMethod(ActionMapping aMapping,
	        ActionForm aForm, HttpServletRequest aRequest,
	        HttpServletResponse aResponse)throws Exception{
		logger.debug("AccidentAction:defaultMethod---------->");
		
		AccidentDetailsForm form=(AccidentDetailsForm)aForm;
		instlist=service.comboInsitute(); 
		form.setInstituteName1List(instlist);
 		list=service.comboInsitute1();
 		form.setInstituteNameList(list);
 		firlist=service.FIRcombo();
 		form.setFIRList(firlist);
 		caselist=service.casecombo();
 		form.setCaseList(caselist);
 		insurancelist=service.insurancecombo();
 		form.setInsuranceList(insurancelist);
 		driverlist=service.driveridcombo();
 		form.setDriverIdList(driverlist);
 		expenselist=service.expensecombo();
 		form.setExpenseList(expenselist);
 		return aMapping.findForward("load");
	}

	/**
	 * To save the values into dtabase
	 * @param aMapping
	 * @param aForm
	 * @param aRequest
	 * @param aResponse
	 * @return
	 * @throws Exception
	 */
	public ActionForward saveMethod(ActionMapping aMapping,
	        ActionForm aForm, HttpServletRequest aRequest,
	        HttpServletResponse aResponse)throws Exception
	        {
		logger.debug("VehicleDetailsAction: saveMethod<-------------");	
		AccidentDetailsForm  form=(AccidentDetailsForm)aForm;
		
		vo.setAccidentDate(form.getAccidentDate());
		vo.setAccidentPlace(form.getAccidentPlace());
		vo.setAccidentTime(form.getAccidentTime());
		vo.setNearByPoliceStation(form.getNearByPoliceStation());
		vo.setVehicleId(form.getVehicleId());
		vo.setVehicleType(form.getVehicleType());
		vo.setInstituteName1(form.getInstituteName1());
		vo.setDriverId(form.getDriverId());
		vo.setDriverName(form.getDriverName());
		vo.setOpponentVehicleId(form.getOpponentVehicleId());
		vo.setOpponentVehicleType(form.getOpponentVehicleType());
		vo.setNoOfPersonsInjured(form.getNoOfPersonsInjured());
		vo.setFIROption(form.getFIROption());
		vo.setCaseOption(form.getCaseOption());			
		vo.setInsuranceOption(form.getInsuranceOption());
		vo.setAmtClaimedFromInsurance(form.getAmtClaimedFromInsurance());
		vo.setAmtClaimedFromOpponent(form.getAmtClaimedFromOpponent());
		vo.setDriverPaid(form.getDriverPaid());
		vo.setInstituteName(form.getInstituteName());
		vo.setAmtPaidByInstitute(form.getAmtPaidByInstitute());
		vo.setAccidentDesc(form.getAccidentDesc());
		vo.setExpense(form.getExpense());
		service.save(vo);
		return aMapping.findForward("load");	    
    }
	
	/**
	 * TO retrieve a vehicletype for corresponding institute
	 * @param aMapping
	 * @param aForm
	 * @param aRequest
	 * @param aResponse
	 * @return
	 * @throws Exception
	 */
	public ActionForward vehicletyperetrieveMethod(ActionMapping aMapping,
	        ActionForm aForm, HttpServletRequest aRequest,
	        HttpServletResponse aResponse)throws Exception
	   {
		logger.debug("VehicleDetailsAction: saveMethod<-------------");	
		AccidentDetailsForm  form=(AccidentDetailsForm)aForm;
		int instid=Integer.parseInt(form.getInstituteName1());
		list=service.vehicletyperetrieve(instid); 
	    form.setVehicleTypeList(list);
	    return aMapping.findForward("load");	    
    }
	
	/**
	 * To retrieve a vehicleid for corresponding vehicle type
	 * @param aMapping
	 * @param aForm
	 * @param aRequest
	 * @param aResponse
	 * @return
	 * @throws Exception
	 */
	public ActionForward vehicleidretrieveMethod(ActionMapping aMapping,
	        ActionForm aForm, HttpServletRequest aRequest,
	        HttpServletResponse aResponse)throws Exception
	   {
		logger.debug("VehicleDetailsAction: vehicleidretrieveMethod<-------------");	
		AccidentDetailsForm  form=(AccidentDetailsForm)aForm;
		int vehicletype=Integer.parseInt(form.getVehicleType());
		list=service.vehicleidretrieve(vehicletype);
		form.setVehicleIdList(list);
		 return aMapping.findForward("load");	    
	  }
	
	/**
	 * To retrieve a driver name for corresponding driver id
	 * @param aMapping
	 * @param aForm
	 * @param aRequest
	 * @param aResponse
	 * @return
	 * @throws Exception
	 */
	public ActionForward drivernameretrieveMethod(ActionMapping aMapping,
	        ActionForm aForm, HttpServletRequest aRequest,
	        HttpServletResponse aResponse)throws Exception
	   {
		logger.debug("VehicleDetailsAction: drivernameretrieveMethod<-------------");	
		AccidentDetailsForm  form=(AccidentDetailsForm)aForm;
		int id=Integer.parseInt(form.getDriverId());
		list=service.drivernameretrieve(id);
		for(int i=0;i<list.size();i++)
		{
			vo=(Accidentvo)list.get(i);		
		}
		form.setDriverName(vo.getDriverName());
		return aMapping.findForward("load");	    
	 }
	
	/**
	 * To load the value from lookup table and set that value into session
	 * @param aMapping
	 * @param aForm
	 * @param aRequest
	 * @param aResponse
	 * @return
	 * @throws Exception
	 */
	public ActionForward expensechangeMethod(ActionMapping aMapping,
	        ActionForm aForm, HttpServletRequest aRequest,
	        HttpServletResponse aResponse)throws Exception
	   {
		logger.debug("VehicleDetailsAction: expensechangeMethod<-------------");	
		AccidentDetailsForm  form=(AccidentDetailsForm)aForm;
		int expense=Integer.parseInt(form.getExpense());
		list=service.expensedesc(expense);
		for(int i=0;i<expenselist.size();i++)
		{
			vo=(Accidentvo)expenselist.get(i);
		}
		logger.debug("value in expense"+vo.getExpensedesc());
		HttpSession session=aRequest.getSession();
		session.setAttribute("EXPENSES",vo.getExpensedesc());
		if(session.getAttribute("EXPENSES")=="DriverPaid")
		{
			logger.debug("this is driver paid");
		}
		return aMapping.findForward("load");	    
	   }
		
	/**
	 * Retrieve all the vehicleid from database and compare it with vehicleid in form,
	 * if both are equal means retrieve the corresponding values otherwise set into null
	 * @param aMapping
	 * @param aForm
	 * @param aRequest
	 * @param aResponse
	 * @return
	 * @throws Exception
	 */
	public ActionForward retrieveMethod(ActionMapping aMapping,
	        ActionForm aForm, HttpServletRequest aRequest,
	        HttpServletResponse aResponse)throws Exception
	   {
		logger.debug("VehicleDetailsAction: retrieveMethod<-------------");	
		AccidentDetailsForm  form=(AccidentDetailsForm)aForm;
		
		list=service.retrieveall();
		for(int i=0;i<list.size();i++)
		{
			vo=(Accidentvo)list.get(i);			
		}
		int id=Integer.parseInt(form.getVehicleId());
		vehicleidlist=service.formvehicleid(id);
		for(int i=0;i<vehicleidlist.size();i++)
		{
			vehicleidvo=(Accidentvo)vehicleidlist.get(i);
		}		
		retrievelist=service.retrieve(id);
		for(int i=0;i<retrievelist.size();i++)
		{
			retrievevo=(Accidentvo)retrievelist.get(i);
		}		
		int did=Integer.parseInt(retrievevo.getDriverName());
		driverlist=service.drivernamedesc(did);
		drivernamevo=(Accidentvo)driverlist.get(0);		
		for(int i=0;i<list.size();i++)
		{
			if(vo.getVehicleiddesc().equals(vehicleidvo.getVehicleiddesc()))
			{
				form.setAccidentDate(retrievevo.getAccidentDate());
				form.setAccidentTime(retrievevo.getAccidentTime());
				form.setAccidentPlace(retrievevo.getAccidentPlace());				
				form.setNearByPoliceStation(retrievevo.getNearByPoliceStation());
				form.setDriverId(retrievevo.getDriverId());
				form.setDriverName(drivernamevo.getDrivernamedesc());
				form.setOpponentVehicleId(retrievevo.getOpponentVehicleId());
				form.setOpponentVehicleType(retrievevo.getOpponentVehicleType());
				form.setNoOfPersonsInjured(retrievevo.getNoOfPersonsInjured());
				form.setFIROption(retrievevo.getFIROption());
				form.setCaseOption(retrievevo.getCaseOption());
				form.setInsuranceOption(retrievevo.getInsuranceOption());
				form.setAmtClaimedFromInsurance(retrievevo.getAmtClaimedFromInsurance());
				form.setAmtClaimedFromOpponent(retrievevo.getAmtClaimedFromOpponent());
				form.setDriverPaid(retrievevo.getDriverPaid());
				form.setInstituteName(retrievevo.getInstituteName());
				form.setAmtPaidByInstitute(retrievevo.getAmtPaidByInstitute());
				form.setAccidentDesc(retrievevo.getAccidentDesc());				
				i=list.size()+1;
			}
			else
			{
			form.setAccidentDate(null);
			form.setAccidentPlace(null);
			form.setAccidentTime(null);
			form.setNearByPoliceStation(null);
			form.setDriverId(null);
			form.setDriverName(null);
			form.setOpponentVehicleId(null);
			form.setOpponentVehicleType(null);
			form.setNoOfPersonsInjured(null);
			form.setFIROption(null);
			form.setCaseOption(null);
			form.setInsuranceOption(null);
			form.setAmtClaimedFromInsurance(null);
			form.setAmtClaimedFromOpponent(null);
			form.setDriverPaid(null);
			form.setInstituteName(null);
			form.setAmtPaidByInstitute(null);
			form.setAccidentDesc(null);	
			}			
		}		
		return aMapping.findForward("load");	    
	 }
}


