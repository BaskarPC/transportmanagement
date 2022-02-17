package com.vo;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.formbean.PaintForm;

public class PaintIssueVO {
	private static final Logger logger=(Logger)Logger.getLogger(PaintIssueVO.class);
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
	private String paintType1;
	private String paintType2;
	private String paintType3;
	private String paintType4;
	private String paintType5;
	private String paintType6;
	private String paintType7;
	private String paintType8;
	private String paintType9;
	private String paintType10;
	
	private String paintColor1;
	private String paintColor2;
	private String paintColor3;
	private String paintColor4;
	private String paintColor5;
	private String paintColor6;
	private String paintColor7;
	private String paintColor8;
	private String paintColor9;
	private String paintColor10;

	private String totalAvailableQuantity1;
	private String totalAvailableQuantity2;
	private String totalAvailableQuantity3;
	private String totalAvailableQuantity4;
	private String totalAvailableQuantity5;
	private String totalAvailableQuantity6;
	private String totalAvailableQuantity7;
	private String totalAvailableQuantity8;
	private String totalAvailableQuantity9;
	private String totalAvailableQuantity10;
	
	private String wantedQuantity1;
	private String wantedQuantity2;
	private String wantedQuantity3;
	private String wantedQuantity4;
	private String wantedQuantity5;
	private String wantedQuantity6;
	private String wantedQuantity7;
	private String wantedQuantity8;
	private String wantedQuantity9;
	private String wantedQuantity10;

	private String oldAvailable1;
	private String oldAvailable2;
	private String oldAvailable3;
	private String oldAvailable4;
	private String oldAvailable5;
	private String oldAvailable6;
	private String oldAvailable7;
	private String oldAvailable8;
	private String oldAvailable9;
	private String oldAvailable10;

	private String newAvailable1;
	private String newAvailable2;
	private String newAvailable3;
	private String newAvailable4;
	private String newAvailable5;
	private String newAvailable6;
	private String newAvailable7;
	private String newAvailable8;
	private String newAvailable9;
	private String newAvailable10;
	
	private String oldRate1;
	private String oldRate2;
	private String oldRate3;
	private String oldRate4;
	private String oldRate5;
	private String oldRate6;
	private String oldRate7;
	private String oldRate8;
	private String oldRate9;
	private String oldRate10;
	
	private String newRate1;
	private String newRate2;
	private String newRate3;
	private String newRate4;
	private String newRate5;
	private String newRate6;
	private String newRate7;
	private String newRate8;
	private String newRate9;
	private String newRate10;

