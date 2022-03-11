package maze;

import java.io.Serializable;

/**
 * 
 * @author abdul
 *
 */

public class Door implements Serializable {

	private static final long serialVersionUID = 5675042526910810015L;
	private boolean locked = false;
	private boolean wall = false;

	/**
	 * 
	 * 
	 */
	public Door() {
		this.locked = false;

	}

	/**
	 * 
	 * @return
	 */

	public boolean getLocked() {
		return this.locked;
	}

	/**
	 * 
	 * @return
	 */

	public boolean getWall() {
		return this.wall;
	}

	/**
	 * 
	 * @param locked
	 */

	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	/**
	 * 
	 * @param wall
	 */
	public void setWall(boolean wall) {
		this.wall = wall;
	}

	public String printDoor() {
		String result = "";
		if (this.getWall() == true) {
			result += "WALL";
		} else if (this.getLocked() == false) {
			result += "OPEN";

		} else {
			result += "LOCKED";
		}
		return result;
	}

}
