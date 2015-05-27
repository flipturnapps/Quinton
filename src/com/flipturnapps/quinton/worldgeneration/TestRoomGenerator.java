package com.flipturnapps.quinton.worldgeneration;

import com.flipturnapps.quinton.id.ItemId;
import com.flipturnapps.quinton.id.RoomId;
import com.flipturnapps.quinton.item.EnvironmentItem;
import com.flipturnapps.quinton.item.ItemBook;
import com.flipturnapps.quinton.item.ItemMirror;
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
		startRoom.setDescription("Next to you there is a large boulder.");
		startRoom.setStartNarration("You stand alone in a forest.");
		startRoom.setLocation(new Location(0,0,0));
		startRoom.setId(RoomId.ROOM_STARTFOREST);
		startRoom.setRegion(new Region("forest"));
		ItemBook startBook = new ItemBook(world,"Pamphlet",ItemId.ITEM_PAMPHLET);
		startBook.setBooktext("Welcome to Qork. The Quinton-designed version of Zork!    \n"
				            + "  The command parser of Qork is quite particular.          \n"
				            + "  Just know that verbs you send into Qork must be ONE WORD. \n"
				            + "  Capiche?");
		startRoom.getItemContainer().addInflatedItem(startBook);
		startRoom.getItemContainer().addInflatedItem(new EnvironmentItem(world,"Boulder",ItemId.ITEM_BOULDER));
		return startRoom;

	}


	public Room generateForestRoom(World world, Location loc)
	{
		Room startRoom = new Room();
		startRoom.setName("A Dark Forest");
		startRoom.setDescription("The deep darkness of the forest surrounds you.");
		startRoom.setStartNarration("You stand alone in a forest");
		startRoom.setLocation(loc);
		startRoom.setId(RoomId.ROOM_SURROUNDFOREST);
		startRoom.setRegion(new Region("forest"));
		return startRoom;

	}

	public Room generateMirrorRoom(World world)
	{
		Room mirrorRoom = new Room();
		mirrorRoom.setName("Mirror Room");
		mirrorRoom.setDescription("There are no exits in the Room. A mirror hangs on the north wall.");
		mirrorRoom.setStartNarration("You find yourself in a mirror room.");
		mirrorRoom.setLocation(new Location(0,0,-1));
		mirrorRoom.setId(RoomId.ROOM_MIRRORROOM);
		mirrorRoom.setDirConstraints(new DirectionConstraints(false,false,false,false,false,false));
		mirrorRoom.setRegion(new Region("underground"));
		ItemMirror mirror = new ItemMirror(world);
		mirrorRoom.getItemContainer().addInflatedItem(mirror);
		return mirrorRoom;

	}

}

