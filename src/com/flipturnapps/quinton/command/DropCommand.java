package com.flipturnapps.quinton.command;

import com.flipturnapps.quinton.item.Item;
import com.flipturnapps.quinton.xmldata.Player;
import com.flipturnapps.quinton.xmldata.Room;
import com.flipturnapps.quinton.xmldata.World;

public class DropCommand extends UserCommand 
{


	@Override
	public String getName() 
	{
		return "drop";
	}

	@Override
	public String getHelpText() 
	{
		return "Usage: drop [item name]";
	}

	@Override
	public int getMaximumParams()
	{
		return Integer.MAX_VALUE;
	}

	@Override
	public int getMinimumParams() 
	{
		return 1;
	}

	@Override
	public String[] getAliases() 
	{
		return new String[]{"lose","throw","toss"};
	}

	@Override
	protected void userCommandExecute(String[] params, World world) 
	{
		Room room = world.getPlayersRoom();
		
		boolean hasDropped = false;
		for(int i = 0; i < world.getPlayer().getInventory().getInflatedItems().size();i++)
		{
			if(world.getPlayer().getInventory().getInflatedItems().get(i).getName().equalsIgnoreCase(params[0]))
			{
				dropItemInRoom(world.getPlayer().getInventory().getInflatedItems().get(i),room,world.getPlayer(),world);
				hasDropped = true;
			}
			
		}
		if(params[0].equalsIgnoreCase("all"))
		{
			int iterations =world.getPlayer().getInventory().getInflatedItems().size();
			for(int i = 0; i < iterations;i++)
			{
				dropItemInRoom(world.getPlayer().getInventory().getInflatedItems().get(0),room,world.getPlayer(),world);
				
			}
			hasDropped = true;
		}
		if(!hasDropped)
			world.println("You don't have that item on you...");
	}

	private void dropItemInRoom(Item item, Room room, Player player, World world)
	{
		player.getInventory().getInflatedItems().remove(item);
		room.getItemContainer().addInflatedItem(item);	
		world.println("You dropped the " + item.getName() + ".");
		
	}

}
