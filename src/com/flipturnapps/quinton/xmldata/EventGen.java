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
	private String eventAttributes;
	private ArrayList<FunctionGen> functions;
	private int id;
	
	public EventGen()
	{
		functions = new ArrayList<FunctionGen>();
		eventAttributes = "";
		eventType = "none";
		id = 0;
	}
	
	public String getEventType() 
	{
		return eventType;
	}
	@XmlAttribute
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	public String getEventAttributes() {
		return eventAttributes;
	}
	@XmlElement
	public void setEventAttributes(String eventAttributes) {
		this.eventAttributes = eventAttributes;
	}
	public ArrayList<FunctionGen> getFunction() {
		return functions;
	}
	@XmlElement
	public void setFunction(ArrayList<FunctionGen> functions) {
		this.functions = functions;
	}
	public int getId() {
		return id;
	}
	@XmlAttribute
	public void setId(int id) {
		this.id = id;
	}
	public void addFuntctionGen(FunctionGen e)
	{
		this.getFunction().add(e);
	}
	
}
	