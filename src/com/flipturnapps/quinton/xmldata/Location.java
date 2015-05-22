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
		x = -1;
		y = -1;
		z = -1;
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

}
