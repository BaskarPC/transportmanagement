package com.formbean;

import java.util.ArrayList;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.validator.ValidatorForm;

import javax.servlet.http.HttpServletRequest;

public class EquipmentAllotmentForm extends ValidatorForm{
	
	private String combo1=null;
	private String combo2=null;
	private String combo3=null;
	private String combo4=null;
	private String table1=null;
	private String equipmentName=null;
	private String equipmentQuantity=null;
	private ArrayList tableList=null;
	private String quantity1=null;
	private String quantity2=null;
	private String quantity3=null;
	private String quantity4=null;
	private String quantity5=null;
	private String quantity6=null;
	private String quantity7=null;
	private String quantity8=null;
	private String quantity9=null;
	private String quantity10=null;
	private String frontLeftTyre=null;
	private String frontRightTyre=null;
	private String backLeftInTyre=null;
	private String backLeftOutTyre=null;
	private String backRightInTyre=null;
	private String backRightOutTyre=null;
	
	private ArrayList combo1List=null;
	private ArrayList combo2List=null;
	private ArrayList combo3List=null;
	private ArrayList combo4List=null;
	private ArrayList tyresizeList=null;
	
	public String getBackLeftInTyre() {
		return backLeftInTyre;
	}
	public void setBackLeftInTyre(String backLeftInTyre) {
		this.backLeftInTyre = backLeftInTyre;
	}
	public String getBackLeftOutTyre() {
		return backLeftOutTyre;
	}
	public void setBackLeftOutTyre(String backLeftOutTyre) {
		this.backLeftOutTyre = backLeftOutTyre;
	}
	public String getBackRightInTyre() {
		return backRightInTyre;
	}
	public void setBackRightInTyre(String backRightInTyre) {
		this.backRightInTyre = backRightInTyre;
	}
	public String getBackRightOutTyre() {
		return backRightOutTyre;
	}
	public void setBackRightOutTyre(String backRightOutTyre) {
		this.backRightOutTyre = backRightOutTyre;
	}
	
	public String getFrontLeftTyre() {
		return frontLeftTyre;
	}
	public void setFrontLeftTyre(String frontLeftTyre) {
		this.frontLeftTyre = frontLeftTyre;
	}
	public String getFrontRightTyre() {
		return frontRightTyre;
	}
	public void setFrontRightTyre(String frontRightTyre) {
		this.frontRightTyre = frontRightTyre;
	}
	
	public ArrayList getTyresizeList() {
		return tyresizeList;
	}
	public void setTyresizeList(ArrayList tyresizeList) {
		this.tyresizeList = tyresizeList;
	}
	public String getCombo1() {
		return combo1;
	}
	public void setCombo1(String combo1) {
		this.combo1 = combo1;
	}
	
	public String getCombo2() {
		return combo2;
	}
	public void setCombo2(String combo2) {
		this.combo2 = combo2;
	}
	
	public String getCombo3() {
		return combo3;
	}
	public void setCombo3(String combo3) {
		this.combo3 = combo3;
	}
	
	public String getCombo4() {
		return combo4;
	}
	public void setCombo4(String combo4) {
		this.combo4 = combo4;
	}
	
	public ArrayList getCombo1List() {
		return combo1List;
	}
	public ArrayList getCombo2List() {
		return combo2List;
	}
	public ArrayList getCombo3List() {
		return combo3List;
	}
	public ArrayList getCombo4List() {
		return combo4List;
	}
	
	public void setCombo1List(ArrayList combo1List) {
		this.combo1List = combo1List;
	}
	public void setCombo2List(ArrayList combo2List) {
		this.combo2List = combo2List;
	}
	public void setCombo3List(ArrayList combo3List) {
		this.combo3List = combo3List;
	}
	public void setCombo4List(ArrayList combo4List) {
		this.combo4List = combo4List;
	}
	public String getQuantity1() {
		return quantity1;
	}
	public void setQuantity1(String quantity1) {
		this.quantity1 = quantity1;
	}
	public String getQuantity2() {
		return quantity2;
	}
	public void setQuantity2(String quantity2) {
		this.quantity2 = quantity2;
	}
	public String getQuantity3() {
		return quantity3;
	}
	public void setQuantity3(String quantity3) {
		this.quantity3 = quantity3;
	}
	public String getQuantity4() {
		return quantity4;
	}
	public void setQuantity4(String quantity4) {
		this.quantity4 = quantity4;
	}
	public String getQuantity10() {
		return quantity10;
	}
	public void setQuantity10(String quantity10) {
		this.quantity10 = quantity10;
	}
	public String getQuantity5() {
		return quantity5;
	}
	public void setQuantity5(String quantity5) {
		this.quantity5 = quantity5;
	}
	public String getQuantity6() {
		return quantity6;
	}
	public void setQuantity6(String quantity6) {
		this.quantity6 = quantity6;
	}
	public String getQuantity7() {
		return quantity7;
	}
	public void setQuantity7(String quantity7) {
		this.quantity7 = quantity7;
	}
	public String getQuantity8() {
		return quantity8;
	}
	public void setQuantity8(String quantity8) {
		this.quantity8 = quantity8;
	}
	public String getQuantity9() {
		return quantity9;
	}
	public void setQuantity9(String quantity9) {
		this.quantity9 = quantity9;
	}
	public ArrayList getTableList() {
		return tableList;
	}
	public void setTableList(ArrayList tableList) {
		this.tableList = tableList;
	}
	public String getTable1() {
		return table1;
	}
	public void setTable1(String table1) {
		this.table1 = table1;
	}
	

