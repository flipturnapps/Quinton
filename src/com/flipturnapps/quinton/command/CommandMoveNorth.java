package com.flipturnapps.quinton.command;

import com.flipturnapps.quinton.xmldata.DirectionConstraints;
import com.flipturnapps.quinton.xmldata.Location;

public class CommandMoveNorth extends CommandMove 
{
	@Override
	protected String getDirectionName() 
	{
		return "north";
	}

	@Override
	protected void modifiyPlayerLocation(Location l) 
	{
		l.changeY(-1);
	}
	@Override
	protected boolean movementAllowed(DirectionConstraints dc) 
	{
		if(dc.getNorth())
			return true;
		return false;
	}
	@Override
	protected char getCharAlias()
	{
		return 'n';
	}

}
