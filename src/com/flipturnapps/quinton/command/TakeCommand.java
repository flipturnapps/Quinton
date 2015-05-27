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
		return 0;
	}

	@Override
	public String[] getAliases() 
	{
		return null;
	}

	@Override
	protected void userCommandExecute(String[] params, World world) 
	{
		if(params.length > 0)
		{
		Room room = world.getPlayersRoom();
		boolean hasTaken = false;
		for(int i = 0; i < room.getItemContainer().getInflatedItems().size();i++)
		{
			if(room.getItemContainer().getInflatedItems().get(i).getName().equalsIgnoreCase(params[0]))
			{
				takeItemFromRoom(room.getItemContainer().getInflatedItems().get(i),room,world.getPlayer(),world);
				hasTaken=true;
			}			
		}
		if(params[0].equalsIgnoreCase("all"))
		{
			Object[] items =room.getItemContainer().getInflatedItems().toArray();
			for(int i = 0; i < items.length;i++)
			{
				takeItemFromRoom((Item) items[i],room,world.getPlayer(),world);	
			}
			hasTaken = true;
		}
		if(!hasTaken)
			world.println("You couldn't find that item...");
		}
		if(world.getPlayersRoom().getItemContainer().getInflatedItems().size() == 1)
		{
			Item item = world.getPlayersRoom().getItemContainer().getInflatedItems().get(0);
			this.takeItemFromRoom(item, world.getPlayersRoom(), world.getPlayer(), world);
		}
		else
		{
			world.println("What to take?");
		}
	}

	private void takeItemFromRoom(Item item, Room room, Player player, World world)
	{
		if(item.canInventory())
		{
			room.getItemContainer().getInflatedItems().remove(item);
			player.getInventory().addInflatedItem(item);	
			world.println("You took the " + item.getName() + ".");
		}
		else
		{
			world.println("You couldn't take the " + item.getName() + ".");
		}

	}

}
