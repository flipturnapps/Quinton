package com.flipturnapps.quinton.xmldata;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class World 
{
	private Room[] rooms;
	private String name;
	
	public String getName() {
		return name;
	}
	@XmlAttribute
	public void setName(String name) {
		this.name = name;
	}
	public Room[] getRoom() {
		return rooms;
	}
	@XmlElement
	public void setRoom(Room[] rooms) {
		this.rooms = rooms;
	}
	
	
	
	
}
