package com.flipturnapps.quinton.command;

import com.flipturnapps.quinton.xmldata.DirectionConstraints;
import com.flipturnapps.quinton.xmldata.Location;

public class CommandMoveUp extends CommandMove 
{
	@Override
	protected String getDirectionName() 
	{
		return "up";
	}

	@Override
	protected void modifiyPlayerLocation(Location l) 
	{
		l.changeZ(1);
	}
	@Override
	protected boolean movementAllowed(DirectionConstraints dc) 
	{
		if(dc.getUp())
			return true;
		return false;
	}
	@Override
	protected char getCharAlias()
	{
		return 'u';
	}

}
