package com.flipturnapps.quinton.worldgeneration;

import com.flipturnapps.quinton.id.ItemId;
import com.flipturnapps.quinton.id.RoomId;
import com.flipturnapps.quinton.item.ItemBook;
import com.flipturnapps.quinton.xmldata.DirectionConstraints;
import com.flipturnapps.quinton.xmldata.Location;
import com.flipturnapps.quinton.xmldata.Region;
import com.flipturnapps.quinton.xmldata.Room;
import com.flipturnapps.quinton.xmldata.World;

public class TestRoomGenerator
{
	
	
	public Room generateStartRoom(World world)
	{
		Room startRoom = new Room();
		startRoom.setName("A Dark Forest");
		startRoom.setDescription("The deep darkness of the forest surrounds you.");
		startRoom.setStartNarration("You stand alone in a forest");
		startRoom.setLocation(new Location(0,0,0));
		startRoom.setId(RoomId.ROOM_STARTFOREST);
		startRoom.setDirConstraints(new DirectionConstraints());
		startRoom.setRegion(new Region("forest"));
		ItemBook startBook = new ItemBook(world,"Pamphlet",ItemId.ITEM_PAMPHLET);
		startBook.setBooktext("Welcome to Qork. The Quinton-designed version of Zork!");
		startRoom.getItemContainer().addInflatedItem(startBook);
		return startRoom;
		
	}
}

