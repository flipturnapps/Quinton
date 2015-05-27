package com.flipturnapps.quinton.item;

import java.util.HashMap;

import com.flipturnapps.quinton.id.ItemId;
import com.flipturnapps.quinton.xmldata.ItemGen;
import com.flipturnapps.quinton.xmldata.World;

public class EnvironmentItem extends Item 
{
	public EnvironmentItem(World world, ItemGen item) 
	{
		super(world, item);
	}

	public EnvironmentItem(World world)
	{
		super(world);
	}

	public EnvironmentItem(World world, String name, int id, String attributes) 
	{
		super(world, name, id, attributes);
	}

	public EnvironmentItem(World world, String name, int id) 
	{
		super(world, name, id);
	}

	@Override
	public boolean canInventory() 
	{
		return false;
	}

	@Override
	public int getSubtypeId() 
	{
		return ItemId.ITEMTYPE_ENVIRONMENT;
	}

	@Override
	public void interactWith(String verb)
	{
		if(verb.equalsIgnoreCase("examine"))
			this.getWorld().println("There is nothing special about the " + this.getName() + ".");
		if(verb.equalsIgnoreCase("use"))
			this.getWorld().println("You dont know how to use the " + this.getName() + ".");
	}

	@Override
	public HashMap<String, String> getSubtypeAttributes() 
	{
		return null;
	}

	@Override
	protected void processSubtypeAttribute(String name, String value)
	{
		
	}

	@Override
	public boolean isVerbAllowed(String verb)
	{
		return (verb.equalsIgnoreCase("examine") || verb.equalsIgnoreCase("use"));
	}
}
