package maze;

/**
 * 
 * 
 */

import java.io.Serializable;

public class Maze implements Serializable {

	private static final long serialVersionUID = 5205114282657699300L;
	/**
	 * 
	 */

	private Room[][] rooms;
	private int row;
	private int column;
	private Player player;
	private int locR = 0;
	private int locC = 0;
	private QuestionDatabase question;

	/**
	 * 
	 * 
	 * @param r
	 * @param c
	 * @param player
	 */
	public Maze(int r, int c, Player p) {
		this.row = r;
		this.column = c;

		setPlayerLoc(0, 0);
		generateMaze(r, c);

	}

	public int getRow() {
		return row;
	}

	public int getColumn() {
		return column;
	}

	/**
	 * 
	 * 
	 * @return
	 */
	public String getPlayerLoc() {

		return "Player Location: R: " + this.locR + " " + "C: " + this.locC;
	}

	/**
	 * 
	 * 
	 */

	public void playerMovement(String direction) {
		int r = this.locR;
		int c = this.locC;
		if (isDoorlocked(direction) == false) {
			// playermovement in that direction method
			playerMoveDirection(direction);
		}

	}

	public boolean isDoorlocked(String direction) {
		int r = this.locR;
		int c = this.locC;
		Door d = this.rooms[r][c].getDoor(direction);
		if (d.getLocked() == true) {
			return true;
		} else {
			return false;
		}
	}

	public void playerMoveDirection(String direction) {
		int r = this.locR;
		int c = this.locC;

		if (direction == "N" || direction == "n") {
			setPlayerLoc(r - 1, c);

		} else if (direction == "W" || direction == "w") {
			setPlayerLoc(r, c - 1);
		} else if (direction == "S" || direction == "s") {
			setPlayerLoc(r + 1, c);
		} else if (direction == "E" || direction == "e") {
			setPlayerLoc(r, c + 1);
		} else {
			System.out.println("Enter the right direction letters");
		}
	}

	public void setPlayerLoc(int i, int j) {
		this.locR = i;
		this.locC = j;
		this.player = new Player();
		player.setLocation(i, j);
	}

	public void generateMaze(int rows, int columns) {
		this.rooms = new Room[rows][columns];

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				if (i == 0 && j == 0) {
					this.rooms[i][j] = new Room(false, true);
					this.rooms[i][j].setDoor("N", true);
					this.rooms[i][j].setWall("N", true);
					this.rooms[i][j].setDoor("W", true);
					this.rooms[i][j].setWall("W", true);
				} else if (i == rows - 1 && j == columns - 1) {
					this.rooms[i][j] = new Room(true, false);
					this.rooms[i][j].setDoor("S", true);
					this.rooms[i][j].setWall("S", true);
					this.rooms[i][j].setDoor("E", true);
					this.rooms[i][j].setWall("E", true);
				} else {
					this.rooms[i][j] = new Room();
					if (i == 0) {

						this.rooms[i][j].setDoor("N", true);
						this.rooms[i][j].setWall("N", true);
					}
					if (i == rows - 1) {
						this.rooms[i][j].setDoor("S", true);
						this.rooms[i][j].setWall("S", true);
					}
					if (j == 0) {
						this.rooms[i][j].setDoor("W", true);
						this.rooms[i][j].setWall("W", true);
					}
					if (j == columns - 1) {
						rooms[i][j].setDoor("E", true);
						rooms[i][j].setWall("E", true);
					}
				}
			}
		}
	}

	/**
	 * 
	 * Room 0, 0 = 0 int k = 0, index = k+i k++; Room 0, 1 = 1 Room 0, 2 = 2 Room 0,
	 * 3 = 3 Room 1, 0 = 4 Room 1, 1 = 5 Room 1, 2 = 6 Room 1, 3 = 7 room 2, 3
	 * 
	 */
	public void generateQuestionInRoom(int r, int c) {
		int k = 0;

		this.rooms = new Room[r][c];
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				this.rooms[i][j] = new Room();
				this.rooms[i][j].setQuestion(k + i);

				k++;
			}
		}

	}

	// public String getQuestionInRoom(int r, int c) {

	// }

	public Room getRoom(int r, int c) {
		return this.rooms[r][c];

	}

	public void displayMaze() {
		int i = this.locR;
		int j = this.locC;
		System.out.println("Room " + "[Row = " + i + " " + "Col = " + j + "]");
		this.rooms[i][j].displayRoom();
		generateQuestionInRoom(i, j);

	}

}
