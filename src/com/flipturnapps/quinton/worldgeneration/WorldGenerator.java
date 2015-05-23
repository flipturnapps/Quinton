package com.flipturnapps.quinton.worldgeneration;
import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.flipturnapps.quinton.xmldata.Room;
import com.flipturnapps.quinton.xmldata.World;


public class WorldGenerator 
{
	public World generateAndSaveQWorld(File f) 
	{
		World world = this.generateQWorld();
		world.deflate();
		this.saveQWorld(world, f);
		return world;
	}
	public World readQWorld(File f)
	{
		try
		{
			JAXBContext jaxbContext = JAXBContext.newInstance(World.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();


			World w = (World) jaxbUnmarshaller.unmarshal(f);
			return w;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return null;
	}
	public void saveQWorld(World w, File f)
	{
		try
		{
			JAXBContext jaxbContext = JAXBContext.newInstance(World.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			jaxbMarshaller.marshal(w, f);
			jaxbMarshaller.marshal(w, System.out);
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
		System.out.println("kek");
		return world;
	}

}

