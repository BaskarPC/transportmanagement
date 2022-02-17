package com.vo;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.apache.struts.validator.ValidatorForm;

public class BreakDownVO{
	private static final Logger logger=(Logger)Logger.getLogger(BreakDownVO.class);
	
	private ArrayList driverIdList=null;
	private String driverId=null;
	private String driverName=null;
	private String vehicleId=null;
	private ArrayList vehicleList=null;
	private String vehicleidcode=null;
	private String vehicleiddesc=null;
	private String alterdriverId=null;
	private ArrayList alterdriverIdList=null;
	private ArrayList instList=null;
	private String instcode=null;
	private String instdesc=null;
	private String drivercode=null;
	private String driverdesc=null;
	private String instituteName=null;
	private String breakDownDate=null;
	private String breakDownTime=null;
	private String breakDownPlace=null;
	private String routeNo=null;
	
	private String natureOfBreakDown=null;
	private String alternateBusId=null;
	private String alternateBusDriverName=null;
	private String remarks=null; 
	
	
	public String getAlternateBusDriverName() {
		return alternateBusDriverName;
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
		
	public String getNatureOfBreakDown() {
		return natureOfBreakDown;
	}
	public void setNatureOfBreakDown(String natureOfBreakDown) {
		this.natureOfBreakDown = natureOfBreakDown;
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
	
	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	
	public String getInstituteName() {
		return instituteName;
	}
	public ArrayList getInstList() {
		return instList;
	}
	public void setInstList(ArrayList instList) {
		this.instList = instList;
	}

	
	public void setInstituteName(String instituteName) {
		this.instituteName = instituteName;
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
	
}
