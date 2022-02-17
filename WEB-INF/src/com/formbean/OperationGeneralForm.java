package com.formbean;
import org.apache.struts.validator.ValidatorForm;
import java.util.ArrayList;

public class OperationGeneralForm extends ValidatorForm{
	
	private String driverId=null;
	private String driverName=null;
	private String VehicleId=null;
	private String instituteName=null;
	private String vehicleType=null;
	private String yesNoOption=null;
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
		return VehicleId;
	}
	public void setVehicleId(String vehicleId) {
		VehicleId = vehicleId;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	public String getYesNoOption() {
		return yesNoOption;
	}
	public void setYesNoOption(String yesNoOption) {
		this.yesNoOption = yesNoOption;
	}
	
}
