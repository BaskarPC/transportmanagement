package com.action;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.*;
import com.formbean.BusAllotmentForm;
import com.service.BusAllotmentService;
import com.vo.BusAllotmentVO;
import com.action.BaseDispatchAction;
import java.util.ArrayList;
import com.vo.UserVO;
import com.vo.UserVerifyVO;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class BusAllotmentAction  extends BaseDispatchAction{
	private static final Logger logger=(Logger)Logger.getLogger(BusAllotmentAction.class);

	BusAllotmentService service=new BusAllotmentService();
	ArrayList list=new ArrayList();
	ArrayList vehicleidlist=new ArrayList();
	ArrayList vehicleretrievelistlist=new ArrayList();
	ArrayList drivernamelist=new ArrayList();
	ArrayList typelist=new ArrayList();
	BusAllotmentVO vo=new BusAllotmentVO();
	BusAllotmentVO voo=new BusAllotmentVO();
	BusAllotmentVO vo1=new BusAllotmentVO();
	BusAllotmentVO vo2=new BusAllotmentVO();

	/**
	 * load the values of institution,driverid,district combo
	 *  
	 */
	public ActionForward defaultMethod(ActionMapping aMapping,
	        ActionForm aForm, HttpServletRequest aRequest,
	        HttpServletResponse aResponse)throws Exception{
			logger.debug("BusAllotmentAction:defaultMethod---------->");
			BusAllotmentForm form=(BusAllotmentForm)aForm;
			list=service.instcombo(vo);
			form.setInstList(list);
			list=service.driveridcombo(vo);
			form.setDriveridList(list);
	   		list=service.districtcombo(vo);
			form.setDistrictList(list);
			return aMapping.findForward("load");
	}
	
	/**
	 * retrieve vehicle id list from database
	 * @param aMapping
	 * @param aForm
	 * @param aRequest
	 * @param aResponse
	 * @return
	 * @throws Exception
	 */
	public ActionForward vehicleretrieveMethod(ActionMapping aMapping,
	        ActionForm aForm, HttpServletRequest aRequest,
	        HttpServletResponse aResponse)throws Exception{
		logger.debug("BusAllotmentAction:vehicleretrieveMethod---------->");
		BusAllotmentForm form=(BusAllotmentForm)aForm;
		list=service.vehicleretrieve(form.getVehicleType());
		form.setVehicleidList(list);
		
		typelist=service.vehicletyperetrieve(form.getInstituteName());
		form.setVehicletypeList(typelist);
		vo=(BusAllotmentVO)typelist.get(0);
		HttpSession session=aRequest.getSession();
		session.setAttribute("VEHICLE_TYPE",vo.getVehicletypedesc());
		if(session.getAttribute("VEHICLE_TYPE")=="Bus")
		{
			logger.debug("this is bus");
		}
		return aMapping.findForward("load");
	}
	
	/**
	 * retrieve driver name from database
	 * @param aMapping
	 * @param aForm
	 * @param aRequest
	 * @param aResponse
	 * @return
	 * @throws Exception
	 */
	public ActionForward nameretrieveMethod(ActionMapping aMapping,
	        ActionForm aForm, HttpServletRequest aRequest,
	        HttpServletResponse aResponse)throws Exception{
		logger.debug("BusAllotmentAction:nameretrieveMethod---------->");
		BusAllotmentForm form=(BusAllotmentForm)aForm;
		int id=Integer.parseInt(form.getDriverId());
		list=service.nameretrieve(id);
		for(int i=0;i<list.size();i++)
		{
			vo=(BusAllotmentVO)list.get(i);
		}
		form.setDriverName(vo.getDriverName());
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
	public ActionForward insertMethod(ActionMapping aMapping,
	        ActionForm aForm, HttpServletRequest aRequest,
	        HttpServletResponse aResponse)throws Exception{
		logger.debug("BusAllotmentAction:insertMethod---------->");
		BusAllotmentForm form=(BusAllotmentForm)aForm;
		String str=",";
		String str1;
		vo.setInstituteName(form.getInstituteName());
		vo.setVehicleType(form.getVehicleType());
		vo.setVehicleId(form.getVehicleId());
		int vehicleType=Integer.parseInt(form.getVehicleType());
		
		if(vehicleType==7)
		{
		vo.setDriverId(form.getDriverId());
		vo.setDriverName(form.getDriverName());
		vo.setVehicleAllottedDate(form.getVehicleAllottedDate());
		vo.setRouteNo(form.getRouteNo());
		vo.setKmTravelledPerDay(form.getKmTravelledPerDay());
		vo.setStartPlace(form.getStartPlace());
		vo.setVia(form.getVia());
		vo.setLastStop(form.getLastStop());
		vo.setHaltPlace(form.getHaltPlace());
		vo.setResidentialNo(form.getResidentialNo());
		vo.setOfficeNo(form.getOfficeNo());
		for(int i=0;i<form.getDistrictarray().length;i++)
		{
			str1=form.getDistrictarray()[i];
			str=str+str1+",";
		}
		String newstr=str.substring(1,str.length()-1);
		vo.setPermittedDistrict(newstr);
		service.insert(vo);
		}		
		else
		{
			vo.setDriverId(form.getDriverId());
			vo.setDriverName(form.getDriverName());
			vo.setVehicleAllottedDate(form.getVehicleAllottedDate());
			service.insertother(vo);
		}			
		return aMapping.findForward("load");
	}
	
	/**
	 * Update the values into database 
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
		logger.debug("BusAllotmentAction:updateMethod---------->");
		BusAllotmentForm form=(BusAllotmentForm)aForm;
		String str=",";
		String str1;
		vo.setInstituteName(form.getInstituteName());
		vo.setVehicleType(form.getVehicleType());
		vo.setVehicleId(form.getVehicleId());
		int vehicleType=Integer.parseInt(form.getVehicleType());
		
		if(vehicleType==7)
		{
		vo.setDriverId(form.getDriverId());
		vo.setDriverName(form.getDriverName());
		vo.setVehicleAllottedDate(form.getVehicleAllottedDate());
		vo.setRouteNo(form.getRouteNo());
		vo.setKmTravelledPerDay(form.getKmTravelledPerDay());
		vo.setStartPlace(form.getStartPlace());
		vo.setVia(form.getVia());
		vo.setLastStop(form.getLastStop());
		vo.setHaltPlace(form.getHaltPlace());
		vo.setResidentialNo(form.getResidentialNo());
		vo.setOfficeNo(form.getOfficeNo());
		for(int i=0;i<form.getDistrictarray().length;i++)
		{
			str1=form.getDistrictarray()[i];
			str=str+str1+",";
		}
		String newstr=str.substring(1,str.length()-1);
		vo.setPermittedDistrict(newstr);
		service.update(vo,form.getVehicleId());
		}		
		else
		{
			vo.setDriverId(form.getDriverId());
			vo.setDriverName(form.getDriverName());
			vo.setVehicleAllottedDate(form.getVehicleAllottedDate());
			service.updateother(vo,form.getVehicleId());
		}			
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
		logger.debug("BusAllotmentAction:clearformMethod---------->");
		BusAllotmentForm form=(BusAllotmentForm)aForm;
		form.setInstituteName(null);
		form.setVehicleId(null);
		form.setDriverId(null);
		form.setDriverName(null);
		form.setVehicleAllottedDate(null);
		form.setRouteNo(null);
		form.setKmTravelledPerDay(null);
		form.setStartPlace(null);
		form.setVia(null);
		form.setLastStop(null);
		form.setHaltPlace(null);
		form.setResidentialNo(null);
		form.setOfficeNo(null);
		form.setPermittedDistrict(null);
		form.setVehicleType(null);
		return aMapping.findForward("load");
	}
	
	/**
	 * update the delete indicator
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
			logger.debug("BusAllotmentAction:deleteindicatorMethod---------->");
			BusAllotmentForm form=(BusAllotmentForm)aForm;
			int id=Integer.parseInt(form.getDriverId());
			service.deleteind(id);
			return aMapping.findForward("load");
	}
	
	/**
	 * retrieve vehicletype from database
	 * @param aMapping
	 * @param aForm
	 * @param aRequest
	 * @param aResponse
	 * @return
	 * @throws Exception
	 */
	public ActionForward vehicletyperetrieveMethod(ActionMapping aMapping,
	        ActionForm aForm, HttpServletRequest aRequest,
	        HttpServletResponse aResponse)throws Exception{
			logger.debug("BusAllotmentAction:vehicletyperetrieveMethod---------->");
			BusAllotmentForm form=(BusAllotmentForm)aForm;
			list=service.vehicletyperetrieve(form.getInstituteName());
			form.setVehicletypeList(list);
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
	
	public ActionForward retrieveallMethod(ActionMapping aMapping,
	        ActionForm aForm, HttpServletRequest aRequest,
	        HttpServletResponse aResponse)throws Exception{
		logger.debug("BusAllotmentAction:retrieveallMethod---------->");
		BusAllotmentForm form=(BusAllotmentForm)aForm;
		list=service.retrieveall();
		int vehicleid=Integer.parseInt(form.getVehicleId());
		vehicleretrievelistlist=service.vehicleidretrieve(vehicleid);
		for(int i=0;i<vehicleretrievelistlist.size();i++)
		{
			vo1=(BusAllotmentVO)vehicleretrievelistlist.get(i);
		}
		
		for(int i=0;i<list.size();i++)
		{   
			vo=(BusAllotmentVO)list.get(i);
			if(vo.getVehicleiddesc().equals(vo1.getVehicleiddesc()))
			{
			   	String str2=form.getVehicleType();
				if(str2.equals("7"))
				{	
					int id=Integer.parseInt(form.getVehicleId());
					vehicleidlist=service.retrieve(id);
				
				for(int j=0;j<vehicleidlist.size();j++)
				{
					voo=(BusAllotmentVO)vehicleidlist.get(j);
				}
		
				int drivername=Integer.parseInt(voo.getDriverName());
				drivernamelist=service.drivernamedesc(drivername);
				for(int s=0;s<drivernamelist.size();s++)
				{
					vo2=(BusAllotmentVO)drivernamelist.get(s);
				}
				
				form.setDriverId(voo.getDriverId());
				form.setDriverName(vo2.getDrivernamedesc());
				form.setVehicleAllottedDate(voo.getVehicleAllottedDate());
				form.setRouteNo(voo.getRouteNo());
				form.setKmTravelledPerDay(voo.getKmTravelledPerDay());
				form.setStartPlace(voo.getStartPlace());
				form.setVia(voo.getVia());
				form.setLastStop(voo.getLastStop());
				form.setHaltPlace(voo.getHaltPlace());
				form.setResidentialNo(voo.getResidentialNo());
				form.setOfficeNo(voo.getOfficeNo()); 
				String dist=voo.getPermittedDistrict();
				logger.debug("dist:"+dist);
				String a[]; 
				a=dist.split(",");
				String districtvalue="";
				for(int k=0;k<a.length;k++)
				{
					logger.debug("district list values:"+a[k]);
					list=service.retrievedistrictvalues(a[k]);
					logger.debug("list size "+list.size());
					vo2=(BusAllotmentVO)list.get(0);
					logger.debug("value of district:"+vo2.getPermittedDistrict());
					districtvalue=districtvalue+vo2.getPermittedDistrict()+" ";
				}
				form.setPermittedDistrict(districtvalue);
				i=list.size()+1;
				}
				
				else
				{
				logger.debug("vehicle type is not bus");
				int id=Integer.parseInt(form.getVehicleId());
				vehicleidlist=service.retrieve(id);
			
			for(int j=0;j<vehicleidlist.size();j++)
			{
				voo=(BusAllotmentVO)vehicleidlist.get(j);
			}
	
			int drivername=Integer.parseInt(voo.getDriverName());
			drivernamelist=service.drivernamedesc(drivername);
			for(int s=0;s<drivernamelist.size();s++)
			{
				vo2=(BusAllotmentVO)drivernamelist.get(s);
			}
			
			form.setDriverId(voo.getDriverId());
			form.setDriverName(vo2.getDrivernamedesc());
			form.setVehicleAllottedDate(voo.getVehicleAllottedDate());
			
			logger.debug("vehicle date in voo"+voo.getVehicleAllottedDate());
			logger.debug("vehicle alloted date"+form.getVehicleAllottedDate());
							
			}
				
			}
			else
			{
				form.setVehicleAllottedDate(null);
				form.setRouteNo(null);
				form.setKmTravelledPerDay(null);
				form.setStartPlace(null);
				form.setVia(null);
				form.setLastStop(null);
				form.setHaltPlace(null);
				form.setResidentialNo(null);
				form.setOfficeNo(null);
			}
			}
		HttpSession session=((HttpServletRequest)aRequest).getSession();
		session.setAttribute("vehicleId", form.getVehicleId());
		String vid=(String)session.getAttribute("vehicleId");
		logger.debug("vehicle id in session"+vid);
			return aMapping.findForward("load");
	}
/*	public ActionForward retrieveallMethod(ActionMapping aMapping,
	        ActionForm aForm, HttpServletRequest aRequest,
	        HttpServletResponse aResponse)throws Exception{
		logger.debug("BusAllotmentAction:retrieveallMethod---------->");
		BusAllotmentForm form=(BusAllotmentForm)aForm;
		list=service.retrieveall();
		int vehicleid=Integer.parseInt(form.getVehicleId());
		vehicleretrievelistlist=service.vehicleidretrieve(vehicleid);
		for(int i=0;i<vehicleretrievelistlist.size();i++)
		{
			vo1=(BusAllotmentVO)vehicleretrievelistlist.get(i);
		}
		
		for(int i=0;i<list.size();i++)
		{   
			vo=(BusAllotmentVO)list.get(i);
			if(vo.getVehicleiddesc().equals(vo1.getVehicleiddesc()))
			{
			   	String str2=form.getVehicleType();
				if(str2.equals("7"))
				{	
					int id=Integer.parseInt(form.getVehicleId());
					vehicleidlist=service.retrieve(id);
				
				for(int j=0;j<vehicleidlist.size();j++)
				{
					voo=(BusAllotmentVO)vehicleidlist.get(j);
				}
		
				int drivername=Integer.parseInt(voo.getDriverName());
				drivernamelist=service.drivernamedesc(drivername);
				for(int s=0;s<drivernamelist.size();s++)
				{
					vo2=(BusAllotmentVO)drivernamelist.get(s);
				}
				
				form.setDriverId(voo.getDriverId());
				form.setDriverName(vo2.getDrivernamedesc());
				form.setVehicleAllottedDate(voo.getVehicleAllottedDate());
				form.setRouteNo(voo.getRouteNo());
				form.setKmTravelledPerDay(voo.getKmTravelledPerDay());
				form.setStartPlace(voo.getStartPlace());
				form.setVia(voo.getVia());
				form.setLastStop(voo.getLastStop());
				form.setHaltPlace(voo.getHaltPlace());
				form.setResidentialNo(voo.getResidentialNo());
				form.setOfficeNo(voo.getOfficeNo()); 
				i=list.size()+1;
				}				
				else
				{
				int id=Integer.parseInt(form.getVehicleId());
				vehicleidlist=service.retrieve(id);
			
			for(int j=0;j<vehicleidlist.size();j++)
			{
				voo=(BusAllotmentVO)vehicleidlist.get(j);
			}
	
			int drivername=Integer.parseInt(voo.getDriverName());
			drivernamelist=service.drivernamedesc(drivername);
			for(int s=0;s<drivernamelist.size();s++)
			{
				vo2=(BusAllotmentVO)drivernamelist.get(s);
			}
			
			form.setDriverId(voo.getDriverId());
			form.setDriverName(vo2.getDrivernamedesc());
			form.setVehicleAllottedDate(voo.getVehicleAllottedDate());
			}				
			}
			else
			{
				form.setVehicleAllottedDate(null);
				form.setRouteNo(null);
				form.setKmTravelledPerDay(null);
				form.setStartPlace(null);
				form.setVia(null);
				form.setLastStop(null);
				form.setHaltPlace(null);
				form.setResidentialNo(null);
				form.setOfficeNo(null);
			}
			}
		HttpSession session=((HttpServletRequest)aRequest).getSession();
		session.setAttribute("vehicleId", form.getVehicleId());
		String vid=(String)session.getAttribute("vehicleId");
		logger.debug("vehicle id in session"+vid);
		return aMapping.findForward("load");
	}*/
	
	
	
	
}
