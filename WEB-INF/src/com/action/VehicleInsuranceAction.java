package com.action;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import javax.servlet.http.HttpServletResponse;
import com.formbean.VehicleInsuranceForm;
import com.service.VehicleInsuranceService;
import com.action.BaseDispatchAction;
import java.util.ArrayList;
import com.vo.VehicleInsuranceVO;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class VehicleInsuranceAction  extends BaseDispatchAction{
	private static final Logger logger=(Logger)Logger.getLogger(VehicleInsuranceAction.class);
	
	ArrayList list=new ArrayList();
	ArrayList retrievelist=new ArrayList();
	ArrayList vehicleidlist=new ArrayList();
	VehicleInsuranceService service=new VehicleInsuranceService();
	VehicleInsuranceVO vo=new VehicleInsuranceVO();
	VehicleInsuranceVO vo1=new VehicleInsuranceVO();
	VehicleInsuranceVO voo=new VehicleInsuranceVO();
	
	/**
	 * load the values of institution combo
	 */
	public ActionForward defaultMethod(ActionMapping aMapping,
	        ActionForm aForm, HttpServletRequest aRequest,
	        HttpServletResponse aResponse)throws Exception{
		logger.debug("VehicleInsuranceAction:defaultMethod---------->");
		VehicleInsuranceForm form=(VehicleInsuranceForm)aForm;
		list=service.instcombo(vo);
		form.setInstList(list);
		return aMapping.findForward("load");
	}
	
	/**
	 * retrieve vehicletype 
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
		logger.debug("VehicleInsuranceAction:vehicletyperetrieveMethod---------->");
		VehicleInsuranceForm form=(VehicleInsuranceForm)aForm;
		String str=form.getInstituteName();
		list=service.vehicletype(str);
		form.setVehicletypeList(list);
		return aMapping.findForward("load");
	}
	
	/**
	 * retrieve vehicleid
	 * @param aMapping
	 * @param aForm
	 * @param aRequest
	 * @param aResponse
	 * @return
	 * @throws Exception
	 */
	public ActionForward vehicleidretrieveMethod(ActionMapping aMapping,
	        ActionForm aForm, HttpServletRequest aRequest,
	        HttpServletResponse aResponse)throws Exception{
		logger.debug("VehicleInsuranceAction:vehicleidretrieveMethod---------->");
		VehicleInsuranceForm form=(VehicleInsuranceForm)aForm;
		list=service.vehicleidretrieve(form.getVehicleType());
		form.setVehicleidList(list);
		return aMapping.findForward("load");
	}
	
	/**
	 * insert values into database
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
		logger.debug("VehicleInsuranceAction:insertMethod---------->");
		VehicleInsuranceForm form=(VehicleInsuranceForm)aForm;
		vo.setInstituteName(form.getInstituteName());
		vo.setVehicleId(form.getVehicleId());
		vo.setVehicleType(form.getVehicleType());
		vo.setVehicleModel(form.getVehicleModel());
		vo.setMarketValue(form.getMarketValue());
		vo.setInsuranceValidFrom(form.getInsuranceValidFrom());
		vo.setInsuranceValidTo(form.getInsuranceValidTo());
		vo.setExistInsuranceCmpyName(form.getExistInsuranceCmpyName());
		vo.setProposedInsuranceCmpyName(form.getProposedInsuranceCmpyName());
		vo.setExistVehicleValue(form.getProposedVehicleValue());
		vo.setProposedVehicleValue(form.getProposedVehicleValue());
		vo.setExistInsurancePremiumAmt(form.getExistInsurancePremiumAmt());
		vo.setProposedInsurancePremiumAmt(form.getProposedInsurancePremiumAmt());
		service.insert(vo);
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
		logger.debug("VehicleInsuranceAction:updateMethod---------->");
		VehicleInsuranceForm form=(VehicleInsuranceForm)aForm;
		
		vo.setInstituteName(form.getInstituteName());
		vo.setVehicleId(form.getVehicleId());
		vo.setVehicleType(form.getVehicleType());
		vo.setVehicleModel(form.getVehicleModel());
		vo.setMarketValue(form.getMarketValue());
		vo.setInsuranceValidFrom(form.getInsuranceValidFrom());
		vo.setInsuranceValidTo(form.getInsuranceValidTo());
		vo.setExistInsuranceCmpyName(form.getExistInsuranceCmpyName());
		vo.setProposedInsuranceCmpyName(form.getProposedInsuranceCmpyName());
		vo.setExistVehicleValue(form.getProposedVehicleValue());
		vo.setProposedVehicleValue(form.getProposedVehicleValue());
		vo.setExistInsurancePremiumAmt(form.getExistInsurancePremiumAmt());
		vo.setProposedInsurancePremiumAmt(form.getProposedInsurancePremiumAmt());
		service.update(vo,form.getVehicleId());
		return aMapping.findForward("load");
	}
	
	/**
	 * retrieve all values from database
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
		logger.debug("VehicleInsuranceAction:retrieveMethod---------->");
		VehicleInsuranceForm form=(VehicleInsuranceForm)aForm;
		
		list=service.retrieveall();
		int vehicleid=Integer.parseInt(form.getVehicleId());
		vehicleidlist=service.formvehicleid(vehicleid);
		for(int i=0;i<vehicleidlist.size();i++)
		{
			vo1=(VehicleInsuranceVO)vehicleidlist.get(i);
		}
			
		for(int i=0;i<list.size();i++)
		{   
			vo=(VehicleInsuranceVO)list.get(i);
			if(vo.getVehicleiddesc().equals(vo1.getVehicleiddesc()))
			{
				    int id=Integer.parseInt(form.getVehicleId());
					retrievelist=service.retrieve(id);
					for(int j=0;j<retrievelist.size();j++)
					{
						voo=(VehicleInsuranceVO)retrievelist.get(j);
					}
					form.setVehicleModel(voo.getVehicleModel());
					form.setMarketValue(voo.getMarketValue());
					form.setInsuranceValidFrom(voo.getInsuranceValidFrom());
					form.setInsuranceValidTo(voo.getInsuranceValidTo());
					form.setExistInsuranceCmpyName(voo.getExistInsuranceCmpyName());
					form.setExistVehicleValue(voo.getExistVehicleValue());
					form.setExistInsurancePremiumAmt(voo.getExistInsurancePremiumAmt());
					form.setProposedInsuranceCmpyName(voo.getProposedInsuranceCmpyName());
					form.setProposedVehicleValue(voo.getProposedVehicleValue());
					form.setProposedInsurancePremiumAmt(voo.getProposedInsurancePremiumAmt());
					i=list.size()+1;
			}
			   else
			   {
				   form.setVehicleModel(null);
				   form.setMarketValue(null);
				   form.setInsuranceValidFrom(null);
				   form.setInsuranceValidTo(null);
				   form.setExistInsuranceCmpyName(null);
				   form.setExistInsurancePremiumAmt(null);
				   form.setExistVehicleValue(null);
				   form.setProposedInsuranceCmpyName(null);
				   form.setProposedInsurancePremiumAmt(null);
				   form.setProposedVehicleValue(null);
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
		logger.debug("VehicleInsuranceAction:clearformMethod---------->");
		VehicleInsuranceForm form=(VehicleInsuranceForm)aForm;
	    form.setInstituteName(null);
	    form.setVehicleId(null);
	    form.setVehicleModel(null);
	    form.setMarketValue(null);
	    form.setVehicleType(null);
	    form.setInsuranceValidFrom(null);
	    form.setInsuranceValidTo(null);
	    form.setExistInsuranceCmpyName(null);
	    form.setExistVehicleValue(null);
	    form.setExistInsurancePremiumAmt(null);
	    form.setProposedInsuranceCmpyName(null);
	    form.setProposedVehicleValue(null);
	    form.setProposedInsurancePremiumAmt(null);
		return aMapping.findForward("load");
	}
}

