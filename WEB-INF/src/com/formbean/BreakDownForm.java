package com.formbean;
import org.apache.log4j.Logger;
import org.apache.struts.validator.ValidatorForm;
import java.util.ArrayList;
import org.apache.struts.validator.ValidatorForm;
import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import javax.servlet.http.HttpServletRequest;

public class BreakDownForm extends ValidatorForm{
	private static final Logger logger=(Logger)Logger.getLogger(BreakDownForm.class);
	private ArrayList driverIdList=null;
	private String driverId=null;
	private String driverName=null;
	private String vehicleId=null;
	private ArrayList vehicleList=null;
	private String vehicleidcode=null;
	private String vehicleiddesc=null;
	private String alterdriverId=null;
	private ArrayList alterdriverIdList=null;
	private String breakDownDate=null;
	private String breakDownTime=null;
	private String breakDownPlace=null;
	private String routeNo=null;
	private String drivercode=null;
	private String driverdesc=null;
	private String natureOfBreakDown=null;
	
    private String alternateBusId=null;
	private String alternateBusDriverName=null;
	private ArrayList instList=null;
	private String instcode=null;
	private String instdesc=null;
	private String instituteName=null;
	
	private String remarks=null; 
	
	public String getAlternateBusDriverName() {
		return alternateBusDriverName;
	}
	
	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	
	public void setInstituteName(String instituteName) {
		this.instituteName = instituteName;
	}
	public void setAlternateBusDriverName(String alternateBusDriverName) {
		this.alternateBusDriverName = alternateBusDriverName;
	}
	public String getBreakDownDate() {
		return breakDownDate;
	}
	public void setBreakDownDate(String breakDownDate) {
		this.breakDownDate = breakDownDate;
	}
	public String getBreakDownPlace() {
		return breakDownPlace;
	}
	public void setBreakDownPlace(String breakDownPlace) {
		this.breakDownPlace = breakDownPlace;
	}
	public String getBreakDownTime() {
		return breakDownTime;
	}
	public void setBreakDownTime(String breakDownTime) {
		this.breakDownTime = breakDownTime;
	}
	
	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getRouteNo() {
		return routeNo;
	}
	public void setRouteNo(String routeNo) {
		this.routeNo = routeNo;
	}
	
	public String getAlternateBusId() {
		return alternateBusId;
	}
	public void setAlternateBusId(String alternateBusId) {
		this.alternateBusId = alternateBusId;
	}
	
	public ArrayList getInstList() {
		return instList;
	}
	public void setInstList(ArrayList instList) {
		this.instList = instList;
	}
	public String getInstituteName() {
		return instituteName;
	}
	
	public String getDriverId() {
		return driverId;
	}
	public void setDriverId(String driverId) {
		this.driverId = driverId;
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

	public ArrayList getDriverIdList() {
		return driverIdList;
	}

	public void setDriverIdList(ArrayList driverIdList) {
		this.driverIdList = driverIdList;
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

	public String getAlterdriverId() {
		return alterdriverId;
	}

	public void setAlterdriverId(String alterdriverId) {
		this.alterdriverId = alterdriverId;
	}

	public ArrayList getAlterdriverIdList() {
		return alterdriverIdList;
	}

	public void setAlterdriverIdList(ArrayList alterdriverIdList) {
		this.alterdriverIdList = alterdriverIdList;
	}

	public ArrayList getVehicleList() {
		return vehicleList;
	}

	public void setVehicleList(ArrayList vehicleList) {
		this.vehicleList = vehicleList;
	}
	public String getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getNatureOfBreakDown() {
		return natureOfBreakDown;
	}

	public void setNatureOfBreakDown(String natureOfBreakDown) {
		this.natureOfBreakDown = natureOfBreakDown;
	}
		
	public ActionErrors validate(ActionMapping mapping, 
			HttpServletRequest request) 
			{ 
			 //Perform validator framework validations 
			ActionErrors errors = new ActionErrors(); 
			 //Only need crossfield validations here 
			if(!(StringUtils.isAlphanumeric(driverId)))
			 {
				 errors.add(ActionErrors.GLOBAL_MESSAGE,new ActionMessage("error.driverId"));
			 }
			
			if(StringUtils.isEmpty(breakDownPlace))
			 {
				 errors.add(ActionErrors.GLOBAL_MESSAGE,new ActionMessage("error.breakDownPlace.required"));
			 }
			else if(!(StringUtils.isAlpha(breakDownPlace)))
			{
				errors.add(ActionErrors.GLOBAL_MESSAGE,new ActionMessage("error.breakDownPlace"));
			}
			
						
			if(StringUtils.isEmpty(driverName))
			 {
				 errors.add(ActionErrors.GLOBAL_MESSAGE,new ActionMessage("error.driverName.required"));
			 }
			else if(!(StringUtils.isAlpha(driverName)))
			{
				errors.add(ActionErrors.GLOBAL_MESSAGE,new ActionMessage("error.driverName"));
			}
			
			if(StringUtils.isEmpty(breakDownDate))
			 {
				 errors.add(ActionErrors.GLOBAL_MESSAGE,new ActionMessage("error.breakDownDate.required"));
			 }
			if(StringUtils.isEmpty(breakDownTime))
			 {
				 errors.add(ActionErrors.GLOBAL_MESSAGE,new ActionMessage("error.breakDownTime.required"));
			 }
			if(StringUtils.isEmpty(routeNo))
			 {
				 errors.add(ActionErrors.GLOBAL_MESSAGE,new ActionMessage("error.routeNo.required"));
			 }
			else if(!(StringUtils.isNumeric(routeNo)))
			{
				errors.add(ActionErrors.GLOBAL_MESSAGE,new ActionMessage("error.routeNo"));
			}
			
			if(StringUtils.isEmpty(natureOfBreakDown))
			 {
				 errors.add(ActionErrors.GLOBAL_MESSAGE,new ActionMessage("error.natureOfBreakDown.required"));
			 }
			else if(!(StringUtils.isAlpha(natureOfBreakDown)))
			{
				errors.add(ActionErrors.GLOBAL_MESSAGE,new ActionMessage("error.natureOfBreakDown"));
			}
			
			if(StringUtils.isEmpty(alternateBusId))
			 {
				 errors.add(ActionErrors.GLOBAL_MESSAGE,new ActionMessage("error.alternateBusId.required"));
			 }
			else if(!(StringUtils.isAlphanumeric(alterdriverId)))
			 {
				 errors.add(ActionErrors.GLOBAL_MESSAGE,new ActionMessage("error.alterdriverId"));
				 logger.debug("after the error");				 
			 }
			
			if(StringUtils.isEmpty(alternateBusDriverName))
			 {
				 errors.add(ActionErrors.GLOBAL_MESSAGE,new ActionMessage("error.alternateBusDriverName.required"));
			 }
			else if(!(StringUtils.isAlpha(alternateBusDriverName)))
			{
				errors.add(ActionErrors.GLOBAL_MESSAGE,new ActionMessage("error.alternateBusDriverName"));
			}
			
				return errors; 
			} 

}
