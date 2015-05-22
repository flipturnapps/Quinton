package com.flipturnapps.quinton.worldgeneration;

import com.flipturnapps.quinton.xmldata.Room;

public class RoomGenerator
{
	
	
	private Room generateStartRoom()
	{
		Room startRoom = new Room();
		startRoom.setName("A Dark Forest");
		startRoom.setDescription("The deep darkness of the forest surrounds you.");
		startRoom.setStartNarration("You stand alone in a forest");
		startRoom.setLocation(new Location(0,0,0));
		
	 
		return startRoom;
	}
}
