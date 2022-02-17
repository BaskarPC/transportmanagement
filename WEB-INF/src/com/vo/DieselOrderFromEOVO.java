package com.vo;

import java.util.ArrayList;

public class DieselOrderFromEOVO {
	private String code=null;
	private String ctype=null;
	private String des=null;
	private String jobid=null;
		private String date=null;
		private String from=null;
		private String companyName=null;
		private String otherCompany=null;
		private String requiredLiters=null;
		private String checkNo=null;
		private String bankName=null;
		private String otherBank=null;
		private String amount=null;
		private ArrayList banklist;
		private ArrayList companylist; 
		public String getAmount() {
			return amount;
		}
		public void setAmount(String amount) {
			this.amount = amount;
		}
		public String getBankName() {
			return bankName;
		}
		public void setBankName(String bankName) {
			this.bankName = bankName;
		}
		public String getCheckNo() {
			return checkNo;
		}
		public void setCheckNo(String checkNo) {
			this.checkNo = checkNo;
		}
		public String getCompanyName() {
			return companyName;
		}
		public void setCompanyName(String companyName) {
			this.companyName = companyName;
		}
		public String getDate() {
			return date;
		}
		public void setDate(String date) {
			this.date = date;
		}
		public String getFrom() {
			return from;
		}
		public void setFrom(String from) {
			this.from = from;
		}
		public String getOtherBank() {
			return otherBank;
		}
		public void setOtherBank(String otherBank) {
			this.otherBank = otherBank;
		}
		public String getRequiredLiters() {
			return requiredLiters;
		}
		public void setRequiredLiters(String requiredLiters) {
			this.requiredLiters = requiredLiters;
		}
		public String getOtherCompany() {
			return otherCompany;
		}
		public void setOtherCompany(String otherCompany) {
			this.otherCompany = otherCompany;
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
		public ArrayList getBanklist() {
			return banklist;
		}
		public void setBanklist(ArrayList banklist) {
			this.banklist = banklist;
		}
		public ArrayList getCompanylist() {
			return companylist;
		}
		public void setCompanylist(ArrayList companylist) {
			this.companylist = companylist;
		}
		public String getCode() {
			return code;
		}
		public void setCode(String code) {
			this.code = code;
		}
		public String getJobid() {
			return jobid;
		}
		public void setJobid(String jobid) {
			this.jobid = jobid;
		}
		
}
