package com.flipturnapps.quinton.xmldata;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.flipturnapps.quinton.item.Item;

@XmlRootElement
public class Room 
{
	private int id;
	private String name ="room";
	private String description = "description";
	private String startNarration = "";
	private DirectionConstraints dirConstraints;
	private Region region;
	private Location location;
	private ItemContainer itemContainer;
	public Room()
	{
		region = new Region();
		id = -1;
		location = new Location();
		name = "RoomName";
		description = "description";
		startNarration = "startNarration";
		this.setItemContainer(new ItemContainer());
		
	}
	public int getId() {
		return id;
	}
	@XmlAttribute
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	@XmlElement
	public void setName(String name) {
		this.name = name;
	}	
	public String getDescription() {
		return description;
	}
	@XmlElement
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStartNarration() {
		return startNarration;
	}
	@XmlElement
	public void setStartNarration(String startNarration) {
		this.startNarration = startNarration;
	}
	
	
	
	public DirectionConstraints getDirConstraints() {
		return dirConstraints;
	}
	@XmlElement
	public void setDirConstraints(DirectionConstraints dirConstraints) {
		this.dirConstraints = dirConstraints;
	}
	
	
	public Location getLocation() {
		return location;
	}
	@XmlElement
	public void setLocation(Location location) {
		this.location = location;
	}
	public Region getRegion() {
		return region;
	}
	@XmlElement
	public void setRegion(Region region) {
		this.region = region;
	}
	public ItemContainer getItemContainer() {
		return itemContainer;
	}
	public void setItemContainer(ItemContainer itemContainer) {
		this.itemContainer = itemContainer;
	}
	public void inflate(World world)
	{
		this.getItemContainer().inflate(world);
		//more to inflate
	}
	public void deflate(World world)
	{
		this.getItemContainer().deflate();
		//more to deflate
	}
	
	
	
	
}
