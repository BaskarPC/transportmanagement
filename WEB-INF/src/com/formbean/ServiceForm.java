package com.formbean;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

public class ServiceForm extends GeneralForm{
	
	private String location=null;
	private String shopName=null;
	private String serviceName1=null;
	private String serviceName2=null;
	private String serviceName3=null;
	private String serviceName4=null;
	private String serviceName5=null;
	private String currentKm1=null;
	private String currentKm2=null;
	private String currentKm3=null;
	private String currentKm4=null;
	private String currentKm5=null;
	private String currentKm6=null;
	private String currentKm7=null;
	private String currentKm8=null;
	private String currentKm9=null;
	private String currentKm10=null;
	private String totalAmount1=null;
	private String totalAmount2=null;
	private String totalAmount3=null;
	private String totalAmount4=null;
	private String totalAmount5=null;
	private String totalAmount6=null;
	private String totalAmount7=null;
	private String totalAmount8=null;
	private String totalAmount9=null;
	private String totalAmount10=null;
	private String serviceWarranty1=null;
	private String serviceWarranty2=null;
	private String serviceWarranty3=null;
	private String serviceWarranty4=null;
	private String serviceWarranty5=null;
	private String serviceWarranty6=null;
	private String serviceWarranty7=null;
	private String serviceWarranty8=null;
	private String serviceWarranty9=null;
	private String serviceWarranty10=null;
	private String nameOfService1=null;
	private String nameOfService2=null;
	private String nameOfService3=null;
	private String nameOfService4=null;
	private String nameOfService5=null;
	private String service=null;
	/**
	 * @return the nameOfService1
	 */
	public String getNameOfService1() {
		return nameOfService1;
	}
	/**
	 * @param nameOfService1 the nameOfService1 to set
	 */
	public void setNameOfService1(String nameOfService1) {
		this.nameOfService1 = nameOfService1;
	}
	/**
	 * @return the nameOfService2
	 */
	public String getNameOfService2() {
		return nameOfService2;
	}
	/**
	 * @param nameOfService2 the nameOfService2 to set
	 */
	public void setNameOfService2(String nameOfService2) {
		this.nameOfService2 = nameOfService2;
	}
	/**
	 * @return the nameOfService3
	 */
	public String getNameOfService3() {
		return nameOfService3;
	}
	/**
	 * @param nameOfService3 the nameOfService3 to set
	 */
	public void setNameOfService3(String nameOfService3) {
		this.nameOfService3 = nameOfService3;
	}
	/**
	 * @return the nameOfService4
	 */
	public String getNameOfService4() {
		return nameOfService4;
	}
	/**
	 * @param nameOfService4 the nameOfService4 to set
	 */
	public void setNameOfService4(String nameOfService4) {
		this.nameOfService4 = nameOfService4;
	}
	/**
	 * @return the nameOfService5
	 */
	public String getNameOfService5() {
		return nameOfService5;
	}
	/**
	 * @param nameOfService5 the nameOfService5 to set
	 */
	public void setNameOfService5(String nameOfService5) {
		this.nameOfService5 = nameOfService5;
	}
	/**
	 * @return the currentKm1
	 */
	public String getCurrentKm1() {
		return currentKm1;
	}
	/**
	 * @param currentKm1 the currentKm1 to set
	 */
	public void setCurrentKm1(String currentKm1) {
		this.currentKm1 = currentKm1;
	}
	/**
	 * @return the currentKm10
	 */
	public String getCurrentKm10() {
		return currentKm10;
	}
	/**
	 * @param currentKm10 the currentKm10 to set
	 */
	public void setCurrentKm10(String currentKm10) {
		this.currentKm10 = currentKm10;
	}
	/**
	 * @return the currentKm2
	 */
	public String getCurrentKm2() {
		return currentKm2;
	}
	/**
	 * @param currentKm2 the currentKm2 to set
	 */
	public void setCurrentKm2(String currentKm2) {
		this.currentKm2 = currentKm2;
	}
	/**
	 * @return the currentKm3
	 */
	public String getCurrentKm3() {
		return currentKm3;
	}
	/**
	 * @param currentKm3 the currentKm3 to set
	 */
	public void setCurrentKm3(String currentKm3) {
		this.currentKm3 = currentKm3;
	}
	/**
	 * @return the currentKm4
	 */
	public String getCurrentKm4() {
		return currentKm4;
	}
	/**
	 * @param currentKm4 the currentKm4 to set
	 */
	public void setCurrentKm4(String currentKm4) {
		this.currentKm4 = currentKm4;
	}
	/**
	 * @return the currentKm5
	 */
	public String getCurrentKm5() {
		return currentKm5;
	}
	/**
	 * @param currentKm5 the currentKm5 to set
	 */
	public void setCurrentKm5(String currentKm5) {
		this.currentKm5 = currentKm5;
	}
	/**
	 * @return the currentKm6
	 */
	public String getCurrentKm6() {
		return currentKm6;
	}
	/**
	 * @param currentKm6 the currentKm6 to set
	 */
	public void setCurrentKm6(String currentKm6) {
		this.currentKm6 = currentKm6;
	}
	/**
	 * @return the currentKm7
	 */
	public String getCurrentKm7() {
		return currentKm7;
	}
	/**
	 * @param currentKm7 the currentKm7 to set
	 */
	public void setCurrentKm7(String currentKm7) {
		this.currentKm7 = currentKm7;
	}
	/**
	 * @return the currentKm8
	 */
	public String getCurrentKm8() {
		return currentKm8;
	}
	/**
	 * @param currentKm8 the currentKm8 to set
	 */
	public void setCurrentKm8(String currentKm8) {
		this.currentKm8 = currentKm8;
	}
	/**
	 * @return the currentKm9
	 */
	public String getCurrentKm9() {
		return currentKm9;
	}
	/**
	 * @param currentKm9 the currentKm9 to set
	 */
	public void setCurrentKm9(String currentKm9) {
		this.currentKm9 = currentKm9;
	}
	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	/**
	 * @return the serviceName1
	 */
	public String getServiceName1() {
		return serviceName1;
	}
	/**
	 * @param serviceName1 the serviceName1 to set
	 */
	public void setServiceName1(String serviceName1) {
		this.serviceName1 = serviceName1;
	}
	/**
	 * @return the serviceName2
	 */
	public String getServiceName2() {
		return serviceName2;
	}
	/**
	 * @param serviceName2 the serviceName2 to set
	 */
	public void setServiceName2(String serviceName2) {
		this.serviceName2 = serviceName2;
	}
	/**
	 * @return the serviceName3
	 */
	public String getServiceName3() {
		return serviceName3;
	}
	/**
	 * @param serviceName3 the serviceName3 to set
	 */
	public void setServiceName3(String serviceName3) {
		this.serviceName3 = serviceName3;
	}
	/**
	 * @return the serviceName4
	 */
	public String getServiceName4() {
		return serviceName4;
	}
	/**
	 * @param serviceName4 the serviceName4 to set
	 */
	public void setServiceName4(String serviceName4) {
		this.serviceName4 = serviceName4;
	}
	/**
	 * @return the serviceName5
	 */
	public String getServiceName5() {
		return serviceName5;
	}
	/**
	 * @param serviceName5 the serviceName5 to set
	 */
	public void setServiceName5(String serviceName5) {
		this.serviceName5 = serviceName5;
	}
	/**
	 * @return the serviceWarranty1
	 */
	public String getServiceWarranty1() {
		return serviceWarranty1;
	}
	/**
	 * @param serviceWarranty1 the serviceWarranty1 to set
	 */
	public void setServiceWarranty1(String serviceWarranty1) {
		this.serviceWarranty1 = serviceWarranty1;
	}
	/**
	 * @return the serviceWarranty10
	 */
	public String getServiceWarranty10() {
		return serviceWarranty10;
	}
	/**
	 * @param serviceWarranty10 the serviceWarranty10 to set
	 */
	public void setServiceWarranty10(String serviceWarranty10) {
		this.serviceWarranty10 = serviceWarranty10;
	}
	/**
	 * @return the serviceWarranty2
	 */
	public String getServiceWarranty2() {
		return serviceWarranty2;
	}
	/**
	 * @param serviceWarranty2 the serviceWarranty2 to set
	 */
	public void setServiceWarranty2(String serviceWarranty2) {
		this.serviceWarranty2 = serviceWarranty2;
	}
	/**
	 * @return the serviceWarranty3
	 */
	public String getServiceWarranty3() {
		return serviceWarranty3;
	}
	/**
	 * @param serviceWarranty3 the serviceWarranty3 to set
	 */
	public void setServiceWarranty3(String serviceWarranty3) {
		this.serviceWarranty3 = serviceWarranty3;
	}
	/**
	 * @return the serviceWarranty4
	 */
	public String getServiceWarranty4() {
		return serviceWarranty4;
	}
	/**
	 * @param serviceWarranty4 the serviceWarranty4 to set
	 */
	public void setServiceWarranty4(String serviceWarranty4) {
		this.serviceWarranty4 = serviceWarranty4;
	}
	/**
	 * @return the serviceWarranty5
	 */
	public String getServiceWarranty5() {
		return serviceWarranty5;
	}
	/**
	 * @param serviceWarranty5 the serviceWarranty5 to set
	 */
	public void setServiceWarranty5(String serviceWarranty5) {
		this.serviceWarranty5 = serviceWarranty5;
	}
	/**
	 * @return the serviceWarranty6
	 */
	public String getServiceWarranty6() {
		return serviceWarranty6;
	}
	/**
	 * @param serviceWarranty6 the serviceWarranty6 to set
	 */
	public void setServiceWarranty6(String serviceWarranty6) {
		this.serviceWarranty6 = serviceWarranty6;
	}
	/**
	 * @return the serviceWarranty7
	 */
	public String getServiceWarranty7() {
		return serviceWarranty7;
	}
	/**
	 * @param serviceWarranty7 the serviceWarranty7 to set
	 */
	public void setServiceWarranty7(String serviceWarranty7) {
		this.serviceWarranty7 = serviceWarranty7;
	}
	/**
	 * @return the serviceWarranty8
	 */
	public String getServiceWarranty8() {
		return serviceWarranty8;
	}
	/**
	 * @param serviceWarranty8 the serviceWarranty8 to set
	 */
	public void setServiceWarranty8(String serviceWarranty8) {
		this.serviceWarranty8 = serviceWarranty8;
	}
	/**
	 * @return the serviceWarranty9
	 */
	public String getServiceWarranty9() {
		return serviceWarranty9;
	}
	/**
	 * @param serviceWarranty9 the serviceWarranty9 to set
	 */
	public void setServiceWarranty9(String serviceWarranty9) {
		this.serviceWarranty9 = serviceWarranty9;
	}
	/**
	 * @return the shopName
	 */
	public String getShopName() {
		return shopName;
	}
	/**
	 * @param shopName the shopName to set
	 */
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	/**
	 * @return the totalAmount1
	 */
	public String getTotalAmount1() {
		return totalAmount1;
	}
	/**
	 * @param totalAmount1 the totalAmount1 to set
	 */
	public void setTotalAmount1(String totalAmount1) {
		this.totalAmount1 = totalAmount1;
	}
	/**
	 * @return the totalAmount10
	 */
	public String getTotalAmount10() {
		return totalAmount10;
	}
	/**
	 * @param totalAmount10 the totalAmount10 to set
	 */
	public void setTotalAmount10(String totalAmount10) {
		this.totalAmount10 = totalAmount10;
	}
	/**
	 * @return the totalAmount2
	 */
	public String getTotalAmount2() {
		return totalAmount2;
	}
	/**
	 * @param totalAmount2 the totalAmount2 to set
	 */
	public void setTotalAmount2(String totalAmount2) {
		this.totalAmount2 = totalAmount2;
	}
	/**
	 * @return the totalAmount3
	 */
	public String getTotalAmount3() {
		return totalAmount3;
	}
	/**
	 * @param totalAmount3 the totalAmount3 to set
	 */
	public void setTotalAmount3(String totalAmount3) {
		this.totalAmount3 = totalAmount3;
	}
	/**
	 * @return the totalAmount4
	 */
	public String getTotalAmount4() {
		return totalAmount4;
	}
	/**
	 * @param totalAmount4 the totalAmount4 to set
	 */
	public void setTotalAmount4(String totalAmount4) {
		this.totalAmount4 = totalAmount4;
	}
	/**
	 * @return the totalAmount5
	 */
	public String getTotalAmount5() {
		return totalAmount5;
	}
	/**
	 * @param totalAmount5 the totalAmount5 to set
	 */
	public void setTotalAmount5(String totalAmount5) {
		this.totalAmount5 = totalAmount5;
	}
	/**
	 * @return the totalAmount6
	 */
	public String getTotalAmount6() {
		return totalAmount6;
	}
	/**
	 * @param totalAmount6 the totalAmount6 to set
	 */
	public void setTotalAmount6(String totalAmount6) {
		this.totalAmount6 = totalAmount6;
	}
	/**
	 * @return the totalAmount7
	 */
	public String getTotalAmount7() {
		return totalAmount7;
	}
	/**
	 * @param totalAmount7 the totalAmount7 to set
	 */
	public void setTotalAmount7(String totalAmount7) {
		this.totalAmount7 = totalAmount7;
	}
	/**
	 * @return the totalAmount8
	 */
	public String getTotalAmount8() {
		return totalAmount8;
	}
	/**
	 * @param totalAmount8 the totalAmount8 to set
	 */
	public void setTotalAmount8(String totalAmount8) {
		this.totalAmount8 = totalAmount8;
	}
	/**
	 * @return the totalAmount9
	 */
	public String getTotalAmount9() {
		return totalAmount9;
	}
	/**
	 * @param totalAmount9 the totalAmount9 to set
	 */
	public void setTotalAmount9(String totalAmount9) {
		this.totalAmount9 = totalAmount9;
	}
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	


	
}
