package com.formbean;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;
public class LabourForm extends GeneralForm{
	
	private ArrayList instList;
	private ArrayList typeList;
	private ArrayList vehicleList;
	private ArrayList labourList;
	private String requestedDate=null;
	private String otherPurpose=null;
	private String institutionName=null;
	private String vehicleType=null;
	private String vehicleNumber=null;
	private String totalAmount;
	private String labourReason;
	/**
	 * @return the labourReason
	 */
	public String getLabourReason() {
		return labourReason;
	}
	/**
	 * @param labourReason the labourReason to set
	 */
	public void setLabourReason(String labourReason) {
		this.labourReason = labourReason;
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
	 * @return the typeList
	 */
	public ArrayList getTypeList() {
		return typeList;
	}
	/**
	 * @param typeList the typeList to set
	 */
	public void setTypeList(ArrayList typeList) {
		this.typeList = typeList;
	}
	/**
	 * @return the vehicleList
	 */
	public ArrayList getVehicleList() {
		return vehicleList;
	}
	/**
	 * @param vehicleList the vehicleList to set
	 */
	public void setVehicleList(ArrayList vehicleList) {
		this.vehicleList = vehicleList;
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
	 * @return the labourList
	 */
	public ArrayList getLabourList() {
		return labourList;
	}
	/**
	 * @param labourList the labourList to set
	 */
	public void setLabourList(ArrayList labourList) {
		this.labourList = labourList;
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
	
}
