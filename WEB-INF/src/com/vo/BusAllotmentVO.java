package com.vo;

import java.util.ArrayList;

import org.apache.log4j.Logger;



public class BusAllotmentVO{
	private static final Logger logger=(Logger)Logger.getLogger(BusAllotmentVO.class);
	
	private String vehicleAllottedDate=null;
	private String routeNo=null;
	private ArrayList instList=null;
	private String instituteName=null;
	private String vehicleId=null;
	private ArrayList vehicleidList=null;
	private ArrayList vehicletypeList=null;
	private String vehicleType=null;
	private String driverId=null;
	private ArrayList driveridList=null;
	private String driverName=null;
	private String kmTravelledPerDay=null;
	private String startPlace=null;
	private String via=null;
	private String lastStop=null;
	private String haltPlace=null;
	private String residentialNo=null;
	private String officeNo=null;
	private String permittedDistrict=null;
	private String districtList=null;
	private String[] districtarray=null;
	
	private String code=null;
	private String cdesc=null;
	private String instcode=null;
	private String instdesc=null;
	private String drivercode=null;
	private String driverdesc=null;
	private String drivernamedesc=null;
	private String vehicleidcode=null;
	private String vehicleiddesc=null;
	private String vehicletypecode=null;
	private String vehicletypedesc=null;
	private String districtcode=null;
	private String districtdesc=null;

	public ArrayList getInstList() {
		return instList;
	}
	public void setInstList(ArrayList instList) {
		this.instList = instList;
	}
	public String getHaltPlace() {
		return haltPlace;
	}
	public void setHaltPlace(String haltPlace) {
		this.haltPlace = haltPlace;
	}
	
	public String getKmTravelledPerDay() {
		return kmTravelledPerDay;
	}
	public void setKmTravelledPerDay(String kmTravelledPerDay) {
		this.kmTravelledPerDay = kmTravelledPerDay;
	}
	public String getLastStop() {
		return lastStop;
	}
	public void setLastStop(String lastStop) {
		this.lastStop = lastStop;
	}
	
	public String getResidentialNo() {
		return residentialNo;
	}
	public void setResidentialNo(String residentialNo) {
		this.residentialNo = residentialNo;
	}
	public String getRouteNo() {
		return routeNo;
	}
	public void setRouteNo(String routeNo) {
		this.routeNo = routeNo;
	}
	public String getStartPlace() {
		return startPlace;
	}
	public void setStartPlace(String startPlace) {
		this.startPlace = startPlace;
	}
	
	public String getVia() {
		return via;
	}
	public void setVia(String via) {
		this.via = via;
	}
	public String getOfficeNo() {
		return officeNo;
	}
	public void setOfficeNo(String officeNo) {
		this.officeNo = officeNo;
	}
	public String getPermittedDistrict() {
		return permittedDistrict;
	}
	public void setPermittedDistrict(String permittedDistrict) {
		this.permittedDistrict = permittedDistrict;
	}
	public String getVehicleAllottedDate() {
		return vehicleAllottedDate;
	}
	public void setVehicleAllottedDate(String vehicleAllottedDate) {
		this.vehicleAllottedDate = vehicleAllottedDate;
	}
	public String getDriverId() {
		return driverId;
	}
	public void setDriverId(String driverId) {
		this.driverId = driverId;
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
	public void setInstituteName(String instituteName) {
		this.instituteName = instituteName;
	}
	
	public String getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
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
	
	public ArrayList getDriveridList() {
		return driveridList;
	}
	public void setDriveridList(ArrayList driveridList) {
		this.driveridList = driveridList;
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
	public ArrayList getVehicleidList() {
		return vehicleidList;
	}
	public void setVehicleidList(ArrayList vehicleidList) {
		this.vehicleidList = vehicleidList;
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
	public String getDistrictcode() {
		return districtcode;
	}
	public void setDistrictcode(String districtcode) {
		this.districtcode = districtcode;
	}
	public String getDistrictdesc() {
		return districtdesc;
	}
	public void setDistrictdesc(String districtdesc) {
		this.districtdesc = districtdesc;
	}
	public String getDistrictList() {
		return districtList;
	}
	public void setDistrictList(String districtList) {
		this.districtList = districtList;
	}
	public String[] getDistrictarray() {
		return districtarray;
	}
	public void setDistrictarray(String[] districtarray) {
		this.districtarray = districtarray;
	}

	public ArrayList getVehicletypeList() {
		return vehicletypeList;
	}
	public void setVehicletypeList(ArrayList vehicletypeList) {
		this.vehicletypeList = vehicletypeList;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	/**
	 * @return the vehicletypecode
	 */
	public String getVehicletypecode() {
		return vehicletypecode;
	}
	/**
	 * @param vehicletypecode the vehicletypecode to set
	 */
	public void setVehicletypecode(String vehicletypecode) {
		this.vehicletypecode = vehicletypecode;
	}
	/**
	 * @return the vehicletypedesc
	 */
	public String getVehicletypedesc() {
		return vehicletypedesc;
	}
	/**
	 * @param vehicletypedesc the vehicletypedesc to set
	 */
	public void setVehicletypedesc(String vehicletypedesc) {
		this.vehicletypedesc = vehicletypedesc;
	}
	public String getCdesc() {
		return cdesc;
	}
	public void setCdesc(String cdesc) {
		this.cdesc = cdesc;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDrivernamedesc() {
		return drivernamedesc;
	}
	public void setDrivernamedesc(String drivernamedesc) {
		this.drivernamedesc = drivernamedesc;
	}

}
