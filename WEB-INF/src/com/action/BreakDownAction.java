package com.action;
import com.service.BreakDownService;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import javax.servlet.http.HttpServletResponse;

import com.action.BaseDispatchAction;
import com.formbean.BreakDownForm;

import java.util.ArrayList;
import com.vo.BreakDownVO;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;



public class BreakDownAction  extends BaseDispatchAction{
	private static final Logger logger=(Logger)Logger.getLogger(BreakDownAction.class);

	ArrayList list=new ArrayList();
	ArrayList retrievelist=new ArrayList();
	ArrayList alterbuslist=new ArrayList();
	ArrayList driveridlist=new ArrayList();
	ArrayList alterdriverlist=new ArrayList();
	ArrayList vehicleidlist=new ArrayList();
	ArrayList formlist=new ArrayList();
	BreakDownService service=new BreakDownService();
	BreakDownVO vo=new BreakDownVO();
	BreakDownVO formvo=new BreakDownVO();
	BreakDownVO driveridvo=new BreakDownVO();
	BreakDownVO alterdrivervo=new BreakDownVO();
	BreakDownVO alterbusvo=new BreakDownVO();
	BreakDownVO retrievevo=new BreakDownVO();
	BreakDownVO vehicleidvo=new BreakDownVO();
	
	/**
	 * Method to load driverID,Alternate DriverID
	 * 
	 *
	 */
	public ActionForward defaultMethod(ActionMapping aMapping,
	        ActionForm aForm, HttpServletRequest aRequest,
	        HttpServletResponse aResponse)throws Exception{
		BreakDownForm form=(BreakDownForm)aForm;
		logger.debug("BreakDownAction:defaultMethod---------->");
		list=service.instcombo(vo);
		form.setInstList(list);		
		driveridlist=service.driveridcombo(vo);
		for(int i=0;i<driveridlist.size();i++)
		{
			vo=(BreakDownVO)driveridlist.get(i);
		}
		form.setDriverIdList(driveridlist);
		alterdriverlist=service.driveridcombo(vo);
		form.setAlterdriverIdList(alterdriverlist);
		return aMapping.findForward("load");
	}
	
	/**
	 * driver name retrieve method
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
    	BreakDownForm form=(BreakDownForm)aForm;
    	logger.debug("BreakDownAction:retrieveMethod---------->");
    	int id=Integer.parseInt(form.getDriverId());
		list=service.retrievecombo(id);
		for(int i=0;i<list.size();i++)
		{
			vo=(BreakDownVO)list.get(i);
		}   
		form.setDriverName(vo.getDriverName());
		return aMapping.findForward("load");
}
	
	/**
	 * retrieve vehicle ID 
	 */
	public ActionForward vehicleretrieveMethod(ActionMapping aMapping,
	        ActionForm aForm, HttpServletRequest aRequest,
	        HttpServletResponse aResponse)throws Exception{
		BreakDownForm form=(BreakDownForm)aForm;
    	logger.debug("BreakDownAction:vehicleretrieveMethod---------->");
      	String str=form.getInstituteName();
    	list=service.vehicleretrieve(str);
     	form.setVehicleList(list);
    	return aMapping.findForward("load");
	}

	/**
	 * retrieve alternate driver name
	 */
	public ActionForward nameretrieveMethod(ActionMapping aMapping,
	        ActionForm aForm, HttpServletRequest aRequest,
	        HttpServletResponse aResponse)throws Exception{
		BreakDownForm form=(BreakDownForm)aForm;
    	logger.debug("BreakDownAction:nameretrieveMethod---------->");
     	int id=Integer.parseInt(form.getAlterdriverId());
    	list=service.nameretrieve(id);
       	for(int i=0;i<list.size();i++)
    	{
    		vo=(BreakDownVO)list.get(i);
    	}
    	form.setAlternateBusDriverName(vo.getAlternateBusDriverName());
    	return aMapping.findForward("load");
	} 
	
