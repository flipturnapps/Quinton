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
		World world = generateQWorld();
		try
		{
			File file = new File("world.xml");
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

	private World generateQWorld()
	{
		return null;
	}

}

