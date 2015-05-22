package com.flipturnapps.quinton.item;

import java.util.HashMap;

import com.flipturnapps.quinton.xmldata.World;

public abstract class Item 
{
	private String name;
	private int id;
	private World world;
	public abstract String getSubtypeName();
	public abstract void useAsSubtype();
	public abstract HashMap<String,String> getSubtypeAttributes();
	protected abstract void processSubtypeAttribute(String name, String value);
	public Item(World world)
	{
		this.setWorld(world);
	}
	public String getName() 
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public World getWorld() 
	{
		return world;
	}
	private void setWorld(World world) 
	{
		this.world = world;
	}
	public void addSubtypeAttributes(String attributeList)
	{
		String[] attributes = attributeList.split(",");
		for (int i = 0; i < attributes.length; i++) 
		{
			String attribute = attributes[i];
		}
	}
	
}
