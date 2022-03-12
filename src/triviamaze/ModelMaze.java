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
     * Serializable long.
     */
    private static final long serialVersionUID = -3365061151045669276L;

    /**
     * The number of rows (including padding).
     */
    private final int myRows;

    /**
     * The number of columns (including padding).
     */
    private final int myCols;

    /**
     * If the maze is solvable; i.e., the user can still reach the end of the maze.
     */
    private boolean myIsSolvable;

    /**
     * The 2d array of Rooms.
     */
    private final ModelRoom[][] myRooms;
    
    /**
     * The 2d array of Doors.
     */
    private final ModelDoor[][] myDoors;


    /**
     * The user.
     */
    private final ModelUser myUser;
    
    /**
     * The scanner for console input.
     */
    private static Scanner myScanner = new Scanner(System.in);
    
    /**
     * The column of the exit/winning room.
     */
    private final int myWinningCol;
    
    /**
     * The row of the exit/winning room.
     */
    private final int myWinningRow;
    
    /**
     * A reference to the winning room.
     */
    private ModelRoom myWinningRoom;
    
    /**
     * A helper boolean to end depth-first search early if it reaches the user.
     */
    private boolean myFoundUser;
    
    /**
     * A helper 2d array of boolean 2d to mark visited rooms during depth-first search.
     */
    private boolean[][] myVisitedRooms;
    
    /**
     * A boolean of if the user won the maze (by getting to the exit/winning room).    
     */
    private boolean myIsWin;
    
    /**
     * Default constructor of 4-by-4 maze.
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
        setMyIsWin(false);
    }
    
    /**
     * A constructor that creates a custom-size maze.
     * @param theRows, the rows of the custom maze.
     * @param theCols, the columns of the custom maze.
     */
    ModelMaze(final int theRows, final int theCols) {
        if (theRows < 1 || theCols < 1) {
            throw new IllegalArgumentException();
        }
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
        setMyIsWin(false);
    }

    /**
     * Getter for the room the user is in.
     * @return ModelRoom, the room of the user.
     */
    ModelRoom getPlayerRoom() {
        return myRooms[myUser.getMyCol()][myUser.getMyRow()];
    }

    /**
     * A setup method that initializes the 2d room and door and visited-rooms arrays,
     * places the user, marks the winning room, and initializes the database.
     */
    void start() {
        startRooms();
        startDoors();
        myRooms[myUser.getMyCol()][myUser.getMyRow()].setMyHasUser(true);
        myWinningRoom = myRooms[myWinningRow][myWinningCol];
        myWinningRoom.setMyIsWinningRoom(true);
        ModelQuestionDatabase.databaseConnection();
    }
    
    /**
     * Uses a 2d for-loop to create new rooms. Padded by null. TODO refactor to pad with unreachable, empty rooms?
     */
    void startRooms() {
        for (int i = 1; i < myRooms.length-1; i++) {
            for (int j = 1; j < myRooms[0].length-1; j++) {
                myRooms[i][j] = new ModelRoom();
            }
        }
    }
    
    /**
     * Uses a 2d for-loop to create new doors iff the row xor column of the door 2d array is odd (the location of a room-connecting door).
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
     * Uses a 2d for-loop to set all visitedRooms to false.
     */
    void startVisitedRooms() {
        myVisitedRooms = new boolean[myRows][myCols];
        for (int i = 0; i < myVisitedRooms.length; i++) {
            for (int j = 0; j < myVisitedRooms[0].length; j++) {
                myVisitedRooms[i][j] = false;
            }
        }
    }
    
    /**
     * Method determines if the maze is solvable using depth-first search.
     */
    void calculateSolvable() {
        //Initialize (or reinitialized) visitedRooms, myFoundUser to false.
        startVisitedRooms();
        myFoundUser = false;
        
        //Starts search at the exit.
        depthFirstSearch(myRows-2, myCols-2);
        
        if (!myFoundUser) {
            setMyIsSolvable(false);
        }
    }
    
    /**
     * Depth-first search to reach the user's room from the exit/winning room.
     * Bypass more searching if the user is found.
     * @param int theRow, the row of the room to search.
     * @param int theCol, the column of the room to search.
     */
    private void depthFirstSearch(int theRow, int theCol) {
        if (theRow == myUser.getMyRow() && theCol == myUser.getMyCol()) {
            myFoundUser = true;
        }
        
        if (!myFoundUser) {
            final int myDoorArrayRows = theRow * 2 - 1;
            final int myDoorArrayCols = theCol * 2 - 1;
            
            //  Is there a door to the:
            //  North?
            if (theRow - 1 > 0 && !myVisitedRooms[theRow - 1][theCol]
                    && !myDoors[myDoorArrayRows - 1][myDoorArrayCols].getMyIsBlocked()) {
                depthFirstSearch(theRow - 1, theCol);
            }
            //  West?
            if (theCol - 1 > 0 && !myVisitedRooms[theRow][theCol - 1]
                    && !myDoors[myDoorArrayRows][myDoorArrayCols - 1].getMyIsBlocked()) {
                depthFirstSearch(theRow, theCol - 1);
            }
            //  South?
            if (theRow + 1 < myRooms.length - 1 && !myVisitedRooms[theRow + 1][theCol]
                    && !myDoors[myDoorArrayRows + 1][myDoorArrayCols].getMyIsBlocked()) {
                depthFirstSearch(theRow + 1, theCol);
            }
            //  East?
            if (theCol + 1 < myRooms[0].length - 1 && !myVisitedRooms[theRow][theCol + 1]
                    && !myDoors[myDoorArrayRows][myDoorArrayCols + 1].getMyIsBlocked()) {
                depthFirstSearch(theRow, theCol + 1);
            }
        }
    }

    /**
     * Moves the user by calling a column, row move method.
     * @param String theMove
     */
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
            System.out.println("Did not move.");
        }
    }

    /**
     * Moves the user.
     * @param theRow
     * @param theCol
     * @return boolean if the user moved.
     */
    boolean move(final int theRow, final int theCol) {
        int userRow = myUser.getMyRow();
        int userCol = myUser.getMyCol();

        int moveToRow = userRow + theRow;       
        int moveToCol = userCol + theCol;
        
        boolean aBoolean = false;
        
        if (isValidRoom(moveToRow, moveToCol)) {
            //Identify door
            int doorRow = userRow * 2 - 1 + theRow;
            int doorCol = userCol * 2 - 1 + theCol;
            
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
                        //calculateSolvable(); TODO
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
                setMyIsWin(true);
            }
        }
        return aBoolean;
    }

    /**
     * Saves the state to save.tm.
     */
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

    /**
     * Loads a maze from a file.
     * @param theMaze
     * @return the loaded maze.
     */
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

    /**
     * Presents information about the project.
     */
    void about() {
        System.out.println("Trivia Maze Group 6 v1.0 Winter 2022");
        System.out.println("Made by Abdulrehim, Daetan, and Hanad");
    }

    /**
     * Exit dialog.
     */
    void exit() {
        System.out.println("Goodbye!");
    }

    /**
     * Win dialog.
     */
    void win() {
        System.out.println("Winner, winner, chicken dinner!!");
    }

    /**
     * Lose dialog.
     */
    void lose() {
        System.out.println("You lost the game!");
    }
    
    /**
     * Returns true iff a room exists at the specified location.
     * @param int theRow
     * @param int theCol
     * @return boolean if a room exists at the location.
     */
    boolean isValidRoom(final int theRow, final int theCol) {
        return theCol > 0 && theCol < myCols - 1 && theRow > 0 && theRow < myRows - 1;
    }

    /**
     * Getter for if maze is solvable.
     * @return boolean of if the maze is still solvable.
     */
    boolean getMyIsSolvable() {
        return myIsSolvable;
    }
    
    /**
     * Setter for if the maze is solvable.
     * @param boolean theIsSolvable
     */
    void setMyIsSolvable(final boolean theIsSolvable) {
        myIsSolvable = theIsSolvable;
    }
    
    /**
     * Calls toString while iterating through myDoors with algorithm to identify rooms.
     */
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
     * Getter of if the user won the game.
     * @return boolean myIsWin
     */
    boolean getMyIsWin() {
        return myIsWin;
    }

    /**
     * Setter of if the user won the game.
     * @param boolean myIsWin
     */
    void setMyIsWin(final boolean theWin) {
        myIsWin = theWin;
    }
    
    /**
     * Getter for myRooms.
     * @return ModelRoom[][] myRooms
     */
    ModelRoom[][] getMyRooms() {
        return myRooms;
    }

    /**
     * Getter for rows.
     * @return int myRows
     */
    int getMyRows() {
        return myRows;
    }

    /**
     * Getter for columns.
     * @return int myCols
     */
    int getMyCols() {
        return myCols;
    }
    
    /**
     * Main method that takes user input.
     * @param args
     */
    public static void main(final String[] args) {
        System.out.println("Welcome to Trivia Maze!");
        
        ModelMaze myMaze = new ModelMaze();
        
        myMaze.start();

        String mySelection = "";

        while (!mySelection.equalsIgnoreCase("X") && myMaze.getMyIsSolvable() && !myMaze.getMyIsWin()) {
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
        
        if (myMaze.getMyIsWin()) {
            myMaze.print();
            myMaze.win();
        }
    }
}
