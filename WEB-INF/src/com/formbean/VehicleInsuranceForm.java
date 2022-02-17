package com.formbean;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.validator.ValidatorForm;

import com.action.VehicleInsuranceAction;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

public class VehicleInsuranceForm extends ValidatorForm{
	private static final Logger logger=(Logger)Logger.getLogger(VehicleInsuranceForm.class);
	
	private String vehicleModel=null;
	private String vehicleId=null;
	private String instituteName=null;
	private ArrayList instList=null;
	
	private String vehicleType=null;
	private ArrayList vehicletypeList=null;
	private String vehicleidcode=null;
	private String vehicleiddesc=null;
	private ArrayList vehicleidList=null;
	private String vehicletypecode=null;
	private String vehicletypedesc=null;
	
	private String insuranceValidFrom=null;
	private String insuranceValidTo=null;
	private String marketValue=null;
	
	private String existInsuranceCmpyName=null;
	private String existVehicleValue=null;
	private String existInsurancePremiumAmt=null;
	private String proposedInsuranceCmpyName=null;
	private String proposedVehicleValue=null;
	private String proposedInsurancePremiumAmt=null;
		
	
    public String getExistVehicleValue() {
		return existVehicleValue;
	}
	public void setExistVehicleValue(String existVehicleValue) {
		this.existVehicleValue = existVehicleValue;
	}

	public String getMarketValue() {
		return marketValue;
	}
	public void setMarketValue(String marketValue) {
		this.marketValue = marketValue;
	}
	public String getProposedVehicleValue() {
		return proposedVehicleValue;
	}
	public void setProposedVehicleValue(String proposedVehicleValue) {
		this.proposedVehicleValue = proposedVehicleValue;
	}
	
	public String getVehicleModel() {
		return vehicleModel;
	}
	public void setVehicleModel(String vehicleModel) {
		this.vehicleModel = vehicleModel;
	}
	
	public String getExistInsuranceCmpyName() {
		return existInsuranceCmpyName;
	}
	public void setExistInsuranceCmpyName(String existInsuranceCmpyName) {
		this.existInsuranceCmpyName = existInsuranceCmpyName;
	}
	public String getExistInsurancePremiumAmt() {
		return existInsurancePremiumAmt;
	}
	public void setExistInsurancePremiumAmt(String existInsurancePremiumAmt) {
		this.existInsurancePremiumAmt = existInsurancePremiumAmt;
	}
	public String getInsuranceValidFrom() {
		return insuranceValidFrom;
	}
	public void setInsuranceValidFrom(String insuranceValidFrom) {
		this.insuranceValidFrom = insuranceValidFrom;
	}
	public String getInsuranceValidTo() {
		return insuranceValidTo;
	}
	public void setInsuranceValidTo(String insuranceValidTo) {
		this.insuranceValidTo = insuranceValidTo;
	}
	public String getProposedInsuranceCmpyName() {
		return proposedInsuranceCmpyName;
	}
	public void setProposedInsuranceCmpyName(String proposedInsuranceCmpyName) {
		this.proposedInsuranceCmpyName = proposedInsuranceCmpyName;
	}
	public String getProposedInsurancePremiumAmt() {
		return proposedInsurancePremiumAmt;
	}
	public void setProposedInsurancePremiumAmt(String proposedInsurancePremiumAmt) {
		this.proposedInsurancePremiumAmt = proposedInsurancePremiumAmt;
	}

	public ArrayList getInstList() {
		return instList;
	}
	public void setInstList(ArrayList instList) {
		this.instList = instList;
	}
	public String getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	public String getInstituteName() {
		return instituteName;
	}
	public void setInstituteName(String instituteName) {
		this.instituteName = instituteName;
	}
	public String getVehicleidcode() {
		return vehicleidcode;
	}
	public void setVehicleidcode(String vehicleidcode) {
		this.vehicleidcode = vehicleidcode;
	}
	public String getVehicleiddesc() {
		return vehicleiddesc;
	}
	public void setVehicleiddesc(String vehicleiddesc) {
		this.vehicleiddesc = vehicleiddesc;
	}
	
	public ArrayList getVehicleidList() {
		return vehicleidList;
	}
	public void setVehicleidList(ArrayList vehicleidList) {
		this.vehicleidList = vehicleidList;
	}
	public String getVehicletypecode() {
		return vehicletypecode;
	}
	public void setVehicletypecode(String vehicletypecode) {
		this.vehicletypecode = vehicletypecode;
	}
	public String getVehicletypedesc() {
		return vehicletypedesc;
	}
	public void setVehicletypedesc(String vehicletypedesc) {
		this.vehicletypedesc = vehicletypedesc;
	}
	public ArrayList getVehicletypeList() {
		return vehicletypeList;
	}
	public void setVehicletypeList(ArrayList vehicletypeList) {
		this.vehicletypeList = vehicletypeList;
	}
	
