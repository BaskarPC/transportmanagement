package com.formbean;


import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.validator.ValidatorForm;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.action.WasteAction;
public class ServiceReqForm extends GeneralForm{
	private static final Logger logger=(Logger)Logger.getLogger(ServiceReqForm.class);

	private String currentKm=null;
	private String workDetails1=null;
	private String workDetails2=null;
	private String workDetails3=null;
	private String workDetails4=null;
	private String workDetails5=null;
	
	private String serviceReason1=null;
	private String serviceReason2=null;
	private String serviceReason3=null;
	private String serviceReason4=null;
	private String serviceReason5=null;
	
	private String serviceName1=null;
	private String serviceName2=null;
	private String serviceName3=null;
	private String serviceName4=null;
	private String serviceName5=null;
	
	private String previousServicedDate1=null;
	private String previousServicedDate2=null;
	private String previousServicedDate3=null;
	private String previousServicedDate4=null;
	private String previousServicedDate5=null;
	
	private String previousServicedKm1=null;
	private String previousServicedKm2=null;
	private String previousServicedKm3=null;
	private String previousServicedKm4=null;
	private String previousServicedKm5=null;
	
	private String differenceKm1=null;
	private String differenceKm2=null;
	private String differenceKm3=null;
	private String differenceKm4=null;
	private String differenceKm5=null;
	
	private String previouslyServicedAmount1=null;
	private String previouslyServicedAmount2=null;
	private String previouslyServicedAmount3=null;
	private String previouslyServicedAmount4=null;
	private String previouslyServicedAmount5=null;
	
	private String previouslyServicedWarranty1=null;
	private String previouslyServicedWarranty2=null;
	private String previouslyServicedWarranty3=null;
	private String previouslyServicedWarranty4=null;
	private String previouslyServicedWarranty5=null;
	
	private String previouslyServicedWorkshopName1=null;
	private String previouslyServicedWorkshopName2=null;
	private String previouslyServicedWorkshopName3=null;
	private String previouslyServicedWorkshopName4=null;
	private String previouslyServicedWorkshopName5=null;
	
	private String recommendation1=null;
	private String recommendation2=null;
	private String recommendation3=null;
	private String recommendation4=null;
	private String recommendation5=null;
	
	private String mechanicName1=null;
	private String mechanicName2=null;
	private String mechanicName3=null;
	private String mechanicName4=null;
	private String mechanicName5=null;
	/**
	 * @return the currentKm
	 */
	public String getCurrentKm() {
		return currentKm;
	}
	/**
	 * @param currentKm the currentKm to set
	 */
	public void setCurrentKm(String currentKm) {
		this.currentKm = currentKm;
	}
	/**
	 * @return the differnceKm1
	 */
	
