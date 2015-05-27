package com.flipturnapps.quinton.command;

import java.util.ArrayList;

import com.flipturnapps.kevinLibrary.command.CommandOutput;
import com.flipturnapps.kevinLibrary.command.HelpCommand;

public class QorkHelpCommand extends HelpCommand {

	public QorkHelpCommand(CommandOutput output) 
	{
		super(output);
	}

	@Override
	public String getHelpText() 
	{
		return "?";
	}

	@Override
	public ArrayList<String> getPermissionsCanHave()
	{
		return null;
	}

	@Override
	public boolean permProtected() 
	{
		return false;
	}

}
