package com.formbean;

import org.apache.struts.validator.ValidatorForm;
import java.util.ArrayList;

public class LoginForm extends ValidatorForm{
	private String userId;
	private String passWord;
	private ArrayList userList;
	
	public ArrayList getUserList() {
		return userList;
	}
	public void setUserList(ArrayList userList) {
		this.userList = userList;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

}
