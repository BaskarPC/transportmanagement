
package com.formbean;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.validator.ValidatorForm;

public class DieselForm extends ValidatorForm{

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
	
	private String wantedQuantity=null;
	private String newAvailable=null;
	private String oldAvailable=null;
	private String newRate=null;
	private String oldRate=null;
	private String routeNumber=null;
	private String totalAmount=null;
	private String presentKm=null;
	private String differenceKm=null;
	private String lastFillingKm=null;
	private String averageKm=null;
	private String remark=null;
	private String stock=null;
	private String openingReading=null;
	private String closingReading=null;
	private String consumptionLitres=null;
	private String balance=null;
	
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
	 * @return the remark
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * @param remark the remark to set
	 */
	public void setRemark(String remark) {
		this.remark = remark;
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
	 * @return the balance
	 */
	public String getBalance() {
		return balance;
	}
	/**
	 * @param balance the balance to set
	 */
	public void setBalance(String balance) {
		this.balance = balance;
	}
	/**
	 * @return the closingReading
	 */
	public String getClosingReading() {
		return closingReading;
	}
	/**
	 * @param closingReading the closingReading to set
	 */
	public void setClosingReading(String closingReading) {
		this.closingReading = closingReading;
	}
	/**
	 * @return the consumptionLitres
	 */
	public String getConsumptionLitres() {
		return consumptionLitres;
	}
	/**
	 * @param consumptionLitres the consumptionLitres to set
	 */
	public void setConsumptionLitres(String consumptionLitres) {
		this.consumptionLitres = consumptionLitres;
	}
	/**
	 * @return the openingReading
	 */
	public String getOpeningReading() {
		return openingReading;
	}
	/**
	 * @param openingReading the openingReading to set
	 */
	public void setOpeningReading(String openingReading) {
		this.openingReading = openingReading;
	}
	/**
	 * @return the stock
	 */
	public String getStock() {
		return stock;
	}
	/**
	 * @param stock the stock to set
	 */
	public void setStock(String stock) {
		this.stock = stock;
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
	
	public ActionErrors validate(ActionMapping mapping, 
			HttpServletRequest request) 
			{ 
//			 Perform validator framework validations 
			ActionErrors errors = new ActionErrors(); 
//			 Only need crossfield validations here 
			 
//	 		For requestedDate property	 
			 if(StringUtils.isEmpty(requestedDate))
			 {
				 errors.add("requestedDate",new ActionMessage("error.requestedDate.required")); 
			 }
//			 For wantedQuantity property	 
			 if(!(StringUtils.isNumeric(wantedQuantity)))
			 {
				 errors.add("wantedQuantity",new ActionMessage("error.wantedQuantity.required")); 
			 }
			 else if(StringUtils.isEmpty(wantedQuantity))
			 {
				 errors.add("presentKm",new ActionMessage("error.wantedQuantity.required")); 
			 }
			 else if(StringUtils.isAlpha(wantedQuantity))
			 {
				 errors.add("presentKm",new ActionMessage("error.wantedQuantity.required")); 
			 }
//			 For presentKm property	 
			 if(StringUtils.isEmpty(presentKm))
			 {
				 errors.add("presentKm",new ActionMessage("error.presentKm.required")); 
			 }
			 else if(!(StringUtils.isNumeric(presentKm)))
				{
					errors.add("presentKm",new ActionMessage("error.presentKm.noalpha"));
				}
// 			For remark property		 
			 
			return errors; 
			}
}
