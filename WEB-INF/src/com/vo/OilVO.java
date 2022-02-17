package com.vo;

public class OilVO {
	
	private String instId;
	private String instDesc;
	private String typeId;
	private String typeDesc;
	private String vehicleId;
	private String vehicleDesc;
	private String oilId;
	private String oilDesc;
	private String oilReasonId;
	private String oilReasonDesc;
	
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
	
	private String currentKM=null;
	private String previousServicedKM=null;
	private String differenceKM=null;
	private String extraQty;
	private String extraRate;
	private String reorderLevel;
	
	/**
	 * @return the reorderLevel
	 */
	public String getReorderLevel() {
		return reorderLevel;
	}
	/**
	 * @param reorderLevel the reorderLevel to set
	 */
	public void setReorderLevel(String reorderLevel) {
		this.reorderLevel = reorderLevel;
	}
	/**
	 * @return the extraQty
	 */
	public String getExtraQty() {
		return extraQty;
	}
	/**
	 * @param extraQty the extraQty to set
	 */
	public void setExtraQty(String extraQty) {
		this.extraQty = extraQty;
	}
	/**
	 * @return the extraRate
	 */
	public String getExtraRate() {
		return extraRate;
	}
	/**
	 * @param extraRate the extraRate to set
	 */
	public void setExtraRate(String extraRate) {
		this.extraRate = extraRate;
	}
	public String getBillNumber() {
		return billNumber;
	}
	public void setBillNumber(String billNumber) {
		this.billNumber = billNumber;
	}
	public String getCurrentKM() {
		return currentKM;
	}
	public void setCurrentKM(String currentKM) {
		this.currentKM = currentKM;
	}
	public String getDifferenceKM() {
		return differenceKM;
	}
	public void setDifferenceKM(String differenceKM) {
		this.differenceKM = differenceKM;
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
	public String getNewAvailable1() {
		return newAvailable1;
	}
	public void setNewAvailable1(String newAvailable1) {
		this.newAvailable1 = newAvailable1;
	}
	public String getNewAvailable2() {
		return newAvailable2;
	}
	public void setNewAvailable2(String newAvailable2) {
		this.newAvailable2 = newAvailable2;
	}
	public String getNewAvailable3() {
		return newAvailable3;
	}
	public void setNewAvailable3(String newAvailable3) {
		this.newAvailable3 = newAvailable3;
	}
	public String getNewAvailable4() {
		return newAvailable4;
	}
	public void setNewAvailable4(String newAvailable4) {
		this.newAvailable4 = newAvailable4;
	}
	public String getNewAvailable5() {
		return newAvailable5;
	}
	public void setNewAvailable5(String newAvailable5) {
		this.newAvailable5 = newAvailable5;
	}
	public String getNewRate1() {
		return newRate1;
	}
	public void setNewRate1(String newRate1) {
		this.newRate1 = newRate1;
	}
	public String getNewRate2() {
		return newRate2;
	}
	public void setNewRate2(String newRate2) {
		this.newRate2 = newRate2;
	}
	public String getNewRate3() {
		return newRate3;
	}
	public void setNewRate3(String newRate3) {
		this.newRate3 = newRate3;
	}
	public String getNewRate4() {
		return newRate4;
	}
	public void setNewRate4(String newRate4) {
		this.newRate4 = newRate4;
	}
	public String getNewRate5() {
		return newRate5;
	}
	public void setNewRate5(String newRate5) {
		this.newRate5 = newRate5;
	}
	public String getOilReason1() {
		return oilReason1;
	}
	public void setOilReason1(String oilReason1) {
		this.oilReason1 = oilReason1;
	}
	public String getOilReason2() {
		return oilReason2;
	}
	public void setOilReason2(String oilReason2) {
		this.oilReason2 = oilReason2;
	}
	public String getOilReason3() {
		return oilReason3;
	}
	public void setOilReason3(String oilReason3) {
		this.oilReason3 = oilReason3;
	}
	public String getOilReason4() {
		return oilReason4;
	}
	public void setOilReason4(String oilReason4) {
		this.oilReason4 = oilReason4;
	}
	public String getOilReason5() {
		return oilReason5;
	}
	public void setOilReason5(String oilReason5) {
		this.oilReason5 = oilReason5;
	}
	public String getOilType1() {
		return oilType1;
	}
	public void setOilType1(String oilType1) {
		this.oilType1 = oilType1;
	}
	public String getOilType2() {
		return oilType2;
	}
	public void setOilType2(String oilType2) {
		this.oilType2 = oilType2;
	}
	public String getOilType3() {
		return oilType3;
	}
	public void setOilType3(String oilType3) {
		this.oilType3 = oilType3;
	}
	public String getOilType4() {
		return oilType4;
	}
	public void setOilType4(String oilType4) {
		this.oilType4 = oilType4;
	}
	public String getOilType5() {
		return oilType5;
	}
	public void setOilType5(String oilType5) {
		this.oilType5 = oilType5;
	}
	public String getOldAvailable1() {
		return oldAvailable1;
	}
	public void setOldAvailable1(String oldAvailable1) {
		this.oldAvailable1 = oldAvailable1;
	}
	public String getOldAvailable2() {
		return oldAvailable2;
	}
	public void setOldAvailable2(String oldAvailable2) {
		this.oldAvailable2 = oldAvailable2;
	}
	public String getOldAvailable3() {
		return oldAvailable3;
	}
	public void setOldAvailable3(String oldAvailable3) {
		this.oldAvailable3 = oldAvailable3;
	}
	public String getOldAvailable4() {
		return oldAvailable4;
	}
	public void setOldAvailable4(String oldAvailable4) {
		this.oldAvailable4 = oldAvailable4;
	}
	public String getOldAvailable5() {
		return oldAvailable5;
	}
	public void setOldAvailable5(String oldAvailable5) {
		this.oldAvailable5 = oldAvailable5;
	}
	public String getOldRate1() {
		return oldRate1;
	}
	public void setOldRate1(String oldRate1) {
		this.oldRate1 = oldRate1;
	}
	public String getOldRate2() {
		return oldRate2;
	}
	public void setOldRate2(String oldRate2) {
		this.oldRate2 = oldRate2;
	}
	public String getOldRate3() {
		return oldRate3;
	}
	public void setOldRate3(String oldRate3) {
		this.oldRate3 = oldRate3;
	}
	public String getOldRate4() {
		return oldRate4;
	}
	public void setOldRate4(String oldRate4) {
		this.oldRate4 = oldRate4;
	}
	public String getOldRate5() {
		return oldRate5;
	}
	public void setOldRate5(String oldRate5) {
		this.oldRate5 = oldRate5;
	}
	public String getOtherPurpose() {
		return otherPurpose;
	}
	public void setOtherPurpose(String otherPurpose) {
		this.otherPurpose = otherPurpose;
	}
	public String getPreviousServicedKM() {
		return previousServicedKM;
	}
	public void setPreviousServicedKM(String previousServicedKM) {
		this.previousServicedKM = previousServicedKM;
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
	public String getTotalAmount1() {
		return totalAmount1;
	}
	public void setTotalAmount1(String totalAmount1) {
		this.totalAmount1 = totalAmount1;
	}
	public String getTotalAmount2() {
		return totalAmount2;
	}
	public void setTotalAmount2(String totalAmount2) {
		this.totalAmount2 = totalAmount2;
	}
	public String getTotalAmount3() {
		return totalAmount3;
	}
	public void setTotalAmount3(String totalAmount3) {
		this.totalAmount3 = totalAmount3;
	}
	public String getTotalAmount4() {
		return totalAmount4;
	}
	public void setTotalAmount4(String totalAmount4) {
		this.totalAmount4 = totalAmount4;
	}
	public String getTotalAmount5() {
		return totalAmount5;
	}
	public void setTotalAmount5(String totalAmount5) {
		this.totalAmount5 = totalAmount5;
	}
	public String getTotalAvailableQuantity1() {
		return totalAvailableQuantity1;
	}
	public void setTotalAvailableQuantity1(String totalAvailableQuantity1) {
		this.totalAvailableQuantity1 = totalAvailableQuantity1;
	}
	public String getTotalAvailableQuantity2() {
		return totalAvailableQuantity2;
	}
	public void setTotalAvailableQuantity2(String totalAvailableQuantity2) {
		this.totalAvailableQuantity2 = totalAvailableQuantity2;
	}
	public String getTotalAvailableQuantity3() {
		return totalAvailableQuantity3;
	}
	public void setTotalAvailableQuantity3(String totalAvailableQuantity3) {
		this.totalAvailableQuantity3 = totalAvailableQuantity3;
	}
	public String getTotalAvailableQuantity4() {
		return totalAvailableQuantity4;
	}
	public void setTotalAvailableQuantity4(String totalAvailableQuantity4) {
		this.totalAvailableQuantity4 = totalAvailableQuantity4;
	}
	public String getTotalAvailableQuantity5() {
		return totalAvailableQuantity5;
	}
	public void setTotalAvailableQuantity5(String totalAvailableQuantity5) {
		this.totalAvailableQuantity5 = totalAvailableQuantity5;
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
	public String getWantedQuantity1() {
		return wantedQuantity1;
	}
	public void setWantedQuantity1(String wantedQuantity1) {
		this.wantedQuantity1 = wantedQuantity1;
	}
	public String getWantedQuantity2() {
		return wantedQuantity2;
	}
	public void setWantedQuantity2(String wantedQuantity2) {
		this.wantedQuantity2 = wantedQuantity2;
	}
	public String getWantedQuantity3() {
		return wantedQuantity3;
	}
	public void setWantedQuantity3(String wantedQuantity3) {
		this.wantedQuantity3 = wantedQuantity3;
	}
	public String getWantedQuantity4() {
		return wantedQuantity4;
	}
	public void setWantedQuantity4(String wantedQuantity4) {
		this.wantedQuantity4 = wantedQuantity4;
	}
	public String getWantedQuantity5() {
		return wantedQuantity5;
	}
	public void setWantedQuantity5(String wantedQuantity5) {
		this.wantedQuantity5 = wantedQuantity5;
	}
	public String getInstDesc() {
		return instDesc;
	}
	public void setInstDesc(String instDesc) {
		this.instDesc = instDesc;
	}
	public String getInstId() {
		return instId;
	}
	public void setInstId(String instId) {
		this.instId = instId;
	}
	public String getTypeDesc() {
		return typeDesc;
	}
	public void setTypeDesc(String typeDesc) {
		this.typeDesc = typeDesc;
	}
	public String getTypeId() {
		return typeId;
	}
	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}
	public String getVehicleDesc() {
		return vehicleDesc;
	}
	public void setVehicleDesc(String vehicleDesc) {
		this.vehicleDesc = vehicleDesc;
	}
	public String getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getOilDesc() {
		return oilDesc;
	}
	public void setOilDesc(String oilDesc) {
		this.oilDesc = oilDesc;
	}
	public String getOilId() {
		return oilId;
	}
	public void setOilId(String oilId) {
		this.oilId = oilId;
	}
	public String getOilReasonDesc() {
		return oilReasonDesc;
	}
	public void setOilReasonDesc(String oilReasonDesc) {
		this.oilReasonDesc = oilReasonDesc;
	}
	public String getOilReasonId() {
		return oilReasonId;
	}
	public void setOilReasonId(String oilReasonId) {
		this.oilReasonId = oilReasonId;
	}
}
