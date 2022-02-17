package com.formbean;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.validator.ValidatorForm;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.action.TyreRebuiltAction;
public class TyreRebuiltForm extends GeneralForm{
	private static final Logger logger=(Logger)Logger.getLogger(TyreRebuiltForm.class);
	
	private String billDate=null;
	private String companyName=null;
	private String billNumber=null;
	private String tyreSize=null;
	private String tyrePly=null;
	private String tyreBrand=null;
	private String tyreNumber=null;
   String[] tyreNumbers=new String[100];
    private String billAmount=null; 
    
	private String tyreNumber1=null;
	private String rebuiltNumber1=null;
	private String rebuiltReason1=null;
	private String tyreBrand1=null;
	private String tyreSize1=null;
	private String tyreNumber2=null;
	private String rebuiltNumber2=null;
	private String rebuiltReason2=null;
	private String tyreBrand2=null;
	private String tyreSize2=null;
	private String tyreNumber3=null;
	private String rebuiltNumber3=null;
	private String rebuiltReason3=null;
	private String tyreBrand3=null;
	private String tyreSize3=null;
	private String tyreNumber4=null;
	private String rebuiltNumber4=null;
	private String rebuiltReason4=null;
	private String tyreBrand4=null;
	private String tyreSize4=null;
	private String tyreNumber5=null;
	private String rebuiltNumber5=null;
	private String rebuiltReason5=null;
	private String tyreBrand5=null;
	private String tyreSize5=null;
	private String tyreNumber6=null;
	private String rebuiltNumber6=null;
	private String rebuiltReason6=null;
	private String tyreBrand6=null;
	private String tyreSize6=null;
	private String tyreNumber7=null;
	private String rebuiltNumber7=null;
	private String rebuiltReason7=null;
	private String tyreBrand7=null;
	private String tyreSize7=null;
	private String tyreNumber8=null;
	private String rebuiltNumber8=null;
	private String rebuiltReason8=null;
	private String tyreBrand8=null;
	private String tyreSize8=null;
	private String tyreNumber9=null;
	private String rebuiltNumber9=null;
	private String rebuiltReason9=null;
	private String tyreBrand9=null;
	private String tyreSize9=null;
	private String tyreNumber10=null;
	private String rebuiltNumber10=null;
	private String rebuiltReason10=null;
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
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getRebuiltNumber1() {
		return rebuiltNumber1;
	}
	public void setRebuiltNumber1(String rebuiltNumber1) {
		this.rebuiltNumber1 = rebuiltNumber1;
	}
	public String getRebuiltNumber10() {
		return rebuiltNumber10;
	}
	public void setRebuiltNumber10(String rebuiltNumber10) {
		this.rebuiltNumber10 = rebuiltNumber10;
	}
	public String getRebuiltNumber2() {
		return rebuiltNumber2;
	}
	public void setRebuiltNumber2(String rebuiltNumber2) {
		this.rebuiltNumber2 = rebuiltNumber2;
	}
	public String getRebuiltNumber3() {
		return rebuiltNumber3;
	}
	public void setRebuiltNumber3(String rebuiltNumber3) {
		this.rebuiltNumber3 = rebuiltNumber3;
	}
	public String getRebuiltNumber4() {
		return rebuiltNumber4;
	}
	public void setRebuiltNumber4(String rebuiltNumber4) {
		this.rebuiltNumber4 = rebuiltNumber4;
	}
	public String getRebuiltNumber5() {
		return rebuiltNumber5;
	}
	public void setRebuiltNumber5(String rebuiltNumber5) {
		this.rebuiltNumber5 = rebuiltNumber5;
	}
	public String getRebuiltNumber6() {
		return rebuiltNumber6;
	}
	public void setRebuiltNumber6(String rebuiltNumber6) {
		this.rebuiltNumber6 = rebuiltNumber6;
	}
	public String getRebuiltNumber7() {
		return rebuiltNumber7;
	}
	public void setRebuiltNumber7(String rebuiltNumber7) {
		this.rebuiltNumber7 = rebuiltNumber7;
	}
	public String getRebuiltNumber8() {
		return rebuiltNumber8;
	}
	public void setRebuiltNumber8(String rebuiltNumber8) {
		this.rebuiltNumber8 = rebuiltNumber8;
	}
	public String getRebuiltNumber9() {
		return rebuiltNumber9;
	}
	public void setRebuiltNumber9(String rebuiltNumber9) {
		this.rebuiltNumber9 = rebuiltNumber9;
	}
	public String getRebuiltReason1() {
		return rebuiltReason1;
	}
	public void setRebuiltReason1(String rebuiltReason1) {
		this.rebuiltReason1 = rebuiltReason1;
	}
	public String getRebuiltReason10() {
		return rebuiltReason10;
	}
	public void setRebuiltReason10(String rebuiltReason10) {
		this.rebuiltReason10 = rebuiltReason10;
	}
	public String getRebuiltReason2() {
		return rebuiltReason2;
	}
	public void setRebuiltReason2(String rebuiltReason2) {
		this.rebuiltReason2 = rebuiltReason2;
	}
	public String getRebuiltReason3() {
		return rebuiltReason3;
	}
	public void setRebuiltReason3(String rebuiltReason3) {
		this.rebuiltReason3 = rebuiltReason3;
	}
	public String getRebuiltReason4() {
		return rebuiltReason4;
	}
	public void setRebuiltReason4(String rebuiltReason4) {
		this.rebuiltReason4 = rebuiltReason4;
	}
	public String getRebuiltReason5() {
		return rebuiltReason5;
	}
	public void setRebuiltReason5(String rebuiltReason5) {
		this.rebuiltReason5 = rebuiltReason5;
	}
	public String getRebuiltReason6() {
		return rebuiltReason6;
	}
	public void setRebuiltReason6(String rebuiltReason6) {
		this.rebuiltReason6 = rebuiltReason6;
	}
	public String getRebuiltReason7() {
		return rebuiltReason7;
	}
	public void setRebuiltReason7(String rebuiltReason7) {
		this.rebuiltReason7 = rebuiltReason7;
	}
	public String getRebuiltReason8() {
		return rebuiltReason8;
	}
	public void setRebuiltReason8(String rebuiltReason8) {
		this.rebuiltReason8 = rebuiltReason8;
	}
	public String getRebuiltReason9() {
		return rebuiltReason9;
	}
	public void setRebuiltReason9(String rebuiltReason9) {
		this.rebuiltReason9 = rebuiltReason9;
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
	public String[] getTyreNumbers() {
		return tyreNumbers;
	}
	public void setTyreNumbers(String[] tyreNumbers) {
		this.tyreNumbers = tyreNumbers;
	}
	public ArrayList getTyreDetailsList() {
		return tyreDetailsList;
	}
	public void setTyreDetailsList(ArrayList tyreDetailsList) {
		this.tyreDetailsList = tyreDetailsList;
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
	public String getBillAmount() {
		return billAmount;
	}
	public void setBillAmount(String billAmount) {
		this.billAmount = billAmount;
	}
	public String getBillDate() {
		return billDate;
	}
	public void setBillDate(String billDate) {
		this.billDate = billDate;
	}
	public String getBillNumber() {
		return billNumber;
	}
	public void setBillNumber(String billNumber) {
		this.billNumber = billNumber;
	}
	
	
}
