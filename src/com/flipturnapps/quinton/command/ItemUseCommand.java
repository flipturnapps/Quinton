package com.flipturnapps.quinton.command;

import java.util.ArrayList;

import com.flipturnapps.kevinLibrary.command.Command;
import com.flipturnapps.kevinLibrary.command.SimpleCommand;

public class ItemUseCommand extends SimpleCommand 
{

	@Override
	public String getName()
	{
		return "useitem";
	}

	@Override
	public String getHelpText() 
	{
		return "useitem [item]";
	}

	@Override
	public int getMaximumParams() 
	{
		return Integer.MAX_VALUE;
	}

	@Override
	public int getMinimumParams() 
	{
		return 2;
	}

	@Override
	public boolean willInterceptCommand(Command command, String[] params) 
	{
		return false;
	}

	@Override
	public void interceptCommand(Command command, String[] params) 
	{

	}

	@Override
	public int getInterceptPriority() 
	{
		return 0;
	}

	@Override
	public String[] getAliases() 
	{
		return null;
	}

	@Override
	public Object execute(String commandName, String[] params, Object data) 
	{
		return null;
	}

	@Override
	public ArrayList<String> getPermissionsCanHave() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean objectDataOK(Object data) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean permProtected() {
		// TODO Auto-generated method stub
		return false;
	}

}
