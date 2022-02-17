package com.formbean;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.apache.struts.validator.ValidatorForm;
public class CondemnTyreForm extends ValidatorForm{
	private static final Logger logger=(Logger)Logger.getLogger(CondemnTyreForm.class);
	
	private String tyreSize=null;
	private String tyrePly=null;
	private String tyreBrand=null;
	private String tyreNumber=null;
	private String tyreStatus=null;
	private String condemnTyreDate=null;
	private String condemnTyreReason=null;
	
	private ArrayList TyreSizeList=null;
	private ArrayList TyrePlyList=null;
	private ArrayList TyreNumberList=null;
	private ArrayList TyreBrandList=null;
	
	public String getCondemnTyreDate() {
		return condemnTyreDate;
	}
	public void setCondemnTyreDate(String condemnTyreDate) {
		this.condemnTyreDate = condemnTyreDate;
	}
	public String getCondemnTyreReason() {
		return condemnTyreReason;
	}
	public void setCondemnTyreReason(String condemnTyreReason) {
		this.condemnTyreReason = condemnTyreReason;
	}
	public String getTyreBrand() {
		return tyreBrand;
	}
	public void setTyreBrand(String tyreBrand) {
		this.tyreBrand = tyreBrand;
	}
	public String getTyreNumber() {
		return tyreNumber;
	}
	public void setTyreNumber(String tyreNumber) {
		this.tyreNumber = tyreNumber;
	}
	public String getTyrePly() {
		return tyrePly;
	}
	public void setTyrePly(String tyrePly) {
		this.tyrePly = tyrePly;
	}
	public String getTyreSize() {
		return tyreSize;
	}
	public void setTyreSize(String tyreSize) {
		this.tyreSize = tyreSize;
	}
	public String getTyreStatus() {
		return tyreStatus;
	}
	public void setTyreStatus(String tyreStatus) {
		this.tyreStatus = tyreStatus;
	}
	public ArrayList getTyreBrandList() {
		return TyreBrandList;
	}
	public void setTyreBrandList(ArrayList tyreBrandList) {
		TyreBrandList = tyreBrandList;
	}
	public ArrayList getTyreNumberList() {
		return TyreNumberList;
	}
	public void setTyreNumberList(ArrayList tyreNumberList) {
		TyreNumberList = tyreNumberList;
	}
	public ArrayList getTyrePlyList() {
		return TyrePlyList;
	}
	public void setTyrePlyList(ArrayList tyrePlyList) {
		TyrePlyList = tyrePlyList;
	}
	public ArrayList getTyreSizeList() {
		return TyreSizeList;
	}
	public void setTyreSizeList(ArrayList tyreSizeList) {
		TyreSizeList = tyreSizeList;
	}
	
}
