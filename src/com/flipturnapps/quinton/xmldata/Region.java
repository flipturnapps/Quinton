package com.flipturnapps.quinton.xmldata;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Region 
{
	private String name;
	private String blockObject;
	public Region()
	{
		setName("unnamed");
	}
	public Region(String name)
	{
		setName(name);
	}
	public Region(String name, String blockObject)
	{
		setName(name);
		this.setBlockObject(blockObject);
	}
	public String getName() {
		return name;
	}
	@XmlElement
	public void setName(String name) {
		this.name = name;
	}
	public String getBlockObject()
	{
		return blockObject;
	}
	@XmlElement
	public void setBlockObject(String blockObject) 
	{
		this.blockObject = blockObject;
	}
	
}
