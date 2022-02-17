package com.vo;

import org.apache.log4j.Logger;

public class SparePartsFormVO {
private static final Logger logger=(Logger)Logger.getLogger(SparePartsFormVO.class);

	private String instId;
	private String instDesc;
	private String typeId;
	private String typeDesc;
	private String vehicleId;
	private String vehicleDesc;
	private String driverName;
	private String institutionName=null;
	private String vehicleType=null;
	private String vehicleNumber=null;
	private String requestedDriverName=null;
	private String billNumber=null;
	private String requestedDate=null;
	private String otherPurpose=null;

	private String spareId;
	private String spareType;
	private String partId; 
	private String sparepartNumber;
	private String oldQuantity;
	private String newQuantity;
	private String neededSpares;

	private String extraQty;
	private String extraRate;
	private String reorderLevel;
	
	private String itemDescription1;
	private String itemDescription2;
	private String itemDescription3;
	private String itemDescription4;
	private String itemDescription5;
	private String itemDescription6;
	private String itemDescription7;
	private String itemDescription8;
	private String itemDescription9;
	private String itemDescription10;
	
	private String partNumber1;
	private String partNumber2;
	private String partNumber3;
	private String partNumber4;
	private String partNumber5;
	private String partNumber6;
	private String partNumber7;
	private String partNumber8;
	private String partNumber9;
	private String partNumber10;

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
	
