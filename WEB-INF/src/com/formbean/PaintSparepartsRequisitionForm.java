package com.formbean;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.validator.ValidatorForm;
public class PaintSparepartsRequisitionForm extends  ValidatorForm{
	private ArrayList typeList;
	private ArrayList partList1;
	private ArrayList partList2;
	private ArrayList partList3;
	private ArrayList partList4;
	private ArrayList partList5;
	private String from;
	private String date;
	private String reason;
	private String vehicleNo;
	private String itemDes;
	private String brandName1;
	private String brandType1;
	private String availableQty1;
	private String qtyNeeded1;
	private String brandName2;
	private String brandType2;
	private String availableQty2;
	private String qtyNeeded2;
	private String brandName3;
	private String brandType3;
	private String availableQty3;
	private String qtyNeeded3;
	private String brandName4;
	private String brandType4;
	private String availableQty4;
	private String qtyNeeded4;
	private String brandName5;
	private String brandType5;
	private String availableQty5;
	private String qtyNeeded5;
	private String newBrandName1;
	private String newBrandType1;
	private String newQtyNeeded1;
	private String newBrandName2;
	private String newBrandType2;
	private String newQtyNeeded2;
	private String newBrandName3;
	private String newBrandType3;
	private String newQtyNeeded3;
	public String getAvailableQty1() {
		return availableQty1;
	}
	public void setAvailableQty1(String availableQty1) {
		this.availableQty1 = availableQty1;
	}
	public String getAvailableQty2() {
		return availableQty2;
	}
	public void setAvailableQty2(String availableQty2) {
		this.availableQty2 = availableQty2;
	}
	public String getAvailableQty3() {
		return availableQty3;
	}
	public void setAvailableQty3(String availableQty3) {
		this.availableQty3 = availableQty3;
	}
	public String getAvailableQty4() {
		return availableQty4;
	}
	public void setAvailableQty4(String availableQty4) {
		this.availableQty4 = availableQty4;
	}
	public String getAvailableQty5() {
		return availableQty5;
	}
	public void setAvailableQty5(String availableQty5) {
		this.availableQty5 = availableQty5;
	}
	public String getBrandName1() {
		return brandName1;
	}
	public void setBrandName1(String brandName1) {
		this.brandName1 = brandName1;
	}
	public String getBrandName2() {
		return brandName2;
	}
	public void setBrandName2(String brandName2) {
		this.brandName2 = brandName2;
	}
	public String getBrandName3() {
		return brandName3;
	}
	public void setBrandName3(String brandName3) {
		this.brandName3 = brandName3;
	}
	public String getBrandName4() {
		return brandName4;
	}
	public void setBrandName4(String brandName4) {
		this.brandName4 = brandName4;
	}
	public String getBrandName5() {
		return brandName5;
	}
	public void setBrandName5(String brandName5) {
		this.brandName5 = brandName5;
	}
	public String getBrandType1() {
		return brandType1;
	}
	public void setBrandType1(String brandType1) {
		this.brandType1 = brandType1;
	}
	public String getBrandType2() {
		return brandType2;
	}
	public void setBrandType2(String brandType2) {
		this.brandType2 = brandType2;
	}
	public String getBrandType3() {
		return brandType3;
	}
	public void setBrandType3(String brandType3) {
		this.brandType3 = brandType3;
	}
	public String getBrandType4() {
		return brandType4;
	}
	public void setBrandType4(String brandType4) {
		this.brandType4 = brandType4;
	}
	public String getBrandType5() {
		return brandType5;
	}
	public void setBrandType5(String brandType5) {
		this.brandType5 = brandType5;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getItemDes() {
		return itemDes;
	}
	public void setItemDes(String itemDes) {
		this.itemDes = itemDes;
	}
	public String getNewBrandName1() {
		return newBrandName1;
	}
	public void setNewBrandName1(String newBrandName1) {
		this.newBrandName1 = newBrandName1;
	}
	public String getNewBrandName2() {
		return newBrandName2;
	}
	public void setNewBrandName2(String newBrandName2) {
		this.newBrandName2 = newBrandName2;
	}
	public String getNewBrandName3() {
		return newBrandName3;
	}
	public void setNewBrandName3(String newBrandName3) {
		this.newBrandName3 = newBrandName3;
	}
	public String getNewBrandType1() {
		return newBrandType1;
	}
	public void setNewBrandType1(String newBrandType1) {
		this.newBrandType1 = newBrandType1;
	}
	public String getNewBrandType2() {
		return newBrandType2;
	}
	public void setNewBrandType2(String newBrandType2) {
		this.newBrandType2 = newBrandType2;
	}
	public String getNewBrandType3() {
		return newBrandType3;
	}
	public void setNewBrandType3(String newBrandType3) {
		this.newBrandType3 = newBrandType3;
	}
	
	public String getQtyNeeded1() {
		return qtyNeeded1;
	}
	public void setQtyNeeded1(String qtyNeeded1) {
		this.qtyNeeded1 = qtyNeeded1;
	}
	public String getQtyNeeded2() {
		return qtyNeeded2;
	}
	public void setQtyNeeded2(String qtyNeeded2) {
		this.qtyNeeded2 = qtyNeeded2;
	}
	public String getQtyNeeded3() {
		return qtyNeeded3;
	}
	public void setQtyNeeded3(String qtyNeeded3) {
		this.qtyNeeded3 = qtyNeeded3;
	}
	public String getQtyNeeded4() {
		return qtyNeeded4;
	}
	public void setQtyNeeded4(String qtyNeeded4) {
		this.qtyNeeded4 = qtyNeeded4;
	}
	public String getQtyNeeded5() {
		return qtyNeeded5;
	}
	public void setQtyNeeded5(String qtyNeeded5) {
		this.qtyNeeded5 = qtyNeeded5;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getVehicleNo() {
		return vehicleNo;
	}
	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}
	public String getNewQtyNeeded1() {
		return newQtyNeeded1;
	}
	public void setNewQtyNeeded1(String newQtyNeeded1) {
		this.newQtyNeeded1 = newQtyNeeded1;
	}
	public String getNewQtyNeeded2() {
		return newQtyNeeded2;
	}
	public void setNewQtyNeeded2(String newQtyNeeded2) {
		this.newQtyNeeded2 = newQtyNeeded2;
	}
	public String getNewQtyNeeded3() {
		return newQtyNeeded3;
	}
	public void setNewQtyNeeded3(String newQtyNeeded3) {
		this.newQtyNeeded3 = newQtyNeeded3;
	}
	
	public ArrayList getTypeList() {
		return typeList;
	}
	public void setTypeList(ArrayList typeList) {
		this.typeList = typeList;
	}
	/**
	 * @return the partList1
	 */
	public ArrayList getPartList1() {
		return partList1;
	}
	/**
	 * @param partList1 the partList1 to set
	 */
	public void setPartList1(ArrayList partList1) {
		this.partList1 = partList1;
	}
	/**
	 * @return the partList2
	 */
	public ArrayList getPartList2() {
		return partList2;
	}
	/**
	 * @param partList2 the partList2 to set
	 */
	public void setPartList2(ArrayList partList2) {
		this.partList2 = partList2;
	}
	/**
	 * @return the partList3
	 */
	public ArrayList getPartList3() {
		return partList3;
	}
	/**
	 * @param partList3 the partList3 to set
	 */
	public void setPartList3(ArrayList partList3) {
		this.partList3 = partList3;
	}
	/**
	 * @return the partList4
	 */
	public ArrayList getPartList4() {
		return partList4;
	}
	/**
	 * @param partList4 the partList4 to set
	 */
	public void setPartList4(ArrayList partList4) {
		this.partList4 = partList4;
	}
	/**
	 * @return the partList5
	 */
	public ArrayList getPartList5() {
		return partList5;
	}
	/**
	 * @param partList5 the partList5 to set
	 */
	public void setPartList5(ArrayList partList5) {
		this.partList5 = partList5;
	}
	public ActionErrors validate(ActionMapping mapping, 
			HttpServletRequest request) 
			{ 
//			 Perform validator framework validations 
			ActionErrors errors = new ActionErrors(); 
//			 Only need crossfield validations here 
			if(StringUtils.isEmpty(reason))
			 {
				 errors.add(ActionErrors.GLOBAL_MESSAGE,new ActionMessage("error.reason.required")); 
			 }
			 if(StringUtils.isAlpha(qtyNeeded1)&& StringUtils.isNotEmpty(qtyNeeded1))
			 {
				 errors.add(ActionErrors.GLOBAL_MESSAGE,new ActionMessage("error.qtyNeeded1.required")); 
			 }
			if (StringUtils.isAlpha(qtyNeeded2)&& StringUtils.isNotEmpty(qtyNeeded2)) { 
				errors.add(ActionErrors.GLOBAL_MESSAGE,new ActionMessage("error.qtyNeeded2.required")); 
				} 
			
			if (StringUtils.isAlpha(qtyNeeded3)&& StringUtils.isNotEmpty(qtyNeeded3)) { 
				errors.add(ActionErrors.GLOBAL_MESSAGE,new ActionMessage("error.qtyNeeded3.required")); 
				} 
			if(StringUtils.isAlpha(qtyNeeded4)&& StringUtils.isNotEmpty(qtyNeeded4))
			 {
				 errors.add(ActionErrors.GLOBAL_MESSAGE,new ActionMessage("error.qtyNeeded4.required")); 
			 }
			if (StringUtils.isAlpha(qtyNeeded5)&& StringUtils.isNotEmpty(qtyNeeded5)) { 
				errors.add(ActionErrors.GLOBAL_MESSAGE,new ActionMessage("error.qtyNeeded5.required")); 
				} 
			
			if (StringUtils.isAlpha(newQtyNeeded1)&& StringUtils.isNotEmpty(newQtyNeeded1)) { 
				errors.add(ActionErrors.GLOBAL_MESSAGE,new ActionMessage("error.newQtyNeeded1.required")); 
				} 
			if(StringUtils.isAlpha(newQtyNeeded2)&& StringUtils.isNotEmpty(newQtyNeeded2))
			 {
				 errors.add(ActionErrors.GLOBAL_MESSAGE,new ActionMessage("error.newQtyNeeded2.required")); 
			 }
			if (StringUtils.isAlpha(newQtyNeeded3)&& StringUtils.isNotEmpty(newQtyNeeded3)) { 
				errors.add(ActionErrors.GLOBAL_MESSAGE,new ActionMessage("error.newQtyNeeded3.required")); 
				} 
			return errors; 
			}

}
