package com.action;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.log4j.Logger;
import javax.servlet.http.HttpServletResponse;
import com.formbean.RoadTaxForm;
import com.service.RoadTaxService;
import com.action.BaseDispatchAction;
import java.util.ArrayList;
import com.vo.RoadTaxVO;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


public class RoadTaxAction  extends BaseDispatchAction{
	private static final Logger logger=(Logger)Logger.getLogger(RoadTaxAction.class);
	
     RoadTaxService service=new RoadTaxService();
     RoadTaxVO vo=new RoadTaxVO();
     RoadTaxVO voo=new RoadTaxVO();
     RoadTaxVO vo1=new RoadTaxVO();
     ArrayList list=new ArrayList();
     ArrayList idlist=new ArrayList();
     ArrayList typelist=new ArrayList();
     ArrayList periodlist=new ArrayList();
     ArrayList optionlist=new ArrayList();
     ArrayList vehicleidlist=new ArrayList();
     ArrayList formvehiclelist=new ArrayList();
	
     /*
	 * load institution,period and option combo
	 */
	public ActionForward defaultMethod(ActionMapping aMapping,
	        ActionForm aForm, HttpServletRequest aRequest,
	        HttpServletResponse aResponse)throws Exception{
		 RoadTaxForm form=(RoadTaxForm)aForm;
		logger.debug("RoadTaxAction:defaultMethod---------->");
		list=service.instcombo(vo);
		form.setInstList(list);
		periodlist=service.periodcombo(vo);
		form.setPeriodList(periodlist);
	    optionlist=service.optioncombo(vo);
	    form.setOptionList(optionlist);
		return aMapping.findForward("load");
	}
	/**
	 * retrieve vehicle type from database
	 * @param aMapping
	 * @param aForm
	 * @param aRequest
	 * @param aResponse
	 * @return
	 * @throws Exception
	 */
	public ActionForward choosevehicletypeMethod(ActionMapping aMapping,
	        ActionForm aForm, HttpServletRequest aRequest,
	        HttpServletResponse aResponse)throws Exception{
		 RoadTaxForm form=(RoadTaxForm)aForm;
		logger.debug("RoadTaxAction:retrievetypecomboMethod---------->");
		typelist=service.vehicletypecombo(form.getInstituteName());
		form.setVehicletypeList(typelist);
		return aMapping.findForward("load");
	}
	
