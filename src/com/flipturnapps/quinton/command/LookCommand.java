package com.flipturnapps.quinton.command;

import java.util.ArrayList;

import com.flipturnapps.kevinLibrary.command.Command;
import com.flipturnapps.kevinLibrary.command.SimpleCommand;
import com.flipturnapps.quinton.xmldata.World;

public class LookCommand extends UserCommand 
{	
	@Override
	public String getName() 
	{
		return "look";
	}

	@Override
	public String getHelpText() 
	{
		return "Usage: \"look\"";
	}

	@Override
	public int getMaximumParams() 
	{
		return Integer.MAX_VALUE;
	}

	@Override
	public int getMinimumParams() 
	{
		return 0;
	}
	
	@Override
	public String[] getAliases()
	{
		return new String[] {"getroom","room","area"};
	}

	@Override
	protected void userCommandExecute(String[] params, World world) 
	{
		world.println(world.getPlayersRoom().getDescription());		
	}
}
