package com.vo;

import org.apache.log4j.Logger;

public class PassingBillVO  {
	private static final Logger logger=(Logger)Logger.getLogger(PassingBillVO.class);
	
	
	private String purchaseissueId;
	private String purchaseissueDesc;
	private String goodsId;
	private String goodsDesc;
	private String billnumberId;
	private String billnumberDesc;
	
	private String purchaseIssue=null;
	private String typeOfProduct=null;
	private String passingBillNumber=null;
	private String serviceStationLocation=null;
	private String serviceName=null;
	private String billDate=null;
	private String headOfAccountDebit=null;
	private String billAmount=null;
	private String driverName;
	private String institutionName=null;
	private String vehicleNumber=null;
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
	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
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
	public String getPurchaseissueDesc() {
		return purchaseissueDesc;
	}
	public void setPurchaseissueDesc(String purchaseissueDesc) {
		this.purchaseissueDesc = purchaseissueDesc;
	}
	public String getPurchaseissueId() {
		return purchaseissueId;
	}
	public void setPurchaseissueId(String purchaseissueId) {
		this.purchaseissueId = purchaseissueId;
	}
	public String getGoodsDesc() {
		return goodsDesc;
	}
	public void setGoodsDesc(String goodsDesc) {
		this.goodsDesc = goodsDesc;
	}
	public String getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}
	public String getBillnumberDesc() {
		return billnumberDesc;
	}
	public void setBillnumberDesc(String billnumberDesc) {
		this.billnumberDesc = billnumberDesc;
	}
	public String getBillnumberId() {
		return billnumberId;
	}
	public void setBillnumberId(String billnumberId) {
		this.billnumberId = billnumberId;
	}
	
}
