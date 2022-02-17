package com.formbean;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.validator.ValidatorForm;

import com.service.RoadTaxService;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

public class RoadTaxForm extends ValidatorForm{
	private static final Logger logger=(Logger)Logger.getLogger(RoadTaxForm.class);
	
	private String seatCapacity=null;
	private String ratePerSeat=null;
	private String taxAmt=null;
	private String roadTaxPeriod=null;
	private String vehicleType=null;
	private String vehicleId=null;
	private ArrayList vehicleidList=null;
	private ArrayList vehicletypeList=null;
	private String percentOfReduction=null;
	private String reductionAmt=null;
	private String totalAmtAfterReduction=null;
	private String subTaxPercent=null;
	private String subTaxAmt=null;
	private String grandTotal=null;
	private String others=null;
	 private String seqid=null;
	 private String instituteName=null;
	 private ArrayList instList=null;
	 private ArrayList periodList=null;
	 private ArrayList optionList=null;
		
	
	private String yesNoOption=null;
	private ArrayList yesNoOptionList=null;
	
	
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
	
	public String getSeqid() {
		return seqid;
	}
	public void setSeqid(String seqid) {
		this.seqid = seqid;
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
	 * @return the yesNoOptionList
	 */
	public ArrayList getYesNoOptionList() {
		return yesNoOptionList;
	}
	/**
	 * @param yesNoOptionList the yesNoOptionList to set
	 */
	public void setYesNoOptionList(ArrayList yesNoOptionList) {
		this.yesNoOptionList = yesNoOptionList;
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
		logger.debug("id list size"+vehicleidList.size());
	
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
	
/*	public ActionErrors validate(ActionMapping mapping, 
			HttpServletRequest request) 
			{ 
			 //Perform validator framework validations 
			ActionErrors errors = new ActionErrors(); 
			 //Only need crossfield validations here 
			if(StringUtils.isEmpty(instituteName))
			{
				errors.add(ActionErrors.GLOBAL_MESSAGE,new ActionMessage("error.instituteName.required"));
			}
			else if(!(StringUtils.isAlpha(instituteName)))
			 {
				 errors.add(ActionErrors.GLOBAL_MESSAGE,new ActionMessage("error.instituteName"));
			 }
			
			if(StringUtils.isEmpty(vehicleType))
			{
				errors.add(ActionErrors.GLOBAL_MESSAGE,new ActionMessage("error.vehicleType.required"));
			}
			else if(!(StringUtils.isAlpha(vehicleType)))
			{
				errors.add(ActionErrors.GLOBAL_MESSAGE,new ActionMessage("error.vehicleType"));
			}
			
			
			return errors; 
			}*/


}
