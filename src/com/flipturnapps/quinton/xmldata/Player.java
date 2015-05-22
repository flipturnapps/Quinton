package com.flipturnapps.quinton.xmldata;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Player 
{
	private double healthPercentage;
	private Location location;
	public double getHealthPercentage() {
		return healthPercentage;
	}
	@XmlElement
	public void setHealthPercentage(double healthPercentage) {
		this.healthPercentage = healthPercentage;
	}
	
	//xml annotation isnt nessesary for this method only "setter" methods one you read this delete the comment
	public void addHealth(double healAmount){
		this.healthPercentage += healAmount;
	}

	public Location getLocation() {
		return location;
	}
	@XmlElement
	public void setLocation(Location location) {
		this.location = location;
	}

}
