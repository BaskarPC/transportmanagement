package com.formbean;


import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.validator.ValidatorForm;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

public class ScrapForm extends GeneralForm{
	
	private ArrayList instList;
	private ArrayList typeList;
	private ArrayList vehicleList;
	private ArrayList categoryList;
	
	private String institutionName=null;
	private String vehicleType=null;
	private String vehicleNumber=null;
	private String billNumber=null;
	private String requestedDate=null;
	private String companyName=null;
	
	private String scrapCumulativeKilogram=null;
	private String scrapCumulativeGram=null;
		
	private String scrapCategory1=null;
	private String scrapCategory2=null;
	private String scrapCategory3=null;
	private String scrapCategory4=null;
	private String scrapCategory5=null;
	
	private String scrapItemName1=null;
	private String scrapItemName2=null;
	private String scrapItemName3=null;
	private String scrapItemName4=null;
	private String scrapItemName5=null;

	private String scrapItemCount1=null;
	private String scrapItemCount2=null;
	private String scrapItemCount3=null;
	private String scrapItemCount4=null;
	private String scrapItemCount5=null;

	private String scrapKilogram1=null;
	private String scrapKilogram2=null;
	private String scrapKilogram3=null;
	private String scrapKilogram4=null;
	private String scrapKilogram5=null;

