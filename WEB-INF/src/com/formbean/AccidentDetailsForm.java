package com.formbean;
import org.apache.struts.validator.ValidatorForm;
import java.util.ArrayList;

public class AccidentDetailsForm extends ValidatorForm{
	
	private String accidentDate=null;
	private String accidentTime=null;
	private String accidentPlace=null;
	private String nearByPoliceStation=null;
	private String vehicleType=null;
	private String vehicleId=null;
	private String instituteName1=null;
	private String instituteName=null;
	private String driverId=null;
	private String expense=null;
	private String FIROption=null;
	private String caseOption=null;
	private String insuranceOption=null;
	
	private ArrayList driverIdList=null;
	private ArrayList expenseList=null;
	private ArrayList instituteName1List=null;
	private ArrayList vehicleIdList=null;
	private ArrayList vehicleTypeList=null;
	private ArrayList instituteNameList=null;
	private ArrayList caseList=null;
	private ArrayList insuranceList=null;
	private ArrayList FIRList=null;
	
	private String driverName=null;
	private String opponentVehicleId=null;
	private String opponentVehicleType=null;
	private String noOfPersonsInjured=null;	
	private String amtClaimedFromInsurance=null;
	private String amtClaimedFromOpponent=null;
	private String driverPaid=null;
	private String amtPaidByInstitute=null;
	private String accidentDesc=null;

	private String vehicleidcode=null;
	private String vehicleiddesc=null;
	private String vehicletypecode=null;
	private String vehicletypedesc=null;
	private String drivercode=null;
	private String driverdesc=null;
	private String instcode=null;
	private String instdesc=null;
	private String inst1code=null;
	private String inst1desc=null;
	private String casecode=null;
	private String casedesc=null;
	private String insurancecode=null;
	private String insurancedesc=null;
	private String FIRcode=null;
	private String FIRdesc=null;
	private String optioncode=null;
	private String optiondesc=null;
	private String expensecode=null;
	private String expensedesc=null;
	private String drivernamedesc=null;
	
