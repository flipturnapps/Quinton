package com.flipturnapps.quinton.worldgeneration;
import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import com.flipturnapps.quinton.xmldata.Room;
import com.flipturnapps.quinton.xmldata.World;


public class WorldGenerator 
{
	public static void main(String[] args)
	{
		new WorldGenerator().go();
	}

	private void go() {
		World world = this.generateQWorld();
		world.deflate();
		try
		{
			File file = new File("world.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(World.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			jaxbMarshaller.marshal(world, file);
			jaxbMarshaller.marshal(world, System.out);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}

	}

	private World generateQWorld()
	{
		RoomGenerator gen = new RoomGenerator();
		World world = new World();
		Room startRoom = gen.generateStartRoom(world);
		Room[] rooms = new Room[1];
		rooms[0] = startRoom;
		world.setRoom(rooms);
		return world;
	}

}

