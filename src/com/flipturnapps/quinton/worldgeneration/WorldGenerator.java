package com.flipturnapps.quinton.worldgeneration;
import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.flipturnapps.quinton.xmldata.Location;
import com.flipturnapps.quinton.xmldata.Room;
import com.flipturnapps.quinton.xmldata.World;


public class WorldGenerator 
{
	public World generateAndSaveTestWorld(File f) 
	{
		World world = this.generateTestWorld();
		world.deflate();
		this.saveWorld(world, f);
		return world;
	}
	public World readWorld(File f)
	{
		try
		{
			JAXBContext jaxbContext = JAXBContext.newInstance(World.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();


			World w = (World) jaxbUnmarshaller.unmarshal(f);
			w.inflate();
			return w;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return null;
	}
	public void saveWorld(World w, File f)
	{
		w.deflate();
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
		w.inflate();
	}
	private World generateTestWorld()
	{
		TestRoomGenerator gen = new TestRoomGenerator();
		World world = new World();
		Room startRoom = gen.generateStartRoom(world);
		Room[] rooms = new Room[4];
		rooms[0] = startRoom;
		rooms[1] = gen.generateForestRoom(world, new Location(1,0,0));
		rooms[2] = gen.generateMirrorRoom(world);
		rooms[3] = gen.generateForestRoom(world, new Location(0,0,1));
		world.setRoom(rooms);
		world.inflate();
		return world;
	}

}

