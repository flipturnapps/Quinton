package com.flipturnapps.quinton.xmldata;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Player 
{
	private double healthPercentage;
	private Location location;
	private String name;
	public Player()
	{
		location = new Location();
		name = "Quinton";
		healthPercentage = 1;
	}
	public double getHealthPercentage() {
		return healthPercentage;
	}
	@XmlElement
	public void setHealthPercentage(double healthPercentage) {
		this.healthPercentage = healthPercentage;
	}
	
	public void changeHealth(double changeAmount){
		this.healthPercentage += changeAmount;
	}

	public Location getLocation() {
		return location;
	}
	@XmlElement
	public void setLocation(Location location) {
		this.location = location;
	}
	public String getName() {
		return name;
	}
	@XmlAttribute
	public void setName(String name) {
		this.name = name;
	}

}
