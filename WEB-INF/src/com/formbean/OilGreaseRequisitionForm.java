package com.formbean;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.validator.ValidatorForm;
public class OilGreaseRequisitionForm extends  ValidatorForm{
	private ArrayList brandNameList=null;
	private ArrayList brandCategoryList=null;
	private ArrayList itemDesList=null;
	private ArrayList approveStatusList;
	private String code=null;
	private String ctype=null;
	private String des=null;
	private String fileName;
	private String date=null;
	private String from=null;
	private String itemDes=null;
	private String brandName1=null;
	private String brandType1=null;
	private String availableQty1;
	private String qtyNeeded1;
	private String approveStatus1;
	private String brandName2;
	private String brandType2;
	private String availableQty2;
	private String qtyNeeded2;
	private String approveStatus2;
	private String brandName3;
	private String brandType3;
	private String availableQty3;
	private String qtyNeeded3;
	private String approveStatus3;
	private String brandName4;
	private String brandType4;
	private String availableQty4;
	private String qtyNeeded4;
	private String approveStatus4;
	private String brandName5;
	private String brandType5;
	private String availableQty5;
	private String qtyNeeded5;
	private String approveStatus5;
	private String newBrandName1;
	private String newBrandType1;
	private String newQtyNeeded1;
	private String approveStatus6;
	private String newBrandName2;
	private String newBrandType2;
	private String newQtyNeeded2;
	private String approveStatus7;
	private String newBrandName3;
	private String newBrandType3;
	private String newQtyNeeded3;
	private String approveStatus8;
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
	public ArrayList getBrandCategoryList() {
		return brandCategoryList;
	}
	public void setBrandCategoryList(ArrayList brandCategoryList) {
		this.brandCategoryList = brandCategoryList;
	}
	public ArrayList getBrandNameList() {
		return brandNameList;
	}
	public void setBrandNameList(ArrayList brandNameList) {
		this.brandNameList = brandNameList;
	}
	public ArrayList getItemDesList() {
		return itemDesList;
	}
	public void setItemDesList(ArrayList itemDesList) {
		this.itemDesList = itemDesList;
	}
	
	public String getCtype() {
		return ctype;
	}
	public void setCtype(String ctype) {
		this.ctype = ctype;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getCode() {
		return code;
	}
	public ActionErrors validate(ActionMapping mapping, 
			HttpServletRequest request) 
			{ 
//			 Perform validator framework validations 
			ActionErrors errors = new ActionErrors(); 
//			 Only need crossfield validations here 
			 
//	 		For requestedDate property	 
			if((StringUtils.isEmpty(date)))
			 {
				 errors.add("date",new ActionMessage("error.date.required")); 
			 }	
			 if(StringUtils.isEmpty(from))
			 {
				 errors.add("from",new ActionMessage("error.from.required")); 
			 }
			
			 		 		 
			return errors; 
			}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getApproveStatus1() {
		return approveStatus1;
	}
	public void setApproveStatus1(String approveStatus1) {
		this.approveStatus1 = approveStatus1;
	}
	public String getApproveStatus2() {
		return approveStatus2;
	}
	public void setApproveStatus2(String approveStatus2) {
		this.approveStatus2 = approveStatus2;
	}
	public String getApproveStatus3() {
		return approveStatus3;
	}
	public void setApproveStatus3(String approveStatus3) {
		this.approveStatus3 = approveStatus3;
	}
	public String getApproveStatus4() {
		return approveStatus4;
	}
	public void setApproveStatus4(String approveStatus4) {
		this.approveStatus4 = approveStatus4;
	}
	public String getApproveStatus5() {
		return approveStatus5;
	}
	public void setApproveStatus5(String approveStatus5) {
		this.approveStatus5 = approveStatus5;
	}
	public String getApproveStatus6() {
		return approveStatus6;
	}
	public void setApproveStatus6(String approveStatus6) {
		this.approveStatus6 = approveStatus6;
	}
	public String getApproveStatus7() {
		return approveStatus7;
	}
	public void setApproveStatus7(String approveStatus7) {
		this.approveStatus7 = approveStatus7;
	}
	public String getApproveStatus8() {
		return approveStatus8;
	}
	public void setApproveStatus8(String approveStatus8) {
		this.approveStatus8 = approveStatus8;
	}
	public ArrayList getApproveStatusList() {
		return approveStatusList;
	}
	public void setApproveStatusList(ArrayList approveStatusList) {
		this.approveStatusList = approveStatusList;
	}

}
