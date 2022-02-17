package com.vo;

import java.util.ArrayList;

public class KeroseneClothRequisitionVO {
	private int jobid;
	private String code;
	private String ctype;
	private String des;
	private String date;
	private String from;
	private String role;
	private String itemDes;
	private String availableQty;
	private String qtyNeeded;
	private ArrayList itemList;	
	private String description;
	
	public String getAvailableQty() {
		return availableQty;
	}
	public void setAvailableQty(String availableQty) {
		this.availableQty = availableQty;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getCtype() {
		return ctype;
	}
	public void setCtype(String ctype) {
		this.ctype = ctype;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
	public ArrayList getItemList() {
		return itemList;
	}
	public void setItemList(ArrayList itemList) {
		this.itemList = itemList;
	}
	public String getQtyNeeded() {
		return qtyNeeded;
	}
	public void setQtyNeeded(String qtyNeeded) {
		this.qtyNeeded = qtyNeeded;
	}
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	public void setJobid(int jobid) {
		this.jobid = jobid;
	}
	public int getJobid() {
		return jobid;
	}
}
