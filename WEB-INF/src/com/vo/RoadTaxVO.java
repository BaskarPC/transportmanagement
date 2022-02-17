package com.vo;
import org.apache.struts.validator.ValidatorForm;
import java.util.ArrayList;


public class RoadTaxVO extends ValidatorForm{
	
	
	private String seatCapacity=null;
	private String ratePerSeat=null;
	private String taxAmt=null;
	private String roadTaxPeriod=null;
	 private ArrayList seqid=null;
	private String percentOfReduction=null;
	private String reductionAmt=null;
	private String totalAmtAfterReduction=null;
	private String subTaxPercent=null;
	private String subTaxAmt=null;
	private String grandTotal=null;
	private String others=null;
	private String instituteName=null;
	 private ArrayList instList=null;
	 private String instdesc=null;
	 private String instcode=null;
	private String vehicleType=null;
	private String vehicleId=null;
	private ArrayList vehicleidList=null;
	private ArrayList vehicletypeList=null;
	private String yesNoOption=null;
	
	 private String vehicleiddesc=null;
	 private String vehicleidcode=null;
	 private String vehicletypedesc=null;
	 private String vehicletypecode=null;
	 private ArrayList periodList=null;
	 private ArrayList optionList=null;
	 private String optioncode=null;
	 private String optiondesc=null;
	 private String periodcode=null;
	 private String perioddesc=null;
	
		
	/**
	 * @return the vehicleidcode
	 */
	public String getVehicleidcode() {
		return vehicleidcode;
	}
	/**
	 * @param vehicleidcode the vehicleidcode to set
	 */
	public void setVehicleidcode(String vehicleidcode) {
		this.vehicleidcode = vehicleidcode;
	}
	/**
	 * @return the vehicleiddesc
	 */
	public String getVehicleiddesc() {
		return vehicleiddesc;
	}
	/**
	 * @param vehicleiddesc the vehicleiddesc to set
	 */
	public void setVehicleiddesc(String vehicleiddesc) {
		this.vehicleiddesc = vehicleiddesc;
	}
	/**
	 * @return the vehicletypecode
	 */
	public String getVehicletypecode() {
		return vehicletypecode;
	}
	/**
	 * @param vehicletypecode the vehicletypecode to set
	 */
	public void setVehicletypecode(String vehicletypecode) {
		this.vehicletypecode = vehicletypecode;
	}
	/**
	 * @return the vehicletypedesc
	 */
	public String getVehicletypedesc() {
		return vehicletypedesc;
	}
	/**
	 * @param vehicletypedesc the vehicletypedesc to set
	 */
	public void setVehicletypedesc(String vehicletypedesc) {
		this.vehicletypedesc = vehicletypedesc;
	}
	public String getGrandTotal() {
		return grandTotal;
	}
	public void setGrandTotal(String grandTotal) {
		this.grandTotal = grandTotal;
	}
	
	public String getPercentOfReduction() {
		return percentOfReduction;
	}
	public void setPercentOfReduction(String percentOfReduction) {
		this.percentOfReduction = percentOfReduction;
	}
	public String getRatePerSeat() {
		return ratePerSeat;
	}
	public void setRatePerSeat(String ratePerSeat) {
		this.ratePerSeat = ratePerSeat;
	}
	public String getReductionAmt() {
		return reductionAmt;
	}
	public void setReductionAmt(String reductionAmt) {
		this.reductionAmt = reductionAmt;
	}
	public String getRoadTaxPeriod() {
		return roadTaxPeriod;
	}
	public void setRoadTaxPeriod(String roadTaxPeriod) {
		this.roadTaxPeriod = roadTaxPeriod;
	}
	public String getSeatCapacity() {
		return seatCapacity;
	}
	public void setSeatCapacity(String seatCapacity) {
		this.seatCapacity = seatCapacity;
	}
	public String getSubTaxAmt() {
		return subTaxAmt;
	}
	public void setSubTaxAmt(String subTaxAmt) {
		this.subTaxAmt = subTaxAmt;
	}
	public String getSubTaxPercent() {
		return subTaxPercent;
	}
	public void setSubTaxPercent(String subTaxPercent) {
		this.subTaxPercent = subTaxPercent;
	}
	public String getTaxAmt() {
		return taxAmt;
	}
	public void setTaxAmt(String taxAmt) {
		this.taxAmt = taxAmt;
	}
	public String getTotalAmtAfterReduction() {
		return totalAmtAfterReduction;
	}
	public void setTotalAmtAfterReduction(String totalAmtAfterReduction) {
		this.totalAmtAfterReduction = totalAmtAfterReduction;
	}
	
