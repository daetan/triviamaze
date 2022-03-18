/**
 * Trivia Maze
 * Group 6: Abdulrehim Shuba, Daetan Huck, and Hanad Pellissier
 * TCSS 360 Winter 2022
 */
package triviamaze;

import java.io.Serializable;

/**
 * A model room class that stores whether it is the winning room or has the user.
 */
class ModelRoom implements Serializable {
    
    /**
     * A long for serialization.
     */
    private static final long serialVersionUID = 4116940108462532359L;
    
    /**
     * A string to represent if the room has the user.
     */
    private String myUserString;
    
    /**
     * A boolean of if the room has the user.
     */
    private boolean myHasUser;
    
    /**
     * A boolean of if the room is the location of the exit/winning room.
     */
    private boolean myIsWinningRoom;
    
    /**
     * Default constructor.
     */
    ModelRoom() {
        setMyHasUser(false);
        setMyIsWinningRoom(false);
    }

    /**
     * Returns true iff the rooms has the user.
     * @return myHasUser
     */
    boolean getMyHasUser() {
        return myHasUser;
    }


    /**
     * Sets the boolean for if the room has the user and updates the user string.
     * @param theHasUser
     */
    void setMyHasUser(final boolean theHasUser) {
        if (!theHasUser) {
            myUserString = " ";
        } else {
            myUserString = "U";
        }
        myHasUser = theHasUser;
    }

    /**
     * Returns true iff the room is the winning room.
     * @return myIsWinningRoom
     */
    boolean getMyIsWinningRoom() {
        return myIsWinningRoom;
    }

    /**
     * Sets the boolean of if the room is the winning room.
     * @param theIsWinningRoom
     */
    void setMyIsWinningRoom(final boolean theIsWinningRoom) {
        myIsWinningRoom = theIsWinningRoom;
    }

    /**
     * Returns a string representation of the room state.
     */
    @Override
    public String toString() {
        final StringBuilder aStringBuilder = new StringBuilder();
        if (myIsWinningRoom) {
            aStringBuilder.append("*");
            aStringBuilder.append(myUserString);
            aStringBuilder.append("*");
        } else {
            aStringBuilder.append("[");
        aStringBuilder.append(myUserString);
        aStringBuilder.append("]");
        }
        
        return aStringBuilder.toString();
    }
}
