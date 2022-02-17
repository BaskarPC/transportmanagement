package com.formbean;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

public class GeneralNoteRequisitionForm extends ValidatorForm{
	private String from=null;
	private String date=null;
	private String reason=null;
	private String itemName1=null;
	private String partNo1=null;
	private String availableQty1=null;
	private String quantityNeeded1=null;
	private String itemName2=null;
	private String partNo2=null;
	private String availableQty2=null;
	private String quantityNeeded2=null;
	private String itemName3=null;
	private String partNo3=null;
	private String availableQty3=null;
	private String quantityNeeded3=null;
	private String itemName4=null;
	private String partNo4=null;
	private String availableQty4=null;
	private String quantityNeeded4=null;
	private String itemName5=null;
	private String partNo5=null;
	private String availableQty5=null;
	private String quantityNeeded5=null;
	private String optionItemName3=null;
	private String optionPartNo3=null;
	private String optionQtyNeeded3=null;
	private String optionItemName1=null;
	private String optionPartNo1=null;
	private String optionQtyNeeded1=null;
	private String optionItemName2=null;
	private String optionPartNo2=null;
	private String optionQtyNeeded2=null;
	private String optionItemName4=null;
	private String optionPartNo4=null;
	private String optionQtyNeeded4=null;
	private String optionItemName5=null;
	private String optionPartNo5=null;
	private String optionQtyNeeded5=null;
	
	
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
	
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
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
	public String getItemName1() {
		return itemName1;
	}
	public void setItemName1(String itemName1) {
		this.itemName1 = itemName1;
	}
	public String getItemName2() {
		return itemName2;
	}
	public void setItemName2(String itemName2) {
		this.itemName2 = itemName2;
	}
	public String getItemName3() {
		return itemName3;
	}
	public void setItemName3(String itemName3) {
		this.itemName3 = itemName3;
	}
	public String getItemName4() {
		return itemName4;
	}
	public void setItemName4(String itemName4) {
		this.itemName4 = itemName4;
	}
	public String getItemName5() {
		return itemName5;
	}
	public void setItemName5(String itemName5) {
		this.itemName5 = itemName5;
	}
	public String getPartNo1() {
		return partNo1;
	}
	public void setPartNo1(String partNo1) {
		this.partNo1 = partNo1;
	}
	public String getPartNo2() {
		return partNo2;
	}
	public void setPartNo2(String partNo2) {
		this.partNo2 = partNo2;
	}
	public String getPartNo3() {
		return partNo3;
	}
	public void setPartNo3(String partNo3) {
		this.partNo3 = partNo3;
	}
	public String getPartNo4() {
		return partNo4;
	}
	public void setPartNo4(String partNo4) {
		this.partNo4 = partNo4;
	}
	public String getPartNo5() {
		return partNo5;
	}
	public void setPartNo5(String partNo5) {
		this.partNo5 = partNo5;
	}
	public String getQuantityNeeded1() {
		return quantityNeeded1;
	}
	public void setQuantityNeeded1(String quantityNeeded1) {
		this.quantityNeeded1 = quantityNeeded1;
	}
	public String getQuantityNeeded2() {
		return quantityNeeded2;
	}
	public void setQuantityNeeded2(String quantityNeeded2) {
		this.quantityNeeded2 = quantityNeeded2;
	}
	public String getQuantityNeeded3() {
		return quantityNeeded3;
	}
	public void setQuantityNeeded3(String quantityNeeded3) {
		this.quantityNeeded3 = quantityNeeded3;
	}
	public String getQuantityNeeded4() {
		return quantityNeeded4;
	}
	public void setQuantityNeeded4(String quantityNeeded4) {
		this.quantityNeeded4 = quantityNeeded4;
	}
	public String getQuantityNeeded5() {
		return quantityNeeded5;
	}
	public void setQuantityNeeded5(String quantityNeeded5) {
		this.quantityNeeded5 = quantityNeeded5;
	}
	public String getOptionItemName1() {
		return optionItemName1;
	}
	public void setOptionItemName1(String optionItemName1) {
		this.optionItemName1 = optionItemName1;
	}
	public String getOptionItemName2() {
		return optionItemName2;
	}
	public void setOptionItemName2(String optionItemName2) {
		this.optionItemName2 = optionItemName2;
	}
	public String getOptionItemName3() {
		return optionItemName3;
	}
	public void setOptionItemName3(String optionItemName3) {
		this.optionItemName3 = optionItemName3;
	}
	public String getOptionItemName4() {
		return optionItemName4;
	}
	public void setOptionItemName4(String optionItemName4) {
		this.optionItemName4 = optionItemName4;
	}
	public String getOptionItemName5() {
		return optionItemName5;
	}
	public void setOptionItemName5(String optionItemName5) {
		this.optionItemName5 = optionItemName5;
	}
	public String getOptionPartNo1() {
		return optionPartNo1;
	}
	public void setOptionPartNo1(String optionPartNo1) {
		this.optionPartNo1 = optionPartNo1;
	}
	public String getOptionPartNo2() {
		return optionPartNo2;
	}
	public void setOptionPartNo2(String optionPartNo2) {
		this.optionPartNo2 = optionPartNo2;
	}
	public String getOptionPartNo3() {
		return optionPartNo3;
	}
	public void setOptionPartNo3(String optionPartNo3) {
		this.optionPartNo3 = optionPartNo3;
	}
	public String getOptionPartNo4() {
		return optionPartNo4;
	}
	public void setOptionPartNo4(String optionPartNo4) {
		this.optionPartNo4 = optionPartNo4;
	}
	public String getOptionPartNo5() {
		return optionPartNo5;
	}
	public void setOptionPartNo5(String optionPartNo5) {
		this.optionPartNo5 = optionPartNo5;
	}
	public String getOptionQtyNeeded1() {
		return optionQtyNeeded1;
	}
	public void setOptionQtyNeeded1(String optionQtyNeeded1) {
		this.optionQtyNeeded1 = optionQtyNeeded1;
	}
	public String getOptionQtyNeeded2() {
		return optionQtyNeeded2;
	}
	public void setOptionQtyNeeded2(String optionQtyNeeded2) {
		this.optionQtyNeeded2 = optionQtyNeeded2;
	}
	public String getOptionQtyNeeded3() {
		return optionQtyNeeded3;
	}
	public void setOptionQtyNeeded3(String optionQtyNeeded3) {
		this.optionQtyNeeded3 = optionQtyNeeded3;
	}
	public String getOptionQtyNeeded4() {
		return optionQtyNeeded4;
	}
	public void setOptionQtyNeeded4(String optionQtyNeeded4) {
		this.optionQtyNeeded4 = optionQtyNeeded4;
	}
	public String getOptionQtyNeeded5() {
		return optionQtyNeeded5;
	}
	public void setOptionQtyNeeded5(String optionQtyNeeded5) {
		this.optionQtyNeeded5 = optionQtyNeeded5;
	}
	

}
