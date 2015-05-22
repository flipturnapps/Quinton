package com.flipturnapps.quinton.xmldata;
import java.util.ArrayList;
import java.util.HashMap;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class FunctionGen
{
	private String functionType;
	private ArrayList<String> functionAttributes;
	public FunctionGen()	
	{
		functionAttributes = new ArrayList<String>();
		functionType = "none";
	}
	public ArrayList<String> getFunctionAttribute() 
	{
		return functionAttributes;
	}
	@XmlElement
	public void setFunctionAttribute(ArrayList<String> functionAttributes) {
		this.functionAttributes = functionAttributes;
	}
	public String getFunctionType() {
		return functionType;
	}
	@XmlAttribute
	public void setFunctionType(String functionType) {
		this.functionType = functionType;
	}
	public void addFunctionAttribute(String name, String value)
	{
		this.functionAttributes.add(name+":"+value);
	}
	
}
