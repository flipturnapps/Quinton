import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DirectionConstraints 
{
	private boolean up;
	private boolean down;
	private boolean north;
	private boolean south;
	private boolean east;
	private boolean west;
	public boolean isUp() {
		return up;
	}
	@XmlAttribute
	public void setUp(boolean up) {
		this.up = up;
	}
	public boolean isDown() {
		return down;
	}
	@XmlAttribute
	public void setDown(boolean down) {
		this.down = down;
	}
	public boolean isNorth() {
		return north;
	}
	@XmlAttribute
	public void setNorth(boolean north) {
		this.north = north;
	}
	public boolean isEast() {
		return east;
	}
	@XmlAttribute
	public void setEast(boolean east) {
		this.east = east;
	}
	public boolean isSouth() {
		return south;
	}
	@XmlAttribute
	public void setSouth(boolean south) {
		this.south = south;
	}
	public boolean isWest() {
		return west;
	}
	@XmlAttribute
	public void setWest(boolean west) {
		this.west = west;
	}
	
}
