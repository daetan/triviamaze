/**
 * 
 */
package triviamaze;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;

/**
 * @author daeta
 *
 */
class ModelMaze implements ModelMazeInterface, Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -3365061151045669276L;

    /**
     * 
     */
    private Integer myHeight;

    /**
     * 
     */
    private Integer myWidth;

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
    private ModelDoor[][] myDoors;


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
        myHeight = 6;
        myWidth = 6;
        isSolvable = true;
        myRooms = new ModelRoom[myHeight][myWidth];
        myDoors = new ModelDoor[myHeight*2-1][myWidth*2-1];
        myUser = new ModelUser();
    }

    /**
     * 
     * @param theX
     * @param theY
     */
    ModelMaze(final Integer theX, final Integer theY) {
        myHeight = theY + 2;
        myWidth = theX + 2;
        isSolvable = true;
        myRooms = new ModelRoom[myHeight][myWidth];
        myDoors = new ModelDoor[myHeight*2-1][myWidth*2-1];
        myUser = new ModelUser();
    }

//    /**
//     * 
//     * @param theX
//     * @param theY
//     * @return
//     */
//    ModelRoom getRoom(final Integer theX, final Integer theY) {
//        ModelRoom returnRoom = new ModelRoom();
//        if (theX < myWidth && theX > 0 && theY < myHeight && theY > 0) {
//            returnRoom = myRooms[theX][theY];
//        }
//        return returnRoom;
//    }

    /**
     * 
     * @return
     */
    ModelRoom getPlayerLocation() {
        return myRooms[myUser.getMyX()][myUser.getMyY()];
    }

    @Override
    public void start() {
        startRooms();
        startDoors();
        myRooms[myUser.getMyX()][myUser.getMyY()].setMyHasUser(true);
    }

    @Override
    public void move(final String theMove) {
        boolean result = false;
        if (theMove.equalsIgnoreCase("E")) {
            result = move(1, 0);
        } else if (theMove.equalsIgnoreCase("S")) {
            result = move(0, -1);
        } else if (theMove.equalsIgnoreCase("W")) {
            result = move(-1, 0);
        } else if (theMove.equalsIgnoreCase("N")) {
            result = move(0, 1);
        }
        if (!result) {
            System.out.println("Could not move.");
        }
    }

    boolean move(final Integer theX, final Integer theY) {
        if (isValidRoom(myUser.getMyX() + theX, myUser.getMyY() + theY)) {
            notifyListeners((Object) this, "X", myUser.getMyX().toString(), theX.toString());
            notifyListeners((Object) this, "Y", myUser.getMyY().toString(), theY.toString());
            myUser.setMyX(myUser.getMyX() + theX);
            myUser.setMyY(myUser.getMyY() + theY);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void answer(String theAnswer) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void save() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void load(String theLoad) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void about() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void exit() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void win() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void lose() {
        // TODO Auto-generated method stub
        
    }
    
    /**
     * 
     * @param theX
     * @param theY
     * @return
     */
    boolean isValidRoom(final Integer theX, final Integer theY) {
        return theX > 0 && theX < myWidth - 1 && theY > 0 && theY < myHeight - 1;
    }

    /**
     * 
     */
    void startRooms() {
        for (int i = 1; i < myRooms.length; i++) {
            for (int j = 1; j < myRooms[0].length; j++) {
                myRooms[i][j] = new ModelRoom(); //TODO why passing int to Room?
            }
        }
    }
    
    /**
     * 
     */
    void startDoors() {
        for (int i = 1; i < myDoors.length-1; i++) {
            for (int j = 1; j < myDoors[0].length-1; j++) {
                if (i % 2 != 0 ^ j % 2 != 0) {
                    myDoors[i][j] = new ModelDoor();
                }
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
    public void notifyListeners(final Object theObject, final String theProperty, final String theOldValue,
            final String theNewValue) {
        for (PropertyChangeListener aListener : myListeners) {
            aListener.propertyChange(new PropertyChangeEvent(this, theProperty, theOldValue, theNewValue));
        }
    }

    /**
     * 
     * @param theNewListener
     */
    @Override
    public void addChangeListener(final PropertyChangeListener theNewListener) {
        myListeners.add(theNewListener);
    }

    /**
     * 
     * @return
     */
    Integer getMyHeight() {
        return myHeight - 2;
    }

    /**
     * 
     * @return
     */
    Integer getMyWidth() {
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
    
    @Override
    public String toString() {
        return "hi";
    }
    
    void print() {
        for (int i = 1; i < myDoors.length-1; i++) {
            for (int j = 1; j < myDoors[0].length-1; j++) {
                if (i % 2 != 0 ^ j % 2 != 0) {
                    System.out.print(myDoors[i][j].toString());
                } else if (i % 2 != 0 && j % 2 != 0) {
                    int lookupRoomI = (i + 1) / 2;
                    int lookupRoomJ = (j + 1) / 2;
                    if (lookupRoomI < myRooms.length && lookupRoomJ < myRooms[0].length) {
                        System.out.print(myRooms[lookupRoomI][lookupRoomJ].toString());
                    } 
                } else {
                    System.out.print("   ");
                }
            }
            System.out.println();
        }
    }
    
    public static void main(final String[] args) {
        //TODO write escape
        System.out.println("Welcome to Trivia Maze!");
        
        ModelMazeInterface myMaze = new ModelMaze();
        myMaze.start();
        
        ((ModelMaze) myMaze).print();
        
        
//        final Scanner myConsole = new Scanner(System.in);
//        final String mySelection = "";
//        
//        //TODO ATriviaMaze
//        myMaze.start();
//        
//        //TODO View
//        System.out.println(myMaze.toString());
//
//        while (!mySelection.equalsIgnoreCase("E")) {
//            myMaze.toString();
//            System.out.print("Enter your selection: ");
//            mySelection = myConsole.nextLine();
//            myControl.setSelection(mySelection);
//            System.out.println("Your selection was: " + myControl.getSelection());
//        }
//
//        myConsole.close();
//        System.out.println("Goodbye!");
    }

}