	private String totalAmount1;
	private String totalAmount2;
	private String totalAmount3;
	private String totalAmount4;
	private String totalAmount5;
	private String totalAmount6;
	private String totalAmount7;
	private String totalAmount8;
	private String totalAmount9;
	private String totalAmount10;
	
	
	private String paintId;
	private String paintType;
	private String paintColor;
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
	public String getNewAvailable1() {
		return newAvailable1;
	}
	public void setNewAvailable1(String newAvailable1) {
		this.newAvailable1 = newAvailable1;
	}
	public String getNewAvailable10() {
		return newAvailable10;
	}
	public void setNewAvailable10(String newAvailable10) {
		this.newAvailable10 = newAvailable10;
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
	public String getNewAvailable6() {
		return newAvailable6;
	}
	public void setNewAvailable6(String newAvailable6) {
		this.newAvailable6 = newAvailable6;
	}
	public String getNewAvailable7() {
		return newAvailable7;
	}
	public void setNewAvailable7(String newAvailable7) {
		this.newAvailable7 = newAvailable7;
	}
	public String getNewAvailable8() {
		return newAvailable8;
	}
	public void setNewAvailable8(String newAvailable8) {
		this.newAvailable8 = newAvailable8;
	}
	public String getNewAvailable9() {
		return newAvailable9;
	}
	public void setNewAvailable9(String newAvailable9) {
		this.newAvailable9 = newAvailable9;
	}
	public String getNewRate1() {
		return newRate1;
	}
	public void setNewRate1(String newRate1) {
		this.newRate1 = newRate1;
	}
	public String getNewRate10() {
		return newRate10;
	}
	public void setNewRate10(String newRate10) {
		this.newRate10 = newRate10;
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
	public String getNewRate6() {
		return newRate6;
	}
	public void setNewRate6(String newRate6) {
		this.newRate6 = newRate6;
	}
	public String getNewRate7() {
		return newRate7;
	}
	public void setNewRate7(String newRate7) {
		this.newRate7 = newRate7;
	}
	public String getNewRate8() {
		return newRate8;
	}
	public void setNewRate8(String newRate8) {
		this.newRate8 = newRate8;
	}
	public String getNewRate9() {
		return newRate9;
	}
	public void setNewRate9(String newRate9) {
		this.newRate9 = newRate9;
	}
	public String getOldAvailable1() {
		return oldAvailable1;
	}
	public void setOldAvailable1(String oldAvailable1) {
		this.oldAvailable1 = oldAvailable1;
	}
	public String getOldAvailable10() {
		return oldAvailable10;
	}
	public void setOldAvailable10(String oldAvailable10) {
		this.oldAvailable10 = oldAvailable10;
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
	public String getOldAvailable6() {
		return oldAvailable6;
	}
	public void setOldAvailable6(String oldAvailable6) {
		this.oldAvailable6 = oldAvailable6;
	}
	public String getOldAvailable7() {
		return oldAvailable7;
	}
	public void setOldAvailable7(String oldAvailable7) {
		this.oldAvailable7 = oldAvailable7;
	}
	public String getOldAvailable8() {
		return oldAvailable8;
	}
	public void setOldAvailable8(String oldAvailable8) {
		this.oldAvailable8 = oldAvailable8;
	}
	public String getOldAvailable9() {
		return oldAvailable9;
	}
	public void setOldAvailable9(String oldAvailable9) {
		this.oldAvailable9 = oldAvailable9;
	}
	public String getOldRate1() {
		return oldRate1;
	}
	public void setOldRate1(String oldRate1) {
		this.oldRate1 = oldRate1;
	}
	public String getOldRate10() {
		return oldRate10;
	}
	public void setOldRate10(String oldRate10) {
		this.oldRate10 = oldRate10;
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
	public String getOldRate6() {
		return oldRate6;
	}
	public void setOldRate6(String oldRate6) {
		this.oldRate6 = oldRate6;
	}
	public String getOldRate7() {
		return oldRate7;
	}
	public void setOldRate7(String oldRate7) {
		this.oldRate7 = oldRate7;
	}
	public String getOldRate8() {
		return oldRate8;
	}
	public void setOldRate8(String oldRate8) {
		this.oldRate8 = oldRate8;
	}
	public String getOldRate9() {
		return oldRate9;
	}
	public void setOldRate9(String oldRate9) {
		this.oldRate9 = oldRate9;
	}
	public String getOtherPurpose() {
		return otherPurpose;
	}
	public void setOtherPurpose(String otherPurpose) {
		this.otherPurpose = otherPurpose;
	}
	public String getPaintColor1() {
		return paintColor1;
	}
	public void setPaintColor1(String paintColor1) {
		this.paintColor1 = paintColor1;
	}
	public String getPaintColor10() {
		return paintColor10;
	}
	public void setPaintColor10(String paintColor10) {
		this.paintColor10 = paintColor10;
	}
	public String getPaintColor2() {
		return paintColor2;
	}
	public void setPaintColor2(String paintColor2) {
		this.paintColor2 = paintColor2;
	}
	public String getPaintColor3() {
		return paintColor3;
	}
	public void setPaintColor3(String paintColor3) {
		this.paintColor3 = paintColor3;
	}
	public String getPaintColor4() {
		return paintColor4;
	}
	public void setPaintColor4(String paintColor4) {
		this.paintColor4 = paintColor4;
	}
	public String getPaintColor5() {
		return paintColor5;
	}
	public void setPaintColor5(String paintColor5) {
		this.paintColor5 = paintColor5;
	}
	public String getPaintColor6() {
		return paintColor6;
	}
	public void setPaintColor6(String paintColor6) {
		this.paintColor6 = paintColor6;
	}
	public String getPaintColor7() {
		return paintColor7;
	}
	public void setPaintColor7(String paintColor7) {
		this.paintColor7 = paintColor7;
	}
	public String getPaintColor8() {
		return paintColor8;
	}
	public void setPaintColor8(String paintColor8) {
		this.paintColor8 = paintColor8;
	}
	public String getPaintColor9() {
		return paintColor9;
	}
	public void setPaintColor9(String paintColor9) {
		this.paintColor9 = paintColor9;
	}
	public String getPaintType1() {
		return paintType1;
	}
	public void setPaintType1(String paintType1) {
		this.paintType1 = paintType1;
	}
	public String getPaintType10() {
		return paintType10;
	}
	public void setPaintType10(String paintType10) {
		this.paintType10 = paintType10;
	}
	public String getPaintType2() {
		return paintType2;
	}
	public void setPaintType2(String paintType2) {
		this.paintType2 = paintType2;
	}
	public String getPaintType3() {
		return paintType3;
	}
	public void setPaintType3(String paintType3) {
		this.paintType3 = paintType3;
	}
	public String getPaintType4() {
		return paintType4;
	}
	public void setPaintType4(String paintType4) {
		this.paintType4 = paintType4;
	}
	public String getPaintType5() {
		return paintType5;
	}
	public void setPaintType5(String paintType5) {
		this.paintType5 = paintType5;
	}
	public String getPaintType6() {
		return paintType6;
	}
	public void setPaintType6(String paintType6) {
		this.paintType6 = paintType6;
	}
	public String getPaintType7() {
		return paintType7;
	}
	public void setPaintType7(String paintType7) {
		this.paintType7 = paintType7;
	}
	public String getPaintType8() {
		return paintType8;
	}
	public void setPaintType8(String paintType8) {
		this.paintType8 = paintType8;
	}
	public String getPaintType9() {
		return paintType9;
	}
	public void setPaintType9(String paintType9) {
		this.paintType9 = paintType9;
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
	public String getTotalAmount10() {
		return totalAmount10;
	}
	public void setTotalAmount10(String totalAmount10) {
		this.totalAmount10 = totalAmount10;
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
	public String getTotalAmount6() {
		return totalAmount6;
	}
	public void setTotalAmount6(String totalAmount6) {
		this.totalAmount6 = totalAmount6;
	}
	public String getTotalAmount7() {
		return totalAmount7;
	}
	public void setTotalAmount7(String totalAmount7) {
		this.totalAmount7 = totalAmount7;
	}
	public String getTotalAmount8() {
		return totalAmount8;
	}
	public void setTotalAmount8(String totalAmount8) {
		this.totalAmount8 = totalAmount8;
	}
	public String getTotalAmount9() {
		return totalAmount9;
	}
	public void setTotalAmount9(String totalAmount9) {
		this.totalAmount9 = totalAmount9;
	}
	public String getTotalAvailableQuantity1() {
		return totalAvailableQuantity1;
	}
	public void setTotalAvailableQuantity1(String totalAvailableQuantity1) {
		this.totalAvailableQuantity1 = totalAvailableQuantity1;
	}
	public String getTotalAvailableQuantity10() {
		return totalAvailableQuantity10;
	}
	public void setTotalAvailableQuantity10(String totalAvailableQuantity10) {
		this.totalAvailableQuantity10 = totalAvailableQuantity10;
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
	public String getTotalAvailableQuantity6() {
		return totalAvailableQuantity6;
	}
	public void setTotalAvailableQuantity6(String totalAvailableQuantity6) {
		this.totalAvailableQuantity6 = totalAvailableQuantity6;
	}
	public String getTotalAvailableQuantity7() {
		return totalAvailableQuantity7;
	}
	public void setTotalAvailableQuantity7(String totalAvailableQuantity7) {
		this.totalAvailableQuantity7 = totalAvailableQuantity7;
	}
	public String getTotalAvailableQuantity8() {
		return totalAvailableQuantity8;
	}
	public void setTotalAvailableQuantity8(String totalAvailableQuantity8) {
		this.totalAvailableQuantity8 = totalAvailableQuantity8;
	}
	public String getTotalAvailableQuantity9() {
		return totalAvailableQuantity9;
	}
	public void setTotalAvailableQuantity9(String totalAvailableQuantity9) {
		this.totalAvailableQuantity9 = totalAvailableQuantity9;
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
	public String getWantedQuantity1() {
		return wantedQuantity1;
	}
	public void setWantedQuantity1(String wantedQuantity1) {
		this.wantedQuantity1 = wantedQuantity1;
	}
	public String getWantedQuantity10() {
		return wantedQuantity10;
	}
	public void setWantedQuantity10(String wantedQuantity10) {
		this.wantedQuantity10 = wantedQuantity10;
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
	public String getWantedQuantity6() {
		return wantedQuantity6;
	}
	public void setWantedQuantity6(String wantedQuantity6) {
		this.wantedQuantity6 = wantedQuantity6;
	}
	public String getWantedQuantity7() {
		return wantedQuantity7;
	}
	public void setWantedQuantity7(String wantedQuantity7) {
		this.wantedQuantity7 = wantedQuantity7;
	}
	public String getWantedQuantity8() {
		return wantedQuantity8;
	}
	public void setWantedQuantity8(String wantedQuantity8) {
		this.wantedQuantity8 = wantedQuantity8;
	}
	public String getWantedQuantity9() {
		return wantedQuantity9;
	}
	public void setWantedQuantity9(String wantedQuantity9) {
		this.wantedQuantity9 = wantedQuantity9;
	}
	/**
	 * @return the paintColor
	 */
	public String getPaintColor() {
		return paintColor;
	}
	/**
	 * @param paintColor the paintColor to set
	 */
	public void setPaintColor(String paintColor) {
		this.paintColor = paintColor;
	}
	/**
	 * @return the paintId
	 */
	public String getPaintId() {
		return paintId;
	}
	/**
	 * @param paintId the paintId to set
	 */
	public void setPaintId(String paintId) {
		this.paintId = paintId;
	}
	/**
	 * @return the paintType
	 */
	public String getPaintType() {
		return paintType;
	}
	/**
	 * @param paintType the paintType to set
	 */
	public void setPaintType(String paintType) {
		this.paintType = paintType;
	}
}
