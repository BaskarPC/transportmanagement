package com.formbean;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;
public class TyrePurchaseForm extends ValidatorForm{
	private String code=null;
	private String ctype=null;
	private String des=null;
	private String billDate=null;
	private String billNo=null;
	private String deliveredDate=null;
	private String companyName=null;
	private ArrayList companyNameList;
	private String place=null;
	private ArrayList placeList;
	private String goodsType=null;
	private String partNo=null;
	private String tyreType1=null;
	private String tyreSize1=null;
	private String tyrePly1=null;
	private String tyreParts1=null;
	private String tyreNo1=null;
	private String tyreRate1=null;
	private String VATPercent1=null;
	private String VATAmount1=null;
	private String additionalAmt1=null;
	private String amount1=null;
	private String tyreType2=null;
	private String tyreSize2=null;
	private String tyrePly2=null;
	private String tyreParts2=null;
	private String tyreNo2=null;
	private String tyreRate2=null;
	private String VATPercent2=null;
	private String VATAmount2=null;
	private String additionalAmt2=null;
	private String amount2=null;
	private String tyreType3=null;
	private String tyreSize3=null;
	private String tyrePly3=null;
	private String tyreParts3=null;
	private String tyreNo3=null;
	private String tyreRate3=null;
	private String VATPercent3=null;
	private String VATAmount3=null;
	private String additionalAmt3=null;
	private String amount3=null;
	private String tyreType4=null;
	private String tyreSize4=null;
	private String tyrePly4=null;
	private String tyreParts4=null;
	private String tyreNo4=null;
	private String tyreRate4=null;
	private String VATPercent4=null;
	private String VATAmount4=null;
	private String additionalAmt4=null;
	private String amount4=null;
	private String tyreType5=null;
	private String tyreSize5=null;
	private String tyrePly5=null;
	private String tyreParts5=null;
	private String tyreNo5=null;
	private String tyreRate5=null;
	private String VATPercent5=null;
	private String VATAmount5=null;
	private String additionalAmt5=null;
	private String amount5=null;
	private String tyreType6=null;
	private String tyreSize6=null;
	private String tyrePly6=null;
	private String tyreParts6=null;
	private String tyreNo6=null;
	private String tyreRate6=null;
	private String VATPercent6=null;
	private String VATAmount6=null;
	private String additionalAmt6=null;
	private String amount6=null;
	private String tyreType7=null;
	private String tyreSize7=null;
	private String tyrePly7=null;
	private String tyreParts7=null;
	private String tyreNo7=null;
	private String tyreRate7=null;
	private String VATPercent7=null;
	private String VATAmount7=null;
	private String additionalAmt7=null;
	private String amount7=null;
	private String tyreType8=null;
	private String tyreSize8=null;
	private String tyrePly8=null;
	private String tyreParts8=null;
	private String tyreNo8=null;
	private String tyreRate8=null;
	private String VATPercent8=null;
	private String VATAmount8=null;
	private String additionalAmt8=null;
	private String amount8=null;
	private String totalAmount=null;
	private ArrayList tyreTypeList;
	private ArrayList tyreSizeList;
	private ArrayList tyrePlyList;
	private ArrayList tyrePartsList;

	public String getAdditionalAmt1() {
		return additionalAmt1;
	}

	public void setAdditionalAmt1(String additionalAmt1) {
		this.additionalAmt1 = additionalAmt1;
	}

	public String getAdditionalAmt2() {
		return additionalAmt2;
	}

	public void setAdditionalAmt2(String additionalAmt2) {
		this.additionalAmt2 = additionalAmt2;
	}

	public String getAdditionalAmt3() {
		return additionalAmt3;
	}

	public void setAdditionalAmt3(String additionalAmt3) {
		this.additionalAmt3 = additionalAmt3;
	}

	public String getAdditionalAmt4() {
		return additionalAmt4;
	}

	public void setAdditionalAmt4(String additionalAmt4) {
		this.additionalAmt4 = additionalAmt4;
	}

	public String getAdditionalAmt5() {
		return additionalAmt5;
	}

	public void setAdditionalAmt5(String additionalAmt5) {
		this.additionalAmt5 = additionalAmt5;
	}

