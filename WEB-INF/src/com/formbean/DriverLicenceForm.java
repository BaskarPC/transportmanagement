package com.formbean;
import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.validator.ValidatorForm;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

public class DriverLicenceForm extends ValidatorForm{
	
	private String seqid=null;
//	private String  driverLicenceNo=null;
	private String licenceNo=null;
	private String batchNo=null;
	private String dateOfLicence=null;
	private String validPeriod=null;
	private String licenceExpiryDate=null;
	private String punishment=null;
	private String endorsement=null;
	private String category=null;
	private String others=null;
	private String driverId=null;
	private String driverName=null;
	private ArrayList driveridList=null;
	private ArrayList endorsementList=null;
	private ArrayList categoryList=null;
	private String[] categoryarray=null;
	private String newcategory=null;
	private String[] endorsementarray=null;
	private String newendorsement=null;
	private String categorycode=null;
	private String endorsementcode=null;
	//driver official 
	
	private String educationalQualification=null;
	private String marks=null;
	private String transport=null;
	private String nonTransport=null;
	private String nonTransportDesc=null;
	private String bloodGroup=null;
	private String department=null;
	private String instituteName=null;
	public String getBloodGroup() {
		return bloodGroup;
	}
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getEducationalQualification() {
		return educationalQualification;
	}
	public void setEducationalQualification(String educationalQualification) {
		this.educationalQualification = educationalQualification;
	}
	public String getInstituteName() {
		return instituteName;
	}
	public void setInstituteName(String instituteName) {
		this.instituteName = instituteName;
	}
	public String getMarks() {
		return marks;
	}
	public void setMarks(String marks) {
		this.marks = marks;
	}
	public String getNonTransport() {
		return nonTransport;
	}
	public void setNonTransport(String nonTransport) {
		this.nonTransport = nonTransport;
	}
	public String getNonTransportDesc() {
		return nonTransportDesc;
	}
	public void setNonTransportDesc(String nonTransportDesc) {
		this.nonTransportDesc = nonTransportDesc;
	}
	public String getTransport() {
		return transport;
	}
	public void setTransport(String transport) {
		this.transport = transport;
	}
	public String getBatchNo() {
		return batchNo;
	}
	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}
	public String getDateOfLicence() {
		return dateOfLicence;
	}
	public void setDateOfLicence(String dateOfLicence) {
		this.dateOfLicence = dateOfLicence;
	}
	
	/*public String getDriverLicenceNo() {
		return driverLicenceNo;
	}
	public void setDriverLicenceNo(String driverLicenceNo) {
		this.driverLicenceNo = driverLicenceNo;
	}*/

	public String getLicenceExpiryDate() {
		return licenceExpiryDate;
	}
	public void setLicenceExpiryDate(String licenceExpiryDate) {
		this.licenceExpiryDate = licenceExpiryDate;
	}
	public String getPunishment() {
		return punishment;
	}
	public void setPunishment(String punishment) {
		this.punishment = punishment;
	}
	public String getValidPeriod() {
		return validPeriod;
	}
	public void setValidPeriod(String validPeriod) {
		this.validPeriod = validPeriod;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getEndorsement() {
		return endorsement;
	}
	public void setEndorsement(String endorsement) {
		this.endorsement = endorsement;
	}
	
	/**
	 * @return the categoryList
	 */
	public ArrayList getCategoryList() {
		return categoryList;
	}
	/**
	 * @param categoryList the categoryList to set
	 */
	public void setCategoryList(ArrayList categoryList) {
		this.categoryList = categoryList;
	}
	/**
	 * @return the driveridList
	 */
	public ArrayList getDriveridList() {
		return driveridList;
	}
	/**
	 * @param driveridList the driveridList to set
	 */
	public void setDriveridList(ArrayList driveridList) {
		this.driveridList = driveridList;
	}
	/**
	 * @return the driverName
	 */
	public String getDriverName() {
		return driverName;
	}
	/**
	 * @param driverName the driverName to set
	 */
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	/**
	 * @return the endorsementList
	 */
	public ArrayList getEndorsementList() {
		return endorsementList;
	}
	/**
	 * @param endorsementList the endorsementList to set
	 */
	public void setEndorsementList(ArrayList endorsementList) {
		this.endorsementList = endorsementList;
	}
	public String getDriverId() {
		return driverId;
	}
	public void setDriverId(String driverId) {
		this.driverId = driverId;
	}
	/**
	 * @return the categoryarray
	 */
	/*public String[] getCategoryarray() {
		return categoryarray;
	}
	/**
	 * @param categoryarray the categoryarray to set
	 */
/*	public void setCategoryarray(String[] categoryarray) {
		this.categoryarray = categoryarray;
	}*/
	/**
	 * @return the categoryarray
	 */
	public String[] getCategoryarray() {
		return categoryarray;
	}
	/**
	 * @param categoryarray the categoryarray to set
	 */
	public void setCategoryarray(String[] categoryarray) {
		this.categoryarray = categoryarray;
	}
	
	public ActionErrors validate(ActionMapping mapping, 
			HttpServletRequest request) 
			{ 
//			 Perform validator framework validations 
			ActionErrors errors = new ActionErrors(); 
//			 Only need crossfield validations here 
			if(StringUtils.isEmpty(licenceNo))
			 {
				 errors.add(ActionErrors.GLOBAL_MESSAGE,new ActionMessage("error.driverLicenceNo.required"));
			 }
			 if(StringUtils.isEmpty(batchNo))
			 {
				 errors.add(ActionErrors.GLOBAL_MESSAGE,new ActionMessage("error.batchNo.required")); 
			 }
			 else if(StringUtils.isAlpha(batchNo))
				{
					errors.add(ActionErrors.GLOBAL_MESSAGE,new ActionMessage("error.batchNo"));
				}
			 if(StringUtils.isEmpty(dateOfLicence))
			 {
				 errors.add(ActionErrors.GLOBAL_MESSAGE,new ActionMessage("error.dateOfLicence.required")); 
			 }
			 if(StringUtils.isEmpty(validPeriod))
				{
					errors.add(ActionErrors.GLOBAL_MESSAGE,new ActionMessage("error.validPeriod.required"));
				}
			 if(StringUtils.isEmpty(licenceExpiryDate))
				{
					errors.add(ActionErrors.GLOBAL_MESSAGE,new ActionMessage("error.licenceExpiryDate.required"));
				}
			 if(StringUtils.isEmpty(punishment))
			 {
				 errors.add(ActionErrors.GLOBAL_MESSAGE,new ActionMessage("error.punishment.required")); 
			 }
			 else if(StringUtils.isNumeric(punishment))
				{
					errors.add(ActionErrors.GLOBAL_MESSAGE,new ActionMessage("error.punishment"));
				}
			 
			return errors; 
			}
	/**
	 * @return the endorsementarray
	 */
	public String[] getEndorsementarray() {
		return endorsementarray;
	}
	/**
	 * @param endorsementarray the endorsementarray to set
	 */
	public void setEndorsementarray(String[] endorsementarray) {
		this.endorsementarray = endorsementarray;
	}
	
	/**
	 * @return the others
	 */
	public String getOthers() {
		return others;
	}
	/**
	 * @param others the others to set
	 */
	public void setOthers(String others) {
		this.others = others;
	}
	/**
	 * @return the seqid
	 */
	/**
	 * @return the seqid
	 */
	public String getSeqid() {
		return seqid;
	}
	/**
	 * @param seqid the seqid to set
	 */
	public void setSeqid(String seqid) {
		this.seqid = seqid;
	}
	public String getCategorycode() {
		return categorycode;
	}
	public void setCategorycode(String categorycode) {
		this.categorycode = categorycode;
	}
	/**
	 * @return the endorsementcode
	 */
	public String getEndorsementcode() {
		return endorsementcode;
	}
	/**
	 * @param endorsementcode the endorsementcode to set
	 */
	public void setEndorsementcode(String endorsementcode) {
		this.endorsementcode = endorsementcode;
	}
	public String getLicenceNo() {
		return licenceNo;
	}
	public void setLicenceNo(String licenceNo) {
		this.licenceNo = licenceNo;
	}
	/**
	 * @return the newcategory
	 */
	public String getNewcategory() {
		return newcategory;
	}
	/**
	 * @param newcategory the newcategory to set
	 */
	public void setNewcategory(String newcategory) {
		this.newcategory = newcategory;
	}
	/**
	 * @return the newendorsement
	 */
	public String getNewendorsement() {
		return newendorsement;
	}
	/**
	 * @param newendorsement the newendorsement to set
	 */
	public void setNewendorsement(String newendorsement) {
		this.newendorsement = newendorsement;
	}
	
	
	
	

}
