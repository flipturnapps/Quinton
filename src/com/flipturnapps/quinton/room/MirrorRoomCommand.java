package com.flipturnapps.quinton.room;

import com.flipturnapps.quinton.id.RoomId;
import com.flipturnapps.quinton.xmldata.World;

public class MirrorRoomCommand extends RoomCommand {

	@Override
	public int getRoomCommandId() {
	 return RoomId.ROOMCOMMAND_MIRRORROOM;
	}

	@Override
	public boolean performCommand(String command, World world) 
	{
		if(command.equalsIgnoreCase("touch mirror"))
		{	
			world.println("Everything around you dissappears....");
			world.getPlayer().getLocation().changeZ(+1);
			return true;
		}
		if(command.equalsIgnoreCase("look at mirror"))
		{	
			world.println("You see your own reflection. Is that a new pimple?");
			return true;
		}
		return false;
		

	}

}
