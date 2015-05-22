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
	private ArrayList<EventGen> events;
	private ArrayList<ItemGen> items;
	private ArrayList<Item> inflatedItems;
	private DirectionConstraints dirConstraints;
	private Region region;
	private Location location;
	public Room()
	{
		region = new Region();
		id = -1;
		location = new Location();
		name = "RoomName";
		description = "description";
		startNarration = "startNarration";
		events = new ArrayList<EventGen>();
		items = new ArrayList<ItemGen>();
		inflatedItems = new ArrayList<Item>();
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
	public ArrayList<EventGen> getEvent() {
		return events;
	}
	@XmlElement
	public void setEvent(ArrayList<EventGen> events) {
		this.events = events;
	}
	public void addEvent(EventGen event)
	{
		this.events.add(event);
	}
	
	public ArrayList<ItemGen> getItem() {
		return items;
	}
	@XmlElement
	public void setItem(ArrayList<ItemGen> items) {
		this.items = items;
	}
	public void addItemGen(ItemGen g)
	{
		items.add(g);
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
	public ArrayList<Item> getInflatedItems() {
		return inflatedItems;
	}
	public void setInflatedItems(ArrayList<Item> inflatedItems) {
		this.inflatedItems = inflatedItems;
	}
	public void addInflatedItem(Item item)
	{
		this.getInflatedItems().add(item);
	}
	public void deflate() 
	{
		this.getItem().clear();
		for(int i = 0; i < this.getInflatedItems().size(); i++)
		{
			Item item = this.getInflatedItems().get(i);
			this.getItem().add(item.deflate());
		}
		this.getInflatedItems().clear();
		//need more for events and functions
	}
	public void inflate(World world)
	{
		this.getInflatedItems().clear();
		for(int i = 0; i < this.getItem().size(); i++)
		{
			ItemGen itemgen = this.getItem().get(i);
			Item.inflateAndAddItem(world,itemgen,this.getInflatedItems());			
		}
		//need more for events and functions
	}
	
	
}
