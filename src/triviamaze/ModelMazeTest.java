package triviamaze;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.lang.reflect.Field;

/**
 * 
 *
 */
class ModelMazeTest {

    private static ModelMaze testDefaultMaze;
    private static ModelRoom[][] testDefaultRooms;

    private static ModelMaze testEdge1000Maze;
    private static ModelRoom[][] testEdge1000Rooms;
    
    private static final int DEFAULT_ROWS = 4;
    private static final int DEFAULT_COLS = 4;

    private static final int BIG_ROWS = 999;
    private static final int BIG_COLS = 1001;

    private static ModelMaze testBigMaze;
    private static ModelMaze testDefaultMazeStarted;

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
        testDefaultMaze = new ModelMaze();
        testDefaultRooms = testDefaultMaze.getMyRooms();

        testEdge1000Maze = new ModelMaze(1000, 1000);
        testEdge1000Rooms = testEdge1000Maze.getMyRooms();
        
        testBigMaze = new ModelMaze(BIG_ROWS, BIG_COLS);
        testDefaultMazeStarted = new ModelMaze();
        testDefaultMazeStarted.start();
    }

    @AfterAll
    static void tearDownAfterClass() throws Exception {
    }

    @BeforeEach
    void setUp() throws Exception {
    }

    @AfterEach
    void tearDown() throws Exception {
    }

    @Test
    void testDefaultConstructorHeight() {
        assertEquals(testDefaultMaze.getMyRows(), 6);
    }

    @Test
    void testDefaultConstructorWidth() {
        assertEquals(testDefaultMaze.getMyCols(), 6);
    }

    @Test
    void testDefaultConstructorIsSolvable() {
        assertTrue(testDefaultMaze.getMyIsSolvable());
    }

    @Test
    void testDefaultConstructorMyRoomsHeight() {
        assertEquals(testDefaultRooms.length, 6);
    }

    @Test
    void testDefaultConstructorMyRoomsWidth() {
        assertEquals(testDefaultRooms[0].length, 6);
    }

    /**
     * Maze constructs a
     */
    @Test
    void testDefaultIsValidRoom() {
        assertFalse(testDefaultMaze.isValidRoom(0, 0), "Room 0, 0 returned true instead of false.");
        assertFalse(testDefaultMaze.isValidRoom(0, 1), "Room 0, 1 returned true instead of false.");
        assertFalse(testDefaultMaze.isValidRoom(0, 2), "Room 0, 2 returned true instead of false.");
        assertFalse(testDefaultMaze.isValidRoom(0, 3), "Room 0, 3 returned true instead of false.");

        assertFalse(testDefaultMaze.isValidRoom(1, 0), "Room 1, 0 returned true instead of false.");
        assertFalse(testDefaultMaze.isValidRoom(1, 5), "Room 1, 5 returned true instead of false.");

        assertFalse(testDefaultMaze.isValidRoom(2, 0), "Room 2, 0 returned true instead of false.");
        assertFalse(testDefaultMaze.isValidRoom(2, 5), "Room 2, 5 returned true instead of false.");

        assertFalse(testDefaultMaze.isValidRoom(3, 0), "Room 3, 0 returned true instead of false.");
        assertFalse(testDefaultMaze.isValidRoom(3, 5), "Room 3, 5 returned true instead of false.");

        assertTrue(testDefaultMaze.isValidRoom(1, 1), "Room 1, 1 returned false instead of true.");
        assertTrue(testDefaultMaze.isValidRoom(1, 2), "Room 1, 2 returned false instead of true.");
        assertTrue(testDefaultMaze.isValidRoom(2, 1), "Room 2, 1 returned false instead of true.");
        assertTrue(testDefaultMaze.isValidRoom(2, 2), "Room 2, 2 returned false instead of true.");
    }

    void testEdge1000ConstructorHeight() {
        assertEquals(testEdge1000Maze.getMyRows(), 1002);
    }

    @Test
    void testEdge1000ConstructorWidth() {
        assertEquals(testEdge1000Maze.getMyCols(), 1002);
    }

    @Test
    void testEdge1000ConstructorIsSolvable() {
        assertTrue(testEdge1000Maze.getMyIsSolvable());
    }

    @Test
    void testEdge1000ConstructorMyRoomsHeight() {
        assertEquals(testEdge1000Rooms.length, 1002);
    }

    @Test
    void testEdge1000ConstructorMyRoomsWidth() {
        assertEquals(testEdge1000Rooms[0].length, 1002);
    }

    @Test
    void testEdge1000IsValidRoom() {
        assertFalse(testEdge1000Maze.isValidRoom(0, 0), "Room 0, 0 returned true instead of false.");
        assertFalse(testEdge1000Maze.isValidRoom(0, 1001), "Room 0, 1001 returned true instead of false.");
        assertFalse(testEdge1000Maze.isValidRoom(1001, 0), "Room 1001, 0 returned true instead of false.");
        assertFalse(testEdge1000Maze.isValidRoom(1001, 1001), "Room 1001, 1001 returned true instead of false.");

        assertFalse(testEdge1000Maze.isValidRoom(500, 0), "Room 500, 0 returned true instead of false.");
        assertFalse(testEdge1000Maze.isValidRoom(500, 1001), "Room 500, 1001 returned true instead of false.");

        assertFalse(testEdge1000Maze.isValidRoom(0, 500), "Room 0, 500 returned true instead of false.");
        assertFalse(testEdge1000Maze.isValidRoom(1001, 500), "Room 1001, 500 returned true instead of false.");

        assertTrue(testEdge1000Maze.isValidRoom(1, 1), "Room 1, 1 returned false instead of true.");
        assertTrue(testEdge1000Maze.isValidRoom(1, 1000), "Room 1, 1000 returned false instead of true.");
        assertTrue(testEdge1000Maze.isValidRoom(1000, 1), "Room 1000, 1 returned false instead of true.");
        assertTrue(testEdge1000Maze.isValidRoom(1000, 1000), "Room 1000, 1000 returned false instead of true.");
        assertTrue(testEdge1000Maze.isValidRoom(500, 500), "Room 500, 500 returned false instead of true.");
    }
    
    @Test
    void testDefaultConstructor() throws Exception {
        int rows = DEFAULT_ROWS + 2;
        int cols = DEFAULT_COLS + 2;

        final Field myRowsField = testDefaultMaze.getClass().getDeclaredField("myRows");
        myRowsField.setAccessible(true);
        assertEquals(rows, myRowsField.get(testDefaultMaze));

        final Field myColsField = testDefaultMaze.getClass().getDeclaredField("myCols");
        myColsField.setAccessible(true);
        assertEquals(cols, myColsField.get(testDefaultMaze));

        final Field myIsSolvableField = testDefaultMaze.getClass().getDeclaredField("myIsSolvable");
        myIsSolvableField.setAccessible(true);
        assertEquals(true, myIsSolvableField.get(testDefaultMaze));

        final Field myRoomsField = testDefaultMaze.getClass().getDeclaredField("myRooms");
        myRoomsField.setAccessible(true);
        ModelRoom[][] rooms = (ModelRoom[][]) myRoomsField.get(testDefaultMaze);
        assertEquals(rows, rooms.length);
        for (ModelRoom[] row : rooms) {
            assertEquals(cols, row.length);
        }

        final Field myDoorsField = testDefaultMaze.getClass().getDeclaredField("myDoors");
        myDoorsField.setAccessible(true);
        ModelDoor[][] doors = (ModelDoor[][]) myDoorsField.get(testDefaultMaze);
        assertEquals(2 * DEFAULT_ROWS + 1, doors.length);
        for (ModelDoor[] row : doors) {
            assertEquals(2 * DEFAULT_COLS + 1, row.length);
        }

        final Field myUserField = testDefaultMaze.getClass().getDeclaredField("myUser");
        myUserField.setAccessible(true);
        assertNotNull(myUserField.get(testDefaultMaze));

        final Field myWinningRowField = testDefaultMaze.getClass().getDeclaredField("myWinningRow");
        myWinningRowField.setAccessible(true);
        assertEquals(rows - 2, myWinningRowField.get(testDefaultMaze));

        final Field myWinningColField = testDefaultMaze.getClass().getDeclaredField("myWinningCol");
        myWinningColField.setAccessible(true);
        assertEquals(cols - 2, myWinningColField.get(testDefaultMaze));

        final Field myIsWinField = testDefaultMaze.getClass().getDeclaredField("myIsWin");
        myIsWinField.setAccessible(true);
        assertEquals(false, myIsWinField.get(testDefaultMaze));
    }

    @Test
    void testSizeConstructor() throws Exception {
        int rows = BIG_ROWS + 2;
        int cols = BIG_COLS + 2;

        final Field myRowsField = testBigMaze.getClass().getDeclaredField("myRows");
        myRowsField.setAccessible(true);
        assertEquals(rows, myRowsField.get(testBigMaze));

        final Field myColsField = testBigMaze.getClass().getDeclaredField("myCols");
        myColsField.setAccessible(true);
        assertEquals(cols, myColsField.get(testBigMaze));

        final Field myIsSolvableField = testBigMaze.getClass().getDeclaredField("myIsSolvable");
        myIsSolvableField.setAccessible(true);
        assertEquals(true, myIsSolvableField.get(testBigMaze));

        final Field myRoomsField = testBigMaze.getClass().getDeclaredField("myRooms");
        myRoomsField.setAccessible(true);
        ModelRoom[][] rooms = (ModelRoom[][]) myRoomsField.get(testBigMaze);
        assertEquals(rows, rooms.length);
        for (ModelRoom[] row : rooms) {
            assertEquals(cols, row.length);
        }

        final Field myDoorsField = testBigMaze.getClass().getDeclaredField("myDoors");
        myDoorsField.setAccessible(true);
        ModelDoor[][] doors = (ModelDoor[][]) myDoorsField.get(testBigMaze);
        assertEquals(2 * BIG_ROWS + 1, doors.length);
        for (ModelDoor[] row : doors) {
            assertEquals(2 * BIG_COLS + 1, row.length);
        }

        final Field myUserField = testBigMaze.getClass().getDeclaredField("myUser");
        myUserField.setAccessible(true);
        assertNotNull(myUserField.get(testBigMaze));

        final Field myWinningRowField = testBigMaze.getClass().getDeclaredField("myWinningRow");
        myWinningRowField.setAccessible(true);
        assertEquals(rows - 2, myWinningRowField.get(testBigMaze));

        final Field myWinningColField = testBigMaze.getClass().getDeclaredField("myWinningCol");
        myWinningColField.setAccessible(true);
        assertEquals(cols - 2, myWinningColField.get(testBigMaze));

        final Field myIsWinField = testBigMaze.getClass().getDeclaredField("myIsWin");
        myIsWinField.setAccessible(true);
        assertEquals(false, myIsWinField.get(testBigMaze));
    }

    @Test
    public void getMyPlayerRoomTest() throws Exception {
        ModelRoom playerRoom = testDefaultMazeStarted.getPlayerRoom();

        final Field myUserField = testDefaultMazeStarted.getClass().getDeclaredField("myUser");
        myUserField.setAccessible(true);
        ModelUser myUser = (ModelUser) myUserField.get(testDefaultMazeStarted);

        final Field myRoomsField = testDefaultMazeStarted.getClass().getDeclaredField("myRooms");
        myRoomsField.setAccessible(true);
        ModelRoom[][] rooms = (ModelRoom[][]) myRoomsField.get(testDefaultMazeStarted);
        assertSame(rooms[myUser.getMyRow()][myUser.getMyCol()], playerRoom);
    }

    @Test
    public void startRoomsTest() throws Exception {
        final Field myRoomsField = testDefaultMazeStarted.getClass().getDeclaredField("myRooms");
        myRoomsField.setAccessible(true);
        ModelRoom[][] rooms = (ModelRoom[][]) myRoomsField.get(testDefaultMazeStarted);
        for (int i = 0; i < DEFAULT_ROWS + 2; i++) {
            for (int j = 0; j < DEFAULT_COLS + 2; j++) {
                if (i == 0 || j == 0 || i == DEFAULT_ROWS + 1 || j == DEFAULT_COLS + 1) {
                    assertNull(rooms[i][j]);
                } else {
                    assertNotNull(rooms[i][j]);
                }
            }
        }
    }

    @Test
    public void startDoorTest() throws Exception {
        final Field myDoorsField = testDefaultMazeStarted.getClass().getDeclaredField("myDoors");
        myDoorsField.setAccessible(true);
        ModelDoor[][] doors = (ModelDoor[][]) myDoorsField.get(testDefaultMazeStarted);
        for (int i = 0; i < 2 * DEFAULT_ROWS + 1; i++) {
            for (int j = 0; j < 2 * DEFAULT_COLS + 1; j++) {
                if (i == 0 || j == 0 || i == 2 * DEFAULT_ROWS || j == 2 * DEFAULT_COLS || ((i % 2 != 0) == (j % 2 != 0))) {
                    assertNull(doors[i][j]);
                } else {
                    assertNotNull(doors[i][j]);
                }
            }
        }
    }

    @Test
    public void startVisitedRooms() throws Exception {
        testDefaultMazeStarted.startVisitedRooms();
        final Field myVisitedRoomsField = testDefaultMazeStarted.getClass().getDeclaredField("myVisitedRooms");
        myVisitedRoomsField.setAccessible(true);
        boolean[][] myVisitedRooms = (boolean[][]) myVisitedRoomsField.get(testDefaultMazeStarted);
        for (int i = 0; i < DEFAULT_ROWS + 2; i++) {
            for (int j = 0; j < DEFAULT_COLS + 2; j++) {
                assertFalse(myVisitedRooms[i][j]);
            }
        }
    }

    @Test
    public void calculateSolvableTest() throws Exception {
        testDefaultMazeStarted.calculateSolvable();
        final Field myIsSolvableField = testDefaultMazeStarted.getClass().getDeclaredField("myIsSolvable");
        myIsSolvableField.setAccessible(true);
        assertEquals(true, myIsSolvableField.get(testDefaultMazeStarted));

        final Field myDoorsField = testDefaultMazeStarted.getClass().getDeclaredField("myDoors");
        myDoorsField.setAccessible(true);
        ModelDoor[][] doors = (ModelDoor[][]) myDoorsField.get(testDefaultMazeStarted);
        doors[2 * DEFAULT_ROWS - 1][2 * DEFAULT_COLS - 2].setMyIsBlocked(true);
        doors[2 * DEFAULT_ROWS - 2][2 * DEFAULT_COLS - 1].setMyIsBlocked(true);
        testDefaultMazeStarted.calculateSolvable();
        assertEquals(false, myIsSolvableField.get(testDefaultMazeStarted));
    }

    @Test
    public void isValidRoomTest() {
        for (int i = 0; i < DEFAULT_ROWS + 2; i++) {
            for (int j = 0; j < DEFAULT_COLS + 2; j++) {
                assertEquals((i > 0 && j > 0 && i <= DEFAULT_ROWS && j <= DEFAULT_COLS), testDefaultMazeStarted.isValidRoom(i, j));
            }
        }
    }

}
