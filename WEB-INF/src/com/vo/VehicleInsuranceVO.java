package com.vo;

import java.util.ArrayList;

public class VehicleInsuranceVO {
	private String vehicleModel=null;
	private String vehicleId=null;
	private ArrayList instList=null;
	private String instituteName=null;
	private String vehicleType=null;
	private ArrayList vehicletypeList;
	private String insuranceValidFrom=null;
	private String insuranceValidTo=null;
	private String marketValue=null;
	private String vehicleidcode=null;
	private String vehicleiddesc=null;
	private ArrayList vehicleidList=null;
	private String vehicletypecode=null;
	private String vehicletypedesc=null;
	
	private String existInsuranceCmpyName=null;
	private String existVehicleValue=null;
	private String existInsurancePremiumAmt=null;
	private String proposedInsuranceCmpyName=null;
	private String proposedVehicleValue=null;
	private String proposedInsurancePremiumAmt=null;
	
	private String instcode=null;
	private String instdesc=null;
	
	public String getInstcode() {
		return instcode;
	}
	public void setInstcode(String instcode) {
		this.instcode = instcode;
	}
	public String getInstdesc() {
		return instdesc;
	}
	public void setInstdesc(String instdesc) {
		this.instdesc = instdesc;
	}
	public String getExistInsuranceCmpyName() {
		return existInsuranceCmpyName;
	}
	public void setExistInsuranceCmpyName(String existInsuranceCmpyName) {
		this.existInsuranceCmpyName = existInsuranceCmpyName;
	}
	public String getExistInsurancePremiumAmt() {
		return existInsurancePremiumAmt;
	}
	public void setExistInsurancePremiumAmt(String existInsurancePremiumAmt) {
		this.existInsurancePremiumAmt = existInsurancePremiumAmt;
	}
	public String getExistVehicleValue() {
		return existVehicleValue;
	}
	public void setExistVehicleValue(String existVehicleValue) {
		this.existVehicleValue = existVehicleValue;
	}
	
	public String getInsuranceValidFrom() {
		return insuranceValidFrom;
	}
	public void setInsuranceValidFrom(String insuranceValidFrom) {
		this.insuranceValidFrom = insuranceValidFrom;
	}
	public String getInsuranceValidTo() {
		return insuranceValidTo;
	}
	public void setInsuranceValidTo(String insuranceValidTo) {
		this.insuranceValidTo = insuranceValidTo;
	}
	public String getMarketValue() {
		return marketValue;
	}
	public void setMarketValue(String marketValue) {
		this.marketValue = marketValue;
	}
	public String getProposedInsuranceCmpyName() {
		return proposedInsuranceCmpyName;
	}
	public void setProposedInsuranceCmpyName(String proposedInsuranceCmpyName) {
		this.proposedInsuranceCmpyName = proposedInsuranceCmpyName;
	}
	public String getProposedInsurancePremiumAmt() {
		return proposedInsurancePremiumAmt;
	}
	public void setProposedInsurancePremiumAmt(String proposedInsurancePremiumAmt) {
		this.proposedInsurancePremiumAmt = proposedInsurancePremiumAmt;
	}
	public String getProposedVehicleValue() {
		return proposedVehicleValue;
	}
	public void setProposedVehicleValue(String proposedVehicleValue) {
		this.proposedVehicleValue = proposedVehicleValue;
	}
	public String getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getVehicleModel() {
		return vehicleModel;
	}
	public void setVehicleModel(String vehicleModel) {
		this.vehicleModel = vehicleModel;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	public void setInstList(ArrayList instList) {
		this.instList = instList;
	}
	public String getInstituteName() {
		return instituteName;
	}
	public void setInstituteName(String instituteName) {
		this.instituteName = instituteName;
	}
	public ArrayList getInstList() {
		return instList;
	}
	
	public String getVehicleidcode() {
		return vehicleidcode;
	}
	public void setVehicleidcode(String vehicleidcode) {
		this.vehicleidcode = vehicleidcode;
	}
	public String getVehicleiddesc() {
		return vehicleiddesc;
	}
	public void setVehicleiddesc(String vehicleiddesc) {
		this.vehicleiddesc = vehicleiddesc;
	}

	public ArrayList getVehicleidList() {
		return vehicleidList;
	}
	public void setVehicleidList(ArrayList vehicleidList) {
		this.vehicleidList = vehicleidList;
	}
	public String getVehicletypecode() {
		return vehicletypecode;
	}
	public void setVehicletypecode(String vehicletypecode) {
		this.vehicletypecode = vehicletypecode;
	}
	public String getVehicletypedesc() {
		return vehicletypedesc;
	}
	public void setVehicletypedesc(String vehicletypedesc) {
		this.vehicletypedesc = vehicletypedesc;
	}
	
	public ArrayList getVehicletypeList() {
		return vehicletypeList;
	}
	public void setVehicletypeList(ArrayList vehicletypeList) {
		this.vehicletypeList = vehicletypeList;
	}
}
