/**
 * 
 */
package model;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

/**
 * @author daeta
 *
 */
public class User {
	
	private int myX;
	
	private int myY;

	/**
	 * TODO code smell to store a Maze in User? Poor composition? A Maze has-a User or a User has-a Maze?
	 * A User can only be in one Maze, but a Maze can have many users. I accept storing a Maze in User.
	 * I won't store Users in Maze to stay loosely coupled.
	 * See Room class for how to implement without storing a Maze object.
	 * Also, I don't want a user to have a position that can be applied to any maze except the one.
	 */
	private Maze myMaze;
	
	private List<PropertyChangeListener> myListeners = new ArrayList<PropertyChangeListener>();

	public User() {
		myX = 1;
		myY = 1;
		myMaze = new Maze();
	}
	
	User(final Maze theMaze) {
		myX = 1;
		myY = 1;
		myMaze = theMaze;
	}
	
	public boolean move(final char theDirection) {
		boolean result = false; 
		if (theDirection == 'E') {
			result = move(1, 0);
		} else if (theDirection == 'S') {
			result = move(0, -1);
		} else if (theDirection == 'W') {
			result = move(-1, 0);
		} else if (theDirection == 'N') {
			result = move(0, 1);
		} 
		return result;
	}
	
	public boolean move(final int theX, final int theY) {
		if (myMaze.isValidRoom(myX + theX, myY + theY)) {
			String theMyIntString; //TODO code smell?
			String theIntString;
			if (theX != 0) {
				theMyIntString = Integer.toString(myX);
				theIntString = Integer.toString(myX + theX);
				notifyListeners(this, "myX", theMyIntString, theIntString);
			}
			if (theY != 0) {
				theMyIntString = Integer.toString(myY);
				theIntString = Integer.toString(myY + theY);
				notifyListeners(this, "myY", theMyIntString, theIntString);
			}
			myX += theX;
			myY += theY;
			System.out.println("[" + myX + ", " + myY + "]");
			return true;
		} else {
			return false;
		}
	}
	
	public int getMyX() {
		return myX;
	}
	
	public int getMyY() {
		return myY;
	}
	
//	public boolean setMyX(final int theX) {
//		if (myMaze.isValidRoom(theX, myY)) {
//			myX = theX;
//			return true;
//		} else {
//			return false;
//		}
//	}
//	
//	public boolean setMyY(final int theY) {
//		if (myMaze.isValidRoom(myX, theY)) {
//			myY = theY;
//			return true;
//		} else {
//			return false;
//		}
//	}
	
	private void notifyListeners(Object theObject, String theProperty, String theOldValue, String theNewValue) {
		for (PropertyChangeListener aListener : myListeners) {
			aListener.propertyChange(new PropertyChangeEvent(this, theProperty, theOldValue, theNewValue));
		}
	}
	
	public void addChangeListener(PropertyChangeListener theNewListener) {
		myListeners.add(theNewListener);
	}
	
	/**
	 * @param args
	 */
	static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
