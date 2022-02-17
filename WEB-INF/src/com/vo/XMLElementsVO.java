package com.vo;





import java.lang.reflect.Method;
import java.util.ArrayList;

public class XMLElementsVO {

	private String property;
	private String attributeName;	
	private String fieldname;
	private Method methodname;	
	private Class classname;
	
	private ArrayList list;
	
	

	
	public ArrayList getList() {
		return list;
	}
	public void setList(ArrayList list) {
		this.list = list;
	}
	public String getProperty() {
		return property;
	}
	public void setProperty(String property) {
		this.property = property;
	}
	public String getFieldname() {
		return fieldname;
	}
	public void setFieldname(String fieldname) {
		this.fieldname = fieldname;
	}
	public String getAttributeName() {
		return attributeName;
	}
	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
	}
	public Method getMethodname() {
		return methodname;
	}
	public void setMethodname(Method methodname) {
		this.methodname = methodname;
	}
	public Class getClassname() {
		return classname;
	}
	public void setClassname(Class classname) {
		this.classname = classname;
	}
	
	
}
