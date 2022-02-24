/**
 * 
 */
package triviamaze;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import java.io.*;

/**
 * @author daeta
 *
 */
class ModelMaze implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3365061151045669276L;

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
	private List<PropertyChangeListener> myListeners = new ArrayList<PropertyChangeListener>();
	
	/**
	 * 
	 */
	ModelMaze() {
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
	void generateRooms(int theRows, int theCols) {
		for (int i = 0; i < myWidth; i++) {
			for (int j = 0; j < myHeight; j++) {
				myRooms[i][j] = new ModelRoom(i, j);
			}
		}
	}
	
	/**
	 * 
	 * @param theObject
	 * @param theProperty
	 * @param theOldValue
	 * @param theNewValue
	 */
	@SuppressWarnings("unused")
	private void notifyListeners(final Object theObject, final String theProperty, final String theOldValue, final String theNewValue) {
		for (PropertyChangeListener aListener : myListeners) {
			aListener.propertyChange(new PropertyChangeEvent(this, theProperty, theOldValue, theNewValue));
		}
	}
	
	/**
	 * 
	 * @param theNewListener
	 */
	void addChangeListener(final PropertyChangeListener theNewListener) {
		myListeners.add(theNewListener);
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
	ModelRoom[][] getMyRooms() {
		return myRooms;
	}
	
	/**
	 * 
	 * @param theCurrentRoom
	 * @return
	 */
	ModelRoom getTopNeighbour(final ModelRoom theCurrentRoom) {
		return myRooms[theCurrentRoom.getMyX() - 1][theCurrentRoom.getMyY()];
	}

	/**
	 * 
	 * @param theCurrentRoom
	 * @return
	 */
	ModelRoom getRightNeighbour(final ModelRoom theCurrentRoom) {
		return myRooms[theCurrentRoom.getMyX()][theCurrentRoom.getMyY() + 1];
	}

	/**
	 * 
	 * @param theCurrentRoom
	 * @return
	 */
	ModelRoom getBottomNeighbour(final ModelRoom theCurrentRoom) {
		return myRooms[theCurrentRoom.getMyX() + 1][theCurrentRoom.getMyY()];
	}

	/**
	 * 
	 * @param theCurrentRoom
	 * @return
	 */
	ModelRoom getLeftNeighbour(final ModelRoom theCurrentRoom) {
		return myRooms[theCurrentRoom.getMyX()][theCurrentRoom.getMyY() - 1];
	}

	/**
	 * @return the myUser
	 */
	ModelUser getMyUser() {
		return myUser;
	}

	/**
	 * @param myUser the myUser to set
	 */
	void setMyUser(ModelUser theUser) {
		myUser = theUser;
	}
	
	
	/**
	 * @param args
	 */
	static void main(String[] args) {
	}
}
