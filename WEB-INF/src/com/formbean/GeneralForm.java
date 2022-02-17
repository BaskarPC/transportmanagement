package com.formbean;

import java.util.ArrayList;


import org.apache.struts.validator.ValidatorForm;

public class GeneralForm extends ValidatorForm {
	
	public ArrayList vehicleNumberList;
	public ArrayList instList;
	public ArrayList vehicleTypeList;
	public String vehicleType=null;
	public String driverName=null;
	public String institutionName=null;
	public String vehicleNumber=null;
	public String billNumber=null;
	public String requestedDate=null;
	public String requestedDriverName=null;
	public String otherPurpose=null;
	
	private String tyreSize=null;
	private String tyrePly=null;
	private String tyreBrand=null;
	private String tyreNumber=null;
	public String getTyreBrand() {
		return tyreBrand;
	}
	public void setTyreBrand(String tyreBrand) {
		this.tyreBrand = tyreBrand;
	}
	public String getTyreNumber() {
		return tyreNumber;
	}
	public void setTyreNumber(String tyreNumber) {
		this.tyreNumber = tyreNumber;
	}
	public String getTyrePly() {
		return tyrePly;
	}
	public void setTyrePly(String tyrePly) {
		this.tyrePly = tyrePly;
	}
	public String getTyreSize() {
		return tyreSize;
	}
	public void setTyreSize(String tyreSize) {
		this.tyreSize = tyreSize;
	}
	/**
	 * @return the billNumber
	 */
	public String getBillNumber() {
		return billNumber;
	}
	/**
	 * @param billNumber the billNumber to set
	 */
	public void setBillNumber(String billNumber) {
		this.billNumber = billNumber;
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
	 * @return the institutionName
	 */
	public String getInstitutionName() {
		return institutionName;
	}
	/**
	 * @param institutionName the institutionName to set
	 */
	public void setInstitutionName(String institutionName) {
		this.institutionName = institutionName;
	}
	/**
	 * @return the otherPurpose
	 */
	public String getOtherPurpose() {
		return otherPurpose;
	}
	/**
	 * @param otherPurpose the otherPurpose to set
	 */
	public void setOtherPurpose(String otherPurpose) {
		this.otherPurpose = otherPurpose;
	}
	/**
	 * @return the requestedDate
	 */
	public String getRequestedDate() {
		return requestedDate;
	}
	/**
	 * @param requestedDate the requestedDate to set
	 */
	public void setRequestedDate(String requestedDate) {
		this.requestedDate = requestedDate;
	}
	/**
	 * @return the requestedDriverName
	 */
	public String getRequestedDriverName() {
		return requestedDriverName;
	}
	/**
	 * @param requestedDriverName the requestedDriverName to set
	 */
	public void setRequestedDriverName(String requestedDriverName) {
		this.requestedDriverName = requestedDriverName;
	}
	/**
	 * @return the vehicleNumber
	 */
	public String getVehicleNumber() {
		return vehicleNumber;
	}
	/**
	 * @param vehicleNumber the vehicleNumber to set
	 */
	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	/**
	 * @return the vehicleType
	 */
	public String getVehicleType() {
		return vehicleType;
	}
	/**
	 * @param vehicleType the vehicleType to set
	 */
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	/**
	 * @return the instList
	 */
	public ArrayList getInstList() {
		return instList;
	}
	/**
	 * @param instList the instList to set
	 */
	public void setInstList(ArrayList instList) {
		this.instList = instList;
	}
	/**
	 * @return the vehicleTypeList
	 */
	public ArrayList getVehicleTypeList() {
		return vehicleTypeList;
	}
	/**
	 * @param vehicleTypeList the vehicleTypeList to set
	 */
	public void setVehicleTypeList(ArrayList vehicleTypeList) {
		this.vehicleTypeList = vehicleTypeList;
	}
	/**
	 * @return the vehicleNumberList
	 */
	public ArrayList getVehicleNumberList() {
		return vehicleNumberList;
	}
	/**
	 * @param vehicleNumberList the vehicleNumberList to set
	 */
	public void setVehicleNumberList(ArrayList vehicleNumberList) {
		this.vehicleNumberList = vehicleNumberList;
	}

}
