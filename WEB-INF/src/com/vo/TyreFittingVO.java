package com.vo;

import org.apache.log4j.Logger;
import java.util.*;
public class TyreFittingVO {
	private static final Logger logger=(Logger)Logger.getLogger(TyreFittingVO.class);
	private String instId;
	private String instDesc;
	private String typeId;
	private String typeDesc;
	private String vehicleId;
	private String vehicleDesc;
	private String tyreStatus=null;
	private String tyrePosition=null;
	private String fittingDate=null;
	private String fittingKM=null;
	private String tyresizeCode=null;
	private String tyresizeCtype=null;
	private String tyresizeCdesc=null;
	private String tyrebrandCode=null;
	private String tyrebrandCtype=null;
	private String tyrebrandCdesc=null;
	private String tyreplyCode=null;
	private String tyreplyCtype=null;
	private String tyreplyCdesc=null;
	private String tyrepositionCode=null;
	private String tyrepositionCtype=null;
	private String tyrepositionCdesc=null;
	private String tyrenumberCode=null;
	private String tyrenumberCtype=null;
	private String tyrenumberCdesc=null;
	
	
	private String institutionName=null;
	private String vehicleType=null;
	private String vehicleNumber=null;
	private String tyreSize=null;
	private String tyrePly=null;
	private String tyreBrand=null;
	private String tyreNumber=null;
	
	public String getFittingDate() {
		return fittingDate;
	}
	public void setFittingDate(String fittingDate) {
		this.fittingDate = fittingDate;
	}
	public String getFittingKM() {
		return fittingKM;
	}
	public void setFittingKM(String fittingKM) {
		this.fittingKM = fittingKM;
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
	public String getInstitutionName() {
		return institutionName;
	}
	public void setInstitutionName(String institutionName) {
		this.institutionName = institutionName;
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
	public String getTyresizeCdesc() {
		return tyresizeCdesc;
	}
	public void setTyresizeCdesc(String tyresizeCdesc) {
		this.tyresizeCdesc = tyresizeCdesc;
	}
	public String getTyresizeCode() {
		return tyresizeCode;
	}
	public void setTyresizeCode(String tyresizeCode) {
		this.tyresizeCode = tyresizeCode;
	}
	public String getTyresizeCtype() {
		return tyresizeCtype;
	}
	public void setTyresizeCtype(String tyresizeCtype) {
		this.tyresizeCtype = tyresizeCtype;
	}
	public String getTyrebrandCdesc() {
		return tyrebrandCdesc;
	}
	public void setTyrebrandCdesc(String tyrebrandCdesc) {
		this.tyrebrandCdesc = tyrebrandCdesc;
	}
	public String getTyrebrandCode() {
		return tyrebrandCode;
	}
	public void setTyrebrandCode(String tyrebrandCode) {
		this.tyrebrandCode = tyrebrandCode;
	}
	public String getTyrebrandCtype() {
		return tyrebrandCtype;
	}
	public void setTyrebrandCtype(String tyrebrandCtype) {
		this.tyrebrandCtype = tyrebrandCtype;
	}
	public String getTyreplyCdesc() {
		return tyreplyCdesc;
	}
	public void setTyreplyCdesc(String tyreplyCdesc) {
		this.tyreplyCdesc = tyreplyCdesc;
	}
	public String getTyreplyCode() {
		return tyreplyCode;
	}
	public void setTyreplyCode(String tyreplyCode) {
		this.tyreplyCode = tyreplyCode;
	}
	public String getTyreplyCtype() {
		return tyreplyCtype;
	}
	public void setTyreplyCtype(String tyreplyCtype) {
		this.tyreplyCtype = tyreplyCtype;
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
