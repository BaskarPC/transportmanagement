package com.formbean;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;
import org.apache.struts.validator.ValidatorForm;
public class DieselRequisitionForm extends ValidatorForm{
	private String date=null;
	private String from=null;
	private String upload=null;
	private FormFile fileName=null;
	private String tankCapacity=null;
	private String currentCapacity=null;
	private String qtyNeeded=null;
	private String imageName=null;
	private String id=null;
	private ArrayList imagelist=null;
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
	public String getUpload() {
		return upload;
	}
	public void setUpload(String upload) {
		this.upload = upload;
	}
	
	public FormFile getFileName() {
		return fileName;
	}
	public void setFileName(FormFile fileName) {
		this.fileName = fileName;
	}
	public ArrayList getImagelist() {
		return imagelist;
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

}
