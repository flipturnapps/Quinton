package com.flipturnapps.quinton.xmldata;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Location 
{
	private int x;
	private int y;
	private int z;
	public Location()
	{
		x = 0;
		y = 0;
		z = 0;
	}
	
	public Location(int x1, int y1, int z1){
		x = x1;
		y = y1;
		z = z1;
	}
	
	public int getX() {
		return x;
	}
	@XmlAttribute
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	@XmlAttribute
	public void setY(int y) {
		this.y = y;
	}
	public int getZ() {
		return z;
	}
	@XmlAttribute
	public void setZ(int z) {
		this.z = z;
	}
	public void changeX(int c)
	{
		this.setX(this.getX() + c);
	}
	public void changeY(int c)
	{
		this.setY(this.getY() + c);
	}
	public void changeZ(int c)
	{
		this.setZ(this.getZ() + c);
	}
	public boolean equals(Location l)
	{
		if(this.getX() != l.getX())
			return false;
		if(this.getY() != l.getY())
			return false;
		if(this.getZ() != l.getZ())
			return false;
		return true;
	}
	public String toString()
	{
		return "Location: ("+ this.getX() + "," + this.getY() + "," + this.getZ() + ")";
	}

	public Location copy()
	{
		return new Location (x,y,z);
	}

}
