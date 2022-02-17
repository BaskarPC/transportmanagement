package com.vo;



import java.util.ArrayList;

public class DieselRequisitionVO {
	private String code=null;
	private String ctype=null;
	private String des=null;
	private String sid=null;
	private String date=null;
	private String role=null;
	private Integer jobid=null;
	private String from=null;
	private String blobimage=null;
	private String tankCapacity=null;
	private String imageName=null;
	private String currentCapacity=null;
	private ArrayList imagelist=null;
	private String id=null;
	private String qtyNeeded=null;
	public String getCurrentCapacity() {
		return currentCapacity;
	}
	public void setCurrentCapacity(String currentCapacity) {
		this.currentCapacity = currentCapacity;
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
	public String getQtyNeeded() {
		return qtyNeeded;
	}
	public void setQtyNeeded(String qtyNeeded) {
		this.qtyNeeded = qtyNeeded;
	}
	public String getTankCapacity() {
		return tankCapacity;
	}
	public void setTankCapacity(String tankCapacity) {
		this.tankCapacity = tankCapacity;
	}
	
	public void setJobid(Integer jobid) {
		this.jobid = jobid;
	}
	public Integer getJobid() {
		return jobid;
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
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	public String getBlobimage() {
		return blobimage;
	}
	public void setBlobimage(String blobimage) {
		this.blobimage = blobimage;
	}
	
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	
	public ArrayList getImagelist() {
		return imagelist;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setImagelist(ArrayList imagelist) {
		this.imagelist = imagelist;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	
	

}
