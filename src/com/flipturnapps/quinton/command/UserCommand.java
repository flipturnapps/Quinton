package com.flipturnapps.quinton.command;

import java.util.ArrayList;

import com.flipturnapps.kevinLibrary.command.Command;
import com.flipturnapps.kevinLibrary.command.SimpleCommand;
import com.flipturnapps.quinton.xmldata.World;

public abstract class UserCommand extends SimpleCommand 
{


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

	protected abstract void userCommandExecute(String[] params, World world);
	
	@Override
	public Object execute(String commandName, String[] params, Object data) 
	{
		this.userCommandExecute(params, (World) data);
		return null;
	}

	@Override
	public ArrayList<String> getPermissionsCanHave() 
	{
		return null;
	}

	@Override
	public boolean objectDataOK(Object data) 
	{
		return true;
	}

	@Override
	public boolean permProtected()
	{
		return false;
	}

}
