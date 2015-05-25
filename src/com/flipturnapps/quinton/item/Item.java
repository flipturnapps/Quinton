package com.flipturnapps.quinton.item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import com.flipturnapps.quinton.command.ItemUseCommand;
import com.flipturnapps.quinton.id.ItemId;
import com.flipturnapps.quinton.xmldata.ItemGen;
import com.flipturnapps.quinton.xmldata.World;

public abstract class Item 
{
	private static final String ATTRIBUTE_SEPARATOR_CHARACTER = ",";
	private static final String KEYVAL_SEPARATOR_CHARACTER = ":";
	
	private String name;
	private int id;
	private World world;
	public abstract int getSubtypeId();
	public abstract void useAsSubtype();
	public abstract HashMap<String,String> getSubtypeAttributes();
	protected abstract void processSubtypeAttribute(String name, String value);
	public abstract String[] getNounSynonyms();
	public abstract String[] getVerbSynonyms();
	public Item(World world, ItemGen item)
	{
		this.setWorld(world);
		this.setId(item.getId());
		this.setName(item.getName());
		this.addSubtypeAttributes(item.getItemAttributes());
	}
	public Item(World world)
	{
		this.setWorld(world);		
	}
	public Item(World world, String name, int id, String attributes)
	{
		this.setWorld(world);
		this.setId(id);
		this.setName(name);
		this.addSubtypeAttributes(attributes);
	}
	public Item(World world, String name, int id)
	{
		this.setWorld(world);
		this.setId(id);
		this.setName(name);
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
	public ItemGen deflate()
	{
		ItemGen item = new ItemGen();
		item.setId(this.getId());
		item.setName(this.getName());
		item.setItemTypeId(this.getSubtypeId());
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
		item.setItemAttributes(attributeString);
		return item;
	}
	public static void inflateAndAddItem(World world, ItemGen itemgen, ArrayList<Item> inflatedItems)
	{
		Item inflatedItem = null;
		if(itemgen.getItemTypeId()==ItemId.ITEMTYPE_BOOK)
			inflatedItem = new ItemBook(world,itemgen);
		ItemUseCommand.registerItem(inflatedItem);
		inflatedItems.add(inflatedItem);
		
	}

}
