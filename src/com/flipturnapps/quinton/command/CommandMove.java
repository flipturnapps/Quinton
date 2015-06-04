package com.flipturnapps.quinton.command;

import com.flipturnapps.quinton.xmldata.DirectionConstraints;
import com.flipturnapps.quinton.xmldata.Location;
import com.flipturnapps.quinton.xmldata.World;

public abstract class CommandMove extends UserCommand 
{
	
	protected abstract String getDirectionName();
	protected abstract void modifiyPlayerLocation(Location l);
	protected abstract boolean movementAllowed(DirectionConstraints dc);
	@Override
	public String getName() 
	{
		return this.getDirectionName();
	}


	@Override
	public int getMaximumParams() 
	{
		return 0;
	}

	@Override
	public int getMinimumParams()
	{
		return 0;
	}
	
	@Override
	public String getHelpText()
	{
		return "Moves your player " + this.getDirectionName();
	}

	@Override
	public String[] getAliases()
	{
		String[] aliases = new String[1];
		aliases[0] = this.getCharAlias() + "";
		return aliases;
	}

	@Override
	protected void userCommandExecute(String[] params, World world) 
	{
		if(!(this.movementAllowed(world.getPlayersRoom().getDirConstraints())))
			world.println("You cant go " + this.getDirectionName() + " from here.");
		else
			this.modifiyPlayerLocation(world.getPlayer().getLocation());
	}
	
	protected abstract char getCharAlias();

}
