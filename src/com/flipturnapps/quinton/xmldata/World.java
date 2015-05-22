package com.flipturnapps.quinton.xmldata;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class World 
{
	private Room[] rooms;
	private String name;
	private Player player;
	
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
	public void outputLine(String string) 
	{
		System.out.println(string);
	}
	public void inflate()
	{
		for(int i = 0; i < rooms.length; i++)
		{
			rooms[i].inflate(this);
		}
	}
	public void deflate()
	{
		for(int i = 0; i < rooms.length; i++)
		{
			rooms[i].deflate();
		}
	}
	public Room getPlayersRoom() 
	{
		for(int i = 0; i < this.getRoom().length; i++)
		{
			if(this.getRoom()[i].getLocation().equals(this.getPlayer().getLocation()))
				return this.getRoom()[i];
		}
		return null;
	}
	@XmlElement
	public void setPlayer(Player p)
	{
		this.player = p;
	}
	public Player getPlayer()
	{
		return this.player;
	}
	
	
	
	
}
