package com.formbean;

import org.apache.log4j.Logger;

public class ScrapIssueForm extends GeneralForm{
	private static final Logger logger=(Logger)Logger.getLogger(ScrapIssueForm.class);
	private String companyName=null;
	private String categoryName=null;
	private String availableQuantity=null;
	private String quantitySold=null;
	private String remainingQuantity=null;
	/**
	 * @return the availableQuantity
	 */
	public String getAvailableQuantity() {
		return availableQuantity;
	}
	/**
	 * @param availableQuantity the availableQuantity to set
	 */
	public void setAvailableQuantity(String availableQuantity) {
		this.availableQuantity = availableQuantity;
	}
	/**
	 * @return the categoryName
	 */
	public String getCategoryName() {
		return categoryName;
	}
	/**
	 * @param categoryName the categoryName to set
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
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
	 * @return the quantitySold
	 */
	public String getQuantitySold() {
		return quantitySold;
	}
	/**
	 * @param quantitySold the quantitySold to set
	 */
	public void setQuantitySold(String quantitySold) {
		this.quantitySold = quantitySold;
	}
	/**
	 * @return the remainingQuantity
	 */
	public String getRemainingQuantity() {
		return remainingQuantity;
	}
	/**
	 * @param remainingQuantity the remainingQuantity to set
	 */
	public void setRemainingQuantity(String remainingQuantity) {
		this.remainingQuantity = remainingQuantity;
	}
	
	

}
