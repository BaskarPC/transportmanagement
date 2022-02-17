package com.formbean;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.validator.ValidatorForm;
public class PaintSparepartsPurchaseForm extends  ValidatorForm{
	private String billDate;
	private String billNo;
	private String deliveredDate;
	private String companyName;
	private String place;
	private String itemDes;
	private String brandName1;
	private String brandType1;
	private String partNo1;
	private String availableQty1;
	private String qtyPurchased1;
	private String unitPrice1;
	private String vatPercent1;
	private String vatAmount1;
	private String additionalAmount1;
	private String amount1;
	private String brandName2;
	private String brandType2;
	private String partNo2;
	private String availableQty2;
	private String qtyPurchased2;
	private String unitPrice2;
	private String vatPercent2;
	private String vatAmount2;
	private String additionalAmount2;
	private String amount2;
	private String brandName3;
	private String brandType3;
	private String partNo3;
	private String availableQty3;
	private String qtyPurchased3;
	private String unitPrice3;
	private String vatPercent3;
	private String vatAmount3;
	private String additionalAmount3;
	private String amount3;
	private String brandName4;
	private String brandType4;
	private String partNo4;
	private String availableQty4;
	private String qtyPurchased4;
	private String unitPrice4;
	private String vatPercent4;
	private String vatAmount4;
	private String additionalAmount4;
	private String amount4;
	private String brandName5;
	private String brandType5;
	private String partNo5;
	private String availableQty5;
	private String qtyPurchased5;
	private String unitPrice5;
	private String vatPercent5;
	private String vatAmount5;
	private String additionalAmount5;
	private String amount5;
	private String totalAmount;
	public String getAdditionalAmount1() {
		return additionalAmount1;
	}
	public void setAdditionalAmount1(String additionalAmount1) {
		this.additionalAmount1 = additionalAmount1;
	}
	public String getAdditionalAmount2() {
		return additionalAmount2;
	}
	public void setAdditionalAmount2(String additionalAmount2) {
		this.additionalAmount2 = additionalAmount2;
	}
	public String getAdditionalAmount3() {
		return additionalAmount3;
	}
	public void setAdditionalAmount3(String additionalAmount3) {
		this.additionalAmount3 = additionalAmount3;
	}
	public String getAdditionalAmount4() {
		return additionalAmount4;
	}
	public void setAdditionalAmount4(String additionalAmount4) {
		this.additionalAmount4 = additionalAmount4;
	}
	public String getAdditionalAmount5() {
		return additionalAmount5;
	}
	public void setAdditionalAmount5(String additionalAmount5) {
		this.additionalAmount5 = additionalAmount5;
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
	public String getAvailableQty1() {
		return availableQty1;
	}
	public void setAvailableQty1(String availableQty1) {
		this.availableQty1 = availableQty1;
	}
	public String getAvailableQty2() {
		return availableQty2;
	}
	public void setAvailableQty2(String availableQty2) {
		this.availableQty2 = availableQty2;
	}
	public String getAvailableQty3() {
		return availableQty3;
	}
	public void setAvailableQty3(String availableQty3) {
		this.availableQty3 = availableQty3;
	}
	public String getAvailableQty4() {
		return availableQty4;
	}
	public void setAvailableQty4(String availableQty4) {
		this.availableQty4 = availableQty4;
	}
	public String getAvailableQty5() {
		return availableQty5;
	}
	public void setAvailableQty5(String availableQty5) {
		this.availableQty5 = availableQty5;
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
	public String getBrandName1() {
		return brandName1;
	}
	public void setBrandName1(String brandName1) {
		this.brandName1 = brandName1;
	}
	public String getBrandName2() {
		return brandName2;
	}
	public void setBrandName2(String brandName2) {
		this.brandName2 = brandName2;
	}
	public String getBrandName3() {
		return brandName3;
	}
	public void setBrandName3(String brandName3) {
		this.brandName3 = brandName3;
	}
	public String getBrandName4() {
		return brandName4;
	}
	public void setBrandName4(String brandName4) {
		this.brandName4 = brandName4;
	}
	public String getBrandName5() {
		return brandName5;
	}
	public void setBrandName5(String brandName5) {
		this.brandName5 = brandName5;
	}
	public String getBrandType1() {
		return brandType1;
	}
	public void setBrandType1(String brandType1) {
		this.brandType1 = brandType1;
	}
	public String getBrandType2() {
		return brandType2;
	}
	public void setBrandType2(String brandType2) {
		this.brandType2 = brandType2;
	}
	public String getBrandType3() {
		return brandType3;
	}
	public void setBrandType3(String brandType3) {
		this.brandType3 = brandType3;
	}
	public String getBrandType4() {
		return brandType4;
	}
	public void setBrandType4(String brandType4) {
		this.brandType4 = brandType4;
	}
	public String getBrandType5() {
		return brandType5;
	}
	public void setBrandType5(String brandType5) {
		this.brandType5 = brandType5;
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
	public String getItemDes() {
		return itemDes;
	}
	public void setItemDes(String itemDes) {
		this.itemDes = itemDes;
	}
	public String getPartNo1() {
		return partNo1;
	}
	public void setPartNo1(String partNo1) {
		this.partNo1 = partNo1;
	}
	public String getPartNo2() {
		return partNo2;
	}
	public void setPartNo2(String partNo2) {
		this.partNo2 = partNo2;
	}
	public String getPartNo3() {
		return partNo3;
	}
	public void setPartNo3(String partNo3) {
		this.partNo3 = partNo3;
	}
	public String getPartNo4() {
		return partNo4;
	}
	public void setPartNo4(String partNo4) {
		this.partNo4 = partNo4;
	}
	public String getPartNo5() {
		return partNo5;
	}
	public void setPartNo5(String partNo5) {
		this.partNo5 = partNo5;
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
	public String getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getUnitPrice1() {
		return unitPrice1;
	}
	public void setUnitPrice1(String unitPrice1) {
		this.unitPrice1 = unitPrice1;
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
	public String getVatAmount1() {
		return vatAmount1;
	}
	public void setVatAmount1(String vatAmount1) {
		this.vatAmount1 = vatAmount1;
	}
	public String getVatAmount2() {
		return vatAmount2;
	}
	public void setVatAmount2(String vatAmount2) {
		this.vatAmount2 = vatAmount2;
	}
	public String getVatAmount3() {
		return vatAmount3;
	}
	public void setVatAmount3(String vatAmount3) {
		this.vatAmount3 = vatAmount3;
	}
	public String getVatAmount4() {
		return vatAmount4;
	}
	public void setVatAmount4(String vatAmount4) {
		this.vatAmount4 = vatAmount4;
	}
	public String getVatAmount5() {
		return vatAmount5;
	}
	public void setVatAmount5(String vatAmount5) {
		this.vatAmount5 = vatAmount5;
	}
	public String getVatPercent1() {
		return vatPercent1;
	}
	public void setVatPercent1(String vatPercent1) {
		this.vatPercent1 = vatPercent1;
	}
	public String getVatPercent2() {
		return vatPercent2;
	}
	public void setVatPercent2(String vatPercent2) {
		this.vatPercent2 = vatPercent2;
	}
	public String getVatPercent3() {
		return vatPercent3;
	}
	public void setVatPercent3(String vatPercent3) {
		this.vatPercent3 = vatPercent3;
	}
	public String getVatPercent4() {
		return vatPercent4;
	}
	public void setVatPercent4(String vatPercent4) {
		this.vatPercent4 = vatPercent4;
	}
	public String getVatPercent5() {
		return vatPercent5;
	}
	public void setVatPercent5(String vatPercent5) {
		this.vatPercent5 = vatPercent5;
	}

}
