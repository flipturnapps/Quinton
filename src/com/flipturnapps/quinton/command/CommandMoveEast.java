package com.flipturnapps.quinton.command;

import com.flipturnapps.quinton.xmldata.DirectionConstraints;
import com.flipturnapps.quinton.xmldata.Location;

public class CommandMoveEast extends CommandMove 
{
	@Override
	protected String getDirectionName() 
	{
		return "east";
	}

	@Override
	protected void modifiyPlayerLocation(Location l) 
	{
		l.changeX(1);
	}
	@Override
	protected boolean movementAllowed(DirectionConstraints dc) 
	{
		if(dc.getEast())
			return true;
		return false;
	}
	@Override
	protected char getCharAlias()
	{
		return 'e';
	}

}
