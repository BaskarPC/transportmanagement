package com.formbean;


import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.validator.ValidatorForm;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.action.TyreFittingAction;

public class TyreFittingForm extends ValidatorForm{
	private static final Logger logger=(Logger)Logger.getLogger(TyreFittingForm.class);
	private String tyresizeCode=null;
	private String tyresizeCtype=null;
	private String tyresizeCdesc=null;
	private String tyrebrandCode=null;
	private String tyrebrandCtype=null;
	private String tyrebrandCdesc=null;
	private String tyreplyCode=null;
	private String tyreplyCtype=null;
	private String tyreplyCdesc=null;
	private String tyrepositionCode=null;
	private String tyrepositionCtype=null;
	private String tyrepositionCdesc=null;
	private String tyrenumberCode=null;
	private String tyrenumberCtype=null;
	private String tyrenumberCdesc=null;
	private String instId;
	private String instDesc;
	private String typeId;
	private String typeDesc;
	private String vehicleId;
	private String vehicleDesc;
	private ArrayList instList;
	private ArrayList typeList;
	private ArrayList vehicleList;
	private String institutionName=null;
	private String vehicleType=null;
	private String vehicleNumber=null;
	private String tyreSize=null;
	private String tyrePly=null;
	private String tyreBrand=null;
	private String tyreNumber=null;
	private ArrayList tyreSizeList=null;
	private ArrayList tyreBrandList=null;
	private ArrayList tyrePlyList=null;
	private ArrayList tyreNumberList=null;
	private ArrayList institutionList=null;
	private ArrayList vehicleTypeList=null;
	private ArrayList vehicleNumberList=null;
	private ArrayList tyrePositionList=null;
	private String tyreStatus=null;
	private String tyrePosition=null;
	private String fittingDate=null;
	private String fittingKM=null;
	
	/**
	 * 
	 * @return the fittingDate
	 */
	
	public String getFittingDate() {
		return fittingDate;
	}
	/**
	 * 
	 * @param fittingDate - to set the fittingDate
	 */
	public void setFittingDate(String fittingDate) {
		this.fittingDate = fittingDate;
	}
	/**
	 * 
	 * @return the fittingKM
	 */
	public String getFittingKM() {
		return fittingKM;
	}
	/**
	 * 
	 * @param fittingKM - to set the fittingKM
	 */
	public void setFittingKM(String fittingKM) {
		this.fittingKM = fittingKM;
	}
   
	 /**	
	  * 
	  * @return the tyrePosition
	  */

	
	public String getTyrePosition() {
		return tyrePosition;
	}
	/**
	 * 
	 * @param tyrePosition - to set the tyrePosition
	 */
	public void setTyrePosition(String tyrePosition) {
		this.tyrePosition = tyrePosition;
	}

	/**
	 * 
	 * @return the tyreStatus
	 */
	public String getTyreStatus() {
		return tyreStatus;
	}
	/**
	 * 
	 * @param tyreStatus - to set the tyreStatus
	 */
	public void setTyreStatus(String tyreStatus) {
		this.tyreStatus = tyreStatus;
	}
	
		
	public ArrayList getInstitutionList() {
		return institutionList;
	}
	public void setInstitutionList(ArrayList institutionList) {
		this.institutionList = institutionList;
	}
	public ArrayList getTyreBrandList() {
		return tyreBrandList;
	}
	public void setTyreBrandList(ArrayList tyreBrandList) {
		this.tyreBrandList = tyreBrandList;
	}
	public ArrayList getTyreNumberList() {
		return tyreNumberList;
	}
	public void setTyreNumberList(ArrayList tyreNumberList) {
		this.tyreNumberList = tyreNumberList;
	}
	public ArrayList getTyrePlyList() {
		return tyrePlyList;
	}
	public void setTyrePlyList(ArrayList tyrePlyList) {
		this.tyrePlyList = tyrePlyList;
	}
	public ArrayList getTyrePositionList() {
		return tyrePositionList;
	}
	public void setTyrePositionList(ArrayList tyrePositionList) {
		this.tyrePositionList = tyrePositionList;
	}
	public ArrayList getTyreSizeList() {
		return tyreSizeList;
	}
	public void setTyreSizeList(ArrayList tyreSizeList) {
		this.tyreSizeList = tyreSizeList;
	}
	public ArrayList getVehicleNumberList() {
		return vehicleNumberList;
	}
	public void setVehicleNumberList(ArrayList vehicleNumberList) {
		this.vehicleNumberList = vehicleNumberList;
	}
	public ArrayList getVehicleTypeList() {
		return vehicleTypeList;
	}
	public void setVehicleTypeList(ArrayList vehicleTypeList) {
		this.vehicleTypeList = vehicleTypeList;
	}
	
