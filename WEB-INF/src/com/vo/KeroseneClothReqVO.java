package com.vo;
import java.util.ArrayList;

public class KeroseneClothReqVO {
	private String code;
	private String id;
	private String des;
	private String date;
	private String from;
	private String itemDes;
	private String availableQty;
	private String qtyNeeded;
	private String description;
	private ArrayList fromList;
	public ArrayList getFromList() {
		return fromList;
	}
	public void setFromList(ArrayList fromList) {
		this.fromList = fromList;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAvailableQty() {
		return availableQty;
	}
	public void setAvailableQty(String availableQty) {
		this.availableQty = availableQty;
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
	public String getQtyNeeded() {
		return qtyNeeded;
	}
	public void setQtyNeeded(String qtyNeeded) {
		this.qtyNeeded = qtyNeeded;
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

}
