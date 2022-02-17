package com.vo;
import java.util.ArrayList;

public class VehicleVo {
	private String dateOfPurchase=null;
	private String manufacturingDate=null;
	private String instituteName=null;
	private String price=null;
	private String supplierName=null;
	private String vehicleType=null;
	private String make=null;
	private String chassisNo=null;
	private String engineNo=null;
	private String bodyType=null;
	private String tankCapacity=null;
	private String seatCapacity=null;
	private String wheelBase=null;
	private String vehicleStatus=null;
	private String roadyesNoOption=null;
	private String roadTaxFrom=null;
	private String roadTaxTo=null;
	private String insuranceOption=null;
	private String insuranceFrom=null;
	private String insuranceTo=null;
	private String insuranceCmpyName=null;
	private String fcExpiryDate=null;
	private String validPermitDate=null;
	private String othersInsitution=null;
	private String others=null;
	private String vehicleId=null;
	private String seqid=null;
	
	
	private ArrayList instituteNameList=null;
	private ArrayList vehicleList=null;
	private ArrayList vehiclestatusList=null;
	private ArrayList yesNoOptionList=null;
	private ArrayList insuranceOptionList=null;
		
	private String instdesc=null;
	private String instcode=null;
	private String vehiclestatusdesc=null;
	private String vehiclestatuscode=null;
	private String vehicletypedesc=null;
	private String vehicletypecode=null;
	private String optiondesc=null;
	private String optioncode=null;
	private String vehicleidcode=null;
	private String vehicleiddesc=null;
	private String insurancecode=null;
	private String insurancedesc=null;
	
	public String getBodyType() {
		return bodyType;
	}
	public void setBodyType(String bodyType) {
		this.bodyType = bodyType;
	}
	public String getChassisNo() {
		return chassisNo;
	}
	public void setChassisNo(String chassisNo) {
		this.chassisNo = chassisNo;
	}
	public String getDateOfPurchase() {
		return dateOfPurchase;
	}
	public void setDateOfPurchase(String dateOfPurchase) {
		this.dateOfPurchase = dateOfPurchase;
	}
	public String getEngineNo() {
		return engineNo;
	}
	public void setEngineNo(String engineNo) {
		this.engineNo = engineNo;
	}
	public String getFcExpiryDate() {
		return fcExpiryDate;
	}
	public void setFcExpiryDate(String fcExpiryDate) {
		this.fcExpiryDate = fcExpiryDate;
	}
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
	public String getInstituteName() {
		return instituteName;
	}
	public void setInstituteName(String instituteName) {
		this.instituteName = instituteName;
	}
	public ArrayList getInstituteNameList() {
		return instituteNameList;
	}
	public void setInstituteNameList(ArrayList instituteNameList) {
		this.instituteNameList = instituteNameList;
	}
	public String getInsuranceCmpyName() {
		return insuranceCmpyName;
	}
	public void setInsuranceCmpyName(String insuranceCmpyName) {
		this.insuranceCmpyName = insuranceCmpyName;
	}
	public String getInsuranceFrom() {
		return insuranceFrom;
	}
	public void setInsuranceFrom(String insuranceFrom) {
		this.insuranceFrom = insuranceFrom;
	}
	public String getInsuranceOption() {
		return insuranceOption;
	}
	public void setInsuranceOption(String insuranceOption) {
		this.insuranceOption = insuranceOption;
	}
	public ArrayList getInsuranceOptionList() {
		return insuranceOptionList;
	}
	public void setInsuranceOptionList(ArrayList insuranceOptionList) {
		this.insuranceOptionList = insuranceOptionList;
	}
	public String getInsuranceTo() {
		return insuranceTo;
	}
	public void setInsuranceTo(String insuranceTo) {
		this.insuranceTo = insuranceTo;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getManufacturingDate() {
		return manufacturingDate;
	}
	public void setManufacturingDate(String manufacturingDate) {
		this.manufacturingDate = manufacturingDate;
	}
	public String getOptioncode() {
		return optioncode;
	}
	public void setOptioncode(String optioncode) {
		this.optioncode = optioncode;
	}
	public String getOptiondesc() {
		return optiondesc;
	}
	public void setOptiondesc(String optiondesc) {
		this.optiondesc = optiondesc;
	}
	public String getOthers() {
		return others;
	}
	public void setOthers(String others) {
		this.others = others;
	}
	public String getOthersInsitution() {
		return othersInsitution;
	}
	public void setOthersInsitution(String othersInsitution) {
		this.othersInsitution = othersInsitution;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getRoadTaxFrom() {
		return roadTaxFrom;
	}
	public void setRoadTaxFrom(String roadTaxFrom) {
		this.roadTaxFrom = roadTaxFrom;
	}
	public String getRoadTaxTo() {
		return roadTaxTo;
	}
	public void setRoadTaxTo(String roadTaxTo) {
		this.roadTaxTo = roadTaxTo;
	}
	public String getRoadyesNoOption() {
		return roadyesNoOption;
	}
	public void setRoadyesNoOption(String roadyesNoOption) {
		this.roadyesNoOption = roadyesNoOption;
	}
	public String getSeatCapacity() {
		return seatCapacity;
	}
	public void setSeatCapacity(String seatCapacity) {
		this.seatCapacity = seatCapacity;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public String getTankCapacity() {
		return tankCapacity;
	}
	public void setTankCapacity(String tankCapacity) {
		this.tankCapacity = tankCapacity;
	}
	public String getValidPermitDate() {
		return validPermitDate;
	}
	public void setValidPermitDate(String validPermitDate) {
		this.validPermitDate = validPermitDate;
	}
	public String getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
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
	public ArrayList getVehicleList() {
		return vehicleList;
	}
	public void setVehicleList(ArrayList vehicleList) {
		this.vehicleList = vehicleList;
	}
	public String getVehicleStatus() {
		return vehicleStatus;
	}
	public void setVehicleStatus(String vehicleStatus) {
		this.vehicleStatus = vehicleStatus;
	}
	public String getVehiclestatuscode() {
		return vehiclestatuscode;
	}
	public void setVehiclestatuscode(String vehiclestatuscode) {
		this.vehiclestatuscode = vehiclestatuscode;
	}
	public String getVehiclestatusdesc() {
		return vehiclestatusdesc;
	}
	public void setVehiclestatusdesc(String vehiclestatusdesc) {
		this.vehiclestatusdesc = vehiclestatusdesc;
	}
	public ArrayList getVehiclestatusList() {
		return vehiclestatusList;
	}
	public void setVehiclestatusList(ArrayList vehiclestatusList) {
		this.vehiclestatusList = vehiclestatusList;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
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
	public String getWheelBase() {
		return wheelBase;
	}
	public void setWheelBase(String wheelBase) {
		this.wheelBase = wheelBase;
	}
	public ArrayList getYesNoOptionList() {
		return yesNoOptionList;
	}
	public void setYesNoOptionList(ArrayList yesNoOptionList) {
		this.yesNoOptionList = yesNoOptionList;
	}
	public String getSeqid() {
		return seqid;
	}
	public void setSeqid(String seqid) {
		this.seqid = seqid;
	}
	public String getInsurancecode() {
		return insurancecode;
	}
	public void setInsurancecode(String insurancecode) {
		this.insurancecode = insurancecode;
	}
	public String getInsurancedesc() {
		return insurancedesc;
	}
	public void setInsurancedesc(String insurancedesc) {
		this.insurancedesc = insurancedesc;
	}

}
