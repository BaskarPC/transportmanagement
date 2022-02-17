package com.formbean;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.validator.ValidatorForm;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.action.GeneralNotePurchaseAction;
public class GeneralNotePurchaseForm extends ValidatorForm{
	private static final Logger logger=(Logger)Logger.getLogger(GeneralNotePurchaseForm.class);
	private String billDate=null;
	private String billNo=null;
	private String goodsType=null;
	private String deliveredDate=null;
	private String companyName=null;
	private String place=null;
	private String itemDes1=null;
	private String itemDes2=null;
	private String itemDes3=null;
	private String itemDes4=null;
	private String itemDes5=null;
	private String itemDes6=null;
	private String itemDes7=null;
	private String itemDes8=null;
	private String itemDes9=null;
	private String itemDes10=null;
	private String qtyPurchased1=null;
	private String qtyPurchased2=null;
	private String qtyPurchased3=null;
	private String qtyPurchased4=null;
	private String qtyPurchased5=null;
	private String qtyPurchased6=null;
	private String qtyPurchased7=null;
	private String qtyPurchased8=null;
	private String qtyPurchased9=null;
	private String qtyPurchased10=null;
	private String unitPrice1=null;
	private String unitPrice2=null;
	private String unitPrice3=null;
	private String unitPrice4=null;
	private String unitPrice5=null;
	private String unitPrice6=null;
	private String unitPrice7=null;
	private String unitPrice8=null;
	private String unitPrice9=null;
	private String unitPrice10=null;
	private String amount1=null;
	private String amount2=null;
	private String amount3=null;
	private String amount4=null;
	private String amount5=null;
	private String amount6=null;
	private String amount7=null;
	private String amount8=null;
	private String amount9=null;
	private String amount10=null;
	private String totalAmount=null;
	

	public ActionErrors validate(ActionMapping mapping, 
			HttpServletRequest request) 
			{ 
//			 Perform validator framework validations 
			ActionErrors errors = new ActionErrors(); 
//			 Only need crossfield validations here 
	//		if (StringUtils.isEmpty(GeneralBillDate) ) { 
		//	errors.add(ActionErrors.GLOBAL_MESSAGE,new ActionMessage("error.sparedname")); 
		//	} 
		//	if (StringUtils.isEmpty(sparereqdname) ) { 
			//	errors.add(ActionErrors.GLOBAL_MESSAGE,new ActionMessage("error.sparereqdname")); 
			//	} 
			return errors; 
			}


	public String getAmount1() {
		return amount1;
	}


	public void setAmount1(String amount1) {
		this.amount1 = amount1;
	}


	public String getAmount10() {
		return amount10;
	}


