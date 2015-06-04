package com.flipturnapps.quinton.xmldata;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ItemGen 
{
	private String name="item";
	private int itemTypeId=-1;
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
	public int getItemTypeId()
	{
		return itemTypeId;
	}
	@XmlAttribute
	public void setItemTypeId(int i) 
	{
		this.itemTypeId = i;
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
