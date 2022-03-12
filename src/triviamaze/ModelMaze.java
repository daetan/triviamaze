/**
 * 
 */
package triviamaze;

import java.util.Scanner;
import java.io.*;

/**
 * @author daeta
 *
 */
class ModelMaze implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -3365061151045669276L;

    /**
     * 
     */
    private final Integer myRows;

    /**
     * 
     */
    private final Integer myCols;

    /**
     * 
     */
    private boolean myIsSolvable;

    /**
     * 
     */
    private final ModelRoom[][] myRooms;
    
    /**
     * 
     */
    private final ModelDoor[][] myDoors;


    /**
     * 
     */
    private final ModelUser myUser;

    private static Scanner myScanner = new Scanner(System.in);
    
    private final Integer myWinningCol;
    private final Integer myWinningRow;
    private ModelRoom myWinningRoom;
    
    private boolean foundUser;
    
    private Boolean[][] reachableRoomsFromFinish;
    
    private boolean isWin;
    
    /**
     * 
     */
    ModelMaze() {
        myRows = 6;
        myCols = 6;
        myIsSolvable = true;
        myRooms = new ModelRoom[myRows][myCols];
        final int myDoorArrayRows = (myRows - 2) * 2 + 1;
        final int myDoorArrayCols = (myCols - 2) * 2 + 1;
        myDoors = new ModelDoor[myDoorArrayRows][myDoorArrayCols];
        myUser = new ModelUser();
        myWinningCol = 4;
        myWinningRow = 4;
        setWin(false);
    }
    
    ModelMaze(final int theRows, final int theCols) {
        myRows = theRows + 2;
        myCols = theCols + 2;
        myIsSolvable = true;
        myRooms = new ModelRoom[myRows][myCols];
        final int myDoorArrayRows = theRows * 2 + 1;
        final int myDoorArrayCols = theCols * 2 + 1;
        myDoors = new ModelDoor[myDoorArrayRows][myDoorArrayCols];
        myUser = new ModelUser();
        myWinningCol = myRows - 2;
        myWinningRow = myCols - 2;
        setWin(false);
    }

    /**
     * 
     * @return
     */
    ModelRoom getPlayerRoom() {
        return myRooms[myUser.getMyCol()][myUser.getMyRow()];
    }

    void start() {
        startRooms();
        startDoors();
        startReachableRooms();
        myRooms[myUser.getMyCol()][myUser.getMyRow()].setMyHasUser(true);
        myWinningRoom = myRooms[myWinningRow][myWinningCol];
        myWinningRoom.setMyIsWinningRoom(true);
        foundUser = false;
        ModelQuestionDatabase.databaseConnection();
    }
    
    /**
     * 
     */
    void startRooms() {
        for (int i = 1; i < myRooms.length-1; i++) {
            for (int j = 1; j < myRooms[0].length-1; j++) {
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
    
    void startReachableRooms() {
        reachableRoomsFromFinish = new Boolean[myRows][myCols];
        for (int i = 0; i < reachableRoomsFromFinish.length; i++) {
            for (int j = 0; j < reachableRoomsFromFinish[0].length; j++) {
                reachableRoomsFromFinish[i][j] = false;
            }
        }
    }
    
    void calculateSolvable() {  
        //visited(v) = true
        //previsit(v)
        //for each edge (v, u) e E: if not visited(u): explore(u)
        startReachableRooms();
        foundUser = false;
        depthFirstSearch(myRows-2, myCols-2);
        
        //postvisit(v)
        if (!foundUser) {
            setMyIsSolvable(false);
        }
    }
    
    private void depthFirstSearch(Integer theRow, Integer theCol) {
        if (theRow == myUser.getMyRow() && theCol == myUser.getMyCol()) {
            foundUser = true;
        }
        
        if (!foundUser) {
            final int myDoorArrayRows = theRow * 2 - 1;
            final int myDoorArrayCols = theCol * 2 - 1;
            //TODO refactor? a lot of repetition
            //  Is there a door to the:
            //  North?
            if (theRow - 1 > 0 && !reachableRoomsFromFinish[theRow - 1][theCol]
                    && !myDoors[myDoorArrayRows - 1][myDoorArrayCols].getMyIsBlocked()) {
                System.out.println("Search N");
                depthFirstSearch(theRow - 1, theCol);
            }
            //  West?
            if (theCol - 1 > 0 && !reachableRoomsFromFinish[theRow][theCol - 1]
                    && !myDoors[myDoorArrayRows][myDoorArrayCols - 1].getMyIsBlocked()) {
                System.out.println("Search W");
                depthFirstSearch(theRow, theCol - 1);
            }
            //  South?
            if (theRow + 1 < myRooms.length - 1 && !reachableRoomsFromFinish[theRow + 1][theCol]
                    && !myDoors[myDoorArrayRows + 1][myDoorArrayCols].getMyIsBlocked()) {
                System.out.println("Search S");
                depthFirstSearch(theRow + 1, theCol);
            }
            //  East?
            if (theCol + 1 < myRooms[0].length - 1 && !reachableRoomsFromFinish[theRow][theCol + 1]
                    && !myDoors[myDoorArrayRows][myDoorArrayCols + 1].getMyIsBlocked()) {
                System.out.println("Search E");
                depthFirstSearch(theRow, theCol + 1);
            } 
        }
    }

    void move(final String theMove) {
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

    boolean move(final Integer theRow, final Integer theCol) {
        Integer userRow = myUser.getMyRow();
        Integer userCol = myUser.getMyCol();

        Integer moveToRow = userRow + theRow;       
        Integer moveToCol = userCol + theCol;
        
        boolean aBoolean = false;
        
        if (isValidRoom(moveToRow, moveToCol)) {
            //Identify door
            Integer doorRow = userRow * 2 - 1 + theRow;
            Integer doorCol = userCol * 2 - 1 + theCol;
            //If door locked, query user for trivia
            if (myDoors[doorRow][doorCol].getMyIsBlocked()) {
                System.out.println("Door is blocked.");
            } else {
                if (myDoors[doorRow][doorCol].getMyIsLocked()) {
                    final ModelQuestion QA = ModelQuestionDatabase.createQuestion();
                    System.out.print(QA.getQuestion() + " ");
                    String aSelection = "";
                    aSelection = myScanner.nextLine();
                    if (QA.getAnswer().equalsIgnoreCase(aSelection)) {
                        myDoors[doorRow][doorCol].setMyIsLocked(false);
                        aBoolean = true;
                    } else {
                        System.out.println("Incorrect answer.");
                        myDoors[doorRow][doorCol].setMyIsBlocked(true);
                        //calculateSolvable();
                    }
                } else {
                    aBoolean = true;
                }
            
            }
        } else {
            System.out.println("There's no door that way.");
        }
        if (aBoolean) {
            myRooms[userRow][userCol].setMyHasUser(false);
            myRooms[moveToRow][moveToCol].setMyHasUser(true);
            myUser.setMyCol(myUser.getMyCol() + theCol);
            myUser.setMyRow(myUser.getMyRow() + theRow);
            if (myUser.getMyCol() == myWinningCol && myUser.getMyRow() == myWinningRow) {
                setWin(true);
            }
        }
        return aBoolean;
    }

    void save() {
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

    ModelMaze load(ModelMaze theMaze) {
        String filename = "save.tm";
        
        try { 
            
            // Reading the object from a file 
            FileInputStream file = new FileInputStream 
                                         (filename); 
            ObjectInputStream in = new ObjectInputStream 
                                         (file); 
  
            // Method for de-serialization of object 
            theMaze = (ModelMaze) in.readObject(); 
            
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

    void about() {
        System.out.println("Trivia Maze Group 6 v1.0 Winter 2022");
        System.out.println("Made by Abdulrehim, Daetan, and Hanad");
    }

    void exit() {
        System.out.println("Goodbye!");
    }

    void win() {
        System.out.println("Winner, winner, chicken dinner!!");
    }

    void lose() {
        System.out.println("You lost the game!");
    }
    
    /**
     * 
     * @param theX
     * @param theY
     * @return
     */
    boolean isValidRoom(final Integer theRow, final Integer theCol) {
        return theCol > 0 && theCol < myCols - 1 && theRow > 0 && theRow < myRows - 1;
    }

    /**
     * 
     * @return
     */
    boolean getMyIsSolvable() {
        return myIsSolvable;
    }
    
    void setMyIsSolvable(final boolean theIsSolvable) {
        myIsSolvable = theIsSolvable;
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
    
    /**
     * @return the isWin
     */
    boolean getWin() {
        return isWin;
    }

    /**
     * @param isWin the isWin to set
     */
    void setWin(final boolean theWin) {
        isWin = theWin;
    }
    
    ModelRoom[][] getMyRooms() {
        return myRooms;
    }

    Integer getMyRows() {
        return myRows;
    }

    Integer getMyCols() {
        return myCols;
    }
    
    public static void main(final String[] args) {
        System.out.println("Welcome to Trivia Maze!");
        
        ModelMaze myMaze = new ModelMaze();
        
        myMaze.start();

        String mySelection = "";

        while (!mySelection.equalsIgnoreCase("X") && myMaze.getMyIsSolvable() && !myMaze.getWin()) {
            myMaze.print();
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
        if (!myMaze.getMyIsSolvable()) {
            myMaze.print();
            myMaze.lose();
        }
        
        if (myMaze.getWin()) {
            myMaze.print();
            myMaze.win();
        }
    }
}
