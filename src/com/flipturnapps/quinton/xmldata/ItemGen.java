package com.flipturnapps.quinton.xmldata;
import java.util.ArrayList;
import java.util.HashMap;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ItemGen 
{
	private String name="item";
	private String itemType="default";
	private int id=-1;
	private String itemAttributes;
	public ItemGen()
	{
		setItemAttributes("");
	}
	public ItemGen(String string) 
	{
		name = string;
	}
	public String getName() 
	{
		return name;
	}
	@XmlAttribute
	public void setName(String name) 
	{
		this.name = name;
	}
	public String getItemType() {
		return itemType;
	}
	@XmlAttribute
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public int getId() {
		return id;
	}
	@XmlAttribute
	public void setId(int id) {
		this.id = id;
	}
	public String getItemAttributes() {
		return itemAttributes;
	}
	@XmlElement
	public void setItemAttributes(String itemAttributes) {
		this.itemAttributes = itemAttributes;
	}

}
