package com.formbean;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.validator.ValidatorForm;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.action.TyreRepairWorkRequisitionAction;
public class TyreRepairWorkRequisitionForm extends ValidatorForm{
	private static final Logger logger=(Logger)Logger.getLogger(TyreRepairWorkRequisitionForm.class);

	private String inchargeName=null;
	private String requestedDate=null;
	private String tyreSize=null;
	private String tyrePly=null;
	private String tyreBrand=null;
	private String tyreNumber=null;
	
	String[] tyreNumbers=new String[100];
	private String tyreNumber1=null;
	private String repairWork1=null;
	private String repairReason1=null;
	private String tyreBrand1=null;
	private String tyreSize1=null;	
	private String tyreNumber2=null;
	private String repairWork2=null;
	private String repairReason2=null;
	private String tyreBrand2=null;
	private String tyreSize2=null;	
	private String tyreNumber3=null;
	private String repairWork3=null;
	private String repairReason3=null;
	private String tyreBrand3=null;
	private String tyreSize3=null;	
	private String tyreNumber4=null;
	private String repairWork4=null;
	private String repairReason4=null;
	private String tyreBrand4=null;
	private String tyreSize4=null;	
	private String tyreNumber5=null;
	private String repairWork5=null;
	private String repairReason5=null;
	private String tyreBrand5=null;
	private String tyreSize5=null;	
	private String tyreNumber6=null;
	private String repairWork6=null;
	private String repairReason6=null;
	private String tyreBrand6=null;
	private String tyreSize6=null;	
	private String tyreNumber7=null;
	private String repairWork7=null;
	private String repairReason7=null;
	private String tyreBrand7=null;
	private String tyreSize7=null;	
	private String tyreNumber8=null;
	private String repairWork8=null;
	private String repairReason8=null;
	private String tyreBrand8=null;
	private String tyreSize8=null;	
	private String tyreNumber9=null;
	private String repairWork9=null;
	private String repairReason9=null;
	private String tyreBrand9=null;
	private String tyreSize9=null;	
	private String tyreNumber10=null;
	private String repairWork10=null;
	private String repairReason10=null;
	private String tyreBrand10=null;
	private String tyreSize10=null;	
	
	private ArrayList tyreSizeList=null;
	private ArrayList tyrePlyList=null;
	private ArrayList tyreNumberList=null;
	private ArrayList tyreBrandList=null;
	private ArrayList tyreDetailsList=null;
	
