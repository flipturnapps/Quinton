package com.flipturnapps.quinton.command;

import java.util.ArrayList;

import com.flipturnapps.quinton.item.Item;
import com.flipturnapps.quinton.xmldata.World;

public class InventoryCommand extends UserCommand {

	
	@Override
	public String getName() 
	{
		
		return "inventory";
	}

	@Override
	public String getHelpText()
	{
		return "Usage: inventory";
	}

	@Override
	public int getMaximumParams()
	{
		return 0;
	}

	@Override
	public int getMinimumParams()
	{
		return 0;
	}

	@Override
	public String[] getAliases() 
	{
		return new String[] {"items"};
	}

	@Override
	protected void userCommandExecute(String[] params, World world) 
	{
		ArrayList<Item> items = world.getPlayer().getInventory().getInflatedItems();
		world.println("Items: ");
		for(int i = 0; i < items.size() ;i++)
		{
			world.println("-"+items.get(i).getItemDisplayText());
		}
	}

}
