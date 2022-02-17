package com.vo;

import java.util.ArrayList;

public class KeroseneClothPurchaseVO {
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
	private String sid;
	private String code;
	private String tempOldQty;
	private String newRate;
	private String newQty;
	
	private String des;
	private String totalAmount;
	private ArrayList itemList;
	private ArrayList comapanyList;
	private ArrayList placeList;
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
	public ArrayList getComapanyList() {
		return comapanyList;
	}
	public void setComapanyList(ArrayList comapanyList) {
		this.comapanyList = comapanyList;
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
	public String getItemDes() {
		return itemDes;
	}
	public void setItemDes(String itemDes) {
		this.itemDes = itemDes;
	}
	public ArrayList getItemList() {
		return itemList;
	}
	public void setItemList(ArrayList itemList) {
		this.itemList = itemList;
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
	public String getQtyPurchased() {
		return qtyPurchased;
	}
	public void setQtyPurchased(String qtyPurchased) {
		this.qtyPurchased = qtyPurchased;
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
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	public ArrayList getPlaceList() {
		return placeList;
	}
	public void setPlaceList(ArrayList placeList) {
		this.placeList = placeList;
	}
	public String getTempOldQty() {
		return tempOldQty;
	}
	public void setTempOldQty(String tempOldQty) {
		this.tempOldQty = tempOldQty;
	}
	public String getNewQty() {
		return newQty;
	}
	public void setNewQty(String newQty) {
		this.newQty = newQty;
	}
	public String getNewRate() {
		return newRate;
	}
	public void setNewRate(String newRate) {
		this.newRate = newRate;
	}
}
