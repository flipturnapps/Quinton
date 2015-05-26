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
	private ItemContainer inventory;
	private int id;
	public Player()
	{
		location = new Location();
		name = "Quinton";
		healthPercentage = 1;
		id = 1;
		this.setInventory(new ItemContainer());
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
	public ItemContainer getInventory() {
		return inventory;
	}
	@XmlElement
	public void setInventory(ItemContainer inventory) {
		this.inventory = inventory;
	}
	public int getId() {
		return id;
	}
	@XmlAttribute
	public void setId(int id) {
		this.id = id;
	}

}
