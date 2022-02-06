package triviamaze;
/**
 * 
 */


/**
 * @author daeta
 *
 */
class Room {
	private int myNumDoors;
	
	private boolean hasEDoor;
	
	private boolean hasSDoor;
	
	private boolean hasWDoor;
	
	private boolean hasNDoor;
	
	Room() {
		myNumDoors = 0;
		hasEDoor = false;
		hasSDoor = false;
		hasWDoor = false;
		hasNDoor = false;
	}
	
	//I should implement this manner for User
	Room(final Maze theMaze, final int theX, final int theY) {
		int aNumDoors = 0;
		if (theMaze.isValidRoom(theX + 1, theY)) {
			hasEDoor = true;
			aNumDoors++;
		}
		if (theMaze.isValidRoom(theX, theY + 1)) {
			hasSDoor = true;
			aNumDoors++;
		}
		if (theMaze.isValidRoom(theX - 1, theY)) {
			hasWDoor = true;
			aNumDoors++;
		}
		if (theMaze.isValidRoom(theX, theY - 1)) {
			hasNDoor = true;
			aNumDoors++;
		}
		myNumDoors = aNumDoors;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
