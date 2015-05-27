package com.flipturnapps.quinton.item;

import java.util.HashMap;

import com.flipturnapps.quinton.xmldata.ItemGen;
import com.flipturnapps.quinton.xmldata.World;

public abstract class EnvironmentItem extends Item 
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
}