	public String getOthers() {
		return others;
	}
	public void setOthers(String others) {
		this.others = others;
	}
	
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	
	public ArrayList getSeqid() {
		return seqid;
	}
	public void setSeqid(ArrayList seqid) {
		this.seqid = seqid;
	}
	/**
	 * @return the instcode
	 */
	public String getInstcode() {
		return instcode;
	}
	/**
	 * @param instcode the instcode to set
	 */
	public void setInstcode(String instcode) {
		this.instcode = instcode;
	}
	/**
	 * @return the instdesc
	 */
	public String getInstdesc() {
		return instdesc;
	}
	/**
	 * @param instdesc the instdesc to set
	 */
	public void setInstdesc(String instdesc) {
		this.instdesc = instdesc;
	}
	/**
	 * @return the instituteName
	 */
	public String getInstituteName() {
		return instituteName;
	}
	/**
	 * @param instituteName the instituteName to set
	 */
	public void setInstituteName(String instituteName) {
		this.instituteName = instituteName;
	}
	/**
	 * @return the instList
	 */
	public ArrayList getInstList() {
		return instList;
	}
	/**
	 * @param instList the instList to set
	 */
	public void setInstList(ArrayList instList) {
		this.instList = instList;
	}
	/**
	 * @return the vehicleId
	 */
	public String getVehicleId() {
		return vehicleId;
	}
	/**
	 * @param vehicleId the vehicleId to set
	 */
	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}
		
	/**
	 * @return the yesNoOption
	 */
	public String getYesNoOption() {
		return yesNoOption;
	}
	/**
	 * @param yesNoOption the yesNoOption to set
	 */
	public void setYesNoOption(String yesNoOption) {
		this.yesNoOption = yesNoOption;
	}
	
	/**
	 * @return the vehicleidList
	 */
	public ArrayList getVehicleidList() {
		return vehicleidList;
	}
	/**
	 * @param vehicleidList the vehicleidList to set
	 */
	public void setVehicleidList(ArrayList vehicleidList) {
		this.vehicleidList = vehicleidList;
	}
	/**
	 * @return the vehicletypeList
	 */
	public ArrayList getVehicletypeList() {
		return vehicletypeList;
	}
	/**
	 * @param vehicletypeList the vehicletypeList to set
	 */
	public void setVehicletypeList(ArrayList vehicletypeList) {
		this.vehicletypeList = vehicletypeList;
	}
	/**
	 * @return the optioncode
	 */
	public String getOptioncode() {
		return optioncode;
	}
	/**
	 * @param optioncode the optioncode to set
	 */
	public void setOptioncode(String optioncode) {
		this.optioncode = optioncode;
	}
	/**
	 * @return the optiondesc
	 */
	public String getOptiondesc() {
		return optiondesc;
	}
	/**
	 * @param optiondesc the optiondesc to set
	 */
	public void setOptiondesc(String optiondesc) {
		this.optiondesc = optiondesc;
	}
	/**
	 * @return the optionList
	 */
	public ArrayList getOptionList() {
		return optionList;
	}
	/**
	 * @param optionList the optionList to set
	 */
	public void setOptionList(ArrayList optionList) {
		this.optionList = optionList;
	}
	/**
	 * @return the periodcode
	 */
	public String getPeriodcode() {
		return periodcode;
	}
	/**
	 * @param periodcode the periodcode to set
	 */
	public void setPeriodcode(String periodcode) {
		this.periodcode = periodcode;
	}
	/**
	 * @return the perioddesc
	 */
	public String getPerioddesc() {
		return perioddesc;
	}
	/**
	 * @param perioddesc the perioddesc to set
	 */
	public void setPerioddesc(String perioddesc) {
		this.perioddesc = perioddesc;
	}
	/**
	 * @return the periodList
	 */
	public ArrayList getPeriodList() {
		return periodList;
	}
	/**
	 * @param periodList the periodList to set
	 */
	public void setPeriodList(ArrayList periodList) {
		this.periodList = periodList;
	}

	


}
