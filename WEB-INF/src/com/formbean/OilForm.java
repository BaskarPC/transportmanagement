package com.formbean;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.validator.ValidatorForm;

public class OilForm extends ValidatorForm{

	private ArrayList instList;
	private ArrayList typeList;
	private ArrayList vehicleList;
	private ArrayList oilList;
	private ArrayList oilReasonList;
	
	private String institutionName=null;
	private String vehicleType=null;
	private String vehicleNumber=null;
	private String driverName=null;
	private String requestedDriverName=null;
	private String billNumber=null;
	private String requestedDate=null;
	private String otherPurpose=null;
	
	private String totalAvailableQuantity1=null;
	private String totalAvailableQuantity2=null;
	private String totalAvailableQuantity3=null;
	private String totalAvailableQuantity4=null;
	private String totalAvailableQuantity5=null;
	
	private String oilType1=null;
	private String oilType2=null;
	private String oilType3=null;
	private String oilType4=null;
	private String oilType5=null;
	
	private String oilReason1=null;
	private String oilReason2=null;
	private String oilReason3=null;
	private String oilReason4=null;
	private String oilReason5=null;

	private String wantedQuantity1=null;
	private String wantedQuantity2=null;
	private String wantedQuantity3=null;
	private String wantedQuantity4=null;
	private String wantedQuantity5=null;

	private String oldAvailable1=null;
	private String oldAvailable2=null;
	private String oldAvailable3=null;
	private String oldAvailable4=null;
	private String oldAvailable5=null;

	private String newAvailable1=null;
	private String newAvailable2=null;
	private String newAvailable3=null;
	private String newAvailable4=null;
	private String newAvailable5=null;
	
	private String oldRate1=null;
	private String oldRate2=null;
	private String oldRate3=null;
	private String oldRate4=null;
	private String oldRate5=null;
	
	private String newRate1=null;
	private String newRate2=null;
	private String newRate3=null;
	private String newRate4=null;
	private String newRate5=null;

	private String totalAmount1=null;
	private String totalAmount2=null;
	private String totalAmount3=null;
	private String totalAmount4=null;
	private String totalAmount5=null;
	private String totalAmount=null;
	
