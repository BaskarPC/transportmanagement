package com.formbean;
import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.validator.ValidatorForm;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

public class DriverPolicyForm extends ValidatorForm{
	
	private String driverId=null;
	private String driverName=null;
	private String  policyNo=null;
	private String policyName=null;
	private String coverage=null;
	private String premiumAmt=null;
	private String insuranceCmpyAddress=null;
	private String validFrom=null;
	private String validTo=null;
	private String tieUp=null;
	private String compensationAmt=null;
	private String hospitalExpenses=null;
	private String buffer=null;
	private String constraints=null;
	private ArrayList idList=null;

	
	
	
	public String getBuffer() {
		return buffer;
	}
	public void setBuffer(String buffer) {
		this.buffer = buffer;
	}
	public String getCompensationAmt() {
		return compensationAmt;
	}
	public void setCompensationAmt(String compensationAmt) {
		this.compensationAmt = compensationAmt;
	}
	public String getConstraints() {
		return constraints;
	}
	public void setConstraints(String constraints) {
		this.constraints = constraints;
	}
	public String getCoverage() {
		return coverage;
	}
	public void setCoverage(String coverage) {
		this.coverage = coverage;
	}
	
	public String getHospitalExpenses() {
		return hospitalExpenses;
	}
	public void setHospitalExpenses(String hospitalExpenses) {
		this.hospitalExpenses = hospitalExpenses;
	}
	public String getPolicyName() {
		return policyName;
	}
	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}
	public String getPolicyNo() {
		return policyNo;
	}
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}
	public String getPremiumAmt() {
		return premiumAmt;
	}
	public void setPremiumAmt(String premiumAmt) {
		this.premiumAmt = premiumAmt;
	}
	public String getTieUp() {
		return tieUp;
	}
	public void setTieUp(String tieUp) {
		this.tieUp = tieUp;
	}
	public String getValidFrom() {
		return validFrom;
	}
	public void setValidFrom(String validFrom) {
		this.validFrom = validFrom;
	}
	public String getValidTo() {
		return validTo;
	}
	public void setValidTo(String validTo) {
		this.validTo = validTo;
	}
	public String getInsuranceCmpyAddress() {
		return insuranceCmpyAddress;
	}
	public void setInsuranceCmpyAddress(String insuranceCmpyAddress) {
		this.insuranceCmpyAddress = insuranceCmpyAddress;
	}
	/**
	 * @return the driverId
	 */
	public String getDriverId() {
		return driverId;
	}
	/**
	 * @param driverId the driverId to set
	 */
	public void setDriverId(String driverId) {
		this.driverId = driverId;
	}
	/**
	 * @return the driverName
	 */
	public String getDriverName() {
		return driverName;
	}
	/**
	 * @param driverName the driverName to set
	 */
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	/**
	 * @return the idList
	 */
	public ArrayList getIdList() {
		return idList;
	}
	/**
	 * @param idList the idList to set
	 */
	public void setIdList(ArrayList idList) {
		this.idList = idList;
	}

	/**
	 * validating fields
	 */
	public ActionErrors validate(ActionMapping mapping, 
			HttpServletRequest request) 
			{ 
//			 Perform validator framework validations 
			ActionErrors errors = new ActionErrors(); 
//			 Only need crossfield validations here 
			if(StringUtils.isEmpty(policyNo))
			 {
				 errors.add(ActionErrors.GLOBAL_MESSAGE,new ActionMessage("error.policyNo.required"));
			 }
			if(StringUtils.isEmpty(policyName))
			{
			errors.add(ActionErrors.GLOBAL_MESSAGE,new ActionMessage("error.policyName.required"));
			}
		    if(StringUtils.isEmpty(coverage))
			 {
				 errors.add(ActionErrors.GLOBAL_MESSAGE,new ActionMessage("error.coverage.required")); 
			 }
			if(StringUtils.isEmpty(premiumAmt))
			{
					errors.add(ActionErrors.GLOBAL_MESSAGE,new ActionMessage("error.premiumAmt.required"));
			}
			else if(StringUtils.isAlpha(premiumAmt))
			 {
				 errors.add(ActionErrors.GLOBAL_MESSAGE,new ActionMessage("error.premiumAmt")); 
			 }
			if(StringUtils.isEmpty(insuranceCmpyAddress))
			{
					errors.add(ActionErrors.GLOBAL_MESSAGE,new ActionMessage("error.insuranceCmpyAddress.required"));
			}
			if(StringUtils.isEmpty(tieUp))
			{
				errors.add(ActionErrors.GLOBAL_MESSAGE,new ActionMessage("error.tieUp.required"));
			}	  
			if(StringUtils.isEmpty(validFrom))
			{
					errors.add(ActionErrors.GLOBAL_MESSAGE,new ActionMessage("error.validFrom.required"));
			}
			if(StringUtils.isEmpty(validTo))
			{
				errors.add(ActionErrors.GLOBAL_MESSAGE,new ActionMessage("error.validTo.required"));
			}	  
			if(StringUtils.isEmpty(compensationAmt))
			{
				errors.add(ActionErrors.GLOBAL_MESSAGE,new ActionMessage("error.compensationAmt.required"));
			}
			else if(StringUtils.isAlpha(compensationAmt))
			 {
				 errors.add(ActionErrors.GLOBAL_MESSAGE,new ActionMessage("error.compensationAmt")); 
			 }
			if(StringUtils.isEmpty(hospitalExpenses))
			{
				errors.add(ActionErrors.GLOBAL_MESSAGE,new ActionMessage("error.hospitalExpenses.required"));
			}
			else if(StringUtils.isAlpha(hospitalExpenses))
			 {
				 errors.add(ActionErrors.GLOBAL_MESSAGE,new ActionMessage(" error.hospitalExpenses")); 
			 }
			if(StringUtils.isEmpty(buffer))
			{
				errors.add(ActionErrors.GLOBAL_MESSAGE,new ActionMessage("error.buffer.required"));
			}
			else if(StringUtils.isAlpha(buffer))
			 {
				 errors.add(ActionErrors.GLOBAL_MESSAGE,new ActionMessage("error.buffer")); 
			 }
			if(StringUtils.isEmpty(constraints))
			{
				errors.add(ActionErrors.GLOBAL_MESSAGE,new ActionMessage("error.constraints.required"));
			}
			
			return errors; 
			}
}
