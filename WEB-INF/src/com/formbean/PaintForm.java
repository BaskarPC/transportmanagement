package com.formbean;


import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.validator.ValidatorForm;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

public class PaintForm extends GeneralForm{
	private static final Logger logger=(Logger)Logger.getLogger(PaintForm.class);
	
	private ArrayList compList;
	private ArrayList colorList1;
	private ArrayList colorList2;
	private ArrayList colorList3;
	private ArrayList colorList4;
	private ArrayList colorList5;
	private ArrayList colorList6;
	private ArrayList colorList7;
	private ArrayList colorList8;
	private ArrayList colorList9;
	private ArrayList colorList10;
	private String paintType1=null;
	private String paintType2=null;
	private String paintType3=null;
	private String paintType4=null;
	private String paintType5=null;
	private String paintType6=null;
	private String paintType7=null;
	private String paintType8=null;
	private String paintType9=null;
	private String paintType10=null;
	
	private String paintColor1=null;
	private String paintColor2=null;
	private String paintColor3=null;
	private String paintColor4=null;
	private String paintColor5=null;
	private String paintColor6=null;
	private String paintColor7=null;
	private String paintColor8=null;
	private String paintColor9=null;
	private String paintColor10=null;

	private String totalAvailableQuantity1=null;
	private String totalAvailableQuantity2=null;
	private String totalAvailableQuantity3=null;
	private String totalAvailableQuantity4=null;
	private String totalAvailableQuantity5=null;
	private String totalAvailableQuantity6=null;
	private String totalAvailableQuantity7=null;
	private String totalAvailableQuantity8=null;
	private String totalAvailableQuantity9=null;
	private String totalAvailableQuantity10=null;
	
	private String wantedQuantity1=null;
	private String wantedQuantity2=null;
	private String wantedQuantity3=null;
	private String wantedQuantity4=null;
	private String wantedQuantity5=null;
	private String wantedQuantity6=null;
	private String wantedQuantity7=null;
	private String wantedQuantity8=null;
	private String wantedQuantity9=null;
	private String wantedQuantity10=null;

	private String oldAvailable1=null;
	private String oldAvailable2=null;
	private String oldAvailable3=null;
	private String oldAvailable4=null;
	private String oldAvailable5=null;
	private String oldAvailable6=null;
	private String oldAvailable7=null;
	private String oldAvailable8=null;
	private String oldAvailable9=null;
	private String oldAvailable10=null;

	private String newAvailable1=null;
	private String newAvailable2=null;
	private String newAvailable3=null;
	private String newAvailable4=null;
	private String newAvailable5=null;
	private String newAvailable6=null;
	private String newAvailable7=null;
	private String newAvailable8=null;
	private String newAvailable9=null;
	private String newAvailable10=null;
	
	private String oldRate1=null;
	private String oldRate2=null;
	private String oldRate3=null;
	private String oldRate4=null;
	private String oldRate5=null;
	private String oldRate6=null;
	private String oldRate7=null;
	private String oldRate8=null;
	private String oldRate9=null;
	private String oldRate10=null;
	
	private String newRate1=null;
	private String newRate2=null;
	private String newRate3=null;
	private String newRate4=null;
	private String newRate5=null;
	private String newRate6=null;
	private String newRate7=null;
	private String newRate8=null;
	private String newRate9=null;
	private String newRate10=null;