	private String currentKM=null;
	private String previousServicedKM=null;
	private String differenceKM=null;
	/**
	 * @return the currentKM
	 */
	public String getCurrentKM() {
		return currentKM;
	}
	/**
	 * @param currentKM the currentKM to set
	 */
	public void setCurrentKM(String currentKM) {
		this.currentKM = currentKM;
	}
	/**
	 * @return the differenceKM
	 */
	public String getDifferenceKM() {
		return differenceKM;
	}
	/**
	 * @param differenceKM the differenceKM to set
	 */
	public void setDifferenceKM(String differenceKM) {
		this.differenceKM = differenceKM;
	}
	/**
	 * @return the newAvailable1
	 */
	public String getNewAvailable1() {
		return newAvailable1;
	}
	/**
	 * @param newAvailable1 the newAvailable1 to set
	 */
	public void setNewAvailable1(String newAvailable1) {
		this.newAvailable1 = newAvailable1;
	}
	/**
	 * @return the newAvailable2
	 */
	public String getNewAvailable2() {
		return newAvailable2;
	}
	/**
	 * @param newAvailable2 the newAvailable2 to set
	 */
	public void setNewAvailable2(String newAvailable2) {
		this.newAvailable2 = newAvailable2;
	}
	/**
	 * @return the newAvailable3
	 */
	public String getNewAvailable3() {
		return newAvailable3;
	}
	/**
	 * @param newAvailable3 the newAvailable3 to set
	 */
	public void setNewAvailable3(String newAvailable3) {
		this.newAvailable3 = newAvailable3;
	}
	/**
	 * @return the newAvailable4
	 */
	public String getNewAvailable4() {
		return newAvailable4;
	}
	/**
	 * @param newAvailable4 the newAvailable4 to set
	 */
	public void setNewAvailable4(String newAvailable4) {
		this.newAvailable4 = newAvailable4;
	}
	/**
	 * @return the newAvailable5
	 */
	public String getNewAvailable5() {
		return newAvailable5;
	}
	/**
	 * @param newAvailable5 the newAvailable5 to set
	 */
	public void setNewAvailable5(String newAvailable5) {
		this.newAvailable5 = newAvailable5;
	}
	/**
	 * @return the newRate1
	 */
	public String getNewRate1() {
		return newRate1;
	}
	/**
	 * @param newRate1 the newRate1 to set
	 */
	public void setNewRate1(String newRate1) {
		this.newRate1 = newRate1;
	}
	/**
	 * @return the newRate2
	 */
	public String getNewRate2() {
		return newRate2;
	}
	/**
	 * @param newRate2 the newRate2 to set
	 */
	public void setNewRate2(String newRate2) {
		this.newRate2 = newRate2;
	}
	/**
	 * @return the newRate3
	 */
	public String getNewRate3() {
		return newRate3;
	}
	/**
	 * @param newRate3 the newRate3 to set
	 */
	public void setNewRate3(String newRate3) {
		this.newRate3 = newRate3;
	}
	/**
	 * @return the newRate4
	 */
	public String getNewRate4() {
		return newRate4;
	}
	/**
	 * @param newRate4 the newRate4 to set
	 */
	public void setNewRate4(String newRate4) {
		this.newRate4 = newRate4;
	}
	/**
	 * @return the newRate5
	 */
	public String getNewRate5() {
		return newRate5;
	}
	/**
	 * @param newRate5 the newRate5 to set
	 */
	public void setNewRate5(String newRate5) {
		this.newRate5 = newRate5;
	}
	/**
	 * @return the oilReason1
	 */
	public String getOilReason1() {
		return oilReason1;
	}
	/**
	 * @param oilReason1 the oilReason1 to set
	 */
	public void setOilReason1(String oilReason1) {
		this.oilReason1 = oilReason1;
	}
	/**
	 * @return the oilReason2
	 */
	public String getOilReason2() {
		return oilReason2;
	}
	/**
	 * @param oilReason2 the oilReason2 to set
	 */
	public void setOilReason2(String oilReason2) {
		this.oilReason2 = oilReason2;
	}
	/**
	 * @return the oilReason3
	 */
	public String getOilReason3() {
		return oilReason3;
	}
	/**
	 * @param oilReason3 the oilReason3 to set
	 */
	public void setOilReason3(String oilReason3) {
		this.oilReason3 = oilReason3;
	}
	/**
	 * @return the oilReason4
	 */
	public String getOilReason4() {
		return oilReason4;
	}
	/**
	 * @param oilReason4 the oilReason4 to set
	 */
	public void setOilReason4(String oilReason4) {
		this.oilReason4 = oilReason4;
	}
	/**
	 * @return the oilReason5
	 */
	public String getOilReason5() {
		return oilReason5;
	}
	/**
	 * @param oilReason5 the oilReason5 to set
	 */
	public void setOilReason5(String oilReason5) {
		this.oilReason5 = oilReason5;
	}
	/**
	 * @return the oilType1
	 */
	public String getOilType1() {
		return oilType1;
	}
	/**
	 * @param oilType1 the oilType1 to set
	 */
	public void setOilType1(String oilType1) {
		this.oilType1 = oilType1;
	}
	/**
	 * @return the oilType2
	 */
	public String getOilType2() {
		return oilType2;
	}
	/**
	 * @param oilType2 the oilType2 to set
	 */
	public void setOilType2(String oilType2) {
		this.oilType2 = oilType2;
	}
	/**
	 * @return the oilType3
	 */
	public String getOilType3() {
		return oilType3;
	}
	/**
	 * @param oilType3 the oilType3 to set
	 */
	public void setOilType3(String oilType3) {
		this.oilType3 = oilType3;
	}
	/**
	 * @return the oilType4
	 */
	public String getOilType4() {
		return oilType4;
	}
	/**
	 * @param oilType4 the oilType4 to set
	 */
	public void setOilType4(String oilType4) {
		this.oilType4 = oilType4;
	}
	/**
	 * @return the oilType5
	 */
	public String getOilType5() {
		return oilType5;
	}
	/**
	 * @param oilType5 the oilType5 to set
	 */
	public void setOilType5(String oilType5) {
		this.oilType5 = oilType5;
	}
	/**
	 * @return the oldAvailable1
	 */
	public String getOldAvailable1() {
		return oldAvailable1;
	}
	/**
	 * @param oldAvailable1 the oldAvailable1 to set
	 */
	public void setOldAvailable1(String oldAvailable1) {
		this.oldAvailable1 = oldAvailable1;
	}
	/**
	 * @return the oldAvailable2
	 */
	public String getOldAvailable2() {
		return oldAvailable2;
	}
	/**
	 * @param oldAvailable2 the oldAvailable2 to set
	 */
	public void setOldAvailable2(String oldAvailable2) {
		this.oldAvailable2 = oldAvailable2;
	}
	/**
	 * @return the oldAvailable3
	 */
	public String getOldAvailable3() {
		return oldAvailable3;
	}
	/**
	 * @param oldAvailable3 the oldAvailable3 to set
	 */
	public void setOldAvailable3(String oldAvailable3) {
		this.oldAvailable3 = oldAvailable3;
	}
	/**
	 * @return the oldAvailable4
	 */
	public String getOldAvailable4() {
		return oldAvailable4;
	}
	/**
	 * @param oldAvailable4 the oldAvailable4 to set
	 */
	public void setOldAvailable4(String oldAvailable4) {
		this.oldAvailable4 = oldAvailable4;
	}
	/**
	 * @return the oldAvailable5
	 */
	public String getOldAvailable5() {
		return oldAvailable5;
	}
	/**
	 * @param oldAvailable5 the oldAvailable5 to set
	 */
	public void setOldAvailable5(String oldAvailable5) {
		this.oldAvailable5 = oldAvailable5;
	}
	/**
	 * @return the oldRate1
	 */
	public String getOldRate1() {
		return oldRate1;
	}
	/**
	 * @param oldRate1 the oldRate1 to set
	 */
	public void setOldRate1(String oldRate1) {
		this.oldRate1 = oldRate1;
	}
	/**
	 * @return the oldRate2
	 */
	public String getOldRate2() {
		return oldRate2;
	}
	/**
	 * @param oldRate2 the oldRate2 to set
	 */
	public void setOldRate2(String oldRate2) {
		this.oldRate2 = oldRate2;
	}
	/**
	 * @return the oldRate3
	 */
	public String getOldRate3() {
		return oldRate3;
	}
	/**
	 * @param oldRate3 the oldRate3 to set
	 */
	public void setOldRate3(String oldRate3) {
		this.oldRate3 = oldRate3;
	}
	/**
	 * @return the oldRate4
	 */
	public String getOldRate4() {
		return oldRate4;
	}
	/**
	 * @param oldRate4 the oldRate4 to set
	 */
	public void setOldRate4(String oldRate4) {
		this.oldRate4 = oldRate4;
	}
	/**
	 * @return the oldRate5
	 */
	public String getOldRate5() {
		return oldRate5;
	}
	/**
	 * @param oldRate5 the oldRate5 to set
	 */
	public void setOldRate5(String oldRate5) {
		this.oldRate5 = oldRate5;
	}
	/**
	 * @return the previousServicedKM
	 */
	public String getPreviousServicedKM() {
		return previousServicedKM;
	}
	/**
	 * @param previousServicedKM the previousServicedKM to set
	 */
	public void setPreviousServicedKM(String previousServicedKM) {
		this.previousServicedKM = previousServicedKM;
	}
	/**
	 * @return the totalAmount1
	 */
	public String getTotalAmount1() {
		return totalAmount1;
	}
	/**
	 * @param totalAmount1 the totalAmount1 to set
	 */
	public void setTotalAmount1(String totalAmount1) {
		this.totalAmount1 = totalAmount1;
	}
	/**
	 * @return the totalAmount2
	 */
	public String getTotalAmount2() {
		return totalAmount2;
	}
	/**
	 * @param totalAmount2 the totalAmount2 to set
	 */
	public void setTotalAmount2(String totalAmount2) {
		this.totalAmount2 = totalAmount2;
	}
	/**
	 * @return the totalAmount3
	 */
	public String getTotalAmount3() {
		return totalAmount3;
	}
	/**
	 * @param totalAmount3 the totalAmount3 to set
	 */
	public void setTotalAmount3(String totalAmount3) {
		this.totalAmount3 = totalAmount3;
	}
	/**
	 * @return the totalAmount4
	 */
	public String getTotalAmount4() {
		return totalAmount4;
	}
	/**
	 * @param totalAmount4 the totalAmount4 to set
	 */
	public void setTotalAmount4(String totalAmount4) {
		this.totalAmount4 = totalAmount4;
	}
	/**
	 * @return the totalAmount5
	 */
	public String getTotalAmount5() {
		return totalAmount5;
	}
	/**
	 * @param totalAmount5 the totalAmount5 to set
	 */
	public void setTotalAmount5(String totalAmount5) {
		this.totalAmount5 = totalAmount5;
	}
	/**
	 * @return the totalAvailableQuantity1
	 */
	public String getTotalAvailableQuantity1() {
		return totalAvailableQuantity1;
	}
	/**
	 * @param totalAvailableQuantity1 the totalAvailableQuantity1 to set
	 */
	public void setTotalAvailableQuantity1(String totalAvailableQuantity1) {
		this.totalAvailableQuantity1 = totalAvailableQuantity1;
	}
	/**
	 * @return the totalAvailableQuantity2
	 */
	public String getTotalAvailableQuantity2() {
		return totalAvailableQuantity2;
	}
	/**
	 * @param totalAvailableQuantity2 the totalAvailableQuantity2 to set
	 */
	public void setTotalAvailableQuantity2(String totalAvailableQuantity2) {
		this.totalAvailableQuantity2 = totalAvailableQuantity2;
	}
	/**
	 * @return the totalAvailableQuantity3
	 */
	public String getTotalAvailableQuantity3() {
		return totalAvailableQuantity3;
	}
	/**
	 * @param totalAvailableQuantity3 the totalAvailableQuantity3 to set
	 */
	public void setTotalAvailableQuantity3(String totalAvailableQuantity3) {
		this.totalAvailableQuantity3 = totalAvailableQuantity3;
	}
	/**
	 * @return the totalAvailableQuantity4
	 */
	public String getTotalAvailableQuantity4() {
		return totalAvailableQuantity4;
	}
	/**
	 * @param totalAvailableQuantity4 the totalAvailableQuantity4 to set
	 */
	public void setTotalAvailableQuantity4(String totalAvailableQuantity4) {
		this.totalAvailableQuantity4 = totalAvailableQuantity4;
	}
	/**
	 * @return the totalAvailableQuantity5
	 */
	public String getTotalAvailableQuantity5() {
		return totalAvailableQuantity5;
	}
	/**
	 * @param totalAvailableQuantity5 the totalAvailableQuantity5 to set
	 */
	public void setTotalAvailableQuantity5(String totalAvailableQuantity5) {
		this.totalAvailableQuantity5 = totalAvailableQuantity5;
	}
	/**
	 * @return the wantedQuantity1
	 */
	public String getWantedQuantity1() {
		return wantedQuantity1;
	}
	/**
	 * @param wantedQuantity1 the wantedQuantity1 to set
	 */
	public void setWantedQuantity1(String wantedQuantity1) {
		this.wantedQuantity1 = wantedQuantity1;
	}
	/**
	 * @return the wantedQuantity2
	 */
	public String getWantedQuantity2() {
		return wantedQuantity2;
	}
	/**
	 * @param wantedQuantity2 the wantedQuantity2 to set
	 */
	public void setWantedQuantity2(String wantedQuantity2) {
		this.wantedQuantity2 = wantedQuantity2;
	}
	/**
	 * @return the wantedQuantity3
	 */
	public String getWantedQuantity3() {
		return wantedQuantity3;
	}
	/**
	 * @param wantedQuantity3 the wantedQuantity3 to set
	 */
	public void setWantedQuantity3(String wantedQuantity3) {
		this.wantedQuantity3 = wantedQuantity3;
	}
	/**
	 * @return the wantedQuantity4
	 */
	public String getWantedQuantity4() {
		return wantedQuantity4;
	}
	/**
	 * @param wantedQuantity4 the wantedQuantity4 to set
	 */
	public void setWantedQuantity4(String wantedQuantity4) {
		this.wantedQuantity4 = wantedQuantity4;
	}
	/**
	 * @return the wantedQuantity5
	 */
	public String getWantedQuantity5() {
		return wantedQuantity5;
	}
	/**
	 * @param wantedQuantity5 the wantedQuantity5 to set
	 */
	public void setWantedQuantity5(String wantedQuantity5) {
		this.wantedQuantity5 = wantedQuantity5;
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
	public ArrayList getOilList() {
		return oilList;
	}
	public void setOilList(ArrayList oilList) {
		this.oilList = oilList;
	}
	public ArrayList getOilReasonList() {
		return oilReasonList;
	}
	public void setOilReasonList(ArrayList oilReasonList) {
		this.oilReasonList = oilReasonList;
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
/*//			 For wantedQuantity1 property	 
			 if(!(StringUtils.isNumeric(wantedQuantity1)))
			 {
				 errors.add("wantedQuantity1",new ActionMessage("error.wantedQuantity1.nonumeric")); 
			 }
			 else if(StringUtils.isAlpha(wantedQuantity1))
			 {
				 errors.add("wantedQuantity1",new ActionMessage("error.wantedQuantity1.alpha")); 
			 }
//			 For wantedQuantity2 property	 
			 if(!(StringUtils.isNumeric(wantedQuantity2)))
			 {
				 errors.add("wantedQuantity2",new ActionMessage("error.wantedQuantity2.nonumeric")); 
			 }
			 else if(StringUtils.isAlpha(wantedQuantity2))
			 {
				 errors.add("wantedQuantity2",new ActionMessage("error.wantedQuantity2.alpha")); 
			 }
//			 For wantedQuantity3 property	 
			 if(!(StringUtils.isNumeric(wantedQuantity3)))
			 {
				 errors.add("wantedQuantity3",new ActionMessage("error.wantedQuantity3.nonumeric")); 
			 }
			 else if(StringUtils.isAlpha(wantedQuantity3))
			 {
				 errors.add("wantedQuantity3",new ActionMessage("error.wantedQuantity3.alpha")); 
			 }
//			 For wantedQuantity4 property	 
			 if(!(StringUtils.isNumeric(wantedQuantity4)))
			 {
				 errors.add("wantedQuantity4",new ActionMessage("error.wantedQuantity4.nonumeric")); 
			 }
			 else if(StringUtils.isAlpha(wantedQuantity4))
			 {
				 errors.add("wantedQuantity4",new ActionMessage("error.wantedQuantity4.alpha")); 
			 }
//			 For wantedQuantity5 property	 
			 if(!(StringUtils.isNumeric(wantedQuantity5)))
			 {
				 errors.add("wantedQuantity5",new ActionMessage("error.wantedQuantity5.nonumeric")); 
			 }
			 else if(StringUtils.isAlpha(wantedQuantity5))
			 {
				 errors.add("wantedQuantity5",new ActionMessage("error.wantedQuantity5.alpha")); 
			 }*/
			 
//			 For presentKm property	 
			 if(StringUtils.isEmpty(currentKM))
			 {
				 errors.add("currentKM",new ActionMessage("error.currentKM.required")); 
			 }
			 else if(!(StringUtils.isNumeric(currentKM)))
				{
					errors.add("currentKM",new ActionMessage("error.currentKM.noalpha"));
				}
// 			For remark property		 
			 
			return errors; 
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
	
}