	public ActionErrors validate(ActionMapping mapping, 
			HttpServletRequest request) 
			{ 
			 //Perform validator framework validations 
			ActionErrors errors = new ActionErrors(); 
			 //Only need crossfield validations here 
					
			if(StringUtils.isEmpty(quantity1))
			 {
				 errors.add(ActionErrors.GLOBAL_MESSAGE,new ActionMessage("error.quantity1.required"));
			 }
			else if(!(StringUtils.isAlphanumeric(quantity1)))
			 {
				 errors.add(ActionErrors.GLOBAL_MESSAGE,new ActionMessage("error.quantity1"));
			 }
			
			if(StringUtils.isEmpty(quantity2))
			 {
				 errors.add(ActionErrors.GLOBAL_MESSAGE,new ActionMessage("error.quantity2.required"));
			 }
			else if(!(StringUtils.isAlphanumeric(quantity2)))
			 {
				 errors.add(ActionErrors.GLOBAL_MESSAGE,new ActionMessage("error.quantity2"));
			 }
			
			if(StringUtils.isEmpty(quantity3))
			 {
				 errors.add(ActionErrors.GLOBAL_MESSAGE,new ActionMessage("error.quantity3.required"));
			 }
			else if(!(StringUtils.isAlphanumeric(quantity3)))
			 {
				 errors.add(ActionErrors.GLOBAL_MESSAGE,new ActionMessage("error.quantity3"));
			 }
			
			if(StringUtils.isEmpty(quantity4))
			 {
				 errors.add(ActionErrors.GLOBAL_MESSAGE,new ActionMessage("error.quantity4.required"));
			 }
			else if(!(StringUtils.isAlphanumeric(quantity4)))
			 {
				 errors.add(ActionErrors.GLOBAL_MESSAGE,new ActionMessage("error.quantity4"));
			 }
			
			if(StringUtils.isEmpty(quantity5))
			 {
				 errors.add(ActionErrors.GLOBAL_MESSAGE,new ActionMessage("error.quantity5.required"));
			 }
			else if(!(StringUtils.isAlphanumeric(quantity5)))
			 {
				 errors.add(ActionErrors.GLOBAL_MESSAGE,new ActionMessage("error.quantity5"));
			 }
			
			if(StringUtils.isEmpty(quantity6))
			 {
				 errors.add(ActionErrors.GLOBAL_MESSAGE,new ActionMessage("error.quantity6.required"));
			 }
			else if(!(StringUtils.isAlphanumeric(quantity6)))
			 {
				 errors.add(ActionErrors.GLOBAL_MESSAGE,new ActionMessage("error.quantity6"));
			 }
			
			if(StringUtils.isEmpty(quantity7))
			 {
				 errors.add(ActionErrors.GLOBAL_MESSAGE,new ActionMessage("error.quantity7.required"));
			 }
			else if(!(StringUtils.isAlphanumeric(quantity7)))
			 {
				 errors.add(ActionErrors.GLOBAL_MESSAGE,new ActionMessage("error.quantity7"));
			 }
			
			if(StringUtils.isEmpty(quantity8))
			 {
				 errors.add(ActionErrors.GLOBAL_MESSAGE,new ActionMessage("error.quantity8.required"));
			 }
			else if(!(StringUtils.isAlphanumeric(quantity8)))
			 {
				 errors.add(ActionErrors.GLOBAL_MESSAGE,new ActionMessage("error.quantity8"));
			 }
			
			if(StringUtils.isEmpty(quantity9))
			 {
				 errors.add(ActionErrors.GLOBAL_MESSAGE,new ActionMessage("error.quantity9.required"));
			 }
			else if(!(StringUtils.isAlphanumeric(quantity9)))
			 {
				 errors.add(ActionErrors.GLOBAL_MESSAGE,new ActionMessage("error.quantity9"));
			 }
			
			return errors;
			}
	public String getEquipmentName() {
		return equipmentName;
	}
	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}
	public String getEquipmentQuantity() {
		return equipmentQuantity;
	}
	public void setEquipmentQuantity(String equipmentQuantity) {
		this.equipmentQuantity = equipmentQuantity;
	}
	
}

