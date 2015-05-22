import java.io.File;
import java.util.function.Function;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;


public class WorldGenerator 
{
	public static void main(String[] args)
	{
		new WorldGenerator().go();
	}

	private void go() {
		World world = generateWorld();
		try
		{
			File file = new File("C:/Users/Kevin/Google Drive/Eclipse/workspace/JAXB/world.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(World.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			jaxbMarshaller.marshal(world, file);
			jaxbMarshaller.marshal(world, System.out);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}

	}
	private World generateWorld()
	{

		World world = new World();
		world.setColCount(1);
		world.setRowCount(1);
		Room[] rooms = new Room[world.getColCount()*world.getRowCount()];
		for(int i = 0; i < rooms.length; i++)
		{
			Room room = new Room();
			room.setCol(i/world.getColCount());
			room.setRow(i%world.getRowCount());
			room.setId(i);
			room.setName("Dark Room");
			room.setStartNarration("You find yourself in a dark room.");
			room.setDescription("You are surrounded by darkness.");
			FunctionGen fGen = new FunctionGen();
			fGen.setFunctionType("itemadd");
			fGen.addFunctionAttribute("item", "1,Wooden Door,visible:true,pocketable:false,interactable:true,useSynonyms:open,nameSynonyms:door");
			EventGen eGen = new EventGen();
			eGen.addEventAttribute("itemid", "0");
			eGen.setEventType("itemuse");
			eGen.addFunction(fGen);
			ItemGen flashlight = new ItemGen();
			flashlight.setName("Flashlight");
			flashlight.setItemType("key");
			flashlight.setId(0);
			room.addEvent(eGen);
			room.addItem(flashlight);
			rooms[i] = room;
		}
		world.setRoom(rooms);
		return world;
	}
}
