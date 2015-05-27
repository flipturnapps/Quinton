package com.flipturnapps.quinton.item;

import java.util.HashMap;

import com.flipturnapps.quinton.id.ItemId;
import com.flipturnapps.quinton.xmldata.ItemGen;
import com.flipturnapps.quinton.xmldata.World;

public class ItemMirror extends EnvironmentItem
{
	
	private boolean broken;
	public ItemMirror(World world, ItemGen item) 
	{
		super(world, item);
		setUp();
	}

	public ItemMirror(World world) 
	{
		super(world);
		setUp();
	}

	public ItemMirror(World world, String name, int id, String attributes) 
	{
		super(world, name, id, attributes);
		setUp();
	}

	public ItemMirror(World world, String name, int id) 
	{
		super(world, name, id);
		setUp();
	}


	private void setUp()
	{
		this.setId(ItemId.ITEM_MIRROR);
		this.setName("mirror");
	}

	@Override
	public int getSubtypeId() 
	{
		return ItemId.ITEMTYPE_MIRROR;
	}

	@Override
	public void interactWith(String verb)
	{
		if(verb.equalsIgnoreCase("break") || verb.equalsIgnoreCase("kick"))
		{
			this.getWorld().println("The mirror shatters. Looks like you won't be trying your luck in the lottery anytime soon.");
			setBroken(true);
		}
		if(verb.equalsIgnoreCase("examine")||verb.equalsIgnoreCase("use"))
		{
			this.getWorld().println("Its a bit dirty.  Or is that your face?");
		}
		if(verb.equalsIgnoreCase("touch"))
		{
			this.getWorld().println("You feel yourself being teleported.");
			this.getWorld().getPlayer().getLocation().changeZ(1);
			
		}
	}
	public boolean isVerbAllowed(String verb)
	{
		if(verb.equalsIgnoreCase("break") || verb.equalsIgnoreCase("kick"))
			return true;
		if(verb.equalsIgnoreCase("examine")||verb.equalsIgnoreCase("use"))
			return true;
		if(verb.equalsIgnoreCase("touch"))
			return true;
		return false;
	}

	@Override
	public HashMap<String, String> getSubtypeAttributes() 
	{
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("broken", this.isBroken()+"");
		return map;
	}

	@Override
	protected void processSubtypeAttribute(String name, String value) 
	{
		if(name.equals("broken"))
			this.setBroken(Boolean.parseBoolean(value));

	}

	public boolean isBroken() {
		return broken;
	}

	public void setBroken(boolean broken) {
		this.broken = broken;
	}
	public String getItemDisplayText()
	{
		if(broken)
			return "A shattered " + this.getName();
		else
			return "A glimmering " + this.getName();
	}

}
