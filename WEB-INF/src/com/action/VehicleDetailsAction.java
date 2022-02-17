package com.action;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import com.vo.VehicleVo;
import com.service.VehicleService;
import com.action.BaseDispatchAction;
import java.util.ArrayList;
import com.formbean.VehicleDetailsForm;
import com.formbean.VehicleInsuranceForm;
import com.formbean.RoadTaxForm;
import com.formbean.BusAllotmentForm;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


/**
 * 
 * 
 *
 */
public class VehicleDetailsAction  extends BaseDispatchAction{
	private static final Logger logger=(Logger)Logger.getLogger(VehicleDetailsAction.class);
	VehicleVo  vo=new VehicleVo();
	VehicleVo  voo=new VehicleVo();
	VehicleVo  vo2=new VehicleVo();
    VehicleService service=new VehicleService();
    ArrayList list=new ArrayList();
    ArrayList list1=new ArrayList();
    ArrayList roadtaxlist=new ArrayList();
    ArrayList instlist=new ArrayList();
    ArrayList insurancelist=new ArrayList();
	
    /**Default method to load combo values
	 * 
	 */
	public ActionForward defaultMethod(ActionMapping aMapping,
	        ActionForm aForm, HttpServletRequest aRequest,
	        HttpServletResponse aResponse)throws Exception
	        {
	    	 logger.debug("VehicleDetailsAction:defaultMethod---------->");
	    	 VehicleDetailsForm form=(VehicleDetailsForm)aForm;	 		
	 		list=service.vehicletypecombo();		
	 		form.setVehicleList(list);	
	 		list1=service.combvstatus(vo);
			form.setVehiclestatusList(list1);			
			roadtaxlist=service.comboroadtax(vo);
			form.setYesNoOptionList(roadtaxlist);			
			instlist=service.comboInstitution();
	 		form.setInstituteNameList(instlist);	 		
	 		insurancelist=service.insurancecombo();
	 		form.setInsuranceOptionList(insurancelist);
	 		return aMapping.findForward("load");
		 }
	
