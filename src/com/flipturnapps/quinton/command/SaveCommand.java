package com.flipturnapps.quinton.command;

import java.io.File;

import com.flipturnapps.kevinLibrary.helper.FileHelper;
import com.flipturnapps.quinton.worldgeneration.WorldGenerator;
import com.flipturnapps.quinton.xmldata.World;

public class SaveCommand extends UserCommand 
{

	@Override
	public String getName()
	{
return "save";
	}

	@Override
	public String getHelpText()
	{
		return "Usage: save <file>";
	}

	@Override
	public int getMaximumParams() 
	{
		return 1;
	}

	@Override
	public int getMinimumParams() 
	{
		return 0;
	}

	@Override
	public String[] getAliases() 
	{
		return null;
	}

	@Override
	protected void userCommandExecute(String[] params, World world)
	{
		WorldGenerator gen = new WorldGenerator();
		String filename;
		if(params == null || params.length == 0)
			filename = "world.qrk";
		else
			filename = params[0];
		new File(FileHelper.getAppDataDir("flipturnapps", "qork")).mkdirs();
		gen.saveWorld(world, new File (FileHelper.getAppDataDir("flipturnapps", "qork")+filename));
	}

}
