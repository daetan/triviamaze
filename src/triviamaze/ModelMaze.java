/**
 * 
 */
package triviamaze;

/**
 * @author daeta
 *
 */
public class ModelMaze {
	
	/**
	 * 
	 */
	private int myHeight;
	
	/**
	 * 
	 */
	private int myWidth;
	
	/**
	 * 
	 */
	private boolean isSolvable;
	
	/**
	 * 
	 */
	private ModelRoom[][] myRooms;
	
	/**
	 * 
	 */
	private ModelUser myUser;
		
	/**
	 * 
	 */
	public ModelMaze() {
		myHeight = 4;
		myWidth = 4;
		isSolvable = true;
		myRooms = new ModelRoom[myHeight][myWidth];
		myUser = new ModelUser();
	}
	
	/**
	 * 
	 * @param theX
	 * @param theY
	 */
	ModelMaze(final int theX, final int theY) {
		myHeight = theY + 2;
		myWidth = theX + 2;
		isSolvable = true;
		myRooms = new ModelRoom[myHeight][myWidth];
		generateRooms(myHeight, myWidth);
	}
	
	/**
	 * 
	 * @param theX
	 * @param theY
	 * @return
	 */
	ModelRoom getRoom(final int theX, final int theY) {
		ModelRoom returnRoom = null;
		if (theX < myWidth && theY < myHeight) {
			returnRoom = myRooms[theX][theY];
		}
		return returnRoom;
	}
	
	/**
	 * 
	 * @return
	 */
	ModelRoom getPlayerLocation() {
		return myUser.getMyRoom();
	}
	
	/**
	 * 
	 * @param theX
	 * @param theY
	 * @return
	 */
	boolean isValidRoom(final int theX, final int theY) {
		return theX > 0 && theX < myWidth - 1 && theY > 0 && theY < myHeight - 1;
	}
	
	/**
	 * 
	 * @param theRows
	 * @param theCols
	 */
	public void generateRooms(int theRows, int theCols) {
		for (int i = 0; i < myWidth; i++) {
			for (int j = 0; j < myHeight; j++) {
				myRooms[i][j] = new ModelRoom(i, j);
			}
		}
	}

	/**
	 * 
	 * @return
	 */
	int getMyHeight() {
		return myHeight - 2;
	}

	/**
	 * 
	 * @return
	 */
	int getMyWidth() {
		return myWidth - 2;
	}
	
	/**
	 * 
	 * @return
	 */
	boolean getIsSolvable() {
		return isSolvable;
	}
	
	/**
	 * 
	 * @return
	 */
	Room[][] getMyRooms() {
		return myRooms;
	}
	
	/**
	 * 
	 * @param theCurrentRoom
	 * @return
	 */
	public Room getTopNeighbour(final Room theCurrentRoom) {
		return myRooms[theCurrentRoom.getMyX() - 1][theCurrentRoom.getMyY()];
	}

	/**
	 * 
	 * @param theCurrentRoom
	 * @return
	 */
	public Room getRightNeighbour(final Room theCurrentRoom) {
		return myRooms[theCurrentRoom.getMyX()][theCurrentRoom.getMyY() + 1];
	}

	/**
	 * 
	 * @param theCurrentRoom
	 * @return
	 */
	public Room getBottomNeighbour(final Room theCurrentRoom) {
		return myRooms[theCurrentRoom.getMyX() + 1][theCurrentRoom.getMyY()];
	}

	/**
	 * 
	 * @param theCurrentRoom
	 * @return
	 */
	public Room getLeftNeighbour(final Room theCurrentRoom) {
		return myRooms[theCurrentRoom.getMyX()][theCurrentRoom.getMyY() - 1];
	}

	/**
	 * @return the myUser
	 */
	public User getMyUser() {
		return myUser;
	}

	/**
	 * @param myUser the myUser to set
	 */
	public void setMyUser(User theUser) {
		myUser = theUser;
	}
	
	
	/**
	 * @param args
	 */
	static void main(String[] args) {
	}
}
