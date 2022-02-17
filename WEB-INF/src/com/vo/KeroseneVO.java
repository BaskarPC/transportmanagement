package com.vo;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.apache.struts.validator.ValidatorForm;

public class KeroseneVO {
private static final Logger logger=(Logger)Logger.getLogger(KeroseneVO.class);
	
	private String totalAvailableQuantity=null;
	private String keroseneReason=null;
	private String requiredQuantity=null;
	private String currentKm=null;
	
	private String oldAvailable=null;
	private String newAvailable=null;
	private String oldRate=null;
	private String newRate=null;
	
	private String totalAmount=null;
	private String remainingQuantity=null;
	
	private ArrayList krlist=null;
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
	 * @return the keroseneReason
	 */
	public String getKeroseneReason() {
		return keroseneReason;
	}
	/**
	 * @param keroseneReason the keroseneReason to set
	 */
	public void setKeroseneReason(String keroseneReason) {
		this.keroseneReason = keroseneReason;
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
	/**
	 * @return the krlist
	 */
	public ArrayList getKrlist() {
		return krlist;
	}
	/**
	 * @param krlist the krlist to set
	 */
	public void setKrlist(ArrayList krlist) {
		this.krlist = krlist;
	}
	
}
