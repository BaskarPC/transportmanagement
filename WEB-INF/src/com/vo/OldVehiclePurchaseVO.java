package com.vo;

import java.util.ArrayList;

import org.apache.log4j.Logger;

public class OldVehiclePurchaseVO{
	
	private static final Logger logger=(Logger)Logger.getLogger(OldVehiclePurchaseVO.class);

	
	private String kmTraveled=null;
	private String vehicleAge=null;
	private String vehicleId=null;
	private String vehiclestatus=null;
	
	private ArrayList vehiclestatusList=null;
	private String optioncode=null;
	private String optiondesc=null;
	private String bodyCmpy=null;
	private String vehicleiddesc=null;
	
	public String getBodyCmpy() {
		return bodyCmpy;
	}
	public void setBodyCmpy(String bodyCmpy) {
		this.bodyCmpy = bodyCmpy;
	}
	public String getKmTraveled() {
		return kmTraveled;
	}
	public void setKmTraveled(String kmTraveled) {
		this.kmTraveled = kmTraveled;
	}
	public String getVehicleAge() {
		return vehicleAge;
	}
	public void setVehicleAge(String vehicleAge) {
		this.vehicleAge = vehicleAge;
	}
	
	public String getOptioncode() {
		return optioncode;
	}
	public void setOptioncode(String optioncode) {
		this.optioncode = optioncode;
	}
	public String getOptiondesc() {
		return optiondesc;
	}
	public void setOptiondesc(String optiondesc) {
		this.optiondesc = optiondesc;
	}
	public String getVehiclestatus() {
		return vehiclestatus;
	}
	public void setVehiclestatus(String vehiclestatus) {
		this.vehiclestatus = vehiclestatus;
	}
	public ArrayList getVehiclestatusList() {
		return vehiclestatusList;
	}
	public void setVehiclestatusList(ArrayList vehiclestatusList) {
		this.vehiclestatusList = vehiclestatusList;
	}
	public String getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getVehicleiddesc() {
		return vehicleiddesc;
	}
	public void setVehicleiddesc(String vehicleiddesc) {
		this.vehicleiddesc = vehicleiddesc;
	}
}