	/**
	 * @return the mechanicName1
	 */
	public String getMechanicName1() {
		return mechanicName1;
	}
	/**
	 * @param mechanicName1 the mechanicName1 to set
	 */
	public void setMechanicName1(String mechanicName1) {
		this.mechanicName1 = mechanicName1;
	}
	/**
	 * @return the mechanicName2
	 */
	public String getMechanicName2() {
		return mechanicName2;
	}
	/**
	 * @param mechanicName2 the mechanicName2 to set
	 */
	public void setMechanicName2(String mechanicName2) {
		this.mechanicName2 = mechanicName2;
	}
	/**
	 * @return the mechanicName3
	 */
	public String getMechanicName3() {
		return mechanicName3;
	}
	/**
	 * @param mechanicName3 the mechanicName3 to set
	 */
	public void setMechanicName3(String mechanicName3) {
		this.mechanicName3 = mechanicName3;
	}
	/**
	 * @return the mechanicName4
	 */
	public String getMechanicName4() {
		return mechanicName4;
	}
	/**
	 * @param mechanicName4 the mechanicName4 to set
	 */
	public void setMechanicName4(String mechanicName4) {
		this.mechanicName4 = mechanicName4;
	}
	/**
	 * @return the mechanicName5
	 */
	public String getMechanicName5() {
		return mechanicName5;
	}
	/**
	 * @param mechanicName5 the mechanicName5 to set
	 */
	public void setMechanicName5(String mechanicName5) {
		this.mechanicName5 = mechanicName5;
	}
	/**
	 * @return the previouslyServicedAmount1
	 */
	public String getPreviouslyServicedAmount1() {
		return previouslyServicedAmount1;
	}
	/**
	 * @param previouslyServicedAmount1 the previouslyServicedAmount1 to set
	 */
	public void setPreviouslyServicedAmount1(String previouslyServicedAmount1) {
		this.previouslyServicedAmount1 = previouslyServicedAmount1;
	}
	/**
	 * @return the previouslyServicedAmount2
	 */
	public String getPreviouslyServicedAmount2() {
		return previouslyServicedAmount2;
	}
	/**
	 * @param previouslyServicedAmount2 the previouslyServicedAmount2 to set
	 */
	public void setPreviouslyServicedAmount2(String previouslyServicedAmount2) {
		this.previouslyServicedAmount2 = previouslyServicedAmount2;
	}
	/**
	 * @return the previouslyServicedAmount3
	 */
	public String getPreviouslyServicedAmount3() {
		return previouslyServicedAmount3;
	}
	/**
	 * @param previouslyServicedAmount3 the previouslyServicedAmount3 to set
	 */
	public void setPreviouslyServicedAmount3(String previouslyServicedAmount3) {
		this.previouslyServicedAmount3 = previouslyServicedAmount3;
	}
	/**
	 * @return the previouslyServicedAmount4
	 */
	public String getPreviouslyServicedAmount4() {
		return previouslyServicedAmount4;
	}
	/**
	 * @param previouslyServicedAmount4 the previouslyServicedAmount4 to set
	 */
	public void setPreviouslyServicedAmount4(String previouslyServicedAmount4) {
		this.previouslyServicedAmount4 = previouslyServicedAmount4;
	}
	/**
	 * @return the previouslyServicedAmount5
	 */
	public String getPreviouslyServicedAmount5() {
		return previouslyServicedAmount5;
	}
	/**
	 * @param previouslyServicedAmount5 the previouslyServicedAmount5 to set
	 */
	public void setPreviouslyServicedAmount5(String previouslyServicedAmount5) {
		this.previouslyServicedAmount5 = previouslyServicedAmount5;
	}
	/**
	 * @return the previouslyServicedWarranty1
	 */
	public String getPreviouslyServicedWarranty1() {
		return previouslyServicedWarranty1;
	}
	/**
	 * @param previouslyServicedWarranty1 the previouslyServicedWarranty1 to set
	 */
	public void setPreviouslyServicedWarranty1(String previouslyServicedWarranty1) {
		this.previouslyServicedWarranty1 = previouslyServicedWarranty1;
	}
	/**
	 * @return the previouslyServicedWarranty2
	 */
	public String getPreviouslyServicedWarranty2() {
		return previouslyServicedWarranty2;
	}
	/**
	 * @param previouslyServicedWarranty2 the previouslyServicedWarranty2 to set
	 */
	public void setPreviouslyServicedWarranty2(String previouslyServicedWarranty2) {
		this.previouslyServicedWarranty2 = previouslyServicedWarranty2;
	}
	/**
	 * @return the previouslyServicedWarranty3
	 */
	public String getPreviouslyServicedWarranty3() {
		return previouslyServicedWarranty3;
	}
	/**
	 * @param previouslyServicedWarranty3 the previouslyServicedWarranty3 to set
	 */
	public void setPreviouslyServicedWarranty3(String previouslyServicedWarranty3) {
		this.previouslyServicedWarranty3 = previouslyServicedWarranty3;
	}
	/**
	 * @return the previouslyServicedWarranty4
	 */
	public String getPreviouslyServicedWarranty4() {
		return previouslyServicedWarranty4;
	}
	/**
	 * @param previouslyServicedWarranty4 the previouslyServicedWarranty4 to set
	 */
	public void setPreviouslyServicedWarranty4(String previouslyServicedWarranty4) {
		this.previouslyServicedWarranty4 = previouslyServicedWarranty4;
	}
	/**
	 * @return the previouslyServicedWarranty5
	 */
	public String getPreviouslyServicedWarranty5() {
		return previouslyServicedWarranty5;
	}
	/**
	 * @param previouslyServicedWarranty5 the previouslyServicedWarranty5 to set
	 */
	public void setPreviouslyServicedWarranty5(String previouslyServicedWarranty5) {
		this.previouslyServicedWarranty5 = previouslyServicedWarranty5;
	}
	/**
	 * @return the previouslyServicedWorkshopName1
	 */
	public String getPreviouslyServicedWorkshopName1() {
		return previouslyServicedWorkshopName1;
	}
	/**
	 * @param previouslyServicedWorkshopName1 the previouslyServicedWorkshopName1 to set
	 */
	public void setPreviouslyServicedWorkshopName1(
			String previouslyServicedWorkshopName1) {
		this.previouslyServicedWorkshopName1 = previouslyServicedWorkshopName1;
	}
	/**
	 * @return the previouslyServicedWorkshopName2
	 */
	public String getPreviouslyServicedWorkshopName2() {
		return previouslyServicedWorkshopName2;
	}
	/**
	 * @param previouslyServicedWorkshopName2 the previouslyServicedWorkshopName2 to set
	 */
	public void setPreviouslyServicedWorkshopName2(
			String previouslyServicedWorkshopName2) {
		this.previouslyServicedWorkshopName2 = previouslyServicedWorkshopName2;
	}
	/**
	 * @return the previouslyServicedWorkshopName3
	 */
	public String getPreviouslyServicedWorkshopName3() {
		return previouslyServicedWorkshopName3;
	}
	/**
	 * @param previouslyServicedWorkshopName3 the previouslyServicedWorkshopName3 to set
	 */
	public void setPreviouslyServicedWorkshopName3(
			String previouslyServicedWorkshopName3) {
		this.previouslyServicedWorkshopName3 = previouslyServicedWorkshopName3;
	}
	/**
	 * @return the previouslyServicedWorkshopName4
	 */
	public String getPreviouslyServicedWorkshopName4() {
		return previouslyServicedWorkshopName4;
	}
	/**
	 * @param previouslyServicedWorkshopName4 the previouslyServicedWorkshopName4 to set
	 */
	public void setPreviouslyServicedWorkshopName4(
			String previouslyServicedWorkshopName4) {
		this.previouslyServicedWorkshopName4 = previouslyServicedWorkshopName4;
	}
	/**
	 * @return the previouslyServicedWorkshopName5
	 */
	public String getPreviouslyServicedWorkshopName5() {
		return previouslyServicedWorkshopName5;
	}
	/**
	 * @param previouslyServicedWorkshopName5 the previouslyServicedWorkshopName5 to set
	 */
	public void setPreviouslyServicedWorkshopName5(
			String previouslyServicedWorkshopName5) {
		this.previouslyServicedWorkshopName5 = previouslyServicedWorkshopName5;
	}
	/**
	 * @return the previousServicedDate1
	 */
	public String getPreviousServicedDate1() {
		return previousServicedDate1;
	}
	/**
	 * @param previousServicedDate1 the previousServicedDate1 to set
	 */
	public void setPreviousServicedDate1(String previousServicedDate1) {
		this.previousServicedDate1 = previousServicedDate1;
	}
	/**
	 * @return the previousServicedDate2
	 */
	public String getPreviousServicedDate2() {
		return previousServicedDate2;
	}
	/**
	 * @param previousServicedDate2 the previousServicedDate2 to set
	 */
	public void setPreviousServicedDate2(String previousServicedDate2) {
		this.previousServicedDate2 = previousServicedDate2;
	}
	/**
	 * @return the previousServicedDate3
	 */
	public String getPreviousServicedDate3() {
		return previousServicedDate3;
	}
	/**
	 * @param previousServicedDate3 the previousServicedDate3 to set
	 */
	public void setPreviousServicedDate3(String previousServicedDate3) {
		this.previousServicedDate3 = previousServicedDate3;
	}
	/**
	 * @return the previousServicedDate4
	 */
	public String getPreviousServicedDate4() {
		return previousServicedDate4;
	}
	/**
	 * @param previousServicedDate4 the previousServicedDate4 to set
	 */
	public void setPreviousServicedDate4(String previousServicedDate4) {
		this.previousServicedDate4 = previousServicedDate4;
	}
	/**
	 * @return the previousServicedDate5
	 */
	public String getPreviousServicedDate5() {
		return previousServicedDate5;
	}
	/**
	 * @param previousServicedDate5 the previousServicedDate5 to set
	 */
	public void setPreviousServicedDate5(String previousServicedDate5) {
		this.previousServicedDate5 = previousServicedDate5;
	}
	/**
	 * @return the previousServicedKm1
	 */
	public String getPreviousServicedKm1() {
		return previousServicedKm1;
	}
	/**
	 * @param previousServicedKm1 the previousServicedKm1 to set
	 */
	public void setPreviousServicedKm1(String previousServicedKm1) {
		this.previousServicedKm1 = previousServicedKm1;
	}
	/**
	 * @return the previousServicedKm2
	 */
	public String getPreviousServicedKm2() {
		return previousServicedKm2;
	}
	/**
	 * @param previousServicedKm2 the previousServicedKm2 to set
	 */
	public void setPreviousServicedKm2(String previousServicedKm2) {
		this.previousServicedKm2 = previousServicedKm2;
	}
	/**
	 * @return the previousServicedKm3
	 */
	public String getPreviousServicedKm3() {
		return previousServicedKm3;
	}
	/**
	 * @param previousServicedKm3 the previousServicedKm3 to set
	 */
	public void setPreviousServicedKm3(String previousServicedKm3) {
		this.previousServicedKm3 = previousServicedKm3;
	}
	/**
	 * @return the previousServicedKm4
	 */
	public String getPreviousServicedKm4() {
		return previousServicedKm4;
	}
	/**
	 * @param previousServicedKm4 the previousServicedKm4 to set
	 */
	public void setPreviousServicedKm4(String previousServicedKm4) {
		this.previousServicedKm4 = previousServicedKm4;
	}
	/**
	 * @return the previousServicedKm5
	 */
	public String getPreviousServicedKm5() {
		return previousServicedKm5;
	}
	/**
	 * @param previousServicedKm5 the previousServicedKm5 to set
	 */
	public void setPreviousServicedKm5(String previousServicedKm5) {
		this.previousServicedKm5 = previousServicedKm5;
	}
	/**
	 * @return the recommendation1
	 */
	public String getRecommendation1() {
		return recommendation1;
	}
	/**
	 * @param recommendation1 the recommendation1 to set
	 */
	public void setRecommendation1(String recommendation1) {
		this.recommendation1 = recommendation1;
	}
	/**
	 * @return the recommendation2
	 */
	public String getRecommendation2() {
		return recommendation2;
	}
	/**
	 * @param recommendation2 the recommendation2 to set
	 */
	public void setRecommendation2(String recommendation2) {
		this.recommendation2 = recommendation2;
	}
	/**
	 * @return the recommendation3
	 */
	public String getRecommendation3() {
		return recommendation3;
	}
	/**
	 * @param recommendation3 the recommendation3 to set
	 */
	public void setRecommendation3(String recommendation3) {
		this.recommendation3 = recommendation3;
	}
	/**
	 * @return the recommendation4
	 */
	public String getRecommendation4() {
		return recommendation4;
	}
	/**
	 * @param recommendation4 the recommendation4 to set
	 */
	public void setRecommendation4(String recommendation4) {
		this.recommendation4 = recommendation4;
	}
	/**
	 * @return the recommendation5
	 */
	public String getRecommendation5() {
		return recommendation5;
	}
	/**
	 * @param recommendation5 the recommendation5 to set
	 */
	public void setRecommendation5(String recommendation5) {
		this.recommendation5 = recommendation5;
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
	 * @return the serviceReason1
	 */
	public String getServiceReason1() {
		return serviceReason1;
	}
	/**
	 * @param serviceReason1 the serviceReason1 to set
	 */
	public void setServiceReason1(String serviceReason1) {
		this.serviceReason1 = serviceReason1;
	}
	/**
	 * @return the serviceReason2
	 */
	public String getServiceReason2() {
		return serviceReason2;
	}
	/**
	 * @param serviceReason2 the serviceReason2 to set
	 */
	public void setServiceReason2(String serviceReason2) {
		this.serviceReason2 = serviceReason2;
	}
	/**
	 * @return the serviceReason3
	 */
	public String getServiceReason3() {
		return serviceReason3;
	}
	/**
	 * @param serviceReason3 the serviceReason3 to set
	 */
	public void setServiceReason3(String serviceReason3) {
		this.serviceReason3 = serviceReason3;
	}
	/**
	 * @return the serviceReason4
	 */
	public String getServiceReason4() {
		return serviceReason4;
	}
	/**
	 * @param serviceReason4 the serviceReason4 to set
	 */
	public void setServiceReason4(String serviceReason4) {
		this.serviceReason4 = serviceReason4;
	}
	/**
	 * @return the serviceReason5
	 */
	public String getServiceReason5() {
		return serviceReason5;
	}
	/**
	 * @param serviceReason5 the serviceReason5 to set
	 */
	public void setServiceReason5(String serviceReason5) {
		this.serviceReason5 = serviceReason5;
	}
	/**
	 * @return the workDetails1
	 */
	public String getWorkDetails1() {
		return workDetails1;
	}
	/**
	 * @param workDetails1 the workDetails1 to set
	 */
	public void setWorkDetails1(String workDetails1) {
		this.workDetails1 = workDetails1;
	}
	/**
	 * @return the workDetails2
	 */
	public String getWorkDetails2() {
		return workDetails2;
	}
	/**
	 * @param workDetails2 the workDetails2 to set
	 */
	public void setWorkDetails2(String workDetails2) {
		this.workDetails2 = workDetails2;
	}
	/**
	 * @return the workDetails3
	 */
	public String getWorkDetails3() {
		return workDetails3;
	}
	/**
	 * @param workDetails3 the workDetails3 to set
	 */
	public void setWorkDetails3(String workDetails3) {
		this.workDetails3 = workDetails3;
	}
	/**
	 * @return the workDetails4
	 */
	public String getWorkDetails4() {
		return workDetails4;
	}
	/**
	 * @param workDetails4 the workDetails4 to set
	 */
	public void setWorkDetails4(String workDetails4) {
		this.workDetails4 = workDetails4;
	}
	/**
	 * @return the workDetails5
	 */
	public String getWorkDetails5() {
		return workDetails5;
	}
	/**
	 * @param workDetails5 the workDetails5 to set
	 */
	public void setWorkDetails5(String workDetails5) {
		this.workDetails5 = workDetails5;
	}
	/**
	 * @return the differenceKm1
	 */
	public String getDifferenceKm1() {
		return differenceKm1;
	}
	/**
	 * @param differenceKm1 the differenceKm1 to set
	 */
	public void setDifferenceKm1(String differenceKm1) {
		this.differenceKm1 = differenceKm1;
	}
	/**
	 * @return the differenceKm2
	 */
	public String getDifferenceKm2() {
		return differenceKm2;
	}
	/**
	 * @param differenceKm2 the differenceKm2 to set
	 */
	public void setDifferenceKm2(String differenceKm2) {
		this.differenceKm2 = differenceKm2;
	}
	/**
	 * @return the differenceKm3
	 */
	public String getDifferenceKm3() {
		return differenceKm3;
	}
	/**
	 * @param differenceKm3 the differenceKm3 to set
	 */
	public void setDifferenceKm3(String differenceKm3) {
		this.differenceKm3 = differenceKm3;
	}
	/**
	 * @return the differenceKm4
	 */
	public String getDifferenceKm4() {
		return differenceKm4;
	}
	/**
	 * @param differenceKm4 the differenceKm4 to set
	 */
	public void setDifferenceKm4(String differenceKm4) {
		this.differenceKm4 = differenceKm4;
	}
	/**
	 * @return the differenceKm5
	 */
	public String getDifferenceKm5() {
		return differenceKm5;
	}
	/**
	 * @param differenceKm5 the differenceKm5 to set
	 */
	public void setDifferenceKm5(String differenceKm5) {
		this.differenceKm5 = differenceKm5;
	}
	
	}
	
	
	
	
	
		
	
	

	