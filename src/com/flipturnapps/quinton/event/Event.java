package com.flipturnapps.quinton.event;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import com.flipturnapps.quinton.item.Item;
import com.flipturnapps.quinton.item.ItemBook;
import com.flipturnapps.quinton.xmldata.EventGen;
import com.flipturnapps.quinton.xmldata.ItemGen;
import com.flipturnapps.quinton.xmldata.World;

public abstract class Event 
{
	private static final String ATTRIBUTE_SEPARATOR_CHARACTER = ",";
	private static final String KEYVAL_SEPARATOR_CHARACTER = ":";
	
	private String name;
	private int id;
	private World world;
	public abstract String getSubtypeName();
	public abstract void useAsSubtype();
	public abstract HashMap<String,String> getSubtypeAttributes();
	protected abstract void processSubtypeAttribute(String name, String value);
	//TODO define constructors
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
	private void addSubtypeAttributes(String attributeList)
	{
		String[] attributes = attributeList.split(ATTRIBUTE_SEPARATOR_CHARACTER);
		for (int i = 0; i < attributes.length; i++) 
		{
			String attribute = attributes[i];
			String[] attributeParts = attribute.split(KEYVAL_SEPARATOR_CHARACTER);
			this.processSubtypeAttribute(attributeParts[0], attributeParts[1]);
		}
	}
	public EventGen deflate()
	{
		EventGen event = new EventGen();
		event.setId(this.getId());
		event.setEventType(this.getSubtypeName());
		String attributeString = "";
		HashMap<String,String> attributes = this.getSubtypeAttributes();
		Set<String> keys = attributes.keySet();
		Object[] keysArray = keys.toArray();
		for (int i = 0; i < keysArray.length; i++) 
		{
			attributeString += keysArray[i];
			attributeString += KEYVAL_SEPARATOR_CHARACTER;
			attributeString += attributes.get(keysArray[i]+"");
			if(keysArray.length -1 != i)
				attributeString += ATTRIBUTE_SEPARATOR_CHARACTER;			
		}
		event.setEventAttributes(attributeString);
		return event;
	}
	/*
	public static void inflateAndAddItem(World world, ItemGen itemgen, ArrayList<Item> inflatedItems)
	{
		Item inflatedItem = null;
		if(itemgen.getItemType().equalsIgnoreCase(ItemBook.SUBTYPE_NAME))
			inflatedItem = new ItemBook(world,itemgen);
		inflatedItems.add(inflatedItem);
		
	}
	*/
	//was previous item code now needs to be adapted for event

}
