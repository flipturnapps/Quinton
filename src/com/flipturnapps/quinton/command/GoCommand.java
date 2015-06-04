package com.flipturnapps.quinton.command;

import com.flipturnapps.quinton.main.QuintonMain;
import com.flipturnapps.quinton.xmldata.World;

public class GoCommand extends UserCommand 
{
	private QuintonMain qMain;
	public GoCommand(QuintonMain m)
	{
		this.qMain = m;
	}
	@Override
	public String getName() 
	{
		return "go";
	}

	@Override
	public int getMaximumParams() 
	{
		return 1;
	}

	@Override
	public int getMinimumParams()
	{
		return 1;
	}
	
	@Override
	public String getHelpText()
	{
		return "Usage: go [directon]";
	}

	@Override
	public String[] getAliases() 
	{
		return new String[]{"move","walk","run"};
	}

	@Override
	protected void userCommandExecute(String[] params, World world) 
	{

		qMain.parseCommand(params[0], world, world.getPlayersRoom());

	}

}