	/**
	 * Values are stored into database
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
		VehicleDetailsForm  form=(VehicleDetailsForm)aForm;
		
		vo.setDateOfPurchase(form.getDateOfPurchase());
		vo.setManufacturingDate(form.getManufacturingDate());
		vo.setInstituteName(form.getInstituteName());
		vo.setVehicleId(form.getVehicleId());
		vo.setPrice(form.getPrice());
		vo.setSupplierName(form.getSupplierName());
		vo.setVehicleType(form.getVehicleType());
		vo.setMake(form.getMake());
		vo.setChassisNo(form.getChassisNo());
		vo.setEngineNo(form.getEngineNo());
		vo.setBodyType(form.getBodyType());
		vo.setTankCapacity(form.getTankCapacity());
		vo.setSeatCapacity(form.getSeatCapacity());
		vo.setWheelBase(form.getWheelBase());
		vo.setVehicleStatus(form.getVehicleStatus());
		vo.setRoadyesNoOption(form.getRoadyesNoOption());
		vo.setRoadTaxFrom(form.getRoadTaxFrom());
		vo.setRoadTaxTo(form.getRoadTaxTo());
		vo.setInsuranceOption(form.getInsuranceOption());
		vo.setInsuranceFrom(form.getInsuranceTo());
		vo.setInsuranceTo(form.getInsuranceTo());
		vo.setInsuranceCmpyName(form.getInsuranceCmpyName());
		vo.setFcExpiryDate(form.getFcExpiryDate());
		vo.setValidPermitDate(form.getValidPermitDate());
		service.save(vo);
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
	        HttpServletResponse aResponse)throws Exception
	        {
		logger.debug("VehicleDetailsAction: updateMethod<-------------");	
		VehicleDetailsForm  form=(VehicleDetailsForm)aForm;
		
		vo.setDateOfPurchase(form.getDateOfPurchase());
		vo.setManufacturingDate(form.getManufacturingDate());
		vo.setInstituteName(form.getInstituteName());
	//	vo.setVehicleId(form.getVehicleId());
		vo.setPrice(form.getPrice());
		vo.setSupplierName(form.getSupplierName());
		vo.setVehicleType(form.getVehicleType());
		vo.setMake(form.getMake());
		vo.setChassisNo(form.getChassisNo());
		vo.setEngineNo(form.getEngineNo());
		vo.setBodyType(form.getBodyType());
		vo.setTankCapacity(form.getTankCapacity());
		vo.setSeatCapacity(form.getSeatCapacity());
		vo.setWheelBase(form.getWheelBase());
		vo.setVehicleStatus(form.getVehicleStatus());
		vo.setRoadyesNoOption(form.getRoadyesNoOption());
		vo.setRoadTaxFrom(form.getRoadTaxFrom());
		vo.setRoadTaxTo(form.getRoadTaxTo());
		vo.setInsuranceOption(form.getInsuranceOption());
		vo.setInsuranceFrom(form.getInsuranceTo());
		vo.setInsuranceTo(form.getInsuranceTo());
		vo.setInsuranceCmpyName(form.getInsuranceCmpyName());
		vo.setFcExpiryDate(form.getFcExpiryDate());
		vo.setValidPermitDate(form.getValidPermitDate());	
		service.update(vo,form.getVehicleId());		
		return aMapping.findForward("load");
	}	  	
	
	/**
	 * Retrieve all the vehicleid from database and compare it with form vehicleid, 
	 * if both are equal then retrieve the values,otherwise save that new entry 
	 * @param aMapping
	 * @param aForm
	 * @param aRequest
	 * @param aResponse
	 * @return
	 * @throws Exception
	 */
		public ActionForward retrieveidMethod(ActionMapping aMapping,
		        ActionForm aForm, HttpServletRequest aRequest,
		        HttpServletResponse aResponse)throws Exception{
			logger.debug("VehicleDetailsAction:retrieveallMethod---------->");
			VehicleDetailsForm form=(VehicleDetailsForm)aForm;
			ArrayList retrievelist =new ArrayList();
			ArrayList idcodelist =new ArrayList();
			VehicleVo idcodevo =new VehicleVo();
			
			list=service.retrieveall();
			for(int i=0;i<list.size();i++)
			{
				vo=(VehicleVo)list.get(i);				
			}
		
		    idcodelist =service.convert(form.getVehicleId());
			idcodevo=(VehicleVo)idcodelist.get(0);
			
			int id=Integer.parseInt(idcodevo.getVehicleidcode());
			retrievelist=service.retrieve(id);
		   	for(int i=0;i<retrievelist.size();i++)
			{
				voo=(VehicleVo)retrievelist.get(i);
			}
			
			for(int i=0;i<list.size();i++)
			{
				if(form.getVehicleId().equals(vo.getVehicleiddesc()))
			{
				form.setDateOfPurchase(voo.getDateOfPurchase());
				form.setManufacturingDate(voo.getManufacturingDate());
				form.setInstituteName(voo.getInstituteName());
				form.setPrice(voo.getPrice());
				form.setSupplierName(voo.getSupplierName());
				form.setVehicleType(voo.getVehicleType());
				form.setMake(voo.getMake());
				form.setChassisNo(voo.getChassisNo());
				form.setEngineNo(voo.getEngineNo());
				form.setBodyType(voo.getBodyType());
				form.setTankCapacity(voo.getTankCapacity());
				form.setSeatCapacity(voo.getSeatCapacity());
				form.setWheelBase(voo.getWheelBase());
				form.setVehicleStatus(voo.getVehicleStatus());
				form.setRoadyesNoOption(voo.getRoadyesNoOption());
				form.setRoadTaxFrom(voo.getRoadTaxFrom());
				form.setRoadTaxTo(voo.getRoadTaxTo());
				form.setInsuranceOption(voo.getInsuranceOption());
				form.setInsuranceFrom(voo.getInsuranceFrom());
				form.setInsuranceTo(voo.getInsuranceTo());
				form.setInsuranceCmpyName(voo.getInsuranceCmpyName());
				form.setFcExpiryDate(voo.getFcExpiryDate());
				form.setValidPermitDate(voo.getValidPermitDate());
				i=list.size()+1;
										
			}
			else
			{
				form.setDateOfPurchase(null);
				form.setManufacturingDate(null);
				form.setInstituteName(null);
				form.setPrice(null);
				form.setSupplierName(null);
				form.setVehicleType(null);
				form.setMake(null);
				form.setChassisNo(null);
				form.setEngineNo(null);
				form.setBodyType(null);
				form.setTankCapacity(null);
				form.setSeatCapacity(null);
				form.setWheelBase(null);
				form.setVehicleStatus(null);
				form.setRoadyesNoOption(null);
				form.setRoadTaxFrom(null);
				form.setRoadTaxTo(null);
				form.setInsuranceOption(null);
				form.setInsuranceFrom(null);
				form.setInsuranceTo(null);
				form.setInsuranceCmpyName(null);
				form.setFcExpiryDate(null);
				form.setValidPermitDate(null);
			}				
		}	
			HttpSession session=((HttpServletRequest)aRequest).getSession();
			session.setAttribute("vehicleId", form.getVehicleId());
			String vid=(String)session.getAttribute("vehicleId");
			logger.debug("vehicle id in session"+vid);
			return aMapping.findForward("load");		
	}
		
		/**
		 *  To change the deleteindicator field in database logically
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
		logger.debug("VehiclePurchase delete method-------------");
		VehicleDetailsForm form=(VehicleDetailsForm)aForm;
			
		String str=form.getVehicleId();
		list=service.vehicledel(str);

		return aMapping.findForward("load");
}

	/**
	 * TO insert a new institution to lookup table
	 * @param aMapping
	 * @param aForm
	 * @param aRequest
	 * @param aResponse
	 * @return
	 * @throws Exception
	 */
	public ActionForward insertinstMethod(ActionMapping aMapping,
	        ActionForm aForm, HttpServletRequest aRequest,
	        HttpServletResponse aResponse)throws Exception{
		logger.debug("VehiclePurchase insertinstMethod -------------");
		VehicleDetailsForm form=(VehicleDetailsForm)aForm;
		String ins=form.getOthersInsitution();
		service.lookupinsertins(ins);
		return aMapping.findForward("load");
}

	/**
	 *  To insert a new vehicleType in Lookup table
	 * @param aMapping
	 * @param aForm
	 * @param aRequest
	 * @param aResponse
	 * @return
	 * @throws Exception
	 */public ActionForward Lookupinsertvtype(ActionMapping aMapping,
	        ActionForm aForm, HttpServletRequest aRequest,
	        HttpServletResponse aResponse)throws Exception{
		logger.debug("VehiclePurchase lookupinsertvtype method-------------");
		VehicleDetailsForm form=(VehicleDetailsForm)aForm;
		String vtype=form.getOthers();
		service.lookupinsertvType(vtype);
		return aMapping.findForward("load");
}		
}

		
	
    