	private String scrapGram1=null;
	private String scrapGram2=null;
	private String scrapGram3=null;
	private String scrapGram4=null;
	private String scrapGram5=null;
	/**
	 * @return the companyName
	 */
	public String getCompanyName() {
		return companyName;
	}
	/**
	 * @param companyName the companyName to set
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	/**
	 * @return the scrapCategory1
	 */
	public String getScrapCategory1() {
		return scrapCategory1;
	}
	/**
	 * @param scrapCategory1 the scrapCategory1 to set
	 */
	public void setScrapCategory1(String scrapCategory1) {
		this.scrapCategory1 = scrapCategory1;
	}
	/**
	 * @return the scrapCategory2
	 */
	public String getScrapCategory2() {
		return scrapCategory2;
	}
	/**
	 * @param scrapCategory2 the scrapCategory2 to set
	 */
	public void setScrapCategory2(String scrapCategory2) {
		this.scrapCategory2 = scrapCategory2;
	}
	/**
	 * @return the scrapCategory3
	 */
	public String getScrapCategory3() {
		return scrapCategory3;
	}
	/**
	 * @param scrapCategory3 the scrapCategory3 to set
	 */
	public void setScrapCategory3(String scrapCategory3) {
		this.scrapCategory3 = scrapCategory3;
	}
	/**
	 * @return the scrapCategory4
	 */
	public String getScrapCategory4() {
		return scrapCategory4;
	}
	/**
	 * @param scrapCategory4 the scrapCategory4 to set
	 */
	public void setScrapCategory4(String scrapCategory4) {
		this.scrapCategory4 = scrapCategory4;
	}
	/**
	 * @return the scrapCategory5
	 */
	public String getScrapCategory5() {
		return scrapCategory5;
	}
	/**
	 * @param scrapCategory5 the scrapCategory5 to set
	 */
	public void setScrapCategory5(String scrapCategory5) {
		this.scrapCategory5 = scrapCategory5;
	}
	/**
	 * @return the scrapCumulativeGram
	 */
	public String getScrapCumulativeGram() {
		return scrapCumulativeGram;
	}
	/**
	 * @param scrapCumulativeGram the scrapCumulativeGram to set
	 */
	public void setScrapCumulativeGram(String scrapCumulativeGram) {
		this.scrapCumulativeGram = scrapCumulativeGram;
	}
	/**
	 * @return the scrapCumulativeKilogram
	 */
	public String getScrapCumulativeKilogram() {
		return scrapCumulativeKilogram;
	}
	/**
	 * @param scrapCumulativeKilogram the scrapCumulativeKilogram to set
	 */
	public void setScrapCumulativeKilogram(String scrapCumulativeKilogram) {
		this.scrapCumulativeKilogram = scrapCumulativeKilogram;
	}
	/**
	 * @return the scrapGram1
	 */
	public String getScrapGram1() {
		return scrapGram1;
	}
	/**
	 * @param scrapGram1 the scrapGram1 to set
	 */
	public void setScrapGram1(String scrapGram1) {
		this.scrapGram1 = scrapGram1;
	}
	/**
	 * @return the scrapGram2
	 */
	public String getScrapGram2() {
		return scrapGram2;
	}
	/**
	 * @param scrapGram2 the scrapGram2 to set
	 */
	public void setScrapGram2(String scrapGram2) {
		this.scrapGram2 = scrapGram2;
	}
	/**
	 * @return the scrapGram3
	 */
	public String getScrapGram3() {
		return scrapGram3;
	}
	/**
	 * @param scrapGram3 the scrapGram3 to set
	 */
	public void setScrapGram3(String scrapGram3) {
		this.scrapGram3 = scrapGram3;
	}
	/**
	 * @return the scrapGram4
	 */
	public String getScrapGram4() {
		return scrapGram4;
	}
	/**
	 * @param scrapGram4 the scrapGram4 to set
	 */
	public void setScrapGram4(String scrapGram4) {
		this.scrapGram4 = scrapGram4;
	}
	/**
	 * @return the scrapGram5
	 */
	public String getScrapGram5() {
		return scrapGram5;
	}
	/**
	 * @param scrapGram5 the scrapGram5 to set
	 */
	public void setScrapGram5(String scrapGram5) {
		this.scrapGram5 = scrapGram5;
	}
	/**
	 * @return the scrapItemCount1
	 */
	public String getScrapItemCount1() {
		return scrapItemCount1;
	}
	/**
	 * @param scrapItemCount1 the scrapItemCount1 to set
	 */
	public void setScrapItemCount1(String scrapItemCount1) {
		this.scrapItemCount1 = scrapItemCount1;
	}
	/**
	 * @return the scrapItemCount2
	 */
	public String getScrapItemCount2() {
		return scrapItemCount2;
	}
	/**
	 * @param scrapItemCount2 the scrapItemCount2 to set
	 */
	public void setScrapItemCount2(String scrapItemCount2) {
		this.scrapItemCount2 = scrapItemCount2;
	}
	/**
	 * @return the scrapItemCount3
	 */
	public String getScrapItemCount3() {
		return scrapItemCount3;
	}
	/**
	 * @param scrapItemCount3 the scrapItemCount3 to set
	 */
	public void setScrapItemCount3(String scrapItemCount3) {
		this.scrapItemCount3 = scrapItemCount3;
	}
	/**
	 * @return the scrapItemCount4
	 */
	public String getScrapItemCount4() {
		return scrapItemCount4;
	}
	/**
	 * @param scrapItemCount4 the scrapItemCount4 to set
	 */
	public void setScrapItemCount4(String scrapItemCount4) {
		this.scrapItemCount4 = scrapItemCount4;
	}
	/**
	 * @return the scrapItemCount5
	 */
	public String getScrapItemCount5() {
		return scrapItemCount5;
	}
	/**
	 * @param scrapItemCount5 the scrapItemCount5 to set
	 */
	public void setScrapItemCount5(String scrapItemCount5) {
		this.scrapItemCount5 = scrapItemCount5;
	}
	/**
	 * @return the scrapItemName1
	 */
	public String getScrapItemName1() {
		return scrapItemName1;
	}
	/**
	 * @param scrapItemName1 the scrapItemName1 to set
	 */
	public void setScrapItemName1(String scrapItemName1) {
		this.scrapItemName1 = scrapItemName1;
	}
	/**
	 * @return the scrapItemName2
	 */
	public String getScrapItemName2() {
		return scrapItemName2;
	}
	/**
	 * @param scrapItemName2 the scrapItemName2 to set
	 */
	public void setScrapItemName2(String scrapItemName2) {
		this.scrapItemName2 = scrapItemName2;
	}
	/**
	 * @return the scrapItemName3
	 */
	public String getScrapItemName3() {
		return scrapItemName3;
	}
	/**
	 * @param scrapItemName3 the scrapItemName3 to set
	 */
	public void setScrapItemName3(String scrapItemName3) {
		this.scrapItemName3 = scrapItemName3;
	}
	/**
	 * @return the scrapItemName4
	 */
	public String getScrapItemName4() {
		return scrapItemName4;
	}
	/**
	 * @param scrapItemName4 the scrapItemName4 to set
	 */
	public void setScrapItemName4(String scrapItemName4) {
		this.scrapItemName4 = scrapItemName4;
	}
	/**
	 * @return the scrapItemName5
	 */
	public String getScrapItemName5() {
		return scrapItemName5;
	}
	/**
	 * @param scrapItemName5 the scrapItemName5 to set
	 */
	public void setScrapItemName5(String scrapItemName5) {
		this.scrapItemName5 = scrapItemName5;
	}
	/**
	 * @return the scrapKilogram1
	 */
	public String getScrapKilogram1() {
		return scrapKilogram1;
	}
	/**
	 * @param scrapKilogram1 the scrapKilogram1 to set
	 */
	public void setScrapKilogram1(String scrapKilogram1) {
		this.scrapKilogram1 = scrapKilogram1;
	}
	/**
	 * @return the scrapKilogram2
	 */
	public String getScrapKilogram2() {
		return scrapKilogram2;
	}
	/**
	 * @param scrapKilogram2 the scrapKilogram2 to set
	 */
	public void setScrapKilogram2(String scrapKilogram2) {
		this.scrapKilogram2 = scrapKilogram2;
	}
	/**
	 * @return the scrapKilogram3
	 */
	public String getScrapKilogram3() {
		return scrapKilogram3;
	}
	/**
	 * @param scrapKilogram3 the scrapKilogram3 to set
	 */
	public void setScrapKilogram3(String scrapKilogram3) {
		this.scrapKilogram3 = scrapKilogram3;
	}
	/**
	 * @return the scrapKilogram4
	 */
	public String getScrapKilogram4() {
		return scrapKilogram4;
	}
	/**
	 * @param scrapKilogram4 the scrapKilogram4 to set
	 */
	public void setScrapKilogram4(String scrapKilogram4) {
		this.scrapKilogram4 = scrapKilogram4;
	}
	/**
	 * @return the scrapKilogram5
	 */
	public String getScrapKilogram5() {
		return scrapKilogram5;
	}
	/**
	 * @param scrapKilogram5 the scrapKilogram5 to set
	 */
	public void setScrapKilogram5(String scrapKilogram5) {
		this.scrapKilogram5 = scrapKilogram5;
	}
	/**
	 * @return the billNumber
	 */
	public String getBillNumber() {
		return billNumber;
	}
	/**
	 * @param billNumber the billNumber to set
	 */
	public void setBillNumber(String billNumber) {
		this.billNumber = billNumber;
	}
	/**
	 * @return the institutionName
	 */
	public String getInstitutionName() {
		return institutionName;
	}
	/**
	 * @param institutionName the institutionName to set
	 */
	public void setInstitutionName(String institutionName) {
		this.institutionName = institutionName;
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
	 * @return the requestedDate
	 */
	public String getRequestedDate() {
		return requestedDate;
	}
	/**
	 * @param requestedDate the requestedDate to set
	 */
	public void setRequestedDate(String requestedDate) {
		this.requestedDate = requestedDate;
	}
	/**
	 * @return the typeList
	 */
	public ArrayList getTypeList() {
		return typeList;
	}
	/**
	 * @param typeList the typeList to set
	 */
	public void setTypeList(ArrayList typeList) {
		this.typeList = typeList;
	}
	/**
	 * @return the vehicleList
	 */
	public ArrayList getVehicleList() {
		return vehicleList;
	}
	/**
	 * @param vehicleList the vehicleList to set
	 */
	public void setVehicleList(ArrayList vehicleList) {
		this.vehicleList = vehicleList;
	}
	/**
	 * @return the vehicleNumber
	 */
	public String getVehicleNumber() {
		return vehicleNumber;
	}
	/**
	 * @param vehicleNumber the vehicleNumber to set
	 */
	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	/**
	 * @return the vehicleType
	 */
	public String getVehicleType() {
		return vehicleType;
	}
	/**
	 * @param vehicleType the vehicleType to set
	 */
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
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
	
			
		}