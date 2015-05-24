package com.flipturnapps.quinton.main;

import java.io.File;

import com.flipturnapps.quinton.worldgeneration.WorldGenerator;
import com.flipturnapps.quinton.xmldata.World;

public class QuintonMain 
{

	private static final boolean SHOULD_READ_WORLD_FROM_FILE = true;
	public static void main(String[] args) 
	{
		new QuintonMain().go();
	}
	private void go() 
	{
		boolean generate = !this.SHOULD_READ_WORLD_FROM_FILE;
		if(!generate && !this.getWorldsaveFile().exists())
			generate = true;
		World world;
		WorldGenerator gen = new WorldGenerator();
		if(generate)
			world = gen.generateAndSaveQWorld(this.getWorldsaveFile());
		else
			world = gen.readQWorld(this.getWorldsaveFile());
	}
	public File getWorldsaveFile()
	{
		return new File("world.xml");
	}
	

}
