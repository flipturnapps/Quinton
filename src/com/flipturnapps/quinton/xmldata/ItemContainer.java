package com.flipturnapps.quinton.xmldata;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.flipturnapps.quinton.item.Item;
@XmlRootElement
public class ItemContainer 
{
	private ArrayList<ItemGen> deflatedItems;
	private ArrayList<Item> inflatedItems;
	
	public ItemContainer()
	{
		this.setDeflatedItems(new ArrayList<ItemGen>());
		this.setInflatedItems(new ArrayList<Item>());
	}
	public ArrayList<ItemGen> getDeflatedItems() {
		return deflatedItems;
	}
	@XmlElement
	public void setDeflatedItems(ArrayList<ItemGen> deflatedItems) {
		this.deflatedItems = deflatedItems;
	}
	public ArrayList<Item> getInflatedItems() {
		return inflatedItems;
	}
	@XmlElement
	public void setInflatedItems(ArrayList<Item> inflatedItems) {
		this.inflatedItems = inflatedItems;
	}
	
	public void deflate() 
	{
		this.getDeflatedItems().clear();
		for(int i = 0; i < this.getInflatedItems().size(); i++)
		{
			Item item = this.getInflatedItems().get(i);
			this.getDeflatedItems().add(item.deflate());
		}
		this.getInflatedItems().clear();
	}
	public void inflate(World world)
	{
		this.getInflatedItems().clear();
		for(int i = 0; i < this.getDeflatedItems().size(); i++)
		{
			ItemGen itemgen = this.getDeflatedItems().get(i);
			Item.inflateAndAddItem(world,itemgen,this.getInflatedItems());			
		}
		this.getDeflatedItems().clear();
	}
	public void addInflatedItem(Item i)
	{
		this.getInflatedItems().add(i);
	}
	public void addDeflatedItem(ItemGen i)
	{
		this.getDeflatedItems().add(i);
	}

}
