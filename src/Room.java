import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Room 
{
	private int id;
	private int col;
	private int row;
	private String name ="room";
	private String description = "description";
	private String startNarration = "";
	private ArrayList<EventGen> events;
	private ArrayList<ItemGen> items;
	private DirectionConstraints dirConstraints;
	public Room()
	{
		id = -1;
		col = -1;
		row = -1;
		name = "RoomName";
		description = "description";
		startNarration = "startNarration";
		events = new ArrayList<EventGen>();
		items = new ArrayList<ItemGen>();
	}
	public int getId() {
		return id;
	}
	@XmlAttribute
	public void setId(int id) {
		this.id = id;
	}
	public int getCol() {
		return col;
	}
	@XmlAttribute
	public void setCol(int col) {
		this.col = col;
	}
	public int getRow() {
		return row;
	}
	@XmlAttribute
	public void setRow(int row) {
		this.row = row;
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
	public void inflate()
	{
		
	}
	public ArrayList<ItemGen> getItem() {
		return items;
	}
	@XmlElement
	public void setItem(ArrayList<ItemGen> items) {
		this.items = items;
	}
	public void addItem(ItemGen g)
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
	
	
}
