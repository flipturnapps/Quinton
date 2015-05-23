package com.flipturnapps.quinton.command;

import com.flipturnapps.quinton.xmldata.DirectionConstraints;
import com.flipturnapps.quinton.xmldata.Location;

public class CommandMoveSouth extends CommandMove 
{
	@Override
	protected String getDirectionName() 
	{
		return "south";
	}

	@Override
	protected void modifiyPlayerLocation(Location l) 
	{
		l.changeY(1);
	}
	@Override
	protected boolean movementAllowed(DirectionConstraints dc) 
	{
		if(dc.getSouth())
			return true;
		return false;
	}
	@Override
	protected char getCharAlias()
	{
		return 's';
	}

}