	/**
	 * Retrieve all vehicleid from database and caompare it with vehicleid in form.
	 * if both are equal, retrieve corresponding values,otherwise set into null
	 * @param aMapping
	 * @param aForm
	 * @param aRequest
	 * @param aResponse
	 * @return
	 * @throws Exception
	 */
	public ActionForward retrieveallMethod(ActionMapping aMapping,
	        ActionForm aForm, HttpServletRequest aRequest,
	        HttpServletResponse aResponse)throws Exception{
		BreakDownForm form=(BreakDownForm)aForm;
    	logger.debug("BreakDownAction:routeretrieveMethod---------->");
    	int drivername,alterdriver,alterbus;
      	int id=Integer.parseInt(form.getVehicleId());
    	vehicleidlist=service.vehicleidretrieve(id);
    	
    	formlist=service.formretrieve(id);
    	for(int i=0;i<formlist.size();i++)
    	{
    		formvo=(BreakDownVO)formlist.get(i);
    	}
    	
    for(int j=0;j<vehicleidlist.size();j++)
    {
          vehicleidvo=(BreakDownVO)vehicleidlist.get(j);
          if(vehicleidvo.getVehicleiddesc().equals(formvo.getVehicleiddesc()))
          {
        	   	list=service.routenoretrieve(id);
        	  	for(int i=0;i<list.size();i++)
        	  	{
        	  		vo=(BreakDownVO)list.get(i);   		   
        	  	}
        	  	form.setRouteNo(vo.getRouteNo());
   	   
        	  	retrievelist=service.retrieveall(id);
        	  	for(int i=0;i<retrievelist.size();i++)
        	  	{
        	  		retrievevo=(BreakDownVO)retrievelist.get(i);
        	  	}
        	  	
        	  	drivername=Integer.parseInt(retrievevo.getDriverName());
        	  	driveridlist=service.drivernameretrieve(drivername);
        	  	for(int i=0;i<driveridlist.size();i++)
        	  	{
        	  		driveridvo=(BreakDownVO)driveridlist.get(i);
        	  	}
        	  	
        	  	alterdriver=Integer.parseInt(retrievevo.getAlternateBusDriverName());
        	  	alterdriverlist=service.alterdriver(alterdriver);
        	  	for(int i=0;i<alterdriverlist.size();i++)
        	  	{
        	  		alterdrivervo=(BreakDownVO)alterdriverlist.get(i);
        	  	}
        	  	
        	  	alterbus=Integer.parseInt(retrievevo.getAlternateBusId());
        	  	alterbuslist=service.alterbus(alterbus);
        	  	for(int i=0;i<alterbuslist.size();i++)
        	  	{
        	  	alterbusvo=(BreakDownVO)alterbuslist.get(i);
        	  	}        	  	
        	  	form.setDriverId(retrievevo.getDriverId());
        	    form.setDriverName(driveridvo.getDriverName());
        	    form.setBreakDownDate(retrievevo.getBreakDownDate());
        	    form.setBreakDownPlace(retrievevo.getBreakDownPlace());
        	    form.setBreakDownTime(retrievevo.getBreakDownTime());
        	    form.setNatureOfBreakDown(retrievevo.getNatureOfBreakDown());
        	    form.setAlternateBusId(alterbusvo.getAlternateBusId());
        	    form.setAlterdriverId(retrievevo.getAlterdriverId());
        	    form.setAlternateBusDriverName(alterdrivervo.getAlternateBusDriverName());
        	    form.setRemarks(retrievevo.getRemarks());
        	   	j=vehicleidlist.size()+1;
          }
          else
          {
        	  form.setBreakDownDate(null);
        	  form.setBreakDownPlace(null);
        	  form.setBreakDownTime(null);
        	  form.setDriverId(null);
        	  form.setDriverName(null);
        	  form.setRouteNo(null);
        	  form.setNatureOfBreakDown(null);
        	  form.setAlterdriverId(null);
        	  form.setAlternateBusDriverName(null);
        	  form.setAlternateBusId(null);
        	  form.setRemarks(null);
          }        	  
    }   	   
              return aMapping.findForward("load");
	}  
	
	/**
	 * insert the values into database
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
		BreakDownForm form=(BreakDownForm)aForm;
		logger.debug("BreakDownAction:saveMethod---------->");
		vo.setBreakDownDate(form.getBreakDownDate());
		vo.setBreakDownPlace(form.getBreakDownPlace());
		vo.setBreakDownTime(form.getBreakDownTime());
		vo.setDriverId(form.getDriverId());
		vo.setDriverName(form.getDriverName());
		vo.setInstituteName(form.getInstituteName());
		vo.setVehicleId(form.getVehicleId());
		vo.setRouteNo(form.getRouteNo());
		vo.setNatureOfBreakDown(form.getNatureOfBreakDown());
		 vo.setAlternateBusId(form.getAlternateBusId());
		vo.setAlterdriverId(form.getAlterdriverId());
		vo.setAlternateBusDriverName(form.getAlternateBusDriverName());
		vo.setRemarks(form.getRemarks());
		service.insert(vo);
		return aMapping.findForward("load");
	}
	
	/**
	 * clear the values of form
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
		BreakDownForm form=(BreakDownForm)aForm;
		logger.debug("BreakDownAction:clearformMethod---------->");
		form.setBreakDownDate(null);
		form.setBreakDownPlace(null);
		form.setBreakDownTime(null);
		form.setDriverId(null);
		form.setDriverName(null);
		form.setInstituteName(null);
		form.setVehicleId(null);
		form.setRouteNo(null);
		form.setNatureOfBreakDown(null);
		form.setAlternateBusId(null);
		form.setAlterdriverId(null);
		form.setAlternateBusDriverName(null);
		form.setRemarks(null);
		return aMapping.findForward("load");
	}
}