	public String getDrivernamedesc() {
		return drivernamedesc;
	}
	public void setDrivernamedesc(String drivernamedesc) {
		this.drivernamedesc = drivernamedesc;
	}
	public String getExpense() {
		return expense;
	}
	public void setExpense(String expense) {
		this.expense = expense;
	}
	public String getExpensecode() {
		return expensecode;
	}
	public void setExpensecode(String expensecode) {
		this.expensecode = expensecode;
	}
	public String getExpensedesc() {
		return expensedesc;
	}
	public void setExpensedesc(String expensedesc) {
		this.expensedesc = expensedesc;
	}
	public ArrayList getExpenseList() {
		return expenseList;
	}
	public void setExpenseList(ArrayList expenseList) {
		this.expenseList = expenseList;
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
	public String getAccidentDate() {
		return accidentDate;
	}
	public void setAccidentDate(String accidentDate) {
		this.accidentDate = accidentDate;
	}
	public String getAccidentDesc() {
		return accidentDesc;
	}
	public void setAccidentDesc(String accidentDesc) {
		this.accidentDesc = accidentDesc;
	}
	public String getAccidentPlace() {
		return accidentPlace;
	}
	public void setAccidentPlace(String accidentPlace) {
		this.accidentPlace = accidentPlace;
	}
	public String getAccidentTime() {
		return accidentTime;
	}
	public void setAccidentTime(String accidentTime) {
		this.accidentTime = accidentTime;
	}
	
	public String getDriverPaid() {
		return driverPaid;
	}
	public void setDriverPaid(String driverPaid) {
		this.driverPaid = driverPaid;
	}
	public String getOpponentVehicleId() {
		return opponentVehicleId;
	}
	public void setOpponentVehicleId(String opponentVehicleId) {
		this.opponentVehicleId = opponentVehicleId;
	}
	public String getOpponentVehicleType() {
		return opponentVehicleType;
	}
	public void setOpponentVehicleType(String opponentVehicleType) {
		this.opponentVehicleType = opponentVehicleType;
	}
			
	public String getAmtClaimedFromInsurance() {
		return amtClaimedFromInsurance;
	}
	public void setAmtClaimedFromInsurance(String amtClaimedFromInsurance) {
		this.amtClaimedFromInsurance = amtClaimedFromInsurance;
	}
	public String getAmtClaimedFromOpponent() {
		return amtClaimedFromOpponent;
	}
	public void setAmtClaimedFromOpponent(String amtClaimedFromOpponent) {
		this.amtClaimedFromOpponent = amtClaimedFromOpponent;
	}
	public String getNearByPoliceStation() {
		return nearByPoliceStation;
	}
	public void setNearByPoliceStation(String nearByPoliceStation) {
		this.nearByPoliceStation = nearByPoliceStation;
	}
	public String getNoOfPersonsInjured() {
		return noOfPersonsInjured;
	}
	public void setNoOfPersonsInjured(String noOfPersonsInjured) {
		this.noOfPersonsInjured = noOfPersonsInjured;
	}
	public String getAmtPaidByInstitute() {
		return amtPaidByInstitute;
	}
	public void setAmtPaidByInstitute(String amtPaidByInstitute) {
		this.amtPaidByInstitute = amtPaidByInstitute;
	}
		public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	public ArrayList getVehicleIdList() {
		return vehicleIdList;
	}
	public void setVehicleIdList(ArrayList vehicleIdList) {
		this.vehicleIdList = vehicleIdList;
	}
		
	public ArrayList getInstituteNameList() {
		return instituteNameList;
	}
	public void setInstituteNameList(ArrayList instituteNameList) {
		this.instituteNameList = instituteNameList;
	}
	public ArrayList getVehicleTypeList() {
		return vehicleTypeList;
	}
	public void setVehicleTypeList(ArrayList vehicleTypeList) {
		this.vehicleTypeList = vehicleTypeList;
	}
	public String getInstituteName1() {
		return instituteName1;
	}
	public void setInstituteName1(String instituteName1) {
		this.instituteName1 = instituteName1;
	}
	
	public ArrayList getDriverIdList() {
		return driverIdList;
	}
	public void setDriverIdList(ArrayList driverIdList) {
		this.driverIdList = driverIdList;
	}
	public String getDriverId() {
		return driverId;
	}
	public void setDriverId(String driverId) {
		this.driverId = driverId;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	public String getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getCasecode() {
		return casecode;
	}
	public void setCasecode(String casecode) {
		this.casecode = casecode;
	}
	public String getCasedesc() {
		return casedesc;
	}
	public void setCasedesc(String casedesc) {
		this.casedesc = casedesc;
	}
	public ArrayList getCaseList() {
		return caseList;
	}
	public void setCaseList(ArrayList caseList) {
		this.caseList = caseList;
	}
	public String getCaseOption() {
		return caseOption;
	}
	public void setCaseOption(String caseOption) {
		this.caseOption = caseOption;
	}
	public String getFIRcode() {
		return FIRcode;
	}
	public void setFIRcode(String rcode) {
		FIRcode = rcode;
	}
	public String getFIRdesc() {
		return FIRdesc;
	}
	public void setFIRdesc(String rdesc) {
		FIRdesc = rdesc;
	}
	public ArrayList getFIRList() {
		return FIRList;
	}
	public void setFIRList(ArrayList list) {
		FIRList = list;
	}
	public String getFIROption() {
		return FIROption;
	}
	public void setFIROption(String option) {
		FIROption = option;
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
	public ArrayList getInsuranceList() {
		return insuranceList;
	}
	public void setInsuranceList(ArrayList insuranceList) {
		this.insuranceList = insuranceList;
	}
	public String getInsuranceOption() {
		return insuranceOption;
	}
	public void setInsuranceOption(String insuranceOption) {
		this.insuranceOption = insuranceOption;
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
	public ArrayList getInstituteName1List() {
		return instituteName1List;
	}
	public void setInstituteName1List(ArrayList instituteName1List) {
		this.instituteName1List = instituteName1List;
	}
	public String getInstituteName() {
		return instituteName;
	}
	public void setInstituteName(String instituteName) {
		this.instituteName = instituteName;
	}
	public String getInst1code() {
		return inst1code;
	}
	public void setInst1code(String inst1code) {
		this.inst1code = inst1code;
	}
	public String getInst1desc() {
		return inst1desc;
	}
	public void setInst1desc(String inst1desc) {
		this.inst1desc = inst1desc;
	}
	public String getDrivercode() {
		return drivercode;
	}
	public void setDrivercode(String drivercode) {
		this.drivercode = drivercode;
	}
	public String getDriverdesc() {
		return driverdesc;
	}
	public void setDriverdesc(String driverdesc) {
		this.driverdesc = driverdesc;
	}
	
}
