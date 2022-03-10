package triviamaze;
/**
 * 
 */

import java.io.Serializable;

/**
 * @author daeta
 *
 */
class ModelRoom implements Serializable {
    
    /**
     * 
     */
    private static final long serialVersionUID = 4116940108462532359L;
    private String myUserString;
    private boolean myHasUser;
    private boolean myIsWinningRoom;
    
    ModelRoom() {
        setMyHasUser(false);
        setMyIsWinningRoom(false);
    }

    
    
    /**
     * @return the myHasUser
     */
    public boolean getMyHasUser() {
        return myHasUser;
    }



    /**
     * @param myHasUser the myHasUser to set
     */
    public void setMyHasUser(boolean myHasUser) {
        if (!myHasUser) {
            myUserString = " ";
        } else {
            myUserString = "U";
        }
        this.myHasUser = myHasUser;
    }

    /**
     * @return the myIsWinningRoom
     */
    public boolean isMyIsWinningRoom() {
        return myIsWinningRoom;
    }



    /**
     * @param myIsWinningRoom the myIsWinningRoom to set
     */
    public void setMyIsWinningRoom(boolean theIsWinningRoom) {
        myIsWinningRoom = theIsWinningRoom;
    }



    //TODO View
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
