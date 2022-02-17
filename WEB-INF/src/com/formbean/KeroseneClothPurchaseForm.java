package com.formbean;
import java.util.ArrayList;

import org.apache.struts.validator.ValidatorForm;
public class KeroseneClothPurchaseForm extends  ValidatorForm{
	private String billDate;
	private String billNo;
	private String deliveredDate;
	private String itemDes;
	private String partNo;
	private String companyName;
	private String place;
	private String qtyPurchased;
	private String unitPrice;
	private String amount;
	private String totalAmount;
	private ArrayList itemList;
	private ArrayList companyList;
	private ArrayList placeList;
	public ArrayList getPlaceList() {
		return placeList;
	}
	public void setPlaceList(ArrayList placeList) {
		this.placeList = placeList;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getBillDate() {
		return billDate;
	}
	public void setBillDate(String billDate) {
		this.billDate = billDate;
	}
	public String getBillNo() {
		return billNo;
	}
	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getDeliveredDate() {
		return deliveredDate;
	}
	public void setDeliveredDate(String deliveredDate) {
		this.deliveredDate = deliveredDate;
	}
	
	public String getPartNo() {
		return partNo;
	}
	public void setPartNo(String partNo) {
		this.partNo = partNo;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	
	public String getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(String unitPrice) {
		this.unitPrice = unitPrice;
	}
	public String getItemDes() {
		return itemDes;
	}
	public void setItemDes(String itemDes) {
		this.itemDes = itemDes;
	}
	public String getQtyPurchased() {
		return qtyPurchased;
	}
	public void setQtyPurchased(String qtyPurchased) {
		this.qtyPurchased = qtyPurchased;
	}
	public ArrayList getCompanyList() {
		return companyList;
	}
	public void setCompanyList(ArrayList companyList) {
		this.companyList = companyList;
	}
	public ArrayList getItemList() {
		return itemList;
	}
	public void setItemList(ArrayList itemList) {
		this.itemList = itemList;
	}


}
