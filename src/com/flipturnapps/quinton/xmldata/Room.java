package com.flipturnapps.quinton.xmldata;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.flipturnapps.quinton.room.RoomCommand;

@XmlRootElement
public class Room 
{
	private static final String ROOM_COMMAND_ID_SEPARATOR = ",";
	private static final String EXPLORED_BY_ID_SEPARATOR = ",";
	private int id;
	private String name ="room";
	private String description = "description";
	private String startNarration = "";
	private DirectionConstraints dirConstraints;
	private Region region;
	private Location location;
	private ItemContainer itemContainer;
	private RoomCommand[] commands;
	private String roomCommandIds;
	private String exploredByIdsString;
	private ArrayList<Integer> exploredByIdsList;
	public Room()
	{
		region = new Region();
		id = -1;
		location = new Location();
		name = "RoomName";
		description = "description";
		startNarration = "startNarration";
		this.setItemContainer(new ItemContainer());
		this.setRoomCommandIds(null);

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
	
	@XmlAttribute
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
		this.inflateCommands();
		this.inflateExploredByIds();
	}
	public void deflate(World world)
	{
		this.getItemContainer().deflate();
		this.deflateCommands();
		this.deflateExploredByIds();
	}
	private void deflateCommands()
	{
		String idString = "";
		RoomCommand[] commands = this.getRoomCommands();
		if(commands != null)
		{
			for (int i = 0; i < commands.length; i++)
			{				
				idString += (commands[i].getRoomCommandId() + "");
				if(i!=(commands.length-1))
				{
					idString += Room.ROOM_COMMAND_ID_SEPARATOR;
				}
			}
			this.setRoomCommandIds(idString);
		}
		this.setRoomCommands(null);
	}
	private void inflateCommands()
	{	
		if(this.getRoomCommandIds() != null && !(this.getRoomCommandIds().equals("")))
		{
			String idStringList = this.getRoomCommandIds();
			String[] idStrings = idStringList.split(ROOM_COMMAND_ID_SEPARATOR);
			RoomCommand[] commands = new RoomCommand[idStrings.length];
			for (int i = 0; i < idStrings.length; i++)
			{
				commands[i] = RoomCommand.createRoomCommand(Integer.parseInt(idStrings[i]));
			}
			this.setRoomCommands(commands);	
		}
	}
	private void deflateExploredByIds()
	{
		String idString = "";
		ArrayList<Integer> ids = this.getExploredByIdsList();
		if(ids != null)
		{
			for (int i = 0; i < ids.size(); i++)
			{				
				idString += (ids.get(i) + "");
				if(i!=(ids.size()-1))
				{
					idString += Room.EXPLORED_BY_ID_SEPARATOR;
				}
			}
			this.setExploredByIdsString(idString);
		}
		this.setExploredByIdsList(null);
	}
	private void inflateExploredByIds()
	{	
		if(this.getExploredByIdsString() != null && !(this.getExploredByIdsString()).equals(""))
		{
			String idStringList = this.getExploredByIdsString();
			String[] idStrings = idStringList.split(Room.EXPLORED_BY_ID_SEPARATOR);
			ArrayList<Integer> ids = new ArrayList<Integer>();
			for (int i = 0; i < idStrings.length; i++)
			{
				ids.add(Integer.parseInt(idStrings[i]));
			}
			this.setExploredByIdsList(ids);	
		}
	}

	public RoomCommand[] getRoomCommands() {
		return commands;
	}
	public void setRoomCommands(RoomCommand[] command)
	{
		this.commands = command;
	}
	public String getRoomCommandIds() {
		return roomCommandIds;
	}
	@XmlElement
	public void setRoomCommandIds(String roomCommandIds) {
		this.roomCommandIds = roomCommandIds;
	}
	public String getExploredByIdsString() {
		return exploredByIdsString;
	}
	@XmlElement
	public void setExploredByIdsString(String exploredByIdsString) {
		this.exploredByIdsString = exploredByIdsString;
	}
	public ArrayList<Integer> getExploredByIdsList() {
		return exploredByIdsList;
	}
	public void setExploredByIdsList(ArrayList<Integer> exploredByIdsList) {
		this.exploredByIdsList = exploredByIdsList;
	}
}