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
	
	//TODO? Boolean[][] would follow Maze Room[][] pattern, allow use of nested loop
	private boolean myHasEDoor;
	private boolean myHasSDoor;
	private boolean myHasWDoor;
	private boolean myHasNDoor;
	
	
	//TODO? Door[][] would follow  Maze Room[][] pattern, allow use of nested loop
	private Door myEDoor;
	private Door mySDoor;
	private Door myWDoor;
	private Door myNDoor;
	
	Room() {
		setMyNumDoors(0);
		setMyHasEDoor(false);
		setMyHasSDoor(false);
		setMyHasWDoor(false);
		setMyHasNDoor(false);
		setMyEDoor(new Door());
		setMySDoor(new Door());
		setMyWDoor(new Door());
		setMyNDoor(new Door());
	}
	
	//I should implement this manner for User--pass in a Maze?
	Room(final Maze theMaze, final int theX, final int theY) {
		int aNumDoors = 0;
		
		if (theMaze.isValidRoom(theX + 1, theY)) {
			setMyHasEDoor(true);
			aNumDoors++;
		}
		if (theMaze.isValidRoom(theX, theY + 1)) {
			setMyHasSDoor(true);
			aNumDoors++;
		}
		if (theMaze.isValidRoom(theX - 1, theY)) {
			setMyHasWDoor(true);
			aNumDoors++;
		}
		if (theMaze.isValidRoom(theX, theY - 1)) {
			setMyHasNDoor(true);
			aNumDoors++;
		}
		setMyNumDoors(aNumDoors);
		
		myEDoor = new Door();
		mySDoor = new Door();
		myWDoor = new Door();
		myNDoor = new Door();
	}

	/**
	 * @return the myNumDoors
	 */
	int getMyNumDoors() {
		return myNumDoors;
	}

	/**
	 * @param myNumDoors the myNumDoors to set
	 */
	void setMyNumDoors(int theNumDoors) {
		myNumDoors = theNumDoors;
	}

	/**
	 * @return the hasEDoor
	 */
	boolean getMyHasEDoor() {
		return myHasEDoor;
	}

	/**
	 * @param hasEDoor the hasEDoor to set
	 */
	void setMyHasEDoor(boolean hasEDoor) {
		myHasEDoor = hasEDoor;
	}

	/**
	 * @return the hasSDoor
	 */
	boolean getMyHasSDoor() {
		return myHasSDoor;
	}

	/**
	 * @param hasSDoor the hasSDoor to set
	 */
	void setMyHasSDoor(boolean hasSDoor) {
		myHasSDoor = hasSDoor;
	}

	/**
	 * @return the hasWDoor
	 */
	boolean getMyHasWDoor() {
		return myHasWDoor;
	}

	/**
	 * @param hasWDoor the hasWDoor to set
	 */
	void setMyHasWDoor(boolean hasWDoor) {
		myHasWDoor = hasWDoor;
	}

	/**
	 * @return the hasNDoor
	 */
	boolean getMyHasNDoor() {
		return myHasNDoor;
	}

	/**
	 * @param hasNDoor the hasNDoor to set
	 */
	void setMyHasNDoor(boolean hasNDoor) {
		myHasNDoor = hasNDoor;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

	/**
	 * @return the myEDoor
	 */
	public Door getMyEDoor() {
		return myEDoor;
	}

	/**
	 * @param myEDoor the myEDoor to set
	 */
	public void setMyEDoor(Door myEDoor) {
		this.myEDoor = myEDoor;
	}

	/**
	 * @return the mySDoor
	 */
	public Door getMySDoor() {
		return mySDoor;
	}

	/**
	 * @param mySDoor the mySDoor to set
	 */
	public void setMySDoor(Door mySDoor) {
		this.mySDoor = mySDoor;
	}

	/**
	 * @return the myWDoor
	 */
	public Door getMyWDoor() {
		return myWDoor;
	}

	/**
	 * @param myWDoor the myWDoor to set
	 */
	public void setMyWDoor(Door myWDoor) {
		this.myWDoor = myWDoor;
	}

	/**
	 * @return the myNDoor
	 */
	public Door getMyNDoor() {
		return myNDoor;
	}

	/**
	 * @param myNDoor the myNDoor to set
	 */
	public void setMyNDoor(Door myNDoor) {
		this.myNDoor = myNDoor;
	}
}
