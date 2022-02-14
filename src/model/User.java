/**
 * 
 */
package model;

/**
 * @author daeta
 *
 */
class User {
	
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
	

	User() {
		myX = 1;
		myY = 1;
		myMaze = new Maze();
	}
	
	User(final Maze theMaze) {
		myX = 1;
		myY = 1;
		myMaze = theMaze;
	}
	
	//YAGNI ¯\_(ツ)_/¯
	boolean move(final char theDirection) {
		boolean result = false; 
		if (theDirection == 'E') {
			result = move(1, 0);
		} else if (theDirection == 'S') {
			result = move(0, 1);
		} else if (theDirection == 'W') {
			result = move(-1, 0);
		} else if (theDirection == 'N') {
			result = move(0, -1);
		} 
		return result;
	}
	
	boolean move(final int theX, final int theY) {
		if (myMaze.isValidRoom(myX + theX, myY + theY)) {
			myX += theX;
			myY += theY;
			return true;
		} else {
			return false;
		}
	}
	
	int getMyX() {
		return myX;
	}
	
	int getMyY() {
		return myY;
	}
	
	boolean setMyX(final int theX) {
		if (myMaze.isValidRoom(theX, myY)) {
			myX = theX;
			return true;
		} else {
			return false;
		}
	}
	
	boolean setMyY(final int theY) {
		if (myMaze.isValidRoom(myX, theY)) {
			myY = theY;
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * @param args
	 */
	static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