	/**
	 * retrieve vehicle ID from database
	 * @param aMapping
	 * @param aForm
	 * @param aRequest
	 * @param aResponse
	 * @return
	 * @throws Exception
	 */
	public ActionForward choosevehicleidMethod(ActionMapping aMapping,
	        ActionForm aForm, HttpServletRequest aRequest,
	        HttpServletResponse aResponse)throws Exception{
		
		 RoadTaxForm form=(RoadTaxForm)aForm;
		logger.debug("RoadTaxAction:choosevehicleidMethod---------->");
		idlist=service.vehicleidcombo(form.getVehicleType(),form.getInstituteName());
		form.setVehicleidList(idlist);
		return aMapping.findForward("load");
	}
	/**
	 * Method to calculate tax amount
	 * @param aMapping
	 * @param aForm
	 * @param aRequest
	 * @param aResponse
	 * @return
	 * @throws Exception
	 */
	public ActionForward taxamtcalcMethod(ActionMapping aMapping,
	        ActionForm aForm, HttpServletRequest aRequest,
	        HttpServletResponse aResponse)throws Exception{
		 RoadTaxForm form=(RoadTaxForm)aForm;
		logger.debug("RoadTaxAction:taxamtcalcMethod---------->");
		int noofseats=Integer.parseInt(form.getSeatCapacity());
		int rateperseat=Integer.parseInt(form.getRatePerSeat());
		form.setTaxAmt(Integer.toString(noofseats*rateperseat));
		return aMapping.findForward("load");
	}
	/**
	 * Method to calculate reduction amount
	 * @param aMapping
	 * @param aForm
	 * @param aRequest
	 * @param aResponse
	 * @return
	 * @throws Exception
	 */
	public ActionForward reductionamtcalcMethod(ActionMapping aMapping,
	        ActionForm aForm, HttpServletRequest aRequest,
	        HttpServletResponse aResponse)throws Exception{
		 RoadTaxForm form=(RoadTaxForm)aForm;
		logger.debug("RoadTaxAction:taxamtcalcMethod---------->");
		float perofreduction=Float.parseFloat(form.getPercentOfReduction());
		int taxamt=Integer.parseInt(form.getTaxAmt());
		form.setReductionAmt(Float.toString((perofreduction/100)*taxamt));
		float reductionamt=Float.parseFloat(form.getReductionAmt());
		form.setTotalAmtAfterReduction(Float.toString(taxamt-reductionamt));
		return aMapping.findForward("load");
	}
	/**
	 * method to calculatesub-charge tax amount
	 * @param aMapping
	 * @param aForm
	 * @param aRequest
	 * @param aResponse
	 * @return
	 * @throws Exception
	 */
	public ActionForward subtaxamtcalcMethod(ActionMapping aMapping,
	        ActionForm aForm, HttpServletRequest aRequest,
	        HttpServletResponse aResponse)throws Exception{
		 RoadTaxForm form=(RoadTaxForm)aForm;
		logger.debug("RoadTaxAction:subtaxamtcalcMethod---------->");
		float perofsubcharge=Float.parseFloat(form.getSubTaxPercent());
		float totreductionamt=Float.parseFloat(form.getTotalAmtAfterReduction());
		form.setSubTaxAmt(Float.toString(totreductionamt*(perofsubcharge/100)));
		float subtaxamt=Float.parseFloat(form.getSubTaxAmt());
		int taxamt=Integer.parseInt(form.getTaxAmt());
		form.setGrandTotal(Float.toString(taxamt+subtaxamt));
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
		 RoadTaxForm form=(RoadTaxForm)aForm;
		logger.debug("RoadTaxAction:saveMethod---------->");
		 form.getInstituteName();
	     form.getVehicleType();
	     form.getVehicleId();
	     form.getSeatCapacity();
	     form.getRatePerSeat();
	     form.getTaxAmt();
	     form.getRoadTaxPeriod();
	     form.getYesNoOption();
	     form.getPercentOfReduction();
	     form.getReductionAmt();
	     form.getTotalAmtAfterReduction();
	     form.getSubTaxPercent();
	     form.getSubTaxAmt();
	     form.getGrandTotal();
	     PropertyUtils.copyProperties(vo,form);
	    service.saveintodb(vo);
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
		logger.debug("RoadTaxAction:updateMethod---------->");
		 RoadTaxForm form=(RoadTaxForm)aForm;		 
		 form.getInstituteName();
	     form.getVehicleType();
	     form.getVehicleId();
	     form.getSeatCapacity();
	     form.getRatePerSeat();
	     form.getTaxAmt();
	     form.getRoadTaxPeriod();
	     form.getYesNoOption();
	     form.getPercentOfReduction();
	     form.getReductionAmt();
	     form.getTotalAmtAfterReduction();
	     form.getSubTaxPercent();
	     form.getSubTaxAmt();
	     form.getGrandTotal();
	     PropertyUtils.copyProperties(vo,form);
	     service.update(vo,form.getVehicleId());
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
	        HttpServletResponse aResponse)throws Exception{
		
		 RoadTaxForm form=(RoadTaxForm)aForm;
		logger.debug("RoadTaxAction:retrieveMethod---------->");
		
		int id=Integer.parseInt(form.getVehicleId());
		vehicleidlist=service.vehicleidretrieve();
		formvehiclelist=service.formvehicleid(id);
		
		for(int i=0;i<formvehiclelist.size();i++)
		{
			vo1=(RoadTaxVO)formvehiclelist.get(i);
		}
		for(int j=0;j<vehicleidlist.size();j++)
		{
			voo=(RoadTaxVO)vehicleidlist.get(j);
		if(voo.getVehicleiddesc().equals(vo1.getVehicleiddesc()))
		{
		   list=service.retrieve(id);
		   for(int i=0;i<list.size();i++)
		   {
		   vo=(RoadTaxVO)list.get(i);
		   
		   }
		    form.setSeatCapacity(vo.getSeatCapacity());
	        form.setRatePerSeat(vo.getRatePerSeat());
	        form.setTaxAmt(vo.getTaxAmt());
	        form.setRoadTaxPeriod(vo.getRoadTaxPeriod());
	        form.setYesNoOption(vo.getYesNoOption());
	        form.setPercentOfReduction(vo.getPercentOfReduction());
	        form.setReductionAmt(vo.getReductionAmt());
	        form.setTotalAmtAfterReduction(vo.getTotalAmtAfterReduction());
	        form.setSubTaxPercent(vo.getSubTaxPercent());
	        form.setSubTaxAmt(vo.getSubTaxAmt());
	        form.setGrandTotal(vo.getGrandTotal());
	        j=vehicleidlist.size()+1;
		}
		else
		{
			form.setSeatCapacity(null);
			form.setRatePerSeat(null);
			form.setTaxAmt(null);
			form.setRoadTaxPeriod(null);
			form.setYesNoOption(null);
			form.setPercentOfReduction(null);
			form.setReductionAmt(null);
			form.setTotalAmtAfterReduction(null);
			form.setSubTaxPercent(null);
			form.setSubTaxAmt(null);
			form.setGrandTotal(null);
		}
		
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
		
		 RoadTaxForm form=(RoadTaxForm)aForm;
		logger.debug("RoadTaxAction:clearformMethod---------->");
		 form.setInstituteName(null);
	     form.setVehicleType(null);
	     form.setVehicleId(null);
	     form.setSeatCapacity(null);
	     form.setRatePerSeat(null);
	     form.setTaxAmt(null);
	     form.setRoadTaxPeriod(null);
	     form.setYesNoOption(null);
	     form.setPercentOfReduction(null);
	     form.setReductionAmt(null);
	     form.setTotalAmtAfterReduction(null);
	     form.setSubTaxPercent(null);
	     form.setSubTaxAmt(null);
	     form.setGrandTotal(null);
	   	 return aMapping.findForward("load");
	}
}
	
	