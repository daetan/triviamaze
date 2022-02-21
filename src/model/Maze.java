/**
 * 
 */
package model;

/**
 * @author daeta
 *
 */
public class Maze {
	
	private int myHeight;
	
	private int myWidth;
	
	private boolean isSolvable;
	
	private Room[][] myRooms;
		
	public Maze() {
		myHeight = 4;
		myWidth = 4;
		isSolvable = true;
		myRooms = new Room[myHeight][myWidth];
	}
	
	Maze(final int theX, final int theY) {
		myHeight = theY + 2;
		myWidth = theX + 2;
		isSolvable = true;
		myRooms = new Room[myHeight][myWidth];
	}

	int getMyHeight() {
		return myHeight - 2;
	}

	int getMyWidth() {
		return myWidth - 2;
	}
	
	boolean getIsSolvable() {
		return isSolvable;
	}
	
	Room[][] getMyRooms() {
		return myRooms;
	}
	
	boolean isValidRoom(final int theX, final int theY) {
		return theX > 0 && theX < myWidth - 1 && theY > 0 && theY < myHeight - 1;
	}
	
	/**
	 * @param args
	 */
	static void main(String[] args) {
	}
}
