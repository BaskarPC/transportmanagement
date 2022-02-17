package com.formbean;
import org.apache.struts.validator.ValidatorForm;
public class DieselPurchaseForm extends  ValidatorForm{
	private String partNo;
	private String amount;
	private String billDate;
	private String vatPercent;
	private String billNo;
	private String vatAmount;
	private String deliveredDate;
	private String additionalAmount;
	private String goodsType;
	private String totalAmount;
	private String companyName;
	private String deliveryVehicleNo;
	private String place;
	private String driverName;
	private String loadNo;
	private String deliveryAmount;
	private String qtyPurchased;
	private String deliveryTime;
	private String unitPrice;
	private String tipScale;
	public String getAdditionalAmount() {
		return additionalAmount;
	}
	public void setAdditionalAmount(String additionalAmount) {
		this.additionalAmount = additionalAmount;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
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
	public String getDeliveryAmount() {
		return deliveryAmount;
	}
	public void setDeliveryAmount(String deliveryAmount) {
		this.deliveryAmount = deliveryAmount;
	}
	public String getDeliveryTime() {
		return deliveryTime;
	}
	public void setDeliveryTime(String deliveryTime) {
		this.deliveryTime = deliveryTime;
	}
	public String getDeliveryVehicleNo() {
		return deliveryVehicleNo;
	}
	public void setDeliveryVehicleNo(String deliveryVehicleNo) {
		this.deliveryVehicleNo = deliveryVehicleNo;
	}
	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	public String getGoodsType() {
		return goodsType;
	}
	public void setGoodsType(String goodsType) {
		this.goodsType = goodsType;
	}
	public String getLoadNo() {
		return loadNo;
	}
	public void setLoadNo(String loadNo) {
		this.loadNo = loadNo;
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
	public String getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(String unitPrice) {
		this.unitPrice = unitPrice;
	}
	public String getVatAmount() {
		return vatAmount;
	}
	public void setVatAmount(String vatAmount) {
		this.vatAmount = vatAmount;
	}
	public String getVatPercent() {
		return vatPercent;
	}
	public void setVatPercent(String vatPercent) {
		this.vatPercent = vatPercent;
	}
	public String getQtyPurchased() {
		return qtyPurchased;
	}
	public void setQtyPurchased(String qtyPurchased) {
		this.qtyPurchased = qtyPurchased;
	}
	public String getTipScale() {
		return tipScale;
	}
	public void setTipScale(String tipScale) {
		this.tipScale = tipScale;
	}

}
