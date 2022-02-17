package com.vo;

import java.util.ArrayList;

public class DriverLicenceVO {

	private String seqid=null;
	//private String  driverLicenceNo=null;
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
    private String categorycode=null;
	private String endorsementcode=null;
	private String endorsementdesc=null;
	private String categorydesc=null;
	private String drivercode=null;
	private String driverdesc=null;
	private String[] categoryarray=null;
	private String[] endorsementarray=null;
	private String newendorsement=null;
	private String newcategory=null;
	
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
	
	/**
	 * @return the categorydesc
	 */
	public String getCategorydesc() {
		return categorydesc;
	}
	/**
	 * @param categorydesc the categorydesc to set
	 */
	public void setCategorydesc(String categorydesc) {
		this.categorydesc = categorydesc;
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
	 * @return the drivercode
	 */
	public String getDrivercode() {
		return drivercode;
	}
	/**
	 * @param drivercode the drivercode to set
	 */
	public void setDrivercode(String drivercode) {
		this.drivercode = drivercode;
	}
	/**
	 * @return the driverdesc
	 */
	public String getDriverdesc() {
		return driverdesc;
	}
	/**
	 * @param driverdesc the driverdesc to set
	 */
	public void setDriverdesc(String driverdesc) {
		this.driverdesc = driverdesc;
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
	 * @return the endorsementdesc
	 */
	public String getEndorsementdesc() {
		return endorsementdesc;
	}
	/**
	 * @param endorsementdesc the endorsementdesc to set
	 */
	public void setEndorsementdesc(String endorsementdesc) {
		this.endorsementdesc = endorsementdesc;
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
	public String getBatchNo() {
		return batchNo;
	}
	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDateOfLicence() {
		return dateOfLicence;
	}
	public void setDateOfLicence(String dateOfLicence) {
		this.dateOfLicence = dateOfLicence;
	}
	public String getDriverId() {
		return driverId;
	}
	public void setDriverId(String driverId) {
		this.driverId = driverId;
	}
	/*public String getDriverLicenceNo() {
		return driverLicenceNo;
	}
	public void setDriverLicenceNo(String driverLicenceNo) {
		this.driverLicenceNo = driverLicenceNo;
	}*/
	public String getEndorsement() {
		return endorsement;
	}
	public void setEndorsement(String endorsement) {
		this.endorsement = endorsement;
	}
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
	public String getSeqid() {
		return seqid;
	}
	/**
	 * @param seqid the seqid to set
	 */
	public void setSeqid(String seqid) {
		this.seqid = seqid;
	}
	/**
	 * @return the categorycode
	 */
	public String getCategorycode() {
		return categorycode;
	}
	/**
	 * @param categorycode the categorycode to set
	 */
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
	
	
	
	
}
