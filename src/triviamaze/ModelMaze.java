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

    private static Scanner myScanner = new Scanner(System.in);
    
    private ModelRoom myWinningRoom;
    
    private Boolean[][] reachableRooms;
    
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
        ModelQuestionDatabase.databaseConnection();
        myWinningRoom = myRooms[myHeight-1][myWidth-1];
        myWinningRoom.setMyIsWinningRoom(true);
        reachableRooms = new Boolean[myHeight-2][myWidth-2];
    }

    @Override
    public void move(final String theMove) {
        boolean result = false;
        if (theMove.equalsIgnoreCase("E")) {
            result = move(0, 1);
        } else if (theMove.equalsIgnoreCase("S")) {
            result = move(1, 0);
        } else if (theMove.equalsIgnoreCase("W")) {
            result = move(0, -1);
        } else if (theMove.equalsIgnoreCase("N")) {
            result = move(-1, 0);
        }
        if (!result) {
            System.out.println("Could not move.");
        }
    }

    boolean move(final Integer theX, final Integer theY) {
        Integer userX = myUser.getMyX();
        Integer userY = myUser.getMyY();
        
        Integer moveToX = userX + theX;
        Integer moveToY = userY + theY;
        
        boolean aBoolean = false;
        
        if (isValidRoom(moveToX, moveToY)) {
            //Identify door
            Integer doorX = userX * 2 - 1 + theX;
            Integer doorY = userY * 2 - 1 + theY;
            //If door locked, query user for trivia
            if (myDoors[doorX][doorY].getMyIsBlocked()) {
                System.out.println("Door is blocked.");
            } else {
                if (myDoors[doorX][doorY].getMyIsLocked()) {
                    final ModelQuestion QA = ModelQuestionDatabase.createQuestion();
                    System.out.print(QA.getQuestion() + " ");
                    String aSelection = "";
                    aSelection = myScanner.nextLine();
                    if (QA.getAnswer().equalsIgnoreCase(aSelection)) {
                        myDoors[doorX][doorY].setMyIsLocked(false);
                        aBoolean = true;
                    } else {
                        System.out.println("Incorrect answer.");
                        myDoors[doorX][doorY].setMyIsBlocked(true);
                        calculateSolvable();
                    }
                } else {
                    aBoolean = true;
                }
            
            }
        } else {
            System.out.println("There's no door that way.");
        }
        if (aBoolean) {
            if (theX != 0) {
                notifyListeners((Object) this, "X", myUser.getMyX().toString(), moveToX.toString());
            }
            if (theY != 0) {
                notifyListeners((Object) this, "Y", myUser.getMyY().toString(), moveToY.toString());
            }
            myRooms[userX][userY].setMyHasUser(false);
            myRooms[moveToX][moveToY].setMyHasUser(true);
            myUser.setMyX(myUser.getMyX() + theX);
            myUser.setMyY(myUser.getMyY() + theY);
        }
        return aBoolean;
    }

    @Override
    public void answer(String theAnswer) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void save() {
        String filename = "save.tm"; 
        
        // Serialization 
        try { 
  
            // Saving of object in a file 
            FileOutputStream file = new FileOutputStream 
                                           (filename); 
            ObjectOutputStream out = new ObjectOutputStream 
                                           (file); 
  
            // Method for serialization of object 
            out.writeObject(this); 
  
            out.close(); 
            file.close(); 
  
            System.out.println("Object has been serialized."); 
        } 
  
        catch (IOException ex) { 
            System.out.println("IOException is caught"); 
        }
    }

    @Override
    public ModelMazeInterface load(ModelMazeInterface theMaze) {
        String filename = "save.tm";
        
        try { 
            
            // Reading the object from a file 
            FileInputStream file = new FileInputStream 
                                         (filename); 
            ObjectInputStream in = new ObjectInputStream 
                                         (file); 
  
            // Method for deserialization of object 
            theMaze = (ModelMazeInterface) in.readObject(); 
            
            in.close(); 
            file.close(); 
            System.out.println("Object has been deserialized.");
            
        } 
  
        catch (IOException ex) { 
            System.out.println("IOException is caught"); 
        } 
  
        catch (ClassNotFoundException ex) { 
            System.out.println("ClassNotFoundException" + 
                                " is caught"); 
        }
        return theMaze;
    }

    @Override
    public void about() {
        System.out.println("Trivia Maze Group 6 v1.0 Winter 2022");
        System.out.println("Made by Abdulrehim, Daetan, and Hanad");
    }

    @Override
    public void exit() {
        System.out.println("Goodbye!");
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
        return theX > 0 && theX < myWidth && theY > 0 && theY < myHeight;
    }

    /**
     * 
     */
    void startRooms() {
        for (int i = 1; i < myRooms.length; i++) {
            for (int j = 1; j < myRooms[0].length; j++) {
                myRooms[i][j] = new ModelRoom();
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
    
    void calculateSolvable() {
        //depthFirstSearch()
    }
    
    @Override
    public String toString() {
        return "hi";
    }
    
    void print() {
        System.out.println("Maze:");
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
        System.out.println();
    }
    
    public static void main(final String[] args) {
        System.out.println("Welcome to Trivia Maze!");
        
        ModelMazeInterface myMaze = new ModelMaze();
        
        myMaze.start();

        String mySelection = "";

        while (!mySelection.equalsIgnoreCase("X") && ((ModelMaze) myMaze).getIsSolvable()) {
            ((ModelMaze) myMaze).print();
            System.out.println("Get to the * * room!");
            System.out.println("Move [N]orth, [S]outh, [E]ast, or [W]est.");
            System.out.println("Sa[V]e, [L]oad, Abou[T], or E[X]it.");
            System.out.print("Enter your selection: ");
            mySelection = myScanner.nextLine();
            if (mySelection.equalsIgnoreCase("N") || mySelection.equalsIgnoreCase("S") || mySelection.equalsIgnoreCase("E") || mySelection.equalsIgnoreCase("W")) {
                myMaze.move(mySelection);
            } else if (mySelection.equalsIgnoreCase("V")) {
                myMaze.save();
            } else if (mySelection.equalsIgnoreCase("L")) {
                myMaze = myMaze.load(myMaze);
            } else if (mySelection.equalsIgnoreCase("T")) {
                myMaze.about();
            } else if (mySelection.equalsIgnoreCase("X")) {
                myMaze.exit();
            }
        }
        myScanner.close();
        
    }
}

///**
//* @return the myUser
//*/
//ModelUser getMyUser() {
// return myUser;
//}
//
///**
//* @param myUser the myUser to set
//*/
//void setMyUser(ModelUser theUser) {
// myUser = theUser;
//}

///**
//* 
//* @return
//*/
//ModelRoom[][] getMyRooms() {
// return myRooms;
//}
//
///**
//* 
//* @param theCurrentRoom
//* @return
//*/
//ModelRoom getTopNeighbour(final ModelRoom theCurrentRoom) {
// return myRooms[theCurrentRoom.getMyX() - 1][theCurrentRoom.getMyY()];
//}
//
///**
//* 
//* @param theCurrentRoom
//* @return
//*/
//ModelRoom getRightNeighbour(final ModelRoom theCurrentRoom) {
// return myRooms[theCurrentRoom.getMyX()][theCurrentRoom.getMyY() + 1];
//}
//
///**
//* 
//* @param theCurrentRoom
//* @return
//*/
//ModelRoom getBottomNeighbour(final ModelRoom theCurrentRoom) {
// return myRooms[theCurrentRoom.getMyX() + 1][theCurrentRoom.getMyY()];
//}
//
///**
//* 
//* @param theCurrentRoom
//* @return
//*/
//ModelRoom getLeftNeighbour(final ModelRoom theCurrentRoom) {
// return myRooms[theCurrentRoom.getMyX()][theCurrentRoom.getMyY() - 1];
//}
