package com.flipturnapps.quinton.xmldata;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class RoomCommandGen 
{
	private int roomCommandId;

	public int getRoomCommandId() 
	{
		return roomCommandId;
	}
	@XmlAttribute
	public void setRoomCommandId(int roomCommandId)
	{
		this.roomCommandId = roomCommandId;
	}
	
}
