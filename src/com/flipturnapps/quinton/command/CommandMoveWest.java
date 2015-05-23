package com.flipturnapps.quinton.command;

import com.flipturnapps.quinton.xmldata.DirectionConstraints;
import com.flipturnapps.quinton.xmldata.Location;

public class CommandMoveWest extends CommandMove 
{
	@Override
	protected String getDirectionName() 
	{
		return "west";
	}

	@Override
	protected void modifiyPlayerLocation(Location l) 
	{
		l.changeX(-1);
	}
	@Override
	protected boolean movementAllowed(DirectionConstraints dc) 
	{
		if(dc.getWest())
			return true;
		return false;
	}
	@Override
	protected char getCharAlias()
	{
		return 'w';
	}

}
