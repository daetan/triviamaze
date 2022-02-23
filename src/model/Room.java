package model;
/**
 * 
 */


/**
 * @author daeta
 *
 */
class Room {
	//TODO code smell of repetitive get/set code below.
	
	
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
	
	private int myX;
	private int myY;
	private boolean myVisited;
	private boolean myLocked;
	
	Room(final int theX, final int theY) {
		setMyX(theX);
		setMyY(theY);
		setMyVisited(false);
		setMyLocked(true);
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
	 * TODO move to View
	 * @param width
	 */
	public void drawRoom(int width) {
		for (int j = 1; j <= width; j++) {
			System.out.print('*');
		}
		System.out.println();
		for (int i = 1; i <= width - 2; i++) {
			System.out.print('*');
			for (int j = 1; j <= width - 2; j++) {
				System.out.print(" ");
			}
			System.out.println('*');
		}
		for (int j = 1; j <= width; j++) {
			System.out.print('*');
		}
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
	void setMyNumDoors(final int theNumDoors) {
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
	void setMyHasEDoor(final boolean hasEDoor) {
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
	void setMyHasSDoor(final boolean hasSDoor) {
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
	void setMyHasWDoor(final boolean hasWDoor) {
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
	void setMyHasNDoor(final boolean hasNDoor) {
		myHasNDoor = hasNDoor;
	}

	/**
	 * @param args
	 */
	static void main(final String[] args) {
		// TODO Auto-generated method stub
	}

	/**
	 * @return the myEDoor
	 */
	Door getMyEDoor() {
		return myEDoor;
	}

	/**
	 * @param myEDoor the myEDoor to set
	 */
	void setMyEDoor(final Door myEDoor) {
		this.myEDoor = myEDoor;
	}

	/**
	 * @return the mySDoor
	 */
	Door getMySDoor() {
		return mySDoor;
	}

	/**
	 * @param mySDoor the mySDoor to set
	 */
	void setMySDoor(final Door mySDoor) {
		this.mySDoor = mySDoor;
	}

	/**
	 * @return the myWDoor
	 */
	Door getMyWDoor() {
		return myWDoor;
	}

	/**
	 * @param myWDoor the myWDoor to set
	 */
	void setMyWDoor(final Door myWDoor) {
		this.myWDoor = myWDoor;
	}

	/**
	 * @return the myNDoor
	 */
	Door getMyNDoor() {
		return myNDoor;
	}

	/**
	 * @param myNDoor the myNDoor to set
	 */
	void setMyNDoor(final Door myNDoor) {
		this.myNDoor = myNDoor;
	}

	/**
	 * @return the myX
	 */
	public int getMyX() {
		return myX;
	}

	/**
	 * @param myX the myX to set
	 */
	public void setMyX(final int theX) {
		myX = theX;
	}

	/**
	 * @return the myY
	 */
	public int getMyY() {
		return myY;
	}

	/**
	 * @param myY the myY to set
	 */
	public void setMyY(final int theY) {
		myY = theY;
	}

	/**
	 * @return the myVisited
	 */
	public boolean isMyVisited() {
		return myVisited;
	}

	/**
	 * @param myVisited the myVisited to set
	 */
	public void setMyVisited(boolean myVisited) {
		this.myVisited = myVisited;
	}

	/**
	 * @return the myLocked
	 */
	public boolean isMyLocked() {
		return myLocked;
	}

	/**
	 * @param myLocked the myLocked to set
	 */
	public void setMyLocked(boolean myLocked) {
		this.myLocked = myLocked;
	}
}
