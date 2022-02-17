package com.formbean;

import java.util.ArrayList;

import org.apache.struts.upload.FormFile;
import org.apache.struts.validator.ValidatorForm;


public class DieselOutsideForm  extends ValidatorForm{
	private ArrayList fuelList;
	private ArrayList instList;
	private ArrayList typeList;
	private ArrayList vehicleList;
	
	private String institutionName=null;
	private String vehicleType=null;
	private String vehicleNumber=null;
	private String driverName=null;
	private String requestedDriverName=null;
	private String billNumber=null;
	private String requestedDate=null;
	private String otherPurpose=null;
	
	private String unitRate=null;
	private String wantedQuantity=null;
	private String routeNumber=null;
	private String totalAmount=null;
	private String presentKm=null;
	private String differenceKm=null;
	private String lastFillingKm=null;
	private String averageKm=null;
	private String remarks=null;
	private String otherBunkName=null;
	private String bunkName=null;
	private String fuelType=null;
	//private FormFile fileName=null;
	
	/**
	 * @return the averageKm
	 */
	public String getAverageKm() {
		return averageKm;
	}
	/**
	 * @param averageKm the averageKm to set
	 */
	public void setAverageKm(String averageKm) {
		this.averageKm = averageKm;
	}
	/**
	 * @return the bunkName
	 */
	public String getBunkName() {
		return bunkName;
	}
	/**
	 * @param bunkName the bunkName to set
	 */
	public void setBunkName(String bunkName) {
		this.bunkName = bunkName;
	}
	/**
	 * @return the differenceKm
	 */
	public String getDifferenceKm() {
		return differenceKm;
	}
	/**
	 * @param differenceKm the differenceKm to set
	 */
	public void setDifferenceKm(String differenceKm) {
		this.differenceKm = differenceKm;
	}
	/**
	 * @return the fuelType
	 */
	public String getFuelType() {
		return fuelType;
	}
	/**
	 * @param fuelType the fuelType to set
	 */
	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}
	/**
	 * @return the lastFillingKm
	 */
	public String getLastFillingKm() {
		return lastFillingKm;
	}
	/**
	 * @param lastFillingKm the lastFillingKm to set
	 */
	public void setLastFillingKm(String lastFillingKm) {
		this.lastFillingKm = lastFillingKm;
	}
	/**
	 * @return the otherBunkName
	 */
	public String getOtherBunkName() {
		return otherBunkName;
	}
	/**
	 * @param otherBunkName the otherBunkName to set
	 */
	public void setOtherBunkName(String otherBunkName) {
		this.otherBunkName = otherBunkName;
	}
	/**
	 * @return the presentKm
	 */
	public String getPresentKm() {
		return presentKm;
	}
	/**
	 * @param presentKm the presentKm to set
	 */
	public void setPresentKm(String presentKm) {
		this.presentKm = presentKm;
	}
	/**
	 * @return the remarks
	 */
	public String getRemarks() {
		return remarks;
	}
	/**
	 * @param remarks the remarks to set
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	/**
	 * @return the routeNumber
	 */
	public String getRouteNumber() {
		return routeNumber;
	}
	/**
	 * @param routeNumber the routeNumber to set
	 */
	public void setRouteNumber(String routeNumber) {
		this.routeNumber = routeNumber;
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
	 * @return the unitRate
	 */
	public String getUnitRate() {
		return unitRate;
	}
	/**
	 * @param unitRate the unitRate to set
	 */
	public void setUnitRate(String unitRate) {
		this.unitRate = unitRate;
	}
	/**
	 * @return the wantedQuantity
	 */
	public String getWantedQuantity() {
		return wantedQuantity;
	}
	/**
	 * @param wantedQuantity the wantedQuantity to set
	 */
	public void setWantedQuantity(String wantedQuantity) {
		this.wantedQuantity = wantedQuantity;
	}
	/**
	 * @return the fileName
	 */
	/*public FormFile getFileName() {
		return fileName;
	}
	/**
	 * @param fileName the fileName to set
	 */
	/*public void setFileName(FormFile fileName) {
		this.fileName = fileName;
	}*/
	public ArrayList getFuelList() {
		return fuelList;
	}
	public void setFuelList(ArrayList fuelList) {
		this.fuelList = fuelList;
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
	public String getOtherPurpose() {
		return otherPurpose;
	}
	public void setOtherPurpose(String otherPurpose) {
		this.otherPurpose = otherPurpose;
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
	public String getVehicleNumber() {
		return vehicleNumber;
	}
	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	public ArrayList getInstList() {
		return instList;
	}
	public void setInstList(ArrayList instList) {
		this.instList = instList;
	}
	public ArrayList getTypeList() {
		return typeList;
	}
	public void setTypeList(ArrayList typeList) {
		this.typeList = typeList;
	}
	public ArrayList getVehicleList() {
		return vehicleList;
	}
	public void setVehicleList(ArrayList vehicleList) {
		this.vehicleList = vehicleList;
	}
	
}