	public String getAmount1() {
		return amount1;
	}

	public void setAmount1(String amount1) {
		this.amount1 = amount1;
	}

	public String getAmount2() {
		return amount2;
	}

	public void setAmount2(String amount2) {
		this.amount2 = amount2;
	}

	public String getAmount3() {
		return amount3;
	}

	public void setAmount3(String amount3) {
		this.amount3 = amount3;
	}

	public String getAmount4() {
		return amount4;
	}

	public void setAmount4(String amount4) {
		this.amount4 = amount4;
	}

	public String getAmount5() {
		return amount5;
	}

	public void setAmount5(String amount5) {
		this.amount5 = amount5;
	}

	public String getBillDate() {
		return billDate;
	}

	public void setBillDate(String billDate) {
		this.billDate = billDate;
	}

	public String getBillNo() {
		return billNo;
	}

	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getDeliveredDate() {
		return deliveredDate;
	}

	public void setDeliveredDate(String deliveredDate) {
		this.deliveredDate = deliveredDate;
	}

	public String getGoodsType() {
		return goodsType;
	}

	public void setGoodsType(String goodsType) {
		this.goodsType = goodsType;
	}

	public String getPartNo() {
		return partNo;
	}

	public void setPartNo(String partNo) {
		this.partNo = partNo;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getTyreNo1() {
		return tyreNo1;
	}

	public void setTyreNo1(String tyreNo1) {
		this.tyreNo1 = tyreNo1;
	}

	public String getTyreNo2() {
		return tyreNo2;
	}

	public void setTyreNo2(String tyreNo2) {
		this.tyreNo2 = tyreNo2;
	}

	public String getTyreNo3() {
		return tyreNo3;
	}

	public void setTyreNo3(String tyreNo3) {
		this.tyreNo3 = tyreNo3;
	}

	public String getTyreNo4() {
		return tyreNo4;
	}

	public void setTyreNo4(String tyreNo4) {
		this.tyreNo4 = tyreNo4;
	}

	public String getTyreNo5() {
		return tyreNo5;
	}

	public void setTyreNo5(String tyreNo5) {
		this.tyreNo5 = tyreNo5;
	}

	public String getTyreParts1() {
		return tyreParts1;
	}

	public void setTyreParts1(String tyreParts1) {
		this.tyreParts1 = tyreParts1;
	}

	public String getTyreParts2() {
		return tyreParts2;
	}

	public void setTyreParts2(String tyreParts2) {
		this.tyreParts2 = tyreParts2;
	}

	public String getTyreParts3() {
		return tyreParts3;
	}

	public void setTyreParts3(String tyreParts3) {
		this.tyreParts3 = tyreParts3;
	}

	public String getTyreParts4() {
		return tyreParts4;
	}

	public void setTyreParts4(String tyreParts4) {
		this.tyreParts4 = tyreParts4;
	}

	public String getTyreParts5() {
		return tyreParts5;
	}

	public void setTyreParts5(String tyreParts5) {
		this.tyreParts5 = tyreParts5;
	}

	public String getTyrePly1() {
		return tyrePly1;
	}

	public void setTyrePly1(String tyrePly1) {
		this.tyrePly1 = tyrePly1;
	}

	public String getTyrePly2() {
		return tyrePly2;
	}

	public void setTyrePly2(String tyrePly2) {
		this.tyrePly2 = tyrePly2;
	}

	public String getTyrePly3() {
		return tyrePly3;
	}

	public void setTyrePly3(String tyrePly3) {
		this.tyrePly3 = tyrePly3;
	}

	public String getTyrePly4() {
		return tyrePly4;
	}

	public void setTyrePly4(String tyrePly4) {
		this.tyrePly4 = tyrePly4;
	}

	public String getTyrePly5() {
		return tyrePly5;
	}

	public void setTyrePly5(String tyrePly5) {
		this.tyrePly5 = tyrePly5;
	}

	public String getTyreRate1() {
		return tyreRate1;
	}

	public void setTyreRate1(String tyreRate1) {
		this.tyreRate1 = tyreRate1;
	}

	public String getTyreRate2() {
		return tyreRate2;
	}

	public void setTyreRate2(String tyreRate2) {
		this.tyreRate2 = tyreRate2;
	}

	public String getTyreRate3() {
		return tyreRate3;
	}

	public void setTyreRate3(String tyreRate3) {
		this.tyreRate3 = tyreRate3;
	}

	public String getTyreRate4() {
		return tyreRate4;
	}

	public void setTyreRate4(String tyreRate4) {
		this.tyreRate4 = tyreRate4;
	}

	public String getTyreRate5() {
		return tyreRate5;
	}

	public void setTyreRate5(String tyreRate5) {
		this.tyreRate5 = tyreRate5;
	}

	public String getTyreSize1() {
		return tyreSize1;
	}

	public void setTyreSize1(String tyreSize1) {
		this.tyreSize1 = tyreSize1;
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

	public String getTyreType1() {
		return tyreType1;
	}

	public void setTyreType1(String tyreType1) {
		this.tyreType1 = tyreType1;
	}

	public String getTyreType2() {
		return tyreType2;
	}

	public void setTyreType2(String tyreType2) {
		this.tyreType2 = tyreType2;
	}

	public String getTyreType3() {
		return tyreType3;
	}

	public void setTyreType3(String tyreType3) {
		this.tyreType3 = tyreType3;
	}

	public String getTyreType4() {
		return tyreType4;
	}

	public void setTyreType4(String tyreType4) {
		this.tyreType4 = tyreType4;
	}

	public String getTyreType5() {
		return tyreType5;
	}

	public void setTyreType5(String tyreType5) {
		this.tyreType5 = tyreType5;
	}

	public String getVATAmount1() {
		return VATAmount1;
	}

	public void setVATAmount1(String amount1) {
		VATAmount1 = amount1;
	}

	public String getVATAmount2() {
		return VATAmount2;
	}

	public void setVATAmount2(String amount2) {
		VATAmount2 = amount2;
	}

	public String getVATAmount3() {
		return VATAmount3;
	}

	public void setVATAmount3(String amount3) {
		VATAmount3 = amount3;
	}

	public String getVATAmount4() {
		return VATAmount4;
	}

	public void setVATAmount4(String amount4) {
		VATAmount4 = amount4;
	}

	public String getVATAmount5() {
		return VATAmount5;
	}

	public void setVATAmount5(String amount5) {
		VATAmount5 = amount5;
	}

	public String getVATPercent1() {
		return VATPercent1;
	}

	public void setVATPercent1(String percent1) {
		VATPercent1 = percent1;
	}

	public String getVATPercent2() {
		return VATPercent2;
	}

	public void setVATPercent2(String percent2) {
		VATPercent2 = percent2;
	}

	public String getVATPercent3() {
		return VATPercent3;
	}

	public void setVATPercent3(String percent3) {
		VATPercent3 = percent3;
	}

	public String getVATPercent4() {
		return VATPercent4;
	}

	public void setVATPercent4(String percent4) {
		VATPercent4 = percent4;
	}

	public String getVATPercent5() {
		return VATPercent5;
	}

	public void setVATPercent5(String percent5) {
		VATPercent5 = percent5;
	}

	public ArrayList getCompanyNameList() {
		return companyNameList;
	}

	public void setCompanyNameList(ArrayList companyNameList) {
		this.companyNameList = companyNameList;
	}

	public ArrayList getPlaceList() {
		return placeList;
	}

	public void setPlaceList(ArrayList placeList) {
		this.placeList = placeList;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCtype() {
		return ctype;
	}

	public void setCtype(String ctype) {
		this.ctype = ctype;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public ArrayList getTyrePartsList() {
		return tyrePartsList;
	}

	public void setTyrePartsList(ArrayList tyrePartsList) {
		this.tyrePartsList = tyrePartsList;
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

	public ArrayList getTyreTypeList() {
		return tyreTypeList;
	}

	public void setTyreTypeList(ArrayList tyreTypeList) {
		this.tyreTypeList = tyreTypeList;
	}

	public String getAdditionalAmt6() {
		return additionalAmt6;
	}

	public void setAdditionalAmt6(String additionalAmt6) {
		this.additionalAmt6 = additionalAmt6;
	}

	public String getAdditionalAmt7() {
		return additionalAmt7;
	}

	public void setAdditionalAmt7(String additionalAmt7) {
		this.additionalAmt7 = additionalAmt7;
	}

	public String getAdditionalAmt8() {
		return additionalAmt8;
	}

	public void setAdditionalAmt8(String additionalAmt8) {
		this.additionalAmt8 = additionalAmt8;
	}

	public String getAmount6() {
		return amount6;
	}

	public void setAmount6(String amount6) {
		this.amount6 = amount6;
	}

	public String getAmount7() {
		return amount7;
	}

	public void setAmount7(String amount7) {
		this.amount7 = amount7;
	}

	public String getAmount8() {
		return amount8;
	}

	public void setAmount8(String amount8) {
		this.amount8 = amount8;
	}

	public String getTyreNo6() {
		return tyreNo6;
	}

	public void setTyreNo6(String tyreNo6) {
		this.tyreNo6 = tyreNo6;
	}

	public String getTyreNo7() {
		return tyreNo7;
	}

	public void setTyreNo7(String tyreNo7) {
		this.tyreNo7 = tyreNo7;
	}

	public String getTyreNo8() {
		return tyreNo8;
	}

	public void setTyreNo8(String tyreNo8) {
		this.tyreNo8 = tyreNo8;
	}

	public String getTyreParts6() {
		return tyreParts6;
	}

	public void setTyreParts6(String tyreParts6) {
		this.tyreParts6 = tyreParts6;
	}

	public String getTyreParts7() {
		return tyreParts7;
	}

	public void setTyreParts7(String tyreParts7) {
		this.tyreParts7 = tyreParts7;
	}

	public String getTyreParts8() {
		return tyreParts8;
	}

	public void setTyreParts8(String tyreParts8) {
		this.tyreParts8 = tyreParts8;
	}

	public String getTyrePly6() {
		return tyrePly6;
	}

	public void setTyrePly6(String tyrePly6) {
		this.tyrePly6 = tyrePly6;
	}

	public String getTyrePly7() {
		return tyrePly7;
	}

	public void setTyrePly7(String tyrePly7) {
		this.tyrePly7 = tyrePly7;
	}

	public String getTyrePly8() {
		return tyrePly8;
	}

	public void setTyrePly8(String tyrePly8) {
		this.tyrePly8 = tyrePly8;
	}

	public String getTyreRate6() {
		return tyreRate6;
	}

	public void setTyreRate6(String tyreRate6) {
		this.tyreRate6 = tyreRate6;
	}

	public String getTyreRate7() {
		return tyreRate7;
	}

	public void setTyreRate7(String tyreRate7) {
		this.tyreRate7 = tyreRate7;
	}

	public String getTyreRate8() {
		return tyreRate8;
	}

	public void setTyreRate8(String tyreRate8) {
		this.tyreRate8 = tyreRate8;
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

	public String getTyreType6() {
		return tyreType6;
	}

	public void setTyreType6(String tyreType6) {
		this.tyreType6 = tyreType6;
	}

	public String getTyreType7() {
		return tyreType7;
	}

	public void setTyreType7(String tyreType7) {
		this.tyreType7 = tyreType7;
	}

	public String getTyreType8() {
		return tyreType8;
	}

	public void setTyreType8(String tyreType8) {
		this.tyreType8 = tyreType8;
	}

	public String getVATAmount6() {
		return VATAmount6;
	}

	public void setVATAmount6(String amount6) {
		VATAmount6 = amount6;
	}

	public String getVATAmount7() {
		return VATAmount7;
	}

	public void setVATAmount7(String amount7) {
		VATAmount7 = amount7;
	}

	public String getVATAmount8() {
		return VATAmount8;
	}

	public void setVATAmount8(String amount8) {
		VATAmount8 = amount8;
	}

	public String getVATPercent6() {
		return VATPercent6;
	}

	public void setVATPercent6(String percent6) {
		VATPercent6 = percent6;
	}

	public String getVATPercent7() {
		return VATPercent7;
	}

	public void setVATPercent7(String percent7) {
		VATPercent7 = percent7;
	}

	public String getVATPercent8() {
		return VATPercent8;
	}

	public void setVATPercent8(String percent8) {
		VATPercent8 = percent8;
	}

	


}