	public ActionErrors validate(ActionMapping mapping, 
			HttpServletRequest request) 
			{ 
			 //Perform validator framework validations 
			ActionErrors errors = new ActionErrors(); 
			 //Only need crossfield validations here 
					
			if(StringUtils.isEmpty(vehicleModel))
			 {
				 errors.add(ActionErrors.GLOBAL_MESSAGE,new ActionMessage("error.vehicleModel.required"));
			 }
			else if(!(StringUtils.isAlphanumeric(vehicleModel)))
			 {
				 errors.add(ActionErrors.GLOBAL_MESSAGE,new ActionMessage("error.vehicleModel"));
			 }
			
			if(StringUtils.isEmpty(marketValue))
			 {
				 errors.add(ActionErrors.GLOBAL_MESSAGE,new ActionMessage("error.marketValue.required"));
			 }
			else if(!(StringUtils.isAlphanumeric(marketValue)))
			 {
				 errors.add(ActionErrors.GLOBAL_MESSAGE,new ActionMessage("error.marketValue"));
			 }
			
			if(StringUtils.isEmpty(insuranceValidFrom))
			 {
				 errors.add(ActionErrors.GLOBAL_MESSAGE,new ActionMessage("error.insuranceValidFrom.required"));
			 }
			
			if(StringUtils.isEmpty(insuranceValidTo))
			 {
				 errors.add(ActionErrors.GLOBAL_MESSAGE,new ActionMessage("error.insuranceValidTo.required"));
			 }
						
			if(StringUtils.isEmpty(existInsuranceCmpyName))
			 {
				 errors.add(ActionErrors.GLOBAL_MESSAGE,new ActionMessage("error.existInsuranceCmpyName.required"));
			 }
			else if(!(StringUtils.isAlpha(existInsuranceCmpyName)))
			 {
				 errors.add(ActionErrors.GLOBAL_MESSAGE,new ActionMessage("error.existInsuranceCmpyName"));
			 }
			
			if(StringUtils.isEmpty(proposedInsuranceCmpyName))
			 {
				 errors.add(ActionErrors.GLOBAL_MESSAGE,new ActionMessage("error.proposedInsuranceCmpyName.required"));
			 }
			else if(!(StringUtils.isAlpha(proposedInsuranceCmpyName)))
			 {
				 errors.add(ActionErrors.GLOBAL_MESSAGE,new ActionMessage("error.proposedInsuranceCmpyName"));
			 }
			
			if(StringUtils.isEmpty(existVehicleValue))
			 {
				 errors.add(ActionErrors.GLOBAL_MESSAGE,new ActionMessage("error.existVehicleValue.required"));
			 }
			else if(!(StringUtils.isAlphanumeric(existVehicleValue)))
			 {
				 errors.add(ActionErrors.GLOBAL_MESSAGE,new ActionMessage("error.existVehicleValue"));
			 }
			
			if(StringUtils.isEmpty(proposedVehicleValue))
			 {
				 errors.add(ActionErrors.GLOBAL_MESSAGE,new ActionMessage("error.proposedVehicleValue.required"));
			 }
			else if(!(StringUtils.isAlphanumeric(proposedVehicleValue)))
			 {
				 errors.add(ActionErrors.GLOBAL_MESSAGE,new ActionMessage("error.proposedVehicleValue"));
			 }
			
			if(StringUtils.isEmpty(existInsurancePremiumAmt))
			 {
				 errors.add(ActionErrors.GLOBAL_MESSAGE,new ActionMessage("error.existInsurancePremiumAmt.required"));
			 }
			else if(!(StringUtils.isAlphanumeric(existInsurancePremiumAmt)))
			 {
				 errors.add(ActionErrors.GLOBAL_MESSAGE,new ActionMessage("error.existInsurancePremiumAmt"));
			 }
			
			if(StringUtils.isEmpty(proposedInsurancePremiumAmt))
			 {
				 errors.add(ActionErrors.GLOBAL_MESSAGE,new ActionMessage("error.proposedInsurancePremiumAmt.required"));
			 }
			else if(!(StringUtils.isAlphanumeric(proposedInsurancePremiumAmt)))
			 {
				 errors.add(ActionErrors.GLOBAL_MESSAGE,new ActionMessage("error.proposedInsurancePremiumAmt"));
			 }
			
			return errors;
			}

}
