package com.vo;

import org.apache.log4j.Logger;

public class TyreRemovalVO {

	private static final Logger logger=(Logger)Logger.getLogger(TyreRemovalVO.class);
	private String institutionName=null;
	private String vehicleType=null;
	private String vehicleNumber=null;
	private String tyreNumber=null;
	private String tyreStatus=null;
	private String tyrePosition=null;
	private String removalDate=null;
	private String fittingKM=null;
	private String removalKM=null;
	private String totalKM=null;
	private String removalReason=null;
	
	private String instId;
	private String instDesc;
	private String typeId;
	private String typeDesc;
	private String vehicleId;
	private String vehicleDesc;
	
	private String tyrenumberCode=null;
	private String tyrenumberCtype=null;
	private String tyrenumberCdesc=null;
	private String tyrepositionCdesc=null;
	private String tyrepositionCode=null;
	private String tyrepositionCtype=null;
	
	public String getInstDesc() {
		return instDesc;
	}
	public void setInstDesc(String instDesc) {
		this.instDesc = instDesc;
	}
	public String getInstId() {
		return instId;
	}
	public void setInstId(String instId) {
		this.instId = instId;
	}
	public String getTypeDesc() {
		return typeDesc;
	}
	public void setTypeDesc(String typeDesc) {
		this.typeDesc = typeDesc;
	}
	public String getTypeId() {
		return typeId;
	}
	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}
	public String getTyrenumberCdesc() {
		return tyrenumberCdesc;
	}
	public void setTyrenumberCdesc(String tyrenumberCdesc) {
		this.tyrenumberCdesc = tyrenumberCdesc;
	}
	public String getTyrenumberCode() {
		return tyrenumberCode;
	}
	public void setTyrenumberCode(String tyrenumberCode) {
		this.tyrenumberCode = tyrenumberCode;
	}
	public String getTyrenumberCtype() {
		return tyrenumberCtype;
	}
	public void setTyrenumberCtype(String tyrenumberCtype) {
		this.tyrenumberCtype = tyrenumberCtype;
	}
	public String getVehicleDesc() {
		return vehicleDesc;
	}
	public void setVehicleDesc(String vehicleDesc) {
		this.vehicleDesc = vehicleDesc;
	}
	public String getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
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
	public String getTyreNumber() {
		return tyreNumber;
	}
	public void setTyreNumber(String tyreNumber) {
		this.tyreNumber = tyreNumber;
	}
	public String getInstitutionName() {
		return institutionName;
	}
	public void setInstitutionName(String institutionName) {
		this.institutionName = institutionName;
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
	public String getTyrepositionCdesc() {
		return tyrepositionCdesc;
	}
	public void setTyrepositionCdesc(String tyrepositionCdesc) {
		this.tyrepositionCdesc = tyrepositionCdesc;
	}
	public String getTyrepositionCode() {
		return tyrepositionCode;
	}
	public void setTyrepositionCode(String tyrepositionCode) {
		this.tyrepositionCode = tyrepositionCode;
	}
	public String getTyrepositionCtype() {
		return tyrepositionCtype;
	}
	public void setTyrepositionCtype(String tyrepositionCtype) {
		this.tyrepositionCtype = tyrepositionCtype;
	}
	
}
