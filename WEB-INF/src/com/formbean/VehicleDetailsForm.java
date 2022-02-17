package com.formbean;
import org.apache.struts.validator.ValidatorForm;
import java.util.ArrayList;

public class VehicleDetailsForm extends ValidatorForm {
	
	private ArrayList vehicleList;
	private String seqid=null;
	private String instituteName;
	private String Insurancepaidyesno;
	private ArrayList instituteNameList;
	private ArrayList yesNoOptionList;
	private ArrayList vehiclestatusList;
	private ArrayList insuranceOptionList;
	
	private String ctype;
	private String cdesc;	
	private String code;
	private String othersInsitution;
	private String dateOfPurchase;
	private String vehicleId;
	private String roadyesNoOption;
	private String insuranceOption;
	private String manufacturingDate;

	private String price;
	private String supplierName;
	
	private String others;
	private String make;
	private String chassisNo;
	private String engineNo;
	private String bodyType;
	private String tankCapacity;
	private String seatCapacity;
	private String wheelBase;

	private String vehicleStatus;
	private String roadTaxFrom;
	private String roadTaxTo;
	private String insuranceFrom;
	private String insuranceTo;
	private String insuranceCmpyName;
	private String fcExpiryDate;
	private String validPermitDate;
	
	private String insurancecode;
	private String insurancedesc;
	private String instdesc;
	private String instcode;
	private String vehiclestatusdesc;
	private String vehiclestatuscode;
	private String vehicletypedesc;
	private String vehicletypecode;
	private String optiondesc;
	private String optioncode;
	private String vehicleidcode;
	private String vehicleiddesc;
	private String vehicleType;
	
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
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
	public String getInsuranceFrom() {
		return insuranceFrom;
	}
	public void setInsuranceFrom(String insuranceFrom) {
		this.insuranceFrom = insuranceFrom;
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
	public String getOthers() {
		return others;
	}
	public void setOthers(String others) {
		this.others = others;
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
	
	public String getWheelBase() {
		return wheelBase;
	}
	public void setWheelBase(String wheelBase) {
		this.wheelBase = wheelBase;
	}
	
	public String getDateOfPurchase() {
		return dateOfPurchase;
	}
	public void setDateOfPurchase(String dateOfPurchase) {
		this.dateOfPurchase = dateOfPurchase;
	}
	public String getRoadTaxTo() {
		return roadTaxTo;
	}
	public void setRoadTaxTo(String roadTaxTo) {
		this.roadTaxTo = roadTaxTo;
	}
	public String getInsuranceCmpyName() {
		return insuranceCmpyName;
	}
	public void setInsuranceCmpyName(String insuranceCmpyName) {
		this.insuranceCmpyName = insuranceCmpyName;
	}
	public String getVehicleStatus() {
		return vehicleStatus;
	}
	public void setVehicleStatus(String vehicleStatus) {
		this.vehicleStatus = vehicleStatus;
	}
	public String getRoadyesNoOption() {
		return roadyesNoOption;
	}
	public void setRoadyesNoOption(String roadyesNoOption) {
		this.roadyesNoOption = roadyesNoOption;
	}
	public String getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}
	public ArrayList getVehicleList() {
		return vehicleList;
	}
	public void setVehicleList(ArrayList vehicleList) {
		this.vehicleList = vehicleList;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	public ArrayList getVehiclestatusList() {
		return vehiclestatusList;
	}
	public void setVehiclestatusList(ArrayList vehiclestatusList) {
		this.vehiclestatusList = vehiclestatusList;
	}
	public String getCdesc() {
		return cdesc;
	}
	public void setCdesc(String cdesc) {
		this.cdesc = cdesc;
	}
	public String getCtype() {
		return ctype;
	}
	public void setCtype(String ctype) {
		this.ctype = ctype;
	}
	public ArrayList getYesNoOptionList() {
		return yesNoOptionList;
	}
	public void setYesNoOptionList(ArrayList yesNoOptionList) {
		this.yesNoOptionList = yesNoOptionList;
	}
	
	public String getOthersInsitution() {
		return othersInsitution;
	}
	public void setOthersInsitution(String othersInsitution) {
		this.othersInsitution = othersInsitution;
	}
	public ArrayList getInstituteNameList() {
		return instituteNameList;
	}
	public void setInstituteNameList(ArrayList instituteNameList) {
		this.instituteNameList = instituteNameList;
	}
	public String getInsurancepaidyesno() {
		return Insurancepaidyesno;
	}
	public void setInsurancepaidyesno(String insurancepaidyesno) {
		Insurancepaidyesno = insurancepaidyesno;
	}
	public String getInstituteName() {
		return instituteName;
	}
	public void setInstituteName(String instituteName) {
		this.instituteName = instituteName;
	}
	public String getSeqid() {
		return seqid;
	}
	public void setSeqid(String seqid) {
		this.seqid = seqid;
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
	
	}
