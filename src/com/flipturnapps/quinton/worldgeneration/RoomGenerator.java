package com.flipturnapps.quinton.worldgeneration;

import com.flipturnapps.quinton.xmldata.DirectionConstraints;
import com.flipturnapps.quinton.xmldata.ItemGen;
import com.flipturnapps.quinton.xmldata.Location;
import com.flipturnapps.quinton.xmldata.Region;
import com.flipturnapps.quinton.xmldata.Room;

public class RoomGenerator
{
	
	
	public Room generateStartRoom()
	{
		Room startRoom = new Room();
		startRoom.setName("A Dark Forest");
		startRoom.setDescription("The deep darkness of the forest surrounds you.");
		startRoom.setStartNarration("You stand alone in a forest");
		startRoom.setLocation(new Location(0,0,0));
		startRoom.setId(0);
		startRoom.setDirConstraints(new DirectionConstraints());
		startRoom.setRegion(new Region("forest"));
		ItemGen axe = new ItemGen();
		//more info
		startRoom.addItem(axe);
		return startRoom;
		
		
	}
}