	public void setAmount10(String amount10) {
		this.amount10 = amount10;
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


	public String getAmount9() {
		return amount9;
	}


	public void setAmount9(String amount9) {
		this.amount9 = amount9;
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


	public String getItemDes1() {
		return itemDes1;
	}


	public void setItemDes1(String itemDes1) {
		this.itemDes1 = itemDes1;
	}


	public String getItemDes10() {
		return itemDes10;
	}


	public void setItemDes10(String itemDes10) {
		this.itemDes10 = itemDes10;
	}


	public String getItemDes2() {
		return itemDes2;
	}


	public void setItemDes2(String itemDes2) {
		this.itemDes2 = itemDes2;
	}


	public String getItemDes3() {
		return itemDes3;
	}


	public void setItemDes3(String itemDes3) {
		this.itemDes3 = itemDes3;
	}


	public String getItemDes4() {
		return itemDes4;
	}


	public void setItemDes4(String itemDes4) {
		this.itemDes4 = itemDes4;
	}


	public String getItemDes5() {
		return itemDes5;
	}


	public void setItemDes5(String itemDes5) {
		this.itemDes5 = itemDes5;
	}


	public String getItemDes6() {
		return itemDes6;
	}


	public void setItemDes6(String itemDes6) {
		this.itemDes6 = itemDes6;
	}


	public String getItemDes7() {
		return itemDes7;
	}


	public void setItemDes7(String itemDes7) {
		this.itemDes7 = itemDes7;
	}


	public String getItemDes8() {
		return itemDes8;
	}


	public void setItemDes8(String itemDes8) {
		this.itemDes8 = itemDes8;
	}


	public String getItemDes9() {
		return itemDes9;
	}


	public void setItemDes9(String itemDes9) {
		this.itemDes9 = itemDes9;
	}


	public String getPlace() {
		return place;
	}


	public void setPlace(String place) {
		this.place = place;
	}


	public String getQtyPurchased1() {
		return qtyPurchased1;
	}


	public void setQtyPurchased1(String qtyPurchased1) {
		this.qtyPurchased1 = qtyPurchased1;
	}


	public String getQtyPurchased10() {
		return qtyPurchased10;
	}


	public void setQtyPurchased10(String qtyPurchased10) {
		this.qtyPurchased10 = qtyPurchased10;
	}


	public String getQtyPurchased2() {
		return qtyPurchased2;
	}


	public void setQtyPurchased2(String qtyPurchased2) {
		this.qtyPurchased2 = qtyPurchased2;
	}


	public String getQtyPurchased3() {
		return qtyPurchased3;
	}


	public void setQtyPurchased3(String qtyPurchased3) {
		this.qtyPurchased3 = qtyPurchased3;
	}


	public String getQtyPurchased4() {
		return qtyPurchased4;
	}


	public void setQtyPurchased4(String qtyPurchased4) {
		this.qtyPurchased4 = qtyPurchased4;
	}


	public String getQtyPurchased5() {
		return qtyPurchased5;
	}


	public void setQtyPurchased5(String qtyPurchased5) {
		this.qtyPurchased5 = qtyPurchased5;
	}


	public String getQtyPurchased6() {
		return qtyPurchased6;
	}


	public void setQtyPurchased6(String qtyPurchased6) {
		this.qtyPurchased6 = qtyPurchased6;
	}


	public String getQtyPurchased7() {
		return qtyPurchased7;
	}


	public void setQtyPurchased7(String qtyPurchased7) {
		this.qtyPurchased7 = qtyPurchased7;
	}


	public String getQtyPurchased8() {
		return qtyPurchased8;
	}


	public void setQtyPurchased8(String qtyPurchased8) {
		this.qtyPurchased8 = qtyPurchased8;
	}


	public String getQtyPurchased9() {
		return qtyPurchased9;
	}


	public void setQtyPurchased9(String qtyPurchased9) {
		this.qtyPurchased9 = qtyPurchased9;
	}


	public String getUnitPrice1() {
		return unitPrice1;
	}


	public void setUnitPrice1(String unitPrice1) {
		this.unitPrice1 = unitPrice1;
	}


	public String getUnitPrice10() {
		return unitPrice10;
	}


	public void setUnitPrice10(String unitPrice10) {
		this.unitPrice10 = unitPrice10;
	}


	public String getUnitPrice2() {
		return unitPrice2;
	}


	public void setUnitPrice2(String unitPrice2) {
		this.unitPrice2 = unitPrice2;
	}


	public String getUnitPrice3() {
		return unitPrice3;
	}


	public void setUnitPrice3(String unitPrice3) {
		this.unitPrice3 = unitPrice3;
	}


	public String getUnitPrice4() {
		return unitPrice4;
	}


	public void setUnitPrice4(String unitPrice4) {
		this.unitPrice4 = unitPrice4;
	}


	public String getUnitPrice5() {
		return unitPrice5;
	}


	public void setUnitPrice5(String unitPrice5) {
		this.unitPrice5 = unitPrice5;
	}


	public String getUnitPrice6() {
		return unitPrice6;
	}


	public void setUnitPrice6(String unitPrice6) {
		this.unitPrice6 = unitPrice6;
	}


	public String getUnitPrice7() {
		return unitPrice7;
	}


	public void setUnitPrice7(String unitPrice7) {
		this.unitPrice7 = unitPrice7;
	}


	public String getUnitPrice8() {
		return unitPrice8;
	}


	public void setUnitPrice8(String unitPrice8) {
		this.unitPrice8 = unitPrice8;
	}


	public String getUnitPrice9() {
		return unitPrice9;
	}


	public void setUnitPrice9(String unitPrice9) {
		this.unitPrice9 = unitPrice9;
	}


	public String getTotalAmount() {
		return totalAmount;
	}


	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}

}
