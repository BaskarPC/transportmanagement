package com.vo;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.formbean.WasteForm;

public class WasteVO {
	private static final Logger logger=(Logger)Logger.getLogger(WasteVO.class);
	public ArrayList vehicleNumberList;
	public ArrayList instList;
	public ArrayList vehicleTypeList;
	public String vehicleType;
	public String driverName;
	public String institutionName;
	public String vehicleNumber;
	public String billNumber;
	public String requestedDate;
	public String requestedDriverName;
	public String otherPurpose;
	private ArrayList reasonList;
	private String totalAvailableQuantity=null;
	private String wasteReason=null;
	private String requiredQuantity=null;
		
	private String oldAvailable=null;
	private String newAvailable=null;
	private String oldRate=null;
	private String newRate=null;
	
	private String totalAmount=null;
	private String remainingQuantity=null;
	
	
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
	public String getBillNumber() {
		return billNumber;
	}
	public void setBillNumber(String billNumber) {
		this.billNumber = billNumber;
	}
	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	public String getInstitutionName() {
		return institutionName;
	}
	public void setInstitutionName(String institutionName) {
		this.institutionName = institutionName;
	}
	public ArrayList getInstList() {
		return instList;
	}
	public void setInstList(ArrayList instList) {
		this.instList = instList;
	}
	public String getOtherPurpose() {
		return otherPurpose;
	}
	public void setOtherPurpose(String otherPurpose) {
		this.otherPurpose = otherPurpose;
	}
	public ArrayList getReasonList() {
		return reasonList;
	}
	public void setReasonList(ArrayList reasonList) {
		this.reasonList = reasonList;
	}
	public String getRemainingQuantity() {
		return remainingQuantity;
	}
	public void setRemainingQuantity(String remainingQuantity) {
		this.remainingQuantity = remainingQuantity;
	}
	public String getRequestedDate() {
		return requestedDate;
	}
	public void setRequestedDate(String requestedDate) {
		this.requestedDate = requestedDate;
	}
	public String getRequestedDriverName() {
		return requestedDriverName;
	}
	public void setRequestedDriverName(String requestedDriverName) {
		this.requestedDriverName = requestedDriverName;
	}
	public String getRequiredQuantity() {
		return requiredQuantity;
	}
	public void setRequiredQuantity(String requiredQuantity) {
		this.requiredQuantity = requiredQuantity;
	}
	public String getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getTotalAvailableQuantity() {
		return totalAvailableQuantity;
	}
	public void setTotalAvailableQuantity(String totalAvailableQuantity) {
		this.totalAvailableQuantity = totalAvailableQuantity;
	}
	
	public String getVehicleNumber() {
		return vehicleNumber;
	}
	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	public ArrayList getVehicleNumberList() {
		return vehicleNumberList;
	}
	public void setVehicleNumberList(ArrayList vehicleNumberList) {
		this.vehicleNumberList = vehicleNumberList;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	public ArrayList getVehicleTypeList() {
		return vehicleTypeList;
	}
	public void setVehicleTypeList(ArrayList vehicleTypeList) {
		this.vehicleTypeList = vehicleTypeList;
	}
	
}
