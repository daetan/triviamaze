package model;

class Door {
	boolean myIsLocked;
	
	Door() {
		myIsLocked = true;
	}
	
	boolean getMyIsLocked() {
		return myIsLocked;
	}
	
	void setMyIsLocked(final boolean theIsLocked) {
		myIsLocked = theIsLocked;
	}
	
}