	/**
	 * @return the itemDescription1
	 */
	public String getItemDescription1() {
		return itemDescription1;
	}
	/**
	 * @param itemDescription1 the itemDescription1 to set
	 */
	public void setItemDescription1(String itemDescription1) {
		this.itemDescription1 = itemDescription1;
	}
	/**
	 * @return the itemDescription10
	 */
	public String getItemDescription10() {
		return itemDescription10;
	}
	/**
	 * @param itemDescription10 the itemDescription10 to set
	 */
	public void setItemDescription10(String itemDescription10) {
		this.itemDescription10 = itemDescription10;
	}
	/**
	 * @return the itemDescription2
	 */
	public String getItemDescription2() {
		return itemDescription2;
	}
	/**
	 * @param itemDescription2 the itemDescription2 to set
	 */
	public void setItemDescription2(String itemDescription2) {
		this.itemDescription2 = itemDescription2;
	}
	/**
	 * @return the itemDescription3
	 */
	public String getItemDescription3() {
		return itemDescription3;
	}
	/**
	 * @param itemDescription3 the itemDescription3 to set
	 */
	public void setItemDescription3(String itemDescription3) {
		this.itemDescription3 = itemDescription3;
	}
	/**
	 * @return the itemDescription4
	 */
	public String getItemDescription4() {
		return itemDescription4;
	}
	/**
	 * @param itemDescription4 the itemDescription4 to set
	 */
	public void setItemDescription4(String itemDescription4) {
		this.itemDescription4 = itemDescription4;
	}
	/**
	 * @return the itemDescription5
	 */
	public String getItemDescription5() {
		return itemDescription5;
	}
	/**
	 * @param itemDescription5 the itemDescription5 to set
	 */
	public void setItemDescription5(String itemDescription5) {
		this.itemDescription5 = itemDescription5;
	}
	/**
	 * @return the itemDescription6
	 */
	public String getItemDescription6() {
		return itemDescription6;
	}
	/**
	 * @param itemDescription6 the itemDescription6 to set
	 */
	public void setItemDescription6(String itemDescription6) {
		this.itemDescription6 = itemDescription6;
	}
	/**
	 * @return the itemDescription7
	 */
	public String getItemDescription7() {
		return itemDescription7;
	}
	/**
	 * @param itemDescription7 the itemDescription7 to set
	 */
	public void setItemDescription7(String itemDescription7) {
		this.itemDescription7 = itemDescription7;
	}
	/**
	 * @return the itemDescription8
	 */
	public String getItemDescription8() {
		return itemDescription8;
	}
	/**
	 * @param itemDescription8 the itemDescription8 to set
	 */
	public void setItemDescription8(String itemDescription8) {
		this.itemDescription8 = itemDescription8;
	}
	/**
	 * @return the itemDescription9
	 */
	public String getItemDescription9() {
		return itemDescription9;
	}
	/**
	 * @param itemDescription9 the itemDescription9 to set
	 */
	public void setItemDescription9(String itemDescription9) {
		this.itemDescription9 = itemDescription9;
	}
	/**
	 * @return the neededSpares
	 */
	public String getNeededSpares() {
		return neededSpares;
	}
	/**
	 * @param neededSpares the neededSpares to set
	 */
	public void setNeededSpares(String neededSpares) {
		this.neededSpares = neededSpares;
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
	 * @return the newAvailable10
	 */
	public String getNewAvailable10() {
		return newAvailable10;
	}
	/**
	 * @param newAvailable10 the newAvailable10 to set
	 */
	public void setNewAvailable10(String newAvailable10) {
		this.newAvailable10 = newAvailable10;
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
	 * @return the newAvailable6
	 */
	public String getNewAvailable6() {
		return newAvailable6;
	}
	/**
	 * @param newAvailable6 the newAvailable6 to set
	 */
	public void setNewAvailable6(String newAvailable6) {
		this.newAvailable6 = newAvailable6;
	}
	/**
	 * @return the newAvailable7
	 */
	public String getNewAvailable7() {
		return newAvailable7;
	}
	/**
	 * @param newAvailable7 the newAvailable7 to set
	 */
	public void setNewAvailable7(String newAvailable7) {
		this.newAvailable7 = newAvailable7;
	}
	/**
	 * @return the newAvailable8
	 */
	public String getNewAvailable8() {
		return newAvailable8;
	}
	/**
	 * @param newAvailable8 the newAvailable8 to set
	 */
	public void setNewAvailable8(String newAvailable8) {
		this.newAvailable8 = newAvailable8;
	}
	/**
	 * @return the newAvailable9
	 */
	public String getNewAvailable9() {
		return newAvailable9;
	}
	/**
	 * @param newAvailable9 the newAvailable9 to set
	 */
	public void setNewAvailable9(String newAvailable9) {
		this.newAvailable9 = newAvailable9;
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
	 * @return the newRate10
	 */
	public String getNewRate10() {
		return newRate10;
	}
	/**
	 * @param newRate10 the newRate10 to set
	 */
	public void setNewRate10(String newRate10) {
		this.newRate10 = newRate10;
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
	 * @return the newRate6
	 */
	public String getNewRate6() {
		return newRate6;
	}
	/**
	 * @param newRate6 the newRate6 to set
	 */
	public void setNewRate6(String newRate6) {
		this.newRate6 = newRate6;
	}
	/**
	 * @return the newRate7
	 */
	public String getNewRate7() {
		return newRate7;
	}
	/**
	 * @param newRate7 the newRate7 to set
	 */
	public void setNewRate7(String newRate7) {
		this.newRate7 = newRate7;
	}
	/**
	 * @return the newRate8
	 */
	public String getNewRate8() {
		return newRate8;
	}
	/**
	 * @param newRate8 the newRate8 to set
	 */
	public void setNewRate8(String newRate8) {
		this.newRate8 = newRate8;
	}
	/**
	 * @return the newRate9
	 */
	public String getNewRate9() {
		return newRate9;
	}
	/**
	 * @param newRate9 the newRate9 to set
	 */
	public void setNewRate9(String newRate9) {
		this.newRate9 = newRate9;
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
	 * @return the oldAvailable10
	 */
	public String getOldAvailable10() {
		return oldAvailable10;
	}
	/**
	 * @param oldAvailable10 the oldAvailable10 to set
	 */
	public void setOldAvailable10(String oldAvailable10) {
		this.oldAvailable10 = oldAvailable10;
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
	 * @return the oldAvailable6
	 */
	public String getOldAvailable6() {
		return oldAvailable6;
	}
	/**
	 * @param oldAvailable6 the oldAvailable6 to set
	 */
	public void setOldAvailable6(String oldAvailable6) {
		this.oldAvailable6 = oldAvailable6;
	}
	/**
	 * @return the oldAvailable7
	 */
	public String getOldAvailable7() {
		return oldAvailable7;
	}
	/**
	 * @param oldAvailable7 the oldAvailable7 to set
	 */
	public void setOldAvailable7(String oldAvailable7) {
		this.oldAvailable7 = oldAvailable7;
	}
	/**
	 * @return the oldAvailable8
	 */
	public String getOldAvailable8() {
		return oldAvailable8;
	}
	/**
	 * @param oldAvailable8 the oldAvailable8 to set
	 */
	public void setOldAvailable8(String oldAvailable8) {
		this.oldAvailable8 = oldAvailable8;
	}
	/**
	 * @return the oldAvailable9
	 */
	public String getOldAvailable9() {
		return oldAvailable9;
	}
	/**
	 * @param oldAvailable9 the oldAvailable9 to set
	 */
	public void setOldAvailable9(String oldAvailable9) {
		this.oldAvailable9 = oldAvailable9;
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
	 * @return the oldRate10
	 */
	public String getOldRate10() {
		return oldRate10;
	}
	/**
	 * @param oldRate10 the oldRate10 to set
	 */
	public void setOldRate10(String oldRate10) {
		this.oldRate10 = oldRate10;
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
	 * @return the oldRate6
	 */
	public String getOldRate6() {
		return oldRate6;
	}
	/**
	 * @param oldRate6 the oldRate6 to set
	 */
	public void setOldRate6(String oldRate6) {
		this.oldRate6 = oldRate6;
	}
	/**
	 * @return the oldRate7
	 */
	public String getOldRate7() {
		return oldRate7;
	}
	/**
	 * @param oldRate7 the oldRate7 to set
	 */
	public void setOldRate7(String oldRate7) {
		this.oldRate7 = oldRate7;
	}
	/**
	 * @return the oldRate8
	 */
	public String getOldRate8() {
		return oldRate8;
	}
	/**
	 * @param oldRate8 the oldRate8 to set
	 */
	public void setOldRate8(String oldRate8) {
		this.oldRate8 = oldRate8;
	}
	/**
	 * @return the oldRate9
	 */
	public String getOldRate9() {
		return oldRate9;
	}
	/**
	 * @param oldRate9 the oldRate9 to set
	 */
	public void setOldRate9(String oldRate9) {
		this.oldRate9 = oldRate9;
	}
	/**
	 * @return the partNumber1
	 */
	public String getPartNumber1() {
		return partNumber1;
	}
	/**
	 * @param partNumber1 the partNumber1 to set
	 */
	public void setPartNumber1(String partNumber1) {
		this.partNumber1 = partNumber1;
	}
	/**
	 * @return the partNumber10
	 */
	public String getPartNumber10() {
		return partNumber10;
	}
	/**
	 * @param partNumber10 the partNumber10 to set
	 */
	public void setPartNumber10(String partNumber10) {
		this.partNumber10 = partNumber10;
	}
	/**
	 * @return the partNumber2
	 */
	public String getPartNumber2() {
		return partNumber2;
	}
	/**
	 * @param partNumber2 the partNumber2 to set
	 */
	public void setPartNumber2(String partNumber2) {
		this.partNumber2 = partNumber2;
	}
	/**
	 * @return the partNumber3
	 */
	public String getPartNumber3() {
		return partNumber3;
	}
	/**
	 * @param partNumber3 the partNumber3 to set
	 */
	public void setPartNumber3(String partNumber3) {
		this.partNumber3 = partNumber3;
	}
	/**
	 * @return the partNumber4
	 */
	public String getPartNumber4() {
		return partNumber4;
	}
	/**
	 * @param partNumber4 the partNumber4 to set
	 */
	public void setPartNumber4(String partNumber4) {
		this.partNumber4 = partNumber4;
	}
	/**
	 * @return the partNumber5
	 */
	public String getPartNumber5() {
		return partNumber5;
	}
	/**
	 * @param partNumber5 the partNumber5 to set
	 */
	public void setPartNumber5(String partNumber5) {
		this.partNumber5 = partNumber5;
	}
	/**
	 * @return the partNumber6
	 */
	public String getPartNumber6() {
		return partNumber6;
	}
	/**
	 * @param partNumber6 the partNumber6 to set
	 */
	public void setPartNumber6(String partNumber6) {
		this.partNumber6 = partNumber6;
	}
	/**
	 * @return the partNumber7
	 */
	public String getPartNumber7() {
		return partNumber7;
	}
	/**
	 * @param partNumber7 the partNumber7 to set
	 */
	public void setPartNumber7(String partNumber7) {
		this.partNumber7 = partNumber7;
	}
	/**
	 * @return the partNumber8
	 */
	public String getPartNumber8() {
		return partNumber8;
	}
	/**
	 * @param partNumber8 the partNumber8 to set
	 */
	public void setPartNumber8(String partNumber8) {
		this.partNumber8 = partNumber8;
	}
	/**
	 * @return the partNumber9
	 */
	public String getPartNumber9() {
		return partNumber9;
	}
	/**
	 * @param partNumber9 the partNumber9 to set
	 */
	public void setPartNumber9(String partNumber9) {
		this.partNumber9 = partNumber9;
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
	 * @return the totalAmount10
	 */
	public String getTotalAmount10() {
		return totalAmount10;
	}
	/**
	 * @param totalAmount10 the totalAmount10 to set
	 */
	public void setTotalAmount10(String totalAmount10) {
		this.totalAmount10 = totalAmount10;
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
	 * @return the totalAmount6
	 */
	public String getTotalAmount6() {
		return totalAmount6;
	}
	/**
	 * @param totalAmount6 the totalAmount6 to set
	 */
	public void setTotalAmount6(String totalAmount6) {
		this.totalAmount6 = totalAmount6;
	}
	/**
	 * @return the totalAmount7
	 */
	public String getTotalAmount7() {
		return totalAmount7;
	}
	/**
	 * @param totalAmount7 the totalAmount7 to set
	 */
	public void setTotalAmount7(String totalAmount7) {
		this.totalAmount7 = totalAmount7;
	}
	/**
	 * @return the totalAmount8
	 */
	public String getTotalAmount8() {
		return totalAmount8;
	}
	/**
	 * @param totalAmount8 the totalAmount8 to set
	 */
	public void setTotalAmount8(String totalAmount8) {
		this.totalAmount8 = totalAmount8;
	}
	/**
	 * @return the totalAmount9
	 */
	public String getTotalAmount9() {
		return totalAmount9;
	}
	/**
	 * @param totalAmount9 the totalAmount9 to set
	 */
	public void setTotalAmount9(String totalAmount9) {
		this.totalAmount9 = totalAmount9;
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
	 * @return the totalAvailableQuantity10
	 */
	public String getTotalAvailableQuantity10() {
		return totalAvailableQuantity10;
	}
	/**
	 * @param totalAvailableQuantity10 the totalAvailableQuantity10 to set
	 */
	public void setTotalAvailableQuantity10(String totalAvailableQuantity10) {
		this.totalAvailableQuantity10 = totalAvailableQuantity10;
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
	 * @return the totalAvailableQuantity6
	 */
	public String getTotalAvailableQuantity6() {
		return totalAvailableQuantity6;
	}
	/**
	 * @param totalAvailableQuantity6 the totalAvailableQuantity6 to set
	 */
	public void setTotalAvailableQuantity6(String totalAvailableQuantity6) {
		this.totalAvailableQuantity6 = totalAvailableQuantity6;
	}
	/**
	 * @return the totalAvailableQuantity7
	 */
	public String getTotalAvailableQuantity7() {
		return totalAvailableQuantity7;
	}
	/**
	 * @param totalAvailableQuantity7 the totalAvailableQuantity7 to set
	 */
	public void setTotalAvailableQuantity7(String totalAvailableQuantity7) {
		this.totalAvailableQuantity7 = totalAvailableQuantity7;
	}
	/**
	 * @return the totalAvailableQuantity8
	 */
	public String getTotalAvailableQuantity8() {
		return totalAvailableQuantity8;
	}
	/**
	 * @param totalAvailableQuantity8 the totalAvailableQuantity8 to set
	 */
	public void setTotalAvailableQuantity8(String totalAvailableQuantity8) {
		this.totalAvailableQuantity8 = totalAvailableQuantity8;
	}
	/**
	 * @return the totalAvailableQuantity9
	 */
	public String getTotalAvailableQuantity9() {
		return totalAvailableQuantity9;
	}
	/**
	 * @param totalAvailableQuantity9 the totalAvailableQuantity9 to set
	 */
	public void setTotalAvailableQuantity9(String totalAvailableQuantity9) {
		this.totalAvailableQuantity9 = totalAvailableQuantity9;
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
	 * @return the wantedQuantity10
	 */
	public String getWantedQuantity10() {
		return wantedQuantity10;
	}
	/**
	 * @param wantedQuantity10 the wantedQuantity10 to set
	 */
	public void setWantedQuantity10(String wantedQuantity10) {
		this.wantedQuantity10 = wantedQuantity10;
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
	/**
	 * @return the wantedQuantity6
	 */
	public String getWantedQuantity6() {
		return wantedQuantity6;
	}
	/**
	 * @param wantedQuantity6 the wantedQuantity6 to set
	 */
	public void setWantedQuantity6(String wantedQuantity6) {
		this.wantedQuantity6 = wantedQuantity6;
	}
	/**
	 * @return the wantedQuantity7
	 */
	public String getWantedQuantity7() {
		return wantedQuantity7;
	}
	/**
	 * @param wantedQuantity7 the wantedQuantity7 to set
	 */
	public void setWantedQuantity7(String wantedQuantity7) {
		this.wantedQuantity7 = wantedQuantity7;
	}
	/**
	 * @return the wantedQuantity8
	 */
	public String getWantedQuantity8() {
		return wantedQuantity8;
	}
	/**
	 * @param wantedQuantity8 the wantedQuantity8 to set
	 */
	public void setWantedQuantity8(String wantedQuantity8) {
		this.wantedQuantity8 = wantedQuantity8;
	}
	/**
	 * @return the wantedQuantity9
	 */
	public String getWantedQuantity9() {
		return wantedQuantity9;
	}
	/**
	 * @param wantedQuantity9 the wantedQuantity9 to set
	 */
	public void setWantedQuantity9(String wantedQuantity9) {
		this.wantedQuantity9 = wantedQuantity9;
	}
	/**
	 * @return the billNumber
	 */
	public String getBillNumber() {
		logger.debug("number"+billNumber);
		return billNumber;
		
	}
	/**
	 * @param billNumber the billNumber to set
	 */
	public void setBillNumber(String billNumber) {
		
		this.billNumber = billNumber;
		logger.debug("number"+billNumber);
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
	
	
	public String getPartId() {
		return partId;
	}
	public void setPartId(String partId) {
		this.partId = partId;
	}
	/**
	 * @return the sparepartNumber
	 */
	public String getSparepartNumber() {
		return sparepartNumber;
	}
	/**
	 * @param sparepartNumber the sparepartNumber to set
	 */
	public void setSparepartNumber(String sparepartNumber) {
		this.sparepartNumber = sparepartNumber;
	}
	/**
	 * @return the newQuantity
	 */
	public String getNewQuantity() {
		return newQuantity;
	}
	/**
	 * @param newQuantity the newQuantity to set
	 */
	public void setNewQuantity(String newQuantity) {
		this.newQuantity = newQuantity;
	}
	/**
	 * @return the oldQuantity
	 */
	public String getOldQuantity() {
		return oldQuantity;
	}
	/**
	 * @param oldQuantity the oldQuantity to set
	 */
	public void setOldQuantity(String oldQuantity) {
		this.oldQuantity = oldQuantity;
	}
	/**
	 * @return the instId
	 */
	public String getInstId() {
		return instId;
	}
	/**
	 * @param instId the instId to set
	 */
	public void setInstId(String instId) {
		this.instId = instId;
	}
	/**
	 * @return the instDesc
	 */
	public String getInstDesc() {
		return instDesc;
	}
	/**
	 * @param instDesc the instDesc to set
	 */
	public void setInstDesc(String instDesc) {
		this.instDesc = instDesc;
	}
	/**
	 * @return the typeDesc
	 */
	public String getTypeDesc() {
		return typeDesc;
	}
	/**
	 * @param typeDesc the typeDesc to set
	 */
	public void setTypeDesc(String typeDesc) {
		this.typeDesc = typeDesc;
	}
	/**
	 * @return the typeId
	 */
	public String getTypeId() {
		return typeId;
	}
	/**
	 * @param typeId the typeId to set
	 */
	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}
	/**
	 * @return the vehicleDesc
	 */
	public String getVehicleDesc() {
		return vehicleDesc;
	}
	/**
	 * @param vehicleDesc the vehicleDesc to set
	 */
	public void setVehicleDesc(String vehicleDesc) {
		this.vehicleDesc = vehicleDesc;
	}
	/**
	 * @return the vehicleId
	 */
	public String getVehicleId() {
		return vehicleId;
	}
	/**
	 * @param vehicleId the vehicleId to set
	 */
	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}
	/**
	 * @return the spareId
	 */
	public String getSpareId() {
		return spareId;
	}
	/**
	 * @param spareId the spareId to set
	 */
	public void setSpareId(String spareId) {
		this.spareId = spareId;
	}
	/**
	 * @return the spareType
	 */
	public String getSpareType() {
		return spareType;
	}
	/**
	 * @param spareType the spareType to set
	 */
	public void setSpareType(String spareType) {
		this.spareType = spareType;
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
	
	
}
