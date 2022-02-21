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
	//TODO code smell: user class is unnecessary...does control-like things...hm...
	
	private int myX;
	
	private int myY;

	/**
	 * TODO code smell to store a Maze in User? Poor design? A Maze has-a User or a User has-a Maze?
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
	}
	
	public User(Maze theMaze) {
		myMaze = theMaze;
	}

	//TODO control method: move?
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
	
	//TODO control method: move?
	public boolean move(final int theX, final int theY) {
		if (myMaze.isValidRoom(myX + theX, myY + theY)) {
			notifyMove(theX, theY);
			myX += theX;
			myY += theY;
			return true;
		} else {
			return false;
		}
	}
	
	//TODO control method: move?
	public boolean setMyX(final int theX) {
		if (myMaze.isValidRoom(theX, myY)) {
			notifyMove(theX, 0);
			myX = theX;
			return true;
		} else {
			return false;
		}
	}
	
	//TODO control method: move?
	public boolean setMyY(final int theY) {
		if (myMaze.isValidRoom(myX, theY)) {
			notifyMove(0, theY);
			myY = theY;
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
	
	private void notifyMove(int theX, int theY) {
		String theMyIntString;
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
	}
	
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
