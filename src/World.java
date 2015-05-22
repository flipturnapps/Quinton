import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class World 
{
	private Room[] rooms;
	private int colCount;
	private int rowCount;
	private String name;
	
	public int getColCount() {
		return colCount;
	}
	@XmlAttribute
	public void setColCount(int colCount) {
		this.colCount = colCount;
	}
	public int getRowCount() {
		return rowCount;
	}
	@XmlAttribute
	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
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
	
	
	
	
}
