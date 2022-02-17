package com.formbean;


import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.validator.ValidatorForm;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.action.WasteAction;
public class WasteForm extends GeneralForm{
	private static final Logger logger=(Logger)Logger.getLogger(WasteForm.class);
	private ArrayList reasonList;
	private String totalAvailableQuantity;
	private String wasteReason;
	private String requiredQuantity;
	private String currentKm;
	private String oldAvailable;
	private String newAvailable;
	private String oldRate;
	private String newRate;
	
	private String totalAmount;
	private String remainingQuantity;
	/**
	 * @return the currentKm
	 */
	public String getCurrentKm() {
		return currentKm;
	}
	/**
	 * @param currentKm the currentKm to set
	 */
	public void setCurrentKm(String currentKm) {
		this.currentKm = currentKm;
	}
	
	/**
	 * @return the newAvailable
	 */
	public String getNewAvailable() {
		return newAvailable;
	}
	/**
	 * @param newAvailable the newAvailable to set
	 */
	public void setNewAvailable(String newAvailable) {
		this.newAvailable = newAvailable;
	}
	/**
	 * @return the newRate
	 */
	public String getNewRate() {
		return newRate;
	}
	/**
	 * @param newRate the newRate to set
	 */
	public void setNewRate(String newRate) {
		this.newRate = newRate;
	}
	/**
	 * @return the oldAvailable
	 */
	public String getOldAvailable() {
		return oldAvailable;
	}
	/**
	 * @param oldAvailable the oldAvailable to set
	 */
	public void setOldAvailable(String oldAvailable) {
		this.oldAvailable = oldAvailable;
	}
	/**
	 * @return the oldRate
	 */
	public String getOldRate() {
		return oldRate;
	}
	/**
	 * @param oldRate the oldRate to set
	 */
	public void setOldRate(String oldRate) {
		this.oldRate = oldRate;
	}
	/**
	 * @return the remainingQuantity
	 */
	public String getRemainingQuantity() {
		return remainingQuantity;
	}
	/**
	 * @param remainingQuantity the remainingQuantity to set
	 */
	public void setRemainingQuantity(String remainingQuantity) {
		this.remainingQuantity = remainingQuantity;
	}
	/**
	 * @return the requiredQuantity
	 */
	public String getRequiredQuantity() {
		return requiredQuantity;
	}
	/**
	 * @param requiredQuantity the requiredQuantity to set
	 */
	public void setRequiredQuantity(String requiredQuantity) {
		this.requiredQuantity = requiredQuantity;
	}
	/**
	 * @return the totalAmount
	 */
	public String getTotalAmount() {
		return totalAmount;
	}
	/**
	 * @param totalAmount the totalAmount to set
	 */
	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}
	/**
	 * @return the totalAvailableQuantity
	 */
	public String getTotalAvailableQuantity() {
		return totalAvailableQuantity;
	}
	/**
	 * @param totalAvailableQuantity the totalAvailableQuantity to set
	 */
	public void setTotalAvailableQuantity(String totalAvailableQuantity) {
		this.totalAvailableQuantity = totalAvailableQuantity;
	}
	
	
	public ArrayList getReasonList() {
		return reasonList;
	}
	public void setReasonList(ArrayList reasonList) {
		this.reasonList = reasonList;
	}
	/**
	 * @return the wasteReason
	 */
	public String getWasteReason() {
		return wasteReason;
	}
	/**
	 * @param wasteReason the wasteReason to set
	 */
	public void setWasteReason(String wasteReason) {
		this.wasteReason = wasteReason;
	}
	
	public ActionErrors validate(ActionMapping mapping, 
			HttpServletRequest request) 
			{ 
//			 Perform validator framework validations 
			ActionErrors errors = new ActionErrors(); 
//			 Only need crossfield validations here 
			if(StringUtils.isEmpty(driverName))
			 {
				 errors.add(ActionErrors.GLOBAL_MESSAGE,new ActionMessage("error.driverName.required")); 
			 }
			
			 if((StringUtils.isAlpha(requiredQuantity)||!StringUtils.isNumeric(requiredQuantity))&& StringUtils.isNotEmpty(requiredQuantity))
			 {
				 errors.add(ActionErrors.GLOBAL_MESSAGE,new ActionMessage("error.kerosenerequiredQuantity.required")); 
			 }
			
							
			if ((StringUtils.isAlpha(billNumber)||!StringUtils.isNumeric(billNumber))&& StringUtils.isNotEmpty(billNumber)) { 
				errors.add(ActionErrors.GLOBAL_MESSAGE,new ActionMessage("error.billNumber.required")); 
				} 
			
			if (StringUtils.isEmpty(requestedDriverName)) { 
				errors.add(ActionErrors.GLOBAL_MESSAGE,new ActionMessage("error.requestedDriverName.required")); 
				} 
			
			
			return errors; 
			}
	
}
	
	
	
	
	
		
	
	

	