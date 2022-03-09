package triviamaze;

import java.io.Serializable;

class ModelDoor implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 2742738560353830826L;

    boolean myIsLocked;

    boolean myIsBlocked;
    
    String myStateString;

    ModelDoor() {
        setMyIsLocked(true);
        setMyIsBlocked(false);
        myStateString = " X ";
    }

    boolean getMyIsLocked() {
        return myIsLocked;
    }

    void setMyIsLocked(final boolean theIsLocked) {
        if (!theIsLocked && !myIsBlocked) {
            myStateString = " O ";
        }
        myIsLocked = theIsLocked;
    }
    
    boolean getMyIsBlocked() {
        return myIsBlocked;
    }

    void setMyIsBlocked(final boolean theIsBlocked) {
        myStateString = " # ";
        myIsBlocked = theIsBlocked;
    }
    
    @Override
    public String toString() {
        return myStateString;
    }

}
