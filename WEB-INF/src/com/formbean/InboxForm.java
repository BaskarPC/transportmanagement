package com.formbean;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

public class InboxForm extends ValidatorForm{
	private ArrayList inboxList = null;

	public ArrayList getInboxList() {
		return inboxList;
	}

	public void setInboxList(ArrayList inboxList) {
		this.inboxList = inboxList;
	}
	
	
}
