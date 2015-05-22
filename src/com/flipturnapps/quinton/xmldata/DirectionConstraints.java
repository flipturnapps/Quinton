package com.flipturnapps.quinton.xmldata;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DirectionConstraints 
{
	private boolean up;
	private boolean down;
	private boolean north;
	private boolean south;
	private boolean east;
	private boolean west;
	
	public DirectionConstraints()
	{
		north = true;
		south = true;
		east = true;
		west = true;
		up = false;
		down = false;
	}
	
	public DirectionConstraints(boolean n, boolean s, boolean e, boolean w, boolean u, boolean d){
		north = n;
		south = s;
		east = e;
		west = w;
		up = u;
		down = d;
	}
	
	public boolean canUp() {
		return up;
	}
	@XmlElement
	public void setUp(boolean up) {
		this.up = up;
	}
	public boolean canDown() {
		return down;
	}
	@XmlElement
	public void setDown(boolean down) {
		this.down = down;
	}
	
	@XmlElement
	public void setNorth(boolean north) {
		this.north = north;
	}
	public boolean canEast() {
		return east;
	}
	@XmlElement
	public void setEast(boolean east) {
		this.east = east;
	}
	public boolean canSouth() {
		return south;
	}
	@XmlElement
	public void setSouth(boolean south) {
		this.south = south;
	}
	public boolean canWest() {
		return west;
	}
	@XmlElement
	public void setWest(boolean west) {
		this.west = west;
	}
	
}
