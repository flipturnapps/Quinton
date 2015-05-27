package com.flipturnapps.quinton.room;

import com.flipturnapps.quinton.xmldata.World;

public abstract class RoomCommand 
{
	public abstract int getRoomCommandId();
	public abstract boolean performCommand (String command, World world);
	
	
	public static RoomCommand createRoomCommand(int id)
	{
		//if(id == RoomId.ROOMCOMMAND_MIRRORROOM)
		//	return new MirrorRoomCommand();
		return null;
	}
	public String toString()
	{
		return "RoomCommand: " + this.getRoomCommandId();
	}
}
