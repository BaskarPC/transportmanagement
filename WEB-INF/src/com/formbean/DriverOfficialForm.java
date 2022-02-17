package com.formbean;
import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.validator.ValidatorForm;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

public class DriverOfficialForm extends ValidatorForm{
	
	
	private String driverId=null;
	private String driverdesc=null;
	private String educationalQualification=null;
	private String marks=null;
	private String transport=null;
	private String nonTransport=null;
	private String nonTransportDesc=null;
	private String licenceNo=null;
	private String insuranceNo=null;
	private String bloodGroup=null;
	private String department=null;
	private String instituteName=null;
	private ArrayList instlist=null;
	private ArrayList deptlist=null;
	private ArrayList bloodgplist=null;
		
	public String getInsuranceNo() {
		return insuranceNo;
	}
	public void setInsuranceNo(String insuranceNo) {
		this.insuranceNo = insuranceNo;
	}
	public String getLicenceNo() {
		return licenceNo;
	}
	public void setLicenceNo(String licenceNo) {
		this.licenceNo = licenceNo;
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
	public String getTransport() {
		return transport;
	}
	public void setTransport(String transport) {
		this.transport = transport;
	}
	public String getEducationalQualification() {
		return educationalQualification;
	}
	public void setEducationalQualification(String educationalQualification) {
		this.educationalQualification = educationalQualification;
	}
	public String getBloodGroup() {
		return bloodGroup;
	}
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	
	
	public String getInstituteName() {
		return instituteName;
	}
	public void setInstituteName(String instituteName) {
		this.instituteName = instituteName;
	}
	
	/**
	 * @return the deptlist
	 */
	public ArrayList getDeptlist() {
		return deptlist;
	}
	/**
	 * @param deptlist the deptlist to set
	 */
	public void setDeptlist(ArrayList deptlist) {
		this.deptlist = deptlist;
	}
	/**
	 * @return the instlist
	 */
	public ArrayList getInstlist() {
		return instlist;
	}
	/**
	 * @param instlist the instlist to set
	 */
	public void setInstlist(ArrayList instlist) {
		this.instlist = instlist;
	}
	/**
	 * @return the bloodgplist
	 */
	public ArrayList getBloodgplist() {
		return bloodgplist;
	}
	/**
	 * @param bloodgplist the bloodgplist to set
	 */
	public void setBloodgplist(ArrayList bloodgplist) {
		this.bloodgplist = bloodgplist;
	}
	/**
	 * @return the department
	 */
	public String getDepartment() {
		return department;
	}
	/**
	 * @param department the department to set
	 */
	public void setDepartment(String department) {
		this.department = department;
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
	public String getNonTransportDesc() {
		return nonTransportDesc;
	}
	public void setNonTransportDesc(String nonTransportDesc) {
		this.nonTransportDesc = nonTransportDesc;
	}
	public ActionErrors validate(ActionMapping mapping, 
			HttpServletRequest request) 
			{ 
//			 Perform validator framework validations 
			ActionErrors errors = new ActionErrors(); 
//			 Only need crossfield validations here 
			if(StringUtils.isEmpty(educationalQualification))
			 {
				 errors.add(ActionErrors.GLOBAL_MESSAGE,new ActionMessage("error.educationalQualification.required"));
			 }
			if(StringUtils.isAlpha(marks))
			 {
				 errors.add(ActionErrors.GLOBAL_MESSAGE,new ActionMessage("error.marks")); 
			 }
			if(StringUtils.isEmpty(transport))
			 {
				 errors.add(ActionErrors.GLOBAL_MESSAGE,new ActionMessage("error.transport.required")); 
			 }
			if(StringUtils.isEmpty(nonTransport))
			{
					errors.add(ActionErrors.GLOBAL_MESSAGE,new ActionMessage("error.nonTransport.required"));
			}
			if(StringUtils.isEmpty(nonTransportDesc))
			{
					errors.add(ActionErrors.GLOBAL_MESSAGE,new ActionMessage("error.nonTransportDesc.required"));
			}
			else if(StringUtils.isNumeric(nonTransportDesc))
			{
				errors.add(ActionErrors.GLOBAL_MESSAGE,new ActionMessage("error.nonTransportDesc"));
			}	  
			return errors; 
			}
	public String getDriverdesc() {
		return driverdesc;
	}
	public void setDriverdesc(String driverdesc) {
		this.driverdesc = driverdesc;
	}
		}