	public ArrayList getTyreBrandList() {
		return tyreBrandList;
	}
	public void setTyreBrandList(ArrayList tyreBrandList) {
		this.tyreBrandList = tyreBrandList;
	}
	public ArrayList getTyreDetailsList() {
		return tyreDetailsList;
	}
	public void setTyreDetailsList(ArrayList tyreDetailsList) {
		this.tyreDetailsList = tyreDetailsList;
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
	public ArrayList getTyreSizeList() {
		return tyreSizeList;
	}
	public void setTyreSizeList(ArrayList tyreSizeList) {
		this.tyreSizeList = tyreSizeList;
	}
	public String getInchargeName() {
		return inchargeName;
	}
	public void setInchargeName(String inchargeName) {
		this.inchargeName = inchargeName;
	}
	public String getRepairReason1() {
		return repairReason1;
	}
	public void setRepairReason1(String repairReason1) {
		this.repairReason1 = repairReason1;
	}
	public String getRepairReason10() {
		return repairReason10;
	}
	public void setRepairReason10(String repairReason10) {
		this.repairReason10 = repairReason10;
	}
	public String getRepairReason2() {
		return repairReason2;
	}
	public void setRepairReason2(String repairReason2) {
		this.repairReason2 = repairReason2;
	}
	public String getRepairReason3() {
		return repairReason3;
	}
	public void setRepairReason3(String repairReason3) {
		this.repairReason3 = repairReason3;
	}
	public String getRepairReason4() {
		return repairReason4;
	}
	public void setRepairReason4(String repairReason4) {
		this.repairReason4 = repairReason4;
	}
	public String getRepairReason5() {
		return repairReason5;
	}
	public void setRepairReason5(String repairReason5) {
		this.repairReason5 = repairReason5;
	}
	public String getRepairReason6() {
		return repairReason6;
	}
	public void setRepairReason6(String repairReason6) {
		this.repairReason6 = repairReason6;
	}
	public String getRepairReason7() {
		return repairReason7;
	}
	public void setRepairReason7(String repairReason7) {
		this.repairReason7 = repairReason7;
	}
	public String getRepairReason8() {
		return repairReason8;
	}
	public void setRepairReason8(String repairReason8) {
		this.repairReason8 = repairReason8;
	}
	public String getRepairReason9() {
		return repairReason9;
	}
	public void setRepairReason9(String repairReason9) {
		this.repairReason9 = repairReason9;
	}
	public String getRepairWork1() {
		return repairWork1;
	}
	public void setRepairWork1(String repairWork1) {
		this.repairWork1 = repairWork1;
	}
	public String getRepairWork10() {
		return repairWork10;
	}
	public void setRepairWork10(String repairWork10) {
		this.repairWork10 = repairWork10;
	}
	public String getRepairWork2() {
		return repairWork2;
	}
	public void setRepairWork2(String repairWork2) {
		this.repairWork2 = repairWork2;
	}
	public String getRepairWork3() {
		return repairWork3;
	}
	public void setRepairWork3(String repairWork3) {
		this.repairWork3 = repairWork3;
	}
	public String getRepairWork4() {
		return repairWork4;
	}
	public void setRepairWork4(String repairWork4) {
		this.repairWork4 = repairWork4;
	}
	public String getRepairWork5() {
		return repairWork5;
	}
	public void setRepairWork5(String repairWork5) {
		this.repairWork5 = repairWork5;
	}
	public String getRepairWork6() {
		return repairWork6;
	}
	public void setRepairWork6(String repairWork6) {
		this.repairWork6 = repairWork6;
	}
	public String getRepairWork7() {
		return repairWork7;
	}
	public void setRepairWork7(String repairWork7) {
		this.repairWork7 = repairWork7;
	}
	public String getRepairWork8() {
		return repairWork8;
	}
	public void setRepairWork8(String repairWork8) {
		this.repairWork8 = repairWork8;
	}
	public String getRepairWork9() {
		return repairWork9;
	}
	public void setRepairWork9(String repairWork9) {
		this.repairWork9 = repairWork9;
	}
	
	public String getTyreNumber1() {
		return tyreNumber1;
	}
	public void setTyreNumber1(String tyreNumber1) {
		this.tyreNumber1 = tyreNumber1;
	}
	public String getTyreNumber10() {
		return tyreNumber10;
	}
	public void setTyreNumber10(String tyreNumber10) {
		this.tyreNumber10 = tyreNumber10;
	}
	public String getTyreNumber2() {
		return tyreNumber2;
	}
	public void setTyreNumber2(String tyreNumber2) {
		this.tyreNumber2 = tyreNumber2;
	}
	public String getTyreNumber3() {
		return tyreNumber3;
	}
	public void setTyreNumber3(String tyreNumber3) {
		this.tyreNumber3 = tyreNumber3;
	}
	public String getTyreNumber4() {
		return tyreNumber4;
	}
	public void setTyreNumber4(String tyreNumber4) {
		this.tyreNumber4 = tyreNumber4;
	}
	public String getTyreNumber5() {
		return tyreNumber5;
	}
	public void setTyreNumber5(String tyreNumber5) {
		this.tyreNumber5 = tyreNumber5;
	}
	public String getTyreNumber6() {
		return tyreNumber6;
	}
	public void setTyreNumber6(String tyreNumber6) {
		this.tyreNumber6 = tyreNumber6;
	}
	public String getTyreNumber7() {
		return tyreNumber7;
	}
	public void setTyreNumber7(String tyreNumber7) {
		this.tyreNumber7 = tyreNumber7;
	}
	public String getTyreNumber8() {
		return tyreNumber8;
	}
	public void setTyreNumber8(String tyreNumber8) {
		this.tyreNumber8 = tyreNumber8;
	}
	public String getTyreNumber9() {
		return tyreNumber9;
	}
	public void setTyreNumber9(String tyreNumber9) {
		this.tyreNumber9 = tyreNumber9;
	}
	public String[] getTyreNumbers() {
		return tyreNumbers;
	}
	public void setTyreNumbers(String[] tyreNumbers) {
		this.tyreNumbers = tyreNumbers;
	}
	public String getRequestedDate() {
		return requestedDate;
	}
	public void setRequestedDate(String requestedDate) {
		this.requestedDate = requestedDate;
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
	public String getTyreBrand1() {
		return tyreBrand1;
	}
	public void setTyreBrand1(String tyreBrand1) {
		this.tyreBrand1 = tyreBrand1;
	}
	public String getTyreBrand10() {
		return tyreBrand10;
	}
	public void setTyreBrand10(String tyreBrand10) {
		this.tyreBrand10 = tyreBrand10;
	}
	public String getTyreBrand2() {
		return tyreBrand2;
	}
	public void setTyreBrand2(String tyreBrand2) {
		this.tyreBrand2 = tyreBrand2;
	}
	public String getTyreBrand3() {
		return tyreBrand3;
	}
	public void setTyreBrand3(String tyreBrand3) {
		this.tyreBrand3 = tyreBrand3;
	}
	public String getTyreBrand4() {
		return tyreBrand4;
	}
	public void setTyreBrand4(String tyreBrand4) {
		this.tyreBrand4 = tyreBrand4;
	}
	public String getTyreBrand5() {
		return tyreBrand5;
	}
	public void setTyreBrand5(String tyreBrand5) {
		this.tyreBrand5 = tyreBrand5;
	}
	public String getTyreBrand6() {
		return tyreBrand6;
	}
	public void setTyreBrand6(String tyreBrand6) {
		this.tyreBrand6 = tyreBrand6;
	}
	public String getTyreBrand7() {
		return tyreBrand7;
	}
	public void setTyreBrand7(String tyreBrand7) {
		this.tyreBrand7 = tyreBrand7;
	}
	public String getTyreBrand8() {
		return tyreBrand8;
	}
	public void setTyreBrand8(String tyreBrand8) {
		this.tyreBrand8 = tyreBrand8;
	}
	public String getTyreBrand9() {
		return tyreBrand9;
	}
	public void setTyreBrand9(String tyreBrand9) {
		this.tyreBrand9 = tyreBrand9;
	}
	public String getTyreSize1() {
		return tyreSize1;
	}
	public void setTyreSize1(String tyreSize1) {
		this.tyreSize1 = tyreSize1;
	}
	public String getTyreSize10() {
		return tyreSize10;
	}
	public void setTyreSize10(String tyreSize10) {
		this.tyreSize10 = tyreSize10;
	}
	public String getTyreSize2() {
		return tyreSize2;
	}
	public void setTyreSize2(String tyreSize2) {
		this.tyreSize2 = tyreSize2;
	}
	public String getTyreSize3() {
		return tyreSize3;
	}
	public void setTyreSize3(String tyreSize3) {
		this.tyreSize3 = tyreSize3;
	}
	public String getTyreSize4() {
		return tyreSize4;
	}
	public void setTyreSize4(String tyreSize4) {
		this.tyreSize4 = tyreSize4;
	}
	public String getTyreSize5() {
		return tyreSize5;
	}
	public void setTyreSize5(String tyreSize5) {
		this.tyreSize5 = tyreSize5;
	}
	public String getTyreSize6() {
		return tyreSize6;
	}
	public void setTyreSize6(String tyreSize6) {
		this.tyreSize6 = tyreSize6;
	}
	public String getTyreSize7() {
		return tyreSize7;
	}
	public void setTyreSize7(String tyreSize7) {
		this.tyreSize7 = tyreSize7;
	}
	public String getTyreSize8() {
		return tyreSize8;
	}
	public void setTyreSize8(String tyreSize8) {
		this.tyreSize8 = tyreSize8;
	}
	public String getTyreSize9() {
		return tyreSize9;
	}
	public void setTyreSize9(String tyreSize9) {
		this.tyreSize9 = tyreSize9;
	}
	
}