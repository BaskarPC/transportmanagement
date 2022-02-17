package com.formbean;

import java.util.ArrayList;
import org.apache.log4j.Logger;
import org.apache.struts.validator.ValidatorForm;

public class PassingBillForm extends ValidatorForm {
	private static final Logger logger=(Logger)Logger.getLogger(PassingBillForm.class);
	
	private ArrayList purchaseissueList;
	private ArrayList goodsList;
	private ArrayList billnumberList;
	
	private String requestedDate=null;
	private String institutionName=null;
	private String vehicleNumber=null;
	private String purchaseIssue=null;
	private String typeOfProduct=null;
	private String passingBillNumber=null;
	private String serviceStationLocation=null;
	private String serviceName=null;
	private String billDate=null;
	private String headOfAccountDebit=null;
	private String billAmount=null;
	private String billNumber=null;
	/**
	 * @return the billAmount
	 */
	public String getBillAmount() {
		return billAmount;
	}
	/**
	 * @param billAmount the billAmount to set
	 */
	public void setBillAmount(String billAmount) {
		this.billAmount = billAmount;
	}
	/**
	 * @return the billDate
	 */
	public String getBillDate() {
		return billDate;
	}
	/**
	 * @param billDate the billDate to set
	 */
	public void setBillDate(String billDate) {
		this.billDate = billDate;
	}


	/**
	 * @return the headOfAccountDebit
	 */
	public String getHeadOfAccountDebit() {
		return headOfAccountDebit;
	}
	/**
	 * @param headOfAccountDebit the headOfAccountDebit to set
	 */
	public void setHeadOfAccountDebit(String headOfAccountDebit) {
		this.headOfAccountDebit = headOfAccountDebit;
	}
	/**
	 * @return the passingBillNumber
	 */
	public String getPassingBillNumber() {
		return passingBillNumber;
	}
	/**
	 * @param passingBillNumber the passingBillNumber to set
	 */
	public void setPassingBillNumber(String passingBillNumber) {
		this.passingBillNumber = passingBillNumber;
	}
	/**
	 * @return the purchaseIssue
	 */
	public String getPurchaseIssue() {
		return purchaseIssue;
	}
	/**
	 * @param purchaseIssue the purchaseIssue to set
	 */
	public void setPurchaseIssue(String purchaseIssue) {
		this.purchaseIssue = purchaseIssue;
	}
	/**
	 * @return the serviceName
	 */
	public String getServiceName() {
		return serviceName;
	}
	/**
	 * @param serviceName the serviceName to set
	 */
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	/**
	 * @return the serviceStationLocation
	 */
	public String getServiceStationLocation() {
		return serviceStationLocation;
	}
	/**
	 * @param serviceStationLocation the serviceStationLocation to set
	 */
	public void setServiceStationLocation(String serviceStationLocation) {
		this.serviceStationLocation = serviceStationLocation;
	}
	/**
	 * @return the typeOfProduct
	 */
	public String getTypeOfProduct() {
		return typeOfProduct;
	}
	/**
	 * @param typeOfProduct the typeOfProduct to set
	 */
	public void setTypeOfProduct(String typeOfProduct) {
		this.typeOfProduct = typeOfProduct;
	}
	public ArrayList getPurchaseissueList() {
		return purchaseissueList;
	}
	public void setPurchaseissueList(ArrayList purchaseissueList) {
		this.purchaseissueList = purchaseissueList;
	}
	public ArrayList getGoodsList() {
		return goodsList;
	}
	public void setGoodsList(ArrayList goodsList) {
		this.goodsList = goodsList;
	}
	public String getBillNumber() {
		return billNumber;
	}
	public void setBillNumber(String billNumber) {
		this.billNumber = billNumber;
	}
	public ArrayList getBillnumberList() {
		return billnumberList;
	}
	public void setBillnumberList(ArrayList billnumberList) {
		this.billnumberList = billnumberList;
	}
	public String getInstitutionName() {
		return institutionName;
	}
	public void setInstitutionName(String institutionName) {
		this.institutionName = institutionName;
	}
	public String getVehicleNumber() {
		return vehicleNumber;
	}
	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	public String getRequestedDate() {
		return requestedDate;
	}
	public void setRequestedDate(String requestedDate) {
		this.requestedDate = requestedDate;
	}
	
}