	public String getInstitutionName() {
		return institutionName;
	}
	public void setInstitutionName(String institutionName) {
		this.institutionName = institutionName;
	}
	public ArrayList getInstList() {
		return instList;
	}
	public void setInstList(ArrayList instList) {
		this.instList = instList;
	}
	public ArrayList getTypeList() {
		return typeList;
	}
	public void setTypeList(ArrayList typeList) {
		this.typeList = typeList;
	}
	public String getTyreBrand() {
		return tyreBrand;
	}
	public void setTyreBrand(String tyreBrand) {
		this.tyreBrand = tyreBrand;
	}
	public String getTyreNumber() {
		return tyreNumber;
	}
	public void setTyreNumber(String tyreNumber) {
		this.tyreNumber = tyreNumber;
	}
	public String getTyrePly() {
		return tyrePly;
	}
	public void setTyrePly(String tyrePly) {
		this.tyrePly = tyrePly;
	}
	public String getTyreSize() {
		return tyreSize;
	}
	public void setTyreSize(String tyreSize) {
		this.tyreSize = tyreSize;
	}
	public ArrayList getVehicleList() {
		return vehicleList;
	}
	public void setVehicleList(ArrayList vehicleList) {
		this.vehicleList = vehicleList;
	}
	public String getVehicleNumber() {
		return vehicleNumber;
	}
	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	public String getInstDesc() {
		return instDesc;
	}
	public void setInstDesc(String instDesc) {
		this.instDesc = instDesc;
	}
	public String getInstId() {
		return instId;
	}
	public void setInstId(String instId) {
		this.instId = instId;
	}
	public String getTypeDesc() {
		return typeDesc;
	}
	public void setTypeDesc(String typeDesc) {
		this.typeDesc = typeDesc;
	}
	public String getTypeId() {
		return typeId;
	}
	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}
	public String getVehicleDesc() {
		return vehicleDesc;
	}
	public void setVehicleDesc(String vehicleDesc) {
		this.vehicleDesc = vehicleDesc;
	}
	public String getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getTyrebrandCdesc() {
		return tyrebrandCdesc;
	}
	public void setTyrebrandCdesc(String tyrebrandCdesc) {
		this.tyrebrandCdesc = tyrebrandCdesc;
	}
	public String getTyrebrandCode() {
		return tyrebrandCode;
	}
	public void setTyrebrandCode(String tyrebrandCode) {
		this.tyrebrandCode = tyrebrandCode;
	}
	public String getTyrebrandCtype() {
		return tyrebrandCtype;
	}
	public void setTyrebrandCtype(String tyrebrandCtype) {
		this.tyrebrandCtype = tyrebrandCtype;
	}
	public String getTyrenumberCdesc() {
		return tyrenumberCdesc;
	}
	public void setTyrenumberCdesc(String tyrenumberCdesc) {
		this.tyrenumberCdesc = tyrenumberCdesc;
	}
	public String getTyrenumberCode() {
		return tyrenumberCode;
	}
	public void setTyrenumberCode(String tyrenumberCode) {
		this.tyrenumberCode = tyrenumberCode;
	}
	public String getTyrenumberCtype() {
		return tyrenumberCtype;
	}
	public void setTyrenumberCtype(String tyrenumberCtype) {
		this.tyrenumberCtype = tyrenumberCtype;
	}
	public String getTyreplyCdesc() {
		return tyreplyCdesc;
	}
	public void setTyreplyCdesc(String tyreplyCdesc) {
		this.tyreplyCdesc = tyreplyCdesc;
	}
	public String getTyreplyCode() {
		return tyreplyCode;
	}
	public void setTyreplyCode(String tyreplyCode) {
		this.tyreplyCode = tyreplyCode;
	}
	public String getTyreplyCtype() {
		return tyreplyCtype;
	}
	public void setTyreplyCtype(String tyreplyCtype) {
		this.tyreplyCtype = tyreplyCtype;
	}
	public String getTyresizeCdesc() {
		return tyresizeCdesc;
	}
	public void setTyresizeCdesc(String tyresizeCdesc) {
		this.tyresizeCdesc = tyresizeCdesc;
	}
	public String getTyresizeCode() {
		return tyresizeCode;
	}
	public void setTyresizeCode(String tyresizeCode) {
		this.tyresizeCode = tyresizeCode;
	}
	public String getTyresizeCtype() {
		return tyresizeCtype;
	}
	public void setTyresizeCtype(String tyresizeCtype) {
		this.tyresizeCtype = tyresizeCtype;
	}
	
	public ActionErrors validate(ActionMapping mapping, 
			HttpServletRequest request) 
			{ 
//			 Perform validator framework validations 
			ActionErrors errors = new ActionErrors(); 
//			 Only need crossfield validations here 
			if(StringUtils.isEmpty(tyreStatus))
			 {
				errors.add("Tyre Status",new ActionMessage("errors.tyrestatus"));
				 
			 }
			else if(!(StringUtils.isAlpha(tyreStatus)))
			{
				errors.add("Tyre Status",new ActionMessage("error.alphaonly"));
			}
			
			/* if(StringUtils.isEmpty(fittingKM))
			 {
				 errors.add(ActionErrors.GLOBAL_MESSAGE,new ActionMessage("error.fittingkm")); 
			 }
			 else if(!StringUtils.isNumeric(fittingKM))
				{
					errors.add(ActionErrors.GLOBAL_MESSAGE,new ActionMessage("error.numericonly"));
				}
			 if(StringUtils.isEmpty(fittingDate))
			 {
				 errors.add(ActionErrors.GLOBAL_MESSAGE,new ActionMessage("error.fittingdate")); 
			 }
			 else if(!StringUtils.isAlpha(fittingDate))
				{
					errors.add(ActionErrors.GLOBAL_MESSAGE,new ActionMessage("error.alphaonly"));
				} */
			 	   
			return errors; 
			}
	public String getTyrepositionCdesc() {
		return tyrepositionCdesc;
	}
	public void setTyrepositionCdesc(String tyrepositionCdesc) {
		this.tyrepositionCdesc = tyrepositionCdesc;
	}
	public String getTyrepositionCode() {
		return tyrepositionCode;
	}
	public void setTyrepositionCode(String tyrepositionCode) {
		this.tyrepositionCode = tyrepositionCode;
	}
	public String getTyrepositionCtype() {
		return tyrepositionCtype;
	}
	public void setTyrepositionCtype(String tyrepositionCtype) {
		this.tyrepositionCtype = tyrepositionCtype;
	}
	
}
