package com.flipturnapps.quinton.command;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getMaximumParams() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMinimumParams() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String[] getAliases() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void userCommandExecute(String[] params, World world) {
		// TODO Auto-generated method stub

	}

}
