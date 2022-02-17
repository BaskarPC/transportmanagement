package com.formbean;

import org.apache.struts.validator.ValidatorForm;
import java.util.ArrayList;

public class successForm extends ValidatorForm{
private String amount;
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}	

}
