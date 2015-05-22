package com.flipturnapps.quinton.xmldata;
import java.util.ArrayList;
import java.util.HashMap;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class EventGen 
{
	private String eventType;
	private ArrayList<String> eventAttributes;
	private ArrayList<FunctionGen> functions;
	public EventGen()
	{
		functions = new ArrayList<FunctionGen>();
		eventAttributes = new ArrayList<String>();
		eventType = "none";
	}
	public String getEventType() {
		return eventType;
	}
	@XmlAttribute
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	public ArrayList<String> getEventAttributes() {
		return eventAttributes;
	}
	@XmlElement
	public void setEventAttributes(ArrayList<String> eventAttributes) {
		this.eventAttributes = eventAttributes;
	}
	public ArrayList<FunctionGen> getFunctions() {
		return functions;
	}
	@XmlElement
	public void setFunctions(ArrayList<FunctionGen> functions) {
		this.functions = functions;
	}
	public void addEventAttribute(String name,String value)
	{
		eventAttributes.add(name +":"+ value);
	}
	public void addFunction(FunctionGen f)
	{
		this.functions.add(f);
	}
}
