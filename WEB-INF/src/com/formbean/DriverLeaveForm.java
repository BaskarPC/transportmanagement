package com.formbean;
import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.validator.ValidatorForm;
import org.apache.struts.action.ActionErrors;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

public class DriverLeaveForm extends ValidatorForm {
	
	private String driverId=null;
	private String driverName=null;
	private String department=null;
	private String noOfDaysLeaveRequired=null;
	private String leaveAlreadyTaken;
	private String casualLeave=null;
	private String compensationLeave=null;
	private String medicalLeave=null;
	private String vacationLeave=null;
	private ArrayList idList=null;
	private ArrayList deptList=null;
	

	/**
	 * @return the casualLeave
	 */
	public String getCasualLeave() {
		return casualLeave;
	}
	/**
	 * @param casualLeave the casualLeave to set
	 */
	public void setCasualLeave(String casualLeave) {
		this.casualLeave = casualLeave;
	}
	/**
	 * @return the compensationLeave
	 */
	public String getCompensationLeave() {
		return compensationLeave;
	}
	/**
	 * @param compensationLeave the compensationLeave to set
	 */
	public void setCompensationLeave(String compensationLeave) {
		this.compensationLeave = compensationLeave;
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
	 * @return the deptList
	 */
	public ArrayList getDeptList() {
		return deptList;
	}
	/**
	 * @param deptList the deptList to set
	 */
	public void setDeptList(ArrayList deptList) {
		this.deptList = deptList;
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
	 * @return the idList
	 */
	public ArrayList getIdList() {
		return idList;
	}
	/**
	 * @param idList the idList to set
	 */
	public void setIdList(ArrayList idList) {
		this.idList = idList;
	}
	/**
	 * @return the leaveAlreadyTaken
	 */
	public String getLeaveAlreadyTaken() {
		return leaveAlreadyTaken;
	}
	/**
	 * @param leaveAlreadyTaken the leaveAlreadyTaken to set
	 */
	public void setLeaveAlreadyTaken(String leaveAlreadyTaken) {
		this.leaveAlreadyTaken = leaveAlreadyTaken;
	}
	/**
	 * @return the medicalLeave
	 */
	public String getMedicalLeave() {
		return medicalLeave;
	}
	/**
	 * @param medicalLeave the medicalLeave to set
	 */
	public void setMedicalLeave(String medicalLeave) {
		this.medicalLeave = medicalLeave;
	}
	/**
	 * @return the noOfDaysLeaveRequired
	 */
	public String getNoOfDaysLeaveRequired() {
		return noOfDaysLeaveRequired;
	}
	/**
	 * @param noOfDaysLeaveRequired the noOfDaysLeaveRequired to set
	 */
	public void setNoOfDaysLeaveRequired(String noOfDaysLeaveRequired) {
		this.noOfDaysLeaveRequired = noOfDaysLeaveRequired;
	}
	/**
	 * @return the vacationLeave
	 */
	public String getVacationLeave() {
		return vacationLeave;
	}
	/**
	 * @param vacationLeave the vacationLeave to set
	 */
	public void setVacationLeave(String vacationLeave) {
		this.vacationLeave = vacationLeave;
	}
public ActionErrors validate(ActionMapping mapping, 
			HttpServletRequest request) 
			{ 
//			 Perform validator framework validations 
			ActionErrors errors = new ActionErrors(); 
//			 Only need crossfield validations here 
			if(StringUtils.isEmpty(noOfDaysLeaveRequired))
			 {
				 errors.add(ActionErrors.GLOBAL_MESSAGE,new ActionMessage("error.noOfDaysLeaveRequired.required"));
			 }
			else if((StringUtils.isAlpha(noOfDaysLeaveRequired)))
			{
				errors.add(ActionErrors.GLOBAL_MESSAGE,new ActionMessage("error.noOfDaysLeaveRequired"));
			}
		
			 	   
			return errors; 
			}
	

}
