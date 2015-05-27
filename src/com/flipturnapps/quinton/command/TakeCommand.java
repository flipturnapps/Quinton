package com.flipturnapps.quinton.command;

import com.flipturnapps.quinton.item.Item;
import com.flipturnapps.quinton.xmldata.Player;
import com.flipturnapps.quinton.xmldata.Room;
import com.flipturnapps.quinton.xmldata.World;

public class TakeCommand extends UserCommand 
{


	@Override
	public String getName() 
	{
		return "take";
	}

	@Override
	public String getHelpText() 
	{
		return "Usage: take [item name]";
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
		return null;
	}

	@Override
	protected void userCommandExecute(String[] params, World world) 
	{
		Room room = world.getPlayersRoom();
		for(int i = 0; i < room.getItemContainer().getInflatedItems().size();i++)
		{
			if(room.getItemContainer().getInflatedItems().get(i).getName().equalsIgnoreCase(params[0]))
				takeItemFromRoom(room.getItemContainer().getInflatedItems().get(i),room,world.getPlayer(),world);
			
		}
		if(params[0].equalsIgnoreCase("all"))
		{
			int iterations =room.getItemContainer().getInflatedItems().size();
			for(int i = 0; i < iterations;i++)
			{
					takeItemFromRoom(room.getItemContainer().getInflatedItems().get(0),room,world.getPlayer(),world);
				
			}
		}
	}

	private void takeItemFromRoom(Item item, Room room, Player player, World world)
	{
		room.getItemContainer().getInflatedItems().remove(item);
		player.getInventory().addInflatedItem(item);	
		world.println("You took the " + item.getName() + ".");
		
	}

}
