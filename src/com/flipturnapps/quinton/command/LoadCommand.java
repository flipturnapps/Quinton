package com.flipturnapps.quinton.command;

import java.io.File;

import com.flipturnapps.kevinLibrary.helper.FileHelper;
import com.flipturnapps.quinton.main.QuintonMain;
import com.flipturnapps.quinton.worldgeneration.WorldGenerator;
import com.flipturnapps.quinton.xmldata.World;

public class LoadCommand extends UserCommand 
{
	private QuintonMain qMain;
	public LoadCommand (QuintonMain q)
	{
		this.qMain =q;
	}
	@Override
	public String getName()
	{
return "load";
	}

	@Override
	public String getHelpText()
	{
		return "Usage: load <file>";
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
		World w = gen.readWorld(new File (FileHelper.getAppDataDir("flipturnapps", "qork")+filename));
		qMain.setWorld(w);
	}

}