	private String totalAmount1=null;
	private String totalAmount2=null;
	private String totalAmount3=null;
	private String totalAmount4=null;
	private String totalAmount5=null;
	private String totalAmount6=null;
	private String totalAmount7=null;
	private String totalAmount8=null;
	private String totalAmount9=null;
	private String totalAmount10=null;
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
	 * @return the paintColor1
	 */
	public String getPaintColor1() {
		return paintColor1;
	}
	/**
	 * @param paintColor1 the paintColor1 to set
	 */
	public void setPaintColor1(String paintColor1) {
		this.paintColor1 = paintColor1;
	}
	/**
	 * @return the paintColor10
	 */
	public String getPaintColor10() {
		return paintColor10;
	}
	/**
	 * @param paintColor10 the paintColor10 to set
	 */
	public void setPaintColor10(String paintColor10) {
		this.paintColor10 = paintColor10;
	}
	/**
	 * @return the paintColor2
	 */
	public String getPaintColor2() {
		return paintColor2;
	}
	/**
	 * @param paintColor2 the paintColor2 to set
	 */
	public void setPaintColor2(String paintColor2) {
		this.paintColor2 = paintColor2;
	}
	/**
	 * @return the paintColor3
	 */
	public String getPaintColor3() {
		return paintColor3;
	}
	/**
	 * @param paintColor3 the paintColor3 to set
	 */
	public void setPaintColor3(String paintColor3) {
		this.paintColor3 = paintColor3;
	}
	/**
	 * @return the paintColor4
	 */
	public String getPaintColor4() {
		return paintColor4;
	}
	/**
	 * @param paintColor4 the paintColor4 to set
	 */
	public void setPaintColor4(String paintColor4) {
		this.paintColor4 = paintColor4;
	}
	/**
	 * @return the paintColor5
	 */
	public String getPaintColor5() {
		return paintColor5;
	}
	/**
	 * @param paintColor5 the paintColor5 to set
	 */
	public void setPaintColor5(String paintColor5) {
		this.paintColor5 = paintColor5;
	}
	/**
	 * @return the paintColor6
	 */
	public String getPaintColor6() {
		return paintColor6;
	}
	/**
	 * @param paintColor6 the paintColor6 to set
	 */
	public void setPaintColor6(String paintColor6) {
		this.paintColor6 = paintColor6;
	}
	/**
	 * @return the paintColor7
	 */
	public String getPaintColor7() {
		return paintColor7;
	}
	/**
	 * @param paintColor7 the paintColor7 to set
	 */
	public void setPaintColor7(String paintColor7) {
		this.paintColor7 = paintColor7;
	}
	/**
	 * @return the paintColor8
	 */
	public String getPaintColor8() {
		return paintColor8;
	}
	/**
	 * @param paintColor8 the paintColor8 to set
	 */
	public void setPaintColor8(String paintColor8) {
		this.paintColor8 = paintColor8;
	}
	/**
	 * @return the paintColor9
	 */
	public String getPaintColor9() {
		return paintColor9;
	}
	/**
	 * @param paintColor9 the paintColor9 to set
	 */
	public void setPaintColor9(String paintColor9) {
		this.paintColor9 = paintColor9;
	}
	/**
	 * @return the paintType1
	 */
	public String getPaintType1() {
		return paintType1;
	}
	/**
	 * @param paintType1 the paintType1 to set
	 */
	public void setPaintType1(String paintType1) {
		this.paintType1 = paintType1;
	}
	/**
	 * @return the paintType10
	 */
	public String getPaintType10() {
		return paintType10;
	}
	/**
	 * @param paintType10 the paintType10 to set
	 */
	public void setPaintType10(String paintType10) {
		this.paintType10 = paintType10;
	}
	/**
	 * @return the paintType2
	 */
	public String getPaintType2() {
		return paintType2;
	}
	/**
	 * @param paintType2 the paintType2 to set
	 */
	public void setPaintType2(String paintType2) {
		this.paintType2 = paintType2;
	}
	/**
	 * @return the paintType3
	 */
	public String getPaintType3() {
		return paintType3;
	}
	/**
	 * @param paintType3 the paintType3 to set
	 */
	public void setPaintType3(String paintType3) {
		this.paintType3 = paintType3;
	}
	/**
	 * @return the paintType4
	 */
	public String getPaintType4() {
		return paintType4;
	}
	/**
	 * @param paintType4 the paintType4 to set
	 */
	public void setPaintType4(String paintType4) {
		this.paintType4 = paintType4;
	}
	/**
	 * @return the paintType5
	 */
	public String getPaintType5() {
		return paintType5;
	}
	/**
	 * @param paintType5 the paintType5 to set
	 */
	public void setPaintType5(String paintType5) {
		this.paintType5 = paintType5;
	}
	/**
	 * @return the paintType6
	 */
	public String getPaintType6() {
		return paintType6;
	}
	/**
	 * @param paintType6 the paintType6 to set
	 */
	public void setPaintType6(String paintType6) {
		this.paintType6 = paintType6;
	}
	/**
	 * @return the paintType7
	 */
	public String getPaintType7() {
		return paintType7;
	}
	/**
	 * @param paintType7 the paintType7 to set
	 */
	public void setPaintType7(String paintType7) {
		this.paintType7 = paintType7;
	}
	/**
	 * @return the paintType8
	 */
	public String getPaintType8() {
		return paintType8;
	}
	/**
	 * @param paintType8 the paintType8 to set
	 */
	public void setPaintType8(String paintType8) {
		this.paintType8 = paintType8;
	}
	/**
	 * @return the paintType9
	 */
	public String getPaintType9() {
		return paintType9;
	}
	/**
	 * @param paintType9 the paintType9 to set
	 */
	public void setPaintType9(String paintType9) {
		this.paintType9 = paintType9;
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
	 * @return the colorList1
	 */
	public ArrayList getColorList1() {
		return colorList1;
	}
	/**
	 * @param colorList1 the colorList1 to set
	 */
	public void setColorList1(ArrayList colorList1) {
		this.colorList1 = colorList1;
	}
	/**
	 * @return the colorList10
	 */
	public ArrayList getColorList10() {
		return colorList10;
	}
	/**
	 * @param colorList10 the colorList10 to set
	 */
	public void setColorList10(ArrayList colorList10) {
		this.colorList10 = colorList10;
	}
	/**
	 * @return the colorList2
	 */
	public ArrayList getColorList2() {
		return colorList2;
	}
	/**
	 * @param colorList2 the colorList2 to set
	 */
	public void setColorList2(ArrayList colorList2) {
		this.colorList2 = colorList2;
	}
	/**
	 * @return the colorList3
	 */
	public ArrayList getColorList3() {
		return colorList3;
	}
	/**
	 * @param colorList3 the colorList3 to set
	 */
	public void setColorList3(ArrayList colorList3) {
		this.colorList3 = colorList3;
	}
	/**
	 * @return the colorList4
	 */
	public ArrayList getColorList4() {
		return colorList4;
	}
	/**
	 * @param colorList4 the colorList4 to set
	 */
	public void setColorList4(ArrayList colorList4) {
		this.colorList4 = colorList4;
	}
	/**
	 * @return the colorList5
	 */
	public ArrayList getColorList5() {
		return colorList5;
	}
	/**
	 * @param colorList5 the colorList5 to set
	 */
	public void setColorList5(ArrayList colorList5) {
		this.colorList5 = colorList5;
	}
	/**
	 * @return the colorList6
	 */
	public ArrayList getColorList6() {
		return colorList6;
	}
	/**
	 * @param colorList6 the colorList6 to set
	 */
	public void setColorList6(ArrayList colorList6) {
		this.colorList6 = colorList6;
	}
	/**
	 * @return the colorList7
	 */
	public ArrayList getColorList7() {
		return colorList7;
	}
	/**
	 * @param colorList7 the colorList7 to set
	 */
	public void setColorList7(ArrayList colorList7) {
		this.colorList7 = colorList7;
	}
	/**
	 * @return the colorList8
	 */
	public ArrayList getColorList8() {
		return colorList8;
	}
	/**
	 * @param colorList8 the colorList8 to set
	 */
	public void setColorList8(ArrayList colorList8) {
		this.colorList8 = colorList8;
	}
	/**
	 * @return the colorList9
	 */
	public ArrayList getColorList9() {
		return colorList9;
	}
	/**
	 * @param colorList9 the colorList9 to set
	 */
	public void setColorList9(ArrayList colorList9) {
		this.colorList9 = colorList9;
	}
	/**
	 * @return the compList
	 */
	public ArrayList getCompList() {
		return compList;
	}
	/**
	 * @param compList the compList to set
	 */
	public void setCompList(ArrayList compList) {
		this.compList = compList;
	}
	
	
}