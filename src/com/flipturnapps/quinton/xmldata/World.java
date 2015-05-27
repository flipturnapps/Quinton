package com.flipturnapps.quinton.xmldata;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.flipturnapps.kevinLibrary.command.CommandOutput;

@XmlRootElement
public class World implements CommandOutput
{
	private Room[] rooms;
	private String name;
	private Player player;
	public World ()
	{
		player = new Player();
		name = "Qork World";
	}
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
	
	public void inflate()
	{
		for(int i = 0; i < rooms.length; i++)
		{
			rooms[i].inflate(this);
		}
		player.inflate(this);
	}
	public void deflate()
	{
		for(int i = 0; i < rooms.length; i++)
		{
			rooms[i].deflate(this);
		}
		player.deflate();
	}
	public Room getPlayersRoom() 
	{
		return this.getRoomByLocation(this.getPlayer().getLocation());
	}
	public Room getRoomByLocation(Location l)
	{
		for(int i = 0; i < this.getRoom().length; i++)
		{
			if(this.getRoom()[i].getLocation().equals(l))
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
	@Override
	public void println(String s) 
	{
		System.out.println(s);		
	}
	@Override
	public void print(String s) 
	{
		System.out.print(s);
	}
	@Override
	public void println()
	{
		System.out.println();		
	}
	
	
	
	
}
