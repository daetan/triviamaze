/**
 * Trivia Maze
 * Group 6: Abdulrehim Shuba, Daetan Huck, and Hanad Pellissier
 * TCSS 360 Winter 2022
 */
package triviamaze;

import java.io.Serializable;

/**
 * The model door class.
 */
class ModelDoor implements Serializable {
    
    /**
     * A long for serialization.
     */
    private static final long serialVersionUID = 2742738560353830826L;

    /**
     * A boolean of the door's locked state.
     */
    boolean myIsLocked;

    /**
     * A boolean of the door's blocked state.
     */
    boolean myIsBlocked;
    
    /**
     * A string representation of the door's locked/blocked state.
     */
    String myStateString;

    /**
     * Default constructor.
     */
    ModelDoor() {
        setMyIsLocked(true);
        setMyIsBlocked(false);
        myStateString = " X ";
    }

    /**
     * Getter for locked state.
     * @return boolean myIsLocked
     */
    boolean getMyIsLocked() {
        return myIsLocked;
    }

    /**
     * Setter for locked state, updates myStateString.
     * @param boolean theIsLocked
     */
    void setMyIsLocked(final boolean theIsLocked) {
        if (!myIsBlocked) {
            if (theIsLocked) {
                myStateString = " X ";
            } else {
                myStateString = " O ";
            }
        }
        myIsLocked = theIsLocked;
    }
    
    /**
     * Getter for the blocked state.
     * @return boolean myIsBlocked
     */
    boolean getMyIsBlocked() {
        return myIsBlocked;
    }

    /**
     * Setter for blocked state.
     * @param boolean theIsBlocked
     */
    void setMyIsBlocked(final boolean theIsBlocked) {
        myStateString = " # ";
        myIsBlocked = theIsBlocked;
    }
    
    /**
     * Returns string of door state.
     */
    @Override
    public String toString() {
        return myStateString;
    }

}
