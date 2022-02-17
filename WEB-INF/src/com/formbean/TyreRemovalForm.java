package com.formbean;


import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.validator.ValidatorForm;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
public class TyreRemovalForm extends ValidatorForm{
	private static final Logger logger=(Logger)Logger.getLogger(TyreRemovalForm.class);
	private String tyreStatus=null;
	private String tyrePosition=null;
	private String removalDate=null;
	private String fittingKM=null;
	private String removalKM=null;
	private String totalKM=null;
	private String removalReason=null;
	
	private String institutionName=null;
	private String vehicleType=null;
	private String vehicleNumber=null;
	private String requestedDate=null;
	private String otherPurpose=null;
	private String tyreSize=null;
	private String tyrePly=null;
	private String tyreBrand=null;
	private String tyreNumber=null;
	
	private ArrayList tyreNumberList=null;
	private ArrayList institutionList=null;
	private ArrayList vehicleTypeList=null;
	private ArrayList vehicleNumberList=null;
	private ArrayList tyreDetailslist=null;
	private ArrayList tyrePositionList=null;
	
	public ArrayList getTyreDetailslist() {
		return tyreDetailslist;
	}
	public void setTyreDetailslist(ArrayList tyreDetailslist) {
		this.tyreDetailslist = tyreDetailslist;
	}
	public ArrayList getInstitutionList() {
		return institutionList;
	}
	public void setInstitutionList(ArrayList institutionList) {
		this.institutionList = institutionList;
	}
	public ArrayList getTyreNumberList() {
		return tyreNumberList;
	}
	public void setTyreNumberList(ArrayList tyreNumberList) {
		this.tyreNumberList = tyreNumberList;
	}
	public ArrayList getVehicleNumberList() {
		return vehicleNumberList;
	}
	public void setVehicleNumberList(ArrayList vehicleNumberList) {
		this.vehicleNumberList = vehicleNumberList;
	}
	public ArrayList getVehicleTypeList() {
		return vehicleTypeList;
	}
	public void setVehicleTypeList(ArrayList vehicleTypeList) {
		this.vehicleTypeList = vehicleTypeList;
	}
	public String getFittingKM() {
		return fittingKM;
	}
	public void setFittingKM(String fittingKM) {
		this.fittingKM = fittingKM;
	}
	public String getRemovalDate() {
		return removalDate;
	}
	public void setRemovalDate(String removalDate) {
		this.removalDate = removalDate;
	}
	public String getRemovalKM() {
		return removalKM;
	}
	public void setRemovalKM(String removalKM) {
		this.removalKM = removalKM;
	}
	public String getRemovalReason() {
		return removalReason;
	}
	public void setRemovalReason(String removalReason) {
		this.removalReason = removalReason;
	}
	public String getTotalKM() {
		return totalKM;
	}
	public void setTotalKM(String totalKM) {
		this.totalKM = totalKM;
	}
	
	public String getTyrePosition() {
		return tyrePosition;
	}
	public void setTyrePosition(String tyrePosition) {
		this.tyrePosition = tyrePosition;
	}
	public String getTyreStatus() {
		return tyreStatus;
	}
	public void setTyreStatus(String tyreStatus) {
		this.tyreStatus = tyreStatus;
	}
	public ArrayList getTyrePositionList() {
		return tyrePositionList;
	}
	public void setTyrePositionList(ArrayList tyrePositionList) {
		this.tyrePositionList = tyrePositionList;
	}
	public String getInstitutionName() {
		return institutionName;
	}
	public void setInstitutionName(String institutionName) {
		this.institutionName = institutionName;
	}
	public String getOtherPurpose() {
		return otherPurpose;
	}
	public void setOtherPurpose(String otherPurpose) {
		this.otherPurpose = otherPurpose;
	}
	public String getRequestedDate() {
		return requestedDate;
	}
	public void setRequestedDate(String requestedDate) {
		this.requestedDate = requestedDate;
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
	public String getVehicleNumber() {
		return vehicleNumber;
	}
	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	
}
