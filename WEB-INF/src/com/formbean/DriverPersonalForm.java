package com.formbean;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.validator.ValidatorForm;

import com.vo.BusAllotmentVO;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

public class DriverPersonalForm extends ValidatorForm{
	
	private static final Logger logger=(Logger)Logger.getLogger(DriverPersonalForm.class);
	private String seqid=null;
	private String driverId=null;
	private ArrayList driveridList=null;
	private String driverName=null;
	private String permanentAddress=null;
	private String temporaryAddress=null;
	private String district1=null;
	private String district2=null;
	private String state1=null;
	private ArrayList state1List=null;
	private ArrayList state2List=null;
	private ArrayList district2List=null;
	private ArrayList district1List=null;
	private String state2=null;
	private String mobileNo=null;
	private String residentialNo1=null;
	private String residentialNo2=null;
	private String community=null;
	private ArrayList communityList=null;
	private String religion=null;
	private ArrayList religionList=null;
	private String DOB=null;
	private String salary=null;
	private String caste=null;
	private String DOJ=null;
	public String getDOB() {
		return DOB;
	}
	public void setDOB(String dob) {
		DOB = dob;
	}
	public String getDOJ() {
		return DOJ;
	}
	public void setDOJ(String doj) {
		DOJ = doj;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public String getCaste() {
		return caste;
	}
	public void setCaste(String caste) {
		this.caste = caste;
	}
	public String getCommunity() {
		return community;
	}
	public void setCommunity(String community) {
		this.community = community;
	}
	public String getDistrict1() {
		return district1;
	}
	public void setDistrict1(String district1) {
		this.district1 = district1;
	}
	public String getDistrict2() {
		return district2;
	}
	public void setDistrict2(String district2) {
		this.district2 = district2;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getPermanentAddress() {
		return permanentAddress;
	}
	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}
	public String getReligion() {
		return religion;
	}
	public void setReligion(String religion) {
		this.religion = religion;
	}
	public String getResidentialNo1() {
		return residentialNo1;
	}
	public void setResidentialNo1(String residentialNo1) {
		this.residentialNo1 = residentialNo1;
	}
	public String getResidentialNo2() {
		return residentialNo2;
	}
	public void setResidentialNo2(String residentialNo2) {
		this.residentialNo2 = residentialNo2;
	}
	public String getState1() {
		return state1;
	}
	public void setState1(String state1) {
		this.state1 = state1;
	}
	public String getState2() {
		return state2;
	}
	public void setState2(String state2) {
		this.state2 = state2;
	}
	public String getTemporaryAddress() {
		return temporaryAddress;
	}
	public void setTemporaryAddress(String temporaryAddress) {
		this.temporaryAddress = temporaryAddress;
	}
	/**
	 * @return the driverId
	 */
	public String getDriverId() {
		return driverId;
	}
	/**
	 * @param driverId the driverId to set
	 */
	public void setDriverId(String driverId) {
		this.driverId = driverId;
	}
	/**
	 * @return the communityList
	 */
	
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
	 * @return the religionList
	 */
	/**
	 * @return the communityList
	 */
	public ArrayList getCommunityList() {
		return communityList;
	}
	/**
	 * @param communityList the communityList to set
	 */
	public void setCommunityList(ArrayList communityList) {
		this.communityList = communityList;
	}
	/**
	 * @return the district1List
	 */
	public ArrayList getDistrict1List() {
		return district1List;
	}
	/**
	 * @param district1List the district1List to set
	 */
	public void setDistrict1List(ArrayList district1List) {
		this.district1List = district1List;
	}
	/**
	 * @return the district2List
	 */
	public ArrayList getDistrict2List() {
		return district2List;
	}
	/**
	 * @param district2List the district2List to set
	 */
	public void setDistrict2List(ArrayList district2List) {
		this.district2List = district2List;
	}
	/**
	 * @return the religionList
	 */
	public ArrayList getReligionList() {
		return religionList;
	}
	/**
	 * @param religionList the religionList to set
	 */
	public void setReligionList(ArrayList religionList) {
		this.religionList = religionList;
	}
	/**
	 * @return the state1List
	 */
	public ArrayList getState1List() {
		return state1List;
	}
	/**
	 * @param state1List the state1List to set
	 */
	public void setState1List(ArrayList state1List) {
		this.state1List = state1List;
	}
	/**
	 * @return the state2List
	 */
	public ArrayList getState2List() {
		return state2List;
	}
	/**
	 * @param state2List the state2List to set
	 */
	public void setState2List(ArrayList state2List) {
		this.state2List = state2List;
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
	public ArrayList getDriveridList() {
		return driveridList;
	}
	public void setDriveridList(ArrayList driveridList) {
		this.driveridList = driveridList;
	}
	
	public ActionErrors validate(ActionMapping mapping, 
			HttpServletRequest request) 
			{ 
//			 Perform validator framework validations 
			ActionErrors errors = new ActionErrors(); 
//			 Only need crossfield validations here 
			if(StringUtils.isEmpty(driverName))
			 {
				 errors.add(ActionErrors.GLOBAL_MESSAGE,new ActionMessage("error.driverName.required"));
			 }
			else if(StringUtils.isNumeric(driverName))
			 {
				 errors.add(ActionErrors.GLOBAL_MESSAGE,new ActionMessage("error.driverName")); 
			 }
			if(StringUtils.isEmpty(permanentAddress))
			 {
				 errors.add(ActionErrors.GLOBAL_MESSAGE,new ActionMessage("error.permanentAddress.required")); 
			 }
			if(StringUtils.isEmpty(temporaryAddress))
			{
					errors.add(ActionErrors.GLOBAL_MESSAGE,new ActionMessage("error.temporaryAddress.required"));
			}
			if(StringUtils.isEmpty(mobileNo))
			{
					errors.add(ActionErrors.GLOBAL_MESSAGE,new ActionMessage("error.mobileNo.required"));
			}
			else if(StringUtils.isAlpha(mobileNo))
			{
				errors.add(ActionErrors.GLOBAL_MESSAGE,new ActionMessage("error.mobileNo"));
			}	  
			if(StringUtils.isEmpty(residentialNo1))
			{
					errors.add(ActionErrors.GLOBAL_MESSAGE,new ActionMessage("error.residentialNo1.required"));
			}
			else if(StringUtils.isAlpha(residentialNo1))
			{
				errors.add(ActionErrors.GLOBAL_MESSAGE,new ActionMessage("error.residentialNo1"));
			}	  
			if(StringUtils.isEmpty(residentialNo2))
			{
					errors.add(ActionErrors.GLOBAL_MESSAGE,new ActionMessage("error.residentialNo2.required"));
			}
			else if(StringUtils.isAlpha(residentialNo2))
			{
				errors.add(ActionErrors.GLOBAL_MESSAGE,new ActionMessage("error.residentialNo2"));
			}	
			if(StringUtils.isEmpty(DOB))
			{
					errors.add(ActionErrors.GLOBAL_MESSAGE,new ActionMessage("error.DOB.required"));
			}
			if(StringUtils.isEmpty(salary))
			{
					errors.add(ActionErrors.GLOBAL_MESSAGE,new ActionMessage("error.salary.required"));
			}
			else if(StringUtils.isAlpha(salary))
			{
				errors.add(ActionErrors.GLOBAL_MESSAGE,new ActionMessage("error.salary"));
			}
			if(StringUtils.isEmpty(caste))
			{
					errors.add(ActionErrors.GLOBAL_MESSAGE,new ActionMessage("error.caste.required"));
			}
			else if(StringUtils.isNumeric(caste))
			{
				errors.add(ActionErrors.GLOBAL_MESSAGE,new ActionMessage("error.caste"));
			}
			if(StringUtils.isEmpty(DOJ))
			{
					errors.add(ActionErrors.GLOBAL_MESSAGE,new ActionMessage("error.DOJ.required"));
			}
			
			return errors; 
			}
}
