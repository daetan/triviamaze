package maze;

/**
 * 
 * @author abdul
 *
 */

public class Player {

	private String name;
	private int locRow = 0;
	private int locColumns = 0;

	/**
	 * 
	 * @param name
	 * @param locRow
	 * @param locColumns
	 * 
	 */
	public Player() {
		this.locRow = 0;
		this.locColumns = 0;
		// TODO Auto-generated constructor stub
	}

	public Player(String name, int locRow, int locColumns) {

		this.name = name;
		this.locRow = locRow;
		this.locColumns = locColumns;

	}

	/**
	 * 
	 * @param direction
	 * @param room
	 * @return
	 */
	public boolean validMove(String direction, Room room) {
		if (!(room.getDoor(direction).getLocked())) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * 
	 * @return
	 */
	public int getLocColumns() {
		return locColumns;
	}

	/**
	 * 
	 * @return
	 */

	public int getLocRow() {
		return locRow;
	}

	/**
	 * 
	 * @param r
	 * @param c
	 */
	public void setLocation(int r, int c) {
		locRow = r;
		locColumns = c;
	}

	public String getLocation() {
		String res = "";
		res += "Player Location " + "R: " + this.getLocRow() + "C: " + this.getLocColumns();
		return res;
	}

	/**
	 * 
	 * @param direction
	 */
	public void move(String direction) {
		if (direction == "N" || direction == "n") {
			this.setLocation(getLocRow() - 1, getLocColumns());
		} else if (direction == "W" || direction == "w") {
			this.setLocation(getLocRow(), getLocColumns() - 1);
		} else if (direction == "S" || direction == "s") {
			this.setLocation(getLocRow() + 1, getLocColumns());
		} else if (direction == "E" || direction == "e") {
			this.setLocation(getLocRow(), getLocColumns());
		} else {
			System.out.print("Illegeal Direction");
		}
	}
}